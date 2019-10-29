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
    private View cfY;
    protected View.OnClickListener eNn;
    private TextView hTS;
    private ApkDownloadView iKT;
    protected CustomMessageListener iKi;
    private TextView iNg;
    private TextView iNh;
    private TextView iNi;
    private TbImageView iNj;
    private TextView iNk;
    private String iNl;
    private AdPostPbData iNm;
    private com.baidu.tbadk.core.util.c.a mPermissionJudgePolicy;
    private View rootView;

    public AdPostPbView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eNn = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostPbView.this.iNm != null) {
                    int a2 = s.a(AdPostPbView.this.cfl, AdPostPbView.this.iNm.scheme, AdPostPbView.this.iNm.id);
                    if (AdPostPbView.this.hfN != null) {
                        AdPostPbView.this.hfN.b(a2, null);
                    }
                }
            }
        };
        this.iKi = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdPostPbView.this.iNl) && AdPostPbView.this.iNl.equals(downloadData.getId())) {
                    AdPostPbView.this.iKT.t(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData) {
        this.iNm = adPostPbData;
        this.iNj.startLoad(adPostPbData.portrait, 17, false);
        this.hTS.setText(adPostPbData.recommend);
        this.iNg.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.iNh.setVisibility(8);
        } else {
            this.iNh.setVisibility(0);
            this.iNh.setText(adPostPbData.desc);
        }
        this.iNi.setText(adPostPbData.buttonText);
        this.iNk.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.iNj.setRadius(l.getDimens(getContext(), R.dimen.ds32));
            this.iNi.setVisibility(8);
            this.iKT.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.iKT.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.iNl = advertAppInfo.bXo;
                DownloadData c = c(advertAppInfo, this.position);
                c.setStatus(ApkDownloadView.getStatus(c));
                this.iKT.setData(c);
                return;
            }
            return;
        }
        this.iNj.setRadius(0);
        this.iKT.setVisibility(8);
        this.iNi.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData, int i) {
        am.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.cfY, R.color.cp_bg_line_e);
        am.setViewTextColor(this.hTS, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.iNk, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.iNg, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.iNh, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.iNi, (int) R.color.cp_link_tip_a);
        am.setBackgroundResource(this.iNi, R.drawable.feed_ad_progress_button_bg);
        this.iKT.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View bIg() {
        MessageManager.getInstance().registerListener(this.iKi);
        this.iKi.setTag(this.cfl.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.post_ad_pb_banner_card, (ViewGroup) null);
        this.iNj = (TbImageView) this.rootView.findViewById(R.id.image);
        this.iNi = (TextView) this.rootView.findViewById(R.id.action_button);
        this.hTS = (TextView) this.rootView.findViewById(R.id.recommend_title);
        this.iNg = (TextView) this.rootView.findViewById(R.id.ad_title);
        this.iNh = (TextView) this.rootView.findViewById(R.id.ad_description);
        this.iNk = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.cfY = this.rootView.findViewById(R.id.divider);
        this.iKT = (ApkDownloadView) this.rootView.findViewById(R.id.ad_download);
        this.iKT.t(this.cfl.getUniqueId());
        this.rootView.setOnClickListener(this.eNn);
        this.iNi.setOnClickListener(this.eNn);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.bXo);
        downloadData.setUrl(advertAppInfo.bXn);
        downloadData.setName(advertAppInfo.bXl);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.toInt(advertAppInfo.bXk, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.c.a();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.cfl.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.cfl.getPageActivity()) && this.hfO != null) {
                this.hfO.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.q(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.cfl.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.agS()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.cfl.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cfl.getPageActivity());
                aVar.nn(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdPostPbView.this.a(advertAppInfo, i, AdPostPbView.this.iKT);
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.cfl).akO();
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
                    s.aK(this.cfl.getPageActivity(), advertAppInfo.bXo);
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
        private AdvertAppInfo iNo;

        public a(AdvertAppInfo advertAppInfo) {
            this.iNo = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdPostPbView.this.cfl.showToast(R.string.neterror);
                return;
            }
            boolean z = view == AdPostPbView.this.iKT;
            if (this.iNo != null) {
                int i = b.toInt(this.iNo.adPosition, -1);
                int status = ApkDownloadView.getStatus(AdPostPbView.this.c(this.iNo, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    AdPostPbView.this.a(this.iNo, i, AdPostPbView.this.iKT, z);
                    if (AdPostPbView.this.hfN != null) {
                        AdPostPbView.this.hfN.b(3, null);
                        return;
                    }
                    return;
                }
                AdPostPbView.this.showDownloadAppDialog(this.iNo, i, true, this.iNo.bXu != null ? this.iNo.bXu.bXG : "");
            }
        }
    }
}
