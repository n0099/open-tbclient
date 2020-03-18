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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.download.h;
import com.baidu.tieba.recapp.lego.model.AdPostPbData;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
/* loaded from: classes13.dex */
public class AdPostPbView extends PostAdBaseView<AdPostPbData> {
    private View cWh;
    protected View.OnClickListener fKP;
    private TextView iOw;
    protected CustomMessageListener jJY;
    private ApkDownloadView jKM;
    private TextView jMX;
    private TextView jMY;
    private TextView jMZ;
    private TbImageView jNa;
    private TextView jNb;
    private String jNc;
    private AdPostPbData jNd;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private View rootView;

    public AdPostPbView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fKP = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostPbView.this.jNd != null) {
                    int b = s.b(AdPostPbView.this.cVv, AdPostPbView.this.jNd.scheme, AdPostPbView.this.jNd.id);
                    if (AdPostPbView.this.iaq != null) {
                        AdPostPbView.this.iaq.b(b, null);
                    }
                }
            }
        };
        this.jJY = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdPostPbView.this.jNc) && AdPostPbView.this.jNc.equals(downloadData.getId())) {
                    AdPostPbView.this.jKM.t(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData) {
        this.jNd = adPostPbData;
        this.jNa.startLoad(adPostPbData.portrait, 17, false);
        this.iOw.setText(adPostPbData.recommend);
        this.jMX.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.jMY.setVisibility(8);
        } else {
            this.jMY.setVisibility(0);
            this.jMY.setText(adPostPbData.desc);
        }
        this.jMZ.setText(adPostPbData.buttonText);
        this.jNb.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.jNa.setRadius(l.getDimens(getContext(), R.dimen.ds32));
            this.jMZ.setVisibility(8);
            this.jKM.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.jKM.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.jNc = advertAppInfo.cNn;
                DownloadData c = c(advertAppInfo, this.position);
                c.setStatus(ApkDownloadView.getStatus(c));
                this.jKM.setData(c);
                return;
            }
            return;
        }
        this.jNa.setRadius(0);
        this.jKM.setVisibility(8);
        this.jMZ.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData, int i) {
        am.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.cWh, R.color.cp_bg_line_e);
        am.setViewTextColor(this.iOw, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.jNb, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.jMX, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.jMY, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.jMZ, (int) R.color.cp_link_tip_a);
        am.setBackgroundResource(this.jMZ, R.drawable.feed_ad_progress_button_bg);
        this.jKM.setTextColor(am.getColor(R.color.cp_btn_a));
        this.jKM.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View ccz() {
        MessageManager.getInstance().registerListener(this.jJY);
        this.jJY.setTag(this.cVv.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.post_ad_pb_banner_card, (ViewGroup) null);
        this.jNa = (TbImageView) this.rootView.findViewById(R.id.image);
        this.jMZ = (TextView) this.rootView.findViewById(R.id.action_button);
        this.iOw = (TextView) this.rootView.findViewById(R.id.recommend_title);
        this.jMX = (TextView) this.rootView.findViewById(R.id.ad_title);
        this.jMY = (TextView) this.rootView.findViewById(R.id.ad_description);
        this.jNb = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.cWh = this.rootView.findViewById(R.id.divider);
        this.jKM = (ApkDownloadView) this.rootView.findViewById(R.id.ad_download);
        this.jKM.u(this.cVv.getUniqueId());
        this.rootView.setOnClickListener(this.fKP);
        this.jMZ.setOnClickListener(this.fKP);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.cNn);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.cNl);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.toInt(advertAppInfo.cNk, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.cVv.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.cVv.getPageActivity()) && this.iar != null) {
                this.iar.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.q(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.cVv.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.aAt()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.cVv.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cVv.getPageActivity());
                aVar.sR(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdPostPbView.this.a(advertAppInfo, i, AdPostPbView.this.jKM);
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.cVv).aEG();
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
                    s.bd(this.cVv.getPageActivity(), advertAppInfo.cNn);
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
        private AdvertAppInfo jNf;

        public a(AdvertAppInfo advertAppInfo) {
            this.jNf = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdPostPbView.this.cVv.showToast(R.string.neterror);
                return;
            }
            boolean z = view == AdPostPbView.this.jKM;
            if (this.jNf != null) {
                int i = b.toInt(this.jNf.adPosition, -1);
                int status = ApkDownloadView.getStatus(AdPostPbView.this.c(this.jNf, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    AdPostPbView.this.a(this.jNf, i, AdPostPbView.this.jKM, z);
                    if (AdPostPbView.this.iaq != null) {
                        AdPostPbView.this.iaq.b(3, null);
                        return;
                    }
                    return;
                }
                AdPostPbView.this.showDownloadAppDialog(this.jNf, i, true, this.jNf.cNt != null ? this.jNf.cNt.cNF : "");
            }
        }
    }
}
