package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bt;
/* loaded from: classes21.dex */
public class h implements com.baidu.adp.widget.ListView.q {
    public static BdUniqueId TYPE = BdUniqueId.gen();
    public String fid;
    public String forumName;
    public String loh;
    public boolean loi = false;
    public int memberNum;
    public int postNum;
    public String tid;

    public h(ForumData forumData) {
        if (forumData != null) {
            this.forumName = forumData.getName();
            this.loh = forumData.getImage_url();
            this.postNum = forumData.getPost_num();
            this.memberNum = forumData.getMember_num();
            this.fid = forumData.getId();
        }
    }

    public h(bt btVar) {
        if (btVar != null) {
            this.forumName = btVar.forumName;
            this.loh = btVar.avatar;
            this.postNum = btVar.postNum;
            this.memberNum = btVar.memberNum;
            this.fid = btVar.forumId;
        }
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return TYPE;
    }
}
