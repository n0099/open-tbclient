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
    public static a iHy;
    private String cln;
    private DistributeVideoView iHo;
    private WebViewContainer iHp;
    private float iHq;
    private int iHr;
    private int iHs;
    private AdCard.a iHt;
    private AdCard.f iHu;
    private WebViewContainer.OnScrollChangedCallback iHv = new WebViewContainer.OnScrollChangedCallback() { // from class: com.baidu.tieba.recapp.activity.newstyle.NewWebVideoActivity.1
        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            NewWebVideoActivity.this.iHr -= i2;
            if (NewWebVideoActivity.this.iHr <= 0) {
                NewWebVideoActivity.this.iHo.stopPlay(NewWebVideoActivity.this.iHo.getPlayStatus() != 2);
            } else if (NewWebVideoActivity.this.iHr < NewWebVideoActivity.this.iHs) {
                NewWebVideoActivity.this.iHo.pausePlay(1);
            } else if (NewWebVideoActivity.this.iHo.getPlayStatus() == 2) {
                NewWebVideoActivity.this.iHo.autoContinue();
            } else if (NewWebVideoActivity.this.iHo.getPlayStatus() == -1) {
                NewWebVideoActivity.this.iHo.autoPlay(0);
            }
        }
    };
    private int iwT;
    private String mThumbUrl;
    private int mVideoHeight;

    /* loaded from: classes3.dex */
    public static class a {
        public String aSM;
        public AdvertAppInfo iHx;
        public int mPageNum;
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.cln = intent.getStringExtra("video_url");
            this.mThumbUrl = intent.getStringExtra("video_thumb_url");
            this.iHq = intent.getFloatExtra("video_ratio", 1.0f);
            this.iwT = intent.getIntExtra("video_duration", 0);
            String stringExtra = intent.getStringExtra("charge_style");
            String stringExtra2 = intent.getStringExtra("charge_url");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.iHt = new AdCard.a();
                this.iHt.iIw = stringExtra2;
                this.iHt.iIv = stringExtra;
            }
            String stringExtra3 = intent.getStringExtra("tail_frame");
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.iHu = new AdCard.f();
                this.iHu.CE(stringExtra3);
            }
        } else if (bundle != null) {
            this.cln = bundle.getString("video_url");
            this.mThumbUrl = bundle.getString("video_thumb_url");
            this.iHq = bundle.getFloat("video_ratio", 1.0f);
            this.iwT = bundle.getInt("video_duration", 0);
        } else {
            BdLog.e("NewWebVideoActivity: onCreate invalid parameters");
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.iHr > this.iHs && this.iHo != null) {
            this.iHo.autoPlay(0);
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.iHr > 0 && this.iHo != null) {
            this.iHo.stopPlay(this.iHo.getPlayStatus() != 2);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.iHo != null) {
            this.iHo.stopPlay(this.iHo.getPlayStatus() != 2);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public View createWebView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.new_ad_web_video_view, (ViewGroup) null, false);
        this.iHp = (WebViewContainer) frameLayout.findViewById(R.id.web_scroll);
        this.dgZ = (TBAdWebView) frameLayout.findViewById(R.id.web_web);
        aDy();
        this.iHo = (DistributeVideoView) frameLayout.findViewById(R.id.web_video);
        if (TextUtils.isEmpty(this.cln) || TextUtils.isEmpty(this.mThumbUrl)) {
            this.iHo.setVisibility(8);
        } else {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = this.cln;
            builder.thumbnail_url = this.mThumbUrl;
            builder.video_width = Integer.valueOf(l.getEquipmentWidth(getActivity()));
            builder.video_height = builder.video_width;
            builder.video_duration = Integer.valueOf(this.iwT);
            if (this.iHq > 0.0f) {
                builder.video_height = Integer.valueOf((int) (builder.video_width.intValue() / this.iHq));
            }
            VideoInfo build = builder.build(false);
            this.iHr = build.video_height.intValue();
            this.iHp.setTopMargin(this.iHr);
            this.iHp.setTopLimit(this.iHr);
            this.iHp.setOnScrollChangeListener(this.iHv);
            d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                this.iHp.setStyle(adAdSense.aoY());
            }
            this.mVideoHeight = build.video_height.intValue();
            this.iHs = this.mVideoHeight / 2;
            if (this.iHu != null) {
                this.iHo.setVideoTailFrameData(this.iHu);
            }
            this.iHo.setPageContext(getPageContext());
            this.iHo.setData(build, 2, getPageContext());
            if (iHy != null) {
                this.iHo.setStatisticInfo(iHy.iHx, iHy.mPageNum, iHy.aSM);
            }
            this.iHo.setTailFrameIsMiddlePage(true);
            this.iHo.updateTailFrameView(null);
            this.iHo.setChargeInfo(this.iHt);
            this.iHo.autoPlay(0);
            yh(build.video_height.intValue());
        }
        return frameLayout;
    }

    private void yh(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dgZ.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (l.getEquipmentHeight(getActivity()) - l.getStatusBarHeight(getActivity())) - cfO();
            this.dgZ.setLayoutParams(layoutParams);
        }
    }

    private int cfO() {
        return l.getDimens(this, R.dimen.ds98);
    }
}
