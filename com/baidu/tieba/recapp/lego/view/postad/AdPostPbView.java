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
/* loaded from: classes8.dex */
public class AdPostPbView extends PostAdBaseView<AdPostPbData> {
    private View bTo;
    protected View.OnClickListener ixc;
    private TextView lXF;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    protected CustomMessageListener mTQ;
    private TextView mWE;
    private TextView mWF;
    private TextView mWG;
    private TbImageView mWH;
    private TextView mWI;
    private ApkDownloadView mWJ;
    private String mWK;
    private AdPostPbData mWL;
    private View rootView;

    public AdPostPbView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ixc = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostPbView.this.mWL != null) {
                    int c = s.c(AdPostPbView.this.eUY, AdPostPbView.this.mWL.scheme, AdPostPbView.this.mWL.id);
                    if (AdPostPbView.this.lcl != null) {
                        AdPostPbView.this.lcl.d(c, null);
                    }
                }
            }
        };
        this.mTQ = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdPostPbView.this.mWK) && AdPostPbView.this.mWK.equals(downloadData.getId())) {
                    AdPostPbView.this.mWJ.t(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData) {
        this.mWL = adPostPbData;
        this.mWH.startLoad(adPostPbData.portrait, 17, false);
        this.lXF.setText(adPostPbData.recommend);
        this.mWE.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.mWF.setVisibility(8);
        } else {
            this.mWF.setVisibility(0);
            this.mWF.setText(adPostPbData.desc);
        }
        this.mWG.setText(adPostPbData.buttonText);
        this.mWI.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.mWH.setRadius(l.getDimens(getContext(), R.dimen.ds32));
            this.mWG.setVisibility(8);
            this.mWJ.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.mWJ.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.mWK = advertAppInfo.eLx;
                DownloadData d = d(advertAppInfo, this.position);
                d.setStatus(ApkDownloadView.getStatus(d));
                this.mWJ.setData(d);
                return;
            }
            return;
        }
        this.mWH.setRadius(0);
        this.mWJ.setVisibility(8);
        this.mWG.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData, int i) {
        ap.setBackgroundColor(this.rootView, R.color.CAM_X0201);
        ap.setBackgroundColor(this.bTo, R.color.CAM_X0205);
        ap.setViewTextColor(this.lXF, R.color.CAM_X0105);
        ap.setViewTextColor(this.mWI, R.color.CAM_X0107);
        ap.setViewTextColor(this.mWE, R.color.CAM_X0105);
        ap.setViewTextColor(this.mWF, R.color.CAM_X0107);
        ap.setViewTextColor(this.mWG, R.color.CAM_X0302);
        ap.setBackgroundResource(this.mWG, R.drawable.feed_ad_progress_button_bg);
        this.mWJ.setTextColor(ap.getColor(R.color.CAM_X0901));
        this.mWJ.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View dbO() {
        MessageManager.getInstance().registerListener(this.mTQ);
        this.mTQ.setTag(this.eUY.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.post_ad_pb_banner_card, (ViewGroup) null);
        this.mWH = (TbImageView) this.rootView.findViewById(R.id.image);
        this.mWG = (TextView) this.rootView.findViewById(R.id.action_button);
        this.lXF = (TextView) this.rootView.findViewById(R.id.recommend_title);
        this.mWE = (TextView) this.rootView.findViewById(R.id.ad_title);
        this.mWF = (TextView) this.rootView.findViewById(R.id.ad_description);
        this.mWI = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.bTo = this.rootView.findViewById(R.id.divider);
        this.mWJ = (ApkDownloadView) this.rootView.findViewById(R.id.ad_download);
        this.mWJ.y(this.eUY.getUniqueId());
        this.rootView.setOnClickListener(this.ixc);
        this.mWG.setOnClickListener(this.ixc);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData d(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.eLx != null ? advertAppInfo.eLx : advertAppInfo.eLu);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.eLv);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.toInt(advertAppInfo.eLu, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.eUY.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.eUY.getPageActivity()) && this.lcm != null) {
                this.lcm.c(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.q(d(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.eUY.getPageActivity(), R.string.neterror);
            } else if (advertAppInfo.blE()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.eUY.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eUY.getPageActivity());
                aVar.Au(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdPostPbView.this.a(advertAppInfo, i, AdPostPbView.this.mWJ);
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.eUY).bqx();
            }
        }
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView, boolean z) {
        if (advertAppInfo != null) {
            DownloadData d = d(advertAppInfo, i);
            switch (ApkDownloadView.getStatus(d)) {
                case 1:
                case 5:
                    if (z) {
                        h.i(advertAppInfo);
                        apkDownloadView.r(d);
                        return;
                    }
                    return;
                case 2:
                case 4:
                default:
                    return;
                case 3:
                    s.installApp(this.eUY.getPageActivity(), advertAppInfo.eLx);
                    return;
                case 6:
                case 7:
                    a(advertAppInfo, i, apkDownloadView);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        private AdvertAppInfo mWO;

        public a(AdvertAppInfo advertAppInfo) {
            this.mWO = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdPostPbView.this.eUY.showToast(R.string.neterror);
                return;
            }
            boolean z = view == AdPostPbView.this.mWJ;
            if (this.mWO != null) {
                int i = b.toInt(this.mWO.adPosition, -1);
                int status = ApkDownloadView.getStatus(AdPostPbView.this.d(this.mWO, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    AdPostPbView.this.a(this.mWO, i, AdPostPbView.this.mWJ, z);
                    if (AdPostPbView.this.lcl != null) {
                        AdPostPbView.this.lcl.d(3, null);
                        return;
                    }
                    return;
                }
                AdPostPbView.this.showDownloadAppDialog(this.mWO, i, true, this.mWO.eLD != null ? this.mWO.eLD.eLQ : "");
            }
        }
    }
}
