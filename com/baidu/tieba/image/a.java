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
    private static int gzP = 7;
    private boolean cds;
    private DragImageView.d cfg;
    private AdvertAppInfo gzR;
    private boolean gzS;
    private b gzT;
    private c gzU;
    private TbPageContext<?> mContext;
    private int gzQ = 0;
    private boolean gzV = false;
    private final View.OnClickListener gzW = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.gzR != null) {
                if (a.this.gzT == null || !a.this.gzT.gAg || a.this.gzT.bya() != view) {
                    if (!u.an((Activity) view.getContext())) {
                        l.showToast((Activity) view.getContext(), d.j.write_external_storage_permission_denied_fun_disable);
                        return;
                    }
                    if (view.getId() == d.g.big_image_ad_title || view.getId() == d.g.big_image_ad_brand) {
                        a.this.gzU.byg();
                    } else {
                        a.this.gzU.byf();
                    }
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.gzR));
                    int i = a.this.gzR.bwF;
                    if (i == 0 || i == 3) {
                        if (!j.kY() || j.kZ()) {
                            String str = a.this.gzR.bwH;
                            if (StringUtils.isNull(str)) {
                                str = a.this.mContext.getString(d.j.app_name);
                            }
                            a.this.gzU.byi();
                            if (s.a(a.this.mContext.getPageActivity(), a.this.gzR, 0, str)) {
                                a.this.gzU.xI(a.this.gzR.bwK);
                                return;
                            }
                            return;
                        }
                        a.this.c(a.this.gzR);
                    } else if (i == 1) {
                        s.f(a.this.gzR);
                        a.this.gzR.bwF = 3;
                        a.this.bxU();
                    } else if (i == 2) {
                        if (com.baidu.tieba.recapp.download.d.bWM().oD(a.this.gzR.bwK)) {
                            u.aR(a.this.mContext.getPageActivity(), a.this.gzR.bwK);
                            return;
                        }
                        a.this.gzR.bwF = 0;
                        a.this.bxU();
                    }
                }
            }
        }
    };
    private final View.OnClickListener gzX = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.gzR != null) {
                if (a.this.gzT == null || !a.this.gzT.gAg || a.this.gzT.bya() != view) {
                    if (view.getId() == d.g.big_image_ad_title || view.getId() == d.g.big_image_ad_brand) {
                        a.this.gzU.byg();
                    } else {
                        a.this.gzU.byf();
                    }
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.gzR));
                    r.bWF().bWC().a(a.this.mContext.getPageActivity(), new String[]{a.this.gzR.bwI}, true);
                }
            }
        }
    };
    private final CustomMessageListener gzY = new CustomMessageListener(0) { // from class: com.baidu.tieba.image.a.6
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
        this.cds = false;
        this.gzS = false;
        this.cds = z;
        this.gzS = z2;
        this.mContext = tbPageContext;
        this.mContext.registerListener(2001118, this.gzY);
        this.gzU = new c(tbPageContext.getPageActivity(), str, str2);
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.gzR = advertAppInfo;
        this.gzQ = i;
        this.gzU.d(this.gzR);
    }

    public boolean bxT() {
        if (!this.gzS || this.gzR == null) {
            return false;
        }
        return (this.gzR.WZ() || this.gzR.WY()) && !u.isInstalledPackage(this.mContext.getPageActivity(), this.gzR.bwK);
    }

    public String getAdId() {
        if (this.gzR != null) {
            return this.gzR.bwG;
        }
        return null;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View g(ViewGroup viewGroup, int i) {
        if (uz(i)) {
            this.gzT = new b(viewGroup);
            this.gzT.setDragToExitListener(this.cfg);
            bxU();
            viewGroup.addView(this.gzT.getView());
            return this.gzT.getView();
        }
        return null;
    }

    private boolean uz(int i) {
        return bxT() && this.gzQ != 0 && i == this.gzQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxU() {
        if (this.gzR != null && this.gzR.bwQ != null) {
            bxV();
            if (this.gzR.WZ()) {
                this.gzT.byb().setVisibility(8);
                this.gzT.w(this.gzX);
            } else if (this.gzR.WY()) {
                this.gzT.byb().setVisibility(0);
                this.gzT.w(this.gzW);
                bxW();
            }
            if (!TextUtils.isEmpty(this.gzR.bwQ.adSource)) {
                this.gzT.gAf.setText(this.gzR.bwQ.adSource);
                this.gzT.gAc.setVisibility(0);
            } else {
                this.gzT.gAc.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.gzR.bwQ.userName)) {
                if (!TextUtils.isEmpty(this.gzR.bwQ.tagName)) {
                    this.gzT.gAe.setText(this.mContext.getResources().getString(d.j.big_image_ad_brand_and_tag, this.gzR.bwQ.userName, this.gzR.bwQ.tagName));
                } else {
                    this.gzT.gAe.setText(this.mContext.getResources().getString(d.j.big_image_ad_brand_and_tag, this.gzR.bwQ.userName, this.mContext.getString(d.j.advert_label)));
                }
            }
            if (!TextUtils.isEmpty(this.gzR.bwQ.bwZ)) {
                this.gzT.gAd.setText(this.gzR.bwQ.bwZ);
            }
        }
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.cfg = dVar;
    }

    private void bxV() {
        this.gzT.bya().setEvent(new TbImageView.a() { // from class: com.baidu.tieba.image.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void L(String str, boolean z) {
                if (z) {
                    a.this.gzT.bye();
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.gzT.bya().startLoad(this.gzR.bwQ.bxb, this.cds ? 30 : 31, 720, 720, false);
        if (this.gzT.bxZ() != null) {
            this.gzT.bxZ().setIsCdn(this.cds);
            this.gzT.bxZ().setUrl(this.gzR.bwQ.bxb, true);
        }
    }

    private void bxW() {
        if (this.gzR != null) {
            String str = this.gzR.bwH;
            if (StringUtils.isNull(str)) {
                str = this.mContext.getString(d.j.app_name);
            }
            if (com.baidu.tieba.recapp.download.d.bWM().oD(this.gzR.bwK)) {
                this.gzR.bwF = 2;
            } else if (com.baidu.tieba.recapp.download.d.bWM().dJ(this.gzR.bwK, str)) {
                if (com.baidu.tieba.recapp.download.d.bWM().oB(this.gzR.bwK)) {
                    this.gzR.bwF = 1;
                } else {
                    this.gzR.bwF = 3;
                }
            }
            switch (this.gzR.bwF) {
                case 0:
                    String string = this.mContext.getString(d.j.install_app);
                    if (this.gzR.bwQ != null && !StringUtils.isNull(this.gzR.bwQ.buttonText)) {
                        string = this.gzR.bwQ.buttonText;
                    }
                    if (string.length() > gzP) {
                        string = string.substring(0, gzP);
                    }
                    this.gzT.xH(string);
                    return;
                case 1:
                    this.gzT.byc();
                    return;
                case 2:
                    this.gzT.byd();
                    return;
                case 3:
                    this.gzT.xH(this.mContext.getString(d.j.pb_download_pause));
                    return;
                default:
                    this.gzT.byb().setVisibility(8);
                    this.gzT.w(null);
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
            aVar.lz(string);
            aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.image.a.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    String str = a.this.gzR.bwH;
                    if (StringUtils.isNull(str)) {
                        str = a.this.mContext.getString(d.j.app_name);
                    }
                    a.this.gzU.byi();
                    if (s.a(a.this.mContext.getPageActivity(), a.this.gzR, 0, str)) {
                        a.this.gzU.xI(a.this.gzR.bwK);
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
            aVar.b(this.mContext).aaW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        if ((responsedMessage instanceof DownloadMessage) && this.gzR != null && (data = ((DownloadMessage) responsedMessage).getData()) != null && data.size() != 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null && TextUtils.equals(this.gzR.bwK, downloadData.getId())) {
                    int status = downloadData.getStatus();
                    if (status == 3 || status == 0) {
                        this.gzR.bwF = 2;
                    } else if (status == 2 || status == 4) {
                        if (!ap.isEmpty(downloadData.getStatusMsg())) {
                            this.mContext.showToast(downloadData.getStatusMsg());
                        }
                        this.gzR.bwF = 0;
                    } else if (status == 1) {
                        this.gzR.bwF = 1;
                    }
                    bxU();
                }
            }
        }
    }

    public void bxX() {
        if (!this.gzV) {
            this.gzV = true;
            this.gzU.byh();
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(this.gzR));
        }
    }
}
