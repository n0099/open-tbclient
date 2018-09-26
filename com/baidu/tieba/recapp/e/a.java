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
    private TextView aBX;
    private HeadImageView dWU;
    private com.baidu.tieba.lego.card.c eXQ;
    private String gAO;
    private TextView gBE;
    private CustomMessageListener gxM;
    private ApkDownloadView gyw;

    public a(View view, String str) {
        super(view, str);
        this.gxM = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.e.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(a.this.gAO) && a.this.gAO.equals(downloadData.getId())) {
                    a.this.gyw.s(downloadData);
                }
            }
        };
        init();
    }

    private void init() {
        this.dWU = (HeadImageView) sP(e.g.user_portrait);
        this.dWU.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.dWU.setDefaultResource(e.f.icon_default_avatar100);
        this.dWU.setDefaultBgResource(e.d.cp_bg_line_e);
        this.dWU.setIsRound(true);
        this.aBX = (TextView) sP(e.g.user_name);
        this.gBE = (TextView) sP(e.g.action);
        this.gyw = (ApkDownloadView) sP(e.g.download_view);
        MessageManager.getInstance().registerListener(this.gxM);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(AdCard.f fVar) {
        super.a(fVar);
        this.dWU.startLoad(fVar.gwW, 10, false);
        this.aBX.setText(fVar.userName);
        this.gBE.setText(fVar.buttonText);
        if (this.gBO != null) {
            View$OnClickListenerC0233a view$OnClickListenerC0233a = new View$OnClickListenerC0233a(this.gBO);
            this.mRootView.setOnClickListener(view$OnClickListenerC0233a);
            this.gyw.setOnClickListener(view$OnClickListenerC0233a);
            int intValue = Integer.valueOf(this.gBO.adPosition).intValue();
            this.gAO = this.gBO.agk;
            DownloadData c = c(this.gBO, intValue);
            c.setStatus(ApkDownloadView.getStatus(c));
            this.gyw.setData(c);
        }
        this.gyw.p(this.mContext.getUniqueId());
        this.gxM.setTag(this.mContext.getUniqueId());
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        al.j(this.mRootView, e.d.cp_cont_b_alpha80);
        al.c(this.aBX, e.d.cp_cont_i, 1);
        al.c(this.gBE, e.d.cp_cont_i, 1);
        al.e(this.gBE, e.d.cp_link_tip_a, 1);
        this.gyw.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* renamed from: com.baidu.tieba.recapp.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class View$OnClickListenerC0233a implements View.OnClickListener {
        private AdvertAppInfo gAR;

        public View$OnClickListenerC0233a(AdvertAppInfo advertAppInfo) {
            this.gAR = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.ky()) {
                a.this.mContext.showToast(e.j.neterror);
                return;
            }
            boolean z = view == a.this.gyw;
            if (this.gAR != null) {
                int l = com.baidu.adp.lib.g.b.l(this.gAR.adPosition, -1);
                int status = ApkDownloadView.getStatus(a.this.c(this.gAR, l));
                if ((6 != status && 7 != status) || !j.kK() || j.kL()) {
                    a.this.a(this.gAR, l, a.this.gyw, z);
                } else {
                    a.this.showDownloadAppDialog(this.gAR, l, true, this.gAR.agr != null ? this.gAR.agr.agD : "");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.agk);
        downloadData.setUrl(advertAppInfo.agj);
        downloadData.setName(advertAppInfo.agg);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.g.b.l(advertAppInfo.agf, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.ky()) {
                l.showToast(this.mContext.getPageActivity(), e.j.neterror);
            } else if (advertAppInfo.uI()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(e.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.dT(str);
                aVar.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.e.a.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        a.this.d(advertAppInfo, i);
                        if (a.this.gyw != null) {
                            a.this.gyw.p(a.this.c(advertAppInfo, i));
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
                aVar.b(this.mContext).yl();
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
                    g.aD(this.mContext.getPageActivity(), advertAppInfo.agk);
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
            if (!s.I(this.mContext.getPageActivity())) {
                l.showToast(this.mContext.getPageActivity(), e.j.write_external_storage_permission_denied_fun_disable);
            } else if (this.eXQ != null) {
                this.eXQ.b(advertAppInfo, i);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        this.eXQ = cVar;
    }
}
