package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import c.a.o0.s.f.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import protobuf.SetLocation.DataRes;
import protobuf.SetLocation.LbsInfo;
import protobuf.SetLocation.SetLocationResIdl;
/* loaded from: classes5.dex */
public class ResponsePersonalLbsInfoMessage extends TbSocketReponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b lbsInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponsePersonalLbsInfoMessage() {
        super(205101);
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

    public b getLbsInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.lbsInfo : (b) invokeV.objValue;
    }

    public void setLbsInfo(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.lbsInfo = bVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.websockt.TbSocketReponsedMessage, com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        SetLocationResIdl setLocationResIdl;
        DataRes dataRes;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) || (setLocationResIdl = (SetLocationResIdl) new Wire(new Class[0]).parseFrom(bArr, SetLocationResIdl.class)) == null || (dataRes = setLocationResIdl.data) == null) {
            return;
        }
        LbsInfo lbsInfo = dataRes.location;
        long j = 0;
        int i2 = -1;
        if (lbsInfo != null) {
            str = lbsInfo.distance;
            Long l = lbsInfo.time;
            if (l != null && l.longValue() > 0) {
                j = setLocationResIdl.data.location.time.longValue();
            }
            Integer num = setLocationResIdl.data.location.isHide;
            if (num != null && num.intValue() >= 0) {
                i2 = setLocationResIdl.data.location.isHide.intValue();
            }
        } else {
            str = "";
        }
        this.lbsInfo = new b(str, j, i2);
    }
}
