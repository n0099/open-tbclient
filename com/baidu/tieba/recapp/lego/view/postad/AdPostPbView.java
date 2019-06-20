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
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.download.g;
import com.baidu.tieba.recapp.lego.model.AdPostPbData;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
/* loaded from: classes3.dex */
public class AdPostPbView extends PostAdBaseView<AdPostPbData> {
    private View divider;
    protected View.OnClickListener exT;
    private TextView hMf;
    protected CustomMessageListener iBz;
    private ApkDownloadView iCj;
    private TextView iEA;
    private String iEB;
    private AdPostPbData iEC;
    private TextView iEw;
    private TextView iEx;
    private TextView iEy;
    private TbImageView iEz;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    private View rootView;

    public AdPostPbView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.exT = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostPbView.this.iEC != null) {
                    int e = s.e(AdPostPbView.this.mContext, AdPostPbView.this.iEC.scheme);
                    if (AdPostPbView.this.gYK != null) {
                        AdPostPbView.this.gYK.b(e, null);
                    }
                }
            }
        };
        this.iBz = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdPostPbView.this.iEB) && AdPostPbView.this.iEB.equals(downloadData.getId())) {
                    AdPostPbView.this.iCj.s(downloadData);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData) {
        this.iEC = adPostPbData;
        this.iEz.startLoad(adPostPbData.portrait, 17, false);
        this.hMf.setText(adPostPbData.recommend);
        this.iEw.setText(adPostPbData.title);
        if (StringUtils.isNull(adPostPbData.desc)) {
            this.iEx.setVisibility(8);
        } else {
            this.iEx.setVisibility(0);
            this.iEx.setText(adPostPbData.desc);
        }
        this.iEy.setText(adPostPbData.buttonText);
        this.iEA.setText(adPostPbData.tagName);
        if (adPostPbData.isDownload()) {
            this.iEz.setRadius(l.g(getContext(), R.dimen.ds32));
            this.iEy.setVisibility(8);
            this.iCj.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPostPbData.getAdvertAppInfo();
            if (advertAppInfo != null) {
                a aVar = new a(advertAppInfo);
                this.rootView.setOnClickListener(aVar);
                this.iCj.setOnClickListener(aVar);
                advertAppInfo.adPosition = String.valueOf(this.position);
                this.iEB = advertAppInfo.bDX;
                DownloadData c = c(advertAppInfo, this.position);
                c.setStatus(ApkDownloadView.getStatus(c));
                this.iCj.setData(c);
                return;
            }
            return;
        }
        this.iEz.setRadius(0);
        this.iCj.setVisibility(8);
        this.iEy.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPostPbData adPostPbData, int i) {
        al.l(this.rootView, R.color.cp_bg_line_d);
        al.l(this.divider, R.color.cp_bg_line_e);
        al.j(this.hMf, R.color.cp_cont_b);
        al.j(this.iEA, R.color.cp_cont_j);
        al.j(this.iEw, R.color.cp_cont_b);
        al.j(this.iEx, R.color.cp_cont_j);
        al.j(this.iEy, R.color.cp_link_tip_a);
        al.k(this.iEy, R.drawable.feed_ad_progress_button_bg);
        this.iCj.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View bHO() {
        MessageManager.getInstance().registerListener(this.iBz);
        this.iBz.setTag(this.mContext.getUniqueId());
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.post_ad_pb_banner_card, (ViewGroup) null);
        this.iEz = (TbImageView) this.rootView.findViewById(R.id.image);
        this.iEy = (TextView) this.rootView.findViewById(R.id.action_button);
        this.hMf = (TextView) this.rootView.findViewById(R.id.recommend_title);
        this.iEw = (TextView) this.rootView.findViewById(R.id.ad_title);
        this.iEx = (TextView) this.rootView.findViewById(R.id.ad_description);
        this.iEA = (TextView) this.rootView.findViewById(R.id.ad_tag);
        this.divider = this.rootView.findViewById(R.id.divider);
        this.iCj = (ApkDownloadView) this.rootView.findViewById(R.id.ad_download);
        this.iCj.s(this.mContext.getUniqueId());
        this.rootView.setOnClickListener(this.exT);
        this.iEy.setOnClickListener(this.exT);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.bDX);
        downloadData.setUrl(advertAppInfo.bDW);
        downloadData.setName(advertAppInfo.bDU);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.f(advertAppInfo.bDT, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.aiM();
            this.mPermissionJudgePolicy.e(this.mContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.aa(this.mContext.getPageActivity()) && this.gYL != null) {
                this.gYL.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.p(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.jG()) {
                l.showToast(this.mContext.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.abF()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.mD(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdPostPbView.this.a(advertAppInfo, i, AdPostPbView.this.iCj);
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostPbView.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.mContext).afG();
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
                    s.aF(this.mContext.getPageActivity(), advertAppInfo.bDX);
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
        private AdvertAppInfo iEE;

        public a(AdvertAppInfo advertAppInfo) {
            this.iEE = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.jG()) {
                AdPostPbView.this.mContext.showToast(R.string.neterror);
                return;
            }
            boolean z = view == AdPostPbView.this.iCj;
            if (this.iEE != null) {
                int f = b.f(this.iEE.adPosition, -1);
                int status = ApkDownloadView.getStatus(AdPostPbView.this.c(this.iEE, f));
                if ((6 != status && 7 != status) || !j.jS() || j.jT()) {
                    AdPostPbView.this.a(this.iEE, f, AdPostPbView.this.iCj, z);
                    if (AdPostPbView.this.gYK != null) {
                        AdPostPbView.this.gYK.b(3, null);
                        return;
                    }
                    return;
                }
                AdPostPbView.this.showDownloadAppDialog(this.iEE, f, true, this.iEE.bEd != null ? this.iEE.bEd.bEp : "");
            }
        }
    }
}
