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
    final /* synthetic */ a fIU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.fIU = aVar;
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
            pbActivity = this.fIU.eka;
            if (pbActivity != null) {
                pbActivity2 = this.fIU.eka;
                if (pbActivity2.checkUpIsLogin()) {
                    voteDataInfo = this.fIU.fIP;
                    if (voteDataInfo != null) {
                        j = this.fIU.mForumId;
                        if (j > 0) {
                            j2 = this.fIU.mThreadId;
                            if (j2 > 0) {
                                z = this.fIU.fIR;
                                if (!z) {
                                    pbActivity3 = this.fIU.eka;
                                    AddVoteModel addVoteModel = new AddVoteModel(pbActivity3);
                                    StringBuilder sb = new StringBuilder();
                                    voteDataInfo2 = this.fIU.fIP;
                                    List<com.baidu.tbadk.widget.vote.a> options = voteDataInfo2.getOptions();
                                    if (options != null) {
                                        for (com.baidu.tbadk.widget.vote.a aVar : options) {
                                            if (aVar != null && aVar.isSelected()) {
                                                sb.append(aVar.getId()).append(",");
                                                list = this.fIU.fIQ;
                                                list.add((f) aVar);
                                                voteDataInfo3 = this.fIU.fIP;
                                                if (voteDataInfo3.getIsMulti() != 1) {
                                                    break;
                                                }
                                            }
                                        }
                                        if (sb.toString().endsWith(",")) {
                                            sb.deleteCharAt(sb.length() - 1);
                                        }
                                        if (TextUtils.isEmpty(sb.toString())) {
                                            pbActivity4 = this.fIU.eka;
                                            UtilHelper.showToast(pbActivity4.getActivity(), w.l.vote_checked_less_one);
                                            return;
                                        }
                                        j3 = this.fIU.mForumId;
                                        j4 = this.fIU.mThreadId;
                                        addVoteModel.a(j3, j4, sb.toString());
                                        this.fIU.fIR = true;
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
