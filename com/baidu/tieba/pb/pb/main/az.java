package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.pb.pb.main.dv;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class az implements dv.a {
    final /* synthetic */ PbActivity ewh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(PbActivity pbActivity) {
        this.ewh = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.dv.a
    public void i(int i, String str, String str2) {
        gg ggVar;
        if (StringUtils.isNull(str)) {
            if (i == 0) {
                this.ewh.showToast(w.l.upgrage_toast_dialog);
            } else {
                this.ewh.showToast(w.l.neterror);
            }
        } else if (i != 0 && !TextUtils.isEmpty(str2)) {
            this.ewh.ewa = str2;
            ggVar = this.ewh.euU;
            ggVar.oU(str);
        } else {
            this.ewh.showToast(str);
        }
    }
}
