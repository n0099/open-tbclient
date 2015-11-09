package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.write.write.AtSelectFriendList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements AtSelectFriendList.a {
    final /* synthetic */ AtListActivity dqn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(AtListActivity atListActivity) {
        this.dqn = atListActivity;
    }

    @Override // com.baidu.tieba.write.write.AtSelectFriendList.a
    public void a(View view, Object obj) {
        if (obj != null) {
            if (obj instanceof TbCheckBox.b) {
                ((TbCheckBox.b) obj).setChecked(false);
            }
            View findViewWithTag = this.dqn.mListView.findViewWithTag(obj);
            if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                ((TbCheckBox) findViewWithTag).setChecked(false);
            } else if (!(obj instanceof MetaData)) {
            } else {
                this.dqn.b((MetaData) obj);
            }
        }
    }
}
