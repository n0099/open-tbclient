package com.baidu.tieba.personExtra;

import b.a.r0.p2.e.q;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetRecommendGodList.GetRecommendGodListResIdl;
/* loaded from: classes9.dex */
public class RecommendGodSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public q recommendGodData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendGodSocketResponseMessage() {
        super(309684);
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        GetRecommendGodListResIdl getRecommendGodListResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) || (getRecommendGodListResIdl = (GetRecommendGodListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetRecommendGodListResIdl.class)) == null) {
            return;
        }
        Error error = getRecommendGodListResIdl.error;
        if (error != null) {
            Integer num = error.errorno;
            if (num != null) {
                setError(num.intValue());
            }
            setErrorString(getRecommendGodListResIdl.error.usermsg);
        }
        q qVar = new q();
        this.recommendGodData = qVar;
        qVar.b(getRecommendGodListResIdl.data);
    }
}
