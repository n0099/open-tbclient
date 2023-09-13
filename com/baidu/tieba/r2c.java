package com.baidu.tieba;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public abstract class r2c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    public abstract void a(String str);

    public final boolean b(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap)) == null) {
            if (TextUtils.isEmpty(this.a)) {
                p2c.b.f("sendBitmap2MainProcess channelId is null");
                return false;
            }
            h2c a = h2c.c.a();
            String str = this.a;
            if (str == null) {
                Intrinsics.throwNpe();
            }
            return a.g(str, bitmap);
        }
        return invokeL.booleanValue;
    }

    public final boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (TextUtils.isEmpty(this.a)) {
                p2c.b.f("sendData2MainProcess: error channelId is empty or null");
                return false;
            }
            h2c a = h2c.c.a();
            String str2 = this.a;
            if (str2 == null) {
                Intrinsics.throwNpe();
            }
            return a.h(str2, str);
        }
        return invokeL.booleanValue;
    }
}
