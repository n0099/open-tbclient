package com.baidu.tieba.square;

import android.view.ViewGroup;
import com.baidu.tieba.util.ce;
import com.baidu.tieba.util.cg;
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
            ce.a(this.a, false, (cg) new l(this, str, dVar));
        }
    }
}
