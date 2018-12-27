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
    public static a gOu;
    private String aEO;
    private int gGg;
    private AdCard.a gOA;
    private AdCard.f gOB;
    private WebViewContainer.OnScrollChangedCallback gOC = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.WebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            WebVideoActivity.this.gOy -= i2;
            if (WebVideoActivity.this.gOy <= 0) {
                WebVideoActivity.this.gOv.stopPlay(WebVideoActivity.this.gOv.getPlayStatus() != 2);
            } else if (WebVideoActivity.this.gOy < WebVideoActivity.this.gOz) {
                WebVideoActivity.this.gOv.pausePlay(1);
            } else if (WebVideoActivity.this.gOv.getPlayStatus() == 2) {
                WebVideoActivity.this.gOv.autoContinue();
            } else if (WebVideoActivity.this.gOv.getPlayStatus() == -1) {
                WebVideoActivity.this.gOv.autoPlay(0);
            }
        }
    };
    private DistributeVideoView gOv;
    private WebViewContainer gOw;
    private float gOx;
    private int gOy;
    private int gOz;
    private String mThumbUrl;
    private int mVideoHeight;

    /* loaded from: classes3.dex */
    public static class a {
        public AdvertAppInfo gOE;
        public String mPage;
        public int mPageNum;
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.aEO = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.gOx = intent.getFloatExtra(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.gGg = intent.getIntExtra(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
            String stringExtra = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_STYLE);
            String stringExtra2 = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_URL);
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.gOA = new AdCard.a();
                this.gOA.gPz = stringExtra2;
                this.gOA.gPy = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra(WebVideoActivityConfig.KEY_TAIL_FRAME);
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.gOB = new AdCard.f();
                this.gOB.uE(stringExtra3);
            }
        } else if (bundle != null) {
            this.aEO = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.gOx = bundle.getFloat(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.gGg = bundle.getInt(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
        } else {
            BdLog.e("WebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.gOy > this.gOz && this.gOv != null) {
            this.gOv.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.gOy > 0 && this.gOv != null) {
            this.gOv.stopPlay(this.gOv.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.gOv != null) {
            this.gOv.stopPlay(this.gOv.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(e.h.ad_web_video_view, (ViewGroup) null, false);
        this.gOw = (WebViewContainer) frameLayout.findViewById(e.g.web_scroll);
        this.bBC = (AdBaseWebView) frameLayout.findViewById(e.g.web_web);
        Wk();
        this.gOv = (DistributeVideoView) frameLayout.findViewById(e.g.web_video);
        if (TextUtils.isEmpty(this.aEO) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.gOv.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.aEO;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_width = Integer.valueOf(l.aO(getActivity()));
            builder.video_height = builder.video_width;
            builder.video_duration = Integer.valueOf(this.gGg);
            if (this.gOx > 0.0f) {
                builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.gOx));
            }
            VideoInfo build = builder.build(false);
            this.gOy = build.video_height.intValue();
            this.gOw.setTopMargin(this.gOy);
            this.gOw.setTopLimit(this.gOy);
            this.gOw.setOnScrollChangeListener(this.gOC);
            d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.gOw.setStyle(adAdSense.GA());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.gOz = this.mVideoHeight / 2;
            if (this.gOB != null) {
                this.gOv.setVideoTailFrameData(this.gOB);
            }
            this.gOv.setPageContext(getPageContext());
            this.gOv.setData(build, 2, getPageContext());
            this.gOv.updateTailFrameView(null);
            if (gOu != null) {
                this.gOv.setStatisticInfo(gOu.gOE, gOu.mPageNum, gOu.mPage);
            }
            this.gOv.setChargeInfo(this.gOA);
            this.gOv.autoPlay(0);
            tY(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void tY(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bBC.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.aQ(getActivity()) - l.r(getActivity())) - bvp();
            this.bBC.setLayoutParams(layoutParams);
        }
    }

    private int bvp() {
        return l.h(this, e.C0210e.ds98);
    }
}
