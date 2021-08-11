package com.bytedance.sdk.component.adnet.face;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.adnet.core.Header;
import java.util.Collections;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public interface a {

    /* renamed from: com.bytedance.sdk.component.adnet.face.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1878a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f64003a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f64004b;

        /* renamed from: c  reason: collision with root package name */
        public String f64005c;

        /* renamed from: d  reason: collision with root package name */
        public long f64006d;

        /* renamed from: e  reason: collision with root package name */
        public long f64007e;

        /* renamed from: f  reason: collision with root package name */
        public long f64008f;

        /* renamed from: g  reason: collision with root package name */
        public long f64009g;

        /* renamed from: h  reason: collision with root package name */
        public Map<String, String> f64010h;

        /* renamed from: i  reason: collision with root package name */
        public List<Header> f64011i;

        public C1878a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64010h = Collections.emptyMap();
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f64008f < System.currentTimeMillis() : invokeV.booleanValue;
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f64009g < System.currentTimeMillis() : invokeV.booleanValue;
        }
    }

    C1878a a(String str);

    void a();

    void a(String str, C1878a c1878a);
}
