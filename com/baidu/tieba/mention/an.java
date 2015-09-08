package com.baidu.tieba.mention;

import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an extends com.baidu.tbadk.editortools.c.a<SingleMentionActivity> {
    final /* synthetic */ ak bXb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public an(ak akVar, com.baidu.adp.base.h hVar) {
        super(hVar);
        this.bXb = akVar;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.tbadk.editortools.c.a
    public boolean Bx() {
        return false;
    }

    @Override // com.baidu.tbadk.editortools.c.a
    public WriteData eQ(String str) {
        String str2;
        FeedData feedData;
        FeedData feedData2;
        FeedData feedData3;
        FeedData feedData4;
        long j;
        long j2;
        long j3;
        FeedData feedData5;
        String quote_pid;
        long j4;
        WriteData writeData = new WriteData();
        str2 = this.bXb.mForumId;
        writeData.setForumId(str2);
        feedData = this.bXb.bWW;
        writeData.setForumName(feedData.getFname());
        feedData2 = this.bXb.bWW;
        writeData.setThreadId(feedData2.getThread_id());
        writeData.setIsAd(false);
        writeData.setFloorNum(0);
        feedData3 = this.bXb.bWW;
        if (!feedData3.getIsFloor()) {
            feedData4 = this.bXb.bWW;
            writeData.setFloor(feedData4.getPost_id());
        } else {
            j3 = this.bXb.bWX;
            if (j3 <= 0) {
                feedData5 = this.bXb.bWW;
                quote_pid = feedData5.getQuote_pid();
            } else {
                j4 = this.bXb.bWX;
                quote_pid = String.valueOf(j4);
            }
            writeData.setFloor(quote_pid);
        }
        j = this.bXb.bWY;
        if (j > 0) {
            j2 = this.bXb.bWY;
            writeData.setRepostId(String.valueOf(j2));
        }
        writeData.setType(2);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.c.a
    public String By() {
        return null;
    }
}
