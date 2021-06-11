package com.baidu.tieba.setting.more.youngster;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.YoungsterPasswordActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.youngster.YoungsterPasswordView;
import com.baidu.tieba.R;
import d.a.c.e.m.e;
/* loaded from: classes5.dex */
public class YoungsterPasswordActivity extends BaseActivity {
    public Runnable finishWithResult = new a();
    public View mBack;
    public int mFrom;
    public NavigationBar mNavigationBar;
    public int mPageType;
    public String mPassword;
    public YoungsterPasswordView mYoungsterPasswordView;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            YoungsterPasswordActivity.this.finish();
        }
    }

    private void initByType(int i2) {
        switch (i2) {
            case 1:
            case 2:
                this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.youngster_settings_open_title));
                break;
            case 3:
                this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.youngster_settings_close_title));
                break;
            case 4:
            case 5:
                this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.youngster_setting));
                break;
            case 6:
                this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.youngster_setting));
                break;
        }
        this.mYoungsterPasswordView.j(i2);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
        this.mYoungsterPasswordView.k();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.mBack) {
            this.mYoungsterPasswordView.h();
            e.a().postDelayed(this.finishWithResult, 200L);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_youngster);
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar = navigationBar;
        View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mBack = addSystemImageButton;
        addSystemImageButton.setOnClickListener(this);
        YoungsterPasswordView youngsterPasswordView = new YoungsterPasswordView(getPageContext());
        this.mYoungsterPasswordView = youngsterPasswordView;
        ((FrameLayout) findViewById(R.id.youngster_content)).addView(youngsterPasswordView);
        Intent intent = getIntent();
        if (intent != null) {
            int intExtra = intent.getIntExtra(YoungsterPasswordActivityConfig.KEY_YOUNGSTER_PASSWORD_PAGE_TYPE, 0);
            this.mPageType = intExtra;
            initByType(intExtra);
            String stringExtra = intent.getStringExtra(YoungsterPasswordActivityConfig.KEY_YOUNGSTER_PASSWORD_INPUT);
            this.mPassword = stringExtra;
            this.mYoungsterPasswordView.setPrePassword(stringExtra);
            int intExtra2 = intent.getIntExtra(YoungsterPasswordActivityConfig.KEY_YOUNGSTER_PASSWORD_FROM, 0);
            this.mFrom = intExtra2;
            this.mYoungsterPasswordView.setFrom(intExtra2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        e.a().removeCallbacks(this.finishWithResult);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        YoungsterPasswordView youngsterPasswordView = this.mYoungsterPasswordView;
        if (youngsterPasswordView != null) {
            youngsterPasswordView.l();
        }
    }
}
