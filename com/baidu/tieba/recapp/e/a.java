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
    private TextView aKT;
    private HeadImageView ena;
    private com.baidu.tieba.lego.card.c fnJ;
    private CustomMessageListener gNE;
    private ApkDownloadView gOo;
    private String gQF;
    private TextView gRu;

    public a(View view, String str) {
        super(view, str);
        this.gNE = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.e.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(a.this.gQF) && a.this.gQF.equals(downloadData.getId())) {
                    a.this.gOo.s(downloadData);
                }
            }
        };
        init();
    }

    private void init() {
        this.ena = (HeadImageView) tZ(e.g.user_portrait);
        this.ena.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.ena.setDefaultResource(e.f.icon_default_avatar100);
        this.ena.setDefaultBgResource(e.d.cp_bg_line_e);
        this.ena.setIsRound(true);
        this.aKT = (TextView) tZ(e.g.user_name);
        this.gRu = (TextView) tZ(e.g.action);
        this.gOo = (ApkDownloadView) tZ(e.g.download_view);
        MessageManager.getInstance().registerListener(this.gNE);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(AdCard.f fVar) {
        super.a(fVar);
        this.ena.startLoad(fVar.gMO, 10, false);
        this.aKT.setText(fVar.userName);
        this.gRu.setText(fVar.buttonText);
        if (this.gRD != null) {
            View$OnClickListenerC0307a view$OnClickListenerC0307a = new View$OnClickListenerC0307a(this.gRD);
            this.mRootView.setOnClickListener(view$OnClickListenerC0307a);
            this.gOo.setOnClickListener(view$OnClickListenerC0307a);
            int intValue = Integer.valueOf(this.gRD.adPosition).intValue();
            this.gQF = this.gRD.apv;
            DownloadData c = c(this.gRD, intValue);
            c.setStatus(ApkDownloadView.getStatus(c));
            this.gOo.setData(c);
        }
        this.gOo.p(this.mContext.getUniqueId());
        this.gNE.setTag(this.mContext.getUniqueId());
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        al.j(this.mRootView, e.d.cp_cont_b_alpha80);
        al.c(this.aKT, e.d.cp_cont_i, 1);
        al.c(this.gRu, e.d.cp_cont_i, 1);
        al.e(this.gRu, e.d.cp_link_tip_a, 1);
        this.gOo.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* renamed from: com.baidu.tieba.recapp.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class View$OnClickListenerC0307a implements View.OnClickListener {
        private AdvertAppInfo gQI;

        public View$OnClickListenerC0307a(AdvertAppInfo advertAppInfo) {
            this.gQI = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.kK()) {
                a.this.mContext.showToast(e.j.neterror);
                return;
            }
            boolean z = view == a.this.gOo;
            if (this.gQI != null) {
                int l = com.baidu.adp.lib.g.b.l(this.gQI.adPosition, -1);
                int status = ApkDownloadView.getStatus(a.this.c(this.gQI, l));
                if ((6 != status && 7 != status) || !j.kV() || j.kW()) {
                    a.this.a(this.gQI, l, a.this.gOo, z);
                } else {
                    a.this.showDownloadAppDialog(this.gQI, l, true, this.gQI.apB != null ? this.gQI.apB.apN : "");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.apv);
        downloadData.setUrl(advertAppInfo.apu);
        downloadData.setName(advertAppInfo.apr);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.g.b.l(advertAppInfo.apq, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.kK()) {
                l.showToast(this.mContext.getPageActivity(), e.j.neterror);
            } else if (advertAppInfo.yd()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(e.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.eB(str);
                aVar.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.e.a.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        a.this.d(advertAppInfo, i);
                        if (a.this.gOo != null) {
                            a.this.gOo.p(a.this.c(advertAppInfo, i));
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
                aVar.b(this.mContext).BF();
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
                    g.aG(this.mContext.getPageActivity(), advertAppInfo.apv);
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
            if (!s.R(this.mContext.getPageActivity())) {
                l.showToast(this.mContext.getPageActivity(), e.j.write_external_storage_permission_denied_fun_disable);
            } else if (this.fnJ != null) {
                this.fnJ.b(advertAppInfo, i);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        this.fnJ = cVar;
    }
}
