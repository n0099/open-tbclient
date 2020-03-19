package com.baidu.tieba.recapp.e;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.mvp.b;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.tieba.recapp.download.h;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
/* loaded from: classes13.dex */
public class a extends e {
    private TextView cbW;
    private DownloadCacheKey dZC;
    private com.baidu.tieba.ad.download.a.d dZD;
    private HeadImageView gVk;
    private com.baidu.tieba.lego.card.c iar;
    private CustomMessageListener jJY;
    private ApkDownloadView jKM;
    private TextView jNP;
    private boolean jNQ;
    protected boolean jNR;
    private String jNc;

    public a(View view, String str) {
        super(view, str);
        this.dZD = null;
        this.jNQ = false;
        this.jJY = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.e.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(a.this.jNc) && a.this.jNc.equals(downloadData.getId())) {
                    a.this.jKM.t(downloadData);
                }
            }
        };
        init();
    }

    private void init() {
        this.gVk = (HeadImageView) Bn(R.id.user_portrait);
        this.gVk.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gVk.setDefaultResource(R.drawable.icon_default_avatar100);
        this.gVk.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gVk.setIsRound(true);
        this.cbW = (TextView) Bn(R.id.user_name);
        this.jNP = (TextView) Bn(R.id.action);
        this.jKM = (ApkDownloadView) Bn(R.id.download_view);
        MessageManager.getInstance().registerListener(this.jJY);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(AdCard.f fVar) {
        super.a(fVar);
        this.gVk.startLoad(fVar.jJf, 10, false);
        this.cbW.setText(fVar.userName);
        this.jNP.setText(fVar.buttonText);
        this.jKM.setTextColor(am.getColor(R.color.cp_btn_a));
        if (this.jOb instanceof AdCard) {
            this.jNQ = ((AdCard) this.jOb).directDownload;
        }
        if (this.jOa != null) {
            View$OnClickListenerC0599a view$OnClickListenerC0599a = new View$OnClickListenerC0599a(this.jOa);
            this.mRootView.setOnClickListener(view$OnClickListenerC0599a);
            if (cDO()) {
                this.jKM.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.e.a.1
                    @Override // com.baidu.tieba.ad.download.mvp.b.a
                    public void bp(View view) {
                    }
                });
            } else {
                this.jKM.setOnClickListener(view$OnClickListenerC0599a);
            }
            int intValue = Integer.valueOf(this.jOa.adPosition).intValue();
            this.jNc = this.jOa.cNn;
            DownloadData c = c(this.jOa, intValue);
            o(c);
            this.jKM.setData(c);
        }
        if (!cDO()) {
            this.jKM.u(this.cVv.getUniqueId());
        }
        this.jJY.setTag(this.cVv.getUniqueId());
        cDP();
        onChangeSkinType();
    }

    private void o(DownloadData downloadData) {
        if (cDO()) {
            if (this.jKM != null) {
                downloadData.setStatus(this.jKM.getDownloadStatus());
                return;
            }
            return;
        }
        downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cDO() {
        return !this.jNQ || this.jNR;
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        am.setViewTextColor(this.cbW, R.color.cp_cont_a, 1);
        am.setViewTextColor(this.jNP, R.color.cp_mask_c_alpha83, 1);
        am.setBackgroundColor(this.jNP, R.color.cp_link_tip_a, 1);
        this.jKM.setTextColorInitSkin(R.color.cp_cont_a);
        this.jKM.setBackgroundSkin(R.drawable.tail_frame_action_btn_bg);
        this.jKM.can();
    }

    public void sj(boolean z) {
        this.jNR = z;
    }

    /* renamed from: com.baidu.tieba.recapp.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    private class View$OnClickListenerC0599a implements View.OnClickListener {
        private AdvertAppInfo jNf;

        public View$OnClickListenerC0599a(AdvertAppInfo advertAppInfo) {
            this.jNf = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                a.this.cVv.showToast(R.string.neterror);
                return;
            }
            boolean z = view == a.this.jKM;
            if (a.this.cDO()) {
                a.this.jKM.performClick();
            } else if (this.jNf != null) {
                int i = com.baidu.adp.lib.f.b.toInt(this.jNf.adPosition, -1);
                int status = ApkDownloadView.getStatus(a.this.c(this.jNf, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    a.this.a(this.jNf, i, a.this.jKM, z);
                } else {
                    a.this.showDownloadAppDialog(this.jNf, i, true, this.jNf.cNt != null ? this.jNf.cNt.cNF : "");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.cNn);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.cNl);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.cNk, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.cVv.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.aAt()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.cVv.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cVv.getPageActivity());
                aVar.sS(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.e.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        a.this.d(advertAppInfo, i);
                        if (a.this.jKM != null) {
                            a.this.jKM.q(a.this.c(advertAppInfo, i));
                        }
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.recapp.e.a.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.cVv).aEG();
            }
        }
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView, boolean z) {
        if (advertAppInfo != null) {
            DownloadData c = c(advertAppInfo, i);
            int status = ApkDownloadView.getStatus(c);
            Log.e("guoqiangxiang", "status: " + status + " id: " + c.getId());
            switch (status) {
                case 1:
                case 5:
                    h.f(advertAppInfo);
                    apkDownloadView.r(c);
                    return;
                case 2:
                case 4:
                default:
                    return;
                case 3:
                    h.bd(this.cVv.getPageActivity(), advertAppInfo.cNn);
                    return;
                case 6:
                case 7:
                    d(advertAppInfo, i);
                    apkDownloadView.s(c);
                    return;
            }
        }
    }

    protected void d(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo != null) {
            if (!s.au(this.cVv.getPageActivity())) {
                l.showToast(this.cVv.getPageActivity(), (int) R.string.write_external_storage_permission_denied_fun_disable);
            } else if (this.iar != null) {
                this.iar.b(advertAppInfo, i);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        this.iar = cVar;
    }

    private void cDP() {
        if (cDO() && this.jOa != null) {
            String str = this.jOa.cNk;
            DownloadCacheKey xc = !TextUtils.isEmpty(str) ? com.baidu.tieba.ad.download.d.aYp().xc(str) : null;
            if (xc == null) {
                xc = DownloadCacheKey.create(str, this.jOa.apkUrl, this.jOa.cNn);
                com.baidu.tieba.ad.download.d.aYp().a(xc, null);
            }
            i(xc);
        }
    }

    private void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.dZC = downloadCacheKey;
            cDQ();
            AdDownloadData d = com.baidu.tieba.ad.download.d.aYp().d(downloadCacheKey);
            if (d != null) {
                this.jKM.a(d.getCurrentState());
            } else {
                this.jKM.a(DownloadStatus.STATUS_NONE);
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.jKM, d, this.jOa != null ? this.jOa.page : "");
            this.dZD = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
            aYj();
        }
    }

    public void aYj() {
        if (this.dZC != null && this.dZD != null) {
            com.baidu.tieba.ad.download.d.aYp().a(this.dZC, this.dZD);
        }
    }

    public void cDQ() {
        if (this.dZC != null && this.dZD != null) {
            com.baidu.tieba.ad.download.d.aYp().b(this.dZC, this.dZD);
        }
    }
}
