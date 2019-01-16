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
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.tbadkCore.u;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements ImagePagerAdapter.a {
    private static int fkf = 7;
    private boolean aUk;
    private DragImageView.d aVK;
    private AdvertAppInfo fkh;
    private boolean fki;
    private b fkj;
    private c fkk;
    private TbPageContext<?> mContext;
    private int fkg = 0;
    private boolean fkl = false;
    private final View.OnClickListener fkm = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.fkh != null) {
                if (a.this.fkj == null || !a.this.fkj.fku || a.this.fkj.aXB() != view) {
                    if (u.O((Activity) view.getContext())) {
                        a.this.fkk.aXG();
                        com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.fkh));
                        int i = a.this.fkh.apR;
                        if (i == 0 || i == 3) {
                            if (!j.kV() || j.kW()) {
                                String str = a.this.fkh.apT;
                                if (StringUtils.isNull(str)) {
                                    str = a.this.mContext.getString(e.j.app_name);
                                }
                                a.this.fkk.aXI();
                                if (s.a(a.this.mContext.getPageActivity(), a.this.fkh, 0, str)) {
                                    a.this.fkk.rf(a.this.fkh.apX);
                                    return;
                                }
                                return;
                            }
                            a.this.c(a.this.fkh);
                            return;
                        } else if (i == 1) {
                            s.f(a.this.fkh);
                            a.this.fkh.apR = 3;
                            a.this.aXv();
                            return;
                        } else if (i == 2) {
                            if (com.baidu.tieba.recapp.download.d.bwa().hO(a.this.fkh.apX)) {
                                u.aE(a.this.mContext.getPageActivity(), a.this.fkh.apX);
                                return;
                            }
                            a.this.fkh.apR = 0;
                            a.this.aXv();
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
    private final View.OnClickListener fkn = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.fkh != null) {
                if (a.this.fkj == null || !a.this.fkj.fku || a.this.fkj.aXB() != view) {
                    a.this.fkk.aXG();
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.fkh));
                    r.bvT().bvQ().a(a.this.mContext.getPageActivity(), new String[]{a.this.fkh.apV}, true);
                }
            }
        }
    };
    private final CustomMessageListener fko = new CustomMessageListener(0) { // from class: com.baidu.tieba.image.a.6
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
        this.aUk = false;
        this.fki = false;
        this.aUk = z;
        this.fki = z2;
        this.mContext = tbPageContext;
        this.mContext.registerListener(2001118, this.fko);
        this.fkk = new c(tbPageContext.getPageActivity(), str, str2);
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.fkh = advertAppInfo;
        this.fkg = i;
        this.fkk.d(this.fkh);
    }

    public boolean aXu() {
        if (!this.fki || this.fkh == null) {
            return false;
        }
        return (this.fkh.yr() || this.fkh.yq()) && !u.isInstalledPackage(this.mContext.getPageActivity(), this.fkh.apX);
    }

    public String getAdId() {
        if (this.fkh != null) {
            return this.fkh.apS;
        }
        return null;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View f(ViewGroup viewGroup, int i) {
        if (qV(i)) {
            this.fkj = new b(viewGroup);
            this.fkj.setDragToExitListener(this.aVK);
            aXv();
            viewGroup.addView(this.fkj.getView());
            return this.fkj.getView();
        }
        return null;
    }

    private boolean qV(int i) {
        return aXu() && this.fkg != 0 && i == this.fkg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXv() {
        if (this.fkh != null && this.fkh.aqd != null) {
            aXw();
            if (this.fkh.yr()) {
                this.fkj.aXC().setVisibility(8);
                this.fkj.v(this.fkn);
            } else if (this.fkh.yq()) {
                this.fkj.aXC().setVisibility(0);
                this.fkj.v(this.fkm);
                aXx();
            }
            s.a(this.fkh.aqd.aqw, this.fkj.fkr, this.fkh.aqd.tagRatio, l.h(this.mContext.getPageActivity(), e.C0210e.ds26));
            if (!TextUtils.isEmpty(this.fkh.aqd.adSource)) {
                this.fkj.fkt.setText(this.fkh.aqd.adSource);
                this.fkj.fks.setVisibility(0);
                return;
            }
            this.fkj.fks.setVisibility(8);
        }
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.aVK = dVar;
    }

    private void aXw() {
        this.fkj.aXB().setEvent(new TbImageView.a() { // from class: com.baidu.tieba.image.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z) {
                    a.this.fkj.aXF();
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.fkj.aXB().startLoad(this.fkh.aqd.aqo, this.aUk ? 30 : 31, 720, 720, false);
        if (this.fkj.aXA() != null) {
            this.fkj.aXA().setIsCdn(this.aUk);
            this.fkj.aXA().setUrl(this.fkh.aqd.aqo, true);
        }
    }

    private void aXx() {
        if (this.fkh != null) {
            String str = this.fkh.apT;
            if (StringUtils.isNull(str)) {
                str = this.mContext.getString(e.j.app_name);
            }
            if (com.baidu.tieba.recapp.download.d.bwa().hO(this.fkh.apX)) {
                this.fkh.apR = 2;
            } else if (com.baidu.tieba.recapp.download.d.bwa().cz(this.fkh.apX, str)) {
                if (com.baidu.tieba.recapp.download.d.bwa().hM(this.fkh.apX)) {
                    this.fkh.apR = 1;
                } else {
                    this.fkh.apR = 3;
                }
            }
            switch (this.fkh.apR) {
                case 0:
                    String string = this.mContext.getString(e.j.install_app);
                    if (this.fkh.aqd != null && !StringUtils.isNull(this.fkh.aqd.buttonText)) {
                        string = this.fkh.aqd.buttonText;
                    }
                    if (string.length() > fkf) {
                        string = string.substring(0, fkf);
                    }
                    this.fkj.re(string);
                    return;
                case 1:
                    this.fkj.aXD();
                    return;
                case 2:
                    this.fkj.aXE();
                    return;
                case 3:
                    this.fkj.re(this.mContext.getString(e.j.pb_download_pause));
                    return;
                default:
                    this.fkj.aXC().setVisibility(8);
                    this.fkj.v(null);
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
            aVar.eK(string);
            aVar.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.image.a.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    String str = a.this.fkh.apT;
                    if (StringUtils.isNull(str)) {
                        str = a.this.mContext.getString(e.j.app_name);
                    }
                    a.this.fkk.aXI();
                    if (s.a(a.this.mContext.getPageActivity(), a.this.fkh, 0, str)) {
                        a.this.fkk.rf(a.this.fkh.apX);
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
            aVar.b(this.mContext).BS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        if ((responsedMessage instanceof DownloadMessage) && this.fkh != null && (data = ((DownloadMessage) responsedMessage).getData()) != null && data.size() != 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null && TextUtils.equals(this.fkh.apX, downloadData.getId())) {
                    int status = downloadData.getStatus();
                    if (status == 3 || status == 0) {
                        this.fkh.apR = 2;
                    } else if (status == 2 || status == 4) {
                        if (!ao.isEmpty(downloadData.getStatusMsg())) {
                            this.mContext.showToast(downloadData.getStatusMsg());
                        }
                        this.fkh.apR = 0;
                    } else if (status == 1) {
                        this.fkh.apR = 1;
                    }
                    aXv();
                }
            }
        }
    }

    public void aXy() {
        if (!this.fkl) {
            this.fkl = true;
            this.fkk.aXH();
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(this.fkh));
        }
    }
}
