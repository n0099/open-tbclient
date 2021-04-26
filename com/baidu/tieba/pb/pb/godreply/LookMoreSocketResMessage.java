package com.baidu.tieba.pb.pb.godreply;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.GetPostList.DataRes;
import tbclient.GetPostList.GetPostListResIdl;
import tbclient.Post;
/* loaded from: classes3.dex */
public class LookMoreSocketResMessage extends SocketResponsedMessage {
    public List<PostData> list;

    public LookMoreSocketResMessage() {
        super(309446);
        this.list = new ArrayList();
    }

    public List<PostData> getData() {
        return this.list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        DataRes dataRes;
        List<Post> list;
        Error error;
        GetPostListResIdl getPostListResIdl = (GetPostListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetPostListResIdl.class);
        if (getPostListResIdl != null && (error = getPostListResIdl.error) != null) {
            setError(error.errorno.intValue());
            setErrorString(getPostListResIdl.error.usermsg);
        }
        if (getError() != 0 || getPostListResIdl == null || (dataRes = getPostListResIdl.data) == null || (list = dataRes.post_list) == null || list.size() <= 0) {
            return;
        }
        for (Post post : list) {
            PostData postData = new PostData();
            postData.b0(post, TbadkCoreApplication.getInst());
            postData.O = 102;
            this.list.add(postData);
        }
    }
}
