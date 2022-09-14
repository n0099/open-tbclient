package com.baidu.tieba.view.anniversary.model;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.vy8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.VideoTemplate.VideoTemplateResIdl;
/* loaded from: classes6.dex */
public class AnniversaryEtSocketResMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vy8 resultData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnniversaryEtSocketResMessage() {
        super(309725);
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
            VideoTemplateResIdl videoTemplateResIdl = (VideoTemplateResIdl) new Wire(new Class[0]).parseFrom(bArr, VideoTemplateResIdl.class);
            if (videoTemplateResIdl != null) {
                Error error = videoTemplateResIdl.error;
                if (error != null) {
                    setError(error.errorno.intValue());
                    setErrorString(videoTemplateResIdl.error.usermsg);
                }
                if (videoTemplateResIdl.data != null) {
                    vy8 vy8Var = new vy8();
                    this.resultData = vy8Var;
                    vy8Var.g(videoTemplateResIdl.data);
                }
            }
            return videoTemplateResIdl;
        }
        return invokeIL.objValue;
    }

    public vy8 getResultData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.resultData : (vy8) invokeV.objValue;
    }
}
