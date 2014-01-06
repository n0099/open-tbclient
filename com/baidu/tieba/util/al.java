package com.baidu.tieba.util;

import android.view.ViewGroup;
import android.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class al implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ ListView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ListView listView) {
        this.a = listView;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        if (dVar != null && str != null) {
            bu.a((ViewGroup) this.a, false, (bw) new am(this, str));
        }
    }
}
