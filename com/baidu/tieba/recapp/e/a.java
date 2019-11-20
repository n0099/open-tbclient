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
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
/* loaded from: classes3.dex */
public class a extends e {
    private TextView crw;
    private DownloadCacheKey dgW;
    private com.baidu.tieba.ad.download.a.d dgX;
    private HeadImageView fZX;
    private com.baidu.tieba.lego.card.c heX;
    private CustomMessageListener iJr;
    private ApkDownloadView iKc;
    private String iMu;
    private TextView iNi;
    private boolean iNj;
    protected boolean iNk;

    public a(View view, String str) {
        super(view, str);
        this.dgX = null;
        this.iNj = false;
        this.iJr = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.e.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(a.this.iMu) && a.this.iMu.equals(downloadData.getId())) {
                    a.this.iKc.t(downloadData);
                }
            }
        };
        init();
    }

    private void init() {
        this.fZX = (HeadImageView) yv(R.id.user_portrait);
        this.fZX.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fZX.setDefaultResource(R.drawable.icon_default_avatar100);
        this.fZX.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fZX.setIsRound(true);
        this.crw = (TextView) yv(R.id.user_name);
        this.iNi = (TextView) yv(R.id.action);
        this.iKc = (ApkDownloadView) yv(R.id.download_view);
        MessageManager.getInstance().registerListener(this.iJr);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(AdCard.f fVar) {
        super.a(fVar);
        this.fZX.startLoad(fVar.iID, 10, false);
        this.crw.setText(fVar.userName);
        this.iNi.setText(fVar.buttonText);
        if (this.iNu instanceof AdCard) {
            this.iNj = ((AdCard) this.iNu).directDownload;
        }
        if (this.iNt != null) {
            View$OnClickListenerC0507a view$OnClickListenerC0507a = new View$OnClickListenerC0507a(this.iNt);
            this.mRootView.setOnClickListener(view$OnClickListenerC0507a);
            if (cgK()) {
                this.iKc.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.e.a.1
                    @Override // com.baidu.tieba.ad.download.mvp.b.a
                    public void bo(View view) {
                    }
                });
            } else {
                this.iKc.setOnClickListener(view$OnClickListenerC0507a);
            }
            int intValue = Integer.valueOf(this.iNt.adPosition).intValue();
            this.iMu = this.iNt.bWx;
            DownloadData c = c(this.iNt, intValue);
            o(c);
            this.iKc.setData(c);
        }
        if (!cgK()) {
            this.iKc.t(this.ceu.getUniqueId());
        }
        this.iJr.setTag(this.ceu.getUniqueId());
        cgL();
        onChangeSkinType();
    }

    private void o(DownloadData downloadData) {
        if (cgK()) {
            if (this.iKc != null) {
                downloadData.setStatus(this.iKc.getDownloadStatus());
                return;
            }
            return;
        }
        downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cgK() {
        return !this.iNj || this.iNk;
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        am.setViewTextColor(this.crw, R.color.cp_cont_a, 1);
        am.setViewTextColor(this.iNi, R.color.cp_mask_c_alpha83, 1);
        am.setBackgroundColor(this.iNi, R.color.cp_link_tip_a, 1);
        this.iKc.bno();
    }

    public void qf(boolean z) {
        this.iNk = z;
    }

    /* renamed from: com.baidu.tieba.recapp.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class View$OnClickListenerC0507a implements View.OnClickListener {
        private AdvertAppInfo iMx;

        public View$OnClickListenerC0507a(AdvertAppInfo advertAppInfo) {
            this.iMx = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                a.this.ceu.showToast(R.string.neterror);
                return;
            }
            boolean z = view == a.this.iKc;
            if (a.this.cgK()) {
                a.this.iKc.performClick();
            } else if (this.iMx != null) {
                int i = com.baidu.adp.lib.g.b.toInt(this.iMx.adPosition, -1);
                int status = ApkDownloadView.getStatus(a.this.c(this.iMx, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    a.this.a(this.iMx, i, a.this.iKc, z);
                } else {
                    a.this.showDownloadAppDialog(this.iMx, i, true, this.iMx.bWD != null ? this.iMx.bWD.bWP : "");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.bWx);
        downloadData.setUrl(advertAppInfo.bWw);
        downloadData.setName(advertAppInfo.bWu);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.g.b.toInt(advertAppInfo.bWt, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.ceu.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.agQ()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.ceu.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ceu.getPageActivity());
                aVar.nn(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.e.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        a.this.d(advertAppInfo, i);
                        if (a.this.iKc != null) {
                            a.this.iKc.q(a.this.c(advertAppInfo, i));
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
                aVar.b(this.ceu).akM();
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
                    h.aK(this.ceu.getPageActivity(), advertAppInfo.bWx);
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
            if (!s.al(this.ceu.getPageActivity())) {
                l.showToast(this.ceu.getPageActivity(), (int) R.string.write_external_storage_permission_denied_fun_disable);
            } else if (this.heX != null) {
                this.heX.b(advertAppInfo, i);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        this.heX = cVar;
    }

    private void cgL() {
        if (cgK() && this.iNt != null) {
            String str = this.iNt.bWt;
            DownloadCacheKey rt = !TextUtils.isEmpty(str) ? com.baidu.tieba.ad.download.d.aDG().rt(str) : null;
            if (rt == null) {
                rt = DownloadCacheKey.create(str, this.iNt.bWw, this.iNt.bWx);
                com.baidu.tieba.ad.download.d.aDG().a(rt, null);
            }
            i(rt);
        }
    }

    private void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.dgW = downloadCacheKey;
            cgM();
            AdDownloadData d = com.baidu.tieba.ad.download.d.aDG().d(downloadCacheKey);
            if (d != null) {
                this.iKc.a(d.getCurrentState());
            } else {
                this.iKc.a(DownloadStatus.STATUS_NONE);
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.iKc, d, this.iNt != null ? this.iNt.page : "");
            this.dgX = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
            aDA();
        }
    }

    public void aDA() {
        if (this.dgW != null && this.dgX != null) {
            com.baidu.tieba.ad.download.d.aDG().a(this.dgW, this.dgX);
        }
    }

    public void cgM() {
        if (this.dgW != null && this.dgX != null) {
            com.baidu.tieba.ad.download.d.aDG().b(this.dgW, this.dgX);
        }
    }
}
