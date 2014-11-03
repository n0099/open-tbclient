package com.baidu.tieba.pb.main;

import android.view.View;
import com.baidu.tieba.editortool.PbEditor;
import com.baidu.tieba.editortool.PbEditorToolView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cr implements View.OnClickListener {
    final /* synthetic */ bv byW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cr(bv bvVar) {
        this.byW = bvVar;
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
        pbEditor = this.byW.byB;
        if (pbEditor == null) {
            this.byW.Xn();
        }
        pbEditor2 = this.byW.byB;
        if (pbEditor2 != null) {
            z = this.byW.byU;
            if (z) {
                this.byW.Bv();
            } else {
                this.byW.Bu();
            }
            pbEditor3 = this.byW.byB;
            pbEditor3.Bc();
            pbActivity = this.byW.bxe;
            if (pbActivity != null) {
                pbActivity3 = this.byW.bxe;
                pbActivity3.Wf();
                pbActivity4 = this.byW.bxe;
                pbActivity4.EB();
            }
            this.byW.eg(false);
            this.byW.byK = false;
            pbActivity2 = this.byW.bxe;
            pbEditor4 = this.byW.byB;
            PbEditorToolView editorToolButtonContainer = pbEditor4.getEditorToolButtonContainer();
            tVar = this.byW.aDB;
            com.baidu.tieba.bubble.h.a(pbActivity2, editorToolButtonContainer, false, tVar);
        }
        view2 = this.byW.byE;
        if (view2 != null) {
            view3 = this.byW.byE;
            view3.setVisibility(8);
            view4 = this.byW.byD;
            view4.setVisibility(8);
            this.byW.byK = false;
        }
    }
}
