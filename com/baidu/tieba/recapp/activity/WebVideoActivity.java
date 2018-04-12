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
    public static a fWT;
    private String baI;
    private int fPm;
    private DistributeVideoView fWU;
    private WebViewContainer fWV;
    private float fWW;
    private int fWX;
    private int fWY;
    private AdCard.a fWZ;
    private AdCard.f fXa;
    private WebViewContainer.OnScrollChangedCallback fXb = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.WebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            WebVideoActivity.this.fWX -= i2;
            if (WebVideoActivity.this.fWX <= 0) {
                WebVideoActivity.this.fWU.stopPlay();
            } else if (WebVideoActivity.this.fWX < WebVideoActivity.this.fWY) {
                WebVideoActivity.this.fWU.pausePlay(1);
            } else if (WebVideoActivity.this.fWU.getPlayStatus() == 2) {
                WebVideoActivity.this.fWU.autoContinue();
            } else if (WebVideoActivity.this.fWU.getPlayStatus() == -1) {
                WebVideoActivity.this.fWU.autoPlay(0);
            }
        }
    };
    private String mThumbUrl;
    private int mVideoHeight;

    /* loaded from: classes3.dex */
    public static class a {
        public AdvertAppInfo fXd;
        public String fXe;
        public int mPageNum;
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.baI = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.fWW = intent.getFloatExtra(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.fPm = intent.getIntExtra(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
            String stringExtra = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_STYLE);
            String stringExtra2 = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_URL);
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.fWZ = new AdCard.a();
                this.fWZ.fXY = stringExtra2;
                this.fWZ.fXX = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra(WebVideoActivityConfig.KEY_TAIL_FRAME);
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.fXa = new AdCard.f();
                this.fXa.rT(stringExtra3);
            }
        } else if (bundle != null) {
            this.baI = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.fWW = bundle.getFloat(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.fPm = bundle.getInt(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
        } else {
            BdLog.e("WebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.fWX > this.fWY && this.fWU != null) {
            this.fWU.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.fWX > 0 && this.fWU != null) {
            this.fWU.stopPlay();
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.fWU != null) {
            this.fWU.stopPlay();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(d.i.ad_web_video_view, (ViewGroup) null, false);
        this.fWV = (WebViewContainer) frameLayout.findViewById(d.g.web_scroll);
        this.bdd = (AdBaseWebView) frameLayout.findViewById(d.g.web_web);
        Nc();
        this.fWU = (DistributeVideoView) frameLayout.findViewById(d.g.web_video);
        if (TextUtils.isEmpty(this.baI) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.fWU.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.baI;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_width = Integer.valueOf(l.af(getActivity()));
            builder.video_height = builder.video_width;
            builder.video_duration = Integer.valueOf(this.fPm);
            if (this.fWW > 0.0f) {
                builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.fWW));
            }
            VideoInfo build = builder.build(false);
            this.fWX = build.video_height.intValue();
            this.fWV.setTopMargin(this.fWX);
            this.fWV.setTopLimit(this.fWX);
            this.fWV.setOnScrollChangeListener(this.fXb);
            c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.fWV.setStyle(adAdSense.yn());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.fWY = this.mVideoHeight / 2;
            if (this.fXa != null) {
                this.fWU.setVideoTailFrameData(this.fXa);
            }
            this.fWU.setPageContext(getPageContext());
            this.fWU.setData(build, 2, getPageContext());
            this.fWU.updateTailFrameView(null);
            if (fWT != null) {
                this.fWU.setStatisticInfo(fWT.fXd, fWT.mPageNum, fWT.fXe);
            }
            this.fWU.setChargeInfo(this.fWZ);
            this.fWU.autoPlay(0);
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
