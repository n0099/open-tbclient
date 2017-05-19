package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ d epZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.epZ = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        if (view == this.epZ.aIC) {
            pbActivity = this.epZ.efF;
            if (pbActivity != null) {
                pbActivity2 = this.epZ.efF;
                pbActivity2.finish();
            }
        }
    }
}
