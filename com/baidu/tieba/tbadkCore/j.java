package com.baidu.tieba.tbadkCore;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements ViewGroup.OnHierarchyChangeListener {
    final /* synthetic */ FrsCommonImageLayout ckX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsCommonImageLayout frsCommonImageLayout) {
        this.ckX = frsCommonImageLayout;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        com.baidu.adp.lib.e.b bVar;
        com.baidu.adp.lib.e.b bVar2;
        if (view2 instanceof TbImageView) {
            bVar = this.ckX.ckP;
            if (bVar != null) {
                bVar2 = this.ckX.ckP;
                bVar2.j((TbImageView) view2);
            }
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
    }
}
