package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements View.OnClickListener {
    final /* synthetic */ WriteActivity dRf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(WriteActivity writeActivity) {
        this.dRf = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.dRf.showDialog(n.f.live_time_rel);
    }
}
