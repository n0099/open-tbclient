package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.pb.pb.main.di;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class at implements di.a {
    final /* synthetic */ PbActivity ehy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(PbActivity pbActivity) {
        this.ehy = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.di.a
    public void i(int i, String str, String str2) {
        fm fmVar;
        if (StringUtils.isNull(str)) {
            if (i == 0) {
                this.ehy.showToast(w.l.upgrage_toast_dialog);
            } else {
                this.ehy.showToast(w.l.neterror);
            }
        } else if (i != 0 && !TextUtils.isEmpty(str2)) {
            this.ehy.ehr = str2;
            fmVar = this.ehy.egt;
            fmVar.nN(str);
        } else {
            this.ehy.showToast(str);
        }
    }
}
