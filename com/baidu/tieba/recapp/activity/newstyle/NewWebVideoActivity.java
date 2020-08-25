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
/* loaded from: classes20.dex */
public class NewWebVideoActivity extends NewAdTbWebViewActivity {
    public static a lCE;
    private AdCard.f lCA;
    private WebViewContainer.OnScrollChangedCallback lCB = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.newstyle.NewWebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            NewWebVideoActivity.this.lCw -= i2;
            if (NewWebVideoActivity.this.lCw <= 0) {
                NewWebVideoActivity.this.lCs.stopPlay(NewWebVideoActivity.this.lCs.getPlayStatus() != 2);
            } else if (NewWebVideoActivity.this.lCw < NewWebVideoActivity.this.lCx) {
                NewWebVideoActivity.this.lCs.pausePlay(1);
            } else if (NewWebVideoActivity.this.lCs.getPlayStatus() == 2) {
                NewWebVideoActivity.this.lCs.autoContinue();
            } else if (NewWebVideoActivity.this.lCs.getPlayStatus() == -1) {
                NewWebVideoActivity.this.lCs.autoPlay(0);
            }
        }
    };
    private DistributeVideoView lCs;
    private WebViewContainer lCt;
    private float lCu;
    private int lCv;
    private int lCw;
    private int lCx;
    private int lCy;
    private AdCard.a lCz;
    private String mThumbUrl;
    private int mVideoHeight;
    private String mVideoUrl;

    /* loaded from: classes20.dex */
    public static class a {
        public AdvertAppInfo lCD;
        public String mPage;
        public int mPageNum;
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.mVideoUrl = intent.getStringExtra("video_url");
            this.mThumbUrl = intent.getStringExtra("video_thumb_url");
            this.lCu = intent.getFloatExtra("video_ratio", 1.0f);
            this.lCv = intent.getIntExtra("video_duration", 0);
            this.lCy = intent.getIntExtra("good_style", 7);
            String stringExtra = intent.getStringExtra("charge_style");
            String stringExtra2 = intent.getStringExtra("charge_url");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.lCz = new AdCard.a();
                this.lCz.lDC = stringExtra2;
                this.lCz.lDB = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra("tail_frame");
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.lCA = new AdCard.f();
                this.lCA.Pr(stringExtra3);
            }
        } else if (bundle != null) {
            this.mVideoUrl = bundle.getString("video_url");
            this.mThumbUrl = bundle.getString("video_thumb_url");
            this.lCu = bundle.getFloat("video_ratio", 1.0f);
            this.lCv = bundle.getInt("video_duration", 0);
            this.lCy = bundle.getInt("good_style", 7);
        } else {
            BdLog.e("NewWebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.lCw > this.lCx && this.lCs != null) {
            this.lCs.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.lCw > 0 && this.lCs != null) {
            this.lCs.stopPlay(this.lCs.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.lCs != null) {
            this.lCs.stopPlay(this.lCs.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.new_ad_web_video_view, (ViewGroup) null, false);
        this.lCt = (WebViewContainer) frameLayout.findViewById(R.id.web_scroll);
        this.foy = (TBAdWebView) frameLayout.findViewById(R.id.web_web);
        bAV();
        this.lCs = (DistributeVideoView) frameLayout.findViewById(R.id.web_video);
        if (TextUtils.isEmpty(this.mVideoUrl) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.lCs.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.mVideoUrl;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_duration = Integer.valueOf(this.lCv);
            if (this.lCy == 14) {
                builder.video_height = Integer.valueOf(l.getEquipmentWidth(getActivity()));
                builder.video_width = Integer.valueOf(com.baidu.g.a.e.a.dk(builder.video_height.intValue()));
            } else {
                builder.video_width = Integer.valueOf(l.getEquipmentWidth(getActivity()));
                builder.video_height = builder.video_width;
                if (this.lCu > 0.0f) {
                    builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.lCu));
                }
            }
            VideoInfo build = builder.build(false);
            this.lCw = build.video_height.intValue();
            this.lCt.setTopMargin(this.lCw);
            this.lCt.setTopLimit(this.lCw);
            this.lCt.setOnScrollChangeListener(this.lCB);
            d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.lCt.setStyle(adAdSense.bmy());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.lCx = this.mVideoHeight / 2;
            if (this.lCA != null) {
                this.lCs.setVideoTailFrameData(this.lCA);
            }
            this.lCs.setPageContext(getPageContext());
            this.lCs.setData(build, 2, getPageContext());
            this.lCs.setTailFrameIsMiddlePage(true);
            this.lCs.setChargeInfo(this.lCz);
            this.lCs.initVideoViewLayout(this.lCy == 14);
            if (lCE != null) {
                this.lCs.updateTailFrameView(lCE.lCD);
                this.lCs.setStatisticInfo(lCE.lCD, lCE.mPageNum, lCE.mPage);
            } else {
                this.lCs.updateTailFrameView(null);
            }
            this.lCs.autoPlay(0);
            Ge(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void Ge(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.foy.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.getEquipmentHeight(getActivity()) - l.getStatusBarHeight(getActivity())) - dnl();
            this.foy.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public void onReceivedError(int i) {
        if (i != -2) {
            super.onReceivedError(i);
        }
    }

    private int dnl() {
        return l.getDimens(this, R.dimen.ds98);
    }

    public static void a(AdvertAppInfo advertAppInfo, int i, String str) {
        lCE = new a();
        lCE.lCD = advertAppInfo;
        lCE.mPage = str;
        lCE.mPageNum = i;
    }

    public static void a(NewWebVideoActivityConfig newWebVideoActivityConfig) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
    }
}
