package com.baidu.tieba.person;

import android.widget.TextView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class z implements Runnable {
    final /* synthetic */ s dvP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(s sVar) {
        this.dvP = sVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        textView = this.dvP.aHS;
        com.baidu.tbadk.core.util.at.b(textView, t.d.cp_cont_f, t.d.navi_op_text_skin);
    }
}
