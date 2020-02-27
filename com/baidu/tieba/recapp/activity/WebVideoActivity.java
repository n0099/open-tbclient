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
    public static a jGd;
    private DistributeVideoView jGe;
    private WebViewContainer jGf;
    private float jGg;
    private int jGh;
    private int jGi;
    private AdCard.a jGj;
    private AdCard.f jGk;
    private WebViewContainer.OnScrollChangedCallback jGl = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.WebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            WebVideoActivity.this.jGh -= i2;
            if (WebVideoActivity.this.jGh <= 0) {
                WebVideoActivity.this.jGe.stopPlay(WebVideoActivity.this.jGe.getPlayStatus() != 2);
            } else if (WebVideoActivity.this.jGh < WebVideoActivity.this.jGi) {
                WebVideoActivity.this.jGe.pausePlay(1);
            } else if (WebVideoActivity.this.jGe.getPlayStatus() == 2) {
                WebVideoActivity.this.jGe.autoContinue();
            } else if (WebVideoActivity.this.jGe.getPlayStatus() == -1) {
                WebVideoActivity.this.jGe.autoPlay(0);
            }
        }
    };
    private int jvo;
    private String mThumbUrl;
    private int mVideoHeight;
    private String mVideoUrl;

    /* loaded from: classes13.dex */
    public static class a {
        public AdvertAppInfo jGn;
        public String mPage;
        public int mPageNum;
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.mVideoUrl = intent.getStringExtra("video_url");
            this.mThumbUrl = intent.getStringExtra("video_thumb_url");
            this.jGg = intent.getFloatExtra("video_ratio", 1.0f);
            this.jvo = intent.getIntExtra("video_duration", 0);
            String stringExtra = intent.getStringExtra("charge_style");
            String stringExtra2 = intent.getStringExtra("charge_url");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.jGj = new AdCard.a();
                this.jGj.jHl = stringExtra2;
                this.jGj.jHk = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra("tail_frame");
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.jGk = new AdCard.f();
                this.jGk.HP(stringExtra3);
            }
        } else if (bundle != null) {
            this.mVideoUrl = bundle.getString("video_url");
            this.mThumbUrl = bundle.getString("video_thumb_url");
            this.jGg = bundle.getFloat("video_ratio", 1.0f);
            this.jvo = bundle.getInt("video_duration", 0);
        } else {
            BdLog.e("WebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.jGh > this.jGi && this.jGe != null) {
            this.jGe.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.jGh > 0 && this.jGe != null) {
            this.jGe.stopPlay(this.jGe.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.jGe != null) {
            this.jGe.stopPlay(this.jGe.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.ad_web_video_view, (ViewGroup) null, false);
        this.jGf = (WebViewContainer) frameLayout.findViewById(R.id.web_scroll);
        this.dYK = (AdBaseWebView) frameLayout.findViewById(R.id.web_web);
        aXZ();
        this.jGe = (DistributeVideoView) frameLayout.findViewById(R.id.web_video);
        if (TextUtils.isEmpty(this.mVideoUrl) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.jGe.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.mVideoUrl;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_width = Integer.valueOf(l.getEquipmentWidth(getActivity()));
            builder.video_height = builder.video_width;
            builder.video_duration = Integer.valueOf(this.jvo);
            if (this.jGg > 0.0f) {
                builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.jGg));
            }
            VideoInfo build = builder.build(false);
            this.jGh = build.video_height.intValue();
            this.jGf.setTopMargin(this.jGh);
            this.jGf.setTopLimit(this.jGh);
            this.jGf.setOnScrollChangeListener(this.jGl);
            d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.jGf.setStyle(adAdSense.aJh());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.jGi = this.mVideoHeight / 2;
            if (this.jGk != null) {
                this.jGe.setVideoTailFrameData(this.jGk);
            }
            this.jGe.setPageContext(getPageContext());
            this.jGe.setData(build, 2, getPageContext());
            this.jGe.updateTailFrameView(null);
            if (jGd != null) {
                this.jGe.setStatisticInfo(jGd.jGn, jGd.mPageNum, jGd.mPage);
            }
            this.jGe.setChargeInfo(this.jGj);
            this.jGe.autoPlay(0);
            AR(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void AR(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dYK.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.getEquipmentHeight(getActivity()) - l.getStatusBarHeight(getActivity())) - cCx();
            this.dYK.setLayoutParams(layoutParams);
        }
    }

    private int cCx() {
        return l.getDimens(this, R.dimen.ds98);
    }
}
