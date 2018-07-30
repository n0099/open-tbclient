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
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.download.g;
import com.baidu.tieba.recapp.lego.model.AdPost;
import com.baidu.tieba.recapp.lego.model.postad.PostAdBaseData;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
/* loaded from: classes3.dex */
public class AdOperateViewDownloadHolder extends AdOperateBarHolder<AdPost> {
    private static final String TAG = AdOperateViewDownloadHolder.class.getSimpleName();
    private TextView ffQ;
    protected CustomMessageListener gqr;
    private String gtr;
    private TextView guE;
    private ImageView guF;
    private ApkDownloadView guG;
    private a mPermissionJudgePolicy;
    private View mRootView;
    private TextView mTitleTextView;

    public AdOperateViewDownloadHolder(TbPageContext tbPageContext, int i, View view) {
        super(tbPageContext, i, view);
        this.gqr = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.view.AdOperateViewDownloadHolder.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdOperateViewDownloadHolder.this.gtr) && AdOperateViewDownloadHolder.this.gtr.equals(downloadData.getId())) {
                    AdOperateViewDownloadHolder.this.guG.s(downloadData);
                }
            }
        };
        this.mRootView = view;
        init();
    }

    private void init() {
        this.mTitleTextView = (TextView) this.mRootView.findViewById(d.g.ad_operate_title);
        this.ffQ = (TextView) this.mRootView.findViewById(d.g.ad_operate_content);
        this.guE = (TextView) this.mRootView.findViewById(d.g.ad_operate_tag_name);
        this.guF = (ImageView) this.mRootView.findViewById(d.g.ad_operate_divider);
        this.guG = (ApkDownloadView) this.mRootView.findViewById(d.g.ad_operate_action);
        this.guG.q(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.gqr);
        this.gqr.setTag(this.mPageContext.getUniqueId());
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.view.AdOperateBarHolder
    public void onChangeSkinType() {
        super.onChangeSkinType();
        am.j(this.mRootView, d.C0140d.cp_bg_line_e);
        am.c(this.mTitleTextView, d.C0140d.cp_cont_j, 1);
        am.c(this.ffQ, d.C0140d.cp_cont_j, 1);
        am.c(this.guE, d.C0140d.cp_cont_f, 1);
        am.c(this.guF, d.f.ad_divider);
        am.c(this.guG, d.C0140d.cp_link_tip_a, 3);
        am.i(this.guG, d.f.btn_focus_border_bg);
        this.guG.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.view.AdOperateBarHolder
    public void update(AdPost adPost) {
        super.update((AdOperateViewDownloadHolder) adPost);
        if (adPost != null && isOperateValid(adPost.adData)) {
            PostAdBaseData.a aVar = adPost.adData;
            this.mTitleTextView.setText(aVar.gpI);
            if (StringUtils.isNull(aVar.gpJ)) {
                this.ffQ.setVisibility(8);
            } else {
                this.ffQ.setVisibility(0);
                this.ffQ.setText(aVar.gpJ);
            }
            this.guE.setText(StringUtils.isNull(aVar.tagName) ? getResources().getString(d.j.advert_label) : aVar.tagName);
            AdClick adClick = new AdClick(adPost);
            this.mRootView.setOnClickListener(adClick);
            this.guG.setOnClickListener(adClick);
            this.guG.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
            if (advertAppInfo != null && advertAppInfo.tG()) {
                this.gtr = advertAppInfo.adJ;
                DownloadData c = c(adPost.getAdvertAppInfo(), b.g(adPost.getAdvertAppInfo().adPosition, -1));
                c.setStatus(ApkDownloadView.getStatus(c));
                this.guG.setData(c);
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
            if (advertAppInfo.tF() != 0) {
                l.showToast(this.mPageContext.getPageActivity(), d.j.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new a();
            }
            this.mPermissionJudgePolicy.zY();
            this.mPermissionJudgePolicy.c(this.mPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.u(this.mPageContext.getPageActivity()) && this.eQA != null) {
                this.eQA.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.p(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.js()) {
                l.showToast(this.mPageContext.getPageActivity(), d.j.neterror);
            } else if (advertAppInfo.tG()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mPageContext.getString(d.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                aVar.dB(str);
                aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.view.AdOperateViewDownloadHolder.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdOperateViewDownloadHolder.this.a(advertAppInfo, i, AdOperateViewDownloadHolder.this.guG);
                        aVar2.dismiss();
                    }
                });
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.recapp.view.AdOperateViewDownloadHolder.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.mPageContext).xf();
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
        private AdPost guI;

        public AdClick(AdPost adPost) {
            this.guI = adPost;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.js()) {
                AdOperateViewDownloadHolder.this.mPageContext.showToast(d.j.neterror);
            } else if (this.guI != null) {
                AdvertAppInfo advertAppInfo = this.guI.getAdvertAppInfo();
                boolean z = view == AdOperateViewDownloadHolder.this.guG;
                if (advertAppInfo != null && advertAppInfo.tG()) {
                    int g = b.g(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(AdOperateViewDownloadHolder.this.c(advertAppInfo, g));
                    if ((6 != status && 7 != status) || !j.jE() || j.jF()) {
                        AdOperateViewDownloadHolder.this.a(advertAppInfo, g, AdOperateViewDownloadHolder.this.guG, z);
                        if (AdOperateViewDownloadHolder.this.eQz != null) {
                            AdOperateViewDownloadHolder.this.eQz.b(3, null);
                            return;
                        }
                        return;
                    }
                    AdOperateViewDownloadHolder.this.showDownloadAppDialog(advertAppInfo, g, true, this.guI.getAdvertAppInfo().adQ.aec);
                }
            }
        }
    }
}
