package com.baidu.tieba.recapp.activity.newstyle;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
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
/* loaded from: classes26.dex */
public class NewWebVideoActivity extends NewAdTbWebViewActivity {
    public static a mHV;
    private DistributeVideoView mHJ;
    private WebViewContainer mHK;
    private float mHL;
    private int mHM;
    private int mHN;
    private int mHO;
    private int mHP;
    private AdCard.a mHQ;
    private AdCard.f mHR;
    private WebViewContainer.OnScrollChangedCallback mHS = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.newstyle.NewWebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            NewWebVideoActivity.this.mHN -= i2;
            if (NewWebVideoActivity.this.mHN <= 0) {
                NewWebVideoActivity.this.mHJ.stopPlay(NewWebVideoActivity.this.mHJ.getPlayStatus() != 2);
            } else if (NewWebVideoActivity.this.mHN < NewWebVideoActivity.this.mHO) {
                NewWebVideoActivity.this.mHJ.pausePlay(1);
            } else if (NewWebVideoActivity.this.mHJ.getPlayStatus() == 2) {
                NewWebVideoActivity.this.mHJ.autoContinue();
            } else if (NewWebVideoActivity.this.mHJ.getPlayStatus() == -1) {
                NewWebVideoActivity.this.mHJ.autoPlay(0);
            }
        }
    };
    private String mThumbUrl;
    private int mVideoHeight;
    private String mVideoUrl;

    /* loaded from: classes26.dex */
    public static class a {
        public AdvertAppInfo mHU;
        public String mPage;
        public int mPageNum;
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.mVideoUrl = intent.getStringExtra("video_url");
            this.mThumbUrl = intent.getStringExtra("video_thumb_url");
            this.mHL = intent.getFloatExtra("video_ratio", 1.0f);
            this.mHM = intent.getIntExtra("video_duration", 0);
            this.mHP = intent.getIntExtra("good_style", 7);
            String stringExtra = intent.getStringExtra("charge_style");
            String stringExtra2 = intent.getStringExtra("charge_url");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.mHQ = new AdCard.a();
                this.mHQ.mIY = stringExtra2;
                this.mHQ.mIX = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra("tail_frame");
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.mHR = new AdCard.f();
                this.mHR.Sa(stringExtra3);
            }
        } else if (bundle != null) {
            this.mVideoUrl = bundle.getString("video_url");
            this.mThumbUrl = bundle.getString("video_thumb_url");
            this.mHL = bundle.getFloat("video_ratio", 1.0f);
            this.mHM = bundle.getInt("video_duration", 0);
            this.mHP = bundle.getInt("good_style", 7);
        } else {
            BdLog.e("NewWebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.mHN > this.mHO && this.mHJ != null) {
            this.mHJ.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.mHN > 0 && this.mHJ != null) {
            this.mHJ.stopPlay(this.mHJ.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.mHJ != null) {
            this.mHJ.stopPlay(this.mHJ.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.new_ad_web_video_view, (ViewGroup) null, false);
        this.mHK = (WebViewContainer) frameLayout.findViewById(R.id.web_scroll);
        this.fZX = (TBAdWebView) frameLayout.findViewById(R.id.web_web);
        bMp();
        this.mHJ = (DistributeVideoView) frameLayout.findViewById(R.id.web_video);
        if (TextUtils.isEmpty(this.mVideoUrl) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.mHJ.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.mVideoUrl;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_duration = Integer.valueOf(this.mHM);
            if (this.mHP == 14) {
                builder.video_height = Integer.valueOf(l.getEquipmentWidth(getActivity()));
                builder.video_width = Integer.valueOf(com.baidu.tieba.recapp.lego.a.a.Jl(builder.video_height.intValue()));
            } else {
                builder.video_width = Integer.valueOf(l.getEquipmentWidth(getActivity()));
                builder.video_height = builder.video_width;
                if (this.mHL > 0.0f) {
                    builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.mHL));
                }
            }
            VideoInfo build = builder.build(false);
            this.mHN = build.video_height.intValue();
            this.mHK.setTopMargin(this.mHN);
            this.mHK.setTopLimit(this.mHN);
            this.mHK.setOnScrollChangeListener(this.mHS);
            d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.mHK.setStyle(adAdSense.bxl());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.mHO = this.mVideoHeight / 2;
            if (this.mHR != null) {
                this.mHJ.setVideoTailFrameData(this.mHR);
            }
            this.mHJ.setPageContext(getPageContext());
            this.mHJ.setData(build, 2, getPageContext());
            this.mHJ.setTailFrameIsMiddlePage(true);
            this.mHJ.setChargeInfo(this.mHQ);
            this.mHJ.initVideoViewLayout(this.mHP == 14);
            if (mHV != null) {
                this.mHJ.updateTailFrameView(mHV.mHU);
                this.mHJ.setStatisticInfo(mHV.mHU, mHV.mPageNum, mHV.mPage);
            } else {
                this.mHJ.updateTailFrameView(null);
            }
            this.mHJ.autoPlay(0);
            Jg(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void Jg(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fZX.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.getEquipmentHeight(getActivity()) - l.getStatusBarHeight(getActivity())) - dFk();
            this.fZX.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public void onReceivedError(int i) {
        if (i != -2) {
            super.onReceivedError(i);
        }
    }

    private int dFk() {
        return l.getDimens(this, R.dimen.ds98);
    }

    public static void a(AdvertAppInfo advertAppInfo, int i, String str) {
        mHV = new a();
        mHV.mHU = advertAppInfo;
        mHV.mPage = str;
        mHV.mPageNum = i;
    }

    public static void a(NewWebVideoActivityConfig newWebVideoActivityConfig) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
    }
}
