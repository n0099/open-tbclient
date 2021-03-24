package com.baidu.tieba.write.transmit.model;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.Error;
import tbclient.GetRepostRecommendForum.DataRes;
import tbclient.GetRepostRecommendForum.GetRepostRecommendForumResIdl;
import tbclient.SimpleForum;
/* loaded from: classes5.dex */
public class GetRepostForumHttpResMessage extends HttpResponsedMessage {
    public List<SimpleForum> forumList;
    public int privateThread;
    public String recommendExt;

    public GetRepostForumHttpResMessage() {
        super(CmdConfigHttp.CMD_GET_REPOST_RECOMMEND_FORUM);
    }

    public List<SimpleForum> getForumList() {
        return this.forumList;
    }

    public int getPrivateThread() {
        return this.privateThread;
    }

    public String getRecommendExtension() {
        return this.recommendExt;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetRepostRecommendForumResIdl getRepostRecommendForumResIdl = (GetRepostRecommendForumResIdl) new Wire(new Class[0]).parseFrom(bArr, GetRepostRecommendForumResIdl.class);
        if (getRepostRecommendForumResIdl != null) {
            Error error = getRepostRecommendForumResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(getRepostRecommendForumResIdl.error.usermsg);
                if (getError() != 0) {
                    return;
                }
            }
            DataRes dataRes = getRepostRecommendForumResIdl.data;
            if (dataRes != null) {
                this.forumList = dataRes.recommend_forum_list;
                this.recommendExt = dataRes.recommend_ext;
                this.privateThread = dataRes.priv_thread.intValue();
            }
        }
    }
}
