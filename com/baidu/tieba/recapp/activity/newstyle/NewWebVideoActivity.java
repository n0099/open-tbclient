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
    public static a krQ;
    private int kha;
    private DistributeVideoView krG;
    private WebViewContainer krH;
    private float krI;
    private int krJ;
    private int krK;
    private AdCard.a krL;
    private AdCard.f krM;
    private WebViewContainer.OnScrollChangedCallback krN = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.newstyle.NewWebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            NewWebVideoActivity.this.krJ -= i2;
            if (NewWebVideoActivity.this.krJ <= 0) {
                NewWebVideoActivity.this.krG.stopPlay(NewWebVideoActivity.this.krG.getPlayStatus() != 2);
            } else if (NewWebVideoActivity.this.krJ < NewWebVideoActivity.this.krK) {
                NewWebVideoActivity.this.krG.pausePlay(1);
            } else if (NewWebVideoActivity.this.krG.getPlayStatus() == 2) {
                NewWebVideoActivity.this.krG.autoContinue();
            } else if (NewWebVideoActivity.this.krG.getPlayStatus() == -1) {
                NewWebVideoActivity.this.krG.autoPlay(0);
            }
        }
    };
    private String mThumbUrl;
    private int mVideoHeight;
    private String mVideoUrl;

    /* loaded from: classes13.dex */
    public static class a {
        public AdvertAppInfo krP;
        public String mPage;
        public int mPageNum;
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.mVideoUrl = intent.getStringExtra("video_url");
            this.mThumbUrl = intent.getStringExtra("video_thumb_url");
            this.krI = intent.getFloatExtra("video_ratio", 1.0f);
            this.kha = intent.getIntExtra("video_duration", 0);
            String stringExtra = intent.getStringExtra("charge_style");
            String stringExtra2 = intent.getStringExtra("charge_url");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.krL = new AdCard.a();
                this.krL.ksO = stringExtra2;
                this.krL.ksN = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra("tail_frame");
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.krM = new AdCard.f();
                this.krM.Jx(stringExtra3);
            }
        } else if (bundle != null) {
            this.mVideoUrl = bundle.getString("video_url");
            this.mThumbUrl = bundle.getString("video_thumb_url");
            this.krI = bundle.getFloat("video_ratio", 1.0f);
            this.kha = bundle.getInt("video_duration", 0);
        } else {
            BdLog.e("NewWebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.krJ > this.krK && this.krG != null) {
            this.krG.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.krJ > 0 && this.krG != null) {
            this.krG.stopPlay(this.krG.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.krG != null) {
            this.krG.stopPlay(this.krG.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.new_ad_web_video_view, (ViewGroup) null, false);
        this.krH = (WebViewContainer) frameLayout.findViewById(R.id.web_scroll);
        this.ezH = (TBAdWebView) frameLayout.findViewById(R.id.web_web);
        bgj();
        this.krG = (DistributeVideoView) frameLayout.findViewById(R.id.web_video);
        if (TextUtils.isEmpty(this.mVideoUrl) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.krG.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.mVideoUrl;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_width = Integer.valueOf(l.getEquipmentWidth(getActivity()));
            builder.video_height = builder.video_width;
            builder.video_duration = Integer.valueOf(this.kha);
            if (this.krI > 0.0f) {
                builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.krI));
            }
            VideoInfo build = builder.build(false);
            this.krJ = build.video_height.intValue();
            this.krH.setTopMargin(this.krJ);
            this.krH.setTopLimit(this.krJ);
            this.krH.setOnScrollChangeListener(this.krN);
            d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.krH.setStyle(adAdSense.aRI());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.krK = this.mVideoHeight / 2;
            if (this.krM != null) {
                this.krG.setVideoTailFrameData(this.krM);
            }
            this.krG.setPageContext(getPageContext());
            this.krG.setData(build, 2, getPageContext());
            this.krG.setTailFrameIsMiddlePage(true);
            this.krG.updateTailFrameView(null);
            this.krG.setChargeInfo(this.krL);
            this.krG.autoPlay(0);
            if (krQ != null) {
                this.krG.setStatisticInfo(krQ.krP, krQ.mPageNum, krQ.mPage);
            }
            Bz(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void Bz(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ezH.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.getEquipmentHeight(getActivity()) - l.getStatusBarHeight(getActivity())) - cNq();
            this.ezH.setLayoutParams(layoutParams);
        }
    }

    private int cNq() {
        return l.getDimens(this, R.dimen.ds98);
    }
}
