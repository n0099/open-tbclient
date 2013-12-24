package com.baidu.tieba.more;

import android.text.TextUtils;
import com.baidu.tieba.im.message.bd;
import com.baidu.tieba.im.message.bx;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class am implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ SecretSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(SecretSettingActivity secretSettingActivity) {
        this.a = secretSettingActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.n nVar) {
        an anVar;
        an anVar2;
        an anVar3;
        an anVar4;
        anVar = this.a.b;
        anVar.g();
        if (nVar.t() == 104103) {
            if (!(nVar instanceof bd)) {
                this.a.showToast(R.string.neterror);
                return;
            }
            bd bdVar = (bd) nVar;
            com.baidu.tieba.im.message.n l = bdVar.l();
            if (!(l instanceof com.baidu.tieba.im.message.aa)) {
                this.a.showToast(R.string.neterror);
            } else if (((com.baidu.tieba.im.message.aa) l).b() == 8) {
                if (bdVar.i()) {
                    if (bdVar.j() > 0) {
                        if (!TextUtils.isEmpty(bdVar.k())) {
                            this.a.showToast(bdVar.k());
                            return;
                        }
                        return;
                    }
                    this.a.showToast(R.string.neterror);
                    return;
                }
                boolean z = bdVar.a() != 0;
                anVar4 = this.a.b;
                anVar4.i().setSelected(z);
            }
        } else if (nVar.t() == 104102) {
            if (!(nVar instanceof bx)) {
                this.a.showToast(R.string.neterror);
                return;
            }
            bx bxVar = (bx) nVar;
            com.baidu.tieba.im.message.n l2 = bxVar.l();
            if (!(l2 instanceof com.baidu.tieba.im.message.at)) {
                this.a.showToast(R.string.neterror);
            } else if (((com.baidu.tieba.im.message.at) l2).b() == 8) {
                if (!bxVar.i()) {
                    anVar2 = this.a.b;
                    Object tag = anVar2.i().getTag();
                    if (tag != null && (tag instanceof Boolean)) {
                        anVar3 = this.a.b;
                        anVar3.i().setSelected(((Boolean) tag).booleanValue());
                    }
                } else if (bxVar.j() > 0) {
                    if (!TextUtils.isEmpty(bxVar.k())) {
                        this.a.showToast(bxVar.k());
                    }
                } else {
                    this.a.showToast(R.string.neterror);
                }
            }
        }
    }
}
