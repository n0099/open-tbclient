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
    private TextView fuO;
    protected CustomMessageListener gEi;
    private String gGW;
    private TextView gIc;
    private ImageView gId;
    private ApkDownloadView gIe;
    private a mPermissionJudgePolicy;
    private View mRootView;

    public AdOperateViewDownloadHolder(TbPageContext tbPageContext, int i, View view) {
        super(tbPageContext, i, view);
        this.gEi = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.view.AdOperateViewDownloadHolder.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdOperateViewDownloadHolder.this.gGW) && AdOperateViewDownloadHolder.this.gGW.equals(downloadData.getId())) {
                    AdOperateViewDownloadHolder.this.gIe.u(downloadData);
                }
            }
        };
        this.mRootView = view;
        init();
    }

    private void init() {
        this.Xh = (TextView) this.mRootView.findViewById(d.g.ad_operate_title);
        this.fuO = (TextView) this.mRootView.findViewById(d.g.ad_operate_content);
        this.gIc = (TextView) this.mRootView.findViewById(d.g.ad_operate_tag_name);
        this.gId = (ImageView) this.mRootView.findViewById(d.g.ad_operate_divider);
        this.gIe = (ApkDownloadView) this.mRootView.findViewById(d.g.ad_operate_action);
        this.gIe.p(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.gEi);
        this.gEi.setTag(this.mPageContext.getUniqueId());
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.view.AdOperateBarHolder
    public void onChangeSkinType() {
        super.onChangeSkinType();
        aj.t(this.mRootView, d.C0141d.cp_bg_line_e);
        aj.e(this.Xh, d.C0141d.cp_cont_j, 1);
        aj.e(this.fuO, d.C0141d.cp_cont_j, 1);
        aj.e(this.gIc, d.C0141d.cp_cont_f, 1);
        aj.c(this.gId, d.f.ad_divider);
        aj.e(this.gIe, d.C0141d.cp_link_tip_a, 3);
        aj.s(this.gIe, d.f.btn_focus_border_bg);
        this.gIe.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.view.AdOperateBarHolder
    public void update(AdPost adPost) {
        super.update((AdOperateViewDownloadHolder) adPost);
        if (adPost != null && isOperateValid(adPost.adData)) {
            PostAdBaseData.a aVar = adPost.adData;
            this.Xh.setText(aVar.gDA);
            if (StringUtils.isNull(aVar.gDB)) {
                this.fuO.setVisibility(8);
            } else {
                this.fuO.setVisibility(0);
                this.fuO.setText(aVar.gDB);
            }
            this.gIc.setText(StringUtils.isNull(aVar.tagName) ? getResources().getString(d.j.advert_label) : aVar.tagName);
            AdClick adClick = new AdClick(adPost);
            this.mRootView.setOnClickListener(adClick);
            this.gIe.setOnClickListener(adClick);
            this.gIe.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
            if (advertAppInfo != null && advertAppInfo.xK()) {
                this.gGW = advertAppInfo.aKA;
                DownloadData c = c(adPost.getAdvertAppInfo(), b.h(adPost.getAdvertAppInfo().adPosition, -1));
                c.setStatus(ApkDownloadView.getStatus(c));
                this.gIe.setData(c);
            }
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.aKA);
        downloadData.setUrl(advertAppInfo.aKz);
        downloadData.setName(advertAppInfo.aKw);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.h(advertAppInfo.aKv, 0));
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
            if (!this.mPermissionJudgePolicy.v(this.mPageContext.getPageActivity()) && this.fbF != null) {
                this.fbF.b(advertAppInfo, i);
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
                        AdOperateViewDownloadHolder.this.a(advertAppInfo, i, AdOperateViewDownloadHolder.this.gIe);
                        aVar2.dismiss();
                    }
                });
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.recapp.view.AdOperateViewDownloadHolder.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.mPageContext).AV();
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
                    s.ao(this.mPageContext.getPageActivity(), advertAppInfo.aKA);
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
        private AdPost gIg;

        public AdClick(AdPost adPost) {
            this.gIg = adPost;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.ox()) {
                AdOperateViewDownloadHolder.this.mPageContext.showToast(d.j.neterror);
            } else if (this.gIg != null) {
                AdvertAppInfo advertAppInfo = this.gIg.getAdvertAppInfo();
                boolean z = view == AdOperateViewDownloadHolder.this.gIe;
                if (advertAppInfo != null && advertAppInfo.xK()) {
                    int h = b.h(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(AdOperateViewDownloadHolder.this.c(advertAppInfo, h));
                    if ((6 != status && 7 != status) || !j.oJ() || j.oK()) {
                        AdOperateViewDownloadHolder.this.a(advertAppInfo, h, AdOperateViewDownloadHolder.this.gIe, z);
                        if (AdOperateViewDownloadHolder.this.fbE != null) {
                            AdOperateViewDownloadHolder.this.fbE.b(3, null);
                            return;
                        }
                        return;
                    }
                    AdOperateViewDownloadHolder.this.showDownloadAppDialog(advertAppInfo, h, true, this.gIg.getAdvertAppInfo().aKH.aKS);
                }
            }
        }
    }
}
