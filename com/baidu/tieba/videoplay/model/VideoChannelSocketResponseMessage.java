package com.baidu.tieba.videoplay.model;

import c.a.p0.s.q.c2;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.Feed.FeedResIdl;
import tbclient.ThreadInfo;
/* loaded from: classes7.dex */
public class VideoChannelSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FeedResIdl idl;
    public ArrayList<VideoItemData> mVideoItemDatas;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoChannelSocketResponseMessage(int i2) {
        super(309706);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mVideoItemDatas = new ArrayList<>();
    }

    public List<VideoItemData> getVideoItemDatas() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mVideoItemDatas : (List) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) {
            FeedResIdl feedResIdl = (FeedResIdl) new Wire(new Class[0]).parseFrom(bArr, FeedResIdl.class);
            this.idl = feedResIdl;
            if (feedResIdl == null || (list = feedResIdl.data.thread_list) == null || list.size() <= 0) {
                return;
            }
            for (int i3 = 0; i3 < list.size(); i3++) {
                VideoItemData videoItemData = new VideoItemData();
                c2 c2Var = new c2();
                c2Var.S2(list.get(i3));
                videoItemData.parseProto(c2Var);
                this.mVideoItemDatas.add(videoItemData);
            }
        }
    }
}
