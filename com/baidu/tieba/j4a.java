package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PersonalBackdropListActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import com.baidu.tieba.themeCenter.background.BackgroundGroupActivity;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class j4a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BackgroundGroupActivity a;
    public View b;
    public View c;
    public NavigationBar d;
    public MemberRecommendView e;
    public BdListView f;
    public TextView g;
    public TextView h;
    public int i;
    public h4a j;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j4a a;

        public a(j4a j4aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j4aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j4aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log("c10283");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalBackdropListActivityConfig(this.a.a.getActivity())));
            }
        }
    }

    public j4a(BackgroundGroupActivity backgroundGroupActivity, k4a k4aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {backgroundGroupActivity, k4aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = 0;
        this.a = backgroundGroupActivity;
        this.i = vi.g(backgroundGroupActivity.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0703b6);
        View inflate = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0135, (ViewGroup) null);
        this.b = inflate;
        this.a.setContentView(inflate);
        this.c = this.b.findViewById(R.id.obfuscated_res_0x7f090414);
        NavigationBar navigationBar = (NavigationBar) this.b.findViewById(R.id.view_navigation_bar);
        this.d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.d.setTitleText(R.string.obfuscated_res_0x7f0f105f);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.b.findViewById(R.id.obfuscated_res_0x7f09288c);
        this.e = memberRecommendView;
        memberRecommendView.setFromType(4);
        this.f = (BdListView) this.b.findViewById(R.id.obfuscated_res_0x7f091509);
        TextView textView = new TextView(this.a.getActivity());
        this.g = textView;
        textView.setHeight(vi.g(this.a.getActivity(), R.dimen.obfuscated_res_0x7f07019c));
        TextView textView2 = (TextView) LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d05e2, (ViewGroup) null);
        this.h = textView2;
        textView2.setText(R.string.obfuscated_res_0x7f0f0c7d);
        this.h.setOnClickListener(new a(this));
        this.j = new h4a(this.a.getPageContext(), k4aVar);
        TextView textView3 = new TextView(this.a.getActivity());
        textView3.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + vi.g(this.a.getActivity(), R.dimen.obfuscated_res_0x7f070282)));
        this.f.w(textView3, 0);
        this.f.addFooterView(this.h);
        this.f.setAdapter((ListAdapter) this.j);
    }

    public final void g(List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            if (list != null && list.size() > 0) {
                this.f.setVisibility(0);
                this.j.a(list);
                this.j.notifyDataSetChanged();
                return;
            }
            this.f.setVisibility(8);
        }
    }

    public final List<Object> b(List<i4a> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (i4a i4aVar : list) {
                arrayList.add(i4aVar.b());
                List<DressItemData> a2 = i4aVar.a();
                int size = a2.size();
                if (size > 3) {
                    size = 3;
                }
                for (int i = 0; i < size; i = i + 2 + 1) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i2 = 0; i2 < 3; i2++) {
                        int i3 = i + i2;
                        if (i3 < size) {
                            arrayList2.add(a2.get(i3));
                        }
                    }
                    arrayList.add(arrayList2);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setBackgroundColor(this.b, R.color.CAM_X0204);
            this.a.hideNetRefreshView(this.b);
            this.c.setVisibility(0);
        }
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.c.setVisibility(8);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.c.setVisibility(0);
        }
    }

    public void f() {
        h4a h4aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            gt5.a(this.a.getPageContext(), this.b);
            this.a.getLayoutMode().k(this.h);
            o75.d(this.h).w(R.color.CAM_X0108);
            NavigationBar navigationBar = this.d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.a.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            BdListView bdListView = this.f;
            if (bdListView != null && bdListView.getVisibility() == 0 && (h4aVar = this.j) != null) {
                h4aVar.notifyDataSetChanged();
            }
            SkinManager.setBackgroundColor(this.g, R.color.CAM_X0204);
            this.e.d();
        }
    }

    public final boolean h(f5a f5aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, f5aVar)) == null) {
            if (f5aVar != null && !StringUtils.isNull(f5aVar.c())) {
                this.e.setVisibility(0);
                this.e.e(f5aVar);
                return true;
            }
            this.e.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.c.setVisibility(8);
            SkinManager.setBackgroundColor(this.b, R.color.CAM_X0201);
            String string = this.a.getPageContext().getResources().getString(R.string.no_data_text);
            this.a.setNetRefreshViewTopMargin(this.i);
            this.a.showNetRefreshView(this.b, string, false);
        }
    }

    public void k(f5a f5aVar, List<i4a> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048585, this, f5aVar, list, z) == null) {
            if (list != null && list.size() > 0) {
                c();
                if (h(f5aVar)) {
                    this.f.removeHeaderView(this.g);
                    this.f.addHeaderView(this.g);
                } else {
                    this.f.removeHeaderView(this.g);
                }
                g(b(list));
                return;
            }
            j();
        }
    }
}
