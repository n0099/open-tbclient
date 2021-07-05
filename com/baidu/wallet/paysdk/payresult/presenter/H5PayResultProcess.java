package com.baidu.wallet.paysdk.payresult.presenter;

import android.content.Context;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.apollon.restnet.rest.httpurlconnection.RestUrlConnectionRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.payresult.datamodel.H5ResultParams;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class H5PayResultProcess {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public H5ResultParams mH5;
    public String mQueryResultString;

    public H5PayResultProcess() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String getProcessedParams(List<RestNameValuePair> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, list, str)) == null) {
            if (list == null || list.size() == 0) {
                return null;
            }
            String processedParams = new RestUrlConnectionRequest(null, null, null, list, null, str).getProcessedParams();
            if (processedParams != null) {
                try {
                    return URLEncoder.encode(processedParams, str);
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                    return processedParams;
                }
            }
            return processedParams;
        }
        return (String) invokeLL.objValue;
    }

    public abstract void afterShow();

    public abstract void beforeShow();

    public abstract void show();
}
