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
    protected View.OnClickListener cwy;
    private View divider;
    private TextView fDs;
    protected CustomMessageListener gqr;
    private ApkDownloadView grb;
    private TextView gtm;
    private TextView gtn;
    private TextView gto;
    private TbImageView gtp;
    private TextView gtq;
    private String gtr;
    private AdPostPbData gts;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    private View rootView;

    public AdPostPbView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.cwy = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostPbView.this.gts != null) {
                    int e = s.e(AdPostPbView.this.mContext, AdPostPbView.this.gts.scheme);
                    if (AdPostPbView.this.eQz != null) {
                        AdPostPbView.this.eQz.b(e, null);
                    }
                }
            }
        };
        this.gqr = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdPostPbView.this.gtr) && AdPostPbView.this.gtr.equals(downloadData.getId())) {
                    AdPostPbView.this.grb.s(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData) {
        this.gts = adPostPbData;
        this.gtp.startLoad(adPostPbData.portrait, 17, false);
        this.fDs.setText(adPostPbData.recommend);
        this.gtm.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.gtn.setVisibility(8);
        } else {
            this.gtn.setVisibility(0);
            this.gtn.setText(adPostPbData.desc);
        }
        this.gto.setText(adPostPbData.buttonText);
        this.gtq.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.gtp.setRadius(l.f(getContext(), d.e.ds32));
            this.gto.setVisibility(8);
            this.grb.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.grb.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.gtr = advertAppInfo.adJ;
                DownloadData c = c(advertAppInfo, this.position);
                c.setStatus(ApkDownloadView.getStatus(c));
                this.grb.setData(c);
                return;
            }
            return;
        }
        this.gtp.setRadius(0);
        this.grb.setVisibility(8);
        this.gto.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData, int i) {
        am.j(this.rootView, d.C0140d.cp_bg_line_d);
        am.j(this.divider, d.C0140d.cp_bg_line_e);
        am.h(this.fDs, d.C0140d.cp_cont_b);
        am.h(this.gtq, d.C0140d.cp_cont_j);
        am.h(this.gtm, d.C0140d.cp_cont_b);
        am.h(this.gtn, d.C0140d.cp_cont_j);
        am.h(this.gto, d.C0140d.cp_link_tip_a);
        am.i(this.gto, d.f.feed_ad_progress_button_bg);
        this.grb.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View aRx() {
        MessageManager.getInstance().registerListener(this.gqr);
        this.gqr.setTag(this.mContext.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(d.h.post_ad_pb_banner_card, (ViewGroup) null);
        this.gtp = (TbImageView) this.rootView.findViewById(d.g.image);
        this.gto = (TextView) this.rootView.findViewById(d.g.action_button);
        this.fDs = (TextView) this.rootView.findViewById(d.g.recommend_title);
        this.gtm = (TextView) this.rootView.findViewById(d.g.ad_title);
        this.gtn = (TextView) this.rootView.findViewById(d.g.ad_description);
        this.gtq = (TextView) this.rootView.findViewById(d.g.ad_tag);
        this.divider = this.rootView.findViewById(d.g.divider);
        this.grb = (ApkDownloadView) this.rootView.findViewById(d.g.ad_download);
        this.grb.q(this.mContext.getUniqueId());
        this.rootView.setOnClickListener(this.cwy);
        this.gto.setOnClickListener(this.cwy);
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
            this.mPermissionJudgePolicy.zY();
            this.mPermissionJudgePolicy.c(this.mContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.u(this.mContext.getPageActivity()) && this.eQA != null) {
                this.eQA.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.p(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.js()) {
                l.showToast(this.mContext.getPageActivity(), d.j.neterror);
            } else if (advertAppInfo.tG()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(d.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.dB(str);
                aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdPostPbView.this.a(advertAppInfo, i, AdPostPbView.this.grb);
                        aVar2.dismiss();
                    }
                });
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.mContext).xf();
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
        private AdvertAppInfo gtu;

        public a(AdvertAppInfo advertAppInfo) {
            this.gtu = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.js()) {
                AdPostPbView.this.mContext.showToast(d.j.neterror);
                return;
            }
            boolean z = view == AdPostPbView.this.grb;
            if (this.gtu != null) {
                int g = b.g(this.gtu.adPosition, -1);
                int status = ApkDownloadView.getStatus(AdPostPbView.this.c(this.gtu, g));
                if ((6 != status && 7 != status) || !j.jE() || j.jF()) {
                    AdPostPbView.this.a(this.gtu, g, AdPostPbView.this.grb, z);
                    if (AdPostPbView.this.eQz != null) {
                        AdPostPbView.this.eQz.b(3, null);
                        return;
                    }
                    return;
                }
                AdPostPbView.this.showDownloadAppDialog(this.gtu, g, true, this.gtu.adQ != null ? this.gtu.adQ.aec : "");
            }
        }
    }
}
