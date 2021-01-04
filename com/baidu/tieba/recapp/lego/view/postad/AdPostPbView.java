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
    private TextView lTo;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    protected CustomMessageListener mPj;
    private TextView mRX;
    private TextView mRY;
    private TextView mRZ;
    private TbImageView mSa;
    private TextView mSb;
    private ApkDownloadView mSc;
    private String mSd;
    private AdPostPbData mSe;
    private View rootView;

    public AdPostPbView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.iwf = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostPbView.this.mSe != null) {
                    int c = s.c(AdPostPbView.this.eXu, AdPostPbView.this.mSe.scheme, AdPostPbView.this.mSe.id);
                    if (AdPostPbView.this.kYN != null) {
                        AdPostPbView.this.kYN.d(c, null);
                    }
                }
            }
        };
        this.mPj = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdPostPbView.this.mSd) && AdPostPbView.this.mSd.equals(downloadData.getId())) {
                    AdPostPbView.this.mSc.t(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData) {
        this.mSe = adPostPbData;
        this.mSa.startLoad(adPostPbData.portrait, 17, false);
        this.lTo.setText(adPostPbData.recommend);
        this.mRX.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.mRY.setVisibility(8);
        } else {
            this.mRY.setVisibility(0);
            this.mRY.setText(adPostPbData.desc);
        }
        this.mRZ.setText(adPostPbData.buttonText);
        this.mSb.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.mSa.setRadius(l.getDimens(getContext(), R.dimen.ds32));
            this.mRZ.setVisibility(8);
            this.mSc.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.mSc.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.mSd = advertAppInfo.eNW;
                DownloadData d = d(advertAppInfo, this.position);
                d.setStatus(ApkDownloadView.getStatus(d));
                this.mSc.setData(d);
                return;
            }
            return;
        }
        this.mSa.setRadius(0);
        this.mSc.setVisibility(8);
        this.mRZ.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData, int i) {
        ao.setBackgroundColor(this.rootView, R.color.CAM_X0201);
        ao.setBackgroundColor(this.bUk, R.color.CAM_X0205);
        ao.setViewTextColor(this.lTo, R.color.CAM_X0105);
        ao.setViewTextColor(this.mSb, R.color.CAM_X0107);
        ao.setViewTextColor(this.mRX, R.color.CAM_X0105);
        ao.setViewTextColor(this.mRY, R.color.CAM_X0107);
        ao.setViewTextColor(this.mRZ, R.color.CAM_X0302);
        ao.setBackgroundResource(this.mRZ, R.drawable.feed_ad_progress_button_bg);
        this.mSc.setTextColor(ao.getColor(R.color.CAM_X0901));
        this.mSc.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View ddH() {
        MessageManager.getInstance().registerListener(this.mPj);
        this.mPj.setTag(this.eXu.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.post_ad_pb_banner_card, (ViewGroup) null);
        this.mSa = (TbImageView) this.rootView.findViewById(R.id.image);
        this.mRZ = (TextView) this.rootView.findViewById(R.id.action_button);
        this.lTo = (TextView) this.rootView.findViewById(R.id.recommend_title);
        this.mRX = (TextView) this.rootView.findViewById(R.id.ad_title);
        this.mRY = (TextView) this.rootView.findViewById(R.id.ad_description);
        this.mSb = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.bUk = this.rootView.findViewById(R.id.divider);
        this.mSc = (ApkDownloadView) this.rootView.findViewById(R.id.ad_download);
        this.mSc.x(this.eXu.getUniqueId());
        this.rootView.setOnClickListener(this.iwf);
        this.mRZ.setOnClickListener(this.iwf);
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
            } else if (advertAppInfo.bpf()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.eXu.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eXu.getPageActivity());
                aVar.Bp(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdPostPbView.this.a(advertAppInfo, i, AdPostPbView.this.mSc);
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.eXu).btX();
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
        private AdvertAppInfo mSg;

        public a(AdvertAppInfo advertAppInfo) {
            this.mSg = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdPostPbView.this.eXu.showToast(R.string.neterror);
                return;
            }
            boolean z = view == AdPostPbView.this.mSc;
            if (this.mSg != null) {
                int i = b.toInt(this.mSg.adPosition, -1);
                int status = ApkDownloadView.getStatus(AdPostPbView.this.d(this.mSg, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    AdPostPbView.this.a(this.mSg, i, AdPostPbView.this.mSc, z);
                    if (AdPostPbView.this.kYN != null) {
                        AdPostPbView.this.kYN.d(3, null);
                        return;
                    }
                    return;
                }
                AdPostPbView.this.showDownloadAppDialog(this.mSg, i, true, this.mSg.eOc != null ? this.mSg.eOc.eOp : "");
            }
        }
    }
}
