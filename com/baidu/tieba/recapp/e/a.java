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
/* loaded from: classes11.dex */
public class a extends e {
    private TextView bXF;
    private DownloadCacheKey dUU;
    private com.baidu.tieba.ad.download.a.d dUV;
    private HeadImageView gRP;
    private com.baidu.tieba.lego.card.c hWF;
    private CustomMessageListener jHp;
    private ApkDownloadView jIa;
    private String jKq;
    private TextView jLd;
    private boolean jLe;
    protected boolean jLf;

    public a(View view, String str) {
        super(view, str);
        this.dUV = null;
        this.jLe = false;
        this.jHp = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.e.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(a.this.jKq) && a.this.jKq.equals(downloadData.getId())) {
                    a.this.jIa.t(downloadData);
                }
            }
        };
        init();
    }

    private void init() {
        this.gRP = (HeadImageView) AW(R.id.user_portrait);
        this.gRP.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gRP.setDefaultResource(R.drawable.icon_default_avatar100);
        this.gRP.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gRP.setIsRound(true);
        this.bXF = (TextView) AW(R.id.user_name);
        this.jLd = (TextView) AW(R.id.action);
        this.jIa = (ApkDownloadView) AW(R.id.download_view);
        MessageManager.getInstance().registerListener(this.jHp);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(AdCard.f fVar) {
        super.a(fVar);
        this.gRP.startLoad(fVar.jGB, 10, false);
        this.bXF.setText(fVar.userName);
        this.jLd.setText(fVar.buttonText);
        this.jIa.setTextColor(am.getColor(R.color.cp_btn_a));
        if (this.jLp instanceof AdCard) {
            this.jLe = ((AdCard) this.jLp).directDownload;
        }
        if (this.jLo != null) {
            View$OnClickListenerC0590a view$OnClickListenerC0590a = new View$OnClickListenerC0590a(this.jLo);
            this.mRootView.setOnClickListener(view$OnClickListenerC0590a);
            if (cBV()) {
                this.jIa.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.e.a.1
                    @Override // com.baidu.tieba.ad.download.mvp.b.a
                    public void bp(View view) {
                    }
                });
            } else {
                this.jIa.setOnClickListener(view$OnClickListenerC0590a);
            }
            int intValue = Integer.valueOf(this.jLo.adPosition).intValue();
            this.jKq = this.jLo.cIV;
            DownloadData c = c(this.jLo, intValue);
            o(c);
            this.jIa.setData(c);
        }
        if (!cBV()) {
            this.jIa.u(this.cRe.getUniqueId());
        }
        this.jHp.setTag(this.cRe.getUniqueId());
        cBW();
        onChangeSkinType();
    }

    private void o(DownloadData downloadData) {
        if (cBV()) {
            if (this.jIa != null) {
                downloadData.setStatus(this.jIa.getDownloadStatus());
                return;
            }
            return;
        }
        downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cBV() {
        return !this.jLe || this.jLf;
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        am.setViewTextColor(this.bXF, R.color.cp_cont_a, 1);
        am.setViewTextColor(this.jLd, R.color.cp_mask_c_alpha83, 1);
        am.setBackgroundColor(this.jLd, R.color.cp_link_tip_a, 1);
        this.jIa.setTextColorInitSkin(R.color.cp_cont_a);
        this.jIa.setBackgroundSkin(R.drawable.tail_frame_action_btn_bg);
        this.jIa.bFO();
    }

    public void sa(boolean z) {
        this.jLf = z;
    }

    /* renamed from: com.baidu.tieba.recapp.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class View$OnClickListenerC0590a implements View.OnClickListener {
        private AdvertAppInfo jKt;

        public View$OnClickListenerC0590a(AdvertAppInfo advertAppInfo) {
            this.jKt = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                a.this.cRe.showToast(R.string.neterror);
                return;
            }
            boolean z = view == a.this.jIa;
            if (a.this.cBV()) {
                a.this.jIa.performClick();
            } else if (this.jKt != null) {
                int i = com.baidu.adp.lib.f.b.toInt(this.jKt.adPosition, -1);
                int status = ApkDownloadView.getStatus(a.this.c(this.jKt, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    a.this.a(this.jKt, i, a.this.jIa, z);
                } else {
                    a.this.showDownloadAppDialog(this.jKt, i, true, this.jKt.cJb != null ? this.jKt.cJb.cJn : "");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.cIV);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.cIT);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.cIS, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.cRe.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.aya()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.cRe.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cRe.getPageActivity());
                aVar.sC(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.e.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        a.this.d(advertAppInfo, i);
                        if (a.this.jIa != null) {
                            a.this.jIa.q(a.this.c(advertAppInfo, i));
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
                aVar.b(this.cRe).aCp();
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
                    h.bd(this.cRe.getPageActivity(), advertAppInfo.cIV);
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
            if (!s.ar(this.cRe.getPageActivity())) {
                l.showToast(this.cRe.getPageActivity(), (int) R.string.write_external_storage_permission_denied_fun_disable);
            } else if (this.hWF != null) {
                this.hWF.b(advertAppInfo, i);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        this.hWF = cVar;
    }

    private void cBW() {
        if (cBV() && this.jLo != null) {
            String str = this.jLo.cIS;
            DownloadCacheKey wG = !TextUtils.isEmpty(str) ? com.baidu.tieba.ad.download.d.aVT().wG(str) : null;
            if (wG == null) {
                wG = DownloadCacheKey.create(str, this.jLo.apkUrl, this.jLo.cIV);
                com.baidu.tieba.ad.download.d.aVT().a(wG, null);
            }
            i(wG);
        }
    }

    private void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.dUU = downloadCacheKey;
            cBX();
            AdDownloadData d = com.baidu.tieba.ad.download.d.aVT().d(downloadCacheKey);
            if (d != null) {
                this.jIa.a(d.getCurrentState());
            } else {
                this.jIa.a(DownloadStatus.STATUS_NONE);
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.jIa, d, this.jLo != null ? this.jLo.page : "");
            this.dUV = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
            aVN();
        }
    }

    public void aVN() {
        if (this.dUU != null && this.dUV != null) {
            com.baidu.tieba.ad.download.d.aVT().a(this.dUU, this.dUV);
        }
    }

    public void cBX() {
        if (this.dUU != null && this.dUV != null) {
            com.baidu.tieba.ad.download.d.aVT().b(this.dUU, this.dUV);
        }
    }
}
