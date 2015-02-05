package com.baidu.tieba.write;

import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.view.TbCheckBox;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tbadk.core.view.ai {
    final /* synthetic */ AtListActivity cfx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AtListActivity atListActivity) {
        this.cfx = atListActivity;
    }

    @Override // com.baidu.tbadk.core.view.ai
    public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
        AtSelectFriendList atSelectFriendList;
        if (obj != null && (obj instanceof MetaData)) {
            if (z) {
                atSelectFriendList = this.cfx.cfm;
                if (5 <= atSelectFriendList.getItemLength()) {
                    this.cfx.showToast(String.format(this.cfx.getPageContext().getString(com.baidu.tieba.z.invite_friend_exceed_max_count), 5));
                    tbCheckBox.setChecked(false);
                    ((MetaData) obj).setChecked(false);
                    return;
                }
                this.cfx.b((MetaData) obj);
                return;
            }
            this.cfx.c((MetaData) obj);
        }
    }
}
