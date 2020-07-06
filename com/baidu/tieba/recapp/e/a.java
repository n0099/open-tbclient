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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.mvp.b;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.tieba.recapp.download.h;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
/* loaded from: classes13.dex */
public class a extends e {
    private TextView dEL;
    private DownloadCacheKey eYA;
    private com.baidu.tieba.ad.download.a.d eYB;
    private HeadImageView ijb;
    private com.baidu.tieba.lego.card.c jrm;
    private CustomMessageListener lgK;
    private ApkDownloadView lhv;
    private String ljr;
    private TextView lki;
    private boolean lkj;
    protected boolean lkk;

    public a(View view, String str) {
        super(view, str);
        this.eYB = null;
        this.lkj = false;
        this.lgK = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.e.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(a.this.ljr) && a.this.ljr.equals(downloadData.getId())) {
                    a.this.lhv.t(downloadData);
                }
            }
        };
        init();
    }

    private void init() {
        this.ijb = (HeadImageView) DB(R.id.user_portrait);
        this.ijb.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.ijb.setDefaultResource(R.drawable.icon_default_avatar100);
        this.ijb.setDefaultBgResource(R.color.cp_bg_line_e);
        this.ijb.setIsRound(true);
        this.dEL = (TextView) DB(R.id.user_name);
        this.lki = (TextView) DB(R.id.action);
        this.lhv = (ApkDownloadView) DB(R.id.download_view);
        MessageManager.getInstance().registerListener(this.lgK);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(AdCard.f fVar) {
        int i;
        super.a(fVar);
        this.ijb.startLoad(fVar.lfS, 10, false);
        this.dEL.setText(fVar.userName);
        this.lki.setText(fVar.buttonText);
        this.lhv.setTextColor(an.getColor(R.color.cp_btn_a));
        if (this.lku instanceof AdCard) {
            this.lkj = ((AdCard) this.lku).directDownload;
        }
        if (this.lkt != null) {
            View$OnClickListenerC0730a view$OnClickListenerC0730a = new View$OnClickListenerC0730a(this.lkt);
            this.mRootView.setOnClickListener(view$OnClickListenerC0730a);
            if (cZV()) {
                this.lhv.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.e.a.1
                    @Override // com.baidu.tieba.ad.download.mvp.b.a
                    public void bu(View view) {
                    }
                });
            } else {
                this.lhv.setOnClickListener(view$OnClickListenerC0730a);
            }
            try {
                i = TextUtils.isEmpty(this.lkt.adPosition) ? 0 : Integer.valueOf(this.lkt.adPosition).intValue();
            } catch (NumberFormatException e) {
                i = 0;
            }
            this.ljr = this.lkt.dGO;
            DownloadData c = c(this.lkt, i);
            o(c);
            this.lhv.setData(c);
        }
        if (!cZV()) {
            this.lhv.x(this.dPv.getUniqueId());
        }
        this.lgK.setTag(this.dPv.getUniqueId());
        cZW();
        onChangeSkinType();
    }

    private void o(DownloadData downloadData) {
        if (cZV()) {
            if (this.lhv != null) {
                downloadData.setStatus(this.lhv.getDownloadStatus());
                return;
            }
            return;
        }
        downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cZV() {
        return !this.lkj || this.lkk;
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        an.setViewTextColor(this.dEL, R.color.cp_cont_a, 1);
        an.setViewTextColor(this.lki, R.color.cp_mask_c_alpha83, 1);
        an.setBackgroundColor(this.lki, R.color.cp_link_tip_a, 1);
        this.lhv.setTextColorInitSkin(R.color.cp_cont_a);
        this.lhv.setBackgroundSkin(R.drawable.tail_frame_action_btn_bg);
        this.lhv.aYi();
    }

    public void tX(boolean z) {
        this.lkk = z;
    }

    /* renamed from: com.baidu.tieba.recapp.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    private class View$OnClickListenerC0730a implements View.OnClickListener {
        private AdvertAppInfo lju;

        public View$OnClickListenerC0730a(AdvertAppInfo advertAppInfo) {
            this.lju = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                a.this.dPv.showToast(R.string.neterror);
                return;
            }
            boolean z = view == a.this.lhv;
            if (a.this.cZV()) {
                a.this.lhv.performClick();
            } else if (this.lju != null) {
                int i = com.baidu.adp.lib.f.b.toInt(this.lju.adPosition, -1);
                int status = ApkDownloadView.getStatus(a.this.c(this.lju, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    a.this.a(this.lju, i, a.this.lhv, z);
                } else {
                    a.this.showDownloadAppDialog(this.lju, i, true, this.lju.dGU != null ? this.lju.dGU.dHg : "");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.dGO);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.dGM);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.dGL, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.dPv.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.aQj()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.dPv.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dPv.getPageActivity());
                aVar.we(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.e.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        a.this.d(advertAppInfo, i);
                        if (a.this.lhv != null) {
                            a.this.lhv.q(a.this.c(advertAppInfo, i));
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
                aVar.b(this.dPv).aUN();
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
                    h.aN(this.dPv.getPageActivity(), advertAppInfo.dGO);
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
            if (!r.aq(this.dPv.getPageActivity())) {
                l.showToast(this.dPv.getPageActivity(), (int) R.string.write_external_storage_permission_denied_fun_disable);
            } else if (this.jrm != null) {
                this.jrm.b(advertAppInfo, i);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        this.jrm = cVar;
    }

    private void cZW() {
        if (cZV() && this.lkt != null) {
            String str = this.lkt.dGL;
            DownloadCacheKey Aq = !TextUtils.isEmpty(str) ? com.baidu.tieba.ad.download.d.bpg().Aq(str) : null;
            if (Aq == null) {
                Aq = DownloadCacheKey.create(str, this.lkt.apkUrl, this.lkt.dGO);
                com.baidu.tieba.ad.download.d.bpg().a(Aq, null);
            }
            i(Aq);
        }
    }

    private void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.eYA = downloadCacheKey;
            cZX();
            AdDownloadData d = com.baidu.tieba.ad.download.d.bpg().d(downloadCacheKey);
            if (d != null) {
                this.lhv.a(d.getCurrentState());
            } else {
                this.lhv.a(DownloadStatus.STATUS_NONE);
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.lhv, d, this.lkt != null ? this.lkt.page : "");
            this.eYB = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
            boZ();
        }
    }

    public void boZ() {
        if (this.eYA != null && this.eYB != null) {
            com.baidu.tieba.ad.download.d.bpg().a(this.eYA, this.eYB);
        }
    }

    public void cZX() {
        if (this.eYA != null && this.eYB != null) {
            com.baidu.tieba.ad.download.d.bpg().b(this.eYA, this.eYB);
        }
    }
}
