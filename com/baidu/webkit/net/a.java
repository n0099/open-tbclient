package com.baidu.webkit.net;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
/* loaded from: classes9.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: d  reason: collision with root package name */
    public static final String f63749d = "a";

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f63750e;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: f  reason: collision with root package name */
    public static a f63751f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f63752g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<Vector<BdNetTask>> f63753a;

    /* renamed from: b  reason: collision with root package name */
    public Vector<BdNetEngine> f63754b;

    /* renamed from: c  reason: collision with root package name */
    public Context f63755c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(129199371, "Lcom/baidu/webkit/net/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(129199371, "Lcom/baidu/webkit/net/a;");
                return;
            }
        }
        f63750e = new int[]{0, 1, 2, 3};
    }

    public a() {
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
        int length = f63750e.length;
        this.f63753a = new ArrayList(length);
        for (int i4 = 0; i4 < length; i4++) {
            this.f63753a.add(new Vector<>());
        }
        this.f63754b = new Vector<>();
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (a.class) {
                if (f63751f == null) {
                    f63751f = new a();
                }
            }
            return f63751f;
        }
        return (a) invokeV.objValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f63752g : invokeV.booleanValue;
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            f63751f = null;
        }
    }

    public final synchronized void a(BdNetTask bdNetTask, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, bdNetTask, i2) == null) {
            synchronized (this) {
                if (bdNetTask == null) {
                    return;
                }
                if (this.f63753a == null) {
                    this.f63753a = new ArrayList(f63750e.length);
                }
                if (this.f63753a.isEmpty()) {
                    for (int i3 = 0; i3 < f63750e.length; i3++) {
                        this.f63753a.add(new Vector<>());
                    }
                }
                int length = f63750e.length;
                for (int i4 = 0; i4 < length; i4++) {
                    if (i2 == f63750e[i4]) {
                        this.f63753a.get(i4).add(bdNetTask);
                        return;
                    }
                }
            }
        }
    }

    public final synchronized BdNetTask d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                int size = this.f63753a.size();
                for (int i2 = 0; i2 < size; i2++) {
                    Vector<BdNetTask> vector = this.f63753a.get(i2);
                    if (vector.size() > 0) {
                        return vector.remove(0);
                    }
                }
                return null;
            }
        }
        return (BdNetTask) invokeV.objValue;
    }

    public final synchronized BdNetEngine e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                int size = this.f63754b.size();
                for (int i2 = 0; i2 < size; i2++) {
                    BdNetEngine bdNetEngine = this.f63754b.get(i2);
                    if (!bdNetEngine.isWorking() && bdNetEngine.isRecycle()) {
                        bdNetEngine.allocate();
                        return bdNetEngine;
                    }
                }
                if (size < 6) {
                    BdNetEngine bdNetEngine2 = new BdNetEngine();
                    bdNetEngine2.allocate();
                    this.f63754b.add(bdNetEngine2);
                    return bdNetEngine2;
                }
                return null;
            }
        }
        return (BdNetEngine) invokeV.objValue;
    }
}
