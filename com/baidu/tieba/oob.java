package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.SecretKey;
/* loaded from: classes7.dex */
public class oob implements qob {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final nob a;
    public SecretKey b;

    public oob(nob nobVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nobVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = nobVar;
        b();
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? !TextUtils.isEmpty(str) && Pattern.matches("^\\[!([A-Fa-f0-9]*)]", str) : invokeL.booleanValue;
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            try {
                Matcher matcher = Pattern.compile("^\\[!([A-Fa-f0-9]*)]").matcher(str);
                return matcher.find() ? matcher.group(1) : "";
            } catch (IllegalStateException | IndexOutOfBoundsException unused) {
                Log.e("ExclamationMark", "getRawString exception");
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.qob
    public String a(String str, String str2) {
        InterceptResult invokeLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            if (this.b == null) {
                str3 = "mKey is null, return default value";
            } else if (!c(str)) {
                return str2;
            } else {
                try {
                    return new String(sob.b(this.b, iob.b(d(str))), "UTF-8");
                } catch (UnsupportedEncodingException | IllegalArgumentException | GeneralSecurityException unused) {
                    str3 = "UnsupportedEncodingException||GeneralSecurityException||IllegalArgumentException";
                }
            }
            Log.e("ExclamationMark", str3);
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    public final SecretKey b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                String a = this.a.a("/code/code1", null);
                String a2 = this.a.a("/code/code2", null);
                String a3 = this.a.a("/code/code3", null);
                String a4 = this.a.a("/code/code4", null);
                if (a != null && a2 != null && a3 != null && a4 != null) {
                    this.b = sob.a(iob.b(a), iob.b(a2), iob.b(a3), iob.b(a4), 10000);
                }
            } catch (IllegalArgumentException | NoSuchAlgorithmException | InvalidKeySpecException unused) {
                Log.e("ExclamationMark", "Exception when reading the 'K&I' for 'Config'.");
                this.b = null;
            }
            return this.b;
        }
        return (SecretKey) invokeV.objValue;
    }
}
