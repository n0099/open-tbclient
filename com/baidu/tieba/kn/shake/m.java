package com.baidu.tieba.kn.shake;

import android.text.TextUtils;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.SendAloneVoteData;
import com.baidu.tieba.model.cb;
import com.baidu.tieba.model.cd;
import com.baidu.tieba.util.be;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class m implements cd {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VoteResultActivity f1818a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(VoteResultActivity voteResultActivity) {
        this.f1818a = voteResultActivity;
    }

    @Override // com.baidu.tieba.model.cd
    public void a() {
        q qVar;
        qVar = this.f1818a.f1806a;
        qVar.a();
    }

    @Override // com.baidu.tieba.model.cd
    public void a(SendAloneVoteData sendAloneVoteData) {
        q qVar;
        cb cbVar;
        q qVar2;
        q qVar3;
        try {
            qVar = this.f1818a.f1806a;
            qVar.e();
            if (sendAloneVoteData == null) {
                this.f1818a.b(R.string.neterror);
                this.f1818a.h();
                return;
            }
            SendAloneVoteData.Error error = sendAloneVoteData.getError();
            if (error == null) {
                String errorMsg = sendAloneVoteData.getErrorMsg();
                if (TextUtils.isEmpty(errorMsg)) {
                    this.f1818a.b(R.string.neterror);
                } else {
                    this.f1818a.a(errorMsg);
                }
                this.f1818a.h();
            } else if (SocialConstants.FALSE.equals(error.getErrorId())) {
                this.f1818a.b(R.string.share_result_send_success);
                this.f1818a.d = true;
                com.baidu.tieba.kn.a a2 = com.baidu.tieba.kn.a.a();
                cbVar = this.f1818a.b;
                a2.a(Integer.valueOf(cbVar.c()).intValue(), TiebaApplication.g().aV() * LocationClientOption.MIN_SCAN_SPAN);
                this.f1818a.c(sendAloneVoteData.getResultPic());
                qVar2 = this.f1818a.f1806a;
                qVar2.f();
                qVar3 = this.f1818a.f1806a;
                qVar3.h();
            } else {
                this.f1818a.a(error.getUserMsg());
                this.f1818a.h();
            }
        } catch (Exception e) {
            be.b(getClass().getName(), "onPostProgress", e.toString());
        }
    }
}
