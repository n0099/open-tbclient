package com.baidu.tieba.recapp.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.g.b;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.b.a;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.e;
import com.baidu.tieba.recapp.download.g;
import com.baidu.tieba.recapp.lego.model.AdPost;
import com.baidu.tieba.recapp.lego.model.postad.PostAdBaseData;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
/* loaded from: classes3.dex */
public class AdOperateViewDownloadHolder extends AdOperateBarHolder<AdPost> {
    private static final String TAG = AdOperateViewDownloadHolder.class.getSimpleName();
    private TextView fGF;
    protected CustomMessageListener gRz;
    private String gUC;
    private TextView gVR;
    private ImageView gVS;
    private ApkDownloadView gVT;
    private a mPermissionJudgePolicy;
    private View mRootView;
    private TextView mTitleTextView;

    public AdOperateViewDownloadHolder(TbPageContext tbPageContext, int i, View view) {
        super(tbPageContext, i, view);
        this.gRz = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.view.AdOperateViewDownloadHolder.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdOperateViewDownloadHolder.this.gUC) && AdOperateViewDownloadHolder.this.gUC.equals(downloadData.getId())) {
                    AdOperateViewDownloadHolder.this.gVT.s(downloadData);
                }
            }
        };
        this.mRootView = view;
        init();
    }

    private void init() {
        this.mTitleTextView = (TextView) this.mRootView.findViewById(e.g.ad_operate_title);
        this.fGF = (TextView) this.mRootView.findViewById(e.g.ad_operate_content);
        this.gVR = (TextView) this.mRootView.findViewById(e.g.ad_operate_tag_name);
        this.gVS = (ImageView) this.mRootView.findViewById(e.g.ad_operate_divider);
        this.gVT = (ApkDownloadView) this.mRootView.findViewById(e.g.ad_operate_action);
        this.gVT.p(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.gRz);
        this.gRz.setTag(this.mPageContext.getUniqueId());
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.view.AdOperateBarHolder
    public void onChangeSkinType() {
        super.onChangeSkinType();
        al.j(this.mRootView, e.d.cp_bg_line_e);
        al.c(this.mTitleTextView, e.d.cp_cont_j, 1);
        al.c(this.fGF, e.d.cp_cont_j, 1);
        al.c(this.gVR, e.d.cp_cont_f, 1);
        al.c(this.gVS, e.f.ad_divider);
        al.c(this.gVT, e.d.cp_link_tip_a, 3);
        al.i(this.gVT, e.f.btn_focus_border_bg);
        this.gVT.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.view.AdOperateBarHolder
    public void update(AdPost adPost) {
        super.update((AdOperateViewDownloadHolder) adPost);
        if (adPost != null && isOperateValid(adPost.adData)) {
            PostAdBaseData.a aVar = adPost.adData;
            this.mTitleTextView.setText(aVar.gQQ);
            if (StringUtils.isNull(aVar.gQR)) {
                this.fGF.setVisibility(8);
            } else {
                this.fGF.setVisibility(0);
                this.fGF.setText(aVar.gQR);
            }
            this.gVR.setText(StringUtils.isNull(aVar.tagName) ? getResources().getString(e.j.advert_label) : aVar.tagName);
            AdClick adClick = new AdClick(adPost);
            this.mRootView.setOnClickListener(adClick);
            this.gVT.setOnClickListener(adClick);
            this.gVT.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
            if (advertAppInfo != null && advertAppInfo.yq()) {
                this.gUC = advertAppInfo.apX;
                DownloadData c = c(adPost.getAdvertAppInfo(), b.l(adPost.getAdvertAppInfo().adPosition, -1));
                c.setStatus(ApkDownloadView.getStatus(c));
                this.gVT.setData(c);
            }
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.apX);
        downloadData.setUrl(advertAppInfo.apW);
        downloadData.setName(advertAppInfo.apT);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.l(advertAppInfo.apS, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (advertAppInfo.yp() != 0) {
                l.showToast(this.mPageContext.getPageActivity(), e.j.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new a();
            }
            this.mPermissionJudgePolicy.EG();
            this.mPermissionJudgePolicy.c(this.mPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.B(this.mPageContext.getPageActivity()) && this.frw != null) {
                this.frw.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.p(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.kK()) {
                l.showToast(this.mPageContext.getPageActivity(), e.j.neterror);
            } else if (advertAppInfo.yq()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mPageContext.getString(e.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                aVar.eK(str);
                aVar.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.view.AdOperateViewDownloadHolder.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdOperateViewDownloadHolder.this.a(advertAppInfo, i, AdOperateViewDownloadHolder.this.gVT);
                        aVar2.dismiss();
                    }
                });
                aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.recapp.view.AdOperateViewDownloadHolder.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.mPageContext).BS();
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
                    s.aE(this.mPageContext.getPageActivity(), advertAppInfo.apX);
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
    public class AdClick implements View.OnClickListener {
        private AdPost gVV;

        public AdClick(AdPost adPost) {
            this.gVV = adPost;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.kK()) {
                AdOperateViewDownloadHolder.this.mPageContext.showToast(e.j.neterror);
            } else if (this.gVV != null) {
                AdvertAppInfo advertAppInfo = this.gVV.getAdvertAppInfo();
                boolean z = view == AdOperateViewDownloadHolder.this.gVT;
                if (advertAppInfo != null && advertAppInfo.yq()) {
                    int l = b.l(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(AdOperateViewDownloadHolder.this.c(advertAppInfo, l));
                    if ((6 != status && 7 != status) || !j.kV() || j.kW()) {
                        AdOperateViewDownloadHolder.this.a(advertAppInfo, l, AdOperateViewDownloadHolder.this.gVT, z);
                        if (AdOperateViewDownloadHolder.this.frv != null) {
                            AdOperateViewDownloadHolder.this.frv.b(3, null);
                            return;
                        }
                        return;
                    }
                    AdOperateViewDownloadHolder.this.showDownloadAppDialog(advertAppInfo, l, true, this.gVV.getAdvertAppInfo().aqd.aqp);
                }
            }
        }
    }
}
