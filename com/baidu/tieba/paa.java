package com.baidu.tieba;

import android.annotation.SuppressLint;
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
import com.baidu.tieba.aa5;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import com.baidu.tieba.themeCenter.background.BackgroundListActivity;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes7.dex */
public class paa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BackgroundListActivity a;
    public View b;
    public View c;
    public NavigationBar d;
    public MemberRecommendView e;
    public BdListView f;
    public ba5 g;
    public TextView h;
    public oaa i;
    public int j;

    public paa(BackgroundListActivity backgroundListActivity, naa naaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {backgroundListActivity, naaVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = null;
        this.j = 0;
        this.a = backgroundListActivity;
        this.j = xi.g(backgroundListActivity.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f07035e);
        View inflate = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0138, (ViewGroup) null);
        this.b = inflate;
        this.a.setContentView(inflate);
        this.c = this.b.findViewById(R.id.obfuscated_res_0x7f090412);
        NavigationBar navigationBar = (NavigationBar) this.b.findViewById(R.id.view_navigation_bar);
        this.d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.d.setTitleText(R.string.obfuscated_res_0x7f0f1081);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.b.findViewById(R.id.obfuscated_res_0x7f0928fb);
        this.e = memberRecommendView;
        memberRecommendView.setFromType(5);
        this.f = (BdListView) this.b.findViewById(R.id.obfuscated_res_0x7f091520);
        ba5 ba5Var = new ba5(this.a.getPageContext());
        this.g = ba5Var;
        this.f.setPullRefresh(ba5Var);
        TextView textView = new TextView(this.a.getActivity());
        this.h = textView;
        textView.setHeight(xi.g(this.a.getActivity(), R.dimen.obfuscated_res_0x7f07019c));
        oaa oaaVar = new oaa(this.a.getPageContext(), naaVar);
        this.i = oaaVar;
        this.f.setAdapter((ListAdapter) oaaVar);
    }

    public final List<List<DressItemData>> a(List<DressItemData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            for (int i = 0; i < size; i = i + 2 + 1) {
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < 3; i2++) {
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

    public final boolean f(iba ibaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ibaVar)) == null) {
            if (ibaVar != null && !StringUtils.isNull(ibaVar.c())) {
                this.e.setVisibility(0);
                this.e.e(ibaVar);
                return true;
            }
            this.e.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setBackgroundColor(this.b, R.color.CAM_X0204);
            this.a.hideNetRefreshView(this.b);
            this.c.setVisibility(0);
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
            this.f.z(0L);
        }
    }

    public void d() {
        oaa oaaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            qt5.a(this.a.getPageContext(), this.b);
            NavigationBar navigationBar = this.d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.a.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            BdListView bdListView = this.f;
            if (bdListView != null && bdListView.getVisibility() == 0 && (oaaVar = this.i) != null) {
                oaaVar.notifyDataSetChanged();
            }
            ba5 ba5Var = this.g;
            if (ba5Var != null) {
                ba5Var.H(TbadkApplication.getInst().getSkinType());
            }
            this.e.d();
            SkinManager.setBackgroundColor(this.h, R.color.CAM_X0204);
        }
    }

    public final void e(List<List<DressItemData>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            if (list != null && list.size() > 0) {
                this.f.setVisibility(0);
                this.i.b(list);
                this.i.notifyDataSetChanged();
                return;
            }
            this.f.setVisibility(8);
        }
    }

    public void g(BdListView.p pVar, aa5.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, pVar, gVar) == null) {
            this.f.setOnSrollToBottomListener(pVar);
            this.g.f(gVar);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.c.setVisibility(8);
            SkinManager.setBackgroundColor(this.b, R.color.CAM_X0201);
            String string = this.a.getPageContext().getResources().getString(R.string.no_data_text);
            this.a.setNetRefreshViewTopMargin(this.j);
            this.a.showNetRefreshView(this.b, string, false);
        }
    }

    public void i(iba ibaVar, List<DressItemData> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, ibaVar, list, z) == null) {
            if (list != null && list.size() > 0) {
                b();
                if (f(ibaVar)) {
                    this.f.removeHeaderView(this.h);
                    this.f.addHeaderView(this.h);
                } else {
                    this.f.removeHeaderView(this.h);
                }
                e(a(list));
                return;
            }
            h();
        }
    }
}
