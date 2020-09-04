package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bs;
/* loaded from: classes16.dex */
public class h implements com.baidu.adp.widget.ListView.q {
    public static BdUniqueId TYPE = BdUniqueId.gen();
    public String fid;
    public String forumName;
    public String kxK;
    public boolean kxL = false;
    public int memberNum;
    public int postNum;
    public String tid;

    public h(ForumData forumData) {
        if (forumData != null) {
            this.forumName = forumData.getName();
            this.kxK = forumData.getImage_url();
            this.postNum = forumData.getPost_num();
            this.memberNum = forumData.getMember_num();
            this.fid = forumData.getId();
        }
    }

    public h(bs bsVar) {
        if (bsVar != null) {
            this.forumName = bsVar.forumName;
            this.kxK = bsVar.avatar;
            this.postNum = bsVar.postNum;
            this.memberNum = bsVar.memberNum;
            this.fid = bsVar.forumId;
        }
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return TYPE;
    }
}
