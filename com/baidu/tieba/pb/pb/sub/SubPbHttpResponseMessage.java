package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.zr7;
import com.squareup.wire.Wire;
import tbclient.PbFloor.PbFloorResIdl;
/* loaded from: classes3.dex */
public class SubPbHttpResponseMessage extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zr7 pbFloorData;
    public boolean treatDelPage;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubPbHttpResponseMessage(int i) {
        super(CmdConfigHttp.SubPb_HTTP_CMD);
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
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            super.decodeInBackGround(i, bArr);
            Object extra = getOrginalMessage().getExtra();
            if (extra != null && (extra instanceof SubPbRequestMessage)) {
                this.treatDelPage = ((SubPbRequestMessage) extra).isTreatDelPage();
            }
            zr7 zr7Var = null;
            try {
                PbFloorResIdl pbFloorResIdl = (PbFloorResIdl) new Wire(new Class[0]).parseFrom(bArr, PbFloorResIdl.class);
                if (pbFloorResIdl != null && pbFloorResIdl.data != null) {
                    zr7Var = zr7.w(pbFloorResIdl.data);
                    if (zr7Var != null) {
                        zr7Var.m = pbFloorResIdl.error;
                    } else if (pbFloorResIdl.error != null) {
                        if (pbFloorResIdl.error.errorno != null) {
                            setError(pbFloorResIdl.error.errorno.intValue());
                        }
                        setErrorString(pbFloorResIdl.error.errmsg);
                    }
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            this.pbFloorData = zr7Var;
        }
    }
}
