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
/* loaded from: classes11.dex */
public class AdPostPbView extends PostAdBaseView<AdPostPbData> {
    private View cRQ;
    protected View.OnClickListener fHv;
    private TextView iLm;
    protected CustomMessageListener jHp;
    private ApkDownloadView jIa;
    private TextView jKl;
    private TextView jKm;
    private TextView jKn;
    private TbImageView jKo;
    private TextView jKp;
    private String jKq;
    private AdPostPbData jKr;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    private View rootView;

    public AdPostPbView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fHv = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostPbView.this.jKr != null) {
                    int b = s.b(AdPostPbView.this.cRe, AdPostPbView.this.jKr.scheme, AdPostPbView.this.jKr.id);
                    if (AdPostPbView.this.hWE != null) {
                        AdPostPbView.this.hWE.b(b, null);
                    }
                }
            }
        };
        this.jHp = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdPostPbView.this.jKq) && AdPostPbView.this.jKq.equals(downloadData.getId())) {
                    AdPostPbView.this.jIa.t(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData) {
        this.jKr = adPostPbData;
        this.jKo.startLoad(adPostPbData.portrait, 17, false);
        this.iLm.setText(adPostPbData.recommend);
        this.jKl.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.jKm.setVisibility(8);
        } else {
            this.jKm.setVisibility(0);
            this.jKm.setText(adPostPbData.desc);
        }
        this.jKn.setText(adPostPbData.buttonText);
        this.jKp.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.jKo.setRadius(l.getDimens(getContext(), R.dimen.ds32));
            this.jKn.setVisibility(8);
            this.jIa.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.jIa.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.jKq = advertAppInfo.cIV;
                DownloadData c = c(advertAppInfo, this.position);
                c.setStatus(ApkDownloadView.getStatus(c));
                this.jIa.setData(c);
                return;
            }
            return;
        }
        this.jKo.setRadius(0);
        this.jIa.setVisibility(8);
        this.jKn.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData, int i) {
        am.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.cRQ, R.color.cp_bg_line_e);
        am.setViewTextColor(this.iLm, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.jKp, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.jKl, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.jKm, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.jKn, (int) R.color.cp_link_tip_a);
        am.setBackgroundResource(this.jKn, R.drawable.feed_ad_progress_button_bg);
        this.jIa.setTextColor(am.getColor(R.color.cp_btn_a));
        this.jIa.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View caC() {
        MessageManager.getInstance().registerListener(this.jHp);
        this.jHp.setTag(this.cRe.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.post_ad_pb_banner_card, (ViewGroup) null);
        this.jKo = (TbImageView) this.rootView.findViewById(R.id.image);
        this.jKn = (TextView) this.rootView.findViewById(R.id.action_button);
        this.iLm = (TextView) this.rootView.findViewById(R.id.recommend_title);
        this.jKl = (TextView) this.rootView.findViewById(R.id.ad_title);
        this.jKm = (TextView) this.rootView.findViewById(R.id.ad_description);
        this.jKp = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.cRQ = this.rootView.findViewById(R.id.divider);
        this.jIa = (ApkDownloadView) this.rootView.findViewById(R.id.ad_download);
        this.jIa.u(this.cRe.getUniqueId());
        this.rootView.setOnClickListener(this.fHv);
        this.jKn.setOnClickListener(this.fHv);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.cIV);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.cIT);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.toInt(advertAppInfo.cIS, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.cRe.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.cRe.getPageActivity()) && this.hWF != null) {
                this.hWF.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.q(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.cRe.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.aya()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.cRe.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cRe.getPageActivity());
                aVar.sC(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdPostPbView.this.a(advertAppInfo, i, AdPostPbView.this.jIa);
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.cRe).aCp();
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
                    s.bd(this.cRe.getPageActivity(), advertAppInfo.cIV);
                    return;
                case 6:
                case 7:
                    a(advertAppInfo, i, apkDownloadView);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a implements View.OnClickListener {
        private AdvertAppInfo jKt;

        public a(AdvertAppInfo advertAppInfo) {
            this.jKt = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdPostPbView.this.cRe.showToast(R.string.neterror);
                return;
            }
            boolean z = view == AdPostPbView.this.jIa;
            if (this.jKt != null) {
                int i = b.toInt(this.jKt.adPosition, -1);
                int status = ApkDownloadView.getStatus(AdPostPbView.this.c(this.jKt, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    AdPostPbView.this.a(this.jKt, i, AdPostPbView.this.jIa, z);
                    if (AdPostPbView.this.hWE != null) {
                        AdPostPbView.this.hWE.b(3, null);
                        return;
                    }
                    return;
                }
                AdPostPbView.this.showDownloadAppDialog(this.jKt, i, true, this.jKt.cJb != null ? this.jKt.cJb.cJn : "");
            }
        }
    }
}
