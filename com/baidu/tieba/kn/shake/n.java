package com.baidu.tieba.kn.shake;

import android.text.TextUtils;
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.SendPKVoteData;
import com.baidu.tieba.model.bs;
import com.baidu.tieba.model.bw;
import com.baidu.tieba.util.av;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class n implements bw {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VoteResultActivity f1324a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(VoteResultActivity voteResultActivity) {
        this.f1324a = voteResultActivity;
    }

    @Override // com.baidu.tieba.model.bw
    public void a() {
        q qVar;
        qVar = this.f1324a.f1311a;
        qVar.b();
    }

    @Override // com.baidu.tieba.model.bw
    public void a(SendPKVoteData sendPKVoteData) {
        q qVar;
        bs bsVar;
        q qVar2;
        q qVar3;
        try {
            qVar = this.f1324a.f1311a;
            qVar.c();
            if (sendPKVoteData == null) {
                this.f1324a.c(R.string.neterror);
                this.f1324a.g();
                return;
            }
            SendPKVoteData.Error error = sendPKVoteData.getError();
            if (error == null) {
                String errorMsg = sendPKVoteData.getErrorMsg();
                if (TextUtils.isEmpty(errorMsg)) {
                    this.f1324a.c(R.string.neterror);
                } else {
                    this.f1324a.a(errorMsg);
                }
                this.f1324a.g();
            } else if ("0".equals(error.getErrorId())) {
                this.f1324a.c(R.string.share_result_send_success);
                this.f1324a.c = true;
                com.baidu.tieba.kn.a a2 = com.baidu.tieba.kn.a.a();
                bsVar = this.f1324a.b;
                a2.a(Integer.valueOf(bsVar.c()).intValue(), TiebaApplication.g().aQ() * LocationClientOption.MIN_SCAN_SPAN);
                this.f1324a.c(sendPKVoteData.getResultPic());
                qVar2 = this.f1324a.f1311a;
                qVar2.d();
                qVar3 = this.f1324a.f1311a;
                qVar3.f();
            } else {
                this.f1324a.a(error.getUserMsg());
                this.f1324a.g();
            }
        } catch (Exception e) {
            av.b(getClass().getName(), "onPostProgress", e.toString());
        }
    }
}
