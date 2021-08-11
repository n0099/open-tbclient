package com.baidu.tieba.videoplay.model;

import c.a.o0.s.q.c2;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.videoplay.data.VideoAttentionPersonListData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.ConcernList;
import tbclient.ConcernTab.ConcernTabResIdl;
import tbclient.ConcernTab.DataRes;
import tbclient.ThreadInfo;
import tbclient.ThreadUser;
/* loaded from: classes7.dex */
public class VideoAttentionSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ConcernTabResIdl idl;
    public long mFeedId;
    public int mHasMore;
    public String mShowWord;
    public ArrayList<VideoAttentionPersonListData> mVideoAttentionPersonListData;
    public ArrayList<VideoItemData> mVideoItemDatasVideo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoAttentionSocketResponseMessage() {
        super(309709);
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
        this.mVideoItemDatasVideo = new ArrayList<>();
        this.mVideoAttentionPersonListData = new ArrayList<>();
        this.mShowWord = "";
    }

    public long getFeedId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mFeedId : invokeV.longValue;
    }

    public int getHasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mHasMore : invokeV.intValue;
    }

    public String getShowWord() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mShowWord : (String) invokeV.objValue;
    }

    public List<VideoAttentionPersonListData> getVideoAttentionPersonListData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mVideoAttentionPersonListData : (List) invokeV.objValue;
    }

    public List<VideoItemData> getVideoItemDatas() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mVideoItemDatasVideo : (List) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) {
            Wire wire = new Wire(new Class[0]);
            if (bArr == null) {
                return;
            }
            ConcernTabResIdl concernTabResIdl = (ConcernTabResIdl) wire.parseFrom(bArr, ConcernTabResIdl.class);
            this.idl = concernTabResIdl;
            if (concernTabResIdl == null) {
                return;
            }
            DataRes dataRes = concernTabResIdl.data;
            ConcernList concernList = dataRes.concern_list;
            List<ThreadUser> list = dataRes.forum_friends;
            List<ThreadInfo> list2 = concernList.thread_list;
            this.mFeedId = concernList.feed_id.longValue();
            this.mShowWord = concernList.show_word;
            this.mHasMore = concernList.has_more.intValue();
            if (list2 != null && list2.size() > 0) {
                for (int i3 = 0; i3 < list2.size(); i3++) {
                    VideoItemData videoItemData = new VideoItemData();
                    c2 c2Var = new c2();
                    c2Var.S2(list2.get(i3));
                    videoItemData.parseProto(c2Var);
                    this.mVideoItemDatasVideo.add(videoItemData);
                }
            }
            if (list == null || list.size() <= 0) {
                return;
            }
            for (int i4 = 0; i4 < list.size(); i4++) {
                VideoAttentionPersonListData videoAttentionPersonListData = new VideoAttentionPersonListData();
                videoAttentionPersonListData.parseProto(list.get(i4).thread_list, list.get(i4).user_info);
                this.mVideoAttentionPersonListData.add(videoAttentionPersonListData);
            }
        }
    }
}
