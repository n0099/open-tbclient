package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.tabs.TabLayout;
import java.util.List;
/* loaded from: classes5.dex */
public class r17 implements TabLayout.OnTabSelectedListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TabLayout.OnTabSelectedListener a;
    public Context b;
    public TabLayout c;
    public int d;

    public r17(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = context;
        b();
    }

    public void d(TabLayout.OnTabSelectedListener onTabSelectedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onTabSelectedListener) == null) {
            this.a = onTabSelectedListener;
        }
    }

    public void e(FrsTabInfoData frsTabInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, frsTabInfoData) == null) {
            h(this.d, frsTabInfoData.tabList, this.c);
        }
    }

    public final void f(TabLayout.Tab tab) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, tab) == null) && tab.getCustomView() != null) {
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) tab.getCustomView();
            if (tBSpecificationBtn.getStyleConfig() instanceof jz4) {
                ((jz4) tBSpecificationBtn.getStyleConfig()).u(R.color.CAM_X0304);
            }
        }
    }

    public final void g(TabLayout.Tab tab) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, tab) == null) && tab != null && tab.getCustomView() != null) {
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) tab.getCustomView();
            if (tBSpecificationBtn.getStyleConfig() instanceof jz4) {
                ((jz4) tBSpecificationBtn.getStyleConfig()).u(R.color.CAM_X0108);
            }
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, tab) == null) {
            f(tab);
            TabLayout.OnTabSelectedListener onTabSelectedListener = this.a;
            if (onTabSelectedListener != null) {
                onTabSelectedListener.onTabReselected(tab);
            }
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, tab) == null) {
            if (tab != null && (tab.getTag() instanceof FrsTabItemData)) {
                this.d = ((FrsTabItemData) tab.getTag()).tabId;
            }
            f(tab);
            TabLayout.OnTabSelectedListener onTabSelectedListener = this.a;
            if (onTabSelectedListener != null) {
                onTabSelectedListener.onTabSelected(tab);
            }
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, tab) == null) {
            g(tab);
            TabLayout.OnTabSelectedListener onTabSelectedListener = this.a;
            if (onTabSelectedListener != null) {
                onTabSelectedListener.onTabUnselected(tab);
            }
        }
    }

    public TabLayout a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (TabLayout) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            TabLayout tabLayout = (TabLayout) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0212, (ViewGroup) null);
            this.c = tabLayout;
            tabLayout.setOnTabSelectedListener((TabLayout.OnTabSelectedListener) this);
            this.c.setTabGravity(2);
        }
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.b;
        }
        return (Context) invokeV.objValue;
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            for (int i2 = 0; i2 < this.c.getTabCount(); i2++) {
                TabLayout.Tab tabAt = this.c.getTabAt(i2);
                if (tabAt != null) {
                    if (tabAt.isSelected()) {
                        f(tabAt);
                    } else {
                        g(tabAt);
                    }
                    if (tabAt.getCustomView() instanceof TBSpecificationBtn) {
                        ((TBSpecificationBtn) tabAt.getCustomView()).l(i);
                    }
                }
            }
        }
    }

    public final void h(int i, List<FrsTabItemData> list, TabLayout tabLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, list, tabLayout) == null) {
            int min = Math.min(list.size(), 9);
            if (tabLayout.getTabCount() > min) {
                int tabCount = tabLayout.getTabCount() - min;
                for (int i2 = 0; i2 < tabCount; i2++) {
                    tabLayout.removeTabAt(0);
                }
            }
            LinearLayout linearLayout = (LinearLayout) tabLayout.getChildAt(0);
            if (linearLayout == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            linearLayout.requestLayout();
            int g = xi.g(getContext(), R.dimen.M_W_X006) / 2;
            int g2 = xi.g(getContext(), R.dimen.M_H_X003);
            int g3 = xi.g(getContext(), R.dimen.M_H_X001);
            for (int i3 = 0; i3 < min; i3++) {
                TabLayout.Tab tabAt = tabLayout.getTabAt(i3);
                if (tabAt == null) {
                    tabAt = tabLayout.newTab();
                    tabLayout.addTab(tabAt, false);
                    View childAt = linearLayout.getChildAt(i3);
                    ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                    layoutParams2.width = -2;
                    layoutParams2.height = -2;
                    childAt.requestLayout();
                    if (childAt != null) {
                        childAt.setPadding(0, 0, 0, 0);
                    }
                }
                FrsTabItemData frsTabItemData = list.get(i3);
                tabAt.setTag(frsTabItemData);
                if (!(tabAt.getCustomView() instanceof TBSpecificationBtn)) {
                    TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(getContext());
                    jz4 jz4Var = new jz4();
                    jz4Var.u(R.color.CAM_X0108);
                    tBSpecificationBtn.setConfig(jz4Var);
                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(UtilHelper.getDimenPixelSize(R.dimen.tbds177), UtilHelper.getDimenPixelSize(R.dimen.tbds75));
                    layoutParams3.setMargins(g, g2, g, g3);
                    tBSpecificationBtn.setLayoutParams(layoutParams3);
                    tabAt.setCustomView(tBSpecificationBtn);
                }
                ((TBSpecificationBtn) tabAt.getCustomView()).setText(StringHelper.cutForumNameWithSuffix(frsTabItemData.name, 10, StringHelper.STRING_MORE));
                tabAt.f1077view.setBackgroundColor(0);
                if (!tabAt.isSelected() && i == frsTabItemData.tabId) {
                    tabAt.select();
                }
            }
            linearLayout.setPadding(0, 0, 0, 0);
        }
    }
}
