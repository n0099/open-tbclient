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
    public static a mHT;
    private DistributeVideoView mHH;
    private WebViewContainer mHI;
    private float mHJ;
    private int mHK;
    private int mHL;
    private int mHM;
    private int mHN;
    private AdCard.a mHO;
    private AdCard.f mHP;
    private WebViewContainer.OnScrollChangedCallback mHQ = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.newstyle.NewWebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            NewWebVideoActivity.this.mHL -= i2;
            if (NewWebVideoActivity.this.mHL <= 0) {
                NewWebVideoActivity.this.mHH.stopPlay(NewWebVideoActivity.this.mHH.getPlayStatus() != 2);
            } else if (NewWebVideoActivity.this.mHL < NewWebVideoActivity.this.mHM) {
                NewWebVideoActivity.this.mHH.pausePlay(1);
            } else if (NewWebVideoActivity.this.mHH.getPlayStatus() == 2) {
                NewWebVideoActivity.this.mHH.autoContinue();
            } else if (NewWebVideoActivity.this.mHH.getPlayStatus() == -1) {
                NewWebVideoActivity.this.mHH.autoPlay(0);
            }
        }
    };
    private String mThumbUrl;
    private int mVideoHeight;
    private String mVideoUrl;

    /* loaded from: classes26.dex */
    public static class a {
        public AdvertAppInfo mHS;
        public String mPage;
        public int mPageNum;
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.mVideoUrl = intent.getStringExtra("video_url");
            this.mThumbUrl = intent.getStringExtra("video_thumb_url");
            this.mHJ = intent.getFloatExtra("video_ratio", 1.0f);
            this.mHK = intent.getIntExtra("video_duration", 0);
            this.mHN = intent.getIntExtra("good_style", 7);
            String stringExtra = intent.getStringExtra("charge_style");
            String stringExtra2 = intent.getStringExtra("charge_url");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.mHO = new AdCard.a();
                this.mHO.mIW = stringExtra2;
                this.mHO.mIV = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra("tail_frame");
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.mHP = new AdCard.f();
                this.mHP.Sa(stringExtra3);
            }
        } else if (bundle != null) {
            this.mVideoUrl = bundle.getString("video_url");
            this.mThumbUrl = bundle.getString("video_thumb_url");
            this.mHJ = bundle.getFloat("video_ratio", 1.0f);
            this.mHK = bundle.getInt("video_duration", 0);
            this.mHN = bundle.getInt("good_style", 7);
        } else {
            BdLog.e("NewWebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.mHL > this.mHM && this.mHH != null) {
            this.mHH.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.mHL > 0 && this.mHH != null) {
            this.mHH.stopPlay(this.mHH.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.mHH != null) {
            this.mHH.stopPlay(this.mHH.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.new_ad_web_video_view, (ViewGroup) null, false);
        this.mHI = (WebViewContainer) frameLayout.findViewById(R.id.web_scroll);
        this.fZV = (TBAdWebView) frameLayout.findViewById(R.id.web_web);
        bMo();
        this.mHH = (DistributeVideoView) frameLayout.findViewById(R.id.web_video);
        if (TextUtils.isEmpty(this.mVideoUrl) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.mHH.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.mVideoUrl;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_duration = Integer.valueOf(this.mHK);
            if (this.mHN == 14) {
                builder.video_height = Integer.valueOf(l.getEquipmentWidth(getActivity()));
                builder.video_width = Integer.valueOf(com.baidu.tieba.recapp.lego.a.a.Jl(builder.video_height.intValue()));
            } else {
                builder.video_width = Integer.valueOf(l.getEquipmentWidth(getActivity()));
                builder.video_height = builder.video_width;
                if (this.mHJ > 0.0f) {
                    builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.mHJ));
                }
            }
            VideoInfo build = builder.build(false);
            this.mHL = build.video_height.intValue();
            this.mHI.setTopMargin(this.mHL);
            this.mHI.setTopLimit(this.mHL);
            this.mHI.setOnScrollChangeListener(this.mHQ);
            d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.mHI.setStyle(adAdSense.bxl());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.mHM = this.mVideoHeight / 2;
            if (this.mHP != null) {
                this.mHH.setVideoTailFrameData(this.mHP);
            }
            this.mHH.setPageContext(getPageContext());
            this.mHH.setData(build, 2, getPageContext());
            this.mHH.setTailFrameIsMiddlePage(true);
            this.mHH.setChargeInfo(this.mHO);
            this.mHH.initVideoViewLayout(this.mHN == 14);
            if (mHT != null) {
                this.mHH.updateTailFrameView(mHT.mHS);
                this.mHH.setStatisticInfo(mHT.mHS, mHT.mPageNum, mHT.mPage);
            } else {
                this.mHH.updateTailFrameView(null);
            }
            this.mHH.autoPlay(0);
            Jg(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void Jg(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fZV.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.getEquipmentHeight(getActivity()) - l.getStatusBarHeight(getActivity())) - dFj();
            this.fZV.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public void onReceivedError(int i) {
        if (i != -2) {
            super.onReceivedError(i);
        }
    }

    private int dFj() {
        return l.getDimens(this, R.dimen.ds98);
    }

    public static void a(AdvertAppInfo advertAppInfo, int i, String str) {
        mHT = new a();
        mHT.mHS = advertAppInfo;
        mHT.mPage = str;
        mHT.mPageNum = i;
    }

    public static void a(NewWebVideoActivityConfig newWebVideoActivityConfig) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
    }
}
