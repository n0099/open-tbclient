package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.os.Environment;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.launch.stats.ActivitySpeedStats;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
/* loaded from: classes9.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static final class a implements Comparator<File> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        private int a(long j2, long j3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
                int i2 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
                if (i2 < 0) {
                    return -1;
                }
                return i2 == 0 ? 0 : 1;
            }
            return invokeCommon.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, file2)) == null) ? a(file.lastModified(), file2.lastModified()) : invokeLL.intValue;
        }
    }

    public static File a(Context context, boolean z, String str, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, Boolean.valueOf(z), str, str2})) == null) {
            String a2 = a(context);
            if (z) {
                str = "/" + r.a(context) + "-" + str;
            }
            String str3 = a2 + str;
            File file = new File(str3);
            if (!file.exists()) {
                file.mkdirs();
            }
            return new File(str3, str2);
        }
        return (File) invokeCommon.objValue;
    }

    public static File b(Context context, boolean z, String str, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{context, Boolean.valueOf(z), str, str2})) == null) {
            String b2 = b(context);
            if (z) {
                str = "/" + r.a(context) + "-" + str;
            }
            String str3 = b2 + str;
            File file = new File(str3);
            if (!file.exists()) {
                file.mkdirs();
            }
            return new File(str3, str2);
        }
        return (File) invokeCommon.objValue;
    }

    public static void c(File file) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65545, null, file) == null) && file != null && file.exists()) {
            try {
                if (file.isFile()) {
                    file.delete();
                } else {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null && listFiles.length > 0) {
                        for (File file2 : listFiles) {
                            if (file2.isDirectory()) {
                                c(file2);
                            } else {
                                try {
                                    file2.delete();
                                } catch (Throwable unused) {
                                }
                            }
                        }
                    }
                    file.delete();
                }
            } catch (Throwable unused2) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x004e, code lost:
        if (r2 == null) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] d(File file) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, file)) == null) {
            if (file != null && file.isFile() && file.exists() && file.canRead() && file.length() > 0) {
                try {
                    Long valueOf = Long.valueOf(file.length());
                    fileInputStream = new FileInputStream(file);
                    try {
                        byte[] bArr = new byte[valueOf.intValue()];
                        if (fileInputStream.read(bArr) == valueOf.longValue()) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable unused) {
                            }
                            return bArr;
                        }
                    } catch (Throwable unused2) {
                    }
                } catch (Throwable unused3) {
                    fileInputStream = null;
                }
                try {
                    fileInputStream.close();
                } catch (Throwable unused4) {
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }

    public static void e(File file) throws IOException {
        RandomAccessFile randomAccessFile;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, file) == null) {
            long length = file.length();
            if (length == 0) {
                f(file);
                return;
            }
            RandomAccessFile randomAccessFile2 = null;
            try {
                randomAccessFile = new RandomAccessFile(file, "rwd");
                j2 = length - 1;
            } catch (Throwable unused) {
            }
            try {
                randomAccessFile.seek(j2);
                byte readByte = randomAccessFile.readByte();
                randomAccessFile.seek(j2);
                randomAccessFile.write(readByte);
                randomAccessFile.close();
            } catch (Throwable unused2) {
                randomAccessFile2 = randomAccessFile;
                if (randomAccessFile2 != null) {
                    randomAccessFile2.close();
                }
            }
        }
    }

    public static void f(File file) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, file) == null) {
            if (file.delete() && file.createNewFile()) {
                return;
            }
            throw new IOException("Error recreate zero-size file " + file);
        }
    }

    public static File a(Context context, boolean z, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{context, Boolean.valueOf(z), str})) == null) {
            String a2 = a(context);
            if (z) {
                str = "/" + r.a(context) + "-" + str;
            }
            File file = new File(a2 + str);
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
        return (File) invokeCommon.objValue;
    }

    public static File b(Context context, boolean z, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{context, Boolean.valueOf(z), str})) == null) {
            String absolutePath = context.getCacheDir().getAbsolutePath();
            if (z) {
                str = "/" + r.a(context) + "-" + str;
            }
            File file = new File(absolutePath + str);
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
        return (File) invokeCommon.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0019, code lost:
        if (android.os.Environment.isExternalStorageRemovable() == false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (context == null) {
                return null;
            }
            boolean z = false;
            try {
                if (!"mounted".equals(Environment.getExternalStorageState())) {
                }
                z = true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
            File externalCacheDir = z ? context.getExternalCacheDir() : null;
            if (externalCacheDir == null) {
                externalCacheDir = context.getCacheDir();
            }
            if (externalCacheDir == null) {
                return null;
            }
            return externalCacheDir.getPath();
        }
        return (String) invokeL.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        File cacheDir;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            if (context == null || (cacheDir = context.getCacheDir()) == null) {
                return null;
            }
            return cacheDir.getPath();
        }
        return (String) invokeL.objValue;
    }

    public static void b(File file) throws IOException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, null, file) == null) && file.exists()) {
            k.f(ActivitySpeedStats.SPLASH_LOADAD_DURATION, "当文件存在更新文件的修改时间");
            long currentTimeMillis = System.currentTimeMillis();
            if (file.setLastModified(currentTimeMillis)) {
                return;
            }
            e(file);
            if (file.lastModified() < currentTimeMillis) {
                k.d("Files", "Last modified date " + new Date(file.lastModified()) + " is not set for file " + file.getAbsolutePath());
            }
        }
    }

    public static List<File> a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, file)) == null) {
            LinkedList linkedList = new LinkedList();
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                List<File> asList = Arrays.asList(listFiles);
                Collections.sort(asList, new a());
                return asList;
            }
            return linkedList;
        }
        return (List) invokeL.objValue;
    }

    public static void a(File file, int i2, Set<String> set) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, file, i2, set) == null) || i2 < 0 || !file.exists() || file.isFile()) {
            return;
        }
        try {
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length <= i2) {
                return;
            }
            List asList = Arrays.asList(listFiles);
            Collections.sort(asList, new Comparator<File>() { // from class: com.bytedance.sdk.component.utils.f.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(File file2, File file3) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, file2, file3)) == null) {
                        int i3 = ((file3.lastModified() - file2.lastModified()) > 0L ? 1 : ((file3.lastModified() - file2.lastModified()) == 0L ? 0 : -1));
                        if (i3 == 0) {
                            return 0;
                        }
                        return i3 < 0 ? -1 : 1;
                    }
                    return invokeLL.intValue;
                }
            });
            while (i2 < asList.size()) {
                File file2 = (File) asList.get(i2);
                if (set != null && !set.contains(file2.getAbsolutePath())) {
                    ((File) asList.get(i2)).delete();
                }
                i2++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
