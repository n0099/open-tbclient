package com.baidu.tieba.im.widget;

import com.baidu.tbadk.util.v;
/* loaded from: classes.dex */
class e extends v<Integer> {
    final /* synthetic */ d dcD;
    private final /* synthetic */ boolean dcE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, boolean z) {
        this.dcD = dVar;
        this.dcE = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.v
    public Integer doInBackground() {
        if (!this.dcE) {
            com.baidu.tieba.im.db.b.anm().ann();
        }
        return 0;
    }
}
