package com.baidu.ufosdk.f;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.StatFs;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
@SuppressLint({"DefaultLocale"})
/* loaded from: classes8.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static String f59218c;

    /* renamed from: d  reason: collision with root package name */
    public static f f59219d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f59220a;

    /* renamed from: b  reason: collision with root package name */
    public final String f59221b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2041467331, "Lcom/baidu/ufosdk/f/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2041467331, "Lcom/baidu/ufosdk/f/f;");
                return;
            }
        }
        f59218c = Environment.getExternalStorageDirectory().getPath() + "/image_cache";
        f59219d = null;
    }

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f59221b = "ufo";
        this.f59220a = 1209600000;
    }

    public static Bitmap a(String str) {
        InterceptResult invokeL;
        Bitmap decodeFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            String b2 = b(str);
            if (new File(b2).exists() && (decodeFile = BitmapFactory.decodeFile(b2, null)) != null) {
                new File(f59218c + "/cache/image/", b2).setLastModified(System.currentTimeMillis());
                return decodeFile;
            }
            return null;
        }
        return (Bitmap) invokeL.objValue;
    }

    public static f a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f59219d == null) {
                f59219d = new f();
            }
            return f59219d;
        }
        return (f) invokeV.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            return f59218c + "/cache/image/" + str;
        }
        return (String) invokeL.objValue;
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            String str = f59218c + "/cache/image/";
            File[] listFiles = new File(str).listFiles();
            if (listFiles == null) {
                return;
            }
            c.b("ufo ->Clear all cache files,dir=" + str);
            for (File file : listFiles) {
                file.delete();
            }
        }
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            if (Environment.getExternalStorageState().equals("mounted")) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return (int) ((statFs.getAvailableBlocks() * statFs.getBlockSize()) / 1048576.0d);
            }
            c.a("sdCard is not exist");
            return 0;
        }
        return invokeV.intValue;
    }

    private void c(String str) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, this, str) == null) || (listFiles = new File(str).listFiles()) == null) {
            return;
        }
        int i2 = 0;
        for (File file : listFiles) {
            i2 = (int) (i2 + file.length());
        }
        if (i2 > 20971520 || 20 > c()) {
            int length = (int) ((listFiles.length * 0.4d) + 1.0d);
            Arrays.sort(listFiles, new g(this));
            c.b("ufo ->Clear some expiredcache files");
            for (int i3 = 0; i3 < length; i3++) {
                listFiles[i3].delete();
            }
        }
    }

    public final void a(Bitmap bitmap, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bitmap, str) == null) {
            try {
                boolean equals = Environment.getExternalStorageState().equals("mounted");
                if (equals) {
                    File file = new File(b(str));
                    if (20 > c()) {
                        c.c("ufo ->Low free space onsd, do not cache");
                        return;
                    }
                    c(f59218c + "/cache/image/");
                    if (equals) {
                        File file2 = new File(f59218c);
                        File file3 = new File(f59218c + "/cache");
                        File file4 = new File(f59218c + "/cache/image");
                        if (!file2.exists()) {
                            file2.mkdir();
                        }
                        if (!file3.exists()) {
                            file3.mkdir();
                        }
                        if (!file4.exists()) {
                            file4.mkdir();
                        }
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                    }
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, bufferedOutputStream);
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
