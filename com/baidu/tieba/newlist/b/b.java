package com.baidu.tieba.newlist.b;

import android.support.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import tbclient.TopicList.NewTopicList;
/* loaded from: classes21.dex */
public class b implements q {
    public String cover;
    public String desc;
    public int index;
    public long replyNum;
    public int tag;
    public String title;
    public long topicId;

    public b(@NonNull NewTopicList newTopicList, int i) {
        this.index = i + 1;
        this.title = newTopicList.topic_name;
        this.desc = newTopicList.topic_desc;
        this.replyNum = newTopicList.discuss_num.longValue();
        this.cover = newTopicList.topic_image;
        this.tag = newTopicList.topic_tag.intValue();
        this.topicId = newTopicList.topic_id.longValue();
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return a.ldj;
    }
}
