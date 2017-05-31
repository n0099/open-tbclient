package com.baidu.tieba.vote;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.widget.vote.b {
    final /* synthetic */ a fRs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.fRs = aVar;
    }

    @Override // com.baidu.tbadk.widget.vote.b
    public void a(com.baidu.tbadk.widget.vote.a aVar, int i, boolean z) {
        VoteDataInfo voteDataInfo;
        VoteDataInfo voteDataInfo2;
        VoteDataInfo voteDataInfo3;
        VoteDataInfo voteDataInfo4;
        voteDataInfo = this.fRs.fRn;
        if (voteDataInfo != null) {
            voteDataInfo2 = this.fRs.fRn;
            if (voteDataInfo2.getOptions() != null && i >= 0) {
                voteDataInfo3 = this.fRs.fRn;
                if (i < voteDataInfo3.getOptions().size()) {
                    voteDataInfo4 = this.fRs.fRn;
                    ((f) voteDataInfo4.getOptions().get(i)).setSelected(z);
                }
            }
        }
    }
}
