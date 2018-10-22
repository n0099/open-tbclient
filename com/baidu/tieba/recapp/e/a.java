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
    private HeadImageView eeO;
    private com.baidu.tieba.lego.card.c ffy;
    private ApkDownloadView gFX;
    private CustomMessageListener gFn;
    private String gIo;
    private TextView gJd;

    public a(View view, String str) {
        super(view, str);
        this.gFn = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.e.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(a.this.gIo) && a.this.gIo.equals(downloadData.getId())) {
                    a.this.gFX.s(downloadData);
                }
            }
        };
        init();
    }

    private void init() {
        this.eeO = (HeadImageView) tm(e.g.user_portrait);
        this.eeO.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.eeO.setDefaultResource(e.f.icon_default_avatar100);
        this.eeO.setDefaultBgResource(e.d.cp_bg_line_e);
        this.eeO.setIsRound(true);
        this.aGD = (TextView) tm(e.g.user_name);
        this.gJd = (TextView) tm(e.g.action);
        this.gFX = (ApkDownloadView) tm(e.g.download_view);
        MessageManager.getInstance().registerListener(this.gFn);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(AdCard.f fVar) {
        super.a(fVar);
        this.eeO.startLoad(fVar.gEx, 10, false);
        this.aGD.setText(fVar.userName);
        this.gJd.setText(fVar.buttonText);
        if (this.gJn != null) {
            View$OnClickListenerC0268a view$OnClickListenerC0268a = new View$OnClickListenerC0268a(this.gJn);
            this.mRootView.setOnClickListener(view$OnClickListenerC0268a);
            this.gFX.setOnClickListener(view$OnClickListenerC0268a);
            int intValue = Integer.valueOf(this.gJn.adPosition).intValue();
            this.gIo = this.gJn.alg;
            DownloadData c = c(this.gJn, intValue);
            c.setStatus(ApkDownloadView.getStatus(c));
            this.gFX.setData(c);
        }
        this.gFX.p(this.mContext.getUniqueId());
        this.gFn.setTag(this.mContext.getUniqueId());
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        al.j(this.mRootView, e.d.cp_cont_b_alpha80);
        al.c(this.aGD, e.d.cp_cont_i, 1);
        al.c(this.gJd, e.d.cp_cont_i, 1);
        al.e(this.gJd, e.d.cp_link_tip_a, 1);
        this.gFX.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* renamed from: com.baidu.tieba.recapp.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class View$OnClickListenerC0268a implements View.OnClickListener {
        private AdvertAppInfo gIr;

        public View$OnClickListenerC0268a(AdvertAppInfo advertAppInfo) {
            this.gIr = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.kM()) {
                a.this.mContext.showToast(e.j.neterror);
                return;
            }
            boolean z = view == a.this.gFX;
            if (this.gIr != null) {
                int l = com.baidu.adp.lib.g.b.l(this.gIr.adPosition, -1);
                int status = ApkDownloadView.getStatus(a.this.c(this.gIr, l));
                if ((6 != status && 7 != status) || !j.kX() || j.kY()) {
                    a.this.a(this.gIr, l, a.this.gFX, z);
                } else {
                    a.this.showDownloadAppDialog(this.gIr, l, true, this.gIr.aln != null ? this.gIr.aln.alz : "");
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
                        if (a.this.gFX != null) {
                            a.this.gFX.p(a.this.c(advertAppInfo, i));
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
            } else if (this.ffy != null) {
                this.ffy.b(advertAppInfo, i);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        this.ffy = cVar;
    }
}
