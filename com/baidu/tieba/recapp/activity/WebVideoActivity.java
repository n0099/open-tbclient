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
    public static a gCf;
    private String bQV;
    private DistributeVideoView gCg;
    private WebViewContainer gCh;
    private float gCi;
    private int gCj;
    private int gCk;
    private AdCard.a gCl;
    private AdCard.e gCm;
    private WebViewContainer.OnScrollChangedCallback gCn = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.WebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            WebVideoActivity.this.gCj -= i2;
            if (WebVideoActivity.this.gCj <= 0) {
                WebVideoActivity.this.gCg.stopPlay();
            } else if (WebVideoActivity.this.gCj < WebVideoActivity.this.gCk) {
                WebVideoActivity.this.gCg.pausePlay(1);
            } else if (WebVideoActivity.this.gCg.getPlayStatus() == 2) {
                WebVideoActivity.this.gCg.autoContinue();
            } else if (WebVideoActivity.this.gCg.getPlayStatus() == -1) {
                WebVideoActivity.this.gCg.autoPlay(0);
            }
        }
    };
    private int guv;
    private String mThumbUrl;
    private int mVideoHeight;

    /* loaded from: classes3.dex */
    public static class a {
        public AdvertAppInfo gCp;
        public String gCq;
        public int mPageNum;
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.bQV = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.gCi = intent.getFloatExtra(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.guv = intent.getIntExtra(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
            String stringExtra = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_STYLE);
            String stringExtra2 = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_URL);
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.gCl = new AdCard.a();
                this.gCl.gDk = stringExtra2;
                this.gCl.gDj = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra(WebVideoActivityConfig.KEY_TAIL_FRAME);
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.gCm = new AdCard.e();
                this.gCm.rN(stringExtra3);
            }
        } else if (bundle != null) {
            this.bQV = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.gCi = bundle.getFloat(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.guv = bundle.getInt(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
        } else {
            BdLog.e("WebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.gCj > this.gCk && this.gCg != null) {
            this.gCg.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.gCj > 0 && this.gCg != null) {
            this.gCg.stopPlay();
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.gCg != null) {
            this.gCg.stopPlay();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(d.h.ad_web_video_view, (ViewGroup) null, false);
        this.gCh = (WebViewContainer) frameLayout.findViewById(d.g.web_scroll);
        this.bTi = (AdBaseWebView) frameLayout.findViewById(d.g.web_web);
        this.gCg = (DistributeVideoView) frameLayout.findViewById(d.g.web_video);
        if (TextUtils.isEmpty(this.bQV) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.gCg.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.bQV;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_width = Integer.valueOf(l.ao(getActivity()));
            builder.video_height = builder.video_width;
            builder.video_duration = Integer.valueOf(this.guv);
            if (this.gCi > 0.0f) {
                builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.gCi));
            }
            VideoInfo build = builder.build(false);
            this.gCj = build.video_height.intValue();
            this.gCh.setTopMargin(this.gCj);
            this.gCh.setTopLimit(this.gCj);
            this.gCh.setOnScrollChangeListener(this.gCn);
            c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.gCh.setStyle(adAdSense.FA());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.gCk = this.mVideoHeight / 2;
            if (this.gCm != null) {
                this.gCg.setVideoTailFrameData(this.gCm);
            }
            this.gCg.setPageContext(getPageContext());
            this.gCg.setData(build, 2, getPageContext());
            this.gCg.updateTailFrameView(null);
            this.gCg.setStatisticInfo(gCf.gCp, gCf.mPageNum, gCf.gCq);
            this.gCg.setChargeInfo(this.gCl);
            this.gCg.autoPlay(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bTi.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.topMargin = build.video_height.intValue();
                layoutParams.height = l.aq(getActivity());
                this.bTi.setLayoutParams(layoutParams);
            }
        }
        UB();
        return frameLayout;
    }
}
