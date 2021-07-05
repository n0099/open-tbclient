package com.baidu.tieba.model.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.z0.w;
import tbclient.AddPollPost.AddPollPostReqIdl;
import tbclient.AddPollPost.DataReq;
/* loaded from: classes5.dex */
public class AddPollPostRequestNetMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long forumId;
    public String options;
    public long threadId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddPollPostRequestNetMessage() {
        super(CmdConfigHttp.CMD_ADD_POLL_POST, 309006);
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
            builder.thread_id = Long.valueOf(this.threadId);
            builder.options = this.options;
            builder.forum_id = Long.valueOf(this.forumId);
            if (z) {
                w.a(builder, true);
            }
            AddPollPostReqIdl.Builder builder2 = new AddPollPostReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeZ.objValue;
    }

    public long getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.forumId : invokeV.longValue;
    }

    public String getOptions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.options : (String) invokeV.objValue;
    }

    public long getThreadId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.threadId : invokeV.longValue;
    }

    public void setForumId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            this.forumId = j;
        }
    }

    public void setOptions(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.options = str;
        }
    }

    public void setThreadId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            this.threadId = j;
        }
    }
}
