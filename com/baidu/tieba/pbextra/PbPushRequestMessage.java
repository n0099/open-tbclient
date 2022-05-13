package com.baidu.tieba.pbextra;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.switchs.SocketAddCommonParamSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.jd5;
import tbclient.PushThread.DataReq;
import tbclient.PushThread.PushThreadReqIdl;
/* loaded from: classes3.dex */
public class PbPushRequestMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long mForumId;
    public int mPushType;
    public long mThreadId;
    public long mUserId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbPushRequestMessage(long j, long j2, int i, long j3) {
        super(CmdConfigHttp.PB_PUSH_THREAD_HTTP_CMD, 309325);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Long.valueOf(j3)};
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
        this.mForumId = j;
        this.mThreadId = j2;
        this.mPushType = i;
        this.mUserId = j3;
        setNetType(NetMessage.NetType.HTTP);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            DataReq.Builder builder = new DataReq.Builder();
            builder.forum_id = Long.valueOf(this.mForumId);
            builder.thread_id = Long.valueOf(this.mThreadId);
            builder.push_type = Integer.valueOf(this.mPushType);
            builder.user_id = Long.valueOf(this.mUserId);
            if (z || SocketAddCommonParamSwitch.getIsOn()) {
                jd5.a(builder, true);
            }
            PushThreadReqIdl.Builder builder2 = new PushThreadReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeZ.objValue;
    }

    public long getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mForumId : invokeV.longValue;
    }

    public int getPushType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mPushType : invokeV.intValue;
    }

    public long getThreadId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mThreadId : invokeV.longValue;
    }

    public long getUserId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mUserId : invokeV.longValue;
    }
}
