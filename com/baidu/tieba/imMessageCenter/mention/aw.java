package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tieba.imMessageCenter.mention.ReplyMeModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class aw implements ReplyMeModel.a {
    final /* synthetic */ av dve;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(av avVar) {
        this.dve = avVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
    public void b(long j, long j2, long j3) {
        com.baidu.tbadk.editortools.pb.n nVar;
        FeedData feedData;
        com.baidu.tbadk.editortools.pb.n nVar2;
        FeedData feedData2;
        com.baidu.tbadk.editortools.pb.n nVar3;
        FeedData feedData3;
        this.dve.mForumId = String.valueOf(j);
        this.dve.dva = j2;
        this.dve.dvb = j3;
        nVar = this.dve.duY;
        if (nVar != null) {
            feedData = this.dve.duZ;
            if (feedData.getIsFloor()) {
                feedData2 = this.dve.duZ;
                if (feedData2.getReplyer() != null) {
                    nVar3 = this.dve.duY;
                    feedData3 = this.dve.duZ;
                    nVar3.fT(feedData3.getReplyer().getName_show());
                    return;
                }
            }
            nVar2 = this.dve.duY;
            nVar2.fT(null);
        }
    }
}
