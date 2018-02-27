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
    protected View.OnClickListener cVx;
    private View divider;
    private TextView fSr;
    protected CustomMessageListener gDS;
    private ApkDownloadView gEC;
    private TextView gGB;
    private TextView gGC;
    private TextView gGD;
    private TbImageView gGE;
    private TextView gGF;
    private String gGG;
    private AdPostPbData gGH;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    private View rootView;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.cVx = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.gGH != null) {
                    int f = s.f(c.this.aRG, c.this.gGH.scheme);
                    if (c.this.fbq != null) {
                        c.this.fbq.b(f, null);
                    }
                }
            }
        };
        this.gDS = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.a.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(c.this.gGG) && c.this.gGG.equals(downloadData.getId())) {
                    c.this.gEC.u(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.a.d
    public void a(AdPostPbData adPostPbData) {
        this.gGH = adPostPbData;
        this.gGE.startLoad(adPostPbData.portrait, 17, false);
        this.fSr.setText(adPostPbData.recommend);
        this.gGB.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.gGC.setVisibility(8);
        } else {
            this.gGC.setVisibility(0);
            this.gGC.setText(adPostPbData.desc);
        }
        this.gGD.setText(adPostPbData.buttonText);
        this.gGF.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.gGE.setRadius(l.t(getContext(), d.e.ds32));
            this.gGD.setVisibility(8);
            this.gEC.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.gEC.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.gGG = advertAppInfo.aKz;
                DownloadData c = c(advertAppInfo, this.position);
                c.setStatus(ApkDownloadView.getStatus(c));
                this.gEC.setData(c);
                return;
            }
            return;
        }
        this.gGE.setRadius(0);
        this.gEC.setVisibility(8);
        this.gGD.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.a.d
    public void a(AdPostPbData adPostPbData, int i) {
        aj.t(this.rootView, d.C0141d.cp_bg_line_d);
        aj.t(this.divider, d.C0141d.cp_bg_line_e);
        aj.r(this.fSr, d.C0141d.cp_cont_b);
        aj.r(this.gGF, d.C0141d.cp_cont_j);
        aj.r(this.gGB, d.C0141d.cp_cont_b);
        aj.r(this.gGC, d.C0141d.cp_cont_j);
        aj.r(this.gGD, d.C0141d.cp_link_tip_a);
        aj.s(this.gGD, d.f.feed_ad_progress_button_bg);
        this.gEC.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.a.d
    protected View aPS() {
        MessageManager.getInstance().registerListener(this.gDS);
        this.gDS.setTag(this.aRG.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(d.h.post_ad_pb_banner_card, (ViewGroup) null);
        this.gGE = (TbImageView) this.rootView.findViewById(d.g.image);
        this.gGD = (TextView) this.rootView.findViewById(d.g.action_button);
        this.fSr = (TextView) this.rootView.findViewById(d.g.recommend_title);
        this.gGB = (TextView) this.rootView.findViewById(d.g.ad_title);
        this.gGC = (TextView) this.rootView.findViewById(d.g.ad_description);
        this.gGF = (TextView) this.rootView.findViewById(d.g.ad_tag);
        this.divider = this.rootView.findViewById(d.g.divider);
        this.gEC = (ApkDownloadView) this.rootView.findViewById(d.g.ad_download);
        this.gEC.p(this.aRG.getUniqueId());
        this.rootView.setOnClickListener(this.cVx);
        this.gGD.setOnClickListener(this.cVx);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.aKz);
        downloadData.setUrl(advertAppInfo.aKy);
        downloadData.setName(advertAppInfo.aKv);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.g.b.h(advertAppInfo.aKu, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.DH();
            this.mPermissionJudgePolicy.c(this.aRG.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.v(this.aRG.getPageActivity()) && this.fbr != null) {
                this.fbr.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.s(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.ox()) {
                l.showToast(this.aRG.getPageActivity(), d.j.neterror);
            } else if (advertAppInfo.xK()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.aRG.getString(d.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aRG.getPageActivity());
                aVar.dk(str);
                aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.c.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.a(advertAppInfo, i, c.this.gEC);
                        aVar2.dismiss();
                    }
                });
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.c.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.aRG).AU();
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
                    s.ao(this.aRG.getPageActivity(), advertAppInfo.aKz);
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
        private AdvertAppInfo gGJ;

        public a(AdvertAppInfo advertAppInfo) {
            this.gGJ = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.ox()) {
                c.this.aRG.showToast(d.j.neterror);
                return;
            }
            boolean z = view == c.this.gEC;
            if (this.gGJ != null) {
                int h = com.baidu.adp.lib.g.b.h(this.gGJ.adPosition, -1);
                int status = ApkDownloadView.getStatus(c.this.c(this.gGJ, h));
                if ((6 != status && 7 != status) || !j.oJ() || j.oK()) {
                    c.this.a(this.gGJ, h, c.this.gEC, z);
                    if (c.this.fbq != null) {
                        c.this.fbq.b(3, null);
                        return;
                    }
                    return;
                }
                c.this.showDownloadAppDialog(this.gGJ, h, true, this.gGJ.aKG != null ? this.gGJ.aKG.aKR : "");
            }
        }
    }
}
