package com.baidu.tieba.pb.main.b;

import android.view.View;
import com.baidu.tieba.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a bze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bze = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        pbActivity = this.bze.bwQ;
        pbActivity.FG();
    }
}
