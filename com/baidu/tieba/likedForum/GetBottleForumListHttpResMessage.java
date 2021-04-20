package com.baidu.tieba.likedForum;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.Error;
import tbclient.RecommendForumListForBottle.DataRes;
import tbclient.RecommendForumListForBottle.ForumInfo;
import tbclient.RecommendForumListForBottle.RecommendForumListForBottleResIdl;
/* loaded from: classes4.dex */
public class GetBottleForumListHttpResMessage extends HttpResponsedMessage {
    public List<ForumInfo> mBottleForumList;

    public GetBottleForumListHttpResMessage() {
        super(CmdConfigHttp.CMD_GET_BOTTLE_FORUM_LIST);
    }

    public List<ForumInfo> getBottleForumList() {
        return this.mBottleForumList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        RecommendForumListForBottleResIdl recommendForumListForBottleResIdl = (RecommendForumListForBottleResIdl) new Wire(new Class[0]).parseFrom(bArr, RecommendForumListForBottleResIdl.class);
        if (recommendForumListForBottleResIdl != null) {
            Error error = recommendForumListForBottleResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(recommendForumListForBottleResIdl.error.usermsg);
                if (getError() != 0) {
                    return;
                }
            }
            DataRes dataRes = recommendForumListForBottleResIdl.data;
            if (dataRes != null) {
                this.mBottleForumList = dataRes.forum_info;
            }
        }
    }
}
