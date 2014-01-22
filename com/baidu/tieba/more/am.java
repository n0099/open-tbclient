package com.baidu.tieba.more;

import android.text.TextUtils;
import com.baidu.tieba.im.message.bd;
import com.baidu.tieba.im.message.bq;
import com.baidu.tieba.im.message.co;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class am implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ SecretSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(SecretSettingActivity secretSettingActivity) {
        this.a = secretSettingActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.q qVar) {
        an anVar;
        an anVar2;
        an anVar3;
        an anVar4;
        anVar = this.a.b;
        anVar.g();
        if (qVar.w() == 104103) {
            if (!(qVar instanceof bq)) {
                this.a.showToast(R.string.neterror);
                return;
            }
            bq bqVar = (bq) qVar;
            com.baidu.tieba.im.message.q n = bqVar.n();
            if (!(n instanceof com.baidu.tieba.im.message.ah)) {
                this.a.showToast(R.string.neterror);
            } else if (((com.baidu.tieba.im.message.ah) n).b() == 8) {
                if (bqVar.k()) {
                    if (bqVar.l() > 0) {
                        if (!TextUtils.isEmpty(bqVar.m())) {
                            this.a.showToast(bqVar.m());
                            return;
                        }
                        return;
                    }
                    this.a.showToast(R.string.neterror);
                    return;
                }
                boolean z = bqVar.a() != 0;
                anVar4 = this.a.b;
                anVar4.i().setSelected(z);
            }
        } else if (qVar.w() == 104102) {
            if (!(qVar instanceof co)) {
                this.a.showToast(R.string.neterror);
                return;
            }
            co coVar = (co) qVar;
            com.baidu.tieba.im.message.q n2 = coVar.n();
            if (!(n2 instanceof bd)) {
                this.a.showToast(R.string.neterror);
            } else if (((bd) n2).b() == 8) {
                if (!coVar.k()) {
                    anVar2 = this.a.b;
                    Object tag = anVar2.i().getTag();
                    if (tag != null && (tag instanceof Boolean)) {
                        anVar3 = this.a.b;
                        anVar3.i().setSelected(((Boolean) tag).booleanValue());
                    }
                } else if (coVar.l() > 0) {
                    if (!TextUtils.isEmpty(coVar.m())) {
                        this.a.showToast(coVar.m());
                    }
                } else {
                    this.a.showToast(R.string.neterror);
                }
            }
        }
    }
}
