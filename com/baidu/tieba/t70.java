package com.baidu.tieba;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.BaseContentUploader;
import com.baidu.searchbox.logsystem.basic.upload.identity.NetworkParam;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public final class t70 implements r70, s70 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

    public t70(Context context) {
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
        this.a = context;
    }

    @Override // com.baidu.tieba.r70
    public final String a() {
        InterceptResult invokeV;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String str = p70.d().c() != w70.a ? "http://bjyz-mco-searchbox201609-m12xi3-044.bjyz.baidu.com:8080/ztbox" : "https://tcbox.baidu.com/ztbox";
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("?");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("action=zubc");
            sb2.append("&appname=imsdk");
            sb2.append("&uid=");
            sb2.append(p70.d().a());
            sb2.append("&ua=");
            Context context = this.a;
            DisplayMetrics a = b80.a(context);
            int i = a != null ? a.widthPixels : 0;
            DisplayMetrics a2 = b80.a(context);
            int i2 = a2 != null ? a2.heightPixels : 0;
            DisplayMetrics a3 = b80.a(context);
            int i3 = a3 != null ? a3.densityDpi : 0;
            sb2.append(i + "_" + i2 + "_android_" + b80.b(context) + "_" + i3);
            sb2.append("&ut=");
            String str2 = Build.MODEL;
            String replace = TextUtils.isEmpty(str2) ? "NUL" : str2.replace("_", "-");
            String str3 = Build.VERSION.RELEASE;
            String replace2 = TextUtils.isEmpty(str3) ? "0.0" : str3.replace("_", "-");
            int i4 = Build.VERSION.SDK_INT;
            String str4 = Build.MANUFACTURER;
            sb2.append(replace + "_" + replace2 + "_" + i4 + "_" + (TextUtils.isEmpty(str4) ? "NUL" : str4.replace("_", "-")));
            sb2.append("&network=");
            z70 z70Var = new z70(this.a);
            boolean isEmpty = TextUtils.isEmpty(z70Var.a);
            String str5 = NetworkParam.NET_TYPE_ID_DISCONNECT;
            if (!isEmpty && (num = z70.c.get(z70Var.a)) != null) {
                str5 = num + "_" + z70Var.b;
            }
            if (str5 == null) {
                str5 = "unknown";
            }
            sb2.append(str5);
            sb2.append("&appversion=");
            sb2.append(b80.b(this.a));
            if (p70.d().c() != w70.a) {
                sb2.append("&debug=1");
            }
            sb.append(sb2.toString());
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.s70
    public final void a(int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            String str = new String(bArr);
            y70.a("UBCRequest", "ubc upload errorcode:" + i + ", resultContent:" + str);
        }
    }

    @Override // com.baidu.tieba.r70
    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "POST" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.s70
    public final void b(int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, bArr) == null) {
            String str = new String(bArr);
            y70.a("UBCRequest", "ubc upload errorcode:" + i + ", resultContent:" + str);
        }
    }

    @Override // com.baidu.tieba.r70
    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "application/octet-stream" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.r70
    public final Map<String, String> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put(BaseContentUploader.NB, "1");
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }
}
