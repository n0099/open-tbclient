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
import d.a.c.a.f;
import d.a.c.a.j;
import d.a.r0.r.q.a1;
import d.a.r0.r.q.p1;
import d.a.s0.g1.c.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class HotTopicDetailPagerAdapter extends PagerAdapter {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static String[] f18751g;

    /* renamed from: h  reason: collision with root package name */
    public static final int f18752h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<HotTopicDetailActivity> f18753a;

    /* renamed from: b  reason: collision with root package name */
    public List<HotTopicDetailFeedView> f18754b;

    /* renamed from: c  reason: collision with root package name */
    public List<d> f18755c;

    /* renamed from: d  reason: collision with root package name */
    public p1 f18756d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f18757e;

    /* renamed from: f  reason: collision with root package name */
    public int f18758f;

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
        f18751g = strArr;
        f18752h = strArr.length;
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
        this.f18757e = false;
        f<?> a2 = j.a(context);
        if (a2 instanceof TbPageContext) {
            this.f18753a = (TbPageContext) a2;
        }
        this.f18755c = new ArrayList();
        this.f18754b = new ArrayList();
        HotTopicDetailFeedView hotTopicDetailFeedView = new HotTopicDetailFeedView(context);
        hotTopicDetailFeedView.m(1);
        HotTopicDetailFeedView hotTopicDetailFeedView2 = new HotTopicDetailFeedView(context);
        hotTopicDetailFeedView2.m(0);
        this.f18754b.add(hotTopicDetailFeedView);
        this.f18754b.add(hotTopicDetailFeedView2);
        d dVar = new d(1);
        d dVar2 = new d(0);
        this.f18755c.add(dVar);
        this.f18755c.add(dVar2);
    }

    public final void A(int i2) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f18754b == null || m(i2) >= this.f18754b.size() || (hotTopicDetailFeedView = this.f18754b.get(m(i2))) == null) {
            return;
        }
        hotTopicDetailFeedView.n();
    }

    public final void B(int i2) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f18754b == null || m(i2) >= this.f18754b.size() || (hotTopicDetailFeedView = this.f18754b.get(m(i2))) == null) {
            return;
        }
        hotTopicDetailFeedView.q();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i2, obj) == null) {
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? f18751g.length : invokeV.intValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? f18751g[i2] : (CharSequence) invokeI.objValue;
    }

    public d i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? (d) ListUtils.getItem(this.f18755c, m(i2) % f18752h) : (d) invokeI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, view, obj)) == null) ? view == obj : invokeLL.booleanValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f18758f == 1 ? 0 : 1 : invokeV.intValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            for (HotTopicDetailFeedView hotTopicDetailFeedView : this.f18754b) {
                if (hotTopicDetailFeedView != null) {
                    hotTopicDetailFeedView.e();
                }
            }
        }
    }

    public final HotTopicDetailFeedView l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (HotTopicDetailFeedView) ListUtils.getItem(this.f18754b, this.f18758f % f18752h) : (HotTopicDetailFeedView) invokeV.objValue;
    }

    public final int m(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) ? i2 == 1 ? 0 : 1 : invokeI.intValue;
    }

    public void n(int i2) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || this.f18754b == null || m(i2) >= this.f18754b.size() || (hotTopicDetailFeedView = this.f18754b.get(m(i2))) == null) {
            return;
        }
        hotTopicDetailFeedView.h();
    }

    public void o(int i2) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || this.f18754b == null || m(i2) >= this.f18754b.size() || (hotTopicDetailFeedView = this.f18754b.get(m(i2))) == null) {
            return;
        }
        hotTopicDetailFeedView.g();
    }

    public final void p(int i2) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i2) == null) || this.f18754b == null || m(i2) >= this.f18754b.size() || (hotTopicDetailFeedView = this.f18754b.get(m(i2))) == null) {
            return;
        }
        hotTopicDetailFeedView.f();
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f18757e = true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: r */
    public HotTopicDetailFeedView instantiateItem(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048592, this, viewGroup, i2)) == null) {
            HotTopicDetailFeedView hotTopicDetailFeedView = this.f18754b.get(i2 % f18751g.length);
            if (hotTopicDetailFeedView.getParent() != null) {
                viewGroup.removeView(hotTopicDetailFeedView);
            }
            viewGroup.addView(hotTopicDetailFeedView);
            return hotTopicDetailFeedView;
        }
        return (HotTopicDetailFeedView) invokeLI.objValue;
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            for (int i3 = 0; i3 < this.f18755c.size(); i3++) {
                HotTopicDetailFeedView hotTopicDetailFeedView = this.f18754b.get(i3);
                if (hotTopicDetailFeedView != null) {
                    hotTopicDetailFeedView.j(i2);
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048594, this, viewGroup, i2, obj) == null) {
            super.setPrimaryItem(viewGroup, i2, obj);
            if (this.f18757e && (i3 = this.f18758f) != i2) {
                this.f18758f = i2;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                HotTopicDetailFeedView hotTopicDetailFeedView = (HotTopicDetailFeedView) ListUtils.getItem(this.f18754b, i3 % f18752h);
                if (hotTopicDetailFeedView != null) {
                    hotTopicDetailFeedView.k();
                }
                HotTopicDetailFeedView hotTopicDetailFeedView2 = (HotTopicDetailFeedView) ListUtils.getItem(this.f18754b, this.f18758f % f18752h);
                d dVar = (d) ListUtils.getItem(this.f18755c, this.f18758f);
                if (hotTopicDetailFeedView2 == null || dVar == null) {
                    return;
                }
                if (ListUtils.isEmpty(dVar.P3)) {
                    this.f18753a.getOrignalPage().refreshFeedData(j());
                } else {
                    hotTopicDetailFeedView2.l();
                }
            }
        }
    }

    public void t() {
        HotTopicDetailFeedView l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (l = l()) == null) {
            return;
        }
        l.k();
    }

    public void u() {
        HotTopicDetailFeedView l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (l = l()) == null) {
            return;
        }
        l.l();
    }

    public void v(p1 p1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, p1Var) == null) {
            this.f18756d = p1Var;
        }
    }

    public void w(RecyclerView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, onScrollListener) == null) {
            for (HotTopicDetailFeedView hotTopicDetailFeedView : this.f18754b) {
                if (hotTopicDetailFeedView != null) {
                    hotTopicDetailFeedView.setScrollListener(onScrollListener);
                }
            }
        }
    }

    public void x(boolean z, int i2) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || this.f18754b == null || m(i2) >= this.f18754b.size() || (hotTopicDetailFeedView = this.f18754b.get(m(i2))) == null) {
            return;
        }
        hotTopicDetailFeedView.p(z);
    }

    public void y(int i2) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048600, this, i2) == null) || this.f18754b == null || m(i2) >= this.f18754b.size() || (hotTopicDetailFeedView = this.f18754b.get(m(i2))) == null) {
            return;
        }
        hotTopicDetailFeedView.o(true);
    }

    public void z(@NonNull d dVar, boolean z, int i2) {
        d dVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{dVar, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || (dVar2 = (d) ListUtils.getItem(this.f18755c, m(i2) % f18752h)) == null) {
            return;
        }
        if (z) {
            dVar2.P3 = dVar.P3;
        } else if (!ListUtils.isEmpty(dVar.P3)) {
            if (dVar2.P3 == null) {
                dVar2.P3 = new ArrayList();
            }
            dVar2.P3.addAll(dVar.P3);
        }
        a1 a1Var = dVar.M3;
        dVar2.M3 = a1Var;
        dVar2.N3 = dVar.N3;
        if ((a1Var == null || a1Var.b() == 0) ? false : true) {
            A(i2);
        } else {
            p(i2);
            B(i2);
        }
        ((HotTopicDetailFeedView) ListUtils.getItem(this.f18754b, m(i2) % f18752h)).setData(dVar2.s4(this.f18756d));
    }
}
