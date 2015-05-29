package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.view.TbCheckBox;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements com.baidu.tbadk.core.view.af {
    final /* synthetic */ AtListActivity cBt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AtListActivity atListActivity) {
        this.cBt = atListActivity;
    }

    @Override // com.baidu.tbadk.core.view.af
    public void handler(TbCheckBox tbCheckBox, boolean z, Object obj) {
        AtSelectFriendList atSelectFriendList;
        if (obj != null && (obj instanceof MetaData)) {
            if (z) {
                atSelectFriendList = this.cBt.cBh;
                if (5 <= atSelectFriendList.getItemLength()) {
                    this.cBt.showToastWithIcon(String.format(this.cBt.getPageContext().getString(com.baidu.tieba.t.invite_friend_exceed_max_count), 5), com.baidu.tieba.p.icon_toast_game_error);
                    tbCheckBox.setChecked(false);
                    ((MetaData) obj).setChecked(false);
                    return;
                }
                this.cBt.b((MetaData) obj);
                return;
            }
            this.cBt.c((MetaData) obj);
        }
    }
}
