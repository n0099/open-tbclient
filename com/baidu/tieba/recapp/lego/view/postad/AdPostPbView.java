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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.download.g;
import com.baidu.tieba.recapp.lego.model.AdPostPbData;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
/* loaded from: classes3.dex */
public class AdPostPbView extends PostAdBaseView<AdPostPbData> {
    protected View.OnClickListener cma;
    private View divider;
    protected CustomMessageListener fYS;
    private ApkDownloadView fZC;
    private TextView fmD;
    private TextView gbL;
    private TextView gbM;
    private TextView gbN;
    private TbImageView gbO;
    private TextView gbP;
    private String gbQ;
    private AdPostPbData gbR;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    private View rootView;

    public AdPostPbView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.cma = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (AdPostPbView.this.gbR != null) {
                    int e = s.e(AdPostPbView.this.adf, AdPostPbView.this.gbR.scheme);
                    if (AdPostPbView.this.ewj != null) {
                        AdPostPbView.this.ewj.b(e, null);
                    }
                }
            }
        };
        this.fYS = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdPostPbView.this.gbQ) && AdPostPbView.this.gbQ.equals(downloadData.getId())) {
                    AdPostPbView.this.fZC.u(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData) {
        this.gbR = adPostPbData;
        this.gbO.startLoad(adPostPbData.portrait, 17, false);
        this.fmD.setText(adPostPbData.recommend);
        this.gbL.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.gbM.setVisibility(8);
        } else {
            this.gbM.setVisibility(0);
            this.gbM.setText(adPostPbData.desc);
        }
        this.gbN.setText(adPostPbData.buttonText);
        this.gbP.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.gbO.setRadius(l.e(getContext(), d.e.ds32));
            this.gbN.setVisibility(8);
            this.fZC.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.fZC.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.gbQ = advertAppInfo.VU;
                DownloadData c = c(advertAppInfo, this.position);
                c.setStatus(ApkDownloadView.getStatus(c));
                this.fZC.setData(c);
                return;
            }
            return;
        }
        this.gbO.setRadius(0);
        this.fZC.setVisibility(8);
        this.gbN.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData, int i) {
        ak.j(this.rootView, d.C0126d.cp_bg_line_d);
        ak.j(this.divider, d.C0126d.cp_bg_line_e);
        ak.h(this.fmD, d.C0126d.cp_cont_b);
        ak.h(this.gbP, d.C0126d.cp_cont_j);
        ak.h(this.gbL, d.C0126d.cp_cont_b);
        ak.h(this.gbM, d.C0126d.cp_cont_j);
        ak.h(this.gbN, d.C0126d.cp_link_tip_a);
        ak.i(this.gbN, d.f.feed_ad_progress_button_bg);
        this.fZC.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View aKU() {
        MessageManager.getInstance().registerListener(this.fYS);
        this.fYS.setTag(this.adf.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(d.i.post_ad_pb_banner_card, (ViewGroup) null);
        this.gbO = (TbImageView) this.rootView.findViewById(d.g.image);
        this.gbN = (TextView) this.rootView.findViewById(d.g.action_button);
        this.fmD = (TextView) this.rootView.findViewById(d.g.recommend_title);
        this.gbL = (TextView) this.rootView.findViewById(d.g.ad_title);
        this.gbM = (TextView) this.rootView.findViewById(d.g.ad_description);
        this.gbP = (TextView) this.rootView.findViewById(d.g.ad_tag);
        this.divider = this.rootView.findViewById(d.g.divider);
        this.fZC = (ApkDownloadView) this.rootView.findViewById(d.g.ad_download);
        this.fZC.p(this.adf.getUniqueId());
        this.rootView.setOnClickListener(this.cma);
        this.gbN.setOnClickListener(this.cma);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.VU);
        downloadData.setUrl(advertAppInfo.VT);
        downloadData.setName(advertAppInfo.VQ);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.g(advertAppInfo.VP, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.wu();
            this.mPermissionJudgePolicy.c(this.adf.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.v(this.adf.getPageActivity()) && this.ewk != null) {
                this.ewk.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.s(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.gD()) {
                l.showToast(this.adf.getPageActivity(), d.k.neterror);
            } else if (advertAppInfo.qt()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.adf.getString(d.k.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.adf.getPageActivity());
                aVar.dc(str);
                aVar.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdPostPbView.this.a(advertAppInfo, i, AdPostPbView.this.fZC);
                        aVar2.dismiss();
                    }
                });
                aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.adf).tD();
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
                        g.e(advertAppInfo);
                        apkDownloadView.t(c);
                        return;
                    }
                    return;
                case 2:
                case 4:
                default:
                    return;
                case 3:
                    s.aj(this.adf.getPageActivity(), advertAppInfo.VU);
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
        private AdvertAppInfo gbT;

        public a(AdvertAppInfo advertAppInfo) {
            this.gbT = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (!j.gD()) {
                AdPostPbView.this.adf.showToast(d.k.neterror);
                return;
            }
            boolean z = view2 == AdPostPbView.this.fZC;
            if (this.gbT != null) {
                int g = b.g(this.gbT.adPosition, -1);
                int status = ApkDownloadView.getStatus(AdPostPbView.this.c(this.gbT, g));
                if ((6 != status && 7 != status) || !j.gP() || j.gQ()) {
                    AdPostPbView.this.a(this.gbT, g, AdPostPbView.this.fZC, z);
                    if (AdPostPbView.this.ewj != null) {
                        AdPostPbView.this.ewj.b(3, null);
                        return;
                    }
                    return;
                }
                AdPostPbView.this.showDownloadAppDialog(this.gbT, g, true, this.gbT.Wb != null ? this.gbT.Wb.Wm : "");
            }
        }
    }
}
