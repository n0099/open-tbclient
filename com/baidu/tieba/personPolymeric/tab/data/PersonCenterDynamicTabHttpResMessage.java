package com.baidu.tieba.personPolymeric.tab.data;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.y;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetShoubaiThreadList.GetShoubaiThreadListResIdl;
import tbclient.ThreadInfo;
/* loaded from: classes8.dex */
public class PersonCenterDynamicTabHttpResMessage extends HttpResponsedMessage {
    public long mCursor;
    public boolean mHasMore;
    public List<cb> mThreadDataList;

    public PersonCenterDynamicTabHttpResMessage() {
        super(CmdConfigHttp.CMD_PERSON_CENTER_DYNAMIC_TAB);
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
                        cb cbVar = new cb();
                        cbVar.a(threadInfo);
                        this.mThreadDataList.add(cbVar);
                    }
                }
            }
        }
    }
}
