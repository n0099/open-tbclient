package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.write.write.AtSelectFriendList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements AtSelectFriendList.a {
    final /* synthetic */ AtListActivity gjY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(AtListActivity atListActivity) {
        this.gjY = atListActivity;
    }

    @Override // com.baidu.tieba.write.write.AtSelectFriendList.a
    public void b(View view, Object obj) {
        if (obj != null) {
            if (obj instanceof TbCheckBox.b) {
                ((TbCheckBox.b) obj).setChecked(false);
            }
            View findViewWithTag = this.gjY.Ib.findViewWithTag(obj);
            if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                ((TbCheckBox) findViewWithTag).setChecked(false);
            } else if (!(obj instanceof MetaData)) {
            } else {
                this.gjY.d((MetaData) obj);
            }
        }
    }
}
