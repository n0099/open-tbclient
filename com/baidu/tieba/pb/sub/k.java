package com.baidu.tieba.pb.sub;

import com.baidu.tbadk.editortool.w;
/* loaded from: classes.dex */
class k implements w {
    final /* synthetic */ i a;
    private final /* synthetic */ w b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar, w wVar) {
        this.a = iVar;
        this.b = wVar;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void a(int i, Object obj) {
        if (i == 0) {
            this.b.a(26, obj);
        } else if (i == 10) {
            this.b.a(27, obj);
        } else if (i == 33) {
            this.a.M.d();
            this.b.a(33, obj);
        } else if (i == 34) {
            this.a.s.setEnabled(true);
        } else {
            this.b.a(i, obj);
        }
    }
}
