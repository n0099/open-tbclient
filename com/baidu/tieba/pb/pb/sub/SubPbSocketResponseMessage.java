package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import b.a.r0.k2.r.s;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.PbFloor.PbFloorResIdl;
/* loaded from: classes9.dex */
public class SubPbSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public s pbFloorData;
    public boolean treatDelPage;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubPbSocketResponseMessage() {
        super(302002);
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
        this.pbFloorData = null;
        this.treatDelPage = false;
    }

    public boolean isTreatDelPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.treatDelPage : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) {
            Object extra = getOrginalMessage().getExtra();
            s sVar = null;
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
                    sVar = s.w(pbFloorResIdl.data, context);
                    if (sVar != null) {
                        sVar.m = pbFloorResIdl.error;
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
            this.pbFloorData = sVar;
        }
    }
}
