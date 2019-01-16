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
    private TextView aLx;
    private HeadImageView eqy;
    private com.baidu.tieba.lego.card.c frw;
    private CustomMessageListener gRz;
    private ApkDownloadView gSj;
    private String gUC;
    private TextView gVr;

    public a(View view, String str) {
        super(view, str);
        this.gRz = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.e.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(a.this.gUC) && a.this.gUC.equals(downloadData.getId())) {
                    a.this.gSj.s(downloadData);
                }
            }
        };
        init();
    }

    private void init() {
        this.eqy = (HeadImageView) up(e.g.user_portrait);
        this.eqy.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.eqy.setDefaultResource(e.f.icon_default_avatar100);
        this.eqy.setDefaultBgResource(e.d.cp_bg_line_e);
        this.eqy.setIsRound(true);
        this.aLx = (TextView) up(e.g.user_name);
        this.gVr = (TextView) up(e.g.action);
        this.gSj = (ApkDownloadView) up(e.g.download_view);
        MessageManager.getInstance().registerListener(this.gRz);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(AdCard.f fVar) {
        super.a(fVar);
        this.eqy.startLoad(fVar.gQJ, 10, false);
        this.aLx.setText(fVar.userName);
        this.gVr.setText(fVar.buttonText);
        if (this.gVA != null) {
            View$OnClickListenerC0307a view$OnClickListenerC0307a = new View$OnClickListenerC0307a(this.gVA);
            this.mRootView.setOnClickListener(view$OnClickListenerC0307a);
            this.gSj.setOnClickListener(view$OnClickListenerC0307a);
            int intValue = Integer.valueOf(this.gVA.adPosition).intValue();
            this.gUC = this.gVA.apX;
            DownloadData c = c(this.gVA, intValue);
            c.setStatus(ApkDownloadView.getStatus(c));
            this.gSj.setData(c);
        }
        this.gSj.p(this.mContext.getUniqueId());
        this.gRz.setTag(this.mContext.getUniqueId());
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        al.j(this.mRootView, e.d.cp_cont_b_alpha80);
        al.c(this.aLx, e.d.cp_cont_i, 1);
        al.c(this.gVr, e.d.cp_cont_i, 1);
        al.e(this.gVr, e.d.cp_link_tip_a, 1);
        this.gSj.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* renamed from: com.baidu.tieba.recapp.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class View$OnClickListenerC0307a implements View.OnClickListener {
        private AdvertAppInfo gUF;

        public View$OnClickListenerC0307a(AdvertAppInfo advertAppInfo) {
            this.gUF = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.kK()) {
                a.this.mContext.showToast(e.j.neterror);
                return;
            }
            boolean z = view == a.this.gSj;
            if (this.gUF != null) {
                int l = com.baidu.adp.lib.g.b.l(this.gUF.adPosition, -1);
                int status = ApkDownloadView.getStatus(a.this.c(this.gUF, l));
                if ((6 != status && 7 != status) || !j.kV() || j.kW()) {
                    a.this.a(this.gUF, l, a.this.gSj, z);
                } else {
                    a.this.showDownloadAppDialog(this.gUF, l, true, this.gUF.aqd != null ? this.gUF.aqd.aqp : "");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.apX);
        downloadData.setUrl(advertAppInfo.apW);
        downloadData.setName(advertAppInfo.apT);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.g.b.l(advertAppInfo.apS, 0));
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
                        if (a.this.gSj != null) {
                            a.this.gSj.p(a.this.c(advertAppInfo, i));
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
                    g.aE(this.mContext.getPageActivity(), advertAppInfo.apX);
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
            } else if (this.frw != null) {
                this.frw.b(advertAppInfo, i);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        this.frw = cVar;
    }
}
