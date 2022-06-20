package com.baidu.tieba.write.transmit.model;

import androidx.annotation.Nullable;
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
import tbclient.GetRepostRecommendForum.DataRes;
import tbclient.GetRepostRecommendForum.GetRepostRecommendForumResIdl;
import tbclient.SimpleForum;
/* loaded from: classes4.dex */
public class GetRepostForumSocketResMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<SimpleForum> forumList;
    public int privateThread;
    public String recommendExt;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetRepostForumSocketResMessage() {
        super(309450);
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

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            GetRepostRecommendForumResIdl getRepostRecommendForumResIdl = (GetRepostRecommendForumResIdl) new Wire(new Class[0]).parseFrom(bArr, GetRepostRecommendForumResIdl.class);
            if (getRepostRecommendForumResIdl != null) {
                Error error = getRepostRecommendForumResIdl.error;
                if (error != null) {
                    setError(error.errorno.intValue());
                    setErrorString(getRepostRecommendForumResIdl.error.usermsg);
                    if (getError() != 0) {
                        return getRepostRecommendForumResIdl;
                    }
                }
                DataRes dataRes = getRepostRecommendForumResIdl.data;
                if (dataRes != null) {
                    this.forumList = dataRes.recommend_forum_list;
                    this.recommendExt = dataRes.recommend_ext;
                    this.privateThread = dataRes.priv_thread.intValue();
                }
            }
            return getRepostRecommendForumResIdl;
        }
        return invokeIL.objValue;
    }

    public List<SimpleForum> getForumList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.forumList : (List) invokeV.objValue;
    }

    public int getPrivateThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.privateThread : invokeV.intValue;
    }

    public String getRecommendExtension() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.recommendExt : (String) invokeV.objValue;
    }
}
