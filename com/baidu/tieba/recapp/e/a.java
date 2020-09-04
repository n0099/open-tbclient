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
/* loaded from: classes20.dex */
public class a extends e {
    private TextView dTU;
    private com.baidu.tieba.ad.download.a.d foA;
    private DownloadCacheKey foz;
    private HeadImageView iDr;
    private com.baidu.tieba.lego.card.c jPr;
    private CustomMessageListener lEL;
    private ApkDownloadView lFy;
    private String lHu;
    private TextView lIl;
    private boolean lIm;
    protected boolean lIn;

    public a(View view, String str) {
        super(view, str);
        this.foA = null;
        this.lIm = false;
        this.lEL = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.e.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(a.this.lHu) && a.this.lHu.equals(downloadData.getId())) {
                    a.this.lFy.t(downloadData);
                }
            }
        };
        init();
    }

    private void init() {
        this.iDr = (HeadImageView) Gs(R.id.user_portrait);
        this.iDr.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.iDr.setDefaultResource(R.drawable.icon_default_avatar100);
        this.iDr.setDefaultBgResource(R.color.cp_bg_line_e);
        this.iDr.setIsRound(true);
        this.dTU = (TextView) Gs(R.id.user_name);
        this.lIl = (TextView) Gs(R.id.action);
        this.lFy = (ApkDownloadView) Gs(R.id.download_view);
        MessageManager.getInstance().registerListener(this.lEL);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(AdCard.f fVar) {
        int i;
        super.a(fVar);
        this.iDr.startLoad(fVar.lDU, 10, false);
        this.dTU.setText(fVar.userName);
        this.lIl.setText(fVar.buttonText);
        this.lFy.setTextColor(ap.getColor(R.color.cp_btn_a));
        if (this.lIx instanceof AdCard) {
            this.lIm = ((AdCard) this.lIx).directDownload;
        }
        if (this.lIw != null) {
            View$OnClickListenerC0792a view$OnClickListenerC0792a = new View$OnClickListenerC0792a(this.lIw);
            this.mRootView.setOnClickListener(view$OnClickListenerC0792a);
            if (dop()) {
                this.lFy.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.e.a.1
                    @Override // com.baidu.tieba.ad.download.mvp.b.a
                    public boolean bC(View view) {
                        return false;
                    }
                });
            } else {
                this.lFy.setOnClickListener(view$OnClickListenerC0792a);
            }
            try {
                i = TextUtils.isEmpty(this.lIw.adPosition) ? 0 : Integer.valueOf(this.lIw.adPosition).intValue();
            } catch (NumberFormatException e) {
                i = 0;
            }
            this.lHu = this.lIw.dWm;
            DownloadData b = b(this.lIw, i);
            h(b);
            this.lFy.setData(b);
        }
        if (!dop()) {
            this.lFy.y(this.efr.getUniqueId());
        }
        this.lEL.setTag(this.efr.getUniqueId());
        doq();
        onChangeSkinType();
    }

    private void h(DownloadData downloadData) {
        if (dop()) {
            if (this.lFy != null) {
                downloadData.setStatus(this.lFy.getDownloadStatus());
                return;
            }
            return;
        }
        downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dop() {
        return !this.lIm || this.lIn;
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ap.setViewTextColor(this.dTU, R.color.cp_cont_a, 1);
        ap.setViewTextColor(this.lIl, R.color.cp_mask_c_alpha83, 1);
        ap.setBackgroundColor(this.lIl, R.color.cp_link_tip_a, 1);
        this.lFy.setTextColorInitSkin(R.color.cp_cont_a);
        this.lFy.setBackgroundSkin(R.drawable.tail_frame_action_btn_bg);
        this.lFy.changeSkin();
    }

    public void vq(boolean z) {
        this.lIn = z;
    }

    /* renamed from: com.baidu.tieba.recapp.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    private class View$OnClickListenerC0792a implements View.OnClickListener {
        private AdvertAppInfo lHx;

        public View$OnClickListenerC0792a(AdvertAppInfo advertAppInfo) {
            this.lHx = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                a.this.efr.showToast(R.string.neterror);
                return;
            }
            boolean z = view == a.this.lFy;
            com.baidu.tieba.lego.card.b.c.a(a.this.lIx);
            if (a.this.dop()) {
                a.this.lFy.performClick();
            } else if (this.lHx != null) {
                int i = com.baidu.adp.lib.f.b.toInt(this.lHx.adPosition, -1);
                int status = ApkDownloadView.getStatus(a.this.b(this.lHx, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    a.this.a(this.lHx, i, a.this.lFy, z);
                } else {
                    a.this.showDownloadAppDialog(this.lHx, i, true, this.lHx.dWs != null ? this.lHx.dWs.dWE : "");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData b(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.dWm);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.dWk);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.dWj, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.efr.getPageActivity(), R.string.neterror);
            } else if (advertAppInfo.bcw()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.efr.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.efr.getPageActivity());
                aVar.zA(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.e.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        a.this.d(advertAppInfo, i);
                        if (a.this.lFy != null) {
                            a.this.lFy.q(a.this.b(advertAppInfo, i));
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
                aVar.b(this.efr).bhg();
            }
        }
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView, boolean z) {
        if (advertAppInfo != null) {
            DownloadData b = b(advertAppInfo, i);
            int status = ApkDownloadView.getStatus(b);
            Log.e("guoqiangxiang", "status: " + status + " id: " + b.getId());
            switch (status) {
                case 1:
                case 5:
                    h.e(advertAppInfo);
                    apkDownloadView.r(b);
                    return;
                case 2:
                case 4:
                default:
                    return;
                case 3:
                    h.aQ(this.efr.getPageActivity(), advertAppInfo.dWm);
                    return;
                case 6:
                case 7:
                    d(advertAppInfo, i);
                    apkDownloadView.s(b);
                    return;
            }
        }
    }

    protected void d(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo != null) {
            if (!s.as(this.efr.getPageActivity())) {
                l.showToast(this.efr.getPageActivity(), R.string.write_external_storage_permission_denied_fun_disable);
            } else if (this.jPr != null) {
                this.jPr.c(advertAppInfo, i);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        this.jPr = cVar;
    }

    private void doq() {
        if (dop() && this.lIw != null) {
            String str = this.lIw.dWj;
            DownloadCacheKey Dw = !TextUtils.isEmpty(str) ? com.baidu.tieba.ad.download.d.bBg().Dw(str) : null;
            if (Dw == null) {
                Dw = DownloadCacheKey.create(str, this.lIw.apkUrl, this.lIw.dWm);
                com.baidu.tieba.ad.download.d.bBg().a(Dw, null);
            }
            i(Dw);
        }
    }

    private void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.foz = downloadCacheKey;
            dor();
            AdDownloadData d = com.baidu.tieba.ad.download.d.bBg().d(downloadCacheKey);
            if (d != null) {
                this.lFy.a(d.getCurrentState());
            } else {
                this.lFy.a(DownloadStatus.STATUS_NONE);
            }
            String str = this.lIw != null ? this.lIw.page : "";
            d.setExtInfo(this.lIw != null ? this.lIw.extensionInfo : "");
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.lFy, d, str);
            this.foA = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
            bAZ();
        }
    }

    public void bAZ() {
        if (this.foz != null && this.foA != null) {
            com.baidu.tieba.ad.download.d.bBg().a(this.foz, this.foA);
        }
    }

    public void dor() {
        if (this.foz != null && this.foA != null) {
            com.baidu.tieba.ad.download.d.bBg().b(this.foz, this.foA);
        }
    }
}
