package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.u;
import tbclient.CheckPost.CheckPostReqIdl;
import tbclient.CheckPost.ReqData;
/* loaded from: classes21.dex */
public class CheckPostRequestMessage extends NetMessage {
    private String forumName;
    public String ori_ugc_nid;
    public String ori_ugc_tid;
    public int ori_ugc_type;
    public String ori_ugc_vid;
    private long pid;
    private int postType;
    private long tid;

    public CheckPostRequestMessage() {
        super(CmdConfigHttp.CMD_CHECK_POST, CmdConfigSocket.CMD_CHECK_POST);
        this.ori_ugc_type = 0;
    }

    public long getPid() {
        return this.pid;
    }

    public void setPid(long j) {
        this.pid = j;
    }

    public int getPostType() {
        return this.postType;
    }

    public void setPostType(int i) {
        this.postType = i;
    }

    public String getForumName() {
        return this.forumName;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    public void setTid(long j) {
        this.tid = j;
    }

    public long getTid() {
        return this.tid;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        ReqData.Builder builder = new ReqData.Builder();
        builder.pid = Long.valueOf(getPid());
        builder.postType = Integer.valueOf(getPostType());
        builder.forumName = getForumName();
        builder.tid = Long.valueOf(this.tid);
        builder.ori_ugc_type = Integer.valueOf(this.ori_ugc_type);
        builder.ori_ugc_tid = this.ori_ugc_tid;
        builder.ori_ugc_nid = this.ori_ugc_nid;
        builder.ori_ugc_vid = this.ori_ugc_vid;
        if (z) {
            u.a(builder, true);
        }
        CheckPostReqIdl.Builder builder2 = new CheckPostReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
