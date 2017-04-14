package com.baidu.tieba.vote;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.w;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a fKD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.fKD = aVar;
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
        if (view.getId() == w.h.btn_pb_vote) {
            pbActivity = this.fKD.eig;
            if (pbActivity != null) {
                pbActivity2 = this.fKD.eig;
                if (pbActivity2.checkUpIsLogin()) {
                    voteDataInfo = this.fKD.fKy;
                    if (voteDataInfo != null) {
                        j = this.fKD.mForumId;
                        if (j > 0) {
                            j2 = this.fKD.mThreadId;
                            if (j2 > 0) {
                                z = this.fKD.fKA;
                                if (!z) {
                                    pbActivity3 = this.fKD.eig;
                                    AddVoteModel addVoteModel = new AddVoteModel(pbActivity3);
                                    StringBuilder sb = new StringBuilder();
                                    voteDataInfo2 = this.fKD.fKy;
                                    List<com.baidu.tbadk.widget.vote.a> options = voteDataInfo2.getOptions();
                                    if (options != null) {
                                        for (com.baidu.tbadk.widget.vote.a aVar : options) {
                                            if (aVar != null && aVar.isSelected()) {
                                                sb.append(aVar.getId()).append(",");
                                                list = this.fKD.fKz;
                                                list.add((f) aVar);
                                                voteDataInfo3 = this.fKD.fKy;
                                                if (voteDataInfo3.getIsMulti() != 1) {
                                                    break;
                                                }
                                            }
                                        }
                                        if (sb.toString().endsWith(",")) {
                                            sb.deleteCharAt(sb.length() - 1);
                                        }
                                        if (TextUtils.isEmpty(sb.toString())) {
                                            pbActivity4 = this.fKD.eig;
                                            UtilHelper.showToast(pbActivity4.getActivity(), w.l.vote_checked_less_one);
                                            return;
                                        }
                                        j3 = this.fKD.mForumId;
                                        j4 = this.fKD.mThreadId;
                                        addVoteModel.a(j3, j4, sb.toString());
                                        this.fKD.fKA = true;
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
