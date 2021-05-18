package com.baidu.tieba.personPolymeric.tab.data;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.util.ListUtils;
import com.squareup.wire.Wire;
import d.a.j0.r.q.a2;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetShoubaiThreadList.DataRes;
import tbclient.GetShoubaiThreadList.GetShoubaiThreadListResIdl;
import tbclient.GetShoubaiThreadList.PageInfo;
import tbclient.ThreadInfo;
/* loaded from: classes5.dex */
public class PersonCenterDynamicTabSocketResMessage extends SocketResponsedMessage {
    public long mCursor;
    public boolean mHasMore;
    public List<a2> mThreadDataList;

    public PersonCenterDynamicTabSocketResMessage() {
        super(309647);
        this.mCursor = 0L;
        this.mHasMore = false;
        this.mThreadDataList = new ArrayList();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        DataRes dataRes;
        GetShoubaiThreadListResIdl getShoubaiThreadListResIdl = (GetShoubaiThreadListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetShoubaiThreadListResIdl.class);
        if (getShoubaiThreadListResIdl == null || (dataRes = getShoubaiThreadListResIdl.data) == null) {
            return;
        }
        PageInfo pageInfo = dataRes.page;
        if (pageInfo != null) {
            this.mCursor = pageInfo.cursor.longValue();
            this.mHasMore = getShoubaiThreadListResIdl.data.page.has_more.intValue() == 1;
        }
        if (ListUtils.isEmpty(getShoubaiThreadListResIdl.data.thread_list)) {
            return;
        }
        for (ThreadInfo threadInfo : getShoubaiThreadListResIdl.data.thread_list) {
            if (threadInfo != null) {
                a2 a2Var = new a2();
                a2Var.T2(threadInfo);
                this.mThreadDataList.add(a2Var);
            }
        }
    }
}
