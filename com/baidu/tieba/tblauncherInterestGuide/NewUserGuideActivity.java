package com.baidu.tieba.tblauncherInterestGuide;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import com.baidu.tieba.tblauncherInterestGuide.model.NewUserGuideModel;
import com.baidu.tieba.tblauncherInterestGuide.view.RightSlideViewPager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
/* loaded from: classes5.dex */
public class NewUserGuideActivity extends BaseFragmentActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String HAS_LIEK_BAR = "has_like_bar";
    public static final String IS_NEW_USER = "is_new_user";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isChanged;
    public NewUserGuideModel.b mCallBack;
    public boolean mHasLikes;
    public boolean mIsNewUser;
    public NewUserGuideModel mNewUserGuideModel;
    public RightSlideViewPager mViewPager;

    /* loaded from: classes5.dex */
    public class a implements NewUserGuideModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewUserGuideActivity f21314a;

        public a(NewUserGuideActivity newUserGuideActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newUserGuideActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21314a = newUserGuideActivity;
        }

        @Override // com.baidu.tieba.tblauncherInterestGuide.model.NewUserGuideModel.b
        public void a(InterestFrsData interestFrsData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, interestFrsData) == null) {
                this.f21314a.mNewUserGuideModel.C(false);
                this.f21314a.mNewUserGuideModel.B(interestFrsData);
                ((NewUserGuideMainFragment) ((FragmentPagerAdapter) this.f21314a.mViewPager.getAdapter()).getItem(1)).O0(interestFrsData);
            }
        }

        @Override // com.baidu.tieba.tblauncherInterestGuide.model.NewUserGuideModel.b
        public void b(InterestFrsData interestFrsData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interestFrsData) == null) {
                this.f21314a.mNewUserGuideModel.C(true);
                this.f21314a.mNewUserGuideModel.B(null);
                this.f21314a.showToast(R.string.neterror);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewUserGuideActivity f21315e;

        public b(NewUserGuideActivity newUserGuideActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newUserGuideActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21315e = newUserGuideActivity;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                NewUserGuideIntroduceFragment newUserGuideIntroduceFragment = (NewUserGuideIntroduceFragment) ((FragmentPagerAdapter) this.f21315e.mViewPager.getAdapter()).getItem(0);
                if (i2 == 0) {
                    newUserGuideIntroduceFragment.K0();
                } else {
                    newUserGuideIntroduceFragment.M0();
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) && this.f21315e.mNewUserGuideModel.z() && i2 == 0 && f2 > 0.0f) {
                this.f21315e.startMainTabEnterFourm();
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) && i2 == 1) {
                this.f21315e.mViewPager.setTag(null);
            }
        }
    }

    public NewUserGuideActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mHasLikes = false;
        this.isChanged = false;
        this.mCallBack = new a(this);
    }

    private void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.mIsNewUser = getIntent().getBooleanExtra("is_new_user", false);
            this.mHasLikes = getIntent().getBooleanExtra("has_like_bar", false);
            int i2 = this.mIsNewUser ? 1 : 2;
            NewUserGuideModel newUserGuideModel = new NewUserGuideModel(this);
            this.mNewUserGuideModel = newUserGuideModel;
            newUserGuideModel.A(i2, 0, 100, this.mCallBack);
        }
    }

    private void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            RightSlideViewPager rightSlideViewPager = (RightSlideViewPager) findViewById(R.id.guide_viewPager);
            this.mViewPager = rightSlideViewPager;
            rightSlideViewPager.setAdapter(new NewUserGuidePagerAdapter(getSupportFragmentManager()));
            this.mViewPager.setTag("canScroll");
            this.mViewPager.setOnPageChangeListener(new b(this));
        }
    }

    public static void startGuideActivity(Context context, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{context, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            Intent intent = new Intent(context, NewUserGuideActivity.class);
            intent.putExtra("is_new_user", z);
            intent.putExtra("has_like_bar", z2);
            context.startActivity(intent);
        }
    }

    private void startHardAccelerated() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) || Build.VERSION.SDK_INT < 11) {
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mHasLikes : invokeV.booleanValue;
    }

    public boolean getIsChanged() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.isChanged : invokeV.booleanValue;
    }

    public NewUserGuideModel getNewUserGuideModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mNewUserGuideModel : (NewUserGuideModel) invokeV.objValue;
    }

    public RightSlideViewPager getViewPager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mViewPager : (RightSlideViewPager) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            startHardAccelerated();
            setContentView(R.layout.guide_activity_interestfrs);
            initUI();
            initData();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            NewUserGuideModel newUserGuideModel = this.mNewUserGuideModel;
            if (newUserGuideModel != null) {
                newUserGuideModel.x();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048583, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                startMainTabEnterFourm();
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public void setHasLike(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.mHasLikes = z;
        }
    }

    public void setIsChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.isChanged = z;
        }
    }

    public void startMainTabEnterFourm() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNewUserCfg(1, this.mIsNewUser)));
            finish();
        }
    }
}
