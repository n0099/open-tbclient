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
    private TextView cAX;
    private com.baidu.tieba.ad.download.a.d ezA;
    private DownloadCacheKey ezz;
    private HeadImageView hFb;
    private com.baidu.tieba.lego.card.c iKl;
    private CustomMessageListener ktL;
    private ApkDownloadView kuw;
    private String kws;
    private TextView kxj;
    private boolean kxk;
    protected boolean kxl;

    public a(View view, String str) {
        super(view, str);
        this.ezA = null;
        this.kxk = false;
        this.ktL = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.e.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(a.this.kws) && a.this.kws.equals(downloadData.getId())) {
                    a.this.kuw.t(downloadData);
                }
            }
        };
        init();
    }

    private void init() {
        this.hFb = (HeadImageView) BN(R.id.user_portrait);
        this.hFb.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hFb.setDefaultResource(R.drawable.icon_default_avatar100);
        this.hFb.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hFb.setIsRound(true);
        this.cAX = (TextView) BN(R.id.user_name);
        this.kxj = (TextView) BN(R.id.action);
        this.kuw = (ApkDownloadView) BN(R.id.download_view);
        MessageManager.getInstance().registerListener(this.ktL);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(AdCard.f fVar) {
        int i;
        super.a(fVar);
        this.hFb.startLoad(fVar.ksR, 10, false);
        this.cAX.setText(fVar.userName);
        this.kxj.setText(fVar.buttonText);
        this.kuw.setTextColor(am.getColor(R.color.cp_btn_a));
        if (this.kxv instanceof AdCard) {
            this.kxk = ((AdCard) this.kxv).directDownload;
        }
        if (this.kxu != null) {
            View$OnClickListenerC0639a view$OnClickListenerC0639a = new View$OnClickListenerC0639a(this.kxu);
            this.mRootView.setOnClickListener(view$OnClickListenerC0639a);
            if (cOp()) {
                this.kuw.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.e.a.1
                    @Override // com.baidu.tieba.ad.download.mvp.b.a
                    public void bq(View view) {
                    }
                });
            } else {
                this.kuw.setOnClickListener(view$OnClickListenerC0639a);
            }
            try {
                i = TextUtils.isEmpty(this.kxu.adPosition) ? 0 : Integer.valueOf(this.kxu.adPosition).intValue();
            } catch (NumberFormatException e) {
                i = 0;
            }
            this.kws = this.kxu.dmr;
            DownloadData c = c(this.kxu, i);
            o(c);
            this.kuw.setData(c);
        }
        if (!cOp()) {
            this.kuw.u(this.duG.getUniqueId());
        }
        this.ktL.setTag(this.duG.getUniqueId());
        cOq();
        onChangeSkinType();
    }

    private void o(DownloadData downloadData) {
        if (cOp()) {
            if (this.kuw != null) {
                downloadData.setStatus(this.kuw.getDownloadStatus());
                return;
            }
            return;
        }
        downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cOp() {
        return !this.kxk || this.kxl;
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        am.setViewTextColor(this.cAX, R.color.cp_cont_a, 1);
        am.setViewTextColor(this.kxj, R.color.cp_mask_c_alpha83, 1);
        am.setBackgroundColor(this.kxj, R.color.cp_link_tip_a, 1);
        this.kuw.setTextColorInitSkin(R.color.cp_cont_a);
        this.kuw.setBackgroundSkin(R.drawable.tail_frame_action_btn_bg);
        this.kuw.ckO();
    }

    public void tk(boolean z) {
        this.kxl = z;
    }

    /* renamed from: com.baidu.tieba.recapp.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    private class View$OnClickListenerC0639a implements View.OnClickListener {
        private AdvertAppInfo kwv;

        public View$OnClickListenerC0639a(AdvertAppInfo advertAppInfo) {
            this.kwv = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                a.this.duG.showToast(R.string.neterror);
                return;
            }
            boolean z = view == a.this.kuw;
            if (a.this.cOp()) {
                a.this.kuw.performClick();
            } else if (this.kwv != null) {
                int i = com.baidu.adp.lib.f.b.toInt(this.kwv.adPosition, -1);
                int status = ApkDownloadView.getStatus(a.this.c(this.kwv, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    a.this.a(this.kwv, i, a.this.kuw, z);
                } else {
                    a.this.showDownloadAppDialog(this.kwv, i, true, this.kwv.dmx != null ? this.kwv.dmx.dmJ : "");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.dmr);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.dmp);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.dmo, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.duG.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.aIG()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.duG.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.duG.getPageActivity());
                aVar.uf(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.e.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        a.this.d(advertAppInfo, i);
                        if (a.this.kuw != null) {
                            a.this.kuw.q(a.this.c(advertAppInfo, i));
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
                aVar.b(this.duG).aMU();
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
                    h.aY(this.duG.getPageActivity(), advertAppInfo.dmr);
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
            if (!r.aq(this.duG.getPageActivity())) {
                l.showToast(this.duG.getPageActivity(), (int) R.string.write_external_storage_permission_denied_fun_disable);
            } else if (this.iKl != null) {
                this.iKl.b(advertAppInfo, i);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        this.iKl = cVar;
    }

    private void cOq() {
        if (cOp() && this.kxu != null) {
            String str = this.kxu.dmo;
            DownloadCacheKey yo = !TextUtils.isEmpty(str) ? com.baidu.tieba.ad.download.d.bgu().yo(str) : null;
            if (yo == null) {
                yo = DownloadCacheKey.create(str, this.kxu.apkUrl, this.kxu.dmr);
                com.baidu.tieba.ad.download.d.bgu().a(yo, null);
            }
            i(yo);
        }
    }

    private void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.ezz = downloadCacheKey;
            cOr();
            AdDownloadData d = com.baidu.tieba.ad.download.d.bgu().d(downloadCacheKey);
            if (d != null) {
                this.kuw.a(d.getCurrentState());
            } else {
                this.kuw.a(DownloadStatus.STATUS_NONE);
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.kuw, d, this.kxu != null ? this.kxu.page : "");
            this.ezA = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
            bgo();
        }
    }

    public void bgo() {
        if (this.ezz != null && this.ezA != null) {
            com.baidu.tieba.ad.download.d.bgu().a(this.ezz, this.ezA);
        }
    }

    public void cOr() {
        if (this.ezz != null && this.ezA != null) {
            com.baidu.tieba.ad.download.d.bgu().b(this.ezz, this.ezA);
        }
    }
}
