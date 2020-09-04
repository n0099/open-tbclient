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
/* loaded from: classes20.dex */
public class WebVideoActivity extends AdTbWebViewActivity {
    public static a lCC;
    private DistributeVideoView lCD;
    private WebViewContainer lCE;
    private float lCF;
    private int lCG;
    private int lCH;
    private int lCI;
    private int lCJ;
    private AdCard.a lCK;
    private AdCard.f lCL;
    private WebViewContainer.OnScrollChangedCallback lCM = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.WebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            WebVideoActivity.this.lCH -= i2;
            if (WebVideoActivity.this.lCH <= 0) {
                WebVideoActivity.this.lCD.stopPlay(WebVideoActivity.this.lCD.getPlayStatus() != 2);
            } else if (WebVideoActivity.this.lCH < WebVideoActivity.this.lCI) {
                WebVideoActivity.this.lCD.pausePlay(1);
            } else if (WebVideoActivity.this.lCD.getPlayStatus() == 2) {
                WebVideoActivity.this.lCD.autoContinue();
            } else if (WebVideoActivity.this.lCD.getPlayStatus() == -1) {
                WebVideoActivity.this.lCD.autoPlay(0);
            }
        }
    };
    private String mThumbUrl;
    private int mVideoHeight;
    private String mVideoUrl;

    /* loaded from: classes20.dex */
    public static class a {
        public AdvertAppInfo lCO;
        public String mPage;
        public int mPageNum;
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.mVideoUrl = intent.getStringExtra("video_url");
            this.mThumbUrl = intent.getStringExtra("video_thumb_url");
            this.lCF = intent.getFloatExtra("video_ratio", 1.0f);
            this.lCG = intent.getIntExtra("video_duration", 0);
            this.lCJ = intent.getIntExtra("good_style", 7);
            String stringExtra = intent.getStringExtra("charge_style");
            String stringExtra2 = intent.getStringExtra("charge_url");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.lCK = new AdCard.a();
                this.lCK.lDN = stringExtra2;
                this.lCK.lDM = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra("tail_frame");
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.lCL = new AdCard.f();
                this.lCL.Ps(stringExtra3);
            }
        } else if (bundle != null) {
            this.mVideoUrl = bundle.getString("video_url");
            this.mThumbUrl = bundle.getString("video_thumb_url");
            this.lCF = bundle.getFloat("video_ratio", 1.0f);
            this.lCG = bundle.getInt("video_duration", 0);
            this.lCJ = bundle.getInt("good_style", 7);
        } else {
            BdLog.e("WebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.lCH > this.lCI && this.lCD != null) {
            this.lCD.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.lCH > 0 && this.lCD != null) {
            this.lCD.stopPlay(this.lCD.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.lCD != null) {
            this.lCD.stopPlay(this.lCD.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.ad_web_video_view, (ViewGroup) null, false);
        this.lCE = (WebViewContainer) frameLayout.findViewById(R.id.web_scroll);
        this.fol = (AdBaseWebView) frameLayout.findViewById(R.id.web_web);
        bAW();
        this.lCD = (DistributeVideoView) frameLayout.findViewById(R.id.web_video);
        if (TextUtils.isEmpty(this.mVideoUrl) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.lCD.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.mVideoUrl;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_duration = Integer.valueOf(this.lCG);
            if (this.lCJ == 14) {
                builder.video_height = Integer.valueOf(l.getEquipmentWidth(getActivity()));
                builder.video_width = Integer.valueOf(com.baidu.g.a.e.a.dk(builder.video_height.intValue()));
            } else {
                builder.video_width = Integer.valueOf(l.getEquipmentWidth(getActivity()));
                builder.video_height = builder.video_width;
                if (this.lCF > 0.0f) {
                    builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.lCF));
                }
            }
            VideoInfo build = builder.build(false);
            this.lCH = build.video_height.intValue();
            this.lCE.setTopMargin(this.lCH);
            this.lCE.setTopLimit(this.lCH);
            this.lCE.setOnScrollChangeListener(this.lCM);
            d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.lCE.setStyle(adAdSense.bmy());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.lCI = this.mVideoHeight / 2;
            if (this.lCL != null) {
                this.lCD.setVideoTailFrameData(this.lCL);
            }
            this.lCD.setPageContext(getPageContext());
            this.lCD.setData(build, 2, getPageContext());
            if (lCC != null) {
                this.lCD.updateTailFrameView(lCC.lCO);
                this.lCD.setStatisticInfo(lCC.lCO, lCC.mPageNum, lCC.mPage);
            } else {
                this.lCD.updateTailFrameView(null);
            }
            this.lCD.setChargeInfo(this.lCK);
            this.lCD.autoPlay(0);
            this.lCD.initVideoViewLayout(this.lCJ == 14);
            Ge(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void Ge(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fol.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.getEquipmentHeight(getActivity()) - l.getStatusBarHeight(getActivity())) - dno();
            this.fol.setLayoutParams(layoutParams);
        }
    }

    private int dno() {
        return l.getDimens(this, R.dimen.ds98);
    }
}
