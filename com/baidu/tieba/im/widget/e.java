package com.baidu.tieba.im.widget;

import com.baidu.tbadk.util.s;
/* loaded from: classes.dex */
class e extends s<Integer> {
    final /* synthetic */ d dgk;
    private final /* synthetic */ boolean dgl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, boolean z) {
        this.dgk = dVar;
        this.dgl = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Integer doInBackground() {
        if (!this.dgl) {
            com.baidu.tieba.im.db.b.aps().apt();
        }
        return 0;
    }
}
