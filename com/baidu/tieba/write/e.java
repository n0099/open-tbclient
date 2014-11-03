package com.baidu.tieba.write;

import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.view.TbCheckBox;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tbadk.core.view.w {
    final /* synthetic */ AtListActivity bST;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AtListActivity atListActivity) {
        this.bST = atListActivity;
    }

    @Override // com.baidu.tbadk.core.view.w
    public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
        AtSelectFriendList atSelectFriendList;
        if (obj != null && (obj instanceof MetaData)) {
            if (z) {
                atSelectFriendList = this.bST.bSI;
                if (5 <= atSelectFriendList.getItemLength()) {
                    this.bST.showToast(String.format(this.bST.getString(com.baidu.tieba.y.invite_friend_exceed_max_count), 5));
                    tbCheckBox.setChecked(false);
                    ((MetaData) obj).setChecked(false);
                    return;
                }
                this.bST.b((MetaData) obj);
                return;
            }
            this.bST.c((MetaData) obj);
        }
    }
}
