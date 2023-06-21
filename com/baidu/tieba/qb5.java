package com.baidu.tieba;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class qb5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewPager a;
    public IndicatorView b;
    public TextView c;
    public BdBaseViewPagerAdapter d;
    public sb5 e;
    public boolean f;
    public boolean g;
    public int h;
    public Context i;
    public List<wn> j;
    public ViewPager.OnPageChangeListener k;
    public long l;
    public final Handler.Callback m;
    public final Handler n;
    public ViewPager.OnPageChangeListener o;

    /* loaded from: classes7.dex */
    public class a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qb5 a;

        public a(qb5 qb5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qb5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qb5Var;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what != 1) {
                    return false;
                }
                this.a.g();
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qb5 a;

        public b(qb5 qb5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qb5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qb5Var;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            int count;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (this.a.k != null) {
                    this.a.k.onPageScrollStateChanged(i);
                }
                if (i == 1) {
                    this.a.n();
                } else if (i != 0 || (count = this.a.d.getCount()) < 2) {
                } else {
                    int currentItem = this.a.a.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        this.a.a.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        this.a.a.setCurrentItem(1, false);
                    }
                    this.a.m();
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && this.a.e != null && this.a.e.a(i) == i) {
                if (this.a.b != null) {
                    this.a.b.setPosition(this.a.e.c(i));
                }
                if (this.a.k != null) {
                    this.a.k.onPageSelected(this.a.e.c(i));
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) && this.a.k != null) {
                this.a.k.onPageScrolled(i, f, i2);
            }
        }
    }

    public qb5(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, viewPager, indicatorView, textView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = false;
        this.g = true;
        this.h = 2;
        this.j = new ArrayList();
        this.l = 5000L;
        this.m = new a(this);
        this.n = new Handler(this.m);
        this.o = new b(this);
        h(context, viewPager, indicatorView, textView);
    }

    public void j(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            if (j < 0) {
                j = 0;
            }
            this.l = j;
        }
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.h = i;
            sb5 sb5Var = this.e;
            if (sb5Var != null) {
                sb5Var.h(i);
            }
        }
    }

    public final void g() {
        int count;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a != null && this.d != null) {
            p9 c = q9.c(this.i);
            if ((c != null && c.isScroll()) || (count = this.d.getCount()) < 2) {
                return;
            }
            int currentItem = this.a.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.a.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.a.setCurrentItem(1, false);
            } else {
                this.a.setCurrentItem(currentItem + 1);
            }
        }
    }

    public final void h(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, viewPager, indicatorView, textView) == null) {
            this.a = viewPager;
            this.b = indicatorView;
            this.c = textView;
            this.i = context;
            BdBaseViewPagerAdapter bdBaseViewPagerAdapter = new BdBaseViewPagerAdapter(context);
            this.d = bdBaseViewPagerAdapter;
            ViewPager viewPager2 = this.a;
            if (viewPager2 != null) {
                viewPager2.setAdapter(bdBaseViewPagerAdapter);
                this.a.setOnPageChangeListener(this.o);
            }
        }
    }

    public void i(Context context, rb5<?, ?> rb5Var) {
        BdBaseViewPagerAdapter bdBaseViewPagerAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, rb5Var) == null) && (bdBaseViewPagerAdapter = this.d) != null) {
            bdBaseViewPagerAdapter.g(context, rb5Var);
        }
    }

    public void k(List<wn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, list) != null) || ListUtils.getCount(list) == 0) {
            return;
        }
        this.j = list;
        sb5 sb5Var = new sb5(list, this.f, this.h);
        this.e = sb5Var;
        sb5Var.i(2);
        this.e.g(1);
        this.d.h(this.e.e());
        this.d.notifyDataSetChanged();
        this.a.setCurrentItem(this.e.d(), false);
        if (this.e.b() <= 0) {
            return;
        }
        if (this.e.b() > this.h) {
            TextView textView = this.c;
            if (textView != null) {
                textView.setVisibility(0);
                this.c.setOnClickListener(null);
                IndicatorView indicatorView = this.b;
                if (indicatorView != null) {
                    indicatorView.setVisibility(8);
                }
            } else {
                IndicatorView indicatorView2 = this.b;
                if (indicatorView2 != null && !this.f) {
                    indicatorView2.setVisibility(8);
                }
            }
            IndicatorView indicatorView3 = this.b;
            if (indicatorView3 != null && indicatorView3.getVisibility() == 0) {
                int count = this.b.getCount();
                int i = this.h;
                if (count != i) {
                    this.b.setCount(i);
                }
            }
            m();
        }
        if (this.e.b() >= 2 && this.e.b() <= this.h) {
            TextView textView2 = this.c;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            IndicatorView indicatorView4 = this.b;
            if (indicatorView4 != null) {
                indicatorView4.setVisibility(0);
                if (this.b.getCount() != this.e.b()) {
                    this.b.setCount(this.e.b());
                }
            }
            m();
        }
        if (this.e.b() < 2) {
            TextView textView3 = this.c;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            IndicatorView indicatorView5 = this.b;
            if (indicatorView5 != null) {
                indicatorView5.setVisibility(8);
            }
            n();
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.g) {
                this.n.removeMessages(1);
                this.n.sendEmptyMessageDelayed(1, this.l);
                return;
            }
            this.n.removeMessages(1);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.n.removeMessages(1);
        }
    }
}
