package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bx;
/* loaded from: classes2.dex */
public class h implements com.baidu.adp.widget.ListView.n {
    public static BdUniqueId TYPE = BdUniqueId.gen();
    public String fid;
    public String forumName;
    public String lKV;
    public boolean lKW = false;
    public int memberNum;
    public int postNum;
    public String tid;

    public h(ForumData forumData) {
        if (forumData != null) {
            this.forumName = forumData.getName();
            this.lKV = forumData.getImage_url();
            this.postNum = forumData.getPost_num();
            this.memberNum = forumData.getMember_num();
            this.fid = forumData.getId();
        }
    }

    public h(bx bxVar) {
        if (bxVar != null) {
            this.forumName = bxVar.forumName;
            this.lKV = bxVar.avatar;
            this.postNum = bxVar.postNum;
            this.memberNum = bxVar.memberNum;
            this.fid = bxVar.forumId;
        }
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return TYPE;
    }
}
