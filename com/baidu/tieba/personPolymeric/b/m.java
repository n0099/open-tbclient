package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.tieba.personPolymeric.b.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ i eKZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(i iVar) {
        this.eKZ = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        i.a aVar;
        i.a aVar2;
        if (com.baidu.adp.lib.util.i.gY()) {
            this.eKZ.Mx();
            this.eKZ.jt(true);
            aVar = this.eKZ.eKY;
            if (aVar != null) {
                aVar2 = this.eKZ.eKY;
                aVar2.bd(view);
            }
        }
    }
}
