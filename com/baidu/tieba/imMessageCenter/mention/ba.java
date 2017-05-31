package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.pb.DataModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class ba extends DataModel<ad> {
    final /* synthetic */ av dni;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ba(av avVar, com.baidu.adp.base.g gVar) {
        super(gVar);
        this.dni = avVar;
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
    public boolean CG() {
        return false;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fo(String str) {
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
        str2 = this.dni.mForumId;
        writeData.setForumId(str2);
        feedData = this.dni.dnd;
        writeData.setForumName(feedData.getFname());
        feedData2 = this.dni.dnd;
        writeData.setThreadId(feedData2.getThread_id());
        writeData.setIsAd(false);
        writeData.setFloorNum(0);
        feedData3 = this.dni.dnd;
        if (!feedData3.getIsFloor()) {
            feedData4 = this.dni.dnd;
            writeData.setFloor(feedData4.getPost_id());
        } else {
            j3 = this.dni.dne;
            if (j3 <= 0) {
                feedData5 = this.dni.dnd;
                quote_pid = feedData5.getQuote_pid();
            } else {
                j4 = this.dni.dne;
                quote_pid = String.valueOf(j4);
            }
            writeData.setFloor(quote_pid);
        }
        j = this.dni.dnf;
        if (j > 0) {
            j2 = this.dni.dnf;
            writeData.setRepostId(String.valueOf(j2));
        }
        writeData.setType(2);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String CH() {
        return null;
    }
}
