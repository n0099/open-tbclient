package com.baidu.tieba.pb.richview;

import android.view.View;
import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements ViewGroup.OnHierarchyChangeListener {
    final /* synthetic */ TbRichView bOy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(TbRichView tbRichView) {
        this.bOy = tbRichView;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        c cVar;
        c cVar2;
        cVar = this.bOy.bOx;
        if (cVar != null) {
            cVar2 = this.bOy.bOx;
            cVar2.O(view2);
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
    }
}
