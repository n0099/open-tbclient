package com.baidu.tieba.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dc implements ViewGroup.OnHierarchyChangeListener {
    final /* synthetic */ UserIconBox a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dc(UserIconBox userIconBox) {
        this.a = userIconBox;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        com.baidu.adp.lib.d.b bVar;
        com.baidu.adp.lib.d.b bVar2;
        com.baidu.adp.lib.util.f.e("pool return child");
        if (view2 instanceof TbImageView) {
            bVar = this.a.b;
            if (bVar != null) {
                bVar2 = this.a.b;
                bVar2.a((com.baidu.adp.lib.d.b) ((TbImageView) view2));
            }
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
    }
}
