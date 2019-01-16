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
    public static a gPy;
    private String aFq;
    private int gHk;
    private WebViewContainer gPA;
    private float gPB;
    private int gPC;
    private int gPD;
    private AdCard.a gPE;
    private AdCard.f gPF;
    private WebViewContainer.OnScrollChangedCallback gPG = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.WebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            WebVideoActivity.this.gPC -= i2;
            if (WebVideoActivity.this.gPC <= 0) {
                WebVideoActivity.this.gPz.stopPlay(WebVideoActivity.this.gPz.getPlayStatus() != 2);
            } else if (WebVideoActivity.this.gPC < WebVideoActivity.this.gPD) {
                WebVideoActivity.this.gPz.pausePlay(1);
            } else if (WebVideoActivity.this.gPz.getPlayStatus() == 2) {
                WebVideoActivity.this.gPz.autoContinue();
            } else if (WebVideoActivity.this.gPz.getPlayStatus() == -1) {
                WebVideoActivity.this.gPz.autoPlay(0);
            }
        }
    };
    private DistributeVideoView gPz;
    private String mThumbUrl;
    private int mVideoHeight;

    /* loaded from: classes3.dex */
    public static class a {
        public AdvertAppInfo gPI;
        public String mPage;
        public int mPageNum;
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.aFq = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.gPB = intent.getFloatExtra(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.gHk = intent.getIntExtra(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
            String stringExtra = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_STYLE);
            String stringExtra2 = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_URL);
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.gPE = new AdCard.a();
                this.gPE.gQC = stringExtra2;
                this.gPE.gQB = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra(WebVideoActivityConfig.KEY_TAIL_FRAME);
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.gPF = new AdCard.f();
                this.gPF.uU(stringExtra3);
            }
        } else if (bundle != null) {
            this.aFq = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.gPB = bundle.getFloat(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.gHk = bundle.getInt(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
        } else {
            BdLog.e("WebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.gPC > this.gPD && this.gPz != null) {
            this.gPz.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.gPC > 0 && this.gPz != null) {
            this.gPz.stopPlay(this.gPz.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.gPz != null) {
            this.gPz.stopPlay(this.gPz.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(e.h.ad_web_video_view, (ViewGroup) null, false);
        this.gPA = (WebViewContainer) frameLayout.findViewById(e.g.web_scroll);
        this.bCp = (AdBaseWebView) frameLayout.findViewById(e.g.web_web);
        WG();
        this.gPz = (DistributeVideoView) frameLayout.findViewById(e.g.web_video);
        if (TextUtils.isEmpty(this.aFq) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.gPz.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.aFq;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_width = Integer.valueOf(l.aO(getActivity()));
            builder.video_height = builder.video_width;
            builder.video_duration = Integer.valueOf(this.gHk);
            if (this.gPB > 0.0f) {
                builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.gPB));
            }
            VideoInfo build = builder.build(false);
            this.gPC = build.video_height.intValue();
            this.gPA.setTopMargin(this.gPC);
            this.gPA.setTopLimit(this.gPC);
            this.gPA.setOnScrollChangeListener(this.gPG);
            d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.gPA.setStyle(adAdSense.GN());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.gPD = this.mVideoHeight / 2;
            if (this.gPF != null) {
                this.gPz.setVideoTailFrameData(this.gPF);
            }
            this.gPz.setPageContext(getPageContext());
            this.gPz.setData(build, 2, getPageContext());
            this.gPz.updateTailFrameView(null);
            if (gPy != null) {
                this.gPz.setStatisticInfo(gPy.gPI, gPy.mPageNum, gPy.mPage);
            }
            this.gPz.setChargeInfo(this.gPE);
            this.gPz.autoPlay(0);
            uc(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void uc(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bCp.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.aQ(getActivity()) - l.r(getActivity())) - bvY();
            this.bCp.setLayoutParams(layoutParams);
        }
    }

    private int bvY() {
        return l.h(this, e.C0210e.ds98);
    }
}
