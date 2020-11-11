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
    private View eIO;
    protected View.OnClickListener hYl;
    private TextView lzU;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    protected CustomMessageListener mvs;
    private ApkDownloadView mwf;
    private TextView mxW;
    private TextView mxX;
    private TextView mxY;
    private TbImageView mxZ;
    private TextView mya;
    private String myb;
    private AdPostPbData myc;
    private View rootView;

    public AdPostPbView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hYl = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostPbView.this.myc != null) {
                    int c = s.c(AdPostPbView.this.eIc, AdPostPbView.this.myc.scheme, AdPostPbView.this.myc.id);
                    if (AdPostPbView.this.kFA != null) {
                        AdPostPbView.this.kFA.d(c, null);
                    }
                }
            }
        };
        this.mvs = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdPostPbView.this.myb) && AdPostPbView.this.myb.equals(downloadData.getId())) {
                    AdPostPbView.this.mwf.t(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData) {
        this.myc = adPostPbData;
        this.mxZ.startLoad(adPostPbData.portrait, 17, false);
        this.lzU.setText(adPostPbData.recommend);
        this.mxW.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.mxX.setVisibility(8);
        } else {
            this.mxX.setVisibility(0);
            this.mxX.setText(adPostPbData.desc);
        }
        this.mxY.setText(adPostPbData.buttonText);
        this.mya.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.mxZ.setRadius(l.getDimens(getContext(), R.dimen.ds32));
            this.mxY.setVisibility(8);
            this.mwf.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.mwf.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.myb = advertAppInfo.eyR;
                DownloadData b = b(advertAppInfo, this.position);
                b.setStatus(ApkDownloadView.getStatus(b));
                this.mwf.setData(b);
                return;
            }
            return;
        }
        this.mxZ.setRadius(0);
        this.mwf.setVisibility(8);
        this.mxY.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData, int i) {
        ap.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.eIO, R.color.cp_bg_line_e);
        ap.setViewTextColor(this.lzU, R.color.cp_cont_b);
        ap.setViewTextColor(this.mya, R.color.cp_cont_j);
        ap.setViewTextColor(this.mxW, R.color.cp_cont_b);
        ap.setViewTextColor(this.mxX, R.color.cp_cont_j);
        ap.setViewTextColor(this.mxY, R.color.cp_link_tip_a);
        ap.setBackgroundResource(this.mxY, R.drawable.feed_ad_progress_button_bg);
        this.mwf.setTextColor(ap.getColor(R.color.cp_btn_a));
        this.mwf.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View cZo() {
        MessageManager.getInstance().registerListener(this.mvs);
        this.mvs.setTag(this.eIc.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.post_ad_pb_banner_card, (ViewGroup) null);
        this.mxZ = (TbImageView) this.rootView.findViewById(R.id.image);
        this.mxY = (TextView) this.rootView.findViewById(R.id.action_button);
        this.lzU = (TextView) this.rootView.findViewById(R.id.recommend_title);
        this.mxW = (TextView) this.rootView.findViewById(R.id.ad_title);
        this.mxX = (TextView) this.rootView.findViewById(R.id.ad_description);
        this.mya = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.eIO = this.rootView.findViewById(R.id.divider);
        this.mwf = (ApkDownloadView) this.rootView.findViewById(R.id.ad_download);
        this.mwf.x(this.eIc.getUniqueId());
        this.rootView.setOnClickListener(this.hYl);
        this.mxY.setOnClickListener(this.hYl);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData b(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.eyR);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.eyP);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.toInt(advertAppInfo.eyO, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.eIc.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.eIc.getPageActivity()) && this.kFB != null) {
                this.kFB.c(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.q(b(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.eIc.getPageActivity(), R.string.neterror);
            } else if (advertAppInfo.bks()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.eIc.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eIc.getPageActivity());
                aVar.Bo(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdPostPbView.this.a(advertAppInfo, i, AdPostPbView.this.mwf);
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.eIc).bpc();
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
                    s.aX(this.eIc.getPageActivity(), advertAppInfo.eyR);
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
        private AdvertAppInfo mye;

        public a(AdvertAppInfo advertAppInfo) {
            this.mye = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdPostPbView.this.eIc.showToast(R.string.neterror);
                return;
            }
            boolean z = view == AdPostPbView.this.mwf;
            if (this.mye != null) {
                int i = b.toInt(this.mye.adPosition, -1);
                int status = ApkDownloadView.getStatus(AdPostPbView.this.b(this.mye, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    AdPostPbView.this.a(this.mye, i, AdPostPbView.this.mwf, z);
                    if (AdPostPbView.this.kFA != null) {
                        AdPostPbView.this.kFA.d(3, null);
                        return;
                    }
                    return;
                }
                AdPostPbView.this.showDownloadAppDialog(this.mye, i, true, this.mye.eyX != null ? this.mye.eyX.ezj : "");
            }
        }
    }
}
