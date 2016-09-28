package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.pb.pb.main.ct;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class at implements ct.a {
    final /* synthetic */ PbActivity eqa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(PbActivity pbActivity) {
        this.eqa = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.ct.a
    public void h(int i, String str, String str2) {
        ex exVar;
        if (StringUtils.isNull(str)) {
            if (i == 0) {
                this.eqa.showToast(r.j.upgrage_toast_dialog);
            } else {
                this.eqa.showToast(r.j.neterror);
            }
        } else if (i != 0 && !TextUtils.isEmpty(str2)) {
            this.eqa.epU = str2;
            exVar = this.eqa.epe;
            exVar.po(str);
        } else {
            this.eqa.showToast(str);
        }
    }
}
