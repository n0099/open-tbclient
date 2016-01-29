package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.pb.pb.main.cm;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class ag implements cm.a {
    final /* synthetic */ PbActivity cNq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(PbActivity pbActivity) {
        this.cNq = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.cm.a
    public void g(int i, String str, String str2) {
        dz dzVar;
        if (StringUtils.isNull(str)) {
            if (i == 0) {
                this.cNq.showToast(t.j.upgrage_toast_dialog);
            } else {
                this.cNq.showToast(t.j.neterror);
            }
        } else if (i != 0 && !TextUtils.isEmpty(str2)) {
            this.cNq.cNo = str2;
            dzVar = this.cNq.cMK;
            dzVar.kP(str);
        } else {
            this.cNq.showToast(str);
        }
    }
}
