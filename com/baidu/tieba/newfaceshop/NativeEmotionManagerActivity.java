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
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.ex7;
import com.baidu.tieba.gx7;
import com.baidu.tieba.newfaceshop.nativemotionmanager.CreateNewEmotionFragment;
import com.baidu.tieba.newfaceshop.nativemotionmanager.MyEmotionManagerFragment;
import com.baidu.tieba.newfaceshop.nativemotionmanager.SingleThreadEmotionFragment;
import com.baidu.tieba.tq4;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class NativeEmotionManagerActivity extends BaseFragmentActivity implements gx7<Boolean> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FragmentPagerAdapter a;
    public List<BaseFragment> b;
    public BaseFragment c;
    public List<String> d;
    public NavigationBar e;
    public CommonPagerSlidingTabStrip f;
    public View g;
    public BdBaseViewPager h;
    public TextView i;
    public int j;
    public LinearLayout k;
    public MyEmotionManagerFragment l;
    public SingleThreadEmotionFragment m;
    public boolean n;
    public int o;

    /* loaded from: classes5.dex */
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
                if (ListUtils.isEmpty(this.a.b)) {
                    return 0;
                }
                return this.a.b.size();
            }
            return invokeV.intValue;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                if (!ListUtils.isEmpty(this.a.b) && this.a.b.size() > i) {
                    return (Fragment) this.a.b.get(i);
                }
                return null;
            }
            return (Fragment) invokeI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                if (ListUtils.isEmpty(this.a.d)) {
                    return "";
                }
                return (CharSequence) this.a.d.get(i);
            }
            return (CharSequence) invokeI.objValue;
        }
    }

    /* loaded from: classes5.dex */
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
                if (this.a.i == null) {
                    return;
                }
                this.a.o = i;
                this.a.R0();
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
        this.b = new ArrayList(2);
        this.d = new ArrayList(2);
        this.n = true;
        this.o = 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.gx7
    /* renamed from: X0 */
    public void onUpdate(Boolean bool) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bool) != null) || bool == null) {
            return;
        }
        this.n = bool.booleanValue();
        R0();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            setContentView(R.layout.obfuscated_res_0x7f0d0261);
            S0();
        }
    }

    public final void R0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.o == 0 && this.n) {
                this.i.setVisibility(0);
            } else {
                this.i.setVisibility(4);
            }
        }
    }

    public final void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.j = getIntent().getIntExtra("is_bazhu", 0);
            this.k = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090903);
            this.d.add("我的表情");
            MyEmotionManagerFragment myEmotionManagerFragment = new MyEmotionManagerFragment();
            this.l = myEmotionManagerFragment;
            myEmotionManagerFragment.D1(this);
            this.b.add(this.l);
            if (this.j == 1) {
                this.d.add("单吧表情");
                SingleThreadEmotionFragment singleThreadEmotionFragment = new SingleThreadEmotionFragment();
                this.m = singleThreadEmotionFragment;
                this.b.add(singleThreadEmotionFragment);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            TextView textView = new TextView(getPageContext().getPageActivity());
            this.i = textView;
            textView.setPadding(0, yi.g(this, R.dimen.obfuscated_res_0x7f0701d5), yi.g(this, R.dimen.obfuscated_res_0x7f07029b), yi.g(this, R.dimen.obfuscated_res_0x7f0701d5));
            this.i.setClickable(true);
            this.i.setLayoutParams(layoutParams);
            this.i.setText(R.string.obfuscated_res_0x7f0f0580);
            this.i.setOnClickListener(this);
            SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0302);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f091703);
            this.e = navigationBar;
            navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.i, (View.OnClickListener) null);
            this.g = this.e.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.e.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.obfuscated_res_0x7f0d0264, (View.OnClickListener) null);
            CommonPagerSlidingTabStrip commonPagerSlidingTabStrip = (CommonPagerSlidingTabStrip) this.e.findViewById(R.id.obfuscated_res_0x7f0908f7);
            this.f = commonPagerSlidingTabStrip;
            commonPagerSlidingTabStrip.k(yi.g(this, R.dimen.obfuscated_res_0x7f070207), yi.g(this, R.dimen.obfuscated_res_0x7f0701e8), yi.g(this, R.dimen.obfuscated_res_0x7f0701e8), yi.g(this, R.dimen.obfuscated_res_0x7f0701e8), yi.g(this, R.dimen.obfuscated_res_0x7f0701e8), yi.g(this, R.dimen.obfuscated_res_0x7f070302), yi.g(this, R.dimen.obfuscated_res_0x7f070261), R.color.CAM_X0107, R.color.CAM_X0105);
            BdBaseViewPager bdBaseViewPager = (BdBaseViewPager) findViewById(R.id.obfuscated_res_0x7f0908fa);
            this.h = bdBaseViewPager;
            bdBaseViewPager.setmDisallowSlip(true);
            this.h.setOffscreenPageLimit(1);
            a aVar = new a(this, getSupportFragmentManager());
            this.a = aVar;
            this.h.setAdapter(aVar);
            this.f.setViewPager(this.h);
            this.f.setOnPageChangeListener(new b(this));
            this.c = new CreateNewEmotionFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("is_bazhu", this.j);
            this.c.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.obfuscated_res_0x7f0908f6, this.c).commit();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.mSkinType = i;
            tq4 layoutMode = getLayoutMode();
            boolean z = true;
            if (i != 1) {
                z = false;
            }
            layoutMode.l(z);
            CommonPagerSlidingTabStrip commonPagerSlidingTabStrip = this.f;
            if (commonPagerSlidingTabStrip != null) {
                commonPagerSlidingTabStrip.n(i);
            }
            TextView textView = this.i;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0302, i);
            }
            LinearLayout linearLayout = this.k;
            if (linearLayout != null) {
                SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0201);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            super.onClick(view2);
            if (view2 == this.i) {
                boolean z = !ex7.b().a();
                ex7.b().d(z);
                if (z) {
                    this.i.setText(R.string.obfuscated_res_0x7f0f0581);
                } else {
                    this.i.setText(R.string.obfuscated_res_0x7f0f0580);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921310));
            }
        }
    }
}
