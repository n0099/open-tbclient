package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditorToolView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cv implements View.OnClickListener {
    final /* synthetic */ ch bOF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cv(ch chVar) {
        this.bOF = chVar;
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
        pbActivity = this.bOF.bKZ;
        if (pbActivity.checkUpIsLogin()) {
            pbEditor = this.bOF.bOh;
            if (pbEditor == null) {
                this.bOF.abW();
            }
            pbEditor2 = this.bOF.bOh;
            if (pbEditor2 != null) {
                z = this.bOF.bOD;
                if (z) {
                    this.bOF.ack();
                } else {
                    this.bOF.acl();
                }
                pbActivity2 = this.bOF.bKZ;
                if (pbActivity2 != null) {
                    pbActivity4 = this.bOF.bKZ;
                    pbActivity4.aaM();
                    pbActivity5 = this.bOF.bKZ;
                    pbActivity5.JR();
                } else {
                    pbEditor3 = this.bOF.bOh;
                    pbEditor3.CQ();
                    this.bOF.ef(false);
                }
                this.bOF.bOn = false;
                pbActivity3 = this.bOF.bKZ;
                pbEditor4 = this.bOF.bOh;
                PbEditorToolView editorToolButtonContainer = pbEditor4.getEditorToolButtonContainer();
                hVar = this.bOF.bOz;
                com.baidu.tieba.tbadkCore.c.a.a(pbActivity3, editorToolButtonContainer, false, hVar);
            }
            view2 = this.bOF.bOj;
            if (view2 != null) {
                view3 = this.bOF.bOj;
                view3.setVisibility(8);
                this.bOF.bOn = false;
            }
        }
    }
}
