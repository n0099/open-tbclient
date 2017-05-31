package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ f exh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.exh = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        if (view == this.exh.aIp) {
            pbActivity = this.exh.elf;
            if (pbActivity != null) {
                pbActivity2 = this.exh.elf;
                pbActivity2.finish();
            }
        }
    }
}
