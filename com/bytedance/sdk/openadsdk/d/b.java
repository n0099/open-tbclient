package com.bytedance.sdk.openadsdk.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.k;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes9.dex */
public class b extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f67851a;

    /* renamed from: b  reason: collision with root package name */
    public int f67852b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f67853c;

    public b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67851a = 15;
        this.f67852b = 3;
        if (i2 > 0) {
            this.f67851a = i2;
            this.f67852b = i3;
            return;
        }
        throw new IllegalArgumentException("Max count must be positive number!");
    }

    private void c(List<File> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, list) == null) {
            long b2 = b(list);
            int size = list.size();
            if (a(b2, size)) {
                return;
            }
            for (File file : list) {
                long length = file.length();
                if (file.delete()) {
                    size--;
                    b2 -= length;
                    k.c("TotalCountLruDiskFile", "Cache file " + file + " is deleted because it exceeds cache limit");
                } else {
                    k.c("TotalCountLruDiskFile", "Error deleting file " + file + " for trimming cache");
                }
                if (a(file, b2, size)) {
                    return;
                }
            }
        }
    }

    private void d(List<File> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, list) == null) || list == null) {
            return;
        }
        try {
            if (list.size() == 0) {
                return;
            }
            long b2 = b(list);
            int size = list.size();
            boolean a2 = a(b2, size);
            if (a2) {
                k.c("splashLoadAd", "不满足删除条件，不执行删除操作(true)" + a2);
                return;
            }
            TreeMap treeMap = new TreeMap();
            for (File file : list) {
                treeMap.put(Long.valueOf(file.lastModified()), file);
            }
            for (Map.Entry entry : treeMap.entrySet()) {
                if (entry != null && !a2) {
                    k.f("splashLoadAd", "LRUDeleteFile deleting fileTime " + ((Long) entry.getKey()).longValue());
                    File file2 = (File) entry.getValue();
                    long length = file2.length();
                    if (file2.delete()) {
                        size--;
                        b2 -= length;
                        k.c("splashLoadAd", "删除 一个 Cache file 当前总个数：" + size);
                    } else {
                        k.f("splashLoadAd", "Error deleting file " + file2 + " for trimming cache");
                    }
                    if (a(file2, b2, size)) {
                        k.c("splashLoadAd", "停止删除 当前总个数 totalCount：" + size + " 最大值存储上限个数 maxCount " + this.f67851a + " 最小个数 " + this.f67852b);
                        return;
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.d.a
    public boolean a(long j2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)})) == null) ? i2 <= this.f67851a : invokeCommon.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.d.a
    public boolean a(File file, long j2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{file, Long.valueOf(j2), Integer.valueOf(i2)})) == null) ? i2 <= this.f67852b : invokeCommon.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.d.a
    public void a(List<File> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            if (this.f67853c) {
                d(list);
                this.f67853c = false;
                return;
            }
            c(list);
        }
    }

    public b(int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f67851a = 15;
        this.f67852b = 3;
        if (i2 > 0) {
            this.f67851a = i2;
            this.f67852b = i3;
            this.f67853c = z;
            return;
        }
        throw new IllegalArgumentException("Max count must be positive number!");
    }
}
