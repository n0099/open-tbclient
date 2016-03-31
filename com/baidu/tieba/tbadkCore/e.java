package com.baidu.tieba.tbadkCore;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements ViewGroup.OnHierarchyChangeListener {
    final /* synthetic */ FrsCommonImageLayout enb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(FrsCommonImageLayout frsCommonImageLayout) {
        this.enb = frsCommonImageLayout;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        com.baidu.adp.lib.f.b bVar;
        com.baidu.adp.lib.f.b bVar2;
        if (view2 instanceof TbImageView) {
            bVar = this.enb.emT;
            if (bVar != null) {
                bVar2 = this.enb.emT;
                bVar2.k((TbImageView) view2);
            }
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
    }
}
