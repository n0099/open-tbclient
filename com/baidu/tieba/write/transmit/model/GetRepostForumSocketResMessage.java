package com.baidu.tieba.write.transmit.model;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.GetRepostRecommendForum.GetRepostRecommendForumResIdl;
import tbclient.SimpleForum;
/* loaded from: classes13.dex */
public class GetRepostForumSocketResMessage extends SocketResponsedMessage {
    private List<SimpleForum> forumList;
    private int privateThread;
    private String recommendExt;

    public GetRepostForumSocketResMessage() {
        super(CmdConfigSocket.CMD_GET_REPOST_RECOMMEND_FORUM);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetRepostRecommendForumResIdl getRepostRecommendForumResIdl = (GetRepostRecommendForumResIdl) new Wire(new Class[0]).parseFrom(bArr, GetRepostRecommendForumResIdl.class);
        if (getRepostRecommendForumResIdl != null) {
            if (getRepostRecommendForumResIdl.error != null) {
                setError(getRepostRecommendForumResIdl.error.errorno.intValue());
                setErrorString(getRepostRecommendForumResIdl.error.usermsg);
                if (getError() != 0) {
                    return;
                }
            }
            if (getRepostRecommendForumResIdl.data != null) {
                this.forumList = getRepostRecommendForumResIdl.data.recommend_forum_list;
                this.recommendExt = getRepostRecommendForumResIdl.data.recommend_ext;
                this.privateThread = getRepostRecommendForumResIdl.data.priv_thread.intValue();
            }
        }
    }

    public List<SimpleForum> getForumList() {
        return this.forumList;
    }

    public String getRecommendExtension() {
        return this.recommendExt;
    }

    public int getPrivateThread() {
        return this.privateThread;
    }
}
