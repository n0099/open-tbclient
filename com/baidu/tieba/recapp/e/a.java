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
/* loaded from: classes25.dex */
public class a extends e {
    private TextView dWe;
    private DownloadCacheKey frG;
    private com.baidu.tieba.ad.download.a.d frH;
    private HeadImageView iKM;
    private com.baidu.tieba.lego.card.c jXU;
    private CustomMessageListener lNF;
    private ApkDownloadView lOs;
    private String lQo;
    private TextView lRf;
    private boolean lRg;
    protected boolean lRh;

    public a(View view, String str) {
        super(view, str);
        this.frH = null;
        this.lRg = false;
        this.lNF = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.e.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(a.this.lQo) && a.this.lQo.equals(downloadData.getId())) {
                    a.this.lOs.t(downloadData);
                }
            }
        };
        init();
    }

    private void init() {
        this.iKM = (HeadImageView) GT(R.id.user_portrait);
        this.iKM.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.iKM.setDefaultResource(R.drawable.icon_default_avatar100);
        this.iKM.setDefaultBgResource(R.color.cp_bg_line_e);
        this.iKM.setIsRound(true);
        this.dWe = (TextView) GT(R.id.user_name);
        this.lRf = (TextView) GT(R.id.action);
        this.lOs = (ApkDownloadView) GT(R.id.download_view);
        MessageManager.getInstance().registerListener(this.lNF);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(AdCard.f fVar) {
        int i;
        super.a(fVar);
        this.iKM.startLoad(fVar.lMO, 10, false);
        this.dWe.setText(fVar.userName);
        this.lRf.setText(fVar.buttonText);
        this.lOs.setTextColor(ap.getColor(R.color.cp_btn_a));
        if (this.lRr instanceof AdCard) {
            this.lRg = ((AdCard) this.lRr).directDownload;
        }
        if (this.lRq != null) {
            View$OnClickListenerC0789a view$OnClickListenerC0789a = new View$OnClickListenerC0789a(this.lRq);
            this.mRootView.setOnClickListener(view$OnClickListenerC0789a);
            if (drZ()) {
                this.lOs.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.e.a.1
                    @Override // com.baidu.tieba.ad.download.mvp.b.a
                    public boolean bG(View view) {
                        return false;
                    }
                });
            } else {
                this.lOs.setOnClickListener(view$OnClickListenerC0789a);
            }
            try {
                i = TextUtils.isEmpty(this.lRq.adPosition) ? 0 : Integer.valueOf(this.lRq.adPosition).intValue();
            } catch (NumberFormatException e) {
                i = 0;
            }
            this.lQo = this.lRq.dYw;
            DownloadData b = b(this.lRq, i);
            h(b);
            this.lOs.setData(b);
        }
        if (!drZ()) {
            this.lOs.x(this.ehG.getUniqueId());
        }
        this.lNF.setTag(this.ehG.getUniqueId());
        dsa();
        onChangeSkinType();
    }

    private void h(DownloadData downloadData) {
        if (drZ()) {
            if (this.lOs != null) {
                downloadData.setStatus(this.lOs.getDownloadStatus());
                return;
            }
            return;
        }
        downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean drZ() {
        return !this.lRg || this.lRh;
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ap.setViewTextColor(this.dWe, R.color.cp_cont_a, 1);
        ap.setViewTextColor(this.lRf, R.color.cp_mask_c_alpha83, 1);
        ap.setBackgroundColor(this.lRf, R.color.cp_link_tip_a, 1);
        this.lOs.setTextColorInitSkin(R.color.cp_cont_a);
        this.lOs.setBackgroundSkin(R.drawable.tail_frame_action_btn_bg);
        this.lOs.changeSkin();
    }

    public void vy(boolean z) {
        this.lRh = z;
    }

    /* renamed from: com.baidu.tieba.recapp.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    private class View$OnClickListenerC0789a implements View.OnClickListener {
        private AdvertAppInfo lQr;

        public View$OnClickListenerC0789a(AdvertAppInfo advertAppInfo) {
            this.lQr = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                a.this.ehG.showToast(R.string.neterror);
                return;
            }
            boolean z = view == a.this.lOs;
            com.baidu.tieba.lego.card.b.c.a(a.this.lRr);
            if (a.this.drZ()) {
                a.this.lOs.performClick();
            } else if (this.lQr != null) {
                int i = com.baidu.adp.lib.f.b.toInt(this.lQr.adPosition, -1);
                int status = ApkDownloadView.getStatus(a.this.b(this.lQr, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    a.this.a(this.lQr, i, a.this.lOs, z);
                } else {
                    a.this.showDownloadAppDialog(this.lQr, i, true, this.lQr.dYC != null ? this.lQr.dYC.dYO : "");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData b(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.dYw);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.dYu);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.dYt, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.ehG.getPageActivity(), R.string.neterror);
            } else if (advertAppInfo.bdq()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.ehG.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ehG.getPageActivity());
                aVar.zV(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.e.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        a.this.d(advertAppInfo, i);
                        if (a.this.lOs != null) {
                            a.this.lOs.q(a.this.b(advertAppInfo, i));
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
                aVar.b(this.ehG).bia();
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
                    h.aT(this.ehG.getPageActivity(), advertAppInfo.dYw);
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
            if (!s.aw(this.ehG.getPageActivity())) {
                l.showToast(this.ehG.getPageActivity(), R.string.write_external_storage_permission_denied_fun_disable);
            } else if (this.jXU != null) {
                this.jXU.c(advertAppInfo, i);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        this.jXU = cVar;
    }

    private void dsa() {
        if (drZ() && this.lRq != null) {
            String str = this.lRq.dYt;
            DownloadCacheKey DT = !TextUtils.isEmpty(str) ? com.baidu.tieba.ad.download.d.bCs().DT(str) : null;
            if (DT == null) {
                DT = DownloadCacheKey.create(str, this.lRq.apkUrl, this.lRq.dYw);
                com.baidu.tieba.ad.download.d.bCs().a(DT, null);
            }
            i(DT);
        }
    }

    private void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.frG = downloadCacheKey;
            dsb();
            AdDownloadData d = com.baidu.tieba.ad.download.d.bCs().d(downloadCacheKey);
            if (d != null) {
                this.lOs.a(d.getCurrentState());
            } else {
                this.lOs.a(DownloadStatus.STATUS_NONE);
            }
            String str = this.lRq != null ? this.lRq.page : "";
            d.setExtInfo(this.lRq != null ? this.lRq.extensionInfo : "");
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.lOs, d, str);
            this.frH = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
            bCl();
        }
    }

    public void bCl() {
        if (this.frG != null && this.frH != null) {
            com.baidu.tieba.ad.download.d.bCs().a(this.frG, this.frH);
        }
    }

    public void dsb() {
        if (this.frG != null && this.frH != null) {
            com.baidu.tieba.ad.download.d.bCs().b(this.frG, this.frH);
        }
    }
}
