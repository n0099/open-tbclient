package com.baidu.tieba.newfaceshop.facemake;

import com.baidu.tieba.face.data.FaceData;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes3.dex */
public class FaceGroupDraft implements Serializable {
    public String mFailMsg;
    public int mForumId;
    public List<FaceData> mList;
    public String mName;

    public String getFailMsg() {
        return this.mFailMsg;
    }

    public int getForumId() {
        return this.mForumId;
    }

    public List<FaceData> getList() {
        return this.mList;
    }

    public String getName() {
        return this.mName;
    }

    public void setFailMsg(String str) {
        this.mFailMsg = str;
    }

    public void setForumId(int i) {
        this.mForumId = i;
    }

    public void setList(List<FaceData> list) {
        this.mList = list;
    }

    public void setName(String str) {
        this.mName = str;
    }
}
