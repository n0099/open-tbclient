package com.baidu.tieba.vote;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.widget.vote.b {
    final /* synthetic */ a fMZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.fMZ = aVar;
    }

    @Override // com.baidu.tbadk.widget.vote.b
    public void a(com.baidu.tbadk.widget.vote.a aVar, int i, boolean z) {
        VoteDataInfo voteDataInfo;
        VoteDataInfo voteDataInfo2;
        VoteDataInfo voteDataInfo3;
        VoteDataInfo voteDataInfo4;
        voteDataInfo = this.fMZ.fMU;
        if (voteDataInfo != null) {
            voteDataInfo2 = this.fMZ.fMU;
            if (voteDataInfo2.getOptions() != null && i >= 0) {
                voteDataInfo3 = this.fMZ.fMU;
                if (i < voteDataInfo3.getOptions().size()) {
                    voteDataInfo4 = this.fMZ.fMU;
                    ((f) voteDataInfo4.getOptions().get(i)).setSelected(z);
                }
            }
        }
    }
}
