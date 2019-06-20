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
    public static a izA;
    private String bVa;
    private int ipN;
    private DistributeVideoView izB;
    private WebViewContainer izC;
    private float izD;
    private int izE;
    private int izF;
    private AdCard.a izG;
    private AdCard.f izH;
    private WebViewContainer.OnScrollChangedCallback izI = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.WebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            WebVideoActivity.this.izE -= i2;
            if (WebVideoActivity.this.izE <= 0) {
                WebVideoActivity.this.izB.stopPlay(WebVideoActivity.this.izB.getPlayStatus() != 2);
            } else if (WebVideoActivity.this.izE < WebVideoActivity.this.izF) {
                WebVideoActivity.this.izB.pausePlay(1);
            } else if (WebVideoActivity.this.izB.getPlayStatus() == 2) {
                WebVideoActivity.this.izB.autoContinue();
            } else if (WebVideoActivity.this.izB.getPlayStatus() == -1) {
                WebVideoActivity.this.izB.autoPlay(0);
            }
        }
    };
    private String mThumbUrl;
    private int mVideoHeight;

    /* loaded from: classes3.dex */
    public static class a {
        public String ayL;
        public AdvertAppInfo izK;
        public int mPageNum;
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.bVa = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.izD = intent.getFloatExtra(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.ipN = intent.getIntExtra(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
            String stringExtra = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_STYLE);
            String stringExtra2 = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_URL);
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.izG = new AdCard.a();
                this.izG.iAE = stringExtra2;
                this.izG.iAD = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra(WebVideoActivityConfig.KEY_TAIL_FRAME);
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.izH = new AdCard.f();
                this.izH.CV(stringExtra3);
            }
        } else if (bundle != null) {
            this.bVa = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.izD = bundle.getFloat(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.ipN = bundle.getInt(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
        } else {
            BdLog.e("WebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.izE > this.izF && this.izB != null) {
            this.izB.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.izE > 0 && this.izB != null) {
            this.izB.stopPlay(this.izB.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.izB != null) {
            this.izB.stopPlay(this.izB.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.ad_web_video_view, (ViewGroup) null, false);
        this.izC = (WebViewContainer) frameLayout.findViewById(R.id.web_scroll);
        this.cVK = (AdBaseWebView) frameLayout.findViewById(R.id.web_web);
        aBM();
        this.izB = (DistributeVideoView) frameLayout.findViewById(R.id.web_video);
        if (TextUtils.isEmpty(this.bVa) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.izB.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.bVa;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_width = Integer.valueOf(l.af(getActivity()));
            builder.video_height = builder.video_width;
            builder.video_duration = Integer.valueOf(this.ipN);
            if (this.izD > 0.0f) {
                builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.izD));
            }
            VideoInfo build = builder.build(false);
            this.izE = build.video_height.intValue();
            this.izC.setTopMargin(this.izE);
            this.izC.setTopLimit(this.izE);
            this.izC.setOnScrollChangeListener(this.izI);
            d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.izC.setStyle(adAdSense.alc());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.izF = this.mVideoHeight / 2;
            if (this.izH != null) {
                this.izB.setVideoTailFrameData(this.izH);
            }
            this.izB.setPageContext(getPageContext());
            this.izB.setData(build, 2, getPageContext());
            this.izB.updateTailFrameView(null);
            if (izA != null) {
                this.izB.setStatisticInfo(izA.izK, izA.mPageNum, izA.ayL);
            }
            this.izB.setChargeInfo(this.izG);
            this.izB.autoPlay(0);
            yS(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void yS(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cVK.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.ah(getActivity()) - l.r(getActivity())) - ceR();
            this.cVK.setLayoutParams(layoutParams);
        }
    }

    private int ceR() {
        return l.g(this, R.dimen.ds98);
    }
}
