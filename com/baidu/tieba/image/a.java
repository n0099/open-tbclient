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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.tbadkCore.u;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements ImagePagerAdapter.a {
    private static int gAd = 7;
    private boolean cdq;
    private DragImageView.d cfe;
    private AdvertAppInfo gAf;
    private boolean gAg;
    private b gAh;
    private c gAi;
    private TbPageContext<?> mContext;
    private int gAe = 0;
    private boolean gAj = false;
    private final View.OnClickListener gAk = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.gAf != null) {
                if (a.this.gAh == null || !a.this.gAh.gAu || a.this.gAh.bye() != view) {
                    if (!u.an((Activity) view.getContext())) {
                        l.showToast((Activity) view.getContext(), d.j.write_external_storage_permission_denied_fun_disable);
                        return;
                    }
                    if (view.getId() == d.g.big_image_ad_title || view.getId() == d.g.big_image_ad_brand) {
                        a.this.gAi.byk();
                    } else {
                        a.this.gAi.byj();
                    }
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.gAf));
                    int i = a.this.gAf.bwA;
                    if (i == 0 || i == 3) {
                        if (!j.kY() || j.kZ()) {
                            String str = a.this.gAf.bwC;
                            if (StringUtils.isNull(str)) {
                                str = a.this.mContext.getString(d.j.app_name);
                            }
                            a.this.gAi.bym();
                            if (s.a(a.this.mContext.getPageActivity(), a.this.gAf, 0, str)) {
                                a.this.gAi.xL(a.this.gAf.bwF);
                                return;
                            }
                            return;
                        }
                        a.this.c(a.this.gAf);
                    } else if (i == 1) {
                        s.f(a.this.gAf);
                        a.this.gAf.bwA = 3;
                        a.this.bxY();
                    } else if (i == 2) {
                        if (com.baidu.tieba.recapp.download.d.bWO().oC(a.this.gAf.bwF)) {
                            u.aS(a.this.mContext.getPageActivity(), a.this.gAf.bwF);
                            return;
                        }
                        a.this.gAf.bwA = 0;
                        a.this.bxY();
                    }
                }
            }
        }
    };
    private final View.OnClickListener gAl = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.gAf != null) {
                if (a.this.gAh == null || !a.this.gAh.gAu || a.this.gAh.bye() != view) {
                    if (view.getId() == d.g.big_image_ad_title || view.getId() == d.g.big_image_ad_brand) {
                        a.this.gAi.byk();
                    } else {
                        a.this.gAi.byj();
                    }
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.gAf));
                    r.bWH().bWE().a(a.this.mContext.getPageActivity(), new String[]{a.this.gAf.bwD}, true);
                }
            }
        }
    };
    private final CustomMessageListener gAm = new CustomMessageListener(0) { // from class: com.baidu.tieba.image.a.6
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
        this.cdq = false;
        this.gAg = false;
        this.cdq = z;
        this.gAg = z2;
        this.mContext = tbPageContext;
        this.mContext.registerListener(2001118, this.gAm);
        this.gAi = new c(tbPageContext.getPageActivity(), str, str2);
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.gAf = advertAppInfo;
        this.gAe = i;
        this.gAi.d(this.gAf);
    }

    public boolean bxX() {
        if (!this.gAg || this.gAf == null) {
            return false;
        }
        return (this.gAf.Xc() || this.gAf.Xb()) && !u.isInstalledPackage(this.mContext.getPageActivity(), this.gAf.bwF);
    }

    public String getAdId() {
        if (this.gAf != null) {
            return this.gAf.bwB;
        }
        return null;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View g(ViewGroup viewGroup, int i) {
        if (uD(i)) {
            this.gAh = new b(viewGroup);
            this.gAh.setDragToExitListener(this.cfe);
            bxY();
            viewGroup.addView(this.gAh.getView());
            return this.gAh.getView();
        }
        return null;
    }

    private boolean uD(int i) {
        return bxX() && this.gAe != 0 && i == this.gAe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxY() {
        if (this.gAf != null && this.gAf.bwL != null) {
            bxZ();
            if (this.gAf.Xc()) {
                this.gAh.byf().setVisibility(8);
                this.gAh.w(this.gAl);
            } else if (this.gAf.Xb()) {
                this.gAh.byf().setVisibility(0);
                this.gAh.w(this.gAk);
                bya();
            }
            if (!TextUtils.isEmpty(this.gAf.bwL.adSource)) {
                this.gAh.gAt.setText(this.gAf.bwL.adSource);
                this.gAh.gAq.setVisibility(0);
            } else {
                this.gAh.gAq.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.gAf.bwL.userName)) {
                if (!TextUtils.isEmpty(this.gAf.bwL.tagName)) {
                    this.gAh.gAs.setText(this.mContext.getResources().getString(d.j.big_image_ad_brand_and_tag, this.gAf.bwL.userName, this.gAf.bwL.tagName));
                } else {
                    this.gAh.gAs.setText(this.mContext.getResources().getString(d.j.big_image_ad_brand_and_tag, this.gAf.bwL.userName, this.mContext.getString(d.j.advert_label)));
                }
            }
            if (!TextUtils.isEmpty(this.gAf.bwL.bwU)) {
                this.gAh.gAr.setText(this.gAf.bwL.bwU);
            }
        }
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.cfe = dVar;
    }

    private void bxZ() {
        this.gAh.bye().setEvent(new TbImageView.a() { // from class: com.baidu.tieba.image.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void L(String str, boolean z) {
                if (z) {
                    a.this.gAh.byi();
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.gAh.bye().startLoad(this.gAf.bwL.bwW, this.cdq ? 30 : 31, 720, 720, false);
        if (this.gAh.byd() != null) {
            this.gAh.byd().setIsCdn(this.cdq);
            this.gAh.byd().setUrl(this.gAf.bwL.bwW, true);
        }
    }

    private void bya() {
        if (this.gAf != null) {
            String str = this.gAf.bwC;
            if (StringUtils.isNull(str)) {
                str = this.mContext.getString(d.j.app_name);
            }
            if (com.baidu.tieba.recapp.download.d.bWO().oC(this.gAf.bwF)) {
                this.gAf.bwA = 2;
            } else if (com.baidu.tieba.recapp.download.d.bWO().dJ(this.gAf.bwF, str)) {
                if (com.baidu.tieba.recapp.download.d.bWO().oA(this.gAf.bwF)) {
                    this.gAf.bwA = 1;
                } else {
                    this.gAf.bwA = 3;
                }
            }
            switch (this.gAf.bwA) {
                case 0:
                    String string = this.mContext.getString(d.j.install_app);
                    if (this.gAf.bwL != null && !StringUtils.isNull(this.gAf.bwL.buttonText)) {
                        string = this.gAf.bwL.buttonText;
                    }
                    if (string.length() > gAd) {
                        string = string.substring(0, gAd);
                    }
                    this.gAh.xK(string);
                    return;
                case 1:
                    this.gAh.byg();
                    return;
                case 2:
                    this.gAh.byh();
                    return;
                case 3:
                    this.gAh.xK(this.mContext.getString(d.j.pb_download_pause));
                    return;
                default:
                    this.gAh.byf().setVisibility(8);
                    this.gAh.w(null);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(AdvertAppInfo advertAppInfo) {
        String string;
        if (advertAppInfo != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            if (j.la()) {
                string = this.mContext.getString(d.j.frs_network_tips);
            } else {
                string = this.mContext.getString(d.j.confirm_download_app);
            }
            aVar.ly(string);
            aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.image.a.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    String str = a.this.gAf.bwC;
                    if (StringUtils.isNull(str)) {
                        str = a.this.mContext.getString(d.j.app_name);
                    }
                    a.this.gAi.bym();
                    if (s.a(a.this.mContext.getPageActivity(), a.this.gAf, 0, str)) {
                        a.this.gAi.xL(a.this.gAf.bwF);
                    }
                    aVar2.dismiss();
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.image.a.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.mContext).aaZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        if ((responsedMessage instanceof DownloadMessage) && this.gAf != null && (data = ((DownloadMessage) responsedMessage).getData()) != null && data.size() != 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null && TextUtils.equals(this.gAf.bwF, downloadData.getId())) {
                    int status = downloadData.getStatus();
                    if (status == 3 || status == 0) {
                        this.gAf.bwA = 2;
                    } else if (status == 2 || status == 4) {
                        if (!ap.isEmpty(downloadData.getStatusMsg())) {
                            this.mContext.showToast(downloadData.getStatusMsg());
                        }
                        this.gAf.bwA = 0;
                    } else if (status == 1) {
                        this.gAf.bwA = 1;
                    }
                    bxY();
                }
            }
        }
    }

    public void byb() {
        if (!this.gAj) {
            this.gAj = true;
            this.gAi.byl();
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(this.gAf));
        }
    }
}
