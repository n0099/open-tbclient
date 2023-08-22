package com.baidu.tieba.immessagecenter.mention.agree.message;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r45;
import com.baidu.tieba.vs8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import tbclient.AgreeList;
import tbclient.AgreeMe.AgreeMeResIdl;
import tbclient.AgreeMe.DataRes;
import tbclient.Error;
/* loaded from: classes6.dex */
public class AgreeMeSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<vs8> datas;
    public boolean hasMore;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgreeMeSocketResponseMessage() {
        super(309593);
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
        this.datas = new ArrayList<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) && !hasError() && (getOrginalMessage().getExtra() instanceof AgreeMeRequestMessage) && ((AgreeMeRequestMessage) getOrginalMessage().getExtra()).id == 0) {
            r45.k();
            r45.j("tb_user_agreeme", TbadkCoreApplication.getCurrentAccountName()).a("agree_me_cache_key", bArr);
        }
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        String str;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, bArr)) == null) {
            boolean z = false;
            AgreeMeResIdl agreeMeResIdl = (AgreeMeResIdl) new Wire(new Class[0]).parseFrom(bArr, AgreeMeResIdl.class);
            if (agreeMeResIdl == null) {
                return null;
            }
            Error error = agreeMeResIdl.error;
            if (error != null && (num = error.errorno) != null) {
                setError(num.intValue());
            }
            Error error2 = agreeMeResIdl.error;
            if (error2 != null && (str = error2.usermsg) != null && str.length() > 0) {
                setErrorString(agreeMeResIdl.error.usermsg);
            }
            if (getError() != 0) {
                return agreeMeResIdl;
            }
            DataRes dataRes = agreeMeResIdl.data;
            if (dataRes != null) {
                if (dataRes.has_more.intValue() == 1) {
                    z = true;
                }
                this.hasMore = z;
                for (AgreeList agreeList : agreeMeResIdl.data.agree_list) {
                    if (agreeList != null) {
                        vs8 vs8Var = new vs8();
                        vs8Var.D(agreeList);
                        this.datas.add(vs8Var);
                    }
                }
            }
            return agreeMeResIdl;
        }
        return invokeIL.objValue;
    }
}
