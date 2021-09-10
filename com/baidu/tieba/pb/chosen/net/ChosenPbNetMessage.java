package com.baidu.tieba.pb.chosen.net;

import c.a.q0.d1.x;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ExcPbPage.DataReq;
import tbclient.ExcPbPage.ExcPbPageReqIdl;
/* loaded from: classes7.dex */
public class ChosenPbNetMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int QUALITY_HIGH = 80;
    public static final int QUALITY_LOW = 45;
    public transient /* synthetic */ FieldHolder $fh;
    public long excId;
    public long q_type;
    public long scrH;
    public long scrW;
    public long scr_dip;
    public long tagCode;
    public long threadId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChosenPbNetMessage() {
        super(CmdConfigHttp.CMD_GET_FINE_PB, 309093);
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
            DataReq.Builder builder = new DataReq.Builder();
            builder.excid = Long.valueOf(this.excId);
            builder.q_type = Long.valueOf(this.q_type);
            builder.scr_h = Long.valueOf(this.scrH);
            builder.scr_w = Long.valueOf(this.scrW);
            builder.scr_dip = Long.valueOf(this.scr_dip);
            builder.tag_code = Long.valueOf(this.tagCode);
            builder.thread_id = Long.valueOf(this.threadId);
            x.a(builder, true);
            ExcPbPageReqIdl.Builder builder2 = new ExcPbPageReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeZ.objValue;
    }

    public void setExcId(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
            this.excId = j2;
        }
    }

    public void setQ_type(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
            this.q_type = j2;
        }
    }

    public void setScrH(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) {
            this.scrH = j2;
        }
    }

    public void setScrW(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j2) == null) {
            this.scrW = j2;
        }
    }

    public void setScr_dip(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) {
            this.scr_dip = j2;
        }
    }

    public void setTagCode(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) {
            this.tagCode = j2;
        }
    }

    public void setThreadId(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) {
            this.threadId = j2;
        }
    }
}
