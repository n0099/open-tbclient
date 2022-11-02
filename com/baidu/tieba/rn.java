package com.baidu.tieba;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class rn {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RecyclerView a;
    public sn b;
    public int c;
    public SparseIntArray d;
    public int e;
    public float f;
    public float g;
    public boolean h;
    public SparseArray<ValueAnimator> i;
    public SparseIntArray j;

    /* loaded from: classes5.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ rn b;

        public a(rn rnVar, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rnVar, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rnVar;
            this.a = view2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.b.n(this.a, ((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ View b;
        public final /* synthetic */ rn c;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }

        public b(rn rnVar, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rnVar, Integer.valueOf(i), view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = rnVar;
            this.a = i;
            this.b = view2;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.c.i.delete(this.a);
                this.c.j.delete(this.a);
                this.c.n(this.b, 0.0f);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.c.i.delete(this.a);
                this.c.j.delete(this.a);
                this.c.d.delete(this.a);
                this.c.n(this.b, 0.0f);
            }
        }
    }

    public rn(sn snVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {snVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = false;
        this.b = snVar;
        this.d = new SparseIntArray();
        this.i = new SparseArray<>();
        this.j = new SparseIntArray();
    }

    public final float f(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            if (view2 == null) {
                return 0.0f;
            }
            if (this.c == 2) {
                return view2.getTranslationY();
            }
            return view2.getTranslationX();
        }
        return invokeL.floatValue;
    }

    public void e(RecyclerView recyclerView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
            this.a = recyclerView;
            this.c = i;
        }
    }

    public final void n(View view2, float f) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLF(1048585, this, view2, f) != null) || view2 == null) {
            return;
        }
        if (this.c == 2) {
            view2.setTranslationY(f);
        } else {
            view2.setTranslationX(f);
        }
    }

    public void g(View view2) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) != null) || (recyclerView = this.a) == null || this.e == 0) {
            return;
        }
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view2);
        RecyclerView.LayoutManager layoutManager = this.a.getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager)) {
            return;
        }
        float f = 0.0f;
        if (childAdapterPosition <= ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition()) {
            float f2 = -this.d.get(childAdapterPosition, 0);
            if (f2 != 0.0f) {
                this.f = f2;
            } else {
                f2 = this.f;
            }
            if (this.a.getChildAt(1) != null) {
                f = f(this.a.getChildAt(1));
            }
            n(view2, f2 + f);
        } else {
            float f3 = -this.d.get(childAdapterPosition, 0);
            if (f3 != 0.0f) {
                this.g = f3;
            } else {
                f3 = this.g;
            }
            if (this.a.getChildAt(recyclerView2.getChildCount() - 2) != null) {
                f = f(this.a.getChildAt(recyclerView3.getChildCount() - 2));
            }
            n(view2, f3 + f);
        }
        j(view2, childAdapterPosition);
    }

    public void h(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, view2) != null) || this.a == null) {
            return;
        }
        n(view2, 0.0f);
        int childAdapterPosition = this.a.getChildAdapterPosition(view2);
        this.d.delete(childAdapterPosition);
        if (this.i.get(childAdapterPosition) != null) {
            this.i.get(childAdapterPosition).cancel();
        }
        this.i.delete(childAdapterPosition);
        this.j.delete(childAdapterPosition);
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) != null) || this.a == null) {
            return;
        }
        this.e = i;
        if (i == 0) {
            this.d.clear();
            k();
        } else if (i == 2) {
            k();
        } else if (i == 1) {
            this.d.clear();
            k();
        }
    }

    public final void i(View view2, float f, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048580, this, new Object[]{view2, Float.valueOf(f), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) != null) || view2 == null) {
            return;
        }
        if (f < 0.0f) {
            if (i < i2) {
                float f2 = f(view2) + (f * this.b.l());
                if (f2 > (-this.d.get(i)) + f(this.a.getChildAt(i3 + 1))) {
                    n(view2, f2);
                } else {
                    j(view2, i);
                }
            } else if (i > i2) {
                float f3 = f(view2) + (f * this.b.e());
                if (f3 > (-this.d.get(i)) + f(this.a.getChildAt(i3 - 1))) {
                    n(view2, f3);
                } else {
                    j(view2, i);
                }
            }
        } else if (i > i2) {
            float f4 = f(view2) + (f * this.b.l());
            if (f4 < (-this.d.get(i)) + f(this.a.getChildAt(i3 - 1))) {
                n(view2, f4);
            } else {
                j(view2, i);
            }
        } else if (i < i2) {
            float f5 = f(view2) + (f * this.b.e());
            if (f5 < (-this.d.get(i)) + f(this.a.getChildAt(i3 + 1))) {
                n(view2, f5);
            } else {
                j(view2, i);
            }
        }
    }

    public final void j(View view2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048581, this, view2, i) != null) || view2 == null) {
            return;
        }
        ValueAnimator valueAnimator = this.i.get(i);
        if (valueAnimator == null) {
            if (Math.abs(f(view2)) < 0.1f) {
                n(view2, 0.0f);
                return;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(f(view2), 0.0f);
            ofFloat.setInterpolator(new tn(1.0f));
            ofFloat.setDuration(this.b.a());
            ofFloat.addUpdateListener(new a(this, view2));
            ofFloat.addListener(new b(this, i, view2));
            this.i.append(i, ofFloat);
            this.j.append(i, (int) f(view2));
            ofFloat.start();
            return;
        }
        if (!valueAnimator.isRunning()) {
            valueAnimator.start();
        }
        float f = f(view2);
        if (Math.abs(f) > Math.abs(this.j.get(i)) + this.b.b()) {
            this.j.append(i, (int) f);
            valueAnimator.setFloatValues(f, 0.0f);
            valueAnimator.cancel();
            valueAnimator.start();
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int childCount = this.a.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.a.getChildAt(i);
                j(childAt, this.a.getChildAdapterPosition(childAt));
            }
        }
    }

    public void l(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIII(1048583, this, i, i2, i3) == null) && this.a != null && this.e == 1 && !this.h) {
            if (this.c == 2) {
                i = i2;
            }
            int childCount = this.a.getChildCount();
            if (!(this.a.getLayoutManager() instanceof LinearLayoutManager)) {
                return;
            }
            int findFirstVisibleItemPosition = i3 - ((LinearLayoutManager) this.a.getLayoutManager()).findFirstVisibleItemPosition();
            for (int i4 = findFirstVisibleItemPosition - 1; i4 >= 0; i4--) {
                View childAt = this.a.getChildAt(i4);
                int childAdapterPosition = this.a.getChildAdapterPosition(childAt);
                if (childAdapterPosition != -1) {
                    i(childAt, i, childAdapterPosition, i3, i4);
                }
            }
            for (int i5 = findFirstVisibleItemPosition + 1; i5 <= childCount - 1; i5++) {
                View childAt2 = this.a.getChildAt(i5);
                int childAdapterPosition2 = this.a.getChildAdapterPosition(childAt2);
                if (childAdapterPosition2 != -1) {
                    i(childAt2, i, childAdapterPosition2, i3, i5);
                }
            }
        }
    }

    public void o(float f, float f2, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048586, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i)}) != null) || this.a == null) {
            return;
        }
        if (this.c == 2) {
            f = f2;
        }
        int i3 = 1;
        if (Math.abs(f) < this.b.i()) {
            this.h = true;
            k();
            return;
        }
        this.h = false;
        if (Math.abs(f) > this.b.h()) {
            if (f > 0.0f) {
                i2 = this.b.h();
            } else {
                i2 = -this.b.h();
            }
            f = i2;
        }
        this.d.clear();
        float f3 = this.b.f() * f;
        if (f < 0.0f) {
            float g = this.b.g();
            int i4 = 1;
            while (true) {
                int i5 = i - i4;
                float f4 = (i4 * g) + f3;
                g *= 1.4f;
                if (f4 > 0.0f) {
                    break;
                }
                float c = (f4 / this.b.c()) + this.d.get(i5);
                if (Math.abs(c) > this.b.d()) {
                    c = -this.b.d();
                }
                this.d.append(i5, (int) c);
                i4++;
            }
            float g2 = this.b.g();
            while (true) {
                int i6 = i + i3;
                float f5 = (i3 * g2) + f3;
                g2 *= 1.4f;
                if (f5 <= 0.0f) {
                    float j = (f5 / this.b.j()) + this.d.get(i6);
                    if (Math.abs(j) > this.b.k()) {
                        j = -this.b.k();
                    }
                    this.d.append(i6, (int) j);
                    i3++;
                } else {
                    return;
                }
            }
        } else {
            float g3 = this.b.g();
            int i7 = 1;
            while (true) {
                int i8 = i - i7;
                float f6 = f3 - (i7 * g3);
                g3 *= 1.4f;
                if (f6 < 0.0f) {
                    break;
                }
                float j2 = (f6 / this.b.j()) + this.d.get(i8);
                if (Math.abs(j2) > this.b.k()) {
                    j2 = this.b.k();
                }
                this.d.append(i8, (int) j2);
                i7++;
            }
            float g4 = this.b.g();
            while (true) {
                int i9 = i + i3;
                float f7 = f3 - (i3 * g4);
                g4 *= 1.4f;
                if (f7 < 0.0f) {
                    return;
                }
                float c2 = (f7 / this.b.c()) + this.d.get(i9);
                if (Math.abs(c2) > this.b.d()) {
                    c2 = this.b.d();
                }
                this.d.append(i9, (int) c2);
                i3++;
            }
        }
    }
}
