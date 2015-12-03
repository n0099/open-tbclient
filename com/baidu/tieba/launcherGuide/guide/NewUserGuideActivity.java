package com.baidu.tieba.launcherGuide.guide;

import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.NewUserGuideActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.launcherGuide.a.a;
import com.baidu.tieba.launcherGuide.view.RightSlideViewPager;
import com.baidu.tieba.n;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class NewUserGuideActivity extends BaseFragmentActivity {
    private com.baidu.tieba.launcherGuide.a.a chV;
    private boolean chX;
    private RightSlideViewPager chZ;
    private boolean chW = false;
    private boolean chY = false;
    private a.b cia = new b(this);

    public void eg(boolean z) {
        this.chY = z;
    }

    public boolean aet() {
        return this.chY;
    }

    public RightSlideViewPager aeu() {
        return this.chZ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        aew();
        setContentView(n.g.guide_activity_interestfrs);
        initUI();
        initData();
    }

    public void eh(boolean z) {
        this.chW = z;
    }

    private void initData() {
        this.chX = getIntent().getBooleanExtra("is_new_user", false);
        this.chW = getIntent().getBooleanExtra(NewUserGuideActivityConfig.HAS_LIEK_BAR, false);
        int i = this.chX ? 1 : 2;
        this.chV = new com.baidu.tieba.launcherGuide.a.a(this);
        this.chV.a(i, 0, 100, this.cia);
    }

    private void initUI() {
        this.chZ = (RightSlideViewPager) findViewById(n.f.guide_viewPager);
        this.chZ.setAdapter(new n(getSupportFragmentManager()));
        this.chZ.setTag("canScroll");
        this.chZ.setOnPageChangeListener(new c(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.chV != null) {
            this.chV.aeE();
        }
    }

    public com.baidu.tieba.launcherGuide.a.a aev() {
        return this.chV;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            aex();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void aew() {
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("FLAG_HARDWARE_ACCELERATED");
                declaredField.setAccessible(true);
                int i = declaredField.getInt(null);
                Window.class.getMethod("setFlags", Integer.TYPE, Integer.TYPE).invoke(getWindow(), Integer.valueOf(i), Integer.valueOf(i));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void aex() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNewUserCfg(1, this.chX)));
        finish();
    }
}
