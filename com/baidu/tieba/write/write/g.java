package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements TbCheckBox.a {
    final /* synthetic */ AtListActivity dqn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AtListActivity atListActivity) {
        this.dqn = atListActivity;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.a
    public void handler(TbCheckBox tbCheckBox, boolean z, Object obj) {
        AtSelectFriendList atSelectFriendList;
        if (obj != null && (obj instanceof MetaData)) {
            if (z) {
                atSelectFriendList = this.dqn.dqb;
                if (5 <= atSelectFriendList.getItemLength()) {
                    this.dqn.showToastWithIcon(String.format(this.dqn.getPageContext().getString(i.h.invite_friend_exceed_max_count), 5), i.e.icon_toast_game_error);
                    tbCheckBox.setChecked(false);
                    ((MetaData) obj).setChecked(false);
                    return;
                }
                this.dqn.a((MetaData) obj);
                return;
            }
            this.dqn.b((MetaData) obj);
        }
    }
}
