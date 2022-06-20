package com.baidu.tieba.pb.ejection;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.pb.ejection.value.LifeCycleState;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.nr7;
import com.repackage.or7;
import com.repackage.qr7;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
/* loaded from: classes3.dex */
public class EjectionAnimationView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;
    public int b;
    public int c;
    public int d;
    public boolean e;
    public boolean f;
    public int g;
    public int h;
    public ArrayList<nr7> i;
    public List<Bitmap> j;
    public qr7 k;
    public Vibrator l;

    /* loaded from: classes3.dex */
    public static class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<EjectionAnimationView> a;

        public a(EjectionAnimationView ejectionAnimationView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ejectionAnimationView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(ejectionAnimationView);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                if (this.a.get() == null) {
                    return;
                }
                sendEmptyMessageDelayed(0, 10L);
                if (this.a.get().d == 1) {
                    this.a.get().f();
                }
                EjectionAnimationView.c(this.a.get());
                if (this.a.get().d == 11) {
                    this.a.get().d = (this.a.get().d - 11) + 1;
                }
                this.a.get().invalidate();
                this.a.get().g();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EjectionAnimationView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static /* synthetic */ int c(EjectionAnimationView ejectionAnimationView) {
        int i = ejectionAnimationView.d;
        ejectionAnimationView.d = i + 1;
        return i;
    }

    public final void f() {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || !this.e || ListUtils.isEmpty(this.j) || (bitmap = this.j.get(new Random().nextInt(this.j.size()))) == null) {
            return;
        }
        this.i.add(new or7(bitmap, this.g, this.h, this.b, this.c));
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f = true;
            Iterator<nr7> it = this.i.iterator();
            while (it.hasNext()) {
                nr7 next = it.next();
                if (next.v == LifeCycleState.ACTIVE) {
                    this.f = false;
                    next.a();
                }
            }
            if (this.f) {
                j();
            }
        }
    }

    public final void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            this.a = new a(this);
            this.l = (Vibrator) context.getSystemService("vibrator");
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || ListUtils.isEmpty(this.j)) {
            return;
        }
        for (Bitmap bitmap : this.j) {
            bitmap.recycle();
        }
        this.j = null;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.d = 1;
            this.i = new ArrayList<>();
            this.a.removeMessages(0);
            qr7 qr7Var = this.k;
            if (qr7Var != null) {
                qr7Var.onStop();
            }
            Vibrator vibrator = this.l;
            if (vibrator != null) {
                vibrator.cancel();
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a.removeMessages(0);
            this.i = new ArrayList<>();
            this.e = true;
            this.d = 1;
            qr7 qr7Var = this.k;
            if (qr7Var != null) {
                qr7Var.onStart();
            }
            this.a.sendEmptyMessage(0);
            Vibrator vibrator = this.l;
            if (vibrator != null) {
                vibrator.vibrate(new long[]{50, 80, 100, 80}, 2);
            }
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.e = false;
            Vibrator vibrator = this.l;
            if (vibrator != null) {
                vibrator.cancel();
            }
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDetachedFromWindow();
            this.a.removeMessages(0);
            i();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, canvas) == null) {
            super.onDraw(canvas);
            ArrayList<nr7> arrayList = this.i;
            if (arrayList == null) {
                return;
            }
            Iterator<nr7> it = arrayList.iterator();
            while (it.hasNext()) {
                nr7 next = it.next();
                if (next.v == LifeCycleState.ACTIVE) {
                    next.b(canvas);
                }
            }
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            this.b = getMeasuredWidth();
            this.c = getMeasuredHeight();
        }
    }

    public void setAnchorPosition(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i, i2) == null) {
            this.g = i;
            this.h = i2;
        }
    }

    public void setBitmaps(List<Bitmap> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            this.j = list;
        }
    }

    public void setEjectionAnimationViewCallback(qr7 qr7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, qr7Var) == null) {
            this.k = qr7Var;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EjectionAnimationView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EjectionAnimationView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.d = 1;
        this.f = false;
        h(context);
    }
}
