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
    protected View.OnClickListener eCY;
    private TextView hTn;
    protected CustomMessageListener iIV;
    private ApkDownloadView iJF;
    private TextView iLS;
    private TextView iLT;
    private TextView iLU;
    private TbImageView iLV;
    private TextView iLW;
    private String iLX;
    private AdPostPbData iLY;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    private View rootView;

    public AdPostPbView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eCY = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostPbView.this.iLY != null) {
                    int e = s.e(AdPostPbView.this.mContext, AdPostPbView.this.iLY.scheme);
                    if (AdPostPbView.this.hfO != null) {
                        AdPostPbView.this.hfO.b(e, null);
                    }
                }
            }
        };
        this.iIV = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdPostPbView.this.iLX) && AdPostPbView.this.iLX.equals(downloadData.getId())) {
                    AdPostPbView.this.iJF.s(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData) {
        this.iLY = adPostPbData;
        this.iLV.startLoad(adPostPbData.portrait, 17, false);
        this.hTn.setText(adPostPbData.recommend);
        this.iLS.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.iLT.setVisibility(8);
        } else {
            this.iLT.setVisibility(0);
            this.iLT.setText(adPostPbData.desc);
        }
        this.iLU.setText(adPostPbData.buttonText);
        this.iLW.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.iLV.setRadius(l.g(getContext(), R.dimen.ds32));
            this.iLU.setVisibility(8);
            this.iJF.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.iJF.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.iLX = advertAppInfo.bEY;
                DownloadData c = c(advertAppInfo, this.position);
                c.setStatus(ApkDownloadView.getStatus(c));
                this.iJF.setData(c);
                return;
            }
            return;
        }
        this.iLV.setRadius(0);
        this.iJF.setVisibility(8);
        this.iLU.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData, int i) {
        am.l(this.rootView, R.color.cp_bg_line_d);
        am.l(this.divider, R.color.cp_bg_line_e);
        am.j(this.hTn, R.color.cp_cont_b);
        am.j(this.iLW, R.color.cp_cont_j);
        am.j(this.iLS, R.color.cp_cont_b);
        am.j(this.iLT, R.color.cp_cont_j);
        am.j(this.iLU, R.color.cp_link_tip_a);
        am.k(this.iLU, R.drawable.feed_ad_progress_button_bg);
        this.iJF.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View bKJ() {
        MessageManager.getInstance().registerListener(this.iIV);
        this.iIV.setTag(this.mContext.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.post_ad_pb_banner_card, (ViewGroup) null);
        this.iLV = (TbImageView) this.rootView.findViewById(R.id.image);
        this.iLU = (TextView) this.rootView.findViewById(R.id.action_button);
        this.hTn = (TextView) this.rootView.findViewById(R.id.recommend_title);
        this.iLS = (TextView) this.rootView.findViewById(R.id.ad_title);
        this.iLT = (TextView) this.rootView.findViewById(R.id.ad_description);
        this.iLW = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.divider = this.rootView.findViewById(R.id.divider);
        this.iJF = (ApkDownloadView) this.rootView.findViewById(R.id.ad_download);
        this.iJF.s(this.mContext.getUniqueId());
        this.rootView.setOnClickListener(this.eCY);
        this.iLU.setOnClickListener(this.eCY);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.bEY);
        downloadData.setUrl(advertAppInfo.bEX);
        downloadData.setName(advertAppInfo.bEV);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.f(advertAppInfo.bEU, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.ajS();
            this.mPermissionJudgePolicy.e(this.mContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.ad(this.mContext.getPageActivity()) && this.hfP != null) {
                this.hfP.b(advertAppInfo, i);
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
            } else if (advertAppInfo.acI()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.mO(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdPostPbView.this.a(advertAppInfo, i, AdPostPbView.this.iJF);
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.mContext).agK();
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
                    s.aG(this.mContext.getPageActivity(), advertAppInfo.bEY);
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
        private AdvertAppInfo iMa;

        public a(AdvertAppInfo advertAppInfo) {
            this.iMa = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.jQ()) {
                AdPostPbView.this.mContext.showToast(R.string.neterror);
                return;
            }
            boolean z = view == AdPostPbView.this.iJF;
            if (this.iMa != null) {
                int f = b.f(this.iMa.adPosition, -1);
                int status = ApkDownloadView.getStatus(AdPostPbView.this.c(this.iMa, f));
                if ((6 != status && 7 != status) || !j.kc() || j.kd()) {
                    AdPostPbView.this.a(this.iMa, f, AdPostPbView.this.iJF, z);
                    if (AdPostPbView.this.hfO != null) {
                        AdPostPbView.this.hfO.b(3, null);
                        return;
                    }
                    return;
                }
                AdPostPbView.this.showDownloadAppDialog(this.iMa, f, true, this.iMa.bFe != null ? this.iMa.bFe.bFq : "");
            }
        }
    }
}
