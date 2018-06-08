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
    protected View.OnClickListener cvP;
    private View divider;
    private TextView fze;
    protected CustomMessageListener glq;
    private ApkDownloadView gma;
    private TextView goj;
    private TextView gok;
    private TextView gol;
    private TbImageView gom;
    private TextView gon;
    private String goo;
    private AdPostPbData gop;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    private View rootView;

    public AdPostPbView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.cvP = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostPbView.this.gop != null) {
                    int e = s.e(AdPostPbView.this.mContext, AdPostPbView.this.gop.scheme);
                    if (AdPostPbView.this.eIN != null) {
                        AdPostPbView.this.eIN.b(e, null);
                    }
                }
            }
        };
        this.glq = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdPostPbView.this.goo) && AdPostPbView.this.goo.equals(downloadData.getId())) {
                    AdPostPbView.this.gma.u(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData) {
        this.gop = adPostPbData;
        this.gom.startLoad(adPostPbData.portrait, 17, false);
        this.fze.setText(adPostPbData.recommend);
        this.goj.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.gok.setVisibility(8);
        } else {
            this.gok.setVisibility(0);
            this.gok.setText(adPostPbData.desc);
        }
        this.gol.setText(adPostPbData.buttonText);
        this.gon.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.gom.setRadius(l.e(getContext(), d.e.ds32));
            this.gol.setVisibility(8);
            this.gma.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.gma.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.goo = advertAppInfo.adQ;
                DownloadData c = c(advertAppInfo, this.position);
                c.setStatus(ApkDownloadView.getStatus(c));
                this.gma.setData(c);
                return;
            }
            return;
        }
        this.gom.setRadius(0);
        this.gma.setVisibility(8);
        this.gol.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData, int i) {
        al.j(this.rootView, d.C0141d.cp_bg_line_d);
        al.j(this.divider, d.C0141d.cp_bg_line_e);
        al.h(this.fze, d.C0141d.cp_cont_b);
        al.h(this.gon, d.C0141d.cp_cont_j);
        al.h(this.goj, d.C0141d.cp_cont_b);
        al.h(this.gok, d.C0141d.cp_cont_j);
        al.h(this.gol, d.C0141d.cp_link_tip_a);
        al.i(this.gol, d.f.feed_ad_progress_button_bg);
        this.gma.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View aPQ() {
        MessageManager.getInstance().registerListener(this.glq);
        this.glq.setTag(this.mContext.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(d.i.post_ad_pb_banner_card, (ViewGroup) null);
        this.gom = (TbImageView) this.rootView.findViewById(d.g.image);
        this.gol = (TextView) this.rootView.findViewById(d.g.action_button);
        this.fze = (TextView) this.rootView.findViewById(d.g.recommend_title);
        this.goj = (TextView) this.rootView.findViewById(d.g.ad_title);
        this.gok = (TextView) this.rootView.findViewById(d.g.ad_description);
        this.gon = (TextView) this.rootView.findViewById(d.g.ad_tag);
        this.divider = this.rootView.findViewById(d.g.divider);
        this.gma = (ApkDownloadView) this.rootView.findViewById(d.g.ad_download);
        this.gma.q(this.mContext.getUniqueId());
        this.rootView.setOnClickListener(this.cvP);
        this.gol.setOnClickListener(this.cvP);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.adQ);
        downloadData.setUrl(advertAppInfo.adP);
        downloadData.setName(advertAppInfo.adM);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.g(advertAppInfo.adL, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.zU();
            this.mPermissionJudgePolicy.c(this.mContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.u(this.mContext.getPageActivity()) && this.eIO != null) {
                this.eIO.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.s(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.jr()) {
                l.showToast(this.mContext.getPageActivity(), d.k.neterror);
            } else if (advertAppInfo.tO()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(d.k.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.dB(str);
                aVar.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdPostPbView.this.a(advertAppInfo, i, AdPostPbView.this.gma);
                        aVar2.dismiss();
                    }
                });
                aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.mContext).xa();
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
                        apkDownloadView.t(c);
                        return;
                    }
                    return;
                case 2:
                case 4:
                default:
                    return;
                case 3:
                    s.al(this.mContext.getPageActivity(), advertAppInfo.adQ);
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
        private AdvertAppInfo gor;

        public a(AdvertAppInfo advertAppInfo) {
            this.gor = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.jr()) {
                AdPostPbView.this.mContext.showToast(d.k.neterror);
                return;
            }
            boolean z = view == AdPostPbView.this.gma;
            if (this.gor != null) {
                int g = b.g(this.gor.adPosition, -1);
                int status = ApkDownloadView.getStatus(AdPostPbView.this.c(this.gor, g));
                if ((6 != status && 7 != status) || !j.jD() || j.jE()) {
                    AdPostPbView.this.a(this.gor, g, AdPostPbView.this.gma, z);
                    if (AdPostPbView.this.eIN != null) {
                        AdPostPbView.this.eIN.b(3, null);
                        return;
                    }
                    return;
                }
                AdPostPbView.this.showDownloadAppDialog(this.gor, g, true, this.gor.adX != null ? this.gor.adX.aej : "");
            }
        }
    }
}
