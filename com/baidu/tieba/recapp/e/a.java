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
    private TextView eig;
    private DownloadCacheKey fDR;
    private com.baidu.tieba.ad.download.a.d fDS;
    private HeadImageView iZE;
    private com.baidu.tieba.lego.card.c knk;
    private CustomMessageListener mcW;
    private ApkDownloadView mdJ;
    private String mfG;
    private TextView mgx;
    private boolean mgy;
    protected boolean mgz;

    public a(View view, String str) {
        super(view, str);
        this.fDS = null;
        this.mgy = false;
        this.mcW = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.e.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(a.this.mfG) && a.this.mfG.equals(downloadData.getId())) {
                    a.this.mdJ.t(downloadData);
                }
            }
        };
        init();
    }

    private void init() {
        this.iZE = (HeadImageView) Hz(R.id.user_portrait);
        this.iZE.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.iZE.setDefaultResource(R.drawable.icon_default_avatar100);
        this.iZE.setDefaultBgResource(R.color.cp_bg_line_e);
        this.iZE.setIsRound(true);
        this.eig = (TextView) Hz(R.id.user_name);
        this.mgx = (TextView) Hz(R.id.action);
        this.mdJ = (ApkDownloadView) Hz(R.id.download_view);
        MessageManager.getInstance().registerListener(this.mcW);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(AdCard.f fVar) {
        int i;
        super.a(fVar);
        this.iZE.startLoad(fVar.mcf, 10, false);
        this.eig.setText(fVar.userName);
        this.mgx.setText(fVar.buttonText);
        this.mdJ.setTextColor(ap.getColor(R.color.cp_btn_a));
        if (this.mgJ instanceof AdCard) {
            this.mgy = ((AdCard) this.mgJ).directDownload;
        }
        if (this.mgI != null) {
            View$OnClickListenerC0807a view$OnClickListenerC0807a = new View$OnClickListenerC0807a(this.mgI);
            this.mRootView.setOnClickListener(view$OnClickListenerC0807a);
            if (dvK()) {
                this.mdJ.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.e.a.1
                    @Override // com.baidu.tieba.ad.download.mvp.b.a
                    public boolean bK(View view) {
                        return false;
                    }
                });
            } else {
                this.mdJ.setOnClickListener(view$OnClickListenerC0807a);
            }
            try {
                i = TextUtils.isEmpty(this.mgI.adPosition) ? 0 : Integer.valueOf(this.mgI.adPosition).intValue();
            } catch (NumberFormatException e) {
                i = 0;
            }
            this.mfG = this.mgI.eky;
            DownloadData b = b(this.mgI, i);
            h(b);
            this.mdJ.setData(b);
        }
        if (!dvK()) {
            this.mdJ.x(this.etO.getUniqueId());
        }
        this.mcW.setTag(this.etO.getUniqueId());
        dvL();
        onChangeSkinType();
    }

    private void h(DownloadData downloadData) {
        if (dvK()) {
            if (this.mdJ != null) {
                downloadData.setStatus(this.mdJ.getDownloadStatus());
                return;
            }
            return;
        }
        downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dvK() {
        return !this.mgy || this.mgz;
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ap.setViewTextColor(this.eig, R.color.cp_cont_a, 1);
        ap.setViewTextColor(this.mgx, R.color.cp_mask_c_alpha83, 1);
        ap.setBackgroundColor(this.mgx, R.color.cp_link_tip_a, 1);
        this.mdJ.setTextColorInitSkin(R.color.cp_cont_a);
        this.mdJ.setBackgroundSkin(R.drawable.tail_frame_action_btn_bg);
        this.mdJ.changeSkin();
    }

    public void wf(boolean z) {
        this.mgz = z;
    }

    /* renamed from: com.baidu.tieba.recapp.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    private class View$OnClickListenerC0807a implements View.OnClickListener {
        private AdvertAppInfo mfJ;

        public View$OnClickListenerC0807a(AdvertAppInfo advertAppInfo) {
            this.mfJ = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                a.this.etO.showToast(R.string.neterror);
                return;
            }
            boolean z = view == a.this.mdJ;
            com.baidu.tieba.lego.card.b.c.a(a.this.mgJ);
            if (a.this.dvK()) {
                a.this.mdJ.performClick();
            } else if (this.mfJ != null) {
                int i = com.baidu.adp.lib.f.b.toInt(this.mfJ.adPosition, -1);
                int status = ApkDownloadView.getStatus(a.this.b(this.mfJ, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    a.this.a(this.mfJ, i, a.this.mdJ, z);
                } else {
                    a.this.showDownloadAppDialog(this.mfJ, i, true, this.mfJ.ekE != null ? this.mfJ.ekE.ekQ : "");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData b(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.eky);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.ekw);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.ekv, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.etO.getPageActivity(), R.string.neterror);
            } else if (advertAppInfo.bfZ()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.etO.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.etO.getPageActivity());
                aVar.AH(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.e.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        a.this.d(advertAppInfo, i);
                        if (a.this.mdJ != null) {
                            a.this.mdJ.q(a.this.b(advertAppInfo, i));
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
                aVar.b(this.etO).bkJ();
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
                    h.aV(this.etO.getPageActivity(), advertAppInfo.eky);
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
            if (!s.ax(this.etO.getPageActivity())) {
                l.showToast(this.etO.getPageActivity(), R.string.write_external_storage_permission_denied_fun_disable);
            } else if (this.knk != null) {
                this.knk.c(advertAppInfo, i);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        this.knk = cVar;
    }

    private void dvL() {
        if (dvK() && this.mgI != null) {
            String str = this.mgI.ekv;
            DownloadCacheKey EE = !TextUtils.isEmpty(str) ? com.baidu.tieba.ad.download.d.bFe().EE(str) : null;
            if (EE == null) {
                EE = DownloadCacheKey.create(str, this.mgI.apkUrl, this.mgI.eky);
                com.baidu.tieba.ad.download.d.bFe().a(EE, null);
            }
            i(EE);
        }
    }

    private void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.fDR = downloadCacheKey;
            dvM();
            AdDownloadData d = com.baidu.tieba.ad.download.d.bFe().d(downloadCacheKey);
            if (d != null) {
                this.mdJ.a(d.getCurrentState());
            } else {
                this.mdJ.a(DownloadStatus.STATUS_NONE);
            }
            String str = this.mgI != null ? this.mgI.page : "";
            d.setExtInfo(this.mgI != null ? this.mgI.extensionInfo : "");
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.mdJ, d, str);
            this.fDS = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
            bEX();
        }
    }

    public void bEX() {
        if (this.fDR != null && this.fDS != null) {
            com.baidu.tieba.ad.download.d.bFe().a(this.fDR, this.fDS);
        }
    }

    public void dvM() {
        if (this.fDR != null && this.fDS != null) {
            com.baidu.tieba.ad.download.d.bFe().b(this.fDR, this.fDS);
        }
    }
}
