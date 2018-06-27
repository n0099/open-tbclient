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
    private TextView ffK;
    protected CustomMessageListener gph;
    private String gsf;
    private TextView gtr;
    private ImageView gts;
    private ApkDownloadView gtt;
    private a mPermissionJudgePolicy;
    private View mRootView;
    private TextView mTitleTextView;

    public AdOperateViewDownloadHolder(TbPageContext tbPageContext, int i, View view) {
        super(tbPageContext, i, view);
        this.gph = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.view.AdOperateViewDownloadHolder.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdOperateViewDownloadHolder.this.gsf) && AdOperateViewDownloadHolder.this.gsf.equals(downloadData.getId())) {
                    AdOperateViewDownloadHolder.this.gtt.u(downloadData);
                }
            }
        };
        this.mRootView = view;
        init();
    }

    private void init() {
        this.mTitleTextView = (TextView) this.mRootView.findViewById(d.g.ad_operate_title);
        this.ffK = (TextView) this.mRootView.findViewById(d.g.ad_operate_content);
        this.gtr = (TextView) this.mRootView.findViewById(d.g.ad_operate_tag_name);
        this.gts = (ImageView) this.mRootView.findViewById(d.g.ad_operate_divider);
        this.gtt = (ApkDownloadView) this.mRootView.findViewById(d.g.ad_operate_action);
        this.gtt.q(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.gph);
        this.gph.setTag(this.mPageContext.getUniqueId());
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.view.AdOperateBarHolder
    public void onChangeSkinType() {
        super.onChangeSkinType();
        am.j(this.mRootView, d.C0142d.cp_bg_line_e);
        am.c(this.mTitleTextView, d.C0142d.cp_cont_j, 1);
        am.c(this.ffK, d.C0142d.cp_cont_j, 1);
        am.c(this.gtr, d.C0142d.cp_cont_f, 1);
        am.c(this.gts, d.f.ad_divider);
        am.c(this.gtt, d.C0142d.cp_link_tip_a, 3);
        am.i(this.gtt, d.f.btn_focus_border_bg);
        this.gtt.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.view.AdOperateBarHolder
    public void update(AdPost adPost) {
        super.update((AdOperateViewDownloadHolder) adPost);
        if (adPost != null && isOperateValid(adPost.adData)) {
            PostAdBaseData.a aVar = adPost.adData;
            this.mTitleTextView.setText(aVar.goy);
            if (StringUtils.isNull(aVar.goz)) {
                this.ffK.setVisibility(8);
            } else {
                this.ffK.setVisibility(0);
                this.ffK.setText(aVar.goz);
            }
            this.gtr.setText(StringUtils.isNull(aVar.tagName) ? getResources().getString(d.k.advert_label) : aVar.tagName);
            AdClick adClick = new AdClick(adPost);
            this.mRootView.setOnClickListener(adClick);
            this.gtt.setOnClickListener(adClick);
            this.gtt.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
            if (advertAppInfo != null && advertAppInfo.tU()) {
                this.gsf = advertAppInfo.aef;
                DownloadData c = c(adPost.getAdvertAppInfo(), b.g(adPost.getAdvertAppInfo().adPosition, -1));
                c.setStatus(ApkDownloadView.getStatus(c));
                this.gtt.setData(c);
            }
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.aef);
        downloadData.setUrl(advertAppInfo.aee);
        downloadData.setName(advertAppInfo.aeb);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.g(advertAppInfo.aea, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (advertAppInfo.tT() != 0) {
                l.showToast(this.mPageContext.getPageActivity(), d.k.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new a();
            }
            this.mPermissionJudgePolicy.Aj();
            this.mPermissionJudgePolicy.c(this.mPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.u(this.mPageContext.getPageActivity()) && this.eMF != null) {
                this.eMF.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.s(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.jr()) {
                l.showToast(this.mPageContext.getPageActivity(), d.k.neterror);
            } else if (advertAppInfo.tU()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mPageContext.getString(d.k.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                aVar.dE(str);
                aVar.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.view.AdOperateViewDownloadHolder.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdOperateViewDownloadHolder.this.a(advertAppInfo, i, AdOperateViewDownloadHolder.this.gtt);
                        aVar2.dismiss();
                    }
                });
                aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.recapp.view.AdOperateViewDownloadHolder.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.mPageContext).xn();
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
                    s.al(this.mPageContext.getPageActivity(), advertAppInfo.aef);
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
        private AdPost gtv;

        public AdClick(AdPost adPost) {
            this.gtv = adPost;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.jr()) {
                AdOperateViewDownloadHolder.this.mPageContext.showToast(d.k.neterror);
            } else if (this.gtv != null) {
                AdvertAppInfo advertAppInfo = this.gtv.getAdvertAppInfo();
                boolean z = view == AdOperateViewDownloadHolder.this.gtt;
                if (advertAppInfo != null && advertAppInfo.tU()) {
                    int g = b.g(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(AdOperateViewDownloadHolder.this.c(advertAppInfo, g));
                    if ((6 != status && 7 != status) || !j.jD() || j.jE()) {
                        AdOperateViewDownloadHolder.this.a(advertAppInfo, g, AdOperateViewDownloadHolder.this.gtt, z);
                        if (AdOperateViewDownloadHolder.this.eME != null) {
                            AdOperateViewDownloadHolder.this.eME.b(3, null);
                            return;
                        }
                        return;
                    }
                    AdOperateViewDownloadHolder.this.showDownloadAppDialog(advertAppInfo, g, true, this.gtv.getAdvertAppInfo().aem.aey);
                }
            }
        }
    }
}
