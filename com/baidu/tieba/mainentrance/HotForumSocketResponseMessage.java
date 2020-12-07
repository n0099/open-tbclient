package com.baidu.tieba.mainentrance;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.HotForum.ForumInfo;
import tbclient.HotForum.HotForumResIdl;
import tbclient.HotForum.HotTopicList;
/* loaded from: classes24.dex */
public class HotForumSocketResponseMessage extends SocketResponsedMessage {
    private List<b> forumInfoList;
    private HotSearchInfoData mSearchInfo;
    private List<c> mTopicInfoList;
    private String mTopicInfoTitle;

    public HotForumSocketResponseMessage() {
        super(CmdConfigSocket.CMD_GET_HOTFORUM);
    }

    public List<b> getForumInfoList() {
        return this.forumInfoList;
    }

    public HotSearchInfoData getSearchInfo() {
        return this.mSearchInfo;
    }

    public List<c> getTopicInfoList() {
        return this.mTopicInfoList;
    }

    public String getTopicInfoTitle() {
        return this.mTopicInfoTitle;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
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
                            b bVar = new b();
                            bVar.a(forumInfo);
                            this.forumInfoList.add(bVar);
                        }
                    }
                }
                if (hotForumResIdl.data.hot_search != null) {
                    this.mSearchInfo = new HotSearchInfoData();
                    this.mSearchInfo.a(hotForumResIdl.data.hot_search);
                }
                if (hotForumResIdl.data.hot_topic != null) {
                    this.mTopicInfoList = new ArrayList();
                    if (hotForumResIdl.data.hot_topic.topic_list != null) {
                        for (HotTopicList hotTopicList : hotForumResIdl.data.hot_topic.topic_list) {
                            if (hotTopicList != null) {
                                c cVar = new c();
                                cVar.a(hotTopicList);
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
    }
}
