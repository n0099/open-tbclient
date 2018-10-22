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
    private TextView fSx;
    private ApkDownloadView gFX;
    protected CustomMessageListener gFn;
    private TextView gIj;
    private TextView gIk;
    private TextView gIl;
    private TbImageView gIm;
    private TextView gIn;
    private String gIo;
    private AdPostPbData gIp;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    private View rootView;

    public AdPostPbView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.cKG = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostPbView.this.gIp != null) {
                    int e = s.e(AdPostPbView.this.mContext, AdPostPbView.this.gIp.scheme);
                    if (AdPostPbView.this.ffx != null) {
                        AdPostPbView.this.ffx.b(e, null);
                    }
                }
            }
        };
        this.gFn = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdPostPbView.this.gIo) && AdPostPbView.this.gIo.equals(downloadData.getId())) {
                    AdPostPbView.this.gFX.s(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData) {
        this.gIp = adPostPbData;
        this.gIm.startLoad(adPostPbData.portrait, 17, false);
        this.fSx.setText(adPostPbData.recommend);
        this.gIj.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.gIk.setVisibility(8);
        } else {
            this.gIk.setVisibility(0);
            this.gIk.setText(adPostPbData.desc);
        }
        this.gIl.setText(adPostPbData.buttonText);
        this.gIn.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.gIm.setRadius(l.h(getContext(), e.C0175e.ds32));
            this.gIl.setVisibility(8);
            this.gFX.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.gFX.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.gIo = advertAppInfo.alg;
                DownloadData c = c(advertAppInfo, this.position);
                c.setStatus(ApkDownloadView.getStatus(c));
                this.gFX.setData(c);
                return;
            }
            return;
        }
        this.gIm.setRadius(0);
        this.gFX.setVisibility(8);
        this.gIl.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData, int i) {
        al.j(this.rootView, e.d.cp_bg_line_d);
        al.j(this.divider, e.d.cp_bg_line_e);
        al.h(this.fSx, e.d.cp_cont_b);
        al.h(this.gIn, e.d.cp_cont_j);
        al.h(this.gIj, e.d.cp_cont_b);
        al.h(this.gIk, e.d.cp_cont_j);
        al.h(this.gIl, e.d.cp_link_tip_a);
        al.i(this.gIl, e.f.feed_ad_progress_button_bg);
        this.gFX.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View aWW() {
        MessageManager.getInstance().registerListener(this.gFn);
        this.gFn.setTag(this.mContext.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(e.h.post_ad_pb_banner_card, (ViewGroup) null);
        this.gIm = (TbImageView) this.rootView.findViewById(e.g.image);
        this.gIl = (TextView) this.rootView.findViewById(e.g.action_button);
        this.fSx = (TextView) this.rootView.findViewById(e.g.recommend_title);
        this.gIj = (TextView) this.rootView.findViewById(e.g.ad_title);
        this.gIk = (TextView) this.rootView.findViewById(e.g.ad_description);
        this.gIn = (TextView) this.rootView.findViewById(e.g.ad_tag);
        this.divider = this.rootView.findViewById(e.g.divider);
        this.gFX = (ApkDownloadView) this.rootView.findViewById(e.g.ad_download);
        this.gFX.p(this.mContext.getUniqueId());
        this.rootView.setOnClickListener(this.cKG);
        this.gIl.setOnClickListener(this.cKG);
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
            if (!this.mPermissionJudgePolicy.z(this.mContext.getPageActivity()) && this.ffy != null) {
                this.ffy.b(advertAppInfo, i);
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
                        AdPostPbView.this.a(advertAppInfo, i, AdPostPbView.this.gFX);
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
        private AdvertAppInfo gIr;

        public a(AdvertAppInfo advertAppInfo) {
            this.gIr = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.kM()) {
                AdPostPbView.this.mContext.showToast(e.j.neterror);
                return;
            }
            boolean z = view == AdPostPbView.this.gFX;
            if (this.gIr != null) {
                int l = b.l(this.gIr.adPosition, -1);
                int status = ApkDownloadView.getStatus(AdPostPbView.this.c(this.gIr, l));
                if ((6 != status && 7 != status) || !j.kX() || j.kY()) {
                    AdPostPbView.this.a(this.gIr, l, AdPostPbView.this.gFX, z);
                    if (AdPostPbView.this.ffx != null) {
                        AdPostPbView.this.ffx.b(3, null);
                        return;
                    }
                    return;
                }
                AdPostPbView.this.showDownloadAppDialog(this.gIr, l, true, this.gIr.aln != null ? this.gIr.aln.alz : "");
            }
        }
    }
}
