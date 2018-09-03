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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.b.a;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.f;
import com.baidu.tieba.recapp.download.g;
import com.baidu.tieba.recapp.lego.model.AdPost;
import com.baidu.tieba.recapp.lego.model.postad.PostAdBaseData;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
/* loaded from: classes3.dex */
public class AdOperateViewDownloadHolder extends AdOperateBarHolder<AdPost> {
    private static final String TAG = AdOperateViewDownloadHolder.class.getSimpleName();
    private TextView ffK;
    protected CustomMessageListener gqu;
    private String gtu;
    private TextView guH;
    private ImageView guI;
    private ApkDownloadView guJ;
    private a mPermissionJudgePolicy;
    private View mRootView;
    private TextView mTitleTextView;

    public AdOperateViewDownloadHolder(TbPageContext tbPageContext, int i, View view) {
        super(tbPageContext, i, view);
        this.gqu = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.view.AdOperateViewDownloadHolder.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdOperateViewDownloadHolder.this.gtu) && AdOperateViewDownloadHolder.this.gtu.equals(downloadData.getId())) {
                    AdOperateViewDownloadHolder.this.guJ.s(downloadData);
                }
            }
        };
        this.mRootView = view;
        init();
    }

    private void init() {
        this.mTitleTextView = (TextView) this.mRootView.findViewById(f.g.ad_operate_title);
        this.ffK = (TextView) this.mRootView.findViewById(f.g.ad_operate_content);
        this.guH = (TextView) this.mRootView.findViewById(f.g.ad_operate_tag_name);
        this.guI = (ImageView) this.mRootView.findViewById(f.g.ad_operate_divider);
        this.guJ = (ApkDownloadView) this.mRootView.findViewById(f.g.ad_operate_action);
        this.guJ.q(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.gqu);
        this.gqu.setTag(this.mPageContext.getUniqueId());
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.view.AdOperateBarHolder
    public void onChangeSkinType() {
        super.onChangeSkinType();
        am.j(this.mRootView, f.d.cp_bg_line_e);
        am.c(this.mTitleTextView, f.d.cp_cont_j, 1);
        am.c(this.ffK, f.d.cp_cont_j, 1);
        am.c(this.guH, f.d.cp_cont_f, 1);
        am.c(this.guI, f.C0146f.ad_divider);
        am.c(this.guJ, f.d.cp_link_tip_a, 3);
        am.i(this.guJ, f.C0146f.btn_focus_border_bg);
        this.guJ.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.view.AdOperateBarHolder
    public void update(AdPost adPost) {
        super.update((AdOperateViewDownloadHolder) adPost);
        if (adPost != null && isOperateValid(adPost.adData)) {
            PostAdBaseData.a aVar = adPost.adData;
            this.mTitleTextView.setText(aVar.gpL);
            if (StringUtils.isNull(aVar.gpM)) {
                this.ffK.setVisibility(8);
            } else {
                this.ffK.setVisibility(0);
                this.ffK.setText(aVar.gpM);
            }
            this.guH.setText(StringUtils.isNull(aVar.tagName) ? getResources().getString(f.j.advert_label) : aVar.tagName);
            AdClick adClick = new AdClick(adPost);
            this.mRootView.setOnClickListener(adClick);
            this.guJ.setOnClickListener(adClick);
            this.guJ.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
            if (advertAppInfo != null && advertAppInfo.tF()) {
                this.gtu = advertAppInfo.adJ;
                DownloadData c = c(adPost.getAdvertAppInfo(), b.g(adPost.getAdvertAppInfo().adPosition, -1));
                c.setStatus(ApkDownloadView.getStatus(c));
                this.guJ.setData(c);
            }
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.adJ);
        downloadData.setUrl(advertAppInfo.adI);
        downloadData.setName(advertAppInfo.adF);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.g(advertAppInfo.adE, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (advertAppInfo.tE() != 0) {
                l.showToast(this.mPageContext.getPageActivity(), f.j.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new a();
            }
            this.mPermissionJudgePolicy.zW();
            this.mPermissionJudgePolicy.c(this.mPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.u(this.mPageContext.getPageActivity()) && this.eQv != null) {
                this.eQv.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.p(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.js()) {
                l.showToast(this.mPageContext.getPageActivity(), f.j.neterror);
            } else if (advertAppInfo.tF()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mPageContext.getString(f.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                aVar.dB(str);
                aVar.a(f.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.view.AdOperateViewDownloadHolder.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdOperateViewDownloadHolder.this.a(advertAppInfo, i, AdOperateViewDownloadHolder.this.guJ);
                        aVar2.dismiss();
                    }
                });
                aVar.b(f.j.cancel, new a.b() { // from class: com.baidu.tieba.recapp.view.AdOperateViewDownloadHolder.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.mPageContext).xe();
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
                    s.an(this.mPageContext.getPageActivity(), advertAppInfo.adJ);
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
        private AdPost guL;

        public AdClick(AdPost adPost) {
            this.guL = adPost;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.js()) {
                AdOperateViewDownloadHolder.this.mPageContext.showToast(f.j.neterror);
            } else if (this.guL != null) {
                AdvertAppInfo advertAppInfo = this.guL.getAdvertAppInfo();
                boolean z = view == AdOperateViewDownloadHolder.this.guJ;
                if (advertAppInfo != null && advertAppInfo.tF()) {
                    int g = b.g(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(AdOperateViewDownloadHolder.this.c(advertAppInfo, g));
                    if ((6 != status && 7 != status) || !j.jE() || j.jF()) {
                        AdOperateViewDownloadHolder.this.a(advertAppInfo, g, AdOperateViewDownloadHolder.this.guJ, z);
                        if (AdOperateViewDownloadHolder.this.eQu != null) {
                            AdOperateViewDownloadHolder.this.eQu.b(3, null);
                            return;
                        }
                        return;
                    }
                    AdOperateViewDownloadHolder.this.showDownloadAppDialog(advertAppInfo, g, true, this.guL.getAdvertAppInfo().adQ.aec);
                }
            }
        }
    }
}
