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
    private View egd;
    protected View.OnClickListener hjU;
    private TextView kJH;
    protected CustomMessageListener lEL;
    private ApkDownloadView lFy;
    private TextView lHp;
    private TextView lHq;
    private TextView lHr;
    private TbImageView lHs;
    private TextView lHt;
    private String lHu;
    private AdPostPbData lHv;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private View rootView;

    public AdPostPbView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hjU = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostPbView.this.lHv != null) {
                    int c = s.c(AdPostPbView.this.efr, AdPostPbView.this.lHv.scheme, AdPostPbView.this.lHv.id);
                    if (AdPostPbView.this.jPq != null) {
                        AdPostPbView.this.jPq.d(c, null);
                    }
                }
            }
        };
        this.lEL = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdPostPbView.this.lHu) && AdPostPbView.this.lHu.equals(downloadData.getId())) {
                    AdPostPbView.this.lFy.t(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData) {
        this.lHv = adPostPbData;
        this.lHs.startLoad(adPostPbData.portrait, 17, false);
        this.kJH.setText(adPostPbData.recommend);
        this.lHp.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.lHq.setVisibility(8);
        } else {
            this.lHq.setVisibility(0);
            this.lHq.setText(adPostPbData.desc);
        }
        this.lHr.setText(adPostPbData.buttonText);
        this.lHt.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.lHs.setRadius(l.getDimens(getContext(), R.dimen.ds32));
            this.lHr.setVisibility(8);
            this.lFy.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.lFy.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.lHu = advertAppInfo.dWm;
                DownloadData b = b(advertAppInfo, this.position);
                b.setStatus(ApkDownloadView.getStatus(b));
                this.lFy.setData(b);
                return;
            }
            return;
        }
        this.lHs.setRadius(0);
        this.lFy.setVisibility(8);
        this.lHr.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData, int i) {
        ap.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.egd, R.color.cp_bg_line_e);
        ap.setViewTextColor(this.kJH, R.color.cp_cont_b);
        ap.setViewTextColor(this.lHt, R.color.cp_cont_j);
        ap.setViewTextColor(this.lHp, R.color.cp_cont_b);
        ap.setViewTextColor(this.lHq, R.color.cp_cont_j);
        ap.setViewTextColor(this.lHr, R.color.cp_link_tip_a);
        ap.setBackgroundResource(this.lHr, R.drawable.feed_ad_progress_button_bg);
        this.lFy.setTextColor(ap.getColor(R.color.cp_btn_a));
        this.lFy.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View cMq() {
        MessageManager.getInstance().registerListener(this.lEL);
        this.lEL.setTag(this.efr.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.post_ad_pb_banner_card, (ViewGroup) null);
        this.lHs = (TbImageView) this.rootView.findViewById(R.id.image);
        this.lHr = (TextView) this.rootView.findViewById(R.id.action_button);
        this.kJH = (TextView) this.rootView.findViewById(R.id.recommend_title);
        this.lHp = (TextView) this.rootView.findViewById(R.id.ad_title);
        this.lHq = (TextView) this.rootView.findViewById(R.id.ad_description);
        this.lHt = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.egd = this.rootView.findViewById(R.id.divider);
        this.lFy = (ApkDownloadView) this.rootView.findViewById(R.id.ad_download);
        this.lFy.y(this.efr.getUniqueId());
        this.rootView.setOnClickListener(this.hjU);
        this.lHr.setOnClickListener(this.hjU);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData b(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.dWm);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.dWk);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.toInt(advertAppInfo.dWj, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.efr.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.efr.getPageActivity()) && this.jPr != null) {
                this.jPr.c(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.q(b(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.efr.getPageActivity(), R.string.neterror);
            } else if (advertAppInfo.bcw()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.efr.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.efr.getPageActivity());
                aVar.zA(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdPostPbView.this.a(advertAppInfo, i, AdPostPbView.this.lFy);
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.efr).bhg();
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
                    s.aQ(this.efr.getPageActivity(), advertAppInfo.dWm);
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
        private AdvertAppInfo lHx;

        public a(AdvertAppInfo advertAppInfo) {
            this.lHx = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdPostPbView.this.efr.showToast(R.string.neterror);
                return;
            }
            boolean z = view == AdPostPbView.this.lFy;
            if (this.lHx != null) {
                int i = b.toInt(this.lHx.adPosition, -1);
                int status = ApkDownloadView.getStatus(AdPostPbView.this.b(this.lHx, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    AdPostPbView.this.a(this.lHx, i, AdPostPbView.this.lFy, z);
                    if (AdPostPbView.this.jPq != null) {
                        AdPostPbView.this.jPq.d(3, null);
                        return;
                    }
                    return;
                }
                AdPostPbView.this.showDownloadAppDialog(this.lHx, i, true, this.lHx.dWs != null ? this.lHx.dWs.dWE : "");
            }
        }
    }
}
