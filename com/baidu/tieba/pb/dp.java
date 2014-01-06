package com.baidu.tieba.pb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dp implements com.baidu.tieba.view.av {
    final /* synthetic */ cs a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dp(cs csVar) {
        this.a = csVar;
    }

    @Override // com.baidu.tieba.view.av
    public void a(int i) {
        ed edVar;
        PbEditor pbEditor;
        if (!this.a.y()) {
            pbEditor = this.a.aq;
            pbEditor.a(i);
        } else {
            edVar = this.a.r;
            edVar.a(i);
        }
        switch (i) {
            case 0:
                this.a.ah = true;
                return;
            case 1:
                this.a.ah = false;
                return;
            default:
                return;
        }
    }
}
