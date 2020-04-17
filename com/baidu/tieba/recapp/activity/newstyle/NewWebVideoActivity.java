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
    public static a krM;
    private int kgW;
    private DistributeVideoView krC;
    private WebViewContainer krD;
    private float krE;
    private int krF;
    private int krG;
    private AdCard.a krH;
    private AdCard.f krI;
    private WebViewContainer.OnScrollChangedCallback krJ = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.newstyle.NewWebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            NewWebVideoActivity.this.krF -= i2;
            if (NewWebVideoActivity.this.krF <= 0) {
                NewWebVideoActivity.this.krC.stopPlay(NewWebVideoActivity.this.krC.getPlayStatus() != 2);
            } else if (NewWebVideoActivity.this.krF < NewWebVideoActivity.this.krG) {
                NewWebVideoActivity.this.krC.pausePlay(1);
            } else if (NewWebVideoActivity.this.krC.getPlayStatus() == 2) {
                NewWebVideoActivity.this.krC.autoContinue();
            } else if (NewWebVideoActivity.this.krC.getPlayStatus() == -1) {
                NewWebVideoActivity.this.krC.autoPlay(0);
            }
        }
    };
    private String mThumbUrl;
    private int mVideoHeight;
    private String mVideoUrl;

    /* loaded from: classes13.dex */
    public static class a {
        public AdvertAppInfo krL;
        public String mPage;
        public int mPageNum;
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.mVideoUrl = intent.getStringExtra("video_url");
            this.mThumbUrl = intent.getStringExtra("video_thumb_url");
            this.krE = intent.getFloatExtra("video_ratio", 1.0f);
            this.kgW = intent.getIntExtra("video_duration", 0);
            String stringExtra = intent.getStringExtra("charge_style");
            String stringExtra2 = intent.getStringExtra("charge_url");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.krH = new AdCard.a();
                this.krH.ksK = stringExtra2;
                this.krH.ksJ = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra("tail_frame");
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.krI = new AdCard.f();
                this.krI.Ju(stringExtra3);
            }
        } else if (bundle != null) {
            this.mVideoUrl = bundle.getString("video_url");
            this.mThumbUrl = bundle.getString("video_thumb_url");
            this.krE = bundle.getFloat("video_ratio", 1.0f);
            this.kgW = bundle.getInt("video_duration", 0);
        } else {
            BdLog.e("NewWebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.krF > this.krG && this.krC != null) {
            this.krC.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.krF > 0 && this.krC != null) {
            this.krC.stopPlay(this.krC.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.krC != null) {
            this.krC.stopPlay(this.krC.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.new_ad_web_video_view, (ViewGroup) null, false);
        this.krD = (WebViewContainer) frameLayout.findViewById(R.id.web_scroll);
        this.ezC = (TBAdWebView) frameLayout.findViewById(R.id.web_web);
        bgl();
        this.krC = (DistributeVideoView) frameLayout.findViewById(R.id.web_video);
        if (TextUtils.isEmpty(this.mVideoUrl) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.krC.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.mVideoUrl;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_width = Integer.valueOf(l.getEquipmentWidth(getActivity()));
            builder.video_height = builder.video_width;
            builder.video_duration = Integer.valueOf(this.kgW);
            if (this.krE > 0.0f) {
                builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.krE));
            }
            VideoInfo build = builder.build(false);
            this.krF = build.video_height.intValue();
            this.krD.setTopMargin(this.krF);
            this.krD.setTopLimit(this.krF);
            this.krD.setOnScrollChangeListener(this.krJ);
            d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.krD.setStyle(adAdSense.aRL());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.krG = this.mVideoHeight / 2;
            if (this.krI != null) {
                this.krC.setVideoTailFrameData(this.krI);
            }
            this.krC.setPageContext(getPageContext());
            this.krC.setData(build, 2, getPageContext());
            this.krC.setTailFrameIsMiddlePage(true);
            this.krC.updateTailFrameView(null);
            this.krC.setChargeInfo(this.krH);
            this.krC.autoPlay(0);
            if (krM != null) {
                this.krC.setStatisticInfo(krM.krL, krM.mPageNum, krM.mPage);
            }
            Bz(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void Bz(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ezC.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.getEquipmentHeight(getActivity()) - l.getStatusBarHeight(getActivity())) - cNs();
            this.ezC.setLayoutParams(layoutParams);
        }
    }

    private int cNs() {
        return l.getDimens(this, R.dimen.ds98);
    }
}
