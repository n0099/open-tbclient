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
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
/* loaded from: classes25.dex */
public class AdPostPbView extends PostAdBaseView<AdPostPbData> {
    private View eHl;
    protected View.OnClickListener hYL;
    private TextView lAm;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    protected CustomMessageListener mvO;
    private TextView myA;
    private TextView myB;
    private TextView myC;
    private TbImageView myD;
    private TextView myE;
    private ApkDownloadView myF;
    private String myG;
    private AdPostPbData myH;
    private View rootView;

    public AdPostPbView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hYL = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostPbView.this.myH != null) {
                    int c = r.c(AdPostPbView.this.eGu, AdPostPbView.this.myH.scheme, AdPostPbView.this.myH.id);
                    if (AdPostPbView.this.kFP != null) {
                        AdPostPbView.this.kFP.d(c, null);
                    }
                }
            }
        };
        this.mvO = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdPostPbView.this.myG) && AdPostPbView.this.myG.equals(downloadData.getId())) {
                    AdPostPbView.this.myF.t(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData) {
        this.myH = adPostPbData;
        this.myD.startLoad(adPostPbData.portrait, 17, false);
        this.lAm.setText(adPostPbData.recommend);
        this.myA.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.myB.setVisibility(8);
        } else {
            this.myB.setVisibility(0);
            this.myB.setText(adPostPbData.desc);
        }
        this.myC.setText(adPostPbData.buttonText);
        this.myE.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.myD.setRadius(l.getDimens(getContext(), R.dimen.ds32));
            this.myC.setVisibility(8);
            this.myF.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.myF.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.myG = advertAppInfo.exf;
                DownloadData c = c(advertAppInfo, this.position);
                c.setStatus(ApkDownloadView.getStatus(c));
                this.myF.setData(c);
                return;
            }
            return;
        }
        this.myD.setRadius(0);
        this.myF.setVisibility(8);
        this.myC.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData, int i) {
        ap.setBackgroundColor(this.rootView, R.color.CAM_X0201);
        ap.setBackgroundColor(this.eHl, R.color.CAM_X0205);
        ap.setViewTextColor(this.lAm, R.color.CAM_X0105);
        ap.setViewTextColor(this.myE, R.color.CAM_X0107);
        ap.setViewTextColor(this.myA, R.color.CAM_X0105);
        ap.setViewTextColor(this.myB, R.color.CAM_X0107);
        ap.setViewTextColor(this.myC, R.color.CAM_X0302);
        ap.setBackgroundResource(this.myC, R.drawable.feed_ad_progress_button_bg);
        this.myF.setTextColor(ap.getColor(R.color.CAM_X0901));
        this.myF.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View cYK() {
        MessageManager.getInstance().registerListener(this.mvO);
        this.mvO.setTag(this.eGu.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.post_ad_pb_banner_card, (ViewGroup) null);
        this.myD = (TbImageView) this.rootView.findViewById(R.id.image);
        this.myC = (TextView) this.rootView.findViewById(R.id.action_button);
        this.lAm = (TextView) this.rootView.findViewById(R.id.recommend_title);
        this.myA = (TextView) this.rootView.findViewById(R.id.ad_title);
        this.myB = (TextView) this.rootView.findViewById(R.id.ad_description);
        this.myE = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.eHl = this.rootView.findViewById(R.id.divider);
        this.myF = (ApkDownloadView) this.rootView.findViewById(R.id.ad_download);
        this.myF.x(this.eGu.getUniqueId());
        this.rootView.setOnClickListener(this.hYL);
        this.myC.setOnClickListener(this.hYL);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.exf != null ? advertAppInfo.exf : advertAppInfo.exc);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.exd);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.toInt(advertAppInfo.exc, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.eGu.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.eGu.getPageActivity()) && this.kFQ != null) {
                this.kFQ.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.q(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.eGu.getPageActivity(), R.string.neterror);
            } else if (advertAppInfo.bju()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.eGu.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eGu.getPageActivity());
                aVar.AJ(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdPostPbView.this.a(advertAppInfo, i, AdPostPbView.this.myF);
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.eGu).bog();
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
                        h.d(advertAppInfo);
                        apkDownloadView.r(c);
                        return;
                    }
                    return;
                case 2:
                case 4:
                default:
                    return;
                case 3:
                    r.aU(this.eGu.getPageActivity(), advertAppInfo.exf);
                    return;
                case 6:
                case 7:
                    a(advertAppInfo, i, apkDownloadView);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public class a implements View.OnClickListener {
        private AdvertAppInfo myJ;

        public a(AdvertAppInfo advertAppInfo) {
            this.myJ = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdPostPbView.this.eGu.showToast(R.string.neterror);
                return;
            }
            boolean z = view == AdPostPbView.this.myF;
            if (this.myJ != null) {
                int i = b.toInt(this.myJ.adPosition, -1);
                int status = ApkDownloadView.getStatus(AdPostPbView.this.c(this.myJ, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    AdPostPbView.this.a(this.myJ, i, AdPostPbView.this.myF, z);
                    if (AdPostPbView.this.kFP != null) {
                        AdPostPbView.this.kFP.d(3, null);
                        return;
                    }
                    return;
                }
                AdPostPbView.this.showDownloadAppDialog(this.myJ, i, true, this.myJ.exl != null ? this.myJ.exl.exy : "");
            }
        }
    }
}
