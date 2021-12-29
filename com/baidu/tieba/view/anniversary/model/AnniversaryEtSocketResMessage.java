package com.baidu.tieba.view.anniversary.model;

import c.a.t0.n4.i.d.b;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.VideoTemplate.VideoTemplateResIdl;
/* loaded from: classes12.dex */
public class AnniversaryEtSocketResMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b resultData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnniversaryEtSocketResMessage() {
        super(309725);
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

    public b getResultData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.resultData : (b) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        VideoTemplateResIdl videoTemplateResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) || (videoTemplateResIdl = (VideoTemplateResIdl) new Wire(new Class[0]).parseFrom(bArr, VideoTemplateResIdl.class)) == null) {
            return;
        }
        Error error = videoTemplateResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(videoTemplateResIdl.error.usermsg);
        }
        if (videoTemplateResIdl.data != null) {
            b bVar = new b();
            this.resultData = bVar;
            bVar.g(videoTemplateResIdl.data);
        }
    }
}
