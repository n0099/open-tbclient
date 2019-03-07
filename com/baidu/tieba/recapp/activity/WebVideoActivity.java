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
import com.baidu.tieba.ad.browser.AdBaseWebView;
import com.baidu.tieba.ad.browser.AdTbWebViewActivity;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.DistributeVideoView;
import com.baidu.tieba.recapp.view.WebViewContainer;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class WebVideoActivity extends AdTbWebViewActivity {
    public static a ihd;
    private String bNk;
    private int hXs;
    private DistributeVideoView ihe;
    private WebViewContainer ihf;
    private float ihg;
    private int ihh;
    private int ihi;
    private AdCard.a ihj;
    private AdCard.f ihk;
    private WebViewContainer.OnScrollChangedCallback ihl = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.WebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            WebVideoActivity.this.ihh -= i2;
            if (WebVideoActivity.this.ihh <= 0) {
                WebVideoActivity.this.ihe.stopPlay(WebVideoActivity.this.ihe.getPlayStatus() != 2);
            } else if (WebVideoActivity.this.ihh < WebVideoActivity.this.ihi) {
                WebVideoActivity.this.ihe.pausePlay(1);
            } else if (WebVideoActivity.this.ihe.getPlayStatus() == 2) {
                WebVideoActivity.this.ihe.autoContinue();
            } else if (WebVideoActivity.this.ihe.getPlayStatus() == -1) {
                WebVideoActivity.this.ihe.autoPlay(0);
            }
        }
    };
    private String mThumbUrl;
    private int mVideoHeight;

    /* loaded from: classes3.dex */
    public static class a {
        public String axH;
        public AdvertAppInfo ihn;
        public int mPageNum;
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.bNk = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.ihg = intent.getFloatExtra(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.hXs = intent.getIntExtra(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
            String stringExtra = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_STYLE);
            String stringExtra2 = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_URL);
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.ihj = new AdCard.a();
                this.ihj.iih = stringExtra2;
                this.ihj.iig = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra(WebVideoActivityConfig.KEY_TAIL_FRAME);
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.ihk = new AdCard.f();
                this.ihk.Bz(stringExtra3);
            }
        } else if (bundle != null) {
            this.bNk = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.ihg = bundle.getFloat(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.hXs = bundle.getInt(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
        } else {
            BdLog.e("WebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.ihh > this.ihi && this.ihe != null) {
            this.ihe.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.ihh > 0 && this.ihe != null) {
            this.ihe.stopPlay(this.ihe.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.ihe != null) {
            this.ihe.stopPlay(this.ihe.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(d.h.ad_web_video_view, (ViewGroup) null, false);
        this.ihf = (WebViewContainer) frameLayout.findViewById(d.g.web_scroll);
        this.cNx = (AdBaseWebView) frameLayout.findViewById(d.g.web_web);
        awG();
        this.ihe = (DistributeVideoView) frameLayout.findViewById(d.g.web_video);
        if (TextUtils.isEmpty(this.bNk) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.ihe.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.bNk;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_width = Integer.valueOf(l.aO(getActivity()));
            builder.video_height = builder.video_width;
            builder.video_duration = Integer.valueOf(this.hXs);
            if (this.ihg > 0.0f) {
                builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.ihg));
            }
            VideoInfo build = builder.build(false);
            this.ihh = build.video_height.intValue();
            this.ihf.setTopMargin(this.ihh);
            this.ihf.setTopLimit(this.ihh);
            this.ihf.setOnScrollChangeListener(this.ihl);
            com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.ihf.setStyle(adAdSense.agg());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.ihi = this.mVideoHeight / 2;
            if (this.ihk != null) {
                this.ihe.setVideoTailFrameData(this.ihk);
            }
            this.ihe.setPageContext(getPageContext());
            this.ihe.setData(build, 2, getPageContext());
            this.ihe.updateTailFrameView(null);
            if (ihd != null) {
                this.ihe.setStatisticInfo(ihd.ihn, ihd.mPageNum, ihd.axH);
            }
            this.ihe.setChargeInfo(this.ihj);
            this.ihe.autoPlay(0);
            xP(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void xP(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cNx.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.aQ(getActivity()) - l.r(getActivity())) - bWL();
            this.cNx.setLayoutParams(layoutParams);
        }
    }

    private int bWL() {
        return l.h(this, d.e.ds98);
    }
}
