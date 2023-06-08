package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity;
import com.baidu.tieba.wa7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class va7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BawuTeamInfoActivity a;
    public BdListView b;
    public wa7 c;
    public NavigationBar d;
    public View e;
    public NoNetworkView f;
    public boolean g;
    public View h;
    public ag5 i;
    public wa7.d j;
    public TextView k;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ BawuTeamInfoActivity b;

        public a(va7 va7Var, long j, BawuTeamInfoActivity bawuTeamInfoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {va7Var, Long.valueOf(j), bawuTeamInfoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j;
            this.b = bawuTeamInfoActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                qx4.v(this.b, "", "https://tieba.baidu.com/tb/cms/redpacket/page/complain.html?id=" + this.a, true);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements wa7.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ va7 a;

        public b(va7 va7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {va7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = va7Var;
        }

        @Override // com.baidu.tieba.wa7.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (TbadkCoreApplication.isLogin() && StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    this.a.i(TbadkCoreApplication.getCurrentAccountInfo());
                } else {
                    UrlManager.getInstance().dealOneLink(this.a.a.getPageContext(), new String[]{str});
                }
            }
        }
    }

    public va7(BawuTeamInfoActivity bawuTeamInfoActivity, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bawuTeamInfoActivity, Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = false;
        this.a = bawuTeamInfoActivity;
        View inflate = LayoutInflater.from(bawuTeamInfoActivity.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0153, (ViewGroup) null);
        this.e = inflate;
        this.a.setContentView(inflate);
        this.h = this.e.findViewById(R.id.obfuscated_res_0x7f091ebd);
        NavigationBar navigationBar = (NavigationBar) this.e.findViewById(R.id.view_navigation_bar);
        this.d = navigationBar;
        navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f0335));
        this.d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.k = new TextView(bawuTeamInfoActivity);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(vi.g(bawuTeamInfoActivity, R.dimen.tbds160), -2);
        layoutParams.rightMargin = vi.g(bawuTeamInfoActivity, R.dimen.M_W_X011);
        this.k.setText(R.string.obfuscated_res_0x7f0f04ab);
        this.k.setTextColor(R.color.CAM_X0107);
        this.k.setLayoutParams(layoutParams);
        this.k.setOnClickListener(new a(this, j, bawuTeamInfoActivity));
        this.d.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_RIGHT).addView(this.k);
        this.d.showBottomLine();
        this.f = (NoNetworkView) this.e.findViewById(R.id.view_no_network);
        this.b = (BdListView) this.e.findViewById(R.id.obfuscated_res_0x7f091508);
        wa7 wa7Var = new wa7(this.a.getPageContext());
        this.c = wa7Var;
        this.b.setAdapter((ListAdapter) wa7Var);
        b bVar = new b(this);
        this.j = bVar;
        this.c.f(bVar);
    }

    public void h(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f.a(bVar);
        }
    }

    public final void i(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, accountData) == null) {
            if (this.i == null) {
                this.i = new ag5(this.a);
            }
            this.i.p();
            this.i.u(accountData);
            this.i.z(1);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.hideNetRefreshView(this.e);
            this.b.setVisibility(0);
        }
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.h;
        }
        return (View) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public void g() {
        ag5 ag5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (ag5Var = this.i) != null) {
            ag5Var.s();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.b.setVisibility(8);
            this.a.showNetRefreshView(this.e, this.a.getPageContext().getResources().getString(R.string.no_data_text), true);
        }
    }

    public void f(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            d05 layoutMode = this.a.getLayoutMode();
            if (i == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.l(z);
            this.a.getLayoutMode().k(this.e);
            this.d.onChangeSkinType(this.a.getPageContext(), i);
            this.f.d(this.a.getPageContext(), i);
            o75 d = o75.d(this.k);
            d.B(R.dimen.T_X07);
            d.w(R.color.CAM_X0107);
            this.c.notifyDataSetChanged();
        }
    }

    public void k(ArrayList<xa7> arrayList, nb7 nb7Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList, nb7Var, z) == null) {
            if (arrayList != null && arrayList.size() > 0) {
                this.g = false;
            } else {
                this.g = true;
            }
            if (z && this.g) {
                j();
                return;
            }
            c();
            this.c.d(arrayList);
            this.c.e(nb7Var);
            this.c.notifyDataSetChanged();
        }
    }
}
