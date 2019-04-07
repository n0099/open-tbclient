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
    protected View.OnClickListener eie;
    private TextView huy;
    protected CustomMessageListener iiJ;
    private ApkDownloadView ijt;
    private TextView ilG;
    private TextView ilH;
    private TextView ilI;
    private TbImageView ilJ;
    private TextView ilK;
    private String ilL;
    private AdPostPbData ilM;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    private View rootView;

    public AdPostPbView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eie = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostPbView.this.ilM != null) {
                    int e = s.e(AdPostPbView.this.mContext, AdPostPbView.this.ilM.scheme);
                    if (AdPostPbView.this.gHl != null) {
                        AdPostPbView.this.gHl.b(e, null);
                    }
                }
            }
        };
        this.iiJ = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdPostPbView.this.ilL) && AdPostPbView.this.ilL.equals(downloadData.getId())) {
                    AdPostPbView.this.ijt.s(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData) {
        this.ilM = adPostPbData;
        this.ilJ.startLoad(adPostPbData.portrait, 17, false);
        this.huy.setText(adPostPbData.recommend);
        this.ilG.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.ilH.setVisibility(8);
        } else {
            this.ilH.setVisibility(0);
            this.ilH.setText(adPostPbData.desc);
        }
        this.ilI.setText(adPostPbData.buttonText);
        this.ilK.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.ilJ.setRadius(l.h(getContext(), d.e.ds32));
            this.ilI.setVisibility(8);
            this.ijt.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.ijt.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.ilL = advertAppInfo.bwK;
                DownloadData c = c(advertAppInfo, this.position);
                c.setStatus(ApkDownloadView.getStatus(c));
                this.ijt.setData(c);
                return;
            }
            return;
        }
        this.ilJ.setRadius(0);
        this.ijt.setVisibility(8);
        this.ilI.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData, int i) {
        al.l(this.rootView, d.C0277d.cp_bg_line_d);
        al.l(this.divider, d.C0277d.cp_bg_line_e);
        al.j(this.huy, d.C0277d.cp_cont_b);
        al.j(this.ilK, d.C0277d.cp_cont_j);
        al.j(this.ilG, d.C0277d.cp_cont_b);
        al.j(this.ilH, d.C0277d.cp_cont_j);
        al.j(this.ilI, d.C0277d.cp_link_tip_a);
        al.k(this.ilI, d.f.feed_ad_progress_button_bg);
        this.ijt.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View bAa() {
        MessageManager.getInstance().registerListener(this.iiJ);
        this.iiJ.setTag(this.mContext.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(d.h.post_ad_pb_banner_card, (ViewGroup) null);
        this.ilJ = (TbImageView) this.rootView.findViewById(d.g.image);
        this.ilI = (TextView) this.rootView.findViewById(d.g.action_button);
        this.huy = (TextView) this.rootView.findViewById(d.g.recommend_title);
        this.ilG = (TextView) this.rootView.findViewById(d.g.ad_title);
        this.ilH = (TextView) this.rootView.findViewById(d.g.ad_description);
        this.ilK = (TextView) this.rootView.findViewById(d.g.ad_tag);
        this.divider = this.rootView.findViewById(d.g.divider);
        this.ijt = (ApkDownloadView) this.rootView.findViewById(d.g.ad_download);
        this.ijt.q(this.mContext.getUniqueId());
        this.rootView.setOnClickListener(this.eie);
        this.ilI.setOnClickListener(this.eie);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.bwK);
        downloadData.setUrl(advertAppInfo.bwJ);
        downloadData.setName(advertAppInfo.bwH);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.l(advertAppInfo.bwG, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.adN();
            this.mPermissionJudgePolicy.e(this.mContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.Y(this.mContext.getPageActivity()) && this.gHm != null) {
                this.gHm.b(advertAppInfo, i);
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
                        AdPostPbView.this.a(advertAppInfo, i, AdPostPbView.this.ijt);
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
                    s.aR(this.mContext.getPageActivity(), advertAppInfo.bwK);
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
        private AdvertAppInfo ilO;

        public a(AdvertAppInfo advertAppInfo) {
            this.ilO = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.kM()) {
                AdPostPbView.this.mContext.showToast(d.j.neterror);
                return;
            }
            boolean z = view == AdPostPbView.this.ijt;
            if (this.ilO != null) {
                int l = b.l(this.ilO.adPosition, -1);
                int status = ApkDownloadView.getStatus(AdPostPbView.this.c(this.ilO, l));
                if ((6 != status && 7 != status) || !j.kY() || j.kZ()) {
                    AdPostPbView.this.a(this.ilO, l, AdPostPbView.this.ijt, z);
                    if (AdPostPbView.this.gHl != null) {
                        AdPostPbView.this.gHl.b(3, null);
                        return;
                    }
                    return;
                }
                AdPostPbView.this.showDownloadAppDialog(this.ilO, l, true, this.ilO.bwQ != null ? this.ilO.bwQ.bxc : "");
            }
        }
    }
}
