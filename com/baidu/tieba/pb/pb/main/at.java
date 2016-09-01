package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.pb.pb.main.ct;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class at implements ct.a {
    final /* synthetic */ PbActivity eob;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(PbActivity pbActivity) {
        this.eob = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.ct.a
    public void h(int i, String str, String str2) {
        ex exVar;
        if (StringUtils.isNull(str)) {
            if (i == 0) {
                this.eob.showToast(t.j.upgrage_toast_dialog);
            } else {
                this.eob.showToast(t.j.neterror);
            }
        } else if (i != 0 && !TextUtils.isEmpty(str2)) {
            this.eob.enV = str2;
            exVar = this.eob.enh;
            exVar.oZ(str);
        } else {
            this.eob.showToast(str);
        }
    }
}
