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
    NavigationBar fuv;
    com.baidu.tieba.play.operableVideoView.e lBA;
    FrameLayout lBB;
    private String thumbUrl;
    private String videoUrl;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        initData(bundle);
        setContentView(this.lBB);
    }

    private void initView() {
        this.lBB = new FrameLayout(this);
        ap.setBackgroundColor(this.lBB, R.color.cp_mask_b_alpha100);
        this.lBB.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        FrameLayout frameLayout = new FrameLayout(this);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.lBB.addView(frameLayout, layoutParams);
        this.lBA = new com.baidu.tieba.play.operableVideoView.e(this, frameLayout);
        this.lBA.setStageType("2006");
        this.fuv = new NavigationBar(this);
        this.fuv.hideBottomLine();
        this.fuv.getTopCoverBgView().setVisibility(8);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 48;
        this.lBB.addView(this.fuv, layoutParams2);
        SvgManager.bkl().a((ImageView) this.fuv.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.play.SimpleVideoPlayActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SimpleVideoPlayActivity.this.finish();
            }
        }).findViewById(R.id.widget_navi_back_button), R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.videoUrl = bundle.getString("video_url", "");
            this.thumbUrl = bundle.getString("thumb_url", "");
        } else if (getIntent() != null) {
            this.videoUrl = getIntent().getStringExtra("video_url");
            this.thumbUrl = getIntent().getStringExtra("thumb_url");
        }
        this.lBA.setData(this.thumbUrl, this.videoUrl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.lBA.startPlay();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.lBA.stopPlay();
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
