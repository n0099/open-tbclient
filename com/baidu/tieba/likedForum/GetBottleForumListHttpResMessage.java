package com.baidu.tieba.likedForum;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.RecommendForumListForBottle.ForumInfo;
import tbclient.RecommendForumListForBottle.RecommendForumListForBottleResIdl;
/* loaded from: classes21.dex */
public class GetBottleForumListHttpResMessage extends HttpResponsedMessage {
    public List<ForumInfo> mBottleForumList;

    public GetBottleForumListHttpResMessage() {
        super(1003316);
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
