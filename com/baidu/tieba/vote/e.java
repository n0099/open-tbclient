package com.baidu.tieba.vote;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.r;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ b fZk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.fZk = bVar;
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
        if (view.getId() == r.g.btn_pb_vote) {
            pbActivity = this.fZk.eow;
            if (pbActivity != null) {
                pbActivity2 = this.fZk.eow;
                if (pbActivity2.checkUpIsLogin()) {
                    voteDataInfo = this.fZk.fZf;
                    if (voteDataInfo != null) {
                        j = this.fZk.mForumId;
                        if (j > 0) {
                            j2 = this.fZk.mThreadId;
                            if (j2 > 0) {
                                z = this.fZk.fZh;
                                if (!z) {
                                    pbActivity3 = this.fZk.eow;
                                    a aVar = new a(pbActivity3);
                                    StringBuilder sb = new StringBuilder();
                                    voteDataInfo2 = this.fZk.fZf;
                                    List<com.baidu.tbadk.widget.vote.a> options = voteDataInfo2.getOptions();
                                    if (options != null) {
                                        for (com.baidu.tbadk.widget.vote.a aVar2 : options) {
                                            if (aVar2 != null && aVar2.isSelected()) {
                                                sb.append(aVar2.getId()).append(",");
                                                list = this.fZk.fZg;
                                                list.add((f) aVar2);
                                                voteDataInfo3 = this.fZk.fZf;
                                                if (voteDataInfo3.getIsMulti() != 1) {
                                                    break;
                                                }
                                            }
                                        }
                                        if (sb.toString().endsWith(",")) {
                                            sb.deleteCharAt(sb.length() - 1);
                                        }
                                        if (TextUtils.isEmpty(sb.toString())) {
                                            pbActivity4 = this.fZk.eow;
                                            UtilHelper.showToast(pbActivity4.getActivity(), r.j.vote_checked_less_one);
                                            return;
                                        }
                                        j3 = this.fZk.mForumId;
                                        j4 = this.fZk.mThreadId;
                                        aVar.b(j3, j4, sb.toString());
                                        this.fZk.fZh = true;
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
