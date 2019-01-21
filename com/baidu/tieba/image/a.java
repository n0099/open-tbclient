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
    private static int fkg = 7;
    private boolean aUl;
    private DragImageView.d aVL;
    private AdvertAppInfo fki;
    private boolean fkj;
    private b fkk;
    private c fkl;
    private TbPageContext<?> mContext;
    private int fkh = 0;
    private boolean fkm = false;
    private final View.OnClickListener fkn = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.fki != null) {
                if (a.this.fkk == null || !a.this.fkk.fkv || a.this.fkk.aXB() != view) {
                    if (u.O((Activity) view.getContext())) {
                        a.this.fkl.aXG();
                        com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.fki));
                        int i = a.this.fki.apS;
                        if (i == 0 || i == 3) {
                            if (!j.kV() || j.kW()) {
                                String str = a.this.fki.apU;
                                if (StringUtils.isNull(str)) {
                                    str = a.this.mContext.getString(e.j.app_name);
                                }
                                a.this.fkl.aXI();
                                if (s.a(a.this.mContext.getPageActivity(), a.this.fki, 0, str)) {
                                    a.this.fkl.rf(a.this.fki.apY);
                                    return;
                                }
                                return;
                            }
                            a.this.c(a.this.fki);
                            return;
                        } else if (i == 1) {
                            s.f(a.this.fki);
                            a.this.fki.apS = 3;
                            a.this.aXv();
                            return;
                        } else if (i == 2) {
                            if (com.baidu.tieba.recapp.download.d.bwa().hO(a.this.fki.apY)) {
                                u.aE(a.this.mContext.getPageActivity(), a.this.fki.apY);
                                return;
                            }
                            a.this.fki.apS = 0;
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
    private final View.OnClickListener fko = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.fki != null) {
                if (a.this.fkk == null || !a.this.fkk.fkv || a.this.fkk.aXB() != view) {
                    a.this.fkl.aXG();
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.fki));
                    r.bvT().bvQ().a(a.this.mContext.getPageActivity(), new String[]{a.this.fki.apW}, true);
                }
            }
        }
    };
    private final CustomMessageListener fkp = new CustomMessageListener(0) { // from class: com.baidu.tieba.image.a.6
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
        this.aUl = false;
        this.fkj = false;
        this.aUl = z;
        this.fkj = z2;
        this.mContext = tbPageContext;
        this.mContext.registerListener(2001118, this.fkp);
        this.fkl = new c(tbPageContext.getPageActivity(), str, str2);
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.fki = advertAppInfo;
        this.fkh = i;
        this.fkl.d(this.fki);
    }

    public boolean aXu() {
        if (!this.fkj || this.fki == null) {
            return false;
        }
        return (this.fki.yr() || this.fki.yq()) && !u.isInstalledPackage(this.mContext.getPageActivity(), this.fki.apY);
    }

    public String getAdId() {
        if (this.fki != null) {
            return this.fki.apT;
        }
        return null;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View f(ViewGroup viewGroup, int i) {
        if (qV(i)) {
            this.fkk = new b(viewGroup);
            this.fkk.setDragToExitListener(this.aVL);
            aXv();
            viewGroup.addView(this.fkk.getView());
            return this.fkk.getView();
        }
        return null;
    }

    private boolean qV(int i) {
        return aXu() && this.fkh != 0 && i == this.fkh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXv() {
        if (this.fki != null && this.fki.aqe != null) {
            aXw();
            if (this.fki.yr()) {
                this.fkk.aXC().setVisibility(8);
                this.fkk.v(this.fko);
            } else if (this.fki.yq()) {
                this.fkk.aXC().setVisibility(0);
                this.fkk.v(this.fkn);
                aXx();
            }
            s.a(this.fki.aqe.aqx, this.fkk.fks, this.fki.aqe.tagRatio, l.h(this.mContext.getPageActivity(), e.C0210e.ds26));
            if (!TextUtils.isEmpty(this.fki.aqe.adSource)) {
                this.fkk.fku.setText(this.fki.aqe.adSource);
                this.fkk.fkt.setVisibility(0);
                return;
            }
            this.fkk.fkt.setVisibility(8);
        }
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.aVL = dVar;
    }

    private void aXw() {
        this.fkk.aXB().setEvent(new TbImageView.a() { // from class: com.baidu.tieba.image.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z) {
                    a.this.fkk.aXF();
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.fkk.aXB().startLoad(this.fki.aqe.aqp, this.aUl ? 30 : 31, 720, 720, false);
        if (this.fkk.aXA() != null) {
            this.fkk.aXA().setIsCdn(this.aUl);
            this.fkk.aXA().setUrl(this.fki.aqe.aqp, true);
        }
    }

    private void aXx() {
        if (this.fki != null) {
            String str = this.fki.apU;
            if (StringUtils.isNull(str)) {
                str = this.mContext.getString(e.j.app_name);
            }
            if (com.baidu.tieba.recapp.download.d.bwa().hO(this.fki.apY)) {
                this.fki.apS = 2;
            } else if (com.baidu.tieba.recapp.download.d.bwa().cz(this.fki.apY, str)) {
                if (com.baidu.tieba.recapp.download.d.bwa().hM(this.fki.apY)) {
                    this.fki.apS = 1;
                } else {
                    this.fki.apS = 3;
                }
            }
            switch (this.fki.apS) {
                case 0:
                    String string = this.mContext.getString(e.j.install_app);
                    if (this.fki.aqe != null && !StringUtils.isNull(this.fki.aqe.buttonText)) {
                        string = this.fki.aqe.buttonText;
                    }
                    if (string.length() > fkg) {
                        string = string.substring(0, fkg);
                    }
                    this.fkk.re(string);
                    return;
                case 1:
                    this.fkk.aXD();
                    return;
                case 2:
                    this.fkk.aXE();
                    return;
                case 3:
                    this.fkk.re(this.mContext.getString(e.j.pb_download_pause));
                    return;
                default:
                    this.fkk.aXC().setVisibility(8);
                    this.fkk.v(null);
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
                    String str = a.this.fki.apU;
                    if (StringUtils.isNull(str)) {
                        str = a.this.mContext.getString(e.j.app_name);
                    }
                    a.this.fkl.aXI();
                    if (s.a(a.this.mContext.getPageActivity(), a.this.fki, 0, str)) {
                        a.this.fkl.rf(a.this.fki.apY);
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
        if ((responsedMessage instanceof DownloadMessage) && this.fki != null && (data = ((DownloadMessage) responsedMessage).getData()) != null && data.size() != 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null && TextUtils.equals(this.fki.apY, downloadData.getId())) {
                    int status = downloadData.getStatus();
                    if (status == 3 || status == 0) {
                        this.fki.apS = 2;
                    } else if (status == 2 || status == 4) {
                        if (!ao.isEmpty(downloadData.getStatusMsg())) {
                            this.mContext.showToast(downloadData.getStatusMsg());
                        }
                        this.fki.apS = 0;
                    } else if (status == 1) {
                        this.fki.apS = 1;
                    }
                    aXv();
                }
            }
        }
    }

    public void aXy() {
        if (!this.fkm) {
            this.fkm = true;
            this.fkl.aXH();
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(this.fki));
        }
    }
}
