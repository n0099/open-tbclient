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
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
/* loaded from: classes13.dex */
public class a extends e {
    private TextView cBd;
    private DownloadCacheKey ezE;
    private com.baidu.tieba.ad.download.a.d ezF;
    private HeadImageView hFh;
    private com.baidu.tieba.lego.card.c iKp;
    private CustomMessageListener ktP;
    private ApkDownloadView kuA;
    private String kww;
    private TextView kxn;
    private boolean kxo;
    protected boolean kxp;

    public a(View view, String str) {
        super(view, str);
        this.ezF = null;
        this.kxo = false;
        this.ktP = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.e.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(a.this.kww) && a.this.kww.equals(downloadData.getId())) {
                    a.this.kuA.t(downloadData);
                }
            }
        };
        init();
    }

    private void init() {
        this.hFh = (HeadImageView) BN(R.id.user_portrait);
        this.hFh.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hFh.setDefaultResource(R.drawable.icon_default_avatar100);
        this.hFh.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hFh.setIsRound(true);
        this.cBd = (TextView) BN(R.id.user_name);
        this.kxn = (TextView) BN(R.id.action);
        this.kuA = (ApkDownloadView) BN(R.id.download_view);
        MessageManager.getInstance().registerListener(this.ktP);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(AdCard.f fVar) {
        int i;
        super.a(fVar);
        this.hFh.startLoad(fVar.ksV, 10, false);
        this.cBd.setText(fVar.userName);
        this.kxn.setText(fVar.buttonText);
        this.kuA.setTextColor(am.getColor(R.color.cp_btn_a));
        if (this.kxz instanceof AdCard) {
            this.kxo = ((AdCard) this.kxz).directDownload;
        }
        if (this.kxy != null) {
            View$OnClickListenerC0660a view$OnClickListenerC0660a = new View$OnClickListenerC0660a(this.kxy);
            this.mRootView.setOnClickListener(view$OnClickListenerC0660a);
            if (cOn()) {
                this.kuA.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.e.a.1
                    @Override // com.baidu.tieba.ad.download.mvp.b.a
                    public void bq(View view) {
                    }
                });
            } else {
                this.kuA.setOnClickListener(view$OnClickListenerC0660a);
            }
            try {
                i = TextUtils.isEmpty(this.kxy.adPosition) ? 0 : Integer.valueOf(this.kxy.adPosition).intValue();
            } catch (NumberFormatException e) {
                i = 0;
            }
            this.kww = this.kxy.dmv;
            DownloadData c = c(this.kxy, i);
            o(c);
            this.kuA.setData(c);
        }
        if (!cOn()) {
            this.kuA.u(this.duK.getUniqueId());
        }
        this.ktP.setTag(this.duK.getUniqueId());
        cOo();
        onChangeSkinType();
    }

    private void o(DownloadData downloadData) {
        if (cOn()) {
            if (this.kuA != null) {
                downloadData.setStatus(this.kuA.getDownloadStatus());
                return;
            }
            return;
        }
        downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cOn() {
        return !this.kxo || this.kxp;
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        am.setViewTextColor(this.cBd, R.color.cp_cont_a, 1);
        am.setViewTextColor(this.kxn, R.color.cp_mask_c_alpha83, 1);
        am.setBackgroundColor(this.kxn, R.color.cp_link_tip_a, 1);
        this.kuA.setTextColorInitSkin(R.color.cp_cont_a);
        this.kuA.setBackgroundSkin(R.drawable.tail_frame_action_btn_bg);
        this.kuA.ckN();
    }

    public void tk(boolean z) {
        this.kxp = z;
    }

    /* renamed from: com.baidu.tieba.recapp.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    private class View$OnClickListenerC0660a implements View.OnClickListener {
        private AdvertAppInfo kwz;

        public View$OnClickListenerC0660a(AdvertAppInfo advertAppInfo) {
            this.kwz = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                a.this.duK.showToast(R.string.neterror);
                return;
            }
            boolean z = view == a.this.kuA;
            if (a.this.cOn()) {
                a.this.kuA.performClick();
            } else if (this.kwz != null) {
                int i = com.baidu.adp.lib.f.b.toInt(this.kwz.adPosition, -1);
                int status = ApkDownloadView.getStatus(a.this.c(this.kwz, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    a.this.a(this.kwz, i, a.this.kuA, z);
                } else {
                    a.this.showDownloadAppDialog(this.kwz, i, true, this.kwz.dmB != null ? this.kwz.dmB.dmN : "");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.dmv);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.dmt);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.dms, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.duK.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.aIE()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.duK.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.duK.getPageActivity());
                aVar.ui(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.e.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        a.this.d(advertAppInfo, i);
                        if (a.this.kuA != null) {
                            a.this.kuA.q(a.this.c(advertAppInfo, i));
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
                aVar.b(this.duK).aMS();
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
                    h.aM(this.duK.getPageActivity(), advertAppInfo.dmv);
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
            if (!r.aq(this.duK.getPageActivity())) {
                l.showToast(this.duK.getPageActivity(), (int) R.string.write_external_storage_permission_denied_fun_disable);
            } else if (this.iKp != null) {
                this.iKp.b(advertAppInfo, i);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        this.iKp = cVar;
    }

    private void cOo() {
        if (cOn() && this.kxy != null) {
            String str = this.kxy.dms;
            DownloadCacheKey yr = !TextUtils.isEmpty(str) ? com.baidu.tieba.ad.download.d.bgs().yr(str) : null;
            if (yr == null) {
                yr = DownloadCacheKey.create(str, this.kxy.apkUrl, this.kxy.dmv);
                com.baidu.tieba.ad.download.d.bgs().a(yr, null);
            }
            i(yr);
        }
    }

    private void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.ezE = downloadCacheKey;
            cOp();
            AdDownloadData d = com.baidu.tieba.ad.download.d.bgs().d(downloadCacheKey);
            if (d != null) {
                this.kuA.a(d.getCurrentState());
            } else {
                this.kuA.a(DownloadStatus.STATUS_NONE);
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.kuA, d, this.kxy != null ? this.kxy.page : "");
            this.ezF = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
            bgm();
        }
    }

    public void bgm() {
        if (this.ezE != null && this.ezF != null) {
            com.baidu.tieba.ad.download.d.bgs().a(this.ezE, this.ezF);
        }
    }

    public void cOp() {
        if (this.ezE != null && this.ezF != null) {
            com.baidu.tieba.ad.download.d.bgs().b(this.ezE, this.ezF);
        }
    }
}
