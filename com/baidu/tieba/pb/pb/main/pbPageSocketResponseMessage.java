package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.pb.PbPageRequestMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bs7;
import com.repackage.ru7;
import com.repackage.ub8;
import com.repackage.zr7;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.PbPage.AppealInfo;
import tbclient.PbPage.DataRes;
import tbclient.PbPage.PbPageResIdl;
import tbclient.SimpleForum;
/* loaded from: classes3.dex */
public class pbPageSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String cacheKey;
    public boolean isFromMark;
    public zr7 mAppealInfo;
    public bs7 pbData;
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

    public zr7 getAppealInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mAppealInfo : (zr7) invokeV.objValue;
    }

    public bs7 getPbData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.pbData : (bs7) invokeV.objValue;
    }

    public int getUpdateType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.updateType : invokeV.intValue;
    }

    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void setOrginalMessage(Message<?> message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, message) == null) {
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
                ru7.b().e(this.cacheKey, this.isFromMark, bArr);
            } else if (i2 != 4) {
            } else {
                ru7.b().f(this.cacheKey, bArr);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, bArr) == null) {
            PbPageResIdl pbPageResIdl = (PbPageResIdl) PbPageRequestMessage.WIRE.parseFrom(bArr, PbPageResIdl.class);
            setError(pbPageResIdl.error.errorno.intValue());
            setErrorString(pbPageResIdl.error.usermsg);
            if (getError() != 0) {
                if (getError() != 4 || pbPageResIdl.data == null) {
                    return;
                }
                zr7 zr7Var = new zr7();
                this.mAppealInfo = zr7Var;
                AppealInfo appealInfo = pbPageResIdl.data.appeal_info;
                if (appealInfo != null) {
                    zr7Var.a = appealInfo.source;
                    zr7Var.c = appealInfo.appeal_url;
                }
                SimpleForum simpleForum = pbPageResIdl.data.forum;
                if (simpleForum != null) {
                    this.mAppealInfo.b = simpleForum.name;
                    return;
                }
                return;
            }
            bs7 bs7Var = new bs7();
            this.pbData = bs7Var;
            bs7Var.y0(2);
            this.pbData.x0(pbPageResIdl.data);
            DataRes dataRes = pbPageResIdl.data;
            if (dataRes != null) {
                JSONObject b = ub8.b(dataRes.thread);
                ArrayList arrayList = new ArrayList();
                if (b != null) {
                    arrayList.add(b);
                }
                ub8.f().h("PB", arrayList);
            }
            BdLog.detailException(null);
        }
    }
}
