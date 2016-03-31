package com.baidu.tieba.pb.pb.praise.grffitiList;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.h.b;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.l;
import tbclient.GetConsentList.DataReq;
import tbclient.GetConsentList.GetConsentListReqIdl;
/* loaded from: classes.dex */
public class GraffitiListRequestData extends NetMessage {
    private static final long ONE_PAGE_ITEM_COUNT = 20;
    private boolean isAuthor;
    private long mNextRequestPageNum;
    private String mPostId;
    private String mThreadId;

    public GraffitiListRequestData(String str, String str2, long j, boolean z) {
        super(CmdConfigHttp.CMD_GRAFFITI_LIST, 309326);
        this.mPostId = "";
        this.mNextRequestPageNum = 1L;
        this.mThreadId = str;
        this.mPostId = str2;
        this.mNextRequestPageNum = j;
        this.isAuthor = z;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.thread_id = Long.valueOf(b.c(this.mThreadId, 0L));
        builder.post_id = Long.valueOf(b.c(this.mPostId, 0L));
        if (this.isAuthor) {
            builder.author_id = Long.valueOf(b.c(TbadkCoreApplication.getCurrentAccount(), 1L));
        }
        builder.page_num = Long.valueOf(this.mNextRequestPageNum);
        builder.res_num = Long.valueOf((long) ONE_PAGE_ITEM_COUNT);
        if (z) {
            l.a(builder, true);
        }
        GetConsentListReqIdl.Builder builder2 = new GetConsentListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
