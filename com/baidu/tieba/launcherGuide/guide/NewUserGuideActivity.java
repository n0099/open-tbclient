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
    private com.baidu.tieba.launcherGuide.a.a bwg;
    private boolean bwi;
    private RightSlideViewPager bwk;
    private boolean bwh = false;
    private boolean bwj = false;
    private com.baidu.tieba.launcherGuide.a.c bwl = new b(this);

    public void dn(boolean z) {
        this.bwj = z;
    }

    public boolean VX() {
        return this.bwj;
    }

    public RightSlideViewPager VY() {
        return this.bwk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        Wa();
        setContentView(com.baidu.tieba.w.guide_activity_interestfrs);
        initUI();
        initData();
    }

    public void dp(boolean z) {
        this.bwh = z;
    }

    private void initData() {
        this.bwi = getIntent().getBooleanExtra("is_new_user", false);
        this.bwh = getIntent().getBooleanExtra(NewUserGuideActivityConfig.HAS_LIEK_BAR, false);
        int i = this.bwi ? 1 : 2;
        this.bwg = new com.baidu.tieba.launcherGuide.a.a(this);
        this.bwg.a(i, 0, 100, this.bwl);
    }

    private void initUI() {
        this.bwk = (RightSlideViewPager) findViewById(com.baidu.tieba.v.guide_viewPager);
        this.bwk.setAdapter(new q(getSupportFragmentManager()));
        this.bwk.setTag("canScroll");
        this.bwk.setOnPageChangeListener(new c(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bwg != null) {
            this.bwg.Wi();
        }
    }

    public com.baidu.tieba.launcherGuide.a.a VZ() {
        return this.bwg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            Wb();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void Wa() {
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

    public void Wb() {
        sendMessage(new CustomMessage(2015001, new MainTabActivityConfig(getPageContext().getPageActivity()).createNewUserCfg(1, this.bwi)));
        finish();
    }
}
