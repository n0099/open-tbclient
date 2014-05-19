package com.baidu.tieba.pb.sub;

import com.baidu.tbadk.editortool.x;
/* loaded from: classes.dex */
class l implements x {
    final /* synthetic */ j a;
    private final /* synthetic */ x b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar, x xVar) {
        this.a = jVar;
        this.b = xVar;
    }

    @Override // com.baidu.tbadk.editortool.x
    public void a(int i, Object obj) {
        if (i == 0) {
            this.b.a(26, obj);
        } else if (i == 10) {
            this.b.a(27, obj);
        } else if (i == 33) {
            this.a.L.d();
            this.b.a(33, obj);
        } else if (i == 34) {
            this.a.r.setEnabled(true);
        } else {
            this.b.a(i, obj);
        }
    }
}
