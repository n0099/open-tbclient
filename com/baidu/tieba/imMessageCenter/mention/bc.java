package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc extends com.baidu.tbadk.editortools.d.a<bf> {
    final /* synthetic */ az dhD;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bc(az azVar, com.baidu.adp.base.h hVar) {
        super(hVar);
        this.dhD = azVar;
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
    public boolean BK() {
        return false;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public WriteData fw(String str) {
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
        str2 = this.dhD.mForumId;
        writeData.setForumId(str2);
        feedData = this.dhD.dhx;
        writeData.setForumName(feedData.getFname());
        feedData2 = this.dhD.dhx;
        writeData.setThreadId(feedData2.getThread_id());
        writeData.setIsAd(false);
        writeData.setFloorNum(0);
        feedData3 = this.dhD.dhx;
        if (!feedData3.getIsFloor()) {
            feedData4 = this.dhD.dhx;
            writeData.setFloor(feedData4.getPost_id());
        } else {
            j3 = this.dhD.dhy;
            if (j3 <= 0) {
                feedData5 = this.dhD.dhx;
                quote_pid = feedData5.getQuote_pid();
            } else {
                j4 = this.dhD.dhy;
                quote_pid = String.valueOf(j4);
            }
            writeData.setFloor(quote_pid);
        }
        j = this.dhD.dhz;
        if (j > 0) {
            j2 = this.dhD.dhz;
            writeData.setRepostId(String.valueOf(j2));
        }
        writeData.setType(2);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public String BL() {
        return null;
    }
}
