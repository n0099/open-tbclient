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
    private NewUserGuideModel hiS;
    private boolean hiU;
    private RightSlideViewPager hiV;
    private boolean hiT = false;
    private boolean isChanged = false;
    private NewUserGuideModel.b hiW = new NewUserGuideModel.b() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideActivity.1
        @Override // com.baidu.tieba.tblauncherInterestGuide.model.NewUserGuideModel.b
        public void a(InterestFrsData interestFrsData) {
            NewUserGuideActivity.this.hiS.nx(false);
            NewUserGuideActivity.this.hiS.e(interestFrsData);
            ((NewUserGuideMainFragment) ((FragmentPagerAdapter) NewUserGuideActivity.this.hiV.getAdapter()).getItem(1)).c(interestFrsData);
        }

        @Override // com.baidu.tieba.tblauncherInterestGuide.model.NewUserGuideModel.b
        public void b(InterestFrsData interestFrsData) {
            NewUserGuideActivity.this.hiS.nx(true);
            NewUserGuideActivity.this.hiS.e(null);
            NewUserGuideActivity.this.showToast(e.j.neterror);
        }
    };

    public boolean bEp() {
        return this.isChanged;
    }

    public void nv(boolean z) {
        this.isChanged = z;
    }

    public RightSlideViewPager bEq() {
        return this.hiV;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        bEs();
        setContentView(e.h.guide_activity_interestfrs);
        initUI();
        initData();
    }

    public void nw(boolean z) {
        this.hiT = z;
    }

    private void initData() {
        this.hiU = getIntent().getBooleanExtra("is_new_user", false);
        this.hiT = getIntent().getBooleanExtra(NewUserGuideActivityConfig.HAS_LIEK_BAR, false);
        int i = this.hiU ? 1 : 2;
        this.hiS = new NewUserGuideModel(this);
        this.hiS.a(i, 0, 100, this.hiW);
    }

    private void initUI() {
        this.hiV = (RightSlideViewPager) findViewById(e.g.guide_viewPager);
        this.hiV.setAdapter(new NewUserGuidePagerAdapter(getSupportFragmentManager()));
        this.hiV.setTag("canScroll");
        this.hiV.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (i == 1) {
                    NewUserGuideActivity.this.hiV.setTag(null);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (NewUserGuideActivity.this.hiS.bEy() && i == 0 && f > 0.0f) {
                    NewUserGuideActivity.this.bEt();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                NewUserGuideIntroduceFragment newUserGuideIntroduceFragment = (NewUserGuideIntroduceFragment) ((FragmentPagerAdapter) NewUserGuideActivity.this.hiV.getAdapter()).getItem(0);
                if (i == 0) {
                    newUserGuideIntroduceFragment.bEv();
                } else {
                    newUserGuideIntroduceFragment.bEw();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hiS != null) {
            this.hiS.bEA();
        }
    }

    public NewUserGuideModel bEr() {
        return this.hiS;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            bEt();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bEs() {
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

    public void bEt() {
        sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNewUserCfg(1, this.hiU)));
        finish();
    }
}
