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
import com.baidu.tieba.iv4;
import com.baidu.tieba.myCollection.ThreadFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class tr7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity a;
    public NavigationBarShadowView b;
    public BdListView c;
    public View d;
    public vy4 e;
    public NoDataView f;
    public sr7 g;
    public RelativeLayout h;
    public ProgressBar i;
    public iv4 j;
    public iv4.e k;
    public c l;
    public boolean m;
    public AbsListView.OnScrollListener n;

    public int g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) ? z ? R.id.obfuscated_res_0x7f091ed6 : R.id.obfuscated_res_0x7f090dcb : invokeZ.intValue;
    }

    public int h(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) ? z ? R.id.obfuscated_res_0x7f091ed8 : R.id.obfuscated_res_0x7f0914ee : invokeZ.intValue;
    }

    public int i(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) ? z ? R.id.obfuscated_res_0x7f091ed7 : R.id.obfuscated_res_0x7f090dcd : invokeZ.intValue;
    }

    /* loaded from: classes6.dex */
    public class a implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tr7 a;

        public a(tr7 tr7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tr7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tr7Var;
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

    /* loaded from: classes6.dex */
    public class b implements iv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(tr7 tr7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tr7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.iv4.e
        public void onClick(iv4 iv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iv4Var) == null) {
                iv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ur7 a;

        public c(ur7 ur7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ur7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ur7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            ur7 ur7Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (ur7Var = this.a) != null) {
                ur7Var.w(Boolean.TRUE);
            }
        }
    }

    public tr7(ThreadFragment threadFragment, View view2) {
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
        this.b = (NavigationBarShadowView) view2.findViewById(R.id.obfuscated_res_0x7f091675);
        this.i = (ProgressBar) view2.findViewById(R.id.obfuscated_res_0x7f091afd);
        this.h = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0917c5);
        this.f = NoDataViewFactory.a(this.a.getPageContext().getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.COLLECTION, xi.g(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f07027b)), NoDataViewFactory.e.b(R.string.obfuscated_res_0x7f0f0aca, R.string.obfuscated_res_0x7f0f0acb), null);
        sr7 sr7Var = new sr7(threadFragment.getPageContext());
        this.g = sr7Var;
        sr7Var.notifyDataSetChanged();
        this.e = new vy4(threadFragment.getPageContext());
        BdListView bdListView = (BdListView) view2.findViewById(R.id.obfuscated_res_0x7f091355);
        this.c = bdListView;
        bdListView.setPullRefresh(this.e);
        this.e.f(threadFragment);
        this.d = new TextView(this.a.getActivity());
        this.d.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + xi.g(this.a.getActivity(), R.dimen.obfuscated_res_0x7f070306)));
        this.c.x(this.d, 0);
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

    public void q(iv4.e eVar) {
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
                this.c.F();
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
            bdListView.A(0L);
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

    public void d(boolean z, String str, ur7 ur7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), str, ur7Var}) == null) {
            if (z) {
                BaseFragmentActivity baseFragmentActivity = this.a;
                baseFragmentActivity.showToast(baseFragmentActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f04c8));
                if (ur7Var != null && ur7Var.n() != null) {
                    this.g.j(ur7Var.n());
                    if (ur7Var.n().size() == 0) {
                        if (this.l == null) {
                            this.l = new c(ur7Var);
                        } else {
                            zg.a().removeCallbacks(this.l);
                        }
                        zg.a().postDelayed(this.l, 600L);
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

    public void e(String str, ur7 ur7Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048580, this, str, ur7Var, z) == null) {
            this.g.p(true);
            if (str != null) {
                this.a.showToast(str);
            }
            if (ur7Var != null) {
                if (ur7Var.p() < 20) {
                    this.g.n(false);
                    this.g.m(true);
                } else {
                    this.g.n(true);
                    this.g.m(true);
                }
                this.g.j(ur7Var.n());
                p(ur7Var, z);
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
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.a.getPageContext().getPageActivity()).createNormalConfig(wg.g(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            SkinManager.setBackgroundColor(this.h, R.color.CAM_X0201);
            vy4 vy4Var = this.e;
            if (vy4Var != null) {
                vy4Var.H(i);
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
            iv4 iv4Var = this.j;
            if (iv4Var != null) {
                iv4Var.dismiss();
                this.j = null;
            }
            ProgressBar progressBar = this.i;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            if (this.l != null) {
                zg.a().removeCallbacks(this.l);
            }
            sr7 sr7Var = this.g;
            if (sr7Var != null) {
                sr7Var.i();
            }
        }
    }

    public void p(ur7 ur7Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048591, this, ur7Var, z) == null) {
            if (ur7Var == null) {
                s();
            } else if (ur7Var.m() > 0) {
                this.f.setVisibility(8);
                this.c.removeHeaderView(this.f);
                this.g.notifyDataSetChanged();
            } else if (ur7Var.m() == 0 && !z) {
                s();
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (this.j == null) {
                iv4 iv4Var = new iv4(this.a.getPageContext().getPageActivity());
                this.j = iv4Var;
                iv4Var.setTitle(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1391));
                this.j.setMessage(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c7f));
                if (this.k != null) {
                    this.j.setPositiveButton(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1059), this.k);
                }
                this.j.setNegativeButton(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f043f), new b(this));
                this.j.create(this.a.getPageContext());
                this.j.setCanceledOnTouchOutside(true);
            }
            this.j.show();
        }
    }
}
