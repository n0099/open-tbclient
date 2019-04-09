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
import com.baidu.tieba.ad.browser.AdBaseWebView;
import com.baidu.tieba.ad.browser.AdTbWebViewActivity;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.DistributeVideoView;
import com.baidu.tieba.recapp.view.WebViewContainer;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class WebVideoActivity extends AdTbWebViewActivity {
    public static a igL;
    private String bNo;
    private int hXa;
    private DistributeVideoView igM;
    private WebViewContainer igN;
    private float igO;
    private int igP;
    private int igQ;
    private AdCard.a igR;
    private AdCard.f igS;
    private WebViewContainer.OnScrollChangedCallback igT = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.WebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            WebVideoActivity.this.igP -= i2;
            if (WebVideoActivity.this.igP <= 0) {
                WebVideoActivity.this.igM.stopPlay(WebVideoActivity.this.igM.getPlayStatus() != 2);
            } else if (WebVideoActivity.this.igP < WebVideoActivity.this.igQ) {
                WebVideoActivity.this.igM.pausePlay(1);
            } else if (WebVideoActivity.this.igM.getPlayStatus() == 2) {
                WebVideoActivity.this.igM.autoContinue();
            } else if (WebVideoActivity.this.igM.getPlayStatus() == -1) {
                WebVideoActivity.this.igM.autoPlay(0);
            }
        }
    };
    private String mThumbUrl;
    private int mVideoHeight;

    /* loaded from: classes3.dex */
    public static class a {
        public String axM;
        public AdvertAppInfo igV;
        public int mPageNum;
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.bNo = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.igO = intent.getFloatExtra(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.hXa = intent.getIntExtra(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
            String stringExtra = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_STYLE);
            String stringExtra2 = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_URL);
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.igR = new AdCard.a();
                this.igR.ihP = stringExtra2;
                this.igR.ihO = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra(WebVideoActivityConfig.KEY_TAIL_FRAME);
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.igS = new AdCard.f();
                this.igS.Bx(stringExtra3);
            }
        } else if (bundle != null) {
            this.bNo = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.igO = bundle.getFloat(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.hXa = bundle.getInt(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
        } else {
            BdLog.e("WebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.igP > this.igQ && this.igM != null) {
            this.igM.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.igP > 0 && this.igM != null) {
            this.igM.stopPlay(this.igM.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.igM != null) {
            this.igM.stopPlay(this.igM.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(d.h.ad_web_video_view, (ViewGroup) null, false);
        this.igN = (WebViewContainer) frameLayout.findViewById(d.g.web_scroll);
        this.cNx = (AdBaseWebView) frameLayout.findViewById(d.g.web_web);
        awD();
        this.igM = (DistributeVideoView) frameLayout.findViewById(d.g.web_video);
        if (TextUtils.isEmpty(this.bNo) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.igM.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.bNo;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_width = Integer.valueOf(l.aO(getActivity()));
            builder.video_height = builder.video_width;
            builder.video_duration = Integer.valueOf(this.hXa);
            if (this.igO > 0.0f) {
                builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.igO));
            }
            VideoInfo build = builder.build(false);
            this.igP = build.video_height.intValue();
            this.igN.setTopMargin(this.igP);
            this.igN.setTopLimit(this.igP);
            this.igN.setOnScrollChangeListener(this.igT);
            com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.igN.setStyle(adAdSense.agd());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.igQ = this.mVideoHeight / 2;
            if (this.igS != null) {
                this.igM.setVideoTailFrameData(this.igS);
            }
            this.igM.setPageContext(getPageContext());
            this.igM.setData(build, 2, getPageContext());
            this.igM.updateTailFrameView(null);
            if (igL != null) {
                this.igM.setStatisticInfo(igL.igV, igL.mPageNum, igL.axM);
            }
            this.igM.setChargeInfo(this.igR);
            this.igM.autoPlay(0);
            xL(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void xL(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cNx.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.aQ(getActivity()) - l.r(getActivity())) - bWK();
            this.cNx.setLayoutParams(layoutParams);
        }
    }

    private int bWK() {
        return l.h(this, d.e.ds98);
    }
}
