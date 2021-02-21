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
/* loaded from: classes8.dex */
public class AdWebVideoActivity extends AdWebViewActivity {
    public static a mRS;
    private DistributeVideoView mRT;
    private WebViewContainer mRU;
    private float mRV;
    private int mRW;
    private int mRX;
    private int mRY;
    private int mRZ;
    private AdCard.f mSa;
    private WebViewContainer.OnScrollChangedCallback mSb = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.newstyle.AdWebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            AdWebVideoActivity.this.mRX -= i2;
            if (AdWebVideoActivity.this.mRX <= 0) {
                AdWebVideoActivity.this.mRT.stopPlay(AdWebVideoActivity.this.mRT.getPlayStatus() != 2);
            } else if (AdWebVideoActivity.this.mRX < AdWebVideoActivity.this.mRY) {
                AdWebVideoActivity.this.mRT.pausePlay(1);
            } else if (AdWebVideoActivity.this.mRT.getPlayStatus() == 2) {
                AdWebVideoActivity.this.mRT.autoContinue();
            } else if (AdWebVideoActivity.this.mRT.getPlayStatus() == -1) {
                AdWebVideoActivity.this.mRT.autoPlay(0);
            }
        }
    };
    private String mThumbUrl;
    private int mVideoHeight;
    private String mVideoUrl;

    /* loaded from: classes8.dex */
    public static class a {
        public String mPage;
        public int mPageNum;
        public AdvertAppInfo mSd;
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.mVideoUrl = intent.getStringExtra("video_url");
            this.mThumbUrl = intent.getStringExtra(AdWebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.mRV = intent.getFloatExtra(AdWebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.mRW = intent.getIntExtra(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
            this.mRZ = intent.getIntExtra(AdWebVideoActivityConfig.KEY_GOOD_STYLE, 7);
            String stringExtra = intent.getStringExtra(AdWebVideoActivityConfig.KEY_TAIL_FRAME);
            if (!TextUtils.isEmpty(stringExtra)) {
                this.mSa = new AdCard.f();
                this.mSa.RF(stringExtra);
            }
        } else if (bundle != null) {
            this.mVideoUrl = bundle.getString("video_url");
            this.mThumbUrl = bundle.getString(AdWebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.mRV = bundle.getFloat(AdWebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.mRW = bundle.getInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
            this.mRZ = bundle.getInt(AdWebVideoActivityConfig.KEY_GOOD_STYLE, 7);
        } else {
            BdLog.e("NewWebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.mRX > this.mRY && this.mRT != null) {
            this.mRT.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.mRX > 0 && this.mRT != null) {
            this.mRT.stopPlay(this.mRT.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.mRT != null) {
            this.mRT.stopPlay(this.mRT.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.new_ad_web_video_view, (ViewGroup) null, false);
        this.mRU = (WebViewContainer) frameLayout.findViewById(R.id.web_scroll);
        this.ghb = (TBAdWebView) frameLayout.findViewById(R.id.web_web);
        bLt();
        this.mRT = (DistributeVideoView) frameLayout.findViewById(R.id.web_video);
        if (TextUtils.isEmpty(this.mVideoUrl) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.mRT.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.mVideoUrl;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_duration = Integer.valueOf(this.mRW);
            if (this.mRZ == 14) {
                builder.video_height = Integer.valueOf(l.getEquipmentWidth(getActivity()));
                builder.video_width = Integer.valueOf(com.baidu.tieba.recapp.lego.a.a.HR(builder.video_height.intValue()));
            } else {
                builder.video_width = Integer.valueOf(l.getEquipmentWidth(getActivity()));
                builder.video_height = builder.video_width;
                if (this.mRV > 0.0f) {
                    builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.mRV));
                }
            }
            VideoInfo build = builder.build(false);
            this.mRX = build.video_height.intValue();
            this.mRU.setTopMargin(this.mRX);
            this.mRU.setTopLimit(this.mRX);
            this.mRU.setOnScrollChangeListener(this.mSb);
            this.mRU.setStyle(TbadkCoreApplication.getInst().getAdVideoPageStyle());
            this.mVideoHeight = build.video_height.intValue();
            this.mRY = this.mVideoHeight / 2;
            if (this.mSa != null) {
                this.mRT.setVideoTailFrameData(this.mSa);
            }
            this.mRT.setPageContext(getPageContext());
            this.mRT.setData(build, 2, getPageContext());
            this.mRT.setTailFrameIsMiddlePage(true);
            this.mRT.initVideoViewLayout(this.mRZ == 14);
            if (mRS != null) {
                this.mRT.updateTailFrameView(mRS.mSd);
                this.mRT.setStatisticInfo(mRS.mSd, mRS.mPageNum, mRS.mPage);
            } else {
                this.mRT.updateTailFrameView(null);
            }
            this.mRT.autoPlay(0);
            HM(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void HM(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ghb.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.getEquipmentHeight(getActivity()) - l.getStatusBarHeight(getActivity())) - dDy();
            this.ghb.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public void onReceivedError(int i) {
        if (i != -2) {
            super.onReceivedError(i);
        }
    }

    private int dDy() {
        return l.getDimens(this, R.dimen.ds98);
    }

    public static void a(AdvertAppInfo advertAppInfo, int i, String str) {
        mRS = new a();
        mRS.mSd = advertAppInfo;
        mRS.mPage = str;
        mRS.mPageNum = i;
    }

    public static void a(AdWebVideoActivityConfig adWebVideoActivityConfig) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, adWebVideoActivityConfig));
    }
}
