package com.baidu.tieba.recapp.activity.newstyle;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity;
import com.baidu.tieba.ad.browser.newstyle.TBAdWebView;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.DistributeVideoView;
import com.baidu.tieba.recapp.view.WebViewContainer;
import tbclient.VideoInfo;
/* loaded from: classes7.dex */
public class AdWebVideoActivity extends AdWebViewActivity {
    public static a mTY;
    private DistributeVideoView mTZ;
    private String mThumbUrl;
    private WebViewContainer mUb;
    private float mUc;
    private int mUd;
    private int mUe;
    private int mUf;
    private int mUg;
    private AdCard.g mUh;
    private WebViewContainer.OnScrollChangedCallback mUi = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.newstyle.AdWebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            AdWebVideoActivity.this.mUe -= i2;
            if (AdWebVideoActivity.this.mUe <= 0) {
                AdWebVideoActivity.this.mTZ.stopPlay(AdWebVideoActivity.this.mTZ.getPlayStatus() != 2);
            } else if (AdWebVideoActivity.this.mUe < AdWebVideoActivity.this.mUf) {
                AdWebVideoActivity.this.mTZ.pausePlay(1);
            } else if (AdWebVideoActivity.this.mTZ.getPlayStatus() == 2) {
                AdWebVideoActivity.this.mTZ.autoContinue();
            } else if (AdWebVideoActivity.this.mTZ.getPlayStatus() == -1) {
                AdWebVideoActivity.this.mTZ.autoPlay(0);
            }
        }
    };
    private int mVideoHeight;
    private String mVideoUrl;

    /* loaded from: classes7.dex */
    public static class a {
        public String mPage;
        public int mPageNum;
        public AdvertAppInfo mUl;
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.mVideoUrl = intent.getStringExtra("video_url");
            this.mThumbUrl = intent.getStringExtra(AdWebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.mUc = intent.getFloatExtra(AdWebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.mUd = intent.getIntExtra(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
            this.mUg = intent.getIntExtra(AdWebVideoActivityConfig.KEY_GOOD_STYLE, 7);
            String stringExtra = intent.getStringExtra(AdWebVideoActivityConfig.KEY_TAIL_FRAME);
            if (!TextUtils.isEmpty(stringExtra)) {
                this.mUh = new AdCard.g();
                this.mUh.RL(stringExtra);
            }
        } else if (bundle != null) {
            this.mVideoUrl = bundle.getString("video_url");
            this.mThumbUrl = bundle.getString(AdWebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.mUc = bundle.getFloat(AdWebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.mUd = bundle.getInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
            this.mUg = bundle.getInt(AdWebVideoActivityConfig.KEY_GOOD_STYLE, 7);
        } else {
            BdLog.e("NewWebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.mUe > this.mUf && this.mTZ != null) {
            this.mTZ.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.mUe > 0 && this.mTZ != null) {
            this.mTZ.stopPlay(this.mTZ.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.mTZ != null) {
            this.mTZ.stopPlay(this.mTZ.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.new_ad_web_video_view, (ViewGroup) null, false);
        this.mUb = (WebViewContainer) frameLayout.findViewById(R.id.web_scroll);
        this.giF = (TBAdWebView) frameLayout.findViewById(R.id.web_web);
        bLx();
        this.mTZ = (DistributeVideoView) frameLayout.findViewById(R.id.web_video);
        if (TextUtils.isEmpty(this.mVideoUrl) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.mTZ.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.mVideoUrl;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_duration = Integer.valueOf(this.mUd);
            if (this.mUg == 14) {
                builder.video_height = Integer.valueOf(l.getEquipmentWidth(getActivity()));
                builder.video_width = Integer.valueOf(com.baidu.tieba.recapp.lego.a.a.HU(builder.video_height.intValue()));
            } else {
                builder.video_width = Integer.valueOf(l.getEquipmentWidth(getActivity()));
                builder.video_height = builder.video_width;
                if (this.mUc > 0.0f) {
                    builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.mUc));
                }
            }
            VideoInfo build = builder.build(false);
            this.mUe = build.video_height.intValue();
            this.mUb.setTopMargin(this.mUe);
            this.mUb.setTopLimit(this.mUe);
            this.mUb.setOnScrollChangeListener(this.mUi);
            this.mUb.setStyle(TbadkCoreApplication.getInst().getAdVideoPageStyle());
            this.mVideoHeight = build.video_height.intValue();
            this.mUf = this.mVideoHeight / 2;
            if (this.mUh != null) {
                this.mTZ.setVideoTailFrameData(this.mUh);
            }
            this.mTZ.setPageContext(getPageContext());
            this.mTZ.setData(build, 2, getPageContext());
            this.mTZ.setTailFrameIsMiddlePage(true);
            this.mTZ.initVideoViewLayout(this.mUg == 14);
            if (mTY != null) {
                this.mTZ.updateTailFrameView(mTY.mUl);
                this.mTZ.setStatisticInfo(mTY.mUl, mTY.mPageNum, mTY.mPage);
            } else {
                this.mTZ.updateTailFrameView(null);
            }
            this.mTZ.autoPlay(0);
            HP(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void HP(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.giF.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.getEquipmentHeight(getActivity()) - l.getStatusBarHeight(getActivity())) - dDG();
            this.giF.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public void onReceivedError(int i) {
        if (i != -2) {
            super.onReceivedError(i);
        }
    }

    private int dDG() {
        return l.getDimens(this, R.dimen.ds98);
    }

    public static void a(AdvertAppInfo advertAppInfo, int i, String str) {
        mTY = new a();
        mTY.mUl = advertAppInfo;
        mTY.mPage = str;
        mTY.mPageNum = i;
    }

    public static void a(AdWebVideoActivityConfig adWebVideoActivityConfig) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, adWebVideoActivityConfig));
    }
}
