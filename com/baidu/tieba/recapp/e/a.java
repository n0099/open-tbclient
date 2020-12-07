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
/* loaded from: classes26.dex */
public class a extends e {
    private TextView eBQ;
    private DownloadCacheKey fZS;
    private com.baidu.tieba.ad.download.a.d fZT;
    private HeadImageView jGd;
    private com.baidu.tieba.lego.card.c kTi;
    private CustomMessageListener mKa;
    private ApkDownloadView mMR;
    private String mMS;
    private TextView mNI;
    private boolean mNJ;
    protected boolean mNK;

    public a(View view, String str) {
        super(view, str);
        this.fZT = null;
        this.mNJ = false;
        this.mKa = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.e.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(a.this.mMS) && a.this.mMS.equals(downloadData.getId())) {
                    a.this.mMR.t(downloadData);
                }
            }
        };
        init();
    }

    private void init() {
        this.jGd = (HeadImageView) Jx(R.id.user_portrait);
        this.jGd.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.jGd.setDefaultResource(R.drawable.icon_default_avatar100);
        this.jGd.setDefaultBgResource(R.color.CAM_X0205);
        this.jGd.setIsRound(true);
        this.eBQ = (TextView) Jx(R.id.user_name);
        this.mNI = (TextView) Jx(R.id.action);
        this.mMR = (ApkDownloadView) Jx(R.id.download_view);
        MessageManager.getInstance().registerListener(this.mKa);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(AdCard.f fVar) {
        int i;
        super.a(fVar);
        this.jGd.startLoad(fVar.mJf, 10, false);
        this.eBQ.setText(fVar.userName);
        this.mNI.setText(fVar.buttonText);
        this.mMR.setTextColor(ap.getColor(R.color.CAM_X0901));
        if (this.mNU instanceof AdCard) {
            this.mNJ = ((AdCard) this.mNU).directDownload;
        }
        if (this.mNT != null) {
            View$OnClickListenerC0855a view$OnClickListenerC0855a = new View$OnClickListenerC0855a(this.mNT);
            this.mRootView.setOnClickListener(view$OnClickListenerC0855a);
            if (dGj()) {
                this.mMR.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.e.a.1
                    @Override // com.baidu.tieba.ad.download.mvp.b.a
                    public boolean bZ(View view) {
                        return false;
                    }
                });
            } else {
                this.mMR.setOnClickListener(view$OnClickListenerC0855a);
            }
            try {
                i = TextUtils.isEmpty(this.mNT.adPosition) ? 0 : Integer.valueOf(this.mNT.adPosition).intValue();
            } catch (NumberFormatException e) {
                i = 0;
            }
            this.mMS = this.mNT.eEg;
            DownloadData d = d(this.mNT, i);
            o(d);
            this.mMR.setData(d);
        }
        if (!dGj()) {
            this.mMR.x(this.eNx.getUniqueId());
        }
        this.mKa.setTag(this.eNx.getUniqueId());
        dGk();
        onChangeSkinType();
    }

    private void o(DownloadData downloadData) {
        if (dGj()) {
            if (this.mMR != null) {
                downloadData.setStatus(this.mMR.getDownloadStatus());
                return;
            }
            return;
        }
        downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dGj() {
        return !this.mNJ || this.mNK;
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ap.setViewTextColor(this.eBQ, R.color.CAM_X0101, 1);
        ap.setViewTextColor(this.mNI, R.color.CAM_X0620, 1);
        ap.setBackgroundResource(this.mNI, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
        this.mMR.setTextColorInitSkin(R.color.CAM_X0101);
        this.mMR.setBackgroundSkin(R.drawable.tail_frame_action_btn_bg);
        this.mMR.bvs();
    }

    public void xm(boolean z) {
        this.mNK = z;
    }

    /* renamed from: com.baidu.tieba.recapp.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    private class View$OnClickListenerC0855a implements View.OnClickListener {
        private AdvertAppInfo mMV;

        public View$OnClickListenerC0855a(AdvertAppInfo advertAppInfo) {
            this.mMV = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                a.this.eNx.showToast(R.string.neterror);
                return;
            }
            boolean z = view == a.this.mMR;
            com.baidu.tieba.lego.card.b.c.a(a.this.mNU);
            if (a.this.dGj()) {
                a.this.mMR.performClick();
            } else if (this.mMV != null) {
                int i = com.baidu.adp.lib.f.b.toInt(this.mMV.adPosition, -1);
                int status = ApkDownloadView.getStatus(a.this.d(this.mMV, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    a.this.a(this.mMV, i, a.this.mMR, z);
                } else {
                    a.this.showDownloadAppDialog(this.mMV, i, true, this.mMV.eEm != null ? this.mMV.eEm.eEz : "");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData d(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.eEg != null ? advertAppInfo.eEg : advertAppInfo.eEd);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.eEe);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.eEd, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.eNx.getPageActivity(), R.string.neterror);
            } else if (advertAppInfo.bmE()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.eNx.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eNx.getPageActivity());
                aVar.Bq(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.e.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        a.this.e(advertAppInfo, i);
                        if (a.this.mMR != null) {
                            a.this.mMR.q(a.this.d(advertAppInfo, i));
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
                aVar.b(this.eNx).brv();
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
                    h.aY(this.eNx.getPageActivity(), advertAppInfo.eEg);
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
            if (!s.ax(this.eNx.getPageActivity())) {
                l.showToast(this.eNx.getPageActivity(), R.string.write_external_storage_permission_denied_fun_disable);
            } else if (this.kTi != null) {
                this.kTi.c(advertAppInfo, i);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        this.kTi = cVar;
    }

    private void dGk() {
        if (dGj() && this.mNT != null) {
            String str = this.mNT.eEg;
            DownloadCacheKey FA = !TextUtils.isEmpty(str) ? com.baidu.tieba.ad.download.d.bMx().FA(str) : null;
            if (FA == null) {
                FA = DownloadCacheKey.create(str, this.mNT.apkUrl, this.mNT.eEg);
                com.baidu.tieba.ad.download.d.bMx().a(FA, null);
            }
            i(FA);
        }
    }

    private void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.fZS = downloadCacheKey;
            dGl();
            AdDownloadData d = com.baidu.tieba.ad.download.d.bMx().d(downloadCacheKey);
            if (d != null) {
                this.mMR.a(d.getCurrentState());
            } else {
                this.mMR.a(DownloadStatus.STATUS_NONE);
            }
            String str = this.mNT != null ? this.mNT.page : "";
            d.setExtInfo(this.mNT != null ? this.mNT.extensionInfo : "");
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.mMR, d, str);
            this.fZT = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
            bMq();
        }
    }

    public void bMq() {
        if (this.fZS != null && this.fZT != null) {
            com.baidu.tieba.ad.download.d.bMx().a(this.fZS, this.fZT);
        }
    }

    public void dGl() {
        if (this.fZS != null && this.fZT != null) {
            com.baidu.tieba.ad.download.d.bMx().b(this.fZS, this.fZT);
        }
    }
}
