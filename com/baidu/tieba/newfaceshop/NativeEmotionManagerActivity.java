package com.baidu.tieba.newfaceshop;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.NativeEmotionManagerActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.newfaceshop.nativemotionmanager.CreateNewEmotionFragment;
import com.baidu.tieba.newfaceshop.nativemotionmanager.MyEmotionManagerFragment;
import com.baidu.tieba.newfaceshop.nativemotionmanager.SingleThreadEmotionFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.mi;
import com.repackage.po7;
import com.repackage.ro7;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class NativeEmotionManagerActivity extends BaseFragmentActivity implements ro7<Boolean> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragment createEmotionFragment;
    public boolean edaitButtonShowCtrl;
    public int fragmentPostion;
    public List<BaseFragment> fragments;
    public int isModerator;
    public FragmentPagerAdapter mAdapter;
    public View mBackImg;
    public LinearLayout mEmotionRootView;
    public TextView mManager;
    public NavigationBar mNavigationBar;
    public CommonPagerSlidingTabStrip mTabStrip;
    public List<String> mTitles;
    public BdBaseViewPager mViewPager;
    public MyEmotionManagerFragment myEmotionManagerFragment;
    public SingleThreadEmotionFragment singleThreadEmotionFragment;

    /* loaded from: classes3.dex */
    public class a extends FragmentPagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NativeEmotionManagerActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(NativeEmotionManagerActivity nativeEmotionManagerActivity, FragmentManager fragmentManager) {
            super(fragmentManager);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nativeEmotionManagerActivity, fragmentManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((FragmentManager) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nativeEmotionManagerActivity;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (ListUtils.isEmpty(this.a.fragments)) {
                    return 0;
                }
                return this.a.fragments.size();
            }
            return invokeV.intValue;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                if (ListUtils.isEmpty(this.a.fragments) || this.a.fragments.size() <= i) {
                    return null;
                }
                return (Fragment) this.a.fragments.get(i);
            }
            return (Fragment) invokeI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? ListUtils.isEmpty(this.a.mTitles) ? "" : (CharSequence) this.a.mTitles.get(i) : (CharSequence) invokeI.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b extends ViewPager.SimpleOnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NativeEmotionManagerActivity a;

        public b(NativeEmotionManagerActivity nativeEmotionManagerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nativeEmotionManagerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nativeEmotionManagerActivity;
        }

        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                super.onPageSelected(i);
                if (this.a.mManager == null) {
                    return;
                }
                this.a.fragmentPostion = i;
                this.a.ctrlIfShowEditButton();
            }
        }
    }

    public NativeEmotionManagerActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.fragments = new ArrayList(2);
        this.mTitles = new ArrayList(2);
        this.edaitButtonShowCtrl = true;
        this.fragmentPostion = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctrlIfShowEditButton() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            if (this.fragmentPostion == 0 && this.edaitButtonShowCtrl) {
                this.mManager.setVisibility(0);
            } else {
                this.mManager.setVisibility(4);
            }
        }
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.isModerator = getIntent().getIntExtra(NativeEmotionManagerActivityConfig.KEY, 0);
            this.mEmotionRootView = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0908aa);
            this.mTitles.add("我的表情");
            MyEmotionManagerFragment myEmotionManagerFragment = new MyEmotionManagerFragment();
            this.myEmotionManagerFragment = myEmotionManagerFragment;
            myEmotionManagerFragment.I0(this);
            this.fragments.add(this.myEmotionManagerFragment);
            if (this.isModerator == 1) {
                this.mTitles.add("单吧表情");
                SingleThreadEmotionFragment singleThreadEmotionFragment = new SingleThreadEmotionFragment();
                this.singleThreadEmotionFragment = singleThreadEmotionFragment;
                this.fragments.add(singleThreadEmotionFragment);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            TextView textView = new TextView(getPageContext().getPageActivity());
            this.mManager = textView;
            textView.setPadding(0, mi.f(this, R.dimen.obfuscated_res_0x7f0701d5), mi.f(this, R.dimen.obfuscated_res_0x7f07029e), mi.f(this, R.dimen.obfuscated_res_0x7f0701d5));
            this.mManager.setClickable(true);
            this.mManager.setLayoutParams(layoutParams);
            this.mManager.setText(R.string.obfuscated_res_0x7f0f0551);
            this.mManager.setOnClickListener(this);
            SkinManager.setViewTextColor(this.mManager, (int) R.color.CAM_X0302);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f091543);
            this.mNavigationBar = navigationBar;
            navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mManager, (View.OnClickListener) null);
            this.mBackImg = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.obfuscated_res_0x7f0d025f, (View.OnClickListener) null);
            CommonPagerSlidingTabStrip commonPagerSlidingTabStrip = (CommonPagerSlidingTabStrip) this.mNavigationBar.findViewById(R.id.obfuscated_res_0x7f09089f);
            this.mTabStrip = commonPagerSlidingTabStrip;
            commonPagerSlidingTabStrip.k(mi.f(this, R.dimen.obfuscated_res_0x7f070207), mi.f(this, R.dimen.obfuscated_res_0x7f0701e8), mi.f(this, R.dimen.obfuscated_res_0x7f0701e8), mi.f(this, R.dimen.obfuscated_res_0x7f0701e8), mi.f(this, R.dimen.obfuscated_res_0x7f0701e8), mi.f(this, R.dimen.obfuscated_res_0x7f070305), mi.f(this, R.dimen.obfuscated_res_0x7f070261), R.color.CAM_X0107, R.color.CAM_X0105);
            BdBaseViewPager bdBaseViewPager = (BdBaseViewPager) findViewById(R.id.obfuscated_res_0x7f0908a2);
            this.mViewPager = bdBaseViewPager;
            bdBaseViewPager.setmDisallowSlip(true);
            this.mViewPager.setOffscreenPageLimit(1);
            a aVar = new a(this, getSupportFragmentManager());
            this.mAdapter = aVar;
            this.mViewPager.setAdapter(aVar);
            this.mTabStrip.setViewPager(this.mViewPager);
            this.mTabStrip.setOnPageChangeListener(new b(this));
            this.createEmotionFragment = new CreateNewEmotionFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(NativeEmotionManagerActivityConfig.KEY, this.isModerator);
            this.createEmotionFragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.obfuscated_res_0x7f09089e, this.createEmotionFragment).commit();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.mSkinType = i;
            getLayoutMode().k(i == 1);
            CommonPagerSlidingTabStrip commonPagerSlidingTabStrip = this.mTabStrip;
            if (commonPagerSlidingTabStrip != null) {
                commonPagerSlidingTabStrip.n(i);
            }
            TextView textView = this.mManager;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0302, i);
            }
            LinearLayout linearLayout = this.mEmotionRootView;
            if (linearLayout != null) {
                SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0201);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            super.onClick(view2);
            if (view2 == this.mManager) {
                boolean z = !po7.b().a();
                po7.b().d(z);
                if (z) {
                    this.mManager.setText(R.string.obfuscated_res_0x7f0f0552);
                } else {
                    this.mManager.setText(R.string.obfuscated_res_0x7f0f0551);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921310));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            setContentView(R.layout.obfuscated_res_0x7f0d025c);
            init();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ro7
    public void onUpdate(Boolean bool) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bool) == null) || bool == null) {
            return;
        }
        this.edaitButtonShowCtrl = bool.booleanValue();
        ctrlIfShowEditButton();
    }
}
