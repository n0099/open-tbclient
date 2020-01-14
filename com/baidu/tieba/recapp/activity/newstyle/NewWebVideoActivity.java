package com.baidu.tieba.recapp.activity.newstyle;

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
import com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity;
import com.baidu.tieba.ad.browser.newstyle.TBAdWebView;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.DistributeVideoView;
import com.baidu.tieba.recapp.view.WebViewContainer;
import tbclient.VideoInfo;
/* loaded from: classes11.dex */
public class NewWebVideoActivity extends NewAdTbWebViewActivity {
    public static a jFx;
    private DistributeVideoView jFn;
    private WebViewContainer jFo;
    private float jFp;
    private int jFq;
    private int jFr;
    private AdCard.a jFs;
    private AdCard.f jFt;
    private WebViewContainer.OnScrollChangedCallback jFu = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.newstyle.NewWebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            NewWebVideoActivity.this.jFq -= i2;
            if (NewWebVideoActivity.this.jFq <= 0) {
                NewWebVideoActivity.this.jFn.stopPlay(NewWebVideoActivity.this.jFn.getPlayStatus() != 2);
            } else if (NewWebVideoActivity.this.jFq < NewWebVideoActivity.this.jFr) {
                NewWebVideoActivity.this.jFn.pausePlay(1);
            } else if (NewWebVideoActivity.this.jFn.getPlayStatus() == 2) {
                NewWebVideoActivity.this.jFn.autoContinue();
            } else if (NewWebVideoActivity.this.jFn.getPlayStatus() == -1) {
                NewWebVideoActivity.this.jFn.autoPlay(0);
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

    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
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
            BdLog.e("NewWebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.jFq > this.jFr && this.jFn != null) {
            this.jFn.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.jFq > 0 && this.jFn != null) {
            this.jFn.stopPlay(this.jFn.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.jFn != null) {
            this.jFn.stopPlay(this.jFn.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.new_ad_web_video_view, (ViewGroup) null, false);
        this.jFo = (WebViewContainer) frameLayout.findViewById(R.id.web_scroll);
        this.dUX = (TBAdWebView) frameLayout.findViewById(R.id.web_web);
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
            if (jFx != null) {
                this.jFn.setStatisticInfo(jFx.jFw, jFx.mPageNum, jFx.mPage);
            }
            this.jFn.setTailFrameIsMiddlePage(true);
            this.jFn.updateTailFrameView(null);
            this.jFn.setChargeInfo(this.jFs);
            this.jFn.autoPlay(0);
            AI(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void AI(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dUX.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.getEquipmentHeight(getActivity()) - l.getStatusBarHeight(getActivity())) - cBb();
            this.dUX.setLayoutParams(layoutParams);
        }
    }

    private int cBb() {
        return l.getDimens(this, R.dimen.ds98);
    }
}
