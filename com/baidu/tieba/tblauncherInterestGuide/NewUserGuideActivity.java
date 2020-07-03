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
/* loaded from: classes9.dex */
public class NewUserGuideActivity extends BaseFragmentActivity {
    private NewUserGuideModel lMO;
    private RightSlideViewPager lMQ;
    private boolean mIsNewUser;
    private boolean lMP = false;
    private boolean isChanged = false;
    private NewUserGuideModel.b lMR = new NewUserGuideModel.b() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideActivity.1
        @Override // com.baidu.tieba.tblauncherInterestGuide.model.NewUserGuideModel.b
        public void a(InterestFrsData interestFrsData) {
            NewUserGuideActivity.this.lMO.uZ(false);
            NewUserGuideActivity.this.lMO.e(interestFrsData);
            ((NewUserGuideMainFragment) ((FragmentPagerAdapter) NewUserGuideActivity.this.lMQ.getAdapter()).getItem(1)).c(interestFrsData);
        }

        @Override // com.baidu.tieba.tblauncherInterestGuide.model.NewUserGuideModel.b
        public void b(InterestFrsData interestFrsData) {
            NewUserGuideActivity.this.lMO.uZ(true);
            NewUserGuideActivity.this.lMO.e(null);
            NewUserGuideActivity.this.showToast(R.string.neterror);
        }
    };

    public boolean dkr() {
        return this.isChanged;
    }

    public void uX(boolean z) {
        this.isChanged = z;
    }

    public RightSlideViewPager dks() {
        return this.lMQ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        dku();
        setContentView(R.layout.guide_activity_interestfrs);
        initUI();
        initData();
    }

    public void uY(boolean z) {
        this.lMP = z;
    }

    private void initData() {
        this.mIsNewUser = getIntent().getBooleanExtra("is_new_user", false);
        this.lMP = getIntent().getBooleanExtra(NewUserGuideActivityConfig.HAS_LIEK_BAR, false);
        int i = this.mIsNewUser ? 1 : 2;
        this.lMO = new NewUserGuideModel(this);
        this.lMO.a(i, 0, 100, this.lMR);
    }

    private void initUI() {
        this.lMQ = (RightSlideViewPager) findViewById(R.id.guide_viewPager);
        this.lMQ.setAdapter(new NewUserGuidePagerAdapter(getSupportFragmentManager()));
        this.lMQ.setTag("canScroll");
        this.lMQ.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (i == 1) {
                    NewUserGuideActivity.this.lMQ.setTag(null);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (NewUserGuideActivity.this.lMO.dkz() && i == 0 && f > 0.0f) {
                    NewUserGuideActivity.this.dkv();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                NewUserGuideIntroduceFragment newUserGuideIntroduceFragment = (NewUserGuideIntroduceFragment) ((FragmentPagerAdapter) NewUserGuideActivity.this.lMQ.getAdapter()).getItem(0);
                if (i == 0) {
                    newUserGuideIntroduceFragment.dkw();
                } else {
                    newUserGuideIntroduceFragment.dkx();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.lMO != null) {
            this.lMO.dkB();
        }
    }

    public NewUserGuideModel dkt() {
        return this.lMO;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            dkv();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void dku() {
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

    public void dkv() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNewUserCfg(1, this.mIsNewUser)));
        finish();
    }
}
