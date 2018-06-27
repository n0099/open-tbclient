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
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.download.g;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
/* loaded from: classes3.dex */
public class a extends e {
    private TextView azm;
    private HeadImageView dMT;
    private com.baidu.tieba.lego.card.c eMF;
    private ApkDownloadView gpR;
    private CustomMessageListener gph;
    private TextView gsU;
    private String gsf;

    public a(View view, String str) {
        super(view, str);
        this.gph = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.e.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(a.this.gsf) && a.this.gsf.equals(downloadData.getId())) {
                    a.this.gpR.u(downloadData);
                }
            }
        };
        init();
    }

    private void init() {
        this.dMT = (HeadImageView) st(d.g.user_portrait);
        this.dMT.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.dMT.setDefaultResource(d.f.icon_default_avatar100);
        this.dMT.setDefaultBgResource(d.C0142d.cp_bg_line_e);
        this.dMT.setIsRound(true);
        this.azm = (TextView) st(d.g.user_name);
        this.gsU = (TextView) st(d.g.action);
        this.gpR = (ApkDownloadView) st(d.g.download_view);
        MessageManager.getInstance().registerListener(this.gph);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(AdCard.f fVar) {
        super.a(fVar);
        this.dMT.startLoad(fVar.gor, 10, false);
        this.azm.setText(fVar.userName);
        this.gsU.setText(fVar.buttonText);
        if (this.gte != null) {
            View$OnClickListenerC0227a view$OnClickListenerC0227a = new View$OnClickListenerC0227a(this.gte);
            this.mRootView.setOnClickListener(view$OnClickListenerC0227a);
            this.gpR.setOnClickListener(view$OnClickListenerC0227a);
            int intValue = Integer.valueOf(this.gte.adPosition).intValue();
            this.gsf = this.gte.aef;
            DownloadData c = c(this.gte, intValue);
            c.setStatus(ApkDownloadView.getStatus(c));
            this.gpR.setData(c);
        }
        this.gpR.q(this.mContext.getUniqueId());
        this.gph.setTag(this.mContext.getUniqueId());
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        am.j(this.mRootView, d.C0142d.cp_cont_b_alpha80);
        am.c(this.azm, d.C0142d.cp_cont_i, 1);
        am.c(this.gsU, d.C0142d.cp_cont_i, 1);
        am.e(this.gsU, d.C0142d.cp_link_tip_a, 1);
        this.gpR.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* renamed from: com.baidu.tieba.recapp.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class View$OnClickListenerC0227a implements View.OnClickListener {
        private AdvertAppInfo gsi;

        public View$OnClickListenerC0227a(AdvertAppInfo advertAppInfo) {
            this.gsi = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.jr()) {
                a.this.mContext.showToast(d.k.neterror);
                return;
            }
            boolean z = view == a.this.gpR;
            if (this.gsi != null) {
                int g = com.baidu.adp.lib.g.b.g(this.gsi.adPosition, -1);
                int status = ApkDownloadView.getStatus(a.this.c(this.gsi, g));
                if ((6 != status && 7 != status) || !j.jD() || j.jE()) {
                    a.this.a(this.gsi, g, a.this.gpR, z);
                } else {
                    a.this.showDownloadAppDialog(this.gsi, g, true, this.gsi.aem != null ? this.gsi.aem.aey : "");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.aef);
        downloadData.setUrl(advertAppInfo.aee);
        downloadData.setName(advertAppInfo.aeb);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.g.b.g(advertAppInfo.aea, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.jr()) {
                l.showToast(this.mContext.getPageActivity(), d.k.neterror);
            } else if (advertAppInfo.tU()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(d.k.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.dE(str);
                aVar.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.e.a.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        a.this.d(advertAppInfo, i);
                        if (a.this.gpR != null) {
                            a.this.gpR.s(a.this.c(advertAppInfo, i));
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
                aVar.b(this.mContext).xn();
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
                    apkDownloadView.t(c);
                    return;
                case 2:
                case 4:
                default:
                    return;
                case 3:
                    g.al(this.mContext.getPageActivity(), advertAppInfo.aef);
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
            if (!s.F(this.mContext.getPageActivity())) {
                l.showToast(this.mContext.getPageActivity(), d.k.write_external_storage_permission_denied_fun_disable);
            } else if (this.eMF != null) {
                this.eMF.b(advertAppInfo, i);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        this.eMF = cVar;
    }
}
