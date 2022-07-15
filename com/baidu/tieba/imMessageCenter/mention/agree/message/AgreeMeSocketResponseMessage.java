package com.baidu.tieba.imMessageCenter.mention.agree.message;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.br4;
import com.repackage.oa7;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import tbclient.AgreeList;
import tbclient.AgreeMe.AgreeMeResIdl;
import tbclient.AgreeMe.DataRes;
import tbclient.Error;
/* loaded from: classes3.dex */
public class AgreeMeSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<oa7> datas;
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

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        DataRes dataRes;
        String str;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, bArr)) == null) {
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
            if (getError() == 0 && (dataRes = agreeMeResIdl.data) != null) {
                this.hasMore = dataRes.has_more.intValue() == 1;
                for (AgreeList agreeList : agreeMeResIdl.data.agree_list) {
                    if (agreeList != null) {
                        oa7 oa7Var = new oa7();
                        oa7Var.I(agreeList);
                        this.datas.add(oa7Var);
                    }
                }
            }
            return agreeMeResIdl;
        }
        return invokeIL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) && !hasError() && (getOrginalMessage().getExtra() instanceof AgreeMeRequestMessage) && ((AgreeMeRequestMessage) getOrginalMessage().getExtra()).id == 0) {
            br4.f();
            br4.e("tb_user_agreeme", TbadkCoreApplication.getCurrentAccountName()).a("agree_me_cache_key", bArr);
        }
    }
}
