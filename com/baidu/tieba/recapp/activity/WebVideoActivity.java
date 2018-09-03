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
import com.baidu.tieba.f;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.DistributeVideoView;
import com.baidu.tieba.recapp.view.WebViewContainer;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class WebVideoActivity extends AdTbWebViewActivity {
    public static a gos;
    private String bdb;
    private int ggb;
    private WebViewContainer.OnScrollChangedCallback goA = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.WebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            WebVideoActivity.this.gow -= i2;
            if (WebVideoActivity.this.gow <= 0) {
                WebVideoActivity.this.got.stopPlay(WebVideoActivity.this.got.getPlayStatus() != 2);
            } else if (WebVideoActivity.this.gow < WebVideoActivity.this.gox) {
                WebVideoActivity.this.got.pausePlay(1);
            } else if (WebVideoActivity.this.got.getPlayStatus() == 2) {
                WebVideoActivity.this.got.autoContinue();
            } else if (WebVideoActivity.this.got.getPlayStatus() == -1) {
                WebVideoActivity.this.got.autoPlay(0);
            }
        }
    };
    private DistributeVideoView got;
    private WebViewContainer gou;
    private float gov;
    private int gow;
    private int gox;
    private AdCard.a goy;
    private AdCard.f goz;
    private String mThumbUrl;
    private int mVideoHeight;

    /* loaded from: classes3.dex */
    public static class a {
        public AdvertAppInfo goC;
        public String goD;
        public int mPageNum;
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.bdb = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.gov = intent.getFloatExtra(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.ggb = intent.getIntExtra(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
            String stringExtra = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_STYLE);
            String stringExtra2 = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_URL);
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.goy = new AdCard.a();
                this.goy.gpx = stringExtra2;
                this.goy.gpw = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra(WebVideoActivityConfig.KEY_TAIL_FRAME);
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.goz = new AdCard.f();
                this.goz.sN(stringExtra3);
            }
        } else if (bundle != null) {
            this.bdb = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.gov = bundle.getFloat(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.ggb = bundle.getInt(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
        } else {
            BdLog.e("WebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.gow > this.gox && this.got != null) {
            this.got.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.gow > 0 && this.got != null) {
            this.got.stopPlay(this.got.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.got != null) {
            this.got.stopPlay(this.got.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(f.h.ad_web_video_view, (ViewGroup) null, false);
        this.gou = (WebViewContainer) frameLayout.findViewById(f.g.web_scroll);
        this.bnw = (AdBaseWebView) frameLayout.findViewById(f.g.web_web);
        Rj();
        this.got = (DistributeVideoView) frameLayout.findViewById(f.g.web_video);
        if (TextUtils.isEmpty(this.bdb) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.got.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.bdb;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_width = Integer.valueOf(l.ah(getActivity()));
            builder.video_height = builder.video_width;
            builder.video_duration = Integer.valueOf(this.ggb);
            if (this.gov > 0.0f) {
                builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.gov));
            }
            VideoInfo build = builder.build(false);
            this.gow = build.video_height.intValue();
            this.gou.setTopMargin(this.gow);
            this.gou.setTopLimit(this.gow);
            this.gou.setOnScrollChangeListener(this.goA);
            c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.gou.setStyle(adAdSense.BS());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.gox = this.mVideoHeight / 2;
            if (this.goz != null) {
                this.got.setVideoTailFrameData(this.goz);
            }
            this.got.setPageContext(getPageContext());
            this.got.setData(build, 2, getPageContext());
            this.got.updateTailFrameView(null);
            if (gos != null) {
                this.got.setStatisticInfo(gos.goC, gos.mPageNum, gos.goD);
            }
            this.got.setChargeInfo(this.goy);
            this.got.autoPlay(0);
            se(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void se(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bnw.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.aj(getActivity()) - l.n(getActivity())) - bnt();
            this.bnw.setLayoutParams(layoutParams);
        }
    }

    private int bnt() {
        return l.f(this, f.e.ds98);
    }
}
