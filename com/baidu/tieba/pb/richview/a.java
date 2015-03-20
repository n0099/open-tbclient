package com.baidu.tieba.pb.richview;

import android.view.View;
import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements ViewGroup.OnHierarchyChangeListener {
    final /* synthetic */ TbRichView bOi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(TbRichView tbRichView) {
        this.bOi = tbRichView;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        c cVar;
        c cVar2;
        cVar = this.bOi.bOh;
        if (cVar != null) {
            cVar2 = this.bOi.bOh;
            cVar2.O(view2);
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
    }
}
