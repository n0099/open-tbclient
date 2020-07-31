package com.baidu.tieba.recapp.activity.newstyle;

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
import com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity;
import com.baidu.tieba.ad.browser.newstyle.TBAdWebView;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.DistributeVideoView;
import com.baidu.tieba.recapp.view.WebViewContainer;
import tbclient.VideoInfo;
/* loaded from: classes20.dex */
public class NewWebVideoActivity extends NewAdTbWebViewActivity {
    public static a lmb;
    private DistributeVideoView llP;
    private WebViewContainer llQ;
    private float llR;
    private int llS;
    private int llT;
    private int llU;
    private int llV;
    private AdCard.a llW;
    private AdCard.f llX;
    private WebViewContainer.OnScrollChangedCallback llY = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.newstyle.NewWebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            NewWebVideoActivity.this.llT -= i2;
            if (NewWebVideoActivity.this.llT <= 0) {
                NewWebVideoActivity.this.llP.stopPlay(NewWebVideoActivity.this.llP.getPlayStatus() != 2);
            } else if (NewWebVideoActivity.this.llT < NewWebVideoActivity.this.llU) {
                NewWebVideoActivity.this.llP.pausePlay(1);
            } else if (NewWebVideoActivity.this.llP.getPlayStatus() == 2) {
                NewWebVideoActivity.this.llP.autoContinue();
            } else if (NewWebVideoActivity.this.llP.getPlayStatus() == -1) {
                NewWebVideoActivity.this.llP.autoPlay(0);
            }
        }
    };
    private String mThumbUrl;
    private int mVideoHeight;
    private String mVideoUrl;

    /* loaded from: classes20.dex */
    public static class a {
        public AdvertAppInfo lma;
        public String mPage;
        public int mPageNum;
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.mVideoUrl = intent.getStringExtra("video_url");
            this.mThumbUrl = intent.getStringExtra("video_thumb_url");
            this.llR = intent.getFloatExtra("video_ratio", 1.0f);
            this.llS = intent.getIntExtra("video_duration", 0);
            this.llV = intent.getIntExtra("good_style", 7);
            String stringExtra = intent.getStringExtra("charge_style");
            String stringExtra2 = intent.getStringExtra("charge_url");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.llW = new AdCard.a();
                this.llW.lmZ = stringExtra2;
                this.llW.lmY = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra("tail_frame");
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.llX = new AdCard.f();
                this.llX.Mt(stringExtra3);
            }
        } else if (bundle != null) {
            this.mVideoUrl = bundle.getString("video_url");
            this.mThumbUrl = bundle.getString("video_thumb_url");
            this.llR = bundle.getFloat("video_ratio", 1.0f);
            this.llS = bundle.getInt("video_duration", 0);
            this.llV = bundle.getInt("good_style", 7);
        } else {
            BdLog.e("NewWebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.llT > this.llU && this.llP != null) {
            this.llP.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.llT > 0 && this.llP != null) {
            this.llP.stopPlay(this.llP.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.llP != null) {
            this.llP.stopPlay(this.llP.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.new_ad_web_video_view, (ViewGroup) null, false);
        this.llQ = (WebViewContainer) frameLayout.findViewById(R.id.web_scroll);
        this.fdf = (TBAdWebView) frameLayout.findViewById(R.id.web_web);
        brY();
        this.llP = (DistributeVideoView) frameLayout.findViewById(R.id.web_video);
        if (TextUtils.isEmpty(this.mVideoUrl) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.llP.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.mVideoUrl;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_duration = Integer.valueOf(this.llS);
            if (this.llV == 14) {
                builder.video_height = Integer.valueOf(l.getEquipmentWidth(getActivity()));
                builder.video_width = Integer.valueOf(com.baidu.c.a.e.a.bA(builder.video_height.intValue()));
            } else {
                builder.video_width = Integer.valueOf(l.getEquipmentWidth(getActivity()));
                builder.video_height = builder.video_width;
                if (this.llR > 0.0f) {
                    builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.llR));
                }
            }
            VideoInfo build = builder.build(false);
            this.llT = build.video_height.intValue();
            this.llQ.setTopMargin(this.llT);
            this.llQ.setTopLimit(this.llT);
            this.llQ.setOnScrollChangeListener(this.llY);
            d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.llQ.setStyle(adAdSense.bdS());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.llU = this.mVideoHeight / 2;
            if (this.llX != null) {
                this.llP.setVideoTailFrameData(this.llX);
            }
            this.llP.setPageContext(getPageContext());
            this.llP.setData(build, 2, getPageContext());
            this.llP.setTailFrameIsMiddlePage(true);
            this.llP.setChargeInfo(this.llW);
            this.llP.autoPlay(0);
            this.llP.initVideoViewLayout(this.llV == 14);
            if (lmb != null) {
                this.llP.updateTailFrameView(lmb.lma);
                this.llP.setStatisticInfo(lmb.lma, lmb.mPageNum, lmb.mPage);
            } else {
                this.llP.updateTailFrameView(null);
            }
            DJ(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void DJ(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fdf.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.getEquipmentHeight(getActivity()) - l.getStatusBarHeight(getActivity())) - dce();
            this.fdf.setLayoutParams(layoutParams);
        }
    }

    private int dce() {
        return l.getDimens(this, R.dimen.ds98);
    }
}
