package com.baidu.tieba.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements ViewGroup.OnHierarchyChangeListener {
    final /* synthetic */ FrsCommonImageLayout bRp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsCommonImageLayout frsCommonImageLayout) {
        this.bRp = frsCommonImageLayout;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        com.baidu.adp.lib.e.b bVar;
        com.baidu.adp.lib.e.b bVar2;
        if (view2 instanceof TbImageView) {
            bVar = this.bRp.bRn;
            if (bVar != null) {
                bVar2 = this.bRp.bRn;
                bVar2.h((TbImageView) view2);
            }
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
    }
}
