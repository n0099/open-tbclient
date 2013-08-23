package com.baidu.tieba.kn.shake;

import android.text.TextUtils;
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.SendAloneVoteData;
import com.baidu.tieba.model.bq;
import com.baidu.tieba.model.bs;
import com.baidu.tieba.util.aq;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class m implements bs {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VoteResultActivity f1289a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(VoteResultActivity voteResultActivity) {
        this.f1289a = voteResultActivity;
    }

    @Override // com.baidu.tieba.model.bs
    public void a() {
        q qVar;
        qVar = this.f1289a.f1277a;
        qVar.b();
    }

    @Override // com.baidu.tieba.model.bs
    public void a(SendAloneVoteData sendAloneVoteData) {
        q qVar;
        bq bqVar;
        q qVar2;
        q qVar3;
        try {
            qVar = this.f1289a.f1277a;
            qVar.c();
            if (sendAloneVoteData == null) {
                this.f1289a.c(R.string.neterror);
                this.f1289a.f();
                return;
            }
            SendAloneVoteData.Error error = sendAloneVoteData.getError();
            if (error == null) {
                String errorMsg = sendAloneVoteData.getErrorMsg();
                if (TextUtils.isEmpty(errorMsg)) {
                    this.f1289a.c(R.string.neterror);
                } else {
                    this.f1289a.a(errorMsg);
                }
                this.f1289a.f();
            } else if ("0".equals(error.getErrorId())) {
                this.f1289a.c(R.string.share_result_send_success);
                this.f1289a.d = true;
                com.baidu.tieba.kn.a a2 = com.baidu.tieba.kn.a.a();
                bqVar = this.f1289a.b;
                a2.a(Integer.valueOf(bqVar.c()).intValue(), TiebaApplication.g().aU() * LocationClientOption.MIN_SCAN_SPAN);
                this.f1289a.c(sendAloneVoteData.getResultPic());
                qVar2 = this.f1289a.f1277a;
                qVar2.d();
                qVar3 = this.f1289a.f1277a;
                qVar3.f();
            } else {
                this.f1289a.a(error.getUserMsg());
                this.f1289a.f();
            }
        } catch (Exception e) {
            aq.b(getClass().getName(), "onPostProgress", e.toString());
        }
    }
}
