package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import d.a.p0.h2.h.r;
import tbclient.PbFloor.PbFloorResIdl;
/* loaded from: classes4.dex */
public class SubPbHttpResponseMessage extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public r pbFloorData;
    public boolean treatDelPage;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubPbHttpResponseMessage(int i2) {
        super(CmdConfigHttp.SubPb_HTTP_CMD);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.pbFloorData = null;
        this.treatDelPage = false;
    }

    public boolean isTreatDelPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.treatDelPage : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) {
            super.decodeInBackGround(i2, bArr);
            Object extra = getOrginalMessage().getExtra();
            r rVar = null;
            if (extra == null || !(extra instanceof SubPbRequestMessage)) {
                context = null;
            } else {
                SubPbRequestMessage subPbRequestMessage = (SubPbRequestMessage) extra;
                context = subPbRequestMessage.getRichTextClickListener();
                this.treatDelPage = subPbRequestMessage.isTreatDelPage();
            }
            try {
                PbFloorResIdl pbFloorResIdl = (PbFloorResIdl) new Wire(new Class[0]).parseFrom(bArr, PbFloorResIdl.class);
                if (pbFloorResIdl != null && pbFloorResIdl.data != null) {
                    rVar = r.w(pbFloorResIdl.data, context);
                    if (rVar != null) {
                        rVar.m = pbFloorResIdl.error;
                    } else if (pbFloorResIdl.error != null) {
                        if (pbFloorResIdl.error.errorno != null) {
                            setError(pbFloorResIdl.error.errorno.intValue());
                        }
                        setErrorString(pbFloorResIdl.error.errmsg);
                    }
                }
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
            this.pbFloorData = rVar;
        }
    }
}
