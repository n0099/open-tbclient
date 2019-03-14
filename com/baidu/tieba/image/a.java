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
    private static int gAc = 7;
    private boolean cdq;
    private DragImageView.d cfe;
    private AdvertAppInfo gAe;
    private boolean gAf;
    private b gAg;
    private c gAh;
    private TbPageContext<?> mContext;
    private int gAd = 0;
    private boolean gAi = false;
    private final View.OnClickListener gAj = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.gAe != null) {
                if (a.this.gAg == null || !a.this.gAg.gAt || a.this.gAg.byd() != view) {
                    if (!u.an((Activity) view.getContext())) {
                        l.showToast((Activity) view.getContext(), d.j.write_external_storage_permission_denied_fun_disable);
                        return;
                    }
                    if (view.getId() == d.g.big_image_ad_title || view.getId() == d.g.big_image_ad_brand) {
                        a.this.gAh.byj();
                    } else {
                        a.this.gAh.byi();
                    }
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.gAe));
                    int i = a.this.gAe.bwC;
                    if (i == 0 || i == 3) {
                        if (!j.kY() || j.kZ()) {
                            String str = a.this.gAe.bwE;
                            if (StringUtils.isNull(str)) {
                                str = a.this.mContext.getString(d.j.app_name);
                            }
                            a.this.gAh.byl();
                            if (s.a(a.this.mContext.getPageActivity(), a.this.gAe, 0, str)) {
                                a.this.gAh.xJ(a.this.gAe.bwH);
                                return;
                            }
                            return;
                        }
                        a.this.c(a.this.gAe);
                    } else if (i == 1) {
                        s.f(a.this.gAe);
                        a.this.gAe.bwC = 3;
                        a.this.bxX();
                    } else if (i == 2) {
                        if (com.baidu.tieba.recapp.download.d.bWQ().oC(a.this.gAe.bwH)) {
                            u.aR(a.this.mContext.getPageActivity(), a.this.gAe.bwH);
                            return;
                        }
                        a.this.gAe.bwC = 0;
                        a.this.bxX();
                    }
                }
            }
        }
    };
    private final View.OnClickListener gAk = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.gAe != null) {
                if (a.this.gAg == null || !a.this.gAg.gAt || a.this.gAg.byd() != view) {
                    if (view.getId() == d.g.big_image_ad_title || view.getId() == d.g.big_image_ad_brand) {
                        a.this.gAh.byj();
                    } else {
                        a.this.gAh.byi();
                    }
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.gAe));
                    r.bWJ().bWG().a(a.this.mContext.getPageActivity(), new String[]{a.this.gAe.bwF}, true);
                }
            }
        }
    };
    private final CustomMessageListener gAl = new CustomMessageListener(0) { // from class: com.baidu.tieba.image.a.6
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
        this.gAf = false;
        this.cdq = z;
        this.gAf = z2;
        this.mContext = tbPageContext;
        this.mContext.registerListener(2001118, this.gAl);
        this.gAh = new c(tbPageContext.getPageActivity(), str, str2);
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.gAe = advertAppInfo;
        this.gAd = i;
        this.gAh.d(this.gAe);
    }

    public boolean bxW() {
        if (!this.gAf || this.gAe == null) {
            return false;
        }
        return (this.gAe.Xc() || this.gAe.Xb()) && !u.isInstalledPackage(this.mContext.getPageActivity(), this.gAe.bwH);
    }

    public String getAdId() {
        if (this.gAe != null) {
            return this.gAe.bwD;
        }
        return null;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View g(ViewGroup viewGroup, int i) {
        if (uD(i)) {
            this.gAg = new b(viewGroup);
            this.gAg.setDragToExitListener(this.cfe);
            bxX();
            viewGroup.addView(this.gAg.getView());
            return this.gAg.getView();
        }
        return null;
    }

    private boolean uD(int i) {
        return bxW() && this.gAd != 0 && i == this.gAd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxX() {
        if (this.gAe != null && this.gAe.bwN != null) {
            bxY();
            if (this.gAe.Xc()) {
                this.gAg.bye().setVisibility(8);
                this.gAg.w(this.gAk);
            } else if (this.gAe.Xb()) {
                this.gAg.bye().setVisibility(0);
                this.gAg.w(this.gAj);
                bxZ();
            }
            if (!TextUtils.isEmpty(this.gAe.bwN.adSource)) {
                this.gAg.gAs.setText(this.gAe.bwN.adSource);
                this.gAg.gAp.setVisibility(0);
            } else {
                this.gAg.gAp.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.gAe.bwN.userName)) {
                if (!TextUtils.isEmpty(this.gAe.bwN.tagName)) {
                    this.gAg.gAr.setText(this.mContext.getResources().getString(d.j.big_image_ad_brand_and_tag, this.gAe.bwN.userName, this.gAe.bwN.tagName));
                } else {
                    this.gAg.gAr.setText(this.mContext.getResources().getString(d.j.big_image_ad_brand_and_tag, this.gAe.bwN.userName, this.mContext.getString(d.j.advert_label)));
                }
            }
            if (!TextUtils.isEmpty(this.gAe.bwN.bwW)) {
                this.gAg.gAq.setText(this.gAe.bwN.bwW);
            }
        }
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.cfe = dVar;
    }

    private void bxY() {
        this.gAg.byd().setEvent(new TbImageView.a() { // from class: com.baidu.tieba.image.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void L(String str, boolean z) {
                if (z) {
                    a.this.gAg.byh();
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.gAg.byd().startLoad(this.gAe.bwN.bwY, this.cdq ? 30 : 31, 720, 720, false);
        if (this.gAg.byc() != null) {
            this.gAg.byc().setIsCdn(this.cdq);
            this.gAg.byc().setUrl(this.gAe.bwN.bwY, true);
        }
    }

    private void bxZ() {
        if (this.gAe != null) {
            String str = this.gAe.bwE;
            if (StringUtils.isNull(str)) {
                str = this.mContext.getString(d.j.app_name);
            }
            if (com.baidu.tieba.recapp.download.d.bWQ().oC(this.gAe.bwH)) {
                this.gAe.bwC = 2;
            } else if (com.baidu.tieba.recapp.download.d.bWQ().dI(this.gAe.bwH, str)) {
                if (com.baidu.tieba.recapp.download.d.bWQ().oA(this.gAe.bwH)) {
                    this.gAe.bwC = 1;
                } else {
                    this.gAe.bwC = 3;
                }
            }
            switch (this.gAe.bwC) {
                case 0:
                    String string = this.mContext.getString(d.j.install_app);
                    if (this.gAe.bwN != null && !StringUtils.isNull(this.gAe.bwN.buttonText)) {
                        string = this.gAe.bwN.buttonText;
                    }
                    if (string.length() > gAc) {
                        string = string.substring(0, gAc);
                    }
                    this.gAg.xI(string);
                    return;
                case 1:
                    this.gAg.byf();
                    return;
                case 2:
                    this.gAg.byg();
                    return;
                case 3:
                    this.gAg.xI(this.mContext.getString(d.j.pb_download_pause));
                    return;
                default:
                    this.gAg.bye().setVisibility(8);
                    this.gAg.w(null);
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
                    String str = a.this.gAe.bwE;
                    if (StringUtils.isNull(str)) {
                        str = a.this.mContext.getString(d.j.app_name);
                    }
                    a.this.gAh.byl();
                    if (s.a(a.this.mContext.getPageActivity(), a.this.gAe, 0, str)) {
                        a.this.gAh.xJ(a.this.gAe.bwH);
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
        if ((responsedMessage instanceof DownloadMessage) && this.gAe != null && (data = ((DownloadMessage) responsedMessage).getData()) != null && data.size() != 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null && TextUtils.equals(this.gAe.bwH, downloadData.getId())) {
                    int status = downloadData.getStatus();
                    if (status == 3 || status == 0) {
                        this.gAe.bwC = 2;
                    } else if (status == 2 || status == 4) {
                        if (!ap.isEmpty(downloadData.getStatusMsg())) {
                            this.mContext.showToast(downloadData.getStatusMsg());
                        }
                        this.gAe.bwC = 0;
                    } else if (status == 1) {
                        this.gAe.bwC = 1;
                    }
                    bxX();
                }
            }
        }
    }

    public void bya() {
        if (!this.gAi) {
            this.gAi = true;
            this.gAh.byk();
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(this.gAe));
        }
    }
}
