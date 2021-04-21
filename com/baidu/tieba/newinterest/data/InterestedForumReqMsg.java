package com.baidu.tieba.newinterest.data;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.b.i0.z0.w;
import java.util.List;
import tbclient.GetVerticalForumList.DataReq;
import tbclient.GetVerticalForumList.GetVerticalForumListReqIdl;
/* loaded from: classes3.dex */
public class InterestedForumReqMsg extends NetMessage {
    public List<Integer> classidList;

    public InterestedForumReqMsg() {
        super(CmdConfigHttp.CMD_GUIDE_INTERESTED_FORUM, 309654);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        if (z) {
            w.a(builder, true);
        }
        builder.begin_id = 1;
        builder.pn = 0;
        builder.classid_list = this.classidList;
        GetVerticalForumListReqIdl.Builder builder2 = new GetVerticalForumListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
