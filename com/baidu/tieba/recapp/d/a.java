package com.baidu.tieba.recapp.d;

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
import com.baidu.tbadk.core.TbadkCoreApplication;
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
import com.baidu.tieba.recapp.t;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
/* loaded from: classes7.dex */
public class a extends e {
    private TextView eKp;
    private com.baidu.tieba.ad.download.a.d giA;
    private DownloadCacheKey giz;
    private HeadImageView jYK;
    private com.baidu.tieba.lego.card.c leE;
    private CustomMessageListener mWB;
    private ApkDownloadView mZu;
    private String mZv;
    private TextView nak;
    private boolean nal;
    protected boolean nam;

    public a(View view, String str) {
        super(view, str);
        this.giA = null;
        this.nal = false;
        this.mWB = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.d.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(a.this.mZv) && a.this.mZv.equals(downloadData.getId())) {
                    a.this.mZu.s(downloadData);
                }
            }
        };
        init();
    }

    private void init() {
        this.jYK = (HeadImageView) Ih(R.id.user_portrait);
        this.jYK.setDefaultResource(R.drawable.icon_default_avatar100);
        this.jYK.setDefaultBgResource(R.color.CAM_X0205);
        this.jYK.setIsRound(true);
        this.eKp = (TextView) Ih(R.id.user_name);
        this.nak = (TextView) Ih(R.id.action);
        this.mZu = (ApkDownloadView) Ih(R.id.download_view);
        MessageManager.getInstance().registerListener(this.mWB);
    }

    @Override // com.baidu.tieba.recapp.d.e
    public void a(AdCard.g gVar) {
        int i;
        super.a(gVar);
        this.jYK.startLoad(gVar.mVF, 10, false);
        this.eKp.setText(gVar.userName);
        this.nak.setText(gVar.buttonText);
        this.mZu.setTextColor(ap.getColor(R.color.CAM_X0901));
        if (this.nax instanceof AdCard) {
            this.nal = ((AdCard) this.nax).directDownload;
        }
        if (this.naw != null) {
            View$OnClickListenerC0863a view$OnClickListenerC0863a = new View$OnClickListenerC0863a(this.naw);
            this.mRootView.setOnClickListener(view$OnClickListenerC0863a);
            if (dEG()) {
                this.mZu.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.d.a.1
                    @Override // com.baidu.tieba.ad.download.mvp.b.a
                    public boolean ce(View view) {
                        return false;
                    }
                });
            } else {
                this.mZu.setOnClickListener(view$OnClickListenerC0863a);
            }
            try {
                i = TextUtils.isEmpty(this.naw.adPosition) ? 0 : Integer.valueOf(this.naw.adPosition).intValue();
            } catch (NumberFormatException e) {
                i = 0;
            }
            this.mZv = this.naw.eMX;
            DownloadData d = d(this.naw, i);
            n(d);
            this.mZu.setData(d);
        }
        if (!dEG()) {
            this.mZu.z(this.eWx.getUniqueId());
        }
        this.mWB.setTag(this.eWx.getUniqueId());
        dEH();
        onChangeSkinType();
    }

    private void n(DownloadData downloadData) {
        if (dEG()) {
            if (this.mZu != null) {
                downloadData.setStatus(this.mZu.getDownloadStatus());
                return;
            }
            return;
        }
        downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dEG() {
        return !this.nal || this.nam;
    }

    @Override // com.baidu.tieba.recapp.d.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ap.setViewTextColor(this.eKp, R.color.CAM_X0101, 1);
        ap.setViewTextColor(this.nak, R.color.CAM_X0620, 1);
        ap.setBackgroundResource(this.nak, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
        this.mZu.setTextColorInitSkin(R.color.CAM_X0101);
        this.mZu.setBackgroundSkin(R.drawable.tail_frame_action_btn_bg);
        this.mZu.bur();
    }

    public void xC(boolean z) {
        this.nam = z;
    }

    /* renamed from: com.baidu.tieba.recapp.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    private class View$OnClickListenerC0863a implements View.OnClickListener {
        private AdvertAppInfo mZy;

        public View$OnClickListenerC0863a(AdvertAppInfo advertAppInfo) {
            this.mZy = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                a.this.eWx.showToast(R.string.neterror);
                return;
            }
            boolean z = view == a.this.mZu;
            com.baidu.tieba.lego.card.a.c.a(a.this.nax);
            if (a.this.dEG()) {
                a.this.mZu.performClick();
            } else if (this.mZy != null) {
                int i = com.baidu.adp.lib.f.b.toInt(this.mZy.adPosition, -1);
                int status = ApkDownloadView.getStatus(a.this.d(this.mZy, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    a.this.a(this.mZy, i, a.this.mZu, z);
                } else {
                    a.this.showDownloadAppDialog(this.mZy, i, true, this.mZy.eNd != null ? this.mZy.eNd.eNr : "");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData d(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.eMX != null ? advertAppInfo.eMX : advertAppInfo.eMU);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.eMV);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.eMU, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.eWx.getPageActivity(), R.string.neterror);
            } else if (advertAppInfo.blG()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.eWx.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eWx.getPageActivity());
                aVar.AB(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.d.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        a.this.e(advertAppInfo, i);
                        if (a.this.mZu != null) {
                            a.this.mZu.p(a.this.d(advertAppInfo, i));
                        }
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.recapp.d.a.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.eWx).bqz();
            }
        }
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView, boolean z) {
        if (advertAppInfo != null) {
            DownloadData d = d(advertAppInfo, i);
            int status = ApkDownloadView.getStatus(d);
            Log.e("guoqiangxiang", "status: " + status + " id: " + d.getId());
            switch (status) {
                case 1:
                case 5:
                    h.i(advertAppInfo);
                    apkDownloadView.q(d);
                    return;
                case 2:
                case 4:
                default:
                    return;
                case 3:
                    h.installApp(this.eWx.getPageActivity(), advertAppInfo.eMX);
                    return;
                case 6:
                case 7:
                    e(advertAppInfo, i);
                    apkDownloadView.r(d);
                    return;
            }
        }
    }

    protected void e(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo != null) {
            if (!t.au(this.eWx.getPageActivity())) {
                l.showToast(this.eWx.getPageActivity(), R.string.write_external_storage_permission_denied_fun_disable);
            } else if (this.leE != null) {
                this.leE.c(advertAppInfo, i);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.d.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        this.leE = cVar;
    }

    private void dEH() {
        if (dEG() && this.naw != null) {
            String str = this.naw.eMX;
            DownloadCacheKey EQ = !TextUtils.isEmpty(str) ? com.baidu.tieba.ad.download.d.bLC().EQ(str) : null;
            if (EQ == null) {
                EQ = DownloadCacheKey.create(str, this.naw.apkUrl, this.naw.eMX);
                com.baidu.tieba.ad.download.d.bLC().a(EQ, null);
            }
            i(EQ);
        }
    }

    private void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.giz = downloadCacheKey;
            dEI();
            AdDownloadData d = com.baidu.tieba.ad.download.d.bLC().d(downloadCacheKey);
            if (d != null) {
                this.mZu.a(d.getCurrentState());
            } else {
                this.mZu.a(DownloadStatus.STATUS_NONE);
            }
            String str = this.naw != null ? this.naw.page : "";
            d.setExtInfo(this.naw != null ? this.naw.extensionInfo : "");
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.mZu, d, str);
            this.giA = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d.extra().getPercent() > 0) {
                aVar.c((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
            bLu();
        }
    }

    public void bLu() {
        if (this.giz != null && this.giA != null) {
            com.baidu.tieba.ad.download.d.bLC().a(this.giz, this.giA);
        }
    }

    public void dEI() {
        if (this.giz != null && this.giA != null) {
            com.baidu.tieba.ad.download.d.bLC().b(this.giz, this.giA);
        }
    }
}
