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
    public static a jGq;
    private DistributeVideoView jGg;
    private WebViewContainer jGh;
    private float jGi;
    private int jGj;
    private int jGk;
    private AdCard.a jGl;
    private AdCard.f jGm;
    private WebViewContainer.OnScrollChangedCallback jGn = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.newstyle.NewWebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            NewWebVideoActivity.this.jGj -= i2;
            if (NewWebVideoActivity.this.jGj <= 0) {
                NewWebVideoActivity.this.jGg.stopPlay(NewWebVideoActivity.this.jGg.getPlayStatus() != 2);
            } else if (NewWebVideoActivity.this.jGj < NewWebVideoActivity.this.jGk) {
                NewWebVideoActivity.this.jGg.pausePlay(1);
            } else if (NewWebVideoActivity.this.jGg.getPlayStatus() == 2) {
                NewWebVideoActivity.this.jGg.autoContinue();
            } else if (NewWebVideoActivity.this.jGg.getPlayStatus() == -1) {
                NewWebVideoActivity.this.jGg.autoPlay(0);
            }
        }
    };
    private int jvq;
    private String mThumbUrl;
    private int mVideoHeight;
    private String mVideoUrl;

    /* loaded from: classes13.dex */
    public static class a {
        public AdvertAppInfo jGp;
        public String mPage;
        public int mPageNum;
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.mVideoUrl = intent.getStringExtra("video_url");
            this.mThumbUrl = intent.getStringExtra("video_thumb_url");
            this.jGi = intent.getFloatExtra("video_ratio", 1.0f);
            this.jvq = intent.getIntExtra("video_duration", 0);
            String stringExtra = intent.getStringExtra("charge_style");
            String stringExtra2 = intent.getStringExtra("charge_url");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.jGl = new AdCard.a();
                this.jGl.jHn = stringExtra2;
                this.jGl.jHm = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra("tail_frame");
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.jGm = new AdCard.f();
                this.jGm.HP(stringExtra3);
            }
        } else if (bundle != null) {
            this.mVideoUrl = bundle.getString("video_url");
            this.mThumbUrl = bundle.getString("video_thumb_url");
            this.jGi = bundle.getFloat("video_ratio", 1.0f);
            this.jvq = bundle.getInt("video_duration", 0);
        } else {
            BdLog.e("NewWebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.jGj > this.jGk && this.jGg != null) {
            this.jGg.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.jGj > 0 && this.jGg != null) {
            this.jGg.stopPlay(this.jGg.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.jGg != null) {
            this.jGg.stopPlay(this.jGg.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.new_ad_web_video_view, (ViewGroup) null, false);
        this.jGh = (WebViewContainer) frameLayout.findViewById(R.id.web_scroll);
        this.dZc = (TBAdWebView) frameLayout.findViewById(R.id.web_web);
        aYb();
        this.jGg = (DistributeVideoView) frameLayout.findViewById(R.id.web_video);
        if (TextUtils.isEmpty(this.mVideoUrl) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.jGg.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.mVideoUrl;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_width = Integer.valueOf(l.getEquipmentWidth(getActivity()));
            builder.video_height = builder.video_width;
            builder.video_duration = Integer.valueOf(this.jvq);
            if (this.jGi > 0.0f) {
                builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.jGi));
            }
            VideoInfo build = builder.build(false);
            this.jGj = build.video_height.intValue();
            this.jGh.setTopMargin(this.jGj);
            this.jGh.setTopLimit(this.jGj);
            this.jGh.setOnScrollChangeListener(this.jGn);
            d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.jGh.setStyle(adAdSense.aJj());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.jGk = this.mVideoHeight / 2;
            if (this.jGm != null) {
                this.jGg.setVideoTailFrameData(this.jGm);
            }
            this.jGg.setPageContext(getPageContext());
            this.jGg.setData(build, 2, getPageContext());
            if (jGq != null) {
                this.jGg.setStatisticInfo(jGq.jGp, jGq.mPageNum, jGq.mPage);
            }
            this.jGg.setTailFrameIsMiddlePage(true);
            this.jGg.updateTailFrameView(null);
            this.jGg.setChargeInfo(this.jGl);
            this.jGg.autoPlay(0);
            AR(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void AR(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dZc.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.getEquipmentHeight(getActivity()) - l.getStatusBarHeight(getActivity())) - cCz();
            this.dZc.setLayoutParams(layoutParams);
        }
    }

    private int cCz() {
        return l.getDimens(this, R.dimen.ds98);
    }
}
