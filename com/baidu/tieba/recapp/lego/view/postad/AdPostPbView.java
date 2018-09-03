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
import com.baidu.tieba.f;
import com.baidu.tieba.recapp.download.g;
import com.baidu.tieba.recapp.lego.model.AdPostPbData;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
/* loaded from: classes3.dex */
public class AdPostPbView extends PostAdBaseView<AdPostPbData> {
    protected View.OnClickListener cwv;
    private View divider;
    private TextView fDl;
    protected CustomMessageListener gqu;
    private ApkDownloadView gre;
    private TextView gtp;
    private TextView gtq;
    private TextView gtr;
    private TbImageView gts;
    private TextView gtt;
    private String gtu;
    private AdPostPbData gtv;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    private View rootView;

    public AdPostPbView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.cwv = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostPbView.this.gtv != null) {
                    int e = s.e(AdPostPbView.this.mContext, AdPostPbView.this.gtv.scheme);
                    if (AdPostPbView.this.eQu != null) {
                        AdPostPbView.this.eQu.b(e, null);
                    }
                }
            }
        };
        this.gqu = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdPostPbView.this.gtu) && AdPostPbView.this.gtu.equals(downloadData.getId())) {
                    AdPostPbView.this.gre.s(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData) {
        this.gtv = adPostPbData;
        this.gts.startLoad(adPostPbData.portrait, 17, false);
        this.fDl.setText(adPostPbData.recommend);
        this.gtp.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.gtq.setVisibility(8);
        } else {
            this.gtq.setVisibility(0);
            this.gtq.setText(adPostPbData.desc);
        }
        this.gtr.setText(adPostPbData.buttonText);
        this.gtt.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.gts.setRadius(l.f(getContext(), f.e.ds32));
            this.gtr.setVisibility(8);
            this.gre.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.gre.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.gtu = advertAppInfo.adJ;
                DownloadData c = c(advertAppInfo, this.position);
                c.setStatus(ApkDownloadView.getStatus(c));
                this.gre.setData(c);
                return;
            }
            return;
        }
        this.gts.setRadius(0);
        this.gre.setVisibility(8);
        this.gtr.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData, int i) {
        am.j(this.rootView, f.d.cp_bg_line_d);
        am.j(this.divider, f.d.cp_bg_line_e);
        am.h(this.fDl, f.d.cp_cont_b);
        am.h(this.gtt, f.d.cp_cont_j);
        am.h(this.gtp, f.d.cp_cont_b);
        am.h(this.gtq, f.d.cp_cont_j);
        am.h(this.gtr, f.d.cp_link_tip_a);
        am.i(this.gtr, f.C0146f.feed_ad_progress_button_bg);
        this.gre.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View aRu() {
        MessageManager.getInstance().registerListener(this.gqu);
        this.gqu.setTag(this.mContext.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(f.h.post_ad_pb_banner_card, (ViewGroup) null);
        this.gts = (TbImageView) this.rootView.findViewById(f.g.image);
        this.gtr = (TextView) this.rootView.findViewById(f.g.action_button);
        this.fDl = (TextView) this.rootView.findViewById(f.g.recommend_title);
        this.gtp = (TextView) this.rootView.findViewById(f.g.ad_title);
        this.gtq = (TextView) this.rootView.findViewById(f.g.ad_description);
        this.gtt = (TextView) this.rootView.findViewById(f.g.ad_tag);
        this.divider = this.rootView.findViewById(f.g.divider);
        this.gre = (ApkDownloadView) this.rootView.findViewById(f.g.ad_download);
        this.gre.q(this.mContext.getUniqueId());
        this.rootView.setOnClickListener(this.cwv);
        this.gtr.setOnClickListener(this.cwv);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.adJ);
        downloadData.setUrl(advertAppInfo.adI);
        downloadData.setName(advertAppInfo.adF);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.g(advertAppInfo.adE, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.zW();
            this.mPermissionJudgePolicy.c(this.mContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.u(this.mContext.getPageActivity()) && this.eQv != null) {
                this.eQv.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.p(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.js()) {
                l.showToast(this.mContext.getPageActivity(), f.j.neterror);
            } else if (advertAppInfo.tF()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(f.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.dB(str);
                aVar.a(f.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdPostPbView.this.a(advertAppInfo, i, AdPostPbView.this.gre);
                        aVar2.dismiss();
                    }
                });
                aVar.b(f.j.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.mContext).xe();
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
                    s.an(this.mContext.getPageActivity(), advertAppInfo.adJ);
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
        private AdvertAppInfo gtx;

        public a(AdvertAppInfo advertAppInfo) {
            this.gtx = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.js()) {
                AdPostPbView.this.mContext.showToast(f.j.neterror);
                return;
            }
            boolean z = view == AdPostPbView.this.gre;
            if (this.gtx != null) {
                int g = b.g(this.gtx.adPosition, -1);
                int status = ApkDownloadView.getStatus(AdPostPbView.this.c(this.gtx, g));
                if ((6 != status && 7 != status) || !j.jE() || j.jF()) {
                    AdPostPbView.this.a(this.gtx, g, AdPostPbView.this.gre, z);
                    if (AdPostPbView.this.eQu != null) {
                        AdPostPbView.this.eQu.b(3, null);
                        return;
                    }
                    return;
                }
                AdPostPbView.this.showDownloadAppDialog(this.gtx, g, true, this.gtx.adQ != null ? this.gtx.adQ.aec : "");
            }
        }
    }
}
