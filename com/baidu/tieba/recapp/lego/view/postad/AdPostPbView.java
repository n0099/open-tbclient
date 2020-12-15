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
/* loaded from: classes26.dex */
public class AdPostPbView extends PostAdBaseView<AdPostPbData> {
    private View eOv;
    protected View.OnClickListener ijK;
    private TextView lOb;
    protected CustomMessageListener mKc;
    private TextView mMO;
    private TextView mMP;
    private TextView mMQ;
    private TbImageView mMR;
    private TextView mMS;
    private ApkDownloadView mMT;
    private String mMU;
    private AdPostPbData mMV;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private View rootView;

    public AdPostPbView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ijK = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostPbView.this.mMV != null) {
                    int c = s.c(AdPostPbView.this.eNx, AdPostPbView.this.mMV.scheme, AdPostPbView.this.mMV.id);
                    if (AdPostPbView.this.kTj != null) {
                        AdPostPbView.this.kTj.d(c, null);
                    }
                }
            }
        };
        this.mKc = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdPostPbView.this.mMU) && AdPostPbView.this.mMU.equals(downloadData.getId())) {
                    AdPostPbView.this.mMT.t(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData) {
        this.mMV = adPostPbData;
        this.mMR.startLoad(adPostPbData.portrait, 17, false);
        this.lOb.setText(adPostPbData.recommend);
        this.mMO.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.mMP.setVisibility(8);
        } else {
            this.mMP.setVisibility(0);
            this.mMP.setText(adPostPbData.desc);
        }
        this.mMQ.setText(adPostPbData.buttonText);
        this.mMS.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.mMR.setRadius(l.getDimens(getContext(), R.dimen.ds32));
            this.mMQ.setVisibility(8);
            this.mMT.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.mMT.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.mMU = advertAppInfo.eEg;
                DownloadData d = d(advertAppInfo, this.position);
                d.setStatus(ApkDownloadView.getStatus(d));
                this.mMT.setData(d);
                return;
            }
            return;
        }
        this.mMR.setRadius(0);
        this.mMT.setVisibility(8);
        this.mMQ.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData, int i) {
        ap.setBackgroundColor(this.rootView, R.color.CAM_X0201);
        ap.setBackgroundColor(this.eOv, R.color.CAM_X0205);
        ap.setViewTextColor(this.lOb, R.color.CAM_X0105);
        ap.setViewTextColor(this.mMS, R.color.CAM_X0107);
        ap.setViewTextColor(this.mMO, R.color.CAM_X0105);
        ap.setViewTextColor(this.mMP, R.color.CAM_X0107);
        ap.setViewTextColor(this.mMQ, R.color.CAM_X0302);
        ap.setBackgroundResource(this.mMQ, R.drawable.feed_ad_progress_button_bg);
        this.mMT.setTextColor(ap.getColor(R.color.CAM_X0901));
        this.mMT.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View ddW() {
        MessageManager.getInstance().registerListener(this.mKc);
        this.mKc.setTag(this.eNx.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.post_ad_pb_banner_card, (ViewGroup) null);
        this.mMR = (TbImageView) this.rootView.findViewById(R.id.image);
        this.mMQ = (TextView) this.rootView.findViewById(R.id.action_button);
        this.lOb = (TextView) this.rootView.findViewById(R.id.recommend_title);
        this.mMO = (TextView) this.rootView.findViewById(R.id.ad_title);
        this.mMP = (TextView) this.rootView.findViewById(R.id.ad_description);
        this.mMS = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.eOv = this.rootView.findViewById(R.id.divider);
        this.mMT = (ApkDownloadView) this.rootView.findViewById(R.id.ad_download);
        this.mMT.x(this.eNx.getUniqueId());
        this.rootView.setOnClickListener(this.ijK);
        this.mMQ.setOnClickListener(this.ijK);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData d(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.eEg != null ? advertAppInfo.eEg : advertAppInfo.eEd);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.eEe);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.toInt(advertAppInfo.eEd, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.eNx.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.eNx.getPageActivity()) && this.kTk != null) {
                this.kTk.c(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.q(d(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.eNx.getPageActivity(), R.string.neterror);
            } else if (advertAppInfo.bmE()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.eNx.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eNx.getPageActivity());
                aVar.Bq(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdPostPbView.this.a(advertAppInfo, i, AdPostPbView.this.mMT);
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.eNx).brv();
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
                    s.aY(this.eNx.getPageActivity(), advertAppInfo.eEg);
                    return;
                case 6:
                case 7:
                    a(advertAppInfo, i, apkDownloadView);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public class a implements View.OnClickListener {
        private AdvertAppInfo mMX;

        public a(AdvertAppInfo advertAppInfo) {
            this.mMX = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdPostPbView.this.eNx.showToast(R.string.neterror);
                return;
            }
            boolean z = view == AdPostPbView.this.mMT;
            if (this.mMX != null) {
                int i = b.toInt(this.mMX.adPosition, -1);
                int status = ApkDownloadView.getStatus(AdPostPbView.this.d(this.mMX, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    AdPostPbView.this.a(this.mMX, i, AdPostPbView.this.mMT, z);
                    if (AdPostPbView.this.kTj != null) {
                        AdPostPbView.this.kTj.d(3, null);
                        return;
                    }
                    return;
                }
                AdPostPbView.this.showDownloadAppDialog(this.mMX, i, true, this.mMX.eEm != null ? this.mMX.eEm.eEz : "");
            }
        }
    }
}
