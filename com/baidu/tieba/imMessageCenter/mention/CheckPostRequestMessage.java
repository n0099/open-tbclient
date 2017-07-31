package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import tbclient.CheckPost.CheckPostReqIdl;
import tbclient.CheckPost.ReqData;
/* loaded from: classes2.dex */
public class CheckPostRequestMessage extends TbSocketMessage {
    private String forumName;
    private long pid;
    private int postType;
    private long tid;

    public CheckPostRequestMessage() {
        super(303010);
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

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    protected Object encode() {
        ReqData.Builder builder = new ReqData.Builder();
        builder.pid = Long.valueOf(getPid());
        builder.postType = Integer.valueOf(getPostType());
        builder.forumName = getForumName();
        builder.tid = Long.valueOf(this.tid);
        CheckPostReqIdl.Builder builder2 = new CheckPostReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
