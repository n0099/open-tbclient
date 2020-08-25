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
/* loaded from: classes20.dex */
public class AdPostPbView extends PostAdBaseView<AdPostPbData> {
    private View efZ;
    protected View.OnClickListener hjQ;
    private TextView kJA;
    protected CustomMessageListener lEA;
    private ApkDownloadView lFl;
    private TextView lHc;
    private TextView lHd;
    private TextView lHe;
    private TbImageView lHf;
    private TextView lHg;
    private String lHh;
    private AdPostPbData lHi;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private View rootView;

    public AdPostPbView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hjQ = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostPbView.this.lHi != null) {
                    int c = s.c(AdPostPbView.this.efn, AdPostPbView.this.lHi.scheme, AdPostPbView.this.lHi.id);
                    if (AdPostPbView.this.jPk != null) {
                        AdPostPbView.this.jPk.d(c, null);
                    }
                }
            }
        };
        this.lEA = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdPostPbView.this.lHh) && AdPostPbView.this.lHh.equals(downloadData.getId())) {
                    AdPostPbView.this.lFl.t(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData) {
        this.lHi = adPostPbData;
        this.lHf.startLoad(adPostPbData.portrait, 17, false);
        this.kJA.setText(adPostPbData.recommend);
        this.lHc.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.lHd.setVisibility(8);
        } else {
            this.lHd.setVisibility(0);
            this.lHd.setText(adPostPbData.desc);
        }
        this.lHe.setText(adPostPbData.buttonText);
        this.lHg.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.lHf.setRadius(l.getDimens(getContext(), R.dimen.ds32));
            this.lHe.setVisibility(8);
            this.lFl.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.lFl.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.lHh = advertAppInfo.dWi;
                DownloadData b = b(advertAppInfo, this.position);
                b.setStatus(ApkDownloadView.getStatus(b));
                this.lFl.setData(b);
                return;
            }
            return;
        }
        this.lHf.setRadius(0);
        this.lFl.setVisibility(8);
        this.lHe.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData, int i) {
        ap.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.efZ, R.color.cp_bg_line_e);
        ap.setViewTextColor(this.kJA, R.color.cp_cont_b);
        ap.setViewTextColor(this.lHg, R.color.cp_cont_j);
        ap.setViewTextColor(this.lHc, R.color.cp_cont_b);
        ap.setViewTextColor(this.lHd, R.color.cp_cont_j);
        ap.setViewTextColor(this.lHe, R.color.cp_link_tip_a);
        ap.setBackgroundResource(this.lHe, R.drawable.feed_ad_progress_button_bg);
        this.lFl.setTextColor(ap.getColor(R.color.cp_btn_a));
        this.lFl.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View cMp() {
        MessageManager.getInstance().registerListener(this.lEA);
        this.lEA.setTag(this.efn.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.post_ad_pb_banner_card, (ViewGroup) null);
        this.lHf = (TbImageView) this.rootView.findViewById(R.id.image);
        this.lHe = (TextView) this.rootView.findViewById(R.id.action_button);
        this.kJA = (TextView) this.rootView.findViewById(R.id.recommend_title);
        this.lHc = (TextView) this.rootView.findViewById(R.id.ad_title);
        this.lHd = (TextView) this.rootView.findViewById(R.id.ad_description);
        this.lHg = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.efZ = this.rootView.findViewById(R.id.divider);
        this.lFl = (ApkDownloadView) this.rootView.findViewById(R.id.ad_download);
        this.lFl.y(this.efn.getUniqueId());
        this.rootView.setOnClickListener(this.hjQ);
        this.lHe.setOnClickListener(this.hjQ);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData b(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.dWi);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.dWg);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.toInt(advertAppInfo.dWf, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.efn.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.efn.getPageActivity()) && this.jPl != null) {
                this.jPl.c(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.q(b(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.efn.getPageActivity(), R.string.neterror);
            } else if (advertAppInfo.bcw()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.efn.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.efn.getPageActivity());
                aVar.zz(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdPostPbView.this.a(advertAppInfo, i, AdPostPbView.this.lFl);
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.efn).bhg();
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
                    s.aQ(this.efn.getPageActivity(), advertAppInfo.dWi);
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
        private AdvertAppInfo lHk;

        public a(AdvertAppInfo advertAppInfo) {
            this.lHk = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdPostPbView.this.efn.showToast(R.string.neterror);
                return;
            }
            boolean z = view == AdPostPbView.this.lFl;
            if (this.lHk != null) {
                int i = b.toInt(this.lHk.adPosition, -1);
                int status = ApkDownloadView.getStatus(AdPostPbView.this.b(this.lHk, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    AdPostPbView.this.a(this.lHk, i, AdPostPbView.this.lFl, z);
                    if (AdPostPbView.this.jPk != null) {
                        AdPostPbView.this.jPk.d(3, null);
                        return;
                    }
                    return;
                }
                AdPostPbView.this.showDownloadAppDialog(this.lHk, i, true, this.lHk.dWo != null ? this.lHk.dWo.dWA : "");
            }
        }
    }
}
