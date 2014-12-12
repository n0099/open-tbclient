package com.baidu.tieba.pb.main;

import android.view.View;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditorToolView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cv implements View.OnClickListener {
    final /* synthetic */ bz bCR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cv(bz bzVar) {
        this.bCR = bzVar;
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
        pbEditor = this.bCR.bCu;
        if (pbEditor == null) {
            this.bCR.XK();
        }
        pbEditor2 = this.bCR.bCu;
        if (pbEditor2 != null) {
            z = this.bCR.bCP;
            if (z) {
                this.bCR.Yo();
            } else {
                this.bCR.Yp();
            }
            pbEditor3 = this.bCR.bCu;
            pbEditor3.yB();
            pbActivity = this.bCR.bAW;
            if (pbActivity != null) {
                pbActivity3 = this.bCR.bAW;
                pbActivity3.WC();
                pbActivity4 = this.bCR.bAW;
                pbActivity4.ET();
            }
            this.bCR.dR(false);
            this.bCR.bCD = false;
            pbActivity2 = this.bCR.bAW;
            pbEditor4 = this.bCR.bCu;
            PbEditorToolView editorToolButtonContainer = pbEditor4.getEditorToolButtonContainer();
            yVar = this.bCR.aFe;
            com.baidu.tieba.tbadkCore.bubble.m.a(pbActivity2, editorToolButtonContainer, false, yVar);
        }
        view2 = this.bCR.bCx;
        if (view2 != null) {
            view3 = this.bCR.bCx;
            view3.setVisibility(8);
            view4 = this.bCR.bCw;
            view4.setVisibility(8);
            this.bCR.bCD = false;
        }
    }
}
