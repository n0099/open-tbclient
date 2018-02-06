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
    private TextView bfg;
    private HeadImageView ecD;
    private com.baidu.tieba.lego.card.c fbD;
    private ApkDownloadView gER;
    private CustomMessageListener gEh;
    private String gGV;
    private TextView gHI;

    public a(View view, String str) {
        super(view, str);
        this.gEh = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.e.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(a.this.gGV) && a.this.gGV.equals(downloadData.getId())) {
                    a.this.gER.u(downloadData);
                }
            }
        };
        init();
    }

    private void init() {
        this.ecD = (HeadImageView) ux(d.g.user_portrait);
        this.ecD.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.ecD.setDefaultResource(d.f.icon_default_avatar100);
        this.ecD.setDefaultBgResource(d.C0140d.cp_bg_line_e);
        this.ecD.setIsRound(true);
        this.bfg = (TextView) ux(d.g.user_name);
        this.gHI = (TextView) ux(d.g.action);
        this.gER = (ApkDownloadView) ux(d.g.download_view);
        MessageManager.getInstance().registerListener(this.gEh);
    }

    @Override // com.baidu.tieba.recapp.e.d
    public void a(AdCard.e eVar) {
        super.a(eVar);
        this.ecD.startLoad(eVar.gDq, 10, false);
        this.bfg.setText(eVar.userName);
        this.gHI.setText(eVar.buttonText);
        if (this.gHP != null) {
            View$OnClickListenerC0225a view$OnClickListenerC0225a = new View$OnClickListenerC0225a(this.gHP);
            this.mRootView.setOnClickListener(view$OnClickListenerC0225a);
            this.gER.setOnClickListener(view$OnClickListenerC0225a);
            int intValue = Integer.valueOf(this.gHP.adPosition).intValue();
            this.gGV = this.gHP.aKK;
            DownloadData c = c(this.gHP, intValue);
            c.setStatus(ApkDownloadView.getStatus(c));
            this.gER.setData(c);
        }
        this.gER.p(this.aRR.getUniqueId());
        this.gEh.setTag(this.aRR.getUniqueId());
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.d
    public void onChangeSkinType() {
        super.onChangeSkinType();
        aj.t(this.mRootView, d.C0140d.cp_cont_b_alpha80);
        aj.e(this.bfg, d.C0140d.cp_cont_i, 1);
        aj.e(this.gHI, d.C0140d.cp_cont_i, 1);
        aj.g(this.gHI, d.C0140d.cp_link_tip_a, 1);
        this.gER.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* renamed from: com.baidu.tieba.recapp.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class View$OnClickListenerC0225a implements View.OnClickListener {
        private AdvertAppInfo gGY;

        public View$OnClickListenerC0225a(AdvertAppInfo advertAppInfo) {
            this.gGY = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.ox()) {
                a.this.aRR.showToast(d.j.neterror);
                return;
            }
            boolean z = view == a.this.gER;
            if (this.gGY != null) {
                int h = com.baidu.adp.lib.g.b.h(this.gGY.adPosition, -1);
                int status = ApkDownloadView.getStatus(a.this.c(this.gGY, h));
                if ((6 != status && 7 != status) || !j.oJ() || j.oK()) {
                    a.this.a(this.gGY, h, a.this.gER, z);
                } else {
                    a.this.showDownloadAppDialog(this.gGY, h, true, this.gGY.aKR != null ? this.gGY.aKR.aLc : "");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.aKK);
        downloadData.setUrl(advertAppInfo.aKJ);
        downloadData.setName(advertAppInfo.aKG);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.g.b.h(advertAppInfo.aKF, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.ox()) {
                l.showToast(this.aRR.getPageActivity(), d.j.neterror);
            } else if (advertAppInfo.xK()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.aRR.getString(d.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aRR.getPageActivity());
                aVar.dk(str);
                aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.e.a.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        a.this.d(advertAppInfo, i);
                        if (a.this.gER != null) {
                            a.this.gER.s(a.this.c(advertAppInfo, i));
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
                aVar.b(this.aRR).AU();
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
                    g.ao(this.aRR.getPageActivity(), advertAppInfo.aKK);
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
            if (!s.C(this.aRR.getPageActivity())) {
                l.showToast(this.aRR.getPageActivity(), d.j.write_external_storage_permission_denied_fun_disable);
            } else if (this.fbD != null) {
                this.fbD.b(advertAppInfo, i);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.e.d
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        this.fbD = cVar;
    }
}
