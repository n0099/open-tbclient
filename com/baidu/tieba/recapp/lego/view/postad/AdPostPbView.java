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
    private View dvs;
    protected View.OnClickListener gpw;
    private TextView jyF;
    protected CustomMessageListener ktL;
    private ApkDownloadView kuw;
    private TextView kwn;
    private TextView kwo;
    private TextView kwp;
    private TbImageView kwq;
    private TextView kwr;
    private String kws;
    private AdPostPbData kwt;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private View rootView;

    public AdPostPbView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gpw = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostPbView.this.kwt != null) {
                    int b = r.b(AdPostPbView.this.duG, AdPostPbView.this.kwt.scheme, AdPostPbView.this.kwt.id);
                    if (AdPostPbView.this.iKk != null) {
                        AdPostPbView.this.iKk.d(b, null);
                    }
                }
            }
        };
        this.ktL = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdPostPbView.this.kws) && AdPostPbView.this.kws.equals(downloadData.getId())) {
                    AdPostPbView.this.kuw.t(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData) {
        this.kwt = adPostPbData;
        this.kwq.startLoad(adPostPbData.portrait, 17, false);
        this.jyF.setText(adPostPbData.recommend);
        this.kwn.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.kwo.setVisibility(8);
        } else {
            this.kwo.setVisibility(0);
            this.kwo.setText(adPostPbData.desc);
        }
        this.kwp.setText(adPostPbData.buttonText);
        this.kwr.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.kwq.setRadius(l.getDimens(getContext(), R.dimen.ds32));
            this.kwp.setVisibility(8);
            this.kuw.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.kuw.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.kws = advertAppInfo.dmr;
                DownloadData c = c(advertAppInfo, this.position);
                c.setStatus(ApkDownloadView.getStatus(c));
                this.kuw.setData(c);
                return;
            }
            return;
        }
        this.kwq.setRadius(0);
        this.kuw.setVisibility(8);
        this.kwp.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData, int i) {
        am.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.dvs, R.color.cp_bg_line_e);
        am.setViewTextColor(this.jyF, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.kwr, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.kwn, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.kwo, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.kwp, (int) R.color.cp_link_tip_a);
        am.setBackgroundResource(this.kwp, R.drawable.feed_ad_progress_button_bg);
        this.kuw.setTextColor(am.getColor(R.color.cp_btn_a));
        this.kuw.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View cna() {
        MessageManager.getInstance().registerListener(this.ktL);
        this.ktL.setTag(this.duG.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.post_ad_pb_banner_card, (ViewGroup) null);
        this.kwq = (TbImageView) this.rootView.findViewById(R.id.image);
        this.kwp = (TextView) this.rootView.findViewById(R.id.action_button);
        this.jyF = (TextView) this.rootView.findViewById(R.id.recommend_title);
        this.kwn = (TextView) this.rootView.findViewById(R.id.ad_title);
        this.kwo = (TextView) this.rootView.findViewById(R.id.ad_description);
        this.kwr = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.dvs = this.rootView.findViewById(R.id.divider);
        this.kuw = (ApkDownloadView) this.rootView.findViewById(R.id.ad_download);
        this.kuw.u(this.duG.getUniqueId());
        this.rootView.setOnClickListener(this.gpw);
        this.kwp.setOnClickListener(this.gpw);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.dmr);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.dmp);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.toInt(advertAppInfo.dmo, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.duG.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.duG.getPageActivity()) && this.iKl != null) {
                this.iKl.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.q(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.duG.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.aIG()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.duG.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.duG.getPageActivity());
                aVar.uf(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdPostPbView.this.a(advertAppInfo, i, AdPostPbView.this.kuw);
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.duG).aMU();
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
                    r.aY(this.duG.getPageActivity(), advertAppInfo.dmr);
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
        private AdvertAppInfo kwv;

        public a(AdvertAppInfo advertAppInfo) {
            this.kwv = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdPostPbView.this.duG.showToast(R.string.neterror);
                return;
            }
            boolean z = view == AdPostPbView.this.kuw;
            if (this.kwv != null) {
                int i = b.toInt(this.kwv.adPosition, -1);
                int status = ApkDownloadView.getStatus(AdPostPbView.this.c(this.kwv, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    AdPostPbView.this.a(this.kwv, i, AdPostPbView.this.kuw, z);
                    if (AdPostPbView.this.iKk != null) {
                        AdPostPbView.this.iKk.d(3, null);
                        return;
                    }
                    return;
                }
                AdPostPbView.this.showDownloadAppDialog(this.kwv, i, true, this.kwv.dmx != null ? this.kwv.dmx.dmJ : "");
            }
        }
    }
}
