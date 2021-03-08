package com.baidu.tieba.play;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class SimpleVideoPlayActivity extends BaseActivity {
    NavigationBar glw;
    FrameLayout hWK;
    com.baidu.tieba.play.operableVideoView.e mJV;
    private String thumbUrl;
    private String videoUrl;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        initData(bundle);
        setContentView(this.hWK);
    }

    private void initView() {
        this.hWK = new FrameLayout(this);
        ap.setBackgroundColor(this.hWK, R.color.CAM_X0611);
        this.hWK.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        FrameLayout frameLayout = new FrameLayout(this);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.hWK.addView(frameLayout, layoutParams);
        this.mJV = new com.baidu.tieba.play.operableVideoView.e(this, frameLayout);
        this.mJV.setStageType("2006");
        this.glw = new NavigationBar(this);
        this.glw.hideBottomLine();
        this.glw.getTopCoverBgView().setVisibility(8);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 48;
        this.hWK.addView(this.glw, layoutParams2);
        SvgManager.bsU().a((ImageView) this.glw.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.play.SimpleVideoPlayActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SimpleVideoPlayActivity.this.finish();
            }
        }).findViewById(R.id.widget_navi_back_button), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.videoUrl = bundle.getString("video_url", "");
            this.thumbUrl = bundle.getString("thumb_url", "");
        } else if (getIntent() != null) {
            this.videoUrl = getIntent().getStringExtra("video_url");
            this.thumbUrl = getIntent().getStringExtra("thumb_url");
        }
        this.mJV.setData(this.thumbUrl, this.videoUrl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mJV.startPlay();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mJV.stopPlay();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("video_url", this.videoUrl);
        bundle.putString("thumb_url", this.thumbUrl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }
}
