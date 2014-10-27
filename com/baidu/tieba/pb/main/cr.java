package com.baidu.tieba.pb.main;

import android.view.View;
import com.baidu.tieba.editortool.PbEditor;
import com.baidu.tieba.editortool.PbEditorToolView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cr implements View.OnClickListener {
    final /* synthetic */ bv byI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cr(bv bvVar) {
        this.byI = bvVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbEditor pbEditor;
        PbEditor pbEditor2;
        View view2;
        View view3;
        View view4;
        boolean z;
        PbEditor pbEditor3;
        PbActivity pbActivity;
        PbActivity pbActivity2;
        PbEditor pbEditor4;
        com.baidu.tieba.bubble.t tVar;
        PbActivity pbActivity3;
        PbActivity pbActivity4;
        pbEditor = this.byI.byn;
        if (pbEditor == null) {
            this.byI.Xk();
        }
        pbEditor2 = this.byI.byn;
        if (pbEditor2 != null) {
            z = this.byI.byG;
            if (z) {
                this.byI.Bt();
            } else {
                this.byI.Bs();
            }
            pbEditor3 = this.byI.byn;
            pbEditor3.Ba();
            pbActivity = this.byI.bwQ;
            if (pbActivity != null) {
                pbActivity3 = this.byI.bwQ;
                pbActivity3.Wc();
                pbActivity4 = this.byI.bwQ;
                pbActivity4.Ez();
            }
            this.byI.eg(false);
            this.byI.byw = false;
            pbActivity2 = this.byI.bwQ;
            pbEditor4 = this.byI.byn;
            PbEditorToolView editorToolButtonContainer = pbEditor4.getEditorToolButtonContainer();
            tVar = this.byI.aDr;
            com.baidu.tieba.bubble.h.a(pbActivity2, editorToolButtonContainer, false, tVar);
        }
        view2 = this.byI.byq;
        if (view2 != null) {
            view3 = this.byI.byq;
            view3.setVisibility(8);
            view4 = this.byI.byp;
            view4.setVisibility(8);
            this.byI.byw = false;
        }
    }
}
