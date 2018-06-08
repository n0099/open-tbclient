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
    public static a gjo;
    private String biU;
    private int gbB;
    private DistributeVideoView gjp;
    private WebViewContainer gjq;
    private float gjr;
    private int gjs;
    private int gjt;
    private AdCard.a gju;
    private AdCard.f gjv;
    private WebViewContainer.OnScrollChangedCallback gjw = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.WebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            WebVideoActivity.this.gjs -= i2;
            if (WebVideoActivity.this.gjs <= 0) {
                WebVideoActivity.this.gjp.stopPlay();
            } else if (WebVideoActivity.this.gjs < WebVideoActivity.this.gjt) {
                WebVideoActivity.this.gjp.pausePlay(1);
            } else if (WebVideoActivity.this.gjp.getPlayStatus() == 2) {
                WebVideoActivity.this.gjp.autoContinue();
            } else if (WebVideoActivity.this.gjp.getPlayStatus() == -1) {
                WebVideoActivity.this.gjp.autoPlay(0);
            }
        }
    };
    private String mThumbUrl;
    private int mVideoHeight;

    /* loaded from: classes3.dex */
    public static class a {
        public AdvertAppInfo gjy;
        public String gjz;
        public int mPageNum;
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.biU = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.gjr = intent.getFloatExtra(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.gbB = intent.getIntExtra(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
            String stringExtra = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_STYLE);
            String stringExtra2 = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_URL);
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.gju = new AdCard.a();
                this.gju.gkt = stringExtra2;
                this.gju.gks = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra(WebVideoActivityConfig.KEY_TAIL_FRAME);
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.gjv = new AdCard.f();
                this.gjv.sO(stringExtra3);
            }
        } else if (bundle != null) {
            this.biU = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.gjr = bundle.getFloat(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.gbB = bundle.getInt(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
        } else {
            BdLog.e("WebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.gjs > this.gjt && this.gjp != null) {
            this.gjp.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.gjs > 0 && this.gjp != null) {
            this.gjp.stopPlay();
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.gjp != null) {
            this.gjp.stopPlay();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(d.i.ad_web_video_view, (ViewGroup) null, false);
        this.gjq = (WebViewContainer) frameLayout.findViewById(d.g.web_scroll);
        this.blo = (AdBaseWebView) frameLayout.findViewById(d.g.web_web);
        QA();
        this.gjp = (DistributeVideoView) frameLayout.findViewById(d.g.web_video);
        if (TextUtils.isEmpty(this.biU) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.gjp.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.biU;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_width = Integer.valueOf(l.ah(getActivity()));
            builder.video_height = builder.video_width;
            builder.video_duration = Integer.valueOf(this.gbB);
            if (this.gjr > 0.0f) {
                builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.gjr));
            }
            VideoInfo build = builder.build(false);
            this.gjs = build.video_height.intValue();
            this.gjq.setTopMargin(this.gjs);
            this.gjq.setTopLimit(this.gjs);
            this.gjq.setOnScrollChangeListener(this.gjw);
            c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.gjq.setStyle(adAdSense.BM());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.gjt = this.mVideoHeight / 2;
            if (this.gjv != null) {
                this.gjp.setVideoTailFrameData(this.gjv);
            }
            this.gjp.setPageContext(getPageContext());
            this.gjp.setData(build, 2, getPageContext());
            this.gjp.updateTailFrameView(null);
            if (gjo != null) {
                this.gjp.setStatisticInfo(gjo.gjy, gjo.mPageNum, gjo.gjz);
            }
            this.gjp.setChargeInfo(this.gju);
            this.gjp.autoPlay(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.blo.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.topMargin = build.video_height.intValue();
                layoutParams.height = l.aj(getActivity());
                this.blo.setLayoutParams(layoutParams);
            }
        }
        return frameLayout;
    }
}
