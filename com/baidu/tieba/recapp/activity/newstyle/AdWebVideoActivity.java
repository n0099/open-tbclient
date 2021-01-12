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
    public static a mIq;
    private WebViewContainer.OnScrollChangedCallback mIA = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.newstyle.AdWebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            AdWebVideoActivity.this.mIw -= i2;
            if (AdWebVideoActivity.this.mIw <= 0) {
                AdWebVideoActivity.this.mIr.stopPlay(AdWebVideoActivity.this.mIr.getPlayStatus() != 2);
            } else if (AdWebVideoActivity.this.mIw < AdWebVideoActivity.this.mIx) {
                AdWebVideoActivity.this.mIr.pausePlay(1);
            } else if (AdWebVideoActivity.this.mIr.getPlayStatus() == 2) {
                AdWebVideoActivity.this.mIr.autoContinue();
            } else if (AdWebVideoActivity.this.mIr.getPlayStatus() == -1) {
                AdWebVideoActivity.this.mIr.autoPlay(0);
            }
        }
    };
    private DistributeVideoView mIr;
    private WebViewContainer mIt;
    private float mIu;
    private int mIv;
    private int mIw;
    private int mIx;
    private int mIy;
    private AdCard.f mIz;
    private String mThumbUrl;
    private int mVideoHeight;
    private String mVideoUrl;

    /* loaded from: classes7.dex */
    public static class a {
        public AdvertAppInfo mIC;
        public String mPage;
        public int mPageNum;
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.mVideoUrl = intent.getStringExtra("video_url");
            this.mThumbUrl = intent.getStringExtra(AdWebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.mIu = intent.getFloatExtra(AdWebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.mIv = intent.getIntExtra(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
            this.mIy = intent.getIntExtra(AdWebVideoActivityConfig.KEY_GOOD_STYLE, 7);
            String stringExtra = intent.getStringExtra(AdWebVideoActivityConfig.KEY_TAIL_FRAME);
            if (!TextUtils.isEmpty(stringExtra)) {
                this.mIz = new AdCard.f();
                this.mIz.Qx(stringExtra);
            }
        } else if (bundle != null) {
            this.mVideoUrl = bundle.getString("video_url");
            this.mThumbUrl = bundle.getString(AdWebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.mIu = bundle.getFloat(AdWebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.mIv = bundle.getInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
            this.mIy = bundle.getInt(AdWebVideoActivityConfig.KEY_GOOD_STYLE, 7);
        } else {
            BdLog.e("NewWebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.mIw > this.mIx && this.mIr != null) {
            this.mIr.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.mIw > 0 && this.mIr != null) {
            this.mIr.stopPlay(this.mIr.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.mIr != null) {
            this.mIr.stopPlay(this.mIr.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.new_ad_web_video_view, (ViewGroup) null, false);
        this.mIt = (WebViewContainer) frameLayout.findViewById(R.id.web_scroll);
        this.geH = (TBAdWebView) frameLayout.findViewById(R.id.web_web);
        bKU();
        this.mIr = (DistributeVideoView) frameLayout.findViewById(R.id.web_video);
        if (TextUtils.isEmpty(this.mVideoUrl) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.mIr.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.mVideoUrl;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_duration = Integer.valueOf(this.mIv);
            if (this.mIy == 14) {
                builder.video_height = Integer.valueOf(l.getEquipmentWidth(getActivity()));
                builder.video_width = Integer.valueOf(com.baidu.tieba.recapp.lego.a.a.Hy(builder.video_height.intValue()));
            } else {
                builder.video_width = Integer.valueOf(l.getEquipmentWidth(getActivity()));
                builder.video_height = builder.video_width;
                if (this.mIu > 0.0f) {
                    builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.mIu));
                }
            }
            VideoInfo build = builder.build(false);
            this.mIw = build.video_height.intValue();
            this.mIt.setTopMargin(this.mIw);
            this.mIt.setTopLimit(this.mIw);
            this.mIt.setOnScrollChangeListener(this.mIA);
            this.mIt.setStyle(TbadkCoreApplication.getInst().getAdVideoPageStyle());
            this.mVideoHeight = build.video_height.intValue();
            this.mIx = this.mVideoHeight / 2;
            if (this.mIz != null) {
                this.mIr.setVideoTailFrameData(this.mIz);
            }
            this.mIr.setPageContext(getPageContext());
            this.mIr.setData(build, 2, getPageContext());
            this.mIr.setTailFrameIsMiddlePage(true);
            this.mIr.initVideoViewLayout(this.mIy == 14);
            if (mIq != null) {
                this.mIr.updateTailFrameView(mIq.mIC);
                this.mIr.setStatisticInfo(mIq.mIC, mIq.mPageNum, mIq.mPage);
            } else {
                this.mIr.updateTailFrameView(null);
            }
            this.mIr.autoPlay(0);
            Ht(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void Ht(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.geH.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.getEquipmentHeight(getActivity()) - l.getStatusBarHeight(getActivity())) - dBi();
            this.geH.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public void onReceivedError(int i) {
        if (i != -2) {
            super.onReceivedError(i);
        }
    }

    private int dBi() {
        return l.getDimens(this, R.dimen.ds98);
    }

    public static void a(AdvertAppInfo advertAppInfo, int i, String str) {
        mIq = new a();
        mIq.mIC = advertAppInfo;
        mIq.mPage = str;
        mIq.mPageNum = i;
    }

    public static void a(AdWebVideoActivityConfig adWebVideoActivityConfig) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, adWebVideoActivityConfig));
    }
}
