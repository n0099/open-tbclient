package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bv;
/* loaded from: classes2.dex */
public class h implements com.baidu.adp.widget.ListView.n {
    public static BdUniqueId TYPE = BdUniqueId.gen();
    public String fid;
    public String forumName;
    public String lGN;
    public boolean lGO = false;
    public int memberNum;
    public int postNum;
    public String tid;

    public h(ForumData forumData) {
        if (forumData != null) {
            this.forumName = forumData.getName();
            this.lGN = forumData.getImage_url();
            this.postNum = forumData.getPost_num();
            this.memberNum = forumData.getMember_num();
            this.fid = forumData.getId();
        }
    }

    public h(bv bvVar) {
        if (bvVar != null) {
            this.forumName = bvVar.forumName;
            this.lGN = bvVar.avatar;
            this.postNum = bvVar.postNum;
            this.memberNum = bvVar.memberNum;
            this.fid = bvVar.forumId;
        }
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return TYPE;
    }
}
