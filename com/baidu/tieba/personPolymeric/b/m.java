package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.tieba.personPolymeric.b.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ i eUZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(i iVar) {
        this.eUZ = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        i.a aVar;
        i.a aVar2;
        if (com.baidu.adp.lib.util.i.gX()) {
            this.eUZ.Np();
            this.eUZ.jR(true);
            aVar = this.eUZ.eUX;
            if (aVar != null) {
                aVar2 = this.eUZ.eUX;
                aVar2.T(view);
            }
        }
    }
}
