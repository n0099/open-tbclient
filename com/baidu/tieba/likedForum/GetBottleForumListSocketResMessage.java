package com.baidu.tieba.likedForum;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.RecommendForumListForBottle.ForumInfo;
import tbclient.RecommendForumListForBottle.RecommendForumListForBottleResIdl;
/* loaded from: classes5.dex */
public class GetBottleForumListSocketResMessage extends SocketResponsedMessage {
    public List<ForumInfo> mBottleForumList;

    public GetBottleForumListSocketResMessage() {
        super(CmdConfigSocket.CMD_GET_BOTTLE_FORUM_LIST);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        RecommendForumListForBottleResIdl recommendForumListForBottleResIdl = (RecommendForumListForBottleResIdl) new Wire(new Class[0]).parseFrom(bArr, RecommendForumListForBottleResIdl.class);
        if (recommendForumListForBottleResIdl != null) {
            if (recommendForumListForBottleResIdl.error != null) {
                setError(recommendForumListForBottleResIdl.error.errorno.intValue());
                setErrorString(recommendForumListForBottleResIdl.error.usermsg);
                if (getError() != 0) {
                    return;
                }
            }
            if (recommendForumListForBottleResIdl.data != null) {
                this.mBottleForumList = recommendForumListForBottleResIdl.data.forum_info;
            }
        }
    }

    public List<ForumInfo> getBottleForumList() {
        return this.mBottleForumList;
    }
}
