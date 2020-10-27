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
/* loaded from: classes21.dex */
public class SimpleVideoPlayActivity extends BaseActivity {
    NavigationBar fOZ;
    com.baidu.tieba.play.operableVideoView.e mdn;
    FrameLayout mdo;
    private String thumbUrl;
    private String videoUrl;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        initData(bundle);
        setContentView(this.mdo);
    }

    private void initView() {
        this.mdo = new FrameLayout(this);
        ap.setBackgroundColor(this.mdo, R.color.cp_mask_b_alpha100);
        this.mdo.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        FrameLayout frameLayout = new FrameLayout(this);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.mdo.addView(frameLayout, layoutParams);
        this.mdn = new com.baidu.tieba.play.operableVideoView.e(this, frameLayout);
        this.mdn.setStageType("2006");
        this.fOZ = new NavigationBar(this);
        this.fOZ.hideBottomLine();
        this.fOZ.getTopCoverBgView().setVisibility(8);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 48;
        this.mdo.addView(this.fOZ, layoutParams2);
        SvgManager.boN().a((ImageView) this.fOZ.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.play.SimpleVideoPlayActivity.1
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
        this.mdn.setData(this.thumbUrl, this.videoUrl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mdn.startPlay();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mdn.stopPlay();
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
