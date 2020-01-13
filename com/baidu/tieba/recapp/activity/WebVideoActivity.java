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
    public static a jFh;
    private DistributeVideoView jFi;
    private WebViewContainer jFj;
    private float jFk;
    private int jFl;
    private int jFm;
    private AdCard.a jFn;
    private AdCard.f jFo;
    private WebViewContainer.OnScrollChangedCallback jFp = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.WebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            WebVideoActivity.this.jFl -= i2;
            if (WebVideoActivity.this.jFl <= 0) {
                WebVideoActivity.this.jFi.stopPlay(WebVideoActivity.this.jFi.getPlayStatus() != 2);
            } else if (WebVideoActivity.this.jFl < WebVideoActivity.this.jFm) {
                WebVideoActivity.this.jFi.pausePlay(1);
            } else if (WebVideoActivity.this.jFi.getPlayStatus() == 2) {
                WebVideoActivity.this.jFi.autoContinue();
            } else if (WebVideoActivity.this.jFi.getPlayStatus() == -1) {
                WebVideoActivity.this.jFi.autoPlay(0);
            }
        }
    };
    private int juu;
    private String mThumbUrl;
    private int mVideoHeight;
    private String mVideoUrl;

    /* loaded from: classes11.dex */
    public static class a {
        public AdvertAppInfo jFr;
        public String mPage;
        public int mPageNum;
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.mVideoUrl = intent.getStringExtra("video_url");
            this.mThumbUrl = intent.getStringExtra("video_thumb_url");
            this.jFk = intent.getFloatExtra("video_ratio", 1.0f);
            this.juu = intent.getIntExtra("video_duration", 0);
            String stringExtra = intent.getStringExtra("charge_style");
            String stringExtra2 = intent.getStringExtra("charge_url");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.jFn = new AdCard.a();
                this.jFn.jGp = stringExtra2;
                this.jFn.jGo = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra("tail_frame");
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.jFo = new AdCard.f();
                this.jFo.HB(stringExtra3);
            }
        } else if (bundle != null) {
            this.mVideoUrl = bundle.getString("video_url");
            this.mThumbUrl = bundle.getString("video_thumb_url");
            this.jFk = bundle.getFloat("video_ratio", 1.0f);
            this.juu = bundle.getInt("video_duration", 0);
        } else {
            BdLog.e("WebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.jFl > this.jFm && this.jFi != null) {
            this.jFi.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.jFl > 0 && this.jFi != null) {
            this.jFi.stopPlay(this.jFi.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.jFi != null) {
            this.jFi.stopPlay(this.jFi.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.ad_web_video_view, (ViewGroup) null, false);
        this.jFj = (WebViewContainer) frameLayout.findViewById(R.id.web_scroll);
        this.dUG = (AdBaseWebView) frameLayout.findViewById(R.id.web_web);
        aVK();
        this.jFi = (DistributeVideoView) frameLayout.findViewById(R.id.web_video);
        if (TextUtils.isEmpty(this.mVideoUrl) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.jFi.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.mVideoUrl;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_width = Integer.valueOf(l.getEquipmentWidth(getActivity()));
            builder.video_height = builder.video_width;
            builder.video_duration = Integer.valueOf(this.juu);
            if (this.jFk > 0.0f) {
                builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.jFk));
            }
            VideoInfo build = builder.build(false);
            this.jFl = build.video_height.intValue();
            this.jFj.setTopMargin(this.jFl);
            this.jFj.setTopLimit(this.jFl);
            this.jFj.setOnScrollChangeListener(this.jFp);
            d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.jFj.setStyle(adAdSense.aGT());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.jFm = this.mVideoHeight / 2;
            if (this.jFo != null) {
                this.jFi.setVideoTailFrameData(this.jFo);
            }
            this.jFi.setPageContext(getPageContext());
            this.jFi.setData(build, 2, getPageContext());
            this.jFi.updateTailFrameView(null);
            if (jFh != null) {
                this.jFi.setStatisticInfo(jFh.jFr, jFh.mPageNum, jFh.mPage);
            }
            this.jFi.setChargeInfo(this.jFn);
            this.jFi.autoPlay(0);
            AI(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void AI(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dUG.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.getEquipmentHeight(getActivity()) - l.getStatusBarHeight(getActivity())) - cAZ();
            this.dUG.setLayoutParams(layoutParams);
        }
    }

    private int cAZ() {
        return l.getDimens(this, R.dimen.ds98);
    }
}
