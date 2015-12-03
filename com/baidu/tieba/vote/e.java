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
    final /* synthetic */ b dJS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.dJS = bVar;
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
        if (view.getId() == n.f.btn_pb_vote) {
            pbActivity = this.dJS.cCy;
            if (pbActivity != null) {
                pbActivity2 = this.dJS.cCy;
                if (pbActivity2.checkUpIsLogin()) {
                    voteDataInfo = this.dJS.dJN;
                    if (voteDataInfo != null) {
                        j = this.dJS.mForumId;
                        if (j > 0) {
                            j2 = this.dJS.mThreadId;
                            if (j2 > 0) {
                                z = this.dJS.dJP;
                                if (!z) {
                                    pbActivity3 = this.dJS.cCy;
                                    a aVar = new a(pbActivity3);
                                    StringBuilder sb = new StringBuilder();
                                    voteDataInfo2 = this.dJS.dJN;
                                    List<com.baidu.tbadk.widget.vote.a> options = voteDataInfo2.getOptions();
                                    if (options != null) {
                                        for (com.baidu.tbadk.widget.vote.a aVar2 : options) {
                                            if (aVar2 != null && aVar2.isSelected()) {
                                                sb.append(aVar2.getId()).append(",");
                                                list = this.dJS.dJO;
                                                list.add((f) aVar2);
                                                voteDataInfo3 = this.dJS.dJN;
                                                if (voteDataInfo3.getIsMulti() != 1) {
                                                    break;
                                                }
                                            }
                                        }
                                        if (sb.toString().endsWith(",")) {
                                            sb.deleteCharAt(sb.length() - 1);
                                        }
                                        if (TextUtils.isEmpty(sb.toString())) {
                                            pbActivity4 = this.dJS.cCy;
                                            UtilHelper.showToast(pbActivity4.getActivity(), n.i.vote_checked_less_one);
                                            return;
                                        }
                                        j3 = this.dJS.mForumId;
                                        j4 = this.dJS.mThreadId;
                                        aVar.c(j3, j4, sb.toString());
                                        this.dJS.dJP = true;
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
