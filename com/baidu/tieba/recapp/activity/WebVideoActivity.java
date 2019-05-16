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
    public static a izx;
    private String bUZ;
    private int ipJ;
    private float izA;
    private int izB;
    private int izC;
    private AdCard.a izD;
    private AdCard.f izE;
    private WebViewContainer.OnScrollChangedCallback izF = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.WebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            WebVideoActivity.this.izB -= i2;
            if (WebVideoActivity.this.izB <= 0) {
                WebVideoActivity.this.izy.stopPlay(WebVideoActivity.this.izy.getPlayStatus() != 2);
            } else if (WebVideoActivity.this.izB < WebVideoActivity.this.izC) {
                WebVideoActivity.this.izy.pausePlay(1);
            } else if (WebVideoActivity.this.izy.getPlayStatus() == 2) {
                WebVideoActivity.this.izy.autoContinue();
            } else if (WebVideoActivity.this.izy.getPlayStatus() == -1) {
                WebVideoActivity.this.izy.autoPlay(0);
            }
        }
    };
    private DistributeVideoView izy;
    private WebViewContainer izz;
    private String mThumbUrl;
    private int mVideoHeight;

    /* loaded from: classes3.dex */
    public static class a {
        public String ayL;
        public AdvertAppInfo izH;
        public int mPageNum;
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.bUZ = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.izA = intent.getFloatExtra(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.ipJ = intent.getIntExtra(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
            String stringExtra = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_STYLE);
            String stringExtra2 = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_URL);
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.izD = new AdCard.a();
                this.izD.iAB = stringExtra2;
                this.izD.iAA = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra(WebVideoActivityConfig.KEY_TAIL_FRAME);
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.izE = new AdCard.f();
                this.izE.CT(stringExtra3);
            }
        } else if (bundle != null) {
            this.bUZ = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.izA = bundle.getFloat(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.ipJ = bundle.getInt(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
        } else {
            BdLog.e("WebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.izB > this.izC && this.izy != null) {
            this.izy.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.izB > 0 && this.izy != null) {
            this.izy.stopPlay(this.izy.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.izy != null) {
            this.izy.stopPlay(this.izy.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.ad_web_video_view, (ViewGroup) null, false);
        this.izz = (WebViewContainer) frameLayout.findViewById(R.id.web_scroll);
        this.cVI = (AdBaseWebView) frameLayout.findViewById(R.id.web_web);
        aBJ();
        this.izy = (DistributeVideoView) frameLayout.findViewById(R.id.web_video);
        if (TextUtils.isEmpty(this.bUZ) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.izy.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.bUZ;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_width = Integer.valueOf(l.af(getActivity()));
            builder.video_height = builder.video_width;
            builder.video_duration = Integer.valueOf(this.ipJ);
            if (this.izA > 0.0f) {
                builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.izA));
            }
            VideoInfo build = builder.build(false);
            this.izB = build.video_height.intValue();
            this.izz.setTopMargin(this.izB);
            this.izz.setTopLimit(this.izB);
            this.izz.setOnScrollChangeListener(this.izF);
            d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.izz.setStyle(adAdSense.alc());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.izC = this.mVideoHeight / 2;
            if (this.izE != null) {
                this.izy.setVideoTailFrameData(this.izE);
            }
            this.izy.setPageContext(getPageContext());
            this.izy.setData(build, 2, getPageContext());
            this.izy.updateTailFrameView(null);
            if (izx != null) {
                this.izy.setStatisticInfo(izx.izH, izx.mPageNum, izx.ayL);
            }
            this.izy.setChargeInfo(this.izD);
            this.izy.autoPlay(0);
            yS(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void yS(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cVI.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.ah(getActivity()) - l.r(getActivity())) - ceO();
            this.cVI.setLayoutParams(layoutParams);
        }
    }

    private int ceO() {
        return l.g(this, R.dimen.ds98);
    }
}
