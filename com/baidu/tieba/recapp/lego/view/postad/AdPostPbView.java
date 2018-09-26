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
    protected View.OnClickListener cCl;
    private View divider;
    private TextView fKV;
    private TextView gAJ;
    private TextView gAK;
    private TextView gAL;
    private TbImageView gAM;
    private TextView gAN;
    private String gAO;
    private AdPostPbData gAP;
    protected CustomMessageListener gxM;
    private ApkDownloadView gyw;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    private View rootView;

    public AdPostPbView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.cCl = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostPbView.this.gAP != null) {
                    int e = s.e(AdPostPbView.this.mContext, AdPostPbView.this.gAP.scheme);
                    if (AdPostPbView.this.eXP != null) {
                        AdPostPbView.this.eXP.b(e, null);
                    }
                }
            }
        };
        this.gxM = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdPostPbView.this.gAO) && AdPostPbView.this.gAO.equals(downloadData.getId())) {
                    AdPostPbView.this.gyw.s(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData) {
        this.gAP = adPostPbData;
        this.gAM.startLoad(adPostPbData.portrait, 17, false);
        this.fKV.setText(adPostPbData.recommend);
        this.gAJ.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.gAK.setVisibility(8);
        } else {
            this.gAK.setVisibility(0);
            this.gAK.setText(adPostPbData.desc);
        }
        this.gAL.setText(adPostPbData.buttonText);
        this.gAN.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.gAM.setRadius(l.h(getContext(), e.C0141e.ds32));
            this.gAL.setVisibility(8);
            this.gyw.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.gyw.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.gAO = advertAppInfo.agk;
                DownloadData c = c(advertAppInfo, this.position);
                c.setStatus(ApkDownloadView.getStatus(c));
                this.gyw.setData(c);
                return;
            }
            return;
        }
        this.gAM.setRadius(0);
        this.gyw.setVisibility(8);
        this.gAL.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData, int i) {
        al.j(this.rootView, e.d.cp_bg_line_d);
        al.j(this.divider, e.d.cp_bg_line_e);
        al.h(this.fKV, e.d.cp_cont_b);
        al.h(this.gAN, e.d.cp_cont_j);
        al.h(this.gAJ, e.d.cp_cont_b);
        al.h(this.gAK, e.d.cp_cont_j);
        al.h(this.gAL, e.d.cp_link_tip_a);
        al.i(this.gAL, e.f.feed_ad_progress_button_bg);
        this.gyw.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View aTI() {
        MessageManager.getInstance().registerListener(this.gxM);
        this.gxM.setTag(this.mContext.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(e.h.post_ad_pb_banner_card, (ViewGroup) null);
        this.gAM = (TbImageView) this.rootView.findViewById(e.g.image);
        this.gAL = (TextView) this.rootView.findViewById(e.g.action_button);
        this.fKV = (TextView) this.rootView.findViewById(e.g.recommend_title);
        this.gAJ = (TextView) this.rootView.findViewById(e.g.ad_title);
        this.gAK = (TextView) this.rootView.findViewById(e.g.ad_description);
        this.gAN = (TextView) this.rootView.findViewById(e.g.ad_tag);
        this.divider = this.rootView.findViewById(e.g.divider);
        this.gyw = (ApkDownloadView) this.rootView.findViewById(e.g.ad_download);
        this.gyw.p(this.mContext.getUniqueId());
        this.rootView.setOnClickListener(this.cCl);
        this.gAL.setOnClickListener(this.cCl);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.agk);
        downloadData.setUrl(advertAppInfo.agj);
        downloadData.setName(advertAppInfo.agg);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.l(advertAppInfo.agf, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.Bb();
            this.mPermissionJudgePolicy.c(this.mContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.x(this.mContext.getPageActivity()) && this.eXQ != null) {
                this.eXQ.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.p(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.ky()) {
                l.showToast(this.mContext.getPageActivity(), e.j.neterror);
            } else if (advertAppInfo.uI()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(e.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.dT(str);
                aVar.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdPostPbView.this.a(advertAppInfo, i, AdPostPbView.this.gyw);
                        aVar2.dismiss();
                    }
                });
                aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.mContext).yl();
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
                    s.aD(this.mContext.getPageActivity(), advertAppInfo.agk);
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
        private AdvertAppInfo gAR;

        public a(AdvertAppInfo advertAppInfo) {
            this.gAR = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.ky()) {
                AdPostPbView.this.mContext.showToast(e.j.neterror);
                return;
            }
            boolean z = view == AdPostPbView.this.gyw;
            if (this.gAR != null) {
                int l = b.l(this.gAR.adPosition, -1);
                int status = ApkDownloadView.getStatus(AdPostPbView.this.c(this.gAR, l));
                if ((6 != status && 7 != status) || !j.kK() || j.kL()) {
                    AdPostPbView.this.a(this.gAR, l, AdPostPbView.this.gyw, z);
                    if (AdPostPbView.this.eXP != null) {
                        AdPostPbView.this.eXP.b(3, null);
                        return;
                    }
                    return;
                }
                AdPostPbView.this.showDownloadAppDialog(this.gAR, l, true, this.gAR.agr != null ? this.gAR.agr.agD : "");
            }
        }
    }
}
