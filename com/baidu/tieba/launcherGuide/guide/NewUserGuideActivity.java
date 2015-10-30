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
    private com.baidu.tieba.launcherGuide.a.a bRo;
    private boolean bRq;
    private RightSlideViewPager bRs;
    private boolean bRp = false;
    private boolean bRr = false;
    private a.b bRt = new b(this);

    public void dF(boolean z) {
        this.bRr = z;
    }

    public boolean aas() {
        return this.bRr;
    }

    public RightSlideViewPager aat() {
        return this.bRs;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        aav();
        setContentView(i.g.guide_activity_interestfrs);
        initUI();
        initData();
    }

    public void dG(boolean z) {
        this.bRp = z;
    }

    private void initData() {
        this.bRq = getIntent().getBooleanExtra("is_new_user", false);
        this.bRp = getIntent().getBooleanExtra(NewUserGuideActivityConfig.HAS_LIEK_BAR, false);
        int i = this.bRq ? 1 : 2;
        this.bRo = new com.baidu.tieba.launcherGuide.a.a(this);
        this.bRo.a(i, 0, 100, this.bRt);
    }

    private void initUI() {
        this.bRs = (RightSlideViewPager) findViewById(i.f.guide_viewPager);
        this.bRs.setAdapter(new n(getSupportFragmentManager()));
        this.bRs.setTag("canScroll");
        this.bRs.setOnPageChangeListener(new c(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bRo != null) {
            this.bRo.aaD();
        }
    }

    public com.baidu.tieba.launcherGuide.a.a aau() {
        return this.bRo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            aaw();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void aav() {
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

    public void aaw() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNewUserCfg(1, this.bRq)));
        finish();
    }
}
