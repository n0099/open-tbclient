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
    private TextView dXU;
    private DownloadCacheKey eOe;
    private com.baidu.tieba.ad.download.a.d eOf;
    private HeadImageView hTU;
    private com.baidu.tieba.lego.card.c iZp;
    private CustomMessageListener kLI;
    private ApkDownloadView kMt;
    private String kOp;
    private TextView kPg;
    private boolean kPh;
    protected boolean kPi;

    public a(View view, String str) {
        super(view, str);
        this.eOf = null;
        this.kPh = false;
        this.kLI = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.e.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(a.this.kOp) && a.this.kOp.equals(downloadData.getId())) {
                    a.this.kMt.t(downloadData);
                }
            }
        };
        init();
    }

    private void init() {
        this.hTU = (HeadImageView) Cx(R.id.user_portrait);
        this.hTU.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hTU.setDefaultResource(R.drawable.icon_default_avatar100);
        this.hTU.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hTU.setIsRound(true);
        this.dXU = (TextView) Cx(R.id.user_name);
        this.kPg = (TextView) Cx(R.id.action);
        this.kMt = (ApkDownloadView) Cx(R.id.download_view);
        MessageManager.getInstance().registerListener(this.kLI);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(AdCard.f fVar) {
        int i;
        super.a(fVar);
        this.hTU.startLoad(fVar.kKP, 10, false);
        this.dXU.setText(fVar.userName);
        this.kPg.setText(fVar.buttonText);
        this.kMt.setTextColor(am.getColor(R.color.cp_btn_a));
        if (this.kPs instanceof AdCard) {
            this.kPh = ((AdCard) this.kPs).directDownload;
        }
        if (this.kPr != null) {
            View$OnClickListenerC0713a view$OnClickListenerC0713a = new View$OnClickListenerC0713a(this.kPr);
            this.mRootView.setOnClickListener(view$OnClickListenerC0713a);
            if (cVo()) {
                this.kMt.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.e.a.1
                    @Override // com.baidu.tieba.ad.download.mvp.b.a
                    public void br(View view) {
                    }
                });
            } else {
                this.kMt.setOnClickListener(view$OnClickListenerC0713a);
            }
            try {
                i = TextUtils.isEmpty(this.kPr.adPosition) ? 0 : Integer.valueOf(this.kPr.adPosition).intValue();
            } catch (NumberFormatException e) {
                i = 0;
            }
            this.kOp = this.kPr.dAx;
            DownloadData c = c(this.kPr, i);
            o(c);
            this.kMt.setData(c);
        }
        if (!cVo()) {
            this.kMt.x(this.dIF.getUniqueId());
        }
        this.kLI.setTag(this.dIF.getUniqueId());
        cVp();
        onChangeSkinType();
    }

    private void o(DownloadData downloadData) {
        if (cVo()) {
            if (this.kMt != null) {
                downloadData.setStatus(this.kMt.getDownloadStatus());
                return;
            }
            return;
        }
        downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cVo() {
        return !this.kPh || this.kPi;
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        am.setViewTextColor(this.dXU, R.color.cp_cont_a, 1);
        am.setViewTextColor(this.kPg, R.color.cp_mask_c_alpha83, 1);
        am.setBackgroundColor(this.kPg, R.color.cp_link_tip_a, 1);
        this.kMt.setTextColorInitSkin(R.color.cp_cont_a);
        this.kMt.setBackgroundSkin(R.drawable.tail_frame_action_btn_bg);
        this.kMt.crm();
    }

    public void tI(boolean z) {
        this.kPi = z;
    }

    /* renamed from: com.baidu.tieba.recapp.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    private class View$OnClickListenerC0713a implements View.OnClickListener {
        private AdvertAppInfo kOs;

        public View$OnClickListenerC0713a(AdvertAppInfo advertAppInfo) {
            this.kOs = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                a.this.dIF.showToast(R.string.neterror);
                return;
            }
            boolean z = view == a.this.kMt;
            if (a.this.cVo()) {
                a.this.kMt.performClick();
            } else if (this.kOs != null) {
                int i = com.baidu.adp.lib.f.b.toInt(this.kOs.adPosition, -1);
                int status = ApkDownloadView.getStatus(a.this.c(this.kOs, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    a.this.a(this.kOs, i, a.this.kMt, z);
                } else {
                    a.this.showDownloadAppDialog(this.kOs, i, true, this.kOs.dAD != null ? this.kOs.dAD.dAP : "");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.dAx);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.dAv);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.dAu, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.dIF.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.aOz()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.dIF.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dIF.getPageActivity());
                aVar.vO(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.e.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        a.this.d(advertAppInfo, i);
                        if (a.this.kMt != null) {
                            a.this.kMt.q(a.this.c(advertAppInfo, i));
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
                aVar.b(this.dIF).aST();
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
                    h.aN(this.dIF.getPageActivity(), advertAppInfo.dAx);
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
            if (!r.ap(this.dIF.getPageActivity())) {
                l.showToast(this.dIF.getPageActivity(), (int) R.string.write_external_storage_permission_denied_fun_disable);
            } else if (this.iZp != null) {
                this.iZp.b(advertAppInfo, i);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        this.iZp = cVar;
    }

    private void cVp() {
        if (cVo() && this.kPr != null) {
            String str = this.kPr.dAu;
            DownloadCacheKey zX = !TextUtils.isEmpty(str) ? com.baidu.tieba.ad.download.d.bmD().zX(str) : null;
            if (zX == null) {
                zX = DownloadCacheKey.create(str, this.kPr.apkUrl, this.kPr.dAx);
                com.baidu.tieba.ad.download.d.bmD().a(zX, null);
            }
            i(zX);
        }
    }

    private void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.eOe = downloadCacheKey;
            cVq();
            AdDownloadData d = com.baidu.tieba.ad.download.d.bmD().d(downloadCacheKey);
            if (d != null) {
                this.kMt.a(d.getCurrentState());
            } else {
                this.kMt.a(DownloadStatus.STATUS_NONE);
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.kMt, d, this.kPr != null ? this.kPr.page : "");
            this.eOf = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
            bmx();
        }
    }

    public void bmx() {
        if (this.eOe != null && this.eOf != null) {
            com.baidu.tieba.ad.download.d.bmD().a(this.eOe, this.eOf);
        }
    }

    public void cVq() {
        if (this.eOe != null && this.eOf != null) {
            com.baidu.tieba.ad.download.d.bmD().b(this.eOe, this.eOf);
        }
    }
}
