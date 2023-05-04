package com.baidu.tieba.personExtra;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.x89;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetRecommendGodList.GetRecommendGodListResIdl;
/* loaded from: classes5.dex */
public class RecommendGodSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public x89 recommendGodData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendGodSocketResponseMessage() {
        super(309684);
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

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            GetRecommendGodListResIdl getRecommendGodListResIdl = (GetRecommendGodListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetRecommendGodListResIdl.class);
            if (getRecommendGodListResIdl == null) {
                return null;
            }
            Error error = getRecommendGodListResIdl.error;
            if (error != null) {
                Integer num = error.errorno;
                if (num != null) {
                    setError(num.intValue());
                }
                setErrorString(getRecommendGodListResIdl.error.usermsg);
            }
            x89 x89Var = new x89();
            this.recommendGodData = x89Var;
            x89Var.b(getRecommendGodListResIdl.data);
            return getRecommendGodListResIdl;
        }
        return invokeIL.objValue;
    }
}
