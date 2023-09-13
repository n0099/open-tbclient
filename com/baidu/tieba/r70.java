package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.retrieve.RetrieveReportRequest;
import com.baidu.searchbox.logsystem.basic.upload.BaseContentUploader;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class r70 implements p70, q70 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

    @Override // com.baidu.tieba.p70
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "application/octet-stream" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.p70
    public String getMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "POST" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.p70
    public byte[] getRequestParameter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (byte[]) invokeV.objValue;
    }

    public r70(Context context) {
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

    @Override // com.baidu.tieba.q70
    public void a(int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, bArr) == null) {
            String str = new String(bArr);
            x70.a("UBCRequest", "ubc upload errorcode:" + i + ", resultContent:" + str);
        }
    }

    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("action=");
            sb.append("zubc");
            sb.append("&appname=");
            sb.append(RetrieveReportRequest.APP_NAME);
            sb.append("&uid=");
            sb.append(n70.d().a());
            sb.append("&ua=");
            sb.append(y70.e(this.a));
            sb.append("&appversion=");
            sb.append(y70.f(this.a));
            if (n70.d().c() != v70.a) {
                sb.append("&debug=");
                sb.append("1");
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.p70
    public Map<String, String> getHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put(BaseContentUploader.NB, "1");
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.tieba.p70
    public String getHost() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (n70.d().c() != v70.a) {
                str = "http://bjyz-mco-searchbox201609-m12xi3-044.bjyz.baidu.com:8080/ztbox";
            } else {
                str = "https://tcbox.baidu.com/ztbox";
            }
            return str + "?" + b();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.q70
    public void onSuccess(int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i, bArr) == null) {
            String str = new String(bArr);
            x70.a("UBCRequest", "ubc upload errorcode:" + i + ", resultContent:" + str);
        }
    }
}
