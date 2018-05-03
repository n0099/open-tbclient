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
    public static a fWQ;
    private String baI;
    private int fPj;
    private DistributeVideoView fWR;
    private WebViewContainer fWS;
    private float fWT;
    private int fWU;
    private int fWV;
    private AdCard.a fWW;
    private AdCard.f fWX;
    private WebViewContainer.OnScrollChangedCallback fWY = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.WebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            WebVideoActivity.this.fWU -= i2;
            if (WebVideoActivity.this.fWU <= 0) {
                WebVideoActivity.this.fWR.stopPlay();
            } else if (WebVideoActivity.this.fWU < WebVideoActivity.this.fWV) {
                WebVideoActivity.this.fWR.pausePlay(1);
            } else if (WebVideoActivity.this.fWR.getPlayStatus() == 2) {
                WebVideoActivity.this.fWR.autoContinue();
            } else if (WebVideoActivity.this.fWR.getPlayStatus() == -1) {
                WebVideoActivity.this.fWR.autoPlay(0);
            }
        }
    };
    private String mThumbUrl;
    private int mVideoHeight;

    /* loaded from: classes3.dex */
    public static class a {
        public AdvertAppInfo fXa;
        public String fXb;
        public int mPageNum;
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.baI = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.fWT = intent.getFloatExtra(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.fPj = intent.getIntExtra(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
            String stringExtra = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_STYLE);
            String stringExtra2 = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_URL);
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.fWW = new AdCard.a();
                this.fWW.fXV = stringExtra2;
                this.fWW.fXU = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra(WebVideoActivityConfig.KEY_TAIL_FRAME);
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.fWX = new AdCard.f();
                this.fWX.rT(stringExtra3);
            }
        } else if (bundle != null) {
            this.baI = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.fWT = bundle.getFloat(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.fPj = bundle.getInt(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
        } else {
            BdLog.e("WebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.fWU > this.fWV && this.fWR != null) {
            this.fWR.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.fWU > 0 && this.fWR != null) {
            this.fWR.stopPlay();
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.fWR != null) {
            this.fWR.stopPlay();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(d.i.ad_web_video_view, (ViewGroup) null, false);
        this.fWS = (WebViewContainer) frameLayout.findViewById(d.g.web_scroll);
        this.bdd = (AdBaseWebView) frameLayout.findViewById(d.g.web_web);
        Nc();
        this.fWR = (DistributeVideoView) frameLayout.findViewById(d.g.web_video);
        if (TextUtils.isEmpty(this.baI) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.fWR.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.baI;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_width = Integer.valueOf(l.af(getActivity()));
            builder.video_height = builder.video_width;
            builder.video_duration = Integer.valueOf(this.fPj);
            if (this.fWT > 0.0f) {
                builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.fWT));
            }
            VideoInfo build = builder.build(false);
            this.fWU = build.video_height.intValue();
            this.fWS.setTopMargin(this.fWU);
            this.fWS.setTopLimit(this.fWU);
            this.fWS.setOnScrollChangeListener(this.fWY);
            c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.fWS.setStyle(adAdSense.yn());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.fWV = this.mVideoHeight / 2;
            if (this.fWX != null) {
                this.fWR.setVideoTailFrameData(this.fWX);
            }
            this.fWR.setPageContext(getPageContext());
            this.fWR.setData(build, 2, getPageContext());
            this.fWR.updateTailFrameView(null);
            if (fWQ != null) {
                this.fWR.setStatisticInfo(fWQ.fXa, fWQ.mPageNum, fWQ.fXb);
            }
            this.fWR.setChargeInfo(this.fWW);
            this.fWR.autoPlay(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bdd.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.topMargin = build.video_height.intValue();
                layoutParams.height = l.ah(getActivity());
                this.bdd.setLayoutParams(layoutParams);
            }
        }
        return frameLayout;
    }
}
