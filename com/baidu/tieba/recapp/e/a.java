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
/* loaded from: classes10.dex */
public class a extends e {
    private TextView bXt;
    private DownloadCacheKey dUL;
    private com.baidu.tieba.ad.download.a.d dUM;
    private HeadImageView gOv;
    private com.baidu.tieba.lego.card.c hTb;
    private CustomMessageListener jDI;
    private ApkDownloadView jEt;
    private String jGJ;
    private TextView jHw;
    private boolean jHx;
    protected boolean jHy;

    public a(View view, String str) {
        super(view, str);
        this.dUM = null;
        this.jHx = false;
        this.jDI = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.e.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(a.this.jGJ) && a.this.jGJ.equals(downloadData.getId())) {
                    a.this.jEt.t(downloadData);
                }
            }
        };
        init();
    }

    private void init() {
        this.gOv = (HeadImageView) AR(R.id.user_portrait);
        this.gOv.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gOv.setDefaultResource(R.drawable.icon_default_avatar100);
        this.gOv.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gOv.setIsRound(true);
        this.bXt = (TextView) AR(R.id.user_name);
        this.jHw = (TextView) AR(R.id.action);
        this.jEt = (ApkDownloadView) AR(R.id.download_view);
        MessageManager.getInstance().registerListener(this.jDI);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(AdCard.f fVar) {
        super.a(fVar);
        this.gOv.startLoad(fVar.jCU, 10, false);
        this.bXt.setText(fVar.userName);
        this.jHw.setText(fVar.buttonText);
        this.jEt.setTextColor(am.getColor(R.color.cp_btn_a));
        if (this.jHI instanceof AdCard) {
            this.jHx = ((AdCard) this.jHI).directDownload;
        }
        if (this.jHH != null) {
            View$OnClickListenerC0585a view$OnClickListenerC0585a = new View$OnClickListenerC0585a(this.jHH);
            this.mRootView.setOnClickListener(view$OnClickListenerC0585a);
            if (cAN()) {
                this.jEt.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.e.a.1
                    @Override // com.baidu.tieba.ad.download.mvp.b.a
                    public void bl(View view) {
                    }
                });
            } else {
                this.jEt.setOnClickListener(view$OnClickListenerC0585a);
            }
            int intValue = Integer.valueOf(this.jHH.adPosition).intValue();
            this.jGJ = this.jHH.cIK;
            DownloadData c = c(this.jHH, intValue);
            o(c);
            this.jEt.setData(c);
        }
        if (!cAN()) {
            this.jEt.u(this.cQU.getUniqueId());
        }
        this.jDI.setTag(this.cQU.getUniqueId());
        cAO();
        onChangeSkinType();
    }

    private void o(DownloadData downloadData) {
        if (cAN()) {
            if (this.jEt != null) {
                downloadData.setStatus(this.jEt.getDownloadStatus());
                return;
            }
            return;
        }
        downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cAN() {
        return !this.jHx || this.jHy;
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        am.setViewTextColor(this.bXt, R.color.cp_cont_a, 1);
        am.setViewTextColor(this.jHw, R.color.cp_mask_c_alpha83, 1);
        am.setBackgroundColor(this.jHw, R.color.cp_link_tip_a, 1);
        this.jEt.setTextColorInitSkin(R.color.cp_cont_a);
        this.jEt.setBackgroundSkin(R.drawable.tail_frame_action_btn_bg);
        this.jEt.bEM();
    }

    public void rO(boolean z) {
        this.jHy = z;
    }

    /* renamed from: com.baidu.tieba.recapp.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private class View$OnClickListenerC0585a implements View.OnClickListener {
        private AdvertAppInfo jGM;

        public View$OnClickListenerC0585a(AdvertAppInfo advertAppInfo) {
            this.jGM = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                a.this.cQU.showToast(R.string.neterror);
                return;
            }
            boolean z = view == a.this.jEt;
            if (a.this.cAN()) {
                a.this.jEt.performClick();
            } else if (this.jGM != null) {
                int i = com.baidu.adp.lib.f.b.toInt(this.jGM.adPosition, -1);
                int status = ApkDownloadView.getStatus(a.this.c(this.jGM, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    a.this.a(this.jGM, i, a.this.jEt, z);
                } else {
                    a.this.showDownloadAppDialog(this.jGM, i, true, this.jGM.cIQ != null ? this.jGM.cIQ.cJc : "");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.cIK);
        downloadData.setUrl(advertAppInfo.cIJ);
        downloadData.setName(advertAppInfo.cIH);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.cIG, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.cQU.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.axH()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.cQU.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cQU.getPageActivity());
                aVar.sz(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.e.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        a.this.d(advertAppInfo, i);
                        if (a.this.jEt != null) {
                            a.this.jEt.q(a.this.c(advertAppInfo, i));
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
                aVar.b(this.cQU).aBW();
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
                    h.bc(this.cQU.getPageActivity(), advertAppInfo.cIK);
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
            if (!s.aq(this.cQU.getPageActivity())) {
                l.showToast(this.cQU.getPageActivity(), (int) R.string.write_external_storage_permission_denied_fun_disable);
            } else if (this.hTb != null) {
                this.hTb.b(advertAppInfo, i);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        this.hTb = cVar;
    }

    private void cAO() {
        if (cAN() && this.jHH != null) {
            String str = this.jHH.cIG;
            DownloadCacheKey wC = !TextUtils.isEmpty(str) ? com.baidu.tieba.ad.download.d.aVA().wC(str) : null;
            if (wC == null) {
                wC = DownloadCacheKey.create(str, this.jHH.cIJ, this.jHH.cIK);
                com.baidu.tieba.ad.download.d.aVA().a(wC, null);
            }
            i(wC);
        }
    }

    private void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.dUL = downloadCacheKey;
            cAP();
            AdDownloadData d = com.baidu.tieba.ad.download.d.aVA().d(downloadCacheKey);
            if (d != null) {
                this.jEt.a(d.getCurrentState());
            } else {
                this.jEt.a(DownloadStatus.STATUS_NONE);
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.jEt, d, this.jHH != null ? this.jHH.page : "");
            this.dUM = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
            aVu();
        }
    }

    public void aVu() {
        if (this.dUL != null && this.dUM != null) {
            com.baidu.tieba.ad.download.d.aVA().a(this.dUL, this.dUM);
        }
    }

    public void cAP() {
        if (this.dUL != null && this.dUM != null) {
            com.baidu.tieba.ad.download.d.aVA().b(this.dUL, this.dUM);
        }
    }
}
