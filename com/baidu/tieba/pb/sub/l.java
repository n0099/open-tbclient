package com.baidu.tieba.pb.sub;
/* loaded from: classes.dex */
class l implements com.baidu.tbadk.editortool.w {
    final /* synthetic */ j a;
    private final /* synthetic */ com.baidu.tbadk.editortool.w b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar, com.baidu.tbadk.editortool.w wVar) {
        this.a = jVar;
        this.b = wVar;
    }

    @Override // com.baidu.tbadk.editortool.w
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
