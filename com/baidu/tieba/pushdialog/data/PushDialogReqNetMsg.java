package com.baidu.tieba.pushdialog.data;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.jd5;
import tbclient.GetLockWindowMsg.DataReq;
import tbclient.GetLockWindowMsg.GetLockWindowMsgReqIdl;
/* loaded from: classes3.dex */
public class PushDialogReqNetMsg extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long task_id;
    public long tid;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushDialogReqNetMsg() {
        super(CmdConfigHttp.CMD_GET_PUSH_DIALOG_DATA, 309614);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
                builder.tid = Long.valueOf(this.tid);
                builder.task_id = Long.valueOf(this.task_id);
                jd5.c(builder, true, true, true);
                GetLockWindowMsgReqIdl.Builder builder2 = new GetLockWindowMsgReqIdl.Builder();
                builder2.data = builder.build(true);
                return builder2.build(true);
            } catch (Throwable unused) {
                return null;
            }
        }
        return invokeZ.objValue;
    }

    public void setTask_id(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            this.task_id = j;
        }
    }

    public void setTid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            this.tid = j;
        }
    }
}
