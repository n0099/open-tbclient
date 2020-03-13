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
    private static int hRf = 7;
    private TbPageContext<?> cVi;
    private boolean dsi;
    private DragImageView.d dtT;
    private AdvertAppInfo hRh;
    private boolean hRi;
    private b hRj;
    private c hRk;
    private int hRg = 0;
    private boolean hRl = false;
    private final View.OnClickListener hRm = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.hRh != null) {
                if (a.this.hRj == null || !a.this.hRj.hRw || a.this.hRj.cac() != view) {
                    if (!w.au((Activity) view.getContext())) {
                        l.showToast((Activity) view.getContext(), (int) R.string.write_external_storage_permission_denied_fun_disable);
                        return;
                    }
                    if (view.getId() == R.id.big_image_ad_title || view.getId() == R.id.big_image_ad_brand) {
                        a.this.hRk.cai();
                    } else {
                        a.this.hRk.cah();
                    }
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.hRh));
                    int i = a.this.hRh.cMW;
                    if (i == 0 || i == 3) {
                        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() || com.baidu.adp.lib.util.j.isWifiNet()) {
                            String str = a.this.hRh.cMY;
                            if (StringUtils.isNull(str)) {
                                str = a.this.cVi.getString(R.string.app_name);
                            }
                            a.this.hRk.cak();
                            if (s.a(a.this.cVi.getPageActivity(), a.this.hRh, 0, str)) {
                                a.this.hRk.DM(a.this.hRh.cNa);
                                return;
                            }
                            return;
                        }
                        a.this.c(a.this.hRh);
                    } else if (i == 1) {
                        s.f(a.this.hRh);
                        a.this.hRh.cMW = 3;
                        a.this.bZW();
                    } else if (i == 2) {
                        if (com.baidu.tieba.recapp.download.e.cCC().uZ(a.this.hRh.cNa)) {
                            w.bd(a.this.cVi.getPageActivity(), a.this.hRh.cNa);
                            return;
                        }
                        a.this.hRh.cMW = 0;
                        a.this.bZW();
                    }
                }
            }
        }
    };
    private final View.OnClickListener hRn = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.hRh != null) {
                if (a.this.hRj == null || !a.this.hRj.hRw || a.this.hRj.cac() != view) {
                    if (view.getId() == R.id.big_image_ad_title || view.getId() == R.id.big_image_ad_brand) {
                        a.this.hRk.cai();
                    } else {
                        a.this.hRk.cah();
                    }
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.hRh));
                    r.cCw().cCt().a(a.this.cVi.getPageActivity(), new String[]{a.this.hRh.cMZ}, true);
                }
            }
        }
    };
    private final CustomMessageListener hRo = new CustomMessageListener(0) { // from class: com.baidu.tieba.image.a.6
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
        this.dsi = false;
        this.hRi = false;
        this.dsi = z;
        this.hRi = z2;
        this.cVi = tbPageContext;
        this.cVi.registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.hRo);
        this.hRk = new c(tbPageContext.getPageActivity(), str, str2);
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.hRh = advertAppInfo;
        this.hRg = i;
        this.hRk.d(this.hRh);
    }

    public boolean bZV() {
        if (!this.hRi || this.hRh == null) {
            return false;
        }
        return (this.hRh.aAr() || this.hRh.aAq()) && !w.isInstalledPackage(this.cVi.getPageActivity(), this.hRh.cNa);
    }

    public String getAdId() {
        if (this.hRh != null) {
            return this.hRh.cMX;
        }
        return null;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View k(ViewGroup viewGroup, int i) {
        if (xf(i)) {
            this.hRj = new b(viewGroup);
            this.hRj.setDragToExitListener(this.dtT);
            bZW();
            viewGroup.addView(this.hRj.getView());
            return this.hRj.getView();
        }
        return null;
    }

    private boolean xf(int i) {
        return bZV() && this.hRg != 0 && i == this.hRg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZW() {
        if (this.hRh != null && this.hRh.cNg != null) {
            bZX();
            if (this.hRh.aAr()) {
                this.hRj.cad().setVisibility(8);
                this.hRj.C(this.hRn);
            } else if (this.hRh.aAq()) {
                this.hRj.cad().setVisibility(0);
                this.hRj.C(this.hRm);
                bZY();
            }
            if (!TextUtils.isEmpty(this.hRh.cNg.adSource)) {
                this.hRj.hRv.setText(this.hRh.cNg.adSource);
                this.hRj.hRs.setVisibility(0);
            } else {
                this.hRj.hRs.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.hRh.cNg.userName)) {
                if (!TextUtils.isEmpty(this.hRh.cNg.tagName)) {
                    this.hRj.hRu.setText(this.cVi.getResources().getString(R.string.big_image_ad_brand_and_tag, this.hRh.cNg.userName, this.hRh.cNg.tagName));
                } else {
                    this.hRj.hRu.setText(this.cVi.getResources().getString(R.string.big_image_ad_brand_and_tag, this.hRh.cNg.userName, this.cVi.getString(R.string.advert_label)));
                }
            }
            if (!TextUtils.isEmpty(this.hRh.cNg.cNp)) {
                this.hRj.hRt.setText(this.hRh.cNg.cNp);
            }
        }
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.dtT = dVar;
    }

    private void bZX() {
        this.hRj.cac().setEvent(new TbImageView.a() { // from class: com.baidu.tieba.image.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z) {
                    a.this.hRj.cag();
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.hRj.cac().a(this.hRh.cNg.cNr, this.dsi ? 30 : 31, 720, 720, false);
        if (this.hRj.cab() != null) {
            this.hRj.cab().setIsCdn(this.dsi);
            this.hRj.cab().setUrl(this.hRh.cNg.cNr, true);
        }
    }

    private void bZY() {
        if (this.hRh != null) {
            String str = this.hRh.cMY;
            if (StringUtils.isNull(str)) {
                str = this.cVi.getString(R.string.app_name);
            }
            if (com.baidu.tieba.recapp.download.e.cCC().uZ(this.hRh.cNa)) {
                this.hRh.cMW = 2;
            } else if (com.baidu.tieba.recapp.download.e.cCC().ep(this.hRh.cNa, str)) {
                if (com.baidu.tieba.recapp.download.e.cCC().uX(this.hRh.cNa)) {
                    this.hRh.cMW = 1;
                } else {
                    this.hRh.cMW = 3;
                }
            }
            switch (this.hRh.cMW) {
                case 0:
                    String string = this.cVi.getString(R.string.install_app);
                    if (this.hRh.cNg != null && !StringUtils.isNull(this.hRh.cNg.buttonText)) {
                        string = this.hRh.cNg.buttonText;
                    }
                    if (string.length() > hRf) {
                        string = string.substring(0, hRf);
                    }
                    this.hRj.DL(string);
                    return;
                case 1:
                    this.hRj.cae();
                    return;
                case 2:
                    this.hRj.caf();
                    return;
                case 3:
                    this.hRj.DL(this.cVi.getString(R.string.pb_download_pause));
                    return;
                default:
                    this.hRj.cad().setVisibility(8);
                    this.hRj.C(null);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(AdvertAppInfo advertAppInfo) {
        String string;
        if (advertAppInfo != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cVi.getPageActivity());
            if (com.baidu.adp.lib.util.j.isMobileNet()) {
                string = this.cVi.getString(R.string.frs_network_tips);
            } else {
                string = this.cVi.getString(R.string.confirm_download_app);
            }
            aVar.sS(string);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.image.a.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    String str = a.this.hRh.cMY;
                    if (StringUtils.isNull(str)) {
                        str = a.this.cVi.getString(R.string.app_name);
                    }
                    a.this.hRk.cak();
                    if (s.a(a.this.cVi.getPageActivity(), a.this.hRh, 0, str)) {
                        a.this.hRk.DM(a.this.hRh.cNa);
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
            aVar.b(this.cVi).aEC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        if ((responsedMessage instanceof DownloadMessage) && this.hRh != null && (data = ((DownloadMessage) responsedMessage).getData()) != null && data.size() != 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null && TextUtils.equals(this.hRh.cNa, downloadData.getId())) {
                    int status = downloadData.getStatus();
                    if (status == 3 || status == 0) {
                        this.hRh.cMW = 2;
                    } else if (status == 2 || status == 4) {
                        if (!aq.isEmpty(downloadData.getStatusMsg())) {
                            this.cVi.showToast(downloadData.getStatusMsg());
                        }
                        this.hRh.cMW = 0;
                    } else if (status == 1) {
                        this.hRh.cMW = 1;
                    }
                    bZW();
                }
            }
        }
    }

    public void bZZ() {
        if (!this.hRl) {
            this.hRl = true;
            this.hRk.caj();
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(this.hRh));
        }
    }
}
