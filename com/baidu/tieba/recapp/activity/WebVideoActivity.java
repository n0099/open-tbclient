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
    public static a mtj;
    private String mThumbUrl;
    private int mVideoHeight;
    private String mVideoUrl;
    private DistributeVideoView mtk;
    private WebViewContainer mtl;
    private float mtm;
    private int mtn;
    private int mto;
    private int mtp;
    private int mtq;
    private AdCard.a mtr;
    private AdCard.f mts;
    private WebViewContainer.OnScrollChangedCallback mtt = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.WebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            WebVideoActivity.this.mto -= i2;
            if (WebVideoActivity.this.mto <= 0) {
                WebVideoActivity.this.mtk.stopPlay(WebVideoActivity.this.mtk.getPlayStatus() != 2);
            } else if (WebVideoActivity.this.mto < WebVideoActivity.this.mtp) {
                WebVideoActivity.this.mtk.pausePlay(1);
            } else if (WebVideoActivity.this.mtk.getPlayStatus() == 2) {
                WebVideoActivity.this.mtk.autoContinue();
            } else if (WebVideoActivity.this.mtk.getPlayStatus() == -1) {
                WebVideoActivity.this.mtk.autoPlay(0);
            }
        }
    };

    /* loaded from: classes26.dex */
    public static class a {
        public String mPage;
        public int mPageNum;
        public AdvertAppInfo mtv;
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.mVideoUrl = intent.getStringExtra("video_url");
            this.mThumbUrl = intent.getStringExtra("video_thumb_url");
            this.mtm = intent.getFloatExtra("video_ratio", 1.0f);
            this.mtn = intent.getIntExtra("video_duration", 0);
            this.mtq = intent.getIntExtra("good_style", 7);
            String stringExtra = intent.getStringExtra("charge_style");
            String stringExtra2 = intent.getStringExtra("charge_url");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.mtr = new AdCard.a();
                this.mtr.muu = stringExtra2;
                this.mtr.mut = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra("tail_frame");
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.mts = new AdCard.f();
                this.mts.Rw(stringExtra3);
            }
        } else if (bundle != null) {
            this.mVideoUrl = bundle.getString("video_url");
            this.mThumbUrl = bundle.getString("video_thumb_url");
            this.mtm = bundle.getFloat("video_ratio", 1.0f);
            this.mtn = bundle.getInt("video_duration", 0);
            this.mtq = bundle.getInt("good_style", 7);
        } else {
            BdLog.e("WebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.mto > this.mtp && this.mtk != null) {
            this.mtk.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.mto > 0 && this.mtk != null) {
            this.mtk.stopPlay(this.mtk.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.mtk != null) {
            this.mtk.stopPlay(this.mtk.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.AdTbWebViewActivity, com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.ad_web_video_view, (ViewGroup) null, false);
        this.mtl = (WebViewContainer) frameLayout.findViewById(R.id.web_scroll);
        this.fRO = (AdBaseWebView) frameLayout.findViewById(R.id.web_web);
        bJm();
        this.mtk = (DistributeVideoView) frameLayout.findViewById(R.id.web_video);
        if (TextUtils.isEmpty(this.mVideoUrl) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.mtk.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.mVideoUrl;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_duration = Integer.valueOf(this.mtn);
            if (this.mtq == 14) {
                builder.video_height = Integer.valueOf(l.getEquipmentWidth(getActivity()));
                builder.video_width = Integer.valueOf(com.baidu.g.a.e.a.m21do(builder.video_height.intValue()));
            } else {
                builder.video_width = Integer.valueOf(l.getEquipmentWidth(getActivity()));
                builder.video_height = builder.video_width;
                if (this.mtm > 0.0f) {
                    builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.mtm));
                }
            }
            VideoInfo build = builder.build(false);
            this.mto = build.video_height.intValue();
            this.mtl.setTopMargin(this.mto);
            this.mtl.setTopLimit(this.mto);
            this.mtl.setOnScrollChangeListener(this.mtt);
            d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.mtl.setStyle(adAdSense.buv());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.mtp = this.mVideoHeight / 2;
            if (this.mts != null) {
                this.mtk.setVideoTailFrameData(this.mts);
            }
            this.mtk.setPageContext(getPageContext());
            this.mtk.setData(build, 2, getPageContext());
            if (mtj != null) {
                this.mtk.updateTailFrameView(mtj.mtv);
                this.mtk.setStatisticInfo(mtj.mtv, mtj.mPageNum, mtj.mPage);
            } else {
                this.mtk.updateTailFrameView(null);
            }
            this.mtk.setChargeInfo(this.mtr);
            this.mtk.autoPlay(0);
            this.mtk.initVideoViewLayout(this.mtq == 14);
            HR(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void HR(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fRO.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.getEquipmentHeight(getActivity()) - l.getStatusBarHeight(getActivity())) - dAs();
            this.fRO.setLayoutParams(layoutParams);
        }
    }

    private int dAs() {
        return l.getDimens(this, R.dimen.ds98);
    }
}
