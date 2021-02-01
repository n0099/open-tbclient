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
    public static a mRA;
    private DistributeVideoView mRB;
    private WebViewContainer mRC;
    private float mRD;
    private int mRE;
    private int mRF;
    private int mRG;
    private int mRH;
    private AdCard.f mRI;
    private WebViewContainer.OnScrollChangedCallback mRJ = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.newstyle.AdWebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            AdWebVideoActivity.this.mRF -= i2;
            if (AdWebVideoActivity.this.mRF <= 0) {
                AdWebVideoActivity.this.mRB.stopPlay(AdWebVideoActivity.this.mRB.getPlayStatus() != 2);
            } else if (AdWebVideoActivity.this.mRF < AdWebVideoActivity.this.mRG) {
                AdWebVideoActivity.this.mRB.pausePlay(1);
            } else if (AdWebVideoActivity.this.mRB.getPlayStatus() == 2) {
                AdWebVideoActivity.this.mRB.autoContinue();
            } else if (AdWebVideoActivity.this.mRB.getPlayStatus() == -1) {
                AdWebVideoActivity.this.mRB.autoPlay(0);
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
        public AdvertAppInfo mRL;
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.mVideoUrl = intent.getStringExtra("video_url");
            this.mThumbUrl = intent.getStringExtra(AdWebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.mRD = intent.getFloatExtra(AdWebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.mRE = intent.getIntExtra(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
            this.mRH = intent.getIntExtra(AdWebVideoActivityConfig.KEY_GOOD_STYLE, 7);
            String stringExtra = intent.getStringExtra(AdWebVideoActivityConfig.KEY_TAIL_FRAME);
            if (!TextUtils.isEmpty(stringExtra)) {
                this.mRI = new AdCard.f();
                this.mRI.Rt(stringExtra);
            }
        } else if (bundle != null) {
            this.mVideoUrl = bundle.getString("video_url");
            this.mThumbUrl = bundle.getString(AdWebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.mRD = bundle.getFloat(AdWebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.mRE = bundle.getInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
            this.mRH = bundle.getInt(AdWebVideoActivityConfig.KEY_GOOD_STYLE, 7);
        } else {
            BdLog.e("NewWebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.mRF > this.mRG && this.mRB != null) {
            this.mRB.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.mRF > 0 && this.mRB != null) {
            this.mRB.stopPlay(this.mRB.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.mRB != null) {
            this.mRB.stopPlay(this.mRB.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.new_ad_web_video_view, (ViewGroup) null, false);
        this.mRC = (WebViewContainer) frameLayout.findViewById(R.id.web_scroll);
        this.ggV = (TBAdWebView) frameLayout.findViewById(R.id.web_web);
        bLo();
        this.mRB = (DistributeVideoView) frameLayout.findViewById(R.id.web_video);
        if (TextUtils.isEmpty(this.mVideoUrl) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.mRB.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.mVideoUrl;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_duration = Integer.valueOf(this.mRE);
            if (this.mRH == 14) {
                builder.video_height = Integer.valueOf(l.getEquipmentWidth(getActivity()));
                builder.video_width = Integer.valueOf(com.baidu.tieba.recapp.lego.a.a.HR(builder.video_height.intValue()));
            } else {
                builder.video_width = Integer.valueOf(l.getEquipmentWidth(getActivity()));
                builder.video_height = builder.video_width;
                if (this.mRD > 0.0f) {
                    builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.mRD));
                }
            }
            VideoInfo build = builder.build(false);
            this.mRF = build.video_height.intValue();
            this.mRC.setTopMargin(this.mRF);
            this.mRC.setTopLimit(this.mRF);
            this.mRC.setOnScrollChangeListener(this.mRJ);
            this.mRC.setStyle(TbadkCoreApplication.getInst().getAdVideoPageStyle());
            this.mVideoHeight = build.video_height.intValue();
            this.mRG = this.mVideoHeight / 2;
            if (this.mRI != null) {
                this.mRB.setVideoTailFrameData(this.mRI);
            }
            this.mRB.setPageContext(getPageContext());
            this.mRB.setData(build, 2, getPageContext());
            this.mRB.setTailFrameIsMiddlePage(true);
            this.mRB.initVideoViewLayout(this.mRH == 14);
            if (mRA != null) {
                this.mRB.updateTailFrameView(mRA.mRL);
                this.mRB.setStatisticInfo(mRA.mRL, mRA.mPageNum, mRA.mPage);
            } else {
                this.mRB.updateTailFrameView(null);
            }
            this.mRB.autoPlay(0);
            HM(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void HM(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ggV.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.getEquipmentHeight(getActivity()) - l.getStatusBarHeight(getActivity())) - dDr();
            this.ggV.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public void onReceivedError(int i) {
        if (i != -2) {
            super.onReceivedError(i);
        }
    }

    private int dDr() {
        return l.getDimens(this, R.dimen.ds98);
    }

    public static void a(AdvertAppInfo advertAppInfo, int i, String str) {
        mRA = new a();
        mRA.mRL = advertAppInfo;
        mRA.mPage = str;
        mRA.mPageNum = i;
    }

    public static void a(AdWebVideoActivityConfig adWebVideoActivityConfig) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, adWebVideoActivityConfig));
    }
}
