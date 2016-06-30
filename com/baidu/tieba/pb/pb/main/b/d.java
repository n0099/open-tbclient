package com.baidu.tieba.pb.pb.main.b;

import android.view.View;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ c dWr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.dWr = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        if (view == this.dWr.aAp) {
            pbActivity = this.dWr.dOg;
            if (pbActivity != null) {
                pbActivity2 = this.dWr.dOg;
                pbActivity2.finish();
            }
        }
    }
}
