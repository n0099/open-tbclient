package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.pb.pb.main.cn;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class ap implements cn.a {
    final /* synthetic */ PbActivity djE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(PbActivity pbActivity) {
        this.djE = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.cn.a
    public void h(int i, String str, String str2) {
        el elVar;
        if (StringUtils.isNull(str)) {
            if (i == 0) {
                this.djE.showToast(t.j.upgrage_toast_dialog);
            } else {
                this.djE.showToast(t.j.neterror);
            }
        } else if (i != 0 && !TextUtils.isEmpty(str2)) {
            this.djE.djy = str2;
            elVar = this.djE.diR;
            elVar.mc(str);
        } else {
            this.djE.showToast(str);
        }
    }
}
