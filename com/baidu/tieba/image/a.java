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
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.tbadkCore.w;
import java.util.List;
/* loaded from: classes8.dex */
public class a implements ImagePagerAdapter.a {
    private static int hQR = 7;
    private TbPageContext<?> cVg;
    private boolean drU;
    private DragImageView.d dtF;
    private AdvertAppInfo hQT;
    private boolean hQU;
    private b hQV;
    private c hQW;
    private int hQS = 0;
    private boolean hQX = false;
    private final View.OnClickListener hQY = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.hQT != null) {
                if (a.this.hQV == null || !a.this.hQV.hRi || a.this.hQV.bZZ() != view) {
                    if (!w.as((Activity) view.getContext())) {
                        l.showToast((Activity) view.getContext(), (int) R.string.write_external_storage_permission_denied_fun_disable);
                        return;
                    }
                    if (view.getId() == R.id.big_image_ad_title || view.getId() == R.id.big_image_ad_brand) {
                        a.this.hQW.caf();
                    } else {
                        a.this.hQW.cae();
                    }
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.hQT));
                    int i = a.this.hQT.cMU;
                    if (i == 0 || i == 3) {
                        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() || com.baidu.adp.lib.util.j.isWifiNet()) {
                            String str = a.this.hQT.cMW;
                            if (StringUtils.isNull(str)) {
                                str = a.this.cVg.getString(R.string.app_name);
                            }
                            a.this.hQW.cah();
                            if (s.a(a.this.cVg.getPageActivity(), a.this.hQT, 0, str)) {
                                a.this.hQW.DL(a.this.hQT.cMY);
                                return;
                            }
                            return;
                        }
                        a.this.c(a.this.hQT);
                    } else if (i == 1) {
                        s.f(a.this.hQT);
                        a.this.hQT.cMU = 3;
                        a.this.bZT();
                    } else if (i == 2) {
                        if (com.baidu.tieba.recapp.download.e.cCz().uY(a.this.hQT.cMY)) {
                            w.bd(a.this.cVg.getPageActivity(), a.this.hQT.cMY);
                            return;
                        }
                        a.this.hQT.cMU = 0;
                        a.this.bZT();
                    }
                }
            }
        }
    };
    private final View.OnClickListener hQZ = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.hQT != null) {
                if (a.this.hQV == null || !a.this.hQV.hRi || a.this.hQV.bZZ() != view) {
                    if (view.getId() == R.id.big_image_ad_title || view.getId() == R.id.big_image_ad_brand) {
                        a.this.hQW.caf();
                    } else {
                        a.this.hQW.cae();
                    }
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.hQT));
                    r.cCt().cCq().a(a.this.cVg.getPageActivity(), new String[]{a.this.hQT.cMX}, true);
                }
            }
        }
    };
    private final CustomMessageListener hRa = new CustomMessageListener(0) { // from class: com.baidu.tieba.image.a.6
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
        this.drU = false;
        this.hQU = false;
        this.drU = z;
        this.hQU = z2;
        this.cVg = tbPageContext;
        this.cVg.registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.hRa);
        this.hQW = new c(tbPageContext.getPageActivity(), str, str2);
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.hQT = advertAppInfo;
        this.hQS = i;
        this.hQW.d(this.hQT);
    }

    public boolean bZS() {
        if (!this.hQU || this.hQT == null) {
            return false;
        }
        return (this.hQT.aAp() || this.hQT.aAo()) && !w.isInstalledPackage(this.cVg.getPageActivity(), this.hQT.cMY);
    }

    public String getAdId() {
        if (this.hQT != null) {
            return this.hQT.cMV;
        }
        return null;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View k(ViewGroup viewGroup, int i) {
        if (xf(i)) {
            this.hQV = new b(viewGroup);
            this.hQV.setDragToExitListener(this.dtF);
            bZT();
            viewGroup.addView(this.hQV.getView());
            return this.hQV.getView();
        }
        return null;
    }

    private boolean xf(int i) {
        return bZS() && this.hQS != 0 && i == this.hQS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZT() {
        if (this.hQT != null && this.hQT.cNe != null) {
            bZU();
            if (this.hQT.aAp()) {
                this.hQV.caa().setVisibility(8);
                this.hQV.C(this.hQZ);
            } else if (this.hQT.aAo()) {
                this.hQV.caa().setVisibility(0);
                this.hQV.C(this.hQY);
                bZV();
            }
            if (!TextUtils.isEmpty(this.hQT.cNe.adSource)) {
                this.hQV.hRh.setText(this.hQT.cNe.adSource);
                this.hQV.hRe.setVisibility(0);
            } else {
                this.hQV.hRe.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.hQT.cNe.userName)) {
                if (!TextUtils.isEmpty(this.hQT.cNe.tagName)) {
                    this.hQV.hRg.setText(this.cVg.getResources().getString(R.string.big_image_ad_brand_and_tag, this.hQT.cNe.userName, this.hQT.cNe.tagName));
                } else {
                    this.hQV.hRg.setText(this.cVg.getResources().getString(R.string.big_image_ad_brand_and_tag, this.hQT.cNe.userName, this.cVg.getString(R.string.advert_label)));
                }
            }
            if (!TextUtils.isEmpty(this.hQT.cNe.cNn)) {
                this.hQV.hRf.setText(this.hQT.cNe.cNn);
            }
        }
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.dtF = dVar;
    }

    private void bZU() {
        this.hQV.bZZ().setEvent(new TbImageView.a() { // from class: com.baidu.tieba.image.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z) {
                    a.this.hQV.cad();
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.hQV.bZZ().a(this.hQT.cNe.cNp, this.drU ? 30 : 31, 720, 720, false);
        if (this.hQV.bZY() != null) {
            this.hQV.bZY().setIsCdn(this.drU);
            this.hQV.bZY().setUrl(this.hQT.cNe.cNp, true);
        }
    }

    private void bZV() {
        if (this.hQT != null) {
            String str = this.hQT.cMW;
            if (StringUtils.isNull(str)) {
                str = this.cVg.getString(R.string.app_name);
            }
            if (com.baidu.tieba.recapp.download.e.cCz().uY(this.hQT.cMY)) {
                this.hQT.cMU = 2;
            } else if (com.baidu.tieba.recapp.download.e.cCz().ep(this.hQT.cMY, str)) {
                if (com.baidu.tieba.recapp.download.e.cCz().uW(this.hQT.cMY)) {
                    this.hQT.cMU = 1;
                } else {
                    this.hQT.cMU = 3;
                }
            }
            switch (this.hQT.cMU) {
                case 0:
                    String string = this.cVg.getString(R.string.install_app);
                    if (this.hQT.cNe != null && !StringUtils.isNull(this.hQT.cNe.buttonText)) {
                        string = this.hQT.cNe.buttonText;
                    }
                    if (string.length() > hQR) {
                        string = string.substring(0, hQR);
                    }
                    this.hQV.DK(string);
                    return;
                case 1:
                    this.hQV.cab();
                    return;
                case 2:
                    this.hQV.cac();
                    return;
                case 3:
                    this.hQV.DK(this.cVg.getString(R.string.pb_download_pause));
                    return;
                default:
                    this.hQV.caa().setVisibility(8);
                    this.hQV.C(null);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(AdvertAppInfo advertAppInfo) {
        String string;
        if (advertAppInfo != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cVg.getPageActivity());
            if (com.baidu.adp.lib.util.j.isMobileNet()) {
                string = this.cVg.getString(R.string.frs_network_tips);
            } else {
                string = this.cVg.getString(R.string.confirm_download_app);
            }
            aVar.sS(string);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.image.a.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    String str = a.this.hQT.cMW;
                    if (StringUtils.isNull(str)) {
                        str = a.this.cVg.getString(R.string.app_name);
                    }
                    a.this.hQW.cah();
                    if (s.a(a.this.cVg.getPageActivity(), a.this.hQT, 0, str)) {
                        a.this.hQW.DL(a.this.hQT.cMY);
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
            aVar.b(this.cVg).aEA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        if ((responsedMessage instanceof DownloadMessage) && this.hQT != null && (data = ((DownloadMessage) responsedMessage).getData()) != null && data.size() != 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null && TextUtils.equals(this.hQT.cMY, downloadData.getId())) {
                    int status = downloadData.getStatus();
                    if (status == 3 || status == 0) {
                        this.hQT.cMU = 2;
                    } else if (status == 2 || status == 4) {
                        if (!aq.isEmpty(downloadData.getStatusMsg())) {
                            this.cVg.showToast(downloadData.getStatusMsg());
                        }
                        this.hQT.cMU = 0;
                    } else if (status == 1) {
                        this.hQT.cMU = 1;
                    }
                    bZT();
                }
            }
        }
    }

    public void bZW() {
        if (!this.hQX) {
            this.hQX = true;
            this.hQW.cag();
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(this.hQT));
        }
    }
}
