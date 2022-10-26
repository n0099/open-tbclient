package com.baidu.tieba.ueg;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.QueryBlockAndAppealInfo.DataRes;
import tbclient.QueryBlockAndAppealInfo.QueryBlockAndAppealInfoResIdl;
/* loaded from: classes6.dex */
public class UEGCancelSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BlockPopInfoData info;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UEGCancelSocketResponseMessage() {
        super(309615);
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

    public BlockPopInfoData getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.info;
        }
        return (BlockPopInfoData) invokeV.objValue;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        QueryBlockAndAppealInfoResIdl queryBlockAndAppealInfoResIdl;
        String str;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            if (bArr == null || (queryBlockAndAppealInfoResIdl = (QueryBlockAndAppealInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, QueryBlockAndAppealInfoResIdl.class)) == null) {
                return null;
            }
            Error error = queryBlockAndAppealInfoResIdl.error;
            if (error != null && (num = error.errorno) != null) {
                setError(num.intValue());
            }
            Error error2 = queryBlockAndAppealInfoResIdl.error;
            if (error2 != null && (str = error2.usermsg) != null && str.length() > 0) {
                setErrorString(queryBlockAndAppealInfoResIdl.error.usermsg);
            }
            BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
            DataRes dataRes = queryBlockAndAppealInfoResIdl.data;
            blockPopInfoData.block_info = dataRes.block_info;
            blockPopInfoData.ahead_info = dataRes.ahead_info;
            blockPopInfoData.ahead_url = dataRes.ahead_url;
            blockPopInfoData.ok_info = dataRes.ok_info;
            blockPopInfoData.win_type = dataRes.win_type.intValue();
            blockPopInfoData.block_id_code = queryBlockAndAppealInfoResIdl.data.block_id_code;
            setData(blockPopInfoData);
            return queryBlockAndAppealInfoResIdl;
        }
        return invokeIL.objValue;
    }

    public void setData(BlockPopInfoData blockPopInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, blockPopInfoData) == null) {
            this.info = blockPopInfoData;
        }
    }
}
