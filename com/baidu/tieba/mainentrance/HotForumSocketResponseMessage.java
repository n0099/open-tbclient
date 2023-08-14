package com.baidu.tieba.mainentrance;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.h09;
import com.baidu.tieba.i09;
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
/* loaded from: classes7.dex */
public class HotForumSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<h09> forumInfoList;
    public HotSearchInfoData mSearchInfo;
    public List<i09> mTopicInfoList;
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

    public List<h09> getForumInfoList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.forumInfoList;
        }
        return (List) invokeV.objValue;
    }

    public HotSearchInfoData getSearchInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mSearchInfo;
        }
        return (HotSearchInfoData) invokeV.objValue;
    }

    public List<i09> getTopicInfoList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mTopicInfoList;
        }
        return (List) invokeV.objValue;
    }

    public String getTopicInfoTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mTopicInfoTitle;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            HotForumResIdl hotForumResIdl = (HotForumResIdl) new Wire(new Class[0]).parseFrom(bArr, HotForumResIdl.class);
            if (hotForumResIdl == null) {
                return null;
            }
            Error error = hotForumResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(hotForumResIdl.error.errmsg);
            }
            if (hotForumResIdl.data == null) {
                return hotForumResIdl;
            }
            this.forumInfoList = new ArrayList();
            List<ForumInfo> list = hotForumResIdl.data.forum_info;
            if (list != null) {
                for (ForumInfo forumInfo : list) {
                    if (forumInfo != null) {
                        h09 h09Var = new h09();
                        h09Var.a(forumInfo);
                        this.forumInfoList.add(h09Var);
                    }
                }
            }
            if (hotForumResIdl.data.hot_search != null) {
                HotSearchInfoData hotSearchInfoData = new HotSearchInfoData();
                this.mSearchInfo = hotSearchInfoData;
                hotSearchInfoData.P(hotForumResIdl.data.hot_search);
            }
            if (hotForumResIdl.data.hot_topic != null) {
                this.mTopicInfoList = new ArrayList();
                List<HotTopicList> list2 = hotForumResIdl.data.hot_topic.topic_list;
                if (list2 != null) {
                    for (HotTopicList hotTopicList : list2) {
                        if (hotTopicList != null) {
                            i09 i09Var = new i09();
                            i09Var.d(hotTopicList);
                            this.mTopicInfoList.add(i09Var);
                        }
                    }
                }
                if (!StringUtils.isNull(hotForumResIdl.data.hot_topic.title)) {
                    this.mTopicInfoTitle = hotForumResIdl.data.hot_topic.title;
                } else {
                    this.mTopicInfoTitle = "";
                }
            }
            return hotForumResIdl;
        }
        return invokeIL.objValue;
    }
}
