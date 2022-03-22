package com.baidu.tieba.pb.pb.main;

import c.a.p0.l3.m0.b;
import c.a.p0.w2.i.d;
import c.a.p0.w2.i.f;
import c.a.p0.w2.m.f.n;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.pb.PbPageRequestMessage;
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
public class pbPageHttpResponseMessage extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String cacheKey;
    public boolean isFromMark;
    public d mAppealInfo;
    public f pbData;
    public int updateType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pbPageHttpResponseMessage(int i) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
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

    public d getAppealInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mAppealInfo : (d) invokeV.objValue;
    }

    public f getPbData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.pbData : (f) invokeV.objValue;
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
                n.b().e(this.cacheKey, this.isFromMark, bArr);
            } else if (i2 != 4) {
            } else {
                n.b().f(this.cacheKey, bArr);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
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
                d dVar = new d();
                this.mAppealInfo = dVar;
                AppealInfo appealInfo = pbPageResIdl.data.appeal_info;
                if (appealInfo != null) {
                    dVar.a = appealInfo.source;
                    dVar.f19812c = appealInfo.appeal_url;
                }
                SimpleForum simpleForum = pbPageResIdl.data.forum;
                if (simpleForum != null) {
                    this.mAppealInfo.f19811b = simpleForum.name;
                    return;
                }
                return;
            }
            f fVar = new f();
            this.pbData = fVar;
            fVar.y0(2);
            this.pbData.x0(pbPageResIdl.data);
            DataRes dataRes = pbPageResIdl.data;
            if (dataRes != null) {
                SimpleForum simpleForum2 = dataRes.forum;
                JSONObject c2 = b.c(pbPageResIdl.data.thread, simpleForum2 != null ? simpleForum2.name : "");
                ArrayList arrayList = new ArrayList();
                if (c2 != null) {
                    arrayList.add(c2);
                }
                b.f().h("PB", arrayList);
            }
            BdLog.detailException(null);
        }
    }
}
