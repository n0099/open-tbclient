package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.pb.pb.main.ct;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class as implements ct.a {
    final /* synthetic */ PbActivity eah;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(PbActivity pbActivity) {
        this.eah = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.ct.a
    public void h(int i, String str, String str2) {
        er erVar;
        if (StringUtils.isNull(str)) {
            if (i == 0) {
                this.eah.showToast(r.j.upgrage_toast_dialog);
            } else {
                this.eah.showToast(r.j.neterror);
            }
        } else if (i != 0 && !TextUtils.isEmpty(str2)) {
            this.eah.eab = str2;
            erVar = this.eah.dZk;
            erVar.oc(str);
        } else {
            this.eah.showToast(str);
        }
    }
}
