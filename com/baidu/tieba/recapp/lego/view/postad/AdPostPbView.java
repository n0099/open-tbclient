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
    private TextView ktV;
    private ApkDownloadView loQ;
    protected CustomMessageListener lob;
    private TextView lqH;
    private TextView lqI;
    private TextView lqJ;
    private TbImageView lqK;
    private TextView lqL;
    private String lqM;
    private AdPostPbData lqN;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private View rootView;

    public AdPostPbView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gWX = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostPbView.this.lqN != null) {
                    int c = s.c(AdPostPbView.this.dVN, AdPostPbView.this.lqN.scheme, AdPostPbView.this.lqN.id);
                    if (AdPostPbView.this.jzQ != null) {
                        AdPostPbView.this.jzQ.d(c, null);
                    }
                }
            }
        };
        this.lob = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdPostPbView.this.lqM) && AdPostPbView.this.lqM.equals(downloadData.getId())) {
                    AdPostPbView.this.loQ.t(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData) {
        this.lqN = adPostPbData;
        this.lqK.startLoad(adPostPbData.portrait, 17, false);
        this.ktV.setText(adPostPbData.recommend);
        this.lqH.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.lqI.setVisibility(8);
        } else {
            this.lqI.setVisibility(0);
            this.lqI.setText(adPostPbData.desc);
        }
        this.lqJ.setText(adPostPbData.buttonText);
        this.lqL.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.lqK.setRadius(l.getDimens(getContext(), R.dimen.ds32));
            this.lqJ.setVisibility(8);
            this.loQ.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.loQ.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.lqM = advertAppInfo.dMZ;
                DownloadData c = c(advertAppInfo, this.position);
                c.setStatus(ApkDownloadView.getStatus(c));
                this.loQ.setData(c);
                return;
            }
            return;
        }
        this.lqK.setRadius(0);
        this.loQ.setVisibility(8);
        this.lqJ.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData, int i) {
        ao.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        ao.setBackgroundColor(this.dWz, R.color.cp_bg_line_e);
        ao.setViewTextColor(this.ktV, R.color.cp_cont_b);
        ao.setViewTextColor(this.lqL, R.color.cp_cont_j);
        ao.setViewTextColor(this.lqH, R.color.cp_cont_b);
        ao.setViewTextColor(this.lqI, R.color.cp_cont_j);
        ao.setViewTextColor(this.lqJ, R.color.cp_link_tip_a);
        ao.setBackgroundResource(this.lqJ, R.drawable.feed_ad_progress_button_bg);
        this.loQ.setTextColor(ao.getColor(R.color.cp_btn_a));
        this.loQ.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View cBx() {
        MessageManager.getInstance().registerListener(this.lob);
        this.lob.setTag(this.dVN.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.post_ad_pb_banner_card, (ViewGroup) null);
        this.lqK = (TbImageView) this.rootView.findViewById(R.id.image);
        this.lqJ = (TextView) this.rootView.findViewById(R.id.action_button);
        this.ktV = (TextView) this.rootView.findViewById(R.id.recommend_title);
        this.lqH = (TextView) this.rootView.findViewById(R.id.ad_title);
        this.lqI = (TextView) this.rootView.findViewById(R.id.ad_description);
        this.lqL = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.dWz = this.rootView.findViewById(R.id.divider);
        this.loQ = (ApkDownloadView) this.rootView.findViewById(R.id.ad_download);
        this.loQ.y(this.dVN.getUniqueId());
        this.rootView.setOnClickListener(this.gWX);
        this.lqJ.setOnClickListener(this.gWX);
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
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.dVN.getPageActivity()) && this.jzR != null) {
                this.jzR.b(advertAppInfo, i);
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
                        AdPostPbView.this.a(advertAppInfo, i, AdPostPbView.this.loQ);
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
        private AdvertAppInfo lqP;

        public a(AdvertAppInfo advertAppInfo) {
            this.lqP = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdPostPbView.this.dVN.showToast(R.string.neterror);
                return;
            }
            boolean z = view == AdPostPbView.this.loQ;
            if (this.lqP != null) {
                int i = b.toInt(this.lqP.adPosition, -1);
                int status = ApkDownloadView.getStatus(AdPostPbView.this.c(this.lqP, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    AdPostPbView.this.a(this.lqP, i, AdPostPbView.this.loQ, z);
                    if (AdPostPbView.this.jzQ != null) {
                        AdPostPbView.this.jzQ.d(3, null);
                        return;
                    }
                    return;
                }
                AdPostPbView.this.showDownloadAppDialog(this.lqP, i, true, this.lqP.dNf != null ? this.lqP.dNf.dNr : "");
            }
        }
    }
}
