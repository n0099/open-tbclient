package com.baidu.tieba.write.transmit.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.switchs.SocketAddCommonParamSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ng;
import com.repackage.ud5;
import tbclient.GetRepostRecommendForum.DataReq;
import tbclient.GetRepostRecommendForum.GetRepostRecommendForumReqIdl;
/* loaded from: classes4.dex */
public class GetRepostForumReqMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long forumId;
    public BdUniqueId mRequestId;
    public String threadContent;
    public String threadTitle;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetRepostForumReqMessage() {
        super(CmdConfigHttp.CMD_GET_REPOST_RECOMMEND_FORUM, 309450);
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
                if (z || SocketAddCommonParamSwitch.getIsOn()) {
                    ud5.a(builder, true);
                }
                builder.title = this.threadTitle;
                builder.content = this.threadContent;
                builder.forum_id = Long.valueOf(this.forumId);
                GetRepostRecommendForumReqIdl.Builder builder2 = new GetRepostRecommendForumReqIdl.Builder();
                builder2.data = builder.build(false);
                return builder2.build(false);
            } catch (Exception unused) {
                return null;
            }
        }
        return invokeZ.objValue;
    }

    public BdUniqueId getRequestId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mRequestId : (BdUniqueId) invokeV.objValue;
    }

    public void setForumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.forumId = ng.g(str, 0L);
        }
    }

    public void setRequestId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
            this.mRequestId = bdUniqueId;
        }
    }

    public void setThreadContent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.threadContent = str;
        }
    }

    public void setThreadTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.threadTitle = str;
        }
    }
}
