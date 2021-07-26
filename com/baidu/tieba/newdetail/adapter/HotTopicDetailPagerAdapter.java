package com.baidu.tieba.newdetail.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.newdetail.HotTopicDetailActivity;
import com.baidu.tieba.newdetail.view.HotTopicDetailFeedView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.a.f;
import d.a.d.a.j;
import d.a.p0.s.q.a1;
import d.a.p0.s.q.p1;
import d.a.q0.g1.c.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class HotTopicDetailPagerAdapter extends PagerAdapter {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static String[] f18876g;

    /* renamed from: h  reason: collision with root package name */
    public static final int f18877h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<HotTopicDetailActivity> f18878a;

    /* renamed from: b  reason: collision with root package name */
    public List<HotTopicDetailFeedView> f18879b;

    /* renamed from: c  reason: collision with root package name */
    public List<d> f18880c;

    /* renamed from: d  reason: collision with root package name */
    public p1 f18881d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f18882e;

    /* renamed from: f  reason: collision with root package name */
    public int f18883f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-314445936, "Lcom/baidu/tieba/newdetail/adapter/HotTopicDetailPagerAdapter;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-314445936, "Lcom/baidu/tieba/newdetail/adapter/HotTopicDetailPagerAdapter;");
                return;
            }
        }
        String[] strArr = {"最热", "最新"};
        f18876g = strArr;
        f18877h = strArr.length;
    }

    public HotTopicDetailPagerAdapter(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f18882e = false;
        f<?> a2 = j.a(context);
        if (a2 instanceof TbPageContext) {
            this.f18878a = (TbPageContext) a2;
        }
        this.f18880c = new ArrayList();
        this.f18879b = new ArrayList();
        HotTopicDetailFeedView hotTopicDetailFeedView = new HotTopicDetailFeedView(context);
        hotTopicDetailFeedView.m(1);
        HotTopicDetailFeedView hotTopicDetailFeedView2 = new HotTopicDetailFeedView(context);
        hotTopicDetailFeedView2.m(0);
        this.f18879b.add(hotTopicDetailFeedView);
        this.f18879b.add(hotTopicDetailFeedView2);
        d dVar = new d(1);
        d dVar2 = new d(0);
        this.f18880c.add(dVar);
        this.f18880c.add(dVar2);
    }

    public d b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (d) ListUtils.getItem(this.f18880c, f(i2) % f18877h) : (d) invokeI.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f18883f == 1 ? 0 : 1 : invokeV.intValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            for (HotTopicDetailFeedView hotTopicDetailFeedView : this.f18879b) {
                if (hotTopicDetailFeedView != null) {
                    hotTopicDetailFeedView.e();
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, viewGroup, i2, obj) == null) {
        }
    }

    public final HotTopicDetailFeedView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (HotTopicDetailFeedView) ListUtils.getItem(this.f18879b, this.f18883f % f18877h) : (HotTopicDetailFeedView) invokeV.objValue;
    }

    public final int f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? i2 == 1 ? 0 : 1 : invokeI.intValue;
    }

    public void g(int i2) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || this.f18879b == null || f(i2) >= this.f18879b.size() || (hotTopicDetailFeedView = this.f18879b.get(f(i2))) == null) {
            return;
        }
        hotTopicDetailFeedView.h();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f18876g.length : invokeV.intValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? f18876g[i2] : (CharSequence) invokeI.objValue;
    }

    public void h(int i2) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || this.f18879b == null || f(i2) >= this.f18879b.size() || (hotTopicDetailFeedView = this.f18879b.get(f(i2))) == null) {
            return;
        }
        hotTopicDetailFeedView.g();
    }

    public final void i(int i2) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || this.f18879b == null || f(i2) >= this.f18879b.size() || (hotTopicDetailFeedView = this.f18879b.get(f(i2))) == null) {
            return;
        }
        hotTopicDetailFeedView.f();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, view, obj)) == null) ? view == obj : invokeLL.booleanValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f18882e = true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: k */
    public HotTopicDetailFeedView instantiateItem(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048590, this, viewGroup, i2)) == null) {
            HotTopicDetailFeedView hotTopicDetailFeedView = this.f18879b.get(i2 % f18876g.length);
            if (hotTopicDetailFeedView.getParent() != null) {
                viewGroup.removeView(hotTopicDetailFeedView);
            }
            viewGroup.addView(hotTopicDetailFeedView);
            return hotTopicDetailFeedView;
        }
        return (HotTopicDetailFeedView) invokeLI.objValue;
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            for (int i3 = 0; i3 < this.f18880c.size(); i3++) {
                HotTopicDetailFeedView hotTopicDetailFeedView = this.f18879b.get(i3);
                if (hotTopicDetailFeedView != null) {
                    hotTopicDetailFeedView.j(i2);
                }
            }
        }
    }

    public void m() {
        HotTopicDetailFeedView e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (e2 = e()) == null) {
            return;
        }
        e2.k();
    }

    public void n() {
        HotTopicDetailFeedView e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (e2 = e()) == null) {
            return;
        }
        e2.l();
    }

    public void o(p1 p1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, p1Var) == null) {
            this.f18881d = p1Var;
        }
    }

    public void p(RecyclerView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, onScrollListener) == null) {
            for (HotTopicDetailFeedView hotTopicDetailFeedView : this.f18879b) {
                if (hotTopicDetailFeedView != null) {
                    hotTopicDetailFeedView.setScrollListener(onScrollListener);
                }
            }
        }
    }

    public void q(boolean z, int i2) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || this.f18879b == null || f(i2) >= this.f18879b.size() || (hotTopicDetailFeedView = this.f18879b.get(f(i2))) == null) {
            return;
        }
        hotTopicDetailFeedView.p(z);
    }

    public void r(int i2) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048597, this, i2) == null) || this.f18879b == null || f(i2) >= this.f18879b.size() || (hotTopicDetailFeedView = this.f18879b.get(f(i2))) == null) {
            return;
        }
        hotTopicDetailFeedView.o(true);
    }

    public void s(@NonNull d dVar, boolean z, int i2) {
        d dVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{dVar, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || (dVar2 = (d) ListUtils.getItem(this.f18880c, f(i2) % f18877h)) == null) {
            return;
        }
        if (z) {
            dVar2.V3 = dVar.V3;
        } else if (!ListUtils.isEmpty(dVar.V3)) {
            if (dVar2.V3 == null) {
                dVar2.V3 = new ArrayList();
            }
            dVar2.V3.addAll(dVar.V3);
        }
        a1 a1Var = dVar.S3;
        dVar2.S3 = a1Var;
        dVar2.T3 = dVar.T3;
        if ((a1Var == null || a1Var.b() == 0) ? false : true) {
            t(i2);
        } else {
            i(i2);
            u(i2);
        }
        ((HotTopicDetailFeedView) ListUtils.getItem(this.f18879b, f(i2) % f18877h)).setData(dVar2.v4(this.f18881d));
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048599, this, viewGroup, i2, obj) == null) {
            super.setPrimaryItem(viewGroup, i2, obj);
            if (this.f18882e && (i3 = this.f18883f) != i2) {
                this.f18883f = i2;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                HotTopicDetailFeedView hotTopicDetailFeedView = (HotTopicDetailFeedView) ListUtils.getItem(this.f18879b, i3 % f18877h);
                if (hotTopicDetailFeedView != null) {
                    hotTopicDetailFeedView.k();
                }
                HotTopicDetailFeedView hotTopicDetailFeedView2 = (HotTopicDetailFeedView) ListUtils.getItem(this.f18879b, this.f18883f % f18877h);
                d dVar = (d) ListUtils.getItem(this.f18880c, this.f18883f);
                if (hotTopicDetailFeedView2 == null || dVar == null) {
                    return;
                }
                if (ListUtils.isEmpty(dVar.V3)) {
                    this.f18878a.getOrignalPage().refreshFeedData(c());
                } else {
                    hotTopicDetailFeedView2.l();
                }
            }
        }
    }

    public final void t(int i2) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048600, this, i2) == null) || this.f18879b == null || f(i2) >= this.f18879b.size() || (hotTopicDetailFeedView = this.f18879b.get(f(i2))) == null) {
            return;
        }
        hotTopicDetailFeedView.n();
    }

    public final void u(int i2) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048601, this, i2) == null) || this.f18879b == null || f(i2) >= this.f18879b.size() || (hotTopicDetailFeedView = this.f18879b.get(f(i2))) == null) {
            return;
        }
        hotTopicDetailFeedView.q();
    }
}
