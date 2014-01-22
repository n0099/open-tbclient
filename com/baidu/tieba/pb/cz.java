package com.baidu.tieba.pb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cz implements com.baidu.tieba.editortool.t {
    final /* synthetic */ com.baidu.tieba.editortool.t a;
    final /* synthetic */ cr b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cz(cr crVar, com.baidu.tieba.editortool.t tVar) {
        this.b = crVar;
        this.a = tVar;
    }

    @Override // com.baidu.tieba.editortool.t
    public void a(int i, Object obj) {
        PbEditor pbEditor;
        PbEditor pbEditor2;
        NewPbActivity newPbActivity;
        if (i == 33) {
            pbEditor = this.b.ap;
            if (!pbEditor.h()) {
                pbEditor2 = this.b.ap;
                if (!pbEditor2.j()) {
                    newPbActivity = this.b.g;
                    com.baidu.tieba.util.by.a(newPbActivity, "pb_reply", "pbclick", 1, new Object[0]);
                }
            }
        }
        this.a.a(i, obj);
    }
}
