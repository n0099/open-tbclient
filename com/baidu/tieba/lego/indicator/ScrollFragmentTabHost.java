package com.baidu.tieba.lego.indicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.j;
import c.a.p0.b2.d;
import c.a.p0.b2.p.e;
import c.a.p0.b2.q.c;
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
import java.util.ArrayList;
import java.util.List;
import tbclient.Lego.DataRes;
/* loaded from: classes5.dex */
public class ScrollFragmentTabHost extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public CustomViewPager f34282b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.b2.q.a f34283c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f34284d;

    /* renamed from: e  reason: collision with root package name */
    public ScrollFragmentAdapter f34285e;

    /* renamed from: f  reason: collision with root package name */
    public List<e> f34286f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f34287g;

    /* renamed from: h  reason: collision with root package name */
    public c f34288h;
    public BdUniqueId i;
    public View.OnClickListener j;
    public c.InterfaceC0947c k;

    /* loaded from: classes5.dex */
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.a.i()) {
                    this.a.e();
                } else {
                    this.a.l();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements c.InterfaceC0947c {
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

        @Override // c.a.p0.b2.q.c.InterfaceC0947c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.f34283c != null) {
                    this.a.f34283c.d();
                }
                if (this.a.f34288h != null) {
                    this.a.f34288h.l(null);
                    this.a.f34288h = null;
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

    public void d(List<e> list, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, list, i) == null) || list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (e eVar : list) {
            if (eVar != null) {
                arrayList.add(new c.a.p0.b2.p.c(eVar));
            }
        }
        this.f34286f = list;
        ScrollFragmentAdapter scrollFragmentAdapter = this.f34285e;
        if (scrollFragmentAdapter != null) {
            scrollFragmentAdapter.l(arrayList);
            c.a.p0.b2.q.a aVar = this.f34283c;
            if (aVar != null) {
                aVar.i(this.f34282b, i);
            }
        }
    }

    public void e() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (cVar = this.f34288h) == null) {
            return;
        }
        cVar.f(this.a);
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ScrollFragmentAdapter scrollFragmentAdapter = this.f34285e;
            return scrollFragmentAdapter != null && scrollFragmentAdapter.getCount() > 0;
        }
        return invokeV.booleanValue;
    }

    public final void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            this.a = context;
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d04f6, (ViewGroup) this, true);
            this.f34284d = (NoNetworkView) findViewById(R.id.obfuscated_res_0x7f0923d1);
            c.a.p0.b2.q.a aVar = new c.a.p0.b2.q.a(context, findViewById(R.id.obfuscated_res_0x7f091e39));
            this.f34283c = aVar;
            aVar.h(this.j);
            this.f34287g = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f091e52);
        }
    }

    public void h(d dVar, c.a.p0.b2.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, dVar, cVar) == null) {
            this.f34282b = (CustomViewPager) findViewById(R.id.obfuscated_res_0x7f091e56);
            ScrollFragmentAdapter scrollFragmentAdapter = new ScrollFragmentAdapter(this.a, dVar, cVar, this.i);
            this.f34285e = scrollFragmentAdapter;
            this.f34282b.setAdapter(scrollFragmentAdapter);
        }
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c cVar = this.f34288h;
            return cVar != null && cVar.j();
        }
        return invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? ListUtils.getCount(this.f34286f) <= 0 : invokeV.booleanValue;
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            c.a.p0.b2.q.a aVar = this.f34283c;
            if (aVar != null) {
                aVar.g(i);
            }
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201, i);
            ScrollFragmentAdapter scrollFragmentAdapter = this.f34285e;
            if (scrollFragmentAdapter != null) {
                scrollFragmentAdapter.e(i);
            }
            if (this.f34284d != null) {
                this.f34284d.c(j.a(getContext()), i);
            }
            c cVar = this.f34288h;
            if (cVar != null) {
                cVar.k(i);
            }
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.f34288h == null) {
                c cVar = new c(this.f34287g);
                this.f34288h = cVar;
                cVar.l(this.k);
            }
            if (this.f34288h.j()) {
                return;
            }
            this.f34288h.m(this.a, this.f34286f, this.f34282b.getCurrentItem());
            c.a.p0.b2.q.a aVar = this.f34283c;
            if (aVar != null) {
                aVar.j();
            }
        }
    }

    public void m(long j, String str) {
        ScrollFragmentAdapter scrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJL(1048585, this, j, str) == null) || (scrollFragmentAdapter = this.f34285e) == null) {
            return;
        }
        scrollFragmentAdapter.h(j, str);
    }

    public void n(boolean z, long j, String str, DataRes dataRes, boolean z2, int i) {
        ScrollFragmentAdapter scrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j), str, dataRes, Boolean.valueOf(z2), Integer.valueOf(i)}) == null) || (scrollFragmentAdapter = this.f34285e) == null) {
            return;
        }
        scrollFragmentAdapter.k(z, j, str, dataRes, z2, i);
    }

    public void o(long j, String str, String str2, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Long.valueOf(j), str, str2, Integer.valueOf(i)}) == null) || this.f34282b == null) {
            return;
        }
        this.f34285e.i(j, str, str2, i);
    }

    public void p(long j, String str, DataRes dataRes, boolean z) {
        ScrollFragmentAdapter scrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Long.valueOf(j), str, dataRes, Boolean.valueOf(z)}) == null) || (scrollFragmentAdapter = this.f34285e) == null) {
            return;
        }
        scrollFragmentAdapter.j(j, str, dataRes, z);
    }

    public void setCurrentTab(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i) == null) || i < 0 || i >= this.f34285e.getCount()) {
            return;
        }
        this.f34282b.setCurrentItem(i, false);
    }

    public void setFirstPosition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.f34285e.g(i);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bdUniqueId) == null) {
            this.i = bdUniqueId;
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
}
