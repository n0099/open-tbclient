package com.baidu.tieba.write;
/* loaded from: classes.dex */
class bb implements com.baidu.tieba.bubble.t {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // com.baidu.tieba.bubble.t
    public void a() {
        WriteEditorToolButtonContainer writeEditorToolButtonContainer;
        WriteEditorToolButtonContainer writeEditorToolButtonContainer2;
        this.a.m = null;
        this.a.a(false);
        writeEditorToolButtonContainer = this.a.B;
        if (writeEditorToolButtonContainer != null) {
            writeEditorToolButtonContainer2 = this.a.B;
            writeEditorToolButtonContainer2.r();
        }
    }
}
