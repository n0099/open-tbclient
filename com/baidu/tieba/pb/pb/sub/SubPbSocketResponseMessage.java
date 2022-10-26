package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.kw7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.PbFloor.PbFloorResIdl;
/* loaded from: classes5.dex */
public class SubPbSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public kw7 pbFloorData;
    public boolean treatDelPage;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubPbSocketResponseMessage() {
        super(302002);
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
        this.pbFloorData = null;
        this.treatDelPage = false;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            Object extra = getOrginalMessage().getExtra();
            if (extra != null && (extra instanceof SubPbRequestMessage)) {
                this.treatDelPage = ((SubPbRequestMessage) extra).isTreatDelPage();
            }
            kw7 kw7Var = null;
            try {
                PbFloorResIdl pbFloorResIdl = (PbFloorResIdl) new Wire(new Class[0]).parseFrom(bArr, PbFloorResIdl.class);
                if (pbFloorResIdl != null && pbFloorResIdl.data != null) {
                    kw7Var = kw7.w(pbFloorResIdl.data);
                    if (kw7Var != null) {
                        kw7Var.m = pbFloorResIdl.error;
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
            this.pbFloorData = kw7Var;
            return kw7Var;
        }
        return invokeIL.objValue;
    }

    public boolean isTreatDelPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.treatDelPage;
        }
        return invokeV.booleanValue;
    }
}
