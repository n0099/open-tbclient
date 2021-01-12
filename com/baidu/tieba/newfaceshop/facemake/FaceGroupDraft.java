package com.baidu.tieba.newfaceshop.facemake;

import com.baidu.tieba.face.data.FaceData;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes8.dex */
public class FaceGroupDraft implements Serializable {
    private String mFailMsg;
    private int mForumId;
    private List<FaceData> mList;
    private String mName;

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public List<FaceData> getList() {
        return this.mList;
    }

    public void setList(List<FaceData> list) {
        this.mList = list;
    }

    public int getForumId() {
        return this.mForumId;
    }

    public void setForumId(int i) {
        this.mForumId = i;
    }

    public String getFailMsg() {
        return this.mFailMsg;
    }

    public void setFailMsg(String str) {
        this.mFailMsg = str;
    }
}
