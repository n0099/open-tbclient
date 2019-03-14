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
    protected View.OnClickListener eis;
    private TextView huL;
    protected CustomMessageListener iiX;
    private ApkDownloadView ijH;
    private TextView ilU;
    private TextView ilV;
    private TextView ilW;
    private TbImageView ilX;
    private TextView ilY;
    private String ilZ;
    private AdPostPbData ima;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    private View rootView;

    public AdPostPbView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eis = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostPbView.this.ima != null) {
                    int e = s.e(AdPostPbView.this.mContext, AdPostPbView.this.ima.scheme);
                    if (AdPostPbView.this.gHy != null) {
                        AdPostPbView.this.gHy.b(e, null);
                    }
                }
            }
        };
        this.iiX = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdPostPbView.this.ilZ) && AdPostPbView.this.ilZ.equals(downloadData.getId())) {
                    AdPostPbView.this.ijH.s(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData) {
        this.ima = adPostPbData;
        this.ilX.startLoad(adPostPbData.portrait, 17, false);
        this.huL.setText(adPostPbData.recommend);
        this.ilU.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.ilV.setVisibility(8);
        } else {
            this.ilV.setVisibility(0);
            this.ilV.setText(adPostPbData.desc);
        }
        this.ilW.setText(adPostPbData.buttonText);
        this.ilY.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.ilX.setRadius(l.h(getContext(), d.e.ds32));
            this.ilW.setVisibility(8);
            this.ijH.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.ijH.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.ilZ = advertAppInfo.bwH;
                DownloadData c = c(advertAppInfo, this.position);
                c.setStatus(ApkDownloadView.getStatus(c));
                this.ijH.setData(c);
                return;
            }
            return;
        }
        this.ilX.setRadius(0);
        this.ijH.setVisibility(8);
        this.ilW.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData, int i) {
        al.l(this.rootView, d.C0277d.cp_bg_line_d);
        al.l(this.divider, d.C0277d.cp_bg_line_e);
        al.j(this.huL, d.C0277d.cp_cont_b);
        al.j(this.ilY, d.C0277d.cp_cont_j);
        al.j(this.ilU, d.C0277d.cp_cont_b);
        al.j(this.ilV, d.C0277d.cp_cont_j);
        al.j(this.ilW, d.C0277d.cp_link_tip_a);
        al.k(this.ilW, d.f.feed_ad_progress_button_bg);
        this.ijH.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View bAd() {
        MessageManager.getInstance().registerListener(this.iiX);
        this.iiX.setTag(this.mContext.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(d.h.post_ad_pb_banner_card, (ViewGroup) null);
        this.ilX = (TbImageView) this.rootView.findViewById(d.g.image);
        this.ilW = (TextView) this.rootView.findViewById(d.g.action_button);
        this.huL = (TextView) this.rootView.findViewById(d.g.recommend_title);
        this.ilU = (TextView) this.rootView.findViewById(d.g.ad_title);
        this.ilV = (TextView) this.rootView.findViewById(d.g.ad_description);
        this.ilY = (TextView) this.rootView.findViewById(d.g.ad_tag);
        this.divider = this.rootView.findViewById(d.g.divider);
        this.ijH = (ApkDownloadView) this.rootView.findViewById(d.g.ad_download);
        this.ijH.q(this.mContext.getUniqueId());
        this.rootView.setOnClickListener(this.eis);
        this.ilW.setOnClickListener(this.eis);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.bwH);
        downloadData.setUrl(advertAppInfo.bwG);
        downloadData.setName(advertAppInfo.bwE);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.l(advertAppInfo.bwD, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.adQ();
            this.mPermissionJudgePolicy.e(this.mContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.Y(this.mContext.getPageActivity()) && this.gHz != null) {
                this.gHz.b(advertAppInfo, i);
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
            } else if (advertAppInfo.Xb()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(d.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.ly(str);
                aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdPostPbView.this.a(advertAppInfo, i, AdPostPbView.this.ijH);
                        aVar2.dismiss();
                    }
                });
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.mContext).aaZ();
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
                    s.aR(this.mContext.getPageActivity(), advertAppInfo.bwH);
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
        private AdvertAppInfo imc;

        public a(AdvertAppInfo advertAppInfo) {
            this.imc = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.kM()) {
                AdPostPbView.this.mContext.showToast(d.j.neterror);
                return;
            }
            boolean z = view == AdPostPbView.this.ijH;
            if (this.imc != null) {
                int l = b.l(this.imc.adPosition, -1);
                int status = ApkDownloadView.getStatus(AdPostPbView.this.c(this.imc, l));
                if ((6 != status && 7 != status) || !j.kY() || j.kZ()) {
                    AdPostPbView.this.a(this.imc, l, AdPostPbView.this.ijH, z);
                    if (AdPostPbView.this.gHy != null) {
                        AdPostPbView.this.gHy.b(3, null);
                        return;
                    }
                    return;
                }
                AdPostPbView.this.showDownloadAppDialog(this.imc, l, true, this.imc.bwN != null ? this.imc.bwN.bwZ : "");
            }
        }
    }
}
