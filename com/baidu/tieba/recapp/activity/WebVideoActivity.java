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
    public static a kJz;
    private DistributeVideoView kJA;
    private WebViewContainer kJB;
    private float kJC;
    private int kJD;
    private int kJE;
    private AdCard.a kJF;
    private AdCard.f kJG;
    private WebViewContainer.OnScrollChangedCallback kJH = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.WebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            WebVideoActivity.this.kJD -= i2;
            if (WebVideoActivity.this.kJD <= 0) {
                WebVideoActivity.this.kJA.stopPlay(WebVideoActivity.this.kJA.getPlayStatus() != 2);
            } else if (WebVideoActivity.this.kJD < WebVideoActivity.this.kJE) {
                WebVideoActivity.this.kJA.pausePlay(1);
            } else if (WebVideoActivity.this.kJA.getPlayStatus() == 2) {
                WebVideoActivity.this.kJA.autoContinue();
            } else if (WebVideoActivity.this.kJA.getPlayStatus() == -1) {
                WebVideoActivity.this.kJA.autoPlay(0);
            }
        }
    };
    private int kyS;
    private String mThumbUrl;
    private int mVideoHeight;
    private String mVideoUrl;

    /* loaded from: classes13.dex */
    public static class a {
        public AdvertAppInfo kJJ;
        public String mPage;
        public int mPageNum;
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.mVideoUrl = intent.getStringExtra("video_url");
            this.mThumbUrl = intent.getStringExtra("video_thumb_url");
            this.kJC = intent.getFloatExtra("video_ratio", 1.0f);
            this.kyS = intent.getIntExtra("video_duration", 0);
            String stringExtra = intent.getStringExtra("charge_style");
            String stringExtra2 = intent.getStringExtra("charge_url");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.kJF = new AdCard.a();
                this.kJF.kKI = stringExtra2;
                this.kJF.kKH = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra("tail_frame");
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.kJG = new AdCard.f();
                this.kJG.Lj(stringExtra3);
            }
        } else if (bundle != null) {
            this.mVideoUrl = bundle.getString("video_url");
            this.mThumbUrl = bundle.getString("video_thumb_url");
            this.kJC = bundle.getFloat("video_ratio", 1.0f);
            this.kyS = bundle.getInt("video_duration", 0);
        } else {
            BdLog.e("WebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.kJD > this.kJE && this.kJA != null) {
            this.kJA.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.kJD > 0 && this.kJA != null) {
            this.kJA.stopPlay(this.kJA.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.kJA != null) {
            this.kJA.stopPlay(this.kJA.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.ad_web_video_view, (ViewGroup) null, false);
        this.kJB = (WebViewContainer) frameLayout.findViewById(R.id.web_scroll);
        this.eNQ = (AdBaseWebView) frameLayout.findViewById(R.id.web_web);
        bmu();
        this.kJA = (DistributeVideoView) frameLayout.findViewById(R.id.web_video);
        if (TextUtils.isEmpty(this.mVideoUrl) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.kJA.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.mVideoUrl;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_width = Integer.valueOf(l.getEquipmentWidth(getActivity()));
            builder.video_height = builder.video_width;
            builder.video_duration = Integer.valueOf(this.kyS);
            if (this.kJC > 0.0f) {
                builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.kJC));
            }
            VideoInfo build = builder.build(false);
            this.kJD = build.video_height.intValue();
            this.kJB.setTopMargin(this.kJD);
            this.kJB.setTopLimit(this.kJD);
            this.kJB.setOnScrollChangeListener(this.kJH);
            d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.kJB.setStyle(adAdSense.aXP());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.kJE = this.mVideoHeight / 2;
            if (this.kJG != null) {
                this.kJA.setVideoTailFrameData(this.kJG);
            }
            this.kJA.setPageContext(getPageContext());
            this.kJA.setData(build, 2, getPageContext());
            this.kJA.updateTailFrameView(null);
            if (kJz != null) {
                this.kJA.setStatisticInfo(kJz.kJJ, kJz.mPageNum, kJz.mPage);
            }
            this.kJA.setChargeInfo(this.kJF);
            this.kJA.autoPlay(0);
            Cj(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void Cj(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eNQ.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.getEquipmentHeight(getActivity()) - l.getStatusBarHeight(getActivity())) - cUq();
            this.eNQ.setLayoutParams(layoutParams);
        }
    }

    private int cUq() {
        return l.getDimens(this, R.dimen.ds98);
    }
}
