package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.view.TbCheckBox;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements s {
    final /* synthetic */ AtListActivity cBt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(AtListActivity atListActivity) {
        this.cBt = atListActivity;
    }

    @Override // com.baidu.tieba.write.write.s
    public void a(View view, Object obj) {
        BdListView bdListView;
        if (obj != null) {
            if (obj instanceof com.baidu.tbadk.core.view.ag) {
                ((com.baidu.tbadk.core.view.ag) obj).setChecked(false);
            }
            bdListView = this.cBt.mListView;
            View findViewWithTag = bdListView.findViewWithTag(obj);
            if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                ((TbCheckBox) findViewWithTag).setChecked(false);
            } else if (!(obj instanceof MetaData)) {
            } else {
                this.cBt.c((MetaData) obj);
            }
        }
    }
}
