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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.download.h;
import com.baidu.tieba.recapp.lego.model.AdPostPbData;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
/* loaded from: classes20.dex */
public class AdPostPbView extends PostAdBaseView<AdPostPbData> {
    private View dWz;
    protected View.OnClickListener gWX;
    private TextView ktT;
    protected CustomMessageListener lnZ;
    private ApkDownloadView loO;
    private TextView lqF;
    private TextView lqG;
    private TextView lqH;
    private TbImageView lqI;
    private TextView lqJ;
    private String lqK;
    private AdPostPbData lqL;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private View rootView;

    public AdPostPbView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gWX = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostPbView.this.lqL != null) {
                    int c = s.c(AdPostPbView.this.dVN, AdPostPbView.this.lqL.scheme, AdPostPbView.this.lqL.id);
                    if (AdPostPbView.this.jzO != null) {
                        AdPostPbView.this.jzO.d(c, null);
                    }
                }
            }
        };
        this.lnZ = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdPostPbView.this.lqK) && AdPostPbView.this.lqK.equals(downloadData.getId())) {
                    AdPostPbView.this.loO.t(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData) {
        this.lqL = adPostPbData;
        this.lqI.startLoad(adPostPbData.portrait, 17, false);
        this.ktT.setText(adPostPbData.recommend);
        this.lqF.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.lqG.setVisibility(8);
        } else {
            this.lqG.setVisibility(0);
            this.lqG.setText(adPostPbData.desc);
        }
        this.lqH.setText(adPostPbData.buttonText);
        this.lqJ.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.lqI.setRadius(l.getDimens(getContext(), R.dimen.ds32));
            this.lqH.setVisibility(8);
            this.loO.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.loO.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.lqK = advertAppInfo.dMZ;
                DownloadData c = c(advertAppInfo, this.position);
                c.setStatus(ApkDownloadView.getStatus(c));
                this.loO.setData(c);
                return;
            }
            return;
        }
        this.lqI.setRadius(0);
        this.loO.setVisibility(8);
        this.lqH.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData, int i) {
        ao.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        ao.setBackgroundColor(this.dWz, R.color.cp_bg_line_e);
        ao.setViewTextColor(this.ktT, R.color.cp_cont_b);
        ao.setViewTextColor(this.lqJ, R.color.cp_cont_j);
        ao.setViewTextColor(this.lqF, R.color.cp_cont_b);
        ao.setViewTextColor(this.lqG, R.color.cp_cont_j);
        ao.setViewTextColor(this.lqH, R.color.cp_link_tip_a);
        ao.setBackgroundResource(this.lqH, R.drawable.feed_ad_progress_button_bg);
        this.loO.setTextColor(ao.getColor(R.color.cp_btn_a));
        this.loO.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View cBx() {
        MessageManager.getInstance().registerListener(this.lnZ);
        this.lnZ.setTag(this.dVN.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.post_ad_pb_banner_card, (ViewGroup) null);
        this.lqI = (TbImageView) this.rootView.findViewById(R.id.image);
        this.lqH = (TextView) this.rootView.findViewById(R.id.action_button);
        this.ktT = (TextView) this.rootView.findViewById(R.id.recommend_title);
        this.lqF = (TextView) this.rootView.findViewById(R.id.ad_title);
        this.lqG = (TextView) this.rootView.findViewById(R.id.ad_description);
        this.lqJ = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.dWz = this.rootView.findViewById(R.id.divider);
        this.loO = (ApkDownloadView) this.rootView.findViewById(R.id.ad_download);
        this.loO.y(this.dVN.getUniqueId());
        this.rootView.setOnClickListener(this.gWX);
        this.lqH.setOnClickListener(this.gWX);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.dMZ);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.dMX);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.toInt(advertAppInfo.dMW, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.dVN.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.dVN.getPageActivity()) && this.jzP != null) {
                this.jzP.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.q(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.dVN.getPageActivity(), R.string.neterror);
            } else if (advertAppInfo.aUf()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.dVN.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dVN.getPageActivity());
                aVar.xl(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdPostPbView.this.a(advertAppInfo, i, AdPostPbView.this.loO);
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.dVN).aYL();
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
                    s.aM(this.dVN.getPageActivity(), advertAppInfo.dMZ);
                    return;
                case 6:
                case 7:
                    a(advertAppInfo, i, apkDownloadView);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public class a implements View.OnClickListener {
        private AdvertAppInfo lqN;

        public a(AdvertAppInfo advertAppInfo) {
            this.lqN = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdPostPbView.this.dVN.showToast(R.string.neterror);
                return;
            }
            boolean z = view == AdPostPbView.this.loO;
            if (this.lqN != null) {
                int i = b.toInt(this.lqN.adPosition, -1);
                int status = ApkDownloadView.getStatus(AdPostPbView.this.c(this.lqN, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    AdPostPbView.this.a(this.lqN, i, AdPostPbView.this.loO, z);
                    if (AdPostPbView.this.jzO != null) {
                        AdPostPbView.this.jzO.d(3, null);
                        return;
                    }
                    return;
                }
                AdPostPbView.this.showDownloadAppDialog(this.lqN, i, true, this.lqN.dNf != null ? this.lqN.dNf.dNr : "");
            }
        }
    }
}
