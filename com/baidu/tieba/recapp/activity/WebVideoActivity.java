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
    public static a igY;
    private String bNl;
    private int hXn;
    private DistributeVideoView igZ;
    private WebViewContainer iha;
    private float ihb;
    private int ihc;
    private int ihd;
    private AdCard.a ihe;
    private AdCard.f ihf;
    private WebViewContainer.OnScrollChangedCallback ihg = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.WebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            WebVideoActivity.this.ihc -= i2;
            if (WebVideoActivity.this.ihc <= 0) {
                WebVideoActivity.this.igZ.stopPlay(WebVideoActivity.this.igZ.getPlayStatus() != 2);
            } else if (WebVideoActivity.this.ihc < WebVideoActivity.this.ihd) {
                WebVideoActivity.this.igZ.pausePlay(1);
            } else if (WebVideoActivity.this.igZ.getPlayStatus() == 2) {
                WebVideoActivity.this.igZ.autoContinue();
            } else if (WebVideoActivity.this.igZ.getPlayStatus() == -1) {
                WebVideoActivity.this.igZ.autoPlay(0);
            }
        }
    };
    private String mThumbUrl;
    private int mVideoHeight;

    /* loaded from: classes3.dex */
    public static class a {
        public String axI;
        public AdvertAppInfo ihi;
        public int mPageNum;
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.bNl = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.ihb = intent.getFloatExtra(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.hXn = intent.getIntExtra(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
            String stringExtra = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_STYLE);
            String stringExtra2 = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_URL);
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.ihe = new AdCard.a();
                this.ihe.iic = stringExtra2;
                this.ihe.iib = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra(WebVideoActivityConfig.KEY_TAIL_FRAME);
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.ihf = new AdCard.f();
                this.ihf.By(stringExtra3);
            }
        } else if (bundle != null) {
            this.bNl = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.ihb = bundle.getFloat(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.hXn = bundle.getInt(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
        } else {
            BdLog.e("WebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.ihc > this.ihd && this.igZ != null) {
            this.igZ.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.ihc > 0 && this.igZ != null) {
            this.igZ.stopPlay(this.igZ.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.igZ != null) {
            this.igZ.stopPlay(this.igZ.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(d.h.ad_web_video_view, (ViewGroup) null, false);
        this.iha = (WebViewContainer) frameLayout.findViewById(d.g.web_scroll);
        this.cNu = (AdBaseWebView) frameLayout.findViewById(d.g.web_web);
        awG();
        this.igZ = (DistributeVideoView) frameLayout.findViewById(d.g.web_video);
        if (TextUtils.isEmpty(this.bNl) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.igZ.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.bNl;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_width = Integer.valueOf(l.aO(getActivity()));
            builder.video_height = builder.video_width;
            builder.video_duration = Integer.valueOf(this.hXn);
            if (this.ihb > 0.0f) {
                builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.ihb));
            }
            VideoInfo build = builder.build(false);
            this.ihc = build.video_height.intValue();
            this.iha.setTopMargin(this.ihc);
            this.iha.setTopLimit(this.ihc);
            this.iha.setOnScrollChangeListener(this.ihg);
            com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.iha.setStyle(adAdSense.agg());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.ihd = this.mVideoHeight / 2;
            if (this.ihf != null) {
                this.igZ.setVideoTailFrameData(this.ihf);
            }
            this.igZ.setPageContext(getPageContext());
            this.igZ.setData(build, 2, getPageContext());
            this.igZ.updateTailFrameView(null);
            if (igY != null) {
                this.igZ.setStatisticInfo(igY.ihi, igY.mPageNum, igY.axI);
            }
            this.igZ.setChargeInfo(this.ihe);
            this.igZ.autoPlay(0);
            xP(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void xP(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cNu.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.aQ(getActivity()) - l.r(getActivity())) - bWO();
            this.cNu.setLayoutParams(layoutParams);
        }
    }

    private int bWO() {
        return l.h(this, d.e.ds98);
    }
}
