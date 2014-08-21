package com.baidu.tieba.pb.main;

import android.view.View;
import com.baidu.tieba.editortool.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cp implements View.OnClickListener {
    final /* synthetic */ bs a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(bs bsVar) {
        this.a = bsVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        View view3;
        View view4;
        PbActivity pbActivity;
        com.baidu.tieba.bubble.t tVar;
        if (this.a.h != null) {
            this.a.h.n();
            this.a.z();
            this.a.aQ = false;
            pbActivity = this.a.k;
            PbEditor pbEditor = this.a.h;
            tVar = this.a.aY;
            com.baidu.tieba.bubble.h.a(pbActivity, pbEditor, false, tVar);
        }
        view2 = this.a.aK;
        if (view2 != null) {
            view3 = this.a.aK;
            view3.setVisibility(8);
            view4 = this.a.aJ;
            view4.setVisibility(8);
            this.a.aQ = false;
        }
    }
}
