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
    final /* synthetic */ a fMZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.fMZ = aVar;
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
            pbActivity = this.fMZ.ekw;
            if (pbActivity != null) {
                pbActivity2 = this.fMZ.ekw;
                if (pbActivity2.checkUpIsLogin()) {
                    voteDataInfo = this.fMZ.fMU;
                    if (voteDataInfo != null) {
                        j = this.fMZ.mForumId;
                        if (j > 0) {
                            j2 = this.fMZ.mThreadId;
                            if (j2 > 0) {
                                z = this.fMZ.fMW;
                                if (!z) {
                                    pbActivity3 = this.fMZ.ekw;
                                    AddVoteModel addVoteModel = new AddVoteModel(pbActivity3);
                                    StringBuilder sb = new StringBuilder();
                                    voteDataInfo2 = this.fMZ.fMU;
                                    List<com.baidu.tbadk.widget.vote.a> options = voteDataInfo2.getOptions();
                                    if (options != null) {
                                        for (com.baidu.tbadk.widget.vote.a aVar : options) {
                                            if (aVar != null && aVar.isSelected()) {
                                                sb.append(aVar.getId()).append(",");
                                                list = this.fMZ.fMV;
                                                list.add((f) aVar);
                                                voteDataInfo3 = this.fMZ.fMU;
                                                if (voteDataInfo3.getIsMulti() != 1) {
                                                    break;
                                                }
                                            }
                                        }
                                        if (sb.toString().endsWith(",")) {
                                            sb.deleteCharAt(sb.length() - 1);
                                        }
                                        if (TextUtils.isEmpty(sb.toString())) {
                                            pbActivity4 = this.fMZ.ekw;
                                            UtilHelper.showToast(pbActivity4.getActivity(), w.l.vote_checked_less_one);
                                            return;
                                        }
                                        j3 = this.fMZ.mForumId;
                                        j4 = this.fMZ.mThreadId;
                                        addVoteModel.a(j3, j4, sb.toString());
                                        this.fMZ.fMW = true;
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
