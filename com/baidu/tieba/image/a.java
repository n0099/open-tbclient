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
/* loaded from: classes5.dex */
public class a implements ImagePagerAdapter.a {
    private static int hLq = 7;
    private TbPageContext<?> cQU;
    private boolean dnA;
    private DragImageView.d dpm;
    private AdvertAppInfo hLs;
    private boolean hLt;
    private b hLu;
    private c hLv;
    private int hLr = 0;
    private boolean hLw = false;
    private final View.OnClickListener hLx = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.hLs != null) {
                if (a.this.hLu == null || !a.this.hLu.hLH || a.this.hLu.bXp() != view) {
                    if (!w.aq((Activity) view.getContext())) {
                        l.showToast((Activity) view.getContext(), (int) R.string.write_external_storage_permission_denied_fun_disable);
                        return;
                    }
                    if (view.getId() == R.id.big_image_ad_title || view.getId() == R.id.big_image_ad_brand) {
                        a.this.hLv.bXv();
                    } else {
                        a.this.hLv.bXu();
                    }
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.hLs));
                    int i = a.this.hLs.cIF;
                    if (i == 0 || i == 3) {
                        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() || com.baidu.adp.lib.util.j.isWifiNet()) {
                            String str = a.this.hLs.cIH;
                            if (StringUtils.isNull(str)) {
                                str = a.this.cQU.getString(R.string.app_name);
                            }
                            a.this.hLv.bXx();
                            if (s.a(a.this.cQU.getPageActivity(), a.this.hLs, 0, str)) {
                                a.this.hLv.Dl(a.this.hLs.cIK);
                                return;
                            }
                            return;
                        }
                        a.this.c(a.this.hLs);
                    } else if (i == 1) {
                        s.f(a.this.hLs);
                        a.this.hLs.cIF = 3;
                        a.this.bXj();
                    } else if (i == 2) {
                        if (com.baidu.tieba.recapp.download.e.czU().uC(a.this.hLs.cIK)) {
                            w.bc(a.this.cQU.getPageActivity(), a.this.hLs.cIK);
                            return;
                        }
                        a.this.hLs.cIF = 0;
                        a.this.bXj();
                    }
                }
            }
        }
    };
    private final View.OnClickListener hLy = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.hLs != null) {
                if (a.this.hLu == null || !a.this.hLu.hLH || a.this.hLu.bXp() != view) {
                    if (view.getId() == R.id.big_image_ad_title || view.getId() == R.id.big_image_ad_brand) {
                        a.this.hLv.bXv();
                    } else {
                        a.this.hLv.bXu();
                    }
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.hLs));
                    r.czO().czL().a(a.this.cQU.getPageActivity(), new String[]{a.this.hLs.cII}, true);
                }
            }
        }
    };
    private final CustomMessageListener hLz = new CustomMessageListener(0) { // from class: com.baidu.tieba.image.a.6
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
        this.dnA = false;
        this.hLt = false;
        this.dnA = z;
        this.hLt = z2;
        this.cQU = tbPageContext;
        this.cQU.registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.hLz);
        this.hLv = new c(tbPageContext.getPageActivity(), str, str2);
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.hLs = advertAppInfo;
        this.hLr = i;
        this.hLv.d(this.hLs);
    }

    public boolean bXi() {
        if (!this.hLt || this.hLs == null) {
            return false;
        }
        return (this.hLs.axI() || this.hLs.axH()) && !w.isInstalledPackage(this.cQU.getPageActivity(), this.hLs.cIK);
    }

    public String getAdId() {
        if (this.hLs != null) {
            return this.hLs.cIG;
        }
        return null;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View k(ViewGroup viewGroup, int i) {
        if (wU(i)) {
            this.hLu = new b(viewGroup);
            this.hLu.setDragToExitListener(this.dpm);
            bXj();
            viewGroup.addView(this.hLu.getView());
            return this.hLu.getView();
        }
        return null;
    }

    private boolean wU(int i) {
        return bXi() && this.hLr != 0 && i == this.hLr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXj() {
        if (this.hLs != null && this.hLs.cIQ != null) {
            bXk();
            if (this.hLs.axI()) {
                this.hLu.bXq().setVisibility(8);
                this.hLu.C(this.hLy);
            } else if (this.hLs.axH()) {
                this.hLu.bXq().setVisibility(0);
                this.hLu.C(this.hLx);
                bXl();
            }
            if (!TextUtils.isEmpty(this.hLs.cIQ.adSource)) {
                this.hLu.hLG.setText(this.hLs.cIQ.adSource);
                this.hLu.hLD.setVisibility(0);
            } else {
                this.hLu.hLD.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.hLs.cIQ.userName)) {
                if (!TextUtils.isEmpty(this.hLs.cIQ.tagName)) {
                    this.hLu.hLF.setText(this.cQU.getResources().getString(R.string.big_image_ad_brand_and_tag, this.hLs.cIQ.userName, this.hLs.cIQ.tagName));
                } else {
                    this.hLu.hLF.setText(this.cQU.getResources().getString(R.string.big_image_ad_brand_and_tag, this.hLs.cIQ.userName, this.cQU.getString(R.string.advert_label)));
                }
            }
            if (!TextUtils.isEmpty(this.hLs.cIQ.cIZ)) {
                this.hLu.hLE.setText(this.hLs.cIQ.cIZ);
            }
        }
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.dpm = dVar;
    }

    private void bXk() {
        this.hLu.bXp().setEvent(new TbImageView.a() { // from class: com.baidu.tieba.image.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z) {
                    a.this.hLu.bXt();
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.hLu.bXp().a(this.hLs.cIQ.cJb, this.dnA ? 30 : 31, 720, 720, false);
        if (this.hLu.bXo() != null) {
            this.hLu.bXo().setIsCdn(this.dnA);
            this.hLu.bXo().setUrl(this.hLs.cIQ.cJb, true);
        }
    }

    private void bXl() {
        if (this.hLs != null) {
            String str = this.hLs.cIH;
            if (StringUtils.isNull(str)) {
                str = this.cQU.getString(R.string.app_name);
            }
            if (com.baidu.tieba.recapp.download.e.czU().uC(this.hLs.cIK)) {
                this.hLs.cIF = 2;
            } else if (com.baidu.tieba.recapp.download.e.czU().ee(this.hLs.cIK, str)) {
                if (com.baidu.tieba.recapp.download.e.czU().uA(this.hLs.cIK)) {
                    this.hLs.cIF = 1;
                } else {
                    this.hLs.cIF = 3;
                }
            }
            switch (this.hLs.cIF) {
                case 0:
                    String string = this.cQU.getString(R.string.install_app);
                    if (this.hLs.cIQ != null && !StringUtils.isNull(this.hLs.cIQ.buttonText)) {
                        string = this.hLs.cIQ.buttonText;
                    }
                    if (string.length() > hLq) {
                        string = string.substring(0, hLq);
                    }
                    this.hLu.Dk(string);
                    return;
                case 1:
                    this.hLu.bXr();
                    return;
                case 2:
                    this.hLu.bXs();
                    return;
                case 3:
                    this.hLu.Dk(this.cQU.getString(R.string.pb_download_pause));
                    return;
                default:
                    this.hLu.bXq().setVisibility(8);
                    this.hLu.C(null);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(AdvertAppInfo advertAppInfo) {
        String string;
        if (advertAppInfo != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cQU.getPageActivity());
            if (com.baidu.adp.lib.util.j.isMobileNet()) {
                string = this.cQU.getString(R.string.frs_network_tips);
            } else {
                string = this.cQU.getString(R.string.confirm_download_app);
            }
            aVar.sz(string);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.image.a.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    String str = a.this.hLs.cIH;
                    if (StringUtils.isNull(str)) {
                        str = a.this.cQU.getString(R.string.app_name);
                    }
                    a.this.hLv.bXx();
                    if (s.a(a.this.cQU.getPageActivity(), a.this.hLs, 0, str)) {
                        a.this.hLv.Dl(a.this.hLs.cIK);
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
            aVar.b(this.cQU).aBW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        if ((responsedMessage instanceof DownloadMessage) && this.hLs != null && (data = ((DownloadMessage) responsedMessage).getData()) != null && data.size() != 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null && TextUtils.equals(this.hLs.cIK, downloadData.getId())) {
                    int status = downloadData.getStatus();
                    if (status == 3 || status == 0) {
                        this.hLs.cIF = 2;
                    } else if (status == 2 || status == 4) {
                        if (!aq.isEmpty(downloadData.getStatusMsg())) {
                            this.cQU.showToast(downloadData.getStatusMsg());
                        }
                        this.hLs.cIF = 0;
                    } else if (status == 1) {
                        this.hLs.cIF = 1;
                    }
                    bXj();
                }
            }
        }
    }

    public void bXm() {
        if (!this.hLw) {
            this.hLw = true;
            this.hLv.bXw();
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(this.hLs));
        }
    }
}
