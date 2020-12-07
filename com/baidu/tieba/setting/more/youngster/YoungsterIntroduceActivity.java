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
/* loaded from: classes26.dex */
public class YoungsterIntroduceActivity extends BaseActivity {
    private int mFrom;
    private NavigationBar mNavigationBar;
    private View mWn;
    private YoungsterIntroduceView mYj;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_youngster);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mWn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mWn.setOnClickListener(this);
        this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.youngster_settings_open_title));
        Intent intent = getIntent();
        if (intent != null) {
            this.mFrom = intent.getIntExtra(YoungsterPasswordActivityConfig.KEY_YOUNGSTER_PASSWORD_FROM, 0);
        }
        this.mYj = new YoungsterIntroduceView(getPageContext().getPageActivity());
        this.mYj.setFrom(this.mFrom);
        ((FrameLayout) findViewById(R.id.youngster_content)).addView(this.mYj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mYj.onChangeSkinType();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.mWn) {
            finish();
        }
    }
}
