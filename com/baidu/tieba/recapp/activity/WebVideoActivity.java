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
    public static a krB;
    private int kgW;
    private DistributeVideoView krC;
    private WebViewContainer krD;
    private float krE;
    private int krF;
    private int krG;
    private AdCard.a krH;
    private AdCard.f krI;
    private WebViewContainer.OnScrollChangedCallback krJ = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.WebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            WebVideoActivity.this.krF -= i2;
            if (WebVideoActivity.this.krF <= 0) {
                WebVideoActivity.this.krC.stopPlay(WebVideoActivity.this.krC.getPlayStatus() != 2);
            } else if (WebVideoActivity.this.krF < WebVideoActivity.this.krG) {
                WebVideoActivity.this.krC.pausePlay(1);
            } else if (WebVideoActivity.this.krC.getPlayStatus() == 2) {
                WebVideoActivity.this.krC.autoContinue();
            } else if (WebVideoActivity.this.krC.getPlayStatus() == -1) {
                WebVideoActivity.this.krC.autoPlay(0);
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

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
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
            BdLog.e("WebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.krF > this.krG && this.krC != null) {
            this.krC.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.krF > 0 && this.krC != null) {
            this.krC.stopPlay(this.krC.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.krC != null) {
            this.krC.stopPlay(this.krC.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.ad_web_video_view, (ViewGroup) null, false);
        this.krD = (WebViewContainer) frameLayout.findViewById(R.id.web_scroll);
        this.ezl = (AdBaseWebView) frameLayout.findViewById(R.id.web_web);
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
            this.krC.updateTailFrameView(null);
            if (krB != null) {
                this.krC.setStatisticInfo(krB.krL, krB.mPageNum, krB.mPage);
            }
            this.krC.setChargeInfo(this.krH);
            this.krC.autoPlay(0);
            Bz(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void Bz(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ezl.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.getEquipmentHeight(getActivity()) - l.getStatusBarHeight(getActivity())) - cNs();
            this.ezl.setLayoutParams(layoutParams);
        }
    }

    private int cNs() {
        return l.getDimens(this, R.dimen.ds98);
    }
}
