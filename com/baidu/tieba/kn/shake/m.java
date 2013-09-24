package com.baidu.tieba.kn.shake;

import android.text.TextUtils;
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.SendAloneVoteData;
import com.baidu.tieba.model.bs;
import com.baidu.tieba.model.bu;
import com.baidu.tieba.util.av;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class m implements bu {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VoteResultActivity f1323a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(VoteResultActivity voteResultActivity) {
        this.f1323a = voteResultActivity;
    }

    @Override // com.baidu.tieba.model.bu
    public void a() {
        q qVar;
        qVar = this.f1323a.f1311a;
        qVar.b();
    }

    @Override // com.baidu.tieba.model.bu
    public void a(SendAloneVoteData sendAloneVoteData) {
        q qVar;
        bs bsVar;
        q qVar2;
        q qVar3;
        try {
            qVar = this.f1323a.f1311a;
            qVar.c();
            if (sendAloneVoteData == null) {
                this.f1323a.c(R.string.neterror);
                this.f1323a.g();
                return;
            }
            SendAloneVoteData.Error error = sendAloneVoteData.getError();
            if (error == null) {
                String errorMsg = sendAloneVoteData.getErrorMsg();
                if (TextUtils.isEmpty(errorMsg)) {
                    this.f1323a.c(R.string.neterror);
                } else {
                    this.f1323a.a(errorMsg);
                }
                this.f1323a.g();
            } else if ("0".equals(error.getErrorId())) {
                this.f1323a.c(R.string.share_result_send_success);
                this.f1323a.d = true;
                com.baidu.tieba.kn.a a2 = com.baidu.tieba.kn.a.a();
                bsVar = this.f1323a.b;
                a2.a(Integer.valueOf(bsVar.c()).intValue(), TiebaApplication.g().aQ() * LocationClientOption.MIN_SCAN_SPAN);
                this.f1323a.c(sendAloneVoteData.getResultPic());
                qVar2 = this.f1323a.f1311a;
                qVar2.d();
                qVar3 = this.f1323a.f1311a;
                qVar3.f();
            } else {
                this.f1323a.a(error.getUserMsg());
                this.f1323a.g();
            }
        } catch (Exception e) {
            av.b(getClass().getName(), "onPostProgress", e.toString());
        }
    }
}
