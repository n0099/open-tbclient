package com.baidu.tieba.mainentrance;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.squareup.wire.Wire;
import d.b.j0.o1.b;
import d.b.j0.o1.c;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.HotForum.ForumInfo;
import tbclient.HotForum.HotForumResIdl;
import tbclient.HotForum.HotTopicList;
/* loaded from: classes3.dex */
public class HotForumHttpResponseMessage extends HttpResponsedMessage {
    public List<b> mForumInfoList;
    public HotSearchInfoData mHotSearchInfo;
    public List<c> mTopicInfoList;
    public String mTopicInfoTitle;

    public HotForumHttpResponseMessage(int i) {
        super(i);
    }

    public List<b> getForumInfoList() {
        return this.mForumInfoList;
    }

    public HotSearchInfoData getHotSearchInfo() {
        return this.mHotSearchInfo;
    }

    public List<c> getTopicInfoList() {
        return this.mTopicInfoList;
    }

    public String getTopicInfoTitle() {
        return this.mTopicInfoTitle;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        HotForumResIdl hotForumResIdl = (HotForumResIdl) new Wire(new Class[0]).parseFrom(bArr, HotForumResIdl.class);
        if (hotForumResIdl == null) {
            return;
        }
        Error error = hotForumResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(hotForumResIdl.error.errmsg);
        }
        if (hotForumResIdl.data == null) {
            return;
        }
        this.mForumInfoList = new ArrayList();
        List<ForumInfo> list = hotForumResIdl.data.forum_info;
        if (list != null) {
            for (ForumInfo forumInfo : list) {
                if (forumInfo != null) {
                    b bVar = new b();
                    bVar.a(forumInfo);
                    this.mForumInfoList.add(bVar);
                }
            }
        }
        if (hotForumResIdl.data.hot_search != null) {
            HotSearchInfoData hotSearchInfoData = new HotSearchInfoData();
            this.mHotSearchInfo = hotSearchInfoData;
            hotSearchInfoData.u(hotForumResIdl.data.hot_search);
        }
        if (hotForumResIdl.data.hot_topic != null) {
            this.mTopicInfoList = new ArrayList();
            List<HotTopicList> list2 = hotForumResIdl.data.hot_topic.topic_list;
            if (list2 != null) {
                for (HotTopicList hotTopicList : list2) {
                    if (hotTopicList != null) {
                        c cVar = new c();
                        cVar.d(hotTopicList);
                        this.mTopicInfoList.add(cVar);
                    }
                }
            }
            if (!StringUtils.isNull(hotForumResIdl.data.hot_topic.title)) {
                this.mTopicInfoTitle = hotForumResIdl.data.hot_topic.title;
            } else {
                this.mTopicInfoTitle = "";
            }
        }
    }
}
