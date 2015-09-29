package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class cb implements a.b {
    final /* synthetic */ ca dqn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(ca caVar) {
        this.dqn = caVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteMultiImgsActivity writeMultiImgsActivity;
        com.baidu.tbadk.core.dialog.a aVar2;
        WriteMultiImgsActivity writeMultiImgsActivity2;
        WriteMultiImgsActivity writeMultiImgsActivity3;
        com.baidu.tbadk.core.dialog.a aVar3;
        writeMultiImgsActivity = this.dqn.dqm;
        aVar2 = writeMultiImgsActivity.dqi;
        if (aVar2 != null) {
            writeMultiImgsActivity3 = this.dqn.dqm;
            aVar3 = writeMultiImgsActivity3.dqi;
            aVar3.dismiss();
        }
        writeMultiImgsActivity2 = this.dqn.dqm;
        writeMultiImgsActivity2.aDC();
    }
}
