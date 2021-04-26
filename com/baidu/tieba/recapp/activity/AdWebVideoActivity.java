package com.baidu.tieba.recapp.activity;

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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity;
import com.baidu.tieba.ad.browser.newstyle.TBAdWebView;
import com.baidu.tieba.recapp.view.DistributeVideoView;
import com.baidu.tieba.recapp.view.WebViewContainer;
import d.a.c.e.p.l;
import d.a.j0.s2.e0.b.e;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class AdWebVideoActivity extends AdWebViewActivity {
    public static b STATISTIC_DATA = null;
    public static final String TAG = "NewWebVideoActivity: ";
    public int mGoodsStyle;
    public int mPausePos;
    public WebViewContainer.OnScrollChangedCallback mScrollCallback = new a();
    public String mThumbUrl;
    public int mVideoDuration;
    public int mVideoHeight;
    public float mVideoRatio;
    public e mVideoTailFrame;
    public String mVideoUrl;
    public DistributeVideoView mVideoView;
    public WebViewContainer mWebContainer;
    public int mWebViewTopMargin;

    /* loaded from: classes3.dex */
    public class a implements WebViewContainer.OnScrollChangedCallback {
        public a() {
        }

        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i2, int i3) {
            AdWebVideoActivity.this.mWebViewTopMargin -= i3;
            if (AdWebVideoActivity.this.mWebViewTopMargin <= 0) {
                AdWebVideoActivity.this.mVideoView.stopPlay(AdWebVideoActivity.this.mVideoView.getPlayStatus() != 2);
            } else if (AdWebVideoActivity.this.mWebViewTopMargin < AdWebVideoActivity.this.mPausePos) {
                AdWebVideoActivity.this.mVideoView.pausePlay(1);
            } else if (AdWebVideoActivity.this.mVideoView.getPlayStatus() == 2) {
                AdWebVideoActivity.this.mVideoView.autoContinue();
            } else if (AdWebVideoActivity.this.mVideoView.getPlayStatus() == -1) {
                AdWebVideoActivity.this.mVideoView.autoPlay(0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public AdvertAppInfo f20933a;

        /* renamed from: b  reason: collision with root package name */
        public int f20934b;

        /* renamed from: c  reason: collision with root package name */
        public String f20935c;
    }

    private void configWebviewParams(int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mWebView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i2;
            layoutParams.height = (l.i(getActivity()) - l.r(getActivity())) - getToolBarHeight();
            this.mWebView.setLayoutParams(layoutParams);
        }
    }

    private int getToolBarHeight() {
        return l.g(this, R.dimen.ds98);
    }

    public static void setConfigAndJump(AdWebVideoActivityConfig adWebVideoActivityConfig) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, adWebVideoActivityConfig));
    }

    public static void setStaticInfo(AdvertAppInfo advertAppInfo, int i2, String str) {
        b bVar = new b();
        STATISTIC_DATA = bVar;
        bVar.f20933a = advertAppInfo;
        bVar.f20935c = str;
        bVar.f20934b = i2;
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.new_ad_web_video_view, (ViewGroup) null, false);
        this.mWebContainer = (WebViewContainer) frameLayout.findViewById(R.id.web_scroll);
        this.mWebView = (TBAdWebView) frameLayout.findViewById(R.id.web_web);
        configWebView();
        this.mVideoView = (DistributeVideoView) frameLayout.findViewById(R.id.web_video);
        if (!TextUtils.isEmpty(this.mVideoUrl) && !TextUtils.isEmpty(this.mThumbUrl)) {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.mVideoUrl;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_duration = Integer.valueOf(this.mVideoDuration);
            if (this.mGoodsStyle == 14) {
                Integer valueOf = Integer.valueOf(l.k(getActivity()));
                builder.video_height = valueOf;
                builder.video_width = Integer.valueOf(d.a.j0.s2.e0.c.a.c(valueOf.intValue()));
            } else {
                Integer valueOf2 = Integer.valueOf(l.k(getActivity()));
                builder.video_width = valueOf2;
                builder.video_height = valueOf2;
                if (this.mVideoRatio > 0.0f) {
                    builder.video_height = Integer.valueOf((int) (valueOf2.intValue() / this.mVideoRatio));
                }
            }
            VideoInfo build = builder.build(false);
            int intValue = build.video_height.intValue();
            this.mWebViewTopMargin = intValue;
            this.mWebContainer.setTopMargin(intValue);
            this.mWebContainer.setTopLimit(this.mWebViewTopMargin);
            this.mWebContainer.setOnScrollChangeListener(this.mScrollCallback);
            this.mWebContainer.setStyle(TbadkCoreApplication.getInst().getAdVideoPageStyle());
            int intValue2 = build.video_height.intValue();
            this.mVideoHeight = intValue2;
            this.mPausePos = intValue2 / 2;
            e eVar = this.mVideoTailFrame;
            if (eVar != null) {
                this.mVideoView.setVideoTailFrameData(eVar);
            }
            this.mVideoView.setPageContext(getPageContext());
            this.mVideoView.setData(build, 2, getPageContext());
            this.mVideoView.setTailFrameIsMiddlePage(true);
            this.mVideoView.initVideoViewLayout(this.mGoodsStyle == 14);
            b bVar = STATISTIC_DATA;
            if (bVar != null) {
                this.mVideoView.updateTailFrameView(bVar.f20933a);
                DistributeVideoView distributeVideoView = this.mVideoView;
                b bVar2 = STATISTIC_DATA;
                distributeVideoView.setStatisticInfo(bVar2.f20933a, bVar2.f20934b, bVar2.f20935c);
            } else {
                this.mVideoView.updateTailFrameView(null);
            }
            this.mVideoView.autoPlay(0);
            configWebviewParams(build.video_height.intValue());
        } else {
            this.mVideoView.setVisibility(8);
        }
        return frameLayout;
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.mVideoUrl = intent.getStringExtra("video_url");
            this.mThumbUrl = intent.getStringExtra(AdWebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.mVideoRatio = intent.getFloatExtra(AdWebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.mVideoDuration = intent.getIntExtra(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
            this.mGoodsStyle = intent.getIntExtra(AdWebVideoActivityConfig.KEY_GOOD_STYLE, 7);
            String stringExtra = intent.getStringExtra(AdWebVideoActivityConfig.KEY_TAIL_FRAME);
            if (!TextUtils.isEmpty(stringExtra)) {
                e eVar = new e();
                this.mVideoTailFrame = eVar;
                eVar.c(stringExtra);
            }
        } else if (bundle != null) {
            this.mVideoUrl = bundle.getString("video_url");
            this.mThumbUrl = bundle.getString(AdWebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.mVideoRatio = bundle.getFloat(AdWebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.mVideoDuration = bundle.getInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
            this.mGoodsStyle = bundle.getInt(AdWebVideoActivityConfig.KEY_GOOD_STYLE, 7);
        } else {
            BdLog.e("NewWebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        DistributeVideoView distributeVideoView = this.mVideoView;
        if (distributeVideoView != null) {
            distributeVideoView.stopPlay(distributeVideoView.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        DistributeVideoView distributeVideoView;
        if (this.mWebViewTopMargin > 0 && (distributeVideoView = this.mVideoView) != null) {
            distributeVideoView.stopPlay(distributeVideoView.getPlayStatus() != 2);
        }
        super.onPause();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public void onReceivedError(int i2) {
        if (i2 == -2) {
            return;
        }
        super.onReceivedError(i2);
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        DistributeVideoView distributeVideoView;
        if (this.mWebViewTopMargin > this.mPausePos && (distributeVideoView = this.mVideoView) != null) {
            distributeVideoView.autoPlay(0);
        }
        super.onResume();
    }
}
