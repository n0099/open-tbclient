package com.baidu.tieba.setting.forbiddenforum;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.b.h0.z0.w;
import tbclient.GetDislikeList.DataReq;
import tbclient.GetDislikeList.GetDislikeListReqIdl;
/* loaded from: classes4.dex */
public class ForbiddenForumReqMsg extends NetMessage {
    public int pageNum;
    public int pageSize;

    public ForbiddenForumReqMsg() {
        super(CmdConfigHttp.CMD_GET_FORBIDDEN_FORUM, 309692);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        if (z) {
            w.a(builder, true);
        }
        builder.user_id = Long.valueOf(TbadkCoreApplication.getCurrentAccountId());
        builder.rn = Integer.valueOf(this.pageSize);
        builder.pn = Integer.valueOf(this.pageNum);
        GetDislikeListReqIdl.Builder builder2 = new GetDislikeListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
