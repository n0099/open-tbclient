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
/* loaded from: classes3.dex */
public class WebVideoActivity extends AdTbWebViewActivity {
    public static a iFS;
    private String bWb;
    private DistributeVideoView iFT;
    private WebViewContainer iFU;
    private float iFV;
    private int iFW;
    private int iFX;
    private AdCard.a iFY;
    private AdCard.f iFZ;
    private WebViewContainer.OnScrollChangedCallback iGa = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.WebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            WebVideoActivity.this.iFW -= i2;
            if (WebVideoActivity.this.iFW <= 0) {
                WebVideoActivity.this.iFT.stopPlay(WebVideoActivity.this.iFT.getPlayStatus() != 2);
            } else if (WebVideoActivity.this.iFW < WebVideoActivity.this.iFX) {
                WebVideoActivity.this.iFT.pausePlay(1);
            } else if (WebVideoActivity.this.iFT.getPlayStatus() == 2) {
                WebVideoActivity.this.iFT.autoContinue();
            } else if (WebVideoActivity.this.iFT.getPlayStatus() == -1) {
                WebVideoActivity.this.iFT.autoPlay(0);
            }
        }
    };
    private int iwd;
    private String mThumbUrl;
    private int mVideoHeight;

    /* loaded from: classes3.dex */
    public static class a {
        public String azs;
        public AdvertAppInfo iGc;
        public int mPageNum;
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.bWb = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = intent.getStringExtra(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.iFV = intent.getFloatExtra(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.iwd = intent.getIntExtra(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
            String stringExtra = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_STYLE);
            String stringExtra2 = intent.getStringExtra(WebVideoActivityConfig.KEY_CHARGE_URL);
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.iFY = new AdCard.a();
                this.iFY.iGW = stringExtra2;
                this.iFY.iGV = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra(WebVideoActivityConfig.KEY_TAIL_FRAME);
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.iFZ = new AdCard.f();
                this.iFZ.DI(stringExtra3);
            }
        } else if (bundle != null) {
            this.bWb = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_URL);
            this.mThumbUrl = bundle.getString(WebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.iFV = bundle.getFloat(WebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.iwd = bundle.getInt(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
        } else {
            BdLog.e("WebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.iFW > this.iFX && this.iFT != null) {
            this.iFT.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.iFW > 0 && this.iFT != null) {
            this.iFT.stopPlay(this.iFT.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.iFT != null) {
            this.iFT.stopPlay(this.iFT.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.ad_web_video_view, (ViewGroup) null, false);
        this.iFU = (WebViewContainer) frameLayout.findViewById(R.id.web_scroll);
        this.cXg = (AdBaseWebView) frameLayout.findViewById(R.id.web_web);
        aDb();
        this.iFT = (DistributeVideoView) frameLayout.findViewById(R.id.web_video);
        if (TextUtils.isEmpty(this.bWb) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.iFT.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.bWb;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_width = Integer.valueOf(l.af(getActivity()));
            builder.video_height = builder.video_width;
            builder.video_duration = Integer.valueOf(this.iwd);
            if (this.iFV > 0.0f) {
                builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.iFV));
            }
            VideoInfo build = builder.build(false);
            this.iFW = build.video_height.intValue();
            this.iFU.setTopMargin(this.iFW);
            this.iFU.setTopLimit(this.iFW);
            this.iFU.setOnScrollChangeListener(this.iGa);
            d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.iFU.setStyle(adAdSense.amh());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.iFX = this.mVideoHeight / 2;
            if (this.iFZ != null) {
                this.iFT.setVideoTailFrameData(this.iFZ);
            }
            this.iFT.setPageContext(getPageContext());
            this.iFT.setData(build, 2, getPageContext());
            this.iFT.updateTailFrameView(null);
            if (iFS != null) {
                this.iFT.setStatisticInfo(iFS.iGc, iFS.mPageNum, iFS.azs);
            }
            this.iFT.setChargeInfo(this.iFY);
            this.iFT.autoPlay(0);
            zx(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void zx(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cXg.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.ah(getActivity()) - l.u(getActivity())) - chI();
            this.cXg.setLayoutParams(layoutParams);
        }
    }

    private int chI() {
        return l.g(this, R.dimen.ds98);
    }
}
