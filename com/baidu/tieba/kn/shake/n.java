package com.baidu.tieba.kn.shake;

import android.text.TextUtils;
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.SendPKVoteData;
import com.baidu.tieba.model.br;
import com.baidu.tieba.model.bv;
import com.baidu.tieba.util.aj;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class n implements bv {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VoteResultActivity f1259a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(VoteResultActivity voteResultActivity) {
        this.f1259a = voteResultActivity;
    }

    @Override // com.baidu.tieba.model.bv
    public void a() {
        q qVar;
        qVar = this.f1259a.f1246a;
        qVar.b();
    }

    @Override // com.baidu.tieba.model.bv
    public void a(SendPKVoteData sendPKVoteData) {
        q qVar;
        br brVar;
        q qVar2;
        q qVar3;
        try {
            qVar = this.f1259a.f1246a;
            qVar.c();
            if (sendPKVoteData == null) {
                this.f1259a.c(R.string.neterror);
                this.f1259a.f();
                return;
            }
            SendPKVoteData.Error error = sendPKVoteData.getError();
            if (error == null) {
                String errorMsg = sendPKVoteData.getErrorMsg();
                if (TextUtils.isEmpty(errorMsg)) {
                    this.f1259a.c(R.string.neterror);
                } else {
                    this.f1259a.a(errorMsg);
                }
                this.f1259a.f();
            } else if ("0".equals(error.getErrorId())) {
                this.f1259a.c(R.string.share_result_send_success);
                this.f1259a.c = true;
                com.baidu.tieba.kn.a a2 = com.baidu.tieba.kn.a.a();
                brVar = this.f1259a.b;
                a2.a(Integer.valueOf(brVar.c()).intValue(), TiebaApplication.f().bg() * LocationClientOption.MIN_SCAN_SPAN);
                this.f1259a.c(sendPKVoteData.getResultPic());
                qVar2 = this.f1259a.f1246a;
                qVar2.d();
                qVar3 = this.f1259a.f1246a;
                qVar3.f();
            } else {
                this.f1259a.a(error.getUserMsg());
                this.f1259a.f();
            }
        } catch (Exception e) {
            aj.b(getClass().getName(), "onPostProgress", e.toString());
        }
    }
}
