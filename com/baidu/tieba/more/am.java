package com.baidu.tieba.more;

import android.text.TextUtils;
import com.baidu.tieba.im.message.bg;
import com.baidu.tieba.im.message.ca;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class am implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ SecretSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(SecretSettingActivity secretSettingActivity) {
        this.a = secretSettingActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.o oVar) {
        an anVar;
        an anVar2;
        an anVar3;
        an anVar4;
        anVar = this.a.b;
        anVar.g();
        if (oVar.u() == 104103) {
            if (!(oVar instanceof bg)) {
                this.a.showToast(R.string.neterror);
                return;
            }
            bg bgVar = (bg) oVar;
            com.baidu.tieba.im.message.o l = bgVar.l();
            if (!(l instanceof com.baidu.tieba.im.message.ad)) {
                this.a.showToast(R.string.neterror);
            } else if (((com.baidu.tieba.im.message.ad) l).b() == 8) {
                if (bgVar.i()) {
                    if (bgVar.j() > 0) {
                        if (!TextUtils.isEmpty(bgVar.k())) {
                            this.a.showToast(bgVar.k());
                            return;
                        }
                        return;
                    }
                    this.a.showToast(R.string.neterror);
                    return;
                }
                boolean z = bgVar.a() != 0;
                anVar4 = this.a.b;
                anVar4.i().setSelected(z);
            }
        } else if (oVar.u() == 104102) {
            if (!(oVar instanceof ca)) {
                this.a.showToast(R.string.neterror);
                return;
            }
            ca caVar = (ca) oVar;
            com.baidu.tieba.im.message.o l2 = caVar.l();
            if (!(l2 instanceof com.baidu.tieba.im.message.aw)) {
                this.a.showToast(R.string.neterror);
            } else if (((com.baidu.tieba.im.message.aw) l2).b() == 8) {
                if (!caVar.i()) {
                    anVar2 = this.a.b;
                    Object tag = anVar2.i().getTag();
                    if (tag != null && (tag instanceof Boolean)) {
                        anVar3 = this.a.b;
                        anVar3.i().setSelected(((Boolean) tag).booleanValue());
                    }
                } else if (caVar.j() > 0) {
                    if (!TextUtils.isEmpty(caVar.k())) {
                        this.a.showToast(caVar.k());
                    }
                } else {
                    this.a.showToast(R.string.neterror);
                }
            }
        }
    }
}
