package com.baidu.tieba.person;

import android.widget.TextView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class aa implements Runnable {
    final /* synthetic */ t eeh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(t tVar) {
        this.eeh = tVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        textView = this.eeh.aLo;
        com.baidu.tbadk.core.util.av.b(textView, u.d.cp_cont_f, u.d.navi_op_text_skin);
    }
}
