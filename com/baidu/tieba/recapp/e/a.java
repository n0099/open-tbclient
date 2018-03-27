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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.download.g;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
/* loaded from: classes3.dex */
public class a extends d {
    private TextView beW;
    private HeadImageView ecH;
    private com.baidu.tieba.lego.card.c fbF;
    private ApkDownloadView gES;
    private CustomMessageListener gEi;
    private String gGW;
    private TextView gHJ;

    public a(View view, String str) {
        super(view, str);
        this.gEi = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.e.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(a.this.gGW) && a.this.gGW.equals(downloadData.getId())) {
                    a.this.gES.u(downloadData);
                }
            }
        };
        init();
    }

    private void init() {
        this.ecH = (HeadImageView) uy(d.g.user_portrait);
        this.ecH.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.ecH.setDefaultResource(d.f.icon_default_avatar100);
        this.ecH.setDefaultBgResource(d.C0141d.cp_bg_line_e);
        this.ecH.setIsRound(true);
        this.beW = (TextView) uy(d.g.user_name);
        this.gHJ = (TextView) uy(d.g.action);
        this.gES = (ApkDownloadView) uy(d.g.download_view);
        MessageManager.getInstance().registerListener(this.gEi);
    }

    @Override // com.baidu.tieba.recapp.e.d
    public void a(AdCard.e eVar) {
        super.a(eVar);
        this.ecH.startLoad(eVar.gDr, 10, false);
        this.beW.setText(eVar.userName);
        this.gHJ.setText(eVar.buttonText);
        if (this.gHQ != null) {
            View$OnClickListenerC0226a view$OnClickListenerC0226a = new View$OnClickListenerC0226a(this.gHQ);
            this.mRootView.setOnClickListener(view$OnClickListenerC0226a);
            this.gES.setOnClickListener(view$OnClickListenerC0226a);
            int intValue = Integer.valueOf(this.gHQ.adPosition).intValue();
            this.gGW = this.gHQ.aKA;
            DownloadData c = c(this.gHQ, intValue);
            c.setStatus(ApkDownloadView.getStatus(c));
            this.gES.setData(c);
        }
        this.gES.p(this.aRI.getUniqueId());
        this.gEi.setTag(this.aRI.getUniqueId());
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.d
    public void onChangeSkinType() {
        super.onChangeSkinType();
        aj.t(this.mRootView, d.C0141d.cp_cont_b_alpha80);
        aj.e(this.beW, d.C0141d.cp_cont_i, 1);
        aj.e(this.gHJ, d.C0141d.cp_cont_i, 1);
        aj.g(this.gHJ, d.C0141d.cp_link_tip_a, 1);
        this.gES.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* renamed from: com.baidu.tieba.recapp.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class View$OnClickListenerC0226a implements View.OnClickListener {
        private AdvertAppInfo gGZ;

        public View$OnClickListenerC0226a(AdvertAppInfo advertAppInfo) {
            this.gGZ = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.ox()) {
                a.this.aRI.showToast(d.j.neterror);
                return;
            }
            boolean z = view == a.this.gES;
            if (this.gGZ != null) {
                int h = com.baidu.adp.lib.g.b.h(this.gGZ.adPosition, -1);
                int status = ApkDownloadView.getStatus(a.this.c(this.gGZ, h));
                if ((6 != status && 7 != status) || !j.oJ() || j.oK()) {
                    a.this.a(this.gGZ, h, a.this.gES, z);
                } else {
                    a.this.showDownloadAppDialog(this.gGZ, h, true, this.gGZ.aKH != null ? this.gGZ.aKH.aKS : "");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.aKA);
        downloadData.setUrl(advertAppInfo.aKz);
        downloadData.setName(advertAppInfo.aKw);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.g.b.h(advertAppInfo.aKv, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.ox()) {
                l.showToast(this.aRI.getPageActivity(), d.j.neterror);
            } else if (advertAppInfo.xK()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.aRI.getString(d.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aRI.getPageActivity());
                aVar.dk(str);
                aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.e.a.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        a.this.d(advertAppInfo, i);
                        if (a.this.gES != null) {
                            a.this.gES.s(a.this.c(advertAppInfo, i));
                        }
                        aVar2.dismiss();
                    }
                });
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.recapp.e.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.aRI).AV();
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
                    g.ao(this.aRI.getPageActivity(), advertAppInfo.aKA);
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
            if (!s.C(this.aRI.getPageActivity())) {
                l.showToast(this.aRI.getPageActivity(), d.j.write_external_storage_permission_denied_fun_disable);
            } else if (this.fbF != null) {
                this.fbF.b(advertAppInfo, i);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.e.d
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        this.fbF = cVar;
    }
}
