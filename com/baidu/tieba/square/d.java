package com.baidu.tieba.square;

import android.view.ViewGroup;
import com.baidu.tieba.util.ce;
import com.baidu.tieba.util.cg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ ViewGroup a;
    final /* synthetic */ c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, ViewGroup viewGroup) {
        this.b = cVar;
        this.a = viewGroup;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        if (dVar != null) {
            ce.a(this.a, false, (cg) new e(this, str, dVar));
        }
    }
}
