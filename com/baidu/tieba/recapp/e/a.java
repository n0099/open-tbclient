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
    private TextView cbK;
    private DownloadCacheKey dYZ;
    private com.baidu.tieba.ad.download.a.d dZa;
    private HeadImageView gTR;
    private com.baidu.tieba.lego.card.c hYF;
    private ApkDownloadView jIY;
    private CustomMessageListener jIn;
    private String jLo;
    private TextView jMb;
    private boolean jMc;
    protected boolean jMd;

    public a(View view, String str) {
        super(view, str);
        this.dZa = null;
        this.jMc = false;
        this.jIn = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.e.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(a.this.jLo) && a.this.jLo.equals(downloadData.getId())) {
                    a.this.jIY.t(downloadData);
                }
            }
        };
        init();
    }

    private void init() {
        this.gTR = (HeadImageView) Bf(R.id.user_portrait);
        this.gTR.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gTR.setDefaultResource(R.drawable.icon_default_avatar100);
        this.gTR.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gTR.setIsRound(true);
        this.cbK = (TextView) Bf(R.id.user_name);
        this.jMb = (TextView) Bf(R.id.action);
        this.jIY = (ApkDownloadView) Bf(R.id.download_view);
        MessageManager.getInstance().registerListener(this.jIn);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(AdCard.f fVar) {
        super.a(fVar);
        this.gTR.startLoad(fVar.jHu, 10, false);
        this.cbK.setText(fVar.userName);
        this.jMb.setText(fVar.buttonText);
        this.jIY.setTextColor(am.getColor(R.color.cp_btn_a));
        if (this.jMn instanceof AdCard) {
            this.jMc = ((AdCard) this.jMn).directDownload;
        }
        if (this.jMm != null) {
            View$OnClickListenerC0598a view$OnClickListenerC0598a = new View$OnClickListenerC0598a(this.jMm);
            this.mRootView.setOnClickListener(view$OnClickListenerC0598a);
            if (cDt()) {
                this.jIY.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.e.a.1
                    @Override // com.baidu.tieba.ad.download.mvp.b.a
                    public void bp(View view) {
                    }
                });
            } else {
                this.jIY.setOnClickListener(view$OnClickListenerC0598a);
            }
            int intValue = Integer.valueOf(this.jMm.adPosition).intValue();
            this.jLo = this.jMm.cMZ;
            DownloadData c = c(this.jMm, intValue);
            o(c);
            this.jIY.setData(c);
        }
        if (!cDt()) {
            this.jIY.u(this.cVh.getUniqueId());
        }
        this.jIn.setTag(this.cVh.getUniqueId());
        cDu();
        onChangeSkinType();
    }

    private void o(DownloadData downloadData) {
        if (cDt()) {
            if (this.jIY != null) {
                downloadData.setStatus(this.jIY.getDownloadStatus());
                return;
            }
            return;
        }
        downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cDt() {
        return !this.jMc || this.jMd;
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        am.setViewTextColor(this.cbK, R.color.cp_cont_a, 1);
        am.setViewTextColor(this.jMb, R.color.cp_mask_c_alpha83, 1);
        am.setBackgroundColor(this.jMb, R.color.cp_link_tip_a, 1);
        this.jIY.setTextColorInitSkin(R.color.cp_cont_a);
        this.jIY.setBackgroundSkin(R.drawable.tail_frame_action_btn_bg);
        this.jIY.bHs();
    }

    public void sd(boolean z) {
        this.jMd = z;
    }

    /* renamed from: com.baidu.tieba.recapp.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    private class View$OnClickListenerC0598a implements View.OnClickListener {
        private AdvertAppInfo jLr;

        public View$OnClickListenerC0598a(AdvertAppInfo advertAppInfo) {
            this.jLr = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                a.this.cVh.showToast(R.string.neterror);
                return;
            }
            boolean z = view == a.this.jIY;
            if (a.this.cDt()) {
                a.this.jIY.performClick();
            } else if (this.jLr != null) {
                int i = com.baidu.adp.lib.f.b.toInt(this.jLr.adPosition, -1);
                int status = ApkDownloadView.getStatus(a.this.c(this.jLr, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    a.this.a(this.jLr, i, a.this.jIY, z);
                } else {
                    a.this.showDownloadAppDialog(this.jLr, i, true, this.jLr.cNf != null ? this.jLr.cNf.cNr : "");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.cMZ);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.cMX);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.cMW, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.cVh.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.aAq()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.cVh.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cVh.getPageActivity());
                aVar.sS(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.e.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        a.this.d(advertAppInfo, i);
                        if (a.this.jIY != null) {
                            a.this.jIY.q(a.this.c(advertAppInfo, i));
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
                aVar.b(this.cVh).aEC();
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
                    h.bd(this.cVh.getPageActivity(), advertAppInfo.cMZ);
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
            if (!s.as(this.cVh.getPageActivity())) {
                l.showToast(this.cVh.getPageActivity(), (int) R.string.write_external_storage_permission_denied_fun_disable);
            } else if (this.hYF != null) {
                this.hYF.b(advertAppInfo, i);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        this.hYF = cVar;
    }

    private void cDu() {
        if (cDt() && this.jMm != null) {
            String str = this.jMm.cMW;
            DownloadCacheKey xa = !TextUtils.isEmpty(str) ? com.baidu.tieba.ad.download.d.aYk().xa(str) : null;
            if (xa == null) {
                xa = DownloadCacheKey.create(str, this.jMm.apkUrl, this.jMm.cMZ);
                com.baidu.tieba.ad.download.d.aYk().a(xa, null);
            }
            i(xa);
        }
    }

    private void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.dYZ = downloadCacheKey;
            cDv();
            AdDownloadData d = com.baidu.tieba.ad.download.d.aYk().d(downloadCacheKey);
            if (d != null) {
                this.jIY.a(d.getCurrentState());
            } else {
                this.jIY.a(DownloadStatus.STATUS_NONE);
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.jIY, d, this.jMm != null ? this.jMm.page : "");
            this.dZa = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
            aYe();
        }
    }

    public void aYe() {
        if (this.dYZ != null && this.dZa != null) {
            com.baidu.tieba.ad.download.d.aYk().a(this.dYZ, this.dZa);
        }
    }

    public void cDv() {
        if (this.dYZ != null && this.dZa != null) {
            com.baidu.tieba.ad.download.d.aYk().b(this.dYZ, this.dZa);
        }
    }
}
