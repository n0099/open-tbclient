package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class ah implements View.OnClickListener {
    final /* synthetic */ WriteActivity cUM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(WriteActivity writeActivity) {
        this.cUM = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cUM.showDialog(i.f.live_time_rel);
    }
}
