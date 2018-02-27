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
import com.baidu.tbadk.coreExtra.data.c;
import com.baidu.tieba.ad.browser.AdBaseWebView;
import com.baidu.tieba.ad.browser.AdTbWebViewActivity;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.DistributeVideoView;
import com.baidu.tieba.recapp.view.WebViewContainer;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class WebVideoActivity extends AdTbWebViewActivity {
    public static a gBQ;
    private String bQI;
    private DistributeVideoView gBR;
    private WebViewContainer gBS;
    private float gBT;
    private int gBU;
    private int gBV;
    private AdCard.a gBW;
    private AdCard.e gBX;
    private WebViewContainer.OnScrollChangedCallback gBY = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.WebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            WebVideoActivity.this.gBU -= i2;
            if (WebVideoActivity.this.gBU <= 0) {
                WebVideoActivity.this.gBR.stopPlay();
            } else if (WebVideoActivity.this.gBU < WebVideoActivity.this.gBV) {
                WebVideoActivity.this.gBR.pausePlay(1);
            } else if (WebVideoActivity.this.gBR.getPlayStatus() == 2) {
                WebVideoActivity.this.gBR.autoContinue();
            } else if (WebVideoActivity.this.gBR.getPlayStatus() == -1) {
                WebVideoActivity.this.gBR.autoPlay(0);
            }
        }
    };
    private int guk;
    private String mThumbUrl;
    private int mVideoHeight;

    /* loaded from: classes3.dex */
    public static class a {
        public AdvertAppInfo gCa;
        public String gCb;
        public int mPageNum;
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.bQI = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.gBT = intent.getFloatExtra(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.guk = intent.getIntExtra(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
            String stringExtra = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_STYLE);
            String stringExtra2 = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_URL);
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.gBW = new AdCard.a();
                this.gBW.gCV = stringExtra2;
                this.gBW.gCU = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra(WebVideoActivityConfig.KEY_TAIL_FRAME);
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.gBX = new AdCard.e();
                this.gBX.rN(stringExtra3);
            }
        } else if (bundle != null) {
            this.bQI = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.gBT = bundle.getFloat(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.guk = bundle.getInt(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
        } else {
            BdLog.e("WebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.gBU > this.gBV && this.gBR != null) {
            this.gBR.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.gBU > 0 && this.gBR != null) {
            this.gBR.stopPlay();
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.gBR != null) {
            this.gBR.stopPlay();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(d.h.ad_web_video_view, (ViewGroup) null, false);
        this.gBS = (WebViewContainer) frameLayout.findViewById(d.g.web_scroll);
        this.bSW = (AdBaseWebView) frameLayout.findViewById(d.g.web_web);
        this.gBR = (DistributeVideoView) frameLayout.findViewById(d.g.web_video);
        if (TextUtils.isEmpty(this.bQI) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.gBR.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.bQI;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_width = Integer.valueOf(l.ao(getActivity()));
            builder.video_height = builder.video_width;
            builder.video_duration = Integer.valueOf(this.guk);
            if (this.gBT > 0.0f) {
                builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.gBT));
            }
            VideoInfo build = builder.build(false);
            this.gBU = build.video_height.intValue();
            this.gBS.setTopMargin(this.gBU);
            this.gBS.setTopLimit(this.gBU);
            this.gBS.setOnScrollChangeListener(this.gBY);
            c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.gBS.setStyle(adAdSense.Fz());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.gBV = this.mVideoHeight / 2;
            if (this.gBX != null) {
                this.gBR.setVideoTailFrameData(this.gBX);
            }
            this.gBR.setPageContext(getPageContext());
            this.gBR.setData(build, 2, getPageContext());
            this.gBR.updateTailFrameView(null);
            this.gBR.setStatisticInfo(gBQ.gCa, gBQ.mPageNum, gBQ.gCb);
            this.gBR.setChargeInfo(this.gBW);
            this.gBR.autoPlay(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bSW.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.topMargin = build.video_height.intValue();
                layoutParams.height = l.aq(getActivity());
                this.bSW.setLayoutParams(layoutParams);
            }
        }
        UA();
        return frameLayout;
    }
}
