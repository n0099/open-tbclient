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
import com.baidu.tieba.ey4;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import com.baidu.tieba.themeCenter.bubble.list.BubbleListActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class tt8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BubbleListActivity a;
    public View b;
    public NavigationBar c;
    public MemberRecommendView d;
    public BdListView e;
    public fy4 f;
    public st8 g;
    public int h;

    public tt8(BubbleListActivity bubbleListActivity, ot8 ot8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bubbleListActivity, ot8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = null;
        this.h = 0;
        this.a = bubbleListActivity;
        this.h = fj.f(bubbleListActivity.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f07023c);
        View inflate = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0168, (ViewGroup) null);
        this.b = inflate;
        this.a.setContentView(inflate);
        NavigationBar navigationBar = (NavigationBar) this.b.findViewById(R.id.obfuscated_res_0x7f0925ad);
        this.c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.c.setTitleText(R.string.obfuscated_res_0x7f0f0351);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.b.findViewById(R.id.obfuscated_res_0x7f0925ac);
        this.d = memberRecommendView;
        memberRecommendView.setFromType(7);
        this.e = (BdListView) this.b.findViewById(R.id.obfuscated_res_0x7f091328);
        fy4 fy4Var = new fy4(this.a.getPageContext());
        this.f = fy4Var;
        this.e.setPullRefresh(fy4Var);
        TextView textView = new TextView(this.a.getActivity());
        textView.setHeight(fj.f(this.a.getActivity(), R.dimen.obfuscated_res_0x7f0701d5));
        this.e.addFooterView(textView);
        st8 st8Var = new st8(this.a.getPageContext(), ot8Var);
        this.g = st8Var;
        this.e.setAdapter((ListAdapter) st8Var);
    }

    public final List a(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            for (int i = 0; i < size; i = i + 1 + 1) {
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < 2; i2++) {
                    int i3 = i + i2;
                    if (i3 < size) {
                        arrayList2.add(list.get(i3));
                    }
                }
                arrayList.add(arrayList2);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final boolean f(cu8 cu8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cu8Var)) == null) {
            if (cu8Var != null && !StringUtils.isNull(cu8Var.c())) {
                this.d.setVisibility(0);
                this.d.e(cu8Var);
                return true;
            }
            this.d.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setBackgroundColor(this.b, R.color.CAM_X0204);
            this.a.hideNetRefreshView(this.b);
            this.d.setVisibility(0);
            this.e.setVisibility(0);
            this.b.setVisibility(0);
        }
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.e.A(0L);
        }
    }

    public void d() {
        st8 st8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            me5.a(this.a.getPageContext(), this.b);
            NavigationBar navigationBar = this.c;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.a.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            BdListView bdListView = this.e;
            if (bdListView != null && bdListView.getVisibility() == 0 && (st8Var = this.g) != null) {
                st8Var.notifyDataSetChanged();
            }
            fy4 fy4Var = this.f;
            if (fy4Var != null) {
                fy4Var.H(TbadkApplication.getInst().getSkinType());
            }
            this.d.d();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.d.setVisibility(8);
            this.e.setVisibility(8);
            this.b.setVisibility(8);
            SkinManager.setBackgroundColor(this.b, R.color.CAM_X0201);
            String string = this.a.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c84);
            this.a.setNetRefreshViewTopMargin(this.h);
            this.a.showNetRefreshView(this.b, string, false);
        }
    }

    public final void e(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            if (list != null && list.size() > 0) {
                this.e.setVisibility(0);
                this.g.b(list);
                this.g.notifyDataSetChanged();
                return;
            }
            this.e.setVisibility(8);
        }
    }

    public void g(BdListView.p pVar, ey4.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, pVar, gVar) == null) {
            this.e.setOnSrollToBottomListener(pVar);
            this.f.f(gVar);
        }
    }

    public void i(cu8 cu8Var, List list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, cu8Var, list, z) == null) {
            if (list != null && list.size() > 0) {
                b();
                f(cu8Var);
                e(a(list));
                return;
            }
            h();
        }
    }
}
