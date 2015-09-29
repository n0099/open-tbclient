package com.baidu.tieba.mainentrance;

import tbclient.HotForum.HotTopicList;
/* loaded from: classes.dex */
public class g {
    private long mId;
    private String mName;

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
        }
    }
}
