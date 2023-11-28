package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.forum.data.SortItem;
import com.baidu.tieba.forum.data.SubTabItem;
import com.baidu.tieba.forum.databinding.FragmentFrsFeedBinding;
import com.baidu.tieba.forum.view.FrsSortSwitchButton;
import com.baidu.tieba.forum.widget.ForumTabLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tbclient.ThemeColorInfo;
/* loaded from: classes8.dex */
public final class sn7 implements TabLayout.OnTabSelectedListener, FrsSortSwitchButton.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Function1<? super TabLayout.Tab, Boolean> a;
    public Function1<? super vs7, Boolean> b;
    public Function1<? super TabLayout.Tab, Boolean> c;
    public final FrameLayout d;
    public final BdRecyclerView e;
    public final LinearLayout f;
    public final ForumTabLayout g;
    public final RelativeLayout h;
    public final TextView i;
    public final FrsSortSwitchButton j;
    public String k;
    public ThemeColorInfo l;

    public sn7(FragmentFrsFeedBinding binding, Function1<? super TabLayout.Tab, Boolean> function1, Function1<? super vs7, Boolean> function12, Function1<? super TabLayout.Tab, Boolean> function13) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {binding, function1, function12, function13};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.a = function1;
        this.b = function12;
        this.c = function13;
        FrameLayout frameLayout = binding.b;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.fakeHeadLayout");
        this.d = frameLayout;
        BdRecyclerView bdRecyclerView = binding.g;
        Intrinsics.checkNotNullExpressionValue(bdRecyclerView, "binding.recyclerView");
        this.e = bdRecyclerView;
        LinearLayout linearLayout = binding.f;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.headLayout");
        this.f = linearLayout;
        ForumTabLayout forumTabLayout = binding.l;
        Intrinsics.checkNotNullExpressionValue(forumTabLayout, "binding.subTabLayout");
        this.g = forumTabLayout;
        RelativeLayout relativeLayout = binding.i;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.sortLayout");
        this.h = relativeLayout;
        TextView textView = binding.j;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.sortName");
        this.i = textView;
        FrsSortSwitchButton frsSortSwitchButton = binding.k;
        Intrinsics.checkNotNullExpressionValue(frsSortSwitchButton, "binding.sortSwitchBtn");
        this.j = frsSortSwitchButton;
        this.g.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) this);
        this.j.setOnSwitchChangeListener(this);
    }

    @Override // com.baidu.tieba.forum.view.FrsSortSwitchButton.d
    public boolean a(vs7 currentData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, currentData)) == null) {
            Intrinsics.checkNotNullParameter(currentData, "currentData");
            Function1<? super vs7, Boolean> function1 = this.b;
            if (function1 != null) {
                return function1.invoke(currentData).booleanValue();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void i(ThemeColorInfo themeColorInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, themeColorInfo) == null) {
            this.l = themeColorInfo;
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, tab) == null) {
            Intrinsics.checkNotNullParameter(tab, "tab");
            Function1<? super TabLayout.Tab, Boolean> function1 = this.c;
            if (function1 != null) {
                function1.invoke(tab);
            }
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, tab) == null) {
            Intrinsics.checkNotNullParameter(tab, "tab");
            Function1<? super TabLayout.Tab, Boolean> function1 = this.a;
            boolean z = false;
            if (function1 != null && !function1.invoke(tab).booleanValue()) {
                z = true;
            }
            if (!z) {
                g(tab);
            }
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, tab) == null) {
            Intrinsics.checkNotNullParameter(tab, "tab");
            h(tab);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ThemeColorInfo themeColorInfo = this.l;
            if (themeColorInfo != null) {
                this.k = z5b.e(themeColorInfo);
            }
            d(this.g);
            this.j.A();
            SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0108);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a = null;
            this.g.removeOnTabSelectedListener((TabLayout.BaseOnTabSelectedListener) null);
            this.b = null;
            this.j.setOnSwitchChangeListener(null);
            this.c = null;
        }
    }

    public final void d(TabLayout tabLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tabLayout) == null) {
            int tabCount = tabLayout.getTabCount();
            for (int i = 0; i < tabCount; i++) {
                TabLayout.Tab tabAt = tabLayout.getTabAt(i);
                if (tabAt != null && (tabAt.getCustomView() instanceof TBSpecificationBtn)) {
                    View customView = tabAt.getCustomView();
                    if (customView != null) {
                        TBSpecificationButtonConfig styleConfig = ((TBSpecificationBtn) customView).getStyleConfig();
                        if (styleConfig != null) {
                            c65 c65Var = (c65) styleConfig;
                            if (!tabAt.isSelected()) {
                                c65Var.s(SkinManager.getColor(R.color.CAM_X0108));
                            } else if (rd.isEmpty(this.k)) {
                                c65Var.s(SkinManager.getColor(R.color.CAM_X0105));
                            } else {
                                c65Var.s(uua.f(this.k));
                            }
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonStyleC");
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn");
                    }
                }
            }
        }
    }

    public final void e(wl7 wl7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, wl7Var) == null) {
            if (wl7Var != null && wl7Var.b().size() >= 2) {
                ArrayList arrayList = new ArrayList();
                for (SortItem sortItem : wl7Var.b()) {
                    vs7 vs7Var = new vs7();
                    vs7Var.b = sortItem.getId();
                    vs7Var.a = sortItem.getName();
                    arrayList.add(vs7Var);
                }
                this.h.setVisibility(0);
                this.j.setData(arrayList, wl7Var.a());
                return;
            }
            this.h.setVisibility(8);
        }
    }

    public final void g(TabLayout.Tab tab) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, tab) == null) && tab.getCustomView() != null) {
            View customView = tab.getCustomView();
            if (customView != null) {
                TBSpecificationButtonConfig styleConfig = ((TBSpecificationBtn) customView).getStyleConfig();
                if (styleConfig != null) {
                    c65 c65Var = (c65) styleConfig;
                    if (rd.isEmpty(this.k)) {
                        c65Var.s(SkinManager.getColor(R.color.CAM_X0105));
                        return;
                    } else {
                        c65Var.s(uua.f(this.k));
                        return;
                    }
                }
                throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonStyleC");
            }
            throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn");
        }
    }

    public final void f(xl7 xl7Var) {
        boolean z;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, xl7Var) == null) {
            if (xl7Var != null && xl7Var.b().size() >= 2) {
                this.g.setVisibility(0);
                this.g.removeAllTabs();
                int i2 = 0;
                for (Object obj : xl7Var.b()) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    SubTabItem subTabItem = (SubTabItem) obj;
                    if (xl7Var.a() == i2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    TabLayout.Tab newTab = this.g.newTab();
                    Intrinsics.checkNotNullExpressionValue(newTab, "subTabLayout.newTab()");
                    newTab.f1201view.setPadding(0, 0, 0, 0);
                    TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(this.g.getContext());
                    c65 c65Var = new c65();
                    if (z) {
                        i = R.color.CAM_X0105;
                    } else {
                        i = R.color.CAM_X0108;
                    }
                    c65Var.t(i);
                    tBSpecificationBtn.setConfig(c65Var);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, BdUtilHelper.getDimens(this.g.getContext(), R.dimen.tbds75));
                    layoutParams.setMargins(BdUtilHelper.getDimens(this.g.getContext(), R.dimen.M_W_X006) / 2, 0, BdUtilHelper.getDimens(this.g.getContext(), R.dimen.M_W_X006) / 2, 0);
                    tBSpecificationBtn.setLayoutParams(layoutParams);
                    newTab.setCustomView(tBSpecificationBtn);
                    tBSpecificationBtn.setText(StringHelper.cutForumNameWithSuffix(subTabItem.getName(), 10, "..."));
                    newTab.setTag(Integer.valueOf(subTabItem.getId()));
                    this.g.addTab(newTab, z);
                    i2 = i3;
                }
                return;
            }
            this.g.setVisibility(8);
            this.g.removeAllTabs();
        }
    }

    public final void h(TabLayout.Tab tab) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, tab) == null) && tab != null && tab.getCustomView() != null) {
            View customView = tab.getCustomView();
            if (customView != null) {
                TBSpecificationButtonConfig styleConfig = ((TBSpecificationBtn) customView).getStyleConfig();
                if (styleConfig != null) {
                    ((c65) styleConfig).t(R.color.CAM_X0108);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonStyleC");
            }
            throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn");
        }
    }

    public final void j() {
        ViewGroup viewGroup;
        RecyclerView.LayoutManager layoutManager;
        RecyclerView.LayoutParams generateLayoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f.setVisibility(0);
            ViewParent parent = this.f.getParent();
            if (Intrinsics.areEqual(parent, this.d)) {
                if (parent instanceof ViewGroup) {
                    viewGroup = (ViewGroup) parent;
                } else {
                    viewGroup = null;
                }
                if (viewGroup != null) {
                    viewGroup.removeView(this.f);
                }
                ViewGroup.LayoutParams layoutParams = this.f.getLayoutParams();
                if (layoutParams != null && (layoutManager = this.e.getLayoutManager()) != null && (generateLayoutParams = layoutManager.generateLayoutParams(layoutParams)) != null) {
                    Intrinsics.checkNotNullExpressionValue(generateLayoutParams, "generateLayoutParams(oldLayoutParams)");
                    this.f.setLayoutParams(generateLayoutParams);
                }
                this.e.addHeaderView(this.f);
            }
        }
    }

    public final void k() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f.setVisibility(0);
            ViewParent parent = this.f.getParent();
            if (!Intrinsics.areEqual(parent, this.d)) {
                if (parent instanceof ViewGroup) {
                    viewGroup = (ViewGroup) parent;
                } else {
                    viewGroup = null;
                }
                if (viewGroup != null) {
                    viewGroup.removeView(this.f);
                }
                this.e.removeHeaderView(this.f);
                ViewGroup.LayoutParams layoutParams = this.f.getLayoutParams();
                if (layoutParams != null) {
                    this.f.setLayoutParams(new FrameLayout.LayoutParams(layoutParams));
                }
                this.d.addView(this.f);
            }
        }
    }
}
