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
import com.baidu.tbadk.core.util.ap;
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
/* loaded from: classes26.dex */
public class a extends e {
    private TextView eqE;
    private DownloadCacheKey fMm;
    private com.baidu.tieba.ad.download.a.d fMn;
    private HeadImageView jlY;
    private com.baidu.tieba.lego.card.c kzH;
    private CustomMessageListener mpv;
    private ApkDownloadView mqi;
    private TextView msW;
    private boolean msX;
    protected boolean msY;
    private String mse;

    public a(View view, String str) {
        super(view, str);
        this.fMn = null;
        this.msX = false;
        this.mpv = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.e.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(a.this.mse) && a.this.mse.equals(downloadData.getId())) {
                    a.this.mqi.t(downloadData);
                }
            }
        };
        init();
    }

    private void init() {
        this.jlY = (HeadImageView) HS(R.id.user_portrait);
        this.jlY.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.jlY.setDefaultResource(R.drawable.icon_default_avatar100);
        this.jlY.setDefaultBgResource(R.color.cp_bg_line_e);
        this.jlY.setIsRound(true);
        this.eqE = (TextView) HS(R.id.user_name);
        this.msW = (TextView) HS(R.id.action);
        this.mqi = (ApkDownloadView) HS(R.id.download_view);
        MessageManager.getInstance().registerListener(this.mpv);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(AdCard.f fVar) {
        int i;
        super.a(fVar);
        this.jlY.startLoad(fVar.moE, 10, false);
        this.eqE.setText(fVar.userName);
        this.msW.setText(fVar.buttonText);
        this.mqi.setTextColor(ap.getColor(R.color.cp_btn_a));
        if (this.mti instanceof AdCard) {
            this.msX = ((AdCard) this.mti).directDownload;
        }
        if (this.mth != null) {
            View$OnClickListenerC0822a view$OnClickListenerC0822a = new View$OnClickListenerC0822a(this.mth);
            this.mRootView.setOnClickListener(view$OnClickListenerC0822a);
            if (dyR()) {
                this.mqi.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.e.a.1
                    @Override // com.baidu.tieba.ad.download.mvp.b.a
                    public boolean bL(View view) {
                        return false;
                    }
                });
            } else {
                this.mqi.setOnClickListener(view$OnClickListenerC0822a);
            }
            try {
                i = TextUtils.isEmpty(this.mth.adPosition) ? 0 : Integer.valueOf(this.mth.adPosition).intValue();
            } catch (NumberFormatException e) {
                i = 0;
            }
            this.mse = this.mth.esX;
            DownloadData b = b(this.mth, i);
            h(b);
            this.mqi.setData(b);
        }
        if (!dyR()) {
            this.mqi.x(this.eCn.getUniqueId());
        }
        this.mpv.setTag(this.eCn.getUniqueId());
        dyS();
        onChangeSkinType();
    }

    private void h(DownloadData downloadData) {
        if (dyR()) {
            if (this.mqi != null) {
                downloadData.setStatus(this.mqi.getDownloadStatus());
                return;
            }
            return;
        }
        downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dyR() {
        return !this.msX || this.msY;
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ap.setViewTextColor(this.eqE, R.color.cp_cont_a, 1);
        ap.setViewTextColor(this.msW, R.color.cp_mask_c_alpha83, 1);
        ap.setBackgroundColor(this.msW, R.color.cp_link_tip_a, 1);
        this.mqi.setTextColorInitSkin(R.color.cp_cont_a);
        this.mqi.setBackgroundSkin(R.drawable.tail_frame_action_btn_bg);
        this.mqi.changeSkin();
    }

    public void ww(boolean z) {
        this.msY = z;
    }

    /* renamed from: com.baidu.tieba.recapp.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    private class View$OnClickListenerC0822a implements View.OnClickListener {
        private AdvertAppInfo msi;

        public View$OnClickListenerC0822a(AdvertAppInfo advertAppInfo) {
            this.msi = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                a.this.eCn.showToast(R.string.neterror);
                return;
            }
            boolean z = view == a.this.mqi;
            com.baidu.tieba.lego.card.b.c.a(a.this.mti);
            if (a.this.dyR()) {
                a.this.mqi.performClick();
            } else if (this.msi != null) {
                int i = com.baidu.adp.lib.f.b.toInt(this.msi.adPosition, -1);
                int status = ApkDownloadView.getStatus(a.this.b(this.msi, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    a.this.a(this.msi, i, a.this.mqi, z);
                } else {
                    a.this.showDownloadAppDialog(this.msi, i, true, this.msi.ete != null ? this.msi.ete.etq : "");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData b(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.esX);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.esV);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.esU, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.eCn.getPageActivity(), R.string.neterror);
            } else if (advertAppInfo.bhS()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.eCn.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eCn.getPageActivity());
                aVar.Ba(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.e.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        a.this.d(advertAppInfo, i);
                        if (a.this.mqi != null) {
                            a.this.mqi.q(a.this.b(advertAppInfo, i));
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
                aVar.b(this.eCn).bmC();
            }
        }
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView, boolean z) {
        if (advertAppInfo != null) {
            DownloadData b = b(advertAppInfo, i);
            int status = ApkDownloadView.getStatus(b);
            Log.e("guoqiangxiang", "status: " + status + " id: " + b.getId());
            switch (status) {
                case 1:
                case 5:
                    h.e(advertAppInfo);
                    apkDownloadView.r(b);
                    return;
                case 2:
                case 4:
                default:
                    return;
                case 3:
                    h.aX(this.eCn.getPageActivity(), advertAppInfo.esX);
                    return;
                case 6:
                case 7:
                    d(advertAppInfo, i);
                    apkDownloadView.s(b);
                    return;
            }
        }
    }

    protected void d(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo != null) {
            if (!s.ax(this.eCn.getPageActivity())) {
                l.showToast(this.eCn.getPageActivity(), R.string.write_external_storage_permission_denied_fun_disable);
            } else if (this.kzH != null) {
                this.kzH.c(advertAppInfo, i);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        this.kzH = cVar;
    }

    private void dyS() {
        if (dyR() && this.mth != null) {
            String str = this.mth.esU;
            DownloadCacheKey EX = !TextUtils.isEmpty(str) ? com.baidu.tieba.ad.download.d.bGX().EX(str) : null;
            if (EX == null) {
                EX = DownloadCacheKey.create(str, this.mth.apkUrl, this.mth.esX);
                com.baidu.tieba.ad.download.d.bGX().a(EX, null);
            }
            i(EX);
        }
    }

    private void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.fMm = downloadCacheKey;
            dyT();
            AdDownloadData d = com.baidu.tieba.ad.download.d.bGX().d(downloadCacheKey);
            if (d != null) {
                this.mqi.a(d.getCurrentState());
            } else {
                this.mqi.a(DownloadStatus.STATUS_NONE);
            }
            String str = this.mth != null ? this.mth.page : "";
            d.setExtInfo(this.mth != null ? this.mth.extensionInfo : "");
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.mqi, d, str);
            this.fMn = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
            bGQ();
        }
    }

    public void bGQ() {
        if (this.fMm != null && this.fMn != null) {
            com.baidu.tieba.ad.download.d.bGX().a(this.fMm, this.fMn);
        }
    }

    public void dyT() {
        if (this.fMm != null && this.fMn != null) {
            com.baidu.tieba.ad.download.d.bGX().b(this.fMm, this.fMn);
        }
    }
}
