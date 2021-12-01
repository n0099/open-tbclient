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
/* loaded from: classes12.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: d  reason: collision with root package name */
    public static final String f54368d = "a";

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f54369e;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: f  reason: collision with root package name */
    public static a f54370f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f54371g;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Vector<BdNetTask>> a;

    /* renamed from: b  reason: collision with root package name */
    public Vector<BdNetEngine> f54372b;

    /* renamed from: c  reason: collision with root package name */
    public Context f54373c;

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
        f54369e = new int[]{0, 1, 2, 3};
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
        int length = f54369e.length;
        this.a = new ArrayList(length);
        for (int i4 = 0; i4 < length; i4++) {
            this.a.add(new Vector<>());
        }
        this.f54372b = new Vector<>();
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (a.class) {
                if (f54370f == null) {
                    f54370f = new a();
                }
            }
            return f54370f;
        }
        return (a) invokeV.objValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f54371g : invokeV.booleanValue;
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            f54370f = null;
        }
    }

    public final synchronized void a(BdNetTask bdNetTask, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, bdNetTask, i2) == null) {
            synchronized (this) {
                if (bdNetTask == null) {
                    return;
                }
                if (this.a == null) {
                    this.a = new ArrayList(f54369e.length);
                }
                if (this.a.isEmpty()) {
                    for (int i3 = 0; i3 < f54369e.length; i3++) {
                        this.a.add(new Vector<>());
                    }
                }
                int length = f54369e.length;
                for (int i4 = 0; i4 < length; i4++) {
                    if (i2 == f54369e[i4]) {
                        this.a.get(i4).add(bdNetTask);
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
                int size = this.a.size();
                for (int i2 = 0; i2 < size; i2++) {
                    Vector<BdNetTask> vector = this.a.get(i2);
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
                int size = this.f54372b.size();
                for (int i2 = 0; i2 < size; i2++) {
                    BdNetEngine bdNetEngine = this.f54372b.get(i2);
                    if (!bdNetEngine.isWorking() && bdNetEngine.isRecycle()) {
                        bdNetEngine.allocate();
                        return bdNetEngine;
                    }
                }
                if (size < 6) {
                    BdNetEngine bdNetEngine2 = new BdNetEngine();
                    bdNetEngine2.allocate();
                    this.f54372b.add(bdNetEngine2);
                    return bdNetEngine2;
                }
                return null;
            }
        }
        return (BdNetEngine) invokeV.objValue;
    }
}
