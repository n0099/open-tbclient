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
    private DownloadCacheKey eOp;
    private com.baidu.tieba.ad.download.a.d eOq;
    private HeadImageView hUH;
    private com.baidu.tieba.lego.card.c jac;
    private CustomMessageListener kMR;
    private ApkDownloadView kNC;
    private String kPy;
    private TextView kQp;
    private boolean kQq;
    protected boolean kQr;

    public a(View view, String str) {
        super(view, str);
        this.eOq = null;
        this.kQq = false;
        this.kMR = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.e.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(a.this.kPy) && a.this.kPy.equals(downloadData.getId())) {
                    a.this.kNC.t(downloadData);
                }
            }
        };
        init();
    }

    private void init() {
        this.hUH = (HeadImageView) Cz(R.id.user_portrait);
        this.hUH.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hUH.setDefaultResource(R.drawable.icon_default_avatar100);
        this.hUH.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hUH.setIsRound(true);
        this.dXU = (TextView) Cz(R.id.user_name);
        this.kQp = (TextView) Cz(R.id.action);
        this.kNC = (ApkDownloadView) Cz(R.id.download_view);
        MessageManager.getInstance().registerListener(this.kMR);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(AdCard.f fVar) {
        int i;
        super.a(fVar);
        this.hUH.startLoad(fVar.kLY, 10, false);
        this.dXU.setText(fVar.userName);
        this.kQp.setText(fVar.buttonText);
        this.kNC.setTextColor(am.getColor(R.color.cp_btn_a));
        if (this.kQB instanceof AdCard) {
            this.kQq = ((AdCard) this.kQB).directDownload;
        }
        if (this.kQA != null) {
            View$OnClickListenerC0714a view$OnClickListenerC0714a = new View$OnClickListenerC0714a(this.kQA);
            this.mRootView.setOnClickListener(view$OnClickListenerC0714a);
            if (cVE()) {
                this.kNC.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.e.a.1
                    @Override // com.baidu.tieba.ad.download.mvp.b.a
                    public void br(View view) {
                    }
                });
            } else {
                this.kNC.setOnClickListener(view$OnClickListenerC0714a);
            }
            try {
                i = TextUtils.isEmpty(this.kQA.adPosition) ? 0 : Integer.valueOf(this.kQA.adPosition).intValue();
            } catch (NumberFormatException e) {
                i = 0;
            }
            this.kPy = this.kQA.dAx;
            DownloadData c = c(this.kQA, i);
            o(c);
            this.kNC.setData(c);
        }
        if (!cVE()) {
            this.kNC.x(this.dIF.getUniqueId());
        }
        this.kMR.setTag(this.dIF.getUniqueId());
        cVF();
        onChangeSkinType();
    }

    private void o(DownloadData downloadData) {
        if (cVE()) {
            if (this.kNC != null) {
                downloadData.setStatus(this.kNC.getDownloadStatus());
                return;
            }
            return;
        }
        downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cVE() {
        return !this.kQq || this.kQr;
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        am.setViewTextColor(this.dXU, R.color.cp_cont_a, 1);
        am.setViewTextColor(this.kQp, R.color.cp_mask_c_alpha83, 1);
        am.setBackgroundColor(this.kQp, R.color.cp_link_tip_a, 1);
        this.kNC.setTextColorInitSkin(R.color.cp_cont_a);
        this.kNC.setBackgroundSkin(R.drawable.tail_frame_action_btn_bg);
        this.kNC.crv();
    }

    public void tI(boolean z) {
        this.kQr = z;
    }

    /* renamed from: com.baidu.tieba.recapp.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    private class View$OnClickListenerC0714a implements View.OnClickListener {
        private AdvertAppInfo kPB;

        public View$OnClickListenerC0714a(AdvertAppInfo advertAppInfo) {
            this.kPB = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                a.this.dIF.showToast(R.string.neterror);
                return;
            }
            boolean z = view == a.this.kNC;
            if (a.this.cVE()) {
                a.this.kNC.performClick();
            } else if (this.kPB != null) {
                int i = com.baidu.adp.lib.f.b.toInt(this.kPB.adPosition, -1);
                int status = ApkDownloadView.getStatus(a.this.c(this.kPB, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    a.this.a(this.kPB, i, a.this.kNC, z);
                } else {
                    a.this.showDownloadAppDialog(this.kPB, i, true, this.kPB.dAD != null ? this.kPB.dAD.dAP : "");
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
                        if (a.this.kNC != null) {
                            a.this.kNC.q(a.this.c(advertAppInfo, i));
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
            } else if (this.jac != null) {
                this.jac.b(advertAppInfo, i);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        this.jac = cVar;
    }

    private void cVF() {
        if (cVE() && this.kQA != null) {
            String str = this.kQA.dAu;
            DownloadCacheKey zX = !TextUtils.isEmpty(str) ? com.baidu.tieba.ad.download.d.bmF().zX(str) : null;
            if (zX == null) {
                zX = DownloadCacheKey.create(str, this.kQA.apkUrl, this.kQA.dAx);
                com.baidu.tieba.ad.download.d.bmF().a(zX, null);
            }
            i(zX);
        }
    }

    private void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.eOp = downloadCacheKey;
            cVG();
            AdDownloadData d = com.baidu.tieba.ad.download.d.bmF().d(downloadCacheKey);
            if (d != null) {
                this.kNC.a(d.getCurrentState());
            } else {
                this.kNC.a(DownloadStatus.STATUS_NONE);
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.kNC, d, this.kQA != null ? this.kQA.page : "");
            this.eOq = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
            bmz();
        }
    }

    public void bmz() {
        if (this.eOp != null && this.eOq != null) {
            com.baidu.tieba.ad.download.d.bmF().a(this.eOp, this.eOq);
        }
    }

    public void cVG() {
        if (this.eOp != null && this.eOq != null) {
            com.baidu.tieba.ad.download.d.bmF().b(this.eOp, this.eOq);
        }
    }
}
