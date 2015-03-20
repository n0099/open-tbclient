package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditorToolView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class db implements View.OnClickListener {
    final /* synthetic */ ci bMm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public db(ci ciVar) {
        this.bMm = ciVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbEditor pbEditor;
        PbEditor pbEditor2;
        View view2;
        View view3;
        boolean z;
        PbActivity pbActivity;
        PbEditor pbEditor3;
        PbActivity pbActivity2;
        PbEditor pbEditor4;
        com.baidu.tieba.tbadkCore.b.h hVar;
        PbActivity pbActivity3;
        PbActivity pbActivity4;
        pbEditor = this.bMm.bLR;
        if (pbEditor == null) {
            this.bMm.aav();
        }
        pbEditor2 = this.bMm.bLR;
        if (pbEditor2 != null) {
            z = this.bMm.bMk;
            if (z) {
                this.bMm.aaY();
            } else {
                this.bMm.aaZ();
            }
            pbActivity = this.bMm.bIF;
            if (pbActivity != null) {
                pbActivity3 = this.bMm.bIF;
                pbActivity3.Zi();
                pbActivity4 = this.bMm.bIF;
                pbActivity4.IL();
            } else {
                pbEditor3 = this.bMm.bLR;
                pbEditor3.BZ();
                this.bMm.dU(false);
            }
            this.bMm.bLW = false;
            pbActivity2 = this.bMm.bIF;
            pbEditor4 = this.bMm.bLR;
            PbEditorToolView editorToolButtonContainer = pbEditor4.getEditorToolButtonContainer();
            hVar = this.bMm.bMf;
            com.baidu.tieba.tbadkCore.b.a.a(pbActivity2, editorToolButtonContainer, false, hVar);
        }
        view2 = this.bMm.bLT;
        if (view2 != null) {
            view3 = this.bMm.bLT;
            view3.setVisibility(8);
            this.bMm.bLW = false;
        }
    }
}
