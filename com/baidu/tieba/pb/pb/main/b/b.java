package com.baidu.tieba.pb.pb.main.b;

import android.view.View;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a bMF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bMF = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        pbActivity = this.bMF.bIF;
        pbActivity.Jt();
    }
}
