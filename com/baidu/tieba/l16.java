package com.baidu.tieba;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
/* loaded from: classes6.dex */
public class l16 {
    public static /* synthetic */ Interceptable $ic;
    public static DateFormat y;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public WheelView b;
    public WheelView c;
    public WheelView d;
    public WheelView e;
    public WheelView f;
    public WheelView g;
    public int h;
    public boolean[] i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public float u;
    public WheelView.DividerType v;
    public boolean w;
    public b16 x;

    /* loaded from: classes6.dex */
    public class a implements p16 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l16 a;

        public a(l16 l16Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l16Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l16Var;
        }

        @Override // com.baidu.tieba.p16
        public void onItemSelected(int i) {
            int h;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                int i2 = i + this.a.j;
                this.a.c.setAdapter(new w06(f16.d(i2)));
                if (f16.g(i2) != 0 && this.a.c.getCurrentItem() > f16.g(i2) - 1) {
                    this.a.c.setCurrentItem(this.a.c.getCurrentItem() + 1);
                } else {
                    this.a.c.setCurrentItem(this.a.c.getCurrentItem());
                }
                if (f16.g(i2) != 0 && this.a.c.getCurrentItem() > f16.g(i2) - 1) {
                    if (this.a.c.getCurrentItem() == f16.g(i2) + 1) {
                        this.a.d.setAdapter(new w06(f16.b(f16.f(i2))));
                        h = f16.f(i2);
                    } else {
                        this.a.d.setAdapter(new w06(f16.b(f16.h(i2, this.a.c.getCurrentItem()))));
                        h = f16.h(i2, this.a.c.getCurrentItem());
                    }
                } else {
                    this.a.d.setAdapter(new w06(f16.b(f16.h(i2, this.a.c.getCurrentItem() + 1))));
                    h = f16.h(i2, this.a.c.getCurrentItem() + 1);
                }
                int i3 = h - 1;
                if (this.a.d.getCurrentItem() > i3) {
                    this.a.d.setCurrentItem(i3);
                }
                if (this.a.x != null) {
                    this.a.x.a();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements p16 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l16 a;

        public b(l16 l16Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l16Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l16Var;
        }

        @Override // com.baidu.tieba.p16
        public void onItemSelected(int i) {
            int h;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                int currentItem = this.a.b.getCurrentItem() + this.a.j;
                if (f16.g(currentItem) != 0 && i > f16.g(currentItem) - 1) {
                    if (this.a.c.getCurrentItem() == f16.g(currentItem) + 1) {
                        this.a.d.setAdapter(new w06(f16.b(f16.f(currentItem))));
                        h = f16.f(currentItem);
                    } else {
                        this.a.d.setAdapter(new w06(f16.b(f16.h(currentItem, i))));
                        h = f16.h(currentItem, i);
                    }
                } else {
                    int i2 = i + 1;
                    this.a.d.setAdapter(new w06(f16.b(f16.h(currentItem, i2))));
                    h = f16.h(currentItem, i2);
                }
                int i3 = h - 1;
                if (this.a.d.getCurrentItem() > i3) {
                    this.a.d.setCurrentItem(i3);
                }
                if (this.a.x != null) {
                    this.a.x.a();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements p16 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ List b;
        public final /* synthetic */ l16 c;

        public c(l16 l16Var, List list, List list2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l16Var, list, list2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = l16Var;
            this.a = list;
            this.b = list2;
        }

        @Override // com.baidu.tieba.p16
        public void onItemSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                int i2 = i + this.c.j;
                this.c.p = i2;
                int currentItem = this.c.c.getCurrentItem();
                if (this.c.j == this.c.k) {
                    this.c.c.setAdapter(new x06(this.c.l, this.c.m));
                    if (currentItem > this.c.c.getAdapter().getItemsCount() - 1) {
                        currentItem = this.c.c.getAdapter().getItemsCount() - 1;
                        this.c.c.setCurrentItem(currentItem);
                    }
                    int i3 = currentItem + this.c.l;
                    if (this.c.l == this.c.m) {
                        l16 l16Var = this.c;
                        l16Var.F(i2, i3, l16Var.n, this.c.o, this.a, this.b);
                    } else if (i3 == this.c.l) {
                        l16 l16Var2 = this.c;
                        l16Var2.F(i2, i3, l16Var2.n, 31, this.a, this.b);
                    } else if (i3 == this.c.m) {
                        l16 l16Var3 = this.c;
                        l16Var3.F(i2, i3, 1, l16Var3.o, this.a, this.b);
                    } else {
                        this.c.F(i2, i3, 1, 31, this.a, this.b);
                    }
                } else if (i2 == this.c.j) {
                    this.c.c.setAdapter(new x06(this.c.l, 12));
                    if (currentItem > this.c.c.getAdapter().getItemsCount() - 1) {
                        currentItem = this.c.c.getAdapter().getItemsCount() - 1;
                        this.c.c.setCurrentItem(currentItem);
                    }
                    int i4 = currentItem + this.c.l;
                    if (i4 == this.c.l) {
                        l16 l16Var4 = this.c;
                        l16Var4.F(i2, i4, l16Var4.n, 31, this.a, this.b);
                    } else {
                        this.c.F(i2, i4, 1, 31, this.a, this.b);
                    }
                } else if (i2 == this.c.k) {
                    this.c.c.setAdapter(new x06(1, this.c.m));
                    if (currentItem > this.c.c.getAdapter().getItemsCount() - 1) {
                        currentItem = this.c.c.getAdapter().getItemsCount() - 1;
                        this.c.c.setCurrentItem(currentItem);
                    }
                    int i5 = 1 + currentItem;
                    if (i5 == this.c.m) {
                        l16 l16Var5 = this.c;
                        l16Var5.F(i2, i5, 1, l16Var5.o, this.a, this.b);
                    } else {
                        this.c.F(i2, i5, 1, 31, this.a, this.b);
                    }
                } else {
                    this.c.c.setAdapter(new x06(1, 12));
                    l16 l16Var6 = this.c;
                    l16Var6.F(i2, 1 + l16Var6.c.getCurrentItem(), 1, 31, this.a, this.b);
                }
                if (this.c.x != null) {
                    this.c.x.a();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements p16 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ List b;
        public final /* synthetic */ l16 c;

        public d(l16 l16Var, List list, List list2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l16Var, list, list2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = l16Var;
            this.a = list;
            this.b = list2;
        }

        @Override // com.baidu.tieba.p16
        public void onItemSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                int i2 = i + 1;
                if (this.c.j == this.c.k) {
                    int i3 = (i2 + this.c.l) - 1;
                    if (this.c.l == this.c.m) {
                        l16 l16Var = this.c;
                        l16Var.F(l16Var.p, i3, this.c.n, this.c.o, this.a, this.b);
                    } else if (this.c.l == i3) {
                        l16 l16Var2 = this.c;
                        l16Var2.F(l16Var2.p, i3, this.c.n, 31, this.a, this.b);
                    } else if (this.c.m == i3) {
                        l16 l16Var3 = this.c;
                        l16Var3.F(l16Var3.p, i3, 1, this.c.o, this.a, this.b);
                    } else {
                        l16 l16Var4 = this.c;
                        l16Var4.F(l16Var4.p, i3, 1, 31, this.a, this.b);
                    }
                } else if (this.c.p == this.c.j) {
                    int i4 = (i2 + this.c.l) - 1;
                    if (i4 == this.c.l) {
                        l16 l16Var5 = this.c;
                        l16Var5.F(l16Var5.p, i4, this.c.n, 31, this.a, this.b);
                    } else {
                        l16 l16Var6 = this.c;
                        l16Var6.F(l16Var6.p, i4, 1, 31, this.a, this.b);
                    }
                } else if (this.c.p == this.c.k) {
                    if (i2 == this.c.m) {
                        l16 l16Var7 = this.c;
                        l16Var7.F(l16Var7.p, this.c.c.getCurrentItem() + 1, 1, this.c.o, this.a, this.b);
                    } else {
                        l16 l16Var8 = this.c;
                        l16Var8.F(l16Var8.p, this.c.c.getCurrentItem() + 1, 1, 31, this.a, this.b);
                    }
                } else {
                    l16 l16Var9 = this.c;
                    l16Var9.F(l16Var9.p, i2, 1, 31, this.a, this.b);
                }
                if (this.c.x != null) {
                    this.c.x.a();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements p16 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l16 a;

        public e(l16 l16Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l16Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l16Var;
        }

        @Override // com.baidu.tieba.p16
        public void onItemSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.x.a();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947890072, "Lcom/baidu/tieba/l16;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947890072, "Lcom/baidu/tieba/l16;");
                return;
            }
        }
        y = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public l16(View view2, boolean[] zArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, zArr, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = FeatureCodes.SKY_SEG;
        this.k = 2100;
        this.l = 1;
        this.m = 12;
        this.n = 1;
        this.o = 31;
        this.w = false;
        this.a = view2;
        this.i = zArr;
        this.h = i;
        this.q = i2;
        O(view2);
    }

    public void A(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048576, this, f) == null) {
            this.u = f;
            z();
        }
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.w = z;
        }
    }

    public void G(b16 b16Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, b16Var) == null) {
            this.x = b16Var;
        }
    }

    public void I(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.j = i;
        }
    }

    public void K(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.s = i;
            J();
        }
    }

    public void M(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.r = i;
            L();
        }
    }

    public void O(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view2) == null) {
            this.a = view2;
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.d.h(z);
            this.c.h(z);
            this.b.h(z);
            this.e.h(z);
            this.f.h(z);
            this.g.h(z);
        }
    }

    public final void q(WheelView wheelView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, wheelView) == null) && this.x != null) {
            wheelView.setOnItemSelectedListener(new e(this));
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.b.setCyclic(z);
            this.c.setCyclic(z);
            this.d.setCyclic(z);
            this.e.setCyclic(z);
            this.f.setCyclic(z);
            this.g.setCyclic(z);
        }
    }

    public void u(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            this.t = i;
            t();
        }
    }

    public void w(WheelView.DividerType dividerType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, dividerType) == null) {
            this.v = dividerType;
            v();
        }
    }

    public void x(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.k = i;
        }
    }

    public final void B(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            WheelView wheelView = (WheelView) this.a.findViewById(R.id.obfuscated_res_0x7f092a67);
            this.b = wheelView;
            wheelView.setAdapter(new w06(f16.e(this.j, this.k)));
            this.b.setLabel("");
            this.b.setCurrentItem(i - this.j);
            this.b.setGravity(this.h);
            WheelView wheelView2 = (WheelView) this.a.findViewById(R.id.obfuscated_res_0x7f091778);
            this.c = wheelView2;
            wheelView2.setAdapter(new w06(f16.d(i)));
            this.c.setLabel("");
            int g = f16.g(i);
            if (g != 0 && (i2 > g - 1 || z)) {
                this.c.setCurrentItem(i2 + 1);
            } else {
                this.c.setCurrentItem(i2);
            }
            this.c.setGravity(this.h);
            this.d = (WheelView) this.a.findViewById(R.id.obfuscated_res_0x7f090858);
            if (f16.g(i) == 0) {
                this.d.setAdapter(new w06(f16.b(f16.h(i, i2))));
            } else {
                this.d.setAdapter(new w06(f16.b(f16.f(i))));
            }
            this.d.setLabel("");
            this.d.setCurrentItem(i3 - 1);
            this.d.setGravity(this.h);
            WheelView wheelView3 = (WheelView) this.a.findViewById(R.id.obfuscated_res_0x7f090fd8);
            this.e = wheelView3;
            int i12 = 0;
            wheelView3.setAdapter(new x06(0, 23));
            this.e.setCurrentItem(i4);
            this.e.setGravity(this.h);
            WheelView wheelView4 = (WheelView) this.a.findViewById(R.id.obfuscated_res_0x7f091760);
            this.f = wheelView4;
            wheelView4.setAdapter(new x06(0, 59));
            this.f.setCurrentItem(i5);
            this.f.setGravity(this.h);
            WheelView wheelView5 = (WheelView) this.a.findViewById(R.id.obfuscated_res_0x7f092120);
            this.g = wheelView5;
            wheelView5.setAdapter(new x06(0, 59));
            this.g.setCurrentItem(i5);
            this.g.setGravity(this.h);
            this.b.setOnItemSelectedListener(new a(this));
            this.c.setOnItemSelectedListener(new b(this));
            q(this.d);
            q(this.e);
            q(this.f);
            q(this.g);
            boolean[] zArr = this.i;
            if (zArr.length == 6) {
                WheelView wheelView6 = this.b;
                if (zArr[0]) {
                    i7 = 0;
                } else {
                    i7 = 8;
                }
                wheelView6.setVisibility(i7);
                WheelView wheelView7 = this.c;
                if (this.i[1]) {
                    i8 = 0;
                } else {
                    i8 = 8;
                }
                wheelView7.setVisibility(i8);
                WheelView wheelView8 = this.d;
                if (this.i[2]) {
                    i9 = 0;
                } else {
                    i9 = 8;
                }
                wheelView8.setVisibility(i9);
                WheelView wheelView9 = this.e;
                if (this.i[3]) {
                    i10 = 0;
                } else {
                    i10 = 8;
                }
                wheelView9.setVisibility(i10);
                WheelView wheelView10 = this.f;
                if (this.i[4]) {
                    i11 = 0;
                } else {
                    i11 = 8;
                }
                wheelView10.setVisibility(i11);
                WheelView wheelView11 = this.g;
                if (!this.i[5]) {
                    i12 = 8;
                }
                wheelView11.setVisibility(i12);
                r();
                return;
            }
            throw new RuntimeException("type[] length is not 6");
        }
    }

    public void D(int i, int i2, int i3, int i4, int i5, int i6) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            if (this.w) {
                int[] d2 = g16.d(i, i2 + 1, i3);
                int i7 = d2[0];
                int i8 = d2[1] - 1;
                int i9 = d2[2];
                if (d2[3] == 1) {
                    z = true;
                } else {
                    z = false;
                }
                B(i7, i8, i9, z, i4, i5, i6);
                return;
            }
            H(i, i2, i3, i4, i5, i6);
        }
    }

    public void E(Calendar calendar, Calendar calendar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, calendar, calendar2) == null) {
            if (calendar == null && calendar2 != null) {
                int i = calendar2.get(1);
                int i2 = calendar2.get(2) + 1;
                int i3 = calendar2.get(5);
                int i4 = this.j;
                if (i > i4) {
                    this.k = i;
                    this.m = i2;
                    this.o = i3;
                } else if (i == i4) {
                    int i5 = this.l;
                    if (i2 > i5) {
                        this.k = i;
                        this.m = i2;
                        this.o = i3;
                    } else if (i2 == i5 && i3 > this.n) {
                        this.k = i;
                        this.m = i2;
                        this.o = i3;
                    }
                }
            } else if (calendar != null && calendar2 == null) {
                int i6 = calendar.get(1);
                int i7 = calendar.get(2) + 1;
                int i8 = calendar.get(5);
                int i9 = this.k;
                if (i6 < i9) {
                    this.l = i7;
                    this.n = i8;
                    this.j = i6;
                } else if (i6 == i9) {
                    int i10 = this.m;
                    if (i7 < i10) {
                        this.l = i7;
                        this.n = i8;
                        this.j = i6;
                    } else if (i7 == i10 && i8 < this.o) {
                        this.l = i7;
                        this.n = i8;
                        this.j = i6;
                    }
                }
            } else if (calendar != null && calendar2 != null) {
                this.j = calendar.get(1);
                this.k = calendar2.get(1);
                this.l = calendar.get(2) + 1;
                this.m = calendar2.get(2) + 1;
                this.n = calendar.get(5);
                this.o = calendar2.get(5);
            }
        }
    }

    public final void F(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), list, list2}) == null) {
            int currentItem = this.d.getCurrentItem();
            if (list.contains(String.valueOf(i2))) {
                if (i4 > 31) {
                    i4 = 31;
                }
                this.d.setAdapter(new x06(i3, i4));
            } else if (list2.contains(String.valueOf(i2))) {
                if (i4 > 30) {
                    i4 = 30;
                }
                this.d.setAdapter(new x06(i3, i4));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (i4 > 29) {
                    i4 = 29;
                }
                this.d.setAdapter(new x06(i3, i4));
            } else {
                if (i4 > 28) {
                    i4 = 28;
                }
                this.d.setAdapter(new x06(i3, i4));
            }
            if (currentItem > this.d.getAdapter().getItemsCount() - 1) {
                this.d.setCurrentItem(this.d.getAdapter().getItemsCount() - 1);
            }
        }
    }

    public final void H(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            List asList = Arrays.asList("1", "3", "5", "7", "8", "10", "12");
            List asList2 = Arrays.asList("4", "6", "9", "11");
            this.p = i;
            WheelView wheelView = (WheelView) this.a.findViewById(R.id.obfuscated_res_0x7f092a67);
            this.b = wheelView;
            wheelView.setAdapter(new x06(this.j, this.k));
            this.b.setCurrentItem(i - this.j);
            this.b.setGravity(this.h);
            WheelView wheelView2 = (WheelView) this.a.findViewById(R.id.obfuscated_res_0x7f091778);
            this.c = wheelView2;
            int i14 = this.j;
            int i15 = this.k;
            if (i14 == i15) {
                wheelView2.setAdapter(new x06(this.l, this.m));
                this.c.setCurrentItem((i2 + 1) - this.l);
            } else if (i == i14) {
                wheelView2.setAdapter(new x06(this.l, 12));
                this.c.setCurrentItem((i2 + 1) - this.l);
            } else if (i == i15) {
                wheelView2.setAdapter(new x06(1, this.m));
                this.c.setCurrentItem(i2);
            } else {
                wheelView2.setAdapter(new x06(1, 12));
                this.c.setCurrentItem(i2);
            }
            this.c.setGravity(this.h);
            this.d = (WheelView) this.a.findViewById(R.id.obfuscated_res_0x7f090858);
            if (this.j == this.k && this.l == this.m) {
                int i16 = i2 + 1;
                if (asList.contains(String.valueOf(i16))) {
                    if (this.o > 31) {
                        this.o = 31;
                    }
                    this.d.setAdapter(new x06(this.n, this.o));
                } else if (asList2.contains(String.valueOf(i16))) {
                    if (this.o > 30) {
                        this.o = 30;
                    }
                    this.d.setAdapter(new x06(this.n, this.o));
                } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                    if (this.o > 29) {
                        this.o = 29;
                    }
                    this.d.setAdapter(new x06(this.n, this.o));
                } else {
                    if (this.o > 28) {
                        this.o = 28;
                    }
                    this.d.setAdapter(new x06(this.n, this.o));
                }
                this.d.setCurrentItem(i3 - this.n);
            } else if (i == this.j && (i8 = i2 + 1) == this.l) {
                if (asList.contains(String.valueOf(i8))) {
                    this.d.setAdapter(new x06(this.n, 31));
                } else if (asList2.contains(String.valueOf(i8))) {
                    this.d.setAdapter(new x06(this.n, 30));
                } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                    this.d.setAdapter(new x06(this.n, 29));
                } else {
                    this.d.setAdapter(new x06(this.n, 28));
                }
                this.d.setCurrentItem(i3 - this.n);
            } else if (i == this.k && (i7 = i2 + 1) == this.m) {
                if (asList.contains(String.valueOf(i7))) {
                    if (this.o > 31) {
                        this.o = 31;
                    }
                    this.d.setAdapter(new x06(1, this.o));
                } else if (asList2.contains(String.valueOf(i7))) {
                    if (this.o > 30) {
                        this.o = 30;
                    }
                    this.d.setAdapter(new x06(1, this.o));
                } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                    if (this.o > 29) {
                        this.o = 29;
                    }
                    this.d.setAdapter(new x06(1, this.o));
                } else {
                    if (this.o > 28) {
                        this.o = 28;
                    }
                    this.d.setAdapter(new x06(1, this.o));
                }
                this.d.setCurrentItem(i3 - 1);
            } else {
                int i17 = i2 + 1;
                if (asList.contains(String.valueOf(i17))) {
                    this.d.setAdapter(new x06(1, 31));
                } else if (asList2.contains(String.valueOf(i17))) {
                    this.d.setAdapter(new x06(1, 30));
                } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                    this.d.setAdapter(new x06(1, 29));
                } else {
                    this.d.setAdapter(new x06(1, 28));
                }
                this.d.setCurrentItem(i3 - 1);
            }
            this.d.setGravity(this.h);
            WheelView wheelView3 = (WheelView) this.a.findViewById(R.id.obfuscated_res_0x7f090fd8);
            this.e = wheelView3;
            int i18 = 0;
            wheelView3.setAdapter(new x06(0, 23));
            this.e.setCurrentItem(i4);
            this.e.setGravity(this.h);
            WheelView wheelView4 = (WheelView) this.a.findViewById(R.id.obfuscated_res_0x7f091760);
            this.f = wheelView4;
            wheelView4.setAdapter(new x06(0, 59));
            this.f.setCurrentItem(i5);
            this.f.setGravity(this.h);
            WheelView wheelView5 = (WheelView) this.a.findViewById(R.id.obfuscated_res_0x7f092120);
            this.g = wheelView5;
            wheelView5.setAdapter(new x06(0, 59));
            this.g.setCurrentItem(i6);
            this.g.setGravity(this.h);
            this.b.setOnItemSelectedListener(new c(this, asList, asList2));
            this.c.setOnItemSelectedListener(new d(this, asList, asList2));
            q(this.d);
            q(this.e);
            q(this.f);
            q(this.g);
            boolean[] zArr = this.i;
            if (zArr.length == 6) {
                WheelView wheelView6 = this.b;
                if (zArr[0]) {
                    i9 = 0;
                } else {
                    i9 = 8;
                }
                wheelView6.setVisibility(i9);
                WheelView wheelView7 = this.c;
                if (this.i[1]) {
                    i10 = 0;
                } else {
                    i10 = 8;
                }
                wheelView7.setVisibility(i10);
                WheelView wheelView8 = this.d;
                if (this.i[2]) {
                    i11 = 0;
                } else {
                    i11 = 8;
                }
                wheelView8.setVisibility(i11);
                WheelView wheelView9 = this.e;
                if (this.i[3]) {
                    i12 = 0;
                } else {
                    i12 = 8;
                }
                wheelView9.setVisibility(i12);
                WheelView wheelView10 = this.f;
                if (this.i[4]) {
                    i13 = 0;
                } else {
                    i13 = 8;
                }
                wheelView10.setVisibility(i13);
                WheelView wheelView11 = this.g;
                if (!this.i[5]) {
                    i18 = 8;
                }
                wheelView11.setVisibility(i18);
                r();
                return;
            }
            throw new IllegalArgumentException("type[] length is not 6");
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.d.setTextColorCenter(this.s);
            this.c.setTextColorCenter(this.s);
            this.b.setTextColorCenter(this.s);
            this.e.setTextColorCenter(this.s);
            this.f.setTextColorCenter(this.s);
            this.g.setTextColorCenter(this.s);
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.d.setTextColorOut(this.r);
            this.c.setTextColorOut(this.r);
            this.b.setTextColorOut(this.r);
            this.e.setTextColorOut(this.r);
            this.f.setTextColorOut(this.r);
            this.g.setTextColorOut(this.r);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.d.setTextSize(this.q);
            this.c.setTextSize(this.q);
            this.b.setTextSize(this.q);
            this.e.setTextSize(this.q);
            this.f.setTextSize(this.q);
            this.g.setTextSize(this.q);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.d.setDividerColor(this.t);
            this.c.setDividerColor(this.t);
            this.b.setDividerColor(this.t);
            this.e.setDividerColor(this.t);
            this.f.setDividerColor(this.t);
            this.g.setDividerColor(this.t);
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.d.setDividerType(this.v);
            this.c.setDividerType(this.v);
            this.b.setDividerType(this.v);
            this.e.setDividerType(this.v);
            this.f.setDividerType(this.v);
            this.g.setDividerType(this.v);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.d.setLineSpacingMultiplier(this.u);
            this.c.setLineSpacingMultiplier(this.u);
            this.b.setLineSpacingMultiplier(this.u);
            this.e.setLineSpacingMultiplier(this.u);
            this.f.setLineSpacingMultiplier(this.u);
            this.g.setLineSpacingMultiplier(this.u);
        }
    }

    public void N(int i, int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            this.d.setTextXOffset(i);
            this.c.setTextXOffset(i2);
            this.b.setTextXOffset(i3);
            this.e.setTextXOffset(i4);
            this.f.setTextXOffset(i5);
            this.g.setTextXOffset(i6);
        }
    }

    public final String n() {
        InterceptResult invokeV;
        int currentItem;
        boolean z;
        int currentItem2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            StringBuilder sb = new StringBuilder();
            int currentItem3 = this.b.getCurrentItem() + this.j;
            if (f16.g(currentItem3) == 0) {
                currentItem2 = this.c.getCurrentItem();
            } else if ((this.c.getCurrentItem() + 1) - f16.g(currentItem3) <= 0) {
                currentItem2 = this.c.getCurrentItem();
            } else if ((this.c.getCurrentItem() + 1) - f16.g(currentItem3) == 1) {
                currentItem = this.c.getCurrentItem();
                z = true;
                int[] b2 = g16.b(currentItem3, currentItem, this.d.getCurrentItem() + 1, z);
                sb.append(b2[0]);
                sb.append("-");
                sb.append(b2[1]);
                sb.append("-");
                sb.append(b2[2]);
                sb.append(" ");
                sb.append(this.e.getCurrentItem());
                sb.append(":");
                sb.append(this.f.getCurrentItem());
                sb.append(":");
                sb.append(this.g.getCurrentItem());
                return sb.toString();
            } else {
                currentItem = this.c.getCurrentItem();
                z = false;
                int[] b22 = g16.b(currentItem3, currentItem, this.d.getCurrentItem() + 1, z);
                sb.append(b22[0]);
                sb.append("-");
                sb.append(b22[1]);
                sb.append("-");
                sb.append(b22[2]);
                sb.append(" ");
                sb.append(this.e.getCurrentItem());
                sb.append(":");
                sb.append(this.f.getCurrentItem());
                sb.append(":");
                sb.append(this.g.getCurrentItem());
                return sb.toString();
            }
            currentItem = currentItem2 + 1;
            z = false;
            int[] b222 = g16.b(currentItem3, currentItem, this.d.getCurrentItem() + 1, z);
            sb.append(b222[0]);
            sb.append("-");
            sb.append(b222[1]);
            sb.append("-");
            sb.append(b222[2]);
            sb.append(" ");
            sb.append(this.e.getCurrentItem());
            sb.append(":");
            sb.append(this.f.getCurrentItem());
            sb.append(":");
            sb.append(this.g.getCurrentItem());
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.w) {
                return n();
            }
            StringBuilder sb = new StringBuilder();
            if (this.p == this.j) {
                int currentItem = this.c.getCurrentItem();
                int i = this.l;
                if (currentItem + i == i) {
                    sb.append(this.b.getCurrentItem() + this.j);
                    sb.append("-");
                    sb.append(this.c.getCurrentItem() + this.l);
                    sb.append("-");
                    sb.append(this.d.getCurrentItem() + this.n);
                    sb.append(" ");
                    sb.append(this.e.getCurrentItem());
                    sb.append(":");
                    sb.append(this.f.getCurrentItem());
                    sb.append(":");
                    sb.append(this.g.getCurrentItem());
                } else {
                    sb.append(this.b.getCurrentItem() + this.j);
                    sb.append("-");
                    sb.append(this.c.getCurrentItem() + this.l);
                    sb.append("-");
                    sb.append(this.d.getCurrentItem() + 1);
                    sb.append(" ");
                    sb.append(this.e.getCurrentItem());
                    sb.append(":");
                    sb.append(this.f.getCurrentItem());
                    sb.append(":");
                    sb.append(this.g.getCurrentItem());
                }
            } else {
                sb.append(this.b.getCurrentItem() + this.j);
                sb.append("-");
                sb.append(this.c.getCurrentItem() + 1);
                sb.append("-");
                sb.append(this.d.getCurrentItem() + 1);
                sb.append(" ");
                sb.append(this.e.getCurrentItem());
                sb.append(":");
                sb.append(this.f.getCurrentItem());
                sb.append(":");
                sb.append(this.g.getCurrentItem());
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public void y(String str, String str2, String str3, String str4, String str5, String str6) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048602, this, new Object[]{str, str2, str3, str4, str5, str6}) != null) || this.w) {
            return;
        }
        if (str != null) {
            this.b.setLabel(str);
        } else {
            this.b.setLabel(this.a.getContext().getString(R.string.pickerview_year));
        }
        if (str2 != null) {
            this.c.setLabel(str2);
        } else {
            this.c.setLabel(this.a.getContext().getString(R.string.pickerview_month));
        }
        if (str3 != null) {
            this.d.setLabel(str3);
        } else {
            this.d.setLabel(this.a.getContext().getString(R.string.pickerview_day));
        }
        if (str4 != null) {
            this.e.setLabel(str4);
        } else {
            this.e.setLabel(this.a.getContext().getString(R.string.pickerview_hours));
        }
        if (str5 != null) {
            this.f.setLabel(str5);
        } else {
            this.f.setLabel(this.a.getContext().getString(R.string.pickerview_minutes));
        }
        if (str6 != null) {
            this.g.setLabel(str6);
        } else {
            this.g.setLabel(this.a.getContext().getString(R.string.pickerview_seconds));
        }
    }
}
