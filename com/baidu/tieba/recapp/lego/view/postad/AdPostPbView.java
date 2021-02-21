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
/* loaded from: classes8.dex */
public class AdPostPbView extends PostAdBaseView<AdPostPbData> {
    private View bTo;
    protected View.OnClickListener ixq;
    private TextView lXU;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    protected CustomMessageListener mUs;
    private TextView mXf;
    private TextView mXg;
    private TextView mXh;
    private TbImageView mXi;
    private TextView mXj;
    private ApkDownloadView mXk;
    private String mXl;
    private AdPostPbData mXm;
    private View rootView;

    public AdPostPbView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ixq = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostPbView.this.mXm != null) {
                    int a2 = t.a(AdPostPbView.this.eUY, AdPostPbView.this.mXm.scheme, AdPostPbView.this.mXm.id, AdPostPbView.this.mXm.extInfo);
                    if (AdPostPbView.this.lcA != null) {
                        AdPostPbView.this.lcA.d(a2, null);
                    }
                }
            }
        };
        this.mUs = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdPostPbView.this.mXl) && AdPostPbView.this.mXl.equals(downloadData.getId())) {
                    AdPostPbView.this.mXk.s(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData) {
        this.mXm = adPostPbData;
        this.mXi.startLoad(adPostPbData.portrait, 17, false);
        this.lXU.setText(adPostPbData.recommend);
        this.mXf.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.mXg.setVisibility(8);
        } else {
            this.mXg.setVisibility(0);
            this.mXg.setText(adPostPbData.desc);
        }
        this.mXh.setText(adPostPbData.buttonText);
        this.mXj.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.mXi.setRadius(l.getDimens(getContext(), R.dimen.ds32));
            this.mXh.setVisibility(8);
            this.mXk.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.mXk.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.mXl = advertAppInfo.eLw;
                DownloadData d = d(advertAppInfo, this.position);
                d.setStatus(ApkDownloadView.getStatus(d));
                this.mXk.setData(d);
                return;
            }
            return;
        }
        this.mXi.setRadius(0);
        this.mXk.setVisibility(8);
        this.mXh.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData, int i) {
        ap.setBackgroundColor(this.rootView, R.color.CAM_X0201);
        ap.setBackgroundColor(this.bTo, R.color.CAM_X0205);
        ap.setViewTextColor(this.lXU, R.color.CAM_X0105);
        ap.setViewTextColor(this.mXj, R.color.CAM_X0107);
        ap.setViewTextColor(this.mXf, R.color.CAM_X0105);
        ap.setViewTextColor(this.mXg, R.color.CAM_X0107);
        ap.setViewTextColor(this.mXh, R.color.CAM_X0302);
        ap.setBackgroundResource(this.mXh, R.drawable.feed_ad_progress_button_bg);
        this.mXk.setTextColor(ap.getColor(R.color.CAM_X0901));
        this.mXk.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View dbV() {
        MessageManager.getInstance().registerListener(this.mUs);
        this.mUs.setTag(this.eUY.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.post_ad_pb_banner_card, (ViewGroup) null);
        this.mXi = (TbImageView) this.rootView.findViewById(R.id.image);
        this.mXh = (TextView) this.rootView.findViewById(R.id.action_button);
        this.lXU = (TextView) this.rootView.findViewById(R.id.recommend_title);
        this.mXf = (TextView) this.rootView.findViewById(R.id.ad_title);
        this.mXg = (TextView) this.rootView.findViewById(R.id.ad_description);
        this.mXj = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.bTo = this.rootView.findViewById(R.id.divider);
        this.mXk = (ApkDownloadView) this.rootView.findViewById(R.id.ad_download);
        this.mXk.y(this.eUY.getUniqueId());
        this.rootView.setOnClickListener(this.ixq);
        this.mXh.setOnClickListener(this.ixq);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData d(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.eLw != null ? advertAppInfo.eLw : advertAppInfo.eLt);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.eLu);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.toInt(advertAppInfo.eLt, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.eUY.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.eUY.getPageActivity()) && this.lcB != null) {
                this.lcB.c(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.p(d(advertAppInfo, i));
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
                        AdPostPbView.this.a(advertAppInfo, i, AdPostPbView.this.mXk);
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
                        apkDownloadView.q(d);
                        return;
                    }
                    return;
                case 2:
                case 4:
                default:
                    return;
                case 3:
                    t.installApp(this.eUY.getPageActivity(), advertAppInfo.eLw);
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
        private AdvertAppInfo mXo;

        public a(AdvertAppInfo advertAppInfo) {
            this.mXo = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdPostPbView.this.eUY.showToast(R.string.neterror);
                return;
            }
            boolean z = view == AdPostPbView.this.mXk;
            if (this.mXo != null) {
                int i = b.toInt(this.mXo.adPosition, -1);
                int status = ApkDownloadView.getStatus(AdPostPbView.this.d(this.mXo, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    AdPostPbView.this.a(this.mXo, i, AdPostPbView.this.mXk, z);
                    if (AdPostPbView.this.lcA != null) {
                        AdPostPbView.this.lcA.d(3, null);
                        return;
                    }
                    return;
                }
                AdPostPbView.this.showDownloadAppDialog(this.mXo, i, true, this.mXo.eLC != null ? this.mXo.eLC.eLQ : "");
            }
        }
    }
}
