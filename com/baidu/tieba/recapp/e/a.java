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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.download.g;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
/* loaded from: classes3.dex */
public class a extends e {
    private TextView aqm;
    private HeadImageView dxn;
    private com.baidu.tieba.lego.card.c ewn;
    private CustomMessageListener fYV;
    private ApkDownloadView fZF;
    private String gbT;
    private TextView gcG;

    public a(View view2, String str) {
        super(view2, str);
        this.fYV = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.e.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(a.this.gbT) && a.this.gbT.equals(downloadData.getId())) {
                    a.this.fZF.u(downloadData);
                }
            }
        };
        init();
    }

    private void init() {
        this.dxn = (HeadImageView) rY(d.g.user_portrait);
        this.dxn.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.dxn.setDefaultResource(d.f.icon_default_avatar100);
        this.dxn.setDefaultBgResource(d.C0126d.cp_bg_line_e);
        this.dxn.setIsRound(true);
        this.aqm = (TextView) rY(d.g.user_name);
        this.gcG = (TextView) rY(d.g.action);
        this.fZF = (ApkDownloadView) rY(d.g.download_view);
        MessageManager.getInstance().registerListener(this.fYV);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(AdCard.f fVar) {
        super.a(fVar);
        this.dxn.startLoad(fVar.fYg, 10, false);
        this.aqm.setText(fVar.userName);
        this.gcG.setText(fVar.buttonText);
        if (this.gcQ != null) {
            View$OnClickListenerC0208a view$OnClickListenerC0208a = new View$OnClickListenerC0208a(this.gcQ);
            this.mRootView.setOnClickListener(view$OnClickListenerC0208a);
            this.fZF.setOnClickListener(view$OnClickListenerC0208a);
            int intValue = Integer.valueOf(this.gcQ.adPosition).intValue();
            this.gbT = this.gcQ.VU;
            DownloadData c = c(this.gcQ, intValue);
            c.setStatus(ApkDownloadView.getStatus(c));
            this.fZF.setData(c);
        }
        this.fZF.p(this.adf.getUniqueId());
        this.fYV.setTag(this.adf.getUniqueId());
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ak.j(this.mRootView, d.C0126d.cp_cont_b_alpha80);
        ak.c(this.aqm, d.C0126d.cp_cont_i, 1);
        ak.c(this.gcG, d.C0126d.cp_cont_i, 1);
        ak.e(this.gcG, d.C0126d.cp_link_tip_a, 1);
        this.fZF.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* renamed from: com.baidu.tieba.recapp.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class View$OnClickListenerC0208a implements View.OnClickListener {
        private AdvertAppInfo gbW;

        public View$OnClickListenerC0208a(AdvertAppInfo advertAppInfo) {
            this.gbW = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (!j.gD()) {
                a.this.adf.showToast(d.k.neterror);
                return;
            }
            boolean z = view2 == a.this.fZF;
            if (this.gbW != null) {
                int g = com.baidu.adp.lib.g.b.g(this.gbW.adPosition, -1);
                int status = ApkDownloadView.getStatus(a.this.c(this.gbW, g));
                if ((6 != status && 7 != status) || !j.gP() || j.gQ()) {
                    a.this.a(this.gbW, g, a.this.fZF, z);
                } else {
                    a.this.showDownloadAppDialog(this.gbW, g, true, this.gbW.Wb != null ? this.gbW.Wb.Wm : "");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.VU);
        downloadData.setUrl(advertAppInfo.VT);
        downloadData.setName(advertAppInfo.VQ);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.g.b.g(advertAppInfo.VP, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.gD()) {
                l.showToast(this.adf.getPageActivity(), d.k.neterror);
            } else if (advertAppInfo.qt()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.adf.getString(d.k.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.adf.getPageActivity());
                aVar.dc(str);
                aVar.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.e.a.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        a.this.d(advertAppInfo, i);
                        if (a.this.fZF != null) {
                            a.this.fZF.s(a.this.c(advertAppInfo, i));
                        }
                        aVar2.dismiss();
                    }
                });
                aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.recapp.e.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.adf).tD();
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
                    g.e(advertAppInfo);
                    apkDownloadView.t(c);
                    return;
                case 2:
                case 4:
                default:
                    return;
                case 3:
                    g.aj(this.adf.getPageActivity(), advertAppInfo.VU);
                    return;
                case 6:
                case 7:
                    d(advertAppInfo, i);
                    apkDownloadView.h(c);
                    return;
            }
        }
    }

    protected void d(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo != null) {
            if (!s.E(this.adf.getPageActivity())) {
                l.showToast(this.adf.getPageActivity(), d.k.write_external_storage_permission_denied_fun_disable);
            } else if (this.ewn != null) {
                this.ewn.b(advertAppInfo, i);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        this.ewn = cVar;
    }
}
