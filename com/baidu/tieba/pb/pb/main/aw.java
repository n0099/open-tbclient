package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.pb.pb.main.Cdo;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class aw implements Cdo.a {
    final /* synthetic */ PbActivity enc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(PbActivity pbActivity) {
        this.enc = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.Cdo.a
    public void i(int i, String str, String str2) {
        fx fxVar;
        if (StringUtils.isNull(str)) {
            if (i == 0) {
                this.enc.showToast(w.l.upgrage_toast_dialog);
            } else {
                this.enc.showToast(w.l.neterror);
            }
        } else if (i != 0 && !TextUtils.isEmpty(str2)) {
            this.enc.emV = str2;
            fxVar = this.enc.elU;
            fxVar.nZ(str);
        } else {
            this.enc.showToast(str);
        }
    }
}
