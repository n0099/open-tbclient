package com.baidu.tieba.pb.pb.main.relatelist;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.RelateRecThread.DataRes;
import tbclient.RelateRecThread.RelateRecThreadResIdl;
/* loaded from: classes5.dex */
public class RelateRecThreadSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DataRes mData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RelateRecThreadSocketResponseMessage() {
        super(309701);
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
            try {
                RelateRecThreadResIdl relateRecThreadResIdl = (RelateRecThreadResIdl) new Wire(new Class[0]).parseFrom(bArr, RelateRecThreadResIdl.class);
                if (relateRecThreadResIdl != null && relateRecThreadResIdl.error != null) {
                    setError(relateRecThreadResIdl.error.errorno.intValue());
                    setErrorString(relateRecThreadResIdl.error.usermsg);
                }
                if (relateRecThreadResIdl != null) {
                    this.mData = relateRecThreadResIdl.data;
                }
                return relateRecThreadResIdl;
            } catch (Exception e) {
                e.printStackTrace();
                setError(-2);
                return null;
            }
        }
        return invokeIL.objValue;
    }

    public DataRes getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mData : (DataRes) invokeV.objValue;
    }
}
