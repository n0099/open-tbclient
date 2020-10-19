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
/* loaded from: classes26.dex */
public class AdPostPbView extends PostAdBaseView<AdPostPbData> {
    private View euA;
    protected View.OnClickListener hFR;
    private TextView lhu;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    protected CustomMessageListener mcW;
    private ApkDownloadView mdJ;
    private TextView mfB;
    private TextView mfC;
    private TextView mfD;
    private TbImageView mfE;
    private TextView mfF;
    private String mfG;
    private AdPostPbData mfH;
    private View rootView;

    public AdPostPbView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hFR = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostPbView.this.mfH != null) {
                    int c = s.c(AdPostPbView.this.etO, AdPostPbView.this.mfH.scheme, AdPostPbView.this.mfH.id);
                    if (AdPostPbView.this.knj != null) {
                        AdPostPbView.this.knj.d(c, null);
                    }
                }
            }
        };
        this.mcW = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdPostPbView.this.mfG) && AdPostPbView.this.mfG.equals(downloadData.getId())) {
                    AdPostPbView.this.mdJ.t(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData) {
        this.mfH = adPostPbData;
        this.mfE.startLoad(adPostPbData.portrait, 17, false);
        this.lhu.setText(adPostPbData.recommend);
        this.mfB.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.mfC.setVisibility(8);
        } else {
            this.mfC.setVisibility(0);
            this.mfC.setText(adPostPbData.desc);
        }
        this.mfD.setText(adPostPbData.buttonText);
        this.mfF.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.mfE.setRadius(l.getDimens(getContext(), R.dimen.ds32));
            this.mfD.setVisibility(8);
            this.mdJ.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.mdJ.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.mfG = advertAppInfo.eky;
                DownloadData b = b(advertAppInfo, this.position);
                b.setStatus(ApkDownloadView.getStatus(b));
                this.mdJ.setData(b);
                return;
            }
            return;
        }
        this.mfE.setRadius(0);
        this.mdJ.setVisibility(8);
        this.mfD.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData, int i) {
        ap.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.euA, R.color.cp_bg_line_e);
        ap.setViewTextColor(this.lhu, R.color.cp_cont_b);
        ap.setViewTextColor(this.mfF, R.color.cp_cont_j);
        ap.setViewTextColor(this.mfB, R.color.cp_cont_b);
        ap.setViewTextColor(this.mfC, R.color.cp_cont_j);
        ap.setViewTextColor(this.mfD, R.color.cp_link_tip_a);
        ap.setBackgroundResource(this.mfD, R.drawable.feed_ad_progress_button_bg);
        this.mdJ.setTextColor(ap.getColor(R.color.cp_btn_a));
        this.mdJ.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View cTG() {
        MessageManager.getInstance().registerListener(this.mcW);
        this.mcW.setTag(this.etO.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.post_ad_pb_banner_card, (ViewGroup) null);
        this.mfE = (TbImageView) this.rootView.findViewById(R.id.image);
        this.mfD = (TextView) this.rootView.findViewById(R.id.action_button);
        this.lhu = (TextView) this.rootView.findViewById(R.id.recommend_title);
        this.mfB = (TextView) this.rootView.findViewById(R.id.ad_title);
        this.mfC = (TextView) this.rootView.findViewById(R.id.ad_description);
        this.mfF = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.euA = this.rootView.findViewById(R.id.divider);
        this.mdJ = (ApkDownloadView) this.rootView.findViewById(R.id.ad_download);
        this.mdJ.x(this.etO.getUniqueId());
        this.rootView.setOnClickListener(this.hFR);
        this.mfD.setOnClickListener(this.hFR);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData b(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.eky);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.ekw);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.toInt(advertAppInfo.ekv, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.etO.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.etO.getPageActivity()) && this.knk != null) {
                this.knk.c(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.q(b(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.etO.getPageActivity(), R.string.neterror);
            } else if (advertAppInfo.bfZ()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.etO.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.etO.getPageActivity());
                aVar.AH(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdPostPbView.this.a(advertAppInfo, i, AdPostPbView.this.mdJ);
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.etO).bkJ();
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
                    s.aV(this.etO.getPageActivity(), advertAppInfo.eky);
                    return;
                case 6:
                case 7:
                    a(advertAppInfo, i, apkDownloadView);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public class a implements View.OnClickListener {
        private AdvertAppInfo mfJ;

        public a(AdvertAppInfo advertAppInfo) {
            this.mfJ = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdPostPbView.this.etO.showToast(R.string.neterror);
                return;
            }
            boolean z = view == AdPostPbView.this.mdJ;
            if (this.mfJ != null) {
                int i = b.toInt(this.mfJ.adPosition, -1);
                int status = ApkDownloadView.getStatus(AdPostPbView.this.b(this.mfJ, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    AdPostPbView.this.a(this.mfJ, i, AdPostPbView.this.mdJ, z);
                    if (AdPostPbView.this.knj != null) {
                        AdPostPbView.this.knj.d(3, null);
                        return;
                    }
                    return;
                }
                AdPostPbView.this.showDownloadAppDialog(this.mfJ, i, true, this.mfJ.ekE != null ? this.mfJ.ekE.ekQ : "");
            }
        }
    }
}
