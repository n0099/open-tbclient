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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.f;
import com.baidu.tieba.recapp.download.g;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
/* loaded from: classes3.dex */
public class a extends e {
    private TextView ayV;
    private HeadImageView dPC;
    private com.baidu.tieba.lego.card.c eQv;
    private CustomMessageListener gqu;
    private ApkDownloadView gre;
    private String gtu;
    private TextView guk;

    public a(View view, String str) {
        super(view, str);
        this.gqu = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.e.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(a.this.gtu) && a.this.gtu.equals(downloadData.getId())) {
                    a.this.gre.s(downloadData);
                }
            }
        };
        init();
    }

    private void init() {
        this.dPC = (HeadImageView) sr(f.g.user_portrait);
        this.dPC.setDefaultErrorResource(f.C0146f.icon_default_avatar100);
        this.dPC.setDefaultResource(f.C0146f.icon_default_avatar100);
        this.dPC.setDefaultBgResource(f.d.cp_bg_line_e);
        this.dPC.setIsRound(true);
        this.ayV = (TextView) sr(f.g.user_name);
        this.guk = (TextView) sr(f.g.action);
        this.gre = (ApkDownloadView) sr(f.g.download_view);
        MessageManager.getInstance().registerListener(this.gqu);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(AdCard.f fVar) {
        super.a(fVar);
        this.dPC.startLoad(fVar.gpE, 10, false);
        this.ayV.setText(fVar.userName);
        this.guk.setText(fVar.buttonText);
        if (this.guu != null) {
            View$OnClickListenerC0227a view$OnClickListenerC0227a = new View$OnClickListenerC0227a(this.guu);
            this.mRootView.setOnClickListener(view$OnClickListenerC0227a);
            this.gre.setOnClickListener(view$OnClickListenerC0227a);
            int intValue = Integer.valueOf(this.guu.adPosition).intValue();
            this.gtu = this.guu.adJ;
            DownloadData c = c(this.guu, intValue);
            c.setStatus(ApkDownloadView.getStatus(c));
            this.gre.setData(c);
        }
        this.gre.q(this.mContext.getUniqueId());
        this.gqu.setTag(this.mContext.getUniqueId());
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        am.j(this.mRootView, f.d.cp_cont_b_alpha80);
        am.c(this.ayV, f.d.cp_cont_i, 1);
        am.c(this.guk, f.d.cp_cont_i, 1);
        am.e(this.guk, f.d.cp_link_tip_a, 1);
        this.gre.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* renamed from: com.baidu.tieba.recapp.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class View$OnClickListenerC0227a implements View.OnClickListener {
        private AdvertAppInfo gtx;

        public View$OnClickListenerC0227a(AdvertAppInfo advertAppInfo) {
            this.gtx = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.js()) {
                a.this.mContext.showToast(f.j.neterror);
                return;
            }
            boolean z = view == a.this.gre;
            if (this.gtx != null) {
                int g = com.baidu.adp.lib.g.b.g(this.gtx.adPosition, -1);
                int status = ApkDownloadView.getStatus(a.this.c(this.gtx, g));
                if ((6 != status && 7 != status) || !j.jE() || j.jF()) {
                    a.this.a(this.gtx, g, a.this.gre, z);
                } else {
                    a.this.showDownloadAppDialog(this.gtx, g, true, this.gtx.adQ != null ? this.gtx.adQ.aec : "");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.adJ);
        downloadData.setUrl(advertAppInfo.adI);
        downloadData.setName(advertAppInfo.adF);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.g.b.g(advertAppInfo.adE, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.js()) {
                l.showToast(this.mContext.getPageActivity(), f.j.neterror);
            } else if (advertAppInfo.tF()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(f.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.dB(str);
                aVar.a(f.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.e.a.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        a.this.d(advertAppInfo, i);
                        if (a.this.gre != null) {
                            a.this.gre.p(a.this.c(advertAppInfo, i));
                        }
                        aVar2.dismiss();
                    }
                });
                aVar.b(f.j.cancel, new a.b() { // from class: com.baidu.tieba.recapp.e.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.mContext).xe();
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
                    g.an(this.mContext.getPageActivity(), advertAppInfo.adJ);
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
            if (!s.G(this.mContext.getPageActivity())) {
                l.showToast(this.mContext.getPageActivity(), f.j.write_external_storage_permission_denied_fun_disable);
            } else if (this.eQv != null) {
                this.eQv.b(advertAppInfo, i);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        this.eQv = cVar;
    }
}
