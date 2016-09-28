package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements c.b {
    private final /* synthetic */ int dSl;
    final /* synthetic */ q eJJ;
    private final /* synthetic */ com.baidu.tbadk.data.k eJK;
    private final /* synthetic */ List eJL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(q qVar, com.baidu.tbadk.data.k kVar, List list, int i) {
        this.eJJ = qVar;
        this.eJK = kVar;
        this.eJL = list;
        this.dSl = i;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        this.eJJ.eJB = true;
        switch (i) {
            case 0:
                this.eJJ.d(this.eJK, this.eJL, this.dSl);
                break;
            case 1:
                this.eJJ.aTT();
                break;
            case 2:
                this.eJJ.aTU();
                break;
            case 3:
                TiebaStatic.log(new ax("c11616").s("obj_type", 1));
                this.eJJ.aTV();
                break;
        }
        cVar.dismiss();
    }
}
