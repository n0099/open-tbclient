package com.baidu.tieba.more;

import android.text.TextUtils;
import com.baidu.tieba.im.message.bj;
import com.baidu.tieba.im.message.bz;
import com.baidu.tieba.im.message.cx;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class al implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ SecretSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(SecretSettingActivity secretSettingActivity) {
        this.a = secretSettingActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.s sVar) {
        am amVar;
        am amVar2;
        am amVar3;
        am amVar4;
        am amVar5;
        am amVar6;
        amVar = this.a.b;
        amVar.g();
        if (sVar.w() == 104103) {
            if (!(sVar instanceof bz)) {
                this.a.showToast(R.string.neterror);
                return;
            }
            bz bzVar = (bz) sVar;
            com.baidu.tieba.im.message.s o = bzVar.o();
            if (!(o instanceof com.baidu.tieba.im.message.an)) {
                this.a.showToast(R.string.neterror);
            } else if (((com.baidu.tieba.im.message.an) o).b() == 8) {
                if (bzVar.l()) {
                    if (bzVar.m() > 0) {
                        if (!TextUtils.isEmpty(bzVar.n())) {
                            this.a.showToast(bzVar.n());
                            return;
                        }
                        return;
                    }
                    this.a.showToast(R.string.neterror);
                    return;
                }
                if (bzVar.a() != 0) {
                    amVar6 = this.a.b;
                    amVar6.i().b();
                    return;
                }
                amVar5 = this.a.b;
                amVar5.i().a();
            }
        } else if (sVar.w() == 104102) {
            if (!(sVar instanceof cx)) {
                this.a.showToast(R.string.neterror);
                return;
            }
            cx cxVar = (cx) sVar;
            com.baidu.tieba.im.message.s o2 = cxVar.o();
            if (!(o2 instanceof bj)) {
                this.a.showToast(R.string.neterror);
            } else if (((bj) o2).b() == 8) {
                if (!cxVar.l()) {
                    amVar2 = this.a.b;
                    Object tag = amVar2.i().getTag();
                    if (tag != null && (tag instanceof Boolean)) {
                        if (((Boolean) tag).booleanValue()) {
                            amVar4 = this.a.b;
                            amVar4.i().b();
                            return;
                        }
                        amVar3 = this.a.b;
                        amVar3.i().a();
                    }
                } else if (cxVar.m() > 0) {
                    if (!TextUtils.isEmpty(cxVar.n())) {
                        this.a.showToast(cxVar.n());
                    }
                } else {
                    this.a.showToast(R.string.neterror);
                }
            }
        }
    }
}
