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
    public static a gCg;
    private String bQL;
    private DistributeVideoView gCh;
    private WebViewContainer gCi;
    private float gCj;
    private int gCk;
    private int gCl;
    private AdCard.a gCm;
    private AdCard.e gCn;
    private WebViewContainer.OnScrollChangedCallback gCo = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.WebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            WebVideoActivity.this.gCk -= i2;
            if (WebVideoActivity.this.gCk <= 0) {
                WebVideoActivity.this.gCh.stopPlay();
            } else if (WebVideoActivity.this.gCk < WebVideoActivity.this.gCl) {
                WebVideoActivity.this.gCh.pausePlay(1);
            } else if (WebVideoActivity.this.gCh.getPlayStatus() == 2) {
                WebVideoActivity.this.gCh.autoContinue();
            } else if (WebVideoActivity.this.gCh.getPlayStatus() == -1) {
                WebVideoActivity.this.gCh.autoPlay(0);
            }
        }
    };
    private int guA;
    private String mThumbUrl;
    private int mVideoHeight;

    /* loaded from: classes3.dex */
    public static class a {
        public AdvertAppInfo gCq;
        public String gCr;
        public int mPageNum;
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.bQL = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.gCj = intent.getFloatExtra(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.guA = intent.getIntExtra(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
            String stringExtra = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_STYLE);
            String stringExtra2 = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_URL);
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.gCm = new AdCard.a();
                this.gCm.gDl = stringExtra2;
                this.gCm.gDk = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra(WebVideoActivityConfig.KEY_TAIL_FRAME);
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.gCn = new AdCard.e();
                this.gCn.rN(stringExtra3);
            }
        } else if (bundle != null) {
            this.bQL = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.gCj = bundle.getFloat(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.guA = bundle.getInt(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
        } else {
            BdLog.e("WebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.gCk > this.gCl && this.gCh != null) {
            this.gCh.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.gCk > 0 && this.gCh != null) {
            this.gCh.stopPlay();
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.gCh != null) {
            this.gCh.stopPlay();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(d.h.ad_web_video_view, (ViewGroup) null, false);
        this.gCi = (WebViewContainer) frameLayout.findViewById(d.g.web_scroll);
        this.bSZ = (AdBaseWebView) frameLayout.findViewById(d.g.web_web);
        this.gCh = (DistributeVideoView) frameLayout.findViewById(d.g.web_video);
        if (TextUtils.isEmpty(this.bQL) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.gCh.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.bQL;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_width = Integer.valueOf(l.ao(getActivity()));
            builder.video_height = builder.video_width;
            builder.video_duration = Integer.valueOf(this.guA);
            if (this.gCj > 0.0f) {
                builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.gCj));
            }
            VideoInfo build = builder.build(false);
            this.gCk = build.video_height.intValue();
            this.gCi.setTopMargin(this.gCk);
            this.gCi.setTopLimit(this.gCk);
            this.gCi.setOnScrollChangeListener(this.gCo);
            c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.gCi.setStyle(adAdSense.FA());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.gCl = this.mVideoHeight / 2;
            if (this.gCn != null) {
                this.gCh.setVideoTailFrameData(this.gCn);
            }
            this.gCh.setPageContext(getPageContext());
            this.gCh.setData(build, 2, getPageContext());
            this.gCh.updateTailFrameView(null);
            this.gCh.setStatisticInfo(gCg.gCq, gCg.mPageNum, gCg.gCr);
            this.gCh.setChargeInfo(this.gCm);
            this.gCh.autoPlay(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bSZ.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.topMargin = build.video_height.intValue();
                layoutParams.height = l.aq(getActivity());
                this.bSZ.setLayoutParams(layoutParams);
            }
        }
        UB();
        return frameLayout;
    }
}
