package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.collectTab.CollectFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.myCollection.CollectTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class zn8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TextView a;
    public final FragmentTabHost b;
    public int c;
    public Fragment d;
    public final NavigationBar e;
    public final NoNetworkView f;
    public CollectTabActivity g;
    public boolean h;
    public List i;
    public ViewPager.OnPageChangeListener j;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zn8 a;

        public a(zn8 zn8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zn8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zn8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.j()) {
                    ii.Q(this.a.g, "请先退出编辑状态");
                } else if (this.a.g != null) {
                    this.a.g.finish();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zn8 a;

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
            }
        }

        public b(zn8 zn8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zn8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zn8Var;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) != null) {
                return;
            }
            this.a.m(i);
            this.a.c(false);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public zn8(CollectTabActivity collectTabActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {collectTabActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = -1;
        this.h = false;
        this.j = new b(this);
        this.g = collectTabActivity;
        FragmentTabHost fragmentTabHost = (FragmentTabHost) collectTabActivity.findViewById(R.id.obfuscated_res_0x7f0921e6);
        this.b = fragmentTabHost;
        fragmentTabHost.setup(this.g.getSupportFragmentManager());
        this.b.setOnPageChangeListener(this.j);
        this.e = (NavigationBar) this.g.findViewById(R.id.navigation_bar);
        this.f = (NoNetworkView) this.g.findViewById(R.id.view_no_network);
        this.e.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        this.e.setCenterTextTitle(this.g.getPageContext().getString(R.string.my_mark));
        TextView textView = (TextView) this.e.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.g).findViewById(R.id.right_textview);
        this.a = textView;
        textView.setText(R.string.obfuscated_res_0x7f0f0563);
        this.a.setOnClickListener(this.g);
        this.e.onChangeSkinType(this.g.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        k(TbadkCoreApplication.getInst().getSkinType());
    }

    @SuppressLint({"ResourceAsColor"})
    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.a.setEnabled(z);
            if (!z) {
                this.a.setText(R.string.obfuscated_res_0x7f0f0563);
                SkinManager.setNavbarTitleColor(this.a, R.color.navi_op_text, R.color.navi_op_text_skin);
            }
        }
    }

    public final void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            FragmentTabHost.c g = this.b.g(i);
            this.c = g.a;
            this.d = g.c;
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void c(boolean z) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            Fragment fragment = this.d;
            if (fragment instanceof CollectFragment) {
                CollectFragment collectFragment = (CollectFragment) fragment;
                if (!collectFragment.F1()) {
                    z = false;
                }
                l(collectFragment.F1());
                i = collectFragment.getType();
            } else {
                i = -1;
            }
            this.h = z;
            TextView textView = this.a;
            if (z) {
                i2 = R.string.obfuscated_res_0x7f0f0530;
            } else {
                i2 = R.string.obfuscated_res_0x7f0f0563;
            }
            textView.setText(i2);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            int i3 = R.color.navi_op_text;
            if (skinType == 2) {
                SkinManager.setNavbarTitleColor(this.a, R.color.navi_op_text, R.color.navi_op_text_skin);
            } else {
                TextView textView2 = this.a;
                if (this.h) {
                    i3 = R.color.CAM_X0302;
                }
                SkinManager.setNavbarTitleColor(textView2, i3, R.color.navi_op_text_skin);
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("is_edit_state", this.h);
            bundle.putInt("fragment_type", i);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022208, bundle));
        }
    }

    public void i(ArrayList<vg5> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, arrayList) == null) && arrayList != null && !arrayList.isEmpty()) {
            this.i = arrayList;
            this.b.t();
            for (int i = 0; i < arrayList.size(); i++) {
                vg5 vg5Var = arrayList.get(i);
                if (vg5Var != null && vg5Var.d()) {
                    d(vg5Var, (FragmentTabIndicator) vg5Var.c(this.g.getPageContext().getPageActivity()));
                }
            }
            this.b.k(0);
            this.b.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.b.getFragmentTabWidget().setVisibility(8);
            }
            m(0);
        }
    }

    public final void d(vg5 vg5Var, FragmentTabIndicator fragmentTabIndicator) {
        wg5 b2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vg5Var, fragmentTabIndicator) != null) || (b2 = vg5Var.b()) == null) {
            return;
        }
        FragmentTabHost.c cVar = new FragmentTabHost.c();
        cVar.c = b2.a;
        cVar.a = b2.e;
        fragmentTabIndicator.setText(b2.b);
        fragmentTabIndicator.setTextSize(0, this.g.getResources().getDimension(R.dimen.obfuscated_res_0x7f0702b7));
        fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
        fragmentTabIndicator.e(TbadkCoreApplication.getInst().getSkinType());
        fragmentTabIndicator.setTipPosType(1);
        cVar.b = fragmentTabIndicator;
        cVar.d = vg5Var;
        this.b.b(cVar);
    }

    public TextView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (TextView) invokeV.objValue;
    }

    public Fragment f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.d;
        }
        return (Fragment) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public final int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return ListUtils.getCount(this.i);
        }
        return invokeV.intValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.h;
        }
        return invokeV.booleanValue;
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.b.s(i);
            if (this.b.getTabWrapper() != null) {
                if (h() <= 1) {
                    this.b.getTabWrapper().setVisibility(8);
                } else {
                    this.b.getTabWrapper().setVisibility(0);
                }
            }
            SkinManager.setNavbarTitleColor(this.a, R.color.navi_op_text, R.color.navi_op_text_skin);
            this.e.onChangeSkinType(this.g.getPageContext(), i);
            this.f.d(this.g.getPageContext(), i);
        }
    }
}
