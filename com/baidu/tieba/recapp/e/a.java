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
    private TextView bTX;
    private HeadImageView fCZ;
    private com.baidu.tieba.lego.card.c gHz;
    private ApkDownloadView ijN;
    private CustomMessageListener ijd;
    private TextView imT;
    private String imf;

    public a(View view, String str) {
        super(view, str);
        this.ijd = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.e.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(a.this.imf) && a.this.imf.equals(downloadData.getId())) {
                    a.this.ijN.s(downloadData);
                }
            }
        };
        init();
    }

    private void init() {
        this.fCZ = (HeadImageView) yd(d.g.user_portrait);
        this.fCZ.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.fCZ.setDefaultResource(d.f.icon_default_avatar100);
        this.fCZ.setDefaultBgResource(d.C0236d.cp_bg_line_e);
        this.fCZ.setIsRound(true);
        this.bTX = (TextView) yd(d.g.user_name);
        this.imT = (TextView) yd(d.g.action);
        this.ijN = (ApkDownloadView) yd(d.g.download_view);
        MessageManager.getInstance().registerListener(this.ijd);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(AdCard.f fVar) {
        super.a(fVar);
        this.fCZ.startLoad(fVar.iio, 10, false);
        this.bTX.setText(fVar.userName);
        this.imT.setText(fVar.buttonText);
        if (this.inc != null) {
            View$OnClickListenerC0302a view$OnClickListenerC0302a = new View$OnClickListenerC0302a(this.inc);
            this.mRootView.setOnClickListener(view$OnClickListenerC0302a);
            this.ijN.setOnClickListener(view$OnClickListenerC0302a);
            int intValue = Integer.valueOf(this.inc.adPosition).intValue();
            this.imf = this.inc.bwF;
            DownloadData c = c(this.inc, intValue);
            c.setStatus(ApkDownloadView.getStatus(c));
            this.ijN.setData(c);
        }
        this.ijN.q(this.mContext.getUniqueId());
        this.ijd.setTag(this.mContext.getUniqueId());
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        al.l(this.mRootView, d.C0236d.cp_cont_b_alpha80);
        al.d(this.bTX, d.C0236d.cp_btn_a, 1);
        al.d(this.imT, d.C0236d.cp_btn_a, 1);
        al.f(this.imT, d.C0236d.cp_link_tip_a, 1);
        this.ijN.bxV();
    }

    /* renamed from: com.baidu.tieba.recapp.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class View$OnClickListenerC0302a implements View.OnClickListener {
        private AdvertAppInfo imj;

        public View$OnClickListenerC0302a(AdvertAppInfo advertAppInfo) {
            this.imj = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.kM()) {
                a.this.mContext.showToast(d.j.neterror);
                return;
            }
            boolean z = view == a.this.ijN;
            if (this.imj != null) {
                int l = com.baidu.adp.lib.g.b.l(this.imj.adPosition, -1);
                int status = ApkDownloadView.getStatus(a.this.c(this.imj, l));
                if ((6 != status && 7 != status) || !j.kY() || j.kZ()) {
                    a.this.a(this.imj, l, a.this.ijN, z);
                } else {
                    a.this.showDownloadAppDialog(this.imj, l, true, this.imj.bwL != null ? this.imj.bwL.bwX : "");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.bwF);
        downloadData.setUrl(advertAppInfo.bwE);
        downloadData.setName(advertAppInfo.bwC);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.g.b.l(advertAppInfo.bwB, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.kM()) {
                l.showToast(this.mContext.getPageActivity(), d.j.neterror);
            } else if (advertAppInfo.Xb()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(d.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.ly(str);
                aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.e.a.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        a.this.d(advertAppInfo, i);
                        if (a.this.ijN != null) {
                            a.this.ijN.p(a.this.c(advertAppInfo, i));
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
                aVar.b(this.mContext).aaZ();
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
                    g.aS(this.mContext.getPageActivity(), advertAppInfo.bwF);
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
            } else if (this.gHz != null) {
                this.gHz.b(advertAppInfo, i);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        this.gHz = cVar;
    }
}
