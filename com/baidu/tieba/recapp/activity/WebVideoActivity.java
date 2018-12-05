package com.baidu.tieba.recapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.coreExtra.data.d;
import com.baidu.tieba.ad.browser.AdBaseWebView;
import com.baidu.tieba.ad.browser.AdTbWebViewActivity;
import com.baidu.tieba.e;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.DistributeVideoView;
import com.baidu.tieba.recapp.view.WebViewContainer;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class WebVideoActivity extends AdTbWebViewActivity {
    public static a gLD;
    private String aEN;
    private int gDp;
    private DistributeVideoView gLE;
    private WebViewContainer gLF;
    private float gLG;
    private int gLH;
    private int gLI;
    private AdCard.a gLJ;
    private AdCard.f gLK;
    private WebViewContainer.OnScrollChangedCallback gLL = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.WebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            WebVideoActivity.this.gLH -= i2;
            if (WebVideoActivity.this.gLH <= 0) {
                WebVideoActivity.this.gLE.stopPlay(WebVideoActivity.this.gLE.getPlayStatus() != 2);
            } else if (WebVideoActivity.this.gLH < WebVideoActivity.this.gLI) {
                WebVideoActivity.this.gLE.pausePlay(1);
            } else if (WebVideoActivity.this.gLE.getPlayStatus() == 2) {
                WebVideoActivity.this.gLE.autoContinue();
            } else if (WebVideoActivity.this.gLE.getPlayStatus() == -1) {
                WebVideoActivity.this.gLE.autoPlay(0);
            }
        }
    };
    private String mThumbUrl;
    private int mVideoHeight;

    /* loaded from: classes3.dex */
    public static class a {
        public AdvertAppInfo gLN;
        public String mPage;
        public int mPageNum;
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.aEN = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.gLG = intent.getFloatExtra(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.gDp = intent.getIntExtra(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
            String stringExtra = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_STYLE);
            String stringExtra2 = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_URL);
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.gLJ = new AdCard.a();
                this.gLJ.gMH = stringExtra2;
                this.gLJ.gMG = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra(WebVideoActivityConfig.KEY_TAIL_FRAME);
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.gLK = new AdCard.f();
                this.gLK.uB(stringExtra3);
            }
        } else if (bundle != null) {
            this.aEN = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.gLG = bundle.getFloat(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.gDp = bundle.getInt(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
        } else {
            BdLog.e("WebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.gLH > this.gLI && this.gLE != null) {
            this.gLE.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.gLH > 0 && this.gLE != null) {
            this.gLE.stopPlay(this.gLE.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.gLE != null) {
            this.gLE.stopPlay(this.gLE.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(e.h.ad_web_video_view, (ViewGroup) null, false);
        this.gLF = (WebViewContainer) frameLayout.findViewById(e.g.web_scroll);
        this.bBz = (AdBaseWebView) frameLayout.findViewById(e.g.web_web);
        Wi();
        this.gLE = (DistributeVideoView) frameLayout.findViewById(e.g.web_video);
        if (TextUtils.isEmpty(this.aEN) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.gLE.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.aEN;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_width = Integer.valueOf(l.aO(getActivity()));
            builder.video_height = builder.video_width;
            builder.video_duration = Integer.valueOf(this.gDp);
            if (this.gLG > 0.0f) {
                builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.gLG));
            }
            VideoInfo build = builder.build(false);
            this.gLH = build.video_height.intValue();
            this.gLF.setTopMargin(this.gLH);
            this.gLF.setTopLimit(this.gLH);
            this.gLF.setOnScrollChangeListener(this.gLL);
            d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.gLF.setStyle(adAdSense.Gz());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.gLI = this.mVideoHeight / 2;
            if (this.gLK != null) {
                this.gLE.setVideoTailFrameData(this.gLK);
            }
            this.gLE.setPageContext(getPageContext());
            this.gLE.setData(build, 2, getPageContext());
            this.gLE.updateTailFrameView(null);
            if (gLD != null) {
                this.gLE.setStatisticInfo(gLD.gLN, gLD.mPageNum, gLD.mPage);
            }
            this.gLE.setChargeInfo(this.gLJ);
            this.gLE.autoPlay(0);
            tL(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void tL(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bBz.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.aQ(getActivity()) - l.r(getActivity())) - buE();
            this.bBz.setLayoutParams(layoutParams);
        }
    }

    private int buE() {
        return l.h(this, e.C0210e.ds98);
    }
}
