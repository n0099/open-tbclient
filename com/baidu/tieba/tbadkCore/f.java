package com.baidu.tieba.tbadkCore;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements ViewGroup.OnHierarchyChangeListener {
    final /* synthetic */ FrsCommonImageLayout fpQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(FrsCommonImageLayout frsCommonImageLayout) {
        this.fpQ = frsCommonImageLayout;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        com.baidu.adp.lib.f.b bVar;
        com.baidu.adp.lib.f.b bVar2;
        if (view2 instanceof TbImageView) {
            bVar = this.fpQ.fpH;
            if (bVar != null) {
                bVar2 = this.fpQ.fpH;
                bVar2.n((TbImageView) view2);
            }
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
    }
}
