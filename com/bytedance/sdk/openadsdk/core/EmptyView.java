package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.u;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class EmptyView extends View implements u.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f29656a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f29657b;

    /* renamed from: c  reason: collision with root package name */
    public a f29658c;

    /* renamed from: d  reason: collision with root package name */
    public View f29659d;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<Activity> f29660e;

    /* renamed from: f  reason: collision with root package name */
    public List<View> f29661f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public List<View> f29662g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f29663h;

    /* renamed from: i  reason: collision with root package name */
    public int f29664i;
    public final Handler j;
    public final AtomicBoolean k;

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void a(View view);

        void a(boolean z);

        void b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptyView(Context context, View view) {
        super(o.a());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view};
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
        this.j = new com.bytedance.sdk.component.utils.u(Looper.getMainLooper(), this);
        this.k = new AtomicBoolean(true);
        if (context instanceof Activity) {
            this.f29660e = new WeakReference<>((Activity) context);
        }
        this.f29659d = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    private void b() {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, this) == null) && this.k.getAndSet(false) && (aVar = this.f29658c) != null) {
            aVar.a();
        }
    }

    private void c() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || this.k.getAndSet(true) || (aVar = this.f29658c) == null) {
            return;
        }
        aVar.b();
    }

    private void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && this.f29657b && !this.f29656a) {
            this.f29656a = true;
            this.j.sendEmptyMessage(1);
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65540, this) == null) && this.f29656a) {
            this.j.removeCallbacksAndMessages(null);
            this.f29656a = false;
        }
    }

    private boolean f() {
        InterceptResult invokeV;
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            boolean a2 = com.bytedance.sdk.openadsdk.r.o.a();
            WeakReference<Activity> weakReference = this.f29660e;
            boolean z = (weakReference == null || (activity = weakReference.get()) == null || activity.isFinishing()) ? false : true;
            boolean a3 = y.a(this.f29659d, 20, this.f29664i);
            if (!a2) {
                a3 = true;
            }
            if (a2 || !z) {
                return true;
            }
            return a3;
        }
        return invokeV.booleanValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a(this.f29661f, null);
            a(this.f29662g, null);
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onAttachedToWindow();
            d();
            this.f29663h = false;
            b();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDetachedFromWindow();
            e();
            this.f29663h = true;
            c();
        }
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onFinishTemporaryDetach();
            b();
        }
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onStartTemporaryDetach();
            c();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            super.onWindowFocusChanged(z);
            a aVar = this.f29658c;
            if (aVar != null) {
                aVar.a(z);
            }
        }
    }

    public void setAdType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f29664i = i2;
        }
    }

    public void setCallback(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            this.f29658c = aVar;
        }
    }

    public void setNeedCheckingShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f29657b = z;
            if (!z && this.f29656a) {
                e();
            } else if (!z || this.f29656a) {
            } else {
                d();
            }
        }
    }

    public void setRefClickViews(List<View> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            this.f29661f = list;
        }
    }

    public void setRefCreativeViews(@Nullable List<View> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, list) == null) {
            this.f29662g = list;
        }
    }

    public void a(List<View> list, com.bytedance.sdk.openadsdk.core.b.c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, list, cVar) == null) && com.bytedance.sdk.component.utils.h.b(list)) {
            for (View view : list) {
                view.setOnClickListener(cVar);
                view.setOnTouchListener(cVar);
            }
        }
    }

    @Override // com.bytedance.sdk.component.utils.u.a
    public void a(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) {
            int i2 = message.what;
            if (i2 != 1) {
                if (i2 != 2) {
                    return;
                }
                if (f()) {
                    this.j.sendEmptyMessageDelayed(2, 1000L);
                } else if (this.f29663h) {
                } else {
                    setNeedCheckingShow(true);
                }
            } else if (this.f29656a) {
                if (y.a(this.f29659d, 20, this.f29664i)) {
                    e();
                    this.j.sendEmptyMessageDelayed(2, 1000L);
                    a aVar = this.f29658c;
                    if (aVar != null) {
                        aVar.a(this.f29659d);
                        return;
                    }
                    return;
                }
                this.j.sendEmptyMessageDelayed(1, 1000L);
            }
        }
    }
}
