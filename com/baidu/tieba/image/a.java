package com.baidu.tieba.image;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.tbadkCore.u;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements ImagePagerAdapter.a {
    private static int fgx = 7;
    private boolean aTz;
    private boolean fgA;
    private b fgB;
    private c fgC;
    private AdvertAppInfo fgz;
    private TbPageContext<?> mContext;
    private int fgy = 0;
    private boolean fgD = false;
    private final View.OnClickListener fgE = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.fgz != null) {
                if (a.this.fgB == null || !a.this.fgB.fgM || a.this.fgB.aWn() != view) {
                    if (u.R((Activity) view.getContext())) {
                        a.this.fgC.aWt();
                        com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.fgz));
                        int i = a.this.fgz.apo;
                        if (i == 0 || i == 3) {
                            if (!j.kV() || j.kW()) {
                                String str = a.this.fgz.apr;
                                if (StringUtils.isNull(str)) {
                                    str = a.this.mContext.getString(e.j.app_name);
                                }
                                a.this.fgC.aWv();
                                if (s.a(a.this.mContext.getPageActivity(), a.this.fgz, 0, str)) {
                                    a.this.fgC.qM(a.this.fgz.apv);
                                    return;
                                }
                                return;
                            }
                            a.this.c(a.this.fgz);
                            return;
                        } else if (i == 1) {
                            s.f(a.this.fgz);
                            a.this.fgz.apo = 3;
                            a.this.aWi();
                            return;
                        } else if (i == 2) {
                            if (com.baidu.tieba.recapp.download.d.buG().hz(a.this.fgz.apv)) {
                                u.aG(a.this.mContext.getPageActivity(), a.this.fgz.apv);
                                return;
                            }
                            a.this.fgz.apo = 0;
                            a.this.aWi();
                            return;
                        } else {
                            return;
                        }
                    }
                    l.showToast((Activity) view.getContext(), e.j.write_external_storage_permission_denied_fun_disable);
                }
            }
        }
    };
    private final View.OnClickListener fgF = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.fgz != null) {
                if (a.this.fgB == null || !a.this.fgB.fgM || a.this.fgB.aWn() != view) {
                    a.this.fgC.aWt();
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.fgz));
                    r.buz().buw().a(a.this.mContext.getPageActivity(), new String[]{a.this.fgz.apt}, true);
                }
            }
        }
    };
    private final CustomMessageListener fgG = new CustomMessageListener(0) { // from class: com.baidu.tieba.image.a.6
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && !customResponsedMessage.hasError()) {
                a.this.e(customResponsedMessage);
            }
        }
    };

    public a(boolean z, boolean z2, TbPageContext<?> tbPageContext, String str, String str2) {
        this.aTz = false;
        this.fgA = false;
        this.aTz = z;
        this.fgA = z2;
        this.mContext = tbPageContext;
        this.mContext.registerListener(2001118, this.fgG);
        this.fgC = new c(tbPageContext.getPageActivity(), str, str2);
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.fgz = advertAppInfo;
        this.fgy = i;
        this.fgC.d(this.fgz);
    }

    public boolean aWh() {
        if (!this.fgA || this.fgz == null) {
            return false;
        }
        return (this.fgz.ye() || this.fgz.yd()) && !u.isInstalledPackage(this.mContext.getPageActivity(), this.fgz.apv);
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View f(ViewGroup viewGroup, int i) {
        if (qH(i)) {
            this.fgB = new b(viewGroup);
            aWi();
            viewGroup.addView(this.fgB.getView());
            return this.fgB.getView();
        }
        return null;
    }

    private boolean qH(int i) {
        return aWh() && this.fgy != 0 && i == this.fgy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWi() {
        if (this.fgz != null && this.fgz.apB != null) {
            aWj();
            if (this.fgz.ye()) {
                this.fgB.aWo().setVisibility(8);
                this.fgB.v(this.fgF);
            } else if (this.fgz.yd()) {
                this.fgB.aWo().setVisibility(0);
                this.fgB.v(this.fgE);
                aWk();
            }
            s.a(this.fgz.apB.apU, this.fgB.fgJ, this.fgz.apB.tagRatio, l.h(this.mContext.getPageActivity(), e.C0210e.ds26));
            if (!TextUtils.isEmpty(this.fgz.apB.adSource)) {
                this.fgB.fgL.setText(this.fgz.apB.adSource);
                this.fgB.fgK.setVisibility(0);
                return;
            }
            this.fgB.fgK.setVisibility(8);
        }
    }

    private void aWj() {
        this.fgB.aWn().setEvent(new TbImageView.a() { // from class: com.baidu.tieba.image.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z) {
                    a.this.fgB.aWr();
                }
                a.this.fgB.aWs();
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
                a.this.fgB.aWs();
            }
        });
        this.fgB.aWn().startLoad(this.fgz.apB.apM, this.aTz ? 30 : 31, 720, 720, false);
    }

    private void aWk() {
        if (this.fgz != null) {
            String str = this.fgz.apr;
            if (StringUtils.isNull(str)) {
                str = this.mContext.getString(e.j.app_name);
            }
            if (com.baidu.tieba.recapp.download.d.buG().hz(this.fgz.apv)) {
                this.fgz.apo = 2;
            } else if (com.baidu.tieba.recapp.download.d.buG().cy(this.fgz.apv, str)) {
                if (com.baidu.tieba.recapp.download.d.buG().hx(this.fgz.apv)) {
                    this.fgz.apo = 1;
                } else {
                    this.fgz.apo = 3;
                }
            }
            switch (this.fgz.apo) {
                case 0:
                    String string = this.mContext.getString(e.j.install_app);
                    if (this.fgz.apB != null && !StringUtils.isNull(this.fgz.apB.buttonText)) {
                        string = this.fgz.apB.buttonText;
                    }
                    if (string.length() > fgx) {
                        string = string.substring(0, fgx);
                    }
                    this.fgB.qL(string);
                    return;
                case 1:
                    this.fgB.aWp();
                    return;
                case 2:
                    this.fgB.aWq();
                    return;
                case 3:
                    this.fgB.qL(this.mContext.getString(e.j.pb_download_pause));
                    return;
                default:
                    this.fgB.aWo().setVisibility(8);
                    this.fgB.v(null);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(AdvertAppInfo advertAppInfo) {
        String string;
        if (advertAppInfo != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            if (j.kX()) {
                string = this.mContext.getString(e.j.frs_network_tips);
            } else {
                string = this.mContext.getString(e.j.confirm_download_app);
            }
            aVar.eB(string);
            aVar.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.image.a.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    String str = a.this.fgz.apr;
                    if (StringUtils.isNull(str)) {
                        str = a.this.mContext.getString(e.j.app_name);
                    }
                    a.this.fgC.aWv();
                    if (s.a(a.this.mContext.getPageActivity(), a.this.fgz, 0, str)) {
                        a.this.fgC.qM(a.this.fgz.apv);
                    }
                    aVar2.dismiss();
                }
            });
            aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.image.a.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.mContext).BF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        if ((responsedMessage instanceof DownloadMessage) && this.fgz != null && (data = ((DownloadMessage) responsedMessage).getData()) != null && data.size() != 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null && TextUtils.equals(this.fgz.apv, downloadData.getId())) {
                    int status = downloadData.getStatus();
                    if (status == 3 || status == 0) {
                        this.fgz.apo = 2;
                    } else if (status == 2 || status == 4) {
                        if (!ao.isEmpty(downloadData.getStatusMsg())) {
                            this.mContext.showToast(downloadData.getStatusMsg());
                        }
                        this.fgz.apo = 0;
                    } else if (status == 1) {
                        this.fgz.apo = 1;
                    }
                    aWi();
                }
            }
        }
    }

    public void aWl() {
        if (!this.fgD) {
            this.fgD = true;
            this.fgC.aWu();
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(this.fgz));
        }
    }
}
