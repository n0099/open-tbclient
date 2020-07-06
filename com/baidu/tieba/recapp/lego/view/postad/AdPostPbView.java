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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.download.h;
import com.baidu.tieba.recapp.lego.model.AdPostPbData;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
/* loaded from: classes13.dex */
public class AdPostPbView extends PostAdBaseView<AdPostPbData> {
    private View dQh;
    protected View.OnClickListener gRs;
    private TextView kkU;
    protected CustomMessageListener lgK;
    private ApkDownloadView lhv;
    private TextView ljm;
    private TextView ljn;
    private TextView ljo;
    private TbImageView ljp;
    private TextView ljq;
    private String ljr;
    private AdPostPbData ljs;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private View rootView;

    public AdPostPbView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gRs = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostPbView.this.ljs != null) {
                    int c = r.c(AdPostPbView.this.dPv, AdPostPbView.this.ljs.scheme, AdPostPbView.this.ljs.id);
                    if (AdPostPbView.this.jrl != null) {
                        AdPostPbView.this.jrl.d(c, null);
                    }
                }
            }
        };
        this.lgK = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdPostPbView.this.ljr) && AdPostPbView.this.ljr.equals(downloadData.getId())) {
                    AdPostPbView.this.lhv.t(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData) {
        this.ljs = adPostPbData;
        this.ljp.startLoad(adPostPbData.portrait, 17, false);
        this.kkU.setText(adPostPbData.recommend);
        this.ljm.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.ljn.setVisibility(8);
        } else {
            this.ljn.setVisibility(0);
            this.ljn.setText(adPostPbData.desc);
        }
        this.ljo.setText(adPostPbData.buttonText);
        this.ljq.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.ljp.setRadius(l.getDimens(getContext(), R.dimen.ds32));
            this.ljo.setVisibility(8);
            this.lhv.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.lhv.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.ljr = advertAppInfo.dGO;
                DownloadData c = c(advertAppInfo, this.position);
                c.setStatus(ApkDownloadView.getStatus(c));
                this.lhv.setData(c);
                return;
            }
            return;
        }
        this.ljp.setRadius(0);
        this.lhv.setVisibility(8);
        this.ljo.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData, int i) {
        an.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        an.setBackgroundColor(this.dQh, R.color.cp_bg_line_e);
        an.setViewTextColor(this.kkU, (int) R.color.cp_cont_b);
        an.setViewTextColor(this.ljq, (int) R.color.cp_cont_j);
        an.setViewTextColor(this.ljm, (int) R.color.cp_cont_b);
        an.setViewTextColor(this.ljn, (int) R.color.cp_cont_j);
        an.setViewTextColor(this.ljo, (int) R.color.cp_link_tip_a);
        an.setBackgroundResource(this.ljo, R.drawable.feed_ad_progress_button_bg);
        this.lhv.setTextColor(an.getColor(R.color.cp_btn_a));
        this.lhv.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View cxz() {
        MessageManager.getInstance().registerListener(this.lgK);
        this.lgK.setTag(this.dPv.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.post_ad_pb_banner_card, (ViewGroup) null);
        this.ljp = (TbImageView) this.rootView.findViewById(R.id.image);
        this.ljo = (TextView) this.rootView.findViewById(R.id.action_button);
        this.kkU = (TextView) this.rootView.findViewById(R.id.recommend_title);
        this.ljm = (TextView) this.rootView.findViewById(R.id.ad_title);
        this.ljn = (TextView) this.rootView.findViewById(R.id.ad_description);
        this.ljq = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.dQh = this.rootView.findViewById(R.id.divider);
        this.lhv = (ApkDownloadView) this.rootView.findViewById(R.id.ad_download);
        this.lhv.x(this.dPv.getUniqueId());
        this.rootView.setOnClickListener(this.gRs);
        this.ljo.setOnClickListener(this.gRs);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.dGO);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.dGM);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.toInt(advertAppInfo.dGL, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.dPv.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.dPv.getPageActivity()) && this.jrm != null) {
                this.jrm.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.q(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.dPv.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.aQj()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.dPv.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dPv.getPageActivity());
                aVar.we(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdPostPbView.this.a(advertAppInfo, i, AdPostPbView.this.lhv);
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.dPv).aUN();
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
                        h.f(advertAppInfo);
                        apkDownloadView.r(c);
                        return;
                    }
                    return;
                case 2:
                case 4:
                default:
                    return;
                case 3:
                    r.aN(this.dPv.getPageActivity(), advertAppInfo.dGO);
                    return;
                case 6:
                case 7:
                    a(advertAppInfo, i, apkDownloadView);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class a implements View.OnClickListener {
        private AdvertAppInfo lju;

        public a(AdvertAppInfo advertAppInfo) {
            this.lju = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdPostPbView.this.dPv.showToast(R.string.neterror);
                return;
            }
            boolean z = view == AdPostPbView.this.lhv;
            if (this.lju != null) {
                int i = b.toInt(this.lju.adPosition, -1);
                int status = ApkDownloadView.getStatus(AdPostPbView.this.c(this.lju, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    AdPostPbView.this.a(this.lju, i, AdPostPbView.this.lhv, z);
                    if (AdPostPbView.this.jrl != null) {
                        AdPostPbView.this.jrl.d(3, null);
                        return;
                    }
                    return;
                }
                AdPostPbView.this.showDownloadAppDialog(this.lju, i, true, this.lju.dGU != null ? this.lju.dGU.dHg : "");
            }
        }
    }
}
