package com.baidu.tieba.pb.main;

import android.text.TextUtils;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ch implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ bj a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(bj bjVar) {
        this.a = bjVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        BdListView bdListView;
        if (aVar != null && !TextUtils.isEmpty(str)) {
            bdListView = this.a.o;
            com.baidu.tbadk.core.util.bp.a((ViewGroup) bdListView, false, (com.baidu.tbadk.core.util.br) new ci(this, str, aVar));
        }
    }
}
