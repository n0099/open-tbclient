package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bg;
/* loaded from: classes9.dex */
public class g implements com.baidu.adp.widget.ListView.o {
    public static BdUniqueId TYPE = BdUniqueId.gen();
    public String fid;
    public String forumName;
    public String jER;
    public boolean jES = false;
    public int memberNum;
    public int postNum;
    public String tid;

    public g(ForumData forumData) {
        if (forumData != null) {
            this.forumName = forumData.getName();
            this.jER = forumData.getImage_url();
            this.postNum = forumData.getPost_num();
            this.memberNum = forumData.getMember_num();
            this.fid = forumData.getId();
        }
    }

    public g(bg bgVar) {
        if (bgVar != null) {
            this.forumName = bgVar.forumName;
            this.jER = bgVar.avatar;
            this.postNum = bgVar.postNum;
            this.memberNum = bgVar.memberNum;
            this.fid = bgVar.forumId;
        }
    }

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return TYPE;
    }
}
