package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tieba.imMessageCenter.mention.ReplyMeModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class aw implements ReplyMeModel.a {
    final /* synthetic */ av dhM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(av avVar) {
        this.dhM = avVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
    public void b(long j, long j2, long j3) {
        com.baidu.tbadk.editortools.pb.n nVar;
        FeedData feedData;
        com.baidu.tbadk.editortools.pb.n nVar2;
        FeedData feedData2;
        com.baidu.tbadk.editortools.pb.n nVar3;
        FeedData feedData3;
        this.dhM.mForumId = String.valueOf(j);
        this.dhM.dhI = j2;
        this.dhM.dhJ = j3;
        nVar = this.dhM.dhG;
        if (nVar != null) {
            feedData = this.dhM.dhH;
            if (feedData.getIsFloor()) {
                feedData2 = this.dhM.dhH;
                if (feedData2.getReplyer() != null) {
                    nVar3 = this.dhM.dhG;
                    feedData3 = this.dhM.dhH;
                    nVar3.fB(feedData3.getReplyer().getUserName());
                    return;
                }
            }
            nVar2 = this.dhM.dhG;
            nVar2.fB(null);
        }
    }
}
