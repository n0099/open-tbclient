package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.pb.DataModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az extends DataModel<ad> {
    final /* synthetic */ au dky;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public az(au auVar, com.baidu.adp.base.g gVar) {
        super(gVar);
        this.dky = auVar;
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
    public boolean CR() {
        return false;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fy(String str) {
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
        str2 = this.dky.mForumId;
        writeData.setForumId(str2);
        feedData = this.dky.dks;
        writeData.setForumName(feedData.getFname());
        feedData2 = this.dky.dks;
        writeData.setThreadId(feedData2.getThread_id());
        writeData.setIsAd(false);
        writeData.setFloorNum(0);
        feedData3 = this.dky.dks;
        if (!feedData3.getIsFloor()) {
            feedData4 = this.dky.dks;
            writeData.setFloor(feedData4.getPost_id());
        } else {
            j3 = this.dky.dkt;
            if (j3 <= 0) {
                feedData5 = this.dky.dks;
                quote_pid = feedData5.getQuote_pid();
            } else {
                j4 = this.dky.dkt;
                quote_pid = String.valueOf(j4);
            }
            writeData.setFloor(quote_pid);
        }
        j = this.dky.dku;
        if (j > 0) {
            j2 = this.dky.dku;
            writeData.setRepostId(String.valueOf(j2));
        }
        writeData.setType(2);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String CS() {
        return null;
    }
}
