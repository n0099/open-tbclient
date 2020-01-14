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
import com.baidu.tieba.R;
import com.baidu.tieba.ad.browser.AdBaseWebView;
import com.baidu.tieba.ad.browser.AdTbWebViewActivity;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.DistributeVideoView;
import com.baidu.tieba.recapp.view.WebViewContainer;
import tbclient.VideoInfo;
/* loaded from: classes11.dex */
public class WebVideoActivity extends AdTbWebViewActivity {
    public static a jFm;
    private DistributeVideoView jFn;
    private WebViewContainer jFo;
    private float jFp;
    private int jFq;
    private int jFr;
    private AdCard.a jFs;
    private AdCard.f jFt;
    private WebViewContainer.OnScrollChangedCallback jFu = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.WebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            WebVideoActivity.this.jFq -= i2;
            if (WebVideoActivity.this.jFq <= 0) {
                WebVideoActivity.this.jFn.stopPlay(WebVideoActivity.this.jFn.getPlayStatus() != 2);
            } else if (WebVideoActivity.this.jFq < WebVideoActivity.this.jFr) {
                WebVideoActivity.this.jFn.pausePlay(1);
            } else if (WebVideoActivity.this.jFn.getPlayStatus() == 2) {
                WebVideoActivity.this.jFn.autoContinue();
            } else if (WebVideoActivity.this.jFn.getPlayStatus() == -1) {
                WebVideoActivity.this.jFn.autoPlay(0);
            }
        }
    };
    private int juz;
    private String mThumbUrl;
    private int mVideoHeight;
    private String mVideoUrl;

    /* loaded from: classes11.dex */
    public static class a {
        public AdvertAppInfo jFw;
        public String mPage;
        public int mPageNum;
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.mVideoUrl = intent.getStringExtra("video_url");
            this.mThumbUrl = intent.getStringExtra("video_thumb_url");
            this.jFp = intent.getFloatExtra("video_ratio", 1.0f);
            this.juz = intent.getIntExtra("video_duration", 0);
            String stringExtra = intent.getStringExtra("charge_style");
            String stringExtra2 = intent.getStringExtra("charge_url");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.jFs = new AdCard.a();
                this.jFs.jGu = stringExtra2;
                this.jFs.jGt = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra("tail_frame");
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.jFt = new AdCard.f();
                this.jFt.HB(stringExtra3);
            }
        } else if (bundle != null) {
            this.mVideoUrl = bundle.getString("video_url");
            this.mThumbUrl = bundle.getString("video_thumb_url");
            this.jFp = bundle.getFloat("video_ratio", 1.0f);
            this.juz = bundle.getInt("video_duration", 0);
        } else {
            BdLog.e("WebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.jFq > this.jFr && this.jFn != null) {
            this.jFn.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.jFq > 0 && this.jFn != null) {
            this.jFn.stopPlay(this.jFn.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.jFn != null) {
            this.jFn.stopPlay(this.jFn.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.ad_web_video_view, (ViewGroup) null, false);
        this.jFo = (WebViewContainer) frameLayout.findViewById(R.id.web_scroll);
        this.dUG = (AdBaseWebView) frameLayout.findViewById(R.id.web_web);
        aVK();
        this.jFn = (DistributeVideoView) frameLayout.findViewById(R.id.web_video);
        if (TextUtils.isEmpty(this.mVideoUrl) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.jFn.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.mVideoUrl;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_width = Integer.valueOf(l.getEquipmentWidth(getActivity()));
            builder.video_height = builder.video_width;
            builder.video_duration = Integer.valueOf(this.juz);
            if (this.jFp > 0.0f) {
                builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.jFp));
            }
            VideoInfo build = builder.build(false);
            this.jFq = build.video_height.intValue();
            this.jFo.setTopMargin(this.jFq);
            this.jFo.setTopLimit(this.jFq);
            this.jFo.setOnScrollChangeListener(this.jFu);
            d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.jFo.setStyle(adAdSense.aGT());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.jFr = this.mVideoHeight / 2;
            if (this.jFt != null) {
                this.jFn.setVideoTailFrameData(this.jFt);
            }
            this.jFn.setPageContext(getPageContext());
            this.jFn.setData(build, 2, getPageContext());
            this.jFn.updateTailFrameView(null);
            if (jFm != null) {
                this.jFn.setStatisticInfo(jFm.jFw, jFm.mPageNum, jFm.mPage);
            }
            this.jFn.setChargeInfo(this.jFs);
            this.jFn.autoPlay(0);
            AI(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void AI(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dUG.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.getEquipmentHeight(getActivity()) - l.getStatusBarHeight(getActivity())) - cBb();
            this.dUG.setLayoutParams(layoutParams);
        }
    }

    private int cBb() {
        return l.getDimens(this, R.dimen.ds98);
    }
}
