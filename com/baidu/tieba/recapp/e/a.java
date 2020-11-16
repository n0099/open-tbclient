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
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
/* loaded from: classes25.dex */
public class a extends e {
    private TextView euO;
    private DownloadCacheKey fRJ;
    private com.baidu.tieba.ad.download.a.d fRK;
    private HeadImageView jsD;
    private com.baidu.tieba.lego.card.c kFQ;
    private CustomMessageListener mvO;
    private ApkDownloadView myF;
    private String myG;
    private TextView mzx;
    private boolean mzy;
    protected boolean mzz;

    public a(View view, String str) {
        super(view, str);
        this.fRK = null;
        this.mzy = false;
        this.mvO = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.e.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(a.this.myG) && a.this.myG.equals(downloadData.getId())) {
                    a.this.myF.t(downloadData);
                }
            }
        };
        init();
    }

    private void init() {
        this.jsD = (HeadImageView) IG(R.id.user_portrait);
        this.jsD.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.jsD.setDefaultResource(R.drawable.icon_default_avatar100);
        this.jsD.setDefaultBgResource(R.color.CAM_X0205);
        this.jsD.setIsRound(true);
        this.euO = (TextView) IG(R.id.user_name);
        this.mzx = (TextView) IG(R.id.action);
        this.myF = (ApkDownloadView) IG(R.id.download_view);
        MessageManager.getInstance().registerListener(this.mvO);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(AdCard.f fVar) {
        int i;
        super.a(fVar);
        this.jsD.startLoad(fVar.muT, 10, false);
        this.euO.setText(fVar.userName);
        this.mzx.setText(fVar.buttonText);
        this.myF.setTextColor(ap.getColor(R.color.CAM_X0901));
        if (this.mzJ instanceof AdCard) {
            this.mzy = ((AdCard) this.mzJ).directDownload;
        }
        if (this.mzI != null) {
            View$OnClickListenerC0840a view$OnClickListenerC0840a = new View$OnClickListenerC0840a(this.mzI);
            this.mRootView.setOnClickListener(view$OnClickListenerC0840a);
            if (dAX()) {
                this.myF.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.e.a.1
                    @Override // com.baidu.tieba.ad.download.mvp.b.a
                    public boolean bS(View view) {
                        return false;
                    }
                });
            } else {
                this.myF.setOnClickListener(view$OnClickListenerC0840a);
            }
            try {
                i = TextUtils.isEmpty(this.mzI.adPosition) ? 0 : Integer.valueOf(this.mzI.adPosition).intValue();
            } catch (NumberFormatException e) {
                i = 0;
            }
            this.myG = this.mzI.exf;
            DownloadData c = c(this.mzI, i);
            o(c);
            this.myF.setData(c);
        }
        if (!dAX()) {
            this.myF.x(this.eGu.getUniqueId());
        }
        this.mvO.setTag(this.eGu.getUniqueId());
        dAY();
        onChangeSkinType();
    }

    private void o(DownloadData downloadData) {
        if (dAX()) {
            if (this.myF != null) {
                downloadData.setStatus(this.myF.getDownloadStatus());
                return;
            }
            return;
        }
        downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dAX() {
        return !this.mzy || this.mzz;
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ap.setViewTextColor(this.euO, R.color.CAM_X0101, 1);
        ap.setViewTextColor(this.mzx, R.color.CAM_X0620, 1);
        ap.setBackgroundResource(this.mzx, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
        this.myF.setTextColorInitSkin(R.color.CAM_X0101);
        this.myF.setBackgroundSkin(R.drawable.tail_frame_action_btn_bg);
        this.myF.changeSkin();
    }

    public void wI(boolean z) {
        this.mzz = z;
    }

    /* renamed from: com.baidu.tieba.recapp.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    private class View$OnClickListenerC0840a implements View.OnClickListener {
        private AdvertAppInfo myJ;

        public View$OnClickListenerC0840a(AdvertAppInfo advertAppInfo) {
            this.myJ = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                a.this.eGu.showToast(R.string.neterror);
                return;
            }
            boolean z = view == a.this.myF;
            com.baidu.tieba.lego.card.b.c.a(a.this.mzJ);
            if (a.this.dAX()) {
                a.this.myF.performClick();
            } else if (this.myJ != null) {
                int i = com.baidu.adp.lib.f.b.toInt(this.myJ.adPosition, -1);
                int status = ApkDownloadView.getStatus(a.this.c(this.myJ, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    a.this.a(this.myJ, i, a.this.myF, z);
                } else {
                    a.this.showDownloadAppDialog(this.myJ, i, true, this.myJ.exl != null ? this.myJ.exl.exy : "");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.exf != null ? advertAppInfo.exf : advertAppInfo.exc);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.exd);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.exc, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.eGu.getPageActivity(), R.string.neterror);
            } else if (advertAppInfo.bju()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.eGu.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eGu.getPageActivity());
                aVar.AJ(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.e.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        a.this.d(advertAppInfo, i);
                        if (a.this.myF != null) {
                            a.this.myF.q(a.this.c(advertAppInfo, i));
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
                aVar.b(this.eGu).bog();
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
                    h.d(advertAppInfo);
                    apkDownloadView.r(c);
                    return;
                case 2:
                case 4:
                default:
                    return;
                case 3:
                    h.aU(this.eGu.getPageActivity(), advertAppInfo.exf);
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
            if (!r.aw(this.eGu.getPageActivity())) {
                l.showToast(this.eGu.getPageActivity(), R.string.write_external_storage_permission_denied_fun_disable);
            } else if (this.kFQ != null) {
                this.kFQ.b(advertAppInfo, i);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        this.kFQ = cVar;
    }

    private void dAY() {
        if (dAX() && this.mzI != null) {
            String str = this.mzI.exf;
            DownloadCacheKey EM = !TextUtils.isEmpty(str) ? com.baidu.tieba.ad.download.d.bIP().EM(str) : null;
            if (EM == null) {
                EM = DownloadCacheKey.create(str, this.mzI.apkUrl, this.mzI.exf);
                com.baidu.tieba.ad.download.d.bIP().a(EM, null);
            }
            i(EM);
        }
    }

    private void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.fRJ = downloadCacheKey;
            dAZ();
            AdDownloadData d = com.baidu.tieba.ad.download.d.bIP().d(downloadCacheKey);
            if (d != null) {
                this.myF.a(d.getCurrentState());
            } else {
                this.myF.a(DownloadStatus.STATUS_NONE);
            }
            String str = this.mzI != null ? this.mzI.page : "";
            d.setExtInfo(this.mzI != null ? this.mzI.extensionInfo : "");
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.myF, d, str);
            this.fRK = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
            bII();
        }
    }

    public void bII() {
        if (this.fRJ != null && this.fRK != null) {
            com.baidu.tieba.ad.download.d.bIP().a(this.fRJ, this.fRK);
        }
    }

    public void dAZ() {
        if (this.fRJ != null && this.fRK != null) {
            com.baidu.tieba.ad.download.d.bIP().b(this.fRJ, this.fRK);
        }
    }
}
