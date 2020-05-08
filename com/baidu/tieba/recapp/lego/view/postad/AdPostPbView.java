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
    private View dvw;
    protected View.OnClickListener gpC;
    private TextView jyJ;
    protected CustomMessageListener ktP;
    private ApkDownloadView kuA;
    private TextView kwr;
    private TextView kws;
    private TextView kwt;
    private TbImageView kwu;
    private TextView kwv;
    private String kww;
    private AdPostPbData kwx;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private View rootView;

    public AdPostPbView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gpC = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostPbView.this.kwx != null) {
                    int b = r.b(AdPostPbView.this.duK, AdPostPbView.this.kwx.scheme, AdPostPbView.this.kwx.id);
                    if (AdPostPbView.this.iKo != null) {
                        AdPostPbView.this.iKo.d(b, null);
                    }
                }
            }
        };
        this.ktP = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdPostPbView.this.kww) && AdPostPbView.this.kww.equals(downloadData.getId())) {
                    AdPostPbView.this.kuA.t(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData) {
        this.kwx = adPostPbData;
        this.kwu.startLoad(adPostPbData.portrait, 17, false);
        this.jyJ.setText(adPostPbData.recommend);
        this.kwr.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.kws.setVisibility(8);
        } else {
            this.kws.setVisibility(0);
            this.kws.setText(adPostPbData.desc);
        }
        this.kwt.setText(adPostPbData.buttonText);
        this.kwv.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.kwu.setRadius(l.getDimens(getContext(), R.dimen.ds32));
            this.kwt.setVisibility(8);
            this.kuA.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.kuA.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.kww = advertAppInfo.dmv;
                DownloadData c = c(advertAppInfo, this.position);
                c.setStatus(ApkDownloadView.getStatus(c));
                this.kuA.setData(c);
                return;
            }
            return;
        }
        this.kwu.setRadius(0);
        this.kuA.setVisibility(8);
        this.kwt.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData, int i) {
        am.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.dvw, R.color.cp_bg_line_e);
        am.setViewTextColor(this.jyJ, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.kwv, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.kwr, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.kws, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.kwt, (int) R.color.cp_link_tip_a);
        am.setBackgroundResource(this.kwt, R.drawable.feed_ad_progress_button_bg);
        this.kuA.setTextColor(am.getColor(R.color.cp_btn_a));
        this.kuA.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View cmX() {
        MessageManager.getInstance().registerListener(this.ktP);
        this.ktP.setTag(this.duK.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.post_ad_pb_banner_card, (ViewGroup) null);
        this.kwu = (TbImageView) this.rootView.findViewById(R.id.image);
        this.kwt = (TextView) this.rootView.findViewById(R.id.action_button);
        this.jyJ = (TextView) this.rootView.findViewById(R.id.recommend_title);
        this.kwr = (TextView) this.rootView.findViewById(R.id.ad_title);
        this.kws = (TextView) this.rootView.findViewById(R.id.ad_description);
        this.kwv = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.dvw = this.rootView.findViewById(R.id.divider);
        this.kuA = (ApkDownloadView) this.rootView.findViewById(R.id.ad_download);
        this.kuA.u(this.duK.getUniqueId());
        this.rootView.setOnClickListener(this.gpC);
        this.kwt.setOnClickListener(this.gpC);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.dmv);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.dmt);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.toInt(advertAppInfo.dms, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.duK.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.duK.getPageActivity()) && this.iKp != null) {
                this.iKp.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.q(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.duK.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.aIE()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.duK.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.duK.getPageActivity());
                aVar.ui(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdPostPbView.this.a(advertAppInfo, i, AdPostPbView.this.kuA);
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.duK).aMS();
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
                    r.aM(this.duK.getPageActivity(), advertAppInfo.dmv);
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
        private AdvertAppInfo kwz;

        public a(AdvertAppInfo advertAppInfo) {
            this.kwz = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdPostPbView.this.duK.showToast(R.string.neterror);
                return;
            }
            boolean z = view == AdPostPbView.this.kuA;
            if (this.kwz != null) {
                int i = b.toInt(this.kwz.adPosition, -1);
                int status = ApkDownloadView.getStatus(AdPostPbView.this.c(this.kwz, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    AdPostPbView.this.a(this.kwz, i, AdPostPbView.this.kuA, z);
                    if (AdPostPbView.this.iKo != null) {
                        AdPostPbView.this.iKo.d(3, null);
                        return;
                    }
                    return;
                }
                AdPostPbView.this.showDownloadAppDialog(this.kwz, i, true, this.kwz.dmB != null ? this.kwz.dmB.dmN : "");
            }
        }
    }
}
