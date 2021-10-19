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
import com.bytedance.sdk.component.utils.w;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public class EmptyView extends View implements w.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f66482a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f66483b;

    /* renamed from: c  reason: collision with root package name */
    public a f66484c;

    /* renamed from: d  reason: collision with root package name */
    public View f66485d;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<Activity> f66486e;

    /* renamed from: f  reason: collision with root package name */
    public List<View> f66487f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public List<View> f66488g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f66489h;

    /* renamed from: i  reason: collision with root package name */
    public int f66490i;

    /* renamed from: j  reason: collision with root package name */
    public final Handler f66491j;
    public final AtomicBoolean k;

    /* loaded from: classes9.dex */
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
        this.f66491j = new com.bytedance.sdk.component.utils.w(Looper.getMainLooper(), this);
        this.k = new AtomicBoolean(true);
        if (context instanceof Activity) {
            this.f66486e = new WeakReference<>((Activity) context);
        }
        this.f66485d = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    private void b() {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, this) == null) && this.k.getAndSet(false) && (aVar = this.f66484c) != null) {
            aVar.a();
        }
    }

    private void c() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || this.k.getAndSet(true) || (aVar = this.f66484c) == null) {
            return;
        }
        aVar.b();
    }

    private void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && this.f66483b && !this.f66482a) {
            this.f66482a = true;
            this.f66491j.sendEmptyMessage(1);
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) && this.f66482a) {
            this.f66491j.removeMessages(1);
            this.f66491j.removeMessages(2);
            this.f66482a = false;
        }
    }

    private boolean f() {
        InterceptResult invokeV;
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            boolean a2 = com.bytedance.sdk.openadsdk.q.q.a();
            WeakReference<Activity> weakReference = this.f66486e;
            boolean z = (weakReference == null || (activity = weakReference.get()) == null || activity.isFinishing()) ? false : true;
            boolean a3 = y.a(this.f66485d, 20, this.f66490i);
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
            a(this.f66487f, null);
            a(this.f66488g, null);
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onAttachedToWindow();
            d();
            this.f66489h = false;
            b();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDetachedFromWindow();
            e();
            this.f66489h = true;
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
            a aVar = this.f66484c;
            if (aVar != null) {
                aVar.a(z);
            }
        }
    }

    public void setAdType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f66490i = i2;
        }
    }

    public void setCallback(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            this.f66484c = aVar;
        }
    }

    public void setNeedCheckingShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f66483b = z;
            if (!z && this.f66482a) {
                e();
            } else if (!z || this.f66482a) {
            } else {
                d();
            }
        }
    }

    public void setRefClickViews(List<View> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            this.f66487f = list;
        }
    }

    public void setRefCreativeViews(@Nullable List<View> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, list) == null) {
            this.f66488g = list;
        }
    }

    public void a(List<View> list, com.bytedance.sdk.openadsdk.core.b.c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, list, cVar) == null) && com.bytedance.sdk.component.utils.i.b(list)) {
            for (View view : list) {
                view.setOnClickListener(cVar);
                view.setOnTouchListener(cVar);
            }
        }
    }

    @Override // com.bytedance.sdk.component.utils.w.a
    public void a(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) {
            int i2 = message.what;
            if (i2 != 1) {
                if (i2 != 2) {
                    return;
                }
                if (f()) {
                    this.f66491j.sendEmptyMessageDelayed(2, 1000L);
                } else if (this.f66489h) {
                } else {
                    setNeedCheckingShow(true);
                }
            } else if (this.f66482a) {
                if (y.a(this.f66485d, 20, this.f66490i)) {
                    e();
                    this.f66491j.sendEmptyMessageDelayed(2, 1000L);
                    a aVar = this.f66484c;
                    if (aVar != null) {
                        aVar.a(this.f66485d);
                        return;
                    }
                    return;
                }
                this.f66491j.sendEmptyMessageDelayed(1, 1000L);
            }
        }
    }
}
