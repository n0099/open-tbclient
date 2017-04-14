package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tieba.imMessageCenter.mention.ReplyMeModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements ReplyMeModel.a {
    final /* synthetic */ au dlq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(au auVar) {
        this.dlq = auVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
    public void b(long j, long j2, long j3) {
        com.baidu.tbadk.editortools.pb.n nVar;
        FeedData feedData;
        com.baidu.tbadk.editortools.pb.n nVar2;
        FeedData feedData2;
        com.baidu.tbadk.editortools.pb.n nVar3;
        FeedData feedData3;
        this.dlq.mForumId = String.valueOf(j);
        this.dlq.dlm = j2;
        this.dlq.dln = j3;
        nVar = this.dlq.dlk;
        if (nVar != null) {
            feedData = this.dlq.dll;
            if (feedData.getIsFloor()) {
                feedData2 = this.dlq.dll;
                if (feedData2.getReplyer() != null) {
                    nVar3 = this.dlq.dlk;
                    feedData3 = this.dlq.dll;
                    nVar3.fE(feedData3.getReplyer().getUserName());
                    return;
                }
            }
            nVar2 = this.dlq.dlk;
            nVar2.fE(null);
        }
    }
}
