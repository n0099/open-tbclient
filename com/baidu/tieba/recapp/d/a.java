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
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
/* loaded from: classes8.dex */
public class a extends e {
    private TextView eIO;
    private DownloadCacheKey ggP;
    private com.baidu.tieba.ad.download.a.d ggQ;
    private HeadImageView jWu;
    private com.baidu.tieba.lego.card.c lcm;
    private CustomMessageListener mTQ;
    private ApkDownloadView mWJ;
    private String mWK;
    private TextView mXA;
    private boolean mXB;
    protected boolean mXC;

    public a(View view, String str) {
        super(view, str);
        this.ggQ = null;
        this.mXB = false;
        this.mTQ = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.d.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(a.this.mWK) && a.this.mWK.equals(downloadData.getId())) {
                    a.this.mWJ.t(downloadData);
                }
            }
        };
        init();
    }

    private void init() {
        this.jWu = (HeadImageView) Id(R.id.user_portrait);
        this.jWu.setDefaultResource(R.drawable.icon_default_avatar100);
        this.jWu.setDefaultBgResource(R.color.CAM_X0205);
        this.jWu.setIsRound(true);
        this.eIO = (TextView) Id(R.id.user_name);
        this.mXA = (TextView) Id(R.id.action);
        this.mWJ = (ApkDownloadView) Id(R.id.download_view);
        MessageManager.getInstance().registerListener(this.mTQ);
    }

    @Override // com.baidu.tieba.recapp.d.e
    public void a(AdCard.f fVar) {
        int i;
        super.a(fVar);
        this.jWu.startLoad(fVar.mST, 10, false);
        this.eIO.setText(fVar.userName);
        this.mXA.setText(fVar.buttonText);
        this.mWJ.setTextColor(ap.getColor(R.color.CAM_X0901));
        if (this.mXM instanceof AdCard) {
            this.mXB = ((AdCard) this.mXM).directDownload;
        }
        if (this.mXL != null) {
            View$OnClickListenerC0856a view$OnClickListenerC0856a = new View$OnClickListenerC0856a(this.mXL);
            this.mRootView.setOnClickListener(view$OnClickListenerC0856a);
            if (dEq()) {
                this.mWJ.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.d.a.1
                    @Override // com.baidu.tieba.ad.download.mvp.b.a
                    public boolean ce(View view) {
                        return false;
                    }
                });
            } else {
                this.mWJ.setOnClickListener(view$OnClickListenerC0856a);
            }
            try {
                i = TextUtils.isEmpty(this.mXL.adPosition) ? 0 : Integer.valueOf(this.mXL.adPosition).intValue();
            } catch (NumberFormatException e) {
                i = 0;
            }
            this.mWK = this.mXL.eLx;
            DownloadData d = d(this.mXL, i);
            o(d);
            this.mWJ.setData(d);
        }
        if (!dEq()) {
            this.mWJ.y(this.eUY.getUniqueId());
        }
        this.mTQ.setTag(this.eUY.getUniqueId());
        dEr();
        onChangeSkinType();
    }

    private void o(DownloadData downloadData) {
        if (dEq()) {
            if (this.mWJ != null) {
                downloadData.setStatus(this.mWJ.getDownloadStatus());
                return;
            }
            return;
        }
        downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dEq() {
        return !this.mXB || this.mXC;
    }

    @Override // com.baidu.tieba.recapp.d.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ap.setViewTextColor(this.eIO, R.color.CAM_X0101, 1);
        ap.setViewTextColor(this.mXA, R.color.CAM_X0620, 1);
        ap.setBackgroundResource(this.mXA, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
        this.mWJ.setTextColorInitSkin(R.color.CAM_X0101);
        this.mWJ.setBackgroundSkin(R.drawable.tail_frame_action_btn_bg);
        this.mWJ.buo();
    }

    public void xC(boolean z) {
        this.mXC = z;
    }

    /* renamed from: com.baidu.tieba.recapp.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private class View$OnClickListenerC0856a implements View.OnClickListener {
        private AdvertAppInfo mWO;

        public View$OnClickListenerC0856a(AdvertAppInfo advertAppInfo) {
            this.mWO = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                a.this.eUY.showToast(R.string.neterror);
                return;
            }
            boolean z = view == a.this.mWJ;
            com.baidu.tieba.lego.card.a.c.a(a.this.mXM);
            if (a.this.dEq()) {
                a.this.mWJ.performClick();
            } else if (this.mWO != null) {
                int i = com.baidu.adp.lib.f.b.toInt(this.mWO.adPosition, -1);
                int status = ApkDownloadView.getStatus(a.this.d(this.mWO, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    a.this.a(this.mWO, i, a.this.mWJ, z);
                } else {
                    a.this.showDownloadAppDialog(this.mWO, i, true, this.mWO.eLD != null ? this.mWO.eLD.eLQ : "");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData d(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.eLx != null ? advertAppInfo.eLx : advertAppInfo.eLu);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.eLv);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.eLu, 0));
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
                        if (a.this.mWJ != null) {
                            a.this.mWJ.q(a.this.d(advertAppInfo, i));
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
                    apkDownloadView.r(d);
                    return;
                case 2:
                case 4:
                default:
                    return;
                case 3:
                    h.installApp(this.eUY.getPageActivity(), advertAppInfo.eLx);
                    return;
                case 6:
                case 7:
                    e(advertAppInfo, i);
                    apkDownloadView.s(d);
                    return;
            }
        }
    }

    protected void e(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo != null) {
            if (!s.at(this.eUY.getPageActivity())) {
                l.showToast(this.eUY.getPageActivity(), R.string.write_external_storage_permission_denied_fun_disable);
            } else if (this.lcm != null) {
                this.lcm.c(advertAppInfo, i);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.d.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        this.lcm = cVar;
    }

    private void dEr() {
        if (dEq() && this.mXL != null) {
            String str = this.mXL.eLx;
            DownloadCacheKey EK = !TextUtils.isEmpty(str) ? com.baidu.tieba.ad.download.d.bLt().EK(str) : null;
            if (EK == null) {
                EK = DownloadCacheKey.create(str, this.mXL.apkUrl, this.mXL.eLx);
                com.baidu.tieba.ad.download.d.bLt().a(EK, null);
            }
            i(EK);
        }
    }

    private void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.ggP = downloadCacheKey;
            dEs();
            AdDownloadData d = com.baidu.tieba.ad.download.d.bLt().d(downloadCacheKey);
            if (d != null) {
                this.mWJ.a(d.getCurrentState());
            } else {
                this.mWJ.a(DownloadStatus.STATUS_NONE);
            }
            String str = this.mXL != null ? this.mXL.page : "";
            d.setExtInfo(this.mXL != null ? this.mXL.extensionInfo : "");
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.mWJ, d, str);
            this.ggQ = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
            bLl();
        }
    }

    public void bLl() {
        if (this.ggP != null && this.ggQ != null) {
            com.baidu.tieba.ad.download.d.bLt().a(this.ggP, this.ggQ);
        }
    }

    public void dEs() {
        if (this.ggP != null && this.ggQ != null) {
            com.baidu.tieba.ad.download.d.bLt().b(this.ggP, this.ggQ);
        }
    }
}
