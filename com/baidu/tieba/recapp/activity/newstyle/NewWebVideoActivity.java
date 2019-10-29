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
/* loaded from: classes3.dex */
public class NewWebVideoActivity extends NewAdTbWebViewActivity {
    public static a iIp;
    private String cmf;
    private DistributeVideoView iIf;
    private WebViewContainer iIg;
    private float iIh;
    private int iIi;
    private int iIj;
    private AdCard.a iIk;
    private AdCard.f iIl;
    private WebViewContainer.OnScrollChangedCallback iIm = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.newstyle.NewWebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            NewWebVideoActivity.this.iIi -= i2;
            if (NewWebVideoActivity.this.iIi <= 0) {
                NewWebVideoActivity.this.iIf.stopPlay(NewWebVideoActivity.this.iIf.getPlayStatus() != 2);
            } else if (NewWebVideoActivity.this.iIi < NewWebVideoActivity.this.iIj) {
                NewWebVideoActivity.this.iIf.pausePlay(1);
            } else if (NewWebVideoActivity.this.iIf.getPlayStatus() == 2) {
                NewWebVideoActivity.this.iIf.autoContinue();
            } else if (NewWebVideoActivity.this.iIf.getPlayStatus() == -1) {
                NewWebVideoActivity.this.iIf.autoPlay(0);
            }
        }
    };
    private int ixK;
    private String mThumbUrl;
    private int mVideoHeight;

    /* loaded from: classes3.dex */
    public static class a {
        public String aTe;
        public AdvertAppInfo iIo;
        public int mPageNum;
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.cmf = intent.getStringExtra("video_url");
            this.mThumbUrl = intent.getStringExtra("video_thumb_url");
            this.iIh = intent.getFloatExtra("video_ratio", 1.0f);
            this.ixK = intent.getIntExtra("video_duration", 0);
            String stringExtra = intent.getStringExtra("charge_style");
            String stringExtra2 = intent.getStringExtra("charge_url");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.iIk = new AdCard.a();
                this.iIk.iJn = stringExtra2;
                this.iIk.iJm = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra("tail_frame");
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.iIl = new AdCard.f();
                this.iIl.CE(stringExtra3);
            }
        } else if (bundle != null) {
            this.cmf = bundle.getString("video_url");
            this.mThumbUrl = bundle.getString("video_thumb_url");
            this.iIh = bundle.getFloat("video_ratio", 1.0f);
            this.ixK = bundle.getInt("video_duration", 0);
        } else {
            BdLog.e("NewWebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.iIi > this.iIj && this.iIf != null) {
            this.iIf.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.iIi > 0 && this.iIf != null) {
            this.iIf.stopPlay(this.iIf.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.iIf != null) {
            this.iIf.stopPlay(this.iIf.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.new_ad_web_video_view, (ViewGroup) null, false);
        this.iIg = (WebViewContainer) frameLayout.findViewById(R.id.web_scroll);
        this.dhQ = (TBAdWebView) frameLayout.findViewById(R.id.web_web);
        aDA();
        this.iIf = (DistributeVideoView) frameLayout.findViewById(R.id.web_video);
        if (TextUtils.isEmpty(this.cmf) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.iIf.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.cmf;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_width = Integer.valueOf(l.getEquipmentWidth(getActivity()));
            builder.video_height = builder.video_width;
            builder.video_duration = Integer.valueOf(this.ixK);
            if (this.iIh > 0.0f) {
                builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.iIh));
            }
            VideoInfo build = builder.build(false);
            this.iIi = build.video_height.intValue();
            this.iIg.setTopMargin(this.iIi);
            this.iIg.setTopLimit(this.iIi);
            this.iIg.setOnScrollChangeListener(this.iIm);
            d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.iIg.setStyle(adAdSense.apa());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.iIj = this.mVideoHeight / 2;
            if (this.iIl != null) {
                this.iIf.setVideoTailFrameData(this.iIl);
            }
            this.iIf.setPageContext(getPageContext());
            this.iIf.setData(build, 2, getPageContext());
            if (iIp != null) {
                this.iIf.setStatisticInfo(iIp.iIo, iIp.mPageNum, iIp.aTe);
            }
            this.iIf.setTailFrameIsMiddlePage(true);
            this.iIf.updateTailFrameView(null);
            this.iIf.setChargeInfo(this.iIk);
            this.iIf.autoPlay(0);
            yi(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void yi(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dhQ.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.getEquipmentHeight(getActivity()) - l.getStatusBarHeight(getActivity())) - cfQ();
            this.dhQ.setLayoutParams(layoutParams);
        }
    }

    private int cfQ() {
        return l.getDimens(this, R.dimen.ds98);
    }
}
