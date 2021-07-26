package com.bytedance.sdk.openadsdk.core.b;

import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.core.j.g;
import com.bytedance.sdk.openadsdk.core.o;
/* loaded from: classes5.dex */
public abstract class c implements View.OnClickListener, View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static int C = 8;

    /* renamed from: a  reason: collision with root package name */
    public static float f29946a;

    /* renamed from: b  reason: collision with root package name */
    public static float f29947b;

    /* renamed from: c  reason: collision with root package name */
    public static float f29948c;

    /* renamed from: d  reason: collision with root package name */
    public static float f29949d;

    /* renamed from: e  reason: collision with root package name */
    public static long f29950e;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public SparseArray<a> D;
    public int t;
    public int u;
    public int v;
    public int w;
    public long x;
    public long y;
    public int z;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f29951a;

        /* renamed from: b  reason: collision with root package name */
        public double f29952b;

        /* renamed from: c  reason: collision with root package name */
        public double f29953c;

        /* renamed from: d  reason: collision with root package name */
        public long f29954d;

        public a(int i2, double d2, double d3, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Double.valueOf(d2), Double.valueOf(d3), Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29951a = -1;
            this.f29951a = i2;
            this.f29952b = d2;
            this.f29953c = d3;
            this.f29954d = j;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(268029312, "Lcom/bytedance/sdk/openadsdk/core/b/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(268029312, "Lcom/bytedance/sdk/openadsdk/core/b/c;");
                return;
            }
        }
        if (ViewConfiguration.get(o.a()) != null) {
            C = ViewConfiguration.get(o.a()).getScaledTouchSlop();
        }
        f29946a = 0.0f;
        f29947b = 0.0f;
        f29948c = 0.0f;
        f29949d = 0.0f;
        f29950e = 0L;
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.D = new SparseArray<>();
    }

    public abstract void a(View view, int i2, int i3, int i4, int i5);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) && g.a()) {
            a(view, this.t, this.u, this.v, this.w);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, motionEvent)) == null) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                this.t = (int) motionEvent.getRawX();
                this.u = (int) motionEvent.getRawY();
                this.x = System.currentTimeMillis();
                this.z = motionEvent.getToolType(0);
                this.A = motionEvent.getDeviceId();
                this.B = motionEvent.getSource();
                f29950e = System.currentTimeMillis();
                i2 = 0;
            } else if (actionMasked == 1) {
                this.v = (int) motionEvent.getRawX();
                this.w = (int) motionEvent.getRawY();
                this.y = System.currentTimeMillis();
                i2 = 3;
            } else if (actionMasked != 2) {
                i2 = actionMasked != 3 ? -1 : 4;
            } else {
                f29948c += Math.abs(motionEvent.getX() - f29946a);
                f29949d += Math.abs(motionEvent.getY() - f29947b);
                f29946a = motionEvent.getX();
                f29947b = motionEvent.getY();
                if (System.currentTimeMillis() - f29950e > 200) {
                    float f2 = f29948c;
                    int i3 = C;
                    if (f2 > i3 || f29949d > i3) {
                        i2 = 1;
                    }
                }
                i2 = 2;
            }
            if (this.D.get(motionEvent.getActionMasked()) == null) {
                this.D.put(motionEvent.getActionMasked(), new a(i2, motionEvent.getSize(), motionEvent.getPressure(), System.currentTimeMillis()));
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
