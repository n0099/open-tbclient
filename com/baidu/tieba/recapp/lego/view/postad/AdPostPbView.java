package com.baidu.tieba.recapp.lego.view.postad;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.g.b;
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
/* loaded from: classes3.dex */
public class AdPostPbView extends PostAdBaseView<AdPostPbData> {
    private View cfh;
    protected View.OnClickListener eMw;
    private TextView hTb;
    protected CustomMessageListener iJr;
    private ApkDownloadView iKc;
    private TextView iMp;
    private TextView iMq;
    private TextView iMr;
    private TbImageView iMs;
    private TextView iMt;
    private String iMu;
    private AdPostPbData iMv;
    private com.baidu.tbadk.core.util.c.a mPermissionJudgePolicy;
    private View rootView;

    public AdPostPbView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eMw = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostPbView.this.iMv != null) {
                    int a2 = s.a(AdPostPbView.this.ceu, AdPostPbView.this.iMv.scheme, AdPostPbView.this.iMv.id);
                    if (AdPostPbView.this.heW != null) {
                        AdPostPbView.this.heW.b(a2, null);
                    }
                }
            }
        };
        this.iJr = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdPostPbView.this.iMu) && AdPostPbView.this.iMu.equals(downloadData.getId())) {
                    AdPostPbView.this.iKc.t(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData) {
        this.iMv = adPostPbData;
        this.iMs.startLoad(adPostPbData.portrait, 17, false);
        this.hTb.setText(adPostPbData.recommend);
        this.iMp.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.iMq.setVisibility(8);
        } else {
            this.iMq.setVisibility(0);
            this.iMq.setText(adPostPbData.desc);
        }
        this.iMr.setText(adPostPbData.buttonText);
        this.iMt.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.iMs.setRadius(l.getDimens(getContext(), R.dimen.ds32));
            this.iMr.setVisibility(8);
            this.iKc.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.iKc.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.iMu = advertAppInfo.bWx;
                DownloadData c = c(advertAppInfo, this.position);
                c.setStatus(ApkDownloadView.getStatus(c));
                this.iKc.setData(c);
                return;
            }
            return;
        }
        this.iMs.setRadius(0);
        this.iKc.setVisibility(8);
        this.iMr.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData, int i) {
        am.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.cfh, R.color.cp_bg_line_e);
        am.setViewTextColor(this.hTb, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.iMt, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.iMp, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.iMq, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.iMr, (int) R.color.cp_link_tip_a);
        am.setBackgroundResource(this.iMr, R.drawable.feed_ad_progress_button_bg);
        this.iKc.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View bIe() {
        MessageManager.getInstance().registerListener(this.iJr);
        this.iJr.setTag(this.ceu.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.post_ad_pb_banner_card, (ViewGroup) null);
        this.iMs = (TbImageView) this.rootView.findViewById(R.id.image);
        this.iMr = (TextView) this.rootView.findViewById(R.id.action_button);
        this.hTb = (TextView) this.rootView.findViewById(R.id.recommend_title);
        this.iMp = (TextView) this.rootView.findViewById(R.id.ad_title);
        this.iMq = (TextView) this.rootView.findViewById(R.id.ad_description);
        this.iMt = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.cfh = this.rootView.findViewById(R.id.divider);
        this.iKc = (ApkDownloadView) this.rootView.findViewById(R.id.ad_download);
        this.iKc.t(this.ceu.getUniqueId());
        this.rootView.setOnClickListener(this.eMw);
        this.iMr.setOnClickListener(this.eMw);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.bWx);
        downloadData.setUrl(advertAppInfo.bWw);
        downloadData.setName(advertAppInfo.bWu);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.toInt(advertAppInfo.bWt, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.c.a();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.ceu.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.ceu.getPageActivity()) && this.heX != null) {
                this.heX.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.q(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.ceu.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.agQ()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.ceu.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ceu.getPageActivity());
                aVar.nn(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdPostPbView.this.a(advertAppInfo, i, AdPostPbView.this.iKc);
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.ceu).akM();
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
                    s.aK(this.ceu.getPageActivity(), advertAppInfo.bWx);
                    return;
                case 6:
                case 7:
                    a(advertAppInfo, i, apkDownloadView);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private AdvertAppInfo iMx;

        public a(AdvertAppInfo advertAppInfo) {
            this.iMx = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdPostPbView.this.ceu.showToast(R.string.neterror);
                return;
            }
            boolean z = view == AdPostPbView.this.iKc;
            if (this.iMx != null) {
                int i = b.toInt(this.iMx.adPosition, -1);
                int status = ApkDownloadView.getStatus(AdPostPbView.this.c(this.iMx, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    AdPostPbView.this.a(this.iMx, i, AdPostPbView.this.iKc, z);
                    if (AdPostPbView.this.heW != null) {
                        AdPostPbView.this.heW.b(3, null);
                        return;
                    }
                    return;
                }
                AdPostPbView.this.showDownloadAppDialog(this.iMx, i, true, this.iMx.bWD != null ? this.iMx.bWD.bWP : "");
            }
        }
    }
}
