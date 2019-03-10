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
    private TextView huS;
    private ApkDownloadView ijO;
    protected CustomMessageListener ije;
    private TextView imb;
    private TextView imc;
    private TextView imd;
    private TbImageView ime;
    private TextView imf;
    private String imh;
    private AdPostPbData imi;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    private View rootView;

    public AdPostPbView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eiw = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostPbView.this.imi != null) {
                    int f = s.f(AdPostPbView.this.mContext, AdPostPbView.this.imi.scheme);
                    if (AdPostPbView.this.gHz != null) {
                        AdPostPbView.this.gHz.b(f, null);
                    }
                }
            }
        };
        this.ije = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdPostPbView.this.imh) && AdPostPbView.this.imh.equals(downloadData.getId())) {
                    AdPostPbView.this.ijO.s(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData) {
        this.imi = adPostPbData;
        this.ime.startLoad(adPostPbData.portrait, 17, false);
        this.huS.setText(adPostPbData.recommend);
        this.imb.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.imc.setVisibility(8);
        } else {
            this.imc.setVisibility(0);
            this.imc.setText(adPostPbData.desc);
        }
        this.imd.setText(adPostPbData.buttonText);
        this.imf.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.ime.setRadius(l.h(getContext(), d.e.ds32));
            this.imd.setVisibility(8);
            this.ijO.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.ijO.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.imh = advertAppInfo.bwF;
                DownloadData c = c(advertAppInfo, this.position);
                c.setStatus(ApkDownloadView.getStatus(c));
                this.ijO.setData(c);
                return;
            }
            return;
        }
        this.ime.setRadius(0);
        this.ijO.setVisibility(8);
        this.imd.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData, int i) {
        al.l(this.rootView, d.C0236d.cp_bg_line_d);
        al.l(this.divider, d.C0236d.cp_bg_line_e);
        al.j(this.huS, d.C0236d.cp_cont_b);
        al.j(this.imf, d.C0236d.cp_cont_j);
        al.j(this.imb, d.C0236d.cp_cont_b);
        al.j(this.imc, d.C0236d.cp_cont_j);
        al.j(this.imd, d.C0236d.cp_link_tip_a);
        al.k(this.imd, d.f.feed_ad_progress_button_bg);
        this.ijO.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View bAe() {
        MessageManager.getInstance().registerListener(this.ije);
        this.ije.setTag(this.mContext.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(d.h.post_ad_pb_banner_card, (ViewGroup) null);
        this.ime = (TbImageView) this.rootView.findViewById(d.g.image);
        this.imd = (TextView) this.rootView.findViewById(d.g.action_button);
        this.huS = (TextView) this.rootView.findViewById(d.g.recommend_title);
        this.imb = (TextView) this.rootView.findViewById(d.g.ad_title);
        this.imc = (TextView) this.rootView.findViewById(d.g.ad_description);
        this.imf = (TextView) this.rootView.findViewById(d.g.ad_tag);
        this.divider = this.rootView.findViewById(d.g.divider);
        this.ijO = (ApkDownloadView) this.rootView.findViewById(d.g.ad_download);
        this.ijO.q(this.mContext.getUniqueId());
        this.rootView.setOnClickListener(this.eiw);
        this.imd.setOnClickListener(this.eiw);
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
            if (!this.mPermissionJudgePolicy.Y(this.mContext.getPageActivity()) && this.gHA != null) {
                this.gHA.b(advertAppInfo, i);
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
                        AdPostPbView.this.a(advertAppInfo, i, AdPostPbView.this.ijO);
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
        private AdvertAppInfo imk;

        public a(AdvertAppInfo advertAppInfo) {
            this.imk = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.kM()) {
                AdPostPbView.this.mContext.showToast(d.j.neterror);
                return;
            }
            boolean z = view == AdPostPbView.this.ijO;
            if (this.imk != null) {
                int l = b.l(this.imk.adPosition, -1);
                int status = ApkDownloadView.getStatus(AdPostPbView.this.c(this.imk, l));
                if ((6 != status && 7 != status) || !j.kY() || j.kZ()) {
                    AdPostPbView.this.a(this.imk, l, AdPostPbView.this.ijO, z);
                    if (AdPostPbView.this.gHz != null) {
                        AdPostPbView.this.gHz.b(3, null);
                        return;
                    }
                    return;
                }
                AdPostPbView.this.showDownloadAppDialog(this.imk, l, true, this.imk.bwL != null ? this.imk.bwL.bwX : "");
            }
        }
    }
}
