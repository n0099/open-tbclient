package com.baidu.tieba.square.forumlist;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.n0.z0.w;
import tbclient.GetForumsFromForumClass.DataReq;
import tbclient.GetForumsFromForumClass.GetForumsFromForumClassReqIdl;
/* loaded from: classes5.dex */
public class SquareForumListReq extends NetMessage {
    public int pageLimit;
    public int pageNum;
    public int pageType;

    public SquareForumListReq(int i2, int i3, int i4) {
        super(CmdConfigHttp.CMD_SQUARE_FORUM_LIST, 309097);
        this.pageType = i2;
        this.pageNum = i3;
        this.pageLimit = i4;
        if (i2 != 1 && i2 != 2) {
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
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        if (z) {
            w.a(builder, true);
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
