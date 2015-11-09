package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements View.OnClickListener {
    final /* synthetic */ WriteActivity dsa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(WriteActivity writeActivity) {
        this.dsa = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.dsa.showDialog(i.f.live_time_rel);
    }
}
