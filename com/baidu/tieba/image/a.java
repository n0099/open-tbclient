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
    private static int iCw = 7;
    private boolean dSr;
    private DragImageView.d dUb;
    private TbPageContext<?> duG;
    private b iCA;
    private c iCB;
    private AdvertAppInfo iCy;
    private boolean iCz;
    private int iCx = 0;
    private boolean iCC = false;
    private final View.OnClickListener iCD = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.iCy != null) {
                if (a.this.iCA == null || !a.this.iCA.iCN || a.this.iCA.ckW() != view) {
                    if (!x.aq((Activity) view.getContext())) {
                        l.showToast((Activity) view.getContext(), (int) R.string.write_external_storage_permission_denied_fun_disable);
                        return;
                    }
                    if (view.getId() == R.id.big_image_ad_title || view.getId() == R.id.big_image_ad_brand) {
                        a.this.iCB.clc();
                    } else {
                        a.this.iCB.clb();
                    }
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.iCy));
                    int i = a.this.iCy.dmn;
                    if (i == 0 || i == 3) {
                        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() || com.baidu.adp.lib.util.j.isWifiNet()) {
                            String str = a.this.iCy.dmp;
                            if (StringUtils.isNull(str)) {
                                str = a.this.duG.getString(R.string.app_name);
                            }
                            a.this.iCB.cle();
                            if (r.a(a.this.duG.getPageActivity(), a.this.iCy, 0, str)) {
                                a.this.iCB.Fu(a.this.iCy.dmr);
                                return;
                            }
                            return;
                        }
                        a.this.c(a.this.iCy);
                    } else if (i == 1) {
                        r.f(a.this.iCy);
                        a.this.iCy.dmn = 3;
                        a.this.ckQ();
                    } else if (i == 2) {
                        if (com.baidu.tieba.recapp.download.e.cNu().wm(a.this.iCy.dmr)) {
                            x.aY(a.this.duG.getPageActivity(), a.this.iCy.dmr);
                            return;
                        }
                        a.this.iCy.dmn = 0;
                        a.this.ckQ();
                    }
                }
            }
        }
    };
    private final View.OnClickListener iCE = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.iCy != null) {
                if (a.this.iCA == null || !a.this.iCA.iCN || a.this.iCA.ckW() != view) {
                    if (view.getId() == R.id.big_image_ad_title || view.getId() == R.id.big_image_ad_brand) {
                        a.this.iCB.clc();
                    } else {
                        a.this.iCB.clb();
                    }
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.iCy));
                    q.cNo().cNl().a(a.this.duG.getPageActivity(), new String[]{a.this.iCy.dmq}, true);
                }
            }
        }
    };
    private final CustomMessageListener iCF = new CustomMessageListener(0) { // from class: com.baidu.tieba.image.a.6
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
        this.dSr = false;
        this.iCz = false;
        this.dSr = z;
        this.iCz = z2;
        this.duG = tbPageContext;
        this.duG.registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.iCF);
        this.iCB = new c(tbPageContext.getPageActivity(), str, str2);
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.iCy = advertAppInfo;
        this.iCx = i;
        this.iCB.d(this.iCy);
    }

    public boolean ckP() {
        if (!this.iCz || this.iCy == null) {
            return false;
        }
        return (this.iCy.aIH() || this.iCy.aIG()) && !x.isInstalledPackage(this.duG.getPageActivity(), this.iCy.dmr);
    }

    public String getAdId() {
        if (this.iCy != null) {
            return this.iCy.dmo;
        }
        return null;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View k(ViewGroup viewGroup, int i) {
        if (xN(i)) {
            this.iCA = new b(viewGroup);
            this.iCA.setDragToExitListener(this.dUb);
            ckQ();
            viewGroup.addView(this.iCA.getView());
            return this.iCA.getView();
        }
        return null;
    }

    private boolean xN(int i) {
        return ckP() && this.iCx != 0 && i == this.iCx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckQ() {
        if (this.iCy != null && this.iCy.dmx != null) {
            ckR();
            if (this.iCy.aIH()) {
                this.iCA.ckX().setVisibility(8);
                this.iCA.D(this.iCE);
            } else if (this.iCy.aIG()) {
                this.iCA.ckX().setVisibility(0);
                this.iCA.D(this.iCD);
                ckS();
            }
            if (!TextUtils.isEmpty(this.iCy.dmx.adSource)) {
                this.iCA.iCM.setText(this.iCy.dmx.adSource);
                this.iCA.iCJ.setVisibility(0);
            } else {
                this.iCA.iCJ.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.iCy.dmx.userName)) {
                if (!TextUtils.isEmpty(this.iCy.dmx.tagName)) {
                    this.iCA.iCL.setText(this.duG.getResources().getString(R.string.big_image_ad_brand_and_tag, this.iCy.dmx.userName, this.iCy.dmx.tagName));
                } else {
                    this.iCA.iCL.setText(this.duG.getResources().getString(R.string.big_image_ad_brand_and_tag, this.iCy.dmx.userName, this.duG.getString(R.string.advert_label)));
                }
            }
            if (!TextUtils.isEmpty(this.iCy.dmx.dmG)) {
                this.iCA.iCK.setText(this.iCy.dmx.dmG);
            }
        }
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.dUb = dVar;
    }

    private void ckR() {
        this.iCA.ckW().setEvent(new TbImageView.a() { // from class: com.baidu.tieba.image.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z) {
                    a.this.iCA.cla();
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.iCA.ckW().a(this.iCy.dmx.dmI, this.dSr ? 30 : 31, 720, 720, false);
        if (this.iCA.ckV() != null) {
            this.iCA.ckV().setIsCdn(this.dSr);
            this.iCA.ckV().setUrl(this.iCy.dmx.dmI, true);
        }
    }

    private void ckS() {
        if (this.iCy != null) {
            String str = this.iCy.dmp;
            if (StringUtils.isNull(str)) {
                str = this.duG.getString(R.string.app_name);
            }
            if (com.baidu.tieba.recapp.download.e.cNu().wm(this.iCy.dmr)) {
                this.iCy.dmn = 2;
            } else if (com.baidu.tieba.recapp.download.e.cNu().eC(this.iCy.dmr, str)) {
                if (com.baidu.tieba.recapp.download.e.cNu().wk(this.iCy.dmr)) {
                    this.iCy.dmn = 1;
                } else {
                    this.iCy.dmn = 3;
                }
            }
            switch (this.iCy.dmn) {
                case 0:
                    String string = this.duG.getString(R.string.install_app);
                    if (this.iCy.dmx != null && !StringUtils.isNull(this.iCy.dmx.buttonText)) {
                        string = this.iCy.dmx.buttonText;
                    }
                    if (string.length() > iCw) {
                        string = string.substring(0, iCw);
                    }
                    this.iCA.Ft(string);
                    return;
                case 1:
                    this.iCA.ckY();
                    return;
                case 2:
                    this.iCA.ckZ();
                    return;
                case 3:
                    this.iCA.Ft(this.duG.getString(R.string.pb_download_pause));
                    return;
                default:
                    this.iCA.ckX().setVisibility(8);
                    this.iCA.D(null);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(AdvertAppInfo advertAppInfo) {
        String string;
        if (advertAppInfo != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.duG.getPageActivity());
            if (com.baidu.adp.lib.util.j.isMobileNet()) {
                string = this.duG.getString(R.string.frs_network_tips);
            } else {
                string = this.duG.getString(R.string.confirm_download_app);
            }
            aVar.uf(string);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.image.a.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    String str = a.this.iCy.dmp;
                    if (StringUtils.isNull(str)) {
                        str = a.this.duG.getString(R.string.app_name);
                    }
                    a.this.iCB.cle();
                    if (r.a(a.this.duG.getPageActivity(), a.this.iCy, 0, str)) {
                        a.this.iCB.Fu(a.this.iCy.dmr);
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
            aVar.b(this.duG).aMU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        if ((responsedMessage instanceof DownloadMessage) && this.iCy != null && (data = ((DownloadMessage) responsedMessage).getData()) != null && data.size() != 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null && TextUtils.equals(this.iCy.dmr, downloadData.getId())) {
                    int status = downloadData.getStatus();
                    if (status == 3 || status == 0) {
                        this.iCy.dmn = 2;
                    } else if (status == 2 || status == 4) {
                        if (!aq.isEmpty(downloadData.getStatusMsg())) {
                            this.duG.showToast(downloadData.getStatusMsg());
                        }
                        this.iCy.dmn = 0;
                    } else if (status == 1) {
                        this.iCy.dmn = 1;
                    }
                    ckQ();
                }
            }
        }
    }

    public void ckT() {
        if (!this.iCC) {
            this.iCC = true;
            this.iCB.cld();
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(this.iCy));
        }
    }
}
