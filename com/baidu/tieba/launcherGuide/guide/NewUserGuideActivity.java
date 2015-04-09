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
import com.baidu.tieba.launcherGuide.view.RightSlideViewPager;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class NewUserGuideActivity extends BaseFragmentActivity {
    private RightSlideViewPager bwA;
    private com.baidu.tieba.launcherGuide.a.a bww;
    private boolean bwy;
    private boolean bwx = false;
    private boolean bwz = false;
    private com.baidu.tieba.launcherGuide.a.c bwB = new b(this);

    public void dl(boolean z) {
        this.bwz = z;
    }

    public boolean Wk() {
        return this.bwz;
    }

    public RightSlideViewPager Wl() {
        return this.bwA;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        Wn();
        setContentView(com.baidu.tieba.w.guide_activity_interestfrs);
        initUI();
        initData();
    }

    public void dm(boolean z) {
        this.bwx = z;
    }

    private void initData() {
        this.bwy = getIntent().getBooleanExtra("is_new_user", false);
        this.bwx = getIntent().getBooleanExtra(NewUserGuideActivityConfig.HAS_LIEK_BAR, false);
        int i = this.bwy ? 1 : 2;
        this.bww = new com.baidu.tieba.launcherGuide.a.a(this);
        this.bww.a(i, 0, 100, this.bwB);
    }

    private void initUI() {
        this.bwA = (RightSlideViewPager) findViewById(com.baidu.tieba.v.guide_viewPager);
        this.bwA.setAdapter(new q(getSupportFragmentManager()));
        this.bwA.setTag("canScroll");
        this.bwA.setOnPageChangeListener(new c(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bww != null) {
            this.bww.Wv();
        }
    }

    public com.baidu.tieba.launcherGuide.a.a Wm() {
        return this.bww;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            Wo();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void Wn() {
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

    public void Wo() {
        sendMessage(new CustomMessage(2015001, new MainTabActivityConfig(getPageContext().getPageActivity()).createNewUserCfg(1, this.bwy)));
        finish();
    }
}
