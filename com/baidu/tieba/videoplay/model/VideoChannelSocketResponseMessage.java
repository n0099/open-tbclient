package com.baidu.tieba.videoplay.model;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.video.VideoItemData;
import com.squareup.wire.Wire;
import d.a.n0.r.q.a2;
import java.util.ArrayList;
import java.util.List;
import tbclient.Feed.FeedResIdl;
import tbclient.ThreadInfo;
/* loaded from: classes5.dex */
public class VideoChannelSocketResponseMessage extends SocketResponsedMessage {
    public FeedResIdl idl;
    public ArrayList<VideoItemData> mVideoItemDatas;

    public VideoChannelSocketResponseMessage(int i2) {
        super(309706);
        this.mVideoItemDatas = new ArrayList<>();
    }

    public List<VideoItemData> getVideoItemDatas() {
        return this.mVideoItemDatas;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        List<ThreadInfo> list;
        FeedResIdl feedResIdl = (FeedResIdl) new Wire(new Class[0]).parseFrom(bArr, FeedResIdl.class);
        this.idl = feedResIdl;
        if (feedResIdl == null || (list = feedResIdl.data.thread_list) == null || list.size() <= 0) {
            return;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            VideoItemData videoItemData = new VideoItemData();
            a2 a2Var = new a2();
            a2Var.V2(list.get(i3));
            videoItemData.parseProto(a2Var);
            this.mVideoItemDatas.add(videoItemData);
        }
    }
}
