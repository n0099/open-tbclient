package com.baidu.tieba.pb.data;

import androidx.annotation.Nullable;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.ThreadPublish.ThreadPublishResIdl;
/* loaded from: classes7.dex */
public class ThreadPublishSocketResMessage extends TbSocketReponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadPublishSocketResMessage() {
        super(309644);
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
            ThreadPublishResIdl threadPublishResIdl = (ThreadPublishResIdl) new Wire(new Class[0]).parseFrom(bArr, ThreadPublishResIdl.class);
            if (threadPublishResIdl != null) {
                setError(threadPublishResIdl.error.errorno.intValue());
                setErrorString(threadPublishResIdl.error.usermsg);
            }
            return threadPublishResIdl;
        }
        return invokeIL.objValue;
    }
}
