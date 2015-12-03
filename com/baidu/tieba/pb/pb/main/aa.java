package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.n;
import com.baidu.tieba.pb.pb.main.cc;
/* loaded from: classes.dex */
class aa implements cc.a {
    final /* synthetic */ PbActivity cCm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(PbActivity pbActivity) {
        this.cCm = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.cc.a
    public void f(int i, String str, String str2) {
        da daVar;
        if (StringUtils.isNull(str)) {
            if (i == 0) {
                this.cCm.showToast(n.i.upgrage_toast_dialog);
            } else {
                this.cCm.showToast(n.i.neterror);
            }
        } else if (i != 0 && !TextUtils.isEmpty(str2)) {
            this.cCm.cCk = str2;
            daVar = this.cCm.cBL;
            daVar.kL(str);
        } else {
            this.cCm.showToast(str);
        }
    }
}
