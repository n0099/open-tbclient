package com.baidu.tieba.pb.pb.main;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.i0a;
import com.baidu.tieba.pb.PbPageRequestMessage;
import com.baidu.tieba.th9;
import com.baidu.tieba.ye9;
import com.baidu.tieba.ze9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.PbPage.AppealInfo;
import tbclient.PbPage.DataRes;
import tbclient.PbPage.PbPageResIdl;
import tbclient.SimpleForum;
/* loaded from: classes7.dex */
public class pbPageSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String cacheKey;
    public boolean isFromMark;
    public ye9 mAppealInfo;
    public ze9 pbData;
    public int updateType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pbPageSocketResponseMessage() {
        super(302001);
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

    public ye9 getAppealInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mAppealInfo;
        }
        return (ye9) invokeV.objValue;
    }

    public ze9 getPbData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.pbData;
        }
        return (ze9) invokeV.objValue;
    }

    public int getUpdateType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.updateType;
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            int i2 = this.updateType;
            if (i2 != 3) {
                if (i2 == 4) {
                    th9.b().f(this.cacheKey, bArr);
                    return;
                }
                return;
            }
            th9.b().e(this.cacheKey, this.isFromMark, bArr);
        }
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, bArr)) == null) {
            PbPageResIdl pbPageResIdl = (PbPageResIdl) PbPageRequestMessage.WIRE.parseFrom(bArr, PbPageResIdl.class);
            setError(pbPageResIdl.error.errorno.intValue());
            setErrorString(pbPageResIdl.error.usermsg);
            if (getError() != 0) {
                if (getError() == 4) {
                    if (pbPageResIdl.data == null) {
                        return pbPageResIdl;
                    }
                    ye9 ye9Var = new ye9();
                    this.mAppealInfo = ye9Var;
                    AppealInfo appealInfo = pbPageResIdl.data.appeal_info;
                    if (appealInfo != null) {
                        ye9Var.a = appealInfo.source;
                        ye9Var.c = appealInfo.appeal_url;
                    }
                    SimpleForum simpleForum = pbPageResIdl.data.forum;
                    if (simpleForum != null) {
                        this.mAppealInfo.b = simpleForum.name;
                    }
                }
                return pbPageResIdl;
            }
            ze9 ze9Var = new ze9();
            this.pbData = ze9Var;
            ze9Var.D0(2);
            this.pbData.C0(pbPageResIdl.data);
            DataRes dataRes = pbPageResIdl.data;
            if (dataRes != null) {
                JSONObject b = i0a.b(dataRes.thread);
                ArrayList arrayList = new ArrayList();
                if (b != null) {
                    arrayList.add(b);
                }
                i0a.f().h("PB", arrayList);
            }
            BdLog.detailException(null);
            return pbPageResIdl;
        }
        return invokeIL.objValue;
    }

    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void setOrginalMessage(Message<?> message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, message) == null) {
            super.setOrginalMessage(message);
            if (message.getExtra() instanceof PbPageRequestMessage) {
                PbPageRequestMessage pbPageRequestMessage = (PbPageRequestMessage) message.getExtra();
                this.updateType = pbPageRequestMessage.getUpdateType();
                this.cacheKey = pbPageRequestMessage.getCacheKey();
                this.isFromMark = pbPageRequestMessage.getIsFromMark();
            }
        }
    }
}
