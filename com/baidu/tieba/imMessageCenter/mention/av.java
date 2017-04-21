package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tieba.imMessageCenter.mention.ReplyMeModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements ReplyMeModel.a {
    final /* synthetic */ au dnH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(au auVar) {
        this.dnH = auVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
    public void b(long j, long j2, long j3) {
        com.baidu.tbadk.editortools.pb.n nVar;
        FeedData feedData;
        com.baidu.tbadk.editortools.pb.n nVar2;
        FeedData feedData2;
        com.baidu.tbadk.editortools.pb.n nVar3;
        FeedData feedData3;
        this.dnH.mForumId = String.valueOf(j);
        this.dnH.dnD = j2;
        this.dnH.dnE = j3;
        nVar = this.dnH.dnB;
        if (nVar != null) {
            feedData = this.dnH.dnC;
            if (feedData.getIsFloor()) {
                feedData2 = this.dnH.dnC;
                if (feedData2.getReplyer() != null) {
                    nVar3 = this.dnH.dnB;
                    feedData3 = this.dnH.dnC;
                    nVar3.fE(feedData3.getReplyer().getUserName());
                    return;
                }
            }
            nVar2 = this.dnH.dnB;
            nVar2.fE(null);
        }
    }
}
