package com.baidu.tieba.mention;

import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao extends com.baidu.tbadk.editortools.c.a<SingleMentionActivity> {
    final /* synthetic */ al caZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ao(al alVar, com.baidu.adp.base.h hVar) {
        super(hVar);
        this.caZ = alVar;
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
    public boolean Bh() {
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
        str2 = this.caZ.mForumId;
        writeData.setForumId(str2);
        feedData = this.caZ.caV;
        writeData.setForumName(feedData.getFname());
        feedData2 = this.caZ.caV;
        writeData.setThreadId(feedData2.getThread_id());
        writeData.setIsAd(false);
        writeData.setFloorNum(0);
        feedData3 = this.caZ.caV;
        if (!feedData3.getIsFloor()) {
            feedData4 = this.caZ.caV;
            writeData.setFloor(feedData4.getPost_id());
        } else {
            j3 = this.caZ.caW;
            if (j3 <= 0) {
                feedData5 = this.caZ.caV;
                quote_pid = feedData5.getQuote_pid();
            } else {
                j4 = this.caZ.caW;
                quote_pid = String.valueOf(j4);
            }
            writeData.setFloor(quote_pid);
        }
        j = this.caZ.caX;
        if (j > 0) {
            j2 = this.caZ.caX;
            writeData.setRepostId(String.valueOf(j2));
        }
        writeData.setType(2);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.c.a
    public String Bi() {
        return null;
    }
}
