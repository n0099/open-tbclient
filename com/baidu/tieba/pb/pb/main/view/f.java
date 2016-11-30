package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e eDG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.eDG = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        if (view == this.eDG.aEA) {
            pbActivity = this.eDG.eug;
            if (pbActivity != null) {
                pbActivity2 = this.eDG.eug;
                pbActivity2.finish();
            }
        }
    }
}
