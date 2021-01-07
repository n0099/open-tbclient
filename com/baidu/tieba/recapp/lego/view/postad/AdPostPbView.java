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
/* loaded from: classes8.dex */
public class AdPostPbView extends PostAdBaseView<AdPostPbData> {
    private View bUk;
    protected View.OnClickListener iwf;
    private TextView lTn;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    protected CustomMessageListener mPi;
    private TextView mRW;
    private TextView mRX;
    private TextView mRY;
    private TbImageView mRZ;
    private TextView mSa;
    private ApkDownloadView mSb;
    private String mSc;
    private AdPostPbData mSd;
    private View rootView;

    public AdPostPbView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.iwf = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostPbView.this.mSd != null) {
                    int c = s.c(AdPostPbView.this.eXu, AdPostPbView.this.mSd.scheme, AdPostPbView.this.mSd.id);
                    if (AdPostPbView.this.kYN != null) {
                        AdPostPbView.this.kYN.d(c, null);
                    }
                }
            }
        };
        this.mPi = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdPostPbView.this.mSc) && AdPostPbView.this.mSc.equals(downloadData.getId())) {
                    AdPostPbView.this.mSb.t(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData) {
        this.mSd = adPostPbData;
        this.mRZ.startLoad(adPostPbData.portrait, 17, false);
        this.lTn.setText(adPostPbData.recommend);
        this.mRW.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.mRX.setVisibility(8);
        } else {
            this.mRX.setVisibility(0);
            this.mRX.setText(adPostPbData.desc);
        }
        this.mRY.setText(adPostPbData.buttonText);
        this.mSa.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.mRZ.setRadius(l.getDimens(getContext(), R.dimen.ds32));
            this.mRY.setVisibility(8);
            this.mSb.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.mSb.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.mSc = advertAppInfo.eNW;
                DownloadData d = d(advertAppInfo, this.position);
                d.setStatus(ApkDownloadView.getStatus(d));
                this.mSb.setData(d);
                return;
            }
            return;
        }
        this.mRZ.setRadius(0);
        this.mSb.setVisibility(8);
        this.mRY.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData, int i) {
        ao.setBackgroundColor(this.rootView, R.color.CAM_X0201);
        ao.setBackgroundColor(this.bUk, R.color.CAM_X0205);
        ao.setViewTextColor(this.lTn, R.color.CAM_X0105);
        ao.setViewTextColor(this.mSa, R.color.CAM_X0107);
        ao.setViewTextColor(this.mRW, R.color.CAM_X0105);
        ao.setViewTextColor(this.mRX, R.color.CAM_X0107);
        ao.setViewTextColor(this.mRY, R.color.CAM_X0302);
        ao.setBackgroundResource(this.mRY, R.drawable.feed_ad_progress_button_bg);
        this.mSb.setTextColor(ao.getColor(R.color.CAM_X0901));
        this.mSb.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View ddI() {
        MessageManager.getInstance().registerListener(this.mPi);
        this.mPi.setTag(this.eXu.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.post_ad_pb_banner_card, (ViewGroup) null);
        this.mRZ = (TbImageView) this.rootView.findViewById(R.id.image);
        this.mRY = (TextView) this.rootView.findViewById(R.id.action_button);
        this.lTn = (TextView) this.rootView.findViewById(R.id.recommend_title);
        this.mRW = (TextView) this.rootView.findViewById(R.id.ad_title);
        this.mRX = (TextView) this.rootView.findViewById(R.id.ad_description);
        this.mSa = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.bUk = this.rootView.findViewById(R.id.divider);
        this.mSb = (ApkDownloadView) this.rootView.findViewById(R.id.ad_download);
        this.mSb.x(this.eXu.getUniqueId());
        this.rootView.setOnClickListener(this.iwf);
        this.mRY.setOnClickListener(this.iwf);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData d(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.eNW != null ? advertAppInfo.eNW : advertAppInfo.eNT);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.eNU);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.toInt(advertAppInfo.eNT, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.eXu.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.eXu.getPageActivity()) && this.kYO != null) {
                this.kYO.c(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.q(d(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.eXu.getPageActivity(), R.string.neterror);
            } else if (advertAppInfo.bpg()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.eXu.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eXu.getPageActivity());
                aVar.Bo(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdPostPbView.this.a(advertAppInfo, i, AdPostPbView.this.mSb);
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.eXu).btY();
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
                        h.h(advertAppInfo);
                        apkDownloadView.r(d);
                        return;
                    }
                    return;
                case 2:
                case 4:
                default:
                    return;
                case 3:
                    s.installApp(this.eXu.getPageActivity(), advertAppInfo.eNW);
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
        private AdvertAppInfo mSf;

        public a(AdvertAppInfo advertAppInfo) {
            this.mSf = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdPostPbView.this.eXu.showToast(R.string.neterror);
                return;
            }
            boolean z = view == AdPostPbView.this.mSb;
            if (this.mSf != null) {
                int i = b.toInt(this.mSf.adPosition, -1);
                int status = ApkDownloadView.getStatus(AdPostPbView.this.d(this.mSf, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    AdPostPbView.this.a(this.mSf, i, AdPostPbView.this.mSb, z);
                    if (AdPostPbView.this.kYN != null) {
                        AdPostPbView.this.kYN.d(3, null);
                        return;
                    }
                    return;
                }
                AdPostPbView.this.showDownloadAppDialog(this.mSf, i, true, this.mSf.eOc != null ? this.mSf.eOc.eOp : "");
            }
        }
    }
}
