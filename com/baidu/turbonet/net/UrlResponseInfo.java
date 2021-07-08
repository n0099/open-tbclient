package com.baidu.turbonet.net;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes4.dex */
public final class UrlResponseInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<String> f23240a;

    /* renamed from: b  reason: collision with root package name */
    public final int f23241b;

    /* renamed from: c  reason: collision with root package name */
    public final String f23242c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f23243d;

    /* renamed from: e  reason: collision with root package name */
    public final String f23244e;

    /* renamed from: f  reason: collision with root package name */
    public final String f23245f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicLong f23246g;

    /* renamed from: h  reason: collision with root package name */
    public final HeaderBlock f23247h;

    /* loaded from: classes4.dex */
    public static final class HeaderBlock {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final List<Map.Entry<String, String>> f23248a;

        /* renamed from: b  reason: collision with root package name */
        public Map<String, List<String>> f23249b;

        public HeaderBlock(List<Map.Entry<String, String>> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23248a = list;
        }

        public List<Map.Entry<String, String>> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f23248a : (List) invokeV.objValue;
        }

        public Map<String, List<String>> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                Map<String, List<String>> map = this.f23249b;
                if (map != null) {
                    return map;
                }
                TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
                for (Map.Entry<String, String> entry : this.f23248a) {
                    ArrayList arrayList = new ArrayList();
                    if (treeMap.containsKey(entry.getKey())) {
                        arrayList.addAll((Collection) treeMap.get(entry.getKey()));
                    }
                    arrayList.add(entry.getValue());
                    treeMap.put(entry.getKey(), Collections.unmodifiableList(arrayList));
                }
                Map<String, List<String>> unmodifiableMap = Collections.unmodifiableMap(treeMap);
                this.f23249b = unmodifiableMap;
                return unmodifiableMap;
            }
            return (Map) invokeV.objValue;
        }
    }

    public UrlResponseInfo(List<String> list, int i2, String str, List<Map.Entry<String, String>> list2, boolean z, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, Integer.valueOf(i2), str, list2, Boolean.valueOf(z), str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23240a = Collections.unmodifiableList(list);
        this.f23241b = i2;
        this.f23242c = str;
        this.f23247h = new HeaderBlock(Collections.unmodifiableList(list2));
        this.f23243d = z;
        this.f23244e = str2;
        this.f23245f = str3;
        this.f23246g = new AtomicLong();
    }

    public Map<String, List<String>> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f23247h.b() : (Map) invokeV.objValue;
    }

    public List<Map.Entry<String, String>> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23247h.a() : (List) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f23241b : invokeV.intValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f23242c : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f23244e : (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f23245f : (String) invokeV.objValue;
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f23246g.get() : invokeV.longValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            List<String> list = this.f23240a;
            return list.get(list.size() - 1);
        }
        return (String) invokeV.objValue;
    }

    public List<String> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f23240a : (List) invokeV.objValue;
    }

    public void j(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
            this.f23246g.set(j);
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f23243d : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? String.format(Locale.ROOT, "UrlResponseInfo@[%s][%s]: urlChain = %s, httpStatus = %d %s, headers = %s, wasCached = %b, negotiatedProtocol = %s, proxyServer= %s, receivedBytesCount = %d", Integer.toHexString(System.identityHashCode(this)), h(), i().toString(), Integer.valueOf(c()), d(), b().toString(), Boolean.valueOf(k()), e(), f(), Long.valueOf(g())) : (String) invokeV.objValue;
    }
}
