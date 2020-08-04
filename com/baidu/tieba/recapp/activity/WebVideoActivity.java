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
/* loaded from: classes20.dex */
public class WebVideoActivity extends AdTbWebViewActivity {
    public static a llQ;
    private DistributeVideoView llR;
    private WebViewContainer llS;
    private float llT;
    private int llU;
    private int llV;
    private int llW;
    private int llX;
    private AdCard.a llY;
    private AdCard.f llZ;
    private WebViewContainer.OnScrollChangedCallback lma = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.WebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            WebVideoActivity.this.llV -= i2;
            if (WebVideoActivity.this.llV <= 0) {
                WebVideoActivity.this.llR.stopPlay(WebVideoActivity.this.llR.getPlayStatus() != 2);
            } else if (WebVideoActivity.this.llV < WebVideoActivity.this.llW) {
                WebVideoActivity.this.llR.pausePlay(1);
            } else if (WebVideoActivity.this.llR.getPlayStatus() == 2) {
                WebVideoActivity.this.llR.autoContinue();
            } else if (WebVideoActivity.this.llR.getPlayStatus() == -1) {
                WebVideoActivity.this.llR.autoPlay(0);
            }
        }
    };
    private String mThumbUrl;
    private int mVideoHeight;
    private String mVideoUrl;

    /* loaded from: classes20.dex */
    public static class a {
        public AdvertAppInfo lmc;
        public String mPage;
        public int mPageNum;
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.mVideoUrl = intent.getStringExtra("video_url");
            this.mThumbUrl = intent.getStringExtra("video_thumb_url");
            this.llT = intent.getFloatExtra("video_ratio", 1.0f);
            this.llU = intent.getIntExtra("video_duration", 0);
            this.llX = intent.getIntExtra("good_style", 7);
            String stringExtra = intent.getStringExtra("charge_style");
            String stringExtra2 = intent.getStringExtra("charge_url");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.llY = new AdCard.a();
                this.llY.lnb = stringExtra2;
                this.llY.lna = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra("tail_frame");
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.llZ = new AdCard.f();
                this.llZ.Mt(stringExtra3);
            }
        } else if (bundle != null) {
            this.mVideoUrl = bundle.getString("video_url");
            this.mThumbUrl = bundle.getString("video_thumb_url");
            this.llT = bundle.getFloat("video_ratio", 1.0f);
            this.llU = bundle.getInt("video_duration", 0);
            this.llX = bundle.getInt("good_style", 7);
        } else {
            BdLog.e("WebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.llV > this.llW && this.llR != null) {
            this.llR.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.llV > 0 && this.llR != null) {
            this.llR.stopPlay(this.llR.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.llR != null) {
            this.llR.stopPlay(this.llR.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.ad_web_video_view, (ViewGroup) null, false);
        this.llS = (WebViewContainer) frameLayout.findViewById(R.id.web_scroll);
        this.fcO = (AdBaseWebView) frameLayout.findViewById(R.id.web_web);
        brY();
        this.llR = (DistributeVideoView) frameLayout.findViewById(R.id.web_video);
        if (TextUtils.isEmpty(this.mVideoUrl) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.llR.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.mVideoUrl;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_duration = Integer.valueOf(this.llU);
            if (this.llX == 14) {
                builder.video_height = Integer.valueOf(l.getEquipmentWidth(getActivity()));
                builder.video_width = Integer.valueOf(com.baidu.c.a.e.a.bA(builder.video_height.intValue()));
            } else {
                builder.video_width = Integer.valueOf(l.getEquipmentWidth(getActivity()));
                builder.video_height = builder.video_width;
                if (this.llT > 0.0f) {
                    builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.llT));
                }
            }
            VideoInfo build = builder.build(false);
            this.llV = build.video_height.intValue();
            this.llS.setTopMargin(this.llV);
            this.llS.setTopLimit(this.llV);
            this.llS.setOnScrollChangeListener(this.lma);
            d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.llS.setStyle(adAdSense.bdS());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.llW = this.mVideoHeight / 2;
            if (this.llZ != null) {
                this.llR.setVideoTailFrameData(this.llZ);
            }
            this.llR.setPageContext(getPageContext());
            this.llR.setData(build, 2, getPageContext());
            if (llQ != null) {
                this.llR.updateTailFrameView(llQ.lmc);
                this.llR.setStatisticInfo(llQ.lmc, llQ.mPageNum, llQ.mPage);
            } else {
                this.llR.updateTailFrameView(null);
            }
            this.llR.setChargeInfo(this.llY);
            this.llR.autoPlay(0);
            this.llR.initVideoViewLayout(this.llX == 14);
            DJ(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void DJ(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fcO.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.getEquipmentHeight(getActivity()) - l.getStatusBarHeight(getActivity())) - dce();
            this.fcO.setLayoutParams(layoutParams);
        }
    }

    private int dce() {
        return l.getDimens(this, R.dimen.ds98);
    }
}
