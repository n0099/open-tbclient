package com.baidu.tieba.quickWebView.message;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.oq8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.HashMap;
import java.util.Map;
import tbclient.GetWebviewCacheInfo.GetWebviewCacheInfoResIdl;
import tbclient.GetWebviewCacheInfo.Offpack;
/* loaded from: classes6.dex */
public class WebViewCacheResHttpMsg extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, oq8> mModuleInfos;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewCacheResHttpMsg() {
        super(CmdConfigHttp.WEBVIEW_CACHE_INFO);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public Map<String, oq8> getModuleInfos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mModuleInfos;
        }
        return (Map) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            GetWebviewCacheInfoResIdl getWebviewCacheInfoResIdl = (GetWebviewCacheInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, GetWebviewCacheInfoResIdl.class);
            setError(getWebviewCacheInfoResIdl.error.errorno.intValue());
            setErrorString(getWebviewCacheInfoResIdl.error.usermsg);
            if (this.mModuleInfos == null) {
                this.mModuleInfos = new HashMap();
            }
            if (getError() == 0 && !ListUtils.isEmpty(getWebviewCacheInfoResIdl.data.offpack_list)) {
                this.mModuleInfos.clear();
                for (Offpack offpack : getWebviewCacheInfoResIdl.data.offpack_list) {
                    if (offpack != null && !TextUtils.isEmpty(offpack.mod_name)) {
                        oq8 oq8Var = new oq8();
                        oq8Var.e(offpack);
                        this.mModuleInfos.put(offpack.mod_name, oq8Var);
                    }
                }
            }
        }
    }
}
