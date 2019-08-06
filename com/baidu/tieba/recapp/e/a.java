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
    private TextView cdg;
    private HeadImageView fZz;
    private com.baidu.tieba.lego.card.c hfP;
    private CustomMessageListener iIV;
    private ApkDownloadView iJF;
    private String iLX;
    private TextView iMK;

    public a(View view, String str) {
        super(view, str);
        this.iIV = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.e.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(a.this.iLX) && a.this.iLX.equals(downloadData.getId())) {
                    a.this.iJF.s(downloadData);
                }
            }
        };
        init();
    }

    private void init() {
        this.fZz = (HeadImageView) zN(R.id.user_portrait);
        this.fZz.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fZz.setDefaultResource(R.drawable.icon_default_avatar100);
        this.fZz.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fZz.setIsRound(true);
        this.cdg = (TextView) zN(R.id.user_name);
        this.iMK = (TextView) zN(R.id.action);
        this.iJF = (ApkDownloadView) zN(R.id.download_view);
        MessageManager.getInstance().registerListener(this.iIV);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(AdCard.f fVar) {
        super.a(fVar);
        this.fZz.startLoad(fVar.iIh, 10, false);
        this.cdg.setText(fVar.userName);
        this.iMK.setText(fVar.buttonText);
        if (this.iMT != null) {
            View$OnClickListenerC0402a view$OnClickListenerC0402a = new View$OnClickListenerC0402a(this.iMT);
            this.mRootView.setOnClickListener(view$OnClickListenerC0402a);
            this.iJF.setOnClickListener(view$OnClickListenerC0402a);
            int intValue = Integer.valueOf(this.iMT.adPosition).intValue();
            this.iLX = this.iMT.bEY;
            DownloadData c = c(this.iMT, intValue);
            c.setStatus(ApkDownloadView.getStatus(c));
            this.iJF.setData(c);
        }
        this.iJF.s(this.mContext.getUniqueId());
        this.iIV.setTag(this.mContext.getUniqueId());
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        am.f(this.cdg, R.color.cp_btn_a, 1);
        am.f(this.iMK, R.color.cp_mask_e, 1);
        am.h(this.iMK, R.color.cp_link_tip_a, 1);
        this.iJF.bIz();
    }

    /* renamed from: com.baidu.tieba.recapp.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class View$OnClickListenerC0402a implements View.OnClickListener {
        private AdvertAppInfo iMa;

        public View$OnClickListenerC0402a(AdvertAppInfo advertAppInfo) {
            this.iMa = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.jQ()) {
                a.this.mContext.showToast(R.string.neterror);
                return;
            }
            boolean z = view == a.this.iJF;
            if (this.iMa != null) {
                int f = com.baidu.adp.lib.g.b.f(this.iMa.adPosition, -1);
                int status = ApkDownloadView.getStatus(a.this.c(this.iMa, f));
                if ((6 != status && 7 != status) || !j.kc() || j.kd()) {
                    a.this.a(this.iMa, f, a.this.iJF, z);
                } else {
                    a.this.showDownloadAppDialog(this.iMa, f, true, this.iMa.bFe != null ? this.iMa.bFe.bFq : "");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.bEY);
        downloadData.setUrl(advertAppInfo.bEX);
        downloadData.setName(advertAppInfo.bEV);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.g.b.f(advertAppInfo.bEU, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.jQ()) {
                l.showToast(this.mContext.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.acI()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.mO(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.e.a.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        a.this.d(advertAppInfo, i);
                        if (a.this.iJF != null) {
                            a.this.iJF.p(a.this.c(advertAppInfo, i));
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
                aVar.b(this.mContext).agK();
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
                    g.aG(this.mContext.getPageActivity(), advertAppInfo.bEY);
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
            } else if (this.hfP != null) {
                this.hfP.b(advertAppInfo, i);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        this.hfP = cVar;
    }
}
