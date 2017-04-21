package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.pb.DataModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az extends DataModel<ad> {
    final /* synthetic */ au dnH;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public az(au auVar, com.baidu.adp.base.g gVar) {
        super(gVar);
        this.dnH = auVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean DI() {
        return false;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData ft(String str) {
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
        str2 = this.dnH.mForumId;
        writeData.setForumId(str2);
        feedData = this.dnH.dnC;
        writeData.setForumName(feedData.getFname());
        feedData2 = this.dnH.dnC;
        writeData.setThreadId(feedData2.getThread_id());
        writeData.setIsAd(false);
        writeData.setFloorNum(0);
        feedData3 = this.dnH.dnC;
        if (!feedData3.getIsFloor()) {
            feedData4 = this.dnH.dnC;
            writeData.setFloor(feedData4.getPost_id());
        } else {
            j3 = this.dnH.dnD;
            if (j3 <= 0) {
                feedData5 = this.dnH.dnC;
                quote_pid = feedData5.getQuote_pid();
            } else {
                j4 = this.dnH.dnD;
                quote_pid = String.valueOf(j4);
            }
            writeData.setFloor(quote_pid);
        }
        j = this.dnH.dnE;
        if (j > 0) {
            j2 = this.dnH.dnE;
            writeData.setRepostId(String.valueOf(j2));
        }
        writeData.setType(2);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String DJ() {
        return null;
    }
}
