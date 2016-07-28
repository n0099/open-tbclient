package com.baidu.tieba.pb.pb.main.b;

import android.view.View;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ c eiU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.eiU = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        if (view == this.eiU.aBf) {
            pbActivity = this.eiU.eat;
            if (pbActivity != null) {
                pbActivity2 = this.eiU.eat;
                pbActivity2.finish();
            }
        }
    }
}
