package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import com.baidu.tieba.themeCenter.card.category.PersonalCardCategoryActivity;
import com.baidu.tieba.themeCenter.card.category.PersonalCardItemView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class z4a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public PersonalCardCategoryActivity b;
    public View c;
    public NavigationBar d;
    public NoNetworkView e;
    public MemberRecommendView f;
    public BdListView g;
    public y4a h;
    public View i;
    public TextView j;
    public int k;

    public z4a(PersonalCardCategoryActivity personalCardCategoryActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {personalCardCategoryActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.k = 0;
        this.b = personalCardCategoryActivity;
        this.k = vi.g(personalCardCategoryActivity.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f07035e);
        View inflate = LayoutInflater.from(this.b.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d01e8, (ViewGroup) null);
        this.c = inflate;
        this.b.setContentView(inflate);
        this.i = this.c.findViewById(R.id.obfuscated_res_0x7f090414);
        NavigationBar navigationBar = (NavigationBar) this.c.findViewById(R.id.view_navigation_bar);
        this.d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.d.setTitleText(R.string.obfuscated_res_0x7f0f1061);
        this.e = (NoNetworkView) this.c.findViewById(R.id.view_no_network);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.c.findViewById(R.id.obfuscated_res_0x7f090641);
        this.f = memberRecommendView;
        memberRecommendView.setFromType(9);
        TextView textView = new TextView(this.b.getActivity());
        this.j = textView;
        textView.setHeight(vi.g(this.b.getActivity(), R.dimen.obfuscated_res_0x7f07019c));
        this.g = (BdListView) this.c.findViewById(R.id.obfuscated_res_0x7f090640);
        y4a y4aVar = new y4a(this.b.getPageContext());
        this.h = y4aVar;
        this.g.setAdapter((ListAdapter) y4aVar);
    }

    public final List<Object> a(List<x4a> list) {
        InterceptResult invokeL;
        int size;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (x4a x4aVar : list) {
                ArrayList<a4a> a = x4aVar.a();
                if (a != null && (size = a.size()) != 0) {
                    arrayList.add(x4aVar.b());
                    if (size > 6) {
                        size = 6;
                    }
                    int i2 = 0;
                    while (i2 < size) {
                        ArrayList arrayList2 = new ArrayList();
                        int i3 = 0;
                        while (true) {
                            i = this.a;
                            if (i3 < i) {
                                int i4 = i2 + i3;
                                if (i4 < size) {
                                    arrayList2.add(a.get(i4));
                                }
                                i3++;
                            }
                        }
                        arrayList.add(arrayList2);
                        i2 = i2 + (i - 1) + 1;
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b.hideNetRefreshView(this.c);
            this.i.setVisibility(0);
        }
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return (View) invokeV.objValue;
    }

    public void d() {
        boolean z;
        y4a y4aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            d05 layoutMode = this.b.getLayoutMode();
            if (TbadkApplication.getInst().getSkinType() == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.l(z);
            this.b.getLayoutMode().k(this.c);
            NavigationBar navigationBar = this.d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.b.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            NoNetworkView noNetworkView = this.e;
            if (noNetworkView != null) {
                noNetworkView.d(this.b.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            BdListView bdListView = this.g;
            if (bdListView != null && bdListView.getVisibility() == 0 && (y4aVar = this.h) != null) {
                y4aVar.notifyDataSetChanged();
            }
            MemberRecommendView memberRecommendView = this.f;
            if (memberRecommendView != null && memberRecommendView.getVisibility() == 0) {
                this.f.d();
            }
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0204);
        }
    }

    public final void e(List<x4a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            if (list != null && list.size() > 0) {
                this.g.setVisibility(0);
                this.h.b(a(list));
                this.h.notifyDataSetChanged();
                return;
            }
            this.g.setVisibility(8);
        }
    }

    public final boolean f(f5a f5aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, f5aVar)) == null) {
            if (f5aVar != null && !StringUtils.isNull(f5aVar.c())) {
                this.f.setVisibility(0);
                this.f.e(f5aVar);
                return true;
            }
            this.f.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void g(PersonalCardItemView.b bVar) {
        y4a y4aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) && (y4aVar = this.h) != null) {
            y4aVar.a(bVar);
        }
    }

    public void h(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, pVar) == null) {
            this.g.setOnSrollToBottomListener(pVar);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.i.setVisibility(8);
            String string = this.b.getPageContext().getResources().getString(R.string.no_data_text);
            this.b.setNetRefreshViewTopMargin(this.k);
            this.b.showNetRefreshView(this.c, string, false);
        }
    }

    public void j(int i, f5a f5aVar, List<x4a> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), f5aVar, list, Boolean.valueOf(z)}) == null) {
            if ((f5aVar != null && !StringUtils.isNull(f5aVar.c())) || (list != null && list.size() > 0)) {
                if (i != 0) {
                    return;
                }
                b();
                if (f(f5aVar)) {
                    this.g.removeHeaderView(this.j);
                    this.g.addHeaderView(this.j);
                } else {
                    this.g.removeHeaderView(this.j);
                }
                e(list);
                return;
            }
            i();
        }
    }
}
