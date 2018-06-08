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
    private NewUserGuideModel gOm;
    private boolean gOo;
    private RightSlideViewPager gOp;
    private boolean gOn = false;
    private boolean isChanged = false;
    private NewUserGuideModel.b gOq = new NewUserGuideModel.b() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideActivity.1
        @Override // com.baidu.tieba.tblauncherInterestGuide.model.NewUserGuideModel.b
        public void a(InterestFrsData interestFrsData) {
            NewUserGuideActivity.this.gOm.mN(false);
            NewUserGuideActivity.this.gOm.e(interestFrsData);
            ((NewUserGuideMainFragment) ((FragmentPagerAdapter) NewUserGuideActivity.this.gOp.getAdapter()).getItem(1)).c(interestFrsData);
        }

        @Override // com.baidu.tieba.tblauncherInterestGuide.model.NewUserGuideModel.b
        public void b(InterestFrsData interestFrsData) {
            NewUserGuideActivity.this.gOm.mN(true);
            NewUserGuideActivity.this.gOm.e(null);
            NewUserGuideActivity.this.showToast(d.k.neterror);
        }
    };

    public boolean bzg() {
        return this.isChanged;
    }

    public void mL(boolean z) {
        this.isChanged = z;
    }

    public RightSlideViewPager bzh() {
        return this.gOp;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        bzj();
        setContentView(d.i.guide_activity_interestfrs);
        initUI();
        initData();
    }

    public void mM(boolean z) {
        this.gOn = z;
    }

    private void initData() {
        this.gOo = getIntent().getBooleanExtra("is_new_user", false);
        this.gOn = getIntent().getBooleanExtra(NewUserGuideActivityConfig.HAS_LIEK_BAR, false);
        int i = this.gOo ? 1 : 2;
        this.gOm = new NewUserGuideModel(this);
        this.gOm.a(i, 0, 100, this.gOq);
    }

    private void initUI() {
        this.gOp = (RightSlideViewPager) findViewById(d.g.guide_viewPager);
        this.gOp.setAdapter(new NewUserGuidePagerAdapter(getSupportFragmentManager()));
        this.gOp.setTag("canScroll");
        this.gOp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (i == 1) {
                    NewUserGuideActivity.this.gOp.setTag(null);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (NewUserGuideActivity.this.gOm.bzp() && i == 0 && f > 0.0f) {
                    NewUserGuideActivity.this.bzk();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                NewUserGuideIntroduceFragment newUserGuideIntroduceFragment = (NewUserGuideIntroduceFragment) ((FragmentPagerAdapter) NewUserGuideActivity.this.gOp.getAdapter()).getItem(0);
                if (i == 0) {
                    newUserGuideIntroduceFragment.bzm();
                } else {
                    newUserGuideIntroduceFragment.bzn();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gOm != null) {
            this.gOm.bzr();
        }
    }

    public NewUserGuideModel bzi() {
        return this.gOm;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            bzk();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bzj() {
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

    public void bzk() {
        sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNewUserCfg(1, this.gOo)));
        finish();
    }
}
