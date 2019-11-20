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
/* loaded from: classes3.dex */
public class a implements ImagePagerAdapter.a {
    private static int gXp = 7;
    private DragImageView.d cBB;
    private TbPageContext<?> ceu;
    private boolean czS;
    private AdvertAppInfo gXr;
    private boolean gXs;
    private b gXt;
    private c gXu;
    private int gXq = 0;
    private boolean gXv = false;
    private final View.OnClickListener gXw = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.gXr != null) {
                if (a.this.gXt == null || !a.this.gXt.gXG || a.this.gXt.bGc() != view) {
                    if (!w.al((Activity) view.getContext())) {
                        l.showToast((Activity) view.getContext(), (int) R.string.write_external_storage_permission_denied_fun_disable);
                        return;
                    }
                    if (view.getId() == R.id.big_image_ad_title || view.getId() == R.id.big_image_ad_brand) {
                        a.this.gXu.bGi();
                    } else {
                        a.this.gXu.bGh();
                    }
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.gXr));
                    int i = a.this.gXr.bWs;
                    if (i == 0 || i == 3) {
                        if (!j.isNetWorkAvailable() || j.isWifiNet()) {
                            String str = a.this.gXr.bWu;
                            if (StringUtils.isNull(str)) {
                                str = a.this.ceu.getString(R.string.app_name);
                            }
                            a.this.gXu.bGk();
                            if (s.a(a.this.ceu.getPageActivity(), a.this.gXr, 0, str)) {
                                a.this.gXu.yC(a.this.gXr.bWx);
                                return;
                            }
                            return;
                        }
                        a.this.c(a.this.gXr);
                    } else if (i == 1) {
                        s.f(a.this.gXr);
                        a.this.gXr.bWs = 3;
                        a.this.bFW();
                    } else if (i == 2) {
                        if (com.baidu.tieba.recapp.download.e.cfQ().pw(a.this.gXr.bWx)) {
                            w.aK(a.this.ceu.getPageActivity(), a.this.gXr.bWx);
                            return;
                        }
                        a.this.gXr.bWs = 0;
                        a.this.bFW();
                    }
                }
            }
        }
    };
    private final View.OnClickListener gXx = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.gXr != null) {
                if (a.this.gXt == null || !a.this.gXt.gXG || a.this.gXt.bGc() != view) {
                    if (view.getId() == R.id.big_image_ad_title || view.getId() == R.id.big_image_ad_brand) {
                        a.this.gXu.bGi();
                    } else {
                        a.this.gXu.bGh();
                    }
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.gXr));
                    r.cfJ().cfG().a(a.this.ceu.getPageActivity(), new String[]{a.this.gXr.bWv}, true);
                }
            }
        }
    };
    private final CustomMessageListener gXy = new CustomMessageListener(0) { // from class: com.baidu.tieba.image.a.6
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
        this.czS = false;
        this.gXs = false;
        this.czS = z;
        this.gXs = z2;
        this.ceu = tbPageContext;
        this.ceu.registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.gXy);
        this.gXu = new c(tbPageContext.getPageActivity(), str, str2);
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.gXr = advertAppInfo;
        this.gXq = i;
        this.gXu.d(this.gXr);
    }

    public boolean bFV() {
        if (!this.gXs || this.gXr == null) {
            return false;
        }
        return (this.gXr.agR() || this.gXr.agQ()) && !w.isInstalledPackage(this.ceu.getPageActivity(), this.gXr.bWx);
    }

    public String getAdId() {
        if (this.gXr != null) {
            return this.gXr.bWt;
        }
        return null;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View f(ViewGroup viewGroup, int i) {
        if (uS(i)) {
            this.gXt = new b(viewGroup);
            this.gXt.setDragToExitListener(this.cBB);
            bFW();
            viewGroup.addView(this.gXt.getView());
            return this.gXt.getView();
        }
        return null;
    }

    private boolean uS(int i) {
        return bFV() && this.gXq != 0 && i == this.gXq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFW() {
        if (this.gXr != null && this.gXr.bWD != null) {
            bFX();
            if (this.gXr.agR()) {
                this.gXt.bGd().setVisibility(8);
                this.gXt.B(this.gXx);
            } else if (this.gXr.agQ()) {
                this.gXt.bGd().setVisibility(0);
                this.gXt.B(this.gXw);
                bFY();
            }
            if (!TextUtils.isEmpty(this.gXr.bWD.adSource)) {
                this.gXt.gXF.setText(this.gXr.bWD.adSource);
                this.gXt.gXC.setVisibility(0);
            } else {
                this.gXt.gXC.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.gXr.bWD.userName)) {
                if (!TextUtils.isEmpty(this.gXr.bWD.tagName)) {
                    this.gXt.gXE.setText(this.ceu.getResources().getString(R.string.big_image_ad_brand_and_tag, this.gXr.bWD.userName, this.gXr.bWD.tagName));
                } else {
                    this.gXt.gXE.setText(this.ceu.getResources().getString(R.string.big_image_ad_brand_and_tag, this.gXr.bWD.userName, this.ceu.getString(R.string.advert_label)));
                }
            }
            if (!TextUtils.isEmpty(this.gXr.bWD.bWM)) {
                this.gXt.gXD.setText(this.gXr.bWD.bWM);
            }
        }
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.cBB = dVar;
    }

    private void bFX() {
        this.gXt.bGc().setEvent(new TbImageView.a() { // from class: com.baidu.tieba.image.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z) {
                    a.this.gXt.bGg();
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.gXt.bGc().a(this.gXr.bWD.bWO, this.czS ? 30 : 31, 720, 720, false);
        if (this.gXt.bGb() != null) {
            this.gXt.bGb().setIsCdn(this.czS);
            this.gXt.bGb().setUrl(this.gXr.bWD.bWO, true);
        }
    }

    private void bFY() {
        if (this.gXr != null) {
            String str = this.gXr.bWu;
            if (StringUtils.isNull(str)) {
                str = this.ceu.getString(R.string.app_name);
            }
            if (com.baidu.tieba.recapp.download.e.cfQ().pw(this.gXr.bWx)) {
                this.gXr.bWs = 2;
            } else if (com.baidu.tieba.recapp.download.e.cfQ().dL(this.gXr.bWx, str)) {
                if (com.baidu.tieba.recapp.download.e.cfQ().pu(this.gXr.bWx)) {
                    this.gXr.bWs = 1;
                } else {
                    this.gXr.bWs = 3;
                }
            }
            switch (this.gXr.bWs) {
                case 0:
                    String string = this.ceu.getString(R.string.install_app);
                    if (this.gXr.bWD != null && !StringUtils.isNull(this.gXr.bWD.buttonText)) {
                        string = this.gXr.bWD.buttonText;
                    }
                    if (string.length() > gXp) {
                        string = string.substring(0, gXp);
                    }
                    this.gXt.yB(string);
                    return;
                case 1:
                    this.gXt.bGe();
                    return;
                case 2:
                    this.gXt.bGf();
                    return;
                case 3:
                    this.gXt.yB(this.ceu.getString(R.string.pb_download_pause));
                    return;
                default:
                    this.gXt.bGd().setVisibility(8);
                    this.gXt.B(null);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(AdvertAppInfo advertAppInfo) {
        String string;
        if (advertAppInfo != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ceu.getPageActivity());
            if (j.isMobileNet()) {
                string = this.ceu.getString(R.string.frs_network_tips);
            } else {
                string = this.ceu.getString(R.string.confirm_download_app);
            }
            aVar.nn(string);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.image.a.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    String str = a.this.gXr.bWu;
                    if (StringUtils.isNull(str)) {
                        str = a.this.ceu.getString(R.string.app_name);
                    }
                    a.this.gXu.bGk();
                    if (s.a(a.this.ceu.getPageActivity(), a.this.gXr, 0, str)) {
                        a.this.gXu.yC(a.this.gXr.bWx);
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
            aVar.b(this.ceu).akM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        if ((responsedMessage instanceof DownloadMessage) && this.gXr != null && (data = ((DownloadMessage) responsedMessage).getData()) != null && data.size() != 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null && TextUtils.equals(this.gXr.bWx, downloadData.getId())) {
                    int status = downloadData.getStatus();
                    if (status == 3 || status == 0) {
                        this.gXr.bWs = 2;
                    } else if (status == 2 || status == 4) {
                        if (!aq.isEmpty(downloadData.getStatusMsg())) {
                            this.ceu.showToast(downloadData.getStatusMsg());
                        }
                        this.gXr.bWs = 0;
                    } else if (status == 1) {
                        this.gXr.bWs = 1;
                    }
                    bFW();
                }
            }
        }
    }

    public void bFZ() {
        if (!this.gXv) {
            this.gXv = true;
            this.gXu.bGj();
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(this.gXr));
        }
    }
}
