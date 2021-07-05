package com.baidu.tieba.imMessageCenter.mention.agree.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.r0.r.k;
import d.a.r0.z0.w;
import tbclient.AgreeMe.AgreeMeReqIdl;
import tbclient.AgreeMe.DataReq;
/* loaded from: classes5.dex */
public class AgreeMeRequestMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long id;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgreeMeRequestMessage() {
        super(CmdConfigHttp.AGREE_ME_HTTP_CMD, 309593);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                super(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            try {
                DataReq.Builder builder = new DataReq.Builder();
                builder.id = Long.valueOf(this.id);
                builder.q_type = Integer.valueOf(k.c().e());
                builder.rn = 20;
                builder.scr_dip = Integer.valueOf((int) TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
                builder.scr_h = Integer.valueOf(l.i(TbadkCoreApplication.getInst().getApp()));
                builder.scr_w = Integer.valueOf(l.k(TbadkCoreApplication.getInst().getApp()));
                if (z) {
                    w.a(builder, true);
                }
                AgreeMeReqIdl.Builder builder2 = new AgreeMeReqIdl.Builder();
                builder2.data = builder.build(false);
                return builder2.build(false);
            } catch (Exception unused) {
                return null;
            }
        }
        return invokeZ.objValue;
    }
}
