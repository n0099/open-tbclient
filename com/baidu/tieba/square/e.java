package com.baidu.tieba.square;

import android.view.ViewGroup;
import com.baidu.tbadk.core.util.bp;
import com.baidu.tbadk.core.util.br;
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
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar != null) {
            bp.a(this.b, false, (br) new f(this, str, aVar));
        }
    }
}
