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
    private NewUserGuideModel hfW;
    private boolean hfY;
    private RightSlideViewPager hfZ;
    private boolean hfX = false;
    private boolean isChanged = false;
    private NewUserGuideModel.b hga = new NewUserGuideModel.b() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideActivity.1
        @Override // com.baidu.tieba.tblauncherInterestGuide.model.NewUserGuideModel.b
        public void a(InterestFrsData interestFrsData) {
            NewUserGuideActivity.this.hfW.mZ(false);
            NewUserGuideActivity.this.hfW.e(interestFrsData);
            ((f) ((FragmentPagerAdapter) NewUserGuideActivity.this.hfZ.getAdapter()).getItem(1)).c(interestFrsData);
        }

        @Override // com.baidu.tieba.tblauncherInterestGuide.model.NewUserGuideModel.b
        public void b(InterestFrsData interestFrsData) {
            NewUserGuideActivity.this.hfW.mZ(true);
            NewUserGuideActivity.this.hfW.e(null);
            NewUserGuideActivity.this.showToast(d.j.neterror);
        }
    };

    public boolean byZ() {
        return this.isChanged;
    }

    public void mX(boolean z) {
        this.isChanged = z;
    }

    public RightSlideViewPager bza() {
        return this.hfZ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        bzc();
        setContentView(d.h.guide_activity_interestfrs);
        initUI();
        initData();
    }

    public void mY(boolean z) {
        this.hfX = z;
    }

    private void initData() {
        this.hfY = getIntent().getBooleanExtra("is_new_user", false);
        this.hfX = getIntent().getBooleanExtra(NewUserGuideActivityConfig.HAS_LIEK_BAR, false);
        int i = this.hfY ? 1 : 2;
        this.hfW = new NewUserGuideModel(this);
        this.hfW.a(i, 0, 100, this.hga);
    }

    private void initUI() {
        this.hfZ = (RightSlideViewPager) findViewById(d.g.guide_viewPager);
        this.hfZ.setAdapter(new g(getSupportFragmentManager()));
        this.hfZ.setTag("canScroll");
        this.hfZ.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (i == 1) {
                    NewUserGuideActivity.this.hfZ.setTag(null);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (NewUserGuideActivity.this.hfW.bzi() && i == 0 && f > 0.0f) {
                    NewUserGuideActivity.this.bzd();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                e eVar = (e) ((FragmentPagerAdapter) NewUserGuideActivity.this.hfZ.getAdapter()).getItem(0);
                if (i == 0) {
                    eVar.bzf();
                } else {
                    eVar.bzg();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hfW != null) {
            this.hfW.bzk();
        }
    }

    public NewUserGuideModel bzb() {
        return this.hfW;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            bzd();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bzc() {
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

    public void bzd() {
        sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNewUserCfg(1, this.hfY)));
        finish();
    }
}
