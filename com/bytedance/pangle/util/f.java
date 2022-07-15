package com.bytedance.pangle.util;

import android.content.Context;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
/* loaded from: classes4.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public static String b;
    public static final byte[] c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1401945108, "Lcom/bytedance/pangle/util/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1401945108, "Lcom/bytedance/pangle/util/f;");
                return;
            }
        }
        c = new byte[4194304];
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) {
            a(new File(str));
        }
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        File parentFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            if (b == null && (parentFile = context.getCacheDir().getParentFile()) != null) {
                try {
                    b = parentFile.getCanonicalPath();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return b;
        }
        return (String) invokeL.objValue;
    }

    public static void a(File file) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, file) == null) && file != null && file.exists()) {
            if (Build.VERSION.SDK_INT >= 26) {
                try {
                    Files.walkFileTree(Paths.get(file.getAbsolutePath(), new String[0]), new SimpleFileVisitor<Path>() { // from class: com.bytedance.pangle.util.g.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                }
                            }
                        }

                        public static FileVisitResult a(Path path) {
                            InterceptResult invokeL;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeL = interceptable2.invokeL(65537, null, path)) == null) {
                                if (path != null) {
                                    try {
                                        Files.deleteIfExists(path);
                                    } catch (IOException unused) {
                                    }
                                }
                                return FileVisitResult.CONTINUE;
                            }
                            return (FileVisitResult) invokeL.objValue;
                        }

                        public static FileVisitResult b(Path path) {
                            InterceptResult invokeL;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeL = interceptable2.invokeL(65538, null, path)) == null) {
                                if (path != null) {
                                    try {
                                        Files.deleteIfExists(path);
                                    } catch (IOException unused) {
                                    }
                                }
                                return FileVisitResult.CONTINUE;
                            }
                            return (FileVisitResult) invokeL.objValue;
                        }

                        @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
                        public final /* synthetic */ FileVisitResult postVisitDirectory(Object obj, IOException iOException) {
                            return b((Path) obj);
                        }

                        @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
                        public final /* bridge */ /* synthetic */ FileVisitResult preVisitDirectory(Object obj, BasicFileAttributes basicFileAttributes) {
                            return FileVisitResult.CONTINUE;
                        }

                        @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
                        public final /* synthetic */ FileVisitResult visitFile(Object obj, BasicFileAttributes basicFileAttributes) {
                            return a((Path) obj);
                        }

                        @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
                        public final /* bridge */ /* synthetic */ FileVisitResult visitFileFailed(Object obj, IOException iOException) {
                            return FileVisitResult.CONTINUE;
                        }
                    });
                    return;
                } catch (IOException unused) {
                    return;
                }
            }
            if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    a(file2);
                }
            }
            file.delete();
        }
    }

    public static void a(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        File parentFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (a == null && (parentFile = context.getCacheDir().getParentFile()) != null) {
                a = parentFile.getAbsolutePath();
            }
            return a;
        }
        return (String) invokeL.objValue;
    }
}
