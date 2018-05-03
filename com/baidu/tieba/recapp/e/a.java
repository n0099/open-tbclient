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
    private HeadImageView dxk;
    private com.baidu.tieba.lego.card.c ewk;
    private CustomMessageListener fYS;
    private ApkDownloadView fZC;
    private String gbQ;
    private TextView gcD;

    public a(View view2, String str) {
        super(view2, str);
        this.fYS = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.e.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(a.this.gbQ) && a.this.gbQ.equals(downloadData.getId())) {
                    a.this.fZC.u(downloadData);
                }
            }
        };
        init();
    }

    private void init() {
        this.dxk = (HeadImageView) rY(d.g.user_portrait);
        this.dxk.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.dxk.setDefaultResource(d.f.icon_default_avatar100);
        this.dxk.setDefaultBgResource(d.C0126d.cp_bg_line_e);
        this.dxk.setIsRound(true);
        this.aqm = (TextView) rY(d.g.user_name);
        this.gcD = (TextView) rY(d.g.action);
        this.fZC = (ApkDownloadView) rY(d.g.download_view);
        MessageManager.getInstance().registerListener(this.fYS);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(AdCard.f fVar) {
        super.a(fVar);
        this.dxk.startLoad(fVar.fYd, 10, false);
        this.aqm.setText(fVar.userName);
        this.gcD.setText(fVar.buttonText);
        if (this.gcN != null) {
            View$OnClickListenerC0208a view$OnClickListenerC0208a = new View$OnClickListenerC0208a(this.gcN);
            this.mRootView.setOnClickListener(view$OnClickListenerC0208a);
            this.fZC.setOnClickListener(view$OnClickListenerC0208a);
            int intValue = Integer.valueOf(this.gcN.adPosition).intValue();
            this.gbQ = this.gcN.VU;
            DownloadData c = c(this.gcN, intValue);
            c.setStatus(ApkDownloadView.getStatus(c));
            this.fZC.setData(c);
        }
        this.fZC.p(this.adf.getUniqueId());
        this.fYS.setTag(this.adf.getUniqueId());
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ak.j(this.mRootView, d.C0126d.cp_cont_b_alpha80);
        ak.c(this.aqm, d.C0126d.cp_cont_i, 1);
        ak.c(this.gcD, d.C0126d.cp_cont_i, 1);
        ak.e(this.gcD, d.C0126d.cp_link_tip_a, 1);
        this.fZC.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* renamed from: com.baidu.tieba.recapp.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class View$OnClickListenerC0208a implements View.OnClickListener {
        private AdvertAppInfo gbT;

        public View$OnClickListenerC0208a(AdvertAppInfo advertAppInfo) {
            this.gbT = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (!j.gD()) {
                a.this.adf.showToast(d.k.neterror);
                return;
            }
            boolean z = view2 == a.this.fZC;
            if (this.gbT != null) {
                int g = com.baidu.adp.lib.g.b.g(this.gbT.adPosition, -1);
                int status = ApkDownloadView.getStatus(a.this.c(this.gbT, g));
                if ((6 != status && 7 != status) || !j.gP() || j.gQ()) {
                    a.this.a(this.gbT, g, a.this.fZC, z);
                } else {
                    a.this.showDownloadAppDialog(this.gbT, g, true, this.gbT.Wb != null ? this.gbT.Wb.Wm : "");
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
                        if (a.this.fZC != null) {
                            a.this.fZC.s(a.this.c(advertAppInfo, i));
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
            } else if (this.ewk != null) {
                this.ewk.b(advertAppInfo, i);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        this.ewk = cVar;
    }
}
