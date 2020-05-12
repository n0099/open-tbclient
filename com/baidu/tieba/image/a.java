package com.baidu.tieba.image;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.q;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.x;
import java.util.List;
/* loaded from: classes8.dex */
public class a implements ImagePagerAdapter.a {
    private static int iCC = 7;
    private boolean dSw;
    private DragImageView.d dUg;
    private TbPageContext<?> duK;
    private AdvertAppInfo iCE;
    private boolean iCF;
    private b iCG;
    private c iCH;
    private int iCD = 0;
    private boolean iCI = false;
    private final View.OnClickListener iCJ = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.iCE != null) {
                if (a.this.iCG == null || !a.this.iCG.iCT || a.this.iCG.ckV() != view) {
                    if (!x.aq((Activity) view.getContext())) {
                        l.showToast((Activity) view.getContext(), (int) R.string.write_external_storage_permission_denied_fun_disable);
                        return;
                    }
                    if (view.getId() == R.id.big_image_ad_title || view.getId() == R.id.big_image_ad_brand) {
                        a.this.iCH.clb();
                    } else {
                        a.this.iCH.cla();
                    }
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.iCE));
                    int i = a.this.iCE.dmr;
                    if (i == 0 || i == 3) {
                        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() || com.baidu.adp.lib.util.j.isWifiNet()) {
                            String str = a.this.iCE.dmt;
                            if (StringUtils.isNull(str)) {
                                str = a.this.duK.getString(R.string.app_name);
                            }
                            a.this.iCH.cld();
                            if (r.a(a.this.duK.getPageActivity(), a.this.iCE, 0, str)) {
                                a.this.iCH.Fx(a.this.iCE.dmv);
                                return;
                            }
                            return;
                        }
                        a.this.c(a.this.iCE);
                    } else if (i == 1) {
                        r.f(a.this.iCE);
                        a.this.iCE.dmr = 3;
                        a.this.ckP();
                    } else if (i == 2) {
                        if (com.baidu.tieba.recapp.download.e.cNs().wp(a.this.iCE.dmv)) {
                            x.aM(a.this.duK.getPageActivity(), a.this.iCE.dmv);
                            return;
                        }
                        a.this.iCE.dmr = 0;
                        a.this.ckP();
                    }
                }
            }
        }
    };
    private final View.OnClickListener iCK = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.iCE != null) {
                if (a.this.iCG == null || !a.this.iCG.iCT || a.this.iCG.ckV() != view) {
                    if (view.getId() == R.id.big_image_ad_title || view.getId() == R.id.big_image_ad_brand) {
                        a.this.iCH.clb();
                    } else {
                        a.this.iCH.cla();
                    }
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.iCE));
                    q.cNm().cNj().a(a.this.duK.getPageActivity(), new String[]{a.this.iCE.dmu}, true);
                }
            }
        }
    };
    private final CustomMessageListener iCL = new CustomMessageListener(0) { // from class: com.baidu.tieba.image.a.6
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
        this.dSw = false;
        this.iCF = false;
        this.dSw = z;
        this.iCF = z2;
        this.duK = tbPageContext;
        this.duK.registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.iCL);
        this.iCH = new c(tbPageContext.getPageActivity(), str, str2);
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.iCE = advertAppInfo;
        this.iCD = i;
        this.iCH.d(this.iCE);
    }

    public boolean ckO() {
        if (!this.iCF || this.iCE == null) {
            return false;
        }
        return (this.iCE.aIF() || this.iCE.aIE()) && !x.isInstalledPackage(this.duK.getPageActivity(), this.iCE.dmv);
    }

    public String getAdId() {
        if (this.iCE != null) {
            return this.iCE.dms;
        }
        return null;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View k(ViewGroup viewGroup, int i) {
        if (xN(i)) {
            this.iCG = new b(viewGroup);
            this.iCG.setDragToExitListener(this.dUg);
            ckP();
            viewGroup.addView(this.iCG.getView());
            return this.iCG.getView();
        }
        return null;
    }

    private boolean xN(int i) {
        return ckO() && this.iCD != 0 && i == this.iCD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckP() {
        if (this.iCE != null && this.iCE.dmB != null) {
            ckQ();
            if (this.iCE.aIF()) {
                this.iCG.ckW().setVisibility(8);
                this.iCG.D(this.iCK);
            } else if (this.iCE.aIE()) {
                this.iCG.ckW().setVisibility(0);
                this.iCG.D(this.iCJ);
                ckR();
            }
            if (!TextUtils.isEmpty(this.iCE.dmB.adSource)) {
                this.iCG.iCS.setText(this.iCE.dmB.adSource);
                this.iCG.iCP.setVisibility(0);
            } else {
                this.iCG.iCP.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.iCE.dmB.userName)) {
                if (!TextUtils.isEmpty(this.iCE.dmB.tagName)) {
                    this.iCG.iCR.setText(this.duK.getResources().getString(R.string.big_image_ad_brand_and_tag, this.iCE.dmB.userName, this.iCE.dmB.tagName));
                } else {
                    this.iCG.iCR.setText(this.duK.getResources().getString(R.string.big_image_ad_brand_and_tag, this.iCE.dmB.userName, this.duK.getString(R.string.advert_label)));
                }
            }
            if (!TextUtils.isEmpty(this.iCE.dmB.dmK)) {
                this.iCG.iCQ.setText(this.iCE.dmB.dmK);
            }
        }
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.dUg = dVar;
    }

    private void ckQ() {
        this.iCG.ckV().setEvent(new TbImageView.a() { // from class: com.baidu.tieba.image.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z) {
                    a.this.iCG.ckZ();
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.iCG.ckV().a(this.iCE.dmB.dmM, this.dSw ? 30 : 31, 720, 720, false);
        if (this.iCG.ckU() != null) {
            this.iCG.ckU().setIsCdn(this.dSw);
            this.iCG.ckU().setUrl(this.iCE.dmB.dmM, true);
        }
    }

    private void ckR() {
        if (this.iCE != null) {
            String str = this.iCE.dmt;
            if (StringUtils.isNull(str)) {
                str = this.duK.getString(R.string.app_name);
            }
            if (com.baidu.tieba.recapp.download.e.cNs().wp(this.iCE.dmv)) {
                this.iCE.dmr = 2;
            } else if (com.baidu.tieba.recapp.download.e.cNs().eC(this.iCE.dmv, str)) {
                if (com.baidu.tieba.recapp.download.e.cNs().wn(this.iCE.dmv)) {
                    this.iCE.dmr = 1;
                } else {
                    this.iCE.dmr = 3;
                }
            }
            switch (this.iCE.dmr) {
                case 0:
                    String string = this.duK.getString(R.string.install_app);
                    if (this.iCE.dmB != null && !StringUtils.isNull(this.iCE.dmB.buttonText)) {
                        string = this.iCE.dmB.buttonText;
                    }
                    if (string.length() > iCC) {
                        string = string.substring(0, iCC);
                    }
                    this.iCG.Fw(string);
                    return;
                case 1:
                    this.iCG.ckX();
                    return;
                case 2:
                    this.iCG.ckY();
                    return;
                case 3:
                    this.iCG.Fw(this.duK.getString(R.string.pb_download_pause));
                    return;
                default:
                    this.iCG.ckW().setVisibility(8);
                    this.iCG.D(null);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(AdvertAppInfo advertAppInfo) {
        String string;
        if (advertAppInfo != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.duK.getPageActivity());
            if (com.baidu.adp.lib.util.j.isMobileNet()) {
                string = this.duK.getString(R.string.frs_network_tips);
            } else {
                string = this.duK.getString(R.string.confirm_download_app);
            }
            aVar.ui(string);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.image.a.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    String str = a.this.iCE.dmt;
                    if (StringUtils.isNull(str)) {
                        str = a.this.duK.getString(R.string.app_name);
                    }
                    a.this.iCH.cld();
                    if (r.a(a.this.duK.getPageActivity(), a.this.iCE, 0, str)) {
                        a.this.iCH.Fx(a.this.iCE.dmv);
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
            aVar.b(this.duK).aMS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        if ((responsedMessage instanceof DownloadMessage) && this.iCE != null && (data = ((DownloadMessage) responsedMessage).getData()) != null && data.size() != 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null && TextUtils.equals(this.iCE.dmv, downloadData.getId())) {
                    int status = downloadData.getStatus();
                    if (status == 3 || status == 0) {
                        this.iCE.dmr = 2;
                    } else if (status == 2 || status == 4) {
                        if (!aq.isEmpty(downloadData.getStatusMsg())) {
                            this.duK.showToast(downloadData.getStatusMsg());
                        }
                        this.iCE.dmr = 0;
                    } else if (status == 1) {
                        this.iCE.dmr = 1;
                    }
                    ckP();
                }
            }
        }
    }

    public void ckS() {
        if (!this.iCI) {
            this.iCI = true;
            this.iCH.clc();
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(this.iCE));
        }
    }
}
