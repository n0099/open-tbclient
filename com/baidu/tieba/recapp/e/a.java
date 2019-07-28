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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.download.g;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
/* loaded from: classes3.dex */
public class a extends e {
    private TextView ccZ;
    private HeadImageView fYJ;
    private com.baidu.tieba.lego.card.c heX;
    private CustomMessageListener iHR;
    private ApkDownloadView iIB;
    private String iKT;
    private TextView iLG;

    public a(View view, String str) {
        super(view, str);
        this.iHR = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.e.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(a.this.iKT) && a.this.iKT.equals(downloadData.getId())) {
                    a.this.iIB.s(downloadData);
                }
            }
        };
        init();
    }

    private void init() {
        this.fYJ = (HeadImageView) zL(R.id.user_portrait);
        this.fYJ.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fYJ.setDefaultResource(R.drawable.icon_default_avatar100);
        this.fYJ.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fYJ.setIsRound(true);
        this.ccZ = (TextView) zL(R.id.user_name);
        this.iLG = (TextView) zL(R.id.action);
        this.iIB = (ApkDownloadView) zL(R.id.download_view);
        MessageManager.getInstance().registerListener(this.iHR);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(AdCard.f fVar) {
        super.a(fVar);
        this.fYJ.startLoad(fVar.iHd, 10, false);
        this.ccZ.setText(fVar.userName);
        this.iLG.setText(fVar.buttonText);
        if (this.iLP != null) {
            View$OnClickListenerC0402a view$OnClickListenerC0402a = new View$OnClickListenerC0402a(this.iLP);
            this.mRootView.setOnClickListener(view$OnClickListenerC0402a);
            this.iIB.setOnClickListener(view$OnClickListenerC0402a);
            int intValue = Integer.valueOf(this.iLP.adPosition).intValue();
            this.iKT = this.iLP.bEX;
            DownloadData c = c(this.iLP, intValue);
            c.setStatus(ApkDownloadView.getStatus(c));
            this.iIB.setData(c);
        }
        this.iIB.s(this.mContext.getUniqueId());
        this.iHR.setTag(this.mContext.getUniqueId());
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        am.f(this.ccZ, R.color.cp_btn_a, 1);
        am.f(this.iLG, R.color.cp_mask_e, 1);
        am.h(this.iLG, R.color.cp_link_tip_a, 1);
        this.iIB.bIl();
    }

    /* renamed from: com.baidu.tieba.recapp.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class View$OnClickListenerC0402a implements View.OnClickListener {
        private AdvertAppInfo iKW;

        public View$OnClickListenerC0402a(AdvertAppInfo advertAppInfo) {
            this.iKW = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.jQ()) {
                a.this.mContext.showToast(R.string.neterror);
                return;
            }
            boolean z = view == a.this.iIB;
            if (this.iKW != null) {
                int f = com.baidu.adp.lib.g.b.f(this.iKW.adPosition, -1);
                int status = ApkDownloadView.getStatus(a.this.c(this.iKW, f));
                if ((6 != status && 7 != status) || !j.kc() || j.kd()) {
                    a.this.a(this.iKW, f, a.this.iIB, z);
                } else {
                    a.this.showDownloadAppDialog(this.iKW, f, true, this.iKW.bFd != null ? this.iKW.bFd.bFp : "");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.bEX);
        downloadData.setUrl(advertAppInfo.bEW);
        downloadData.setName(advertAppInfo.bEU);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.g.b.f(advertAppInfo.bET, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.jQ()) {
                l.showToast(this.mContext.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.acH()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.mO(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.e.a.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        a.this.d(advertAppInfo, i);
                        if (a.this.iIB != null) {
                            a.this.iIB.p(a.this.c(advertAppInfo, i));
                        }
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.recapp.e.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.mContext).agI();
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
                    g.aG(this.mContext.getPageActivity(), advertAppInfo.bEX);
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
            if (!s.at(this.mContext.getPageActivity())) {
                l.showToast(this.mContext.getPageActivity(), (int) R.string.write_external_storage_permission_denied_fun_disable);
            } else if (this.heX != null) {
                this.heX.b(advertAppInfo, i);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        this.heX = cVar;
    }
}
