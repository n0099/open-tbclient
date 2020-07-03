package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bq;
/* loaded from: classes9.dex */
public class g implements com.baidu.adp.widget.ListView.q {
    public static BdUniqueId TYPE = BdUniqueId.gen();
    public String fid;
    public String forumName;
    public String jZH;
    public boolean jZI = false;
    public int memberNum;
    public int postNum;
    public String tid;

    public g(ForumData forumData) {
        if (forumData != null) {
            this.forumName = forumData.getName();
            this.jZH = forumData.getImage_url();
            this.postNum = forumData.getPost_num();
            this.memberNum = forumData.getMember_num();
            this.fid = forumData.getId();
        }
    }

    public g(bq bqVar) {
        if (bqVar != null) {
            this.forumName = bqVar.forumName;
            this.jZH = bqVar.avatar;
            this.postNum = bqVar.postNum;
            this.memberNum = bqVar.memberNum;
            this.fid = bqVar.forumId;
        }
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return TYPE;
    }
}
