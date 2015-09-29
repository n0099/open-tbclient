package com.baidu.tieba.vote;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.pb.main.PbActivity;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ b diZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.diZ = bVar;
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
        if (view.getId() == i.f.btn_pb_vote) {
            pbActivity = this.diZ.ciJ;
            if (pbActivity != null) {
                pbActivity2 = this.diZ.ciJ;
                if (pbActivity2.checkUpIsLogin()) {
                    voteDataInfo = this.diZ.diU;
                    if (voteDataInfo != null) {
                        j = this.diZ.mForumId;
                        if (j > 0) {
                            j2 = this.diZ.mThreadId;
                            if (j2 > 0) {
                                z = this.diZ.diW;
                                if (!z) {
                                    pbActivity3 = this.diZ.ciJ;
                                    a aVar = new a(pbActivity3);
                                    StringBuilder sb = new StringBuilder();
                                    voteDataInfo2 = this.diZ.diU;
                                    List<com.baidu.tbadk.widget.vote.a> options = voteDataInfo2.getOptions();
                                    if (options != null) {
                                        for (com.baidu.tbadk.widget.vote.a aVar2 : options) {
                                            if (aVar2 != null && aVar2.isSelected()) {
                                                sb.append(aVar2.getId()).append(",");
                                                list = this.diZ.diV;
                                                list.add((f) aVar2);
                                                voteDataInfo3 = this.diZ.diU;
                                                if (voteDataInfo3.getIsMulti() != 1) {
                                                    break;
                                                }
                                            }
                                        }
                                        if (sb.toString().endsWith(",")) {
                                            sb.deleteCharAt(sb.length() - 1);
                                        }
                                        if (TextUtils.isEmpty(sb.toString())) {
                                            pbActivity4 = this.diZ.ciJ;
                                            UtilHelper.showToast(pbActivity4.getActivity(), i.h.vote_checked_less_one);
                                            return;
                                        }
                                        j3 = this.diZ.mForumId;
                                        j4 = this.diZ.mThreadId;
                                        aVar.c(j3, j4, sb.toString());
                                        this.diZ.diW = true;
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
