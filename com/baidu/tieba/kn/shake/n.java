package com.baidu.tieba.kn.shake;

import android.text.TextUtils;
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.SendPKVoteData;
import com.baidu.tieba.model.bq;
import com.baidu.tieba.model.bu;
import com.baidu.tieba.util.aq;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class n implements bu {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VoteResultActivity f1290a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(VoteResultActivity voteResultActivity) {
        this.f1290a = voteResultActivity;
    }

    @Override // com.baidu.tieba.model.bu
    public void a() {
        q qVar;
        qVar = this.f1290a.f1277a;
        qVar.b();
    }

    @Override // com.baidu.tieba.model.bu
    public void a(SendPKVoteData sendPKVoteData) {
        q qVar;
        bq bqVar;
        q qVar2;
        q qVar3;
        try {
            qVar = this.f1290a.f1277a;
            qVar.c();
            if (sendPKVoteData == null) {
                this.f1290a.c(R.string.neterror);
                this.f1290a.f();
                return;
            }
            SendPKVoteData.Error error = sendPKVoteData.getError();
            if (error == null) {
                String errorMsg = sendPKVoteData.getErrorMsg();
                if (TextUtils.isEmpty(errorMsg)) {
                    this.f1290a.c(R.string.neterror);
                } else {
                    this.f1290a.a(errorMsg);
                }
                this.f1290a.f();
            } else if ("0".equals(error.getErrorId())) {
                this.f1290a.c(R.string.share_result_send_success);
                this.f1290a.c = true;
                com.baidu.tieba.kn.a a2 = com.baidu.tieba.kn.a.a();
                bqVar = this.f1290a.b;
                a2.a(Integer.valueOf(bqVar.c()).intValue(), TiebaApplication.g().aU() * LocationClientOption.MIN_SCAN_SPAN);
                this.f1290a.c(sendPKVoteData.getResultPic());
                qVar2 = this.f1290a.f1277a;
                qVar2.d();
                qVar3 = this.f1290a.f1277a;
                qVar3.f();
            } else {
                this.f1290a.a(error.getUserMsg());
                this.f1290a.f();
            }
        } catch (Exception e) {
            aq.b(getClass().getName(), "onPostProgress", e.toString());
        }
    }
}
