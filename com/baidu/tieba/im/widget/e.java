package com.baidu.tieba.im.widget;

import com.baidu.tbadk.util.s;
/* loaded from: classes.dex */
class e extends s<Integer> {
    final /* synthetic */ d diB;
    private final /* synthetic */ boolean diC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, boolean z) {
        this.diB = dVar;
        this.diC = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Integer doInBackground() {
        if (!this.diC) {
            com.baidu.tieba.im.db.b.aqt().aqu();
        }
        return 0;
    }
}
