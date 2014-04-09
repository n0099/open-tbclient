package com.baidu.tieba.pb.main;

import android.text.TextUtils;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ck implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ bm a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(bm bmVar) {
        this.a = bmVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        BdListView bdListView;
        if (bVar != null && !TextUtils.isEmpty(str)) {
            bdListView = this.a.o;
            com.baidu.tbadk.core.util.bn.a((ViewGroup) bdListView, false, (com.baidu.tbadk.core.util.bp) new cl(this, str, bVar));
        }
    }
}
