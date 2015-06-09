package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.view.TbCheckBox;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements com.baidu.tbadk.core.view.af {
    final /* synthetic */ AtListActivity cBu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AtListActivity atListActivity) {
        this.cBu = atListActivity;
    }

    @Override // com.baidu.tbadk.core.view.af
    public void handler(TbCheckBox tbCheckBox, boolean z, Object obj) {
        AtSelectFriendList atSelectFriendList;
        if (obj != null && (obj instanceof MetaData)) {
            if (z) {
                atSelectFriendList = this.cBu.cBi;
                if (5 <= atSelectFriendList.getItemLength()) {
                    this.cBu.showToastWithIcon(String.format(this.cBu.getPageContext().getString(com.baidu.tieba.t.invite_friend_exceed_max_count), 5), com.baidu.tieba.p.icon_toast_game_error);
                    tbCheckBox.setChecked(false);
                    ((MetaData) obj).setChecked(false);
                    return;
                }
                this.cBu.b((MetaData) obj);
                return;
            }
            this.cBu.c((MetaData) obj);
        }
    }
}
