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
import com.baidu.tbadk.core.util.ao;
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
/* loaded from: classes20.dex */
public class a extends e {
    private TextView dKI;
    private DownloadCacheKey fdc;
    private com.baidu.tieba.ad.download.a.d fdd;
    private HeadImageView iph;
    private com.baidu.tieba.lego.card.c jzR;
    private ApkDownloadView loQ;
    private CustomMessageListener lob;
    private String lqM;
    private TextView lrD;
    private boolean lrE;
    protected boolean lrF;

    public a(View view, String str) {
        super(view, str);
        this.fdd = null;
        this.lrE = false;
        this.lob = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.e.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(a.this.lqM) && a.this.lqM.equals(downloadData.getId())) {
                    a.this.loQ.t(downloadData);
                }
            }
        };
        init();
    }

    private void init() {
        this.iph = (HeadImageView) DX(R.id.user_portrait);
        this.iph.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.iph.setDefaultResource(R.drawable.icon_default_avatar100);
        this.iph.setDefaultBgResource(R.color.cp_bg_line_e);
        this.iph.setIsRound(true);
        this.dKI = (TextView) DX(R.id.user_name);
        this.lrD = (TextView) DX(R.id.action);
        this.loQ = (ApkDownloadView) DX(R.id.download_view);
        MessageManager.getInstance().registerListener(this.lob);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(AdCard.f fVar) {
        int i;
        super.a(fVar);
        this.iph.startLoad(fVar.lnj, 10, false);
        this.dKI.setText(fVar.userName);
        this.lrD.setText(fVar.buttonText);
        this.loQ.setTextColor(ao.getColor(R.color.cp_btn_a));
        if (this.lrP instanceof AdCard) {
            this.lrE = ((AdCard) this.lrP).directDownload;
        }
        if (this.lrO != null) {
            View$OnClickListenerC0740a view$OnClickListenerC0740a = new View$OnClickListenerC0740a(this.lrO);
            this.mRootView.setOnClickListener(view$OnClickListenerC0740a);
            if (ddc()) {
                this.loQ.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.e.a.1
                    @Override // com.baidu.tieba.ad.download.mvp.b.a
                    public void bA(View view) {
                    }
                });
            } else {
                this.loQ.setOnClickListener(view$OnClickListenerC0740a);
            }
            try {
                i = TextUtils.isEmpty(this.lrO.adPosition) ? 0 : Integer.valueOf(this.lrO.adPosition).intValue();
            } catch (NumberFormatException e) {
                i = 0;
            }
            this.lqM = this.lrO.dMZ;
            DownloadData c = c(this.lrO, i);
            o(c);
            this.loQ.setData(c);
        }
        if (!ddc()) {
            this.loQ.y(this.dVN.getUniqueId());
        }
        this.lob.setTag(this.dVN.getUniqueId());
        ddd();
        onChangeSkinType();
    }

    private void o(DownloadData downloadData) {
        if (ddc()) {
            if (this.loQ != null) {
                downloadData.setStatus(this.loQ.getDownloadStatus());
                return;
            }
            return;
        }
        downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ddc() {
        return !this.lrE || this.lrF;
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ao.setViewTextColor(this.dKI, R.color.cp_cont_a, 1);
        ao.setViewTextColor(this.lrD, R.color.cp_mask_c_alpha83, 1);
        ao.setBackgroundColor(this.lrD, R.color.cp_link_tip_a, 1);
        this.loQ.setTextColorInitSkin(R.color.cp_cont_a);
        this.loQ.setBackgroundSkin(R.drawable.tail_frame_action_btn_bg);
        this.loQ.changeSkin();
    }

    public void uB(boolean z) {
        this.lrF = z;
    }

    /* renamed from: com.baidu.tieba.recapp.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    private class View$OnClickListenerC0740a implements View.OnClickListener {
        private AdvertAppInfo lqP;

        public View$OnClickListenerC0740a(AdvertAppInfo advertAppInfo) {
            this.lqP = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                a.this.dVN.showToast(R.string.neterror);
                return;
            }
            boolean z = view == a.this.loQ;
            if (a.this.ddc()) {
                a.this.loQ.performClick();
            } else if (this.lqP != null) {
                int i = com.baidu.adp.lib.f.b.toInt(this.lqP.adPosition, -1);
                int status = ApkDownloadView.getStatus(a.this.c(this.lqP, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    a.this.a(this.lqP, i, a.this.loQ, z);
                } else {
                    a.this.showDownloadAppDialog(this.lqP, i, true, this.lqP.dNf != null ? this.lqP.dNf.dNr : "");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.dMZ);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.dMX);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.dMW, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.dVN.getPageActivity(), R.string.neterror);
            } else if (advertAppInfo.aUf()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.dVN.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dVN.getPageActivity());
                aVar.xl(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.e.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        a.this.d(advertAppInfo, i);
                        if (a.this.loQ != null) {
                            a.this.loQ.q(a.this.c(advertAppInfo, i));
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
                aVar.b(this.dVN).aYL();
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
                    h.aM(this.dVN.getPageActivity(), advertAppInfo.dMZ);
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
            if (!s.ar(this.dVN.getPageActivity())) {
                l.showToast(this.dVN.getPageActivity(), R.string.write_external_storage_permission_denied_fun_disable);
            } else if (this.jzR != null) {
                this.jzR.b(advertAppInfo, i);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        this.jzR = cVar;
    }

    private void ddd() {
        if (ddc() && this.lrO != null) {
            String str = this.lrO.dMW;
            DownloadCacheKey Bb = !TextUtils.isEmpty(str) ? com.baidu.tieba.ad.download.d.bsi().Bb(str) : null;
            if (Bb == null) {
                Bb = DownloadCacheKey.create(str, this.lrO.apkUrl, this.lrO.dMZ);
                com.baidu.tieba.ad.download.d.bsi().a(Bb, null);
            }
            i(Bb);
        }
    }

    private void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.fdc = downloadCacheKey;
            dde();
            AdDownloadData d = com.baidu.tieba.ad.download.d.bsi().d(downloadCacheKey);
            if (d != null) {
                this.loQ.a(d.getCurrentState());
            } else {
                this.loQ.a(DownloadStatus.STATUS_NONE);
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.loQ, d, this.lrO != null ? this.lrO.page : "");
            this.fdd = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
            bsb();
        }
    }

    public void bsb() {
        if (this.fdc != null && this.fdd != null) {
            com.baidu.tieba.ad.download.d.bsi().a(this.fdc, this.fdd);
        }
    }

    public void dde() {
        if (this.fdc != null && this.fdd != null) {
            com.baidu.tieba.ad.download.d.bsi().b(this.fdc, this.fdd);
        }
    }
}
