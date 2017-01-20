package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.pb.pb.main.db;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class as implements db.a {
    final /* synthetic */ PbActivity eiV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(PbActivity pbActivity) {
        this.eiV = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.db.a
    public void i(int i, String str, String str2) {
        ez ezVar;
        if (StringUtils.isNull(str)) {
            if (i == 0) {
                this.eiV.showToast(r.l.upgrage_toast_dialog);
            } else {
                this.eiV.showToast(r.l.neterror);
            }
        } else if (i != 0 && !TextUtils.isEmpty(str2)) {
            this.eiV.eiO = str2;
            ezVar = this.eiV.ehV;
            ezVar.ot(str);
        } else {
            this.eiV.showToast(str);
        }
    }
}
