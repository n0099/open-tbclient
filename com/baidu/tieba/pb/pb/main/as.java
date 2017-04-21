package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.pb.pb.main.cy;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class as implements cy.a {
    final /* synthetic */ PbActivity emk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(PbActivity pbActivity) {
        this.emk = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.cy.a
    public void h(int i, String str, String str2) {
        ey eyVar;
        if (StringUtils.isNull(str)) {
            if (i == 0) {
                this.emk.showToast(w.l.upgrage_toast_dialog);
            } else {
                this.emk.showToast(w.l.neterror);
            }
        } else if (i != 0 && !TextUtils.isEmpty(str2)) {
            this.emk.emd = str2;
            eyVar = this.emk.eli;
            eyVar.nH(str);
        } else {
            this.emk.showToast(str);
        }
    }
}
