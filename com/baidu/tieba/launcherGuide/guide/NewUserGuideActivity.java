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
import com.baidu.tieba.i;
import com.baidu.tieba.launcherGuide.a.a;
import com.baidu.tieba.launcherGuide.view.RightSlideViewPager;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class NewUserGuideActivity extends BaseFragmentActivity {
    private com.baidu.tieba.launcherGuide.a.a bRJ;
    private boolean bRL;
    private RightSlideViewPager bRN;
    private boolean bRK = false;
    private boolean bRM = false;
    private a.b bRO = new b(this);

    public void dH(boolean z) {
        this.bRM = z;
    }

    public boolean aaN() {
        return this.bRM;
    }

    public RightSlideViewPager aaO() {
        return this.bRN;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        aaQ();
        setContentView(i.g.guide_activity_interestfrs);
        initUI();
        initData();
    }

    public void dI(boolean z) {
        this.bRK = z;
    }

    private void initData() {
        this.bRL = getIntent().getBooleanExtra("is_new_user", false);
        this.bRK = getIntent().getBooleanExtra(NewUserGuideActivityConfig.HAS_LIEK_BAR, false);
        int i = this.bRL ? 1 : 2;
        this.bRJ = new com.baidu.tieba.launcherGuide.a.a(this);
        this.bRJ.a(i, 0, 100, this.bRO);
    }

    private void initUI() {
        this.bRN = (RightSlideViewPager) findViewById(i.f.guide_viewPager);
        this.bRN.setAdapter(new n(getSupportFragmentManager()));
        this.bRN.setTag("canScroll");
        this.bRN.setOnPageChangeListener(new c(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bRJ != null) {
            this.bRJ.aaY();
        }
    }

    public com.baidu.tieba.launcherGuide.a.a aaP() {
        return this.bRJ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            aaR();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void aaQ() {
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

    public void aaR() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNewUserCfg(1, this.bRL)));
        finish();
    }
}
