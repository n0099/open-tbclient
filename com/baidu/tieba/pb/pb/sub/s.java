package com.baidu.tieba.pb.pb.sub;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ NewSubPbActivity cLc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(NewSubPbActivity newSubPbActivity) {
        this.cLc = newSubPbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ao aoVar;
        ao aoVar2;
        aoVar = this.cLc.cKR;
        if (aoVar != null) {
            aoVar2 = this.cLc.cKR;
            aoVar2.Dy();
        }
    }
}
