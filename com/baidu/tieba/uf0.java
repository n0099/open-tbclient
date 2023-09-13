package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Environment;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.utils.FileUtils;
import java.io.File;
import java.util.Objects;
/* loaded from: classes8.dex */
public class uf0 {
    public static /* synthetic */ Interceptable $ic;
    public static uf0 h;
    public transient /* synthetic */ FieldHolder $fh;
    public File a;
    public File b;
    public File c;
    public File d;
    public File e;
    public File f;
    public File g;

    public uf0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            synchronized (uf0.class) {
                if (h == null) {
                    h = new uf0();
                }
            }
        }
    }

    public static uf0 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (h == null) {
                a();
            }
            return h;
        }
        return (uf0) invokeV.objValue;
    }

    public static File f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return d().g;
        }
        return (File) invokeV.objValue;
    }

    public File g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (File) invokeV.objValue;
    }

    public File h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (File) invokeV.objValue;
    }

    public static File b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65538, null, z)) == null) {
            if (z) {
                return d().f;
            }
            return d().e;
        }
        return (File) invokeZ.objValue;
    }

    public static File e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            File file = new File(context.getFilesDir(), FileUtils.DIR_DUAR);
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
        return (File) invokeL.objValue;
    }

    @SuppressLint({"NewApi"})
    public File c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            if (Environment.getExternalStorageState().equals("mounted")) {
                return ((Context) Objects.requireNonNull(context)).getExternalFilesDir(FileUtils.DIR_DUAR);
            }
            return null;
        }
        return (File) invokeL.objValue;
    }

    public void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            this.a = e(context);
            File c = c(context);
            this.b = c;
            if (c == null) {
                this.b = this.a;
            }
            if (this.b != null) {
                this.c = new File(this.b, "sdk");
                File file = new File(this.c, "arsource");
                this.d = file;
                if (!file.exists()) {
                    this.d.mkdirs();
                }
            }
            if (this.a != null) {
                new File(this.a, "sdk");
                File file2 = new File(this.a, "sdklibs/armeabi-v7a");
                this.e = file2;
                if (!file2.exists()) {
                    this.e.mkdirs();
                }
                File file3 = new File(this.a, "sdklibs/arm64-v8a");
                this.f = file3;
                if (!file3.exists()) {
                    this.f.mkdirs();
                }
                File file4 = new File(this.a, "sdklibs/armeabi-v7a-2");
                this.g = file4;
                if (!file4.exists()) {
                    this.g.mkdirs();
                }
            }
        }
    }
}
