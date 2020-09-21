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
import com.baidu.tieba.R;
import com.baidu.tieba.ad.browser.AdBaseWebView;
import com.baidu.tieba.ad.browser.AdTbWebViewActivity;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.DistributeVideoView;
import com.baidu.tieba.recapp.view.WebViewContainer;
import tbclient.VideoInfo;
@Deprecated
/* loaded from: classes25.dex */
public class WebVideoActivity extends AdTbWebViewActivity {
    public static a lLw;
    private int lLA;
    private int lLB;
    private int lLC;
    private int lLD;
    private AdCard.a lLE;
    private AdCard.f lLF;
    private WebViewContainer.OnScrollChangedCallback lLG = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.WebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            WebVideoActivity.this.lLB -= i2;
            if (WebVideoActivity.this.lLB <= 0) {
                WebVideoActivity.this.lLx.stopPlay(WebVideoActivity.this.lLx.getPlayStatus() != 2);
            } else if (WebVideoActivity.this.lLB < WebVideoActivity.this.lLC) {
                WebVideoActivity.this.lLx.pausePlay(1);
            } else if (WebVideoActivity.this.lLx.getPlayStatus() == 2) {
                WebVideoActivity.this.lLx.autoContinue();
            } else if (WebVideoActivity.this.lLx.getPlayStatus() == -1) {
                WebVideoActivity.this.lLx.autoPlay(0);
            }
        }
    };
    private DistributeVideoView lLx;
    private WebViewContainer lLy;
    private float lLz;
    private String mThumbUrl;
    private int mVideoHeight;
    private String mVideoUrl;

    /* loaded from: classes25.dex */
    public static class a {
        public AdvertAppInfo lLI;
        public String mPage;
        public int mPageNum;
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.mVideoUrl = intent.getStringExtra("video_url");
            this.mThumbUrl = intent.getStringExtra("video_thumb_url");
            this.lLz = intent.getFloatExtra("video_ratio", 1.0f);
            this.lLA = intent.getIntExtra("video_duration", 0);
            this.lLD = intent.getIntExtra("good_style", 7);
            String stringExtra = intent.getStringExtra("charge_style");
            String stringExtra2 = intent.getStringExtra("charge_url");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.lLE = new AdCard.a();
                this.lLE.lMH = stringExtra2;
                this.lLE.lMG = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra("tail_frame");
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.lLF = new AdCard.f();
                this.lLF.PS(stringExtra3);
            }
        } else if (bundle != null) {
            this.mVideoUrl = bundle.getString("video_url");
            this.mThumbUrl = bundle.getString("video_thumb_url");
            this.lLz = bundle.getFloat("video_ratio", 1.0f);
            this.lLA = bundle.getInt("video_duration", 0);
            this.lLD = bundle.getInt("good_style", 7);
        } else {
            BdLog.e("WebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.lLB > this.lLC && this.lLx != null) {
            this.lLx.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.lLB > 0 && this.lLx != null) {
            this.lLx.stopPlay(this.lLx.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.lLx != null) {
            this.lLx.stopPlay(this.lLx.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.ad_web_video_view, (ViewGroup) null, false);
        this.lLy = (WebViewContainer) frameLayout.findViewById(R.id.web_scroll);
        this.frr = (AdBaseWebView) frameLayout.findViewById(R.id.web_web);
        bCi();
        this.lLx = (DistributeVideoView) frameLayout.findViewById(R.id.web_video);
        if (TextUtils.isEmpty(this.mVideoUrl) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.lLx.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.mVideoUrl;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_duration = Integer.valueOf(this.lLA);
            if (this.lLD == 14) {
                builder.video_height = Integer.valueOf(l.getEquipmentWidth(getActivity()));
                builder.video_width = Integer.valueOf(com.baidu.g.a.e.a.m22do(builder.video_height.intValue()));
            } else {
                builder.video_width = Integer.valueOf(l.getEquipmentWidth(getActivity()));
                builder.video_height = builder.video_width;
                if (this.lLz > 0.0f) {
                    builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.lLz));
                }
            }
            VideoInfo build = builder.build(false);
            this.lLB = build.video_height.intValue();
            this.lLy.setTopMargin(this.lLB);
            this.lLy.setTopLimit(this.lLB);
            this.lLy.setOnScrollChangeListener(this.lLG);
            d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.lLy.setStyle(adAdSense.bns());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.lLC = this.mVideoHeight / 2;
            if (this.lLF != null) {
                this.lLx.setVideoTailFrameData(this.lLF);
            }
            this.lLx.setPageContext(getPageContext());
            this.lLx.setData(build, 2, getPageContext());
            if (lLw != null) {
                this.lLx.updateTailFrameView(lLw.lLI);
                this.lLx.setStatisticInfo(lLw.lLI, lLw.mPageNum, lLw.mPage);
            } else {
                this.lLx.updateTailFrameView(null);
            }
            this.lLx.setChargeInfo(this.lLE);
            this.lLx.autoPlay(0);
            this.lLx.initVideoViewLayout(this.lLD == 14);
            GF(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void GF(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.frr.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.getEquipmentHeight(getActivity()) - l.getStatusBarHeight(getActivity())) - dqY();
            this.frr.setLayoutParams(layoutParams);
        }
    }

    private int dqY() {
        return l.getDimens(this, R.dimen.ds98);
    }
}
