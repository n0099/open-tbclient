package com.bytedance.sdk.component.adnet.core;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes9.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f64680a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f64681b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, String> f64682c;

    /* renamed from: d  reason: collision with root package name */
    public final List<Header> f64683d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f64684e;

    /* renamed from: f  reason: collision with root package name */
    public final long f64685f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public i(int i2, byte[] bArr, Map<String, String> map, boolean z, long j2) {
        this(i2, bArr, map, a(map), z, j2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), bArr, map, Boolean.valueOf(z), Long.valueOf(j2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (byte[]) objArr2[1], (Map) objArr2[2], (List) objArr2[3], ((Boolean) objArr2[4]).booleanValue(), ((Long) objArr2[5]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static Map<String, String> a(List<Header> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, list)) == null) {
            if (list == null) {
                return null;
            }
            if (list.isEmpty()) {
                return Collections.emptyMap();
            }
            TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            for (Header header : list) {
                treeMap.put(header.getName(), header.getValue());
            }
            return treeMap;
        }
        return (Map) invokeL.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i(int i2, byte[] bArr, boolean z, long j2, List<Header> list) {
        this(i2, bArr, a(list), list, z, j2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), bArr, Boolean.valueOf(z), Long.valueOf(j2), list};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (byte[]) objArr2[1], (Map) objArr2[2], (List) objArr2[3], ((Boolean) objArr2[4]).booleanValue(), ((Long) objArr2[5]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public i(byte[] bArr, Map<String, String> map) {
        this(200, bArr, map, false, 0L);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr, map};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (byte[]) objArr2[1], (Map) objArr2[2], ((Boolean) objArr2[3]).booleanValue(), ((Long) objArr2[4]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    public i(int i2, byte[] bArr, Map<String, String> map, List<Header> list, boolean z, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), bArr, map, list, Boolean.valueOf(z), Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64680a = i2;
        this.f64681b = bArr;
        this.f64682c = map;
        if (list == null) {
            this.f64683d = null;
        } else {
            this.f64683d = Collections.unmodifiableList(list);
        }
        this.f64684e = z;
        this.f64685f = j2;
    }

    public static List<Header> a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, map)) == null) {
            if (map == null) {
                return null;
            }
            if (map.isEmpty()) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList(map.size());
            for (Map.Entry<String, String> entry : map.entrySet()) {
                arrayList.add(new Header(entry.getKey(), entry.getValue()));
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
