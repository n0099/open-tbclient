package com.baidu.tieba.personInfo;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements c.b {
    private final /* synthetic */ int cEl;
    final /* synthetic */ f diG;
    private final /* synthetic */ com.baidu.tbadk.data.g diH;
    private final /* synthetic */ List diI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(f fVar, com.baidu.tbadk.data.g gVar, List list, int i) {
        this.diG = fVar;
        this.diH = gVar;
        this.diI = list;
        this.cEl = i;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    this.diG.e(this.diH, this.diI, this.cEl);
                }
            } else {
                this.diG.a(this.diH);
            }
        } else {
            this.diG.d(this.diH, this.diI, this.cEl);
        }
        cVar.dismiss();
    }
}
