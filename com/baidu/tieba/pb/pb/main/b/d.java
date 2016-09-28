package com.baidu.tieba.pb.pb.main.b;

import android.view.View;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ c exh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.exh = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        if (view == this.exh.aDK) {
            pbActivity = this.exh.eow;
            if (pbActivity != null) {
                pbActivity2 = this.exh.eow;
                pbActivity2.finish();
            }
        }
    }
}
