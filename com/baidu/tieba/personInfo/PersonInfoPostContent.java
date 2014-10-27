package com.baidu.tieba.personInfo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.Abstract;
import tbclient.PostInfoContent;
/* loaded from: classes.dex */
public class PersonInfoPostContent implements Serializable {
    private static final long serialVersionUID = -244269927395688642L;
    private List<PersonInfoAbstract> abstractList = new ArrayList();
    private long createTime;
    private long postId;
    private long postType;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.createTime = jSONObject.optLong("create_time");
            this.postType = jSONObject.optLong("post_type");
            this.postId = jSONObject.optLong("post_id");
            JSONArray optJSONArray = jSONObject.optJSONArray("post_content");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        PersonInfoAbstract personInfoAbstract = new PersonInfoAbstract();
                        personInfoAbstract.parseJson(optJSONObject);
                        this.abstractList.add(personInfoAbstract);
                    }
                }
            }
        }
    }

    public void parseProto(PostInfoContent postInfoContent) {
        if (postInfoContent != null) {
            this.createTime = postInfoContent.create_time.longValue();
            this.postType = postInfoContent.post_type.longValue();
            this.postId = postInfoContent.post_id.longValue();
            List<Abstract> list = postInfoContent.post_content;
            if (list != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < list.size()) {
                        PersonInfoAbstract personInfoAbstract = new PersonInfoAbstract();
                        personInfoAbstract.parseProto(list.get(i2));
                        this.abstractList.add(personInfoAbstract);
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public List<PersonInfoAbstract> getAbstractList() {
        return this.abstractList;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public long getPostType() {
        return this.postType;
    }

    public long getPostId() {
        return this.postId;
    }
}
