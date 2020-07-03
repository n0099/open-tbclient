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
    public static a leN;
    private int kTV;
    private DistributeVideoView leC;
    private WebViewContainer leD;
    private float leE;
    private int leF;
    private int leG;
    private int leH;
    private AdCard.a leI;
    private AdCard.f leJ;
    private WebViewContainer.OnScrollChangedCallback leK = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.newstyle.NewWebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            NewWebVideoActivity.this.leF -= i2;
            if (NewWebVideoActivity.this.leF <= 0) {
                NewWebVideoActivity.this.leC.stopPlay(NewWebVideoActivity.this.leC.getPlayStatus() != 2);
            } else if (NewWebVideoActivity.this.leF < NewWebVideoActivity.this.leG) {
                NewWebVideoActivity.this.leC.pausePlay(1);
            } else if (NewWebVideoActivity.this.leC.getPlayStatus() == 2) {
                NewWebVideoActivity.this.leC.autoContinue();
            } else if (NewWebVideoActivity.this.leC.getPlayStatus() == -1) {
                NewWebVideoActivity.this.leC.autoPlay(0);
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

    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
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
            BdLog.e("NewWebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.leF > this.leG && this.leC != null) {
            this.leC.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.leF > 0 && this.leC != null) {
            this.leC.stopPlay(this.leC.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.leC != null) {
            this.leC.stopPlay(this.leC.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.new_ad_web_video_view, (ViewGroup) null, false);
        this.leD = (WebViewContainer) frameLayout.findViewById(R.id.web_scroll);
        this.eYD = (TBAdWebView) frameLayout.findViewById(R.id.web_web);
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
            this.leC.setTailFrameIsMiddlePage(true);
            this.leC.setChargeInfo(this.leI);
            this.leC.autoPlay(0);
            this.leC.initVideoViewLayout(this.leH == 14);
            if (leN != null) {
                this.leC.updateTailFrameView(leN.leM);
                this.leC.setStatisticInfo(leN.leM, leN.mPageNum, leN.mPage);
            } else {
                this.leC.updateTailFrameView(null);
            }
            Dn(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void Dn(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eYD.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.getEquipmentHeight(getActivity()) - l.getStatusBarHeight(getActivity())) - cYW();
            this.eYD.setLayoutParams(layoutParams);
        }
    }

    private int cYW() {
        return l.getDimens(this, R.dimen.ds98);
    }
}
