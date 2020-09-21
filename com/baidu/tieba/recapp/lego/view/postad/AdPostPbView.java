package com.baidu.tieba.recapp.lego.view.postad;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.download.h;
import com.baidu.tieba.recapp.lego.model.AdPostPbData;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
/* loaded from: classes25.dex */
public class AdPostPbView extends PostAdBaseView<AdPostPbData> {
    private View eis;
    protected View.OnClickListener hqX;
    private TextView kSh;
    protected CustomMessageListener lNF;
    private ApkDownloadView lOs;
    private TextView lQj;
    private TextView lQk;
    private TextView lQl;
    private TbImageView lQm;
    private TextView lQn;
    private String lQo;
    private AdPostPbData lQp;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private View rootView;

    public AdPostPbView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hqX = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostPbView.this.lQp != null) {
                    int c = s.c(AdPostPbView.this.ehG, AdPostPbView.this.lQp.scheme, AdPostPbView.this.lQp.id);
                    if (AdPostPbView.this.jXT != null) {
                        AdPostPbView.this.jXT.d(c, null);
                    }
                }
            }
        };
        this.lNF = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdPostPbView.this.lQo) && AdPostPbView.this.lQo.equals(downloadData.getId())) {
                    AdPostPbView.this.lOs.t(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData) {
        this.lQp = adPostPbData;
        this.lQm.startLoad(adPostPbData.portrait, 17, false);
        this.kSh.setText(adPostPbData.recommend);
        this.lQj.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.lQk.setVisibility(8);
        } else {
            this.lQk.setVisibility(0);
            this.lQk.setText(adPostPbData.desc);
        }
        this.lQl.setText(adPostPbData.buttonText);
        this.lQn.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.lQm.setRadius(l.getDimens(getContext(), R.dimen.ds32));
            this.lQl.setVisibility(8);
            this.lOs.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.lOs.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.lQo = advertAppInfo.dYw;
                DownloadData b = b(advertAppInfo, this.position);
                b.setStatus(ApkDownloadView.getStatus(b));
                this.lOs.setData(b);
                return;
            }
            return;
        }
        this.lQm.setRadius(0);
        this.lOs.setVisibility(8);
        this.lQl.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData, int i) {
        ap.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.eis, R.color.cp_bg_line_e);
        ap.setViewTextColor(this.kSh, R.color.cp_cont_b);
        ap.setViewTextColor(this.lQn, R.color.cp_cont_j);
        ap.setViewTextColor(this.lQj, R.color.cp_cont_b);
        ap.setViewTextColor(this.lQk, R.color.cp_cont_j);
        ap.setViewTextColor(this.lQl, R.color.cp_link_tip_a);
        ap.setBackgroundResource(this.lQl, R.drawable.feed_ad_progress_button_bg);
        this.lOs.setTextColor(ap.getColor(R.color.cp_btn_a));
        this.lOs.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View cPW() {
        MessageManager.getInstance().registerListener(this.lNF);
        this.lNF.setTag(this.ehG.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.post_ad_pb_banner_card, (ViewGroup) null);
        this.lQm = (TbImageView) this.rootView.findViewById(R.id.image);
        this.lQl = (TextView) this.rootView.findViewById(R.id.action_button);
        this.kSh = (TextView) this.rootView.findViewById(R.id.recommend_title);
        this.lQj = (TextView) this.rootView.findViewById(R.id.ad_title);
        this.lQk = (TextView) this.rootView.findViewById(R.id.ad_description);
        this.lQn = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.eis = this.rootView.findViewById(R.id.divider);
        this.lOs = (ApkDownloadView) this.rootView.findViewById(R.id.ad_download);
        this.lOs.x(this.ehG.getUniqueId());
        this.rootView.setOnClickListener(this.hqX);
        this.lQl.setOnClickListener(this.hqX);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData b(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.dYw);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.dYu);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.toInt(advertAppInfo.dYt, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.ehG.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.ehG.getPageActivity()) && this.jXU != null) {
                this.jXU.c(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.q(b(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.ehG.getPageActivity(), R.string.neterror);
            } else if (advertAppInfo.bdq()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.ehG.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ehG.getPageActivity());
                aVar.zV(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdPostPbView.this.a(advertAppInfo, i, AdPostPbView.this.lOs);
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.ehG).bia();
            }
        }
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView, boolean z) {
        if (advertAppInfo != null) {
            DownloadData b = b(advertAppInfo, i);
            switch (ApkDownloadView.getStatus(b)) {
                case 1:
                case 5:
                    if (z) {
                        h.e(advertAppInfo);
                        apkDownloadView.r(b);
                        return;
                    }
                    return;
                case 2:
                case 4:
                default:
                    return;
                case 3:
                    s.aT(this.ehG.getPageActivity(), advertAppInfo.dYw);
                    return;
                case 6:
                case 7:
                    a(advertAppInfo, i, apkDownloadView);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public class a implements View.OnClickListener {
        private AdvertAppInfo lQr;

        public a(AdvertAppInfo advertAppInfo) {
            this.lQr = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdPostPbView.this.ehG.showToast(R.string.neterror);
                return;
            }
            boolean z = view == AdPostPbView.this.lOs;
            if (this.lQr != null) {
                int i = b.toInt(this.lQr.adPosition, -1);
                int status = ApkDownloadView.getStatus(AdPostPbView.this.b(this.lQr, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    AdPostPbView.this.a(this.lQr, i, AdPostPbView.this.lOs, z);
                    if (AdPostPbView.this.jXT != null) {
                        AdPostPbView.this.jXT.d(3, null);
                        return;
                    }
                    return;
                }
                AdPostPbView.this.showDownloadAppDialog(this.lQr, i, true, this.lQr.dYC != null ? this.lQr.dYC.dYO : "");
            }
        }
    }
}
