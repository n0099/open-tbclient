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
    private View divider;
    protected View.OnClickListener eEH;
    private TextView hVk;
    protected CustomMessageListener iLr;
    private ApkDownloadView iMb;
    private TextView iOo;
    private TextView iOp;
    private TextView iOq;
    private TbImageView iOr;
    private TextView iOs;
    private String iOt;
    private AdPostPbData iOu;
    private com.baidu.tbadk.core.util.c.a mPermissionJudgePolicy;
    private View rootView;

    public AdPostPbView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eEH = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostPbView.this.iOu != null) {
                    int a2 = s.a(AdPostPbView.this.mContext, AdPostPbView.this.iOu.scheme, AdPostPbView.this.iOu.id);
                    if (AdPostPbView.this.hhI != null) {
                        AdPostPbView.this.hhI.b(a2, null);
                    }
                }
            }
        };
        this.iLr = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdPostPbView.this.iOt) && AdPostPbView.this.iOt.equals(downloadData.getId())) {
                    AdPostPbView.this.iMb.s(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData) {
        this.iOu = adPostPbData;
        this.iOr.startLoad(adPostPbData.portrait, 17, false);
        this.hVk.setText(adPostPbData.recommend);
        this.iOo.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.iOp.setVisibility(8);
        } else {
            this.iOp.setVisibility(0);
            this.iOp.setText(adPostPbData.desc);
        }
        this.iOq.setText(adPostPbData.buttonText);
        this.iOs.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.iOr.setRadius(l.g(getContext(), R.dimen.ds32));
            this.iOq.setVisibility(8);
            this.iMb.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.iMb.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.iOt = advertAppInfo.bFw;
                DownloadData c = c(advertAppInfo, this.position);
                c.setStatus(ApkDownloadView.getStatus(c));
                this.iMb.setData(c);
                return;
            }
            return;
        }
        this.iOr.setRadius(0);
        this.iMb.setVisibility(8);
        this.iOq.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData, int i) {
        am.l(this.rootView, R.color.cp_bg_line_d);
        am.l(this.divider, R.color.cp_bg_line_e);
        am.j(this.hVk, R.color.cp_cont_b);
        am.j(this.iOs, R.color.cp_cont_j);
        am.j(this.iOo, R.color.cp_cont_b);
        am.j(this.iOp, R.color.cp_cont_j);
        am.j(this.iOq, R.color.cp_link_tip_a);
        am.k(this.iOq, R.drawable.feed_ad_progress_button_bg);
        this.iMb.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View bLw() {
        MessageManager.getInstance().registerListener(this.iLr);
        this.iLr.setTag(this.mContext.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.post_ad_pb_banner_card, (ViewGroup) null);
        this.iOr = (TbImageView) this.rootView.findViewById(R.id.image);
        this.iOq = (TextView) this.rootView.findViewById(R.id.action_button);
        this.hVk = (TextView) this.rootView.findViewById(R.id.recommend_title);
        this.iOo = (TextView) this.rootView.findViewById(R.id.ad_title);
        this.iOp = (TextView) this.rootView.findViewById(R.id.ad_description);
        this.iOs = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.divider = this.rootView.findViewById(R.id.divider);
        this.iMb = (ApkDownloadView) this.rootView.findViewById(R.id.ad_download);
        this.iMb.s(this.mContext.getUniqueId());
        this.rootView.setOnClickListener(this.eEH);
        this.iOq.setOnClickListener(this.eEH);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.bFw);
        downloadData.setUrl(advertAppInfo.bFv);
        downloadData.setName(advertAppInfo.bFt);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.f(advertAppInfo.bFs, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.c.a();
            }
            this.mPermissionJudgePolicy.ake();
            this.mPermissionJudgePolicy.e(this.mContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.ad(this.mContext.getPageActivity()) && this.hhJ != null) {
                this.hhJ.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.p(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.jQ()) {
                l.showToast(this.mContext.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.acM()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.mQ(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdPostPbView.this.a(advertAppInfo, i, AdPostPbView.this.iMb);
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.mContext).agO();
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
                        apkDownloadView.q(c);
                        return;
                    }
                    return;
                case 2:
                case 4:
                default:
                    return;
                case 3:
                    s.aN(this.mContext.getPageActivity(), advertAppInfo.bFw);
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
        private AdvertAppInfo iOw;

        public a(AdvertAppInfo advertAppInfo) {
            this.iOw = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.jQ()) {
                AdPostPbView.this.mContext.showToast(R.string.neterror);
                return;
            }
            boolean z = view == AdPostPbView.this.iMb;
            if (this.iOw != null) {
                int f = b.f(this.iOw.adPosition, -1);
                int status = ApkDownloadView.getStatus(AdPostPbView.this.c(this.iOw, f));
                if ((6 != status && 7 != status) || !j.kc() || j.kd()) {
                    AdPostPbView.this.a(this.iOw, f, AdPostPbView.this.iMb, z);
                    if (AdPostPbView.this.hhI != null) {
                        AdPostPbView.this.hhI.b(3, null);
                        return;
                    }
                    return;
                }
                AdPostPbView.this.showDownloadAppDialog(this.iOw, f, true, this.iOw.bFC != null ? this.iOw.bFC.bFO : "");
            }
        }
    }
}
