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
    private static int iRq = 7;
    private TbPageContext<?> dIF;
    private boolean egI;
    private DragImageView.d eip;
    private AdvertAppInfo iRs;
    private boolean iRt;
    private b iRu;
    private c iRv;
    private int iRr = 0;
    private boolean iRw = false;
    private final View.OnClickListener iRx = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.iRs != null) {
                if (a.this.iRu == null || !a.this.iRu.iRH || a.this.iRu.cru() != view) {
                    if (!x.ap((Activity) view.getContext())) {
                        l.showToast((Activity) view.getContext(), (int) R.string.write_external_storage_permission_denied_fun_disable);
                        return;
                    }
                    if (view.getId() == R.id.big_image_ad_title || view.getId() == R.id.big_image_ad_brand || view.getId() == R.id.big_image_ad_tag) {
                        a.this.iRv.crA();
                    } else {
                        a.this.iRv.crz();
                    }
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.iRs));
                    int i = a.this.iRs.dAt;
                    if (i == 0 || i == 3) {
                        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() || com.baidu.adp.lib.util.j.isWifiNet()) {
                            String str = a.this.iRs.dAv;
                            if (StringUtils.isNull(str)) {
                                str = a.this.dIF.getString(R.string.app_name);
                            }
                            a.this.iRv.crC();
                            if (r.a(a.this.dIF.getPageActivity(), a.this.iRs, 0, str)) {
                                a.this.iRv.Hg(a.this.iRs.dAx);
                                return;
                            }
                            return;
                        }
                        a.this.c(a.this.iRs);
                    } else if (i == 1) {
                        r.f(a.this.iRs);
                        a.this.iRs.dAt = 3;
                        a.this.cro();
                    } else if (i == 2) {
                        if (com.baidu.tieba.recapp.download.e.cUs().xV(a.this.iRs.dAx)) {
                            x.aN(a.this.dIF.getPageActivity(), a.this.iRs.dAx);
                            return;
                        }
                        a.this.iRs.dAt = 0;
                        a.this.cro();
                    }
                }
            }
        }
    };
    private final View.OnClickListener iRy = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.iRs != null) {
                if (a.this.iRu == null || !a.this.iRu.iRH || a.this.iRu.cru() != view) {
                    if (view.getId() == R.id.big_image_ad_title || view.getId() == R.id.big_image_ad_brand || view.getId() == R.id.big_image_ad_tag) {
                        a.this.iRv.crA();
                    } else {
                        a.this.iRv.crz();
                    }
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.iRs));
                    q.cUm().cUj().a(a.this.dIF.getPageActivity(), new String[]{a.this.iRs.dAw}, true);
                }
            }
        }
    };
    private final CustomMessageListener iRz = new CustomMessageListener(0) { // from class: com.baidu.tieba.image.a.6
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
        this.iRt = false;
        this.egI = z;
        this.iRt = z2;
        this.dIF = tbPageContext;
        this.dIF.registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.iRz);
        this.iRv = new c(tbPageContext.getPageActivity(), str, str2);
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.iRs = advertAppInfo;
        this.iRr = i;
        this.iRv.d(this.iRs);
    }

    public boolean crn() {
        if (!this.iRt || this.iRs == null) {
            return false;
        }
        return (this.iRs.aOA() || this.iRs.aOz()) && !x.isInstalledPackage(this.dIF.getPageActivity(), this.iRs.dAx);
    }

    public String getAdId() {
        if (this.iRs != null) {
            return this.iRs.dAu;
        }
        return null;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View i(ViewGroup viewGroup, int i) {
        if (yt(i)) {
            this.iRu = new b(viewGroup);
            this.iRu.setDragToExitListener(this.eip);
            cro();
            viewGroup.addView(this.iRu.getView());
            return this.iRu.getView();
        }
        return null;
    }

    private boolean yt(int i) {
        return crn() && this.iRr != 0 && i == this.iRr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cro() {
        if (this.iRs != null && this.iRs.dAD != null) {
            crp();
            if (this.iRs.aOA()) {
                this.iRu.crv().setVisibility(8);
                this.iRu.C(this.iRy);
            } else if (this.iRs.aOz()) {
                this.iRu.crv().setVisibility(0);
                this.iRu.C(this.iRx);
                crq();
            }
            if (!TextUtils.isEmpty(this.iRs.dAD.adSource)) {
                this.iRu.iRG.setText(this.iRs.dAD.adSource);
                this.iRu.iRC.setVisibility(0);
            } else {
                this.iRu.iRC.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.iRs.dAD.userName)) {
                this.iRu.iRE.setText(this.iRs.dAD.userName);
                if (!TextUtils.isEmpty(this.iRs.dAD.tagName)) {
                    this.iRu.iRF.setText(this.iRs.dAD.tagName);
                } else {
                    this.iRu.iRF.setText(this.dIF.getString(R.string.advert_label));
                }
            }
            if (!TextUtils.isEmpty(this.iRs.dAD.dAM)) {
                this.iRu.iRD.setText(this.iRs.dAD.dAM);
            }
        }
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.eip = dVar;
    }

    private void crp() {
        this.iRu.cru().setEvent(new TbImageView.a() { // from class: com.baidu.tieba.image.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z) {
                    a.this.iRu.cry();
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.iRu.cru().a(this.iRs.dAD.dAO, this.egI ? 30 : 31, 720, 720, false);
        if (this.iRu.crt() != null) {
            this.iRu.crt().setIsCdn(this.egI);
            this.iRu.crt().setUrl(this.iRs.dAD.dAO, true);
        }
    }

    private void crq() {
        if (this.iRs != null) {
            String str = this.iRs.dAv;
            if (StringUtils.isNull(str)) {
                str = this.dIF.getString(R.string.app_name);
            }
            if (com.baidu.tieba.recapp.download.e.cUs().xV(this.iRs.dAx)) {
                this.iRs.dAt = 2;
            } else if (com.baidu.tieba.recapp.download.e.cUs().fd(this.iRs.dAx, str)) {
                if (com.baidu.tieba.recapp.download.e.cUs().xT(this.iRs.dAx)) {
                    this.iRs.dAt = 1;
                } else {
                    this.iRs.dAt = 3;
                }
            }
            switch (this.iRs.dAt) {
                case 0:
                    String string = this.dIF.getString(R.string.install_app);
                    if (this.iRs.dAD != null && !StringUtils.isNull(this.iRs.dAD.buttonText)) {
                        string = this.iRs.dAD.buttonText;
                    }
                    if (string.length() > iRq) {
                        string = string.substring(0, iRq);
                    }
                    this.iRu.Hf(string);
                    return;
                case 1:
                    this.iRu.crw();
                    return;
                case 2:
                    this.iRu.crx();
                    return;
                case 3:
                    this.iRu.Hf(this.dIF.getString(R.string.pb_download_pause));
                    return;
                default:
                    this.iRu.crv().setVisibility(8);
                    this.iRu.C(null);
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
                    String str = a.this.iRs.dAv;
                    if (StringUtils.isNull(str)) {
                        str = a.this.dIF.getString(R.string.app_name);
                    }
                    a.this.iRv.crC();
                    if (r.a(a.this.dIF.getPageActivity(), a.this.iRs, 0, str)) {
                        a.this.iRv.Hg(a.this.iRs.dAx);
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
        if ((responsedMessage instanceof DownloadMessage) && this.iRs != null && (data = ((DownloadMessage) responsedMessage).getData()) != null && data.size() != 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null && TextUtils.equals(this.iRs.dAx, downloadData.getId())) {
                    int status = downloadData.getStatus();
                    if (status == 3 || status == 0) {
                        this.iRs.dAt = 2;
                    } else if (status == 2 || status == 4) {
                        if (!aq.isEmpty(downloadData.getStatusMsg())) {
                            this.dIF.showToast(downloadData.getStatusMsg());
                        }
                        this.iRs.dAt = 0;
                    } else if (status == 1) {
                        this.iRs.dAt = 1;
                    }
                    cro();
                }
            }
        }
    }

    public void crr() {
        if (!this.iRw) {
            this.iRw = true;
            this.iRv.crB();
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(this.iRs));
        }
    }
}
