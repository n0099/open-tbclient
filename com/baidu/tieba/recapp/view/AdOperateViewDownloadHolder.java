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
import com.baidu.tbadk.core.util.c.a;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.download.h;
import com.baidu.tieba.recapp.lego.model.AdPost;
import com.baidu.tieba.recapp.lego.model.postad.PostAdBaseData;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
/* loaded from: classes3.dex */
public class AdOperateViewDownloadHolder extends AdOperateBarHolder<AdPost> {
    private static final String TAG = AdOperateViewDownloadHolder.class.getSimpleName();
    private TextView hwZ;
    protected CustomMessageListener iLr;
    private String iOt;
    private TextView iPG;
    private ImageView iPH;
    private ApkDownloadView iPI;
    private a mPermissionJudgePolicy;
    private View mRootView;
    private TextView mTitleTextView;

    public AdOperateViewDownloadHolder(TbPageContext tbPageContext, int i, View view) {
        super(tbPageContext, i, view);
        this.iLr = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.view.AdOperateViewDownloadHolder.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdOperateViewDownloadHolder.this.iOt) && AdOperateViewDownloadHolder.this.iOt.equals(downloadData.getId())) {
                    AdOperateViewDownloadHolder.this.iPI.s(downloadData);
                }
            }
        };
        this.mRootView = view;
        init();
    }

    private void init() {
        this.mTitleTextView = (TextView) this.mRootView.findViewById(R.id.ad_operate_title);
        this.hwZ = (TextView) this.mRootView.findViewById(R.id.ad_operate_content);
        this.iPG = (TextView) this.mRootView.findViewById(R.id.ad_operate_tag_name);
        this.iPH = (ImageView) this.mRootView.findViewById(R.id.ad_operate_divider);
        this.iPI = (ApkDownloadView) this.mRootView.findViewById(R.id.ad_operate_action);
        this.iPI.s(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.iLr);
        this.iLr.setTag(this.mPageContext.getUniqueId());
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.view.AdOperateBarHolder
    public void onChangeSkinType() {
        super.onChangeSkinType();
        am.l(this.mRootView, R.color.cp_bg_line_e);
        am.f(this.mTitleTextView, R.color.cp_cont_j, 1);
        am.f(this.hwZ, R.color.cp_cont_j, 1);
        am.f(this.iPG, R.color.cp_cont_f, 1);
        am.c(this.iPH, (int) R.drawable.ad_divider);
        am.f(this.iPI, R.color.cp_link_tip_a, 3);
        am.k(this.iPI, R.drawable.btn_focus_border_bg);
        this.iPI.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.view.AdOperateBarHolder
    public void update(AdPost adPost) {
        super.update((AdOperateViewDownloadHolder) adPost);
        if (adPost != null && isOperateValid(adPost.adData)) {
            PostAdBaseData.a aVar = adPost.adData;
            this.mTitleTextView.setText(aVar.RY);
            if (StringUtils.isNull(aVar.iKK)) {
                this.hwZ.setVisibility(8);
            } else {
                this.hwZ.setVisibility(0);
                this.hwZ.setText(aVar.iKK);
            }
            this.iPG.setText(StringUtils.isNull(aVar.tagName) ? getResources().getString(R.string.advert_label) : aVar.tagName);
            AdClick adClick = new AdClick(adPost);
            this.mRootView.setOnClickListener(adClick);
            this.iPI.setOnClickListener(adClick);
            this.iPI.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
            if (advertAppInfo != null && advertAppInfo.acM()) {
                this.iOt = advertAppInfo.bFw;
                DownloadData c = c(adPost.getAdvertAppInfo(), b.f(adPost.getAdvertAppInfo().adPosition, -1));
                c.setStatus(ApkDownloadView.getStatus(c));
                this.iPI.setData(c);
            }
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.bFw);
        downloadData.setUrl(advertAppInfo.bFv);
        downloadData.setName(advertAppInfo.bFt);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.f(advertAppInfo.bFs, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (advertAppInfo.acL() != 0) {
                l.showToast(this.mPageContext.getPageActivity(), (int) R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new a();
            }
            this.mPermissionJudgePolicy.ake();
            this.mPermissionJudgePolicy.e(this.mPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.ad(this.mPageContext.getPageActivity()) && this.hhJ != null) {
                this.hhJ.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.p(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.jQ()) {
                l.showToast(this.mPageContext.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.acM()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mPageContext.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                aVar.mQ(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.view.AdOperateViewDownloadHolder.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdOperateViewDownloadHolder.this.a(advertAppInfo, i, AdOperateViewDownloadHolder.this.iPI);
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.recapp.view.AdOperateViewDownloadHolder.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.mPageContext).agO();
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
                        h.f(advertAppInfo);
                        apkDownloadView.q(c);
                        return;
                    }
                    return;
                case 2:
                case 4:
                default:
                    return;
                case 3:
                    s.aN(this.mPageContext.getPageActivity(), advertAppInfo.bFw);
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
        private AdPost iPK;

        public AdClick(AdPost adPost) {
            this.iPK = adPost;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.jQ()) {
                AdOperateViewDownloadHolder.this.mPageContext.showToast(R.string.neterror);
            } else if (this.iPK != null) {
                AdvertAppInfo advertAppInfo = this.iPK.getAdvertAppInfo();
                boolean z = view == AdOperateViewDownloadHolder.this.iPI;
                if (advertAppInfo != null && advertAppInfo.acM()) {
                    int f = b.f(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(AdOperateViewDownloadHolder.this.c(advertAppInfo, f));
                    if ((6 != status && 7 != status) || !j.kc() || j.kd()) {
                        AdOperateViewDownloadHolder.this.a(advertAppInfo, f, AdOperateViewDownloadHolder.this.iPI, z);
                        if (AdOperateViewDownloadHolder.this.hhI != null) {
                            AdOperateViewDownloadHolder.this.hhI.b(3, null);
                            return;
                        }
                        return;
                    }
                    AdOperateViewDownloadHolder.this.showDownloadAppDialog(advertAppInfo, f, true, this.iPK.getAdvertAppInfo().bFC.bFO);
                }
            }
        }
    }
}
