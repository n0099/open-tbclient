package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.pb.pb.main.cu;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class at implements cu.a {
    final /* synthetic */ PbActivity evL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(PbActivity pbActivity) {
        this.evL = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.cu.a
    public void h(int i, String str, String str2) {
        ey eyVar;
        if (StringUtils.isNull(str)) {
            if (i == 0) {
                this.evL.showToast(r.j.upgrage_toast_dialog);
            } else {
                this.evL.showToast(r.j.neterror);
            }
        } else if (i != 0 && !TextUtils.isEmpty(str2)) {
            this.evL.evF = str2;
            eyVar = this.evL.euP;
            eyVar.pB(str);
        } else {
            this.evL.showToast(str);
        }
    }
}
