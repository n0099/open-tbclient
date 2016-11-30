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
    final /* synthetic */ b ggH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.ggH = bVar;
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
            pbActivity = this.ggH.eug;
            if (pbActivity != null) {
                pbActivity2 = this.ggH.eug;
                if (pbActivity2.checkUpIsLogin()) {
                    voteDataInfo = this.ggH.ggC;
                    if (voteDataInfo != null) {
                        j = this.ggH.mForumId;
                        if (j > 0) {
                            j2 = this.ggH.mThreadId;
                            if (j2 > 0) {
                                z = this.ggH.ggE;
                                if (!z) {
                                    pbActivity3 = this.ggH.eug;
                                    a aVar = new a(pbActivity3);
                                    StringBuilder sb = new StringBuilder();
                                    voteDataInfo2 = this.ggH.ggC;
                                    List<com.baidu.tbadk.widget.vote.a> options = voteDataInfo2.getOptions();
                                    if (options != null) {
                                        for (com.baidu.tbadk.widget.vote.a aVar2 : options) {
                                            if (aVar2 != null && aVar2.isSelected()) {
                                                sb.append(aVar2.getId()).append(",");
                                                list = this.ggH.ggD;
                                                list.add((g) aVar2);
                                                voteDataInfo3 = this.ggH.ggC;
                                                if (voteDataInfo3.getIsMulti() != 1) {
                                                    break;
                                                }
                                            }
                                        }
                                        if (sb.toString().endsWith(",")) {
                                            sb.deleteCharAt(sb.length() - 1);
                                        }
                                        if (TextUtils.isEmpty(sb.toString())) {
                                            pbActivity4 = this.ggH.eug;
                                            UtilHelper.showToast(pbActivity4.getActivity(), r.j.vote_checked_less_one);
                                            return;
                                        }
                                        j3 = this.ggH.mForumId;
                                        j4 = this.ggH.mThreadId;
                                        aVar.a(j3, j4, sb.toString());
                                        this.ggH.ggE = true;
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
