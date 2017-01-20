package com.baidu.tieba.vote;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.r;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a fEt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.fEt = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        VoteDataInfo voteDataInfo;
        long j;
        long j2;
        boolean z;
        PbActivity pbActivity3;
        VoteDataInfo voteDataInfo2;
        long j3;
        long j4;
        PbActivity pbActivity4;
        List list;
        VoteDataInfo voteDataInfo3;
        if (view.getId() == r.h.btn_pb_vote) {
            pbActivity = this.fEt.ehi;
            if (pbActivity != null) {
                pbActivity2 = this.fEt.ehi;
                if (pbActivity2.checkUpIsLogin()) {
                    voteDataInfo = this.fEt.fEo;
                    if (voteDataInfo != null) {
                        j = this.fEt.mForumId;
                        if (j > 0) {
                            j2 = this.fEt.mThreadId;
                            if (j2 > 0) {
                                z = this.fEt.fEq;
                                if (!z) {
                                    pbActivity3 = this.fEt.ehi;
                                    AddVoteModel addVoteModel = new AddVoteModel(pbActivity3);
                                    StringBuilder sb = new StringBuilder();
                                    voteDataInfo2 = this.fEt.fEo;
                                    List<com.baidu.tbadk.widget.vote.a> options = voteDataInfo2.getOptions();
                                    if (options != null) {
                                        for (com.baidu.tbadk.widget.vote.a aVar : options) {
                                            if (aVar != null && aVar.isSelected()) {
                                                sb.append(aVar.getId()).append(",");
                                                list = this.fEt.fEp;
                                                list.add((f) aVar);
                                                voteDataInfo3 = this.fEt.fEo;
                                                if (voteDataInfo3.getIsMulti() != 1) {
                                                    break;
                                                }
                                            }
                                        }
                                        if (sb.toString().endsWith(",")) {
                                            sb.deleteCharAt(sb.length() - 1);
                                        }
                                        if (TextUtils.isEmpty(sb.toString())) {
                                            pbActivity4 = this.fEt.ehi;
                                            UtilHelper.showToast(pbActivity4.getActivity(), r.l.vote_checked_less_one);
                                            return;
                                        }
                                        j3 = this.fEt.mForumId;
                                        j4 = this.fEt.mThreadId;
                                        addVoteModel.a(j3, j4, sb.toString());
                                        this.fEt.fEq = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
