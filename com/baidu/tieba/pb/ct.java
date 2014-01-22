package com.baidu.tieba.pb;

import android.view.View;
import com.baidu.tieba.view.PbListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ct implements View.OnClickListener {
    final /* synthetic */ cr a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(cr crVar) {
        this.a = crVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbListView pbListView;
        boolean z;
        pbListView = this.a.as;
        pbListView.c();
        by byVar = this.a.f;
        z = this.a.at;
        byVar.a(z);
        this.a.ai();
    }
}
