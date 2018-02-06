package com.baidu.tieba.recapp.lego.view.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.download.g;
import com.baidu.tieba.recapp.lego.model.AdPostPbData;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
/* loaded from: classes3.dex */
public class c extends d<AdPostPbData> {
    protected View.OnClickListener cVJ;
    private View divider;
    private TextView fSC;
    private ApkDownloadView gER;
    protected CustomMessageListener gEh;
    private TextView gGQ;
    private TextView gGR;
    private TextView gGS;
    private TbImageView gGT;
    private TextView gGU;
    private String gGV;
    private AdPostPbData gGW;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    private View rootView;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.cVJ = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.gGW != null) {
                    int f = s.f(c.this.aRR, c.this.gGW.scheme);
                    if (c.this.fbC != null) {
                        c.this.fbC.b(f, null);
                    }
                }
            }
        };
        this.gEh = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.a.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(c.this.gGV) && c.this.gGV.equals(downloadData.getId())) {
                    c.this.gER.u(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.a.d
    public void a(AdPostPbData adPostPbData) {
        this.gGW = adPostPbData;
        this.gGT.startLoad(adPostPbData.portrait, 17, false);
        this.fSC.setText(adPostPbData.recommend);
        this.gGQ.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.gGR.setVisibility(8);
        } else {
            this.gGR.setVisibility(0);
            this.gGR.setText(adPostPbData.desc);
        }
        this.gGS.setText(adPostPbData.buttonText);
        this.gGU.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.gGT.setRadius(l.t(getContext(), d.e.ds32));
            this.gGS.setVisibility(8);
            this.gER.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.gER.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.gGV = advertAppInfo.aKK;
                DownloadData c = c(advertAppInfo, this.position);
                c.setStatus(ApkDownloadView.getStatus(c));
                this.gER.setData(c);
                return;
            }
            return;
        }
        this.gGT.setRadius(0);
        this.gER.setVisibility(8);
        this.gGS.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.a.d
    public void a(AdPostPbData adPostPbData, int i) {
        aj.t(this.rootView, d.C0140d.cp_bg_line_d);
        aj.t(this.divider, d.C0140d.cp_bg_line_e);
        aj.r(this.fSC, d.C0140d.cp_cont_b);
        aj.r(this.gGU, d.C0140d.cp_cont_j);
        aj.r(this.gGQ, d.C0140d.cp_cont_b);
        aj.r(this.gGR, d.C0140d.cp_cont_j);
        aj.r(this.gGS, d.C0140d.cp_link_tip_a);
        aj.s(this.gGS, d.f.feed_ad_progress_button_bg);
        this.gER.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.a.d
    protected View aPT() {
        MessageManager.getInstance().registerListener(this.gEh);
        this.gEh.setTag(this.aRR.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(d.h.post_ad_pb_banner_card, (ViewGroup) null);
        this.gGT = (TbImageView) this.rootView.findViewById(d.g.image);
        this.gGS = (TextView) this.rootView.findViewById(d.g.action_button);
        this.fSC = (TextView) this.rootView.findViewById(d.g.recommend_title);
        this.gGQ = (TextView) this.rootView.findViewById(d.g.ad_title);
        this.gGR = (TextView) this.rootView.findViewById(d.g.ad_description);
        this.gGU = (TextView) this.rootView.findViewById(d.g.ad_tag);
        this.divider = this.rootView.findViewById(d.g.divider);
        this.gER = (ApkDownloadView) this.rootView.findViewById(d.g.ad_download);
        this.gER.p(this.aRR.getUniqueId());
        this.rootView.setOnClickListener(this.cVJ);
        this.gGS.setOnClickListener(this.cVJ);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.aKK);
        downloadData.setUrl(advertAppInfo.aKJ);
        downloadData.setName(advertAppInfo.aKG);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.g.b.h(advertAppInfo.aKF, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.DI();
            this.mPermissionJudgePolicy.c(this.aRR.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.v(this.aRR.getPageActivity()) && this.fbD != null) {
                this.fbD.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.s(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.ox()) {
                l.showToast(this.aRR.getPageActivity(), d.j.neterror);
            } else if (advertAppInfo.xK()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.aRR.getString(d.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aRR.getPageActivity());
                aVar.dk(str);
                aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.c.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.a(advertAppInfo, i, c.this.gER);
                        aVar2.dismiss();
                    }
                });
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.c.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.aRR).AU();
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
                        g.e(advertAppInfo);
                        apkDownloadView.t(c);
                        return;
                    }
                    return;
                case 2:
                case 4:
                default:
                    return;
                case 3:
                    s.ao(this.aRR.getPageActivity(), advertAppInfo.aKK);
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
        private AdvertAppInfo gGY;

        public a(AdvertAppInfo advertAppInfo) {
            this.gGY = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.ox()) {
                c.this.aRR.showToast(d.j.neterror);
                return;
            }
            boolean z = view == c.this.gER;
            if (this.gGY != null) {
                int h = com.baidu.adp.lib.g.b.h(this.gGY.adPosition, -1);
                int status = ApkDownloadView.getStatus(c.this.c(this.gGY, h));
                if ((6 != status && 7 != status) || !j.oJ() || j.oK()) {
                    c.this.a(this.gGY, h, c.this.gER, z);
                    if (c.this.fbC != null) {
                        c.this.fbC.b(3, null);
                        return;
                    }
                    return;
                }
                c.this.showDownloadAppDialog(this.gGY, h, true, this.gGY.aKR != null ? this.gGY.aKR.aLc : "");
            }
        }
    }
}
