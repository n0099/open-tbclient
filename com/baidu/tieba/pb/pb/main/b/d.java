package com.baidu.tieba.pb.pb.main.b;

import android.view.View;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ c evb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.evb = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        if (view == this.evb.aEm) {
            pbActivity = this.evb.emy;
            if (pbActivity != null) {
                pbActivity2 = this.evb.emy;
                pbActivity2.finish();
            }
        }
    }
}
