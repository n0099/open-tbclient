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
import com.baidu.tieba.t;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class NewUserGuideActivity extends BaseFragmentActivity {
    private com.baidu.tieba.launcherGuide.a.a cDg;
    private boolean cDi;
    private RightSlideViewPager cDk;
    private boolean cDh = false;
    private boolean cDj = false;
    private a.b cDl = new b(this);

    public void eQ(boolean z) {
        this.cDj = z;
    }

    public boolean amX() {
        return this.cDj;
    }

    public RightSlideViewPager amY() {
        return this.cDk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        ana();
        setContentView(t.h.guide_activity_interestfrs);
        pU();
        initData();
    }

    public void eR(boolean z) {
        this.cDh = z;
    }

    private void initData() {
        this.cDi = getIntent().getBooleanExtra("is_new_user", false);
        this.cDh = getIntent().getBooleanExtra(NewUserGuideActivityConfig.HAS_LIEK_BAR, false);
        int i = this.cDi ? 1 : 2;
        this.cDg = new com.baidu.tieba.launcherGuide.a.a(this);
        this.cDg.a(i, 0, 100, this.cDl);
    }

    private void pU() {
        this.cDk = (RightSlideViewPager) findViewById(t.g.guide_viewPager);
        this.cDk.setAdapter(new n(getSupportFragmentManager()));
        this.cDk.setTag("canScroll");
        this.cDk.setOnPageChangeListener(new c(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.cDg != null) {
            this.cDg.ani();
        }
    }

    public com.baidu.tieba.launcherGuide.a.a amZ() {
        return this.cDg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            anb();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void ana() {
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

    public void anb() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNewUserCfg(1, this.cDi)));
        finish();
    }
}
