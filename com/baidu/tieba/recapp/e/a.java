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
    private TextView aGD;
    private HeadImageView eeN;
    private com.baidu.tieba.lego.card.c ffx;
    private ApkDownloadView gFW;
    private CustomMessageListener gFm;
    private String gIn;
    private TextView gJc;

    public a(View view, String str) {
        super(view, str);
        this.gFm = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.e.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(a.this.gIn) && a.this.gIn.equals(downloadData.getId())) {
                    a.this.gFW.s(downloadData);
                }
            }
        };
        init();
    }

    private void init() {
        this.eeN = (HeadImageView) tm(e.g.user_portrait);
        this.eeN.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.eeN.setDefaultResource(e.f.icon_default_avatar100);
        this.eeN.setDefaultBgResource(e.d.cp_bg_line_e);
        this.eeN.setIsRound(true);
        this.aGD = (TextView) tm(e.g.user_name);
        this.gJc = (TextView) tm(e.g.action);
        this.gFW = (ApkDownloadView) tm(e.g.download_view);
        MessageManager.getInstance().registerListener(this.gFm);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(AdCard.f fVar) {
        super.a(fVar);
        this.eeN.startLoad(fVar.gEw, 10, false);
        this.aGD.setText(fVar.userName);
        this.gJc.setText(fVar.buttonText);
        if (this.gJm != null) {
            View$OnClickListenerC0268a view$OnClickListenerC0268a = new View$OnClickListenerC0268a(this.gJm);
            this.mRootView.setOnClickListener(view$OnClickListenerC0268a);
            this.gFW.setOnClickListener(view$OnClickListenerC0268a);
            int intValue = Integer.valueOf(this.gJm.adPosition).intValue();
            this.gIn = this.gJm.alg;
            DownloadData c = c(this.gJm, intValue);
            c.setStatus(ApkDownloadView.getStatus(c));
            this.gFW.setData(c);
        }
        this.gFW.p(this.mContext.getUniqueId());
        this.gFm.setTag(this.mContext.getUniqueId());
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        al.j(this.mRootView, e.d.cp_cont_b_alpha80);
        al.c(this.aGD, e.d.cp_cont_i, 1);
        al.c(this.gJc, e.d.cp_cont_i, 1);
        al.e(this.gJc, e.d.cp_link_tip_a, 1);
        this.gFW.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* renamed from: com.baidu.tieba.recapp.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class View$OnClickListenerC0268a implements View.OnClickListener {
        private AdvertAppInfo gIq;

        public View$OnClickListenerC0268a(AdvertAppInfo advertAppInfo) {
            this.gIq = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.kM()) {
                a.this.mContext.showToast(e.j.neterror);
                return;
            }
            boolean z = view == a.this.gFW;
            if (this.gIq != null) {
                int l = com.baidu.adp.lib.g.b.l(this.gIq.adPosition, -1);
                int status = ApkDownloadView.getStatus(a.this.c(this.gIq, l));
                if ((6 != status && 7 != status) || !j.kX() || j.kY()) {
                    a.this.a(this.gIq, l, a.this.gFW, z);
                } else {
                    a.this.showDownloadAppDialog(this.gIq, l, true, this.gIq.aln != null ? this.gIq.aln.alz : "");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.alg);
        downloadData.setUrl(advertAppInfo.alf);
        downloadData.setName(advertAppInfo.alc);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.g.b.l(advertAppInfo.alb, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.kM()) {
                l.showToast(this.mContext.getPageActivity(), e.j.neterror);
            } else if (advertAppInfo.wR()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(e.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.ej(str);
                aVar.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.e.a.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        a.this.d(advertAppInfo, i);
                        if (a.this.gFW != null) {
                            a.this.gFW.p(a.this.c(advertAppInfo, i));
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
                aVar.b(this.mContext).Au();
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
                    g.aF(this.mContext.getPageActivity(), advertAppInfo.alg);
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
            if (!s.L(this.mContext.getPageActivity())) {
                l.showToast(this.mContext.getPageActivity(), e.j.write_external_storage_permission_denied_fun_disable);
            } else if (this.ffx != null) {
                this.ffx.b(advertAppInfo, i);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        this.ffx = cVar;
    }
}
