package com.baidu.tieba.write.write;

import android.view.View;
/* loaded from: classes.dex */
class bn implements View.OnClickListener {
    final /* synthetic */ WriteActivity cCP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(WriteActivity writeActivity) {
        this.cCP = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.write.editor.b bVar;
        bVar = this.cCP.cCw;
        switch (bVar.getLocationInfoViewState()) {
            case 0:
                this.cCP.JP();
                return;
            case 1:
            default:
                return;
            case 2:
                this.cCP.JO();
                return;
        }
    }
}
