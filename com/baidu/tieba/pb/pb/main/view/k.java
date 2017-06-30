package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ j eGR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.eGR = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        pbActivity = this.eGR.euf;
        pbActivity.aej();
    }
}
