package com.baidu.tieba.mainentrance;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.HotForum.ForumInfo;
import tbclient.HotForum.HotForumResIdl;
/* loaded from: classes.dex */
public class HotForumSocketResponseMessage extends SocketResponsedMessage {
    private List<e> forumInfoList;

    public HotForumSocketResponseMessage() {
        super(303116);
    }

    public List<e> getForumInfoList() {
        return this.forumInfoList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        HotForumResIdl hotForumResIdl = (HotForumResIdl) new Wire(new Class[0]).parseFrom(bArr, HotForumResIdl.class);
        if (hotForumResIdl != null) {
            if (hotForumResIdl.error != null) {
                setError(hotForumResIdl.error.errorno.intValue());
                setErrorString(hotForumResIdl.error.errmsg);
            }
            if (hotForumResIdl.data != null) {
                this.forumInfoList = new ArrayList();
                if (hotForumResIdl.data.forum_info != null) {
                    for (ForumInfo forumInfo : hotForumResIdl.data.forum_info) {
                        if (forumInfo != null) {
                            e eVar = new e();
                            eVar.a(forumInfo);
                            if (!eVar.WN()) {
                                this.forumInfoList.add(eVar);
                            }
                        }
                    }
                }
            }
        }
    }
}
