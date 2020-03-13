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
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
/* loaded from: classes13.dex */
public class AdPostPbView extends PostAdBaseView<AdPostPbData> {
    private View cVU;
    protected View.OnClickListener fKh;
    private TextView iMV;
    protected CustomMessageListener jIz;
    private ApkDownloadView jJk;
    private String jLA;
    private AdPostPbData jLB;
    private TextView jLv;
    private TextView jLw;
    private TextView jLx;
    private TbImageView jLy;
    private TextView jLz;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private View rootView;

    public AdPostPbView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fKh = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostPbView.this.jLB != null) {
                    int b = s.b(AdPostPbView.this.cVi, AdPostPbView.this.jLB.scheme, AdPostPbView.this.jLB.id);
                    if (AdPostPbView.this.hYQ != null) {
                        AdPostPbView.this.hYQ.b(b, null);
                    }
                }
            }
        };
        this.jIz = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdPostPbView.this.jLA) && AdPostPbView.this.jLA.equals(downloadData.getId())) {
                    AdPostPbView.this.jJk.t(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData) {
        this.jLB = adPostPbData;
        this.jLy.startLoad(adPostPbData.portrait, 17, false);
        this.iMV.setText(adPostPbData.recommend);
        this.jLv.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.jLw.setVisibility(8);
        } else {
            this.jLw.setVisibility(0);
            this.jLw.setText(adPostPbData.desc);
        }
        this.jLx.setText(adPostPbData.buttonText);
        this.jLz.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.jLy.setRadius(l.getDimens(getContext(), R.dimen.ds32));
            this.jLx.setVisibility(8);
            this.jJk.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.jJk.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.jLA = advertAppInfo.cNa;
                DownloadData c = c(advertAppInfo, this.position);
                c.setStatus(ApkDownloadView.getStatus(c));
                this.jJk.setData(c);
                return;
            }
            return;
        }
        this.jLy.setRadius(0);
        this.jJk.setVisibility(8);
        this.jLx.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData, int i) {
        am.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.cVU, R.color.cp_bg_line_e);
        am.setViewTextColor(this.iMV, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.jLz, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.jLv, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.jLw, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.jLx, (int) R.color.cp_link_tip_a);
        am.setBackgroundResource(this.jLx, R.drawable.feed_ad_progress_button_bg);
        this.jJk.setTextColor(am.getColor(R.color.cp_btn_a));
        this.jJk.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View ccg() {
        MessageManager.getInstance().registerListener(this.jIz);
        this.jIz.setTag(this.cVi.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.post_ad_pb_banner_card, (ViewGroup) null);
        this.jLy = (TbImageView) this.rootView.findViewById(R.id.image);
        this.jLx = (TextView) this.rootView.findViewById(R.id.action_button);
        this.iMV = (TextView) this.rootView.findViewById(R.id.recommend_title);
        this.jLv = (TextView) this.rootView.findViewById(R.id.ad_title);
        this.jLw = (TextView) this.rootView.findViewById(R.id.ad_description);
        this.jLz = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.cVU = this.rootView.findViewById(R.id.divider);
        this.jJk = (ApkDownloadView) this.rootView.findViewById(R.id.ad_download);
        this.jJk.u(this.cVi.getUniqueId());
        this.rootView.setOnClickListener(this.fKh);
        this.jLx.setOnClickListener(this.fKh);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.cNa);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.cMY);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.toInt(advertAppInfo.cMX, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.cVi.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.cVi.getPageActivity()) && this.hYR != null) {
                this.hYR.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.q(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.cVi.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.aAq()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.cVi.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cVi.getPageActivity());
                aVar.sS(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdPostPbView.this.a(advertAppInfo, i, AdPostPbView.this.jJk);
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.cVi).aEC();
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
                    s.bd(this.cVi.getPageActivity(), advertAppInfo.cNa);
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
        private AdvertAppInfo jLD;

        public a(AdvertAppInfo advertAppInfo) {
            this.jLD = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdPostPbView.this.cVi.showToast(R.string.neterror);
                return;
            }
            boolean z = view == AdPostPbView.this.jJk;
            if (this.jLD != null) {
                int i = b.toInt(this.jLD.adPosition, -1);
                int status = ApkDownloadView.getStatus(AdPostPbView.this.c(this.jLD, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    AdPostPbView.this.a(this.jLD, i, AdPostPbView.this.jJk, z);
                    if (AdPostPbView.this.hYQ != null) {
                        AdPostPbView.this.hYQ.b(3, null);
                        return;
                    }
                    return;
                }
                AdPostPbView.this.showDownloadAppDialog(this.jLD, i, true, this.jLD.cNg != null ? this.jLD.cNg.cNs : "");
            }
        }
    }
}
