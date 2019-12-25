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
/* loaded from: classes10.dex */
public class NewWebVideoActivity extends NewAdTbWebViewActivity {
    public static a jBQ;
    private DistributeVideoView jBG;
    private WebViewContainer jBH;
    private float jBI;
    private int jBJ;
    private int jBK;
    private AdCard.a jBL;
    private AdCard.f jBM;
    private WebViewContainer.OnScrollChangedCallback jBN = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.newstyle.NewWebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            NewWebVideoActivity.this.jBJ -= i2;
            if (NewWebVideoActivity.this.jBJ <= 0) {
                NewWebVideoActivity.this.jBG.stopPlay(NewWebVideoActivity.this.jBG.getPlayStatus() != 2);
            } else if (NewWebVideoActivity.this.jBJ < NewWebVideoActivity.this.jBK) {
                NewWebVideoActivity.this.jBG.pausePlay(1);
            } else if (NewWebVideoActivity.this.jBG.getPlayStatus() == 2) {
                NewWebVideoActivity.this.jBG.autoContinue();
            } else if (NewWebVideoActivity.this.jBG.getPlayStatus() == -1) {
                NewWebVideoActivity.this.jBG.autoPlay(0);
            }
        }
    };
    private int jqT;
    private String mThumbUrl;
    private int mVideoHeight;
    private String mVideoUrl;

    /* loaded from: classes10.dex */
    public static class a {
        public AdvertAppInfo jBP;
        public String mPage;
        public int mPageNum;
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.mVideoUrl = intent.getStringExtra("video_url");
            this.mThumbUrl = intent.getStringExtra("video_thumb_url");
            this.jBI = intent.getFloatExtra("video_ratio", 1.0f);
            this.jqT = intent.getIntExtra("video_duration", 0);
            String stringExtra = intent.getStringExtra("charge_style");
            String stringExtra2 = intent.getStringExtra("charge_url");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.jBL = new AdCard.a();
                this.jBL.jCN = stringExtra2;
                this.jBL.jCM = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra("tail_frame");
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.jBM = new AdCard.f();
                this.jBM.Hr(stringExtra3);
            }
        } else if (bundle != null) {
            this.mVideoUrl = bundle.getString("video_url");
            this.mThumbUrl = bundle.getString("video_thumb_url");
            this.jBI = bundle.getFloat("video_ratio", 1.0f);
            this.jqT = bundle.getInt("video_duration", 0);
        } else {
            BdLog.e("NewWebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.jBJ > this.jBK && this.jBG != null) {
            this.jBG.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.jBJ > 0 && this.jBG != null) {
            this.jBG.stopPlay(this.jBG.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.jBG != null) {
            this.jBG.stopPlay(this.jBG.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.new_ad_web_video_view, (ViewGroup) null, false);
        this.jBH = (WebViewContainer) frameLayout.findViewById(R.id.web_scroll);
        this.dUO = (TBAdWebView) frameLayout.findViewById(R.id.web_web);
        aVr();
        this.jBG = (DistributeVideoView) frameLayout.findViewById(R.id.web_video);
        if (TextUtils.isEmpty(this.mVideoUrl) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.jBG.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.mVideoUrl;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_width = Integer.valueOf(l.getEquipmentWidth(getActivity()));
            builder.video_height = builder.video_width;
            builder.video_duration = Integer.valueOf(this.jqT);
            if (this.jBI > 0.0f) {
                builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.jBI));
            }
            VideoInfo build = builder.build(false);
            this.jBJ = build.video_height.intValue();
            this.jBH.setTopMargin(this.jBJ);
            this.jBH.setTopLimit(this.jBJ);
            this.jBH.setOnScrollChangeListener(this.jBN);
            d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.jBH.setStyle(adAdSense.aGA());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.jBK = this.mVideoHeight / 2;
            if (this.jBM != null) {
                this.jBG.setVideoTailFrameData(this.jBM);
            }
            this.jBG.setPageContext(getPageContext());
            this.jBG.setData(build, 2, getPageContext());
            if (jBQ != null) {
                this.jBG.setStatisticInfo(jBQ.jBP, jBQ.mPageNum, jBQ.mPage);
            }
            this.jBG.setTailFrameIsMiddlePage(true);
            this.jBG.updateTailFrameView(null);
            this.jBG.setChargeInfo(this.jBL);
            this.jBG.autoPlay(0);
            AD(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void AD(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dUO.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.getEquipmentHeight(getActivity()) - l.getStatusBarHeight(getActivity())) - czS();
            this.dUO.setLayoutParams(layoutParams);
        }
    }

    private int czS() {
        return l.getDimens(this, R.dimen.ds98);
    }
}
