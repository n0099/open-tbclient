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
import com.baidu.tbadk.coreExtra.data.c;
import com.baidu.tieba.ad.browser.AdBaseWebView;
import com.baidu.tieba.ad.browser.AdTbWebViewActivity;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.DistributeVideoView;
import com.baidu.tieba.recapp.view.WebViewContainer;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class WebVideoActivity extends AdTbWebViewActivity {
    public static a gnf;
    private String bcS;
    private int gfC;
    private DistributeVideoView gng;
    private WebViewContainer gnh;
    private float gni;
    private int gnj;
    private int gnk;
    private AdCard.a gnl;
    private AdCard.f gnm;
    private WebViewContainer.OnScrollChangedCallback gnn = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.WebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            WebVideoActivity.this.gnj -= i2;
            if (WebVideoActivity.this.gnj <= 0) {
                WebVideoActivity.this.gng.stopPlay();
            } else if (WebVideoActivity.this.gnj < WebVideoActivity.this.gnk) {
                WebVideoActivity.this.gng.pausePlay(1);
            } else if (WebVideoActivity.this.gng.getPlayStatus() == 2) {
                WebVideoActivity.this.gng.autoContinue();
            } else if (WebVideoActivity.this.gng.getPlayStatus() == -1) {
                WebVideoActivity.this.gng.autoPlay(0);
            }
        }
    };
    private String mThumbUrl;
    private int mVideoHeight;

    /* loaded from: classes3.dex */
    public static class a {
        public AdvertAppInfo gnp;
        public String gnq;
        public int mPageNum;
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.bcS = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.gni = intent.getFloatExtra(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.gfC = intent.getIntExtra(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
            String stringExtra = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_STYLE);
            String stringExtra2 = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_URL);
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.gnl = new AdCard.a();
                this.gnl.gok = stringExtra2;
                this.gnl.goj = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra(WebVideoActivityConfig.KEY_TAIL_FRAME);
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.gnm = new AdCard.f();
                this.gnm.sN(stringExtra3);
            }
        } else if (bundle != null) {
            this.bcS = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.gni = bundle.getFloat(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.gfC = bundle.getInt(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
        } else {
            BdLog.e("WebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.gnj > this.gnk && this.gng != null) {
            this.gng.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.gnj > 0 && this.gng != null) {
            this.gng.stopPlay();
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.gng != null) {
            this.gng.stopPlay();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(d.i.ad_web_video_view, (ViewGroup) null, false);
        this.gnh = (WebViewContainer) frameLayout.findViewById(d.g.web_scroll);
        this.bmN = (AdBaseWebView) frameLayout.findViewById(d.g.web_web);
        QX();
        this.gng = (DistributeVideoView) frameLayout.findViewById(d.g.web_video);
        if (TextUtils.isEmpty(this.bcS) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.gng.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.bcS;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_width = Integer.valueOf(l.ah(getActivity()));
            builder.video_height = builder.video_width;
            builder.video_duration = Integer.valueOf(this.gfC);
            if (this.gni > 0.0f) {
                builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.gni));
            }
            VideoInfo build = builder.build(false);
            this.gnj = build.video_height.intValue();
            this.gnh.setTopMargin(this.gnj);
            this.gnh.setTopLimit(this.gnj);
            this.gnh.setOnScrollChangeListener(this.gnn);
            c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.gnh.setStyle(adAdSense.Cd());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.gnk = this.mVideoHeight / 2;
            if (this.gnm != null) {
                this.gng.setVideoTailFrameData(this.gnm);
            }
            this.gng.setPageContext(getPageContext());
            this.gng.setData(build, 2, getPageContext());
            this.gng.updateTailFrameView(null);
            if (gnf != null) {
                this.gng.setStatisticInfo(gnf.gnp, gnf.mPageNum, gnf.gnq);
            }
            this.gng.setChargeInfo(this.gnl);
            this.gng.autoPlay(0);
            sg(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void sg(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bmN.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.aj(getActivity()) - l.o(getActivity())) - boO();
            this.bmN.setLayoutParams(layoutParams);
        }
    }

    private int boO() {
        return l.e(this, d.e.ds98);
    }
}
