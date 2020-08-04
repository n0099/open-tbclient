package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.br;
/* loaded from: classes16.dex */
public class h implements com.baidu.adp.widget.ListView.q {
    public static BdUniqueId TYPE = BdUniqueId.gen();
    public String fid;
    public String forumName;
    public String kil;
    public boolean kim = false;
    public int memberNum;
    public int postNum;
    public String tid;

    public h(ForumData forumData) {
        if (forumData != null) {
            this.forumName = forumData.getName();
            this.kil = forumData.getImage_url();
            this.postNum = forumData.getPost_num();
            this.memberNum = forumData.getMember_num();
            this.fid = forumData.getId();
        }
    }

    public h(br brVar) {
        if (brVar != null) {
            this.forumName = brVar.forumName;
            this.kil = brVar.avatar;
            this.postNum = brVar.postNum;
            this.memberNum = brVar.memberNum;
            this.fid = brVar.forumId;
        }
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return TYPE;
    }
}
