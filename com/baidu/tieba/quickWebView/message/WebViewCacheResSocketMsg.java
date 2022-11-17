package com.baidu.tieba.quickWebView.message;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.baidu.tieba.jf8;
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
/* loaded from: classes5.dex */
public class WebViewCacheResSocketMsg extends TbSocketReponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, jf8> mModuleInfos;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewCacheResSocketMsg() {
        super(309485);
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

    public Map<String, jf8> getModuleInfos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mModuleInfos;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
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
                        jf8 jf8Var = new jf8();
                        jf8Var.e(offpack);
                        this.mModuleInfos.put(offpack.mod_name, jf8Var);
                    }
                }
            }
            return getWebviewCacheInfoResIdl;
        }
        return invokeIL.objValue;
    }
}
