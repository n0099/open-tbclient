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
    public static a izz;
    private String bUZ;
    private int ipM;
    private DistributeVideoView izA;
    private WebViewContainer izB;
    private float izC;
    private int izD;
    private int izE;
    private AdCard.a izF;
    private AdCard.f izG;
    private WebViewContainer.OnScrollChangedCallback izH = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.WebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            WebVideoActivity.this.izD -= i2;
            if (WebVideoActivity.this.izD <= 0) {
                WebVideoActivity.this.izA.stopPlay(WebVideoActivity.this.izA.getPlayStatus() != 2);
            } else if (WebVideoActivity.this.izD < WebVideoActivity.this.izE) {
                WebVideoActivity.this.izA.pausePlay(1);
            } else if (WebVideoActivity.this.izA.getPlayStatus() == 2) {
                WebVideoActivity.this.izA.autoContinue();
            } else if (WebVideoActivity.this.izA.getPlayStatus() == -1) {
                WebVideoActivity.this.izA.autoPlay(0);
            }
        }
    };
    private String mThumbUrl;
    private int mVideoHeight;

    /* loaded from: classes3.dex */
    public static class a {
        public String ayL;
        public AdvertAppInfo izJ;
        public int mPageNum;
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.bUZ = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.izC = intent.getFloatExtra(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.ipM = intent.getIntExtra(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
            String stringExtra = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_STYLE);
            String stringExtra2 = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_URL);
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.izF = new AdCard.a();
                this.izF.iAD = stringExtra2;
                this.izF.iAC = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra(WebVideoActivityConfig.KEY_TAIL_FRAME);
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.izG = new AdCard.f();
                this.izG.CT(stringExtra3);
            }
        } else if (bundle != null) {
            this.bUZ = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.izC = bundle.getFloat(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.ipM = bundle.getInt(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
        } else {
            BdLog.e("WebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.izD > this.izE && this.izA != null) {
            this.izA.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.izD > 0 && this.izA != null) {
            this.izA.stopPlay(this.izA.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.izA != null) {
            this.izA.stopPlay(this.izA.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.ad_web_video_view, (ViewGroup) null, false);
        this.izB = (WebViewContainer) frameLayout.findViewById(R.id.web_scroll);
        this.cVJ = (AdBaseWebView) frameLayout.findViewById(R.id.web_web);
        aBM();
        this.izA = (DistributeVideoView) frameLayout.findViewById(R.id.web_video);
        if (TextUtils.isEmpty(this.bUZ) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.izA.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.bUZ;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_width = Integer.valueOf(l.af(getActivity()));
            builder.video_height = builder.video_width;
            builder.video_duration = Integer.valueOf(this.ipM);
            if (this.izC > 0.0f) {
                builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.izC));
            }
            VideoInfo build = builder.build(false);
            this.izD = build.video_height.intValue();
            this.izB.setTopMargin(this.izD);
            this.izB.setTopLimit(this.izD);
            this.izB.setOnScrollChangeListener(this.izH);
            d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.izB.setStyle(adAdSense.alc());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.izE = this.mVideoHeight / 2;
            if (this.izG != null) {
                this.izA.setVideoTailFrameData(this.izG);
            }
            this.izA.setPageContext(getPageContext());
            this.izA.setData(build, 2, getPageContext());
            this.izA.updateTailFrameView(null);
            if (izz != null) {
                this.izA.setStatisticInfo(izz.izJ, izz.mPageNum, izz.ayL);
            }
            this.izA.setChargeInfo(this.izF);
            this.izA.autoPlay(0);
            yS(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void yS(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cVJ.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.ah(getActivity()) - l.r(getActivity())) - ceQ();
            this.cVJ.setLayoutParams(layoutParams);
        }
    }

    private int ceQ() {
        return l.g(this, R.dimen.ds98);
    }
}
