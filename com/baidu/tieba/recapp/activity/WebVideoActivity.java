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
    public static a gPz;
    private String aFr;
    private int gHl;
    private DistributeVideoView gPA;
    private WebViewContainer gPB;
    private float gPC;
    private int gPD;
    private int gPE;
    private AdCard.a gPF;
    private AdCard.f gPG;
    private WebViewContainer.OnScrollChangedCallback gPH = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.WebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            WebVideoActivity.this.gPD -= i2;
            if (WebVideoActivity.this.gPD <= 0) {
                WebVideoActivity.this.gPA.stopPlay(WebVideoActivity.this.gPA.getPlayStatus() != 2);
            } else if (WebVideoActivity.this.gPD < WebVideoActivity.this.gPE) {
                WebVideoActivity.this.gPA.pausePlay(1);
            } else if (WebVideoActivity.this.gPA.getPlayStatus() == 2) {
                WebVideoActivity.this.gPA.autoContinue();
            } else if (WebVideoActivity.this.gPA.getPlayStatus() == -1) {
                WebVideoActivity.this.gPA.autoPlay(0);
            }
        }
    };
    private String mThumbUrl;
    private int mVideoHeight;

    /* loaded from: classes3.dex */
    public static class a {
        public AdvertAppInfo gPJ;
        public String mPage;
        public int mPageNum;
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.aFr = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.gPC = intent.getFloatExtra(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.gHl = intent.getIntExtra(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
            String stringExtra = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_STYLE);
            String stringExtra2 = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_URL);
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.gPF = new AdCard.a();
                this.gPF.gQD = stringExtra2;
                this.gPF.gQC = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra(WebVideoActivityConfig.KEY_TAIL_FRAME);
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.gPG = new AdCard.f();
                this.gPG.uU(stringExtra3);
            }
        } else if (bundle != null) {
            this.aFr = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.gPC = bundle.getFloat(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.gHl = bundle.getInt(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
        } else {
            BdLog.e("WebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.gPD > this.gPE && this.gPA != null) {
            this.gPA.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.gPD > 0 && this.gPA != null) {
            this.gPA.stopPlay(this.gPA.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.gPA != null) {
            this.gPA.stopPlay(this.gPA.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(e.h.ad_web_video_view, (ViewGroup) null, false);
        this.gPB = (WebViewContainer) frameLayout.findViewById(e.g.web_scroll);
        this.bCq = (AdBaseWebView) frameLayout.findViewById(e.g.web_web);
        WG();
        this.gPA = (DistributeVideoView) frameLayout.findViewById(e.g.web_video);
        if (TextUtils.isEmpty(this.aFr) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.gPA.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.aFr;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_width = Integer.valueOf(l.aO(getActivity()));
            builder.video_height = builder.video_width;
            builder.video_duration = Integer.valueOf(this.gHl);
            if (this.gPC > 0.0f) {
                builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.gPC));
            }
            VideoInfo build = builder.build(false);
            this.gPD = build.video_height.intValue();
            this.gPB.setTopMargin(this.gPD);
            this.gPB.setTopLimit(this.gPD);
            this.gPB.setOnScrollChangeListener(this.gPH);
            d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.gPB.setStyle(adAdSense.GN());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.gPE = this.mVideoHeight / 2;
            if (this.gPG != null) {
                this.gPA.setVideoTailFrameData(this.gPG);
            }
            this.gPA.setPageContext(getPageContext());
            this.gPA.setData(build, 2, getPageContext());
            this.gPA.updateTailFrameView(null);
            if (gPz != null) {
                this.gPA.setStatisticInfo(gPz.gPJ, gPz.mPageNum, gPz.mPage);
            }
            this.gPA.setChargeInfo(this.gPF);
            this.gPA.autoPlay(0);
            uc(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void uc(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bCq.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.aQ(getActivity()) - l.r(getActivity())) - bvY();
            this.bCq.setLayoutParams(layoutParams);
        }
    }

    private int bvY() {
        return l.h(this, e.C0210e.ds98);
    }
}
