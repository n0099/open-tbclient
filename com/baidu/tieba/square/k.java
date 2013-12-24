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
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        com.baidu.tieba.util.bk.a(this.a, false, (com.baidu.tieba.util.bm) new l(this, str, eVar));
    }
}
