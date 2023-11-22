package com.baidu.tieba.newdetail.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.a5;
import com.baidu.tieba.ey4;
import com.baidu.tieba.newdetail.HotTopicDetailActivity;
import com.baidu.tieba.newdetail.view.HotTopicDetailFeedView;
import com.baidu.tieba.sy4;
import com.baidu.tieba.ui8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class HotTopicDetailPagerAdapter extends PagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public static String[] g;
    public static final int h;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<HotTopicDetailActivity> a;
    public List<HotTopicDetailFeedView> b;
    public List<ui8> c;
    public sy4 d;
    public boolean e;
    public int f;

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, viewGroup, i, obj) == null) {
        }
    }

    public final int f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? i == 1 ? 0 : 1 : invokeI.intValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view2, @NonNull Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, view2, obj)) == null) ? view2 == obj : invokeLL.booleanValue;
    }

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

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f != 1) {
                return 1;
            }
            return 0;
        }
        return invokeV.intValue;
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

    public final HotTopicDetailFeedView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return (HotTopicDetailFeedView) ListUtils.getItem(this.b, this.f % h);
        }
        return (HotTopicDetailFeedView) invokeV.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return g.length;
        }
        return invokeV.intValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.e = true;
        }
    }

    public void n() {
        HotTopicDetailFeedView e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (e = e()) != null) {
            e.k();
        }
    }

    public void p() {
        HotTopicDetailFeedView e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (e = e()) != null) {
            e.l();
        }
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
        BdPageContext<?> a = a5.a(context);
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
        ui8 ui8Var = new ui8(1);
        ui8 ui8Var2 = new ui8(0);
        this.c.add(ui8Var);
        this.c.add(ui8Var2);
    }

    public ui8 b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            return (ui8) ListUtils.getItem(this.c, f(i) % h);
        }
        return (ui8) invokeI.objValue;
    }

    public void g(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048582, this, i) == null) && this.b != null && f(i) < this.b.size() && (hotTopicDetailFeedView = this.b.get(f(i))) != null) {
            hotTopicDetailFeedView.h();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            return g[i];
        }
        return (CharSequence) invokeI.objValue;
    }

    public void h(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048585, this, i) == null) && this.b != null && f(i) < this.b.size() && (hotTopicDetailFeedView = this.b.get(f(i))) != null) {
            hotTopicDetailFeedView.g();
        }
    }

    public final void i(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048586, this, i) == null) && this.b != null && f(i) < this.b.size() && (hotTopicDetailFeedView = this.b.get(f(i))) != null) {
            hotTopicDetailFeedView.f();
        }
    }

    public void m(int i) {
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

    public void q(sy4 sy4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, sy4Var) == null) {
            this.d = sy4Var;
        }
    }

    public void r(RecyclerView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, onScrollListener) == null) {
            for (HotTopicDetailFeedView hotTopicDetailFeedView : this.b) {
                if (hotTopicDetailFeedView != null) {
                    hotTopicDetailFeedView.setScrollListener(onScrollListener);
                }
            }
        }
    }

    public void t(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048599, this, i) == null) && this.b != null && f(i) < this.b.size() && (hotTopicDetailFeedView = this.b.get(f(i))) != null) {
            hotTopicDetailFeedView.o(true);
        }
    }

    public final void x(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048601, this, i) == null) && this.b != null && f(i) < this.b.size() && (hotTopicDetailFeedView = this.b.get(f(i))) != null) {
            hotTopicDetailFeedView.n();
        }
    }

    public final void y(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048602, this, i) == null) && this.b != null && f(i) < this.b.size() && (hotTopicDetailFeedView = this.b.get(f(i))) != null) {
            hotTopicDetailFeedView.q();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: l */
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

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.c.clear();
            this.c.add(new ui8(1));
            this.c.add(new ui8(0));
            for (HotTopicDetailFeedView hotTopicDetailFeedView : this.b) {
                hotTopicDetailFeedView.setData(new ArrayList());
            }
            m(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void s(boolean z, int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && this.b != null && f(i) < this.b.size() && (hotTopicDetailFeedView = this.b.get(f(i))) != null) {
            hotTopicDetailFeedView.p(z);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048598, this, viewGroup, i, obj) == null) {
            super.setPrimaryItem(viewGroup, i, obj);
            if (!this.e || (i2 = this.f) == i) {
                return;
            }
            this.f = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
            HotTopicDetailFeedView hotTopicDetailFeedView = (HotTopicDetailFeedView) ListUtils.getItem(this.b, i2 % h);
            if (hotTopicDetailFeedView != null) {
                hotTopicDetailFeedView.k();
            }
            HotTopicDetailFeedView hotTopicDetailFeedView2 = (HotTopicDetailFeedView) ListUtils.getItem(this.b, this.f % h);
            ui8 ui8Var = (ui8) ListUtils.getItem(this.c, this.f);
            if (hotTopicDetailFeedView2 != null && ui8Var != null) {
                if (ListUtils.isEmpty(ui8Var.e)) {
                    this.a.getOrignalPage().U0(c());
                } else {
                    hotTopicDetailFeedView2.l();
                }
            }
        }
    }

    public void u(@NonNull ui8 ui8Var, boolean z, int i) {
        ui8 ui8Var2;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048600, this, new Object[]{ui8Var, Boolean.valueOf(z), Integer.valueOf(i)}) != null) || (ui8Var2 = (ui8) ListUtils.getItem(this.c, f(i) % h)) == null) {
            return;
        }
        if (z) {
            ui8Var2.e = ui8Var.e;
        } else if (!ListUtils.isEmpty(ui8Var.e)) {
            if (ui8Var2.e == null) {
                ui8Var2.e = new ArrayList();
            }
            ui8Var2.e.addAll(ui8Var.e);
        }
        ey4 ey4Var = ui8Var.b;
        ui8Var2.b = ey4Var;
        ui8Var2.c = ui8Var.c;
        if (ey4Var != null && ey4Var.b() != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            x(i);
        } else {
            i(i);
            y(i);
        }
        ((HotTopicDetailFeedView) ListUtils.getItem(this.b, f(i) % h)).setData(ui8Var2.d(this.d));
    }
}
