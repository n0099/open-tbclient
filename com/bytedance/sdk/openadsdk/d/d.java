package com.bytedance.sdk.openadsdk.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.j;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes6.dex */
public class d extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f30896a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f30897b;

    public d() {
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
        this.f30896a = 83886080L;
        this.f30897b = false;
    }

    private void c(List<File> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, this, list) == null) || list == null || list.size() == 0) {
            return;
        }
        long b2 = b(list);
        j.c("TotalSizeLruDiskUsage", "当前缓存文件的总size：" + ((b2 / 1024) / 1024) + "MB");
        int size = list.size();
        boolean a2 = a(b2, size);
        if (a2) {
            j.c("TotalSizeLruDiskUsage", "不满足删除条件，不执行删除操作(true)" + a2);
        } else {
            j.c("TotalSizeLruDiskUsage", "满足删除条件，开始执行删除操作(false)" + a2);
        }
        for (File file : list) {
            if (!a2) {
                j.c("TotalSizeLruDiskUsage", "满足删除条件开始删除文件......................");
                long length = file.length();
                if (file.delete()) {
                    size--;
                    b2 -= length;
                    j.c("TotalSizeLruDiskUsage", "删除 一个 Cache file 当前总大小totalSize：" + ((b2 / 1024) / 1024) + "MB");
                } else {
                    j.f("TotalSizeLruDiskUsage", "Error deleting file " + file + " for trimming cache");
                }
                boolean a3 = a(file, b2, size);
                if (a3) {
                    j.c("TotalSizeLruDiskUsage", "当前总大小totalSize：" + ((b2 / 1024) / 1024) + "MB，最大值存储上限maxSize=" + ((this.f30896a / 1024) / 1024) + "MB，当前文件的总大小totalSize已小于等于maxSize一半，停止删除操作：minStopDeleteCondition=" + a3);
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
            boolean a2 = a(b2, list.size());
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
                    long longValue = ((Long) entry.getKey()).longValue();
                    j.f("splashLoadAd", "lruDeleteFile deleting fileTime " + longValue);
                    File file2 = (File) entry.getValue();
                    long length = file2.length();
                    if (file2.delete()) {
                        b2 -= length;
                        j.c("splashLoadAd", "删除 一个 Cache file 当前总大小totalSize：" + ((((float) b2) / 1024.0f) / 1024.0f) + "MB");
                    } else {
                        j.f("splashLoadAd", "Error deleting file " + file2 + " for trimming cache");
                    }
                    boolean a3 = a(b2);
                    if (a3) {
                        j.c("splashLoadAd", "当前总大小totalSize：" + ((((float) b2) / 1024.0f) / 1024.0f) + "MB，最大值存储上限maxSize=" + ((((float) this.f30896a) / 1024.0f) / 1024.0f) + "MB，当前文件的总大小totalSize已小于等于maxSize的80%，停止删除操作：minStopDeleteCondition=" + a3);
                        return;
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.d.b
    public File a(String str, File file) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, file)) == null) {
            return null;
        }
        return (File) invokeLL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.d.b
    public boolean a(long j, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2)})) == null) ? j < this.f30896a : invokeCommon.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.d.b
    public boolean a(File file, long j, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{file, Long.valueOf(j), Integer.valueOf(i2)})) == null) {
            j.f("splashLoadAd", "缓存的最大内存 maxSize " + this.f30896a);
            return j < this.f30896a / 2;
        }
        return invokeCommon.booleanValue;
    }

    public d(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f30896a = j;
        if (j <= 0) {
            this.f30896a = 83886080L;
        }
        this.f30897b = z;
    }

    @Override // com.bytedance.sdk.openadsdk.d.b
    public void a(List<File> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            if (this.f30897b) {
                d(list);
            } else {
                c(list);
            }
        }
    }

    public boolean a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
            j.f("splashLoadAd", "缓存的最大内存 maxSize " + this.f30896a + " 最小内存 minSize 18874368");
            return j <= 18874368;
        }
        return invokeJ.booleanValue;
    }
}
