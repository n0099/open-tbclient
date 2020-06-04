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
    public static a kKH;
    private DistributeVideoView kKI;
    private WebViewContainer kKJ;
    private float kKK;
    private int kKL;
    private int kKM;
    private int kKN;
    private AdCard.a kKO;
    private AdCard.f kKP;
    private WebViewContainer.OnScrollChangedCallback kKQ = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.WebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            WebVideoActivity.this.kKL -= i2;
            if (WebVideoActivity.this.kKL <= 0) {
                WebVideoActivity.this.kKI.stopPlay(WebVideoActivity.this.kKI.getPlayStatus() != 2);
            } else if (WebVideoActivity.this.kKL < WebVideoActivity.this.kKM) {
                WebVideoActivity.this.kKI.pausePlay(1);
            } else if (WebVideoActivity.this.kKI.getPlayStatus() == 2) {
                WebVideoActivity.this.kKI.autoContinue();
            } else if (WebVideoActivity.this.kKI.getPlayStatus() == -1) {
                WebVideoActivity.this.kKI.autoPlay(0);
            }
        }
    };
    private int kzY;
    private String mThumbUrl;
    private int mVideoHeight;
    private String mVideoUrl;

    /* loaded from: classes13.dex */
    public static class a {
        public AdvertAppInfo kKS;
        public String mPage;
        public int mPageNum;
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.mVideoUrl = intent.getStringExtra("video_url");
            this.mThumbUrl = intent.getStringExtra("video_thumb_url");
            this.kKK = intent.getFloatExtra("video_ratio", 1.0f);
            this.kzY = intent.getIntExtra("video_duration", 0);
            this.kKN = intent.getIntExtra("good_style", 7);
            String stringExtra = intent.getStringExtra("charge_style");
            String stringExtra2 = intent.getStringExtra("charge_url");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.kKO = new AdCard.a();
                this.kKO.kLR = stringExtra2;
                this.kKO.kLQ = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra("tail_frame");
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.kKP = new AdCard.f();
                this.kKP.Lk(stringExtra3);
            }
        } else if (bundle != null) {
            this.mVideoUrl = bundle.getString("video_url");
            this.mThumbUrl = bundle.getString("video_thumb_url");
            this.kKK = bundle.getFloat("video_ratio", 1.0f);
            this.kzY = bundle.getInt("video_duration", 0);
            this.kKN = bundle.getInt("good_style", 7);
        } else {
            BdLog.e("WebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.kKL > this.kKM && this.kKI != null) {
            this.kKI.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.kKL > 0 && this.kKI != null) {
            this.kKI.stopPlay(this.kKI.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.kKI != null) {
            this.kKI.stopPlay(this.kKI.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.ad_web_video_view, (ViewGroup) null, false);
        this.kKJ = (WebViewContainer) frameLayout.findViewById(R.id.web_scroll);
        this.eOb = (AdBaseWebView) frameLayout.findViewById(R.id.web_web);
        bmw();
        this.kKI = (DistributeVideoView) frameLayout.findViewById(R.id.web_video);
        if (TextUtils.isEmpty(this.mVideoUrl) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.kKI.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.mVideoUrl;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_duration = Integer.valueOf(this.kzY);
            if (this.kKN == 14) {
                builder.video_height = Integer.valueOf(l.getEquipmentWidth(getActivity()));
                builder.video_width = Integer.valueOf(com.baidu.b.a.e.a.bt(builder.video_height.intValue()));
            } else {
                builder.video_width = Integer.valueOf(l.getEquipmentWidth(getActivity()));
                builder.video_height = builder.video_width;
                if (this.kKK > 0.0f) {
                    builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.kKK));
                }
            }
            VideoInfo build = builder.build(false);
            this.kKL = build.video_height.intValue();
            this.kKJ.setTopMargin(this.kKL);
            this.kKJ.setTopLimit(this.kKL);
            this.kKJ.setOnScrollChangeListener(this.kKQ);
            d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.kKJ.setStyle(adAdSense.aXQ());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.kKM = this.mVideoHeight / 2;
            if (this.kKP != null) {
                this.kKI.setVideoTailFrameData(this.kKP);
            }
            this.kKI.setPageContext(getPageContext());
            this.kKI.setData(build, 2, getPageContext());
            if (kKH != null) {
                this.kKI.updateTailFrameView(kKH.kKS);
                this.kKI.setStatisticInfo(kKH.kKS, kKH.mPageNum, kKH.mPage);
            } else {
                this.kKI.updateTailFrameView(null);
            }
            this.kKI.setChargeInfo(this.kKO);
            this.kKI.autoPlay(0);
            this.kKI.initVideoViewLayout(this.kKN == 14);
            Cl(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void Cl(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eOb.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.getEquipmentHeight(getActivity()) - l.getStatusBarHeight(getActivity())) - cUG();
            this.eOb.setLayoutParams(layoutParams);
        }
    }

    private int cUG() {
        return l.getDimens(this, R.dimen.ds98);
    }
}
