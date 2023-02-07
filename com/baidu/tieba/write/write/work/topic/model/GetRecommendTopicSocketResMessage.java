package com.baidu.tieba.write.write.work.topic.model;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.fn9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.Error;
import tbclient.GetRecommendTopic.DataRes;
import tbclient.GetRecommendTopic.GetRecommendTopicResIdl;
import tbclient.GetRecommendTopic.TopicList;
import tbclient.GetRecommendTopic.TopicListModule;
/* loaded from: classes6.dex */
public class GetRecommendTopicSocketResMessage extends SocketResponsedMessage implements fn9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TopicListModule recommendTopic;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetRecommendTopicSocketResMessage() {
        super(309713);
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

    @Override // com.baidu.tieba.fn9
    public List<TopicList> getTopicList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            TopicListModule topicListModule = this.recommendTopic;
            if (topicListModule != null) {
                return topicListModule.topic_list;
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            GetRecommendTopicResIdl getRecommendTopicResIdl = (GetRecommendTopicResIdl) new Wire(new Class[0]).parseFrom(bArr, GetRecommendTopicResIdl.class);
            if (getRecommendTopicResIdl != null) {
                Error error = getRecommendTopicResIdl.error;
                if (error != null) {
                    setError(error.errorno.intValue());
                    setErrorString(getRecommendTopicResIdl.error.usermsg);
                    if (getError() != 0) {
                        return getRecommendTopicResIdl;
                    }
                }
                DataRes dataRes = getRecommendTopicResIdl.data;
                if (dataRes != null) {
                    this.recommendTopic = dataRes.recommend_topic;
                }
            }
            return getRecommendTopicResIdl;
        }
        return invokeIL.objValue;
    }
}
