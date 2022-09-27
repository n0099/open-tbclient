package com.baidu.tieba.userblock.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.switchs.SocketAddCommonParamSwitch;
import com.baidu.tieba.sh5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.PermissionList;
import tbclient.SetUserBlack.DataReq;
import tbclient.SetUserBlack.SetUserBlackReqIdl;
/* loaded from: classes6.dex */
public class UserBlockSetRequestMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int chat;
    public int follow;
    public int interact;
    public long mBlockUserId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserBlockSetRequestMessage() {
        super(CmdConfigHttp.CMD_USER_BLOCK_SET, 309697);
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
            DataReq.Builder builder = new DataReq.Builder();
            builder.black_uid = Long.valueOf(this.mBlockUserId);
            PermissionList.Builder builder2 = new PermissionList.Builder();
            builder2.follow = Integer.valueOf(this.follow);
            builder2.interact = Integer.valueOf(this.interact);
            builder2.chat = Integer.valueOf(this.chat);
            builder.perm_list = builder2.build(true);
            if (z || SocketAddCommonParamSwitch.getIsOn()) {
                sh5.a(builder, true);
            }
            SetUserBlackReqIdl.Builder builder3 = new SetUserBlackReqIdl.Builder();
            builder3.data = builder.build(false);
            return builder3.build(false);
        }
        return invokeZ.objValue;
    }

    public long getBlockUserId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mBlockUserId : invokeV.longValue;
    }

    public void setBlockUserId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            this.mBlockUserId = j;
        }
    }

    public void setChat(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.chat = i;
        }
    }

    public void setFollow(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.follow = i;
        }
    }

    public void setInteract(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.interact = i;
        }
    }
}
