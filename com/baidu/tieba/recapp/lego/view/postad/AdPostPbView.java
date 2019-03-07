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
    protected View.OnClickListener eiw;
    private TextView huR;
    private ApkDownloadView ijN;
    protected CustomMessageListener ijd;
    private TextView ima;
    private TextView imb;
    private TextView imc;
    private TbImageView imd;
    private TextView ime;
    private String imf;
    private AdPostPbData imh;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    private View rootView;

    public AdPostPbView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eiw = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostPbView.this.imh != null) {
                    int f = s.f(AdPostPbView.this.mContext, AdPostPbView.this.imh.scheme);
                    if (AdPostPbView.this.gHy != null) {
                        AdPostPbView.this.gHy.b(f, null);
                    }
                }
            }
        };
        this.ijd = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdPostPbView.this.imf) && AdPostPbView.this.imf.equals(downloadData.getId())) {
                    AdPostPbView.this.ijN.s(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData) {
        this.imh = adPostPbData;
        this.imd.startLoad(adPostPbData.portrait, 17, false);
        this.huR.setText(adPostPbData.recommend);
        this.ima.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.imb.setVisibility(8);
        } else {
            this.imb.setVisibility(0);
            this.imb.setText(adPostPbData.desc);
        }
        this.imc.setText(adPostPbData.buttonText);
        this.ime.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.imd.setRadius(l.h(getContext(), d.e.ds32));
            this.imc.setVisibility(8);
            this.ijN.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.ijN.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.imf = advertAppInfo.bwF;
                DownloadData c = c(advertAppInfo, this.position);
                c.setStatus(ApkDownloadView.getStatus(c));
                this.ijN.setData(c);
                return;
            }
            return;
        }
        this.imd.setRadius(0);
        this.ijN.setVisibility(8);
        this.imc.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData, int i) {
        al.l(this.rootView, d.C0236d.cp_bg_line_d);
        al.l(this.divider, d.C0236d.cp_bg_line_e);
        al.j(this.huR, d.C0236d.cp_cont_b);
        al.j(this.ime, d.C0236d.cp_cont_j);
        al.j(this.ima, d.C0236d.cp_cont_b);
        al.j(this.imb, d.C0236d.cp_cont_j);
        al.j(this.imc, d.C0236d.cp_link_tip_a);
        al.k(this.imc, d.f.feed_ad_progress_button_bg);
        this.ijN.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View bAd() {
        MessageManager.getInstance().registerListener(this.ijd);
        this.ijd.setTag(this.mContext.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(d.h.post_ad_pb_banner_card, (ViewGroup) null);
        this.imd = (TbImageView) this.rootView.findViewById(d.g.image);
        this.imc = (TextView) this.rootView.findViewById(d.g.action_button);
        this.huR = (TextView) this.rootView.findViewById(d.g.recommend_title);
        this.ima = (TextView) this.rootView.findViewById(d.g.ad_title);
        this.imb = (TextView) this.rootView.findViewById(d.g.ad_description);
        this.ime = (TextView) this.rootView.findViewById(d.g.ad_tag);
        this.divider = this.rootView.findViewById(d.g.divider);
        this.ijN = (ApkDownloadView) this.rootView.findViewById(d.g.ad_download);
        this.ijN.q(this.mContext.getUniqueId());
        this.rootView.setOnClickListener(this.eiw);
        this.imc.setOnClickListener(this.eiw);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.bwF);
        downloadData.setUrl(advertAppInfo.bwE);
        downloadData.setName(advertAppInfo.bwC);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.l(advertAppInfo.bwB, 0));
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
                        AdPostPbView.this.a(advertAppInfo, i, AdPostPbView.this.ijN);
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
                    s.aS(this.mContext.getPageActivity(), advertAppInfo.bwF);
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
        private AdvertAppInfo imj;

        public a(AdvertAppInfo advertAppInfo) {
            this.imj = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.kM()) {
                AdPostPbView.this.mContext.showToast(d.j.neterror);
                return;
            }
            boolean z = view == AdPostPbView.this.ijN;
            if (this.imj != null) {
                int l = b.l(this.imj.adPosition, -1);
                int status = ApkDownloadView.getStatus(AdPostPbView.this.c(this.imj, l));
                if ((6 != status && 7 != status) || !j.kY() || j.kZ()) {
                    AdPostPbView.this.a(this.imj, l, AdPostPbView.this.ijN, z);
                    if (AdPostPbView.this.gHy != null) {
                        AdPostPbView.this.gHy.b(3, null);
                        return;
                    }
                    return;
                }
                AdPostPbView.this.showDownloadAppDialog(this.imj, l, true, this.imj.bwL != null ? this.imj.bwL.bwX : "");
            }
        }
    }
}
