package com.baidu.tieba.pb.sub;

import com.baidu.tbadk.editortool.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements x {
    final /* synthetic */ m a;
    private final /* synthetic */ x b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(m mVar, x xVar) {
        this.a = mVar;
        this.b = xVar;
    }

    @Override // com.baidu.tbadk.editortool.x
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
