package com.baidu.tieba.square;

import android.view.ViewGroup;
import com.baidu.tieba.util.ch;
import com.baidu.tieba.util.cj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ c a;
    private final /* synthetic */ ViewGroup b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, ViewGroup viewGroup) {
        this.a = cVar;
        this.b = viewGroup;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        if (bVar != null) {
            ch.a(this.b, false, (cj) new f(this, str, bVar));
        }
    }
}
