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
/* loaded from: classes13.dex */
public class WebVideoActivity extends AdTbWebViewActivity {
    public static a leB;
    private int kTV;
    private DistributeVideoView leC;
    private WebViewContainer leD;
    private float leE;
    private int leF;
    private int leG;
    private int leH;
    private AdCard.a leI;
    private AdCard.f leJ;
    private WebViewContainer.OnScrollChangedCallback leK = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.WebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            WebVideoActivity.this.leF -= i2;
            if (WebVideoActivity.this.leF <= 0) {
                WebVideoActivity.this.leC.stopPlay(WebVideoActivity.this.leC.getPlayStatus() != 2);
            } else if (WebVideoActivity.this.leF < WebVideoActivity.this.leG) {
                WebVideoActivity.this.leC.pausePlay(1);
            } else if (WebVideoActivity.this.leC.getPlayStatus() == 2) {
                WebVideoActivity.this.leC.autoContinue();
            } else if (WebVideoActivity.this.leC.getPlayStatus() == -1) {
                WebVideoActivity.this.leC.autoPlay(0);
            }
        }
    };
    private String mThumbUrl;
    private int mVideoHeight;
    private String mVideoUrl;

    /* loaded from: classes13.dex */
    public static class a {
        public AdvertAppInfo leM;
        public String mPage;
        public int mPageNum;
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.mVideoUrl = intent.getStringExtra("video_url");
            this.mThumbUrl = intent.getStringExtra("video_thumb_url");
            this.leE = intent.getFloatExtra("video_ratio", 1.0f);
            this.kTV = intent.getIntExtra("video_duration", 0);
            this.leH = intent.getIntExtra("good_style", 7);
            String stringExtra = intent.getStringExtra("charge_style");
            String stringExtra2 = intent.getStringExtra("charge_url");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.leI = new AdCard.a();
                this.leI.lfL = stringExtra2;
                this.leI.lfK = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra("tail_frame");
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.leJ = new AdCard.f();
                this.leJ.LL(stringExtra3);
            }
        } else if (bundle != null) {
            this.mVideoUrl = bundle.getString("video_url");
            this.mThumbUrl = bundle.getString("video_thumb_url");
            this.leE = bundle.getFloat("video_ratio", 1.0f);
            this.kTV = bundle.getInt("video_duration", 0);
            this.leH = bundle.getInt("good_style", 7);
        } else {
            BdLog.e("WebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.leF > this.leG && this.leC != null) {
            this.leC.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.leF > 0 && this.leC != null) {
            this.leC.stopPlay(this.leC.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.leC != null) {
            this.leC.stopPlay(this.leC.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.ad_web_video_view, (ViewGroup) null, false);
        this.leD = (WebViewContainer) frameLayout.findViewById(R.id.web_scroll);
        this.eYm = (AdBaseWebView) frameLayout.findViewById(R.id.web_web);
        boV();
        this.leC = (DistributeVideoView) frameLayout.findViewById(R.id.web_video);
        if (TextUtils.isEmpty(this.mVideoUrl) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.leC.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.mVideoUrl;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_duration = Integer.valueOf(this.kTV);
            if (this.leH == 14) {
                builder.video_height = Integer.valueOf(l.getEquipmentWidth(getActivity()));
                builder.video_width = Integer.valueOf(com.baidu.b.a.e.a.by(builder.video_height.intValue()));
            } else {
                builder.video_width = Integer.valueOf(l.getEquipmentWidth(getActivity()));
                builder.video_height = builder.video_width;
                if (this.leE > 0.0f) {
                    builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.leE));
                }
            }
            VideoInfo build = builder.build(false);
            this.leF = build.video_height.intValue();
            this.leD.setTopMargin(this.leF);
            this.leD.setTopLimit(this.leF);
            this.leD.setOnScrollChangeListener(this.leK);
            d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.leD.setStyle(adAdSense.aZV());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.leG = this.mVideoHeight / 2;
            if (this.leJ != null) {
                this.leC.setVideoTailFrameData(this.leJ);
            }
            this.leC.setPageContext(getPageContext());
            this.leC.setData(build, 2, getPageContext());
            if (leB != null) {
                this.leC.updateTailFrameView(leB.leM);
                this.leC.setStatisticInfo(leB.leM, leB.mPageNum, leB.mPage);
            } else {
                this.leC.updateTailFrameView(null);
            }
            this.leC.setChargeInfo(this.leI);
            this.leC.autoPlay(0);
            this.leC.initVideoViewLayout(this.leH == 14);
            Dn(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void Dn(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eYm.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.getEquipmentHeight(getActivity()) - l.getStatusBarHeight(getActivity())) - cYW();
            this.eYm.setLayoutParams(layoutParams);
        }
    }

    private int cYW() {
        return l.getDimens(this, R.dimen.ds98);
    }
}
