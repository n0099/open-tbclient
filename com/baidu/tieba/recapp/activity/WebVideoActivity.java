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
    public static a ihe;
    private String bNk;
    private int hXt;
    private DistributeVideoView ihf;
    private WebViewContainer ihg;
    private float ihh;
    private int ihi;
    private int ihj;
    private AdCard.a ihk;
    private AdCard.f ihl;
    private WebViewContainer.OnScrollChangedCallback ihm = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.WebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            WebVideoActivity.this.ihi -= i2;
            if (WebVideoActivity.this.ihi <= 0) {
                WebVideoActivity.this.ihf.stopPlay(WebVideoActivity.this.ihf.getPlayStatus() != 2);
            } else if (WebVideoActivity.this.ihi < WebVideoActivity.this.ihj) {
                WebVideoActivity.this.ihf.pausePlay(1);
            } else if (WebVideoActivity.this.ihf.getPlayStatus() == 2) {
                WebVideoActivity.this.ihf.autoContinue();
            } else if (WebVideoActivity.this.ihf.getPlayStatus() == -1) {
                WebVideoActivity.this.ihf.autoPlay(0);
            }
        }
    };
    private String mThumbUrl;
    private int mVideoHeight;

    /* loaded from: classes3.dex */
    public static class a {
        public String axH;
        public AdvertAppInfo iho;
        public int mPageNum;
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.bNk = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.ihh = intent.getFloatExtra(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.hXt = intent.getIntExtra(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
            String stringExtra = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_STYLE);
            String stringExtra2 = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_URL);
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.ihk = new AdCard.a();
                this.ihk.iii = stringExtra2;
                this.ihk.iih = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra(WebVideoActivityConfig.KEY_TAIL_FRAME);
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.ihl = new AdCard.f();
                this.ihl.BA(stringExtra3);
            }
        } else if (bundle != null) {
            this.bNk = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.ihh = bundle.getFloat(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.hXt = bundle.getInt(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
        } else {
            BdLog.e("WebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.ihi > this.ihj && this.ihf != null) {
            this.ihf.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.ihi > 0 && this.ihf != null) {
            this.ihf.stopPlay(this.ihf.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.ihf != null) {
            this.ihf.stopPlay(this.ihf.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(d.h.ad_web_video_view, (ViewGroup) null, false);
        this.ihg = (WebViewContainer) frameLayout.findViewById(d.g.web_scroll);
        this.cNx = (AdBaseWebView) frameLayout.findViewById(d.g.web_web);
        awH();
        this.ihf = (DistributeVideoView) frameLayout.findViewById(d.g.web_video);
        if (TextUtils.isEmpty(this.bNk) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.ihf.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.bNk;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_width = Integer.valueOf(l.aO(getActivity()));
            builder.video_height = builder.video_width;
            builder.video_duration = Integer.valueOf(this.hXt);
            if (this.ihh > 0.0f) {
                builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.ihh));
            }
            VideoInfo build = builder.build(false);
            this.ihi = build.video_height.intValue();
            this.ihg.setTopMargin(this.ihi);
            this.ihg.setTopLimit(this.ihi);
            this.ihg.setOnScrollChangeListener(this.ihm);
            com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.ihg.setStyle(adAdSense.agg());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.ihj = this.mVideoHeight / 2;
            if (this.ihl != null) {
                this.ihf.setVideoTailFrameData(this.ihl);
            }
            this.ihf.setPageContext(getPageContext());
            this.ihf.setData(build, 2, getPageContext());
            this.ihf.updateTailFrameView(null);
            if (ihe != null) {
                this.ihf.setStatisticInfo(ihe.iho, ihe.mPageNum, ihe.axH);
            }
            this.ihf.setChargeInfo(this.ihk);
            this.ihf.autoPlay(0);
            xP(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void xP(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cNx.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.aQ(getActivity()) - l.r(getActivity())) - bWM();
            this.cNx.setLayoutParams(layoutParams);
        }
    }

    private int bWM() {
        return l.h(this, d.e.ds98);
    }
}
