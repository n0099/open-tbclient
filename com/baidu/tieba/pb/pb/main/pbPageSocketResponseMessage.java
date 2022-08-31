package com.baidu.tieba.pb.pb.main;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.cw7;
import com.baidu.tieba.it7;
import com.baidu.tieba.kt7;
import com.baidu.tieba.pb.PbPageRequestMessage;
import com.baidu.tieba.qd8;
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
/* loaded from: classes5.dex */
public class pbPageSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String cacheKey;
    public boolean isFromMark;
    public it7 mAppealInfo;
    public kt7 pbData;
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
                if (getError() != 4 || pbPageResIdl.data == null) {
                    return pbPageResIdl;
                }
                it7 it7Var = new it7();
                this.mAppealInfo = it7Var;
                AppealInfo appealInfo = pbPageResIdl.data.appeal_info;
                if (appealInfo != null) {
                    it7Var.a = appealInfo.source;
                    it7Var.c = appealInfo.appeal_url;
                }
                SimpleForum simpleForum = pbPageResIdl.data.forum;
                if (simpleForum != null) {
                    this.mAppealInfo.b = simpleForum.name;
                }
                return pbPageResIdl;
            }
            kt7 kt7Var = new kt7();
            this.pbData = kt7Var;
            kt7Var.B0(2);
            this.pbData.A0(pbPageResIdl.data);
            DataRes dataRes = pbPageResIdl.data;
            if (dataRes != null) {
                JSONObject b = qd8.b(dataRes.thread);
                ArrayList arrayList = new ArrayList();
                if (b != null) {
                    arrayList.add(b);
                }
                qd8.f().h("PB", arrayList);
            }
            BdLog.detailException(null);
            return pbPageResIdl;
        }
        return invokeIL.objValue;
    }

    public it7 getAppealInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mAppealInfo : (it7) invokeV.objValue;
    }

    public kt7 getPbData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.pbData : (kt7) invokeV.objValue;
    }

    public int getUpdateType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.updateType : invokeV.intValue;
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            int i2 = this.updateType;
            if (i2 == 3) {
                cw7.b().e(this.cacheKey, this.isFromMark, bArr);
            } else if (i2 != 4) {
            } else {
                cw7.b().f(this.cacheKey, bArr);
            }
        }
    }
}
