package com.baidu.tieba.mainentrance;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.HotForum.ForumInfo;
import tbclient.HotForum.HotForumResIdl;
import tbclient.HotForum.HotTopicList;
/* loaded from: classes.dex */
public class HotForumHttpResponseMessage extends HttpResponsedMessage {
    private List<c> mForumInfoList;
    private f mHotSearchInfo;
    private List<g> mTopicInfoList;

    public HotForumHttpResponseMessage(int i) {
        super(i);
    }

    public List<c> getForumInfoList() {
        return this.mForumInfoList;
    }

    public f getHotSearchInfo() {
        return this.mHotSearchInfo;
    }

    public List<g> getTopicInfoList() {
        return this.mTopicInfoList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) {
        HotForumResIdl hotForumResIdl = (HotForumResIdl) new Wire(new Class[0]).parseFrom(bArr, HotForumResIdl.class);
        if (hotForumResIdl != null) {
            if (hotForumResIdl.error != null) {
                setError(hotForumResIdl.error.errorno.intValue());
                setErrorString(hotForumResIdl.error.errmsg);
            }
            if (hotForumResIdl.data != null) {
                this.mForumInfoList = new ArrayList();
                if (hotForumResIdl.data.forum_info != null) {
                    for (ForumInfo forumInfo : hotForumResIdl.data.forum_info) {
                        if (forumInfo != null) {
                            c cVar = new c();
                            cVar.a(forumInfo);
                            this.mForumInfoList.add(cVar);
                        }
                    }
                }
                if (hotForumResIdl.data.hot_search != null) {
                    this.mHotSearchInfo = new f();
                    this.mHotSearchInfo.a(hotForumResIdl.data.hot_search);
                }
                if (hotForumResIdl.data.hot_topic != null && hotForumResIdl.data.hot_topic.topic_list != null) {
                    this.mTopicInfoList = new ArrayList();
                    for (HotTopicList hotTopicList : hotForumResIdl.data.hot_topic.topic_list) {
                        if (hotTopicList != null) {
                            g gVar = new g();
                            gVar.a(hotTopicList);
                            this.mTopicInfoList.add(gVar);
                        }
                    }
                }
            }
        }
    }
}
