package com.baidu.tieba.quickWebView.message;

import android.text.TextUtils;
import c.a.t0.h3.e.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
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
/* loaded from: classes12.dex */
public class WebViewCacheResSocketMsg extends TbSocketReponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, a> mModuleInfos;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewCacheResSocketMsg() {
        super(309485);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public Map<String, a> getModuleInfos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mModuleInfos : (Map) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.websockt.TbSocketReponsedMessage, com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) {
            GetWebviewCacheInfoResIdl getWebviewCacheInfoResIdl = (GetWebviewCacheInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, GetWebviewCacheInfoResIdl.class);
            setError(getWebviewCacheInfoResIdl.error.errorno.intValue());
            setErrorString(getWebviewCacheInfoResIdl.error.usermsg);
            if (this.mModuleInfos == null) {
                this.mModuleInfos = new HashMap();
            }
            if (getError() != 0 || ListUtils.isEmpty(getWebviewCacheInfoResIdl.data.offpack_list)) {
                return;
            }
            this.mModuleInfos.clear();
            for (Offpack offpack : getWebviewCacheInfoResIdl.data.offpack_list) {
                if (offpack != null && !TextUtils.isEmpty(offpack.mod_name)) {
                    a aVar = new a();
                    aVar.e(offpack);
                    this.mModuleInfos.put(offpack.mod_name, aVar);
                }
            }
        }
    }
}
