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
/* loaded from: classes6.dex */
public class a implements ImagePagerAdapter.a {
    private static int hOT = 7;
    private TbPageContext<?> cRe;
    private boolean dnL;
    private DragImageView.d dpx;
    private AdvertAppInfo hOV;
    private boolean hOW;
    private b hOX;
    private c hOY;
    private int hOU = 0;
    private boolean hOZ = false;
    private final View.OnClickListener hPa = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.hOV != null) {
                if (a.this.hOX == null || !a.this.hOX.hPk || a.this.hOX.bYy() != view) {
                    if (!w.ar((Activity) view.getContext())) {
                        l.showToast((Activity) view.getContext(), (int) R.string.write_external_storage_permission_denied_fun_disable);
                        return;
                    }
                    if (view.getId() == R.id.big_image_ad_title || view.getId() == R.id.big_image_ad_brand) {
                        a.this.hOY.bYE();
                    } else {
                        a.this.hOY.bYD();
                    }
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.hOV));
                    int i = a.this.hOV.cIR;
                    if (i == 0 || i == 3) {
                        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() || com.baidu.adp.lib.util.j.isWifiNet()) {
                            String str = a.this.hOV.cIT;
                            if (StringUtils.isNull(str)) {
                                str = a.this.cRe.getString(R.string.app_name);
                            }
                            a.this.hOY.bYG();
                            if (s.a(a.this.cRe.getPageActivity(), a.this.hOV, 0, str)) {
                                a.this.hOY.Dv(a.this.hOV.cIV);
                                return;
                            }
                            return;
                        }
                        a.this.c(a.this.hOV);
                    } else if (i == 1) {
                        s.f(a.this.hOV);
                        a.this.hOV.cIR = 3;
                        a.this.bYs();
                    } else if (i == 2) {
                        if (com.baidu.tieba.recapp.download.e.cBb().uH(a.this.hOV.cIV)) {
                            w.bd(a.this.cRe.getPageActivity(), a.this.hOV.cIV);
                            return;
                        }
                        a.this.hOV.cIR = 0;
                        a.this.bYs();
                    }
                }
            }
        }
    };
    private final View.OnClickListener hPb = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.hOV != null) {
                if (a.this.hOX == null || !a.this.hOX.hPk || a.this.hOX.bYy() != view) {
                    if (view.getId() == R.id.big_image_ad_title || view.getId() == R.id.big_image_ad_brand) {
                        a.this.hOY.bYE();
                    } else {
                        a.this.hOY.bYD();
                    }
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.hOV));
                    r.cAV().cAS().a(a.this.cRe.getPageActivity(), new String[]{a.this.hOV.cIU}, true);
                }
            }
        }
    };
    private final CustomMessageListener hPc = new CustomMessageListener(0) { // from class: com.baidu.tieba.image.a.6
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
        this.dnL = false;
        this.hOW = false;
        this.dnL = z;
        this.hOW = z2;
        this.cRe = tbPageContext;
        this.cRe.registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.hPc);
        this.hOY = new c(tbPageContext.getPageActivity(), str, str2);
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.hOV = advertAppInfo;
        this.hOU = i;
        this.hOY.d(this.hOV);
    }

    public boolean bYr() {
        if (!this.hOW || this.hOV == null) {
            return false;
        }
        return (this.hOV.ayb() || this.hOV.aya()) && !w.isInstalledPackage(this.cRe.getPageActivity(), this.hOV.cIV);
    }

    public String getAdId() {
        if (this.hOV != null) {
            return this.hOV.cIS;
        }
        return null;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View k(ViewGroup viewGroup, int i) {
        if (wZ(i)) {
            this.hOX = new b(viewGroup);
            this.hOX.setDragToExitListener(this.dpx);
            bYs();
            viewGroup.addView(this.hOX.getView());
            return this.hOX.getView();
        }
        return null;
    }

    private boolean wZ(int i) {
        return bYr() && this.hOU != 0 && i == this.hOU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYs() {
        if (this.hOV != null && this.hOV.cJb != null) {
            bYt();
            if (this.hOV.ayb()) {
                this.hOX.bYz().setVisibility(8);
                this.hOX.B(this.hPb);
            } else if (this.hOV.aya()) {
                this.hOX.bYz().setVisibility(0);
                this.hOX.B(this.hPa);
                bYu();
            }
            if (!TextUtils.isEmpty(this.hOV.cJb.adSource)) {
                this.hOX.hPj.setText(this.hOV.cJb.adSource);
                this.hOX.hPg.setVisibility(0);
            } else {
                this.hOX.hPg.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.hOV.cJb.userName)) {
                if (!TextUtils.isEmpty(this.hOV.cJb.tagName)) {
                    this.hOX.hPi.setText(this.cRe.getResources().getString(R.string.big_image_ad_brand_and_tag, this.hOV.cJb.userName, this.hOV.cJb.tagName));
                } else {
                    this.hOX.hPi.setText(this.cRe.getResources().getString(R.string.big_image_ad_brand_and_tag, this.hOV.cJb.userName, this.cRe.getString(R.string.advert_label)));
                }
            }
            if (!TextUtils.isEmpty(this.hOV.cJb.cJk)) {
                this.hOX.hPh.setText(this.hOV.cJb.cJk);
            }
        }
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.dpx = dVar;
    }

    private void bYt() {
        this.hOX.bYy().setEvent(new TbImageView.a() { // from class: com.baidu.tieba.image.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z) {
                    a.this.hOX.bYC();
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.hOX.bYy().a(this.hOV.cJb.cJm, this.dnL ? 30 : 31, 720, 720, false);
        if (this.hOX.bYx() != null) {
            this.hOX.bYx().setIsCdn(this.dnL);
            this.hOX.bYx().setUrl(this.hOV.cJb.cJm, true);
        }
    }

    private void bYu() {
        if (this.hOV != null) {
            String str = this.hOV.cIT;
            if (StringUtils.isNull(str)) {
                str = this.cRe.getString(R.string.app_name);
            }
            if (com.baidu.tieba.recapp.download.e.cBb().uH(this.hOV.cIV)) {
                this.hOV.cIR = 2;
            } else if (com.baidu.tieba.recapp.download.e.cBb().eg(this.hOV.cIV, str)) {
                if (com.baidu.tieba.recapp.download.e.cBb().uF(this.hOV.cIV)) {
                    this.hOV.cIR = 1;
                } else {
                    this.hOV.cIR = 3;
                }
            }
            switch (this.hOV.cIR) {
                case 0:
                    String string = this.cRe.getString(R.string.install_app);
                    if (this.hOV.cJb != null && !StringUtils.isNull(this.hOV.cJb.buttonText)) {
                        string = this.hOV.cJb.buttonText;
                    }
                    if (string.length() > hOT) {
                        string = string.substring(0, hOT);
                    }
                    this.hOX.Du(string);
                    return;
                case 1:
                    this.hOX.bYA();
                    return;
                case 2:
                    this.hOX.bYB();
                    return;
                case 3:
                    this.hOX.Du(this.cRe.getString(R.string.pb_download_pause));
                    return;
                default:
                    this.hOX.bYz().setVisibility(8);
                    this.hOX.B(null);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(AdvertAppInfo advertAppInfo) {
        String string;
        if (advertAppInfo != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cRe.getPageActivity());
            if (com.baidu.adp.lib.util.j.isMobileNet()) {
                string = this.cRe.getString(R.string.frs_network_tips);
            } else {
                string = this.cRe.getString(R.string.confirm_download_app);
            }
            aVar.sC(string);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.image.a.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    String str = a.this.hOV.cIT;
                    if (StringUtils.isNull(str)) {
                        str = a.this.cRe.getString(R.string.app_name);
                    }
                    a.this.hOY.bYG();
                    if (s.a(a.this.cRe.getPageActivity(), a.this.hOV, 0, str)) {
                        a.this.hOY.Dv(a.this.hOV.cIV);
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
            aVar.b(this.cRe).aCp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        if ((responsedMessage instanceof DownloadMessage) && this.hOV != null && (data = ((DownloadMessage) responsedMessage).getData()) != null && data.size() != 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null && TextUtils.equals(this.hOV.cIV, downloadData.getId())) {
                    int status = downloadData.getStatus();
                    if (status == 3 || status == 0) {
                        this.hOV.cIR = 2;
                    } else if (status == 2 || status == 4) {
                        if (!aq.isEmpty(downloadData.getStatusMsg())) {
                            this.cRe.showToast(downloadData.getStatusMsg());
                        }
                        this.hOV.cIR = 0;
                    } else if (status == 1) {
                        this.hOV.cIR = 1;
                    }
                    bYs();
                }
            }
        }
    }

    public void bYv() {
        if (!this.hOZ) {
            this.hOZ = true;
            this.hOY.bYF();
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(this.hOV));
        }
    }
}
