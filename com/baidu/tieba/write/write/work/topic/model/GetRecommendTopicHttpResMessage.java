package com.baidu.tieba.write.write.work.topic.model;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.g09;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.Error;
import tbclient.GetRecommendTopic.DataRes;
import tbclient.GetRecommendTopic.GetRecommendTopicResIdl;
import tbclient.GetRecommendTopic.TopicList;
import tbclient.GetRecommendTopic.TopicListModule;
/* loaded from: classes4.dex */
public class GetRecommendTopicHttpResMessage extends HttpResponsedMessage implements g09 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TopicListModule recommendTopic;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetRecommendTopicHttpResMessage() {
        super(CmdConfigHttp.CMD_GET_RECOMMEND_TOPIC);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.g09
    public List<TopicList> getTopicList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            TopicListModule topicListModule = this.recommendTopic;
            if (topicListModule != null) {
                return topicListModule.topic_list;
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetRecommendTopicResIdl getRecommendTopicResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) || (getRecommendTopicResIdl = (GetRecommendTopicResIdl) new Wire(new Class[0]).parseFrom(bArr, GetRecommendTopicResIdl.class)) == null) {
            return;
        }
        Error error = getRecommendTopicResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(getRecommendTopicResIdl.error.usermsg);
            if (getError() != 0) {
                return;
            }
        }
        DataRes dataRes = getRecommendTopicResIdl.data;
        if (dataRes != null) {
            this.recommendTopic = dataRes.recommend_topic;
        }
    }
}
