package com.baidu.tieba.pb.main;

import com.baidu.tieba.editortool.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw implements com.baidu.tieba.bubble.t {
    final /* synthetic */ bv byW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(bv bvVar) {
        this.byW = bvVar;
    }

    @Override // com.baidu.tieba.bubble.t
    public void hz() {
        PbEditor pbEditor;
        PbEditor pbEditor2;
        pbEditor = this.byW.byB;
        if (pbEditor != null) {
            pbEditor2 = this.byW.byB;
            pbEditor2.refresh();
        }
    }
}
