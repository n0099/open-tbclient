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
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
/* loaded from: classes20.dex */
public class AdOperateViewDownloadHolder extends AdOperateBarHolder<AdPost> {
    private static final String TAG = AdOperateViewDownloadHolder.class.getSimpleName();
    private TextView aAw;
    protected CustomMessageListener lEA;
    private String lHh;
    private TextView lID;
    private ImageView lIE;
    private ApkDownloadView lIF;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private View mRootView;
    private TextView mTitleTextView;

    public AdOperateViewDownloadHolder(TbPageContext tbPageContext, int i, View view) {
        super(tbPageContext, i, view);
        this.lEA = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.view.AdOperateViewDownloadHolder.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdOperateViewDownloadHolder.this.lHh) && AdOperateViewDownloadHolder.this.lHh.equals(downloadData.getId())) {
                    AdOperateViewDownloadHolder.this.lIF.t(downloadData);
                }
            }
        };
        this.mRootView = view;
        init();
    }

    private void init() {
        this.mTitleTextView = (TextView) this.mRootView.findViewById(R.id.ad_operate_title);
        this.aAw = (TextView) this.mRootView.findViewById(R.id.ad_operate_content);
        this.lID = (TextView) this.mRootView.findViewById(R.id.ad_operate_tag_name);
        this.lIE = (ImageView) this.mRootView.findViewById(R.id.ad_operate_divider);
        this.lIF = (ApkDownloadView) this.mRootView.findViewById(R.id.ad_operate_action);
        this.lIF.y(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.lEA);
        this.lEA.setTag(this.mPageContext.getUniqueId());
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.view.AdOperateBarHolder
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
        ap.setViewTextColor(this.mTitleTextView, R.color.cp_cont_j, 1);
        ap.setViewTextColor(this.aAw, R.color.cp_cont_j, 1);
        ap.setViewTextColor(this.lID, R.color.cp_cont_f, 1);
        ap.setImageResource(this.lIE, R.drawable.ad_divider);
        ap.setViewTextColor(this.lIF, R.color.cp_link_tip_a, 3);
        ap.setBackgroundResource(this.lIF, R.drawable.btn_focus_border_bg);
        this.lIF.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.view.AdOperateBarHolder
    public void update(AdPost adPost) {
        super.update((AdOperateViewDownloadHolder) adPost);
        if (adPost != null && isOperateValid(adPost.adData)) {
            PostAdBaseData.a aVar = adPost.adData;
            this.mTitleTextView.setText(aVar.YH);
            if (StringUtils.isNull(aVar.lDQ)) {
                this.aAw.setVisibility(8);
            } else {
                this.aAw.setVisibility(0);
                this.aAw.setText(aVar.lDQ);
            }
            this.lID.setText(StringUtils.isNull(aVar.tagName) ? getResources().getString(R.string.advert_label) : aVar.tagName);
            AdClick adClick = new AdClick(adPost);
            this.mRootView.setOnClickListener(adClick);
            this.lIF.setOnClickListener(adClick);
            this.lIF.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
            if (advertAppInfo != null && advertAppInfo.bcw()) {
                this.lHh = advertAppInfo.dWi;
                DownloadData b = b(adPost.getAdvertAppInfo(), b.toInt(adPost.getAdvertAppInfo().adPosition, -1));
                b.setStatus(ApkDownloadView.getStatus(b));
                this.lIF.setData(b);
            }
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData b(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.dWi);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.dWg);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.toInt(advertAppInfo.dWf, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (advertAppInfo.bcv() != 0) {
                l.showToast(this.mPageContext.getPageActivity(), R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.mPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.mPageContext.getPageActivity()) && this.jPl != null) {
                this.jPl.c(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.q(b(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.mPageContext.getPageActivity(), R.string.neterror);
            } else if (advertAppInfo.bcw()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mPageContext.getString(R.string.frs_network_tips);
                }
                a aVar = new a(this.mPageContext.getPageActivity());
                aVar.zz(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.view.AdOperateViewDownloadHolder.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(a aVar2) {
                        AdOperateViewDownloadHolder.this.a(advertAppInfo, i, AdOperateViewDownloadHolder.this.lIF);
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.recapp.view.AdOperateViewDownloadHolder.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.mPageContext).bhg();
            }
        }
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView, boolean z) {
        if (advertAppInfo != null) {
            DownloadData b = b(advertAppInfo, i);
            switch (ApkDownloadView.getStatus(b)) {
                case 1:
                case 5:
                    if (z) {
                        h.e(advertAppInfo);
                        apkDownloadView.r(b);
                        return;
                    }
                    return;
                case 2:
                case 4:
                default:
                    return;
                case 3:
                    s.aQ(this.mPageContext.getPageActivity(), advertAppInfo.dWi);
                    return;
                case 6:
                case 7:
                    a(advertAppInfo, i, apkDownloadView);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public class AdClick implements View.OnClickListener {
        private AdPost lIH;

        public AdClick(AdPost adPost) {
            this.lIH = adPost;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdOperateViewDownloadHolder.this.mPageContext.showToast(R.string.neterror);
            } else if (this.lIH != null) {
                AdvertAppInfo advertAppInfo = this.lIH.getAdvertAppInfo();
                boolean z = view == AdOperateViewDownloadHolder.this.lIF;
                if (advertAppInfo != null && advertAppInfo.bcw()) {
                    int i = b.toInt(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(AdOperateViewDownloadHolder.this.b(advertAppInfo, i));
                    if ((6 != status && 7 != status) || !j.isNetWorkAvailable() || j.isWifiNet()) {
                        AdOperateViewDownloadHolder.this.a(advertAppInfo, i, AdOperateViewDownloadHolder.this.lIF, z);
                        if (AdOperateViewDownloadHolder.this.jPk != null) {
                            AdOperateViewDownloadHolder.this.jPk.d(3, null);
                            return;
                        }
                        return;
                    }
                    AdOperateViewDownloadHolder.this.showDownloadAppDialog(advertAppInfo, i, true, this.lIH.getAdvertAppInfo().dWo.dWA);
                }
            }
        }
    }
}
