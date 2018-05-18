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
    public static a fXW;
    private String baJ;
    private int fQp;
    private DistributeVideoView fXX;
    private WebViewContainer fXY;
    private float fXZ;
    private int fYa;
    private int fYb;
    private AdCard.a fYc;
    private AdCard.f fYd;
    private WebViewContainer.OnScrollChangedCallback fYe = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.WebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            WebVideoActivity.this.fYa -= i2;
            if (WebVideoActivity.this.fYa <= 0) {
                WebVideoActivity.this.fXX.stopPlay();
            } else if (WebVideoActivity.this.fYa < WebVideoActivity.this.fYb) {
                WebVideoActivity.this.fXX.pausePlay(1);
            } else if (WebVideoActivity.this.fXX.getPlayStatus() == 2) {
                WebVideoActivity.this.fXX.autoContinue();
            } else if (WebVideoActivity.this.fXX.getPlayStatus() == -1) {
                WebVideoActivity.this.fXX.autoPlay(0);
            }
        }
    };
    private String mThumbUrl;
    private int mVideoHeight;

    /* loaded from: classes3.dex */
    public static class a {
        public AdvertAppInfo fYg;
        public String fYh;
        public int mPageNum;
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.baJ = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.fXZ = intent.getFloatExtra(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.fQp = intent.getIntExtra(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
            String stringExtra = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_STYLE);
            String stringExtra2 = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_URL);
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.fYc = new AdCard.a();
                this.fYc.fZb = stringExtra2;
                this.fYc.fZa = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra(WebVideoActivityConfig.KEY_TAIL_FRAME);
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.fYd = new AdCard.f();
                this.fYd.rW(stringExtra3);
            }
        } else if (bundle != null) {
            this.baJ = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.fXZ = bundle.getFloat(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.fQp = bundle.getInt(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
        } else {
            BdLog.e("WebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.fYa > this.fYb && this.fXX != null) {
            this.fXX.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.fYa > 0 && this.fXX != null) {
            this.fXX.stopPlay();
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.fXX != null) {
            this.fXX.stopPlay();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(d.i.ad_web_video_view, (ViewGroup) null, false);
        this.fXY = (WebViewContainer) frameLayout.findViewById(d.g.web_scroll);
        this.bde = (AdBaseWebView) frameLayout.findViewById(d.g.web_web);
        Na();
        this.fXX = (DistributeVideoView) frameLayout.findViewById(d.g.web_video);
        if (TextUtils.isEmpty(this.baJ) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.fXX.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.baJ;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_width = Integer.valueOf(l.af(getActivity()));
            builder.video_height = builder.video_width;
            builder.video_duration = Integer.valueOf(this.fQp);
            if (this.fXZ > 0.0f) {
                builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.fXZ));
            }
            VideoInfo build = builder.build(false);
            this.fYa = build.video_height.intValue();
            this.fXY.setTopMargin(this.fYa);
            this.fXY.setTopLimit(this.fYa);
            this.fXY.setOnScrollChangeListener(this.fYe);
            c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.fXY.setStyle(adAdSense.ym());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.fYb = this.mVideoHeight / 2;
            if (this.fYd != null) {
                this.fXX.setVideoTailFrameData(this.fYd);
            }
            this.fXX.setPageContext(getPageContext());
            this.fXX.setData(build, 2, getPageContext());
            this.fXX.updateTailFrameView(null);
            if (fXW != null) {
                this.fXX.setStatisticInfo(fXW.fYg, fXW.mPageNum, fXW.fYh);
            }
            this.fXX.setChargeInfo(this.fYc);
            this.fXX.autoPlay(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bde.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.topMargin = build.video_height.intValue();
                layoutParams.height = l.ah(getActivity());
                this.bde.setLayoutParams(layoutParams);
            }
        }
        return frameLayout;
    }
}
