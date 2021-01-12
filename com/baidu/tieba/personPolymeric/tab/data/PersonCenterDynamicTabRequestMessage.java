package com.baidu.tieba.personPolymeric.tab.data;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.t;
import tbclient.GetShoubaiThreadList.DataReq;
import tbclient.GetShoubaiThreadList.GetShoubaiThreadListReqIdl;
/* loaded from: classes7.dex */
public class PersonCenterDynamicTabRequestMessage extends NetMessage {
    private long cursor;
    private int pageSize;
    private long uid;

    public PersonCenterDynamicTabRequestMessage(long j, long j2, int i) {
        super(CmdConfigHttp.CMD_PERSON_CENTER_DYNAMIC_TAB, 309647);
        this.uid = j;
        this.cursor = j2;
        this.pageSize = i;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.uid = Long.valueOf(this.uid);
        builder.cursor = Long.valueOf(this.cursor);
        builder.page_size = Integer.valueOf(this.pageSize);
        if (z) {
            t.b(builder, true);
        }
        GetShoubaiThreadListReqIdl.Builder builder2 = new GetShoubaiThreadListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
