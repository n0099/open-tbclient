package com.baidu.tieba.pb.pb.main.b;

import android.view.View;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ c dpT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.dpT = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        if (view == this.dpT.azx) {
            pbActivity = this.dpT.dhY;
            if (pbActivity != null) {
                pbActivity2 = this.dpT.dhY;
                pbActivity2.finish();
            }
        }
    }
}
