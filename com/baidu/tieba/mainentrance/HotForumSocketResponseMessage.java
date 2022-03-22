package com.baidu.tieba.mainentrance;

import c.a.p0.g2.b;
import c.a.p0.g2.c;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.HotForum.ForumInfo;
import tbclient.HotForum.HotForumResIdl;
import tbclient.HotForum.HotTopicList;
/* loaded from: classes5.dex */
public class HotForumSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<b> forumInfoList;
    public HotSearchInfoData mSearchInfo;
    public List<c> mTopicInfoList;
    public String mTopicInfoTitle;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotForumSocketResponseMessage() {
        super(303116);
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

    public List<b> getForumInfoList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.forumInfoList : (List) invokeV.objValue;
    }

    public HotSearchInfoData getSearchInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mSearchInfo : (HotSearchInfoData) invokeV.objValue;
    }

    public List<c> getTopicInfoList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mTopicInfoList : (List) invokeV.objValue;
    }

    public String getTopicInfoTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mTopicInfoTitle : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        HotForumResIdl hotForumResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) || (hotForumResIdl = (HotForumResIdl) new Wire(new Class[0]).parseFrom(bArr, HotForumResIdl.class)) == null) {
            return;
        }
        Error error = hotForumResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(hotForumResIdl.error.errmsg);
        }
        if (hotForumResIdl.data == null) {
            return;
        }
        this.forumInfoList = new ArrayList();
        List<ForumInfo> list = hotForumResIdl.data.forum_info;
        if (list != null) {
            for (ForumInfo forumInfo : list) {
                if (forumInfo != null) {
                    b bVar = new b();
                    bVar.a(forumInfo);
                    this.forumInfoList.add(bVar);
                }
            }
        }
        if (hotForumResIdl.data.hot_search != null) {
            HotSearchInfoData hotSearchInfoData = new HotSearchInfoData();
            this.mSearchInfo = hotSearchInfoData;
            hotSearchInfoData.z(hotForumResIdl.data.hot_search);
        }
        if (hotForumResIdl.data.hot_topic != null) {
            this.mTopicInfoList = new ArrayList();
            List<HotTopicList> list2 = hotForumResIdl.data.hot_topic.topic_list;
            if (list2 != null) {
                for (HotTopicList hotTopicList : list2) {
                    if (hotTopicList != null) {
                        c cVar = new c();
                        cVar.d(hotTopicList);
                        this.mTopicInfoList.add(cVar);
                    }
                }
            }
            if (!StringUtils.isNull(hotForumResIdl.data.hot_topic.title)) {
                this.mTopicInfoTitle = hotForumResIdl.data.hot_topic.title;
            } else {
                this.mTopicInfoTitle = "";
            }
        }
    }
}
