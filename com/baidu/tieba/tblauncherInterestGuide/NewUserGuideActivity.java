package com.baidu.tieba.tblauncherInterestGuide;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.NewUserGuideActivityConfig;
import com.baidu.tieba.d;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import com.baidu.tieba.tblauncherInterestGuide.model.NewUserGuideModel;
import com.baidu.tieba.tblauncherInterestGuide.view.RightSlideViewPager;
import java.lang.reflect.Field;
/* loaded from: classes3.dex */
public class NewUserGuideActivity extends BaseFragmentActivity {
    private NewUserGuideModel hfH;
    private boolean hfJ;
    private RightSlideViewPager hfK;
    private boolean hfI = false;
    private boolean isChanged = false;
    private NewUserGuideModel.b hfL = new NewUserGuideModel.b() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideActivity.1
        @Override // com.baidu.tieba.tblauncherInterestGuide.model.NewUserGuideModel.b
        public void a(InterestFrsData interestFrsData) {
            NewUserGuideActivity.this.hfH.mZ(false);
            NewUserGuideActivity.this.hfH.e(interestFrsData);
            ((f) ((FragmentPagerAdapter) NewUserGuideActivity.this.hfK.getAdapter()).getItem(1)).c(interestFrsData);
        }

        @Override // com.baidu.tieba.tblauncherInterestGuide.model.NewUserGuideModel.b
        public void b(InterestFrsData interestFrsData) {
            NewUserGuideActivity.this.hfH.mZ(true);
            NewUserGuideActivity.this.hfH.e(null);
            NewUserGuideActivity.this.showToast(d.j.neterror);
        }
    };

    public boolean byY() {
        return this.isChanged;
    }

    public void mX(boolean z) {
        this.isChanged = z;
    }

    public RightSlideViewPager byZ() {
        return this.hfK;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        bzb();
        setContentView(d.h.guide_activity_interestfrs);
        initUI();
        initData();
    }

    public void mY(boolean z) {
        this.hfI = z;
    }

    private void initData() {
        this.hfJ = getIntent().getBooleanExtra("is_new_user", false);
        this.hfI = getIntent().getBooleanExtra(NewUserGuideActivityConfig.HAS_LIEK_BAR, false);
        int i = this.hfJ ? 1 : 2;
        this.hfH = new NewUserGuideModel(this);
        this.hfH.a(i, 0, 100, this.hfL);
    }

    private void initUI() {
        this.hfK = (RightSlideViewPager) findViewById(d.g.guide_viewPager);
        this.hfK.setAdapter(new g(getSupportFragmentManager()));
        this.hfK.setTag("canScroll");
        this.hfK.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (i == 1) {
                    NewUserGuideActivity.this.hfK.setTag(null);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (NewUserGuideActivity.this.hfH.bzh() && i == 0 && f > 0.0f) {
                    NewUserGuideActivity.this.bzc();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                e eVar = (e) ((FragmentPagerAdapter) NewUserGuideActivity.this.hfK.getAdapter()).getItem(0);
                if (i == 0) {
                    eVar.bze();
                } else {
                    eVar.bzf();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hfH != null) {
            this.hfH.bzj();
        }
    }

    public NewUserGuideModel bza() {
        return this.hfH;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            bzc();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bzb() {
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

    public void bzc() {
        sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNewUserCfg(1, this.hfJ)));
        finish();
    }
}
