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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.download.g;
import com.baidu.tieba.recapp.lego.model.AdPostPbData;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
/* loaded from: classes3.dex */
public class AdPostPbView extends PostAdBaseView<AdPostPbData> {
    private View divider;
    protected View.OnClickListener eif;
    private TextView huz;
    protected CustomMessageListener iiK;
    private ApkDownloadView iju;
    private TextView ilH;
    private TextView ilI;
    private TextView ilJ;
    private TbImageView ilK;
    private TextView ilL;
    private String ilM;
    private AdPostPbData ilN;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    private View rootView;

    public AdPostPbView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eif = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostPbView.this.ilN != null) {
                    int e = s.e(AdPostPbView.this.mContext, AdPostPbView.this.ilN.scheme);
                    if (AdPostPbView.this.gHm != null) {
                        AdPostPbView.this.gHm.b(e, null);
                    }
                }
            }
        };
        this.iiK = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdPostPbView.this.ilM) && AdPostPbView.this.ilM.equals(downloadData.getId())) {
                    AdPostPbView.this.iju.s(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData) {
        this.ilN = adPostPbData;
        this.ilK.startLoad(adPostPbData.portrait, 17, false);
        this.huz.setText(adPostPbData.recommend);
        this.ilH.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.ilI.setVisibility(8);
        } else {
            this.ilI.setVisibility(0);
            this.ilI.setText(adPostPbData.desc);
        }
        this.ilJ.setText(adPostPbData.buttonText);
        this.ilL.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.ilK.setRadius(l.h(getContext(), d.e.ds32));
            this.ilJ.setVisibility(8);
            this.iju.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.iju.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.ilM = advertAppInfo.bwL;
                DownloadData c = c(advertAppInfo, this.position);
                c.setStatus(ApkDownloadView.getStatus(c));
                this.iju.setData(c);
                return;
            }
            return;
        }
        this.ilK.setRadius(0);
        this.iju.setVisibility(8);
        this.ilJ.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData, int i) {
        al.l(this.rootView, d.C0277d.cp_bg_line_d);
        al.l(this.divider, d.C0277d.cp_bg_line_e);
        al.j(this.huz, d.C0277d.cp_cont_b);
        al.j(this.ilL, d.C0277d.cp_cont_j);
        al.j(this.ilH, d.C0277d.cp_cont_b);
        al.j(this.ilI, d.C0277d.cp_cont_j);
        al.j(this.ilJ, d.C0277d.cp_link_tip_a);
        al.k(this.ilJ, d.f.feed_ad_progress_button_bg);
        this.iju.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View bAa() {
        MessageManager.getInstance().registerListener(this.iiK);
        this.iiK.setTag(this.mContext.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(d.h.post_ad_pb_banner_card, (ViewGroup) null);
        this.ilK = (TbImageView) this.rootView.findViewById(d.g.image);
        this.ilJ = (TextView) this.rootView.findViewById(d.g.action_button);
        this.huz = (TextView) this.rootView.findViewById(d.g.recommend_title);
        this.ilH = (TextView) this.rootView.findViewById(d.g.ad_title);
        this.ilI = (TextView) this.rootView.findViewById(d.g.ad_description);
        this.ilL = (TextView) this.rootView.findViewById(d.g.ad_tag);
        this.divider = this.rootView.findViewById(d.g.divider);
        this.iju = (ApkDownloadView) this.rootView.findViewById(d.g.ad_download);
        this.iju.q(this.mContext.getUniqueId());
        this.rootView.setOnClickListener(this.eif);
        this.ilJ.setOnClickListener(this.eif);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.bwL);
        downloadData.setUrl(advertAppInfo.bwK);
        downloadData.setName(advertAppInfo.bwI);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.l(advertAppInfo.bwH, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.adN();
            this.mPermissionJudgePolicy.e(this.mContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.Y(this.mContext.getPageActivity()) && this.gHn != null) {
                this.gHn.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.p(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.kM()) {
                l.showToast(this.mContext.getPageActivity(), d.j.neterror);
            } else if (advertAppInfo.WY()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(d.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.lz(str);
                aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdPostPbView.this.a(advertAppInfo, i, AdPostPbView.this.iju);
                        aVar2.dismiss();
                    }
                });
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.mContext).aaW();
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
                        g.f(advertAppInfo);
                        apkDownloadView.q(c);
                        return;
                    }
                    return;
                case 2:
                case 4:
                default:
                    return;
                case 3:
                    s.aR(this.mContext.getPageActivity(), advertAppInfo.bwL);
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
        private AdvertAppInfo ilP;

        public a(AdvertAppInfo advertAppInfo) {
            this.ilP = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.kM()) {
                AdPostPbView.this.mContext.showToast(d.j.neterror);
                return;
            }
            boolean z = view == AdPostPbView.this.iju;
            if (this.ilP != null) {
                int l = b.l(this.ilP.adPosition, -1);
                int status = ApkDownloadView.getStatus(AdPostPbView.this.c(this.ilP, l));
                if ((6 != status && 7 != status) || !j.kY() || j.kZ()) {
                    AdPostPbView.this.a(this.ilP, l, AdPostPbView.this.iju, z);
                    if (AdPostPbView.this.gHm != null) {
                        AdPostPbView.this.gHm.b(3, null);
                        return;
                    }
                    return;
                }
                AdPostPbView.this.showDownloadAppDialog(this.ilP, l, true, this.ilP.bwR != null ? this.ilP.bwR.bxd : "");
            }
        }
    }
}
