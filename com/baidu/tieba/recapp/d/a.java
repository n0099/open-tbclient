package com.baidu.tieba.recapp.d;

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
import com.baidu.tbadk.core.TbadkCoreApplication;
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
import com.baidu.tieba.recapp.t;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
/* loaded from: classes8.dex */
public class a extends e {
    private TextView eIO;
    private DownloadCacheKey ggV;
    private com.baidu.tieba.ad.download.a.d ggW;
    private HeadImageView jWI;
    private com.baidu.tieba.lego.card.c lcB;
    private CustomMessageListener mUs;
    private ApkDownloadView mXk;
    private String mXl;
    private TextView mYa;
    private boolean mYb;
    protected boolean mYc;

    public a(View view, String str) {
        super(view, str);
        this.ggW = null;
        this.mYb = false;
        this.mUs = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.d.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(a.this.mXl) && a.this.mXl.equals(downloadData.getId())) {
                    a.this.mXk.s(downloadData);
                }
            }
        };
        init();
    }

    private void init() {
        this.jWI = (HeadImageView) Id(R.id.user_portrait);
        this.jWI.setDefaultResource(R.drawable.icon_default_avatar100);
        this.jWI.setDefaultBgResource(R.color.CAM_X0205);
        this.jWI.setIsRound(true);
        this.eIO = (TextView) Id(R.id.user_name);
        this.mYa = (TextView) Id(R.id.action);
        this.mXk = (ApkDownloadView) Id(R.id.download_view);
        MessageManager.getInstance().registerListener(this.mUs);
    }

    @Override // com.baidu.tieba.recapp.d.e
    public void a(AdCard.f fVar) {
        int i;
        super.a(fVar);
        this.jWI.startLoad(fVar.mTv, 10, false);
        this.eIO.setText(fVar.userName);
        this.mYa.setText(fVar.buttonText);
        this.mXk.setTextColor(ap.getColor(R.color.CAM_X0901));
        if (this.mYm instanceof AdCard) {
            this.mYb = ((AdCard) this.mYm).directDownload;
        }
        if (this.mYl != null) {
            View$OnClickListenerC0857a view$OnClickListenerC0857a = new View$OnClickListenerC0857a(this.mYl);
            this.mRootView.setOnClickListener(view$OnClickListenerC0857a);
            if (dEy()) {
                this.mXk.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.d.a.1
                    @Override // com.baidu.tieba.ad.download.mvp.b.a
                    public boolean ce(View view) {
                        return false;
                    }
                });
            } else {
                this.mXk.setOnClickListener(view$OnClickListenerC0857a);
            }
            try {
                i = TextUtils.isEmpty(this.mYl.adPosition) ? 0 : Integer.valueOf(this.mYl.adPosition).intValue();
            } catch (NumberFormatException e) {
                i = 0;
            }
            this.mXl = this.mYl.eLw;
            DownloadData d = d(this.mYl, i);
            n(d);
            this.mXk.setData(d);
        }
        if (!dEy()) {
            this.mXk.y(this.eUY.getUniqueId());
        }
        this.mUs.setTag(this.eUY.getUniqueId());
        dEz();
        onChangeSkinType();
    }

    private void n(DownloadData downloadData) {
        if (dEy()) {
            if (this.mXk != null) {
                downloadData.setStatus(this.mXk.getDownloadStatus());
                return;
            }
            return;
        }
        downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dEy() {
        return !this.mYb || this.mYc;
    }

    @Override // com.baidu.tieba.recapp.d.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ap.setViewTextColor(this.eIO, R.color.CAM_X0101, 1);
        ap.setViewTextColor(this.mYa, R.color.CAM_X0620, 1);
        ap.setBackgroundResource(this.mYa, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
        this.mXk.setTextColorInitSkin(R.color.CAM_X0101);
        this.mXk.setBackgroundSkin(R.drawable.tail_frame_action_btn_bg);
        this.mXk.buo();
    }

    public void xC(boolean z) {
        this.mYc = z;
    }

    /* renamed from: com.baidu.tieba.recapp.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private class View$OnClickListenerC0857a implements View.OnClickListener {
        private AdvertAppInfo mXo;

        public View$OnClickListenerC0857a(AdvertAppInfo advertAppInfo) {
            this.mXo = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                a.this.eUY.showToast(R.string.neterror);
                return;
            }
            boolean z = view == a.this.mXk;
            com.baidu.tieba.lego.card.a.c.a(a.this.mYm);
            if (a.this.dEy()) {
                a.this.mXk.performClick();
            } else if (this.mXo != null) {
                int i = com.baidu.adp.lib.f.b.toInt(this.mXo.adPosition, -1);
                int status = ApkDownloadView.getStatus(a.this.d(this.mXo, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    a.this.a(this.mXo, i, a.this.mXk, z);
                } else {
                    a.this.showDownloadAppDialog(this.mXo, i, true, this.mXo.eLC != null ? this.mXo.eLC.eLQ : "");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData d(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.eLw != null ? advertAppInfo.eLw : advertAppInfo.eLt);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.eLu);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.eLt, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.eUY.getPageActivity(), R.string.neterror);
            } else if (advertAppInfo.blE()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.eUY.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eUY.getPageActivity());
                aVar.Au(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.d.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        a.this.e(advertAppInfo, i);
                        if (a.this.mXk != null) {
                            a.this.mXk.p(a.this.d(advertAppInfo, i));
                        }
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.recapp.d.a.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.eUY).bqx();
            }
        }
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView, boolean z) {
        if (advertAppInfo != null) {
            DownloadData d = d(advertAppInfo, i);
            int status = ApkDownloadView.getStatus(d);
            Log.e("guoqiangxiang", "status: " + status + " id: " + d.getId());
            switch (status) {
                case 1:
                case 5:
                    h.i(advertAppInfo);
                    apkDownloadView.q(d);
                    return;
                case 2:
                case 4:
                default:
                    return;
                case 3:
                    h.installApp(this.eUY.getPageActivity(), advertAppInfo.eLw);
                    return;
                case 6:
                case 7:
                    e(advertAppInfo, i);
                    apkDownloadView.r(d);
                    return;
            }
        }
    }

    protected void e(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo != null) {
            if (!t.at(this.eUY.getPageActivity())) {
                l.showToast(this.eUY.getPageActivity(), R.string.write_external_storage_permission_denied_fun_disable);
            } else if (this.lcB != null) {
                this.lcB.c(advertAppInfo, i);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.d.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        this.lcB = cVar;
    }

    private void dEz() {
        if (dEy() && this.mYl != null) {
            String str = this.mYl.eLw;
            DownloadCacheKey EJ = !TextUtils.isEmpty(str) ? com.baidu.tieba.ad.download.d.bLy().EJ(str) : null;
            if (EJ == null) {
                EJ = DownloadCacheKey.create(str, this.mYl.apkUrl, this.mYl.eLw);
                com.baidu.tieba.ad.download.d.bLy().a(EJ, null);
            }
            i(EJ);
        }
    }

    private void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.ggV = downloadCacheKey;
            dEA();
            AdDownloadData d = com.baidu.tieba.ad.download.d.bLy().d(downloadCacheKey);
            if (d != null) {
                this.mXk.a(d.getCurrentState());
            } else {
                this.mXk.a(DownloadStatus.STATUS_NONE);
            }
            String str = this.mYl != null ? this.mYl.page : "";
            d.setExtInfo(this.mYl != null ? this.mYl.extensionInfo : "");
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.mXk, d, str);
            this.ggW = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d.extra().getPercent() > 0) {
                aVar.c((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
            bLq();
        }
    }

    public void bLq() {
        if (this.ggV != null && this.ggW != null) {
            com.baidu.tieba.ad.download.d.bLy().a(this.ggV, this.ggW);
        }
    }

    public void dEA() {
        if (this.ggV != null && this.ggW != null) {
            com.baidu.tieba.ad.download.d.bLy().b(this.ggV, this.ggW);
        }
    }
}
