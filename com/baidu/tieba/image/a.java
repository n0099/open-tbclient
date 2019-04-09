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
    private static int gzQ = 7;
    private boolean cdt;
    private DragImageView.d cfh;
    private AdvertAppInfo gzS;
    private boolean gzT;
    private b gzU;
    private c gzV;
    private TbPageContext<?> mContext;
    private int gzR = 0;
    private boolean gzW = false;
    private final View.OnClickListener gzX = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.gzS != null) {
                if (a.this.gzU == null || !a.this.gzU.gAh || a.this.gzU.bya() != view) {
                    if (!u.an((Activity) view.getContext())) {
                        l.showToast((Activity) view.getContext(), d.j.write_external_storage_permission_denied_fun_disable);
                        return;
                    }
                    if (view.getId() == d.g.big_image_ad_title || view.getId() == d.g.big_image_ad_brand) {
                        a.this.gzV.byg();
                    } else {
                        a.this.gzV.byf();
                    }
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.gzS));
                    int i = a.this.gzS.bwG;
                    if (i == 0 || i == 3) {
                        if (!j.kY() || j.kZ()) {
                            String str = a.this.gzS.bwI;
                            if (StringUtils.isNull(str)) {
                                str = a.this.mContext.getString(d.j.app_name);
                            }
                            a.this.gzV.byi();
                            if (s.a(a.this.mContext.getPageActivity(), a.this.gzS, 0, str)) {
                                a.this.gzV.xI(a.this.gzS.bwL);
                                return;
                            }
                            return;
                        }
                        a.this.c(a.this.gzS);
                    } else if (i == 1) {
                        s.f(a.this.gzS);
                        a.this.gzS.bwG = 3;
                        a.this.bxU();
                    } else if (i == 2) {
                        if (com.baidu.tieba.recapp.download.d.bWM().oD(a.this.gzS.bwL)) {
                            u.aR(a.this.mContext.getPageActivity(), a.this.gzS.bwL);
                            return;
                        }
                        a.this.gzS.bwG = 0;
                        a.this.bxU();
                    }
                }
            }
        }
    };
    private final View.OnClickListener gzY = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.gzS != null) {
                if (a.this.gzU == null || !a.this.gzU.gAh || a.this.gzU.bya() != view) {
                    if (view.getId() == d.g.big_image_ad_title || view.getId() == d.g.big_image_ad_brand) {
                        a.this.gzV.byg();
                    } else {
                        a.this.gzV.byf();
                    }
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.gzS));
                    r.bWF().bWC().a(a.this.mContext.getPageActivity(), new String[]{a.this.gzS.bwJ}, true);
                }
            }
        }
    };
    private final CustomMessageListener gzZ = new CustomMessageListener(0) { // from class: com.baidu.tieba.image.a.6
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
        this.cdt = false;
        this.gzT = false;
        this.cdt = z;
        this.gzT = z2;
        this.mContext = tbPageContext;
        this.mContext.registerListener(2001118, this.gzZ);
        this.gzV = new c(tbPageContext.getPageActivity(), str, str2);
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.gzS = advertAppInfo;
        this.gzR = i;
        this.gzV.d(this.gzS);
    }

    public boolean bxT() {
        if (!this.gzT || this.gzS == null) {
            return false;
        }
        return (this.gzS.WZ() || this.gzS.WY()) && !u.isInstalledPackage(this.mContext.getPageActivity(), this.gzS.bwL);
    }

    public String getAdId() {
        if (this.gzS != null) {
            return this.gzS.bwH;
        }
        return null;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View g(ViewGroup viewGroup, int i) {
        if (uz(i)) {
            this.gzU = new b(viewGroup);
            this.gzU.setDragToExitListener(this.cfh);
            bxU();
            viewGroup.addView(this.gzU.getView());
            return this.gzU.getView();
        }
        return null;
    }

    private boolean uz(int i) {
        return bxT() && this.gzR != 0 && i == this.gzR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxU() {
        if (this.gzS != null && this.gzS.bwR != null) {
            bxV();
            if (this.gzS.WZ()) {
                this.gzU.byb().setVisibility(8);
                this.gzU.w(this.gzY);
            } else if (this.gzS.WY()) {
                this.gzU.byb().setVisibility(0);
                this.gzU.w(this.gzX);
                bxW();
            }
            if (!TextUtils.isEmpty(this.gzS.bwR.adSource)) {
                this.gzU.gAg.setText(this.gzS.bwR.adSource);
                this.gzU.gAd.setVisibility(0);
            } else {
                this.gzU.gAd.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.gzS.bwR.userName)) {
                if (!TextUtils.isEmpty(this.gzS.bwR.tagName)) {
                    this.gzU.gAf.setText(this.mContext.getResources().getString(d.j.big_image_ad_brand_and_tag, this.gzS.bwR.userName, this.gzS.bwR.tagName));
                } else {
                    this.gzU.gAf.setText(this.mContext.getResources().getString(d.j.big_image_ad_brand_and_tag, this.gzS.bwR.userName, this.mContext.getString(d.j.advert_label)));
                }
            }
            if (!TextUtils.isEmpty(this.gzS.bwR.bxa)) {
                this.gzU.gAe.setText(this.gzS.bwR.bxa);
            }
        }
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.cfh = dVar;
    }

    private void bxV() {
        this.gzU.bya().setEvent(new TbImageView.a() { // from class: com.baidu.tieba.image.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void L(String str, boolean z) {
                if (z) {
                    a.this.gzU.bye();
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.gzU.bya().startLoad(this.gzS.bwR.bxc, this.cdt ? 30 : 31, 720, 720, false);
        if (this.gzU.bxZ() != null) {
            this.gzU.bxZ().setIsCdn(this.cdt);
            this.gzU.bxZ().setUrl(this.gzS.bwR.bxc, true);
        }
    }

    private void bxW() {
        if (this.gzS != null) {
            String str = this.gzS.bwI;
            if (StringUtils.isNull(str)) {
                str = this.mContext.getString(d.j.app_name);
            }
            if (com.baidu.tieba.recapp.download.d.bWM().oD(this.gzS.bwL)) {
                this.gzS.bwG = 2;
            } else if (com.baidu.tieba.recapp.download.d.bWM().dJ(this.gzS.bwL, str)) {
                if (com.baidu.tieba.recapp.download.d.bWM().oB(this.gzS.bwL)) {
                    this.gzS.bwG = 1;
                } else {
                    this.gzS.bwG = 3;
                }
            }
            switch (this.gzS.bwG) {
                case 0:
                    String string = this.mContext.getString(d.j.install_app);
                    if (this.gzS.bwR != null && !StringUtils.isNull(this.gzS.bwR.buttonText)) {
                        string = this.gzS.bwR.buttonText;
                    }
                    if (string.length() > gzQ) {
                        string = string.substring(0, gzQ);
                    }
                    this.gzU.xH(string);
                    return;
                case 1:
                    this.gzU.byc();
                    return;
                case 2:
                    this.gzU.byd();
                    return;
                case 3:
                    this.gzU.xH(this.mContext.getString(d.j.pb_download_pause));
                    return;
                default:
                    this.gzU.byb().setVisibility(8);
                    this.gzU.w(null);
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
                    String str = a.this.gzS.bwI;
                    if (StringUtils.isNull(str)) {
                        str = a.this.mContext.getString(d.j.app_name);
                    }
                    a.this.gzV.byi();
                    if (s.a(a.this.mContext.getPageActivity(), a.this.gzS, 0, str)) {
                        a.this.gzV.xI(a.this.gzS.bwL);
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
        if ((responsedMessage instanceof DownloadMessage) && this.gzS != null && (data = ((DownloadMessage) responsedMessage).getData()) != null && data.size() != 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null && TextUtils.equals(this.gzS.bwL, downloadData.getId())) {
                    int status = downloadData.getStatus();
                    if (status == 3 || status == 0) {
                        this.gzS.bwG = 2;
                    } else if (status == 2 || status == 4) {
                        if (!ap.isEmpty(downloadData.getStatusMsg())) {
                            this.mContext.showToast(downloadData.getStatusMsg());
                        }
                        this.gzS.bwG = 0;
                    } else if (status == 1) {
                        this.gzS.bwG = 1;
                    }
                    bxU();
                }
            }
        }
    }

    public void bxX() {
        if (!this.gzW) {
            this.gzW = true;
            this.gzV.byh();
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(this.gzS));
        }
    }
}
