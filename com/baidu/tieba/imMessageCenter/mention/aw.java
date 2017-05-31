package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tieba.imMessageCenter.mention.ReplyMeModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class aw implements ReplyMeModel.a {
    final /* synthetic */ av dni;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(av avVar) {
        this.dni = avVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
    public void b(long j, long j2, long j3) {
        com.baidu.tbadk.editortools.pb.n nVar;
        FeedData feedData;
        com.baidu.tbadk.editortools.pb.n nVar2;
        FeedData feedData2;
        com.baidu.tbadk.editortools.pb.n nVar3;
        FeedData feedData3;
        this.dni.mForumId = String.valueOf(j);
        this.dni.dne = j2;
        this.dni.dnf = j3;
        nVar = this.dni.dnc;
        if (nVar != null) {
            feedData = this.dni.dnd;
            if (feedData.getIsFloor()) {
                feedData2 = this.dni.dnd;
                if (feedData2.getReplyer() != null) {
                    nVar3 = this.dni.dnc;
                    feedData3 = this.dni.dnd;
                    nVar3.fz(feedData3.getReplyer().getUserName());
                    return;
                }
            }
            nVar2 = this.dni.dnc;
            nVar2.fz(null);
        }
    }
}
