package com.baidu.tieba.personPolymeric.tab.data;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.b.h0.z0.w;
import tbclient.GetShoubaiThreadList.DataReq;
import tbclient.GetShoubaiThreadList.GetShoubaiThreadListReqIdl;
/* loaded from: classes3.dex */
public class PersonCenterDynamicTabRequestMessage extends NetMessage {
    public long cursor;
    public int pageSize;
    public long uid;

    public PersonCenterDynamicTabRequestMessage(long j, long j2, int i) {
        super(CmdConfigHttp.CMD_PERSON_CENTER_DYNAMIC_TAB, 309647);
        this.uid = j;
        this.cursor = j2;
        this.pageSize = i;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.uid = Long.valueOf(this.uid);
        builder.cursor = Long.valueOf(this.cursor);
        builder.page_size = Integer.valueOf(this.pageSize);
        if (z) {
            w.a(builder, true);
        }
        GetShoubaiThreadListReqIdl.Builder builder2 = new GetShoubaiThreadListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
