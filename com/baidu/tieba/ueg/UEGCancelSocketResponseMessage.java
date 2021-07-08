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
/* loaded from: classes4.dex */
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

    public BlockPopInfoData getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.info : (BlockPopInfoData) invokeV.objValue;
    }

    public void setData(BlockPopInfoData blockPopInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, blockPopInfoData) == null) {
            this.info = blockPopInfoData;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        QueryBlockAndAppealInfoResIdl queryBlockAndAppealInfoResIdl;
        String str;
        Integer num;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) || bArr == null || (queryBlockAndAppealInfoResIdl = (QueryBlockAndAppealInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, QueryBlockAndAppealInfoResIdl.class)) == null) {
            return;
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
    }
}
