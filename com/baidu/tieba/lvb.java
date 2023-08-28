package com.baidu.tieba;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes7.dex */
public class lvb implements fvb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public final String b;

    public lvb(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        this.b = str;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            try {
                return "agc_" + avb.c(b(str.getBytes("UTF-8")));
            } catch (UnsupportedEncodingException | NoSuchAlgorithmException unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static byte[] b(byte[] bArr) throws NoSuchAlgorithmException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) ? MessageDigest.getInstance("SHA-256").digest(bArr) : (byte[]) invokeL.objValue;
    }

    @Override // com.baidu.tieba.fvb
    public String a(String str, String str2) {
        InterceptResult invokeLL;
        int identifier;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            String a = a(str);
            if (TextUtils.isEmpty(a) || (identifier = this.a.getResources().getIdentifier(a, EMABTest.TYPE_STRING, this.b)) == 0) {
                return str2;
            }
            try {
                return this.a.getResources().getString(identifier);
            } catch (Resources.NotFoundException unused) {
                return str2;
            }
        }
        return (String) invokeLL.objValue;
    }
}
