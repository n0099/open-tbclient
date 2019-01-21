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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.e;
import com.baidu.tieba.recapp.download.g;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
/* loaded from: classes3.dex */
public class a extends e {
    private TextView aLy;
    private HeadImageView eqz;
    private com.baidu.tieba.lego.card.c frx;
    private CustomMessageListener gRA;
    private ApkDownloadView gSk;
    private String gUD;
    private TextView gVs;

    public a(View view, String str) {
        super(view, str);
        this.gRA = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.e.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(a.this.gUD) && a.this.gUD.equals(downloadData.getId())) {
                    a.this.gSk.s(downloadData);
                }
            }
        };
        init();
    }

    private void init() {
        this.eqz = (HeadImageView) up(e.g.user_portrait);
        this.eqz.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.eqz.setDefaultResource(e.f.icon_default_avatar100);
        this.eqz.setDefaultBgResource(e.d.cp_bg_line_e);
        this.eqz.setIsRound(true);
        this.aLy = (TextView) up(e.g.user_name);
        this.gVs = (TextView) up(e.g.action);
        this.gSk = (ApkDownloadView) up(e.g.download_view);
        MessageManager.getInstance().registerListener(this.gRA);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(AdCard.f fVar) {
        super.a(fVar);
        this.eqz.startLoad(fVar.gQK, 10, false);
        this.aLy.setText(fVar.userName);
        this.gVs.setText(fVar.buttonText);
        if (this.gVB != null) {
            View$OnClickListenerC0307a view$OnClickListenerC0307a = new View$OnClickListenerC0307a(this.gVB);
            this.mRootView.setOnClickListener(view$OnClickListenerC0307a);
            this.gSk.setOnClickListener(view$OnClickListenerC0307a);
            int intValue = Integer.valueOf(this.gVB.adPosition).intValue();
            this.gUD = this.gVB.apY;
            DownloadData c = c(this.gVB, intValue);
            c.setStatus(ApkDownloadView.getStatus(c));
            this.gSk.setData(c);
        }
        this.gSk.p(this.mContext.getUniqueId());
        this.gRA.setTag(this.mContext.getUniqueId());
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        al.j(this.mRootView, e.d.cp_cont_b_alpha80);
        al.c(this.aLy, e.d.cp_cont_i, 1);
        al.c(this.gVs, e.d.cp_cont_i, 1);
        al.e(this.gVs, e.d.cp_link_tip_a, 1);
        this.gSk.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* renamed from: com.baidu.tieba.recapp.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class View$OnClickListenerC0307a implements View.OnClickListener {
        private AdvertAppInfo gUG;

        public View$OnClickListenerC0307a(AdvertAppInfo advertAppInfo) {
            this.gUG = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.kK()) {
                a.this.mContext.showToast(e.j.neterror);
                return;
            }
            boolean z = view == a.this.gSk;
            if (this.gUG != null) {
                int l = com.baidu.adp.lib.g.b.l(this.gUG.adPosition, -1);
                int status = ApkDownloadView.getStatus(a.this.c(this.gUG, l));
                if ((6 != status && 7 != status) || !j.kV() || j.kW()) {
                    a.this.a(this.gUG, l, a.this.gSk, z);
                } else {
                    a.this.showDownloadAppDialog(this.gUG, l, true, this.gUG.aqe != null ? this.gUG.aqe.aqq : "");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.apY);
        downloadData.setUrl(advertAppInfo.apX);
        downloadData.setName(advertAppInfo.apU);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.g.b.l(advertAppInfo.apT, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.kK()) {
                l.showToast(this.mContext.getPageActivity(), e.j.neterror);
            } else if (advertAppInfo.yq()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(e.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.eK(str);
                aVar.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.e.a.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        a.this.d(advertAppInfo, i);
                        if (a.this.gSk != null) {
                            a.this.gSk.p(a.this.c(advertAppInfo, i));
                        }
                        aVar2.dismiss();
                    }
                });
                aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.recapp.e.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.mContext).BS();
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
                    g.f(advertAppInfo);
                    apkDownloadView.q(c);
                    return;
                case 2:
                case 4:
                default:
                    return;
                case 3:
                    g.aE(this.mContext.getPageActivity(), advertAppInfo.apY);
                    return;
                case 6:
                case 7:
                    d(advertAppInfo, i);
                    apkDownloadView.r(c);
                    return;
            }
        }
    }

    protected void d(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo != null) {
            if (!s.O(this.mContext.getPageActivity())) {
                l.showToast(this.mContext.getPageActivity(), e.j.write_external_storage_permission_denied_fun_disable);
            } else if (this.frx != null) {
                this.frx.b(advertAppInfo, i);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        this.frx = cVar;
    }
}
