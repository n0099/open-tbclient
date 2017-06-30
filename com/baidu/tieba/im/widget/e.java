package com.baidu.tieba.im.widget;

import com.baidu.tbadk.util.w;
/* loaded from: classes.dex */
class e extends w<Integer> {
    final /* synthetic */ d dpV;
    private final /* synthetic */ boolean dpW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, boolean z) {
        this.dpV = dVar;
        this.dpW = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.w
    public Integer doInBackground() {
        if (!this.dpW) {
            com.baidu.tieba.im.db.b.arX().arY();
        }
        return 0;
    }
}
