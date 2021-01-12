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
/* loaded from: classes7.dex */
public class a extends e {
    private TextView eGI;
    private DownloadCacheKey geB;
    private com.baidu.tieba.ad.download.a.d geC;
    private HeadImageView jOS;
    private com.baidu.tieba.lego.card.c kUj;
    private CustomMessageListener mKE;
    private ApkDownloadView mNv;
    private String mNw;
    private TextView mOl;
    private boolean mOm;
    protected boolean mOn;

    public a(View view, String str) {
        super(view, str);
        this.geC = null;
        this.mOm = false;
        this.mKE = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.d.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(a.this.mNw) && a.this.mNw.equals(downloadData.getId())) {
                    a.this.mNv.t(downloadData);
                }
            }
        };
        init();
    }

    private void init() {
        this.jOS = (HeadImageView) HK(R.id.user_portrait);
        this.jOS.setDefaultResource(R.drawable.icon_default_avatar100);
        this.jOS.setDefaultBgResource(R.color.CAM_X0205);
        this.jOS.setIsRound(true);
        this.eGI = (TextView) HK(R.id.user_name);
        this.mOl = (TextView) HK(R.id.action);
        this.mNv = (ApkDownloadView) HK(R.id.download_view);
        MessageManager.getInstance().registerListener(this.mKE);
    }

    @Override // com.baidu.tieba.recapp.d.e
    public void a(AdCard.f fVar) {
        int i;
        super.a(fVar);
        this.jOS.startLoad(fVar.mJK, 10, false);
        this.eGI.setText(fVar.userName);
        this.mOl.setText(fVar.buttonText);
        this.mNv.setTextColor(ao.getColor(R.color.CAM_X0901));
        if (this.mOx instanceof AdCard) {
            this.mOm = ((AdCard) this.mOx).directDownload;
        }
        if (this.mOw != null) {
            View$OnClickListenerC0853a view$OnClickListenerC0853a = new View$OnClickListenerC0853a(this.mOw);
            this.mRootView.setOnClickListener(view$OnClickListenerC0853a);
            if (dCi()) {
                this.mNv.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.d.a.1
                    @Override // com.baidu.tieba.ad.download.mvp.b.a
                    public boolean ci(View view) {
                        return false;
                    }
                });
            } else {
                this.mNv.setOnClickListener(view$OnClickListenerC0853a);
            }
            try {
                i = TextUtils.isEmpty(this.mOw.adPosition) ? 0 : Integer.valueOf(this.mOw.adPosition).intValue();
            } catch (NumberFormatException e) {
                i = 0;
            }
            this.mNw = this.mOw.eJl;
            DownloadData d = d(this.mOw, i);
            o(d);
            this.mNv.setData(d);
        }
        if (!dCi()) {
            this.mNv.x(this.eSJ.getUniqueId());
        }
        this.mKE.setTag(this.eSJ.getUniqueId());
        dCj();
        onChangeSkinType();
    }

    private void o(DownloadData downloadData) {
        if (dCi()) {
            if (this.mNv != null) {
                downloadData.setStatus(this.mNv.getDownloadStatus());
                return;
            }
            return;
        }
        downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dCi() {
        return !this.mOm || this.mOn;
    }

    @Override // com.baidu.tieba.recapp.d.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ao.setViewTextColor(this.eGI, R.color.CAM_X0101, 1);
        ao.setViewTextColor(this.mOl, R.color.CAM_X0620, 1);
        ao.setBackgroundResource(this.mOl, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
        this.mNv.setTextColorInitSkin(R.color.CAM_X0101);
        this.mNv.setBackgroundSkin(R.drawable.tail_frame_action_btn_bg);
        this.mNv.btU();
    }

    public void xj(boolean z) {
        this.mOn = z;
    }

    /* renamed from: com.baidu.tieba.recapp.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    private class View$OnClickListenerC0853a implements View.OnClickListener {
        private AdvertAppInfo mNz;

        public View$OnClickListenerC0853a(AdvertAppInfo advertAppInfo) {
            this.mNz = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                a.this.eSJ.showToast(R.string.neterror);
                return;
            }
            boolean z = view == a.this.mNv;
            com.baidu.tieba.lego.card.a.c.a(a.this.mOx);
            if (a.this.dCi()) {
                a.this.mNv.performClick();
            } else if (this.mNz != null) {
                int i = com.baidu.adp.lib.f.b.toInt(this.mNz.adPosition, -1);
                int status = ApkDownloadView.getStatus(a.this.d(this.mNz, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    a.this.a(this.mNz, i, a.this.mNv, z);
                } else {
                    a.this.showDownloadAppDialog(this.mNz, i, true, this.mNz.eJr != null ? this.mNz.eJr.eJE : "");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData d(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.eJl != null ? advertAppInfo.eJl : advertAppInfo.eJi);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.eJj);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.eJi, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.eSJ.getPageActivity(), R.string.neterror);
            } else if (advertAppInfo.blm()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.eSJ.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eSJ.getPageActivity());
                aVar.Ad(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.d.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        a.this.e(advertAppInfo, i);
                        if (a.this.mNv != null) {
                            a.this.mNv.q(a.this.d(advertAppInfo, i));
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
                aVar.b(this.eSJ).bqe();
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
                    h.h(advertAppInfo);
                    apkDownloadView.r(d);
                    return;
                case 2:
                case 4:
                default:
                    return;
                case 3:
                    h.installApp(this.eSJ.getPageActivity(), advertAppInfo.eJl);
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
            if (!s.aA(this.eSJ.getPageActivity())) {
                l.showToast(this.eSJ.getPageActivity(), R.string.write_external_storage_permission_denied_fun_disable);
            } else if (this.kUj != null) {
                this.kUj.c(advertAppInfo, i);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.d.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        this.kUj = cVar;
    }

    private void dCj() {
        if (dCi() && this.mOw != null) {
            String str = this.mOw.eJl;
            DownloadCacheKey Em = !TextUtils.isEmpty(str) ? com.baidu.tieba.ad.download.d.bKZ().Em(str) : null;
            if (Em == null) {
                Em = DownloadCacheKey.create(str, this.mOw.apkUrl, this.mOw.eJl);
                com.baidu.tieba.ad.download.d.bKZ().a(Em, null);
            }
            i(Em);
        }
    }

    private void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.geB = downloadCacheKey;
            dCk();
            AdDownloadData d = com.baidu.tieba.ad.download.d.bKZ().d(downloadCacheKey);
            if (d != null) {
                this.mNv.a(d.getCurrentState());
            } else {
                this.mNv.a(DownloadStatus.STATUS_NONE);
            }
            String str = this.mOw != null ? this.mOw.page : "";
            d.setExtInfo(this.mOw != null ? this.mOw.extensionInfo : "");
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.mNv, d, str);
            this.geC = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
            bKR();
        }
    }

    public void bKR() {
        if (this.geB != null && this.geC != null) {
            com.baidu.tieba.ad.download.d.bKZ().a(this.geB, this.geC);
        }
    }

    public void dCk() {
        if (this.geB != null && this.geC != null) {
            com.baidu.tieba.ad.download.d.bKZ().b(this.geB, this.geC);
        }
    }
}
