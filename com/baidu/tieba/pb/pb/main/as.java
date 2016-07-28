package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.pb.pb.main.ct;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class as implements ct.a {
    final /* synthetic */ PbActivity ebT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(PbActivity pbActivity) {
        this.ebT = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.ct.a
    public void h(int i, String str, String str2) {
        ew ewVar;
        if (StringUtils.isNull(str)) {
            if (i == 0) {
                this.ebT.showToast(u.j.upgrage_toast_dialog);
            } else {
                this.ebT.showToast(u.j.neterror);
            }
        } else if (i != 0 && !TextUtils.isEmpty(str2)) {
            this.ebT.ebN = str2;
            ewVar = this.ebT.ebb;
            ewVar.oq(str);
        } else {
            this.ebT.showToast(str);
        }
    }
}
