package com.baidu.tieba.pb.pb.main.b;

import android.view.View;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ c cno;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.cno = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        pbActivity = this.cno.cjZ;
        pbActivity.Ls();
    }
}
