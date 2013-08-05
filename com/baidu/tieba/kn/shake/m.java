package com.baidu.tieba.kn.shake;

import android.text.TextUtils;
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.SendAloneVoteData;
import com.baidu.tieba.model.br;
import com.baidu.tieba.model.bt;
import com.baidu.tieba.util.aj;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class m implements bt {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VoteResultActivity f1258a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(VoteResultActivity voteResultActivity) {
        this.f1258a = voteResultActivity;
    }

    @Override // com.baidu.tieba.model.bt
    public void a() {
        q qVar;
        qVar = this.f1258a.f1246a;
        qVar.b();
    }

    @Override // com.baidu.tieba.model.bt
    public void a(SendAloneVoteData sendAloneVoteData) {
        q qVar;
        br brVar;
        q qVar2;
        q qVar3;
        try {
            qVar = this.f1258a.f1246a;
            qVar.c();
            if (sendAloneVoteData == null) {
                this.f1258a.c(R.string.neterror);
                this.f1258a.f();
                return;
            }
            SendAloneVoteData.Error error = sendAloneVoteData.getError();
            if (error == null) {
                String errorMsg = sendAloneVoteData.getErrorMsg();
                if (TextUtils.isEmpty(errorMsg)) {
                    this.f1258a.c(R.string.neterror);
                } else {
                    this.f1258a.a(errorMsg);
                }
                this.f1258a.f();
            } else if ("0".equals(error.getErrorId())) {
                this.f1258a.c(R.string.share_result_send_success);
                this.f1258a.d = true;
                com.baidu.tieba.kn.a a2 = com.baidu.tieba.kn.a.a();
                brVar = this.f1258a.b;
                a2.a(Integer.valueOf(brVar.c()).intValue(), TiebaApplication.f().bg() * LocationClientOption.MIN_SCAN_SPAN);
                this.f1258a.c(sendAloneVoteData.getResultPic());
                qVar2 = this.f1258a.f1246a;
                qVar2.d();
                qVar3 = this.f1258a.f1246a;
                qVar3.f();
            } else {
                this.f1258a.a(error.getUserMsg());
                this.f1258a.f();
            }
        } catch (Exception e) {
            aj.b(getClass().getName(), "onPostProgress", e.toString());
        }
    }
}
