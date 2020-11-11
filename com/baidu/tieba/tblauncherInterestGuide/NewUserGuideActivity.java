package com.baidu.tieba.tblauncherInterestGuide;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.NewUserGuideActivityConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import com.baidu.tieba.tblauncherInterestGuide.model.NewUserGuideModel;
import com.baidu.tieba.tblauncherInterestGuide.view.RightSlideViewPager;
import java.lang.reflect.Field;
/* loaded from: classes22.dex */
public class NewUserGuideActivity extends BaseFragmentActivity {
    private boolean mIsNewUser;
    private NewUserGuideModel ndY;
    private RightSlideViewPager nea;
    private boolean ndZ = false;
    private boolean isChanged = false;
    private NewUserGuideModel.b neb = new NewUserGuideModel.b() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideActivity.1
        @Override // com.baidu.tieba.tblauncherInterestGuide.model.NewUserGuideModel.b
        public void a(InterestFrsData interestFrsData) {
            NewUserGuideActivity.this.ndY.xK(false);
            NewUserGuideActivity.this.ndY.e(interestFrsData);
            ((NewUserGuideMainFragment) ((FragmentPagerAdapter) NewUserGuideActivity.this.nea.getAdapter()).getItem(1)).c(interestFrsData);
        }

        @Override // com.baidu.tieba.tblauncherInterestGuide.model.NewUserGuideModel.b
        public void b(InterestFrsData interestFrsData) {
            NewUserGuideActivity.this.ndY.xK(true);
            NewUserGuideActivity.this.ndY.e(null);
            NewUserGuideActivity.this.showToast(R.string.neterror);
        }
    };

    public boolean dMz() {
        return this.isChanged;
    }

    public void xI(boolean z) {
        this.isChanged = z;
    }

    public RightSlideViewPager dMA() {
        return this.nea;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        dMC();
        setContentView(R.layout.guide_activity_interestfrs);
        initUI();
        initData();
    }

    public void xJ(boolean z) {
        this.ndZ = z;
    }

    private void initData() {
        this.mIsNewUser = getIntent().getBooleanExtra("is_new_user", false);
        this.ndZ = getIntent().getBooleanExtra(NewUserGuideActivityConfig.HAS_LIEK_BAR, false);
        int i = this.mIsNewUser ? 1 : 2;
        this.ndY = new NewUserGuideModel(this);
        this.ndY.a(i, 0, 100, this.neb);
    }

    private void initUI() {
        this.nea = (RightSlideViewPager) findViewById(R.id.guide_viewPager);
        this.nea.setAdapter(new NewUserGuidePagerAdapter(getSupportFragmentManager()));
        this.nea.setTag("canScroll");
        this.nea.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (i == 1) {
                    NewUserGuideActivity.this.nea.setTag(null);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (NewUserGuideActivity.this.ndY.dMH() && i == 0 && f > 0.0f) {
                    NewUserGuideActivity.this.dMD();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                NewUserGuideIntroduceFragment newUserGuideIntroduceFragment = (NewUserGuideIntroduceFragment) ((FragmentPagerAdapter) NewUserGuideActivity.this.nea.getAdapter()).getItem(0);
                if (i == 0) {
                    newUserGuideIntroduceFragment.dME();
                } else {
                    newUserGuideIntroduceFragment.dMF();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.ndY != null) {
            this.ndY.dMJ();
        }
    }

    public NewUserGuideModel dMB() {
        return this.ndY;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            dMD();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void dMC() {
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

    public void dMD() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNewUserCfg(1, this.mIsNewUser)));
        finish();
    }
}
