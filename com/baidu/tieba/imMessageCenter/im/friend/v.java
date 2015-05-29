package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.core.view.ag;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements k {
    final /* synthetic */ t bvV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar) {
        this.bvV = tVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.k
    public void a(View view, Object obj) {
        BdListView bdListView;
        if (obj != null) {
            if (obj instanceof ag) {
                ((ag) obj).setChecked(false);
            }
            bdListView = this.bvV.mListView;
            View findViewWithTag = bdListView.findViewWithTag(obj);
            if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                ((TbCheckBox) findViewWithTag).setChecked(false);
            } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                this.bvV.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
            }
        }
    }
}
