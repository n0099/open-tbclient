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
/* loaded from: classes13.dex */
public class a extends e {
    private TextView cbL;
    private DownloadCacheKey dZm;
    private com.baidu.tieba.ad.download.a.d dZn;
    private HeadImageView gUd;
    private com.baidu.tieba.lego.card.c hYR;
    private CustomMessageListener jIz;
    private ApkDownloadView jJk;
    private String jLA;
    private TextView jMn;
    private boolean jMo;
    protected boolean jMp;

    public a(View view, String str) {
        super(view, str);
        this.dZn = null;
        this.jMo = false;
        this.jIz = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.e.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(a.this.jLA) && a.this.jLA.equals(downloadData.getId())) {
                    a.this.jJk.t(downloadData);
                }
            }
        };
        init();
    }

    private void init() {
        this.gUd = (HeadImageView) Bf(R.id.user_portrait);
        this.gUd.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gUd.setDefaultResource(R.drawable.icon_default_avatar100);
        this.gUd.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gUd.setIsRound(true);
        this.cbL = (TextView) Bf(R.id.user_name);
        this.jMn = (TextView) Bf(R.id.action);
        this.jJk = (ApkDownloadView) Bf(R.id.download_view);
        MessageManager.getInstance().registerListener(this.jIz);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(AdCard.f fVar) {
        super.a(fVar);
        this.gUd.startLoad(fVar.jHG, 10, false);
        this.cbL.setText(fVar.userName);
        this.jMn.setText(fVar.buttonText);
        this.jJk.setTextColor(am.getColor(R.color.cp_btn_a));
        if (this.jMz instanceof AdCard) {
            this.jMo = ((AdCard) this.jMz).directDownload;
        }
        if (this.jMy != null) {
            View$OnClickListenerC0598a view$OnClickListenerC0598a = new View$OnClickListenerC0598a(this.jMy);
            this.mRootView.setOnClickListener(view$OnClickListenerC0598a);
            if (cDu()) {
                this.jJk.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.e.a.1
                    @Override // com.baidu.tieba.ad.download.mvp.b.a
                    public void bp(View view) {
                    }
                });
            } else {
                this.jJk.setOnClickListener(view$OnClickListenerC0598a);
            }
            int intValue = Integer.valueOf(this.jMy.adPosition).intValue();
            this.jLA = this.jMy.cNa;
            DownloadData c = c(this.jMy, intValue);
            o(c);
            this.jJk.setData(c);
        }
        if (!cDu()) {
            this.jJk.u(this.cVi.getUniqueId());
        }
        this.jIz.setTag(this.cVi.getUniqueId());
        cDv();
        onChangeSkinType();
    }

    private void o(DownloadData downloadData) {
        if (cDu()) {
            if (this.jJk != null) {
                downloadData.setStatus(this.jJk.getDownloadStatus());
                return;
            }
            return;
        }
        downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cDu() {
        return !this.jMo || this.jMp;
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        am.setViewTextColor(this.cbL, R.color.cp_cont_a, 1);
        am.setViewTextColor(this.jMn, R.color.cp_mask_c_alpha83, 1);
        am.setBackgroundColor(this.jMn, R.color.cp_link_tip_a, 1);
        this.jJk.setTextColorInitSkin(R.color.cp_cont_a);
        this.jJk.setBackgroundSkin(R.drawable.tail_frame_action_btn_bg);
        this.jJk.bHt();
    }

    public void sd(boolean z) {
        this.jMp = z;
    }

    /* renamed from: com.baidu.tieba.recapp.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    private class View$OnClickListenerC0598a implements View.OnClickListener {
        private AdvertAppInfo jLD;

        public View$OnClickListenerC0598a(AdvertAppInfo advertAppInfo) {
            this.jLD = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                a.this.cVi.showToast(R.string.neterror);
                return;
            }
            boolean z = view == a.this.jJk;
            if (a.this.cDu()) {
                a.this.jJk.performClick();
            } else if (this.jLD != null) {
                int i = com.baidu.adp.lib.f.b.toInt(this.jLD.adPosition, -1);
                int status = ApkDownloadView.getStatus(a.this.c(this.jLD, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    a.this.a(this.jLD, i, a.this.jJk, z);
                } else {
                    a.this.showDownloadAppDialog(this.jLD, i, true, this.jLD.cNg != null ? this.jLD.cNg.cNs : "");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.cNa);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.cMY);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.cMX, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.cVi.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.aAq()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.cVi.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cVi.getPageActivity());
                aVar.sS(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.e.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        a.this.d(advertAppInfo, i);
                        if (a.this.jJk != null) {
                            a.this.jJk.q(a.this.c(advertAppInfo, i));
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
                aVar.b(this.cVi).aEC();
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
                    h.bd(this.cVi.getPageActivity(), advertAppInfo.cNa);
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
            if (!s.au(this.cVi.getPageActivity())) {
                l.showToast(this.cVi.getPageActivity(), (int) R.string.write_external_storage_permission_denied_fun_disable);
            } else if (this.hYR != null) {
                this.hYR.b(advertAppInfo, i);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        this.hYR = cVar;
    }

    private void cDv() {
        if (cDu() && this.jMy != null) {
            String str = this.jMy.cMX;
            DownloadCacheKey xb = !TextUtils.isEmpty(str) ? com.baidu.tieba.ad.download.d.aYl().xb(str) : null;
            if (xb == null) {
                xb = DownloadCacheKey.create(str, this.jMy.apkUrl, this.jMy.cNa);
                com.baidu.tieba.ad.download.d.aYl().a(xb, null);
            }
            i(xb);
        }
    }

    private void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.dZm = downloadCacheKey;
            cDw();
            AdDownloadData d = com.baidu.tieba.ad.download.d.aYl().d(downloadCacheKey);
            if (d != null) {
                this.jJk.a(d.getCurrentState());
            } else {
                this.jJk.a(DownloadStatus.STATUS_NONE);
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.jJk, d, this.jMy != null ? this.jMy.page : "");
            this.dZn = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
            aYf();
        }
    }

    public void aYf() {
        if (this.dZm != null && this.dZn != null) {
            com.baidu.tieba.ad.download.d.aYl().a(this.dZm, this.dZn);
        }
    }

    public void cDw() {
        if (this.dZm != null && this.dZn != null) {
            com.baidu.tieba.ad.download.d.aYl().b(this.dZm, this.dZn);
        }
    }
}
