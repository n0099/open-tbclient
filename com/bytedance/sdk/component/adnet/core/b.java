package com.bytedance.sdk.component.adnet.core;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Comparator<byte[]> f64286a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final List<byte[]> f64287b;

    /* renamed from: c  reason: collision with root package name */
    public final List<byte[]> f64288c;

    /* renamed from: d  reason: collision with root package name */
    public int f64289d;

    /* renamed from: e  reason: collision with root package name */
    public final int f64290e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(8116335, "Lcom/bytedance/sdk/component/adnet/core/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(8116335, "Lcom/bytedance/sdk/component/adnet/core/b;");
                return;
            }
        }
        f64286a = new Comparator<byte[]>() { // from class: com.bytedance.sdk.component.adnet.core.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(byte[] bArr, byte[] bArr2) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, bArr, bArr2)) == null) ? bArr.length - bArr2.length : invokeLL.intValue;
            }
        };
    }

    public b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f64287b = new ArrayList();
        this.f64288c = new ArrayList(64);
        this.f64289d = 0;
        this.f64290e = i2;
    }

    public synchronized byte[] a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            synchronized (this) {
                for (int i3 = 0; i3 < this.f64288c.size(); i3++) {
                    byte[] bArr = this.f64288c.get(i3);
                    if (bArr.length >= i2) {
                        this.f64289d -= bArr.length;
                        this.f64288c.remove(i3);
                        this.f64287b.remove(bArr);
                        return bArr;
                    }
                }
                return new byte[i2];
            }
        }
        return (byte[]) invokeI.objValue;
    }

    public synchronized void a(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bArr) == null) {
            synchronized (this) {
                if (bArr != null) {
                    if (bArr.length <= this.f64290e) {
                        this.f64287b.add(bArr);
                        int binarySearch = Collections.binarySearch(this.f64288c, bArr, f64286a);
                        if (binarySearch < 0) {
                            binarySearch = (-binarySearch) - 1;
                        }
                        this.f64288c.add(binarySearch, bArr);
                        this.f64289d += bArr.length;
                        a();
                    }
                }
            }
        }
    }

    private synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            synchronized (this) {
                while (this.f64289d > this.f64290e) {
                    byte[] remove = this.f64287b.remove(0);
                    this.f64288c.remove(remove);
                    this.f64289d -= remove.length;
                }
            }
        }
    }
}
