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
import com.baidu.tieba.e;
import com.baidu.tieba.recapp.download.g;
import com.baidu.tieba.recapp.lego.model.AdPostPbData;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
/* loaded from: classes3.dex */
public class AdPostPbView extends PostAdBaseView<AdPostPbData> {
    protected View.OnClickListener cSt;
    private View divider;
    protected CustomMessageListener gNE;
    private ApkDownloadView gOo;
    private TextView gQA;
    private TextView gQB;
    private TextView gQC;
    private TbImageView gQD;
    private TextView gQE;
    private String gQF;
    private AdPostPbData gQG;
    private TextView gaM;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    private View rootView;

    public AdPostPbView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.cSt = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostPbView.this.gQG != null) {
                    int e = s.e(AdPostPbView.this.mContext, AdPostPbView.this.gQG.scheme);
                    if (AdPostPbView.this.fnI != null) {
                        AdPostPbView.this.fnI.b(e, null);
                    }
                }
            }
        };
        this.gNE = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdPostPbView.this.gQF) && AdPostPbView.this.gQF.equals(downloadData.getId())) {
                    AdPostPbView.this.gOo.s(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData) {
        this.gQG = adPostPbData;
        this.gQD.startLoad(adPostPbData.portrait, 17, false);
        this.gaM.setText(adPostPbData.recommend);
        this.gQA.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.gQB.setVisibility(8);
        } else {
            this.gQB.setVisibility(0);
            this.gQB.setText(adPostPbData.desc);
        }
        this.gQC.setText(adPostPbData.buttonText);
        this.gQE.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.gQD.setRadius(l.h(getContext(), e.C0210e.ds32));
            this.gQC.setVisibility(8);
            this.gOo.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.gOo.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.gQF = advertAppInfo.apv;
                DownloadData c = c(advertAppInfo, this.position);
                c.setStatus(ApkDownloadView.getStatus(c));
                this.gOo.setData(c);
                return;
            }
            return;
        }
        this.gQD.setRadius(0);
        this.gOo.setVisibility(8);
        this.gQC.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData, int i) {
        al.j(this.rootView, e.d.cp_bg_line_d);
        al.j(this.divider, e.d.cp_bg_line_e);
        al.h(this.gaM, e.d.cp_cont_b);
        al.h(this.gQE, e.d.cp_cont_j);
        al.h(this.gQA, e.d.cp_cont_b);
        al.h(this.gQB, e.d.cp_cont_j);
        al.h(this.gQC, e.d.cp_link_tip_a);
        al.i(this.gQC, e.f.feed_ad_progress_button_bg);
        this.gOo.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View aYl() {
        MessageManager.getInstance().registerListener(this.gNE);
        this.gNE.setTag(this.mContext.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(e.h.post_ad_pb_banner_card, (ViewGroup) null);
        this.gQD = (TbImageView) this.rootView.findViewById(e.g.image);
        this.gQC = (TextView) this.rootView.findViewById(e.g.action_button);
        this.gaM = (TextView) this.rootView.findViewById(e.g.recommend_title);
        this.gQA = (TextView) this.rootView.findViewById(e.g.ad_title);
        this.gQB = (TextView) this.rootView.findViewById(e.g.ad_description);
        this.gQE = (TextView) this.rootView.findViewById(e.g.ad_tag);
        this.divider = this.rootView.findViewById(e.g.divider);
        this.gOo = (ApkDownloadView) this.rootView.findViewById(e.g.ad_download);
        this.gOo.p(this.mContext.getUniqueId());
        this.rootView.setOnClickListener(this.cSt);
        this.gQC.setOnClickListener(this.cSt);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.apv);
        downloadData.setUrl(advertAppInfo.apu);
        downloadData.setName(advertAppInfo.apr);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.l(advertAppInfo.apq, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.Et();
            this.mPermissionJudgePolicy.c(this.mContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.A(this.mContext.getPageActivity()) && this.fnJ != null) {
                this.fnJ.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.p(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.kK()) {
                l.showToast(this.mContext.getPageActivity(), e.j.neterror);
            } else if (advertAppInfo.yd()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(e.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.eB(str);
                aVar.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdPostPbView.this.a(advertAppInfo, i, AdPostPbView.this.gOo);
                        aVar2.dismiss();
                    }
                });
                aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.mContext).BF();
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
                    s.aG(this.mContext.getPageActivity(), advertAppInfo.apv);
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
        private AdvertAppInfo gQI;

        public a(AdvertAppInfo advertAppInfo) {
            this.gQI = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.kK()) {
                AdPostPbView.this.mContext.showToast(e.j.neterror);
                return;
            }
            boolean z = view == AdPostPbView.this.gOo;
            if (this.gQI != null) {
                int l = b.l(this.gQI.adPosition, -1);
                int status = ApkDownloadView.getStatus(AdPostPbView.this.c(this.gQI, l));
                if ((6 != status && 7 != status) || !j.kV() || j.kW()) {
                    AdPostPbView.this.a(this.gQI, l, AdPostPbView.this.gOo, z);
                    if (AdPostPbView.this.fnI != null) {
                        AdPostPbView.this.fnI.b(3, null);
                        return;
                    }
                    return;
                }
                AdPostPbView.this.showDownloadAppDialog(this.gQI, l, true, this.gQI.apB != null ? this.gQI.apB.apN : "");
            }
        }
    }
}
