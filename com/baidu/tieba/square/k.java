package com.baidu.tieba.square;

import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ ViewGroup a;
    final /* synthetic */ i b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar, ViewGroup viewGroup) {
        this.b = iVar;
        this.a = viewGroup;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        if (dVar != null && str != null) {
            com.baidu.tieba.util.bu.a(this.a, false, (com.baidu.tieba.util.bw) new l(this, str, dVar));
        }
    }
}
