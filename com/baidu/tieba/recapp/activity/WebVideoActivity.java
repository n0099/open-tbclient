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
/* loaded from: classes3.dex */
public class WebVideoActivity extends AdTbWebViewActivity {
    public static a iGW;
    private String bWh;
    private DistributeVideoView iGX;
    private WebViewContainer iGY;
    private float iGZ;
    private int iHa;
    private int iHb;
    private AdCard.a iHc;
    private AdCard.f iHd;
    private WebViewContainer.OnScrollChangedCallback iHe = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.WebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            WebVideoActivity.this.iHa -= i2;
            if (WebVideoActivity.this.iHa <= 0) {
                WebVideoActivity.this.iGX.stopPlay(WebVideoActivity.this.iGX.getPlayStatus() != 2);
            } else if (WebVideoActivity.this.iHa < WebVideoActivity.this.iHb) {
                WebVideoActivity.this.iGX.pausePlay(1);
            } else if (WebVideoActivity.this.iGX.getPlayStatus() == 2) {
                WebVideoActivity.this.iGX.autoContinue();
            } else if (WebVideoActivity.this.iGX.getPlayStatus() == -1) {
                WebVideoActivity.this.iGX.autoPlay(0);
            }
        }
    };
    private int ixg;
    private String mThumbUrl;
    private int mVideoHeight;

    /* loaded from: classes3.dex */
    public static class a {
        public String azs;
        public AdvertAppInfo iHg;
        public int mPageNum;
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.bWh = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.iGZ = intent.getFloatExtra(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.ixg = intent.getIntExtra(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
            String stringExtra = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_STYLE);
            String stringExtra2 = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_URL);
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.iHc = new AdCard.a();
                this.iHc.iIa = stringExtra2;
                this.iHc.iHZ = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra(WebVideoActivityConfig.KEY_TAIL_FRAME);
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.iHd = new AdCard.f();
                this.iHd.DJ(stringExtra3);
            }
        } else if (bundle != null) {
            this.bWh = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.iGZ = bundle.getFloat(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.ixg = bundle.getInt(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
        } else {
            BdLog.e("WebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.iHa > this.iHb && this.iGX != null) {
            this.iGX.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.iHa > 0 && this.iGX != null) {
            this.iGX.stopPlay(this.iGX.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.iGX != null) {
            this.iGX.stopPlay(this.iGX.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.ad_web_video_view, (ViewGroup) null, false);
        this.iGY = (WebViewContainer) frameLayout.findViewById(R.id.web_scroll);
        this.cXn = (AdBaseWebView) frameLayout.findViewById(R.id.web_web);
        aDd();
        this.iGX = (DistributeVideoView) frameLayout.findViewById(R.id.web_video);
        if (TextUtils.isEmpty(this.bWh) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.iGX.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.bWh;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_width = Integer.valueOf(l.af(getActivity()));
            builder.video_height = builder.video_width;
            builder.video_duration = Integer.valueOf(this.ixg);
            if (this.iGZ > 0.0f) {
                builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.iGZ));
            }
            VideoInfo build = builder.build(false);
            this.iHa = build.video_height.intValue();
            this.iGY.setTopMargin(this.iHa);
            this.iGY.setTopLimit(this.iHa);
            this.iGY.setOnScrollChangeListener(this.iHe);
            d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.iGY.setStyle(adAdSense.amj());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.iHb = this.mVideoHeight / 2;
            if (this.iHd != null) {
                this.iGX.setVideoTailFrameData(this.iHd);
            }
            this.iGX.setPageContext(getPageContext());
            this.iGX.setData(build, 2, getPageContext());
            this.iGX.updateTailFrameView(null);
            if (iGW != null) {
                this.iGX.setStatisticInfo(iGW.iHg, iGW.mPageNum, iGW.azs);
            }
            this.iGX.setChargeInfo(this.iHc);
            this.iGX.autoPlay(0);
            zz(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void zz(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cXn.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.ah(getActivity()) - l.u(getActivity())) - cia();
            this.cXn.setLayoutParams(layoutParams);
        }
    }

    private int cia() {
        return l.g(this, R.dimen.ds98);
    }
}
