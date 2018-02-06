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
import com.baidu.tbadk.core.util.aj;
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
    private TextView Xn;
    private TextView fuK;
    protected CustomMessageListener gEh;
    private String gGV;
    private TextView gIb;
    private ImageView gIc;
    private ApkDownloadView gId;
    private a mPermissionJudgePolicy;
    private View mRootView;

    public AdOperateViewDownloadHolder(TbPageContext tbPageContext, int i, View view) {
        super(tbPageContext, i, view);
        this.gEh = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.view.AdOperateViewDownloadHolder.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdOperateViewDownloadHolder.this.gGV) && AdOperateViewDownloadHolder.this.gGV.equals(downloadData.getId())) {
                    AdOperateViewDownloadHolder.this.gId.u(downloadData);
                }
            }
        };
        this.mRootView = view;
        init();
    }

    private void init() {
        this.Xn = (TextView) this.mRootView.findViewById(d.g.ad_operate_title);
        this.fuK = (TextView) this.mRootView.findViewById(d.g.ad_operate_content);
        this.gIb = (TextView) this.mRootView.findViewById(d.g.ad_operate_tag_name);
        this.gIc = (ImageView) this.mRootView.findViewById(d.g.ad_operate_divider);
        this.gId = (ApkDownloadView) this.mRootView.findViewById(d.g.ad_operate_action);
        this.gId.p(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.gEh);
        this.gEh.setTag(this.mPageContext.getUniqueId());
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.view.AdOperateBarHolder
    public void onChangeSkinType() {
        super.onChangeSkinType();
        aj.t(this.mRootView, d.C0140d.cp_bg_line_e);
        aj.e(this.Xn, d.C0140d.cp_cont_j, 1);
        aj.e(this.fuK, d.C0140d.cp_cont_j, 1);
        aj.e(this.gIb, d.C0140d.cp_cont_f, 1);
        aj.c(this.gIc, d.f.ad_divider);
        aj.e(this.gId, d.C0140d.cp_link_tip_a, 3);
        aj.s(this.gId, d.f.btn_focus_border_bg);
        this.gId.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.view.AdOperateBarHolder
    public void update(AdPost adPost) {
        super.update((AdOperateViewDownloadHolder) adPost);
        if (adPost != null && isOperateValid(adPost.adData)) {
            PostAdBaseData.a aVar = adPost.adData;
            this.Xn.setText(aVar.gDz);
            if (StringUtils.isNull(aVar.gDA)) {
                this.fuK.setVisibility(8);
            } else {
                this.fuK.setVisibility(0);
                this.fuK.setText(aVar.gDA);
            }
            this.gIb.setText(StringUtils.isNull(aVar.tagName) ? getResources().getString(d.j.advert_label) : aVar.tagName);
            AdClick adClick = new AdClick(adPost);
            this.mRootView.setOnClickListener(adClick);
            this.gId.setOnClickListener(adClick);
            this.gId.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
            if (advertAppInfo != null && advertAppInfo.xK()) {
                this.gGV = advertAppInfo.aKK;
                DownloadData c = c(adPost.getAdvertAppInfo(), b.h(adPost.getAdvertAppInfo().adPosition, -1));
                c.setStatus(ApkDownloadView.getStatus(c));
                this.gId.setData(c);
            }
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.aKK);
        downloadData.setUrl(advertAppInfo.aKJ);
        downloadData.setName(advertAppInfo.aKG);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.h(advertAppInfo.aKF, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (advertAppInfo.xJ() != 0) {
                l.showToast(this.mPageContext.getPageActivity(), d.j.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new a();
            }
            this.mPermissionJudgePolicy.DI();
            this.mPermissionJudgePolicy.c(this.mPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.v(this.mPageContext.getPageActivity()) && this.fbD != null) {
                this.fbD.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.s(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.ox()) {
                l.showToast(this.mPageContext.getPageActivity(), d.j.neterror);
            } else if (advertAppInfo.xK()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mPageContext.getString(d.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                aVar.dk(str);
                aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.view.AdOperateViewDownloadHolder.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdOperateViewDownloadHolder.this.a(advertAppInfo, i, AdOperateViewDownloadHolder.this.gId);
                        aVar2.dismiss();
                    }
                });
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.recapp.view.AdOperateViewDownloadHolder.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.mPageContext).AU();
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
                    s.ao(this.mPageContext.getPageActivity(), advertAppInfo.aKK);
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
        private AdPost gIf;

        public AdClick(AdPost adPost) {
            this.gIf = adPost;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.ox()) {
                AdOperateViewDownloadHolder.this.mPageContext.showToast(d.j.neterror);
            } else if (this.gIf != null) {
                AdvertAppInfo advertAppInfo = this.gIf.getAdvertAppInfo();
                boolean z = view == AdOperateViewDownloadHolder.this.gId;
                if (advertAppInfo != null && advertAppInfo.xK()) {
                    int h = b.h(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(AdOperateViewDownloadHolder.this.c(advertAppInfo, h));
                    if ((6 != status && 7 != status) || !j.oJ() || j.oK()) {
                        AdOperateViewDownloadHolder.this.a(advertAppInfo, h, AdOperateViewDownloadHolder.this.gId, z);
                        if (AdOperateViewDownloadHolder.this.fbC != null) {
                            AdOperateViewDownloadHolder.this.fbC.b(3, null);
                            return;
                        }
                        return;
                    }
                    AdOperateViewDownloadHolder.this.showDownloadAppDialog(advertAppInfo, h, true, this.gIf.getAdvertAppInfo().aKR.aLc);
                }
            }
        }
    }
}
