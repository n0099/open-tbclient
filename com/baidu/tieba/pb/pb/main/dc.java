package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditorToolView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dc implements View.OnClickListener {
    final /* synthetic */ cj bMC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dc(cj cjVar) {
        this.bMC = cjVar;
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
        pbEditor = this.bMC.bMh;
        if (pbEditor == null) {
            this.bMC.aaI();
        }
        pbEditor2 = this.bMC.bMh;
        if (pbEditor2 != null) {
            z = this.bMC.bMA;
            if (z) {
                this.bMC.abm();
            } else {
                this.bMC.abn();
            }
            pbActivity = this.bMC.bIT;
            if (pbActivity != null) {
                pbActivity3 = this.bMC.bIT;
                pbActivity3.Zv();
                pbActivity4 = this.bMC.bIT;
                pbActivity4.IR();
            } else {
                pbEditor3 = this.bMC.bMh;
                pbEditor3.Cf();
                this.bMC.dS(false);
            }
            this.bMC.bMm = false;
            pbActivity2 = this.bMC.bIT;
            pbEditor4 = this.bMC.bMh;
            PbEditorToolView editorToolButtonContainer = pbEditor4.getEditorToolButtonContainer();
            hVar = this.bMC.bMv;
            com.baidu.tieba.tbadkCore.b.a.a(pbActivity2, editorToolButtonContainer, false, hVar);
        }
        view2 = this.bMC.bMj;
        if (view2 != null) {
            view3 = this.bMC.bMj;
            view3.setVisibility(8);
            this.bMC.bMm = false;
        }
    }
}
