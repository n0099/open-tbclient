package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.TbCheckBox;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements k {
    final /* synthetic */ t bsV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar) {
        this.bsV = tVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.k
    public void a(View view, Object obj) {
        BdListView bdListView;
        if (obj != null) {
            if (obj instanceof com.baidu.tbadk.core.view.ab) {
                ((com.baidu.tbadk.core.view.ab) obj).setChecked(false);
            }
            bdListView = this.bsV.mListView;
            View findViewWithTag = bdListView.findViewWithTag(obj);
            if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                ((TbCheckBox) findViewWithTag).setChecked(false);
            } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                this.bsV.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
            }
        }
    }
}
