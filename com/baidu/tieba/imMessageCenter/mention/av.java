package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tieba.imMessageCenter.mention.ReplyMeModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements ReplyMeModel.a {
    final /* synthetic */ au dmR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(au auVar) {
        this.dmR = auVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
    public void b(long j, long j2, long j3) {
        com.baidu.tbadk.editortools.pb.n nVar;
        FeedData feedData;
        com.baidu.tbadk.editortools.pb.n nVar2;
        FeedData feedData2;
        com.baidu.tbadk.editortools.pb.n nVar3;
        FeedData feedData3;
        this.dmR.mForumId = String.valueOf(j);
        this.dmR.dmN = j2;
        this.dmR.dmO = j3;
        nVar = this.dmR.dmL;
        if (nVar != null) {
            feedData = this.dmR.dmM;
            if (feedData.getIsFloor()) {
                feedData2 = this.dmR.dmM;
                if (feedData2.getReplyer() != null) {
                    nVar3 = this.dmR.dmL;
                    feedData3 = this.dmR.dmM;
                    nVar3.fy(feedData3.getReplyer().getUserName());
                    return;
                }
            }
            nVar2 = this.dmR.dmL;
            nVar2.fy(null);
        }
    }
}
