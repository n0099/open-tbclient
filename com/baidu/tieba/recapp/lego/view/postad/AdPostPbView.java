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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.download.g;
import com.baidu.tieba.recapp.lego.model.AdPostPbData;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
/* loaded from: classes3.dex */
public class AdPostPbView extends PostAdBaseView<AdPostPbData> {
    protected View.OnClickListener cnk;
    private View divider;
    protected CustomMessageListener fZY;
    private TextView fnK;
    private ApkDownloadView gaI;
    private TextView gcR;
    private TextView gcS;
    private TextView gcT;
    private TbImageView gcU;
    private TextView gcV;
    private String gcW;
    private AdPostPbData gcX;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    private View rootView;

    public AdPostPbView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.cnk = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (AdPostPbView.this.gcX != null) {
                    int e = s.e(AdPostPbView.this.mContext, AdPostPbView.this.gcX.scheme);
                    if (AdPostPbView.this.exr != null) {
                        AdPostPbView.this.exr.b(e, null);
                    }
                }
            }
        };
        this.fZY = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdPostPbView.this.gcW) && AdPostPbView.this.gcW.equals(downloadData.getId())) {
                    AdPostPbView.this.gaI.u(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData) {
        this.gcX = adPostPbData;
        this.gcU.startLoad(adPostPbData.portrait, 17, false);
        this.fnK.setText(adPostPbData.recommend);
        this.gcR.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.gcS.setVisibility(8);
        } else {
            this.gcS.setVisibility(0);
            this.gcS.setText(adPostPbData.desc);
        }
        this.gcT.setText(adPostPbData.buttonText);
        this.gcV.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.gcU.setRadius(l.e(getContext(), d.e.ds32));
            this.gcT.setVisibility(8);
            this.gaI.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.gaI.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.gcW = advertAppInfo.VQ;
                DownloadData c = c(advertAppInfo, this.position);
                c.setStatus(ApkDownloadView.getStatus(c));
                this.gaI.setData(c);
                return;
            }
            return;
        }
        this.gcU.setRadius(0);
        this.gaI.setVisibility(8);
        this.gcT.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData, int i) {
        ak.j(this.rootView, d.C0126d.cp_bg_line_d);
        ak.j(this.divider, d.C0126d.cp_bg_line_e);
        ak.h(this.fnK, d.C0126d.cp_cont_b);
        ak.h(this.gcV, d.C0126d.cp_cont_j);
        ak.h(this.gcR, d.C0126d.cp_cont_b);
        ak.h(this.gcS, d.C0126d.cp_cont_j);
        ak.h(this.gcT, d.C0126d.cp_link_tip_a);
        ak.i(this.gcT, d.f.feed_ad_progress_button_bg);
        this.gaI.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View aKT() {
        MessageManager.getInstance().registerListener(this.fZY);
        this.fZY.setTag(this.mContext.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(d.i.post_ad_pb_banner_card, (ViewGroup) null);
        this.gcU = (TbImageView) this.rootView.findViewById(d.g.image);
        this.gcT = (TextView) this.rootView.findViewById(d.g.action_button);
        this.fnK = (TextView) this.rootView.findViewById(d.g.recommend_title);
        this.gcR = (TextView) this.rootView.findViewById(d.g.ad_title);
        this.gcS = (TextView) this.rootView.findViewById(d.g.ad_description);
        this.gcV = (TextView) this.rootView.findViewById(d.g.ad_tag);
        this.divider = this.rootView.findViewById(d.g.divider);
        this.gaI = (ApkDownloadView) this.rootView.findViewById(d.g.ad_download);
        this.gaI.p(this.mContext.getUniqueId());
        this.rootView.setOnClickListener(this.cnk);
        this.gcT.setOnClickListener(this.cnk);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.VQ);
        downloadData.setUrl(advertAppInfo.VP);
        downloadData.setName(advertAppInfo.VM);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.g(advertAppInfo.VL, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.wt();
            this.mPermissionJudgePolicy.c(this.mContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.v(this.mContext.getPageActivity()) && this.exs != null) {
                this.exs.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.s(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.gD()) {
                l.showToast(this.mContext.getPageActivity(), d.k.neterror);
            } else if (advertAppInfo.qs()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(d.k.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.dc(str);
                aVar.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdPostPbView.this.a(advertAppInfo, i, AdPostPbView.this.gaI);
                        aVar2.dismiss();
                    }
                });
                aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.mContext).tC();
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
                    s.aj(this.mContext.getPageActivity(), advertAppInfo.VQ);
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
        private AdvertAppInfo gcZ;

        public a(AdvertAppInfo advertAppInfo) {
            this.gcZ = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (!j.gD()) {
                AdPostPbView.this.mContext.showToast(d.k.neterror);
                return;
            }
            boolean z = view2 == AdPostPbView.this.gaI;
            if (this.gcZ != null) {
                int g = b.g(this.gcZ.adPosition, -1);
                int status = ApkDownloadView.getStatus(AdPostPbView.this.c(this.gcZ, g));
                if ((6 != status && 7 != status) || !j.gP() || j.gQ()) {
                    AdPostPbView.this.a(this.gcZ, g, AdPostPbView.this.gaI, z);
                    if (AdPostPbView.this.exr != null) {
                        AdPostPbView.this.exr.b(3, null);
                        return;
                    }
                    return;
                }
                AdPostPbView.this.showDownloadAppDialog(this.gcZ, g, true, this.gcZ.VX != null ? this.gcZ.VX.Wi : "");
            }
        }
    }
}
