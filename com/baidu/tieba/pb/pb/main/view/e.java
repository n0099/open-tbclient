package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ d eub;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.eub = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        if (view == this.eub.aIg) {
            pbActivity = this.eub.eka;
            if (pbActivity != null) {
                pbActivity2 = this.eub.eka;
                pbActivity2.finish();
            }
        }
    }
}
