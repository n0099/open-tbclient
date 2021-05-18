package com.baidu.tieba.tblauncherInterestGuide;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import com.baidu.tieba.tblauncherInterestGuide.model.NewUserGuideModel;
import com.baidu.tieba.tblauncherInterestGuide.view.RightSlideViewPager;
import java.lang.reflect.Field;
/* loaded from: classes5.dex */
public class NewUserGuideActivity extends BaseFragmentActivity {
    public static final String HAS_LIEK_BAR = "has_like_bar";
    public static final String IS_NEW_USER = "is_new_user";
    public boolean mIsNewUser;
    public NewUserGuideModel mNewUserGuideModel;
    public RightSlideViewPager mViewPager;
    public boolean mHasLikes = false;
    public boolean isChanged = false;
    public NewUserGuideModel.b mCallBack = new a();

    /* loaded from: classes5.dex */
    public class a implements NewUserGuideModel.b {
        public a() {
        }

        @Override // com.baidu.tieba.tblauncherInterestGuide.model.NewUserGuideModel.b
        public void a(InterestFrsData interestFrsData) {
            NewUserGuideActivity.this.mNewUserGuideModel.y(false);
            NewUserGuideActivity.this.mNewUserGuideModel.x(interestFrsData);
            ((NewUserGuideMainFragment) ((FragmentPagerAdapter) NewUserGuideActivity.this.mViewPager.getAdapter()).getItem(1)).L0(interestFrsData);
        }

        @Override // com.baidu.tieba.tblauncherInterestGuide.model.NewUserGuideModel.b
        public void b(InterestFrsData interestFrsData) {
            NewUserGuideActivity.this.mNewUserGuideModel.y(true);
            NewUserGuideActivity.this.mNewUserGuideModel.x(null);
            NewUserGuideActivity.this.showToast(R.string.neterror);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            NewUserGuideIntroduceFragment newUserGuideIntroduceFragment = (NewUserGuideIntroduceFragment) ((FragmentPagerAdapter) NewUserGuideActivity.this.mViewPager.getAdapter()).getItem(0);
            if (i2 == 0) {
                newUserGuideIntroduceFragment.H0();
            } else {
                newUserGuideIntroduceFragment.J0();
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            if (NewUserGuideActivity.this.mNewUserGuideModel.v() && i2 == 0 && f2 > 0.0f) {
                NewUserGuideActivity.this.startMainTabEnterFourm();
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            if (i2 == 1) {
                NewUserGuideActivity.this.mViewPager.setTag(null);
            }
        }
    }

    private void initData() {
        this.mIsNewUser = getIntent().getBooleanExtra("is_new_user", false);
        this.mHasLikes = getIntent().getBooleanExtra("has_like_bar", false);
        int i2 = this.mIsNewUser ? 1 : 2;
        NewUserGuideModel newUserGuideModel = new NewUserGuideModel(this);
        this.mNewUserGuideModel = newUserGuideModel;
        newUserGuideModel.w(i2, 0, 100, this.mCallBack);
    }

    private void initUI() {
        RightSlideViewPager rightSlideViewPager = (RightSlideViewPager) findViewById(R.id.guide_viewPager);
        this.mViewPager = rightSlideViewPager;
        rightSlideViewPager.setAdapter(new NewUserGuidePagerAdapter(getSupportFragmentManager()));
        this.mViewPager.setTag("canScroll");
        this.mViewPager.setOnPageChangeListener(new b());
    }

    public static void startGuideActivity(Context context, boolean z, boolean z2) {
        Intent intent = new Intent(context, NewUserGuideActivity.class);
        intent.putExtra("is_new_user", z);
        intent.putExtra("has_like_bar", z2);
        context.startActivity(intent);
    }

    private void startHardAccelerated() {
        if (Build.VERSION.SDK_INT < 11) {
            return;
        }
        try {
            Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("FLAG_HARDWARE_ACCELERATED");
            declaredField.setAccessible(true);
            int i2 = declaredField.getInt(null);
            Window.class.getMethod("setFlags", Integer.TYPE, Integer.TYPE).invoke(getWindow(), Integer.valueOf(i2), Integer.valueOf(i2));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean getHasLike() {
        return this.mHasLikes;
    }

    public boolean getIsChanged() {
        return this.isChanged;
    }

    public NewUserGuideModel getNewUserGuideModel() {
        return this.mNewUserGuideModel;
    }

    public RightSlideViewPager getViewPager() {
        return this.mViewPager;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        startHardAccelerated();
        setContentView(R.layout.guide_activity_interestfrs);
        initUI();
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        NewUserGuideModel newUserGuideModel = this.mNewUserGuideModel;
        if (newUserGuideModel != null) {
            newUserGuideModel.t();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            startMainTabEnterFourm();
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    public void setHasLike(boolean z) {
        this.mHasLikes = z;
    }

    public void setIsChanged(boolean z) {
        this.isChanged = z;
    }

    public void startMainTabEnterFourm() {
        sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNewUserCfg(1, this.mIsNewUser)));
        finish();
    }
}
