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
/* loaded from: classes8.dex */
public class a extends e {
    private TextView eLt;
    private DownloadCacheKey gjj;
    private com.baidu.tieba.ad.download.a.d gjk;
    private HeadImageView jTx;
    private com.baidu.tieba.lego.card.c kYO;
    private CustomMessageListener mPj;
    private TextView mSU;
    private boolean mSV;
    protected boolean mSW;
    private ApkDownloadView mSc;
    private String mSd;

    public a(View view, String str) {
        super(view, str);
        this.gjk = null;
        this.mSV = false;
        this.mPj = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.d.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(a.this.mSd) && a.this.mSd.equals(downloadData.getId())) {
                    a.this.mSc.t(downloadData);
                }
            }
        };
        init();
    }

    private void init() {
        this.jTx = (HeadImageView) Jr(R.id.user_portrait);
        this.jTx.setDefaultResource(R.drawable.icon_default_avatar100);
        this.jTx.setDefaultBgResource(R.color.CAM_X0205);
        this.jTx.setIsRound(true);
        this.eLt = (TextView) Jr(R.id.user_name);
        this.mSU = (TextView) Jr(R.id.action);
        this.mSc = (ApkDownloadView) Jr(R.id.download_view);
        MessageManager.getInstance().registerListener(this.mPj);
    }

    @Override // com.baidu.tieba.recapp.d.e
    public void a(AdCard.f fVar) {
        int i;
        super.a(fVar);
        this.jTx.startLoad(fVar.mOp, 10, false);
        this.eLt.setText(fVar.userName);
        this.mSU.setText(fVar.buttonText);
        this.mSc.setTextColor(ao.getColor(R.color.CAM_X0901));
        if (this.mTg instanceof AdCard) {
            this.mSV = ((AdCard) this.mTg).directDownload;
        }
        if (this.mTf != null) {
            View$OnClickListenerC0837a view$OnClickListenerC0837a = new View$OnClickListenerC0837a(this.mTf);
            this.mRootView.setOnClickListener(view$OnClickListenerC0837a);
            if (dFZ()) {
                this.mSc.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.d.a.1
                    @Override // com.baidu.tieba.ad.download.mvp.b.a
                    public boolean ci(View view) {
                        return false;
                    }
                });
            } else {
                this.mSc.setOnClickListener(view$OnClickListenerC0837a);
            }
            try {
                i = TextUtils.isEmpty(this.mTf.adPosition) ? 0 : Integer.valueOf(this.mTf.adPosition).intValue();
            } catch (NumberFormatException e) {
                i = 0;
            }
            this.mSd = this.mTf.eNW;
            DownloadData d = d(this.mTf, i);
            o(d);
            this.mSc.setData(d);
        }
        if (!dFZ()) {
            this.mSc.x(this.eXu.getUniqueId());
        }
        this.mPj.setTag(this.eXu.getUniqueId());
        dGa();
        onChangeSkinType();
    }

    private void o(DownloadData downloadData) {
        if (dFZ()) {
            if (this.mSc != null) {
                downloadData.setStatus(this.mSc.getDownloadStatus());
                return;
            }
            return;
        }
        downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dFZ() {
        return !this.mSV || this.mSW;
    }

    @Override // com.baidu.tieba.recapp.d.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ao.setViewTextColor(this.eLt, R.color.CAM_X0101, 1);
        ao.setViewTextColor(this.mSU, R.color.CAM_X0620, 1);
        ao.setBackgroundResource(this.mSU, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
        this.mSc.setTextColorInitSkin(R.color.CAM_X0101);
        this.mSc.setBackgroundSkin(R.drawable.tail_frame_action_btn_bg);
        this.mSc.bxN();
    }

    public void xn(boolean z) {
        this.mSW = z;
    }

    /* renamed from: com.baidu.tieba.recapp.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private class View$OnClickListenerC0837a implements View.OnClickListener {
        private AdvertAppInfo mSg;

        public View$OnClickListenerC0837a(AdvertAppInfo advertAppInfo) {
            this.mSg = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                a.this.eXu.showToast(R.string.neterror);
                return;
            }
            boolean z = view == a.this.mSc;
            com.baidu.tieba.lego.card.a.c.a(a.this.mTg);
            if (a.this.dFZ()) {
                a.this.mSc.performClick();
            } else if (this.mSg != null) {
                int i = com.baidu.adp.lib.f.b.toInt(this.mSg.adPosition, -1);
                int status = ApkDownloadView.getStatus(a.this.d(this.mSg, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    a.this.a(this.mSg, i, a.this.mSc, z);
                } else {
                    a.this.showDownloadAppDialog(this.mSg, i, true, this.mSg.eOc != null ? this.mSg.eOc.eOp : "");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData d(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.eNW != null ? advertAppInfo.eNW : advertAppInfo.eNT);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.eNU);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.eNT, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.eXu.getPageActivity(), R.string.neterror);
            } else if (advertAppInfo.bpf()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.eXu.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eXu.getPageActivity());
                aVar.Bp(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.d.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        a.this.e(advertAppInfo, i);
                        if (a.this.mSc != null) {
                            a.this.mSc.q(a.this.d(advertAppInfo, i));
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
                aVar.b(this.eXu).btX();
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
                    h.installApp(this.eXu.getPageActivity(), advertAppInfo.eNW);
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
            if (!s.aA(this.eXu.getPageActivity())) {
                l.showToast(this.eXu.getPageActivity(), R.string.write_external_storage_permission_denied_fun_disable);
            } else if (this.kYO != null) {
                this.kYO.c(advertAppInfo, i);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.d.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        this.kYO = cVar;
    }

    private void dGa() {
        if (dFZ() && this.mTf != null) {
            String str = this.mTf.eNW;
            DownloadCacheKey Fy = !TextUtils.isEmpty(str) ? com.baidu.tieba.ad.download.d.bOQ().Fy(str) : null;
            if (Fy == null) {
                Fy = DownloadCacheKey.create(str, this.mTf.apkUrl, this.mTf.eNW);
                com.baidu.tieba.ad.download.d.bOQ().a(Fy, null);
            }
            i(Fy);
        }
    }

    private void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.gjj = downloadCacheKey;
            dGb();
            AdDownloadData d = com.baidu.tieba.ad.download.d.bOQ().d(downloadCacheKey);
            if (d != null) {
                this.mSc.a(d.getCurrentState());
            } else {
                this.mSc.a(DownloadStatus.STATUS_NONE);
            }
            String str = this.mTf != null ? this.mTf.page : "";
            d.setExtInfo(this.mTf != null ? this.mTf.extensionInfo : "");
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.mSc, d, str);
            this.gjk = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
            bOI();
        }
    }

    public void bOI() {
        if (this.gjj != null && this.gjk != null) {
            com.baidu.tieba.ad.download.d.bOQ().a(this.gjj, this.gjk);
        }
    }

    public void dGb() {
        if (this.gjj != null && this.gjk != null) {
            com.baidu.tieba.ad.download.d.bOQ().b(this.gjj, this.gjk);
        }
    }
}
