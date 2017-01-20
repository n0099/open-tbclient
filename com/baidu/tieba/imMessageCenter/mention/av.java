package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tieba.imMessageCenter.mention.ReplyMeModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements ReplyMeModel.a {
    final /* synthetic */ au dky;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(au auVar) {
        this.dky = auVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
    public void b(long j, long j2, long j3) {
        com.baidu.tbadk.editortools.pb.n nVar;
        FeedData feedData;
        com.baidu.tbadk.editortools.pb.n nVar2;
        FeedData feedData2;
        com.baidu.tbadk.editortools.pb.n nVar3;
        FeedData feedData3;
        this.dky.mForumId = String.valueOf(j);
        this.dky.dkt = j2;
        this.dky.dku = j3;
        nVar = this.dky.dkr;
        if (nVar != null) {
            feedData = this.dky.dks;
            if (feedData.getIsFloor()) {
                feedData2 = this.dky.dks;
                if (feedData2.getReplyer() != null) {
                    nVar3 = this.dky.dkr;
                    feedData3 = this.dky.dks;
                    nVar3.fJ(feedData3.getReplyer().getUserName());
                    return;
                }
            }
            nVar2 = this.dky.dkr;
            nVar2.fJ(null);
        }
    }
}
