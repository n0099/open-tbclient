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
    private static int iSd = 7;
    private TbPageContext<?> dIF;
    private boolean egI;
    private DragImageView.d eip;
    private AdvertAppInfo iSf;
    private boolean iSg;
    private b iSh;
    private c iSi;
    private int iSe = 0;
    private boolean iSj = false;
    private final View.OnClickListener iSk = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.iSf != null) {
                if (a.this.iSh == null || !a.this.iSh.iSu || a.this.iSh.crD() != view) {
                    if (!x.ap((Activity) view.getContext())) {
                        l.showToast((Activity) view.getContext(), (int) R.string.write_external_storage_permission_denied_fun_disable);
                        return;
                    }
                    if (view.getId() == R.id.big_image_ad_title || view.getId() == R.id.big_image_ad_brand || view.getId() == R.id.big_image_ad_tag) {
                        a.this.iSi.crJ();
                    } else {
                        a.this.iSi.crI();
                    }
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.iSf));
                    int i = a.this.iSf.dAt;
                    if (i == 0 || i == 3) {
                        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() || com.baidu.adp.lib.util.j.isWifiNet()) {
                            String str = a.this.iSf.dAv;
                            if (StringUtils.isNull(str)) {
                                str = a.this.dIF.getString(R.string.app_name);
                            }
                            a.this.iSi.crL();
                            if (r.a(a.this.dIF.getPageActivity(), a.this.iSf, 0, str)) {
                                a.this.iSi.Hg(a.this.iSf.dAx);
                                return;
                            }
                            return;
                        }
                        a.this.c(a.this.iSf);
                    } else if (i == 1) {
                        r.f(a.this.iSf);
                        a.this.iSf.dAt = 3;
                        a.this.crx();
                    } else if (i == 2) {
                        if (com.baidu.tieba.recapp.download.e.cUI().xV(a.this.iSf.dAx)) {
                            x.aN(a.this.dIF.getPageActivity(), a.this.iSf.dAx);
                            return;
                        }
                        a.this.iSf.dAt = 0;
                        a.this.crx();
                    }
                }
            }
        }
    };
    private final View.OnClickListener iSl = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.iSf != null) {
                if (a.this.iSh == null || !a.this.iSh.iSu || a.this.iSh.crD() != view) {
                    if (view.getId() == R.id.big_image_ad_title || view.getId() == R.id.big_image_ad_brand || view.getId() == R.id.big_image_ad_tag) {
                        a.this.iSi.crJ();
                    } else {
                        a.this.iSi.crI();
                    }
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.iSf));
                    q.cUC().cUz().a(a.this.dIF.getPageActivity(), new String[]{a.this.iSf.dAw}, true);
                }
            }
        }
    };
    private final CustomMessageListener iSm = new CustomMessageListener(0) { // from class: com.baidu.tieba.image.a.6
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
        this.egI = false;
        this.iSg = false;
        this.egI = z;
        this.iSg = z2;
        this.dIF = tbPageContext;
        this.dIF.registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.iSm);
        this.iSi = new c(tbPageContext.getPageActivity(), str, str2);
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.iSf = advertAppInfo;
        this.iSe = i;
        this.iSi.d(this.iSf);
    }

    public boolean crw() {
        if (!this.iSg || this.iSf == null) {
            return false;
        }
        return (this.iSf.aOA() || this.iSf.aOz()) && !x.isInstalledPackage(this.dIF.getPageActivity(), this.iSf.dAx);
    }

    public String getAdId() {
        if (this.iSf != null) {
            return this.iSf.dAu;
        }
        return null;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View i(ViewGroup viewGroup, int i) {
        if (yv(i)) {
            this.iSh = new b(viewGroup);
            this.iSh.setDragToExitListener(this.eip);
            crx();
            viewGroup.addView(this.iSh.getView());
            return this.iSh.getView();
        }
        return null;
    }

    private boolean yv(int i) {
        return crw() && this.iSe != 0 && i == this.iSe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crx() {
        if (this.iSf != null && this.iSf.dAD != null) {
            cry();
            if (this.iSf.aOA()) {
                this.iSh.crE().setVisibility(8);
                this.iSh.C(this.iSl);
            } else if (this.iSf.aOz()) {
                this.iSh.crE().setVisibility(0);
                this.iSh.C(this.iSk);
                crz();
            }
            if (!TextUtils.isEmpty(this.iSf.dAD.adSource)) {
                this.iSh.iSt.setText(this.iSf.dAD.adSource);
                this.iSh.iSp.setVisibility(0);
            } else {
                this.iSh.iSp.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.iSf.dAD.userName)) {
                this.iSh.iSr.setText(this.iSf.dAD.userName);
                if (!TextUtils.isEmpty(this.iSf.dAD.tagName)) {
                    this.iSh.iSs.setText(this.iSf.dAD.tagName);
                } else {
                    this.iSh.iSs.setText(this.dIF.getString(R.string.advert_label));
                }
            }
            if (!TextUtils.isEmpty(this.iSf.dAD.dAM)) {
                this.iSh.iSq.setText(this.iSf.dAD.dAM);
            }
        }
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.eip = dVar;
    }

    private void cry() {
        this.iSh.crD().setEvent(new TbImageView.a() { // from class: com.baidu.tieba.image.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z) {
                    a.this.iSh.crH();
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.iSh.crD().a(this.iSf.dAD.dAO, this.egI ? 30 : 31, 720, 720, false);
        if (this.iSh.crC() != null) {
            this.iSh.crC().setIsCdn(this.egI);
            this.iSh.crC().setUrl(this.iSf.dAD.dAO, true);
        }
    }

    private void crz() {
        if (this.iSf != null) {
            String str = this.iSf.dAv;
            if (StringUtils.isNull(str)) {
                str = this.dIF.getString(R.string.app_name);
            }
            if (com.baidu.tieba.recapp.download.e.cUI().xV(this.iSf.dAx)) {
                this.iSf.dAt = 2;
            } else if (com.baidu.tieba.recapp.download.e.cUI().fd(this.iSf.dAx, str)) {
                if (com.baidu.tieba.recapp.download.e.cUI().xT(this.iSf.dAx)) {
                    this.iSf.dAt = 1;
                } else {
                    this.iSf.dAt = 3;
                }
            }
            switch (this.iSf.dAt) {
                case 0:
                    String string = this.dIF.getString(R.string.install_app);
                    if (this.iSf.dAD != null && !StringUtils.isNull(this.iSf.dAD.buttonText)) {
                        string = this.iSf.dAD.buttonText;
                    }
                    if (string.length() > iSd) {
                        string = string.substring(0, iSd);
                    }
                    this.iSh.Hf(string);
                    return;
                case 1:
                    this.iSh.crF();
                    return;
                case 2:
                    this.iSh.crG();
                    return;
                case 3:
                    this.iSh.Hf(this.dIF.getString(R.string.pb_download_pause));
                    return;
                default:
                    this.iSh.crE().setVisibility(8);
                    this.iSh.C(null);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(AdvertAppInfo advertAppInfo) {
        String string;
        if (advertAppInfo != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dIF.getPageActivity());
            if (com.baidu.adp.lib.util.j.isMobileNet()) {
                string = this.dIF.getString(R.string.frs_network_tips);
            } else {
                string = this.dIF.getString(R.string.confirm_download_app);
            }
            aVar.vO(string);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.image.a.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    String str = a.this.iSf.dAv;
                    if (StringUtils.isNull(str)) {
                        str = a.this.dIF.getString(R.string.app_name);
                    }
                    a.this.iSi.crL();
                    if (r.a(a.this.dIF.getPageActivity(), a.this.iSf, 0, str)) {
                        a.this.iSi.Hg(a.this.iSf.dAx);
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
            aVar.b(this.dIF).aST();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        if ((responsedMessage instanceof DownloadMessage) && this.iSf != null && (data = ((DownloadMessage) responsedMessage).getData()) != null && data.size() != 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null && TextUtils.equals(this.iSf.dAx, downloadData.getId())) {
                    int status = downloadData.getStatus();
                    if (status == 3 || status == 0) {
                        this.iSf.dAt = 2;
                    } else if (status == 2 || status == 4) {
                        if (!aq.isEmpty(downloadData.getStatusMsg())) {
                            this.dIF.showToast(downloadData.getStatusMsg());
                        }
                        this.iSf.dAt = 0;
                    } else if (status == 1) {
                        this.iSf.dAt = 1;
                    }
                    crx();
                }
            }
        }
    }

    public void crA() {
        if (!this.iSj) {
            this.iSj = true;
            this.iSi.crK();
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(this.iSf));
        }
    }
}
