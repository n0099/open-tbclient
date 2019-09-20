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
    public static a iJn;
    private String bXa;
    private DistributeVideoView iJo;
    private WebViewContainer iJp;
    private float iJq;
    private int iJr;
    private int iJs;
    private AdCard.a iJt;
    private AdCard.f iJu;
    private WebViewContainer.OnScrollChangedCallback iJv = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.WebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            WebVideoActivity.this.iJr -= i2;
            if (WebVideoActivity.this.iJr <= 0) {
                WebVideoActivity.this.iJo.stopPlay(WebVideoActivity.this.iJo.getPlayStatus() != 2);
            } else if (WebVideoActivity.this.iJr < WebVideoActivity.this.iJs) {
                WebVideoActivity.this.iJo.pausePlay(1);
            } else if (WebVideoActivity.this.iJo.getPlayStatus() == 2) {
                WebVideoActivity.this.iJo.autoContinue();
            } else if (WebVideoActivity.this.iJo.getPlayStatus() == -1) {
                WebVideoActivity.this.iJo.autoPlay(0);
            }
        }
    };
    private int izi;
    private String mThumbUrl;
    private int mVideoHeight;

    /* loaded from: classes3.dex */
    public static class a {
        public String azQ;
        public AdvertAppInfo iJx;
        public int mPageNum;
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.bXa = intent.getStringExtra("video_url");
            this.mThumbUrl = intent.getStringExtra("video_thumb_url");
            this.iJq = intent.getFloatExtra("video_ratio", 1.0f);
            this.izi = intent.getIntExtra("video_duration", 0);
            String stringExtra = intent.getStringExtra("charge_style");
            String stringExtra2 = intent.getStringExtra("charge_url");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.iJt = new AdCard.a();
                this.iJt.iKw = stringExtra2;
                this.iJt.iKv = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra("tail_frame");
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.iJu = new AdCard.f();
                this.iJu.Ej(stringExtra3);
            }
        } else if (bundle != null) {
            this.bXa = bundle.getString("video_url");
            this.mThumbUrl = bundle.getString("video_thumb_url");
            this.iJq = bundle.getFloat("video_ratio", 1.0f);
            this.izi = bundle.getInt("video_duration", 0);
        } else {
            BdLog.e("WebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.iJr > this.iJs && this.iJo != null) {
            this.iJo.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.iJr > 0 && this.iJo != null) {
            this.iJo.stopPlay(this.iJo.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.iJo != null) {
            this.iJo.stopPlay(this.iJo.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.ad_web_video_view, (ViewGroup) null, false);
        this.iJp = (WebViewContainer) frameLayout.findViewById(R.id.web_scroll);
        this.cYg = (AdBaseWebView) frameLayout.findViewById(R.id.web_web);
        aDr();
        this.iJo = (DistributeVideoView) frameLayout.findViewById(R.id.web_video);
        if (TextUtils.isEmpty(this.bXa) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.iJo.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.bXa;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_width = Integer.valueOf(l.af(getActivity()));
            builder.video_height = builder.video_width;
            builder.video_duration = Integer.valueOf(this.izi);
            if (this.iJq > 0.0f) {
                builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.iJq));
            }
            VideoInfo build = builder.build(false);
            this.iJr = build.video_height.intValue();
            this.iJp.setTopMargin(this.iJr);
            this.iJp.setTopLimit(this.iJr);
            this.iJp.setOnScrollChangeListener(this.iJv);
            d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.iJp.setStyle(adAdSense.amv());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.iJs = this.mVideoHeight / 2;
            if (this.iJu != null) {
                this.iJo.setVideoTailFrameData(this.iJu);
            }
            this.iJo.setPageContext(getPageContext());
            this.iJo.setData(build, 2, getPageContext());
            this.iJo.updateTailFrameView(null);
            if (iJn != null) {
                this.iJo.setStatisticInfo(iJn.iJx, iJn.mPageNum, iJn.azQ);
            }
            this.iJo.setChargeInfo(this.iJt);
            this.iJo.autoPlay(0);
            zC(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void zC(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cYg.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.ah(getActivity()) - l.u(getActivity())) - ciO();
            this.cYg.setLayoutParams(layoutParams);
        }
    }

    private int ciO() {
        return l.g(this, R.dimen.ds98);
    }
}
