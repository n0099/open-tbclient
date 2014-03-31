package com.baidu.tieba.write;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.view.TbCheckBox;
/* loaded from: classes.dex */
final class k implements r {
    final /* synthetic */ AtListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(AtListActivity atListActivity) {
        this.a = atListActivity;
    }

    @Override // com.baidu.tieba.write.r
    public final void a(Object obj) {
        BdListView bdListView;
        if (obj != null) {
            if (obj instanceof com.baidu.tbadk.core.view.p) {
                ((com.baidu.tbadk.core.view.p) obj).setChecked(false);
            }
            bdListView = this.a.d;
            View findViewWithTag = bdListView.findViewWithTag(obj);
            if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                ((TbCheckBox) findViewWithTag).setChecked(false);
            } else if (!(obj instanceof MetaData)) {
            } else {
                this.a.c((MetaData) obj);
            }
        }
    }
}
