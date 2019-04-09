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
    private TextView bUb;
    private HeadImageView fCM;
    private com.baidu.tieba.lego.card.c gHn;
    private CustomMessageListener iiK;
    private ApkDownloadView iju;
    private String ilM;
    private TextView imA;

    public a(View view, String str) {
        super(view, str);
        this.iiK = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.e.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(a.this.ilM) && a.this.ilM.equals(downloadData.getId())) {
                    a.this.iju.s(downloadData);
                }
            }
        };
        init();
    }

    private void init() {
        this.fCM = (HeadImageView) xZ(d.g.user_portrait);
        this.fCM.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.fCM.setDefaultResource(d.f.icon_default_avatar100);
        this.fCM.setDefaultBgResource(d.C0277d.cp_bg_line_e);
        this.fCM.setIsRound(true);
        this.bUb = (TextView) xZ(d.g.user_name);
        this.imA = (TextView) xZ(d.g.action);
        this.iju = (ApkDownloadView) xZ(d.g.download_view);
        MessageManager.getInstance().registerListener(this.iiK);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(AdCard.f fVar) {
        super.a(fVar);
        this.fCM.startLoad(fVar.ihW, 10, false);
        this.bUb.setText(fVar.userName);
        this.imA.setText(fVar.buttonText);
        if (this.imJ != null) {
            View$OnClickListenerC0378a view$OnClickListenerC0378a = new View$OnClickListenerC0378a(this.imJ);
            this.mRootView.setOnClickListener(view$OnClickListenerC0378a);
            this.iju.setOnClickListener(view$OnClickListenerC0378a);
            int intValue = Integer.valueOf(this.imJ.adPosition).intValue();
            this.ilM = this.imJ.bwL;
            DownloadData c = c(this.imJ, intValue);
            c.setStatus(ApkDownloadView.getStatus(c));
            this.iju.setData(c);
        }
        this.iju.q(this.mContext.getUniqueId());
        this.iiK.setTag(this.mContext.getUniqueId());
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        al.l(this.mRootView, d.C0277d.cp_cont_b_alpha80);
        al.d(this.bUb, d.C0277d.cp_btn_a, 1);
        al.d(this.imA, d.C0277d.cp_btn_a, 1);
        al.f(this.imA, d.C0277d.cp_link_tip_a, 1);
        this.iju.bxS();
    }

    /* renamed from: com.baidu.tieba.recapp.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class View$OnClickListenerC0378a implements View.OnClickListener {
        private AdvertAppInfo ilP;

        public View$OnClickListenerC0378a(AdvertAppInfo advertAppInfo) {
            this.ilP = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.kM()) {
                a.this.mContext.showToast(d.j.neterror);
                return;
            }
            boolean z = view == a.this.iju;
            if (this.ilP != null) {
                int l = com.baidu.adp.lib.g.b.l(this.ilP.adPosition, -1);
                int status = ApkDownloadView.getStatus(a.this.c(this.ilP, l));
                if ((6 != status && 7 != status) || !j.kY() || j.kZ()) {
                    a.this.a(this.ilP, l, a.this.iju, z);
                } else {
                    a.this.showDownloadAppDialog(this.ilP, l, true, this.ilP.bwR != null ? this.ilP.bwR.bxd : "");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.bwL);
        downloadData.setUrl(advertAppInfo.bwK);
        downloadData.setName(advertAppInfo.bwI);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.g.b.l(advertAppInfo.bwH, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.kM()) {
                l.showToast(this.mContext.getPageActivity(), d.j.neterror);
            } else if (advertAppInfo.WY()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(d.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.lz(str);
                aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.e.a.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        a.this.d(advertAppInfo, i);
                        if (a.this.iju != null) {
                            a.this.iju.p(a.this.c(advertAppInfo, i));
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
                aVar.b(this.mContext).aaW();
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
                    g.aR(this.mContext.getPageActivity(), advertAppInfo.bwL);
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
            if (!s.an(this.mContext.getPageActivity())) {
                l.showToast(this.mContext.getPageActivity(), d.j.write_external_storage_permission_denied_fun_disable);
            } else if (this.gHn != null) {
                this.gHn.b(advertAppInfo, i);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        this.gHn = cVar;
    }
}
