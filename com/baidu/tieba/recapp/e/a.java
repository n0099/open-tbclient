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
    private TextView ewx;
    private DownloadCacheKey fSc;
    private com.baidu.tieba.ad.download.a.d fSd;
    private HeadImageView jrW;
    private com.baidu.tieba.lego.card.c kFB;
    private CustomMessageListener mvs;
    private ApkDownloadView mwf;
    private TextView myS;
    private boolean myT;
    protected boolean myU;
    private String myb;

    public a(View view, String str) {
        super(view, str);
        this.fSd = null;
        this.myT = false;
        this.mvs = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.e.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(a.this.myb) && a.this.myb.equals(downloadData.getId())) {
                    a.this.mwf.t(downloadData);
                }
            }
        };
        init();
    }

    private void init() {
        this.jrW = (HeadImageView) If(R.id.user_portrait);
        this.jrW.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.jrW.setDefaultResource(R.drawable.icon_default_avatar100);
        this.jrW.setDefaultBgResource(R.color.cp_bg_line_e);
        this.jrW.setIsRound(true);
        this.ewx = (TextView) If(R.id.user_name);
        this.myS = (TextView) If(R.id.action);
        this.mwf = (ApkDownloadView) If(R.id.download_view);
        MessageManager.getInstance().registerListener(this.mvs);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(AdCard.f fVar) {
        int i;
        super.a(fVar);
        this.jrW.startLoad(fVar.muB, 10, false);
        this.ewx.setText(fVar.userName);
        this.myS.setText(fVar.buttonText);
        this.mwf.setTextColor(ap.getColor(R.color.cp_btn_a));
        if (this.mze instanceof AdCard) {
            this.myT = ((AdCard) this.mze).directDownload;
        }
        if (this.mzd != null) {
            View$OnClickListenerC0837a view$OnClickListenerC0837a = new View$OnClickListenerC0837a(this.mzd);
            this.mRootView.setOnClickListener(view$OnClickListenerC0837a);
            if (dBt()) {
                this.mwf.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.e.a.1
                    @Override // com.baidu.tieba.ad.download.mvp.b.a
                    public boolean bP(View view) {
                        return false;
                    }
                });
            } else {
                this.mwf.setOnClickListener(view$OnClickListenerC0837a);
            }
            try {
                i = TextUtils.isEmpty(this.mzd.adPosition) ? 0 : Integer.valueOf(this.mzd.adPosition).intValue();
            } catch (NumberFormatException e) {
                i = 0;
            }
            this.myb = this.mzd.eyR;
            DownloadData b = b(this.mzd, i);
            h(b);
            this.mwf.setData(b);
        }
        if (!dBt()) {
            this.mwf.x(this.eIc.getUniqueId());
        }
        this.mvs.setTag(this.eIc.getUniqueId());
        dBu();
        onChangeSkinType();
    }

    private void h(DownloadData downloadData) {
        if (dBt()) {
            if (this.mwf != null) {
                downloadData.setStatus(this.mwf.getDownloadStatus());
                return;
            }
            return;
        }
        downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dBt() {
        return !this.myT || this.myU;
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ap.setViewTextColor(this.ewx, R.color.cp_cont_a, 1);
        ap.setViewTextColor(this.myS, R.color.cp_mask_c_alpha83, 1);
        ap.setBackgroundColor(this.myS, R.color.cp_link_tip_a, 1);
        this.mwf.setTextColorInitSkin(R.color.cp_cont_a);
        this.mwf.setBackgroundSkin(R.drawable.tail_frame_action_btn_bg);
        this.mwf.changeSkin();
    }

    public void wF(boolean z) {
        this.myU = z;
    }

    /* renamed from: com.baidu.tieba.recapp.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    private class View$OnClickListenerC0837a implements View.OnClickListener {
        private AdvertAppInfo mye;

        public View$OnClickListenerC0837a(AdvertAppInfo advertAppInfo) {
            this.mye = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                a.this.eIc.showToast(R.string.neterror);
                return;
            }
            boolean z = view == a.this.mwf;
            com.baidu.tieba.lego.card.b.c.a(a.this.mze);
            if (a.this.dBt()) {
                a.this.mwf.performClick();
            } else if (this.mye != null) {
                int i = com.baidu.adp.lib.f.b.toInt(this.mye.adPosition, -1);
                int status = ApkDownloadView.getStatus(a.this.b(this.mye, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    a.this.a(this.mye, i, a.this.mwf, z);
                } else {
                    a.this.showDownloadAppDialog(this.mye, i, true, this.mye.eyX != null ? this.mye.eyX.ezj : "");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData b(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.eyR);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.eyP);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.eyO, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.eIc.getPageActivity(), R.string.neterror);
            } else if (advertAppInfo.bks()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.eIc.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eIc.getPageActivity());
                aVar.Bo(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.e.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        a.this.d(advertAppInfo, i);
                        if (a.this.mwf != null) {
                            a.this.mwf.q(a.this.b(advertAppInfo, i));
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
                aVar.b(this.eIc).bpc();
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
                    h.aX(this.eIc.getPageActivity(), advertAppInfo.eyR);
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
            if (!s.ax(this.eIc.getPageActivity())) {
                l.showToast(this.eIc.getPageActivity(), R.string.write_external_storage_permission_denied_fun_disable);
            } else if (this.kFB != null) {
                this.kFB.c(advertAppInfo, i);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        this.kFB = cVar;
    }

    private void dBu() {
        if (dBt() && this.mzd != null) {
            String str = this.mzd.eyO;
            DownloadCacheKey Fl = !TextUtils.isEmpty(str) ? com.baidu.tieba.ad.download.d.bJw().Fl(str) : null;
            if (Fl == null) {
                Fl = DownloadCacheKey.create(str, this.mzd.apkUrl, this.mzd.eyR);
                com.baidu.tieba.ad.download.d.bJw().a(Fl, null);
            }
            i(Fl);
        }
    }

    private void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.fSc = downloadCacheKey;
            dBv();
            AdDownloadData d = com.baidu.tieba.ad.download.d.bJw().d(downloadCacheKey);
            if (d != null) {
                this.mwf.a(d.getCurrentState());
            } else {
                this.mwf.a(DownloadStatus.STATUS_NONE);
            }
            String str = this.mzd != null ? this.mzd.page : "";
            d.setExtInfo(this.mzd != null ? this.mzd.extensionInfo : "");
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.mwf, d, str);
            this.fSd = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
            bJp();
        }
    }

    public void bJp() {
        if (this.fSc != null && this.fSd != null) {
            com.baidu.tieba.ad.download.d.bJw().a(this.fSc, this.fSd);
        }
    }

    public void dBv() {
        if (this.fSc != null && this.fSd != null) {
            com.baidu.tieba.ad.download.d.bJw().b(this.fSc, this.fSd);
        }
    }
}
