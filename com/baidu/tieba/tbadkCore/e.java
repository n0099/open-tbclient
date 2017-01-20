package com.baidu.tieba.tbadkCore;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements ViewGroup.OnHierarchyChangeListener {
    final /* synthetic */ FrsCommonImageLayout fnc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(FrsCommonImageLayout frsCommonImageLayout) {
        this.fnc = frsCommonImageLayout;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        com.baidu.adp.lib.e.b bVar;
        com.baidu.adp.lib.e.b bVar2;
        if (view2 instanceof TbImageView) {
            bVar = this.fnc.fmR;
            if (bVar != null) {
                bVar2 = this.fnc.fmR;
                bVar2.n((TbImageView) view2);
            }
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
    }
}
