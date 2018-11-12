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
import com.baidu.tieba.ad.browser.AdBaseWebView;
import com.baidu.tieba.ad.browser.AdTbWebViewActivity;
import com.baidu.tieba.e;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.DistributeVideoView;
import com.baidu.tieba.recapp.view.WebViewContainer;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class WebVideoActivity extends AdTbWebViewActivity {
    public static a gEN;
    private String aBn;
    private DistributeVideoView gEO;
    private WebViewContainer gEP;
    private float gEQ;
    private int gER;
    private int gES;
    private AdCard.a gET;
    private AdCard.f gEU;
    private WebViewContainer.OnScrollChangedCallback gEV = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.WebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            WebVideoActivity.this.gER -= i2;
            if (WebVideoActivity.this.gER <= 0) {
                WebVideoActivity.this.gEO.stopPlay(WebVideoActivity.this.gEO.getPlayStatus() != 2);
            } else if (WebVideoActivity.this.gER < WebVideoActivity.this.gES) {
                WebVideoActivity.this.gEO.pausePlay(1);
            } else if (WebVideoActivity.this.gEO.getPlayStatus() == 2) {
                WebVideoActivity.this.gEO.autoContinue();
            } else if (WebVideoActivity.this.gEO.getPlayStatus() == -1) {
                WebVideoActivity.this.gEO.autoPlay(0);
            }
        }
    };
    private int gwz;
    private String mThumbUrl;
    private int mVideoHeight;

    /* loaded from: classes3.dex */
    public static class a {
        public AdvertAppInfo gEX;
        public String mPage;
        public int mPageNum;
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.aBn = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.gEQ = intent.getFloatExtra(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.gwz = intent.getIntExtra(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
            String stringExtra = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_STYLE);
            String stringExtra2 = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_URL);
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.gET = new AdCard.a();
                this.gET.gFR = stringExtra2;
                this.gET.gFQ = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra(WebVideoActivityConfig.KEY_TAIL_FRAME);
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.gEU = new AdCard.f();
                this.gEU.ua(stringExtra3);
            }
        } else if (bundle != null) {
            this.aBn = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.gEQ = bundle.getFloat(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.gwz = bundle.getInt(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
        } else {
            BdLog.e("WebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.gER > this.gES && this.gEO != null) {
            this.gEO.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.gER > 0 && this.gEO != null) {
            this.gEO.stopPlay(this.gEO.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.gEO != null) {
            this.gEO.stopPlay(this.gEO.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(e.h.ad_web_video_view, (ViewGroup) null, false);
        this.gEP = (WebViewContainer) frameLayout.findViewById(e.g.web_scroll);
        this.byc = (AdBaseWebView) frameLayout.findViewById(e.g.web_web);
        Vc();
        this.gEO = (DistributeVideoView) frameLayout.findViewById(e.g.web_video);
        if (TextUtils.isEmpty(this.aBn) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.gEO.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.aBn;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_width = Integer.valueOf(l.aO(getActivity()));
            builder.video_height = builder.video_width;
            builder.video_duration = Integer.valueOf(this.gwz);
            if (this.gEQ > 0.0f) {
                builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.gEQ));
            }
            VideoInfo build = builder.build(false);
            this.gER = build.video_height.intValue();
            this.gEP.setTopMargin(this.gER);
            this.gEP.setTopLimit(this.gER);
            this.gEP.setOnScrollChangeListener(this.gEV);
            d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.gEP.setStyle(adAdSense.Fv());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.gES = this.mVideoHeight / 2;
            if (this.gEU != null) {
                this.gEO.setVideoTailFrameData(this.gEU);
            }
            this.gEO.setPageContext(getPageContext());
            this.gEO.setData(build, 2, getPageContext());
            this.gEO.updateTailFrameView(null);
            if (gEN != null) {
                this.gEO.setStatisticInfo(gEN.gEX, gEN.mPageNum, gEN.mPage);
            }
            this.gEO.setChargeInfo(this.gET);
            this.gEO.autoPlay(0);
            tr(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void tr(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.byc.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.aQ(getActivity()) - l.r(getActivity())) - bsL();
            this.byc.setLayoutParams(layoutParams);
        }
    }

    private int bsL() {
        return l.h(this, e.C0200e.ds98);
    }
}
