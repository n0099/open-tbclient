package com.baidu.tieba.mention;

import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao extends com.baidu.tbadk.editortools.c.a<SingleMentionActivity> {
    final /* synthetic */ al caO;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ao(al alVar, com.baidu.adp.base.h hVar) {
        super(hVar);
        this.caO = alVar;
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
    public boolean Bk() {
        return false;
    }

    @Override // com.baidu.tbadk.editortools.c.a
    public WriteData eV(String str) {
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
        str2 = this.caO.mForumId;
        writeData.setForumId(str2);
        feedData = this.caO.caK;
        writeData.setForumName(feedData.getFname());
        feedData2 = this.caO.caK;
        writeData.setThreadId(feedData2.getThread_id());
        writeData.setIsAd(false);
        writeData.setFloorNum(0);
        feedData3 = this.caO.caK;
        if (!feedData3.getIsFloor()) {
            feedData4 = this.caO.caK;
            writeData.setFloor(feedData4.getPost_id());
        } else {
            j3 = this.caO.caL;
            if (j3 <= 0) {
                feedData5 = this.caO.caK;
                quote_pid = feedData5.getQuote_pid();
            } else {
                j4 = this.caO.caL;
                quote_pid = String.valueOf(j4);
            }
            writeData.setFloor(quote_pid);
        }
        j = this.caO.caM;
        if (j > 0) {
            j2 = this.caO.caM;
            writeData.setRepostId(String.valueOf(j2));
        }
        writeData.setType(2);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.c.a
    public String Bl() {
        return null;
    }
}
