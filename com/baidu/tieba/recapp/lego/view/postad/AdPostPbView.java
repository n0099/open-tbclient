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
import com.baidu.tieba.recapp.t;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
/* loaded from: classes7.dex */
public class AdPostPbView extends PostAdBaseView<AdPostPbData> {
    private View bUO;
    protected View.OnClickListener iyZ;
    private TextView lZW;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    protected CustomMessageListener mWB;
    private TextView mZp;
    private TextView mZq;
    private TextView mZr;
    private TbImageView mZs;
    private TextView mZt;
    private ApkDownloadView mZu;
    private String mZv;
    private AdPostPbData mZw;
    private View rootView;

    public AdPostPbView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.iyZ = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostPbView.this.mZw != null) {
                    int a2 = t.a(AdPostPbView.this.eWx, AdPostPbView.this.mZw.scheme, AdPostPbView.this.mZw.id, AdPostPbView.this.mZw.extInfo);
                    if (AdPostPbView.this.leD != null) {
                        AdPostPbView.this.leD.d(a2, null);
                    }
                }
            }
        };
        this.mWB = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdPostPbView.this.mZv) && AdPostPbView.this.mZv.equals(downloadData.getId())) {
                    AdPostPbView.this.mZu.s(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData) {
        this.mZw = adPostPbData;
        this.mZs.startLoad(adPostPbData.portrait, 17, false);
        this.lZW.setText(adPostPbData.recommend);
        this.mZp.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.mZq.setVisibility(8);
        } else {
            this.mZq.setVisibility(0);
            this.mZq.setText(adPostPbData.desc);
        }
        this.mZr.setText(adPostPbData.buttonText);
        this.mZt.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.mZs.setRadius(l.getDimens(getContext(), R.dimen.ds32));
            this.mZr.setVisibility(8);
            this.mZu.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.mZu.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.mZv = advertAppInfo.eMX;
                DownloadData d = d(advertAppInfo, this.position);
                d.setStatus(ApkDownloadView.getStatus(d));
                this.mZu.setData(d);
                return;
            }
            return;
        }
        this.mZs.setRadius(0);
        this.mZu.setVisibility(8);
        this.mZr.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData, int i) {
        ap.setBackgroundColor(this.rootView, R.color.CAM_X0201);
        ap.setBackgroundColor(this.bUO, R.color.CAM_X0205);
        ap.setViewTextColor(this.lZW, R.color.CAM_X0105);
        ap.setViewTextColor(this.mZt, R.color.CAM_X0107);
        ap.setViewTextColor(this.mZp, R.color.CAM_X0105);
        ap.setViewTextColor(this.mZq, R.color.CAM_X0107);
        ap.setViewTextColor(this.mZr, R.color.CAM_X0302);
        ap.setBackgroundResource(this.mZr, R.drawable.feed_ad_progress_button_bg);
        this.mZu.setTextColor(ap.getColor(R.color.CAM_X0901));
        this.mZu.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View dce() {
        MessageManager.getInstance().registerListener(this.mWB);
        this.mWB.setTag(this.eWx.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.post_ad_pb_banner_card, (ViewGroup) null);
        this.mZs = (TbImageView) this.rootView.findViewById(R.id.image);
        this.mZr = (TextView) this.rootView.findViewById(R.id.action_button);
        this.lZW = (TextView) this.rootView.findViewById(R.id.recommend_title);
        this.mZp = (TextView) this.rootView.findViewById(R.id.ad_title);
        this.mZq = (TextView) this.rootView.findViewById(R.id.ad_description);
        this.mZt = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.bUO = this.rootView.findViewById(R.id.divider);
        this.mZu = (ApkDownloadView) this.rootView.findViewById(R.id.ad_download);
        this.mZu.z(this.eWx.getUniqueId());
        this.rootView.setOnClickListener(this.iyZ);
        this.mZr.setOnClickListener(this.iyZ);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData d(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.eMX != null ? advertAppInfo.eMX : advertAppInfo.eMU);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.eMV);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.toInt(advertAppInfo.eMU, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.eWx.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.eWx.getPageActivity()) && this.leE != null) {
                this.leE.c(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.p(d(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.eWx.getPageActivity(), R.string.neterror);
            } else if (advertAppInfo.blG()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.eWx.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eWx.getPageActivity());
                aVar.AB(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdPostPbView.this.a(advertAppInfo, i, AdPostPbView.this.mZu);
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.eWx).bqz();
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
                        apkDownloadView.q(d);
                        return;
                    }
                    return;
                case 2:
                case 4:
                default:
                    return;
                case 3:
                    t.installApp(this.eWx.getPageActivity(), advertAppInfo.eMX);
                    return;
                case 6:
                case 7:
                    a(advertAppInfo, i, apkDownloadView);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        private AdvertAppInfo mZy;

        public a(AdvertAppInfo advertAppInfo) {
            this.mZy = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdPostPbView.this.eWx.showToast(R.string.neterror);
                return;
            }
            boolean z = view == AdPostPbView.this.mZu;
            if (this.mZy != null) {
                int i = b.toInt(this.mZy.adPosition, -1);
                int status = ApkDownloadView.getStatus(AdPostPbView.this.d(this.mZy, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    AdPostPbView.this.a(this.mZy, i, AdPostPbView.this.mZu, z);
                    if (AdPostPbView.this.leD != null) {
                        AdPostPbView.this.leD.d(3, null);
                        return;
                    }
                    return;
                }
                AdPostPbView.this.showDownloadAppDialog(this.mZy, i, true, this.mZy.eNd != null ? this.mZy.eNd.eNr : "");
            }
        }
    }
}
