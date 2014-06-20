package com.baidu.tieba.pb.main;

import android.text.TextUtils;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class co implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ bq a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public co(bq bqVar) {
        this.a = bqVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        BdListView bdListView;
        if (aVar != null && !TextUtils.isEmpty(str)) {
            bdListView = this.a.o;
            com.baidu.tbadk.core.util.br.a((ViewGroup) bdListView, false, (com.baidu.tbadk.core.util.bt) new cp(this, str, aVar));
        }
    }
}
