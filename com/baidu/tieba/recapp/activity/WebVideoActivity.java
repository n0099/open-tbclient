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
import com.baidu.tbadk.coreExtra.data.c;
import com.baidu.tieba.ad.browser.AdBaseWebView;
import com.baidu.tieba.ad.browser.AdTbWebViewActivity;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.DistributeVideoView;
import com.baidu.tieba.recapp.view.WebViewContainer;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class WebVideoActivity extends AdTbWebViewActivity {
    public static a gop;
    private String bdb;
    private int ggc;
    private DistributeVideoView goq;
    private WebViewContainer gor;
    private float gos;
    private int got;
    private int gou;
    private AdCard.a gov;
    private AdCard.f gow;
    private WebViewContainer.OnScrollChangedCallback gox = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.WebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            WebVideoActivity.this.got -= i2;
            if (WebVideoActivity.this.got <= 0) {
                WebVideoActivity.this.goq.stopPlay(WebVideoActivity.this.goq.getPlayStatus() != 2);
            } else if (WebVideoActivity.this.got < WebVideoActivity.this.gou) {
                WebVideoActivity.this.goq.pausePlay(1);
            } else if (WebVideoActivity.this.goq.getPlayStatus() == 2) {
                WebVideoActivity.this.goq.autoContinue();
            } else if (WebVideoActivity.this.goq.getPlayStatus() == -1) {
                WebVideoActivity.this.goq.autoPlay(0);
            }
        }
    };
    private String mThumbUrl;
    private int mVideoHeight;

    /* loaded from: classes3.dex */
    public static class a {
        public String goA;
        public AdvertAppInfo goz;
        public int mPageNum;
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.bdb = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.gos = intent.getFloatExtra(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.ggc = intent.getIntExtra(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
            String stringExtra = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_STYLE);
            String stringExtra2 = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_URL);
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.gov = new AdCard.a();
                this.gov.gpu = stringExtra2;
                this.gov.gpt = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra(WebVideoActivityConfig.KEY_TAIL_FRAME);
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.gow = new AdCard.f();
                this.gow.sJ(stringExtra3);
            }
        } else if (bundle != null) {
            this.bdb = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.gos = bundle.getFloat(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.ggc = bundle.getInt(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
        } else {
            BdLog.e("WebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.got > this.gou && this.goq != null) {
            this.goq.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.got > 0 && this.goq != null) {
            this.goq.stopPlay(this.goq.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.goq != null) {
            this.goq.stopPlay(this.goq.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(d.h.ad_web_video_view, (ViewGroup) null, false);
        this.gor = (WebViewContainer) frameLayout.findViewById(d.g.web_scroll);
        this.bnt = (AdBaseWebView) frameLayout.findViewById(d.g.web_web);
        Re();
        this.goq = (DistributeVideoView) frameLayout.findViewById(d.g.web_video);
        if (TextUtils.isEmpty(this.bdb) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.goq.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.bdb;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_width = Integer.valueOf(l.ah(getActivity()));
            builder.video_height = builder.video_width;
            builder.video_duration = Integer.valueOf(this.ggc);
            if (this.gos > 0.0f) {
                builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.gos));
            }
            VideoInfo build = builder.build(false);
            this.got = build.video_height.intValue();
            this.gor.setTopMargin(this.got);
            this.gor.setTopLimit(this.got);
            this.gor.setOnScrollChangeListener(this.gox);
            c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.gor.setStyle(adAdSense.BV());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.gou = this.mVideoHeight / 2;
            if (this.gow != null) {
                this.goq.setVideoTailFrameData(this.gow);
            }
            this.goq.setPageContext(getPageContext());
            this.goq.setData(build, 2, getPageContext());
            this.goq.updateTailFrameView(null);
            if (gop != null) {
                this.goq.setStatisticInfo(gop.goz, gop.mPageNum, gop.goA);
            }
            this.goq.setChargeInfo(this.gov);
            this.goq.autoPlay(0);
            se(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void se(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bnt.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.aj(getActivity()) - l.o(getActivity())) - bns();
            this.bnt.setLayoutParams(layoutParams);
        }
    }

    private int bns() {
        return l.f(this, d.e.ds98);
    }
}
