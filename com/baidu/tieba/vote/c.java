package com.baidu.tieba.vote;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tbadk.widget.vote.b {
    final /* synthetic */ b eWD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.eWD = bVar;
    }

    @Override // com.baidu.tbadk.widget.vote.b
    public void a(com.baidu.tbadk.widget.vote.a aVar, int i, boolean z) {
        VoteDataInfo voteDataInfo;
        VoteDataInfo voteDataInfo2;
        VoteDataInfo voteDataInfo3;
        VoteDataInfo voteDataInfo4;
        voteDataInfo = this.eWD.eWy;
        if (voteDataInfo != null) {
            voteDataInfo2 = this.eWD.eWy;
            if (voteDataInfo2.getOptions() != null && i >= 0) {
                voteDataInfo3 = this.eWD.eWy;
                if (i < voteDataInfo3.getOptions().size()) {
                    voteDataInfo4 = this.eWD.eWy;
                    ((f) voteDataInfo4.getOptions().get(i)).setSelected(z);
                }
            }
        }
    }
}
