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
    private TextView csn;
    private DownloadCacheKey dhN;
    private com.baidu.tieba.ad.download.a.d dhO;
    private HeadImageView gaO;
    private com.baidu.tieba.lego.card.c hfO;
    private ApkDownloadView iKT;
    private CustomMessageListener iKi;
    private TextView iNZ;
    private String iNl;
    private boolean iOa;
    protected boolean iOb;

    public a(View view, String str) {
        super(view, str);
        this.dhO = null;
        this.iOa = false;
        this.iKi = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.e.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(a.this.iNl) && a.this.iNl.equals(downloadData.getId())) {
                    a.this.iKT.t(downloadData);
                }
            }
        };
        init();
    }

    private void init() {
        this.gaO = (HeadImageView) yw(R.id.user_portrait);
        this.gaO.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gaO.setDefaultResource(R.drawable.icon_default_avatar100);
        this.gaO.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gaO.setIsRound(true);
        this.csn = (TextView) yw(R.id.user_name);
        this.iNZ = (TextView) yw(R.id.action);
        this.iKT = (ApkDownloadView) yw(R.id.download_view);
        MessageManager.getInstance().registerListener(this.iKi);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(AdCard.f fVar) {
        super.a(fVar);
        this.gaO.startLoad(fVar.iJu, 10, false);
        this.csn.setText(fVar.userName);
        this.iNZ.setText(fVar.buttonText);
        if (this.iOl instanceof AdCard) {
            this.iOa = ((AdCard) this.iOl).directDownload;
        }
        if (this.iOk != null) {
            View$OnClickListenerC0507a view$OnClickListenerC0507a = new View$OnClickListenerC0507a(this.iOk);
            this.mRootView.setOnClickListener(view$OnClickListenerC0507a);
            if (cgM()) {
                this.iKT.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.e.a.1
                    @Override // com.baidu.tieba.ad.download.mvp.b.a
                    public void bo(View view) {
                    }
                });
            } else {
                this.iKT.setOnClickListener(view$OnClickListenerC0507a);
            }
            int intValue = Integer.valueOf(this.iOk.adPosition).intValue();
            this.iNl = this.iOk.bXo;
            DownloadData c = c(this.iOk, intValue);
            o(c);
            this.iKT.setData(c);
        }
        if (!cgM()) {
            this.iKT.t(this.cfl.getUniqueId());
        }
        this.iKi.setTag(this.cfl.getUniqueId());
        cgN();
        onChangeSkinType();
    }

    private void o(DownloadData downloadData) {
        if (cgM()) {
            if (this.iKT != null) {
                downloadData.setStatus(this.iKT.getDownloadStatus());
                return;
            }
            return;
        }
        downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cgM() {
        return !this.iOa || this.iOb;
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        am.setViewTextColor(this.csn, R.color.cp_cont_a, 1);
        am.setViewTextColor(this.iNZ, R.color.cp_mask_c_alpha83, 1);
        am.setBackgroundColor(this.iNZ, R.color.cp_link_tip_a, 1);
        this.iKT.bnq();
    }

    public void qf(boolean z) {
        this.iOb = z;
    }

    /* renamed from: com.baidu.tieba.recapp.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class View$OnClickListenerC0507a implements View.OnClickListener {
        private AdvertAppInfo iNo;

        public View$OnClickListenerC0507a(AdvertAppInfo advertAppInfo) {
            this.iNo = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                a.this.cfl.showToast(R.string.neterror);
                return;
            }
            boolean z = view == a.this.iKT;
            if (a.this.cgM()) {
                a.this.iKT.performClick();
            } else if (this.iNo != null) {
                int i = com.baidu.adp.lib.g.b.toInt(this.iNo.adPosition, -1);
                int status = ApkDownloadView.getStatus(a.this.c(this.iNo, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    a.this.a(this.iNo, i, a.this.iKT, z);
                } else {
                    a.this.showDownloadAppDialog(this.iNo, i, true, this.iNo.bXu != null ? this.iNo.bXu.bXG : "");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.bXo);
        downloadData.setUrl(advertAppInfo.bXn);
        downloadData.setName(advertAppInfo.bXl);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.g.b.toInt(advertAppInfo.bXk, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.cfl.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.agS()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.cfl.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cfl.getPageActivity());
                aVar.nn(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.e.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        a.this.d(advertAppInfo, i);
                        if (a.this.iKT != null) {
                            a.this.iKT.q(a.this.c(advertAppInfo, i));
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
                aVar.b(this.cfl).akO();
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
                    h.aK(this.cfl.getPageActivity(), advertAppInfo.bXo);
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
            if (!s.al(this.cfl.getPageActivity())) {
                l.showToast(this.cfl.getPageActivity(), (int) R.string.write_external_storage_permission_denied_fun_disable);
            } else if (this.hfO != null) {
                this.hfO.b(advertAppInfo, i);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        this.hfO = cVar;
    }

    private void cgN() {
        if (cgM() && this.iOk != null) {
            String str = this.iOk.bXk;
            DownloadCacheKey rt = !TextUtils.isEmpty(str) ? com.baidu.tieba.ad.download.d.aDI().rt(str) : null;
            if (rt == null) {
                rt = DownloadCacheKey.create(str, this.iOk.bXn, this.iOk.bXo);
                com.baidu.tieba.ad.download.d.aDI().a(rt, null);
            }
            i(rt);
        }
    }

    private void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.dhN = downloadCacheKey;
            cgO();
            AdDownloadData d = com.baidu.tieba.ad.download.d.aDI().d(downloadCacheKey);
            if (d != null) {
                this.iKT.a(d.getCurrentState());
            } else {
                this.iKT.a(DownloadStatus.STATUS_NONE);
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.iKT, d, this.iOk != null ? this.iOk.page : "");
            this.dhO = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
            aDC();
        }
    }

    public void aDC() {
        if (this.dhN != null && this.dhO != null) {
            com.baidu.tieba.ad.download.d.aDI().a(this.dhN, this.dhO);
        }
    }

    public void cgO() {
        if (this.dhN != null && this.dhO != null) {
            com.baidu.tieba.ad.download.d.aDI().b(this.dhN, this.dhO);
        }
    }
}
