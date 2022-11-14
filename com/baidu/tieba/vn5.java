package com.baidu.tieba;

import android.graphics.Typeface;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class vn5<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public WheelView b;
    public WheelView c;
    public WheelView d;
    public List<T> e;
    public List<List<T>> f;
    public List<List<List<T>>> g;
    public boolean h;
    public boolean i;
    public ao5 j;
    public ao5 k;
    public nn5 l;
    public int m;
    public int n;
    public int o;
    public WheelView.DividerType p;
    public float q;

    /* loaded from: classes6.dex */
    public class a implements ao5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vn5 a;

        public a(vn5 vn5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vn5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vn5Var;
        }

        @Override // com.baidu.tieba.ao5
        public void onItemSelected(int i) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (this.a.f == null) {
                    if (this.a.l != null) {
                        this.a.l.a(this.a.b.getCurrentItem(), 0, 0);
                        return;
                    }
                    return;
                }
                if (!this.a.i) {
                    i2 = this.a.c.getCurrentItem();
                    if (i2 >= ((List) this.a.f.get(i)).size() - 1) {
                        i2 = ((List) this.a.f.get(i)).size() - 1;
                    }
                } else {
                    i2 = 0;
                }
                this.a.c.setAdapter(new gn5((List) this.a.f.get(i)));
                this.a.c.setCurrentItem(i2);
                if (this.a.g != null) {
                    this.a.k.onItemSelected(i2);
                } else if (this.a.l != null) {
                    this.a.l.a(i, i2, 0);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ao5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vn5 a;

        public b(vn5 vn5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vn5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vn5Var;
        }

        @Override // com.baidu.tieba.ao5
        public void onItemSelected(int i) {
            int currentItem;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                int i2 = 0;
                if (this.a.g != null) {
                    int currentItem2 = this.a.b.getCurrentItem();
                    if (currentItem2 >= this.a.g.size() - 1) {
                        currentItem2 = this.a.g.size() - 1;
                    }
                    if (i >= ((List) this.a.f.get(currentItem2)).size() - 1) {
                        i = ((List) this.a.f.get(currentItem2)).size() - 1;
                    }
                    if (!this.a.i) {
                        if (this.a.d.getCurrentItem() >= ((List) ((List) this.a.g.get(currentItem2)).get(i)).size() - 1) {
                            currentItem = ((List) ((List) this.a.g.get(currentItem2)).get(i)).size() - 1;
                        } else {
                            currentItem = this.a.d.getCurrentItem();
                        }
                        i2 = currentItem;
                    }
                    this.a.d.setAdapter(new gn5((List) ((List) this.a.g.get(this.a.b.getCurrentItem())).get(i)));
                    this.a.d.setCurrentItem(i2);
                    if (this.a.l != null) {
                        this.a.l.a(this.a.b.getCurrentItem(), i, i2);
                    }
                } else if (this.a.l != null) {
                    this.a.l.a(this.a.b.getCurrentItem(), i, 0);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ao5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vn5 a;

        public c(vn5 vn5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vn5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vn5Var;
        }

        @Override // com.baidu.tieba.ao5
        public void onItemSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.l.a(this.a.b.getCurrentItem(), this.a.c.getCurrentItem(), i);
            }
        }
    }

    public vn5(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = true;
        this.i = z;
        this.a = view2;
        this.b = (WheelView) view2.findViewById(R.id.obfuscated_res_0x7f091783);
        this.c = (WheelView) view2.findViewById(R.id.obfuscated_res_0x7f091784);
        this.d = (WheelView) view2.findViewById(R.id.obfuscated_res_0x7f091785);
    }

    public void B(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.m = i;
            A();
        }
    }

    public void C(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            float f = i;
            this.b.setTextSize(f);
            this.c.setTextSize(f);
            this.d.setTextSize(f);
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.b.h(z);
            this.c.h(z);
            this.d.h(z);
        }
    }

    public void m(Typeface typeface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, typeface) == null) {
            this.b.setCenterTypeface(typeface);
            this.c.setCenterTypeface(typeface);
            this.d.setCenterTypeface(typeface);
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.b.setCyclic(z);
            this.c.setCyclic(z);
            this.d.setCyclic(z);
        }
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.o = i;
            p();
        }
    }

    public void s(WheelView.DividerType dividerType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, dividerType) == null) {
            this.p = dividerType;
            r();
        }
    }

    public void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.b.setItemsVisible(i);
            this.c.setItemsVisible(i);
            this.d.setItemsVisible(i);
        }
    }

    public void v(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048592, this, f) == null) {
            this.q = f;
            u();
        }
    }

    public void w(nn5 nn5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, nn5Var) == null) {
            this.l = nn5Var;
        }
    }

    public void z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.n = i;
            y();
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b.setTextColorOut(this.m);
            this.c.setTextColorOut(this.m);
            this.d.setTextColorOut(this.m);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.b.invalidate();
            this.c.invalidate();
            this.d.invalidate();
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.b.setDividerColor(this.o);
            this.c.setDividerColor(this.o);
            this.d.setDividerColor(this.o);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.b.setDividerType(this.p);
            this.c.setDividerType(this.p);
            this.d.setDividerType(this.p);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.b.setLineSpacingMultiplier(this.q);
            this.c.setLineSpacingMultiplier(this.q);
            this.d.setLineSpacingMultiplier(this.q);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.b.setTextColorCenter(this.n);
            this.c.setTextColorCenter(this.n);
            this.d.setTextColorCenter(this.n);
        }
    }

    public int[] i() {
        InterceptResult invokeV;
        int currentItem;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int[] iArr = new int[3];
            int i = 0;
            iArr[0] = this.b.getCurrentItem();
            List<List<T>> list = this.f;
            if (list != null && list.size() > 0) {
                if (this.c.getCurrentItem() > this.f.get(iArr[0]).size() - 1) {
                    currentItem = 0;
                } else {
                    currentItem = this.c.getCurrentItem();
                }
                iArr[1] = currentItem;
            } else {
                iArr[1] = this.c.getCurrentItem();
            }
            List<List<List<T>>> list2 = this.g;
            if (list2 != null && list2.size() > 0) {
                if (this.d.getCurrentItem() <= this.g.get(iArr[0]).get(iArr[1]).size() - 1) {
                    i = this.d.getCurrentItem();
                }
                iArr[2] = i;
            } else {
                iArr[2] = this.d.getCurrentItem();
            }
            return iArr;
        }
        return (int[]) invokeV.objValue;
    }

    public final void l(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048582, this, i, i2, i3) == null) {
            if (this.e != null) {
                this.b.setCurrentItem(i);
            }
            List<List<T>> list = this.f;
            if (list != null) {
                this.c.setAdapter(new gn5(list.get(i)));
                this.c.setCurrentItem(i2);
            }
            List<List<List<T>>> list2 = this.g;
            if (list2 != null) {
                this.d.setAdapter(new gn5(list2.get(i).get(i2)));
                this.d.setCurrentItem(i3);
            }
        }
    }

    public void n(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, i3) == null) {
            if (this.h) {
                l(i, i2, i3);
                return;
            }
            this.b.setCurrentItem(i);
            this.c.setCurrentItem(i2);
            this.d.setCurrentItem(i3);
        }
    }

    public void x(List<T> list, List<List<T>> list2, List<List<List<T>>> list3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048594, this, list, list2, list3) == null) {
            this.e = list;
            this.f = list2;
            this.g = list3;
            this.b.setAdapter(new gn5(list));
            this.b.setCurrentItem(0);
            List<List<T>> list4 = this.f;
            if (list4 != null) {
                this.c.setAdapter(new gn5(list4.get(0)));
            }
            WheelView wheelView = this.c;
            wheelView.setCurrentItem(wheelView.getCurrentItem());
            List<List<List<T>>> list5 = this.g;
            if (list5 != null) {
                this.d.setAdapter(new gn5(list5.get(0).get(0)));
            }
            WheelView wheelView2 = this.d;
            wheelView2.setCurrentItem(wheelView2.getCurrentItem());
            this.b.setIsOptions(true);
            this.c.setIsOptions(true);
            this.d.setIsOptions(true);
            if (this.f == null) {
                this.c.setVisibility(8);
            } else {
                this.c.setVisibility(0);
            }
            if (this.g == null) {
                this.d.setVisibility(8);
            } else {
                this.d.setVisibility(0);
            }
            this.j = new a(this);
            this.k = new b(this);
            if (list != null && this.h) {
                this.b.setOnItemSelectedListener(this.j);
            }
            if (list2 != null && this.h) {
                this.c.setOnItemSelectedListener(this.k);
            }
            if (list3 != null && this.h && this.l != null) {
                this.d.setOnItemSelectedListener(new c(this));
            }
        }
    }
}
