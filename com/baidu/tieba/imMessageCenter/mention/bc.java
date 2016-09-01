package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc extends com.baidu.tbadk.editortools.d.a<bf> {
    final /* synthetic */ az dti;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bc(az azVar, com.baidu.adp.base.h hVar) {
        super(hVar);
        this.dti = azVar;
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
    public boolean Df() {
        return false;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public WriteData fz(String str) {
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
        str2 = this.dti.mForumId;
        writeData.setForumId(str2);
        feedData = this.dti.dtd;
        writeData.setForumName(feedData.getFname());
        feedData2 = this.dti.dtd;
        writeData.setThreadId(feedData2.getThread_id());
        writeData.setIsAd(false);
        writeData.setFloorNum(0);
        feedData3 = this.dti.dtd;
        if (!feedData3.getIsFloor()) {
            feedData4 = this.dti.dtd;
            writeData.setFloor(feedData4.getPost_id());
        } else {
            j3 = this.dti.dte;
            if (j3 <= 0) {
                feedData5 = this.dti.dtd;
                quote_pid = feedData5.getQuote_pid();
            } else {
                j4 = this.dti.dte;
                quote_pid = String.valueOf(j4);
            }
            writeData.setFloor(quote_pid);
        }
        j = this.dti.dtf;
        if (j > 0) {
            j2 = this.dti.dtf;
            writeData.setRepostId(String.valueOf(j2));
        }
        writeData.setType(2);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public String Dg() {
        return null;
    }
}
