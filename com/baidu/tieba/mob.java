package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.net.UrlResponseInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public final class mob extends UrlResponseInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<String> a;
    public final int b;
    public final String c;
    public final boolean d;
    public final String e;
    public final String f;
    public final AtomicLong g;
    public final a h;

    /* loaded from: classes7.dex */
    public static final class a extends UrlResponseInfo.HeaderBlock {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final List<Map.Entry<String, String>> a;
        public Map<String, List<String>> b;

        public a(List<Map.Entry<String, String>> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = list;
        }

        public List<Map.Entry<String, String>> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return (List) invokeV.objValue;
        }

        public Map<String, List<String>> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                Map<String, List<String>> map = this.b;
                if (map != null) {
                    return map;
                }
                TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
                for (Map.Entry<String, String> entry : this.a) {
                    ArrayList arrayList = new ArrayList();
                    if (treeMap.containsKey(entry.getKey())) {
                        arrayList.addAll((Collection) treeMap.get(entry.getKey()));
                    }
                    arrayList.add(entry.getValue());
                    treeMap.put(entry.getKey(), Collections.unmodifiableList(arrayList));
                }
                Map<String, List<String>> unmodifiableMap = Collections.unmodifiableMap(treeMap);
                this.b = unmodifiableMap;
                return unmodifiableMap;
            }
            return (Map) invokeV.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public mob(List<String> list, int i, String str, List<Map.Entry<String, String>> list2, boolean z, String str2, String str3) {
        this(list, i, str, list2, z, str2, str3, 0L);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, Integer.valueOf(i), str, list2, Boolean.valueOf(z), str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((List) objArr2[0], ((Integer) objArr2[1]).intValue(), (String) objArr2[2], (List) objArr2[3], ((Boolean) objArr2[4]).booleanValue(), (String) objArr2[5], (String) objArr2[6], ((Long) objArr2[7]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public mob(List<String> list, int i, String str, List<Map.Entry<String, String>> list2, boolean z, String str2, String str3, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, Integer.valueOf(i), str, list2, Boolean.valueOf(z), str2, str3, Long.valueOf(j)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = Collections.unmodifiableList(list);
        this.b = i;
        this.c = str;
        this.h = new a(Collections.unmodifiableList(list2));
        this.d = z;
        this.e = str2;
        this.f = str3;
        this.g = new AtomicLong(j);
    }

    @Override // com.baidu.turbonet.net.UrlResponseInfo
    public List<Map.Entry<String, String>> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.h.a();
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.turbonet.net.UrlResponseInfo
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.turbonet.net.UrlResponseInfo
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.turbonet.net.UrlResponseInfo
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.turbonet.net.UrlResponseInfo
    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g.get();
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.turbonet.net.UrlResponseInfo
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            List<String> list = this.a;
            return list.get(list.size() - 1);
        }
        return (String) invokeV.objValue;
    }

    public Map<String, List<String>> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.h.b();
        }
        return (Map) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public List<String> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.a;
        }
        return (List) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.d;
        }
        return invokeV.booleanValue;
    }

    public void j(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
            this.g.set(j);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return String.format(Locale.ROOT, "UrlResponseInfo@[%s][%s]: urlChain = %s, httpStatus = %d %s, headers = %s, wasCached = %b, negotiatedProtocol = %s, proxyServer= %s, receivedByteCount = %d", Integer.toHexString(System.identityHashCode(this)), f(), i().toString(), Integer.valueOf(b()), c(), a().toString(), Boolean.valueOf(k()), d(), h(), Long.valueOf(e()));
        }
        return (String) invokeV.objValue;
    }
}
