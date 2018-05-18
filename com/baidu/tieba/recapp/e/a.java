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
    private HeadImageView dyr;
    private com.baidu.tieba.lego.card.c exs;
    private CustomMessageListener fZY;
    private ApkDownloadView gaI;
    private String gcW;
    private TextView gdJ;

    public a(View view2, String str) {
        super(view2, str);
        this.fZY = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.e.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(a.this.gcW) && a.this.gcW.equals(downloadData.getId())) {
                    a.this.gaI.u(downloadData);
                }
            }
        };
        init();
    }

    private void init() {
        this.dyr = (HeadImageView) rX(d.g.user_portrait);
        this.dyr.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.dyr.setDefaultResource(d.f.icon_default_avatar100);
        this.dyr.setDefaultBgResource(d.C0126d.cp_bg_line_e);
        this.dyr.setIsRound(true);
        this.aqm = (TextView) rX(d.g.user_name);
        this.gdJ = (TextView) rX(d.g.action);
        this.gaI = (ApkDownloadView) rX(d.g.download_view);
        MessageManager.getInstance().registerListener(this.fZY);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(AdCard.f fVar) {
        super.a(fVar);
        this.dyr.startLoad(fVar.fZj, 10, false);
        this.aqm.setText(fVar.userName);
        this.gdJ.setText(fVar.buttonText);
        if (this.gdT != null) {
            View$OnClickListenerC0208a view$OnClickListenerC0208a = new View$OnClickListenerC0208a(this.gdT);
            this.mRootView.setOnClickListener(view$OnClickListenerC0208a);
            this.gaI.setOnClickListener(view$OnClickListenerC0208a);
            int intValue = Integer.valueOf(this.gdT.adPosition).intValue();
            this.gcW = this.gdT.VQ;
            DownloadData c = c(this.gdT, intValue);
            c.setStatus(ApkDownloadView.getStatus(c));
            this.gaI.setData(c);
        }
        this.gaI.p(this.mContext.getUniqueId());
        this.fZY.setTag(this.mContext.getUniqueId());
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ak.j(this.mRootView, d.C0126d.cp_cont_b_alpha80);
        ak.c(this.aqm, d.C0126d.cp_cont_i, 1);
        ak.c(this.gdJ, d.C0126d.cp_cont_i, 1);
        ak.e(this.gdJ, d.C0126d.cp_link_tip_a, 1);
        this.gaI.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* renamed from: com.baidu.tieba.recapp.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class View$OnClickListenerC0208a implements View.OnClickListener {
        private AdvertAppInfo gcZ;

        public View$OnClickListenerC0208a(AdvertAppInfo advertAppInfo) {
            this.gcZ = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (!j.gD()) {
                a.this.mContext.showToast(d.k.neterror);
                return;
            }
            boolean z = view2 == a.this.gaI;
            if (this.gcZ != null) {
                int g = com.baidu.adp.lib.g.b.g(this.gcZ.adPosition, -1);
                int status = ApkDownloadView.getStatus(a.this.c(this.gcZ, g));
                if ((6 != status && 7 != status) || !j.gP() || j.gQ()) {
                    a.this.a(this.gcZ, g, a.this.gaI, z);
                } else {
                    a.this.showDownloadAppDialog(this.gcZ, g, true, this.gcZ.VX != null ? this.gcZ.VX.Wi : "");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.VQ);
        downloadData.setUrl(advertAppInfo.VP);
        downloadData.setName(advertAppInfo.VM);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.g.b.g(advertAppInfo.VL, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.gD()) {
                l.showToast(this.mContext.getPageActivity(), d.k.neterror);
            } else if (advertAppInfo.qs()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(d.k.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.dc(str);
                aVar.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.e.a.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        a.this.d(advertAppInfo, i);
                        if (a.this.gaI != null) {
                            a.this.gaI.s(a.this.c(advertAppInfo, i));
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
                aVar.b(this.mContext).tC();
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
                    g.aj(this.mContext.getPageActivity(), advertAppInfo.VQ);
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
            if (!s.E(this.mContext.getPageActivity())) {
                l.showToast(this.mContext.getPageActivity(), d.k.write_external_storage_permission_denied_fun_disable);
            } else if (this.exs != null) {
                this.exs.b(advertAppInfo, i);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        this.exs = cVar;
    }
}
