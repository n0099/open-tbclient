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
/* loaded from: classes13.dex */
public class WebVideoActivity extends AdTbWebViewActivity {
    public static a jHQ;
    private DistributeVideoView jHR;
    private WebViewContainer jHS;
    private float jHT;
    private int jHU;
    private int jHV;
    private AdCard.a jHW;
    private AdCard.f jHX;
    private WebViewContainer.OnScrollChangedCallback jHY = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.WebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            WebVideoActivity.this.jHU -= i2;
            if (WebVideoActivity.this.jHU <= 0) {
                WebVideoActivity.this.jHR.stopPlay(WebVideoActivity.this.jHR.getPlayStatus() != 2);
            } else if (WebVideoActivity.this.jHU < WebVideoActivity.this.jHV) {
                WebVideoActivity.this.jHR.pausePlay(1);
            } else if (WebVideoActivity.this.jHR.getPlayStatus() == 2) {
                WebVideoActivity.this.jHR.autoContinue();
            } else if (WebVideoActivity.this.jHR.getPlayStatus() == -1) {
                WebVideoActivity.this.jHR.autoPlay(0);
            }
        }
    };
    private int jxb;
    private String mThumbUrl;
    private int mVideoHeight;
    private String mVideoUrl;

    /* loaded from: classes13.dex */
    public static class a {
        public AdvertAppInfo jIa;
        public String mPage;
        public int mPageNum;
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.mVideoUrl = intent.getStringExtra("video_url");
            this.mThumbUrl = intent.getStringExtra("video_thumb_url");
            this.jHT = intent.getFloatExtra("video_ratio", 1.0f);
            this.jxb = intent.getIntExtra("video_duration", 0);
            String stringExtra = intent.getStringExtra("charge_style");
            String stringExtra2 = intent.getStringExtra("charge_url");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.jHW = new AdCard.a();
                this.jHW.jIY = stringExtra2;
                this.jHW.jIX = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra("tail_frame");
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.jHX = new AdCard.f();
                this.jHX.HQ(stringExtra3);
            }
        } else if (bundle != null) {
            this.mVideoUrl = bundle.getString("video_url");
            this.mThumbUrl = bundle.getString("video_thumb_url");
            this.jHT = bundle.getFloat("video_ratio", 1.0f);
            this.jxb = bundle.getInt("video_duration", 0);
        } else {
            BdLog.e("WebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.jHU > this.jHV && this.jHR != null) {
            this.jHR.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.jHU > 0 && this.jHR != null) {
            this.jHR.stopPlay(this.jHR.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.jHR != null) {
            this.jHR.stopPlay(this.jHR.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.ad_web_video_view, (ViewGroup) null, false);
        this.jHS = (WebViewContainer) frameLayout.findViewById(R.id.web_scroll);
        this.dZo = (AdBaseWebView) frameLayout.findViewById(R.id.web_web);
        aYg();
        this.jHR = (DistributeVideoView) frameLayout.findViewById(R.id.web_video);
        if (TextUtils.isEmpty(this.mVideoUrl) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.jHR.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.mVideoUrl;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_width = Integer.valueOf(l.getEquipmentWidth(getActivity()));
            builder.video_height = builder.video_width;
            builder.video_duration = Integer.valueOf(this.jxb);
            if (this.jHT > 0.0f) {
                builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.jHT));
            }
            VideoInfo build = builder.build(false);
            this.jHU = build.video_height.intValue();
            this.jHS.setTopMargin(this.jHU);
            this.jHS.setTopLimit(this.jHU);
            this.jHS.setOnScrollChangeListener(this.jHY);
            d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.jHS.setStyle(adAdSense.aJo());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.jHV = this.mVideoHeight / 2;
            if (this.jHX != null) {
                this.jHR.setVideoTailFrameData(this.jHX);
            }
            this.jHR.setPageContext(getPageContext());
            this.jHR.setData(build, 2, getPageContext());
            this.jHR.updateTailFrameView(null);
            if (jHQ != null) {
                this.jHR.setStatisticInfo(jHQ.jIa, jHQ.mPageNum, jHQ.mPage);
            }
            this.jHR.setChargeInfo(this.jHW);
            this.jHR.autoPlay(0);
            AZ(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void AZ(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dZo.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.getEquipmentHeight(getActivity()) - l.getStatusBarHeight(getActivity())) - cCU();
            this.dZo.setLayoutParams(layoutParams);
        }
    }

    private int cCU() {
        return l.getDimens(this, R.dimen.ds98);
    }
}
