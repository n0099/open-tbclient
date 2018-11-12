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
    private TextView fwd;
    protected CustomMessageListener gGO;
    private String gJP;
    private TextView gLa;
    private ImageView gLb;
    private ApkDownloadView gLc;
    private a mPermissionJudgePolicy;
    private View mRootView;
    private TextView mTitleTextView;

    public AdOperateViewDownloadHolder(TbPageContext tbPageContext, int i, View view) {
        super(tbPageContext, i, view);
        this.gGO = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.view.AdOperateViewDownloadHolder.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdOperateViewDownloadHolder.this.gJP) && AdOperateViewDownloadHolder.this.gJP.equals(downloadData.getId())) {
                    AdOperateViewDownloadHolder.this.gLc.s(downloadData);
                }
            }
        };
        this.mRootView = view;
        init();
    }

    private void init() {
        this.mTitleTextView = (TextView) this.mRootView.findViewById(e.g.ad_operate_title);
        this.fwd = (TextView) this.mRootView.findViewById(e.g.ad_operate_content);
        this.gLa = (TextView) this.mRootView.findViewById(e.g.ad_operate_tag_name);
        this.gLb = (ImageView) this.mRootView.findViewById(e.g.ad_operate_divider);
        this.gLc = (ApkDownloadView) this.mRootView.findViewById(e.g.ad_operate_action);
        this.gLc.p(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.gGO);
        this.gGO.setTag(this.mPageContext.getUniqueId());
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.view.AdOperateBarHolder
    public void onChangeSkinType() {
        super.onChangeSkinType();
        al.j(this.mRootView, e.d.cp_bg_line_e);
        al.c(this.mTitleTextView, e.d.cp_cont_j, 1);
        al.c(this.fwd, e.d.cp_cont_j, 1);
        al.c(this.gLa, e.d.cp_cont_f, 1);
        al.c(this.gLb, e.f.ad_divider);
        al.c(this.gLc, e.d.cp_link_tip_a, 3);
        al.i(this.gLc, e.f.btn_focus_border_bg);
        this.gLc.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.view.AdOperateBarHolder
    public void update(AdPost adPost) {
        super.update((AdOperateViewDownloadHolder) adPost);
        if (adPost != null && isOperateValid(adPost.adData)) {
            PostAdBaseData.a aVar = adPost.adData;
            this.mTitleTextView.setText(aVar.gGf);
            if (StringUtils.isNull(aVar.gGg)) {
                this.fwd.setVisibility(8);
            } else {
                this.fwd.setVisibility(0);
                this.fwd.setText(aVar.gGg);
            }
            this.gLa.setText(StringUtils.isNull(aVar.tagName) ? getResources().getString(e.j.advert_label) : aVar.tagName);
            AdClick adClick = new AdClick(adPost);
            this.mRootView.setOnClickListener(adClick);
            this.gLc.setOnClickListener(adClick);
            this.gLc.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
            if (advertAppInfo != null && advertAppInfo.wZ()) {
                this.gJP = advertAppInfo.alU;
                DownloadData c = c(adPost.getAdvertAppInfo(), b.l(adPost.getAdvertAppInfo().adPosition, -1));
                c.setStatus(ApkDownloadView.getStatus(c));
                this.gLc.setData(c);
            }
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.alU);
        downloadData.setUrl(advertAppInfo.alT);
        downloadData.setName(advertAppInfo.alQ);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.l(advertAppInfo.alP, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (advertAppInfo.wY() != 0) {
                l.showToast(this.mPageContext.getPageActivity(), e.j.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new a();
            }
            this.mPermissionJudgePolicy.Dp();
            this.mPermissionJudgePolicy.c(this.mPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.A(this.mPageContext.getPageActivity()) && this.fgR != null) {
                this.fgR.b(advertAppInfo, i);
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
            } else if (advertAppInfo.wZ()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mPageContext.getString(e.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                aVar.ej(str);
                aVar.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.view.AdOperateViewDownloadHolder.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdOperateViewDownloadHolder.this.a(advertAppInfo, i, AdOperateViewDownloadHolder.this.gLc);
                        aVar2.dismiss();
                    }
                });
                aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.recapp.view.AdOperateViewDownloadHolder.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.mPageContext).AB();
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
                    s.aD(this.mPageContext.getPageActivity(), advertAppInfo.alU);
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
        private AdPost gLe;

        public AdClick(AdPost adPost) {
            this.gLe = adPost;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.kK()) {
                AdOperateViewDownloadHolder.this.mPageContext.showToast(e.j.neterror);
            } else if (this.gLe != null) {
                AdvertAppInfo advertAppInfo = this.gLe.getAdvertAppInfo();
                boolean z = view == AdOperateViewDownloadHolder.this.gLc;
                if (advertAppInfo != null && advertAppInfo.wZ()) {
                    int l = b.l(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(AdOperateViewDownloadHolder.this.c(advertAppInfo, l));
                    if ((6 != status && 7 != status) || !j.kV() || j.kW()) {
                        AdOperateViewDownloadHolder.this.a(advertAppInfo, l, AdOperateViewDownloadHolder.this.gLc, z);
                        if (AdOperateViewDownloadHolder.this.fgQ != null) {
                            AdOperateViewDownloadHolder.this.fgQ.b(3, null);
                            return;
                        }
                        return;
                    }
                    AdOperateViewDownloadHolder.this.showDownloadAppDialog(advertAppInfo, l, true, this.gLe.getAdvertAppInfo().ama.amm);
                }
            }
        }
    }
}
