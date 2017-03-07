package com.baidu.tieba.vote;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.widget.vote.b {
    final /* synthetic */ a fIU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.fIU = aVar;
    }

    @Override // com.baidu.tbadk.widget.vote.b
    public void a(com.baidu.tbadk.widget.vote.a aVar, int i, boolean z) {
        VoteDataInfo voteDataInfo;
        VoteDataInfo voteDataInfo2;
        VoteDataInfo voteDataInfo3;
        VoteDataInfo voteDataInfo4;
        voteDataInfo = this.fIU.fIP;
        if (voteDataInfo != null) {
            voteDataInfo2 = this.fIU.fIP;
            if (voteDataInfo2.getOptions() != null && i >= 0) {
                voteDataInfo3 = this.fIU.fIP;
                if (i < voteDataInfo3.getOptions().size()) {
                    voteDataInfo4 = this.fIU.fIP;
                    ((f) voteDataInfo4.getOptions().get(i)).setSelected(z);
                }
            }
        }
    }
}
