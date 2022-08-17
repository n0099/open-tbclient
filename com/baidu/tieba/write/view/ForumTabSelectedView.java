package com.baidu.tieba.write.view;

import android.content.Context;
import android.graphics.Outline;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.tabs.TabLayout;
import com.repackage.ms4;
import com.repackage.pv4;
import com.repackage.qi;
import com.repackage.ru4;
import com.repackage.we6;
import java.util.List;
/* loaded from: classes4.dex */
public class ForumTabSelectedView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsTabItemData a;
    public ImageView b;
    public TextView c;
    public TabLayout d;
    public int e;
    public TabLayout.OnTabSelectedListener f;
    public BaseActivity g;
    public View.OnClickListener h;

    /* loaded from: classes4.dex */
    public class a implements TabLayout.OnTabSelectedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumTabSelectedView a;

        public a(ForumTabSelectedView forumTabSelectedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumTabSelectedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumTabSelectedView;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, tab) == null) && tab != null && (tab.getTag() instanceof FrsTabItemData)) {
                FrsTabItemData frsTabItemData = (FrsTabItemData) tab.getTag();
                if (frsTabItemData.isSelected) {
                    frsTabItemData.isSelected = false;
                    this.a.a = null;
                    this.a.setTabColorUnSelected(tab);
                    return;
                }
                frsTabItemData.isSelected = true;
                this.a.a = frsTabItemData;
                this.a.setTabColorSelected(tab);
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tab) == null) && tab != null && (tab.getTag() instanceof FrsTabItemData)) {
                FrsTabItemData frsTabItemData = (FrsTabItemData) tab.getTag();
                frsTabItemData.isSelected = true;
                this.a.a = frsTabItemData;
                this.a.setTabColorSelected(tab);
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tab) == null) && tab != null && (tab.getTag() instanceof FrsTabItemData)) {
                ((FrsTabItemData) tab.getTag()).isSelected = false;
                this.a.setTabColorUnSelected(tab);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumTabSelectedView a;

        public b(ForumTabSelectedView forumTabSelectedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumTabSelectedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumTabSelectedView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.g == null) {
                return;
            }
            qi.x(this.a.getContext(), this.a);
            we6.a(this.a.g, this.a.g.getPageContext());
        }
    }

    /* loaded from: classes4.dex */
    public class c extends ViewOutlineProvider {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumTabSelectedView a;

        public c(ForumTabSelectedView forumTabSelectedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumTabSelectedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumTabSelectedView;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view2, Outline outline) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, outline) == null) {
                outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), view2.getWidth() * 0.5f);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumTabSelectedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = R.color.CAM_X0202;
        this.f = new a(this);
        this.h = new b(this);
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTabColorSelected(TabLayout.Tab tab) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, this, tab) == null) || tab == null || tab.getCustomView() == null) {
            return;
        }
        ((pv4) f(tab, null).getStyleConfig()).r(R.color.CAM_X0302);
        View e = e(tab);
        if (e != null) {
            e.setVisibility(8);
            ru4.k().u("send_thread_forum_section_gaokao_red_dot", false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTabColorUnSelected(TabLayout.Tab tab) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, this, tab) == null) || tab == null || tab.getCustomView() == null) {
            return;
        }
        pv4 pv4Var = (pv4) f(tab, null).getStyleConfig();
        if (l(tab)) {
            return;
        }
        pv4Var.t(R.color.CAM_X0107);
    }

    @RequiresApi(api = 21)
    public final View e(TabLayout.Tab tab) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tab)) == null) {
            View findViewById = tab.getCustomView().findViewById(R.id.obfuscated_res_0x7f090a99);
            if (findViewById != null) {
                return findViewById;
            }
            View view2 = new View(getContext());
            int f = qi.f(getContext(), R.dimen.tbds21);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(f, f);
            layoutParams.setMargins(0, 0, qi.f(getContext(), R.dimen.tbds10), 0);
            layoutParams.gravity = 5;
            view2.setLayoutParams(layoutParams);
            SkinManager.setBackgroundColor(view2, R.color.CAM_X0301);
            view2.setId(R.id.obfuscated_res_0x7f090a99);
            view2.setOutlineProvider(new c(this));
            view2.setClipToOutline(true);
            return view2;
        }
        return (View) invokeL.objValue;
    }

    public final TBSpecificationBtn f(TabLayout.Tab tab, FrsTabItemData frsTabItemData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tab, frsTabItemData)) == null) {
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) tab.getCustomView().findViewById(R.id.obfuscated_res_0x7f090a98);
            if (tBSpecificationBtn != null) {
                return tBSpecificationBtn;
            }
            if (frsTabItemData == null) {
                return null;
            }
            int f = qi.f(getContext(), R.dimen.M_W_X002);
            qi.f(getContext(), R.dimen.tbds25);
            int f2 = qi.f(getContext(), R.dimen.M_W_X006);
            int f3 = qi.f(getContext(), R.dimen.M_H_X003);
            TBSpecificationBtn tBSpecificationBtn2 = new TBSpecificationBtn(getContext());
            pv4 pv4Var = new pv4();
            pv4Var.l(f2);
            pv4Var.n(f3);
            if (frsTabItemData.tabId == 505) {
                pv4Var.t(R.color.CAM_X0302);
            } else {
                pv4Var.t(R.color.CAM_X0107);
            }
            tBSpecificationBtn2.setConfig(pv4Var);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(f, 0, f, 0);
            tBSpecificationBtn2.setLayoutParams(layoutParams);
            tBSpecificationBtn2.setId(R.id.obfuscated_res_0x7f090a98);
            return tBSpecificationBtn2;
        }
        return (TBSpecificationBtn) invokeLL.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b = new ImageView(getContext());
            int f = qi.f(getContext(), R.dimen.tbds31);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(f, f);
            layoutParams.setMargins(qi.f(getContext(), R.dimen.M_W_X002), 0, 0, 0);
            this.b.setLayoutParams(layoutParams);
            this.b.setOnClickListener(this.h);
            addView(this.b);
        }
    }

    public FrsTabItemData getSelectedTabItemData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            FrsTabItemData frsTabItemData = this.a;
            if (frsTabItemData == null || !frsTabItemData.isSelected) {
                return null;
            }
            return frsTabItemData;
        }
        return (FrsTabItemData) invokeV.objValue;
    }

    public final void h(TabLayout tabLayout) {
        TBSpecificationBtn f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, tabLayout) == null) {
            SkinManager.setBackgroundColor(tabLayout, this.e);
            if (tabLayout != null) {
                for (int i = 0; i < tabLayout.getTabCount(); i++) {
                    TabLayout.Tab tabAt = tabLayout.getTabAt(i);
                    if (tabAt != null && (tabAt.getCustomView() instanceof FrameLayout) && (f = f(tabAt, null)) != null) {
                        f.k();
                        pv4 pv4Var = (pv4) f.getStyleConfig();
                        if (tabAt.isSelected()) {
                            pv4Var.r(R.color.CAM_X0302);
                        } else if (l(tabAt)) {
                            pv4Var.t(R.color.CAM_X0302);
                        } else {
                            pv4Var.t(R.color.CAM_X0107);
                        }
                    }
                }
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.d = (TabLayout) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d02c9, (ViewGroup) null);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(qi.f(getContext(), R.dimen.M_W_X002), 0, 0, 0);
            this.d.setLayoutParams(layoutParams);
            addView(this.d);
            this.d.setOnTabSelectedListener(this.f);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.c = new EMTextView(getContext());
            this.c.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            ms4.d(this.c).z(R.dimen.T_X08);
            this.c.setText(R.string.obfuscated_res_0x7f0f06c2);
            this.c.setOnClickListener(this.h);
            addView(this.c);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            setOrientation(0);
            setGravity(16);
            j();
            g();
            i();
        }
    }

    public final boolean l(TabLayout.Tab tab) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tab)) == null) ? tab != null && (tab.getTag() instanceof FrsTabItemData) && ((FrsTabItemData) tab.getTag()).tabId == 505 : invokeL.booleanValue;
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            h(this.d);
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0107);
            this.b.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809b0, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
        }
    }

    public final void n(List<FrsTabItemData> list, TabLayout tabLayout, int i) {
        TBSpecificationBtn f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048586, this, list, tabLayout, i) == null) {
            tabLayout.removeAllTabs();
            tabLayout.setTabRippleColorResource(R.color.transparent);
            int min = Math.min(list.size(), 10);
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
            for (int i3 = 0; i3 < min; i3++) {
                TabLayout.Tab tabAt = tabLayout.getTabAt(i3);
                if (tabAt == null) {
                    tabAt = tabLayout.newTab();
                    tabLayout.addTab(tabAt, false);
                    View childAt = linearLayout.getChildAt(i3);
                    if (childAt != null) {
                        childAt.setPadding(0, 0, 0, 0);
                    }
                }
                FrsTabItemData frsTabItemData = list.get(i3);
                if (frsTabItemData != null) {
                    String str = frsTabItemData.name;
                    int i4 = frsTabItemData.tabId;
                    if (!TextUtils.isEmpty(str) && i4 >= 0) {
                        if (!(tabAt.getCustomView() instanceof FrameLayout)) {
                            FrameLayout frameLayout = new FrameLayout(getContext());
                            frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                            tabAt.setCustomView(frameLayout);
                            f = f(tabAt, frsTabItemData);
                            frameLayout.addView(f);
                            boolean z = true;
                            if ((ru4.k().h("send_thread_forum_section_gaokao_red_dot", true) && frsTabItemData.tabType == 102) ? false : false) {
                                frameLayout.addView(e(tabAt));
                            }
                        } else {
                            f = f(tabAt, frsTabItemData);
                        }
                        if (f != null) {
                            f.setText(str);
                        }
                        if (tabAt != null) {
                            tabAt.setTag(frsTabItemData);
                        }
                        if (i4 == i) {
                            tabAt.select();
                        }
                    }
                }
            }
            int f2 = qi.f(getContext(), R.dimen.M_W_X004);
            linearLayout.setPadding(f2, 0, f2, 0);
        }
    }

    public void setActivity(BaseActivity baseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, baseActivity) == null) {
            this.g = baseActivity;
        }
    }

    public void setBgColor(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i) == null) || i == 0) {
            return;
        }
        this.e = i;
    }

    public void setData(FrsTabInfoData frsTabInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, frsTabInfoData) == null) {
            if (frsTabInfoData != null && !ListUtils.isEmpty(frsTabInfoData.tabList)) {
                setVisibility(0);
                n(frsTabInfoData.tabList, this.d, frsTabInfoData.selectedTabId);
                return;
            }
            setVisibility(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumTabSelectedView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = R.color.CAM_X0202;
        this.f = new a(this);
        this.h = new b(this);
        k();
    }
}
