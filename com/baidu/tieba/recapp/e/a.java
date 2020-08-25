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
    private TextView dTQ;
    private DownloadCacheKey fov;
    private com.baidu.tieba.ad.download.a.d fow;
    private HeadImageView iDl;
    private com.baidu.tieba.lego.card.c jPl;
    private CustomMessageListener lEA;
    private ApkDownloadView lFl;
    private TextView lHY;
    private boolean lHZ;
    private String lHh;
    protected boolean lIa;

    public a(View view, String str) {
        super(view, str);
        this.fow = null;
        this.lHZ = false;
        this.lEA = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.e.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(a.this.lHh) && a.this.lHh.equals(downloadData.getId())) {
                    a.this.lFl.t(downloadData);
                }
            }
        };
        init();
    }

    private void init() {
        this.iDl = (HeadImageView) Gs(R.id.user_portrait);
        this.iDl.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.iDl.setDefaultResource(R.drawable.icon_default_avatar100);
        this.iDl.setDefaultBgResource(R.color.cp_bg_line_e);
        this.iDl.setIsRound(true);
        this.dTQ = (TextView) Gs(R.id.user_name);
        this.lHY = (TextView) Gs(R.id.action);
        this.lFl = (ApkDownloadView) Gs(R.id.download_view);
        MessageManager.getInstance().registerListener(this.lEA);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(AdCard.f fVar) {
        int i;
        super.a(fVar);
        this.iDl.startLoad(fVar.lDJ, 10, false);
        this.dTQ.setText(fVar.userName);
        this.lHY.setText(fVar.buttonText);
        this.lFl.setTextColor(ap.getColor(R.color.cp_btn_a));
        if (this.lIk instanceof AdCard) {
            this.lHZ = ((AdCard) this.lIk).directDownload;
        }
        if (this.lIj != null) {
            View$OnClickListenerC0792a view$OnClickListenerC0792a = new View$OnClickListenerC0792a(this.lIj);
            this.mRootView.setOnClickListener(view$OnClickListenerC0792a);
            if (dom()) {
                this.lFl.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.e.a.1
                    @Override // com.baidu.tieba.ad.download.mvp.b.a
                    public boolean bC(View view) {
                        return false;
                    }
                });
            } else {
                this.lFl.setOnClickListener(view$OnClickListenerC0792a);
            }
            try {
                i = TextUtils.isEmpty(this.lIj.adPosition) ? 0 : Integer.valueOf(this.lIj.adPosition).intValue();
            } catch (NumberFormatException e) {
                i = 0;
            }
            this.lHh = this.lIj.dWi;
            DownloadData b = b(this.lIj, i);
            h(b);
            this.lFl.setData(b);
        }
        if (!dom()) {
            this.lFl.y(this.efn.getUniqueId());
        }
        this.lEA.setTag(this.efn.getUniqueId());
        don();
        onChangeSkinType();
    }

    private void h(DownloadData downloadData) {
        if (dom()) {
            if (this.lFl != null) {
                downloadData.setStatus(this.lFl.getDownloadStatus());
                return;
            }
            return;
        }
        downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dom() {
        return !this.lHZ || this.lIa;
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ap.setViewTextColor(this.dTQ, R.color.cp_cont_a, 1);
        ap.setViewTextColor(this.lHY, R.color.cp_mask_c_alpha83, 1);
        ap.setBackgroundColor(this.lHY, R.color.cp_link_tip_a, 1);
        this.lFl.setTextColorInitSkin(R.color.cp_cont_a);
        this.lFl.setBackgroundSkin(R.drawable.tail_frame_action_btn_bg);
        this.lFl.changeSkin();
    }

    public void vo(boolean z) {
        this.lIa = z;
    }

    /* renamed from: com.baidu.tieba.recapp.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    private class View$OnClickListenerC0792a implements View.OnClickListener {
        private AdvertAppInfo lHk;

        public View$OnClickListenerC0792a(AdvertAppInfo advertAppInfo) {
            this.lHk = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                a.this.efn.showToast(R.string.neterror);
                return;
            }
            boolean z = view == a.this.lFl;
            com.baidu.tieba.lego.card.b.c.a(a.this.lIk);
            if (a.this.dom()) {
                a.this.lFl.performClick();
            } else if (this.lHk != null) {
                int i = com.baidu.adp.lib.f.b.toInt(this.lHk.adPosition, -1);
                int status = ApkDownloadView.getStatus(a.this.b(this.lHk, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    a.this.a(this.lHk, i, a.this.lFl, z);
                } else {
                    a.this.showDownloadAppDialog(this.lHk, i, true, this.lHk.dWo != null ? this.lHk.dWo.dWA : "");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData b(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.dWi);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.dWg);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.dWf, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.efn.getPageActivity(), R.string.neterror);
            } else if (advertAppInfo.bcw()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.efn.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.efn.getPageActivity());
                aVar.zz(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.e.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        a.this.d(advertAppInfo, i);
                        if (a.this.lFl != null) {
                            a.this.lFl.q(a.this.b(advertAppInfo, i));
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
                aVar.b(this.efn).bhg();
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
                    h.aQ(this.efn.getPageActivity(), advertAppInfo.dWi);
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
            if (!s.as(this.efn.getPageActivity())) {
                l.showToast(this.efn.getPageActivity(), R.string.write_external_storage_permission_denied_fun_disable);
            } else if (this.jPl != null) {
                this.jPl.c(advertAppInfo, i);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        this.jPl = cVar;
    }

    private void don() {
        if (dom() && this.lIj != null) {
            String str = this.lIj.dWf;
            DownloadCacheKey Dv = !TextUtils.isEmpty(str) ? com.baidu.tieba.ad.download.d.bBf().Dv(str) : null;
            if (Dv == null) {
                Dv = DownloadCacheKey.create(str, this.lIj.apkUrl, this.lIj.dWi);
                com.baidu.tieba.ad.download.d.bBf().a(Dv, null);
            }
            i(Dv);
        }
    }

    private void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.fov = downloadCacheKey;
            doo();
            AdDownloadData d = com.baidu.tieba.ad.download.d.bBf().d(downloadCacheKey);
            if (d != null) {
                this.lFl.a(d.getCurrentState());
            } else {
                this.lFl.a(DownloadStatus.STATUS_NONE);
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.lFl, d, this.lIj != null ? this.lIj.page : "");
            this.fow = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
            bAY();
        }
    }

    public void bAY() {
        if (this.fov != null && this.fow != null) {
            com.baidu.tieba.ad.download.d.bBf().a(this.fov, this.fow);
        }
    }

    public void doo() {
        if (this.fov != null && this.fow != null) {
            com.baidu.tieba.ad.download.d.bBf().b(this.fov, this.fow);
        }
    }
}
