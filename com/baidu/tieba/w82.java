package com.baidu.tieba;

import android.os.Environment;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.Channels;
/* loaded from: classes6.dex */
public class w82 extends t82 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public File b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948224376, "Lcom/baidu/tieba/w82;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948224376, "Lcom/baidu/tieba/w82;");
                return;
            }
        }
        c = ij1.a;
    }

    public w82() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = o();
    }

    @Override // com.baidu.tieba.t82
    public boolean e(u82 u82Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, u82Var)) == null) {
            if (u82Var != null && this.b.exists()) {
                File file = this.b;
                File file2 = new File(file, u82Var.g + File.separator + u82Var.q);
                if (file2.exists()) {
                    try {
                        if (!d(Channels.newChannel(new FileInputStream(file2)), u82Var.m)) {
                            if (c) {
                                Log.e("SdCardPresetController", "校验签名失败");
                            }
                            return false;
                        }
                        File j = j(u82Var.h, u82Var.g, u82Var.i);
                        if (j == null) {
                            if (c) {
                                Log.e("SdCardPresetController", "获取解压路径失败");
                            }
                            return false;
                        }
                        return n(new BufferedInputStream(new FileInputStream(file2)), j);
                    } catch (IOException e) {
                        if (c) {
                            e.printStackTrace();
                        }
                        return false;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.t82
    public String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (this.b.exists()) {
                File file = this.b;
                File file2 = new File(file, str + File.separator + "app_info.json");
                if (file2.exists()) {
                    return cj4.E(file2);
                }
                return null;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.t82
    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.b.exists()) {
                File file = new File(this.b, "preset_list.json");
                if (file.exists()) {
                    return cj4.E(file);
                }
                return null;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public final File o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new File(Environment.getExternalStorageDirectory().getPath(), "baidu/swan_preset/") : (File) invokeV.objValue;
    }
}
