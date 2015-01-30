package com.baidu.tieba.pb.main;

import android.view.View;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditorToolView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ct implements View.OnClickListener {
    final /* synthetic */ bz bEC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(bz bzVar) {
        this.bEC = bzVar;
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
        pbEditor = this.bEC.bEf;
        if (pbEditor == null) {
            this.bEC.Yp();
        }
        pbEditor2 = this.bEC.bEf;
        if (pbEditor2 != null) {
            z = this.bEC.bEA;
            if (z) {
                this.bEC.YT();
            } else {
                this.bEC.YU();
            }
            pbEditor3 = this.bEC.bEf;
            pbEditor3.yR();
            pbActivity = this.bEC.bCG;
            if (pbActivity != null) {
                pbActivity3 = this.bEC.bCG;
                pbActivity3.Xh();
                pbActivity4 = this.bEC.bCG;
                pbActivity4.Fs();
            }
            this.bEC.dX(false);
            this.bEC.bEo = false;
            pbActivity2 = this.bEC.bCG;
            pbEditor4 = this.bEC.bEf;
            PbEditorToolView editorToolButtonContainer = pbEditor4.getEditorToolButtonContainer();
            yVar = this.bEC.aGh;
            com.baidu.tieba.tbadkCore.bubble.m.a(pbActivity2, editorToolButtonContainer, false, yVar);
        }
        view2 = this.bEC.bEi;
        if (view2 != null) {
            view3 = this.bEC.bEi;
            view3.setVisibility(8);
            view4 = this.bEC.bEh;
            view4.setVisibility(8);
            this.bEC.bEo = false;
        }
    }
}
