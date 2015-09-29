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
    private com.baidu.tieba.launcherGuide.a.a bRd;
    private boolean bRf;
    private RightSlideViewPager bRh;
    private boolean bRe = false;
    private boolean bRg = false;
    private a.b bRi = new b(this);

    public void dF(boolean z) {
        this.bRg = z;
    }

    public boolean aaw() {
        return this.bRg;
    }

    public RightSlideViewPager aax() {
        return this.bRh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        aaz();
        setContentView(i.g.guide_activity_interestfrs);
        initUI();
        initData();
    }

    public void dG(boolean z) {
        this.bRe = z;
    }

    private void initData() {
        this.bRf = getIntent().getBooleanExtra("is_new_user", false);
        this.bRe = getIntent().getBooleanExtra(NewUserGuideActivityConfig.HAS_LIEK_BAR, false);
        int i = this.bRf ? 1 : 2;
        this.bRd = new com.baidu.tieba.launcherGuide.a.a(this);
        this.bRd.a(i, 0, 100, this.bRi);
    }

    private void initUI() {
        this.bRh = (RightSlideViewPager) findViewById(i.f.guide_viewPager);
        this.bRh.setAdapter(new n(getSupportFragmentManager()));
        this.bRh.setTag("canScroll");
        this.bRh.setOnPageChangeListener(new c(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bRd != null) {
            this.bRd.aaH();
        }
    }

    public com.baidu.tieba.launcherGuide.a.a aay() {
        return this.bRd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            aaA();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void aaz() {
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

    public void aaA() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNewUserCfg(1, this.bRf)));
        finish();
    }
}
