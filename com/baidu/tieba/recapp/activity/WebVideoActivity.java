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
    public static a igK;
    private String bNn;
    private int hWZ;
    private DistributeVideoView igL;
    private WebViewContainer igM;
    private float igN;
    private int igO;
    private int igP;
    private AdCard.a igQ;
    private AdCard.f igR;
    private WebViewContainer.OnScrollChangedCallback igS = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.WebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            WebVideoActivity.this.igO -= i2;
            if (WebVideoActivity.this.igO <= 0) {
                WebVideoActivity.this.igL.stopPlay(WebVideoActivity.this.igL.getPlayStatus() != 2);
            } else if (WebVideoActivity.this.igO < WebVideoActivity.this.igP) {
                WebVideoActivity.this.igL.pausePlay(1);
            } else if (WebVideoActivity.this.igL.getPlayStatus() == 2) {
                WebVideoActivity.this.igL.autoContinue();
            } else if (WebVideoActivity.this.igL.getPlayStatus() == -1) {
                WebVideoActivity.this.igL.autoPlay(0);
            }
        }
    };
    private String mThumbUrl;
    private int mVideoHeight;

    /* loaded from: classes3.dex */
    public static class a {
        public String axL;
        public AdvertAppInfo igU;
        public int mPageNum;
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.bNn = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.igN = intent.getFloatExtra(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.hWZ = intent.getIntExtra(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
            String stringExtra = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_STYLE);
            String stringExtra2 = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_URL);
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.igQ = new AdCard.a();
                this.igQ.ihO = stringExtra2;
                this.igQ.ihN = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra(WebVideoActivityConfig.KEY_TAIL_FRAME);
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.igR = new AdCard.f();
                this.igR.Bx(stringExtra3);
            }
        } else if (bundle != null) {
            this.bNn = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.igN = bundle.getFloat(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.hWZ = bundle.getInt(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
        } else {
            BdLog.e("WebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.igO > this.igP && this.igL != null) {
            this.igL.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.igO > 0 && this.igL != null) {
            this.igL.stopPlay(this.igL.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.igL != null) {
            this.igL.stopPlay(this.igL.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(d.h.ad_web_video_view, (ViewGroup) null, false);
        this.igM = (WebViewContainer) frameLayout.findViewById(d.g.web_scroll);
        this.cNw = (AdBaseWebView) frameLayout.findViewById(d.g.web_web);
        awD();
        this.igL = (DistributeVideoView) frameLayout.findViewById(d.g.web_video);
        if (TextUtils.isEmpty(this.bNn) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.igL.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.bNn;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_width = Integer.valueOf(l.aO(getActivity()));
            builder.video_height = builder.video_width;
            builder.video_duration = Integer.valueOf(this.hWZ);
            if (this.igN > 0.0f) {
                builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.igN));
            }
            VideoInfo build = builder.build(false);
            this.igO = build.video_height.intValue();
            this.igM.setTopMargin(this.igO);
            this.igM.setTopLimit(this.igO);
            this.igM.setOnScrollChangeListener(this.igS);
            com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.igM.setStyle(adAdSense.agd());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.igP = this.mVideoHeight / 2;
            if (this.igR != null) {
                this.igL.setVideoTailFrameData(this.igR);
            }
            this.igL.setPageContext(getPageContext());
            this.igL.setData(build, 2, getPageContext());
            this.igL.updateTailFrameView(null);
            if (igK != null) {
                this.igL.setStatisticInfo(igK.igU, igK.mPageNum, igK.axL);
            }
            this.igL.setChargeInfo(this.igQ);
            this.igL.autoPlay(0);
            xL(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void xL(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cNw.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.aQ(getActivity()) - l.r(getActivity())) - bWK();
            this.cNw.setLayoutParams(layoutParams);
        }
    }

    private int bWK() {
        return l.h(this, d.e.ds98);
    }
}
