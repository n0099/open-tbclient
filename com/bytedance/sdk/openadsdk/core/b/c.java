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
/* loaded from: classes6.dex */
public abstract class c implements View.OnClickListener, View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static int B = 8;

    /* renamed from: a  reason: collision with root package name */
    public static float f29740a;

    /* renamed from: b  reason: collision with root package name */
    public static float f29741b;

    /* renamed from: c  reason: collision with root package name */
    public static float f29742c;

    /* renamed from: d  reason: collision with root package name */
    public static float f29743d;

    /* renamed from: e  reason: collision with root package name */
    public static long f29744e;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public SparseArray<a> C;
    public int s;
    public int t;
    public int u;
    public int v;
    public long w;
    public long x;
    public int y;
    public int z;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f29745a;

        /* renamed from: b  reason: collision with root package name */
        public double f29746b;

        /* renamed from: c  reason: collision with root package name */
        public double f29747c;

        /* renamed from: d  reason: collision with root package name */
        public long f29748d;

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
            this.f29745a = -1;
            this.f29745a = i2;
            this.f29746b = d2;
            this.f29747c = d3;
            this.f29748d = j;
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
            B = ViewConfiguration.get(o.a()).getScaledTouchSlop();
        }
        f29740a = 0.0f;
        f29741b = 0.0f;
        f29742c = 0.0f;
        f29743d = 0.0f;
        f29744e = 0L;
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
        this.C = new SparseArray<>();
    }

    public abstract void a(View view, int i2, int i3, int i4, int i5);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) && g.a()) {
            a(view, this.s, this.t, this.u, this.v);
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
                this.s = (int) motionEvent.getRawX();
                this.t = (int) motionEvent.getRawY();
                this.w = System.currentTimeMillis();
                this.y = motionEvent.getToolType(0);
                this.z = motionEvent.getDeviceId();
                this.A = motionEvent.getSource();
                f29744e = System.currentTimeMillis();
                i2 = 0;
            } else if (actionMasked == 1) {
                this.u = (int) motionEvent.getRawX();
                this.v = (int) motionEvent.getRawY();
                this.x = System.currentTimeMillis();
                i2 = 3;
            } else if (actionMasked != 2) {
                i2 = actionMasked != 3 ? -1 : 4;
            } else {
                f29742c += Math.abs(motionEvent.getX() - f29740a);
                f29743d += Math.abs(motionEvent.getY() - f29741b);
                f29740a = motionEvent.getX();
                f29741b = motionEvent.getY();
                if (System.currentTimeMillis() - f29744e > 200) {
                    float f2 = f29742c;
                    int i3 = B;
                    if (f2 > i3 || f29743d > i3) {
                        i2 = 1;
                    }
                }
                i2 = 2;
            }
            if (this.C.get(motionEvent.getActionMasked()) == null) {
                this.C.put(motionEvent.getActionMasked(), new a(i2, motionEvent.getSize(), motionEvent.getPressure(), System.currentTimeMillis()));
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
