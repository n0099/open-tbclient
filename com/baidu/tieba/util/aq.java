package com.baidu.tieba.util;

import android.view.ViewGroup;
import android.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements com.baidu.tbadk.imageManager.d {
    private final /* synthetic */ ListView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ListView listView) {
        this.a = listView;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        if (bVar != null && str != null) {
            ch.a((ViewGroup) this.a, false, (cj) new ar(this, str));
        }
    }
}
