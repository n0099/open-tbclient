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
    private static int hQT = 7;
    private TbPageContext<?> cVh;
    private boolean drV;
    private DragImageView.d dtG;
    private AdvertAppInfo hQV;
    private boolean hQW;
    private b hQX;
    private c hQY;
    private int hQU = 0;
    private boolean hQZ = false;
    private final View.OnClickListener hRa = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.hQV != null) {
                if (a.this.hQX == null || !a.this.hQX.hRk || a.this.hQX.cab() != view) {
                    if (!w.as((Activity) view.getContext())) {
                        l.showToast((Activity) view.getContext(), (int) R.string.write_external_storage_permission_denied_fun_disable);
                        return;
                    }
                    if (view.getId() == R.id.big_image_ad_title || view.getId() == R.id.big_image_ad_brand) {
                        a.this.hQY.cah();
                    } else {
                        a.this.hQY.cag();
                    }
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.hQV));
                    int i = a.this.hQV.cMV;
                    if (i == 0 || i == 3) {
                        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() || com.baidu.adp.lib.util.j.isWifiNet()) {
                            String str = a.this.hQV.cMX;
                            if (StringUtils.isNull(str)) {
                                str = a.this.cVh.getString(R.string.app_name);
                            }
                            a.this.hQY.caj();
                            if (s.a(a.this.cVh.getPageActivity(), a.this.hQV, 0, str)) {
                                a.this.hQY.DL(a.this.hQV.cMZ);
                                return;
                            }
                            return;
                        }
                        a.this.c(a.this.hQV);
                    } else if (i == 1) {
                        s.f(a.this.hQV);
                        a.this.hQV.cMV = 3;
                        a.this.bZV();
                    } else if (i == 2) {
                        if (com.baidu.tieba.recapp.download.e.cCB().uY(a.this.hQV.cMZ)) {
                            w.bd(a.this.cVh.getPageActivity(), a.this.hQV.cMZ);
                            return;
                        }
                        a.this.hQV.cMV = 0;
                        a.this.bZV();
                    }
                }
            }
        }
    };
    private final View.OnClickListener hRb = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.hQV != null) {
                if (a.this.hQX == null || !a.this.hQX.hRk || a.this.hQX.cab() != view) {
                    if (view.getId() == R.id.big_image_ad_title || view.getId() == R.id.big_image_ad_brand) {
                        a.this.hQY.cah();
                    } else {
                        a.this.hQY.cag();
                    }
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.hQV));
                    r.cCv().cCs().a(a.this.cVh.getPageActivity(), new String[]{a.this.hQV.cMY}, true);
                }
            }
        }
    };
    private final CustomMessageListener hRc = new CustomMessageListener(0) { // from class: com.baidu.tieba.image.a.6
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
        this.drV = false;
        this.hQW = false;
        this.drV = z;
        this.hQW = z2;
        this.cVh = tbPageContext;
        this.cVh.registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.hRc);
        this.hQY = new c(tbPageContext.getPageActivity(), str, str2);
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.hQV = advertAppInfo;
        this.hQU = i;
        this.hQY.d(this.hQV);
    }

    public boolean bZU() {
        if (!this.hQW || this.hQV == null) {
            return false;
        }
        return (this.hQV.aAr() || this.hQV.aAq()) && !w.isInstalledPackage(this.cVh.getPageActivity(), this.hQV.cMZ);
    }

    public String getAdId() {
        if (this.hQV != null) {
            return this.hQV.cMW;
        }
        return null;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View k(ViewGroup viewGroup, int i) {
        if (xf(i)) {
            this.hQX = new b(viewGroup);
            this.hQX.setDragToExitListener(this.dtG);
            bZV();
            viewGroup.addView(this.hQX.getView());
            return this.hQX.getView();
        }
        return null;
    }

    private boolean xf(int i) {
        return bZU() && this.hQU != 0 && i == this.hQU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZV() {
        if (this.hQV != null && this.hQV.cNf != null) {
            bZW();
            if (this.hQV.aAr()) {
                this.hQX.cac().setVisibility(8);
                this.hQX.C(this.hRb);
            } else if (this.hQV.aAq()) {
                this.hQX.cac().setVisibility(0);
                this.hQX.C(this.hRa);
                bZX();
            }
            if (!TextUtils.isEmpty(this.hQV.cNf.adSource)) {
                this.hQX.hRj.setText(this.hQV.cNf.adSource);
                this.hQX.hRg.setVisibility(0);
            } else {
                this.hQX.hRg.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.hQV.cNf.userName)) {
                if (!TextUtils.isEmpty(this.hQV.cNf.tagName)) {
                    this.hQX.hRi.setText(this.cVh.getResources().getString(R.string.big_image_ad_brand_and_tag, this.hQV.cNf.userName, this.hQV.cNf.tagName));
                } else {
                    this.hQX.hRi.setText(this.cVh.getResources().getString(R.string.big_image_ad_brand_and_tag, this.hQV.cNf.userName, this.cVh.getString(R.string.advert_label)));
                }
            }
            if (!TextUtils.isEmpty(this.hQV.cNf.cNo)) {
                this.hQX.hRh.setText(this.hQV.cNf.cNo);
            }
        }
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.dtG = dVar;
    }

    private void bZW() {
        this.hQX.cab().setEvent(new TbImageView.a() { // from class: com.baidu.tieba.image.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z) {
                    a.this.hQX.caf();
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.hQX.cab().a(this.hQV.cNf.cNq, this.drV ? 30 : 31, 720, 720, false);
        if (this.hQX.caa() != null) {
            this.hQX.caa().setIsCdn(this.drV);
            this.hQX.caa().setUrl(this.hQV.cNf.cNq, true);
        }
    }

    private void bZX() {
        if (this.hQV != null) {
            String str = this.hQV.cMX;
            if (StringUtils.isNull(str)) {
                str = this.cVh.getString(R.string.app_name);
            }
            if (com.baidu.tieba.recapp.download.e.cCB().uY(this.hQV.cMZ)) {
                this.hQV.cMV = 2;
            } else if (com.baidu.tieba.recapp.download.e.cCB().ep(this.hQV.cMZ, str)) {
                if (com.baidu.tieba.recapp.download.e.cCB().uW(this.hQV.cMZ)) {
                    this.hQV.cMV = 1;
                } else {
                    this.hQV.cMV = 3;
                }
            }
            switch (this.hQV.cMV) {
                case 0:
                    String string = this.cVh.getString(R.string.install_app);
                    if (this.hQV.cNf != null && !StringUtils.isNull(this.hQV.cNf.buttonText)) {
                        string = this.hQV.cNf.buttonText;
                    }
                    if (string.length() > hQT) {
                        string = string.substring(0, hQT);
                    }
                    this.hQX.DK(string);
                    return;
                case 1:
                    this.hQX.cad();
                    return;
                case 2:
                    this.hQX.cae();
                    return;
                case 3:
                    this.hQX.DK(this.cVh.getString(R.string.pb_download_pause));
                    return;
                default:
                    this.hQX.cac().setVisibility(8);
                    this.hQX.C(null);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(AdvertAppInfo advertAppInfo) {
        String string;
        if (advertAppInfo != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cVh.getPageActivity());
            if (com.baidu.adp.lib.util.j.isMobileNet()) {
                string = this.cVh.getString(R.string.frs_network_tips);
            } else {
                string = this.cVh.getString(R.string.confirm_download_app);
            }
            aVar.sS(string);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.image.a.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    String str = a.this.hQV.cMX;
                    if (StringUtils.isNull(str)) {
                        str = a.this.cVh.getString(R.string.app_name);
                    }
                    a.this.hQY.caj();
                    if (s.a(a.this.cVh.getPageActivity(), a.this.hQV, 0, str)) {
                        a.this.hQY.DL(a.this.hQV.cMZ);
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
            aVar.b(this.cVh).aEC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        if ((responsedMessage instanceof DownloadMessage) && this.hQV != null && (data = ((DownloadMessage) responsedMessage).getData()) != null && data.size() != 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null && TextUtils.equals(this.hQV.cMZ, downloadData.getId())) {
                    int status = downloadData.getStatus();
                    if (status == 3 || status == 0) {
                        this.hQV.cMV = 2;
                    } else if (status == 2 || status == 4) {
                        if (!aq.isEmpty(downloadData.getStatusMsg())) {
                            this.cVh.showToast(downloadData.getStatusMsg());
                        }
                        this.hQV.cMV = 0;
                    } else if (status == 1) {
                        this.hQV.cMV = 1;
                    }
                    bZV();
                }
            }
        }
    }

    public void bZY() {
        if (!this.hQZ) {
            this.hQZ = true;
            this.hQY.cai();
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(this.hQV));
        }
    }
}
