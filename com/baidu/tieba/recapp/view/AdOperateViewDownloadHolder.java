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
    private TextView Xh;
    private TextView fuy;
    protected CustomMessageListener gDS;
    private String gGG;
    private TextView gHM;
    private ImageView gHN;
    private ApkDownloadView gHO;
    private a mPermissionJudgePolicy;
    private View mRootView;

    public AdOperateViewDownloadHolder(TbPageContext tbPageContext, int i, View view) {
        super(tbPageContext, i, view);
        this.gDS = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.view.AdOperateViewDownloadHolder.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdOperateViewDownloadHolder.this.gGG) && AdOperateViewDownloadHolder.this.gGG.equals(downloadData.getId())) {
                    AdOperateViewDownloadHolder.this.gHO.u(downloadData);
                }
            }
        };
        this.mRootView = view;
        init();
    }

    private void init() {
        this.Xh = (TextView) this.mRootView.findViewById(d.g.ad_operate_title);
        this.fuy = (TextView) this.mRootView.findViewById(d.g.ad_operate_content);
        this.gHM = (TextView) this.mRootView.findViewById(d.g.ad_operate_tag_name);
        this.gHN = (ImageView) this.mRootView.findViewById(d.g.ad_operate_divider);
        this.gHO = (ApkDownloadView) this.mRootView.findViewById(d.g.ad_operate_action);
        this.gHO.p(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.gDS);
        this.gDS.setTag(this.mPageContext.getUniqueId());
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.view.AdOperateBarHolder
    public void onChangeSkinType() {
        super.onChangeSkinType();
        aj.t(this.mRootView, d.C0141d.cp_bg_line_e);
        aj.e(this.Xh, d.C0141d.cp_cont_j, 1);
        aj.e(this.fuy, d.C0141d.cp_cont_j, 1);
        aj.e(this.gHM, d.C0141d.cp_cont_f, 1);
        aj.c(this.gHN, d.f.ad_divider);
        aj.e(this.gHO, d.C0141d.cp_link_tip_a, 3);
        aj.s(this.gHO, d.f.btn_focus_border_bg);
        this.gHO.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.view.AdOperateBarHolder
    public void update(AdPost adPost) {
        super.update((AdOperateViewDownloadHolder) adPost);
        if (adPost != null && isOperateValid(adPost.adData)) {
            PostAdBaseData.a aVar = adPost.adData;
            this.Xh.setText(aVar.gDk);
            if (StringUtils.isNull(aVar.gDl)) {
                this.fuy.setVisibility(8);
            } else {
                this.fuy.setVisibility(0);
                this.fuy.setText(aVar.gDl);
            }
            this.gHM.setText(StringUtils.isNull(aVar.tagName) ? getResources().getString(d.j.advert_label) : aVar.tagName);
            AdClick adClick = new AdClick(adPost);
            this.mRootView.setOnClickListener(adClick);
            this.gHO.setOnClickListener(adClick);
            this.gHO.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
            if (advertAppInfo != null && advertAppInfo.xK()) {
                this.gGG = advertAppInfo.aKz;
                DownloadData c = c(adPost.getAdvertAppInfo(), b.h(adPost.getAdvertAppInfo().adPosition, -1));
                c.setStatus(ApkDownloadView.getStatus(c));
                this.gHO.setData(c);
            }
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.aKz);
        downloadData.setUrl(advertAppInfo.aKy);
        downloadData.setName(advertAppInfo.aKv);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.h(advertAppInfo.aKu, 0));
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
            this.mPermissionJudgePolicy.DH();
            this.mPermissionJudgePolicy.c(this.mPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.v(this.mPageContext.getPageActivity()) && this.fbr != null) {
                this.fbr.b(advertAppInfo, i);
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
                        AdOperateViewDownloadHolder.this.a(advertAppInfo, i, AdOperateViewDownloadHolder.this.gHO);
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
                    s.ao(this.mPageContext.getPageActivity(), advertAppInfo.aKz);
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
        private AdPost gHQ;

        public AdClick(AdPost adPost) {
            this.gHQ = adPost;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.ox()) {
                AdOperateViewDownloadHolder.this.mPageContext.showToast(d.j.neterror);
            } else if (this.gHQ != null) {
                AdvertAppInfo advertAppInfo = this.gHQ.getAdvertAppInfo();
                boolean z = view == AdOperateViewDownloadHolder.this.gHO;
                if (advertAppInfo != null && advertAppInfo.xK()) {
                    int h = b.h(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(AdOperateViewDownloadHolder.this.c(advertAppInfo, h));
                    if ((6 != status && 7 != status) || !j.oJ() || j.oK()) {
                        AdOperateViewDownloadHolder.this.a(advertAppInfo, h, AdOperateViewDownloadHolder.this.gHO, z);
                        if (AdOperateViewDownloadHolder.this.fbq != null) {
                            AdOperateViewDownloadHolder.this.fbq.b(3, null);
                            return;
                        }
                        return;
                    }
                    AdOperateViewDownloadHolder.this.showDownloadAppDialog(advertAppInfo, h, true, this.gHQ.getAdvertAppInfo().aKG.aKR);
                }
            }
        }
    }
}
