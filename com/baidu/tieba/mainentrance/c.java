package com.baidu.tieba.mainentrance;

import tbclient.HotForum.HotTopicList;
/* loaded from: classes6.dex */
public class c {
    private long mId;
    private String mName;
    private int mTag;

    public int getTag() {
        return this.mTag;
    }

    public long getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void a(HotTopicList hotTopicList) {
        if (hotTopicList != null) {
            this.mId = hotTopicList.topic_id.longValue();
            this.mName = hotTopicList.topic_name;
            this.mTag = hotTopicList.tag.intValue();
        }
    }
}
