package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditorToolView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cv implements View.OnClickListener {
    final /* synthetic */ ch bOG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cv(ch chVar) {
        this.bOG = chVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbEditor pbEditor;
        PbEditor pbEditor2;
        View view2;
        View view3;
        boolean z;
        PbActivity pbActivity2;
        PbEditor pbEditor3;
        PbActivity pbActivity3;
        PbEditor pbEditor4;
        com.baidu.tieba.tbadkCore.c.h hVar;
        PbActivity pbActivity4;
        PbActivity pbActivity5;
        pbActivity = this.bOG.bLa;
        if (pbActivity.checkUpIsLogin()) {
            pbEditor = this.bOG.bOi;
            if (pbEditor == null) {
                this.bOG.abX();
            }
            pbEditor2 = this.bOG.bOi;
            if (pbEditor2 != null) {
                z = this.bOG.bOE;
                if (z) {
                    this.bOG.acl();
                } else {
                    this.bOG.acm();
                }
                pbActivity2 = this.bOG.bLa;
                if (pbActivity2 != null) {
                    pbActivity4 = this.bOG.bLa;
                    pbActivity4.aaN();
                    pbActivity5 = this.bOG.bLa;
                    pbActivity5.JS();
                } else {
                    pbEditor3 = this.bOG.bOi;
                    pbEditor3.CR();
                    this.bOG.ef(false);
                }
                this.bOG.bOo = false;
                pbActivity3 = this.bOG.bLa;
                pbEditor4 = this.bOG.bOi;
                PbEditorToolView editorToolButtonContainer = pbEditor4.getEditorToolButtonContainer();
                hVar = this.bOG.bOA;
                com.baidu.tieba.tbadkCore.c.a.a(pbActivity3, editorToolButtonContainer, false, hVar);
            }
            view2 = this.bOG.bOk;
            if (view2 != null) {
                view3 = this.bOG.bOk;
                view3.setVisibility(8);
                this.bOG.bOo = false;
            }
        }
    }
}
