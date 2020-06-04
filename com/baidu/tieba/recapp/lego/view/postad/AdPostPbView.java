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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.download.h;
import com.baidu.tieba.recapp.lego.model.AdPostPbData;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
/* loaded from: classes13.dex */
public class AdPostPbView extends PostAdBaseView<AdPostPbData> {
    private View dJr;
    protected View.OnClickListener gEC;
    private TextView jRe;
    protected CustomMessageListener kMR;
    private ApkDownloadView kNC;
    private TextView kPt;
    private TextView kPu;
    private TextView kPv;
    private TbImageView kPw;
    private TextView kPx;
    private String kPy;
    private AdPostPbData kPz;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private View rootView;

    public AdPostPbView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gEC = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostPbView.this.kPz != null) {
                    int b = r.b(AdPostPbView.this.dIF, AdPostPbView.this.kPz.scheme, AdPostPbView.this.kPz.id);
                    if (AdPostPbView.this.jab != null) {
                        AdPostPbView.this.jab.d(b, null);
                    }
                }
            }
        };
        this.kMR = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdPostPbView.this.kPy) && AdPostPbView.this.kPy.equals(downloadData.getId())) {
                    AdPostPbView.this.kNC.t(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData) {
        this.kPz = adPostPbData;
        this.kPw.startLoad(adPostPbData.portrait, 17, false);
        this.jRe.setText(adPostPbData.recommend);
        this.kPt.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.kPu.setVisibility(8);
        } else {
            this.kPu.setVisibility(0);
            this.kPu.setText(adPostPbData.desc);
        }
        this.kPv.setText(adPostPbData.buttonText);
        this.kPx.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.kPw.setRadius(l.getDimens(getContext(), R.dimen.ds32));
            this.kPv.setVisibility(8);
            this.kNC.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.kNC.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.kPy = advertAppInfo.dAx;
                DownloadData c = c(advertAppInfo, this.position);
                c.setStatus(ApkDownloadView.getStatus(c));
                this.kNC.setData(c);
                return;
            }
            return;
        }
        this.kPw.setRadius(0);
        this.kNC.setVisibility(8);
        this.kPv.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData, int i) {
        am.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.dJr, R.color.cp_bg_line_e);
        am.setViewTextColor(this.jRe, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.kPx, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.kPt, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.kPu, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.kPv, (int) R.color.cp_link_tip_a);
        am.setBackgroundResource(this.kPv, R.drawable.feed_ad_progress_button_bg);
        this.kNC.setTextColor(am.getColor(R.color.cp_btn_a));
        this.kNC.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View ctJ() {
        MessageManager.getInstance().registerListener(this.kMR);
        this.kMR.setTag(this.dIF.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.post_ad_pb_banner_card, (ViewGroup) null);
        this.kPw = (TbImageView) this.rootView.findViewById(R.id.image);
        this.kPv = (TextView) this.rootView.findViewById(R.id.action_button);
        this.jRe = (TextView) this.rootView.findViewById(R.id.recommend_title);
        this.kPt = (TextView) this.rootView.findViewById(R.id.ad_title);
        this.kPu = (TextView) this.rootView.findViewById(R.id.ad_description);
        this.kPx = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.dJr = this.rootView.findViewById(R.id.divider);
        this.kNC = (ApkDownloadView) this.rootView.findViewById(R.id.ad_download);
        this.kNC.x(this.dIF.getUniqueId());
        this.rootView.setOnClickListener(this.gEC);
        this.kPv.setOnClickListener(this.gEC);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.dAx);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.dAv);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.toInt(advertAppInfo.dAu, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.dIF.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.dIF.getPageActivity()) && this.jac != null) {
                this.jac.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.q(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.dIF.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.aOz()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.dIF.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dIF.getPageActivity());
                aVar.vO(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdPostPbView.this.a(advertAppInfo, i, AdPostPbView.this.kNC);
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.dIF).aST();
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
                    r.aN(this.dIF.getPageActivity(), advertAppInfo.dAx);
                    return;
                case 6:
                case 7:
                    a(advertAppInfo, i, apkDownloadView);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class a implements View.OnClickListener {
        private AdvertAppInfo kPB;

        public a(AdvertAppInfo advertAppInfo) {
            this.kPB = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdPostPbView.this.dIF.showToast(R.string.neterror);
                return;
            }
            boolean z = view == AdPostPbView.this.kNC;
            if (this.kPB != null) {
                int i = b.toInt(this.kPB.adPosition, -1);
                int status = ApkDownloadView.getStatus(AdPostPbView.this.c(this.kPB, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    AdPostPbView.this.a(this.kPB, i, AdPostPbView.this.kNC, z);
                    if (AdPostPbView.this.jab != null) {
                        AdPostPbView.this.jab.d(3, null);
                        return;
                    }
                    return;
                }
                AdPostPbView.this.showDownloadAppDialog(this.kPB, i, true, this.kPB.dAD != null ? this.kPB.dAD.dAP : "");
            }
        }
    }
}
