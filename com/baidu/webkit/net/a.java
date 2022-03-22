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
/* loaded from: classes6.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: d  reason: collision with root package name */
    public static final String f37947d = "a";

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f37948e;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: f  reason: collision with root package name */
    public static a f37949f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f37950g;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Vector<BdNetTask>> a;

    /* renamed from: b  reason: collision with root package name */
    public Vector<BdNetEngine> f37951b;

    /* renamed from: c  reason: collision with root package name */
    public Context f37952c;

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
        f37948e = new int[]{0, 1, 2, 3};
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        int length = f37948e.length;
        this.a = new ArrayList(length);
        for (int i3 = 0; i3 < length; i3++) {
            this.a.add(new Vector<>());
        }
        this.f37951b = new Vector<>();
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (a.class) {
                if (f37949f == null) {
                    f37949f = new a();
                }
            }
            return f37949f;
        }
        return (a) invokeV.objValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f37950g : invokeV.booleanValue;
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            f37949f = null;
        }
    }

    public final synchronized void a(BdNetTask bdNetTask, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, bdNetTask, i) == null) {
            synchronized (this) {
                if (bdNetTask == null) {
                    return;
                }
                if (this.a == null) {
                    this.a = new ArrayList(f37948e.length);
                }
                if (this.a.isEmpty()) {
                    for (int i2 = 0; i2 < f37948e.length; i2++) {
                        this.a.add(new Vector<>());
                    }
                }
                int length = f37948e.length;
                for (int i3 = 0; i3 < length; i3++) {
                    if (i == f37948e[i3]) {
                        this.a.get(i3).add(bdNetTask);
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
                for (int i = 0; i < size; i++) {
                    Vector<BdNetTask> vector = this.a.get(i);
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
                int size = this.f37951b.size();
                for (int i = 0; i < size; i++) {
                    BdNetEngine bdNetEngine = this.f37951b.get(i);
                    if (!bdNetEngine.isWorking() && bdNetEngine.isRecycle()) {
                        bdNetEngine.allocate();
                        return bdNetEngine;
                    }
                }
                if (size < 6) {
                    BdNetEngine bdNetEngine2 = new BdNetEngine();
                    bdNetEngine2.allocate();
                    this.f37951b.add(bdNetEngine2);
                    return bdNetEngine2;
                }
                return null;
            }
        }
        return (BdNetEngine) invokeV.objValue;
    }
}
