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
    public static a gDl;
    private String aAy;
    private DistributeVideoView gDm;
    private WebViewContainer gDn;
    private float gDo;
    private int gDp;
    private int gDq;
    private AdCard.a gDr;
    private AdCard.f gDs;
    private WebViewContainer.OnScrollChangedCallback gDt = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.WebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            WebVideoActivity.this.gDp -= i2;
            if (WebVideoActivity.this.gDp <= 0) {
                WebVideoActivity.this.gDm.stopPlay(WebVideoActivity.this.gDm.getPlayStatus() != 2);
            } else if (WebVideoActivity.this.gDp < WebVideoActivity.this.gDq) {
                WebVideoActivity.this.gDm.pausePlay(1);
            } else if (WebVideoActivity.this.gDm.getPlayStatus() == 2) {
                WebVideoActivity.this.gDm.autoContinue();
            } else if (WebVideoActivity.this.gDm.getPlayStatus() == -1) {
                WebVideoActivity.this.gDm.autoPlay(0);
            }
        }
    };
    private int guX;
    private String mThumbUrl;
    private int mVideoHeight;

    /* loaded from: classes3.dex */
    public static class a {
        public AdvertAppInfo gDv;
        public String mPage;
        public int mPageNum;
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.aAy = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.gDo = intent.getFloatExtra(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.guX = intent.getIntExtra(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
            String stringExtra = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_STYLE);
            String stringExtra2 = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_URL);
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.gDr = new AdCard.a();
                this.gDr.gEp = stringExtra2;
                this.gDr.gEo = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra(WebVideoActivityConfig.KEY_TAIL_FRAME);
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.gDs = new AdCard.f();
                this.gDs.tW(stringExtra3);
            }
        } else if (bundle != null) {
            this.aAy = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.gDo = bundle.getFloat(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.guX = bundle.getInt(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
        } else {
            BdLog.e("WebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.gDp > this.gDq && this.gDm != null) {
            this.gDm.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.gDp > 0 && this.gDm != null) {
            this.gDm.stopPlay(this.gDm.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.gDm != null) {
            this.gDm.stopPlay(this.gDm.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(e.h.ad_web_video_view, (ViewGroup) null, false);
        this.gDn = (WebViewContainer) frameLayout.findViewById(e.g.web_scroll);
        this.bxr = (AdBaseWebView) frameLayout.findViewById(e.g.web_web);
        UT();
        this.gDm = (DistributeVideoView) frameLayout.findViewById(e.g.web_video);
        if (TextUtils.isEmpty(this.aAy) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.gDm.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.aAy;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_width = Integer.valueOf(l.aO(getActivity()));
            builder.video_height = builder.video_width;
            builder.video_duration = Integer.valueOf(this.guX);
            if (this.gDo > 0.0f) {
                builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.gDo));
            }
            VideoInfo build = builder.build(false);
            this.gDp = build.video_height.intValue();
            this.gDn.setTopMargin(this.gDp);
            this.gDn.setTopLimit(this.gDp);
            this.gDn.setOnScrollChangeListener(this.gDt);
            d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.gDn.setStyle(adAdSense.Fk());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.gDq = this.mVideoHeight / 2;
            if (this.gDs != null) {
                this.gDm.setVideoTailFrameData(this.gDs);
            }
            this.gDm.setPageContext(getPageContext());
            this.gDm.setData(build, 2, getPageContext());
            this.gDm.updateTailFrameView(null);
            if (gDl != null) {
                this.gDm.setStatisticInfo(gDl.gDv, gDl.mPageNum, gDl.mPage);
            }
            this.gDm.setChargeInfo(this.gDr);
            this.gDm.autoPlay(0);
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
