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
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.download.g;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
/* loaded from: classes3.dex */
public class a extends e {
    private TextView cbW;
    private HeadImageView fTM;
    private com.baidu.tieba.lego.card.c gYL;
    private CustomMessageListener iBz;
    private ApkDownloadView iCj;
    private String iEB;
    private TextView iFo;

    public a(View view, String str) {
        super(view, str);
        this.iBz = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.e.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(a.this.iEB) && a.this.iEB.equals(downloadData.getId())) {
                    a.this.iCj.s(downloadData);
                }
            }
        };
        init();
    }

    private void init() {
        this.fTM = (HeadImageView) zg(R.id.user_portrait);
        this.fTM.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fTM.setDefaultResource(R.drawable.icon_default_avatar100);
        this.fTM.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fTM.setIsRound(true);
        this.cbW = (TextView) zg(R.id.user_name);
        this.iFo = (TextView) zg(R.id.action);
        this.iCj = (ApkDownloadView) zg(R.id.download_view);
        MessageManager.getInstance().registerListener(this.iBz);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(AdCard.f fVar) {
        super.a(fVar);
        this.fTM.startLoad(fVar.iAL, 10, false);
        this.cbW.setText(fVar.userName);
        this.iFo.setText(fVar.buttonText);
        if (this.iFx != null) {
            View$OnClickListenerC0397a view$OnClickListenerC0397a = new View$OnClickListenerC0397a(this.iFx);
            this.mRootView.setOnClickListener(view$OnClickListenerC0397a);
            this.iCj.setOnClickListener(view$OnClickListenerC0397a);
            int intValue = Integer.valueOf(this.iFx.adPosition).intValue();
            this.iEB = this.iFx.bDX;
            DownloadData c = c(this.iFx, intValue);
            c.setStatus(ApkDownloadView.getStatus(c));
            this.iCj.setData(c);
        }
        this.iCj.s(this.mContext.getUniqueId());
        this.iBz.setTag(this.mContext.getUniqueId());
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        al.f(this.cbW, R.color.cp_btn_a, 1);
        al.f(this.iFo, R.color.cp_mask_e, 1);
        al.h(this.iFo, R.color.cp_link_tip_a, 1);
        this.iCj.bFE();
    }

    /* renamed from: com.baidu.tieba.recapp.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class View$OnClickListenerC0397a implements View.OnClickListener {
        private AdvertAppInfo iEE;

        public View$OnClickListenerC0397a(AdvertAppInfo advertAppInfo) {
            this.iEE = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.jG()) {
                a.this.mContext.showToast(R.string.neterror);
                return;
            }
            boolean z = view == a.this.iCj;
            if (this.iEE != null) {
                int f = com.baidu.adp.lib.g.b.f(this.iEE.adPosition, -1);
                int status = ApkDownloadView.getStatus(a.this.c(this.iEE, f));
                if ((6 != status && 7 != status) || !j.jS() || j.jT()) {
                    a.this.a(this.iEE, f, a.this.iCj, z);
                } else {
                    a.this.showDownloadAppDialog(this.iEE, f, true, this.iEE.bEd != null ? this.iEE.bEd.bEp : "");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.bDX);
        downloadData.setUrl(advertAppInfo.bDW);
        downloadData.setName(advertAppInfo.bDU);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.g.b.f(advertAppInfo.bDT, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.jG()) {
                l.showToast(this.mContext.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.abF()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.mD(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.e.a.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        a.this.d(advertAppInfo, i);
                        if (a.this.iCj != null) {
                            a.this.iCj.p(a.this.c(advertAppInfo, i));
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
                aVar.b(this.mContext).afG();
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
                    g.aF(this.mContext.getPageActivity(), advertAppInfo.bDX);
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
            if (!s.aq(this.mContext.getPageActivity())) {
                l.showToast(this.mContext.getPageActivity(), (int) R.string.write_external_storage_permission_denied_fun_disable);
            } else if (this.gYL != null) {
                this.gYL.b(advertAppInfo, i);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        this.gYL = cVar;
    }
}
