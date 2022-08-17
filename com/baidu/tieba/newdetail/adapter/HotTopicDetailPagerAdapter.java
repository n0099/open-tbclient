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
import com.baidu.tbadk.core.TbadkCoreApplication;
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
import com.repackage.d9;
import com.repackage.gq4;
import com.repackage.h9;
import com.repackage.u47;
import com.repackage.vq4;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class HotTopicDetailPagerAdapter extends PagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public static String[] g;
    public static final int h;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<HotTopicDetailActivity> a;
    public List<HotTopicDetailFeedView> b;
    public List<u47> c;
    public vq4 d;
    public boolean e;
    public int f;

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
        g = strArr;
        h = strArr.length;
    }

    public HotTopicDetailPagerAdapter(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = false;
        d9<?> a = h9.a(context);
        if (a instanceof TbPageContext) {
            this.a = (TbPageContext) a;
        }
        this.c = new ArrayList();
        this.b = new ArrayList();
        HotTopicDetailFeedView hotTopicDetailFeedView = new HotTopicDetailFeedView(context);
        hotTopicDetailFeedView.m(1);
        HotTopicDetailFeedView hotTopicDetailFeedView2 = new HotTopicDetailFeedView(context);
        hotTopicDetailFeedView2.m(0);
        this.b.add(hotTopicDetailFeedView);
        this.b.add(hotTopicDetailFeedView2);
        u47 u47Var = new u47(1);
        u47 u47Var2 = new u47(0);
        this.c.add(u47Var);
        this.c.add(u47Var2);
    }

    public u47 b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? (u47) ListUtils.getItem(this.c, f(i) % h) : (u47) invokeI.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f == 1 ? 0 : 1 : invokeV.intValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            for (HotTopicDetailFeedView hotTopicDetailFeedView : this.b) {
                if (hotTopicDetailFeedView != null) {
                    hotTopicDetailFeedView.e();
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, viewGroup, i, obj) == null) {
        }
    }

    public final HotTopicDetailFeedView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (HotTopicDetailFeedView) ListUtils.getItem(this.b, this.f % h) : (HotTopicDetailFeedView) invokeV.objValue;
    }

    public final int f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? i == 1 ? 0 : 1 : invokeI.intValue;
    }

    public void g(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i) == null) || this.b == null || f(i) >= this.b.size() || (hotTopicDetailFeedView = this.b.get(f(i))) == null) {
            return;
        }
        hotTopicDetailFeedView.h();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? g.length : invokeV.intValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) ? g[i] : (CharSequence) invokeI.objValue;
    }

    public void h(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i) == null) || this.b == null || f(i) >= this.b.size() || (hotTopicDetailFeedView = this.b.get(f(i))) == null) {
            return;
        }
        hotTopicDetailFeedView.g();
    }

    public final void i(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i) == null) || this.b == null || f(i) >= this.b.size() || (hotTopicDetailFeedView = this.b.get(f(i))) == null) {
            return;
        }
        hotTopicDetailFeedView.f();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view2, @NonNull Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, view2, obj)) == null) ? view2 == obj : invokeLL.booleanValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.e = true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: k */
    public HotTopicDetailFeedView instantiateItem(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048590, this, viewGroup, i)) == null) {
            HotTopicDetailFeedView hotTopicDetailFeedView = this.b.get(i % g.length);
            if (hotTopicDetailFeedView.getParent() != null) {
                viewGroup.removeView(hotTopicDetailFeedView);
            }
            viewGroup.addView(hotTopicDetailFeedView);
            return hotTopicDetailFeedView;
        }
        return (HotTopicDetailFeedView) invokeLI.objValue;
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            for (int i2 = 0; i2 < this.c.size(); i2++) {
                HotTopicDetailFeedView hotTopicDetailFeedView = this.b.get(i2);
                if (hotTopicDetailFeedView != null) {
                    hotTopicDetailFeedView.j(i);
                }
            }
        }
    }

    public void m() {
        HotTopicDetailFeedView e;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (e = e()) == null) {
            return;
        }
        e.k();
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.c.clear();
            this.c.add(new u47(1));
            this.c.add(new u47(0));
            for (HotTopicDetailFeedView hotTopicDetailFeedView : this.b) {
                hotTopicDetailFeedView.setData(new ArrayList());
            }
            l(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void o() {
        HotTopicDetailFeedView e;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (e = e()) == null) {
            return;
        }
        e.l();
    }

    public void p(vq4 vq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, vq4Var) == null) {
            this.d = vq4Var;
        }
    }

    public void q(RecyclerView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, onScrollListener) == null) {
            for (HotTopicDetailFeedView hotTopicDetailFeedView : this.b) {
                if (hotTopicDetailFeedView != null) {
                    hotTopicDetailFeedView.setScrollListener(onScrollListener);
                }
            }
        }
    }

    public void r(boolean z, int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) || this.b == null || f(i) >= this.b.size() || (hotTopicDetailFeedView = this.b.get(f(i))) == null) {
            return;
        }
        hotTopicDetailFeedView.p(z);
    }

    public void s(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048598, this, i) == null) || this.b == null || f(i) >= this.b.size() || (hotTopicDetailFeedView = this.b.get(f(i))) == null) {
            return;
        }
        hotTopicDetailFeedView.o(true);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048599, this, viewGroup, i, obj) == null) {
            super.setPrimaryItem(viewGroup, i, obj);
            if (this.e && (i2 = this.f) != i) {
                this.f = i;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                HotTopicDetailFeedView hotTopicDetailFeedView = (HotTopicDetailFeedView) ListUtils.getItem(this.b, i2 % h);
                if (hotTopicDetailFeedView != null) {
                    hotTopicDetailFeedView.k();
                }
                HotTopicDetailFeedView hotTopicDetailFeedView2 = (HotTopicDetailFeedView) ListUtils.getItem(this.b, this.f % h);
                u47 u47Var = (u47) ListUtils.getItem(this.c, this.f);
                if (hotTopicDetailFeedView2 == null || u47Var == null) {
                    return;
                }
                if (ListUtils.isEmpty(u47Var.e)) {
                    this.a.getOrignalPage().H1(c());
                } else {
                    hotTopicDetailFeedView2.l();
                }
            }
        }
    }

    public void t(@NonNull u47 u47Var, boolean z, int i) {
        u47 u47Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{u47Var, Boolean.valueOf(z), Integer.valueOf(i)}) == null) || (u47Var2 = (u47) ListUtils.getItem(this.c, f(i) % h)) == null) {
            return;
        }
        if (z) {
            u47Var2.e = u47Var.e;
        } else if (!ListUtils.isEmpty(u47Var.e)) {
            if (u47Var2.e == null) {
                u47Var2.e = new ArrayList();
            }
            u47Var2.e.addAll(u47Var.e);
        }
        gq4 gq4Var = u47Var.b;
        u47Var2.b = gq4Var;
        u47Var2.c = u47Var.c;
        if ((gq4Var == null || gq4Var.b() == 0) ? false : true) {
            u(i);
        } else {
            i(i);
            v(i);
        }
        ((HotTopicDetailFeedView) ListUtils.getItem(this.b, f(i) % h)).setData(u47Var2.f(this.d));
    }

    public final void u(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048601, this, i) == null) || this.b == null || f(i) >= this.b.size() || (hotTopicDetailFeedView = this.b.get(f(i))) == null) {
            return;
        }
        hotTopicDetailFeedView.n();
    }

    public final void v(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048602, this, i) == null) || this.b == null || f(i) >= this.b.size() || (hotTopicDetailFeedView = this.b.get(f(i))) == null) {
            return;
        }
        hotTopicDetailFeedView.q();
    }
}
