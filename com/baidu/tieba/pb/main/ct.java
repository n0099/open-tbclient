package com.baidu.tieba.pb.main;

import android.view.View;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditorToolView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ct implements View.OnClickListener {
    final /* synthetic */ bz bEB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(bz bzVar) {
        this.bEB = bzVar;
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
        com.baidu.tieba.tbadkCore.bubble.y yVar;
        PbActivity pbActivity3;
        PbActivity pbActivity4;
        pbEditor = this.bEB.bEe;
        if (pbEditor == null) {
            this.bEB.Yk();
        }
        pbEditor2 = this.bEB.bEe;
        if (pbEditor2 != null) {
            z = this.bEB.bEz;
            if (z) {
                this.bEB.YO();
            } else {
                this.bEB.YP();
            }
            pbEditor3 = this.bEB.bEe;
            pbEditor3.yL();
            pbActivity = this.bEB.bCF;
            if (pbActivity != null) {
                pbActivity3 = this.bEB.bCF;
                pbActivity3.Xc();
                pbActivity4 = this.bEB.bCF;
                pbActivity4.Fm();
            }
            this.bEB.dX(false);
            this.bEB.bEn = false;
            pbActivity2 = this.bEB.bCF;
            pbEditor4 = this.bEB.bEe;
            PbEditorToolView editorToolButtonContainer = pbEditor4.getEditorToolButtonContainer();
            yVar = this.bEB.aGe;
            com.baidu.tieba.tbadkCore.bubble.m.a(pbActivity2, editorToolButtonContainer, false, yVar);
        }
        view2 = this.bEB.bEh;
        if (view2 != null) {
            view3 = this.bEB.bEh;
            view3.setVisibility(8);
            view4 = this.bEB.bEg;
            view4.setVisibility(8);
            this.bEB.bEn = false;
        }
    }
}
