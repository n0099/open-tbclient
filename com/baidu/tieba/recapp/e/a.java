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
    private DownloadCacheKey fZU;
    private com.baidu.tieba.ad.download.a.d fZV;
    private HeadImageView jGf;
    private com.baidu.tieba.lego.card.c kTk;
    private CustomMessageListener mKc;
    private ApkDownloadView mMT;
    private String mMU;
    private TextView mNK;
    private boolean mNL;
    protected boolean mNM;

    public a(View view, String str) {
        super(view, str);
        this.fZV = null;
        this.mNL = false;
        this.mKc = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.e.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(a.this.mMU) && a.this.mMU.equals(downloadData.getId())) {
                    a.this.mMT.t(downloadData);
                }
            }
        };
        init();
    }

    private void init() {
        this.jGf = (HeadImageView) Jx(R.id.user_portrait);
        this.jGf.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.jGf.setDefaultResource(R.drawable.icon_default_avatar100);
        this.jGf.setDefaultBgResource(R.color.CAM_X0205);
        this.jGf.setIsRound(true);
        this.eBQ = (TextView) Jx(R.id.user_name);
        this.mNK = (TextView) Jx(R.id.action);
        this.mMT = (ApkDownloadView) Jx(R.id.download_view);
        MessageManager.getInstance().registerListener(this.mKc);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(AdCard.f fVar) {
        int i;
        super.a(fVar);
        this.jGf.startLoad(fVar.mJh, 10, false);
        this.eBQ.setText(fVar.userName);
        this.mNK.setText(fVar.buttonText);
        this.mMT.setTextColor(ap.getColor(R.color.CAM_X0901));
        if (this.mNW instanceof AdCard) {
            this.mNL = ((AdCard) this.mNW).directDownload;
        }
        if (this.mNV != null) {
            View$OnClickListenerC0855a view$OnClickListenerC0855a = new View$OnClickListenerC0855a(this.mNV);
            this.mRootView.setOnClickListener(view$OnClickListenerC0855a);
            if (dGk()) {
                this.mMT.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.e.a.1
                    @Override // com.baidu.tieba.ad.download.mvp.b.a
                    public boolean bZ(View view) {
                        return false;
                    }
                });
            } else {
                this.mMT.setOnClickListener(view$OnClickListenerC0855a);
            }
            try {
                i = TextUtils.isEmpty(this.mNV.adPosition) ? 0 : Integer.valueOf(this.mNV.adPosition).intValue();
            } catch (NumberFormatException e) {
                i = 0;
            }
            this.mMU = this.mNV.eEg;
            DownloadData d = d(this.mNV, i);
            o(d);
            this.mMT.setData(d);
        }
        if (!dGk()) {
            this.mMT.x(this.eNx.getUniqueId());
        }
        this.mKc.setTag(this.eNx.getUniqueId());
        dGl();
        onChangeSkinType();
    }

    private void o(DownloadData downloadData) {
        if (dGk()) {
            if (this.mMT != null) {
                downloadData.setStatus(this.mMT.getDownloadStatus());
                return;
            }
            return;
        }
        downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dGk() {
        return !this.mNL || this.mNM;
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ap.setViewTextColor(this.eBQ, R.color.CAM_X0101, 1);
        ap.setViewTextColor(this.mNK, R.color.CAM_X0620, 1);
        ap.setBackgroundResource(this.mNK, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
        this.mMT.setTextColorInitSkin(R.color.CAM_X0101);
        this.mMT.setBackgroundSkin(R.drawable.tail_frame_action_btn_bg);
        this.mMT.bvs();
    }

    public void xm(boolean z) {
        this.mNM = z;
    }

    /* renamed from: com.baidu.tieba.recapp.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    private class View$OnClickListenerC0855a implements View.OnClickListener {
        private AdvertAppInfo mMX;

        public View$OnClickListenerC0855a(AdvertAppInfo advertAppInfo) {
            this.mMX = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                a.this.eNx.showToast(R.string.neterror);
                return;
            }
            boolean z = view == a.this.mMT;
            com.baidu.tieba.lego.card.b.c.a(a.this.mNW);
            if (a.this.dGk()) {
                a.this.mMT.performClick();
            } else if (this.mMX != null) {
                int i = com.baidu.adp.lib.f.b.toInt(this.mMX.adPosition, -1);
                int status = ApkDownloadView.getStatus(a.this.d(this.mMX, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    a.this.a(this.mMX, i, a.this.mMT, z);
                } else {
                    a.this.showDownloadAppDialog(this.mMX, i, true, this.mMX.eEm != null ? this.mMX.eEm.eEz : "");
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
                        if (a.this.mMT != null) {
                            a.this.mMT.q(a.this.d(advertAppInfo, i));
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
            } else if (this.kTk != null) {
                this.kTk.c(advertAppInfo, i);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        this.kTk = cVar;
    }

    private void dGl() {
        if (dGk() && this.mNV != null) {
            String str = this.mNV.eEg;
            DownloadCacheKey FA = !TextUtils.isEmpty(str) ? com.baidu.tieba.ad.download.d.bMy().FA(str) : null;
            if (FA == null) {
                FA = DownloadCacheKey.create(str, this.mNV.apkUrl, this.mNV.eEg);
                com.baidu.tieba.ad.download.d.bMy().a(FA, null);
            }
            i(FA);
        }
    }

    private void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.fZU = downloadCacheKey;
            dGm();
            AdDownloadData d = com.baidu.tieba.ad.download.d.bMy().d(downloadCacheKey);
            if (d != null) {
                this.mMT.a(d.getCurrentState());
            } else {
                this.mMT.a(DownloadStatus.STATUS_NONE);
            }
            String str = this.mNV != null ? this.mNV.page : "";
            d.setExtInfo(this.mNV != null ? this.mNV.extensionInfo : "");
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.mMT, d, str);
            this.fZV = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
            bMr();
        }
    }

    public void bMr() {
        if (this.fZU != null && this.fZV != null) {
            com.baidu.tieba.ad.download.d.bMy().a(this.fZU, this.fZV);
        }
    }

    public void dGm() {
        if (this.fZU != null && this.fZV != null) {
            com.baidu.tieba.ad.download.d.bMy().b(this.fZU, this.fZV);
        }
    }
}
