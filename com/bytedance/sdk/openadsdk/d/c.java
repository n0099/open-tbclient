package com.bytedance.sdk.openadsdk.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.j;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes6.dex */
public class c extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f30893a;

    /* renamed from: b  reason: collision with root package name */
    public int f30894b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f30895c;

    public c(int i2, int i3) {
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
        this.f30893a = 15;
        this.f30894b = 3;
        if (i2 > 0) {
            this.f30893a = i2;
            this.f30894b = i3;
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
                    j.c("TotalCountLruDiskFile", "Cache file " + file + " is deleted because it exceeds cache limit");
                } else {
                    j.c("TotalCountLruDiskFile", "Error deleting file " + file + " for trimming cache");
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
                j.c("splashLoadAd", "不满足删除条件，不执行删除操作(true)" + a2);
                return;
            }
            TreeMap treeMap = new TreeMap();
            for (File file : list) {
                treeMap.put(Long.valueOf(file.lastModified()), file);
            }
            for (Map.Entry entry : treeMap.entrySet()) {
                if (entry != null && !a2) {
                    j.f("splashLoadAd", "LRUDeleteFile deleting fileTime " + ((Long) entry.getKey()).longValue());
                    File file2 = (File) entry.getValue();
                    long length = file2.length();
                    if (file2.delete()) {
                        size--;
                        b2 -= length;
                        j.c("splashLoadAd", "删除 一个 Cache file 当前总个数：" + size);
                    } else {
                        j.f("splashLoadAd", "Error deleting file " + file2 + " for trimming cache");
                    }
                    if (a(file2, b2, size)) {
                        j.c("splashLoadAd", "停止删除 当前总个数 totalCount：" + size + " 最大值存储上限个数 maxCount " + this.f30893a + " 最小个数 " + this.f30894b);
                        return;
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.d.b
    public boolean a(long j, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2)})) == null) ? i2 <= this.f30893a : invokeCommon.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.d.b
    public boolean a(File file, long j, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{file, Long.valueOf(j), Integer.valueOf(i2)})) == null) ? i2 <= this.f30894b : invokeCommon.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.d.b
    public void a(List<File> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            if (this.f30895c) {
                d(list);
                this.f30895c = false;
                return;
            }
            c(list);
        }
    }

    public c(int i2, int i3, boolean z) {
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
        this.f30893a = 15;
        this.f30894b = 3;
        if (i2 > 0) {
            this.f30893a = i2;
            this.f30894b = i3;
            this.f30895c = z;
            return;
        }
        throw new IllegalArgumentException("Max count must be positive number!");
    }
}
