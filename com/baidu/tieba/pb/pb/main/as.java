package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.pb.pb.main.cs;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class as implements cs.a {
    final /* synthetic */ PbActivity dPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(PbActivity pbActivity) {
        this.dPF = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.cs.a
    public void h(int i, String str, String str2) {
        es esVar;
        if (StringUtils.isNull(str)) {
            if (i == 0) {
                this.dPF.showToast(u.j.upgrage_toast_dialog);
            } else {
                this.dPF.showToast(u.j.neterror);
            }
        } else if (i != 0 && !TextUtils.isEmpty(str2)) {
            this.dPF.dPz = str2;
            esVar = this.dPF.dOO;
            esVar.nD(str);
        } else {
            this.dPF.showToast(str);
        }
    }
}
