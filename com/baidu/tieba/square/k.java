package com.baidu.tieba.square;

import android.view.ViewGroup;
import com.baidu.tbadk.core.util.br;
import com.baidu.tbadk.core.util.bt;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ i a;
    private final /* synthetic */ ViewGroup b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar, ViewGroup viewGroup) {
        this.a = iVar;
        this.b = viewGroup;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar != null && str != null) {
            br.a(this.b, false, (bt) new l(this, str, aVar));
        }
    }
}
