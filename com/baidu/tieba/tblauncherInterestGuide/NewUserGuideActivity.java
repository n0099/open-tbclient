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
    private NewUserGuideModel gTL;
    private boolean gTN;
    private RightSlideViewPager gTO;
    private boolean gTM = false;
    private boolean isChanged = false;
    private NewUserGuideModel.b gTP = new NewUserGuideModel.b() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideActivity.1
        @Override // com.baidu.tieba.tblauncherInterestGuide.model.NewUserGuideModel.b
        public void a(InterestFrsData interestFrsData) {
            NewUserGuideActivity.this.gTL.mJ(false);
            NewUserGuideActivity.this.gTL.e(interestFrsData);
            ((NewUserGuideMainFragment) ((FragmentPagerAdapter) NewUserGuideActivity.this.gTO.getAdapter()).getItem(1)).c(interestFrsData);
        }

        @Override // com.baidu.tieba.tblauncherInterestGuide.model.NewUserGuideModel.b
        public void b(InterestFrsData interestFrsData) {
            NewUserGuideActivity.this.gTL.mJ(true);
            NewUserGuideActivity.this.gTL.e(null);
            NewUserGuideActivity.this.showToast(d.j.neterror);
        }
    };

    public boolean byr() {
        return this.isChanged;
    }

    public void mH(boolean z) {
        this.isChanged = z;
    }

    public RightSlideViewPager bys() {
        return this.gTO;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        byu();
        setContentView(d.h.guide_activity_interestfrs);
        initUI();
        initData();
    }

    public void mI(boolean z) {
        this.gTM = z;
    }

    private void initData() {
        this.gTN = getIntent().getBooleanExtra("is_new_user", false);
        this.gTM = getIntent().getBooleanExtra(NewUserGuideActivityConfig.HAS_LIEK_BAR, false);
        int i = this.gTN ? 1 : 2;
        this.gTL = new NewUserGuideModel(this);
        this.gTL.a(i, 0, 100, this.gTP);
    }

    private void initUI() {
        this.gTO = (RightSlideViewPager) findViewById(d.g.guide_viewPager);
        this.gTO.setAdapter(new NewUserGuidePagerAdapter(getSupportFragmentManager()));
        this.gTO.setTag("canScroll");
        this.gTO.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (i == 1) {
                    NewUserGuideActivity.this.gTO.setTag(null);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (NewUserGuideActivity.this.gTL.byA() && i == 0 && f > 0.0f) {
                    NewUserGuideActivity.this.byv();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                NewUserGuideIntroduceFragment newUserGuideIntroduceFragment = (NewUserGuideIntroduceFragment) ((FragmentPagerAdapter) NewUserGuideActivity.this.gTO.getAdapter()).getItem(0);
                if (i == 0) {
                    newUserGuideIntroduceFragment.byx();
                } else {
                    newUserGuideIntroduceFragment.byy();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gTL != null) {
            this.gTL.byC();
        }
    }

    public NewUserGuideModel byt() {
        return this.gTL;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            byv();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void byu() {
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

    public void byv() {
        sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNewUserCfg(1, this.gTN)));
        finish();
    }
}
