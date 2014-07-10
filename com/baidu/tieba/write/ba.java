package com.baidu.tieba.write;
/* loaded from: classes.dex */
class ba implements com.baidu.tieba.bubble.t {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // com.baidu.tieba.bubble.t
    public void a() {
        WriteEditorToolButtonContainer writeEditorToolButtonContainer;
        WriteEditorToolButtonContainer writeEditorToolButtonContainer2;
        this.a.l = null;
        this.a.a(false);
        writeEditorToolButtonContainer = this.a.z;
        if (writeEditorToolButtonContainer != null) {
            writeEditorToolButtonContainer2 = this.a.z;
            writeEditorToolButtonContainer2.r();
        }
    }
}
