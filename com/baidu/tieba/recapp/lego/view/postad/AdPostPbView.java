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
    private View cVT;
    protected View.OnClickListener fJU;
    private TextView iMJ;
    private ApkDownloadView jIY;
    protected CustomMessageListener jIn;
    private TextView jLj;
    private TextView jLk;
    private TextView jLl;
    private TbImageView jLm;
    private TextView jLn;
    private String jLo;
    private AdPostPbData jLp;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    private View rootView;

    public AdPostPbView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fJU = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostPbView.this.jLp != null) {
                    int b = s.b(AdPostPbView.this.cVh, AdPostPbView.this.jLp.scheme, AdPostPbView.this.jLp.id);
                    if (AdPostPbView.this.hYE != null) {
                        AdPostPbView.this.hYE.b(b, null);
                    }
                }
            }
        };
        this.jIn = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdPostPbView.this.jLo) && AdPostPbView.this.jLo.equals(downloadData.getId())) {
                    AdPostPbView.this.jIY.t(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData) {
        this.jLp = adPostPbData;
        this.jLm.startLoad(adPostPbData.portrait, 17, false);
        this.iMJ.setText(adPostPbData.recommend);
        this.jLj.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.jLk.setVisibility(8);
        } else {
            this.jLk.setVisibility(0);
            this.jLk.setText(adPostPbData.desc);
        }
        this.jLl.setText(adPostPbData.buttonText);
        this.jLn.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.jLm.setRadius(l.getDimens(getContext(), R.dimen.ds32));
            this.jLl.setVisibility(8);
            this.jIY.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.jIY.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.jLo = advertAppInfo.cMZ;
                DownloadData c = c(advertAppInfo, this.position);
                c.setStatus(ApkDownloadView.getStatus(c));
                this.jIY.setData(c);
                return;
            }
            return;
        }
        this.jLm.setRadius(0);
        this.jIY.setVisibility(8);
        this.jLl.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData, int i) {
        am.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.cVT, R.color.cp_bg_line_e);
        am.setViewTextColor(this.iMJ, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.jLn, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.jLj, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.jLk, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.jLl, (int) R.color.cp_link_tip_a);
        am.setBackgroundResource(this.jLl, R.drawable.feed_ad_progress_button_bg);
        this.jIY.setTextColor(am.getColor(R.color.cp_btn_a));
        this.jIY.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View ccf() {
        MessageManager.getInstance().registerListener(this.jIn);
        this.jIn.setTag(this.cVh.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.post_ad_pb_banner_card, (ViewGroup) null);
        this.jLm = (TbImageView) this.rootView.findViewById(R.id.image);
        this.jLl = (TextView) this.rootView.findViewById(R.id.action_button);
        this.iMJ = (TextView) this.rootView.findViewById(R.id.recommend_title);
        this.jLj = (TextView) this.rootView.findViewById(R.id.ad_title);
        this.jLk = (TextView) this.rootView.findViewById(R.id.ad_description);
        this.jLn = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.cVT = this.rootView.findViewById(R.id.divider);
        this.jIY = (ApkDownloadView) this.rootView.findViewById(R.id.ad_download);
        this.jIY.u(this.cVh.getUniqueId());
        this.rootView.setOnClickListener(this.fJU);
        this.jLl.setOnClickListener(this.fJU);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.cMZ);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.cMX);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.toInt(advertAppInfo.cMW, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.cVh.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.cVh.getPageActivity()) && this.hYF != null) {
                this.hYF.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.q(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.cVh.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.aAq()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.cVh.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cVh.getPageActivity());
                aVar.sS(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdPostPbView.this.a(advertAppInfo, i, AdPostPbView.this.jIY);
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.cVh).aEC();
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
                    s.bd(this.cVh.getPageActivity(), advertAppInfo.cMZ);
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
        private AdvertAppInfo jLr;

        public a(AdvertAppInfo advertAppInfo) {
            this.jLr = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdPostPbView.this.cVh.showToast(R.string.neterror);
                return;
            }
            boolean z = view == AdPostPbView.this.jIY;
            if (this.jLr != null) {
                int i = b.toInt(this.jLr.adPosition, -1);
                int status = ApkDownloadView.getStatus(AdPostPbView.this.c(this.jLr, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    AdPostPbView.this.a(this.jLr, i, AdPostPbView.this.jIY, z);
                    if (AdPostPbView.this.hYE != null) {
                        AdPostPbView.this.hYE.b(3, null);
                        return;
                    }
                    return;
                }
                AdPostPbView.this.showDownloadAppDialog(this.jLr, i, true, this.jLr.cNf != null ? this.jLr.cNf.cNr : "");
            }
        }
    }
}
