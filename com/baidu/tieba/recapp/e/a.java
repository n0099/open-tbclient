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
    private TextView aHt;
    private HeadImageView egi;
    private com.baidu.tieba.lego.card.c fgR;
    private CustomMessageListener gGO;
    private ApkDownloadView gHy;
    private String gJP;
    private TextView gKE;

    public a(View view, String str) {
        super(view, str);
        this.gGO = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.e.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(a.this.gJP) && a.this.gJP.equals(downloadData.getId())) {
                    a.this.gHy.s(downloadData);
                }
            }
        };
        init();
    }

    private void init() {
        this.egi = (HeadImageView) tF(e.g.user_portrait);
        this.egi.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.egi.setDefaultResource(e.f.icon_default_avatar100);
        this.egi.setDefaultBgResource(e.d.cp_bg_line_e);
        this.egi.setIsRound(true);
        this.aHt = (TextView) tF(e.g.user_name);
        this.gKE = (TextView) tF(e.g.action);
        this.gHy = (ApkDownloadView) tF(e.g.download_view);
        MessageManager.getInstance().registerListener(this.gGO);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(AdCard.f fVar) {
        super.a(fVar);
        this.egi.startLoad(fVar.gFY, 10, false);
        this.aHt.setText(fVar.userName);
        this.gKE.setText(fVar.buttonText);
        if (this.gKN != null) {
            View$OnClickListenerC0296a view$OnClickListenerC0296a = new View$OnClickListenerC0296a(this.gKN);
            this.mRootView.setOnClickListener(view$OnClickListenerC0296a);
            this.gHy.setOnClickListener(view$OnClickListenerC0296a);
            int intValue = Integer.valueOf(this.gKN.adPosition).intValue();
            this.gJP = this.gKN.alU;
            DownloadData c = c(this.gKN, intValue);
            c.setStatus(ApkDownloadView.getStatus(c));
            this.gHy.setData(c);
        }
        this.gHy.p(this.mContext.getUniqueId());
        this.gGO.setTag(this.mContext.getUniqueId());
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        al.j(this.mRootView, e.d.cp_cont_b_alpha80);
        al.c(this.aHt, e.d.cp_cont_i, 1);
        al.c(this.gKE, e.d.cp_cont_i, 1);
        al.e(this.gKE, e.d.cp_link_tip_a, 1);
        this.gHy.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* renamed from: com.baidu.tieba.recapp.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class View$OnClickListenerC0296a implements View.OnClickListener {
        private AdvertAppInfo gJS;

        public View$OnClickListenerC0296a(AdvertAppInfo advertAppInfo) {
            this.gJS = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.kK()) {
                a.this.mContext.showToast(e.j.neterror);
                return;
            }
            boolean z = view == a.this.gHy;
            if (this.gJS != null) {
                int l = com.baidu.adp.lib.g.b.l(this.gJS.adPosition, -1);
                int status = ApkDownloadView.getStatus(a.this.c(this.gJS, l));
                if ((6 != status && 7 != status) || !j.kV() || j.kW()) {
                    a.this.a(this.gJS, l, a.this.gHy, z);
                } else {
                    a.this.showDownloadAppDialog(this.gJS, l, true, this.gJS.ama != null ? this.gJS.ama.amm : "");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.alU);
        downloadData.setUrl(advertAppInfo.alT);
        downloadData.setName(advertAppInfo.alQ);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.g.b.l(advertAppInfo.alP, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.kK()) {
                l.showToast(this.mContext.getPageActivity(), e.j.neterror);
            } else if (advertAppInfo.wZ()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(e.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.ej(str);
                aVar.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.e.a.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        a.this.d(advertAppInfo, i);
                        if (a.this.gHy != null) {
                            a.this.gHy.p(a.this.c(advertAppInfo, i));
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
                aVar.b(this.mContext).AB();
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
                    g.aD(this.mContext.getPageActivity(), advertAppInfo.alU);
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
            } else if (this.fgR != null) {
                this.fgR.b(advertAppInfo, i);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        this.fgR = cVar;
    }
}
