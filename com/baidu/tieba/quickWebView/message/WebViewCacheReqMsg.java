package com.baidu.tieba.quickWebView.message;

import c.a.q0.d1.x;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.GetWebviewCacheInfo.DataReq;
import tbclient.GetWebviewCacheInfo.GetWebviewCacheInfoReqIdl;
/* loaded from: classes7.dex */
public class WebViewCacheReqMsg extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String mWebViewVersion;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewCacheReqMsg(String str) {
        super(CmdConfigHttp.WEBVIEW_CACHE_INFO, 309485);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mWebViewVersion = str;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            DataReq.Builder builder = new DataReq.Builder();
            builder.webview_version = this.mWebViewVersion;
            if (z) {
                x.a(builder, true);
            }
            GetWebviewCacheInfoReqIdl.Builder builder2 = new GetWebviewCacheInfoReqIdl.Builder();
            builder2.data = builder.build(true);
            return builder2.build(true);
        }
        return invokeZ.objValue;
    }

    public String getVersionNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mWebViewVersion : (String) invokeV.objValue;
    }
}
