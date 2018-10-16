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
    protected View.OnClickListener cKG;
    private View divider;
    private TextView fSw;
    private ApkDownloadView gFW;
    protected CustomMessageListener gFm;
    private TextView gIi;
    private TextView gIj;
    private TextView gIk;
    private TbImageView gIl;
    private TextView gIm;
    private String gIn;
    private AdPostPbData gIo;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    private View rootView;

    public AdPostPbView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.cKG = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostPbView.this.gIo != null) {
                    int e = s.e(AdPostPbView.this.mContext, AdPostPbView.this.gIo.scheme);
                    if (AdPostPbView.this.ffw != null) {
                        AdPostPbView.this.ffw.b(e, null);
                    }
                }
            }
        };
        this.gFm = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdPostPbView.this.gIn) && AdPostPbView.this.gIn.equals(downloadData.getId())) {
                    AdPostPbView.this.gFW.s(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData) {
        this.gIo = adPostPbData;
        this.gIl.startLoad(adPostPbData.portrait, 17, false);
        this.fSw.setText(adPostPbData.recommend);
        this.gIi.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.gIj.setVisibility(8);
        } else {
            this.gIj.setVisibility(0);
            this.gIj.setText(adPostPbData.desc);
        }
        this.gIk.setText(adPostPbData.buttonText);
        this.gIm.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.gIl.setRadius(l.h(getContext(), e.C0175e.ds32));
            this.gIk.setVisibility(8);
            this.gFW.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.gFW.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.gIn = advertAppInfo.alg;
                DownloadData c = c(advertAppInfo, this.position);
                c.setStatus(ApkDownloadView.getStatus(c));
                this.gFW.setData(c);
                return;
            }
            return;
        }
        this.gIl.setRadius(0);
        this.gFW.setVisibility(8);
        this.gIk.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData, int i) {
        al.j(this.rootView, e.d.cp_bg_line_d);
        al.j(this.divider, e.d.cp_bg_line_e);
        al.h(this.fSw, e.d.cp_cont_b);
        al.h(this.gIm, e.d.cp_cont_j);
        al.h(this.gIi, e.d.cp_cont_b);
        al.h(this.gIj, e.d.cp_cont_j);
        al.h(this.gIk, e.d.cp_link_tip_a);
        al.i(this.gIk, e.f.feed_ad_progress_button_bg);
        this.gFW.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View aWW() {
        MessageManager.getInstance().registerListener(this.gFm);
        this.gFm.setTag(this.mContext.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(e.h.post_ad_pb_banner_card, (ViewGroup) null);
        this.gIl = (TbImageView) this.rootView.findViewById(e.g.image);
        this.gIk = (TextView) this.rootView.findViewById(e.g.action_button);
        this.fSw = (TextView) this.rootView.findViewById(e.g.recommend_title);
        this.gIi = (TextView) this.rootView.findViewById(e.g.ad_title);
        this.gIj = (TextView) this.rootView.findViewById(e.g.ad_description);
        this.gIm = (TextView) this.rootView.findViewById(e.g.ad_tag);
        this.divider = this.rootView.findViewById(e.g.divider);
        this.gFW = (ApkDownloadView) this.rootView.findViewById(e.g.ad_download);
        this.gFW.p(this.mContext.getUniqueId());
        this.rootView.setOnClickListener(this.cKG);
        this.gIk.setOnClickListener(this.cKG);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.alg);
        downloadData.setUrl(advertAppInfo.alf);
        downloadData.setName(advertAppInfo.alc);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.l(advertAppInfo.alb, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.Di();
            this.mPermissionJudgePolicy.c(this.mContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.z(this.mContext.getPageActivity()) && this.ffx != null) {
                this.ffx.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.p(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.kM()) {
                l.showToast(this.mContext.getPageActivity(), e.j.neterror);
            } else if (advertAppInfo.wR()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(e.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.ej(str);
                aVar.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdPostPbView.this.a(advertAppInfo, i, AdPostPbView.this.gFW);
                        aVar2.dismiss();
                    }
                });
                aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.mContext).Au();
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
                    s.aF(this.mContext.getPageActivity(), advertAppInfo.alg);
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
        private AdvertAppInfo gIq;

        public a(AdvertAppInfo advertAppInfo) {
            this.gIq = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.kM()) {
                AdPostPbView.this.mContext.showToast(e.j.neterror);
                return;
            }
            boolean z = view == AdPostPbView.this.gFW;
            if (this.gIq != null) {
                int l = b.l(this.gIq.adPosition, -1);
                int status = ApkDownloadView.getStatus(AdPostPbView.this.c(this.gIq, l));
                if ((6 != status && 7 != status) || !j.kX() || j.kY()) {
                    AdPostPbView.this.a(this.gIq, l, AdPostPbView.this.gFW, z);
                    if (AdPostPbView.this.ffw != null) {
                        AdPostPbView.this.ffw.b(3, null);
                        return;
                    }
                    return;
                }
                AdPostPbView.this.showDownloadAppDialog(this.gIq, l, true, this.gIq.aln != null ? this.gIq.aln.alz : "");
            }
        }
    }
}
