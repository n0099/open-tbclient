package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.system.Os;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.rtc.RTCConst;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
/* loaded from: classes8.dex */
public class yr4 implements vr4<String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    public yr4(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context.getApplicationContext();
    }

    @Override // com.baidu.tieba.vr4
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return !new File(this.a.getFilesDir(), "libuuid.so").exists();
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.vr4
    /* renamed from: b */
    public String get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return d();
        }
        return (String) invokeV.objValue;
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            File file = new File(this.a.getFilesDir(), "libuuid.so");
            if (!file.exists()) {
                return null;
            }
            return bs4.c(file);
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.vr4
    /* renamed from: c */
    public void put(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            e(str);
        }
    }

    @SuppressLint({"WorldReadableFiles"})
    @TargetApi(21)
    public final void e(String str) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            File file = new File(this.a.getFilesDir(), "libuuid.so");
            if (Build.VERSION.SDK_INT >= 24) {
                i = 1;
            } else {
                i = 0;
            }
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    fileOutputStream = this.a.openFileOutput("libuuid.so", i ^ 1);
                    fileOutputStream.write(str.getBytes());
                    fileOutputStream.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (i != 0) {
                    try {
                        Os.chmod(file.getAbsolutePath(), RTCConst.RTC_ROOM_USERID_ALREADY_EXIST_ERROR);
                    } catch (Exception unused) {
                    }
                }
            } finally {
                bs4.a(fileOutputStream);
            }
        }
    }
}
