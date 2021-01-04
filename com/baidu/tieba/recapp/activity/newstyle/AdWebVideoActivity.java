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
import com.baidu.tieba.R;
import com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity;
import com.baidu.tieba.ad.browser.newstyle.TBAdWebView;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.DistributeVideoView;
import com.baidu.tieba.recapp.view.WebViewContainer;
import tbclient.VideoInfo;
/* loaded from: classes8.dex */
public class AdWebVideoActivity extends AdWebViewActivity {
    public static a mMY;
    private DistributeVideoView mMZ;
    private WebViewContainer mNa;
    private float mNb;
    private int mNc;
    private int mNd;
    private int mNe;
    private int mNf;
    private AdCard.f mNg;
    private WebViewContainer.OnScrollChangedCallback mNh = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.newstyle.AdWebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            AdWebVideoActivity.this.mNd -= i2;
            if (AdWebVideoActivity.this.mNd <= 0) {
                AdWebVideoActivity.this.mMZ.stopPlay(AdWebVideoActivity.this.mMZ.getPlayStatus() != 2);
            } else if (AdWebVideoActivity.this.mNd < AdWebVideoActivity.this.mNe) {
                AdWebVideoActivity.this.mMZ.pausePlay(1);
            } else if (AdWebVideoActivity.this.mMZ.getPlayStatus() == 2) {
                AdWebVideoActivity.this.mMZ.autoContinue();
            } else if (AdWebVideoActivity.this.mMZ.getPlayStatus() == -1) {
                AdWebVideoActivity.this.mMZ.autoPlay(0);
            }
        }
    };
    private String mThumbUrl;
    private int mVideoHeight;
    private String mVideoUrl;

    /* loaded from: classes8.dex */
    public static class a {
        public AdvertAppInfo mNj;
        public String mPage;
        public int mPageNum;
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.mVideoUrl = intent.getStringExtra("video_url");
            this.mThumbUrl = intent.getStringExtra(AdWebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.mNb = intent.getFloatExtra(AdWebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.mNc = intent.getIntExtra(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
            this.mNf = intent.getIntExtra(AdWebVideoActivityConfig.KEY_GOOD_STYLE, 7);
            String stringExtra = intent.getStringExtra(AdWebVideoActivityConfig.KEY_TAIL_FRAME);
            if (!TextUtils.isEmpty(stringExtra)) {
                this.mNg = new AdCard.f();
                this.mNg.RG(stringExtra);
            }
        } else if (bundle != null) {
            this.mVideoUrl = bundle.getString("video_url");
            this.mThumbUrl = bundle.getString(AdWebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
            this.mNb = bundle.getFloat(AdWebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
            this.mNc = bundle.getInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
            this.mNf = bundle.getInt(AdWebVideoActivityConfig.KEY_GOOD_STYLE, 7);
        } else {
            BdLog.e("NewWebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.mNd > this.mNe && this.mMZ != null) {
            this.mMZ.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.mNd > 0 && this.mMZ != null) {
            this.mMZ.stopPlay(this.mMZ.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.mMZ != null) {
            this.mMZ.stopPlay(this.mMZ.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.new_ad_web_video_view, (ViewGroup) null, false);
        this.mNa = (WebViewContainer) frameLayout.findViewById(R.id.web_scroll);
        this.gjp = (TBAdWebView) frameLayout.findViewById(R.id.web_web);
        bOL();
        this.mMZ = (DistributeVideoView) frameLayout.findViewById(R.id.web_video);
        if (TextUtils.isEmpty(this.mVideoUrl) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.mMZ.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.mVideoUrl;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_duration = Integer.valueOf(this.mNc);
            if (this.mNf == 14) {
                builder.video_height = Integer.valueOf(l.getEquipmentWidth(getActivity()));
                builder.video_width = Integer.valueOf(com.baidu.tieba.recapp.lego.a.a.Jf(builder.video_height.intValue()));
            } else {
                builder.video_width = Integer.valueOf(l.getEquipmentWidth(getActivity()));
                builder.video_height = builder.video_width;
                if (this.mNb > 0.0f) {
                    builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.mNb));
                }
            }
            VideoInfo build = builder.build(false);
            this.mNd = build.video_height.intValue();
            this.mNa.setTopMargin(this.mNd);
            this.mNa.setTopLimit(this.mNd);
            this.mNa.setOnScrollChangeListener(this.mNh);
            this.mNa.setStyle(TbadkCoreApplication.getInst().getAdVideoPageStyle());
            this.mVideoHeight = build.video_height.intValue();
            this.mNe = this.mVideoHeight / 2;
            if (this.mNg != null) {
                this.mMZ.setVideoTailFrameData(this.mNg);
            }
            this.mMZ.setPageContext(getPageContext());
            this.mMZ.setData(build, 2, getPageContext());
            this.mMZ.setTailFrameIsMiddlePage(true);
            this.mMZ.initVideoViewLayout(this.mNf == 14);
            if (mMY != null) {
                this.mMZ.updateTailFrameView(mMY.mNj);
                this.mMZ.setStatisticInfo(mMY.mNj, mMY.mPageNum, mMY.mPage);
            } else {
                this.mMZ.updateTailFrameView(null);
            }
            this.mMZ.autoPlay(0);
            Ja(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void Ja(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gjp.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.getEquipmentHeight(getActivity()) - l.getStatusBarHeight(getActivity())) - dEZ();
            this.gjp.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public void onReceivedError(int i) {
        if (i != -2) {
            super.onReceivedError(i);
        }
    }

    private int dEZ() {
        return l.getDimens(this, R.dimen.ds98);
    }

    public static void a(AdvertAppInfo advertAppInfo, int i, String str) {
        mMY = new a();
        mMY.mNj = advertAppInfo;
        mMY.mPage = str;
        mMY.mPageNum = i;
    }

    public static void a(AdWebVideoActivityConfig adWebVideoActivityConfig) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, adWebVideoActivityConfig));
    }
}
