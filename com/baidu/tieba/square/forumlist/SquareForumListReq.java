package com.baidu.tieba.square.forumlist;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.v;
import tbclient.GetForumsFromForumClass.DataReq;
import tbclient.GetForumsFromForumClass.GetForumsFromForumClassReqIdl;
/* loaded from: classes7.dex */
public class SquareForumListReq extends NetMessage {
    private int pageLimit;
    private int pageNum;
    private int pageType;

    public SquareForumListReq(int i, int i2, int i3) {
        super(1003060, CmdConfigSocket.CMD_SQUARE_FORUM_LIST);
        this.pageType = i;
        this.pageNum = i2;
        this.pageLimit = i3;
        if (this.pageType != 1 && this.pageType != 2) {
            this.pageType = 1;
        }
        if (this.pageNum <= 0) {
            this.pageNum = 1;
        }
        if (this.pageLimit < 10) {
            this.pageLimit = 10;
        }
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        if (z) {
            v.b(builder, true);
        }
        GetForumsFromForumClassReqIdl.Builder builder2 = new GetForumsFromForumClassReqIdl.Builder();
        builder.limit = Integer.valueOf(this.pageLimit);
        builder.pn = Integer.valueOf(this.pageNum);
        builder.type = Integer.valueOf(this.pageType);
        builder.q_type = 0L;
        builder.scr_dip = Double.valueOf(0.0d);
        builder.scr_h = 0;
        builder.scr_w = 0;
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
