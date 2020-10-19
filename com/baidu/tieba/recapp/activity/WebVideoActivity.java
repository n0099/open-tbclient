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
@Deprecated
/* loaded from: classes26.dex */
public class WebVideoActivity extends AdTbWebViewActivity {
    public static a maN;
    private String mThumbUrl;
    private int mVideoHeight;
    private String mVideoUrl;
    private DistributeVideoView maO;
    private WebViewContainer maP;
    private float maQ;
    private int maR;
    private int maS;
    private int maT;
    private int maU;
    private AdCard.a maV;
    private AdCard.f maW;
    private WebViewContainer.OnScrollChangedCallback maX = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.WebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            WebVideoActivity.this.maS -= i2;
            if (WebVideoActivity.this.maS <= 0) {
                WebVideoActivity.this.maO.stopPlay(WebVideoActivity.this.maO.getPlayStatus() != 2);
            } else if (WebVideoActivity.this.maS < WebVideoActivity.this.maT) {
                WebVideoActivity.this.maO.pausePlay(1);
            } else if (WebVideoActivity.this.maO.getPlayStatus() == 2) {
                WebVideoActivity.this.maO.autoContinue();
            } else if (WebVideoActivity.this.maO.getPlayStatus() == -1) {
                WebVideoActivity.this.maO.autoPlay(0);
            }
        }
    };

    /* loaded from: classes26.dex */
    public static class a {
        public String mPage;
        public int mPageNum;
        public AdvertAppInfo maZ;
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.mVideoUrl = intent.getStringExtra("video_url");
            this.mThumbUrl = intent.getStringExtra("video_thumb_url");
            this.maQ = intent.getFloatExtra("video_ratio", 1.0f);
            this.maR = intent.getIntExtra("video_duration", 0);
            this.maU = intent.getIntExtra("good_style", 7);
            String stringExtra = intent.getStringExtra("charge_style");
            String stringExtra2 = intent.getStringExtra("charge_url");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.maV = new AdCard.a();
                this.maV.mbY = stringExtra2;
                this.maV.mbX = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra("tail_frame");
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.maW = new AdCard.f();
                this.maW.QH(stringExtra3);
            }
        } else if (bundle != null) {
            this.mVideoUrl = bundle.getString("video_url");
            this.mThumbUrl = bundle.getString("video_thumb_url");
            this.maQ = bundle.getFloat("video_ratio", 1.0f);
            this.maR = bundle.getInt("video_duration", 0);
            this.maU = bundle.getInt("good_style", 7);
        } else {
            BdLog.e("WebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.maS > this.maT && this.maO != null) {
            this.maO.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.maS > 0 && this.maO != null) {
            this.maO.stopPlay(this.maO.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.maO != null) {
            this.maO.stopPlay(this.maO.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.ad_web_video_view, (ViewGroup) null, false);
        this.maP = (WebViewContainer) frameLayout.findViewById(R.id.web_scroll);
        this.fDD = (AdBaseWebView) frameLayout.findViewById(R.id.web_web);
        bEU();
        this.maO = (DistributeVideoView) frameLayout.findViewById(R.id.web_video);
        if (TextUtils.isEmpty(this.mVideoUrl) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.maO.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.mVideoUrl;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_duration = Integer.valueOf(this.maR);
            if (this.maU == 14) {
                builder.video_height = Integer.valueOf(l.getEquipmentWidth(getActivity()));
                builder.video_width = Integer.valueOf(com.baidu.g.a.e.a.m21do(builder.video_height.intValue()));
            } else {
                builder.video_width = Integer.valueOf(l.getEquipmentWidth(getActivity()));
                builder.video_height = builder.video_width;
                if (this.maQ > 0.0f) {
                    builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.maQ));
                }
            }
            VideoInfo build = builder.build(false);
            this.maS = build.video_height.intValue();
            this.maP.setTopMargin(this.maS);
            this.maP.setTopLimit(this.maS);
            this.maP.setOnScrollChangeListener(this.maX);
            d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.maP.setStyle(adAdSense.bqc());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.maT = this.mVideoHeight / 2;
            if (this.maW != null) {
                this.maO.setVideoTailFrameData(this.maW);
            }
            this.maO.setPageContext(getPageContext());
            this.maO.setData(build, 2, getPageContext());
            if (maN != null) {
                this.maO.updateTailFrameView(maN.maZ);
                this.maO.setStatisticInfo(maN.maZ, maN.mPageNum, maN.mPage);
            } else {
                this.maO.updateTailFrameView(null);
            }
            this.maO.setChargeInfo(this.maV);
            this.maO.autoPlay(0);
            this.maO.initVideoViewLayout(this.maU == 14);
            Hl(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void Hl(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fDD.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.getEquipmentHeight(getActivity()) - l.getStatusBarHeight(getActivity())) - duJ();
            this.fDD.setLayoutParams(layoutParams);
        }
    }

    private int duJ() {
        return l.getDimens(this, R.dimen.ds98);
    }
}
