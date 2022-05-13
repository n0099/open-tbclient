package com.baidu.tieba.personPolymeric.tab.data;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.switchs.SocketAddCommonParamSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.jd5;
import tbclient.GetShoubaiThreadList.DataReq;
import tbclient.GetShoubaiThreadList.GetShoubaiThreadListReqIdl;
/* loaded from: classes3.dex */
public class PersonCenterDynamicTabRequestMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long cursor;
    public int pageSize;
    public long uid;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonCenterDynamicTabRequestMessage(long j, long j2, int i) {
        super(CmdConfigHttp.CMD_PERSON_CENTER_DYNAMIC_TAB, 309647);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.uid = j;
        this.cursor = j2;
        this.pageSize = i;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            DataReq.Builder builder = new DataReq.Builder();
            builder.uid = Long.valueOf(this.uid);
            builder.cursor = Long.valueOf(this.cursor);
            builder.page_size = Integer.valueOf(this.pageSize);
            if (z || SocketAddCommonParamSwitch.getIsOn()) {
                jd5.a(builder, true);
            }
            GetShoubaiThreadListReqIdl.Builder builder2 = new GetShoubaiThreadListReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeZ.objValue;
    }
}
