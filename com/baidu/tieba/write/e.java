package com.baidu.tieba.write;

import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.view.TbCheckBox;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tbadk.core.view.w {
    final /* synthetic */ AtListActivity bSE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AtListActivity atListActivity) {
        this.bSE = atListActivity;
    }

    @Override // com.baidu.tbadk.core.view.w
    public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
        AtSelectFriendList atSelectFriendList;
        if (obj != null && (obj instanceof MetaData)) {
            if (z) {
                atSelectFriendList = this.bSE.bSt;
                if (5 <= atSelectFriendList.getItemLength()) {
                    this.bSE.showToast(String.format(this.bSE.getString(com.baidu.tieba.y.invite_friend_exceed_max_count), 5));
                    tbCheckBox.setChecked(false);
                    ((MetaData) obj).setChecked(false);
                    return;
                }
                this.bSE.b((MetaData) obj);
                return;
            }
            this.bSE.c((MetaData) obj);
        }
    }
}
