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
    public static a gvK;
    private String avN;
    private int gnv;
    private DistributeVideoView gvL;
    private WebViewContainer gvM;
    private float gvN;
    private int gvO;
    private int gvP;
    private AdCard.a gvQ;
    private AdCard.f gvR;
    private WebViewContainer.OnScrollChangedCallback gvS = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.WebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            WebVideoActivity.this.gvO -= i2;
            if (WebVideoActivity.this.gvO <= 0) {
                WebVideoActivity.this.gvL.stopPlay(WebVideoActivity.this.gvL.getPlayStatus() != 2);
            } else if (WebVideoActivity.this.gvO < WebVideoActivity.this.gvP) {
                WebVideoActivity.this.gvL.pausePlay(1);
            } else if (WebVideoActivity.this.gvL.getPlayStatus() == 2) {
                WebVideoActivity.this.gvL.autoContinue();
            } else if (WebVideoActivity.this.gvL.getPlayStatus() == -1) {
                WebVideoActivity.this.gvL.autoPlay(0);
            }
        }
    };
    private String mThumbUrl;
    private int mVideoHeight;

    /* loaded from: classes3.dex */
    public static class a {
        public AdvertAppInfo gvU;
        public String gvV;
        public int mPageNum;
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.avN = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.gvN = intent.getFloatExtra(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.gnv = intent.getIntExtra(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
            String stringExtra = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_STYLE);
            String stringExtra2 = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_URL);
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.gvQ = new AdCard.a();
                this.gvQ.gwP = stringExtra2;
                this.gvQ.gwO = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra(WebVideoActivityConfig.KEY_TAIL_FRAME);
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.gvR = new AdCard.f();
                this.gvR.tu(stringExtra3);
            }
        } else if (bundle != null) {
            this.avN = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.gvN = bundle.getFloat(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.gnv = bundle.getInt(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
        } else {
            BdLog.e("WebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.gvO > this.gvP && this.gvL != null) {
            this.gvL.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.gvO > 0 && this.gvL != null) {
            this.gvL.stopPlay(this.gvL.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.gvL != null) {
            this.gvL.stopPlay(this.gvL.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(e.h.ad_web_video_view, (ViewGroup) null, false);
        this.gvM = (WebViewContainer) frameLayout.findViewById(e.g.web_scroll);
        this.btk = (AdBaseWebView) frameLayout.findViewById(e.g.web_web);
        SX();
        this.gvL = (DistributeVideoView) frameLayout.findViewById(e.g.web_video);
        if (TextUtils.isEmpty(this.avN) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.gvL.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.avN;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_width = Integer.valueOf(l.aO(getActivity()));
            builder.video_height = builder.video_width;
            builder.video_duration = Integer.valueOf(this.gnv);
            if (this.gvN > 0.0f) {
                builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.gvN));
            }
            VideoInfo build = builder.build(false);
            this.gvO = build.video_height.intValue();
            this.gvM.setTopMargin(this.gvO);
            this.gvM.setTopLimit(this.gvO);
            this.gvM.setOnScrollChangeListener(this.gvS);
            d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.gvM.setStyle(adAdSense.Dg());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.gvP = this.mVideoHeight / 2;
            if (this.gvR != null) {
                this.gvL.setVideoTailFrameData(this.gvR);
            }
            this.gvL.setPageContext(getPageContext());
            this.gvL.setData(build, 2, getPageContext());
            this.gvL.updateTailFrameView(null);
            if (gvK != null) {
                this.gvL.setStatisticInfo(gvK.gvU, gvK.mPageNum, gvK.gvV);
            }
            this.gvL.setChargeInfo(this.gvQ);
            this.gvL.autoPlay(0);
            sB(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void sB(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.btk.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.aQ(getActivity()) - l.r(getActivity())) - bqa();
            this.btk.setLayoutParams(layoutParams);
        }
    }

    private int bqa() {
        return l.h(this, e.C0141e.ds98);
    }
}
