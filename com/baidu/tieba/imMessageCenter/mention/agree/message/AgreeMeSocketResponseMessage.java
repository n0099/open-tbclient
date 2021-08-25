package com.baidu.tieba.imMessageCenter.mention.agree.message;

import c.a.q0.k1.b.p.a;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import tbclient.AgreeList;
import tbclient.AgreeMe.AgreeMeResIdl;
import tbclient.AgreeMe.DataRes;
import tbclient.Error;
/* loaded from: classes7.dex */
public class AgreeMeSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<a> datas;
    public boolean hasMore;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgreeMeSocketResponseMessage() {
        super(309593);
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
        this.datas = new ArrayList<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i2, byte[] bArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) && !hasError() && (getOrginalMessage().getExtra() instanceof AgreeMeRequestMessage) && ((AgreeMeRequestMessage) getOrginalMessage().getExtra()).id == 0) {
            c.a.p0.s.r.a.f();
            c.a.p0.s.r.a.e("tb_user_agreeme", TbadkCoreApplication.getCurrentAccountName()).a("agree_me_cache_key", bArr);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        DataRes dataRes;
        String str;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, bArr) == null) {
            AgreeMeResIdl agreeMeResIdl = (AgreeMeResIdl) new Wire(new Class[0]).parseFrom(bArr, AgreeMeResIdl.class);
            if (agreeMeResIdl == null) {
                return;
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
                        a aVar = new a();
                        aVar.G(agreeList);
                        this.datas.add(aVar);
                    }
                }
            }
        }
    }
}
