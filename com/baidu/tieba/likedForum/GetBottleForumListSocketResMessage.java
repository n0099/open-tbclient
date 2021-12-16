package com.baidu.tieba.likedForum;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.Error;
import tbclient.RecommendForumListForBottle.DataRes;
import tbclient.RecommendForumListForBottle.ForumInfo;
import tbclient.RecommendForumListForBottle.RecommendForumListForBottleResIdl;
/* loaded from: classes12.dex */
public class GetBottleForumListSocketResMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ForumInfo> mBottleForumList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetBottleForumListSocketResMessage() {
        super(309440);
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

    public List<ForumInfo> getBottleForumList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mBottleForumList : (List) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        RecommendForumListForBottleResIdl recommendForumListForBottleResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) || (recommendForumListForBottleResIdl = (RecommendForumListForBottleResIdl) new Wire(new Class[0]).parseFrom(bArr, RecommendForumListForBottleResIdl.class)) == null) {
            return;
        }
        Error error = recommendForumListForBottleResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(recommendForumListForBottleResIdl.error.usermsg);
            if (getError() != 0) {
                return;
            }
        }
        DataRes dataRes = recommendForumListForBottleResIdl.data;
        if (dataRes != null) {
            this.mBottleForumList = dataRes.forum_info;
        }
    }
}
