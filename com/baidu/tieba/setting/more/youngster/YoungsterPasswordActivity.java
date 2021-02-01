package com.baidu.tieba.setting.more.youngster;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.lib.f.e;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.YoungsterPasswordActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.youngster.YoungsterPasswordView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class YoungsterPasswordActivity extends BaseActivity {
    private View mBack;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private int mPageType;
    private String mPassword;
    private YoungsterPasswordView niJ;
    private Runnable niK = new Runnable() { // from class: com.baidu.tieba.setting.more.youngster.YoungsterPasswordActivity.1
        @Override // java.lang.Runnable
        public void run() {
            YoungsterPasswordActivity.this.finish();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_youngster);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mBack.setOnClickListener(this);
        this.niJ = new YoungsterPasswordView(getPageContext());
        ((FrameLayout) findViewById(R.id.youngster_content)).addView(this.niJ);
        Intent intent = getIntent();
        if (intent != null) {
            this.mPageType = intent.getIntExtra(YoungsterPasswordActivityConfig.KEY_YOUNGSTER_PASSWORD_PAGE_TYPE, 0);
            sK(this.mPageType);
            this.mPassword = intent.getStringExtra(YoungsterPasswordActivityConfig.KEY_YOUNGSTER_PASSWORD_INPUT);
            this.niJ.setPrePassword(this.mPassword);
            this.mFrom = intent.getIntExtra(YoungsterPasswordActivityConfig.KEY_YOUNGSTER_PASSWORD_FROM, 0);
            this.niJ.setFrom(this.mFrom);
        }
    }

    private void sK(int i) {
        switch (i) {
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
        }
        this.niJ.sK(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.niJ.onChangeSkinType();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.mBack) {
            this.niJ.bIW();
            e.mA().postDelayed(this.niK, 200L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.niJ != null) {
            this.niJ.bIV();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        e.mA().removeCallbacks(this.niK);
    }
}
