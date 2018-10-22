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
    public static a gDm;
    private String aAy;
    private DistributeVideoView gDn;
    private WebViewContainer gDo;
    private float gDp;
    private int gDq;
    private int gDr;
    private AdCard.a gDs;
    private AdCard.f gDt;
    private WebViewContainer.OnScrollChangedCallback gDu = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.WebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            WebVideoActivity.this.gDq -= i2;
            if (WebVideoActivity.this.gDq <= 0) {
                WebVideoActivity.this.gDn.stopPlay(WebVideoActivity.this.gDn.getPlayStatus() != 2);
            } else if (WebVideoActivity.this.gDq < WebVideoActivity.this.gDr) {
                WebVideoActivity.this.gDn.pausePlay(1);
            } else if (WebVideoActivity.this.gDn.getPlayStatus() == 2) {
                WebVideoActivity.this.gDn.autoContinue();
            } else if (WebVideoActivity.this.gDn.getPlayStatus() == -1) {
                WebVideoActivity.this.gDn.autoPlay(0);
            }
        }
    };
    private int guY;
    private String mThumbUrl;
    private int mVideoHeight;

    /* loaded from: classes3.dex */
    public static class a {
        public AdvertAppInfo gDw;
        public String mPage;
        public int mPageNum;
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.aAy = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.gDp = intent.getFloatExtra(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.guY = intent.getIntExtra(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
            String stringExtra = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_STYLE);
            String stringExtra2 = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_URL);
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.gDs = new AdCard.a();
                this.gDs.gEq = stringExtra2;
                this.gDs.gEp = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra(WebVideoActivityConfig.KEY_TAIL_FRAME);
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.gDt = new AdCard.f();
                this.gDt.tW(stringExtra3);
            }
        } else if (bundle != null) {
            this.aAy = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.gDp = bundle.getFloat(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.guY = bundle.getInt(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
        } else {
            BdLog.e("WebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.gDq > this.gDr && this.gDn != null) {
            this.gDn.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.gDq > 0 && this.gDn != null) {
            this.gDn.stopPlay(this.gDn.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.gDn != null) {
            this.gDn.stopPlay(this.gDn.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(e.h.ad_web_video_view, (ViewGroup) null, false);
        this.gDo = (WebViewContainer) frameLayout.findViewById(e.g.web_scroll);
        this.bxr = (AdBaseWebView) frameLayout.findViewById(e.g.web_web);
        UT();
        this.gDn = (DistributeVideoView) frameLayout.findViewById(e.g.web_video);
        if (TextUtils.isEmpty(this.aAy) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.gDn.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.aAy;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_width = Integer.valueOf(l.aO(getActivity()));
            builder.video_height = builder.video_width;
            builder.video_duration = Integer.valueOf(this.guY);
            if (this.gDp > 0.0f) {
                builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.gDp));
            }
            VideoInfo build = builder.build(false);
            this.gDq = build.video_height.intValue();
            this.gDo.setTopMargin(this.gDq);
            this.gDo.setTopLimit(this.gDq);
            this.gDo.setOnScrollChangeListener(this.gDu);
            d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.gDo.setStyle(adAdSense.Fk());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.gDr = this.mVideoHeight / 2;
            if (this.gDt != null) {
                this.gDn.setVideoTailFrameData(this.gDt);
            }
            this.gDn.setPageContext(getPageContext());
            this.gDn.setData(build, 2, getPageContext());
            this.gDn.updateTailFrameView(null);
            if (gDm != null) {
                this.gDn.setStatisticInfo(gDm.gDw, gDm.mPageNum, gDm.mPage);
            }
            this.gDn.setChargeInfo(this.gDs);
            this.gDn.autoPlay(0);
            sY(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void sY(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bxr.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.aQ(getActivity()) - l.r(getActivity())) - btp();
            this.bxr.setLayoutParams(layoutParams);
        }
    }

    private int btp() {
        return l.h(this, e.C0175e.ds98);
    }
}
