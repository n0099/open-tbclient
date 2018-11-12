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
    protected View.OnClickListener cLM;
    private View divider;
    private TextView fTW;
    protected CustomMessageListener gGO;
    private ApkDownloadView gHy;
    private TextView gJK;
    private TextView gJL;
    private TextView gJM;
    private TbImageView gJN;
    private TextView gJO;
    private String gJP;
    private AdPostPbData gJQ;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    private View rootView;

    public AdPostPbView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.cLM = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostPbView.this.gJQ != null) {
                    int e = s.e(AdPostPbView.this.mContext, AdPostPbView.this.gJQ.scheme);
                    if (AdPostPbView.this.fgQ != null) {
                        AdPostPbView.this.fgQ.b(e, null);
                    }
                }
            }
        };
        this.gGO = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdPostPbView.this.gJP) && AdPostPbView.this.gJP.equals(downloadData.getId())) {
                    AdPostPbView.this.gHy.s(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData) {
        this.gJQ = adPostPbData;
        this.gJN.startLoad(adPostPbData.portrait, 17, false);
        this.fTW.setText(adPostPbData.recommend);
        this.gJK.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.gJL.setVisibility(8);
        } else {
            this.gJL.setVisibility(0);
            this.gJL.setText(adPostPbData.desc);
        }
        this.gJM.setText(adPostPbData.buttonText);
        this.gJO.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.gJN.setRadius(l.h(getContext(), e.C0200e.ds32));
            this.gJM.setVisibility(8);
            this.gHy.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.gHy.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.gJP = advertAppInfo.alU;
                DownloadData c = c(advertAppInfo, this.position);
                c.setStatus(ApkDownloadView.getStatus(c));
                this.gHy.setData(c);
                return;
            }
            return;
        }
        this.gJN.setRadius(0);
        this.gHy.setVisibility(8);
        this.gJM.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData, int i) {
        al.j(this.rootView, e.d.cp_bg_line_d);
        al.j(this.divider, e.d.cp_bg_line_e);
        al.h(this.fTW, e.d.cp_cont_b);
        al.h(this.gJO, e.d.cp_cont_j);
        al.h(this.gJK, e.d.cp_cont_b);
        al.h(this.gJL, e.d.cp_cont_j);
        al.h(this.gJM, e.d.cp_link_tip_a);
        al.i(this.gJM, e.f.feed_ad_progress_button_bg);
        this.gHy.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View aWt() {
        MessageManager.getInstance().registerListener(this.gGO);
        this.gGO.setTag(this.mContext.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(e.h.post_ad_pb_banner_card, (ViewGroup) null);
        this.gJN = (TbImageView) this.rootView.findViewById(e.g.image);
        this.gJM = (TextView) this.rootView.findViewById(e.g.action_button);
        this.fTW = (TextView) this.rootView.findViewById(e.g.recommend_title);
        this.gJK = (TextView) this.rootView.findViewById(e.g.ad_title);
        this.gJL = (TextView) this.rootView.findViewById(e.g.ad_description);
        this.gJO = (TextView) this.rootView.findViewById(e.g.ad_tag);
        this.divider = this.rootView.findViewById(e.g.divider);
        this.gHy = (ApkDownloadView) this.rootView.findViewById(e.g.ad_download);
        this.gHy.p(this.mContext.getUniqueId());
        this.rootView.setOnClickListener(this.cLM);
        this.gJM.setOnClickListener(this.cLM);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.alU);
        downloadData.setUrl(advertAppInfo.alT);
        downloadData.setName(advertAppInfo.alQ);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.l(advertAppInfo.alP, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.Dp();
            this.mPermissionJudgePolicy.c(this.mContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.A(this.mContext.getPageActivity()) && this.fgR != null) {
                this.fgR.b(advertAppInfo, i);
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
            } else if (advertAppInfo.wZ()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(e.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.ej(str);
                aVar.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdPostPbView.this.a(advertAppInfo, i, AdPostPbView.this.gHy);
                        aVar2.dismiss();
                    }
                });
                aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.mContext).AB();
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
                    s.aD(this.mContext.getPageActivity(), advertAppInfo.alU);
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
        private AdvertAppInfo gJS;

        public a(AdvertAppInfo advertAppInfo) {
            this.gJS = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.kK()) {
                AdPostPbView.this.mContext.showToast(e.j.neterror);
                return;
            }
            boolean z = view == AdPostPbView.this.gHy;
            if (this.gJS != null) {
                int l = b.l(this.gJS.adPosition, -1);
                int status = ApkDownloadView.getStatus(AdPostPbView.this.c(this.gJS, l));
                if ((6 != status && 7 != status) || !j.kV() || j.kW()) {
                    AdPostPbView.this.a(this.gJS, l, AdPostPbView.this.gHy, z);
                    if (AdPostPbView.this.fgQ != null) {
                        AdPostPbView.this.fgQ.b(3, null);
                        return;
                    }
                    return;
                }
                AdPostPbView.this.showDownloadAppDialog(this.gJS, l, true, this.gJS.ama != null ? this.gJS.ama.amm : "");
            }
        }
    }
}
