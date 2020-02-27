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
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.download.h;
import com.baidu.tieba.recapp.lego.model.AdPostPbData;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
/* loaded from: classes13.dex */
public class AdPostPbView extends PostAdBaseView<AdPostPbData> {
    private View cVS;
    protected View.OnClickListener fJS;
    private TextView iMH;
    private ApkDownloadView jIW;
    protected CustomMessageListener jIl;
    private TextView jLh;
    private TextView jLi;
    private TextView jLj;
    private TbImageView jLk;
    private TextView jLl;
    private String jLm;
    private AdPostPbData jLn;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    private View rootView;

    public AdPostPbView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fJS = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostPbView.this.jLn != null) {
                    int b = s.b(AdPostPbView.this.cVg, AdPostPbView.this.jLn.scheme, AdPostPbView.this.jLn.id);
                    if (AdPostPbView.this.hYC != null) {
                        AdPostPbView.this.hYC.b(b, null);
                    }
                }
            }
        };
        this.jIl = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdPostPbView.this.jLm) && AdPostPbView.this.jLm.equals(downloadData.getId())) {
                    AdPostPbView.this.jIW.t(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData) {
        this.jLn = adPostPbData;
        this.jLk.startLoad(adPostPbData.portrait, 17, false);
        this.iMH.setText(adPostPbData.recommend);
        this.jLh.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.jLi.setVisibility(8);
        } else {
            this.jLi.setVisibility(0);
            this.jLi.setText(adPostPbData.desc);
        }
        this.jLj.setText(adPostPbData.buttonText);
        this.jLl.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.jLk.setRadius(l.getDimens(getContext(), R.dimen.ds32));
            this.jLj.setVisibility(8);
            this.jIW.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.jIW.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.jLm = advertAppInfo.cMY;
                DownloadData c = c(advertAppInfo, this.position);
                c.setStatus(ApkDownloadView.getStatus(c));
                this.jIW.setData(c);
                return;
            }
            return;
        }
        this.jLk.setRadius(0);
        this.jIW.setVisibility(8);
        this.jLj.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData, int i) {
        am.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.cVS, R.color.cp_bg_line_e);
        am.setViewTextColor(this.iMH, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.jLl, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.jLh, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.jLi, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.jLj, (int) R.color.cp_link_tip_a);
        am.setBackgroundResource(this.jLj, R.drawable.feed_ad_progress_button_bg);
        this.jIW.setTextColor(am.getColor(R.color.cp_btn_a));
        this.jIW.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View ccd() {
        MessageManager.getInstance().registerListener(this.jIl);
        this.jIl.setTag(this.cVg.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.post_ad_pb_banner_card, (ViewGroup) null);
        this.jLk = (TbImageView) this.rootView.findViewById(R.id.image);
        this.jLj = (TextView) this.rootView.findViewById(R.id.action_button);
        this.iMH = (TextView) this.rootView.findViewById(R.id.recommend_title);
        this.jLh = (TextView) this.rootView.findViewById(R.id.ad_title);
        this.jLi = (TextView) this.rootView.findViewById(R.id.ad_description);
        this.jLl = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.cVS = this.rootView.findViewById(R.id.divider);
        this.jIW = (ApkDownloadView) this.rootView.findViewById(R.id.ad_download);
        this.jIW.u(this.cVg.getUniqueId());
        this.rootView.setOnClickListener(this.fJS);
        this.jLj.setOnClickListener(this.fJS);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.cMY);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.cMW);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.toInt(advertAppInfo.cMV, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.cVg.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.cVg.getPageActivity()) && this.hYD != null) {
                this.hYD.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.q(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.cVg.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.aAo()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.cVg.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cVg.getPageActivity());
                aVar.sS(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdPostPbView.this.a(advertAppInfo, i, AdPostPbView.this.jIW);
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.cVg).aEA();
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
                    s.bd(this.cVg.getPageActivity(), advertAppInfo.cMY);
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
        private AdvertAppInfo jLp;

        public a(AdvertAppInfo advertAppInfo) {
            this.jLp = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdPostPbView.this.cVg.showToast(R.string.neterror);
                return;
            }
            boolean z = view == AdPostPbView.this.jIW;
            if (this.jLp != null) {
                int i = b.toInt(this.jLp.adPosition, -1);
                int status = ApkDownloadView.getStatus(AdPostPbView.this.c(this.jLp, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    AdPostPbView.this.a(this.jLp, i, AdPostPbView.this.jIW, z);
                    if (AdPostPbView.this.hYC != null) {
                        AdPostPbView.this.hYC.b(3, null);
                        return;
                    }
                    return;
                }
                AdPostPbView.this.showDownloadAppDialog(this.jLp, i, true, this.jLp.cNe != null ? this.jLp.cNe.cNq : "");
            }
        }
    }
}
