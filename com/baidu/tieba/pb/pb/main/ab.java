package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.n;
import com.baidu.tieba.pb.pb.main.cf;
/* loaded from: classes.dex */
class ab implements cf.a {
    final /* synthetic */ PbActivity cFS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(PbActivity pbActivity) {
        this.cFS = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.cf.a
    public void f(int i, String str, String str2) {
        dk dkVar;
        if (StringUtils.isNull(str)) {
            if (i == 0) {
                this.cFS.showToast(n.j.upgrage_toast_dialog);
            } else {
                this.cFS.showToast(n.j.neterror);
            }
        } else if (i != 0 && !TextUtils.isEmpty(str2)) {
            this.cFS.cFQ = str2;
            dkVar = this.cFS.cFq;
            dkVar.kJ(str);
        } else {
            this.cFS.showToast(str);
        }
    }
}
