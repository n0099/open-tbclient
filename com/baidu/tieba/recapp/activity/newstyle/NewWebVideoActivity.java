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
/* loaded from: classes13.dex */
public class NewWebVideoActivity extends NewAdTbWebViewActivity {
    public static a jGC;
    private DistributeVideoView jGs;
    private WebViewContainer jGt;
    private float jGu;
    private int jGv;
    private int jGw;
    private AdCard.a jGx;
    private AdCard.f jGy;
    private WebViewContainer.OnScrollChangedCallback jGz = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.newstyle.NewWebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            NewWebVideoActivity.this.jGv -= i2;
            if (NewWebVideoActivity.this.jGv <= 0) {
                NewWebVideoActivity.this.jGs.stopPlay(NewWebVideoActivity.this.jGs.getPlayStatus() != 2);
            } else if (NewWebVideoActivity.this.jGv < NewWebVideoActivity.this.jGw) {
                NewWebVideoActivity.this.jGs.pausePlay(1);
            } else if (NewWebVideoActivity.this.jGs.getPlayStatus() == 2) {
                NewWebVideoActivity.this.jGs.autoContinue();
            } else if (NewWebVideoActivity.this.jGs.getPlayStatus() == -1) {
                NewWebVideoActivity.this.jGs.autoPlay(0);
            }
        }
    };
    private int jvC;
    private String mThumbUrl;
    private int mVideoHeight;
    private String mVideoUrl;

    /* loaded from: classes13.dex */
    public static class a {
        public AdvertAppInfo jGB;
        public String mPage;
        public int mPageNum;
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.mVideoUrl = intent.getStringExtra("video_url");
            this.mThumbUrl = intent.getStringExtra("video_thumb_url");
            this.jGu = intent.getFloatExtra("video_ratio", 1.0f);
            this.jvC = intent.getIntExtra("video_duration", 0);
            String stringExtra = intent.getStringExtra("charge_style");
            String stringExtra2 = intent.getStringExtra("charge_url");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.jGx = new AdCard.a();
                this.jGx.jHz = stringExtra2;
                this.jGx.jHy = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra("tail_frame");
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.jGy = new AdCard.f();
                this.jGy.HQ(stringExtra3);
            }
        } else if (bundle != null) {
            this.mVideoUrl = bundle.getString("video_url");
            this.mThumbUrl = bundle.getString("video_thumb_url");
            this.jGu = bundle.getFloat("video_ratio", 1.0f);
            this.jvC = bundle.getInt("video_duration", 0);
        } else {
            BdLog.e("NewWebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.jGv > this.jGw && this.jGs != null) {
            this.jGs.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.jGv > 0 && this.jGs != null) {
            this.jGs.stopPlay(this.jGs.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.jGs != null) {
            this.jGs.stopPlay(this.jGs.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.new_ad_web_video_view, (ViewGroup) null, false);
        this.jGt = (WebViewContainer) frameLayout.findViewById(R.id.web_scroll);
        this.dZp = (TBAdWebView) frameLayout.findViewById(R.id.web_web);
        aYc();
        this.jGs = (DistributeVideoView) frameLayout.findViewById(R.id.web_video);
        if (TextUtils.isEmpty(this.mVideoUrl) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.jGs.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.mVideoUrl;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_width = Integer.valueOf(l.getEquipmentWidth(getActivity()));
            builder.video_height = builder.video_width;
            builder.video_duration = Integer.valueOf(this.jvC);
            if (this.jGu > 0.0f) {
                builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.jGu));
            }
            VideoInfo build = builder.build(false);
            this.jGv = build.video_height.intValue();
            this.jGt.setTopMargin(this.jGv);
            this.jGt.setTopLimit(this.jGv);
            this.jGt.setOnScrollChangeListener(this.jGz);
            d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.jGt.setStyle(adAdSense.aJk());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.jGw = this.mVideoHeight / 2;
            if (this.jGy != null) {
                this.jGs.setVideoTailFrameData(this.jGy);
            }
            this.jGs.setPageContext(getPageContext());
            this.jGs.setData(build, 2, getPageContext());
            if (jGC != null) {
                this.jGs.setStatisticInfo(jGC.jGB, jGC.mPageNum, jGC.mPage);
            }
            this.jGs.setTailFrameIsMiddlePage(true);
            this.jGs.updateTailFrameView(null);
            this.jGs.setChargeInfo(this.jGx);
            this.jGs.autoPlay(0);
            AR(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void AR(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dZp.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.getEquipmentHeight(getActivity()) - l.getStatusBarHeight(getActivity())) - cCA();
            this.dZp.setLayoutParams(layoutParams);
        }
    }

    private int cCA() {
        return l.getDimens(this, R.dimen.ds98);
    }
}
