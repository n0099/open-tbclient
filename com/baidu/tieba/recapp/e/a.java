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
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.download.g;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
/* loaded from: classes3.dex */
public class a extends e {
    private TextView ayt;
    private HeadImageView dJB;
    private com.baidu.tieba.lego.card.c eIO;
    private CustomMessageListener glq;
    private ApkDownloadView gma;
    private String goo;
    private TextView gpc;

    public a(View view, String str) {
        super(view, str);
        this.glq = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.e.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(a.this.goo) && a.this.goo.equals(downloadData.getId())) {
                    a.this.gma.u(downloadData);
                }
            }
        };
        init();
    }

    private void init() {
        this.dJB = (HeadImageView) sj(d.g.user_portrait);
        this.dJB.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.dJB.setDefaultResource(d.f.icon_default_avatar100);
        this.dJB.setDefaultBgResource(d.C0141d.cp_bg_line_e);
        this.dJB.setIsRound(true);
        this.ayt = (TextView) sj(d.g.user_name);
        this.gpc = (TextView) sj(d.g.action);
        this.gma = (ApkDownloadView) sj(d.g.download_view);
        MessageManager.getInstance().registerListener(this.glq);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(AdCard.f fVar) {
        super.a(fVar);
        this.dJB.startLoad(fVar.gkB, 10, false);
        this.ayt.setText(fVar.userName);
        this.gpc.setText(fVar.buttonText);
        if (this.gpm != null) {
            View$OnClickListenerC0225a view$OnClickListenerC0225a = new View$OnClickListenerC0225a(this.gpm);
            this.mRootView.setOnClickListener(view$OnClickListenerC0225a);
            this.gma.setOnClickListener(view$OnClickListenerC0225a);
            int intValue = Integer.valueOf(this.gpm.adPosition).intValue();
            this.goo = this.gpm.adQ;
            DownloadData c = c(this.gpm, intValue);
            c.setStatus(ApkDownloadView.getStatus(c));
            this.gma.setData(c);
        }
        this.gma.q(this.mContext.getUniqueId());
        this.glq.setTag(this.mContext.getUniqueId());
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        al.j(this.mRootView, d.C0141d.cp_cont_b_alpha80);
        al.c(this.ayt, d.C0141d.cp_cont_i, 1);
        al.c(this.gpc, d.C0141d.cp_cont_i, 1);
        al.e(this.gpc, d.C0141d.cp_link_tip_a, 1);
        this.gma.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* renamed from: com.baidu.tieba.recapp.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class View$OnClickListenerC0225a implements View.OnClickListener {
        private AdvertAppInfo gor;

        public View$OnClickListenerC0225a(AdvertAppInfo advertAppInfo) {
            this.gor = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.jr()) {
                a.this.mContext.showToast(d.k.neterror);
                return;
            }
            boolean z = view == a.this.gma;
            if (this.gor != null) {
                int g = com.baidu.adp.lib.g.b.g(this.gor.adPosition, -1);
                int status = ApkDownloadView.getStatus(a.this.c(this.gor, g));
                if ((6 != status && 7 != status) || !j.jD() || j.jE()) {
                    a.this.a(this.gor, g, a.this.gma, z);
                } else {
                    a.this.showDownloadAppDialog(this.gor, g, true, this.gor.adX != null ? this.gor.adX.aej : "");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.adQ);
        downloadData.setUrl(advertAppInfo.adP);
        downloadData.setName(advertAppInfo.adM);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.g.b.g(advertAppInfo.adL, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.jr()) {
                l.showToast(this.mContext.getPageActivity(), d.k.neterror);
            } else if (advertAppInfo.tO()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(d.k.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.dB(str);
                aVar.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.e.a.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        a.this.d(advertAppInfo, i);
                        if (a.this.gma != null) {
                            a.this.gma.s(a.this.c(advertAppInfo, i));
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
                aVar.b(this.mContext).xa();
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
                    g.al(this.mContext.getPageActivity(), advertAppInfo.adQ);
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
            } else if (this.eIO != null) {
                this.eIO.b(advertAppInfo, i);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        this.eIO = cVar;
    }
}
