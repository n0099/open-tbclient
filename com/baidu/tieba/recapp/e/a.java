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
    private TextView cbJ;
    private DownloadCacheKey dYY;
    private com.baidu.tieba.ad.download.a.d dYZ;
    private HeadImageView gTP;
    private com.baidu.tieba.lego.card.c hYD;
    private ApkDownloadView jIW;
    private CustomMessageListener jIl;
    private TextView jLZ;
    private String jLm;
    private boolean jMa;
    protected boolean jMb;

    public a(View view, String str) {
        super(view, str);
        this.dYZ = null;
        this.jMa = false;
        this.jIl = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.e.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(a.this.jLm) && a.this.jLm.equals(downloadData.getId())) {
                    a.this.jIW.t(downloadData);
                }
            }
        };
        init();
    }

    private void init() {
        this.gTP = (HeadImageView) Bf(R.id.user_portrait);
        this.gTP.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gTP.setDefaultResource(R.drawable.icon_default_avatar100);
        this.gTP.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gTP.setIsRound(true);
        this.cbJ = (TextView) Bf(R.id.user_name);
        this.jLZ = (TextView) Bf(R.id.action);
        this.jIW = (ApkDownloadView) Bf(R.id.download_view);
        MessageManager.getInstance().registerListener(this.jIl);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(AdCard.f fVar) {
        super.a(fVar);
        this.gTP.startLoad(fVar.jHs, 10, false);
        this.cbJ.setText(fVar.userName);
        this.jLZ.setText(fVar.buttonText);
        this.jIW.setTextColor(am.getColor(R.color.cp_btn_a));
        if (this.jMl instanceof AdCard) {
            this.jMa = ((AdCard) this.jMl).directDownload;
        }
        if (this.jMk != null) {
            View$OnClickListenerC0598a view$OnClickListenerC0598a = new View$OnClickListenerC0598a(this.jMk);
            this.mRootView.setOnClickListener(view$OnClickListenerC0598a);
            if (cDr()) {
                this.jIW.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.e.a.1
                    @Override // com.baidu.tieba.ad.download.mvp.b.a
                    public void bp(View view) {
                    }
                });
            } else {
                this.jIW.setOnClickListener(view$OnClickListenerC0598a);
            }
            int intValue = Integer.valueOf(this.jMk.adPosition).intValue();
            this.jLm = this.jMk.cMY;
            DownloadData c = c(this.jMk, intValue);
            o(c);
            this.jIW.setData(c);
        }
        if (!cDr()) {
            this.jIW.u(this.cVg.getUniqueId());
        }
        this.jIl.setTag(this.cVg.getUniqueId());
        cDs();
        onChangeSkinType();
    }

    private void o(DownloadData downloadData) {
        if (cDr()) {
            if (this.jIW != null) {
                downloadData.setStatus(this.jIW.getDownloadStatus());
                return;
            }
            return;
        }
        downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cDr() {
        return !this.jMa || this.jMb;
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        am.setViewTextColor(this.cbJ, R.color.cp_cont_a, 1);
        am.setViewTextColor(this.jLZ, R.color.cp_mask_c_alpha83, 1);
        am.setBackgroundColor(this.jLZ, R.color.cp_link_tip_a, 1);
        this.jIW.setTextColorInitSkin(R.color.cp_cont_a);
        this.jIW.setBackgroundSkin(R.drawable.tail_frame_action_btn_bg);
        this.jIW.bHq();
    }

    public void sd(boolean z) {
        this.jMb = z;
    }

    /* renamed from: com.baidu.tieba.recapp.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    private class View$OnClickListenerC0598a implements View.OnClickListener {
        private AdvertAppInfo jLp;

        public View$OnClickListenerC0598a(AdvertAppInfo advertAppInfo) {
            this.jLp = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                a.this.cVg.showToast(R.string.neterror);
                return;
            }
            boolean z = view == a.this.jIW;
            if (a.this.cDr()) {
                a.this.jIW.performClick();
            } else if (this.jLp != null) {
                int i = com.baidu.adp.lib.f.b.toInt(this.jLp.adPosition, -1);
                int status = ApkDownloadView.getStatus(a.this.c(this.jLp, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    a.this.a(this.jLp, i, a.this.jIW, z);
                } else {
                    a.this.showDownloadAppDialog(this.jLp, i, true, this.jLp.cNe != null ? this.jLp.cNe.cNq : "");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.cMY);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.cMW);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.cMV, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.cVg.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.aAo()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.cVg.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cVg.getPageActivity());
                aVar.sS(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.e.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        a.this.d(advertAppInfo, i);
                        if (a.this.jIW != null) {
                            a.this.jIW.q(a.this.c(advertAppInfo, i));
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
                aVar.b(this.cVg).aEA();
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
                    h.bd(this.cVg.getPageActivity(), advertAppInfo.cMY);
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
            if (!s.as(this.cVg.getPageActivity())) {
                l.showToast(this.cVg.getPageActivity(), (int) R.string.write_external_storage_permission_denied_fun_disable);
            } else if (this.hYD != null) {
                this.hYD.b(advertAppInfo, i);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        this.hYD = cVar;
    }

    private void cDs() {
        if (cDr() && this.jMk != null) {
            String str = this.jMk.cMV;
            DownloadCacheKey xa = !TextUtils.isEmpty(str) ? com.baidu.tieba.ad.download.d.aYi().xa(str) : null;
            if (xa == null) {
                xa = DownloadCacheKey.create(str, this.jMk.apkUrl, this.jMk.cMY);
                com.baidu.tieba.ad.download.d.aYi().a(xa, null);
            }
            i(xa);
        }
    }

    private void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.dYY = downloadCacheKey;
            cDt();
            AdDownloadData d = com.baidu.tieba.ad.download.d.aYi().d(downloadCacheKey);
            if (d != null) {
                this.jIW.a(d.getCurrentState());
            } else {
                this.jIW.a(DownloadStatus.STATUS_NONE);
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.jIW, d, this.jMk != null ? this.jMk.page : "");
            this.dYZ = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
            aYc();
        }
    }

    public void aYc() {
        if (this.dYY != null && this.dYZ != null) {
            com.baidu.tieba.ad.download.d.aYi().a(this.dYY, this.dYZ);
        }
    }

    public void cDt() {
        if (this.dYY != null && this.dYZ != null) {
            com.baidu.tieba.ad.download.d.aYi().b(this.dYY, this.dYZ);
        }
    }
}
