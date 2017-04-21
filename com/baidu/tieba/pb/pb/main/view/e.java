package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ d euw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.euw = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        if (view == this.euw.aIy) {
            pbActivity = this.euw.ekw;
            if (pbActivity != null) {
                pbActivity2 = this.euw.ekw;
                pbActivity2.finish();
            }
        }
    }
}
