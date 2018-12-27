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
    private NewUserGuideModel hva;
    private boolean hvc;
    private RightSlideViewPager hvd;
    private boolean hvb = false;
    private boolean isChanged = false;
    private NewUserGuideModel.b hve = new NewUserGuideModel.b() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideActivity.1
        @Override // com.baidu.tieba.tblauncherInterestGuide.model.NewUserGuideModel.b
        public void a(InterestFrsData interestFrsData) {
            NewUserGuideActivity.this.hva.nQ(false);
            NewUserGuideActivity.this.hva.e(interestFrsData);
            ((NewUserGuideMainFragment) ((FragmentPagerAdapter) NewUserGuideActivity.this.hvd.getAdapter()).getItem(1)).c(interestFrsData);
        }

        @Override // com.baidu.tieba.tblauncherInterestGuide.model.NewUserGuideModel.b
        public void b(InterestFrsData interestFrsData) {
            NewUserGuideActivity.this.hva.nQ(true);
            NewUserGuideActivity.this.hva.e(null);
            NewUserGuideActivity.this.showToast(e.j.neterror);
        }
    };

    public boolean bGH() {
        return this.isChanged;
    }

    public void nO(boolean z) {
        this.isChanged = z;
    }

    public RightSlideViewPager bGI() {
        return this.hvd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        bGK();
        setContentView(e.h.guide_activity_interestfrs);
        initUI();
        initData();
    }

    public void nP(boolean z) {
        this.hvb = z;
    }

    private void initData() {
        this.hvc = getIntent().getBooleanExtra("is_new_user", false);
        this.hvb = getIntent().getBooleanExtra(NewUserGuideActivityConfig.HAS_LIEK_BAR, false);
        int i = this.hvc ? 1 : 2;
        this.hva = new NewUserGuideModel(this);
        this.hva.a(i, 0, 100, this.hve);
    }

    private void initUI() {
        this.hvd = (RightSlideViewPager) findViewById(e.g.guide_viewPager);
        this.hvd.setAdapter(new NewUserGuidePagerAdapter(getSupportFragmentManager()));
        this.hvd.setTag("canScroll");
        this.hvd.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (i == 1) {
                    NewUserGuideActivity.this.hvd.setTag(null);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (NewUserGuideActivity.this.hva.bGQ() && i == 0 && f > 0.0f) {
                    NewUserGuideActivity.this.bGL();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                NewUserGuideIntroduceFragment newUserGuideIntroduceFragment = (NewUserGuideIntroduceFragment) ((FragmentPagerAdapter) NewUserGuideActivity.this.hvd.getAdapter()).getItem(0);
                if (i == 0) {
                    newUserGuideIntroduceFragment.bGN();
                } else {
                    newUserGuideIntroduceFragment.bGO();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hva != null) {
            this.hva.bGS();
        }
    }

    public NewUserGuideModel bGJ() {
        return this.hva;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            bGL();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bGK() {
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

    public void bGL() {
        sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNewUserCfg(1, this.hvc)));
        finish();
    }
}
