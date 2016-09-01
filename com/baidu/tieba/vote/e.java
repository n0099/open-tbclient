package com.baidu.tieba.vote;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.t;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ b fXg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.fXg = bVar;
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
        if (view.getId() == t.g.btn_pb_vote) {
            pbActivity = this.fXg.emy;
            if (pbActivity != null) {
                pbActivity2 = this.fXg.emy;
                if (pbActivity2.checkUpIsLogin()) {
                    voteDataInfo = this.fXg.fXb;
                    if (voteDataInfo != null) {
                        j = this.fXg.mForumId;
                        if (j > 0) {
                            j2 = this.fXg.mThreadId;
                            if (j2 > 0) {
                                z = this.fXg.fXd;
                                if (!z) {
                                    pbActivity3 = this.fXg.emy;
                                    a aVar = new a(pbActivity3);
                                    StringBuilder sb = new StringBuilder();
                                    voteDataInfo2 = this.fXg.fXb;
                                    List<com.baidu.tbadk.widget.vote.a> options = voteDataInfo2.getOptions();
                                    if (options != null) {
                                        for (com.baidu.tbadk.widget.vote.a aVar2 : options) {
                                            if (aVar2 != null && aVar2.isSelected()) {
                                                sb.append(aVar2.getId()).append(",");
                                                list = this.fXg.fXc;
                                                list.add((f) aVar2);
                                                voteDataInfo3 = this.fXg.fXb;
                                                if (voteDataInfo3.getIsMulti() != 1) {
                                                    break;
                                                }
                                            }
                                        }
                                        if (sb.toString().endsWith(",")) {
                                            sb.deleteCharAt(sb.length() - 1);
                                        }
                                        if (TextUtils.isEmpty(sb.toString())) {
                                            pbActivity4 = this.fXg.emy;
                                            UtilHelper.showToast(pbActivity4.getActivity(), t.j.vote_checked_less_one);
                                            return;
                                        }
                                        j3 = this.fXg.mForumId;
                                        j4 = this.fXg.mThreadId;
                                        aVar.b(j3, j4, sb.toString());
                                        this.fXg.fXd = true;
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
