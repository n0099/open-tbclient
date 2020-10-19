package com.baidu.tieba.personPolymeric.tab.data;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.y;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetShoubaiThreadList.GetShoubaiThreadListResIdl;
import tbclient.ThreadInfo;
/* loaded from: classes24.dex */
public class PersonCenterDynamicTabSocketResMessage extends SocketResponsedMessage {
    public long mCursor;
    public boolean mHasMore;
    public List<bw> mThreadDataList;

    public PersonCenterDynamicTabSocketResMessage() {
        super(309647);
        this.mCursor = 0L;
        this.mHasMore = false;
        this.mThreadDataList = new ArrayList();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetShoubaiThreadListResIdl getShoubaiThreadListResIdl = (GetShoubaiThreadListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetShoubaiThreadListResIdl.class);
        if (getShoubaiThreadListResIdl != null && getShoubaiThreadListResIdl.data != null) {
            if (getShoubaiThreadListResIdl.data.page != null) {
                this.mCursor = getShoubaiThreadListResIdl.data.page.cursor.longValue();
                this.mHasMore = getShoubaiThreadListResIdl.data.page.has_more.intValue() == 1;
            }
            if (!y.isEmpty(getShoubaiThreadListResIdl.data.thread_list)) {
                for (ThreadInfo threadInfo : getShoubaiThreadListResIdl.data.thread_list) {
                    if (threadInfo != null) {
                        bw bwVar = new bw();
                        bwVar.a(threadInfo);
                        this.mThreadDataList.add(bwVar);
                    }
                }
            }
        }
    }
}
