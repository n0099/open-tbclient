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
import com.baidu.tieba.tbadkCore.x;
import java.util.List;
/* loaded from: classes8.dex */
public class a implements ImagePagerAdapter.a {
    private static int hSF = 7;
    private TbPageContext<?> cVv;
    private boolean dsw;
    private DragImageView.d dug;
    private AdvertAppInfo hSH;
    private boolean hSI;
    private b hSJ;
    private c hSK;
    private int hSG = 0;
    private boolean hSL = false;
    private final View.OnClickListener hSM = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.hSH != null) {
                if (a.this.hSJ == null || !a.this.hSJ.hSW || a.this.hSJ.cav() != view) {
                    if (!x.au((Activity) view.getContext())) {
                        l.showToast((Activity) view.getContext(), (int) R.string.write_external_storage_permission_denied_fun_disable);
                        return;
                    }
                    if (view.getId() == R.id.big_image_ad_title || view.getId() == R.id.big_image_ad_brand) {
                        a.this.hSK.caB();
                    } else {
                        a.this.hSK.caA();
                    }
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.hSH));
                    int i = a.this.hSH.cNj;
                    if (i == 0 || i == 3) {
                        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() || com.baidu.adp.lib.util.j.isWifiNet()) {
                            String str = a.this.hSH.cNl;
                            if (StringUtils.isNull(str)) {
                                str = a.this.cVv.getString(R.string.app_name);
                            }
                            a.this.hSK.caD();
                            if (s.a(a.this.cVv.getPageActivity(), a.this.hSH, 0, str)) {
                                a.this.hSK.DM(a.this.hSH.cNn);
                                return;
                            }
                            return;
                        }
                        a.this.c(a.this.hSH);
                    } else if (i == 1) {
                        s.f(a.this.hSH);
                        a.this.hSH.cNj = 3;
                        a.this.cap();
                    } else if (i == 2) {
                        if (com.baidu.tieba.recapp.download.e.cCW().uZ(a.this.hSH.cNn)) {
                            x.bd(a.this.cVv.getPageActivity(), a.this.hSH.cNn);
                            return;
                        }
                        a.this.hSH.cNj = 0;
                        a.this.cap();
                    }
                }
            }
        }
    };
    private final View.OnClickListener hSN = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.hSH != null) {
                if (a.this.hSJ == null || !a.this.hSJ.hSW || a.this.hSJ.cav() != view) {
                    if (view.getId() == R.id.big_image_ad_title || view.getId() == R.id.big_image_ad_brand) {
                        a.this.hSK.caB();
                    } else {
                        a.this.hSK.caA();
                    }
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.hSH));
                    r.cCQ().cCN().a(a.this.cVv.getPageActivity(), new String[]{a.this.hSH.cNm}, true);
                }
            }
        }
    };
    private final CustomMessageListener hSO = new CustomMessageListener(0) { // from class: com.baidu.tieba.image.a.6
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
        this.dsw = false;
        this.hSI = false;
        this.dsw = z;
        this.hSI = z2;
        this.cVv = tbPageContext;
        this.cVv.registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.hSO);
        this.hSK = new c(tbPageContext.getPageActivity(), str, str2);
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.hSH = advertAppInfo;
        this.hSG = i;
        this.hSK.d(this.hSH);
    }

    public boolean cao() {
        if (!this.hSI || this.hSH == null) {
            return false;
        }
        return (this.hSH.aAu() || this.hSH.aAt()) && !x.isInstalledPackage(this.cVv.getPageActivity(), this.hSH.cNn);
    }

    public String getAdId() {
        if (this.hSH != null) {
            return this.hSH.cNk;
        }
        return null;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View k(ViewGroup viewGroup, int i) {
        if (xn(i)) {
            this.hSJ = new b(viewGroup);
            this.hSJ.setDragToExitListener(this.dug);
            cap();
            viewGroup.addView(this.hSJ.getView());
            return this.hSJ.getView();
        }
        return null;
    }

    private boolean xn(int i) {
        return cao() && this.hSG != 0 && i == this.hSG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cap() {
        if (this.hSH != null && this.hSH.cNt != null) {
            caq();
            if (this.hSH.aAu()) {
                this.hSJ.caw().setVisibility(8);
                this.hSJ.C(this.hSN);
            } else if (this.hSH.aAt()) {
                this.hSJ.caw().setVisibility(0);
                this.hSJ.C(this.hSM);
                car();
            }
            if (!TextUtils.isEmpty(this.hSH.cNt.adSource)) {
                this.hSJ.hSV.setText(this.hSH.cNt.adSource);
                this.hSJ.hSS.setVisibility(0);
            } else {
                this.hSJ.hSS.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.hSH.cNt.userName)) {
                if (!TextUtils.isEmpty(this.hSH.cNt.tagName)) {
                    this.hSJ.hSU.setText(this.cVv.getResources().getString(R.string.big_image_ad_brand_and_tag, this.hSH.cNt.userName, this.hSH.cNt.tagName));
                } else {
                    this.hSJ.hSU.setText(this.cVv.getResources().getString(R.string.big_image_ad_brand_and_tag, this.hSH.cNt.userName, this.cVv.getString(R.string.advert_label)));
                }
            }
            if (!TextUtils.isEmpty(this.hSH.cNt.cNC)) {
                this.hSJ.hST.setText(this.hSH.cNt.cNC);
            }
        }
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.dug = dVar;
    }

    private void caq() {
        this.hSJ.cav().setEvent(new TbImageView.a() { // from class: com.baidu.tieba.image.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z) {
                    a.this.hSJ.caz();
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.hSJ.cav().a(this.hSH.cNt.cNE, this.dsw ? 30 : 31, 720, 720, false);
        if (this.hSJ.cau() != null) {
            this.hSJ.cau().setIsCdn(this.dsw);
            this.hSJ.cau().setUrl(this.hSH.cNt.cNE, true);
        }
    }

    private void car() {
        if (this.hSH != null) {
            String str = this.hSH.cNl;
            if (StringUtils.isNull(str)) {
                str = this.cVv.getString(R.string.app_name);
            }
            if (com.baidu.tieba.recapp.download.e.cCW().uZ(this.hSH.cNn)) {
                this.hSH.cNj = 2;
            } else if (com.baidu.tieba.recapp.download.e.cCW().en(this.hSH.cNn, str)) {
                if (com.baidu.tieba.recapp.download.e.cCW().uX(this.hSH.cNn)) {
                    this.hSH.cNj = 1;
                } else {
                    this.hSH.cNj = 3;
                }
            }
            switch (this.hSH.cNj) {
                case 0:
                    String string = this.cVv.getString(R.string.install_app);
                    if (this.hSH.cNt != null && !StringUtils.isNull(this.hSH.cNt.buttonText)) {
                        string = this.hSH.cNt.buttonText;
                    }
                    if (string.length() > hSF) {
                        string = string.substring(0, hSF);
                    }
                    this.hSJ.DL(string);
                    return;
                case 1:
                    this.hSJ.cax();
                    return;
                case 2:
                    this.hSJ.cay();
                    return;
                case 3:
                    this.hSJ.DL(this.cVv.getString(R.string.pb_download_pause));
                    return;
                default:
                    this.hSJ.caw().setVisibility(8);
                    this.hSJ.C(null);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(AdvertAppInfo advertAppInfo) {
        String string;
        if (advertAppInfo != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cVv.getPageActivity());
            if (com.baidu.adp.lib.util.j.isMobileNet()) {
                string = this.cVv.getString(R.string.frs_network_tips);
            } else {
                string = this.cVv.getString(R.string.confirm_download_app);
            }
            aVar.sS(string);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.image.a.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    String str = a.this.hSH.cNl;
                    if (StringUtils.isNull(str)) {
                        str = a.this.cVv.getString(R.string.app_name);
                    }
                    a.this.hSK.caD();
                    if (s.a(a.this.cVv.getPageActivity(), a.this.hSH, 0, str)) {
                        a.this.hSK.DM(a.this.hSH.cNn);
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
            aVar.b(this.cVv).aEG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        if ((responsedMessage instanceof DownloadMessage) && this.hSH != null && (data = ((DownloadMessage) responsedMessage).getData()) != null && data.size() != 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null && TextUtils.equals(this.hSH.cNn, downloadData.getId())) {
                    int status = downloadData.getStatus();
                    if (status == 3 || status == 0) {
                        this.hSH.cNj = 2;
                    } else if (status == 2 || status == 4) {
                        if (!aq.isEmpty(downloadData.getStatusMsg())) {
                            this.cVv.showToast(downloadData.getStatusMsg());
                        }
                        this.hSH.cNj = 0;
                    } else if (status == 1) {
                        this.hSH.cNj = 1;
                    }
                    cap();
                }
            }
        }
    }

    public void cas() {
        if (!this.hSL) {
            this.hSL = true;
            this.hSK.caC();
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(this.hSH));
        }
    }
}
