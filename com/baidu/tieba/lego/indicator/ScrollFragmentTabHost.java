package com.baidu.tieba.lego.indicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import b.a.e.a.j;
import b.a.r0.q1.d;
import b.a.r0.q1.p.e;
import b.a.r0.q1.q.c;
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
/* loaded from: classes9.dex */
public class ScrollFragmentTabHost extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f51227e;

    /* renamed from: f  reason: collision with root package name */
    public CustomViewPager f51228f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.r0.q1.q.a f51229g;

    /* renamed from: h  reason: collision with root package name */
    public NoNetworkView f51230h;

    /* renamed from: i  reason: collision with root package name */
    public ScrollFragmentAdapter f51231i;
    public List<e> j;
    public FrameLayout k;
    public c l;
    public BdUniqueId m;
    public View.OnClickListener n;
    public c.InterfaceC1111c o;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f51232e;

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
            this.f51232e = scrollFragmentTabHost;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f51232e.isMoreWindowShowing()) {
                    this.f51232e.dismissPopupWindow();
                } else {
                    this.f51232e.showPopupWindow();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements c.InterfaceC1111c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f51233a;

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
            this.f51233a = scrollFragmentTabHost;
        }

        @Override // b.a.r0.q1.q.c.InterfaceC1111c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f51233a.f51229g != null) {
                    this.f51233a.f51229g.d();
                }
                if (this.f51233a.l != null) {
                    this.f51233a.l.l(null);
                    this.f51233a.l = null;
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
        d(context);
    }

    public void addNewTagList(List<e> list, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, list, i2) == null) || list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (e eVar : list) {
            if (eVar != null) {
                arrayList.add(new b.a.r0.q1.p.c(eVar));
            }
        }
        this.j = list;
        ScrollFragmentAdapter scrollFragmentAdapter = this.f51231i;
        if (scrollFragmentAdapter != null) {
            scrollFragmentAdapter.updateList(arrayList);
            b.a.r0.q1.q.a aVar = this.f51229g;
            if (aVar != null) {
                aVar.i(this.f51228f, i2);
            }
        }
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.f51227e = context;
            LayoutInflater.from(context).inflate(R.layout.lego_scroll_fragment_tabhost, (ViewGroup) this, true);
            this.f51230h = (NoNetworkView) findViewById(R.id.view_no_network);
            b.a.r0.q1.q.a aVar = new b.a.r0.q1.q.a(context, findViewById(R.id.tab_container));
            this.f51229g = aVar;
            aVar.h(this.n);
            this.k = (FrameLayout) findViewById(R.id.tab_widget_content_container);
        }
    }

    public void dismissPopupWindow() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (cVar = this.l) == null) {
            return;
        }
        cVar.f(this.f51227e);
    }

    public boolean hasContentData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ScrollFragmentAdapter scrollFragmentAdapter = this.f51231i;
            return scrollFragmentAdapter != null && scrollFragmentAdapter.getCount() > 0;
        }
        return invokeV.booleanValue;
    }

    public void initViewPager(d dVar, b.a.r0.q1.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, dVar, cVar) == null) {
            this.f51228f = (CustomViewPager) findViewById(R.id.tab_widget_view_pager);
            ScrollFragmentAdapter scrollFragmentAdapter = new ScrollFragmentAdapter(this.f51227e, dVar, cVar, this.m);
            this.f51231i = scrollFragmentAdapter;
            this.f51228f.setAdapter(scrollFragmentAdapter);
        }
    }

    public boolean isMoreWindowShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c cVar = this.l;
            return cVar != null && cVar.j();
        }
        return invokeV.booleanValue;
    }

    public boolean isTagListEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? ListUtils.getCount(this.j) <= 0 : invokeV.booleanValue;
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            b.a.r0.q1.q.a aVar = this.f51229g;
            if (aVar != null) {
                aVar.g(i2);
            }
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201, i2);
            ScrollFragmentAdapter scrollFragmentAdapter = this.f51231i;
            if (scrollFragmentAdapter != null) {
                scrollFragmentAdapter.onChangeSkin(i2);
            }
            if (this.f51230h != null) {
                this.f51230h.onChangeSkinType(j.a(getContext()), i2);
            }
            c cVar = this.l;
            if (cVar != null) {
                cVar.k(i2);
            }
        }
    }

    public void setCurrentTab(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || i2 < 0 || i2 >= this.f51231i.getCount()) {
            return;
        }
        this.f51228f.setCurrentItem(i2, false);
    }

    public void setFirstPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f51231i.setFirstPosition(i2);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bdUniqueId) == null) {
            this.m = bdUniqueId;
        }
    }

    public void showPopupWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.l == null) {
                c cVar = new c(this.k);
                this.l = cVar;
                cVar.l(this.o);
            }
            if (this.l.j()) {
                return;
            }
            this.l.m(this.f51227e, this.j, this.f51228f.getCurrentItem());
            b.a.r0.q1.q.a aVar = this.f51229g;
            if (aVar != null) {
                aVar.j();
            }
        }
    }

    public void startFirstLoad(long j, String str) {
        ScrollFragmentAdapter scrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJL(1048588, this, j, str) == null) || (scrollFragmentAdapter = this.f51231i) == null) {
            return;
        }
        scrollFragmentAdapter.startFirstLoad(j, str);
    }

    public void updateData(boolean z, long j, String str, DataRes dataRes, boolean z2, int i2) {
        ScrollFragmentAdapter scrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j), str, dataRes, Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) || (scrollFragmentAdapter = this.f51231i) == null) {
            return;
        }
        scrollFragmentAdapter.updateItem(z, j, str, dataRes, z2, i2);
    }

    public void updateError(long j, String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Long.valueOf(j), str, str2, Integer.valueOf(i2)}) == null) || this.f51228f == null) {
            return;
        }
        this.f51231i.updateError(j, str, str2, i2);
    }

    public void updateHotData(long j, String str, DataRes dataRes, boolean z) {
        ScrollFragmentAdapter scrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Long.valueOf(j), str, dataRes, Boolean.valueOf(z)}) == null) || (scrollFragmentAdapter = this.f51231i) == null) {
            return;
        }
        scrollFragmentAdapter.updateHotData(j, str, dataRes, z);
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
        d(context);
    }
}
