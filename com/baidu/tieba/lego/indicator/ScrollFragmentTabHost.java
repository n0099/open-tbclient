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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.j;
import d.a.s0.n1.d;
import d.a.s0.n1.p.e;
import d.a.s0.n1.q.c;
import java.util.ArrayList;
import java.util.List;
import tbclient.Lego.DataRes;
/* loaded from: classes5.dex */
public class ScrollFragmentTabHost extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f18260e;

    /* renamed from: f  reason: collision with root package name */
    public CustomViewPager f18261f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.s0.n1.q.a f18262g;

    /* renamed from: h  reason: collision with root package name */
    public NoNetworkView f18263h;

    /* renamed from: i  reason: collision with root package name */
    public ScrollFragmentAdapter f18264i;
    public List<e> j;
    public FrameLayout k;
    public c l;
    public BdUniqueId m;
    public View.OnClickListener n;
    public c.InterfaceC1609c o;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f18265e;

        public a(ScrollFragmentTabHost scrollFragmentTabHost) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollFragmentTabHost};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18265e = scrollFragmentTabHost;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f18265e.i()) {
                    this.f18265e.e();
                } else {
                    this.f18265e.l();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements c.InterfaceC1609c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f18266a;

        public b(ScrollFragmentTabHost scrollFragmentTabHost) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollFragmentTabHost};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18266a = scrollFragmentTabHost;
        }

        @Override // d.a.s0.n1.q.c.InterfaceC1609c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f18266a.f18262g != null) {
                    this.f18266a.f18262g.d();
                }
                if (this.f18266a.l != null) {
                    this.f18266a.l.l(null);
                    this.f18266a.l = null;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new a(this);
        this.o = new b(this);
        g(context);
    }

    public void d(List<e> list, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, list, i2) == null) || list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (e eVar : list) {
            if (eVar != null) {
                arrayList.add(new d.a.s0.n1.p.c(eVar));
            }
        }
        this.j = list;
        ScrollFragmentAdapter scrollFragmentAdapter = this.f18264i;
        if (scrollFragmentAdapter != null) {
            scrollFragmentAdapter.p(arrayList);
            d.a.s0.n1.q.a aVar = this.f18262g;
            if (aVar != null) {
                aVar.i(this.f18261f, i2);
            }
        }
    }

    public void e() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (cVar = this.l) == null) {
            return;
        }
        cVar.f(this.f18260e);
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ScrollFragmentAdapter scrollFragmentAdapter = this.f18264i;
            return scrollFragmentAdapter != null && scrollFragmentAdapter.getCount() > 0;
        }
        return invokeV.booleanValue;
    }

    public final void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            this.f18260e = context;
            LayoutInflater.from(context).inflate(R.layout.lego_scroll_fragment_tabhost, (ViewGroup) this, true);
            this.f18263h = (NoNetworkView) findViewById(R.id.view_no_network);
            d.a.s0.n1.q.a aVar = new d.a.s0.n1.q.a(context, findViewById(R.id.tab_container));
            this.f18262g = aVar;
            aVar.h(this.n);
            this.k = (FrameLayout) findViewById(R.id.tab_widget_content_container);
        }
    }

    public void h(d dVar, d.a.s0.n1.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, dVar, cVar) == null) {
            this.f18261f = (CustomViewPager) findViewById(R.id.tab_widget_view_pager);
            ScrollFragmentAdapter scrollFragmentAdapter = new ScrollFragmentAdapter(this.f18260e, dVar, cVar, this.m);
            this.f18264i = scrollFragmentAdapter;
            this.f18261f.setAdapter(scrollFragmentAdapter);
        }
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c cVar = this.l;
            return cVar != null && cVar.j();
        }
        return invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? ListUtils.getCount(this.j) <= 0 : invokeV.booleanValue;
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            d.a.s0.n1.q.a aVar = this.f18262g;
            if (aVar != null) {
                aVar.g(i2);
            }
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201, i2);
            ScrollFragmentAdapter scrollFragmentAdapter = this.f18264i;
            if (scrollFragmentAdapter != null) {
                scrollFragmentAdapter.i(i2);
            }
            if (this.f18263h != null) {
                this.f18263h.c(j.a(getContext()), i2);
            }
            c cVar = this.l;
            if (cVar != null) {
                cVar.k(i2);
            }
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.l == null) {
                c cVar = new c(this.k);
                this.l = cVar;
                cVar.l(this.o);
            }
            if (this.l.j()) {
                return;
            }
            this.l.m(this.f18260e, this.j, this.f18261f.getCurrentItem());
            d.a.s0.n1.q.a aVar = this.f18262g;
            if (aVar != null) {
                aVar.j();
            }
        }
    }

    public void m(long j, String str) {
        ScrollFragmentAdapter scrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJL(1048585, this, j, str) == null) || (scrollFragmentAdapter = this.f18264i) == null) {
            return;
        }
        scrollFragmentAdapter.l(j, str);
    }

    public void n(boolean z, long j, String str, DataRes dataRes, boolean z2, int i2) {
        ScrollFragmentAdapter scrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j), str, dataRes, Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) || (scrollFragmentAdapter = this.f18264i) == null) {
            return;
        }
        scrollFragmentAdapter.o(z, j, str, dataRes, z2, i2);
    }

    public void o(long j, String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Long.valueOf(j), str, str2, Integer.valueOf(i2)}) == null) || this.f18261f == null) {
            return;
        }
        this.f18264i.m(j, str, str2, i2);
    }

    public void p(long j, String str, DataRes dataRes, boolean z) {
        ScrollFragmentAdapter scrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Long.valueOf(j), str, dataRes, Boolean.valueOf(z)}) == null) || (scrollFragmentAdapter = this.f18264i) == null) {
            return;
        }
        scrollFragmentAdapter.n(j, str, dataRes, z);
    }

    public void setCurrentTab(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || i2 < 0 || i2 >= this.f18264i.getCount()) {
            return;
        }
        this.f18261f.setCurrentItem(i2, false);
    }

    public void setFirstPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f18264i.k(i2);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bdUniqueId) == null) {
            this.m = bdUniqueId;
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
        this.n = new a(this);
        this.o = new b(this);
        g(context);
    }
}
