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
    protected View.OnClickListener gEr;
    private TextView jPY;
    protected CustomMessageListener kLI;
    private ApkDownloadView kMt;
    private TextView kOk;
    private TextView kOl;
    private TextView kOm;
    private TbImageView kOn;
    private TextView kOo;
    private String kOp;
    private AdPostPbData kOq;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private View rootView;

    public AdPostPbView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gEr = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostPbView.this.kOq != null) {
                    int b = r.b(AdPostPbView.this.dIF, AdPostPbView.this.kOq.scheme, AdPostPbView.this.kOq.id);
                    if (AdPostPbView.this.iZo != null) {
                        AdPostPbView.this.iZo.d(b, null);
                    }
                }
            }
        };
        this.kLI = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdPostPbView.this.kOp) && AdPostPbView.this.kOp.equals(downloadData.getId())) {
                    AdPostPbView.this.kMt.t(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData) {
        this.kOq = adPostPbData;
        this.kOn.startLoad(adPostPbData.portrait, 17, false);
        this.jPY.setText(adPostPbData.recommend);
        this.kOk.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.kOl.setVisibility(8);
        } else {
            this.kOl.setVisibility(0);
            this.kOl.setText(adPostPbData.desc);
        }
        this.kOm.setText(adPostPbData.buttonText);
        this.kOo.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.kOn.setRadius(l.getDimens(getContext(), R.dimen.ds32));
            this.kOm.setVisibility(8);
            this.kMt.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.kMt.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.kOp = advertAppInfo.dAx;
                DownloadData c = c(advertAppInfo, this.position);
                c.setStatus(ApkDownloadView.getStatus(c));
                this.kMt.setData(c);
                return;
            }
            return;
        }
        this.kOn.setRadius(0);
        this.kMt.setVisibility(8);
        this.kOm.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData, int i) {
        am.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.dJr, R.color.cp_bg_line_e);
        am.setViewTextColor(this.jPY, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.kOo, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.kOk, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.kOl, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.kOm, (int) R.color.cp_link_tip_a);
        am.setBackgroundResource(this.kOm, R.drawable.feed_ad_progress_button_bg);
        this.kMt.setTextColor(am.getColor(R.color.cp_btn_a));
        this.kMt.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View ctA() {
        MessageManager.getInstance().registerListener(this.kLI);
        this.kLI.setTag(this.dIF.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.post_ad_pb_banner_card, (ViewGroup) null);
        this.kOn = (TbImageView) this.rootView.findViewById(R.id.image);
        this.kOm = (TextView) this.rootView.findViewById(R.id.action_button);
        this.jPY = (TextView) this.rootView.findViewById(R.id.recommend_title);
        this.kOk = (TextView) this.rootView.findViewById(R.id.ad_title);
        this.kOl = (TextView) this.rootView.findViewById(R.id.ad_description);
        this.kOo = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.dJr = this.rootView.findViewById(R.id.divider);
        this.kMt = (ApkDownloadView) this.rootView.findViewById(R.id.ad_download);
        this.kMt.x(this.dIF.getUniqueId());
        this.rootView.setOnClickListener(this.gEr);
        this.kOm.setOnClickListener(this.gEr);
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
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.dIF.getPageActivity()) && this.iZp != null) {
                this.iZp.b(advertAppInfo, i);
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
                        AdPostPbView.this.a(advertAppInfo, i, AdPostPbView.this.kMt);
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
        private AdvertAppInfo kOs;

        public a(AdvertAppInfo advertAppInfo) {
            this.kOs = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdPostPbView.this.dIF.showToast(R.string.neterror);
                return;
            }
            boolean z = view == AdPostPbView.this.kMt;
            if (this.kOs != null) {
                int i = b.toInt(this.kOs.adPosition, -1);
                int status = ApkDownloadView.getStatus(AdPostPbView.this.c(this.kOs, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    AdPostPbView.this.a(this.kOs, i, AdPostPbView.this.kMt, z);
                    if (AdPostPbView.this.iZo != null) {
                        AdPostPbView.this.iZo.d(3, null);
                        return;
                    }
                    return;
                }
                AdPostPbView.this.showDownloadAppDialog(this.kOs, i, true, this.kOs.dAD != null ? this.kOs.dAD.dAP : "");
            }
        }
    }
}
