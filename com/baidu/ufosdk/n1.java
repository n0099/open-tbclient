package com.baidu.ufosdk;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.StatFs;
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
import java.util.Comparator;
@SuppressLint({"DefaultLocale"})
/* loaded from: classes9.dex */
public class n1 {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public static n1 b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public class a implements Comparator<File> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(n1 n1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, file2)) == null) {
                File file3 = file;
                File file4 = file2;
                if (file3.lastModified() > file4.lastModified()) {
                    return 1;
                }
                if (file3.lastModified() == file4.lastModified()) {
                    return 0;
                }
                return -1;
            }
            return invokeLL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1174240147, "Lcom/baidu/ufosdk/n1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1174240147, "Lcom/baidu/ufosdk/n1;");
                return;
            }
        }
        a = Environment.getExternalStorageDirectory().getPath() + "/image_cache";
        b = null;
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (Environment.getExternalStorageState().equals("mounted")) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return (int) ((statFs.getAvailableBlocks() * statFs.getBlockSize()) / 1048576.0d);
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public n1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static Bitmap a(String str) {
        InterceptResult invokeL;
        Bitmap decodeFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            String str2 = a + "/cache/image/" + str;
            if (!new File(str2).exists() || (decodeFile = BitmapFactory.decodeFile(str2, null)) == null) {
                return null;
            }
            new File(a + "/cache/image/", str2).setLastModified(System.currentTimeMillis());
            return decodeFile;
        }
        return (Bitmap) invokeL.objValue;
    }

    public void a(Bitmap bitmap, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bitmap, str) == null) {
            try {
                boolean equals = Environment.getExternalStorageState().equals("mounted");
                if (!equals) {
                    return;
                }
                File file = new File(a + "/cache/image/" + str);
                if (20 > a()) {
                    return;
                }
                File[] listFiles = new File(a + "/cache/image/").listFiles();
                if (listFiles != null) {
                    int i = 0;
                    for (File file2 : listFiles) {
                        i = (int) (i + file2.length());
                    }
                    if (i > 20971520 || 20 > a()) {
                        int length = (int) ((listFiles.length * 0.4d) + 1.0d);
                        Arrays.sort(listFiles, new a(this));
                        for (int i2 = 0; i2 < length; i2++) {
                            listFiles[i2].delete();
                        }
                    }
                }
                if (equals) {
                    File file3 = new File(a);
                    File file4 = new File(a + "/cache");
                    File file5 = new File(a + "/cache/image");
                    if (!file3.exists()) {
                        file3.mkdir();
                    }
                    if (!file4.exists()) {
                        file4.mkdir();
                    }
                    if (!file5.exists()) {
                        file5.mkdir();
                    }
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                }
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, bufferedOutputStream);
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
