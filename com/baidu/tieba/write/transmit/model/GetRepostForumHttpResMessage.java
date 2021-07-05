package com.baidu.tieba.write.transmit.model;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.Error;
import tbclient.GetRepostRecommendForum.DataRes;
import tbclient.GetRepostRecommendForum.GetRepostRecommendForumResIdl;
import tbclient.SimpleForum;
/* loaded from: classes5.dex */
public class GetRepostForumHttpResMessage extends HttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<SimpleForum> forumList;
    public int privateThread;
    public String recommendExt;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetRepostForumHttpResMessage() {
        super(CmdConfigHttp.CMD_GET_REPOST_RECOMMEND_FORUM);
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
    }

    public List<SimpleForum> getForumList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.forumList : (List) invokeV.objValue;
    }

    public int getPrivateThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.privateThread : invokeV.intValue;
    }

    public String getRecommendExtension() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.recommendExt : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        GetRepostRecommendForumResIdl getRepostRecommendForumResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) || (getRepostRecommendForumResIdl = (GetRepostRecommendForumResIdl) new Wire(new Class[0]).parseFrom(bArr, GetRepostRecommendForumResIdl.class)) == null) {
            return;
        }
        Error error = getRepostRecommendForumResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(getRepostRecommendForumResIdl.error.usermsg);
            if (getError() != 0) {
                return;
            }
        }
        DataRes dataRes = getRepostRecommendForumResIdl.data;
        if (dataRes != null) {
            this.forumList = dataRes.recommend_forum_list;
            this.recommendExt = dataRes.recommend_ext;
            this.privateThread = dataRes.priv_thread.intValue();
        }
    }
}
