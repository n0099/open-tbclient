package com.baidu.tieba.write;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.TbCheckBox;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements n {
    final /* synthetic */ AtListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(AtListActivity atListActivity) {
        this.a = atListActivity;
    }

    @Override // com.baidu.tieba.write.n
    public void a(View view, Object obj) {
        BdListView bdListView;
        if (obj != null) {
            if (obj instanceof com.baidu.tbadk.core.view.p) {
                ((com.baidu.tbadk.core.view.p) obj).setChecked(false);
            }
            bdListView = this.a.d;
            View findViewWithTag = bdListView.findViewWithTag(obj);
            if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                ((TbCheckBox) findViewWithTag).setChecked(false);
            } else if (!(obj instanceof com.baidu.tbadk.coreExtra.relationship.b)) {
            } else {
                this.a.b((com.baidu.tbadk.coreExtra.relationship.b) obj);
            }
        }
    }
}
