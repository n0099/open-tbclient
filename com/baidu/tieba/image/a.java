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
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.tbadkCore.u;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements ImagePagerAdapter.a {
    private static int gRc = 7;
    private boolean clx;
    private DragImageView.d cnn;
    private AdvertAppInfo gRe;
    private boolean gRf;
    private b gRg;
    private c gRh;
    private TbPageContext<?> mContext;
    private int gRd = 0;
    private boolean gRi = false;
    private final View.OnClickListener gRj = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.gRe != null) {
                if (a.this.gRg == null || !a.this.gRg.gRt || a.this.gRg.bFI() != view) {
                    if (!u.aq((Activity) view.getContext())) {
                        l.showToast((Activity) view.getContext(), (int) R.string.write_external_storage_permission_denied_fun_disable);
                        return;
                    }
                    if (view.getId() == R.id.big_image_ad_title || view.getId() == R.id.big_image_ad_brand) {
                        a.this.gRh.bFO();
                    } else {
                        a.this.gRh.bFN();
                    }
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.gRe));
                    int i = a.this.gRe.bDR;
                    if (i == 0 || i == 3) {
                        if (!j.jS() || j.jT()) {
                            String str = a.this.gRe.bDT;
                            if (StringUtils.isNull(str)) {
                                str = a.this.mContext.getString(R.string.app_name);
                            }
                            a.this.gRh.bFQ();
                            if (s.a(a.this.mContext.getPageActivity(), a.this.gRe, 0, str)) {
                                a.this.gRh.yX(a.this.gRe.bDW);
                                return;
                            }
                            return;
                        }
                        a.this.c(a.this.gRe);
                    } else if (i == 1) {
                        s.f(a.this.gRe);
                        a.this.gRe.bDR = 3;
                        a.this.bFC();
                    } else if (i == 2) {
                        if (com.baidu.tieba.recapp.download.d.ceQ().pL(a.this.gRe.bDW)) {
                            u.aF(a.this.mContext.getPageActivity(), a.this.gRe.bDW);
                            return;
                        }
                        a.this.gRe.bDR = 0;
                        a.this.bFC();
                    }
                }
            }
        }
    };
    private final View.OnClickListener gRk = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.gRe != null) {
                if (a.this.gRg == null || !a.this.gRg.gRt || a.this.gRg.bFI() != view) {
                    if (view.getId() == R.id.big_image_ad_title || view.getId() == R.id.big_image_ad_brand) {
                        a.this.gRh.bFO();
                    } else {
                        a.this.gRh.bFN();
                    }
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.gRe));
                    r.ceJ().ceG().a(a.this.mContext.getPageActivity(), new String[]{a.this.gRe.bDU}, true);
                }
            }
        }
    };
    private final CustomMessageListener gRl = new CustomMessageListener(0) { // from class: com.baidu.tieba.image.a.6
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && !customResponsedMessage.hasError()) {
                a.this.f(customResponsedMessage);
            }
        }
    };

    public a(boolean z, boolean z2, TbPageContext<?> tbPageContext, String str, String str2) {
        this.clx = false;
        this.gRf = false;
        this.clx = z;
        this.gRf = z2;
        this.mContext = tbPageContext;
        this.mContext.registerListener(2001118, this.gRl);
        this.gRh = new c(tbPageContext.getPageActivity(), str, str2);
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.gRe = advertAppInfo;
        this.gRd = i;
        this.gRh.d(this.gRe);
    }

    public boolean bFB() {
        if (!this.gRf || this.gRe == null) {
            return false;
        }
        return (this.gRe.abG() || this.gRe.abF()) && !u.isInstalledPackage(this.mContext.getPageActivity(), this.gRe.bDW);
    }

    public String getAdId() {
        if (this.gRe != null) {
            return this.gRe.bDS;
        }
        return null;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View h(ViewGroup viewGroup, int i) {
        if (vG(i)) {
            this.gRg = new b(viewGroup);
            this.gRg.setDragToExitListener(this.cnn);
            bFC();
            viewGroup.addView(this.gRg.getView());
            return this.gRg.getView();
        }
        return null;
    }

    private boolean vG(int i) {
        return bFB() && this.gRd != 0 && i == this.gRd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFC() {
        if (this.gRe != null && this.gRe.bEc != null) {
            bFD();
            if (this.gRe.abG()) {
                this.gRg.bFJ().setVisibility(8);
                this.gRg.y(this.gRk);
            } else if (this.gRe.abF()) {
                this.gRg.bFJ().setVisibility(0);
                this.gRg.y(this.gRj);
                bFE();
            }
            if (!TextUtils.isEmpty(this.gRe.bEc.adSource)) {
                this.gRg.gRs.setText(this.gRe.bEc.adSource);
                this.gRg.gRp.setVisibility(0);
            } else {
                this.gRg.gRp.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.gRe.bEc.userName)) {
                if (!TextUtils.isEmpty(this.gRe.bEc.tagName)) {
                    this.gRg.gRr.setText(this.mContext.getResources().getString(R.string.big_image_ad_brand_and_tag, this.gRe.bEc.userName, this.gRe.bEc.tagName));
                } else {
                    this.gRg.gRr.setText(this.mContext.getResources().getString(R.string.big_image_ad_brand_and_tag, this.gRe.bEc.userName, this.mContext.getString(R.string.advert_label)));
                }
            }
            if (!TextUtils.isEmpty(this.gRe.bEc.bEl)) {
                this.gRg.gRq.setText(this.gRe.bEc.bEl);
            }
        }
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.cnn = dVar;
    }

    private void bFD() {
        this.gRg.bFI().setEvent(new TbImageView.a() { // from class: com.baidu.tieba.image.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void O(String str, boolean z) {
                if (z) {
                    a.this.gRg.bFM();
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.gRg.bFI().startLoad(this.gRe.bEc.bEn, this.clx ? 30 : 31, 720, 720, false);
        if (this.gRg.bFH() != null) {
            this.gRg.bFH().setIsCdn(this.clx);
            this.gRg.bFH().setUrl(this.gRe.bEc.bEn, true);
        }
    }

    private void bFE() {
        if (this.gRe != null) {
            String str = this.gRe.bDT;
            if (StringUtils.isNull(str)) {
                str = this.mContext.getString(R.string.app_name);
            }
            if (com.baidu.tieba.recapp.download.d.ceQ().pL(this.gRe.bDW)) {
                this.gRe.bDR = 2;
            } else if (com.baidu.tieba.recapp.download.d.ceQ().dX(this.gRe.bDW, str)) {
                if (com.baidu.tieba.recapp.download.d.ceQ().pJ(this.gRe.bDW)) {
                    this.gRe.bDR = 1;
                } else {
                    this.gRe.bDR = 3;
                }
            }
            switch (this.gRe.bDR) {
                case 0:
                    String string = this.mContext.getString(R.string.install_app);
                    if (this.gRe.bEc != null && !StringUtils.isNull(this.gRe.bEc.buttonText)) {
                        string = this.gRe.bEc.buttonText;
                    }
                    if (string.length() > gRc) {
                        string = string.substring(0, gRc);
                    }
                    this.gRg.yW(string);
                    return;
                case 1:
                    this.gRg.bFK();
                    return;
                case 2:
                    this.gRg.bFL();
                    return;
                case 3:
                    this.gRg.yW(this.mContext.getString(R.string.pb_download_pause));
                    return;
                default:
                    this.gRg.bFJ().setVisibility(8);
                    this.gRg.y(null);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(AdvertAppInfo advertAppInfo) {
        String string;
        if (advertAppInfo != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            if (j.jU()) {
                string = this.mContext.getString(R.string.frs_network_tips);
            } else {
                string = this.mContext.getString(R.string.confirm_download_app);
            }
            aVar.mE(string);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.image.a.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    String str = a.this.gRe.bDT;
                    if (StringUtils.isNull(str)) {
                        str = a.this.mContext.getString(R.string.app_name);
                    }
                    a.this.gRh.bFQ();
                    if (s.a(a.this.mContext.getPageActivity(), a.this.gRe, 0, str)) {
                        a.this.gRh.yX(a.this.gRe.bDW);
                    }
                    aVar2.dismiss();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.image.a.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.mContext).afG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        if ((responsedMessage instanceof DownloadMessage) && this.gRe != null && (data = ((DownloadMessage) responsedMessage).getData()) != null && data.size() != 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null && TextUtils.equals(this.gRe.bDW, downloadData.getId())) {
                    int status = downloadData.getStatus();
                    if (status == 3 || status == 0) {
                        this.gRe.bDR = 2;
                    } else if (status == 2 || status == 4) {
                        if (!ap.isEmpty(downloadData.getStatusMsg())) {
                            this.mContext.showToast(downloadData.getStatusMsg());
                        }
                        this.gRe.bDR = 0;
                    } else if (status == 1) {
                        this.gRe.bDR = 1;
                    }
                    bFC();
                }
            }
        }
    }

    public void bFF() {
        if (!this.gRi) {
            this.gRi = true;
            this.gRh.bFP();
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(this.gRe));
        }
    }
}
