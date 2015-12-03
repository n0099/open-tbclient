package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az extends com.baidu.tbadk.editortools.d.a<bc> {
    final /* synthetic */ aw cfd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public az(aw awVar, com.baidu.adp.base.h hVar) {
        super(hVar);
        this.cfd = awVar;
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
    public boolean BT() {
        return false;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public WriteData fl(String str) {
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
        str2 = this.cfd.mForumId;
        writeData.setForumId(str2);
        feedData = this.cfd.ceZ;
        writeData.setForumName(feedData.getFname());
        feedData2 = this.cfd.ceZ;
        writeData.setThreadId(feedData2.getThread_id());
        writeData.setIsAd(false);
        writeData.setFloorNum(0);
        feedData3 = this.cfd.ceZ;
        if (!feedData3.getIsFloor()) {
            feedData4 = this.cfd.ceZ;
            writeData.setFloor(feedData4.getPost_id());
        } else {
            j3 = this.cfd.cfa;
            if (j3 <= 0) {
                feedData5 = this.cfd.ceZ;
                quote_pid = feedData5.getQuote_pid();
            } else {
                j4 = this.cfd.cfa;
                quote_pid = String.valueOf(j4);
            }
            writeData.setFloor(quote_pid);
        }
        j = this.cfd.cfb;
        if (j > 0) {
            j2 = this.cfd.cfb;
            writeData.setRepostId(String.valueOf(j2));
        }
        writeData.setType(2);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public String BU() {
        return null;
    }
}
