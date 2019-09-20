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
import com.baidu.tieba.recapp.download.h;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
/* loaded from: classes3.dex */
public class a extends e {
    private TextView cdZ;
    private HeadImageView gbq;
    private com.baidu.tieba.lego.card.c hhJ;
    private CustomMessageListener iLr;
    private ApkDownloadView iMb;
    private String iOt;
    private TextView iPg;

    public a(View view, String str) {
        super(view, str);
        this.iLr = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.e.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(a.this.iOt) && a.this.iOt.equals(downloadData.getId())) {
                    a.this.iMb.s(downloadData);
                }
            }
        };
        init();
    }

    private void init() {
        this.gbq = (HeadImageView) zQ(R.id.user_portrait);
        this.gbq.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gbq.setDefaultResource(R.drawable.icon_default_avatar100);
        this.gbq.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gbq.setIsRound(true);
        this.cdZ = (TextView) zQ(R.id.user_name);
        this.iPg = (TextView) zQ(R.id.action);
        this.iMb = (ApkDownloadView) zQ(R.id.download_view);
        MessageManager.getInstance().registerListener(this.iLr);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(AdCard.f fVar) {
        super.a(fVar);
        this.gbq.startLoad(fVar.iKD, 10, false);
        this.cdZ.setText(fVar.userName);
        this.iPg.setText(fVar.buttonText);
        if (this.iPp != null) {
            View$OnClickListenerC0413a view$OnClickListenerC0413a = new View$OnClickListenerC0413a(this.iPp);
            this.mRootView.setOnClickListener(view$OnClickListenerC0413a);
            this.iMb.setOnClickListener(view$OnClickListenerC0413a);
            int intValue = Integer.valueOf(this.iPp.adPosition).intValue();
            this.iOt = this.iPp.bFw;
            DownloadData c = c(this.iPp, intValue);
            c.setStatus(ApkDownloadView.getStatus(c));
            this.iMb.setData(c);
        }
        this.iMb.s(this.mContext.getUniqueId());
        this.iLr.setTag(this.mContext.getUniqueId());
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        am.f(this.cdZ, R.color.cp_cont_a, 1);
        am.f(this.iPg, R.color.cp_mask_c_alpha83, 1);
        am.h(this.iPg, R.color.cp_link_tip_a, 1);
        this.iMb.bql();
    }

    /* renamed from: com.baidu.tieba.recapp.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class View$OnClickListenerC0413a implements View.OnClickListener {
        private AdvertAppInfo iOw;

        public View$OnClickListenerC0413a(AdvertAppInfo advertAppInfo) {
            this.iOw = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.jQ()) {
                a.this.mContext.showToast(R.string.neterror);
                return;
            }
            boolean z = view == a.this.iMb;
            if (this.iOw != null) {
                int f = com.baidu.adp.lib.g.b.f(this.iOw.adPosition, -1);
                int status = ApkDownloadView.getStatus(a.this.c(this.iOw, f));
                if ((6 != status && 7 != status) || !j.kc() || j.kd()) {
                    a.this.a(this.iOw, f, a.this.iMb, z);
                } else {
                    a.this.showDownloadAppDialog(this.iOw, f, true, this.iOw.bFC != null ? this.iOw.bFC.bFO : "");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.bFw);
        downloadData.setUrl(advertAppInfo.bFv);
        downloadData.setName(advertAppInfo.bFt);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.g.b.f(advertAppInfo.bFs, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.jQ()) {
                l.showToast(this.mContext.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.acM()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.mQ(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.e.a.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        a.this.d(advertAppInfo, i);
                        if (a.this.iMb != null) {
                            a.this.iMb.p(a.this.c(advertAppInfo, i));
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
                aVar.b(this.mContext).agO();
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
                    h.f(advertAppInfo);
                    apkDownloadView.q(c);
                    return;
                case 2:
                case 4:
                default:
                    return;
                case 3:
                    h.aN(this.mContext.getPageActivity(), advertAppInfo.bFw);
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
            } else if (this.hhJ != null) {
                this.hhJ.b(advertAppInfo, i);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        this.hhJ = cVar;
    }
}
