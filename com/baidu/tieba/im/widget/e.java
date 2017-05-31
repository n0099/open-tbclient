package com.baidu.tieba.im.widget;

import com.baidu.tbadk.util.v;
/* loaded from: classes.dex */
class e extends v<Integer> {
    final /* synthetic */ d dhZ;
    private final /* synthetic */ boolean dia;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, boolean z) {
        this.dhZ = dVar;
        this.dia = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.v
    public Integer doInBackground() {
        if (!this.dia) {
            com.baidu.tieba.im.db.b.aom().aon();
        }
        return 0;
    }
}
