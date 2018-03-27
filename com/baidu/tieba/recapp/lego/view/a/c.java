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
    protected View.OnClickListener cVA;
    private View divider;
    private TextView fSH;
    private ApkDownloadView gES;
    protected CustomMessageListener gEi;
    private TextView gGR;
    private TextView gGS;
    private TextView gGT;
    private TbImageView gGU;
    private TextView gGV;
    private String gGW;
    private AdPostPbData gGX;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    private View rootView;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.cVA = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.gGX != null) {
                    int f = s.f(c.this.aRI, c.this.gGX.scheme);
                    if (c.this.fbE != null) {
                        c.this.fbE.b(f, null);
                    }
                }
            }
        };
        this.gEi = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.a.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(c.this.gGW) && c.this.gGW.equals(downloadData.getId())) {
                    c.this.gES.u(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.a.d
    public void a(AdPostPbData adPostPbData) {
        this.gGX = adPostPbData;
        this.gGU.startLoad(adPostPbData.portrait, 17, false);
        this.fSH.setText(adPostPbData.recommend);
        this.gGR.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.gGS.setVisibility(8);
        } else {
            this.gGS.setVisibility(0);
            this.gGS.setText(adPostPbData.desc);
        }
        this.gGT.setText(adPostPbData.buttonText);
        this.gGV.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.gGU.setRadius(l.t(getContext(), d.e.ds32));
            this.gGT.setVisibility(8);
            this.gES.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.gES.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.gGW = advertAppInfo.aKA;
                DownloadData c = c(advertAppInfo, this.position);
                c.setStatus(ApkDownloadView.getStatus(c));
                this.gES.setData(c);
                return;
            }
            return;
        }
        this.gGU.setRadius(0);
        this.gES.setVisibility(8);
        this.gGT.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.a.d
    public void a(AdPostPbData adPostPbData, int i) {
        aj.t(this.rootView, d.C0141d.cp_bg_line_d);
        aj.t(this.divider, d.C0141d.cp_bg_line_e);
        aj.r(this.fSH, d.C0141d.cp_cont_b);
        aj.r(this.gGV, d.C0141d.cp_cont_j);
        aj.r(this.gGR, d.C0141d.cp_cont_b);
        aj.r(this.gGS, d.C0141d.cp_cont_j);
        aj.r(this.gGT, d.C0141d.cp_link_tip_a);
        aj.s(this.gGT, d.f.feed_ad_progress_button_bg);
        this.gES.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.a.d
    protected View aPT() {
        MessageManager.getInstance().registerListener(this.gEi);
        this.gEi.setTag(this.aRI.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(d.h.post_ad_pb_banner_card, (ViewGroup) null);
        this.gGU = (TbImageView) this.rootView.findViewById(d.g.image);
        this.gGT = (TextView) this.rootView.findViewById(d.g.action_button);
        this.fSH = (TextView) this.rootView.findViewById(d.g.recommend_title);
        this.gGR = (TextView) this.rootView.findViewById(d.g.ad_title);
        this.gGS = (TextView) this.rootView.findViewById(d.g.ad_description);
        this.gGV = (TextView) this.rootView.findViewById(d.g.ad_tag);
        this.divider = this.rootView.findViewById(d.g.divider);
        this.gES = (ApkDownloadView) this.rootView.findViewById(d.g.ad_download);
        this.gES.p(this.aRI.getUniqueId());
        this.rootView.setOnClickListener(this.cVA);
        this.gGT.setOnClickListener(this.cVA);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.aKA);
        downloadData.setUrl(advertAppInfo.aKz);
        downloadData.setName(advertAppInfo.aKw);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.g.b.h(advertAppInfo.aKv, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.DI();
            this.mPermissionJudgePolicy.c(this.aRI.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.v(this.aRI.getPageActivity()) && this.fbF != null) {
                this.fbF.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.s(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.ox()) {
                l.showToast(this.aRI.getPageActivity(), d.j.neterror);
            } else if (advertAppInfo.xK()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.aRI.getString(d.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aRI.getPageActivity());
                aVar.dk(str);
                aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.c.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.a(advertAppInfo, i, c.this.gES);
                        aVar2.dismiss();
                    }
                });
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.c.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.aRI).AV();
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
                    s.ao(this.aRI.getPageActivity(), advertAppInfo.aKA);
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
        private AdvertAppInfo gGZ;

        public a(AdvertAppInfo advertAppInfo) {
            this.gGZ = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.ox()) {
                c.this.aRI.showToast(d.j.neterror);
                return;
            }
            boolean z = view == c.this.gES;
            if (this.gGZ != null) {
                int h = com.baidu.adp.lib.g.b.h(this.gGZ.adPosition, -1);
                int status = ApkDownloadView.getStatus(c.this.c(this.gGZ, h));
                if ((6 != status && 7 != status) || !j.oJ() || j.oK()) {
                    c.this.a(this.gGZ, h, c.this.gES, z);
                    if (c.this.fbE != null) {
                        c.this.fbE.b(3, null);
                        return;
                    }
                    return;
                }
                c.this.showDownloadAppDialog(this.gGZ, h, true, this.gGZ.aKH != null ? this.gGZ.aKH.aKS : "");
            }
        }
    }
}
