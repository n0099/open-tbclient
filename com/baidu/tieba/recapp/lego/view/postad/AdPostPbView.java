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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.download.g;
import com.baidu.tieba.recapp.lego.model.AdPostPbData;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
/* loaded from: classes3.dex */
public class AdPostPbView extends PostAdBaseView<AdPostPbData> {
    protected View.OnClickListener ctV;
    private View divider;
    private TextView fDf;
    private ApkDownloadView gpR;
    protected CustomMessageListener gph;
    private TextView gsa;
    private TextView gsb;
    private TextView gsc;
    private TbImageView gsd;
    private TextView gse;
    private String gsf;
    private AdPostPbData gsg;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    private View rootView;

    public AdPostPbView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ctV = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostPbView.this.gsg != null) {
                    int e = s.e(AdPostPbView.this.mContext, AdPostPbView.this.gsg.scheme);
                    if (AdPostPbView.this.eME != null) {
                        AdPostPbView.this.eME.b(e, null);
                    }
                }
            }
        };
        this.gph = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdPostPbView.this.gsf) && AdPostPbView.this.gsf.equals(downloadData.getId())) {
                    AdPostPbView.this.gpR.u(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData) {
        this.gsg = adPostPbData;
        this.gsd.startLoad(adPostPbData.portrait, 17, false);
        this.fDf.setText(adPostPbData.recommend);
        this.gsa.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.gsb.setVisibility(8);
        } else {
            this.gsb.setVisibility(0);
            this.gsb.setText(adPostPbData.desc);
        }
        this.gsc.setText(adPostPbData.buttonText);
        this.gse.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.gsd.setRadius(l.e(getContext(), d.e.ds32));
            this.gsc.setVisibility(8);
            this.gpR.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.gpR.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.gsf = advertAppInfo.aef;
                DownloadData c = c(advertAppInfo, this.position);
                c.setStatus(ApkDownloadView.getStatus(c));
                this.gpR.setData(c);
                return;
            }
            return;
        }
        this.gsd.setRadius(0);
        this.gpR.setVisibility(8);
        this.gsc.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData, int i) {
        am.j(this.rootView, d.C0142d.cp_bg_line_d);
        am.j(this.divider, d.C0142d.cp_bg_line_e);
        am.h(this.fDf, d.C0142d.cp_cont_b);
        am.h(this.gse, d.C0142d.cp_cont_j);
        am.h(this.gsa, d.C0142d.cp_cont_b);
        am.h(this.gsb, d.C0142d.cp_cont_j);
        am.h(this.gsc, d.C0142d.cp_link_tip_a);
        am.i(this.gsc, d.f.feed_ad_progress_button_bg);
        this.gpR.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View aQw() {
        MessageManager.getInstance().registerListener(this.gph);
        this.gph.setTag(this.mContext.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(d.i.post_ad_pb_banner_card, (ViewGroup) null);
        this.gsd = (TbImageView) this.rootView.findViewById(d.g.image);
        this.gsc = (TextView) this.rootView.findViewById(d.g.action_button);
        this.fDf = (TextView) this.rootView.findViewById(d.g.recommend_title);
        this.gsa = (TextView) this.rootView.findViewById(d.g.ad_title);
        this.gsb = (TextView) this.rootView.findViewById(d.g.ad_description);
        this.gse = (TextView) this.rootView.findViewById(d.g.ad_tag);
        this.divider = this.rootView.findViewById(d.g.divider);
        this.gpR = (ApkDownloadView) this.rootView.findViewById(d.g.ad_download);
        this.gpR.q(this.mContext.getUniqueId());
        this.rootView.setOnClickListener(this.ctV);
        this.gsc.setOnClickListener(this.ctV);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.aef);
        downloadData.setUrl(advertAppInfo.aee);
        downloadData.setName(advertAppInfo.aeb);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.g(advertAppInfo.aea, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.Aj();
            this.mPermissionJudgePolicy.c(this.mContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.u(this.mContext.getPageActivity()) && this.eMF != null) {
                this.eMF.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.s(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.jr()) {
                l.showToast(this.mContext.getPageActivity(), d.k.neterror);
            } else if (advertAppInfo.tU()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(d.k.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.dE(str);
                aVar.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdPostPbView.this.a(advertAppInfo, i, AdPostPbView.this.gpR);
                        aVar2.dismiss();
                    }
                });
                aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.mContext).xn();
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
                        apkDownloadView.t(c);
                        return;
                    }
                    return;
                case 2:
                case 4:
                default:
                    return;
                case 3:
                    s.al(this.mContext.getPageActivity(), advertAppInfo.aef);
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
        private AdvertAppInfo gsi;

        public a(AdvertAppInfo advertAppInfo) {
            this.gsi = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.jr()) {
                AdPostPbView.this.mContext.showToast(d.k.neterror);
                return;
            }
            boolean z = view == AdPostPbView.this.gpR;
            if (this.gsi != null) {
                int g = b.g(this.gsi.adPosition, -1);
                int status = ApkDownloadView.getStatus(AdPostPbView.this.c(this.gsi, g));
                if ((6 != status && 7 != status) || !j.jD() || j.jE()) {
                    AdPostPbView.this.a(this.gsi, g, AdPostPbView.this.gpR, z);
                    if (AdPostPbView.this.eME != null) {
                        AdPostPbView.this.eME.b(3, null);
                        return;
                    }
                    return;
                }
                AdPostPbView.this.showDownloadAppDialog(this.gsi, g, true, this.gsi.aem != null ? this.gsi.aem.aey : "");
            }
        }
    }
}
