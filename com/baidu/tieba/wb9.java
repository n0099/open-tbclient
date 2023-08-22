package com.baidu.tieba;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.myCollection.ThreadFragment;
import com.baidu.tieba.s45;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class wb9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity a;
    public NavigationBarShadowView b;
    public BdListView c;
    public View d;
    public q95 e;
    public NoDataView f;
    public vb9 g;
    public RelativeLayout h;
    public ProgressBar i;
    public s45 j;
    public s45.e k;
    public c l;
    public boolean m;
    public AbsListView.OnScrollListener n;

    public int g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) ? z ? R.id.obfuscated_res_0x7f0921cd : R.id.obfuscated_res_0x7f090f7f : invokeZ.intValue;
    }

    public int h(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) ? z ? R.id.obfuscated_res_0x7f0921cf : R.id.obfuscated_res_0x7f0916f8 : invokeZ.intValue;
    }

    public int i(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) ? z ? R.id.obfuscated_res_0x7f0921ce : R.id.obfuscated_res_0x7f090f81 : invokeZ.intValue;
    }

    /* loaded from: classes8.dex */
    public class a implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wb9 a;

        public a(wb9 wb9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wb9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wb9Var;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) && i == 0) {
                View childAt = absListView.getChildAt(0);
                if (this.a.b != null && childAt != null && childAt.getTop() == 0) {
                    this.a.b.a();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            NavigationBarShadowView navigationBarShadowView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) && (navigationBarShadowView = this.a.b) != null && i == 1) {
                navigationBarShadowView.c();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements s45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(wb9 wb9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wb9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.s45.e
        public void onClick(s45 s45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, s45Var) == null) {
                s45Var.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public xb9 a;

        public c(xb9 xb9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xb9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xb9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            xb9 xb9Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (xb9Var = this.a) != null) {
                xb9Var.w(Boolean.TRUE);
            }
        }
    }

    public wb9(ThreadFragment threadFragment, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {threadFragment, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.c = null;
        this.d = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.m = false;
        this.n = new a(this);
        this.a = threadFragment.getBaseFragmentActivity();
        this.b = (NavigationBarShadowView) view2.findViewById(R.id.obfuscated_res_0x7f0918e2);
        this.i = (ProgressBar) view2.findViewById(R.id.obfuscated_res_0x7f091d87);
        this.h = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091a55);
        this.f = NoDataViewFactory.a(this.a.getPageContext().getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.COLLECTION, BdUtilHelper.getDimens(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f07039b)), NoDataViewFactory.e.b(R.string.obfuscated_res_0x7f0f0c4b, R.string.obfuscated_res_0x7f0f0c4c), null);
        vb9 vb9Var = new vb9(threadFragment.getPageContext());
        this.g = vb9Var;
        vb9Var.notifyDataSetChanged();
        this.e = new q95(threadFragment.getPageContext());
        BdListView bdListView = (BdListView) view2.findViewById(R.id.obfuscated_res_0x7f091549);
        this.c = bdListView;
        bdListView.setPullRefresh(this.e);
        this.e.a(threadFragment);
        this.d = new TextView(this.a.getActivity());
        this.d.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + BdUtilHelper.getDimens(this.a.getActivity(), R.dimen.obfuscated_res_0x7f070420)));
        this.c.w(this.d, 0);
        this.c.setAdapter((ListAdapter) this.g);
        this.c.setOnSrollToBottomListener(threadFragment);
        this.c.setOnItemClickListener(threadFragment);
        this.c.setOnScrollListener(this.n);
        this.g.k(threadFragment);
        this.g.r(threadFragment);
        this.g.q(threadFragment);
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.g.l(z);
            this.g.notifyDataSetChanged();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            BdListViewHelper.c(this.d, BdListViewHelper.HeadType.DEFAULT, z);
        }
    }

    public void q(s45.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, eVar) == null) {
            this.k = eVar;
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.m = z;
        }
    }

    public void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            if (i == 0) {
                this.c.E();
                return;
            }
            this.g.p(true);
            this.g.notifyDataSetChanged();
        }
    }

    public void w(ArrayList<MarkData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, arrayList) == null) {
            this.g.j(arrayList);
        }
    }

    public void c() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (bdListView = this.c) != null) {
            bdListView.z(0L);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.i.setVisibility(8);
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.m;
        }
        return invokeV.booleanValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.g.notifyDataSetChanged();
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.f.d(this.a.getPageContext());
            this.c.removeHeaderView(this.f);
            this.c.addHeaderView(this.f);
            this.f.setVisibility(0);
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.i.setVisibility(0);
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && this.f.isShown()) {
            this.f.d(this.a.getPageContext());
        }
    }

    public void d(boolean z, String str, xb9 xb9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), str, xb9Var}) == null) {
            if (z) {
                BaseFragmentActivity baseFragmentActivity = this.a;
                baseFragmentActivity.showToast(baseFragmentActivity.getPageContext().getString(R.string.delete_success));
                if (xb9Var != null && xb9Var.n() != null) {
                    this.g.j(xb9Var.n());
                    if (xb9Var.n().size() == 0) {
                        if (this.l == null) {
                            this.l = new c(xb9Var);
                        } else {
                            SafeHandler.getInst().removeCallbacks(this.l);
                        }
                        SafeHandler.getInst().postDelayed(this.l, 600L);
                    }
                } else {
                    this.i.setVisibility(8);
                    return;
                }
            } else {
                this.a.showToast(str);
            }
            this.g.m(false);
            this.i.setVisibility(8);
        }
    }

    public void e(String str, xb9 xb9Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048580, this, str, xb9Var, z) == null) {
            this.g.p(true);
            if (str != null) {
                this.a.showToast(str);
            }
            if (xb9Var != null) {
                if (xb9Var.p() < 20) {
                    this.g.n(false);
                    this.g.m(true);
                } else {
                    this.g.n(true);
                    this.g.m(true);
                }
                this.g.j(xb9Var.n());
                p(xb9Var, z);
            }
            this.g.p(false);
            this.g.notifyDataSetChanged();
            if (k()) {
                r(false);
            }
        }
    }

    public void f(boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.a.closeLoadingDialog();
            if (str != null) {
                this.a.showToast(str);
            }
            if (z2) {
                t();
            }
            this.g.notifyDataSetChanged();
        }
    }

    public void l(MarkData markData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, markData) == null) && markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.a.getPageContext().getPageActivity()).createNormalConfig(JavaTypesHelper.toLong(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            SkinManager.setBackgroundColor(this.h, R.color.CAM_X0201);
            q95 q95Var = this.e;
            if (q95Var != null) {
                q95Var.C(i);
            }
            m();
            NoDataView noDataView = this.f;
            if (noDataView != null) {
                noDataView.f(this.a.getPageContext(), i);
                SkinManager.setBackgroundColor(this.f, R.color.CAM_X0201);
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            s45 s45Var = this.j;
            if (s45Var != null) {
                s45Var.dismiss();
                this.j = null;
            }
            ProgressBar progressBar = this.i;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            if (this.l != null) {
                SafeHandler.getInst().removeCallbacks(this.l);
            }
            vb9 vb9Var = this.g;
            if (vb9Var != null) {
                vb9Var.i();
            }
        }
    }

    public void p(xb9 xb9Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048591, this, xb9Var, z) == null) {
            if (xb9Var == null) {
                s();
            } else if (xb9Var.m() > 0) {
                this.f.setVisibility(8);
                this.c.removeHeaderView(this.f);
                this.g.notifyDataSetChanged();
            } else if (xb9Var.m() == 0 && !z) {
                s();
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (this.j == null) {
                s45 s45Var = new s45(this.a.getPageContext().getPageActivity());
                this.j = s45Var;
                s45Var.setTitle(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f15b3));
                this.j.setMessage(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e29));
                if (this.k != null) {
                    this.j.setPositiveButton(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1260), this.k);
                }
                this.j.setNegativeButton(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f04c2), new b(this));
                this.j.create(this.a.getPageContext());
                this.j.setCanceledOnTouchOutside(true);
            }
            this.j.show();
        }
    }
}
