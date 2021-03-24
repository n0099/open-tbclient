package com.baidu.tieba.setting.more.youngster;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.YoungsterPasswordActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.more.youngster.view.YoungsterIntroduceView;
/* loaded from: classes5.dex */
public class YoungsterIntroduceActivity extends BaseActivity {
    public int mFrom;
    public NavigationBar mNavigationBar;
    public YoungsterIntroduceView mYoungsterIntroduceView;
    public View vBack;

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mYoungsterIntroduceView.b();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.vBack) {
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_youngster);
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar = navigationBar;
        View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.vBack = addSystemImageButton;
        addSystemImageButton.setOnClickListener(this);
        this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.youngster_settings_open_title));
        Intent intent = getIntent();
        if (intent != null) {
            this.mFrom = intent.getIntExtra(YoungsterPasswordActivityConfig.KEY_YOUNGSTER_PASSWORD_FROM, 0);
        }
        YoungsterIntroduceView youngsterIntroduceView = new YoungsterIntroduceView(getPageContext().getPageActivity());
        this.mYoungsterIntroduceView = youngsterIntroduceView;
        youngsterIntroduceView.setFrom(this.mFrom);
        ((FrameLayout) findViewById(R.id.youngster_content)).addView(this.mYoungsterIntroduceView);
    }
}
