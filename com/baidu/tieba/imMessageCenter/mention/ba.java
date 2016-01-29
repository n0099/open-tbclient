package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba extends com.baidu.tbadk.editortools.d.a<bd> {
    final /* synthetic */ ax cnH;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ba(ax axVar, com.baidu.adp.base.h hVar) {
        super(hVar);
        this.cnH = axVar;
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
    public boolean CY() {
        return false;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public WriteData fn(String str) {
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
        str2 = this.cnH.mForumId;
        writeData.setForumId(str2);
        feedData = this.cnH.cnD;
        writeData.setForumName(feedData.getFname());
        feedData2 = this.cnH.cnD;
        writeData.setThreadId(feedData2.getThread_id());
        writeData.setIsAd(false);
        writeData.setFloorNum(0);
        feedData3 = this.cnH.cnD;
        if (!feedData3.getIsFloor()) {
            feedData4 = this.cnH.cnD;
            writeData.setFloor(feedData4.getPost_id());
        } else {
            j3 = this.cnH.cnE;
            if (j3 <= 0) {
                feedData5 = this.cnH.cnD;
                quote_pid = feedData5.getQuote_pid();
            } else {
                j4 = this.cnH.cnE;
                quote_pid = String.valueOf(j4);
            }
            writeData.setFloor(quote_pid);
        }
        j = this.cnH.cnF;
        if (j > 0) {
            j2 = this.cnH.cnF;
            writeData.setRepostId(String.valueOf(j2));
        }
        writeData.setType(2);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public String CZ() {
        return null;
    }
}
