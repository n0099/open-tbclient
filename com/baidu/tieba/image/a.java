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
    private static int gRf = 7;
    private boolean clx;
    private DragImageView.d cnn;
    private AdvertAppInfo gRh;
    private boolean gRi;
    private b gRj;
    private c gRk;
    private TbPageContext<?> mContext;
    private int gRg = 0;
    private boolean gRl = false;
    private final View.OnClickListener gRm = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.gRh != null) {
                if (a.this.gRj == null || !a.this.gRj.gRw || a.this.gRj.bFL() != view) {
                    if (!u.aq((Activity) view.getContext())) {
                        l.showToast((Activity) view.getContext(), (int) R.string.write_external_storage_permission_denied_fun_disable);
                        return;
                    }
                    if (view.getId() == R.id.big_image_ad_title || view.getId() == R.id.big_image_ad_brand) {
                        a.this.gRk.bFR();
                    } else {
                        a.this.gRk.bFQ();
                    }
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.gRh));
                    int i = a.this.gRh.bDR;
                    if (i == 0 || i == 3) {
                        if (!j.jS() || j.jT()) {
                            String str = a.this.gRh.bDT;
                            if (StringUtils.isNull(str)) {
                                str = a.this.mContext.getString(R.string.app_name);
                            }
                            a.this.gRk.bFT();
                            if (s.a(a.this.mContext.getPageActivity(), a.this.gRh, 0, str)) {
                                a.this.gRk.yX(a.this.gRh.bDW);
                                return;
                            }
                            return;
                        }
                        a.this.c(a.this.gRh);
                    } else if (i == 1) {
                        s.f(a.this.gRh);
                        a.this.gRh.bDR = 3;
                        a.this.bFF();
                    } else if (i == 2) {
                        if (com.baidu.tieba.recapp.download.d.ceS().pL(a.this.gRh.bDW)) {
                            u.aF(a.this.mContext.getPageActivity(), a.this.gRh.bDW);
                            return;
                        }
                        a.this.gRh.bDR = 0;
                        a.this.bFF();
                    }
                }
            }
        }
    };
    private final View.OnClickListener gRn = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.gRh != null) {
                if (a.this.gRj == null || !a.this.gRj.gRw || a.this.gRj.bFL() != view) {
                    if (view.getId() == R.id.big_image_ad_title || view.getId() == R.id.big_image_ad_brand) {
                        a.this.gRk.bFR();
                    } else {
                        a.this.gRk.bFQ();
                    }
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.gRh));
                    r.ceL().ceI().a(a.this.mContext.getPageActivity(), new String[]{a.this.gRh.bDU}, true);
                }
            }
        }
    };
    private final CustomMessageListener gRo = new CustomMessageListener(0) { // from class: com.baidu.tieba.image.a.6
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
        this.gRi = false;
        this.clx = z;
        this.gRi = z2;
        this.mContext = tbPageContext;
        this.mContext.registerListener(2001118, this.gRo);
        this.gRk = new c(tbPageContext.getPageActivity(), str, str2);
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.gRh = advertAppInfo;
        this.gRg = i;
        this.gRk.d(this.gRh);
    }

    public boolean bFE() {
        if (!this.gRi || this.gRh == null) {
            return false;
        }
        return (this.gRh.abG() || this.gRh.abF()) && !u.isInstalledPackage(this.mContext.getPageActivity(), this.gRh.bDW);
    }

    public String getAdId() {
        if (this.gRh != null) {
            return this.gRh.bDS;
        }
        return null;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View h(ViewGroup viewGroup, int i) {
        if (vG(i)) {
            this.gRj = new b(viewGroup);
            this.gRj.setDragToExitListener(this.cnn);
            bFF();
            viewGroup.addView(this.gRj.getView());
            return this.gRj.getView();
        }
        return null;
    }

    private boolean vG(int i) {
        return bFE() && this.gRg != 0 && i == this.gRg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFF() {
        if (this.gRh != null && this.gRh.bEc != null) {
            bFG();
            if (this.gRh.abG()) {
                this.gRj.bFM().setVisibility(8);
                this.gRj.y(this.gRn);
            } else if (this.gRh.abF()) {
                this.gRj.bFM().setVisibility(0);
                this.gRj.y(this.gRm);
                bFH();
            }
            if (!TextUtils.isEmpty(this.gRh.bEc.adSource)) {
                this.gRj.gRv.setText(this.gRh.bEc.adSource);
                this.gRj.gRs.setVisibility(0);
            } else {
                this.gRj.gRs.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.gRh.bEc.userName)) {
                if (!TextUtils.isEmpty(this.gRh.bEc.tagName)) {
                    this.gRj.gRu.setText(this.mContext.getResources().getString(R.string.big_image_ad_brand_and_tag, this.gRh.bEc.userName, this.gRh.bEc.tagName));
                } else {
                    this.gRj.gRu.setText(this.mContext.getResources().getString(R.string.big_image_ad_brand_and_tag, this.gRh.bEc.userName, this.mContext.getString(R.string.advert_label)));
                }
            }
            if (!TextUtils.isEmpty(this.gRh.bEc.bEl)) {
                this.gRj.gRt.setText(this.gRh.bEc.bEl);
            }
        }
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.cnn = dVar;
    }

    private void bFG() {
        this.gRj.bFL().setEvent(new TbImageView.a() { // from class: com.baidu.tieba.image.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void O(String str, boolean z) {
                if (z) {
                    a.this.gRj.bFP();
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.gRj.bFL().startLoad(this.gRh.bEc.bEn, this.clx ? 30 : 31, 720, 720, false);
        if (this.gRj.bFK() != null) {
            this.gRj.bFK().setIsCdn(this.clx);
            this.gRj.bFK().setUrl(this.gRh.bEc.bEn, true);
        }
    }

    private void bFH() {
        if (this.gRh != null) {
            String str = this.gRh.bDT;
            if (StringUtils.isNull(str)) {
                str = this.mContext.getString(R.string.app_name);
            }
            if (com.baidu.tieba.recapp.download.d.ceS().pL(this.gRh.bDW)) {
                this.gRh.bDR = 2;
            } else if (com.baidu.tieba.recapp.download.d.ceS().dX(this.gRh.bDW, str)) {
                if (com.baidu.tieba.recapp.download.d.ceS().pJ(this.gRh.bDW)) {
                    this.gRh.bDR = 1;
                } else {
                    this.gRh.bDR = 3;
                }
            }
            switch (this.gRh.bDR) {
                case 0:
                    String string = this.mContext.getString(R.string.install_app);
                    if (this.gRh.bEc != null && !StringUtils.isNull(this.gRh.bEc.buttonText)) {
                        string = this.gRh.bEc.buttonText;
                    }
                    if (string.length() > gRf) {
                        string = string.substring(0, gRf);
                    }
                    this.gRj.yW(string);
                    return;
                case 1:
                    this.gRj.bFN();
                    return;
                case 2:
                    this.gRj.bFO();
                    return;
                case 3:
                    this.gRj.yW(this.mContext.getString(R.string.pb_download_pause));
                    return;
                default:
                    this.gRj.bFM().setVisibility(8);
                    this.gRj.y(null);
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
                    String str = a.this.gRh.bDT;
                    if (StringUtils.isNull(str)) {
                        str = a.this.mContext.getString(R.string.app_name);
                    }
                    a.this.gRk.bFT();
                    if (s.a(a.this.mContext.getPageActivity(), a.this.gRh, 0, str)) {
                        a.this.gRk.yX(a.this.gRh.bDW);
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
        if ((responsedMessage instanceof DownloadMessage) && this.gRh != null && (data = ((DownloadMessage) responsedMessage).getData()) != null && data.size() != 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null && TextUtils.equals(this.gRh.bDW, downloadData.getId())) {
                    int status = downloadData.getStatus();
                    if (status == 3 || status == 0) {
                        this.gRh.bDR = 2;
                    } else if (status == 2 || status == 4) {
                        if (!ap.isEmpty(downloadData.getStatusMsg())) {
                            this.mContext.showToast(downloadData.getStatusMsg());
                        }
                        this.gRh.bDR = 0;
                    } else if (status == 1) {
                        this.gRh.bDR = 1;
                    }
                    bFF();
                }
            }
        }
    }

    public void bFI() {
        if (!this.gRl) {
            this.gRl = true;
            this.gRk.bFS();
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(this.gRh));
        }
    }
}
