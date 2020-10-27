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
    public static a mnl;
    private String mThumbUrl;
    private int mVideoHeight;
    private String mVideoUrl;
    private DistributeVideoView mnm;
    private WebViewContainer mnn;
    private float mno;
    private int mnp;
    private int mnq;
    private int mnr;
    private int mns;
    private AdCard.a mnt;
    private AdCard.f mnu;
    private WebViewContainer.OnScrollChangedCallback mnv = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.WebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            WebVideoActivity.this.mnq -= i2;
            if (WebVideoActivity.this.mnq <= 0) {
                WebVideoActivity.this.mnm.stopPlay(WebVideoActivity.this.mnm.getPlayStatus() != 2);
            } else if (WebVideoActivity.this.mnq < WebVideoActivity.this.mnr) {
                WebVideoActivity.this.mnm.pausePlay(1);
            } else if (WebVideoActivity.this.mnm.getPlayStatus() == 2) {
                WebVideoActivity.this.mnm.autoContinue();
            } else if (WebVideoActivity.this.mnm.getPlayStatus() == -1) {
                WebVideoActivity.this.mnm.autoPlay(0);
            }
        }
    };

    /* loaded from: classes26.dex */
    public static class a {
        public String mPage;
        public int mPageNum;
        public AdvertAppInfo mnx;
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.mVideoUrl = intent.getStringExtra("video_url");
            this.mThumbUrl = intent.getStringExtra("video_thumb_url");
            this.mno = intent.getFloatExtra("video_ratio", 1.0f);
            this.mnp = intent.getIntExtra("video_duration", 0);
            this.mns = intent.getIntExtra("good_style", 7);
            String stringExtra = intent.getStringExtra("charge_style");
            String stringExtra2 = intent.getStringExtra("charge_url");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.mnt = new AdCard.a();
                this.mnt.mox = stringExtra2;
                this.mnt.mow = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra("tail_frame");
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.mnu = new AdCard.f();
                this.mnu.Rf(stringExtra3);
            }
        } else if (bundle != null) {
            this.mVideoUrl = bundle.getString("video_url");
            this.mThumbUrl = bundle.getString("video_thumb_url");
            this.mno = bundle.getFloat("video_ratio", 1.0f);
            this.mnp = bundle.getInt("video_duration", 0);
            this.mns = bundle.getInt("good_style", 7);
        } else {
            BdLog.e("WebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.mnq > this.mnr && this.mnm != null) {
            this.mnm.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.mnq > 0 && this.mnm != null) {
            this.mnm.stopPlay(this.mnm.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.mnm != null) {
            this.mnm.stopPlay(this.mnm.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.ad_web_video_view, (ViewGroup) null, false);
        this.mnn = (WebViewContainer) frameLayout.findViewById(R.id.web_scroll);
        this.fLY = (AdBaseWebView) frameLayout.findViewById(R.id.web_web);
        bGN();
        this.mnm = (DistributeVideoView) frameLayout.findViewById(R.id.web_video);
        if (TextUtils.isEmpty(this.mVideoUrl) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.mnm.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.mVideoUrl;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_duration = Integer.valueOf(this.mnp);
            if (this.mns == 14) {
                builder.video_height = Integer.valueOf(l.getEquipmentWidth(getActivity()));
                builder.video_width = Integer.valueOf(com.baidu.g.a.e.a.m21do(builder.video_height.intValue()));
            } else {
                builder.video_width = Integer.valueOf(l.getEquipmentWidth(getActivity()));
                builder.video_height = builder.video_width;
                if (this.mno > 0.0f) {
                    builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.mno));
                }
            }
            VideoInfo build = builder.build(false);
            this.mnq = build.video_height.intValue();
            this.mnn.setTopMargin(this.mnq);
            this.mnn.setTopLimit(this.mnq);
            this.mnn.setOnScrollChangeListener(this.mnv);
            d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.mnn.setStyle(adAdSense.brV());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.mnr = this.mVideoHeight / 2;
            if (this.mnu != null) {
                this.mnm.setVideoTailFrameData(this.mnu);
            }
            this.mnm.setPageContext(getPageContext());
            this.mnm.setData(build, 2, getPageContext());
            if (mnl != null) {
                this.mnm.updateTailFrameView(mnl.mnx);
                this.mnm.setStatisticInfo(mnl.mnx, mnl.mPageNum, mnl.mPage);
            } else {
                this.mnm.updateTailFrameView(null);
            }
            this.mnm.setChargeInfo(this.mnt);
            this.mnm.autoPlay(0);
            this.mnm.initVideoViewLayout(this.mns == 14);
            HE(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void HE(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fLY.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.getEquipmentHeight(getActivity()) - l.getStatusBarHeight(getActivity())) - dxQ();
            this.fLY.setLayoutParams(layoutParams);
        }
    }

    private int dxQ() {
        return l.getDimens(this, R.dimen.ds98);
    }
}
