package com.baidu.tieba.play;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import d.a.n0.k2.q.e;
/* loaded from: classes5.dex */
public class SimpleVideoPlayActivity extends BaseActivity {
    public NavigationBar navigationBar;
    public FrameLayout rootView;
    public String thumbUrl;
    public e videoContainer;
    public String videoUrl;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SimpleVideoPlayActivity.this.finish();
        }
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.videoUrl = bundle.getString("video_url", "");
            this.thumbUrl = bundle.getString("thumb_url", "");
        } else if (getIntent() != null) {
            this.videoUrl = getIntent().getStringExtra("video_url");
            this.thumbUrl = getIntent().getStringExtra("thumb_url");
        }
        this.videoContainer.A0(this.thumbUrl, this.videoUrl);
    }

    private void initView() {
        FrameLayout frameLayout = new FrameLayout(this);
        this.rootView = frameLayout;
        SkinManager.setBackgroundColor(frameLayout, R.color.CAM_X0611);
        this.rootView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        FrameLayout frameLayout2 = new FrameLayout(this);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.rootView.addView(frameLayout2, layoutParams);
        e eVar = new e(this, frameLayout2);
        this.videoContainer = eVar;
        eVar.setStageType("2006");
        NavigationBar navigationBar = new NavigationBar(this);
        this.navigationBar = navigationBar;
        navigationBar.hideBottomLine();
        this.navigationBar.getTopCoverBgView().setVisibility(8);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 48;
        this.rootView.addView(this.navigationBar, layoutParams2);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a()).findViewById(R.id.widget_navi_back_button), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        initData(bundle);
        setContentView(this.rootView);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.videoContainer.stopPlay();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.videoContainer.startPlay();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("video_url", this.videoUrl);
        bundle.putString("thumb_url", this.thumbUrl);
    }
}
