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
    final /* synthetic */ b djz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.djz = bVar;
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
            pbActivity = this.djz.ciU;
            if (pbActivity != null) {
                pbActivity2 = this.djz.ciU;
                if (pbActivity2.checkUpIsLogin()) {
                    voteDataInfo = this.djz.dju;
                    if (voteDataInfo != null) {
                        j = this.djz.mForumId;
                        if (j > 0) {
                            j2 = this.djz.mThreadId;
                            if (j2 > 0) {
                                z = this.djz.djw;
                                if (!z) {
                                    pbActivity3 = this.djz.ciU;
                                    a aVar = new a(pbActivity3);
                                    StringBuilder sb = new StringBuilder();
                                    voteDataInfo2 = this.djz.dju;
                                    List<com.baidu.tbadk.widget.vote.a> options = voteDataInfo2.getOptions();
                                    if (options != null) {
                                        for (com.baidu.tbadk.widget.vote.a aVar2 : options) {
                                            if (aVar2 != null && aVar2.isSelected()) {
                                                sb.append(aVar2.getId()).append(",");
                                                list = this.djz.djv;
                                                list.add((f) aVar2);
                                                voteDataInfo3 = this.djz.dju;
                                                if (voteDataInfo3.getIsMulti() != 1) {
                                                    break;
                                                }
                                            }
                                        }
                                        if (sb.toString().endsWith(",")) {
                                            sb.deleteCharAt(sb.length() - 1);
                                        }
                                        if (TextUtils.isEmpty(sb.toString())) {
                                            pbActivity4 = this.djz.ciU;
                                            UtilHelper.showToast(pbActivity4.getActivity(), i.h.vote_checked_less_one);
                                            return;
                                        }
                                        j3 = this.djz.mForumId;
                                        j4 = this.djz.mThreadId;
                                        aVar.c(j3, j4, sb.toString());
                                        this.djz.djw = true;
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
