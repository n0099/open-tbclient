package com.bytedance.sdk.openadsdk.core.widget;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.q.s;
/* loaded from: classes9.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final a f67013a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f67014b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f67015c;

    /* renamed from: d  reason: collision with root package name */
    public float f67016d;

    /* renamed from: e  reason: collision with root package name */
    public float f67017e;

    /* renamed from: f  reason: collision with root package name */
    public int f67018f;

    /* renamed from: g  reason: collision with root package name */
    public int f67019g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f67020h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f67021i;

    /* renamed from: j  reason: collision with root package name */
    public final View.OnTouchListener f67022j;
    public boolean k;

    /* loaded from: classes9.dex */
    public interface a {
        void a(View view, boolean z);

        void l();

        boolean m();
    }

    public h(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67014b = false;
        this.f67015c = false;
        this.f67020h = true;
        this.f67021i = false;
        this.f67022j = new View.OnTouchListener(this) { // from class: com.bytedance.sdk.openadsdk.core.widget.h.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ h f67023a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f67023a = this;
            }

            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) {
                    if (this.f67023a.f67013a.m()) {
                        return this.f67023a.f67014b || !this.f67023a.f67015c;
                    }
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    int action = motionEvent.getAction();
                    if (action == 0) {
                        h hVar = this.f67023a;
                        hVar.k = hVar.a(motionEvent);
                        this.f67023a.f67016d = x;
                        this.f67023a.f67017e = y;
                        this.f67023a.f67018f = (int) x;
                        this.f67023a.f67019g = (int) y;
                        this.f67023a.f67020h = true;
                        if (this.f67023a.f67013a != null && this.f67023a.f67015c && !this.f67023a.f67014b) {
                            this.f67023a.f67013a.a(view, true);
                        }
                    } else if (action == 1) {
                        if (Math.abs(x - this.f67023a.f67018f) > 20.0f || Math.abs(y - this.f67023a.f67019g) > 20.0f) {
                            this.f67023a.f67020h = false;
                        }
                        if (!this.f67023a.f67014b) {
                            this.f67023a.f67020h = true;
                        }
                        this.f67023a.f67021i = false;
                        this.f67023a.f67016d = 0.0f;
                        this.f67023a.f67017e = 0.0f;
                        this.f67023a.f67018f = 0;
                        if (this.f67023a.f67013a != null) {
                            this.f67023a.f67013a.a(view, this.f67023a.f67020h);
                        }
                        this.f67023a.k = false;
                    } else if (action != 2) {
                        if (action == 3) {
                            this.f67023a.k = false;
                        }
                    } else if (this.f67023a.f67014b && !this.f67023a.k) {
                        float abs = Math.abs(x - this.f67023a.f67016d);
                        float abs2 = Math.abs(y - this.f67023a.f67017e);
                        if (!this.f67023a.f67021i) {
                            if (abs <= 20.0f && abs2 <= 20.0f) {
                                return true;
                            }
                            this.f67023a.f67021i = true;
                        }
                        if (this.f67023a.f67013a != null) {
                            this.f67023a.f67013a.l();
                        }
                        this.f67023a.f67016d = x;
                        this.f67023a.f67017e = y;
                    }
                    return this.f67023a.f67014b || !this.f67023a.f67015c;
                }
                return invokeLL.booleanValue;
            }
        };
        this.f67013a = aVar;
    }

    public void a(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
            return;
        }
        view.setOnTouchListener(this.f67022j);
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f67015c = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, motionEvent)) == null) {
            if (motionEvent.getActionMasked() == 0) {
                int c2 = s.c(o.a().getApplicationContext());
                int d2 = s.d(o.a().getApplicationContext());
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float f2 = c2;
                if (rawX > f2 * 0.01f && rawX < f2 * 0.99f) {
                    float f3 = d2;
                    if (rawY > 0.01f * f3 && rawY < f3 * 0.99f) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
