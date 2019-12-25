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
/* loaded from: classes10.dex */
public class AdPostPbView extends PostAdBaseView<AdPostPbData> {
    private View cRG;
    protected View.OnClickListener fEl;
    private TextView iHI;
    protected CustomMessageListener jDI;
    private ApkDownloadView jEt;
    private TextView jGE;
    private TextView jGF;
    private TextView jGG;
    private TbImageView jGH;
    private TextView jGI;
    private String jGJ;
    private AdPostPbData jGK;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    private View rootView;

    public AdPostPbView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fEl = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostPbView.this.jGK != null) {
                    int a2 = s.a(AdPostPbView.this.cQU, AdPostPbView.this.jGK.scheme, AdPostPbView.this.jGK.id);
                    if (AdPostPbView.this.hTa != null) {
                        AdPostPbView.this.hTa.b(a2, null);
                    }
                }
            }
        };
        this.jDI = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdPostPbView.this.jGJ) && AdPostPbView.this.jGJ.equals(downloadData.getId())) {
                    AdPostPbView.this.jEt.t(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData) {
        this.jGK = adPostPbData;
        this.jGH.startLoad(adPostPbData.portrait, 17, false);
        this.iHI.setText(adPostPbData.recommend);
        this.jGE.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.jGF.setVisibility(8);
        } else {
            this.jGF.setVisibility(0);
            this.jGF.setText(adPostPbData.desc);
        }
        this.jGG.setText(adPostPbData.buttonText);
        this.jGI.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.jGH.setRadius(l.getDimens(getContext(), R.dimen.ds32));
            this.jGG.setVisibility(8);
            this.jEt.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.jEt.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.jGJ = advertAppInfo.cIK;
                DownloadData c = c(advertAppInfo, this.position);
                c.setStatus(ApkDownloadView.getStatus(c));
                this.jEt.setData(c);
                return;
            }
            return;
        }
        this.jGH.setRadius(0);
        this.jEt.setVisibility(8);
        this.jGG.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData, int i) {
        am.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.cRG, R.color.cp_bg_line_e);
        am.setViewTextColor(this.iHI, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.jGI, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.jGE, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.jGF, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.jGG, (int) R.color.cp_link_tip_a);
        am.setBackgroundResource(this.jGG, R.drawable.feed_ad_progress_button_bg);
        this.jEt.setTextColor(am.getColor(R.color.cp_btn_a));
        this.jEt.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View bZt() {
        MessageManager.getInstance().registerListener(this.jDI);
        this.jDI.setTag(this.cQU.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.post_ad_pb_banner_card, (ViewGroup) null);
        this.jGH = (TbImageView) this.rootView.findViewById(R.id.image);
        this.jGG = (TextView) this.rootView.findViewById(R.id.action_button);
        this.iHI = (TextView) this.rootView.findViewById(R.id.recommend_title);
        this.jGE = (TextView) this.rootView.findViewById(R.id.ad_title);
        this.jGF = (TextView) this.rootView.findViewById(R.id.ad_description);
        this.jGI = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.cRG = this.rootView.findViewById(R.id.divider);
        this.jEt = (ApkDownloadView) this.rootView.findViewById(R.id.ad_download);
        this.jEt.u(this.cQU.getUniqueId());
        this.rootView.setOnClickListener(this.fEl);
        this.jGG.setOnClickListener(this.fEl);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.cIK);
        downloadData.setUrl(advertAppInfo.cIJ);
        downloadData.setName(advertAppInfo.cIH);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.toInt(advertAppInfo.cIG, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.cQU.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.cQU.getPageActivity()) && this.hTb != null) {
                this.hTb.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.q(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.cQU.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.axH()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.cQU.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cQU.getPageActivity());
                aVar.sz(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdPostPbView.this.a(advertAppInfo, i, AdPostPbView.this.jEt);
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.cQU).aBW();
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
                    s.bc(this.cQU.getPageActivity(), advertAppInfo.cIK);
                    return;
                case 6:
                case 7:
                    a(advertAppInfo, i, apkDownloadView);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        private AdvertAppInfo jGM;

        public a(AdvertAppInfo advertAppInfo) {
            this.jGM = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdPostPbView.this.cQU.showToast(R.string.neterror);
                return;
            }
            boolean z = view == AdPostPbView.this.jEt;
            if (this.jGM != null) {
                int i = b.toInt(this.jGM.adPosition, -1);
                int status = ApkDownloadView.getStatus(AdPostPbView.this.c(this.jGM, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    AdPostPbView.this.a(this.jGM, i, AdPostPbView.this.jEt, z);
                    if (AdPostPbView.this.hTa != null) {
                        AdPostPbView.this.hTa.b(3, null);
                        return;
                    }
                    return;
                }
                AdPostPbView.this.showDownloadAppDialog(this.jGM, i, true, this.jGM.cIQ != null ? this.jGM.cIQ.cJc : "");
            }
        }
    }
}
