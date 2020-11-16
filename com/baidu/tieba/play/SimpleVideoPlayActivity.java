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
/* loaded from: classes20.dex */
public class SimpleVideoPlayActivity extends BaseActivity {
    NavigationBar fUw;
    com.baidu.tieba.play.operableVideoView.e mjF;
    FrameLayout mjG;
    private String thumbUrl;
    private String videoUrl;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        initData(bundle);
        setContentView(this.mjG);
    }

    private void initView() {
        this.mjG = new FrameLayout(this);
        ap.setBackgroundColor(this.mjG, R.color.CAM_X0611);
        this.mjG.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        FrameLayout frameLayout = new FrameLayout(this);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.mjG.addView(frameLayout, layoutParams);
        this.mjF = new com.baidu.tieba.play.operableVideoView.e(this, frameLayout);
        this.mjF.setStageType("2006");
        this.fUw = new NavigationBar(this);
        this.fUw.hideBottomLine();
        this.fUw.getTopCoverBgView().setVisibility(8);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 48;
        this.mjG.addView(this.fUw, layoutParams2);
        SvgManager.bqB().a((ImageView) this.fUw.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.play.SimpleVideoPlayActivity.1
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
        this.mjF.setData(this.thumbUrl, this.videoUrl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mjF.startPlay();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mjF.stopPlay();
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
