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
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.download.g;
import com.baidu.tieba.recapp.lego.model.AdPostPbData;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
/* loaded from: classes3.dex */
public class AdPostPbView extends PostAdBaseView<AdPostPbData> {
    private View divider;
    protected View.OnClickListener eCR;
    private TextView hSs;
    protected CustomMessageListener iHR;
    private ApkDownloadView iIB;
    private TextView iKO;
    private TextView iKP;
    private TextView iKQ;
    private TbImageView iKR;
    private TextView iKS;
    private String iKT;
    private AdPostPbData iKU;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    private View rootView;

    public AdPostPbView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eCR = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostPbView.this.iKU != null) {
                    int e = s.e(AdPostPbView.this.mContext, AdPostPbView.this.iKU.scheme);
                    if (AdPostPbView.this.heW != null) {
                        AdPostPbView.this.heW.b(e, null);
                    }
                }
            }
        };
        this.iHR = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdPostPbView.this.iKT) && AdPostPbView.this.iKT.equals(downloadData.getId())) {
                    AdPostPbView.this.iIB.s(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData) {
        this.iKU = adPostPbData;
        this.iKR.startLoad(adPostPbData.portrait, 17, false);
        this.hSs.setText(adPostPbData.recommend);
        this.iKO.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.iKP.setVisibility(8);
        } else {
            this.iKP.setVisibility(0);
            this.iKP.setText(adPostPbData.desc);
        }
        this.iKQ.setText(adPostPbData.buttonText);
        this.iKS.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.iKR.setRadius(l.g(getContext(), R.dimen.ds32));
            this.iKQ.setVisibility(8);
            this.iIB.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.iIB.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.iKT = advertAppInfo.bEX;
                DownloadData c = c(advertAppInfo, this.position);
                c.setStatus(ApkDownloadView.getStatus(c));
                this.iIB.setData(c);
                return;
            }
            return;
        }
        this.iKR.setRadius(0);
        this.iIB.setVisibility(8);
        this.iKQ.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData, int i) {
        am.l(this.rootView, R.color.cp_bg_line_d);
        am.l(this.divider, R.color.cp_bg_line_e);
        am.j(this.hSs, R.color.cp_cont_b);
        am.j(this.iKS, R.color.cp_cont_j);
        am.j(this.iKO, R.color.cp_cont_b);
        am.j(this.iKP, R.color.cp_cont_j);
        am.j(this.iKQ, R.color.cp_link_tip_a);
        am.k(this.iKQ, R.drawable.feed_ad_progress_button_bg);
        this.iIB.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View bKv() {
        MessageManager.getInstance().registerListener(this.iHR);
        this.iHR.setTag(this.mContext.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.post_ad_pb_banner_card, (ViewGroup) null);
        this.iKR = (TbImageView) this.rootView.findViewById(R.id.image);
        this.iKQ = (TextView) this.rootView.findViewById(R.id.action_button);
        this.hSs = (TextView) this.rootView.findViewById(R.id.recommend_title);
        this.iKO = (TextView) this.rootView.findViewById(R.id.ad_title);
        this.iKP = (TextView) this.rootView.findViewById(R.id.ad_description);
        this.iKS = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.divider = this.rootView.findViewById(R.id.divider);
        this.iIB = (ApkDownloadView) this.rootView.findViewById(R.id.ad_download);
        this.iIB.s(this.mContext.getUniqueId());
        this.rootView.setOnClickListener(this.eCR);
        this.iKQ.setOnClickListener(this.eCR);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.bEX);
        downloadData.setUrl(advertAppInfo.bEW);
        downloadData.setName(advertAppInfo.bEU);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.f(advertAppInfo.bET, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.ajQ();
            this.mPermissionJudgePolicy.e(this.mContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.ad(this.mContext.getPageActivity()) && this.heX != null) {
                this.heX.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.p(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.jQ()) {
                l.showToast(this.mContext.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.acH()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.mO(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdPostPbView.this.a(advertAppInfo, i, AdPostPbView.this.iIB);
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.mContext).agI();
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
                    s.aG(this.mContext.getPageActivity(), advertAppInfo.bEX);
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
        private AdvertAppInfo iKW;

        public a(AdvertAppInfo advertAppInfo) {
            this.iKW = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.jQ()) {
                AdPostPbView.this.mContext.showToast(R.string.neterror);
                return;
            }
            boolean z = view == AdPostPbView.this.iIB;
            if (this.iKW != null) {
                int f = b.f(this.iKW.adPosition, -1);
                int status = ApkDownloadView.getStatus(AdPostPbView.this.c(this.iKW, f));
                if ((6 != status && 7 != status) || !j.kc() || j.kd()) {
                    AdPostPbView.this.a(this.iKW, f, AdPostPbView.this.iIB, z);
                    if (AdPostPbView.this.heW != null) {
                        AdPostPbView.this.heW.b(3, null);
                        return;
                    }
                    return;
                }
                AdPostPbView.this.showDownloadAppDialog(this.iKW, f, true, this.iKW.bFd != null ? this.iKW.bFd.bFp : "");
            }
        }
    }
}
