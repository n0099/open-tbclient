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
/* loaded from: classes25.dex */
public class NewWebVideoActivity extends NewAdTbWebViewActivity {
    public static a mtM;
    private String mThumbUrl;
    private int mVideoHeight;
    private String mVideoUrl;
    private DistributeVideoView mtA;
    private WebViewContainer mtB;
    private float mtC;
    private int mtD;
    private int mtE;
    private int mtF;
    private int mtG;
    private AdCard.a mtH;
    private AdCard.f mtI;
    private WebViewContainer.OnScrollChangedCallback mtJ = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.newstyle.NewWebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            NewWebVideoActivity.this.mtE -= i2;
            if (NewWebVideoActivity.this.mtE <= 0) {
                NewWebVideoActivity.this.mtA.stopPlay(NewWebVideoActivity.this.mtA.getPlayStatus() != 2);
            } else if (NewWebVideoActivity.this.mtE < NewWebVideoActivity.this.mtF) {
                NewWebVideoActivity.this.mtA.pausePlay(1);
            } else if (NewWebVideoActivity.this.mtA.getPlayStatus() == 2) {
                NewWebVideoActivity.this.mtA.autoContinue();
            } else if (NewWebVideoActivity.this.mtA.getPlayStatus() == -1) {
                NewWebVideoActivity.this.mtA.autoPlay(0);
            }
        }
    };

    /* loaded from: classes25.dex */
    public static class a {
        public String mPage;
        public int mPageNum;
        public AdvertAppInfo mtL;
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.mVideoUrl = intent.getStringExtra("video_url");
            this.mThumbUrl = intent.getStringExtra("video_thumb_url");
            this.mtC = intent.getFloatExtra("video_ratio", 1.0f);
            this.mtD = intent.getIntExtra("video_duration", 0);
            this.mtG = intent.getIntExtra("good_style", 7);
            String stringExtra = intent.getStringExtra("charge_style");
            String stringExtra2 = intent.getStringExtra("charge_url");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.mtH = new AdCard.a();
                this.mtH.muK = stringExtra2;
                this.mtH.muJ = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra("tail_frame");
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.mtI = new AdCard.f();
                this.mtI.QR(stringExtra3);
            }
        } else if (bundle != null) {
            this.mVideoUrl = bundle.getString("video_url");
            this.mThumbUrl = bundle.getString("video_thumb_url");
            this.mtC = bundle.getFloat("video_ratio", 1.0f);
            this.mtD = bundle.getInt("video_duration", 0);
            this.mtG = bundle.getInt("good_style", 7);
        } else {
            BdLog.e("NewWebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.mtE > this.mtF && this.mtA != null) {
            this.mtA.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.mtE > 0 && this.mtA != null) {
            this.mtA.stopPlay(this.mtA.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.mtA != null) {
            this.mtA.stopPlay(this.mtA.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.new_ad_web_video_view, (ViewGroup) null, false);
        this.mtB = (WebViewContainer) frameLayout.findViewById(R.id.web_scroll);
        this.fRM = (TBAdWebView) frameLayout.findViewById(R.id.web_web);
        bIG();
        this.mtA = (DistributeVideoView) frameLayout.findViewById(R.id.web_video);
        if (TextUtils.isEmpty(this.mVideoUrl) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.mtA.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.mVideoUrl;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_duration = Integer.valueOf(this.mtD);
            if (this.mtG == 14) {
                builder.video_height = Integer.valueOf(l.getEquipmentWidth(getActivity()));
                builder.video_width = Integer.valueOf(com.baidu.tieba.recapp.lego.a.a.Iu(builder.video_height.intValue()));
            } else {
                builder.video_width = Integer.valueOf(l.getEquipmentWidth(getActivity()));
                builder.video_height = builder.video_width;
                if (this.mtC > 0.0f) {
                    builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.mtC));
                }
            }
            VideoInfo build = builder.build(false);
            this.mtE = build.video_height.intValue();
            this.mtB.setTopMargin(this.mtE);
            this.mtB.setTopLimit(this.mtE);
            this.mtB.setOnScrollChangeListener(this.mtJ);
            d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.mtB.setStyle(adAdSense.btL());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.mtF = this.mVideoHeight / 2;
            if (this.mtI != null) {
                this.mtA.setVideoTailFrameData(this.mtI);
            }
            this.mtA.setPageContext(getPageContext());
            this.mtA.setData(build, 2, getPageContext());
            this.mtA.setTailFrameIsMiddlePage(true);
            this.mtA.setChargeInfo(this.mtH);
            this.mtA.initVideoViewLayout(this.mtG == 14);
            if (mtM != null) {
                this.mtA.updateTailFrameView(mtM.mtL);
                this.mtA.setStatisticInfo(mtM.mtL, mtM.mPageNum, mtM.mPage);
            } else {
                this.mtA.updateTailFrameView(null);
            }
            this.mtA.autoPlay(0);
            Ip(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void Ip(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fRM.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.getEquipmentHeight(getActivity()) - l.getStatusBarHeight(getActivity())) - dzS();
            this.fRM.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public void onReceivedError(int i) {
        if (i != -2) {
            super.onReceivedError(i);
        }
    }

    private int dzS() {
        return l.getDimens(this, R.dimen.ds98);
    }

    public static void a(AdvertAppInfo advertAppInfo, int i, String str) {
        mtM = new a();
        mtM.mtL = advertAppInfo;
        mtM.mPage = str;
        mtM.mPageNum = i;
    }

    public static void a(NewWebVideoActivityConfig newWebVideoActivityConfig) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
    }
}
