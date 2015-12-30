package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba extends com.baidu.tbadk.editortools.d.a<bd> {
    final /* synthetic */ ax cjh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ba(ax axVar, com.baidu.adp.base.h hVar) {
        super(hVar);
        this.cjh = axVar;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public boolean BI() {
        return false;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public WriteData fp(String str) {
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
        str2 = this.cjh.mForumId;
        writeData.setForumId(str2);
        feedData = this.cjh.cjd;
        writeData.setForumName(feedData.getFname());
        feedData2 = this.cjh.cjd;
        writeData.setThreadId(feedData2.getThread_id());
        writeData.setIsAd(false);
        writeData.setFloorNum(0);
        feedData3 = this.cjh.cjd;
        if (!feedData3.getIsFloor()) {
            feedData4 = this.cjh.cjd;
            writeData.setFloor(feedData4.getPost_id());
        } else {
            j3 = this.cjh.cje;
            if (j3 <= 0) {
                feedData5 = this.cjh.cjd;
                quote_pid = feedData5.getQuote_pid();
            } else {
                j4 = this.cjh.cje;
                quote_pid = String.valueOf(j4);
            }
            writeData.setFloor(quote_pid);
        }
        j = this.cjh.cjf;
        if (j > 0) {
            j2 = this.cjh.cjf;
            writeData.setRepostId(String.valueOf(j2));
        }
        writeData.setType(2);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public String BJ() {
        return null;
    }
}
