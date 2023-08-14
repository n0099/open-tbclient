package com.baidu.tieba;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class v6c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public Window b;
    public View c;
    public View d;
    public View e;
    public s6c f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public ViewTreeObserver.OnGlobalLayoutListener p;

    /* loaded from: classes8.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v6c a;

        public a(v6c v6cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v6cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v6cVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int i;
            int i2;
            int i3;
            int height;
            int i4;
            int i5;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.a.o) {
                return;
            }
            Rect rect = new Rect();
            this.a.c.getWindowVisibleDisplayFrame(rect);
            boolean z = true;
            if (this.a.f.x) {
                int height2 = (this.a.d.getHeight() - rect.bottom) - this.a.n;
                if (this.a.f.z != null) {
                    if (height2 <= this.a.n) {
                        z = false;
                    }
                    this.a.f.z.a(z, height2);
                }
            } else if (this.a.e != null) {
                if (this.a.f.s) {
                    height = this.a.d.getHeight() + this.a.l + this.a.m;
                    i4 = rect.bottom;
                } else if (this.a.f.n) {
                    height = this.a.d.getHeight() + this.a.l;
                    i4 = rect.bottom;
                } else {
                    height = this.a.d.getHeight();
                    i4 = rect.bottom;
                }
                int i6 = height - i4;
                if (this.a.f.e) {
                    i5 = i6 - this.a.n;
                } else {
                    i5 = i6;
                }
                if (this.a.f.e && i6 == this.a.n) {
                    i6 -= this.a.n;
                }
                if (i5 != this.a.k) {
                    this.a.d.setPadding(this.a.g, this.a.h, this.a.i, i6 + this.a.j);
                    this.a.k = i5;
                    if (this.a.f.z != null) {
                        if (i5 <= this.a.n) {
                            z = false;
                        }
                        this.a.f.z.a(z, i5);
                    }
                }
            } else {
                int height3 = this.a.d.getHeight() - rect.bottom;
                if (this.a.f.v && this.a.f.w) {
                    if (Build.VERSION.SDK_INT == 19 || w6c.i()) {
                        i2 = this.a.n;
                    } else if (this.a.f.e) {
                        i2 = this.a.n;
                    } else {
                        i3 = height3;
                        if (this.a.f.e && height3 == this.a.n) {
                            height3 -= this.a.n;
                        }
                        int i7 = height3;
                        height3 = i3;
                        i = i7;
                    }
                    i3 = height3 - i2;
                    if (this.a.f.e) {
                        height3 -= this.a.n;
                    }
                    int i72 = height3;
                    height3 = i3;
                    i = i72;
                } else {
                    i = height3;
                }
                if (height3 != this.a.k) {
                    if (this.a.f.s) {
                        this.a.d.setPadding(0, this.a.l + this.a.m, 0, i);
                    } else if (this.a.f.n) {
                        this.a.d.setPadding(0, this.a.l, 0, i);
                    } else {
                        this.a.d.setPadding(0, 0, 0, i);
                    }
                    this.a.k = height3;
                    if (this.a.f.z != null) {
                        if (height3 <= this.a.n) {
                            z = false;
                        }
                        this.a.f.z.a(z, height3);
                    }
                }
            }
        }
    }

    public v6c(Activity activity, Window window) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, window};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = new a(this);
        this.a = activity;
        this.b = window;
        View decorView = window.getDecorView();
        this.c = decorView;
        FrameLayout frameLayout = (FrameLayout) decorView.findViewById(16908290);
        if (frameLayout == null) {
            return;
        }
        View childAt = frameLayout.getChildAt(0);
        this.e = childAt;
        frameLayout = childAt != null ? childAt : frameLayout;
        this.d = frameLayout;
        this.g = frameLayout.getPaddingLeft();
        this.h = this.d.getPaddingTop();
        this.i = this.d.getPaddingRight();
        this.j = this.d.getPaddingBottom();
        r6c r6cVar = new r6c(this.a);
        this.l = r6cVar.i();
        this.n = r6cVar.d();
        this.m = r6cVar.a();
        this.o = r6cVar.l();
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                this.b.setSoftInputMode(i);
                this.c.getViewTreeObserver().removeOnGlobalLayoutListener(this.p);
            }
            this.a = null;
        }
    }

    public void p(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && Build.VERSION.SDK_INT >= 19) {
            this.b.setSoftInputMode(i);
            this.c.getViewTreeObserver().addOnGlobalLayoutListener(this.p);
        }
    }

    public void r(s6c s6cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, s6cVar) == null) {
            this.f = s6cVar;
        }
    }

    public static v6c q(Activity activity, Window window) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, activity, window)) == null) {
            return new v6c(activity, window);
        }
        return (v6c) invokeLL.objValue;
    }
}
