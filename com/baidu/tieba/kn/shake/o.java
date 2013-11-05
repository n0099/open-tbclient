package com.baidu.tieba.kn.shake;

import android.text.TextUtils;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.SendPKVoteData;
import com.baidu.tieba.model.cb;
import com.baidu.tieba.model.cf;
import com.baidu.tieba.util.be;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class o implements cf {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VoteResultActivity f1820a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(VoteResultActivity voteResultActivity) {
        this.f1820a = voteResultActivity;
    }

    @Override // com.baidu.tieba.model.cf
    public void a() {
        q qVar;
        qVar = this.f1820a.f1806a;
        qVar.a();
    }

    @Override // com.baidu.tieba.model.cf
    public void a(SendPKVoteData sendPKVoteData) {
        q qVar;
        cb cbVar;
        q qVar2;
        q qVar3;
        try {
            qVar = this.f1820a.f1806a;
            qVar.e();
            if (sendPKVoteData == null) {
                this.f1820a.b(R.string.neterror);
                this.f1820a.h();
                return;
            }
            SendPKVoteData.Error error = sendPKVoteData.getError();
            if (error == null) {
                String errorMsg = sendPKVoteData.getErrorMsg();
                if (TextUtils.isEmpty(errorMsg)) {
                    this.f1820a.b(R.string.neterror);
                } else {
                    this.f1820a.a(errorMsg);
                }
                this.f1820a.h();
            } else if (SocialConstants.FALSE.equals(error.getErrorId())) {
                this.f1820a.b(R.string.share_result_send_success);
                this.f1820a.c = true;
                com.baidu.tieba.kn.a a2 = com.baidu.tieba.kn.a.a();
                cbVar = this.f1820a.b;
                a2.a(Integer.valueOf(cbVar.c()).intValue(), TiebaApplication.g().aV() * LocationClientOption.MIN_SCAN_SPAN);
                this.f1820a.c(sendPKVoteData.getResultPic());
                qVar2 = this.f1820a.f1806a;
                qVar2.f();
                qVar3 = this.f1820a.f1806a;
                qVar3.h();
            } else {
                this.f1820a.a(error.getUserMsg());
                this.f1820a.h();
            }
        } catch (Exception e) {
            be.b(getClass().getName(), "onPostProgress", e.toString());
        }
    }
}
