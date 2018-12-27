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
    protected View.OnClickListener cVj;
    private View divider;
    protected CustomMessageListener gQw;
    private ApkDownloadView gRg;
    private TextView gTs;
    private TextView gTt;
    private TextView gTu;
    private TbImageView gTv;
    private TextView gTw;
    private String gTx;
    private AdPostPbData gTy;
    private TextView gdE;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    private View rootView;

    public AdPostPbView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.cVj = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostPbView.this.gTy != null) {
                    int e = s.e(AdPostPbView.this.mContext, AdPostPbView.this.gTy.scheme);
                    if (AdPostPbView.this.fqA != null) {
                        AdPostPbView.this.fqA.b(e, null);
                    }
                }
            }
        };
        this.gQw = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdPostPbView.this.gTx) && AdPostPbView.this.gTx.equals(downloadData.getId())) {
                    AdPostPbView.this.gRg.s(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData) {
        this.gTy = adPostPbData;
        this.gTv.startLoad(adPostPbData.portrait, 17, false);
        this.gdE.setText(adPostPbData.recommend);
        this.gTs.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.gTt.setVisibility(8);
        } else {
            this.gTt.setVisibility(0);
            this.gTt.setText(adPostPbData.desc);
        }
        this.gTu.setText(adPostPbData.buttonText);
        this.gTw.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.gTv.setRadius(l.h(getContext(), e.C0210e.ds32));
            this.gTu.setVisibility(8);
            this.gRg.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.gRg.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.gTx = advertAppInfo.apv;
                DownloadData c = c(advertAppInfo, this.position);
                c.setStatus(ApkDownloadView.getStatus(c));
                this.gRg.setData(c);
                return;
            }
            return;
        }
        this.gTv.setRadius(0);
        this.gRg.setVisibility(8);
        this.gTu.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData, int i) {
        al.j(this.rootView, e.d.cp_bg_line_d);
        al.j(this.divider, e.d.cp_bg_line_e);
        al.h(this.gdE, e.d.cp_cont_b);
        al.h(this.gTw, e.d.cp_cont_j);
        al.h(this.gTs, e.d.cp_cont_b);
        al.h(this.gTt, e.d.cp_cont_j);
        al.h(this.gTu, e.d.cp_link_tip_a);
        al.i(this.gTu, e.f.feed_ad_progress_button_bg);
        this.gRg.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View aYY() {
        MessageManager.getInstance().registerListener(this.gQw);
        this.gQw.setTag(this.mContext.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(e.h.post_ad_pb_banner_card, (ViewGroup) null);
        this.gTv = (TbImageView) this.rootView.findViewById(e.g.image);
        this.gTu = (TextView) this.rootView.findViewById(e.g.action_button);
        this.gdE = (TextView) this.rootView.findViewById(e.g.recommend_title);
        this.gTs = (TextView) this.rootView.findViewById(e.g.ad_title);
        this.gTt = (TextView) this.rootView.findViewById(e.g.ad_description);
        this.gTw = (TextView) this.rootView.findViewById(e.g.ad_tag);
        this.divider = this.rootView.findViewById(e.g.divider);
        this.gRg = (ApkDownloadView) this.rootView.findViewById(e.g.ad_download);
        this.gRg.p(this.mContext.getUniqueId());
        this.rootView.setOnClickListener(this.cVj);
        this.gTu.setOnClickListener(this.cVj);
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
            if (!this.mPermissionJudgePolicy.A(this.mContext.getPageActivity()) && this.fqB != null) {
                this.fqB.b(advertAppInfo, i);
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
                        AdPostPbView.this.a(advertAppInfo, i, AdPostPbView.this.gRg);
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
        private AdvertAppInfo gTA;

        public a(AdvertAppInfo advertAppInfo) {
            this.gTA = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.kK()) {
                AdPostPbView.this.mContext.showToast(e.j.neterror);
                return;
            }
            boolean z = view == AdPostPbView.this.gRg;
            if (this.gTA != null) {
                int l = b.l(this.gTA.adPosition, -1);
                int status = ApkDownloadView.getStatus(AdPostPbView.this.c(this.gTA, l));
                if ((6 != status && 7 != status) || !j.kV() || j.kW()) {
                    AdPostPbView.this.a(this.gTA, l, AdPostPbView.this.gRg, z);
                    if (AdPostPbView.this.fqA != null) {
                        AdPostPbView.this.fqA.b(3, null);
                        return;
                    }
                    return;
                }
                AdPostPbView.this.showDownloadAppDialog(this.gTA, l, true, this.gTA.apB != null ? this.gTA.apB.apN : "");
            }
        }
    }
}
