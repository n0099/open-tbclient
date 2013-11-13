package com.baidu.tieba.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq implements ViewGroup.OnHierarchyChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UserIconBox f2580a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(UserIconBox userIconBox) {
        this.f2580a = userIconBox;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        com.baidu.adp.lib.d.b bVar;
        com.baidu.adp.lib.d.b bVar2;
        com.baidu.adp.lib.h.d.d("pool return child");
        if (view2 instanceof TbImageView) {
            bVar = this.f2580a.b;
            if (bVar != null) {
                bVar2 = this.f2580a.b;
                bVar2.a((com.baidu.adp.lib.d.b) ((TbImageView) view2));
            }
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
    }
}
