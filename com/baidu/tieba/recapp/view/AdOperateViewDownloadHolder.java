package com.baidu.tieba.recapp.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.download.h;
import com.baidu.tieba.recapp.lego.model.AdPost;
import com.baidu.tieba.recapp.lego.model.postad.PostAdBaseData;
import com.baidu.tieba.recapp.t;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
/* loaded from: classes8.dex */
public class AdOperateViewDownloadHolder extends AdOperateBarHolder<AdPost> {
    private static final String TAG = AdOperateViewDownloadHolder.class.getSimpleName();
    private TextView aDt;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private View mRootView;
    private TextView mTitleTextView;
    protected CustomMessageListener mUs;
    private String mXl;
    private TextView mYP;
    private ImageView mYQ;
    private ApkDownloadView mYR;

    public AdOperateViewDownloadHolder(TbPageContext tbPageContext, int i, View view) {
        super(tbPageContext, i, view);
        this.mUs = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.view.AdOperateViewDownloadHolder.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdOperateViewDownloadHolder.this.mXl) && AdOperateViewDownloadHolder.this.mXl.equals(downloadData.getId())) {
                    AdOperateViewDownloadHolder.this.mYR.s(downloadData);
                }
            }
        };
        this.mRootView = view;
        init();
    }

    private void init() {
        this.mTitleTextView = (TextView) this.mRootView.findViewById(R.id.ad_operate_title);
        this.aDt = (TextView) this.mRootView.findViewById(R.id.ad_operate_content);
        this.mYP = (TextView) this.mRootView.findViewById(R.id.ad_operate_tag_name);
        this.mYQ = (ImageView) this.mRootView.findViewById(R.id.ad_operate_divider);
        this.mYR = (ApkDownloadView) this.mRootView.findViewById(R.id.ad_operate_action);
        this.mYR.y(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.mUs);
        this.mUs.setTag(this.mPageContext.getUniqueId());
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.view.AdOperateBarHolder
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0205);
        ap.setViewTextColor(this.mTitleTextView, R.color.CAM_X0107, 1);
        ap.setViewTextColor(this.aDt, R.color.CAM_X0107, 1);
        ap.setViewTextColor(this.mYP, R.color.CAM_X0106, 1);
        ap.setImageResource(this.mYQ, R.drawable.ad_divider);
        ap.setViewTextColor(this.mYR, R.color.CAM_X0302, 3);
        ap.setBackgroundResource(this.mYR, R.drawable.btn_focus_border_bg);
        this.mYR.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.view.AdOperateBarHolder
    public void update(AdPost adPost) {
        super.update((AdOperateViewDownloadHolder) adPost);
        if (adPost != null && isOperateValid(adPost.adData)) {
            PostAdBaseData.a aVar = adPost.adData;
            this.mTitleTextView.setText(aVar.aaX);
            if (StringUtils.isNull(aVar.mTB)) {
                this.aDt.setVisibility(8);
            } else {
                this.aDt.setVisibility(0);
                this.aDt.setText(aVar.mTB);
            }
            this.mYP.setText(StringUtils.isNull(aVar.tagName) ? getResources().getString(R.string.advert_label) : aVar.tagName);
            AdClick adClick = new AdClick(adPost);
            this.mRootView.setOnClickListener(adClick);
            this.mYR.setOnClickListener(adClick);
            this.mYR.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
            if (advertAppInfo != null && advertAppInfo.blE()) {
                this.mXl = advertAppInfo.eLw;
                DownloadData d = d(adPost.getAdvertAppInfo(), b.toInt(adPost.getAdvertAppInfo().adPosition, -1));
                d.setStatus(ApkDownloadView.getStatus(d));
                this.mYR.setData(d);
            }
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData d(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.eLw != null ? advertAppInfo.eLw : advertAppInfo.eLt);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.eLu);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.toInt(advertAppInfo.eLt, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (advertAppInfo.blD() != 0) {
                l.showToast(this.mPageContext.getPageActivity(), R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.mPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.mPageContext.getPageActivity()) && this.lcB != null) {
                this.lcB.c(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.p(d(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.mPageContext.getPageActivity(), R.string.neterror);
            } else if (advertAppInfo.blE()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mPageContext.getString(R.string.frs_network_tips);
                }
                a aVar = new a(this.mPageContext.getPageActivity());
                aVar.Au(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.view.AdOperateViewDownloadHolder.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(a aVar2) {
                        AdOperateViewDownloadHolder.this.a(advertAppInfo, i, AdOperateViewDownloadHolder.this.mYR);
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.recapp.view.AdOperateViewDownloadHolder.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.mPageContext).bqx();
            }
        }
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView, boolean z) {
        if (advertAppInfo != null) {
            DownloadData d = d(advertAppInfo, i);
            switch (ApkDownloadView.getStatus(d)) {
                case 1:
                case 5:
                    if (z) {
                        h.i(advertAppInfo);
                        apkDownloadView.q(d);
                        return;
                    }
                    return;
                case 2:
                case 4:
                default:
                    return;
                case 3:
                    t.installApp(this.mPageContext.getPageActivity(), advertAppInfo.eLw);
                    return;
                case 6:
                case 7:
                    a(advertAppInfo, i, apkDownloadView);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class AdClick implements View.OnClickListener {
        private AdPost mYT;

        public AdClick(AdPost adPost) {
            this.mYT = adPost;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdOperateViewDownloadHolder.this.mPageContext.showToast(R.string.neterror);
            } else if (this.mYT != null) {
                AdvertAppInfo advertAppInfo = this.mYT.getAdvertAppInfo();
                boolean z = view == AdOperateViewDownloadHolder.this.mYR;
                if (advertAppInfo != null && advertAppInfo.blE()) {
                    int i = b.toInt(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(AdOperateViewDownloadHolder.this.d(advertAppInfo, i));
                    if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                        AdOperateViewDownloadHolder.this.a(advertAppInfo, i, AdOperateViewDownloadHolder.this.mYR, z);
                        if (AdOperateViewDownloadHolder.this.lcA != null) {
                            AdOperateViewDownloadHolder.this.lcA.d(3, null);
                            return;
                        }
                        return;
                    }
                    AdOperateViewDownloadHolder.this.showDownloadAppDialog(advertAppInfo, i, true, this.mYT.getAdvertAppInfo().eLC.eLQ);
                }
            }
        }
    }
}
