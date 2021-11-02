package com.baidu.tieba.write.write.relevance;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import b.a.e.e.p.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.message.EvaluateRelevanceItemSearchMessage;
import com.baidu.tbadk.core.message.EvaluateRelevanceItemUpdatedMessage;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.relevance.list.RelevanceItemListFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes10.dex */
public class RelevanceItemSearchView implements b.a.q0.x0.a, ViewPager.OnPageChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String[] f56116e;

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f56117f;

    /* renamed from: g  reason: collision with root package name */
    public final NavigationBar f56118g;

    /* renamed from: h  reason: collision with root package name */
    public final RelevanceItemSearchActivity f56119h;

    /* renamed from: i  reason: collision with root package name */
    public TbTabLayout f56120i;
    public CustomViewPager j;
    public FragmentAdapter k;
    public View l;
    public EditText m;
    public ImageView n;
    public List<c> o;
    public CustomMessageListener p;

    /* loaded from: classes10.dex */
    public static class FragmentAdapter extends FragmentPagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<c> f56121a;

        /* renamed from: b  reason: collision with root package name */
        public Long f56122b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fragmentManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((FragmentManager) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56121a = new ArrayList();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f56121a.size() : invokeV.intValue;
        }

        public List<c> getFragmentStructureList() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f56121a : (List) invokeV.objValue;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                c cVar = this.f56121a.get(i2);
                if (cVar != null) {
                    return cVar.f56125a;
                }
                return null;
            }
            return (Fragment) invokeI.objValue;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public long getItemId(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? super.getItemId(i2) + this.f56122b.longValue() : invokeI.longValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                c cVar = this.f56121a.get(i2);
                return cVar != null ? cVar.f56126b : "";
            }
            return (CharSequence) invokeI.objValue;
        }

        public void setData(List<c> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
                this.f56122b = Long.valueOf(System.currentTimeMillis());
                this.f56121a.clear();
                if (!ListUtils.isEmpty(list)) {
                    this.f56121a.addAll(list);
                }
                notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RelevanceItemSearchView f56123a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(RelevanceItemSearchView relevanceItemSearchView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {relevanceItemSearchView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56123a = relevanceItemSearchView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage instanceof EvaluateRelevanceItemUpdatedMessage)) {
                EvaluateRelevanceItemUpdatedMessage evaluateRelevanceItemUpdatedMessage = (EvaluateRelevanceItemUpdatedMessage) customResponsedMessage;
                this.f56123a.f56119h.hideLoadingView(this.f56123a.f56117f);
                if (ListUtils.isEmpty(evaluateRelevanceItemUpdatedMessage.tabs)) {
                    return;
                }
                String[] strArr = (String[]) evaluateRelevanceItemUpdatedMessage.tabs.toArray(new String[0]);
                if (Arrays.equals(this.f56123a.f56116e, strArr)) {
                    return;
                }
                this.f56123a.f56116e = strArr;
                this.f56123a.h();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RelevanceItemSearchView f56124e;

        public b(RelevanceItemSearchView relevanceItemSearchView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {relevanceItemSearchView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56124e = relevanceItemSearchView;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.f56124e.g();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public RelevanceItemListFragment f56125a;

        /* renamed from: b  reason: collision with root package name */
        public String f56126b;

        public c(RelevanceItemSearchView relevanceItemSearchView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {relevanceItemSearchView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public RelevanceItemSearchView(RelevanceItemSearchActivity relevanceItemSearchActivity, LinearLayout linearLayout, NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {relevanceItemSearchActivity, linearLayout, navigationBar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f56116e = new String[]{"游戏", "数码"};
        this.o = new ArrayList();
        this.p = new a(this, 2921522);
        this.f56117f = linearLayout;
        this.f56118g = navigationBar;
        this.f56119h = relevanceItemSearchActivity;
        m();
        i();
        h();
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new EvaluateRelevanceItemSearchMessage(this.m.getText().toString()));
        }
    }

    @Override // b.a.q0.x0.a
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (Intent) invokeV.objValue;
    }

    public EditText getSearchText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.m : (EditText) invokeV.objValue;
    }

    public final void h() {
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.o.clear();
            this.f56120i.removeAllTabs();
            for (String str : this.f56116e) {
                this.f56120i.addTab(this.f56120i.newTab());
                c cVar = new c(this);
                RelevanceItemListFragment relevanceItemListFragment = new RelevanceItemListFragment();
                cVar.f56125a = relevanceItemListFragment;
                relevanceItemListFragment.setCategory(str);
                cVar.f56126b = str;
                this.o.add(cVar);
            }
            this.k.setData(this.o);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MessageManager.getInstance().registerListener(this.p);
        }
    }

    @Override // b.a.q0.x0.a
    public boolean isOnViewCancel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.q0.x0.a
    public boolean isOnViewTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f56118g.setCenterTextTitle(this.f56117f.getResources().getString(R.string.releavance_item_category));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f56118g.getLayoutParams();
            layoutParams.height = l.g(this.f56117f.getContext(), R.dimen.tbds60);
            layoutParams.topMargin = l.g(this.f56117f.getContext(), R.dimen.tbds15);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.l = this.f56117f.findViewById(R.id.search_container);
            this.n = (ImageView) this.f56117f.findViewById(R.id.search_icon);
            EditText editText = (EditText) this.f56117f.findViewById(R.id.search_text);
            this.m = editText;
            editText.addTextChangedListener(new b(this));
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            TbTabLayout tbTabLayout = (TbTabLayout) this.f56117f.findViewById(R.id.tablayout);
            this.f56120i = tbTabLayout;
            tbTabLayout.setTabTextSize(l.g(this.f56119h, R.dimen.tbds46));
            this.f56120i.setSelectedTabTextSize(l.g(this.f56119h, R.dimen.tbds52));
            this.f56120i.setSelectedIndicatorBottomMargin(l.g(this.f56119h, R.dimen.tbds11));
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            LayoutInflater.from(this.f56117f.getContext()).inflate(R.layout.relevance_item_search_view, (ViewGroup) this.f56117f, true);
            this.f56119h.showLoadingView(this.f56117f);
            k();
            j();
            l();
            n();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            CustomViewPager customViewPager = (CustomViewPager) this.f56117f.findViewById(R.id.viewpager);
            this.j = customViewPager;
            customViewPager.addOnPageChangeListener(this);
            FragmentAdapter fragmentAdapter = new FragmentAdapter(this.f56119h.getSupportFragmentManager());
            this.k = fragmentAdapter;
            this.j.setAdapter(fragmentAdapter);
            this.f56120i.setupWithViewPager(this.j);
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.p);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
        }
    }

    @Override // b.a.q0.x0.a
    public void onViewChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.n, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0109);
            SkinManager.setBackgroundResource(this.l, R.drawable.enter_forum_search_bg);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.n, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
            if (i2 == 2) {
                this.m.setHintTextColor(SkinManager.getColor(R.color.s_navbar_title_color));
            } else {
                this.m.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            }
            SkinManager.setNavbarTitleColor(this.m, R.color.CAM_X0105, R.color.s_navbar_title_color);
            this.f56120i.setTabTextColors(SkinManager.getColor(R.color.CAM_X0108), SkinManager.getColor(R.color.CAM_X0105));
            this.f56120i.setSelectedTabTextBlod(true);
            this.f56120i.setSelectedTabIndicatorColor(SkinManager.getColor(R.color.CAM_X0302));
        }
    }
}
