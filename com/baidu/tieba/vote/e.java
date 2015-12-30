package com.baidu.tieba.vote;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.n;
import com.baidu.tieba.pb.pb.main.PbActivity;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ b dRr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.dRr = bVar;
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
        if (view.getId() == n.g.btn_pb_vote) {
            pbActivity = this.dRr.cGj;
            if (pbActivity != null) {
                pbActivity2 = this.dRr.cGj;
                if (pbActivity2.checkUpIsLogin()) {
                    voteDataInfo = this.dRr.dRm;
                    if (voteDataInfo != null) {
                        j = this.dRr.mForumId;
                        if (j > 0) {
                            j2 = this.dRr.mThreadId;
                            if (j2 > 0) {
                                z = this.dRr.dRo;
                                if (!z) {
                                    pbActivity3 = this.dRr.cGj;
                                    a aVar = new a(pbActivity3);
                                    StringBuilder sb = new StringBuilder();
                                    voteDataInfo2 = this.dRr.dRm;
                                    List<com.baidu.tbadk.widget.vote.a> options = voteDataInfo2.getOptions();
                                    if (options != null) {
                                        for (com.baidu.tbadk.widget.vote.a aVar2 : options) {
                                            if (aVar2 != null && aVar2.isSelected()) {
                                                sb.append(aVar2.getId()).append(",");
                                                list = this.dRr.dRn;
                                                list.add((f) aVar2);
                                                voteDataInfo3 = this.dRr.dRm;
                                                if (voteDataInfo3.getIsMulti() != 1) {
                                                    break;
                                                }
                                            }
                                        }
                                        if (sb.toString().endsWith(",")) {
                                            sb.deleteCharAt(sb.length() - 1);
                                        }
                                        if (TextUtils.isEmpty(sb.toString())) {
                                            pbActivity4 = this.dRr.cGj;
                                            UtilHelper.showToast(pbActivity4.getActivity(), n.j.vote_checked_less_one);
                                            return;
                                        }
                                        j3 = this.dRr.mForumId;
                                        j4 = this.dRr.mThreadId;
                                        aVar.c(j3, j4, sb.toString());
                                        this.dRr.dRo = true;
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
