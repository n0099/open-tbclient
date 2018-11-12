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
import com.baidu.tieba.e;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import com.baidu.tieba.tblauncherInterestGuide.model.NewUserGuideModel;
import com.baidu.tieba.tblauncherInterestGuide.view.RightSlideViewPager;
import java.lang.reflect.Field;
/* loaded from: classes3.dex */
public class NewUserGuideActivity extends BaseFragmentActivity {
    private NewUserGuideModel hkC;
    private boolean hkE;
    private RightSlideViewPager hkF;
    private boolean hkD = false;
    private boolean isChanged = false;
    private NewUserGuideModel.b hkG = new NewUserGuideModel.b() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideActivity.1
        @Override // com.baidu.tieba.tblauncherInterestGuide.model.NewUserGuideModel.b
        public void a(InterestFrsData interestFrsData) {
            NewUserGuideActivity.this.hkC.nL(false);
            NewUserGuideActivity.this.hkC.e(interestFrsData);
            ((NewUserGuideMainFragment) ((FragmentPagerAdapter) NewUserGuideActivity.this.hkF.getAdapter()).getItem(1)).c(interestFrsData);
        }

        @Override // com.baidu.tieba.tblauncherInterestGuide.model.NewUserGuideModel.b
        public void b(InterestFrsData interestFrsData) {
            NewUserGuideActivity.this.hkC.nL(true);
            NewUserGuideActivity.this.hkC.e(null);
            NewUserGuideActivity.this.showToast(e.j.neterror);
        }
    };

    public boolean bDO() {
        return this.isChanged;
    }

    public void nJ(boolean z) {
        this.isChanged = z;
    }

    public RightSlideViewPager bDP() {
        return this.hkF;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        bDR();
        setContentView(e.h.guide_activity_interestfrs);
        initUI();
        initData();
    }

    public void nK(boolean z) {
        this.hkD = z;
    }

    private void initData() {
        this.hkE = getIntent().getBooleanExtra("is_new_user", false);
        this.hkD = getIntent().getBooleanExtra(NewUserGuideActivityConfig.HAS_LIEK_BAR, false);
        int i = this.hkE ? 1 : 2;
        this.hkC = new NewUserGuideModel(this);
        this.hkC.a(i, 0, 100, this.hkG);
    }

    private void initUI() {
        this.hkF = (RightSlideViewPager) findViewById(e.g.guide_viewPager);
        this.hkF.setAdapter(new NewUserGuidePagerAdapter(getSupportFragmentManager()));
        this.hkF.setTag("canScroll");
        this.hkF.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (i == 1) {
                    NewUserGuideActivity.this.hkF.setTag(null);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (NewUserGuideActivity.this.hkC.bDX() && i == 0 && f > 0.0f) {
                    NewUserGuideActivity.this.bDS();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                NewUserGuideIntroduceFragment newUserGuideIntroduceFragment = (NewUserGuideIntroduceFragment) ((FragmentPagerAdapter) NewUserGuideActivity.this.hkF.getAdapter()).getItem(0);
                if (i == 0) {
                    newUserGuideIntroduceFragment.bDU();
                } else {
                    newUserGuideIntroduceFragment.bDV();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hkC != null) {
            this.hkC.bDZ();
        }
    }

    public NewUserGuideModel bDQ() {
        return this.hkC;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            bDS();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bDR() {
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

    public void bDS() {
        sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNewUserCfg(1, this.hkE)));
        finish();
    }
}
