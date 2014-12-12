package com.baidu.tieba.write;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.view.TbCheckBox;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements n {
    final /* synthetic */ AtListActivity cdZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AtListActivity atListActivity) {
        this.cdZ = atListActivity;
    }

    @Override // com.baidu.tieba.write.n
    public void a(View view, Object obj) {
        BdListView bdListView;
        if (obj != null) {
            if (obj instanceof com.baidu.tbadk.core.view.aj) {
                ((com.baidu.tbadk.core.view.aj) obj).setChecked(false);
            }
            bdListView = this.cdZ.mListView;
            View findViewWithTag = bdListView.findViewWithTag(obj);
            if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                ((TbCheckBox) findViewWithTag).setChecked(false);
            } else if (!(obj instanceof MetaData)) {
            } else {
                this.cdZ.c((MetaData) obj);
            }
        }
    }
}
