package com.baidu.tieba.recapp.lego.view.postad;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.g.b;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.recapp.download.g;
import com.baidu.tieba.recapp.lego.model.AdPostPbData;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
/* loaded from: classes3.dex */
public class AdPostPbView extends PostAdBaseView<AdPostPbData> {
    protected View.OnClickListener cVV;
    private View divider;
    protected CustomMessageListener gRA;
    private ApkDownloadView gSk;
    private TextView gUA;
    private TbImageView gUB;
    private TextView gUC;
    private String gUD;
    private AdPostPbData gUE;
    private TextView gUy;
    private TextView gUz;
    private TextView geJ;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    private View rootView;

    public AdPostPbView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.cVV = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostPbView.this.gUE != null) {
                    int e = s.e(AdPostPbView.this.mContext, AdPostPbView.this.gUE.scheme);
                    if (AdPostPbView.this.frw != null) {
                        AdPostPbView.this.frw.b(e, null);
                    }
                }
            }
        };
        this.gRA = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdPostPbView.this.gUD) && AdPostPbView.this.gUD.equals(downloadData.getId())) {
                    AdPostPbView.this.gSk.s(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData) {
        this.gUE = adPostPbData;
        this.gUB.startLoad(adPostPbData.portrait, 17, false);
        this.geJ.setText(adPostPbData.recommend);
        this.gUy.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.gUz.setVisibility(8);
        } else {
            this.gUz.setVisibility(0);
            this.gUz.setText(adPostPbData.desc);
        }
        this.gUA.setText(adPostPbData.buttonText);
        this.gUC.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.gUB.setRadius(l.h(getContext(), e.C0210e.ds32));
            this.gUA.setVisibility(8);
            this.gSk.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.gSk.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.gUD = advertAppInfo.apY;
                DownloadData c = c(advertAppInfo, this.position);
                c.setStatus(ApkDownloadView.getStatus(c));
                this.gSk.setData(c);
                return;
            }
            return;
        }
        this.gUB.setRadius(0);
        this.gSk.setVisibility(8);
        this.gUA.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData, int i) {
        al.j(this.rootView, e.d.cp_bg_line_d);
        al.j(this.divider, e.d.cp_bg_line_e);
        al.h(this.geJ, e.d.cp_cont_b);
        al.h(this.gUC, e.d.cp_cont_j);
        al.h(this.gUy, e.d.cp_cont_b);
        al.h(this.gUz, e.d.cp_cont_j);
        al.h(this.gUA, e.d.cp_link_tip_a);
        al.i(this.gUA, e.f.feed_ad_progress_button_bg);
        this.gSk.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View aZy() {
        MessageManager.getInstance().registerListener(this.gRA);
        this.gRA.setTag(this.mContext.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(e.h.post_ad_pb_banner_card, (ViewGroup) null);
        this.gUB = (TbImageView) this.rootView.findViewById(e.g.image);
        this.gUA = (TextView) this.rootView.findViewById(e.g.action_button);
        this.geJ = (TextView) this.rootView.findViewById(e.g.recommend_title);
        this.gUy = (TextView) this.rootView.findViewById(e.g.ad_title);
        this.gUz = (TextView) this.rootView.findViewById(e.g.ad_description);
        this.gUC = (TextView) this.rootView.findViewById(e.g.ad_tag);
        this.divider = this.rootView.findViewById(e.g.divider);
        this.gSk = (ApkDownloadView) this.rootView.findViewById(e.g.ad_download);
        this.gSk.p(this.mContext.getUniqueId());
        this.rootView.setOnClickListener(this.cVV);
        this.gUA.setOnClickListener(this.cVV);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.apY);
        downloadData.setUrl(advertAppInfo.apX);
        downloadData.setName(advertAppInfo.apU);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.l(advertAppInfo.apT, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.EG();
            this.mPermissionJudgePolicy.c(this.mContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.B(this.mContext.getPageActivity()) && this.frx != null) {
                this.frx.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.p(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.kK()) {
                l.showToast(this.mContext.getPageActivity(), e.j.neterror);
            } else if (advertAppInfo.yq()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(e.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.eK(str);
                aVar.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdPostPbView.this.a(advertAppInfo, i, AdPostPbView.this.gSk);
                        aVar2.dismiss();
                    }
                });
                aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.mContext).BS();
            }
        }
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView, boolean z) {
        if (advertAppInfo != null) {
            DownloadData c = c(advertAppInfo, i);
            switch (ApkDownloadView.getStatus(c)) {
                case 1:
                case 5:
                    if (z) {
                        g.f(advertAppInfo);
                        apkDownloadView.q(c);
                        return;
                    }
                    return;
                case 2:
                case 4:
                default:
                    return;
                case 3:
                    s.aE(this.mContext.getPageActivity(), advertAppInfo.apY);
                    return;
                case 6:
                case 7:
                    a(advertAppInfo, i, apkDownloadView);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private AdvertAppInfo gUG;

        public a(AdvertAppInfo advertAppInfo) {
            this.gUG = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.kK()) {
                AdPostPbView.this.mContext.showToast(e.j.neterror);
                return;
            }
            boolean z = view == AdPostPbView.this.gSk;
            if (this.gUG != null) {
                int l = b.l(this.gUG.adPosition, -1);
                int status = ApkDownloadView.getStatus(AdPostPbView.this.c(this.gUG, l));
                if ((6 != status && 7 != status) || !j.kV() || j.kW()) {
                    AdPostPbView.this.a(this.gUG, l, AdPostPbView.this.gSk, z);
                    if (AdPostPbView.this.frw != null) {
                        AdPostPbView.this.frw.b(3, null);
                        return;
                    }
                    return;
                }
                AdPostPbView.this.showDownloadAppDialog(this.gUG, l, true, this.gUG.aqe != null ? this.gUG.aqe.aqq : "");
            }
        }
    }
}
