package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb extends com.baidu.tbadk.editortools.d.a<be> {
    final /* synthetic */ ay cyj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bb(ay ayVar, com.baidu.adp.base.h hVar) {
        super(hVar);
        this.cyj = ayVar;
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
    public boolean DG() {
        return false;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public WriteData fv(String str) {
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
        str2 = this.cyj.mForumId;
        writeData.setForumId(str2);
        feedData = this.cyj.cyf;
        writeData.setForumName(feedData.getFname());
        feedData2 = this.cyj.cyf;
        writeData.setThreadId(feedData2.getThread_id());
        writeData.setIsAd(false);
        writeData.setFloorNum(0);
        feedData3 = this.cyj.cyf;
        if (!feedData3.getIsFloor()) {
            feedData4 = this.cyj.cyf;
            writeData.setFloor(feedData4.getPost_id());
        } else {
            j3 = this.cyj.cyg;
            if (j3 <= 0) {
                feedData5 = this.cyj.cyf;
                quote_pid = feedData5.getQuote_pid();
            } else {
                j4 = this.cyj.cyg;
                quote_pid = String.valueOf(j4);
            }
            writeData.setFloor(quote_pid);
        }
        j = this.cyj.cyh;
        if (j > 0) {
            j2 = this.cyj.cyh;
            writeData.setRepostId(String.valueOf(j2));
        }
        writeData.setType(2);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public String DH() {
        return null;
    }
}
