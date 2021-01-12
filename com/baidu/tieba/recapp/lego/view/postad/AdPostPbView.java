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
/* loaded from: classes7.dex */
public class AdPostPbView extends PostAdBaseView<AdPostPbData> {
    private View bPy;
    protected View.OnClickListener iry;
    private TextView lOJ;
    protected CustomMessageListener mKE;
    private TextView mNq;
    private TextView mNr;
    private TextView mNs;
    private TbImageView mNt;
    private TextView mNu;
    private ApkDownloadView mNv;
    private String mNw;
    private AdPostPbData mNx;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private View rootView;

    public AdPostPbView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.iry = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostPbView.this.mNx != null) {
                    int c = s.c(AdPostPbView.this.eSJ, AdPostPbView.this.mNx.scheme, AdPostPbView.this.mNx.id);
                    if (AdPostPbView.this.kUi != null) {
                        AdPostPbView.this.kUi.d(c, null);
                    }
                }
            }
        };
        this.mKE = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdPostPbView.this.mNw) && AdPostPbView.this.mNw.equals(downloadData.getId())) {
                    AdPostPbView.this.mNv.t(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData) {
        this.mNx = adPostPbData;
        this.mNt.startLoad(adPostPbData.portrait, 17, false);
        this.lOJ.setText(adPostPbData.recommend);
        this.mNq.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.mNr.setVisibility(8);
        } else {
            this.mNr.setVisibility(0);
            this.mNr.setText(adPostPbData.desc);
        }
        this.mNs.setText(adPostPbData.buttonText);
        this.mNu.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.mNt.setRadius(l.getDimens(getContext(), R.dimen.ds32));
            this.mNs.setVisibility(8);
            this.mNv.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.mNv.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.mNw = advertAppInfo.eJl;
                DownloadData d = d(advertAppInfo, this.position);
                d.setStatus(ApkDownloadView.getStatus(d));
                this.mNv.setData(d);
                return;
            }
            return;
        }
        this.mNt.setRadius(0);
        this.mNv.setVisibility(8);
        this.mNs.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData, int i) {
        ao.setBackgroundColor(this.rootView, R.color.CAM_X0201);
        ao.setBackgroundColor(this.bPy, R.color.CAM_X0205);
        ao.setViewTextColor(this.lOJ, R.color.CAM_X0105);
        ao.setViewTextColor(this.mNu, R.color.CAM_X0107);
        ao.setViewTextColor(this.mNq, R.color.CAM_X0105);
        ao.setViewTextColor(this.mNr, R.color.CAM_X0107);
        ao.setViewTextColor(this.mNs, R.color.CAM_X0302);
        ao.setBackgroundResource(this.mNs, R.drawable.feed_ad_progress_button_bg);
        this.mNv.setTextColor(ao.getColor(R.color.CAM_X0901));
        this.mNv.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View cZQ() {
        MessageManager.getInstance().registerListener(this.mKE);
        this.mKE.setTag(this.eSJ.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.post_ad_pb_banner_card, (ViewGroup) null);
        this.mNt = (TbImageView) this.rootView.findViewById(R.id.image);
        this.mNs = (TextView) this.rootView.findViewById(R.id.action_button);
        this.lOJ = (TextView) this.rootView.findViewById(R.id.recommend_title);
        this.mNq = (TextView) this.rootView.findViewById(R.id.ad_title);
        this.mNr = (TextView) this.rootView.findViewById(R.id.ad_description);
        this.mNu = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.bPy = this.rootView.findViewById(R.id.divider);
        this.mNv = (ApkDownloadView) this.rootView.findViewById(R.id.ad_download);
        this.mNv.x(this.eSJ.getUniqueId());
        this.rootView.setOnClickListener(this.iry);
        this.mNs.setOnClickListener(this.iry);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData d(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.eJl != null ? advertAppInfo.eJl : advertAppInfo.eJi);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.eJj);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.toInt(advertAppInfo.eJi, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.eSJ.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.eSJ.getPageActivity()) && this.kUj != null) {
                this.kUj.c(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.q(d(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.eSJ.getPageActivity(), R.string.neterror);
            } else if (advertAppInfo.blm()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.eSJ.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eSJ.getPageActivity());
                aVar.Ad(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdPostPbView.this.a(advertAppInfo, i, AdPostPbView.this.mNv);
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.eSJ).bqe();
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
                    s.installApp(this.eSJ.getPageActivity(), advertAppInfo.eJl);
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
        private AdvertAppInfo mNz;

        public a(AdvertAppInfo advertAppInfo) {
            this.mNz = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdPostPbView.this.eSJ.showToast(R.string.neterror);
                return;
            }
            boolean z = view == AdPostPbView.this.mNv;
            if (this.mNz != null) {
                int i = b.toInt(this.mNz.adPosition, -1);
                int status = ApkDownloadView.getStatus(AdPostPbView.this.d(this.mNz, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    AdPostPbView.this.a(this.mNz, i, AdPostPbView.this.mNv, z);
                    if (AdPostPbView.this.kUi != null) {
                        AdPostPbView.this.kUi.d(3, null);
                        return;
                    }
                    return;
                }
                AdPostPbView.this.showDownloadAppDialog(this.mNz, i, true, this.mNz.eJr != null ? this.mNz.eJr.eJE : "");
            }
        }
    }
}
