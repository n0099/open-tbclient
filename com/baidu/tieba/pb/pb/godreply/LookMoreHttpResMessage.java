package com.baidu.tieba.pb.pb.godreply;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetPostList.GetPostListResIdl;
import tbclient.Post;
/* loaded from: classes4.dex */
public class LookMoreHttpResMessage extends HttpResponsedMessage {
    public List<PostData> list;

    public LookMoreHttpResMessage() {
        super(1001603);
        this.list = new ArrayList();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        List<Post> list;
        GetPostListResIdl getPostListResIdl = (GetPostListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetPostListResIdl.class);
        if (getPostListResIdl != null && getPostListResIdl.error != null) {
            setError(getPostListResIdl.error.errorno.intValue());
            setErrorString(getPostListResIdl.error.usermsg);
        }
        if (getError() == 0 && getPostListResIdl != null && getPostListResIdl.data != null && (list = getPostListResIdl.data.post_list) != null && list.size() > 0) {
            for (Post post : list) {
                PostData postData = new PostData();
                postData.a(post, TbadkCoreApplication.getInst());
                postData.jiW = 102;
                this.list.add(postData);
            }
        }
    }

    public List<PostData> getData() {
        return this.list;
    }
}
