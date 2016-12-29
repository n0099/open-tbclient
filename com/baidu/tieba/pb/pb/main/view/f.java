package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e ehH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.ehH = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        if (view == this.ehH.aDT) {
            pbActivity = this.ehH.dYB;
            if (pbActivity != null) {
                pbActivity2 = this.ehH.dYB;
                pbActivity2.finish();
            }
        }
    }
}
