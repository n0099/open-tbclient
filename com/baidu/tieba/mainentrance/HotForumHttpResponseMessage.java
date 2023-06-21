package com.baidu.tieba.mainentrance;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.yr8;
import com.baidu.tieba.zr8;
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
/* loaded from: classes6.dex */
public class HotForumHttpResponseMessage extends HttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<yr8> mForumInfoList;
    public HotSearchInfoData mHotSearchInfo;
    public List<zr8> mTopicInfoList;
    public String mTopicInfoTitle;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotForumHttpResponseMessage(int i) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        HotForumResIdl hotForumResIdl;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) != null) || (hotForumResIdl = (HotForumResIdl) new Wire(new Class[0]).parseFrom(bArr, HotForumResIdl.class)) == null) {
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
        this.mForumInfoList = new ArrayList();
        List<ForumInfo> list = hotForumResIdl.data.forum_info;
        if (list != null) {
            for (ForumInfo forumInfo : list) {
                if (forumInfo != null) {
                    yr8 yr8Var = new yr8();
                    yr8Var.a(forumInfo);
                    this.mForumInfoList.add(yr8Var);
                }
            }
        }
        if (hotForumResIdl.data.hot_search != null) {
            HotSearchInfoData hotSearchInfoData = new HotSearchInfoData();
            this.mHotSearchInfo = hotSearchInfoData;
            hotSearchInfoData.W(hotForumResIdl.data.hot_search);
        }
        if (hotForumResIdl.data.hot_topic != null) {
            this.mTopicInfoList = new ArrayList();
            List<HotTopicList> list2 = hotForumResIdl.data.hot_topic.topic_list;
            if (list2 != null) {
                for (HotTopicList hotTopicList : list2) {
                    if (hotTopicList != null) {
                        zr8 zr8Var = new zr8();
                        zr8Var.d(hotTopicList);
                        this.mTopicInfoList.add(zr8Var);
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

    public List<yr8> getForumInfoList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mForumInfoList;
        }
        return (List) invokeV.objValue;
    }

    public HotSearchInfoData getHotSearchInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mHotSearchInfo;
        }
        return (HotSearchInfoData) invokeV.objValue;
    }

    public List<zr8> getTopicInfoList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mTopicInfoList;
        }
        return (List) invokeV.objValue;
    }

    public String getTopicInfoTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mTopicInfoTitle;
        }
        return (String) invokeV.objValue;
    }
}
