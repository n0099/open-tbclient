package com.baidu.tieba.pb.sub;

import com.baidu.tbadk.editortool.w;
/* loaded from: classes.dex */
class r implements w {
    final /* synthetic */ l a;
    private final /* synthetic */ w b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(l lVar, w wVar) {
        this.a = lVar;
        this.b = wVar;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void a(int i, Object obj) {
        if (i == 0) {
            this.b.a(26, obj);
        } else if (i == 10) {
            this.b.a(27, obj);
        } else if (i == 34) {
            this.a.r.setEnabled(true);
        } else if (i == 33) {
            this.a.r.setEnabled(false);
        } else {
            this.b.a(i, obj);
        }
    }
}
