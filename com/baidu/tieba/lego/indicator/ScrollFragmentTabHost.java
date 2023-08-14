package com.baidu.tieba.lego.indicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.ax8;
import com.baidu.tieba.bx8;
import com.baidu.tieba.l9;
import com.baidu.tieba.sy8;
import com.baidu.tieba.uy8;
import com.baidu.tieba.vy8;
import com.baidu.tieba.xy8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.Lego.DataRes;
/* loaded from: classes6.dex */
public class ScrollFragmentTabHost extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public CustomViewPager b;
    public vy8 c;
    public NoNetworkView d;
    public ScrollFragmentAdapter e;
    public List<uy8> f;
    public FrameLayout g;
    public xy8 h;
    public BdUniqueId i;
    public View.OnClickListener j;
    public xy8.c k;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

        public a(ScrollFragmentTabHost scrollFragmentTabHost) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollFragmentTabHost};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = scrollFragmentTabHost;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.i()) {
                    this.a.e();
                } else {
                    this.a.l();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements xy8.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

        public b(ScrollFragmentTabHost scrollFragmentTabHost) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollFragmentTabHost};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = scrollFragmentTabHost;
        }

        @Override // com.baidu.tieba.xy8.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.c != null) {
                    this.a.c.d();
                }
                if (this.a.h != null) {
                    this.a.h.l(null);
                    this.a.h = null;
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollFragmentTabHost(Context context) {
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
        this.j = new a(this);
        this.k = new b(this);
        g(context);
    }

    public final void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            this.a = context;
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d05a3, (ViewGroup) this, true);
            this.d = (NoNetworkView) findViewById(R.id.view_no_network);
            vy8 vy8Var = new vy8(context, findViewById(R.id.obfuscated_res_0x7f092344));
            this.c = vy8Var;
            vy8Var.h(this.j);
            this.g = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f09235e);
        }
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            vy8 vy8Var = this.c;
            if (vy8Var != null) {
                vy8Var.g(i);
            }
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201, i);
            ScrollFragmentAdapter scrollFragmentAdapter = this.e;
            if (scrollFragmentAdapter != null) {
                scrollFragmentAdapter.e(i);
            }
            if (this.d != null) {
                this.d.onChangeSkinType(l9.a(getContext()), i);
            }
            xy8 xy8Var = this.h;
            if (xy8Var != null) {
                xy8Var.k(i);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
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
        this.j = new a(this);
        this.k = new b(this);
        g(context);
    }

    public void d(List<uy8> list, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048576, this, list, i) == null) && list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (uy8 uy8Var : list) {
                if (uy8Var != null) {
                    arrayList.add(new sy8(uy8Var));
                }
            }
            this.f = list;
            ScrollFragmentAdapter scrollFragmentAdapter = this.e;
            if (scrollFragmentAdapter != null) {
                scrollFragmentAdapter.l(arrayList);
                vy8 vy8Var = this.c;
                if (vy8Var != null) {
                    vy8Var.i(this.b, i);
                }
            }
        }
    }

    public void setCurrentTab(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048589, this, i) == null) && i >= 0 && i < this.e.getCount()) {
            this.b.setCurrentItem(i, false);
        }
    }

    public void setFirstPosition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.e.g(i);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bdUniqueId) == null) {
            this.i = bdUniqueId;
        }
    }

    public void h(bx8 bx8Var, ax8 ax8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, bx8Var, ax8Var) == null) {
            this.b = (CustomViewPager) findViewById(R.id.obfuscated_res_0x7f092362);
            ScrollFragmentAdapter scrollFragmentAdapter = new ScrollFragmentAdapter(this.a, bx8Var, ax8Var, this.i);
            this.e = scrollFragmentAdapter;
            this.b.setAdapter(scrollFragmentAdapter);
        }
    }

    public void m(long j, String str) {
        ScrollFragmentAdapter scrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJL(1048585, this, j, str) == null) && (scrollFragmentAdapter = this.e) != null) {
            scrollFragmentAdapter.h(j, str);
        }
    }

    public void e() {
        xy8 xy8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (xy8Var = this.h) != null) {
            xy8Var.f(this.a);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ScrollFragmentAdapter scrollFragmentAdapter = this.e;
            if (scrollFragmentAdapter != null && scrollFragmentAdapter.getCount() > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            xy8 xy8Var = this.h;
            if (xy8Var != null && xy8Var.j()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (ListUtils.getCount(this.f) <= 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.h == null) {
                xy8 xy8Var = new xy8(this.g);
                this.h = xy8Var;
                xy8Var.l(this.k);
            }
            if (this.h.j()) {
                return;
            }
            this.h.m(this.a, this.f, this.b.getCurrentItem());
            vy8 vy8Var = this.c;
            if (vy8Var != null) {
                vy8Var.j();
            }
        }
    }

    public void n(boolean z, long j, String str, DataRes dataRes, boolean z2, int i) {
        ScrollFragmentAdapter scrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j), str, dataRes, Boolean.valueOf(z2), Integer.valueOf(i)}) != null) || (scrollFragmentAdapter = this.e) == null) {
            return;
        }
        scrollFragmentAdapter.k(z, j, str, dataRes, z2, i);
    }

    public void o(long j, String str, String str2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048587, this, new Object[]{Long.valueOf(j), str, str2, Integer.valueOf(i)}) != null) || this.b == null) {
            return;
        }
        this.e.i(j, str, str2, i);
    }

    public void p(long j, String str, DataRes dataRes, boolean z) {
        ScrollFragmentAdapter scrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Long.valueOf(j), str, dataRes, Boolean.valueOf(z)}) == null) && (scrollFragmentAdapter = this.e) != null) {
            scrollFragmentAdapter.j(j, str, dataRes, z);
        }
    }
}
