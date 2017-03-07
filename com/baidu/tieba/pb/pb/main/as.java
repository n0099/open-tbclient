package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.pb.pb.main.da;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class as implements da.a {
    final /* synthetic */ PbActivity elO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(PbActivity pbActivity) {
        this.elO = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.da.a
    public void h(int i, String str, String str2) {
        fa faVar;
        if (StringUtils.isNull(str)) {
            if (i == 0) {
                this.elO.showToast(w.l.upgrage_toast_dialog);
            } else {
                this.elO.showToast(w.l.neterror);
            }
        } else if (i != 0 && !TextUtils.isEmpty(str2)) {
            this.elO.elH = str2;
            faVar = this.elO.ekM;
            faVar.nA(str);
        } else {
            this.elO.showToast(str);
        }
    }
}
