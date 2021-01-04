package com.baidu.tieba.tblauncherInterestGuide;

import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
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
/* loaded from: classes2.dex */
public class NewUserGuideActivity extends BaseFragmentActivity {
    private boolean mIsNewUser;
    private NewUserGuideModel nzf;
    private RightSlideViewPager nzh;
    private boolean nzg = false;
    private boolean isChanged = false;
    private NewUserGuideModel.b nzi = new NewUserGuideModel.b() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideActivity.1
        @Override // com.baidu.tieba.tblauncherInterestGuide.model.NewUserGuideModel.b
        public void a(InterestFrsData interestFrsData) {
            NewUserGuideActivity.this.nzf.yB(false);
            NewUserGuideActivity.this.nzf.e(interestFrsData);
            ((NewUserGuideMainFragment) ((FragmentPagerAdapter) NewUserGuideActivity.this.nzh.getAdapter()).getItem(1)).c(interestFrsData);
        }

        @Override // com.baidu.tieba.tblauncherInterestGuide.model.NewUserGuideModel.b
        public void b(InterestFrsData interestFrsData) {
            NewUserGuideActivity.this.nzf.yB(true);
            NewUserGuideActivity.this.nzf.e(null);
            NewUserGuideActivity.this.showToast(R.string.neterror);
        }
    };

    public boolean dSc() {
        return this.isChanged;
    }

    public void yz(boolean z) {
        this.isChanged = z;
    }

    public RightSlideViewPager dSd() {
        return this.nzh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        dSf();
        setContentView(R.layout.guide_activity_interestfrs);
        initUI();
        initData();
    }

    public void yA(boolean z) {
        this.nzg = z;
    }

    private void initData() {
        this.mIsNewUser = getIntent().getBooleanExtra("is_new_user", false);
        this.nzg = getIntent().getBooleanExtra(NewUserGuideActivityConfig.HAS_LIEK_BAR, false);
        int i = this.mIsNewUser ? 1 : 2;
        this.nzf = new NewUserGuideModel(this);
        this.nzf.a(i, 0, 100, this.nzi);
    }

    private void initUI() {
        this.nzh = (RightSlideViewPager) findViewById(R.id.guide_viewPager);
        this.nzh.setAdapter(new NewUserGuidePagerAdapter(getSupportFragmentManager()));
        this.nzh.setTag("canScroll");
        this.nzh.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideActivity.2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (i == 1) {
                    NewUserGuideActivity.this.nzh.setTag(null);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (NewUserGuideActivity.this.nzf.dSk() && i == 0 && f > 0.0f) {
                    NewUserGuideActivity.this.dSg();
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                NewUserGuideIntroduceFragment newUserGuideIntroduceFragment = (NewUserGuideIntroduceFragment) ((FragmentPagerAdapter) NewUserGuideActivity.this.nzh.getAdapter()).getItem(0);
                if (i == 0) {
                    newUserGuideIntroduceFragment.dSh();
                } else {
                    newUserGuideIntroduceFragment.dSi();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nzf != null) {
            this.nzf.dSm();
        }
    }

    public NewUserGuideModel dSe() {
        return this.nzf;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            dSg();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void dSf() {
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

    public void dSg() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNewUserCfg(1, this.mIsNewUser)));
        finish();
    }
}
