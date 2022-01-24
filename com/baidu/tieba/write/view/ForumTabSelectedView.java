package com.baidu.tieba.write.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.s0.s.u.c;
import c.a.t0.e1.m;
import c.a.t0.p4.d;
import c.a.t0.p4.e;
import c.a.t0.p4.f;
import c.a.t0.p4.h;
import c.a.t0.p4.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
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
/* loaded from: classes13.dex */
public class ForumTabSelectedView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public FrsTabItemData f49723e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f49724f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f49725g;

    /* renamed from: h  reason: collision with root package name */
    public TabLayout f49726h;

    /* renamed from: i  reason: collision with root package name */
    public int f49727i;

    /* renamed from: j  reason: collision with root package name */
    public TabLayout.OnTabSelectedListener f49728j;
    public BaseActivity k;
    public View.OnClickListener l;

    /* loaded from: classes13.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                    this.a.f49723e = null;
                    this.a.setTabColorUnSelected(tab);
                    return;
                }
                frsTabItemData.isSelected = true;
                this.a.f49723e = frsTabItemData;
                this.a.setTabColorSelected(tab);
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tab) == null) && tab != null && (tab.getTag() instanceof FrsTabItemData)) {
                FrsTabItemData frsTabItemData = (FrsTabItemData) tab.getTag();
                frsTabItemData.isSelected = true;
                this.a.f49723e = frsTabItemData;
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

    /* loaded from: classes13.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumTabSelectedView f49729e;

        public b(ForumTabSelectedView forumTabSelectedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumTabSelectedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49729e = forumTabSelectedView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f49729e.k == null) {
                return;
            }
            n.w(this.f49729e.getContext(), this.f49729e);
            m.b(this.f49729e.k, this.f49729e.k.getPageContext());
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f49727i = d.CAM_X0202;
        this.f49728j = new a(this);
        this.l = new b(this);
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTabColorSelected(TabLayout.Tab tab) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, this, tab) == null) || tab == null || tab.getCustomView() == null) {
            return;
        }
        ((c.a.s0.s.k0.n.b) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig()).r(d.CAM_X0302);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTabColorUnSelected(TabLayout.Tab tab) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, this, tab) == null) || tab == null || tab.getCustomView() == null) {
            return;
        }
        c.a.s0.s.k0.n.b bVar = (c.a.s0.s.k0.n.b) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig();
        if (j(tab)) {
            return;
        }
        bVar.s(d.CAM_X0107);
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f49724f = new ImageView(getContext());
            int f2 = n.f(getContext(), e.tbds31);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(f2, f2);
            layoutParams.setMargins(n.f(getContext(), e.M_W_X002), 0, 0, 0);
            this.f49724f.setLayoutParams(layoutParams);
            this.f49724f.setOnClickListener(this.l);
            addView(this.f49724f);
        }
    }

    public final void f(TabLayout tabLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tabLayout) == null) {
            SkinManager.setBackgroundColor(tabLayout, this.f49727i);
            if (tabLayout != null) {
                for (int i2 = 0; i2 < tabLayout.getTabCount(); i2++) {
                    TabLayout.Tab tabAt = tabLayout.getTabAt(i2);
                    if (tabAt != null && (tabAt.getCustomView() instanceof TBSpecificationBtn)) {
                        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) tabAt.getCustomView();
                        tBSpecificationBtn.changeSkinType();
                        c.a.s0.s.k0.n.b bVar = (c.a.s0.s.k0.n.b) tBSpecificationBtn.getStyleConfig();
                        if (tabAt.isSelected()) {
                            bVar.r(d.CAM_X0302);
                        } else if (j(tabAt)) {
                            bVar.s(d.CAM_X0302);
                        } else {
                            bVar.s(d.CAM_X0107);
                        }
                    }
                }
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f49726h = (TabLayout) LayoutInflater.from(getContext()).inflate(h.forum_tab_select_layout, (ViewGroup) null);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(n.f(getContext(), e.M_W_X002), 0, 0, 0);
            this.f49726h.setLayoutParams(layoutParams);
            addView(this.f49726h);
            this.f49726h.setOnTabSelectedListener(this.f49728j);
        }
    }

    public FrsTabItemData getSelectedTabItemData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            FrsTabItemData frsTabItemData = this.f49723e;
            if (frsTabItemData == null || !frsTabItemData.isSelected) {
                return null;
            }
            return frsTabItemData;
        }
        return (FrsTabItemData) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f49725g = new EMTextView(getContext());
            this.f49725g.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            c.d(this.f49725g).z(e.T_X08);
            this.f49725g.setText(j.forum_tab_select_title);
            this.f49725g.setOnClickListener(this.l);
            addView(this.f49725g);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            setOrientation(0);
            setGravity(16);
            h();
            e();
            g();
        }
    }

    public final boolean j(TabLayout.Tab tab) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, tab)) == null) ? tab != null && (tab.getTag() instanceof FrsTabItemData) && ((FrsTabItemData) tab.getTag()).tabId == 505 : invokeL.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r18v0, resolved type: com.google.android.material.tabs.TabLayout */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    public final void k(List<FrsTabItemData> list, TabLayout tabLayout, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048583, this, list, tabLayout, i2) == null) {
            tabLayout.removeAllTabs();
            tabLayout.setTabRippleColorResource(d.transparent);
            int min = Math.min(list.size(), 10);
            ?? r3 = 0;
            if (tabLayout.getTabCount() > min) {
                int tabCount = tabLayout.getTabCount() - min;
                for (int i3 = 0; i3 < tabCount; i3++) {
                    tabLayout.removeTabAt(0);
                }
            }
            LinearLayout linearLayout = (LinearLayout) tabLayout.getChildAt(0);
            if (linearLayout == null) {
                return;
            }
            int f2 = n.f(getContext(), e.M_W_X002);
            n.f(getContext(), e.tbds25);
            int f3 = n.f(getContext(), e.M_W_X006);
            int f4 = n.f(getContext(), e.M_H_X003);
            int i4 = 0;
            while (i4 < min) {
                TabLayout.Tab tabAt = tabLayout.getTabAt(i4);
                if (tabAt == null) {
                    tabAt = tabLayout.newTab();
                    tabLayout.addTab(tabAt, (boolean) r3);
                    View childAt = linearLayout.getChildAt(i4);
                    if (childAt != null) {
                        childAt.setPadding(r3, r3, r3, r3);
                    }
                }
                FrsTabItemData frsTabItemData = list.get(i4);
                if (frsTabItemData != null) {
                    String str = frsTabItemData.name;
                    int i5 = frsTabItemData.tabId;
                    if (!TextUtils.isEmpty(str) && i5 >= 0) {
                        TBSpecificationBtn tBSpecificationBtn = null;
                        if (!(tabAt.getCustomView() instanceof TBSpecificationBtn)) {
                            tBSpecificationBtn = new TBSpecificationBtn(getContext());
                            c.a.s0.s.k0.n.b bVar = new c.a.s0.s.k0.n.b();
                            bVar.l(f3);
                            bVar.n(f4);
                            if (frsTabItemData.tabId == 505) {
                                bVar.s(d.CAM_X0302);
                            } else {
                                bVar.s(d.CAM_X0107);
                            }
                            tBSpecificationBtn.setConfig(bVar);
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                            layoutParams.setMargins(f2, 0, f2, 0);
                            tBSpecificationBtn.setLayoutParams(layoutParams);
                            tabAt.setCustomView(tBSpecificationBtn);
                        }
                        if (tBSpecificationBtn != null) {
                            tBSpecificationBtn.setText(str);
                        }
                        if (tabAt != null) {
                            tabAt.setTag(frsTabItemData);
                        }
                        if (i5 == i2) {
                            tabAt.select();
                        }
                        i4++;
                        r3 = 0;
                    }
                }
                i4++;
                r3 = 0;
            }
            int f5 = n.f(getContext(), e.M_W_X004);
            linearLayout.setPadding(f5, 0, f5, 0);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            f(this.f49726h);
            SkinManager.setViewTextColor(this.f49725g, d.CAM_X0107);
            this.f49724f.setImageDrawable(WebPManager.getPureDrawable(f.icon_pure_post_section12, SkinManager.getColor(d.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
        }
    }

    public void setActivity(BaseActivity baseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, baseActivity) == null) {
            this.k = baseActivity;
        }
    }

    public void setBgColor(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || i2 == 0) {
            return;
        }
        this.f49727i = i2;
    }

    public void setData(FrsTabInfoData frsTabInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, frsTabInfoData) == null) {
            if (frsTabInfoData != null && !ListUtils.isEmpty(frsTabInfoData.tabList)) {
                setVisibility(0);
                k(frsTabInfoData.tabList, this.f49726h, frsTabInfoData.selectedTabId);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f49727i = d.CAM_X0202;
        this.f49728j = new a(this);
        this.l = new b(this);
        i();
    }
}
