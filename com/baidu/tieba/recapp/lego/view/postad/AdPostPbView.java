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
    private View eCZ;
    protected View.OnClickListener hSo;
    private TextView ltX;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    protected CustomMessageListener mpv;
    private ApkDownloadView mqi;
    private TextView mrZ;
    private TextView msa;
    private TextView msb;
    private TbImageView msc;
    private TextView msd;
    private String mse;
    private AdPostPbData msf;
    private View rootView;

    public AdPostPbView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hSo = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostPbView.this.msf != null) {
                    int c = s.c(AdPostPbView.this.eCn, AdPostPbView.this.msf.scheme, AdPostPbView.this.msf.id);
                    if (AdPostPbView.this.kzG != null) {
                        AdPostPbView.this.kzG.d(c, null);
                    }
                }
            }
        };
        this.mpv = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdPostPbView.this.mse) && AdPostPbView.this.mse.equals(downloadData.getId())) {
                    AdPostPbView.this.mqi.t(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData) {
        this.msf = adPostPbData;
        this.msc.startLoad(adPostPbData.portrait, 17, false);
        this.ltX.setText(adPostPbData.recommend);
        this.mrZ.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.msa.setVisibility(8);
        } else {
            this.msa.setVisibility(0);
            this.msa.setText(adPostPbData.desc);
        }
        this.msb.setText(adPostPbData.buttonText);
        this.msd.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.msc.setRadius(l.getDimens(getContext(), R.dimen.ds32));
            this.msb.setVisibility(8);
            this.mqi.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.mqi.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.mse = advertAppInfo.esX;
                DownloadData b = b(advertAppInfo, this.position);
                b.setStatus(ApkDownloadView.getStatus(b));
                this.mqi.setData(b);
                return;
            }
            return;
        }
        this.msc.setRadius(0);
        this.mqi.setVisibility(8);
        this.msb.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData, int i) {
        ap.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.eCZ, R.color.cp_bg_line_e);
        ap.setViewTextColor(this.ltX, R.color.cp_cont_b);
        ap.setViewTextColor(this.msd, R.color.cp_cont_j);
        ap.setViewTextColor(this.mrZ, R.color.cp_cont_b);
        ap.setViewTextColor(this.msa, R.color.cp_cont_j);
        ap.setViewTextColor(this.msb, R.color.cp_link_tip_a);
        ap.setBackgroundResource(this.msb, R.drawable.feed_ad_progress_button_bg);
        this.mqi.setTextColor(ap.getColor(R.color.cp_btn_a));
        this.mqi.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View cWN() {
        MessageManager.getInstance().registerListener(this.mpv);
        this.mpv.setTag(this.eCn.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.post_ad_pb_banner_card, (ViewGroup) null);
        this.msc = (TbImageView) this.rootView.findViewById(R.id.image);
        this.msb = (TextView) this.rootView.findViewById(R.id.action_button);
        this.ltX = (TextView) this.rootView.findViewById(R.id.recommend_title);
        this.mrZ = (TextView) this.rootView.findViewById(R.id.ad_title);
        this.msa = (TextView) this.rootView.findViewById(R.id.ad_description);
        this.msd = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.eCZ = this.rootView.findViewById(R.id.divider);
        this.mqi = (ApkDownloadView) this.rootView.findViewById(R.id.ad_download);
        this.mqi.x(this.eCn.getUniqueId());
        this.rootView.setOnClickListener(this.hSo);
        this.msb.setOnClickListener(this.hSo);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData b(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.esX);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.esV);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.toInt(advertAppInfo.esU, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.eCn.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.eCn.getPageActivity()) && this.kzH != null) {
                this.kzH.c(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.q(b(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.eCn.getPageActivity(), R.string.neterror);
            } else if (advertAppInfo.bhS()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.eCn.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eCn.getPageActivity());
                aVar.Ba(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdPostPbView.this.a(advertAppInfo, i, AdPostPbView.this.mqi);
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.eCn).bmC();
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
                    s.aX(this.eCn.getPageActivity(), advertAppInfo.esX);
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
        private AdvertAppInfo msi;

        public a(AdvertAppInfo advertAppInfo) {
            this.msi = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdPostPbView.this.eCn.showToast(R.string.neterror);
                return;
            }
            boolean z = view == AdPostPbView.this.mqi;
            if (this.msi != null) {
                int i = b.toInt(this.msi.adPosition, -1);
                int status = ApkDownloadView.getStatus(AdPostPbView.this.b(this.msi, i));
                if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                    AdPostPbView.this.a(this.msi, i, AdPostPbView.this.mqi, z);
                    if (AdPostPbView.this.kzG != null) {
                        AdPostPbView.this.kzG.d(3, null);
                        return;
                    }
                    return;
                }
                AdPostPbView.this.showDownloadAppDialog(this.msi, i, true, this.msi.ete != null ? this.msi.ete.etq : "");
            }
        }
    }
}
